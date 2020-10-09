package org.bonitasoft.web.client;

import lombok.extern.slf4j.Slf4j;
import okhttp3.logging.HttpLoggingInterceptor;
import org.bonitasoft.web.client.api.UserApi;
import org.bonitasoft.web.client.model.*;
import org.bonitasoft.web.client.services.policies.ApplicationImportPolicy;
import org.bonitasoft.web.client.services.policies.OrganizationImportPolicy;
import org.bonitasoft.web.client.services.policies.ProfileImportPolicy;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.bonitasoft.web.client.api.ApplicationApi.FindApplicationsQueryParams;

@Slf4j
@Testcontainers
class BonitaClientIT {

//    @Container
//    private static final BonitaContainer BONITA_CONTAINER = new BonitaContainer();

    private BonitaClient bonitaClient;

    @BeforeEach
    void setUp() {
//        String portalUrl = BONITA_CONTAINER.getPortalUrl();
        String portalUrl = "http://localhost:8888/bonita";
        bonitaClient = BonitaClient.newFeignBuilder(portalUrl)
                .logInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    @Test
    void profiles_should_not_be_uploaded_in_community() throws Exception {
        // When
        File profile = getClasspathFile("/Profile_Data.xml");
        bonitaClient.importProfiles(profile, ProfileImportPolicy.REPLACE_DUPLICATES);

        // Then
        List<Profile> profiles = bonitaClient.searchProfiles(0, 10);
        assertThat(profiles).isEmpty();
    }

    @Test
    void organization_should_be_uploaded() throws Exception {
        // Given
        bonitaIsRunning();
        loggedInAsTechnicalUser();

        // When
        File organization = getClasspathFile("/Organization_Data.xml");
        bonitaClient.importOrganization(organization, OrganizationImportPolicy.MERGE_DUPLICATES);

        // Then
        List<User> users = bonitaClient.findUsers(new UserApi.FindUsersQueryParams().p(0).c(10));
        assertThat(users).isNotEmpty();
    }

    @Test
    void applications_should_be_uploaded() throws Exception {
        // Given
        bonitaIsRunning();
        loggedInAsTechnicalUser();

        // When
        File application = getClasspathFile("/application.xml");
        bonitaClient.importApplications(application, ApplicationImportPolicy.REPLACE_DUPLICATES);

        // Then
        List<Application> applications = bonitaClient.findApplications(new FindApplicationsQueryParams().p(0).c(10));
        assertThat(applications).isNotEmpty();
    }

    @Test
    void user_should_be_created() throws Exception {

        // Given
        bonitaIsRunning();
        loggedInAsTechnicalUser();

        String firstname = "walter";
        String lastname = "bates";
        String username = firstname + "." + lastname;
        String password = "bpm";

        // When
        User user = bonitaClient.createUser(
                new UserCreateRequest().userName(username)
                        .firstname(firstname).lastname(lastname)
                        .password(password).passwordConfirm(password)
                        .enabled("true")
        );

        // Then
        User walter = bonitaClient.getUser(username);
        assertThat(walter).isEqualTo(user);
    }

    @Test
    void bdm_should_be_uploaded() throws Exception {
        // Given
        bonitaIsRunning();
        loggedInAsTechnicalUser();

        // When
        File bdmFile = getClasspathFile("/bdm.zip");
        bonitaClient.importBDM(bdmFile);

        // Then
        Bdm bdm = bonitaClient.getBdmStatus();
        assertThat(bdm.getState()).isEqualTo(TenantResourceState.INSTALLED);
    }

    private void loggedInAsTechnicalUser() {
        Session session = bonitaClient.login("install", "install");
        assertThat(session).isNotNull();
        assertThat(session.getUserName()).isEqualTo("install");
    }

    private void bonitaIsRunning() {
//        assertThat(BONITA_CONTAINER.isRunning()).isTrue();
    }

    @NotNull
    private File getClasspathFile(String s) throws URISyntaxException {
        return new File(getClass().getResource(s).toURI());
    }

}