package org.bonitasoft.web.client.services;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bonitasoft.web.client.api.ProcessApi;
import org.bonitasoft.web.client.model.ProcessDefinition;
import org.bonitasoft.web.client.model.ProcessInstantiationResponse;
import org.bonitasoft.web.client.model.ProcessParameter;
import org.bonitasoft.web.client.model.ProcessResolutionProblem;
import org.bonitasoft.web.client.model.UserTask;
import org.bonitasoft.web.client.services.policies.ProcessImportPolicy;

public interface ProcessService {

    /**
     * @param file
     * @param policy throws DuplicatedProcessException : if policy is set to {@link
     *        ProcessImportPolicy#FAIL_ON_DUPLICATES}
     */
    void importProcess(File file, ProcessImportPolicy policy);

    List<ProcessDefinition> searchProcesses(int page, int count);

    List<ProcessDefinition> searchProcesses(ProcessApi.SearchProcessesQueryParams params);

    List<ProcessParameter> searchProcessParameters(int page, int count, String processId);

    List<ProcessResolutionProblem> getProcessProblem(int page, int count, String processId);

    Optional<ProcessDefinition> getProcess(String name, String version);

    ProcessInstantiationResponse startProcess(String name, String version);

    ProcessInstantiationResponse startProcess(String id);

    ProcessInstantiationResponse startProcess(String id, Map<String, Object> params);

    /**
     * @param taskId
     * @return
     * @throws org.bonitasoft.web.client.exception.NotFoundException if no UserTask for the given id
     */
    UserTask getUserTask(String taskId);

    List<UserTask> searchUserTask(String rootContainerId);

    void assignUserTask(String taskId, String assignedUserId);

    void assignUserTask(String taskId, String assignedUserId, String state);

    void executeUserTask(String taskId);

    void executeUserTask(String taskId, Map<String, Object> contractData);
}
