package org.bonitasoft.web.client.services.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.bonitasoft.web.client.api.ProcessApi;
import org.bonitasoft.web.client.api.ProcessParameterApi;
import org.bonitasoft.web.client.api.ProcessResolutionProblemApi;
import org.bonitasoft.web.client.api.UserTaskApi;
import org.bonitasoft.web.client.exception.NotFoundException;
import org.bonitasoft.web.client.exception.process.DuplicatedProcessException;
import org.bonitasoft.web.client.exception.process.ProcessActivationException;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.ActivationState;
import org.bonitasoft.web.client.model.ConfigurationState;
import org.bonitasoft.web.client.model.ProcessCreateRequest;
import org.bonitasoft.web.client.model.ProcessDefinition;
import org.bonitasoft.web.client.model.ProcessInstantiationResponse;
import org.bonitasoft.web.client.model.ProcessParameter;
import org.bonitasoft.web.client.model.ProcessResolutionProblem;
import org.bonitasoft.web.client.model.ProcessUpdateRequest;
import org.bonitasoft.web.client.model.UserTask;
import org.bonitasoft.web.client.model.UserTaskUpdateRequest;
import org.bonitasoft.web.client.services.ProcessService;
import org.bonitasoft.web.client.services.impl.base.AbstractService;
import org.bonitasoft.web.client.services.impl.base.ClientContext;
import org.bonitasoft.web.client.services.policies.ProcessImportPolicy;

import static java.lang.String.format;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

@Slf4j
public class DefaultProcessService extends AbstractService implements ProcessService {

    public DefaultProcessService(
            ClientContext clientContext, ApiProvider apiProvider, ObjectMapper objectMapper) {
        super(apiProvider, objectMapper, clientContext);
    }

    @Override
    public void importProcess(File barFile, ProcessImportPolicy policy) {
        log.info("Deploying process '{}' using policy {} ...", barFile.getName(), policy.name());
        BusinessArchiveInfo barInfo = BusinessArchiveInfo.readFrom(barFile);
        Optional<ProcessDefinition> process = getProcess(barInfo.getProcessName(), barInfo.getProcessVersion());
        if (process.isPresent()) {
            log.debug(
                    "Process '{}' in version '{}' already exists.",
                    barInfo.getProcessName(),
                    barInfo.getProcessVersion());
            switch (policy) {
                case REPLACE_DUPLICATES:
                    // simulate a REPLACE_DUPLICATES policy here because it is not implemented in engine side
                    log.debug("Policy REPLACE_DUPLICATES: deleting existing process...");
                    deleteExistingProcess(process.get());
                    break;
                case IGNORE_DUPLICATES:
                    log.debug("Policy IGNORE_DUPLICATES: skip deployment of existing process.");
                    return;
                case FAIL_ON_DUPLICATES:
                default:
                    throw new DuplicatedProcessException(
                            barInfo.getProcessName(),
                            barInfo.getProcessVersion(),
                            "Policy FAIL_ON_DUPLICATES: deployment aborted.");
            }
        }

        ProcessApi processApi = apiProvider.get(ProcessApi.class);
        log.debug("Uploading process file...");
        String uploadedFileName = processApi.uploadProcess(barFile);
        log.debug("Process file uploaded successfully.");

        ProcessDefinition processDeployed = processApi
                .createProcess(new ProcessCreateRequest().fileupload(uploadedFileName));
        log.info(
                "Process {}-{} deployed successfully.",
                processDeployed.getName(),
                processDeployed.getVersion());

        if (ConfigurationState.RESOLVED.equals(processDeployed.getConfigurationState())) {
            log.info(
                    "Process {}-{} is resolved. Activating process...",
                    barInfo.getProcessName(),
                    barInfo.getProcessVersion());
            String processId = processDeployed.getId();
            processApi.updateProcessById(
                    processId, new ProcessUpdateRequest().activationState(ActivationState.ENABLED));
            log.info("Process activated successfully.");
        } else {
            // Process maybe resolved later with deployment of bconf file.
            throw new ProcessActivationException(
                    "Process is unresolved, maybe some process parameters have not been configured yet.",
                    barInfo.getProcessName(),
                    barInfo.getProcessVersion());
        }
    }

    private void deleteExistingProcess(ProcessDefinition process) {
        ProcessApi processApi = apiProvider.get(ProcessApi.class);
        if (ActivationState.ENABLED.equals(process.getActivationState())) {
            log.info(
                    "Deactivating existing process {}-{} before deletion...",
                    process.getName(),
                    process.getVersion());
            processApi.updateProcessById(
                    process.getId(), new ProcessUpdateRequest().activationState(ActivationState.DISABLED));
            log.info("Existing process {}-{} deactivated.", process.getName(), process.getVersion());
        }
        processApi.deleteProcessById(process.getId());
        log.info("Existing process {}-{} deleted.", process.getName(), process.getVersion());
    }

