package org.bonitasoft.web.client.services;

import org.bonitasoft.web.client.model.ProcessParameter;
import org.bonitasoft.web.client.services.policies.ProcessImportPolicy;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ProcessService {
    long importProcess(File file, ProcessImportPolicy policy);

    List<Process> searchProcesses(int page, int count);

    List<ProcessParameter> searchProcessParameters(int page, int count, long processId);

    Process getProcess(String name, String version);

    long startProcess(String name, String version);

    long startProcess(long id);

    long startProcess(long id, Map<String, Serializable> params);
}
