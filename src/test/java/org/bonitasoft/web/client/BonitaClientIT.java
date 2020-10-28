package org.bonitasoft.web.client;

import feign.Feign;
import lombok.extern.slf4j.Slf4j;
import org.bonitasoft.testcontainers.BonitaContainer;
import org.bonitasoft.web.client.exception.LicenseException;
import org.bonitasoft.web.client.exception.process.DuplicatedProcessException;
import org.bonitasoft.web.client.exception.process.ProcessActivationException;
import org.bonitasoft.web.client.feign.BonitaFeignClientBuilder;
import org.bonitasoft.web.client.log.LogContentLevel;
import org.bonitasoft.web.client.model.*;
import org.bonitasoft.web.client.services.policies.ApplicationImportPolicy;
import org.bonitasoft.web.client.services.policies.OrganizationImportPolicy;
import org.bonitasoft.web.client.services.policies.ProcessImportPolicy;
import org.bonitasoft.web.client.services.policies.ProfileImportPolicy;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import org.testcontainers.shaded.okhttp3.OkHttpClient;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.bonitasoft.web.client.api.ApplicationApi.SearchApplicationsQueryParams;
import static org.bonitasoft.web.client.api.UserApi.SearchUsersQueryParams;

@Slf4j
@Testcontainers
class BonitaClientIT {


    public static final String ROLE_MEMBER_NAME = "member";

    @Container
    private static final BonitaContainer BONITA_CONTAINER = new BonitaContainer();

    private BonitaClient bonitaClient;

    @BeforeEach
    void setUp() {
//         String portalUrl = "http://localhost:8888/bonita";
        String portalUrl = BONITA_CONTAINER.getPortalUrl();
        bonitaClient = BonitaClient.builder(portalUrl)
                .logContentLevel(LogContentLevel.HEADER)
                .build();
    }

    @Test
    void profiles_should_not_be_uploaded_in_community() throws Exception {
        // Given
        loggedInAsTechnicalUser();

        // When
        File profile = getClasspathFile("/CustomProfile_Data.xml");

        // Then
        assertThatThrownBy(() -> bonitaClient.users().importProfiles(profile, ProfileImportPolicy.REPLACE_DUPLICATES))
                .isInstanceOf(LicenseException.class);

    }

    @Test
    void unresolved_process_should_not_be_activated() throws Exception {
        // Given
        loggedInAsTechnicalUser();

        // When
        File processFile = getClasspathFile("/bconf/Pool-1.0.bar");

        // Then
        assertThatThrownBy(() -> bonitaClient.processes().importProcess(processFile, ProcessImportPolicy.IGNORE_DUPLICATES))
                .isInstanceOf(ProcessActivationException.class);

    } @Test
    void duplicated_process_should_throw_ex() throws Exception {
        // Given
        loggedInAsTechnicalUser();
        importOrganization();
        importBDM();
        File processFile = getClasspathFile("/CreateAndUpdateData--1.0.bar");

        // First import
        bonitaClient.processes().importProcess(processFile, ProcessImportPolicy.REPLACE_DUPLICATES);

        // When
        // Second import should fail because of policy
        assertThatThrownBy(() -> bonitaClient.processes().importProcess(processFile, ProcessImportPolicy.FAIL_ON_DUPLICATES))
                .isInstanceOf(DuplicatedProcessException.class);

        // Then
        Optional<BusinessProcess> maybeProcess = bonitaClient.processes().getProcess("CreateAndUpdateData", "1.0");
        assertThat(maybeProcess).isPresent();
        BusinessProcess process = maybeProcess.get();
        assertThat(process.getConfigurationState()).isEqualTo(ConfigurationState.RESOLVED);
        assertThat(process.getActivationState()).isEqualTo(ActivationState.ENABLED);

    }

    @Test
    void bconf_should_not_be_uploaded_in_community() throws Exception {
        // Given
        loggedInAsTechnicalUser();

        // When
        File bconfFile = getClasspathFile("/bconf/default-Production.bconf");

        // Then
        assertThatThrownBy(() -> bonitaClient.applications().importBonitaConfiguration(bconfFile))
                .isInstanceOf(LicenseException.class);

    }

    @Test
    void organization_should_be_uploaded() throws Exception {
        // Given
        loggedInAsTechnicalUser();

        // When
        importOrganization();

        // add "User" profile to all imported users
        Profile userProfile = bonitaClient.users().getProfileByName(BonitaClient.USER_PROFILE_NAME);
        Role memberRole = bonitaClient.users().getRoleByName(ROLE_MEMBER_NAME);
        bonitaClient.users().addRoleToProfile(memberRole.getId(), userProfile.getId());

        // Then
        List<User> users = bonitaClient.users().searchUsers(new SearchUsersQueryParams().p(0).c(10));
        assertThat(users).isNotEmpty();
    }

    @Test
    void applications_should_be_uploaded() throws Exception {
        // Given
        loggedInAsTechnicalUser();

        // When
        File application = getClasspathFile("/application.xml");
        bonitaClient.applications().importApplications(application, ApplicationImportPolicy.REPLACE_DUPLICATES);

        // Then
        List<Application> applications = bonitaClient.applications().searchApplications(new SearchApplicationsQueryParams().p(0).c(10));
        assertThat(applications).isNotEmpty();
    }

