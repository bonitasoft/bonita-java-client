/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package org.bonitasoft.web.client.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bonitasoft.web.client.BonitaClient;
import org.bonitasoft.web.client.api.*;
import org.bonitasoft.web.client.exception.ClientException;
import org.bonitasoft.web.client.exception.NotFoundException;
import org.bonitasoft.web.client.model.*;
import org.bonitasoft.web.client.services.LoginService;
import org.bonitasoft.web.client.services.model.BusinessArchive;
import org.bonitasoft.web.client.services.policies.ApplicationImportPolicy;
import org.bonitasoft.web.client.services.policies.OrganizationImportPolicy;
import org.bonitasoft.web.client.services.policies.ProcessImportPolicy;
import org.bonitasoft.web.client.services.policies.ProfileImportPolicy;
import org.bonitasoft.web.client.services.utils.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.lang.String.format;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.Optional.ofNullable;
import static org.bonitasoft.web.client.api.ApplicationApi.SearchApplicationsQueryParams;
import static org.bonitasoft.web.client.api.UserApi.SearchUsersQueryParams;

/**
 * Entry point to interact with the REST API of bonita. <br>
 * Instances of BonitaClient can be created with the {@link BonitaFeignClientBuilderImpl} class.
 */
@Slf4j
@RequiredArgsConstructor
class BonitaFeignClient implements BonitaClient {

    private static final String COMMUNITY = "Community";
    public static final License COMMUNITY_LICENCE = new License().edition(COMMUNITY).nbCpuCores("" + Runtime.getRuntime().availableProcessors());

    private final LoginService loginService;
    private final ApiProvider apiProvider;
    private final ObjectMapper objectMapper;

    private Boolean community = null;

    @Override
    public boolean isPlatformUpAndRunning() {
        return loginService.isPlatformUpAndRunning();
    }

    @Override
    public Session login(String username, String password) {
        return login(username, password, DEFAULT_TENANT_ID);
    }

    @Override
    public Session login(String username, String password, String tenant) {
        log.info("Try login user {} on tenant {}", username, tenant);
        Session session = loginService.login(username, password, tenant);
        log.debug("User logged in: {}", session);
        return session;
    }

    @Override
    public void logout() {
        log.info("Logout user");
        loginService.logout();
    }

    @Override
    public void logoutSilent() {
        try {
            logout();
        } catch (Exception e) {
            log.debug("Ignoring error as we are performing a silent logout", e);
        }
    }

    @Override
    public void importBDM(File bdm) {
        log.info("Importing Business Data Model file: {}", bdm.getName());

        // Pause tenant
        log.debug("Pausing tenant ...");
        SystemTenantApi tenantApi = apiProvider.get(SystemTenantApi.class);
        tenantApi.updateSystemTenant(DEFAULT_TENANT_ID, new TenantPauseRequest().paused("true"));
        log.debug("Tenant paused");

        deleteBdmAccessControlIfNeeded();

        BdmApi bdmApi = apiProvider.get(BdmApi.class);
        String uploadedFileName = bdmApi.uploadBDM(bdm);
        log.debug("BDM file uploaded");
        bdmApi.installBDM(new BDMInstallRequest().fileUpload(uploadedFileName));
        log.debug("BDM file installed");

        // Restart tenant
        log.debug("Resuming tenant ...");
        tenantApi.updateSystemTenant(DEFAULT_TENANT_ID, new TenantPauseRequest().paused("false"));
        log.debug("Tenant Resumed");

        log.info("Business Data Model deployed successfully.");
    }

    @Override
    public void importBdmAccessControl(File accessControl) {
        log.info("Importing BDM AccessControl file: {}", accessControl.getName());

        deleteBdmAccessControlIfNeeded();

        BdmAccessControlApi bdmAccessControlApi = apiProvider.get(BdmAccessControlApi.class);
        String uploadedFileName = bdmAccessControlApi.uploadBDMAccessControl(accessControl);
        log.debug("BDM Access Control file uploaded");
        bdmAccessControlApi.importBDMAccessControl(uploadedFileName);
        log.debug("BDM Access Control file installed");

        log.info("BDM AccessControl file imported successfully");
    }

