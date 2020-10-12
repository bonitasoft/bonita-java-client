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
import org.bonitasoft.web.client.services.policies.ApplicationImportPolicy;
import org.bonitasoft.web.client.services.policies.OrganizationImportPolicy;
import org.bonitasoft.web.client.services.policies.ProcessImportPolicy;
import org.bonitasoft.web.client.services.policies.ProfileImportPolicy;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.Process;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    private final ApiLocator apiLocator;
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
        SystemTenantApi tenantApi = apiLocator.getApi(SystemTenantApi.class);
        tenantApi.updateSystemTenant(DEFAULT_TENANT_ID, new TenantPauseRequest().paused("true"));
        log.debug("Tenant paused");

        deleteBdmAccessControlIfNeeded();

        BdmApi bdmApi = apiLocator.getApi(BdmApi.class);
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

        BdmAccessControlApi bdmAccessControlApi = apiLocator.getApi(BdmAccessControlApi.class);
        String uploadedFileName = bdmAccessControlApi.uploadBDMAccessControl(accessControl);
        log.debug("BDM Access Control file uploaded");
        bdmAccessControlApi.importBDMAccessControl(uploadedFileName);
        log.debug("BDM Access Control file installed");

        log.info("BDM AccessControl file imported successfully");
    }

    private void deleteBdmAccessControlIfNeeded() {
        if (TenantResourceState.INSTALLED.equals(getBdmAccessControlStatus().getState())) {
            log.debug("Deleting previous BdmAccessControl ...");
            BdmAccessControlApi accessControlApi = apiLocator.getApi(BdmAccessControlApi.class);
            accessControlApi.deleteBDMAccessControl();
            log.debug("Previous BdmAccessControl deleted");
        }
    }

    @Override
    public Bdm getBdmStatus() {
        log.info("Get BDM status");
        BdmApi bdmApi = apiLocator.getApi(BdmApi.class);
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
        BdmAccessControlApi accessControlApi = apiLocator.getApi(BdmAccessControlApi.class);
        BDMAccessControl bdmAccessControlStatus = accessControlApi.getBDMAccessControlStatus();
        log.debug("BDM status: {}", bdmAccessControlStatus);
        return bdmAccessControlStatus;
    }

    @Override
    public void importOrganization(File organization, OrganizationImportPolicy policy) {
        log.info("Importing organization file: {} with policy: {}", organization.getName(), policy);
        OrganizationApi organizationApi = apiLocator.getApi(OrganizationApi.class);
        String uploadedFileName = organizationApi.uploadOrganization(organization);
        log.debug("Organization file uploaded");
        organizationApi.importOrganization(uploadedFileName, policy.name());
        log.debug("Organization file installed");
        log.info("Organization file imported successfully");
    }

    @Override
    public User getUser(String username) {
        log.info("Get user with username: {}", username);
        UserApi userApi = apiLocator.getApi(UserApi.class);
        String filter = "userName=" + username;
        return userApi.searchUsers(new SearchUsersQueryParams().p(0).c(1).f(filter)).stream().findFirst()
                .orElseThrow(() -> new NotFoundException("No user found for the username: " + username));
    }

    @Override
    public User createUser(UserCreateRequest userCreateRequest) {
        log.info("Create user with params: {}", userCreateRequest);
        UserApi userApi = apiLocator.getApi(UserApi.class);
        return userApi.createUser(userCreateRequest);
    }

    @Override
    public List<User> searchUsers(SearchUsersQueryParams params) {
        log.info("Find users with params: {}", params);
        UserApi userApi = apiLocator.getApi(UserApi.class);
        return userApi.searchUsers(params);
    }

    @Override
    public boolean isTenantPaused() {
        log.info("Check if tenant is paused");
        SystemTenantApi tenantApi = apiLocator.getApi(SystemTenantApi.class);
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
        LicenseApi licenseApi = apiLocator.getApi(LicenseApi.class);
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
        ApplicationApi applicationApi = apiLocator.getApi(ApplicationApi.class);
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
                apiLocator.getApi(ApplicationApi.class).deleteApplicationById(app.getId());
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
        return apiLocator.getApi(ApplicationApi.class)
                .searchApplications(new SearchApplicationsQueryParams().p(0).c(1).f("token=" + applicationToken))
                .stream().findFirst().orElse(null);
    }

    @Override
    public List<Application> searchApplications(int page, int count) {
        return searchApplications(new SearchApplicationsQueryParams().p(page).c(count));
    }

    @Override
    public List<Application> searchApplications(SearchApplicationsQueryParams params) {
        log.debug("Findings applications with request params {}", params);
        return apiLocator.getApi(ApplicationApi.class)
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
        apiLocator.getApi(ApplicationApi.class).deleteApplicationById(application.getId());
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

        // TODO: POST multipart (part configuration) on APIv2/service/install

        log.info("Configuration deployed successfully.");
    }

    @Override
    public String importPage(File content) {
        return null;
    }

    @Override
    public List<Page> searchPages(int page, int count) {
        return null;
    }

    @Override
    public Page getPage(String token) {
        return null;
    }

    @Override
    public boolean deletePage(String token) {
        return false;
    }

    @Override
    public long importProcess(File file, ProcessImportPolicy policy) {
        return 0;
    }

    @Override
    public List<Process> searchProcesses(int page, int count) {
        return null;
    }

    @Override
    public List<ProcessParameter> searchProcessParameters(int page, int count, long processId) {
        return null;
    }

    @Override
    public Process getProcess(String name, String version) {
        return null;
    }

    @Override
    public long startProcess(String name, String version) {
        return 0;
    }

    @Override
    public long startProcess(long id) {
        return 0;
    }

    @Override
    public long startProcess(long id, Map<String, Serializable> params) {
        return 0;
    }

    @Override
    public void importProfiles(File profiles, ProfileImportPolicy policy) {
        if (isCommunity()) {
            log.warn("Profile import is not available in community edition.");
            return;
        }
        log.info("Importing profiles from {} with {}...", profiles.getName(), policy);
        ProfileApi profileApi = apiLocator.getApi(ProfileApi.class);
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
                .f("name=" + name)
        ).stream().findFirst().orElseThrow(() -> new NotFoundException("Role with name '" + name + "' not found"));
    }

    @Override
    public Profile getProfileByName(String name) {
        return searchProfiles(new ProfileApi.SearchProfilesQueryParams()
                .p(0).c(1)
                .f("name=" + name)
        ).stream().findFirst().orElseThrow(() -> new NotFoundException("Profile with name  '" + name + "' not found"));
    }

    @Override
    public List<Role> searchRoles(RoleApi.SearchRolesQueryParams params) {
        log.info("Finding roles with params: {}", params);
        return apiLocator.getApi(RoleApi.class).searchRoles(params);
    }

    public List<Profile> searchProfiles(ProfileApi.SearchProfilesQueryParams params) {
        log.info("Finding profiles with params: {}", params);
        return apiLocator.getApi(ProfileApi.class).searchProfiles(params);
    }

    @Override
    public String addUserToProfile(String userId, String profileId) {
        return "0";
    }

    @Override
    public String addRoleToProfile(String roleId, String profileId) {
        log.info("Add role {} to profile {}...", roleId, profileId);
        ProfileMemberApi profileMemberApi = apiLocator.getApi(ProfileMemberApi.class);
        ProfileMember profileMember = profileMemberApi.createProfileMember(new ProfileMemberCreateRequest()
                .memberType(ProfileMemberCreateRequest.MemberTypeEnum.ROLE)
                .roleId(roleId)
                .profileId(profileId)
        );
        log.info("Role membership add to profile {}. Membership: {}", profileId, profileMember);
        return profileMember.getId();
    }

    @Override
    public String addUserToProfileByNames(String username, String profileName) {
        return "0";
    }

    @Override
    public UserTask getUserTask(long taskId) {
        return null;
    }

    @Override
    public List<UserTask> searchUserTask(long rootContainerId) {
        return null;
    }

    @Override
    public void assignUserTask(long taskId, long assignedUserId) {

    }

    @Override
    public void executeUserTask(long taskId) {

    }

    @Override
    public void executeUserTask(long taskId, Map<String, Serializable> params) {

    }
}