    @Test
    void user_should_be_created() throws Exception {

        // Given
        loggedInAsTechnicalUser();

        String firstname = "Jeremy";
        String lastname = "Lambert";
        String username = firstname + "." + lastname;
        String password = "bpm";

        // When
        User user = bonitaClient.users().createUser(
                new UserCreateRequest().userName(username)
                        .firstname(firstname).lastname(lastname)
                        .password(password).passwordConfirm(password)
                        .enabled("true")
        );

        Profile administratorProfile = bonitaClient.users().getProfileByName(BonitaClient.ADMIN_PROFILE_NAME);
        bonitaClient.users().addUserToProfile(user.getId(), administratorProfile.getId());

        // Then
        User walter = bonitaClient.users().getUser(username);
        assertThat(walter).isEqualTo(user);
    }

    @Test
    void bdm_should_be_uploaded() throws Exception {
        // Given
        loggedInAsTechnicalUser();

        // When
        importBDM();

        // Then
        Bdm bdm = bonitaClient.bdm().getBdmStatus();
        assertThat(bdm.getState()).isEqualTo(TenantResourceState.INSTALLED);
    }

    private void importBDM() throws URISyntaxException {
        File bdmFile = getClasspathFile("/bdm.zip");
        bonitaClient.bdm().importBDM(bdmFile);
    }

    @Test
    void page_should_be_uploaded() throws Exception {
        // Given
        loggedInAsTechnicalUser();

        // When
        File pageFile = getClasspathFile("/page.zip");
        Page page = bonitaClient.applications().importPage(pageFile);

        // Then
        Page pageAgain = bonitaClient.applications().getPage(page.getUrlToken());
        assertThat(pageAgain.getId()).isEqualTo(page.getId());
        assertThat(pageAgain.getUrlToken()).isEqualTo(page.getUrlToken());
        assertThat(pageAgain.getDisplayName()).isEqualTo(page.getDisplayName());
        assertThat(pageAgain.getContentName()).isEqualTo(page.getContentName());
    }

    @Test
    void restapi_should_be_uploaded() throws Exception {
        // Given
        loggedInAsTechnicalUser();

        // When
        File restapiFile = getClasspathFile("/RestAPI-1.0.0.zip");
        Page restapi = bonitaClient.applications().importPage(restapiFile);

        // Then
        Page restapiAgain = bonitaClient.applications().getPage(restapi.getUrlToken());
        assertThat(restapiAgain.getId()).isEqualTo(restapi.getId());
        assertThat(restapiAgain.getUrlToken()).isEqualTo(restapi.getUrlToken());
        assertThat(restapiAgain.getDisplayName()).isEqualTo(restapi.getDisplayName());
        assertThat(restapiAgain.getContentName()).isEqualTo(restapi.getContentName());
    }

    @Test
    void process_should_be_uploaded() throws Exception {
        // Given
        loggedInAsTechnicalUser();
        importOrganization();
        importBDM();

        // When
        File processFile = getClasspathFile("/CreateAndUpdateData--1.0.bar");
        bonitaClient.processes().importProcess(processFile, ProcessImportPolicy.REPLACE_DUPLICATES);

        // Then
        Optional<BusinessProcess> maybeProcess = bonitaClient.processes().getProcess("CreateAndUpdateData", "1.0");
        assertThat(maybeProcess).isPresent();
        BusinessProcess process = maybeProcess.get();
        assertThat(process.getConfigurationState()).isEqualTo(ConfigurationState.RESOLVED);
        assertThat(process.getActivationState()).isEqualTo(ActivationState.ENABLED);
    }

    @Test
    void unresolved_process_problem_should_be_listed() throws Exception {
        // Given
        loggedInAsTechnicalUser();

        File processFile = getClasspathFile("/bconf/Pool-1.0.bar");
        String processName = "Pool";
        String processVersion = "1.0";

        assertThatThrownBy(() -> bonitaClient.processes().importProcess(processFile, ProcessImportPolicy.REPLACE_DUPLICATES))
                .isInstanceOf(ProcessActivationException.class)
                .hasFieldOrPropertyWithValue("processName", processName)
                .hasFieldOrPropertyWithValue("processVersion", processVersion);

        Optional<BusinessProcess> maybeProcess = bonitaClient.processes().getProcess(processName, processVersion);
        assertThat(maybeProcess).isPresent();
        BusinessProcess process = maybeProcess.get();
        assertThat(process.getConfigurationState()).isEqualTo(ConfigurationState.UNRESOLVED);
        assertThat(process.getActivationState()).isEqualTo(ActivationState.DISABLED);

        // When
        List<ProcessResolutionProblem> processProblems = bonitaClient.processes().getProcessProblem(0, 20, process.getId());

        // Then
        assertThat(processProblems).isNotEmpty();
    }


    private void importOrganization() throws URISyntaxException {
        File organization = getClasspathFile("/Organization_Data.xml");
        bonitaClient.users().importOrganization(organization, OrganizationImportPolicy.MERGE_DUPLICATES);
    }

    private void loggedInAsTechnicalUser() {
        Session session = bonitaClient.login("install", "install");
        assertThat(session).isNotNull();
        assertThat(session.getUserName()).isEqualTo("install");
    }

    @NotNull
    private File getClasspathFile(String s) throws URISyntaxException {
        return new File(getClass().getResource(s).toURI());
    }

}