    private void deleteBdmAccessControlIfNeeded() {
        if (TenantResourceState.INSTALLED.equals(getBdmAccessControlStatus().getState())) {
            log.debug("Deleting previous BdmAccessControl ...");
            BdmAccessControlApi accessControlApi = apiProvider.get(BdmAccessControlApi.class);
            accessControlApi.deleteBDMAccessControl();
            log.debug("Previous BdmAccessControl deleted");
        }
    }

    @Override
    public Bdm getBdmStatus() {
        log.info("Get BDM status");
        BdmApi bdmApi = apiProvider.get(BdmApi.class);
        Bdm bdm = bdmApi.getBdm();
        log.debug("BDM status: {}", bdm);
        return bdm;
    }

    @Override
    public BDMAccessControl getBdmAccessControlStatus() {
        log.info("Get BDM AccessControl status");

        if (isCommunity()) {
            log.warn("BDM AccessControl management is not available in community edition.");
            // Prevent BDMAccessControl deletion by returning another status than INSTALLED
            return new BDMAccessControl().state(TenantResourceState.INSTALLING);
        }
        BdmAccessControlApi accessControlApi = apiProvider.get(BdmAccessControlApi.class);
        BDMAccessControl bdmAccessControlStatus = accessControlApi.getBDMAccessControlStatus();
        log.debug("BDM status: {}", bdmAccessControlStatus);
        return bdmAccessControlStatus;
    }

    @Override
    public void importOrganization(File organization, OrganizationImportPolicy policy) {
        log.info("Importing organization file: {} with policy: {}", organization.getName(), policy);
        OrganizationApi organizationApi = apiProvider.get(OrganizationApi.class);
        String uploadedFileName = organizationApi.uploadOrganization(organization);
        log.debug("Organization file uploaded");
        organizationApi.importOrganization(uploadedFileName, policy.name());
        log.debug("Organization file installed");
        log.info("Organization file imported successfully");
    }

    @Override
    public User getUser(String username) {
        log.info("Get user with username: {}", username);
        UserApi userApi = apiProvider.get(UserApi.class);
        List<String> filter = singletonList("userName=" + username);
        return userApi.searchUsers(new SearchUsersQueryParams().p(0).c(1).f(filter)).stream().findFirst()
                .orElseThrow(() -> new NotFoundException("No user found for the username: " + username));
    }

    @Override
    public User createUser(UserCreateRequest userCreateRequest) {
        log.info("Create user with params: {}", userCreateRequest);
        UserApi userApi = apiProvider.get(UserApi.class);
        return userApi.createUser(userCreateRequest);
    }

    @Override
    public List<User> searchUsers(SearchUsersQueryParams params) {
        log.info("Find users with params: {}", params);
        UserApi userApi = apiProvider.get(UserApi.class);
        return userApi.searchUsers(params);
    }

    @Override
    public boolean isTenantPaused() {
        log.info("Check if tenant is paused");
        SystemTenantApi tenantApi = apiProvider.get(SystemTenantApi.class);
        Boolean paused = ofNullable(tenantApi.getSystemTenant(DEFAULT_TENANT_ID).getPaused())
                .orElse(false);
        log.debug("Tenant paused: {}", paused);
        return paused;
    }

    @Override
    public String getVersion() {
        log.info("Get Bonita version");
        Session session = loginService.getSession();
        String version = session.getVersion();
        log.debug("Bonita version: {}", version);
        return version;
    }

    @Override
    public License getLicense() {
        log.info("Get Bonita license");
        LicenseApi licenseApi = apiProvider.get(LicenseApi.class);
        Response response = licenseApi.getLicense();
        License license;
        if (response.status() == 200) {
            try {
                license = objectMapper.readValue(response.body().asInputStream(), License.class);
                log.debug("Bonita license: {}", license);
                return license;
            } catch (Exception e) {
                log.error("Failed to read license response", e);
                return COMMUNITY_LICENCE;
            }
        } else {
            log.debug("Bonita license: {}", COMMUNITY_LICENCE);
            return COMMUNITY_LICENCE;
        }
    }

