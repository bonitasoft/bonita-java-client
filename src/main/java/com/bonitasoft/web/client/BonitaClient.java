/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client;

import com.bonitasoft.web.client.exception.BdmAccessControlException;
import com.bonitasoft.web.client.exception.ClientException;
import com.bonitasoft.web.client.exception.NotFoundException;
import com.bonitasoft.web.client.exception.UnauthorizedException;

import com.bonitasoft.web.client.internal.services.*;
import com.bonitasoft.web.client.internal.services.model.CreateUser;
import com.bonitasoft.web.client.model.*;
import com.bonitasoft.web.client.model.Process;
import com.bonitasoft.web.client.policies.ApplicationImportPolicy;
import com.bonitasoft.web.client.policies.OrganizationImportPolicy;
import com.bonitasoft.web.client.policies.ProcessImportPolicy;
import com.bonitasoft.web.client.policies.ProfileImportPolicy;
import com.github.zafarkhaja.semver.Version;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.lang.String.format;

/**
 * Entry point to interact with the REST API of bonita. <br>
 * Instances of BonitaClient can be created with the {@link BonitaClientBuilder} class.
 *
 * @author Baptiste Mesta.
 */
@Slf4j
public class BonitaClient {

    private final LoginService loginService;
    private final ApplicationService applicationService;
    private final OrganizationService organizationService;
    private final PageService pageService;
    private final ProfileService profileService;
    private final ProcessService processService;
    private final BdmService bdmService;
    private final SystemService systemService;
    private final BdmAccessControlService bdmAccessControlService;
    private final IdentityService identityService;
    private final UserTaskService userTaskService;
    private final ConfigurationService configurationService;

    @Getter
    @Setter
    private String url;

    BonitaClient(LoginService loginService, ApplicationService applicationService,
                 OrganizationService organizationService, PageService pageService, ProfileService profileService,
                 ProcessService processService, BdmService bdmService, SystemService systemService,
                 BdmAccessControlService bdmAccessControlService, IdentityService identityService,
                 UserTaskService userTaskService, ConfigurationService configurationService) {
        this.loginService = loginService;
        this.applicationService = applicationService;
        this.organizationService = organizationService;
        this.pageService = pageService;
        this.profileService = profileService;
        this.processService = processService;
        this.bdmService = bdmService;
        this.systemService = systemService;
        this.bdmAccessControlService = bdmAccessControlService;
        this.identityService = identityService;
        this.userTaskService = userTaskService;
        this.configurationService = configurationService;
    }

    public boolean isPlatformUpAndRunning() {
        return loginService.isPlatformUpAndRunning();
    }

    public void login(String username, String password) throws UnauthorizedException, IOException {
        //check the session is ok + it will trigger the loading of servlets
        loginService.login(username, password);
    }

    public void logout() throws IOException, UnauthorizedException {
        loginService.logout();
    }

    public void logoutSilent() {
        try {
            loginService.logout();
        } catch (IOException | UnauthorizedException e) {
            log.debug("Ignoring error as we are performing a silent logout", e);
        }
    }

    // =================================================================================================================
    // APPLICATION
    // =================================================================================================================

    public String importApplications(File content, ApplicationImportPolicy policy)
            throws IOException, UnauthorizedException {
        return applicationService.importApplications(content, policy);
    }

    public List<Application> searchApplications(int page, int count)
            throws IOException, UnauthorizedException {
        return applicationService.searchApplications(page, count);
    }

    public boolean deleteApplication(String applicationToken) throws UnauthorizedException, IOException {
        return applicationService.deleteApplication(applicationToken);
    }

    // =================================================================================================================
    // PROFILE
    // =================================================================================================================

    public void importProfiles(File content, ProfileImportPolicy policy)
            throws IOException, UnauthorizedException {
        profileService.importProfiles(content, policy);
    }

    public List<Profile> searchProfiles(int page, int count)
            throws IOException, UnauthorizedException {
        return profileService.searchProfiles(page, count);
    }

    public long addUserToProfile(long userId, long profileId) throws IOException, ClientException {
        return profileService.addUserToProfile(userId, profileId);
    }

    public long addUserToProfile(String username, String profileName) throws IOException, ClientException {
        return profileService.addUserToProfile(username, profileName);
    }

    // =================================================================================================================
    // IDENTITY / ORGANIZATION
    // =================================================================================================================

