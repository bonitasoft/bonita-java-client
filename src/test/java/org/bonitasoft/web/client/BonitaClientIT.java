package org.bonitasoft.web.client;

import org.bonitasoft.testcontainers.BonitaContainer;
import org.bonitasoft.web.client.api.BdmApi;
import org.bonitasoft.web.client.api.UserApi;
import org.bonitasoft.web.client.model.Bdm;
import org.bonitasoft.web.client.model.Session;
import org.bonitasoft.web.client.model.User;
import org.bonitasoft.web.client.services.DeploymentService;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
class BonitaClientIT {

    @Container
    private static final BonitaContainer BONITA_CONTAINER = new BonitaContainer();

    private BonitaClient bonitaClient;

    @BeforeEach
    void setUp() {
        String portalUrl = BONITA_CONTAINER.getPortalUrl();
        bonitaClient = BonitaClient.newBuilder(portalUrl).build();
    }

    @Test
    void organization_should_be_uploaded() throws Exception {
        // Given
        bonitaIsRunning();
        loggedInAsTechnicalUser();

        // When
        File organization = getClasspathFile("/Organization_Data.xml");
        DeploymentService deploymentService = bonitaClient.service(DeploymentService.class);
        deploymentService.deployOranization(organization);

        // Then
        List<User> users = bonitaClient.service(UserApi.class)
                .findUsers(new UserApi.FindUsersQueryParams().p(0).c(10));
        assertThat(users).isNotEmpty();
    }

    @Disabled("Failing for now ...")
    @Test
    void bdm_should_be_uploaded() throws Exception {
        // Given
        bonitaIsRunning();
        loggedInAsTechnicalUser();

        // When
        File bdmFile = getClasspathFile("/bdm.zip");
        DeploymentService deploymentService = bonitaClient.service(DeploymentService.class);
        deploymentService.deployBDM(bdmFile);

        // Then
        BdmApi bdmApi = bonitaClient.service(BdmApi.class);
        Bdm bdm = bdmApi.getBdm();
        assertThat(bdm).isNotNull();
    }

    private void loggedInAsTechnicalUser() {
        Session session = bonitaClient.login("install", "install");
        assertThat(session).isNotNull();
        assertThat(session.getUserName()).isEqualTo("install");
    }

    private void bonitaIsRunning() {
        assertThat(BONITA_CONTAINER.isRunning()).isTrue();
    }

    @NotNull
    private File getClasspathFile(String s) throws URISyntaxException {
        return new File(getClass().getResource(s).toURI());
    }

}