    private boolean isCommunity() {
        if (community == null) {
            // Get licence only once and cache result
            community = COMMUNITY.equalsIgnoreCase(getLicense().getEdition());
        }
        return community;
    }

    @Override
    public void importApplications(File application, ApplicationImportPolicy policy) {

        log.info("Deploying applications in '{}' using policy {}", application.getName(), policy.name());

        //temporary simulate a REPLACE_DUPLICATES policy here because it is not implemented in engine side
        if (policy.equals(ApplicationImportPolicy.REPLACE_DUPLICATES)) {
            log.debug("Policy REPLACE_DUPLICATES: deleting existing applications...");
            deleteExistingApplications(application);
            log.debug("Existing application deleted successfully.");
            //reset
            policy = ApplicationImportPolicy.FAIL_ON_DUPLICATES;
        }
        log.debug("Uploading application file...");
        ApplicationApi applicationApi = apiProvider.get(ApplicationApi.class);
        String uploadedFileName = applicationApi.uploadApplication(application);
        log.debug("Application file uploaded successfully.");
        applicationApi.importApplication(uploadedFileName, policy.name());
        log.info("Applications in '{}' deployed successfully.", application.getName());
    }

    private void deleteExistingApplications(File application) {
        List<String> applicationTokens = getApplicationTokens(application);
        for (String applicationToken : applicationTokens) {
            Application app = getApplication(applicationToken);
            if (app != null) {
                log.debug("Deleting application '{}'...", app.getToken());
                apiProvider.get(ApplicationApi.class).deleteApplicationById(app.getId());
                log.debug("Application '{}' deleted successfully.", app.getToken());
            }
        }
    }

