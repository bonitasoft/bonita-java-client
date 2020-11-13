package org.bonitasoft.web.client.services;

import java.io.File;
import java.util.List;
import org.bonitasoft.web.client.api.ApplicationApi;
import org.bonitasoft.web.client.api.PageApi;
import org.bonitasoft.web.client.model.Application;
import org.bonitasoft.web.client.model.Page;
import org.bonitasoft.web.client.services.policies.ApplicationImportPolicy;

public interface ApplicationService {

  void importApplications(File application, ApplicationImportPolicy policy);

  Application getApplication(String applicationToken);

  List<Application> searchApplications(int page, int count);

  List<Application> searchApplications(ApplicationApi.SearchApplicationsQueryParams params);

  boolean deleteApplication(String applicationToken);

  void importBonitaConfiguration(File configurationFile);

  Page importPage(File pageZip);

  List<Page> searchPages(int page, int count);

  List<Page> searchPages(PageApi.SearchPagesQueryParams params);

  Page getPage(String token);

  boolean deletePage(String token);
}
