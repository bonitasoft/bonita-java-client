/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.services;

import com.bonitasoft.web.client.event.ImportNotifier;
import com.bonitasoft.web.client.event.ImportWarningEvent;
import com.bonitasoft.web.client.exception.ClientException;
import com.bonitasoft.web.client.exception.UnauthorizedException;
import com.bonitasoft.web.client.internal.api.ProcessAPI;
import com.bonitasoft.web.client.internal.security.SecurityContext;
import com.bonitasoft.web.client.internal.services.model.BusinessArchive;
import com.bonitasoft.web.client.model.Process;
import com.bonitasoft.web.client.model.ProcessParameter;
import com.bonitasoft.web.client.model.ProcessResolutionProblem;
import com.bonitasoft.web.client.policies.ProcessImportPolicy;
import com.bonitasoft.web.client.utils.Json;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import static java.lang.String.format;

@Slf4j
public class ProcessService extends ClientService {

    private final ProcessAPI processAPI;
    private final ImportNotifier importNotifier;

    public ProcessService(SecurityContext securityContext, ProcessAPI processAPI, ImportNotifier importNotifier) {
        super(securityContext);
        this.processAPI = processAPI;
        this.importNotifier = importNotifier;
    }

    /**
     * Upload and activate a process according the given policy
     *
     * @param content the process file to deploy
     * @param policy  the deploy policy
     * @return the deployed process id
     * @throws IOException
     * @throws ClientException
     */
    public long importProcess(File content, ProcessImportPolicy policy)
            throws IOException, ClientException {
        log.info("Deploying process '{}' using policy {} ...", content.getName(), policy.name());
        securityContext.isAuthenticated();
        BusinessArchive businessArchive = BusinessArchive.read(content);
        String processName = businessArchive.getName();
        String processVersion = businessArchive.getVersion();
        Optional<Process> maybeProcess = getProcess(processName, processVersion);
        if (maybeProcess.isPresent()) {
            Process process = maybeProcess.get();
            log.debug("Process '{}' in version '{}' already exists.", processName, processVersion);
            switch (policy) {
                case REPLACE_DUPLICATES:
                    //simulate a REPLACE_DUPLICATES policy here because it is not implemented in engine side
                    log.debug("Process '{}' in version '{}' already exists. Policy REPLACE_DUPLICATES: deleting existing process...", processName, processVersion);
                    deleteExistingProcess(process);
                    break;
                case IGNORE_DUPLICATES:
                    String message = String.format("Process '%s' in version '%s' already exists. " +
                            "Policy IGNORE_DUPLICATES: skip deployment of existing process.", processName, processVersion);
                    importNotifier.post(new ImportWarningEvent(message));
                    break;
                default:
                    throw new ClientException(format("Process '%s' in version '%s' already exists. Policy FAIL_ON_DUPLICATES: deployment aborted.", processName, processVersion));
            }
        }

        RequestBody requestFile = RequestBody.create(MultipartBody.FORM, content);
        MultipartBody.Part body = MultipartBody.Part.createFormData("process.bar", "process.bar",
                requestFile);

        log.debug("Uploading process file...");
        Response<String> responseUpload = processAPI.uploadContent(body).execute();
        checkResponse(responseUpload);
        log.debug("Process file uploaded successfully.");

        Map<String, Serializable> uploadedPageZipName = Json.asMap("fileupload", responseUpload.body());
        Response<Process> responseImport = processAPI.add(uploadedPageZipName).execute();
        checkResponse(responseImport);
        log.info("Process deployed successfully.");

        final Process processDeployed = responseImport.body();
        if (processDeployed == null) {
            throw new ClientException(format("Failed to parse import process response for process %s-%s", processName, processVersion));
        }
        if (Process.ConfigurationState.RESOLVED.equals(processDeployed.getConfigurationState())) {
            log.info("Process '{}' ({}) is resolved. Activating process...", processName, processVersion);
            long processId = processDeployed.getId();
            try {
                Map<String, Serializable> payload = Json.asMap("activationState", "ENABLED");
                Response<ResponseBody> responseProcessActivation = processAPI.update(processId, payload).execute();
                checkResponse(responseProcessActivation);
                log.info("Process activated successfully.");
            } catch (IOException e) {
                log.debug(e.getMessage());
                String message = format(
                        "Failed to activate the process %s. This is certainly due to configuration issues, see details below.",
                        content.getName());
                importNotifier.post(new ImportWarningEvent(message));

                log.debug("Retrieving process activation problems...");
                Response<List<ProcessResolutionProblem>> problems = processAPI
                        .processResolutionProblem(0, 20, "process_id=" + processId).execute(); // 20 looks enough for a single shot.
                checkResponse(problems);
                log.debug("Process activation problems retrieved successfully.");
                problems.body().stream()
                        .map(ProcessResolutionProblem::toString)
                        .forEach(log::warn);
            }
        } else {
            log.info("Process '{}' ({}) is unresolved. It cannot be activated for now.", processName, processVersion);
        }

        return processDeployed.getId();
    }

    private void deleteExistingProcess(Process process) throws IOException, UnauthorizedException {
        if (Objects.equals(process.getActivationState(), Process.ActivationState.ENABLED)) {
            log.info("Deactivating existing process...");
            Map<String, Serializable> payload = Json.asMap("activationState", "DISABLED");
            Response<ResponseBody> responseProcessActivation = processAPI.update(process.getId(), payload)
                    .execute();
            checkResponse(responseProcessActivation);
            log.info("Existing process deactivated.");
        }
        List<Long> payload = Collections.singletonList(process.getId());
        Response<ResponseBody> response = processAPI.delete(payload).execute();
        checkResponse(response);
        log.debug("Existing process deleted.");
    }

    public Optional<Process> getProcess(String name, String version) throws IOException {
        log.debug("Retrieving process '{}' with version '{}'", name, version);
        List<Process> body = processAPI.search(0, 1, "name=" + name, "version=" + version).execute().body();
        if (body == null || body.isEmpty()) {
            log.debug("Can't find any existing process with name '{}' and version '{}'.", name, version);
            return Optional.empty();
        }
        log.debug("Process '{}' with version '{}' retrieved successfully.", name, version);
        return Optional.of(body.get(0));
    }

    public List<Process> searchProcesses(int page, int count) throws IOException {
        List<Process> body = processAPI.search(page, count).execute().body();
        if (body == null || body.isEmpty()) {
            return Collections.emptyList();
        }
        return body;
    }

    public List<ProcessParameter> searchProcessParameters(int page, int count, long processId) throws IOException {
        List<ProcessParameter> body = processAPI.searchParameters(page, count, "process_id=" + processId).execute()
                .body();
        if (body == null || body.isEmpty()) {
            return Collections.emptyList();
        }
        return body;
    }

    /**
     * @return the id of the case/process instance
     */
    public long startProcess(long processDefinitionId) throws IOException, ClientException {
        return startProcess(processDefinitionId, new HashMap<>());
    }

    /**
     * @return the id of the case/process instance
     */
    public long startProcess(long processDefinitionId, Map<String, Serializable> params)
            throws IOException, ClientException {
        securityContext.isAuthenticated();
        Response<ResponseBody> response = processAPI
                .start(processDefinitionId, params).execute();
        checkResponse(response);
        HashMap<String, Object> responseMap = objectMapper.readValue(response.body().string(), HashMap.class);
        Number caseId = (Number) responseMap.get("caseId");
        return caseId.longValue();
    }

}