    private List<String> getApplicationTokens(File application) {
        List<String> tokens = new ArrayList<>();
        try {
            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setNamespaceAware(false);
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document doc = builder.parse(application);
            XPath xPath = XPathFactory.newInstance().newXPath();
            XPathExpression compile = xPath.compile("/applications/application/@token");
            NodeList nodeList = (NodeList) compile.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node item = nodeList.item(i);
                tokens.add(item.getNodeValue());
            }
        } catch (IOException | XPathExpressionException | SAXException | ParserConfigurationException e) {
            throw new ClientException("Failed to read application tokens from file: " + application.getName(), e);
        }
        return tokens;
    }

    @Override
    public Application getApplication(String applicationToken) {
        log.debug("Retrieving application '{}'", applicationToken);
        return apiProvider.get(ApplicationApi.class)
                .searchApplications(new SearchApplicationsQueryParams()
                        .p(0).c(1)
                        .f(singletonList("token=" + applicationToken)))
                .stream().findFirst().orElse(null);
    }

    @Override
    public List<Application> searchApplications(int page, int count) {
        return searchApplications(new SearchApplicationsQueryParams().p(page).c(count));
    }

    @Override
    public List<Application> searchApplications(SearchApplicationsQueryParams params) {
        log.debug("Findings applications with request params {}", params);
        return apiProvider.get(ApplicationApi.class)
                .searchApplications(params);
    }

    @Override
    public boolean deleteApplication(String applicationToken) {
        log.debug("Deleting application: {}", applicationToken);
        Application application = getApplication(applicationToken);
        if (application == null) {
            log.error("Failed to delete application (not found): {}", applicationToken);
            return false;
        }
        apiProvider.get(ApplicationApi.class).deleteApplicationById(application.getId());
        log.debug("Application {} deleted", applicationToken);
        return true;
    }

    @Override
    public void importBonitaConfiguration(File configurationFile) {
        if (isCommunity()) {
            String message = "Skipping the Bonita Configuration deployment: your current Bonita license is 'Community'"
                    + " and the Bonita Configuration feature is supported only on 'Subscription' editions.";
            log.warn(message);
            return;
        }
        log.info("Deploying configuration '{}'...", configurationFile.getName());
        String uploadedFileName = apiProvider.get(ApplicationApi.class).uploadApplicationConfiguration(configurationFile);
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
            //page already exists, we update it
            log.debug("Updating existing page...");
            pageApi.updatePageById(page.getId(), new PageUpdateRequest().pageZip(uploadedFileName));
        } else {
            //page do not exists, we create it
            log.debug("Creating new page...");
            page = pageApi.createPage(new PageCreateRequest().pageZip(uploadedFileName));
        }
        log.info("Page deployed successfully.");
        return page;
    }

    private Page getPage(File pageZip) {
        try {
            byte[] pageProperties = FileUtils.getFileFromZip(pageZip, "page.properties");
            Properties properties = new Properties();
            properties.load(new ByteArrayInputStream(pageProperties));
            String name = properties.getProperty("name");
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException(format("Invalid page %s, page.properties do not contains a name" +
                        " attribute", pageZip.getPath()));
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
        log.info("Retrieving page '{}'", token);
        List<Page> pages = apiProvider.get(PageApi.class).searchPages(new PageApi.SearchPagesQueryParams()
                .p(0).c(1)
                .f(singletonList("urlToken=" + token)));
        if (pages.isEmpty()) {
            // FIXME: why not 404 ?
            log.debug("Can't find any existing page with the token '{}'.", token);
            return null;
        }
        log.debug("Page '{}' retrieved successfully.", token);
        return pages.get(0);
    }

    @Override
    public boolean deletePage(String token) {
        log.info("Deleting page '{}'...", token);
        Page page = getPage(token);
        if (page == null) {
            log.debug("Page '{}' not found, skip deletion", token);
            return false;
        }
        apiProvider.get(PageApi.class).deletePageById(page.getId());
        log.debug("Page '{}' deleted", token);
        return true;
    }

    @Override
    public void importProcess(File barFile, ProcessImportPolicy policy) {
        log.info("Deploying process '{}' using policy {} ...", barFile.getName(), policy.name());
        BusinessArchive bar = BusinessArchive.create(barFile);
        Optional<BusinessProcess> process = getProcess(bar.getProcessName(), bar.getProcessVersion());
        if (process.isPresent()) {
            log.debug("Process '{}' in version '{}' already exists.", bar.getProcessName(), bar.getProcessVersion());
            switch (policy) {
                case REPLACE_DUPLICATES:
                    //simulate a REPLACE_DUPLICATES policy here because it is not implemented in engine side
                    log.debug("Process '{}' in version '{}' already exists. Policy REPLACE_DUPLICATES: deleting existing process...",
                            bar.getProcessName(), bar.getProcessVersion());
                    deleteExistingProcess(process.get());
                    break;
                case IGNORE_DUPLICATES:
                    String message = format("Process '%s' in version '%s' already exists. Policy IGNORE_DUPLICATES: skip deployment of existing process.",
                            bar.getProcessName(), bar.getProcessVersion());
                    log.debug(message);
                    break;
                case FAIL_ON_DUPLICATES:
                    // ???
                    break;
                default:
                    throw new ClientException(format("Process '%s' in version '%s' already exists. Policy FAIL_ON_DUPLICATES: deployment aborted.",
                            bar.getProcessName(), bar.getProcessVersion()));
            }
        }

        ProcessApi processApi = apiProvider.get(ProcessApi.class);
        log.debug("Uploading process file...");
        String uploadedFileName = processApi.uploadProcess(barFile);
        log.debug("Process file uploaded successfully.");

        BusinessProcess processDeployed = processApi.createProcess(new ProcessCreateRequest().fileupload(uploadedFileName));
        log.info("Process deployed successfully.");

        if (ConfigurationState.RESOLVED.equals(processDeployed.getConfigurationState())) {
            log.info("Process '{}' ({}) is resolved. Activating process...", bar.getProcessName(), bar.getProcessVersion());
            String processId = processDeployed.getId();
            processApi.updateProcessById(processId, new ProcessUpdateRequest().activationState(ActivationState.ENABLED));
            log.info("Process activated successfully.");
        } else {
            log.info("Process '{}' ({}) is unresolved. It cannot be activated for now.", bar.getProcessName(), bar.getProcessVersion());
        }
    }

    private void deleteExistingProcess(BusinessProcess process) {
        ProcessApi processApi = apiProvider.get(ProcessApi.class);
        if (ActivationState.ENABLED.equals(process.getActivationState())) {
            log.info("Deactivating existing process...");
            processApi.updateProcessById(process.getId(), new ProcessUpdateRequest().activationState(ActivationState.DISABLED));
            log.info("Existing process deactivated.");
        }
        processApi.deleteProcessById(process.getId());
        log.debug("Existing process deleted.");
    }

    @Override
    public Optional<BusinessProcess> getProcess(String name, String version) {
        log.debug("Retrieving process '{}' with version '{}'", name, version);
        List<BusinessProcess> processes = apiProvider.get(ProcessApi.class).searchProcesses(new ProcessApi.SearchProcessesQueryParams()
                .p(0).c(1)
                .f(asList(
                        "name=" + name,
                        "version=" + version
                ))
        );
        if (processes.isEmpty()) {
            log.debug("Can't find any existing process with name '{}' and version '{}'.", name, version);
            return Optional.empty();
        }
        log.debug("Process '{}' with version '{}' retrieved successfully.", name, version);
        return processes.stream().findFirst();
    }

    @Override
    public List<BusinessProcess> searchProcesses(int page, int count) {
        return searchProcesses(new ProcessApi.SearchProcessesQueryParams().p(page).c(count));
    }

    @Override
    public List<BusinessProcess> searchProcesses(ProcessApi.SearchProcessesQueryParams params) {
        return apiProvider.get(ProcessApi.class).searchProcesses(params);
    }

    @Override
    public List<ProcessParameter> searchProcessParameters(int page, int count, long processId) {
        return apiProvider.get(ProcessParameterApi.class).searchProcessParameters(
                new ProcessParameterApi.SearchProcessParametersQueryParams().p(page).c(count)
                        .f(singletonList("process_id=" + processId)));
    }

    @Override
    public ProcessInstantiationResponse startProcess(String name, String version) {
        return getProcess(name, version)
                .map(p -> startProcess(p.getId()))
                .orElseThrow(() -> new NotFoundException(format("No process found for name '%s' and version '%s'", name, version)));
    }

    @Override
    public ProcessInstantiationResponse startProcess(String id) {
        return startProcess(id, new HashMap<>());
    }

    @Override
    public ProcessInstantiationResponse startProcess(String id, Map<String, Object> params) {
        return apiProvider.get(ProcessApi.class).instanciateProcess(id, params);
    }

    @Override
    public void importProfiles(File profiles, ProfileImportPolicy policy) {
        if (isCommunity()) {
            log.warn("Profile import is not available in community edition.");
            return;
        }
        log.info("Importing profiles from {} with {}...", profiles.getName(), policy);
        ProfileApi profileApi = apiProvider.get(ProfileApi.class);
        log.debug("Uploading profiles file...");
        String uploadedFileName = profileApi.uploadprofiles(profiles);
        log.debug("Installing profiles file...");
        profileApi.importProfiles(uploadedFileName, policy.name());
        log.info("Profiles imported");
    }

    @Override
    public List<Profile> searchProfiles(int page, int count) {
        ProfileApi.SearchProfilesQueryParams params = new ProfileApi.SearchProfilesQueryParams()
                .p(page).c(count)
                .o("name ASC");
        return searchProfiles(params);
    }

    @Override
    public Role getRoleByName(String name) {
        return searchRoles(new RoleApi.SearchRolesQueryParams()
                .p(0).c(1)
                .f(singletonList("name=" + name))
        ).stream().findFirst().orElseThrow(() -> new NotFoundException("Role with name '" + name + "' not found"));
    }

    @Override
    public Profile getProfileByName(String name) {
        return searchProfiles(new ProfileApi.SearchProfilesQueryParams()
                .p(0).c(1)
                .f(singletonList("name=" + name))
        ).stream().findFirst().orElseThrow(() -> new NotFoundException("Profile with name  '" + name + "' not found"));
    }

    @Override
    public List<Role> searchRoles(RoleApi.SearchRolesQueryParams params) {
        log.info("Finding roles with params: {}", params);
        return apiProvider.get(RoleApi.class).searchRoles(params);
    }

    public List<Profile> searchProfiles(ProfileApi.SearchProfilesQueryParams params) {
        log.info("Finding profiles with params: {}", params);
        return apiProvider.get(ProfileApi.class).searchProfiles(params);
    }

    @Override
    public String addUserToProfile(String userId, String profileId) {
        log.info("Add user {} to profile {}...", userId, profileId);
        ProfileMemberApi profileMemberApi = apiProvider.get(ProfileMemberApi.class);
        ProfileMember profileMember = profileMemberApi.createProfileMember(new ProfileMemberCreateRequest()
                .memberType(ProfileMemberCreateRequest.MemberTypeEnum.USER)
                .userId(userId)
                .profileId(profileId)
        );
        log.info("User membership added to profile {}. Membership: {}", profileId, profileMember);
        return profileMember.getId();
    }

    @Override
    public String addRoleToProfile(String roleId, String profileId) {
        log.info("Add role {} to profile {}...", roleId, profileId);
        ProfileMemberApi profileMemberApi = apiProvider.get(ProfileMemberApi.class);
        ProfileMember profileMember = profileMemberApi.createProfileMember(new ProfileMemberCreateRequest()
                .memberType(ProfileMemberCreateRequest.MemberTypeEnum.ROLE)
                .roleId(roleId)
                .profileId(profileId)
        );
        log.info("Role membership added to profile {}. Membership: {}", profileId, profileMember);
        return profileMember.getId();
    }

    @Override
    public String addUserToProfileByNames(String username, String profileName) {
        User user = getUser(username);
        Profile profile = getProfileByName(profileName);
        return addUserToProfile(user.getId(), profile.getId());
    }

    @Override
    public UserTask getUserTask(String taskId) {
        log.debug("Getting User Task {}", taskId);
        UserTask userTask = apiProvider.get(UserTaskApi.class).getUserTaskById(taskId);
        log.debug("Retrieved User Task: {}", userTask);
        return userTask;
    }

    @Override
    public List<UserTask> searchUserTask(String rootContainerId) {
        log.debug("Searching User Task for process instance {}", rootContainerId);
        // from deployer code ???: TODO human task api call instead user task api
        List<UserTask> userTasks = apiProvider.get(UserTaskApi.class).searchUserTasks(
                new UserTaskApi.SearchUserTasksQueryParams()
                        .f(singletonList("rootContainerId=" + rootContainerId))
        );
        log.debug("Retrieved User Tasks: {}", userTasks);
        return userTasks;
    }
    @Override
    public void assignUserTask(String taskId, String assignedUserId) {
        assignUserTask(taskId,assignedUserId,null);
    }

    @Override
    public void assignUserTask(String taskId, String assignedUserId, String state) {
        log.debug("Updating User Task {}. Assigned to {} in state {}", taskId, assignedUserId, state);
        UserTaskUpdateRequest params = new UserTaskUpdateRequest().assignedId(assignedUserId);
        if (state != null) {
            params.setState(state);
        }
        apiProvider.get(UserTaskApi.class).updateUserTaskById(taskId, params);
        log.debug("User Task {} updated", taskId);
    }

    @Override
    public void executeUserTask(String taskId) {
        executeUserTask(taskId,new HashMap<>());
    }

    @Override
    public void executeUserTask(String taskId, Map<String, Object> contractData) {
        log.debug("Executing User Task {} with parameters {}", taskId, contractData);
        apiProvider.get(UserTaskApi.class).executeUserTask(taskId, contractData,false);
        log.debug("User Task {} executed", taskId);
    }
}
