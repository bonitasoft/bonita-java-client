package org.bonitasoft.web.client.services;

import org.bonitasoft.web.client.api.ApplicationApi;
import org.bonitasoft.web.client.model.Application;
import org.bonitasoft.web.client.services.policies.ApplicationImportPolicy;

import java.io.File;
import java.util.List;

public interface ApplicationService {

    void importApplications(File content, ApplicationImportPolicy policy);

    Application getApplication(String applicationToken);

    List<Application> searchApplications(int page, int count);

    List<Application> searchApplications(ApplicationApi.SearchApplicationsQueryParams params);

    boolean deleteApplication(String applicationToken);
}
