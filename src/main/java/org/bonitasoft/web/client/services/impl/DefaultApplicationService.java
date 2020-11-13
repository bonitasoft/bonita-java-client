package org.bonitasoft.web.client.services.impl;

import static java.lang.String.format;
import static java.util.Collections.singletonList;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.bonitasoft.web.client.api.ApplicationApi;
import org.bonitasoft.web.client.api.PageApi;
import org.bonitasoft.web.client.exception.ClientException;
import org.bonitasoft.web.client.exception.LicenseException;
import org.bonitasoft.web.client.exception.NotFoundException;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.Application;
import org.bonitasoft.web.client.model.Page;
import org.bonitasoft.web.client.model.PageCreateRequest;
import org.bonitasoft.web.client.model.PageUpdateRequest;
import org.bonitasoft.web.client.services.ApplicationService;
import org.bonitasoft.web.client.services.impl.base.AbstractService;
import org.bonitasoft.web.client.services.impl.base.ClientContext;
import org.bonitasoft.web.client.services.impl.xml.XmlDocumentParser;
import org.bonitasoft.web.client.services.policies.ApplicationImportPolicy;
import org.bonitasoft.web.client.services.utils.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Slf4j
public class DefaultApplicationService extends AbstractService implements ApplicationService {

  public DefaultApplicationService(
      ClientContext clientContext, ApiProvider apiProvider, ObjectMapper objectMapper) {
    super(apiProvider, objectMapper, clientContext);
  }

  @Override
  public void importApplications(File applicationFile, ApplicationImportPolicy policy) {
    log.info(
        "Deploying applications in '{}' using policy {}", applicationFile.getName(), policy.name());
    // temporary simulate a REPLACE_DUPLICATES policy here because it is not implemented in engine
    // side
    if (policy.equals(ApplicationImportPolicy.REPLACE_DUPLICATES)) {
      log.debug("Policy REPLACE_DUPLICATES: deleting existing applications...");
      readApplicationTokensFromFile(applicationFile).forEach(this::silentDeleteApplication);
      log.debug("Existing applicationFile deleted successfully.");
      // reset policy
      policy = ApplicationImportPolicy.FAIL_ON_DUPLICATES;
    }
    log.debug("Uploading applicationFile file...");
    ApplicationApi applicationApi = apiProvider.get(ApplicationApi.class);
    String uploadedFileName = applicationApi.uploadApplication(applicationFile);
    log.debug("Application file uploaded successfully.");
    applicationApi.importApplication(uploadedFileName, policy.name());
    log.info("Applications in '{}' deployed successfully.", applicationFile.getName());
  }

  private void silentDeleteApplication(String applicationToken) {
    try {
      deleteApplication(applicationToken);
    } catch (NotFoundException e) {
      // No need to delete if it does not exist
    }
  }

  private List<String> readApplicationTokensFromFile(File application) {
    log.debug("Extract application token from file: {}", application.getName());
    List<String> tokens = new ArrayList<>();
    final XmlDocumentParser documentParser = new XmlDocumentParser();
    Document doc = documentParser.parse(application);
    NodeList nodeList = documentParser.queryNodeList(doc, "/applications/application/@token");
    for (int i = 0; i < nodeList.getLength(); i++) {
      Node item = nodeList.item(i);
      tokens.add(item.getNodeValue());
    }
    return tokens;
  }

  @Override
  public Application getApplication(String applicationToken) {
    log.info("Get application '{}'", applicationToken);
    return apiProvider
        .get(ApplicationApi.class)
        .searchApplications(
            new ApplicationApi.SearchApplicationsQueryParams()
                .p(0)
                .c(1)
                .f(singletonList("token=" + applicationToken)))
        .stream()
        .findFirst()
        .orElse(null);
  }

  @Override
  public List<Application> searchApplications(int page, int count) {
    return searchApplications(new ApplicationApi.SearchApplicationsQueryParams().p(page).c(count));
  }