    public String importOrganization(File content, OrganizationImportPolicy policy)
            throws IOException, UnauthorizedException {
        return organizationService.importOrganization(content, policy);
    }

    public User getUser(String username) throws UnauthorizedException, IOException {
        return identityService.getUser(username);
    }

    public User createUser(CreateUser user) throws UnauthorizedException, IOException {
        return identityService.createUser(user);
    }

    // =================================================================================================================
    // PAGE
    // =================================================================================================================

    public String importPage(File content) throws IOException, UnauthorizedException {
        return pageService.importPage(content);
    }

    public List<Page> searchPages(int page, int count) throws IOException, UnauthorizedException {
        return pageService.searchPages(page, count);
    }

    public Page getPage(String token) throws IOException, UnauthorizedException {
        return pageService.getPage(token);
    }

    public boolean deletePage(String token) throws IOException, UnauthorizedException {
        return pageService.deletePage(token);
    }

    // =================================================================================================================
    // PROCESS
    // =================================================================================================================

    public long importProcess(File file, ProcessImportPolicy policy) throws IOException, ClientException {
        return processService.importProcess(file, policy);
    }

    public List<Process> searchProcesses(int page, int count) throws IOException {
        return processService.searchProcesses(page, count);
    }

    public List<ProcessParameter> searchProcessParameters(int page, int count, long processId) throws IOException {
        return processService.searchProcessParameters(page, count, processId);
    }

    public Process getProcess(String name, String version) throws IOException, NotFoundException {
        Optional<Process> process = processService.getProcess(name, version);
        if (!process.isPresent()) {
            throw new NotFoundException(format("Process '%s' in version '%s' does not exist", name, version));
        }
        return process.get();
    }

    public long startProcess(String name, String version) throws IOException, ClientException {
        Process process = getProcess(name, version);
        return startProcess(process.getId());
    }

    public long startProcess(long id) throws IOException, ClientException {
        return processService.startProcess(id);
    }

    public long startProcess(long id, Map<String, Serializable> params) throws IOException, ClientException {
        return processService.startProcess(id, params);
    }

    // =================================================================================================================
    // BDM
    // =================================================================================================================

    public String importBDM(File content) throws IOException, UnauthorizedException {
        try {
            if (!systemService.isTenantPaused()) {
                systemService.pauseTenant();
            }
            return bdmService.importBdm(content);
        } finally {
            if (systemService.isTenantPaused()) {
                systemService.resumeTenant();
            }
        }
    }

    public void importBdmAccessControl(File content)
            throws IOException, BdmAccessControlException {
        bdmAccessControlService.importBdmAccessControl(content);
    }

    public TenantResourceStatus getBdmStatus() throws IOException, UnauthorizedException {
        return bdmService.getBdmStatus();
    }

    public TenantResourceStatus getBdmAccessControlStatus() {
        return bdmAccessControlService.getBdmAccessControlStatus();
    }

    // =================================================================================================================
    // SYSTEM
    // =================================================================================================================

    public boolean isTenantPaused() throws UnauthorizedException, IOException {
        return systemService.isTenantPaused();
    }

    public Version getVersion() throws IOException {
        return systemService.getVersion();
    }

    public License getLicense() throws IOException {
        return systemService.getLicense();
    }

    // =================================================================================================================
    // USER TASK
    // =================================================================================================================

    public UserTask getUserTask(long taskId) throws IOException, UnauthorizedException {
        return userTaskService.get(taskId);
    }

    public List<UserTask> searchUserTask(long rootContainerId) throws IOException, UnauthorizedException {
        return userTaskService.search(rootContainerId);
    }

    public void assignUserTask(long taskId, long assignedUserId) throws IOException, UnauthorizedException {
        userTaskService.update(taskId, assignedUserId, null);
    }

    public void executeUserTask(long taskId) throws IOException, UnauthorizedException {
        userTaskService.execute(taskId);
    }

    public void executeUserTask(long taskId, Map<String, Serializable> params)
            throws IOException, UnauthorizedException {
        userTaskService.execute(taskId, params);
    }

    // =================================================================================================================
    // CONFIGURATION
    // =================================================================================================================

    public void importBonitaConfiguration(File configurationFile) throws IOException, UnauthorizedException {
        configurationService.importBonitaConfiguration(configurationFile);
    }

}
