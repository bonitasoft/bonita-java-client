package org.bonitasoft.web.client.services;

import org.bonitasoft.web.client.api.ProcessApi;
import org.bonitasoft.web.client.model.BusinessProcess;
import org.bonitasoft.web.client.model.ProcessInstantiationResponse;
import org.bonitasoft.web.client.model.ProcessParameter;
import org.bonitasoft.web.client.services.policies.ProcessImportPolicy;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProcessService {
    void importProcess(File file, ProcessImportPolicy policy);

    List<BusinessProcess> searchProcesses(int page, int count);

    List<BusinessProcess> searchProcesses(ProcessApi.SearchProcessesQueryParams params);

    List<ProcessParameter> searchProcessParameters(int page, int count, long processId);

    Optional<BusinessProcess> getProcess(String name, String version);

    ProcessInstantiationResponse startProcess(String name, String version);

    ProcessInstantiationResponse startProcess(String id);

    ProcessInstantiationResponse startProcess(String id, Map<String, Object> params);
}