  @Override
  public List<Application> searchApplications(ApplicationApi.SearchApplicationsQueryParams params) {
    log.info("Search applications with params {}", params);
    return apiProvider.get(ApplicationApi.class).searchApplications(params);
  }

  @Override
  public boolean deleteApplication(String applicationToken) {
    log.info("Deleting application: {}", applicationToken);
    Application application = getApplication(applicationToken);
    if (application == null) {
      throw new NotFoundException(format("Application not found: %s", applicationToken));
    }
    apiProvider.get(ApplicationApi.class).deleteApplicationById(application.getId());
    log.info("Application {} deleted", applicationToken);
    return true;
  }

  @Override
  public void importBonitaConfiguration(File configurationFile) {
    if (isCommunity()) {
      String message =
          "Bonita Configuration deployment skipped: your current Bonita license is 'Community' and this feature is only supported in 'Subscription' editions.";
      throw new LicenseException(message);
    }
    log.info("Deploying configuration '{}'...", configurationFile.getName());
    String uploadedFileName =
        apiProvider.get(ApplicationApi.class).uploadApplicationConfiguration(configurationFile);
    log.debug("Bconf upload response: {}", uploadedFileName);
    log.info("Configuration deployed successfully.");
  }

  @Override
  public Page importPage(File pageZip) {
    log.info("Deploying page '{}'...", pageZip.getName());
    PageApi pageApi = apiProvider.get(PageApi.class);

    log.debug("Uploading page file...");
    String uploadedFileName = pageApi.uploadPage(pageZip);
    log.debug("Page file uploaded successfully.");

    Page page = getPage(pageZip);
    if (page != null) {
      // page already exists, we update it
      log.debug("Updating existing page...");
      pageApi.updatePageById(page.getId(), new PageUpdateRequest().pageZip(uploadedFileName));
    } else {
      // page do not exists, we create it
      log.debug("Creating new page...");
      page = pageApi.createPage(new PageCreateRequest().pageZip(uploadedFileName));
    }
    log.info("Page deployed successfully.");
    return page;
  }

  private Page getPage(File pageZip) {
    try {
      log.debug("Extract page name from page.properties in file: {}", pageZip.getName());
      byte[] pageProperties = FileUtils.getFileFromZip(pageZip, "page.properties");
      Properties properties = new Properties();
      properties.load(new ByteArrayInputStream(pageProperties));
      String name = properties.getProperty("name");
      if (name == null || name.isEmpty()) {
        throw new IllegalArgumentException(
            format(
                "Invalid page %s, page.properties do not contains a name attribute",
                pageZip.getPath()));
      }
      return getPage(name);
    } catch (IOException e) {
      String message = "Failed to read page token from page zip file: " + pageZip.getName();
      log.error(message, e);
      throw new ClientException(message);
    }
  }

  @Override
  public List<Page> searchPages(int page, int count) {
    return searchPages(new PageApi.SearchPagesQueryParams().p(page).c(count));
  }

  @Override
  public List<Page> searchPages(PageApi.SearchPagesQueryParams params) {
    log.info("Search pages with request params {}", params);
    return apiProvider.get(PageApi.class).searchPages(params);
  }

  @Override
  public Page getPage(String token) {
    log.info("Get page '{}'", token);
    List<Page> pages =
        apiProvider
            .get(PageApi.class)
            .searchPages(
                new PageApi.SearchPagesQueryParams()
                    .p(0)
                    .c(1)
                    .f(singletonList("urlToken=" + token)));
    if (pages.isEmpty()) {
      // FIXME: why not 404 ?
      log.debug("Can't find any existing page with the token '{}'.", token);
      return null;
    }
    log.debug("Page '{}' found successfully.", token);
    return pages.get(0);
  }

  @Override
  public boolean deletePage(String token) {
    log.info("Deleting page '{}'...", token);
    Page page = getPage(token);
    if (page == null) {
      log.info("Page '{}' not found, skip deletion", token);
      return false;
    }
    apiProvider.get(PageApi.class).deletePageById(page.getId());
    log.info("Page '{}' deleted", token);
    return true;
  }
}
