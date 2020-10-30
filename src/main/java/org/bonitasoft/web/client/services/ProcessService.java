package org.bonitasoft.web.client.services;

import org.bonitasoft.web.client.api.ProcessApi;
import org.bonitasoft.web.client.model.*;
import org.bonitasoft.web.client.services.policies.ProcessImportPolicy;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProcessService {

    /**
     *
     * @param file
     * @param policy
     * throws DuplicatedProcessException : if policy is set to {@link ProcessImportPolicy#FAIL_ON_DUPLICATES}
     */
    void importProcess(File file, ProcessImportPolicy policy);

    List<BusinessProcess> searchProcesses(int page, int count);

    List<BusinessProcess> searchProcesses(ProcessApi.SearchProcessesQueryParams params);

    List<ProcessParameter> searchProcessParameters(int page, int count, String processId);

    List<ProcessResolutionProblem> getProcessProblem(int page, int count, String processId) ;

    Optional<BusinessProcess> getProcess(String name, String version);

    ProcessInstantiationResponse startProcess(String name, String version);

    ProcessInstantiationResponse startProcess(String id);

    ProcessInstantiationResponse startProcess(String id, Map<String, Object> params);

    UserTask getUserTask(String taskId);

    List<UserTask> searchUserTask(String rootContainerId);

    void assignUserTask(String taskId, String assignedUserId);

    void assignUserTask(String taskId, String assignedUserId, String state);

    void executeUserTask(String taskId);

    void executeUserTask(String taskId, Map<String, Object> contractData);
}