    @Override
    public Optional<ProcessDefinition> getProcess(String name, String version) {
        log.info("Get process '{}' with version '{}'", name, version);
        List<ProcessDefinition> processes = apiProvider
                .get(ProcessApi.class)
                .searchProcesses(
                        new ProcessApi.SearchProcessesQueryParams()
                                .p(0)
                                .c(1)
                                .f(asList("name=" + name, "version=" + version)));
        if (processes.isEmpty()) {
            log.debug("Can't find any existing process with name '{}' and version '{}'.", name, version);
            return empty();
        }
        log.debug("Process '{}' with version '{}' found successfully.", name, version);
        return processes.stream().findFirst();
    }

    @Override
    public List<ProcessDefinition> searchProcesses(int page, int count) {
        return searchProcesses(new ProcessApi.SearchProcessesQueryParams().p(page).c(count));
    }

    @Override
    public List<ProcessDefinition> searchProcesses(ProcessApi.SearchProcessesQueryParams params) {
        log.info("Search processes with params {}", params);
        return apiProvider.get(ProcessApi.class).searchProcesses(params);
    }

    @Override
    public List<ProcessParameter> searchProcessParameters(int page, int count, String processId) {
        log.info(
                "Search process parameters for process {} with params: p={},c={}", processId, page, count);
        return apiProvider
                .get(ProcessParameterApi.class)
                .searchProcessParameters(
                        new ProcessParameterApi.SearchProcessParametersQueryParams()
                                .p(page)
                                .c(count)
                                .f(singletonList("process_id=" + processId)));
    }

    @Override
    public List<ProcessResolutionProblem> getProcessProblem(int page, int count, String processId) {
        log.info(
                "Search process problems for process {} with params: p={},c={}", processId, page, count);
        return apiProvider
                .get(ProcessResolutionProblemApi.class)
                .searchProcessResolutionProblems(
                        new ProcessResolutionProblemApi.SearchProcessResolutionProblemsQueryParams()
                                .p(page)
                                .c(count)
                                .f(singletonList("process_id=" + processId)));
    }

    @Override
    public ProcessInstantiationResponse startProcess(String name, String version) {
        return getProcess(name, version)
                .map(p -> startProcess(p.getId()))
                .orElseThrow(
                        () -> new NotFoundException(
                                format("No process found for name '%s' and version '%s'", name, version)));
    }

    @Override
    public ProcessInstantiationResponse startProcess(String id) {
        return startProcess(id, new HashMap<>());
    }

    @Override
    public ProcessInstantiationResponse startProcess(String id, Map<String, Object> params) {
        log.info("Start process {} with params {}", id, params);
        return apiProvider.get(ProcessApi.class).instanciateProcess(id, params);
    }

    @Override
    public UserTask getUserTask(String taskId) {
        log.info("Get User Task {}", taskId);
        return ofNullable(apiProvider.get(UserTaskApi.class).getUserTaskById(taskId))
                .map(
                        userTask -> {
                            log.debug("Found successfully User Task: {}", userTask);
                            return userTask;
                        })
                .orElseThrow(() -> new NotFoundException("No user task found for id: " + taskId));
    }

    @Override
    public List<UserTask> searchUserTask(String rootContainerId) {
        log.info("Search User Task for process instance {}", rootContainerId);
        // comment reported from deployer code ???: TODO human task api call instead user task api
        List<UserTask> userTasks = apiProvider
                .get(UserTaskApi.class)
                .searchUserTasks(
                        new UserTaskApi.SearchUserTasksQueryParams()
                                .f(singletonList("rootCaseId=" + rootContainerId)));
        log.debug("Found User Tasks: {}", userTasks);
        return userTasks;
    }

    @Override
    public void assignUserTask(String taskId, String assignedUserId) {
        assignUserTask(taskId, assignedUserId, null);
    }

    @Override
    public void assignUserTask(String taskId, String assignedUserId, String state) {
        log.info("Updating User Task {}. Assigned to {} in state {}", taskId, assignedUserId, state);
        UserTaskUpdateRequest params = new UserTaskUpdateRequest().assignedId(assignedUserId);
        if (state != null) {
            params.setState(state);
        }
        apiProvider.get(UserTaskApi.class).updateUserTaskById(taskId, params);
        log.info("User Task {} updated", taskId);
    }

    @Override
    public void executeUserTask(String taskId) {
        executeUserTask(taskId, new HashMap<>());
    }

    @Override
    public void executeUserTask(String taskId, Map<String, Object> contractData) {
        log.info("Executing User Task {} with parameters {}", taskId, contractData);
        apiProvider.get(UserTaskApi.class).executeUserTask(taskId, contractData, false);
        log.info("User Task {} executed", taskId);
    }
}
