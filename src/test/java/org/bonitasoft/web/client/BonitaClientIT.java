package com.bonitasoft.web.client;

import com.bonitasoft.web.client.policies.OrganizationImportPolicy;
import org.bonitasoft.web.client.api.OrganizationApi;
import org.bonitasoft.web.client.api.UserApi;
import org.bonitasoft.web.client.model.Session;
import org.bonitasoft.web.client.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BonitaClientIT {

    private GenericContainer bonitaContainer;

    private BonitaClient bonitaClient;

    @BeforeEach
    void setUp() {
        bonitaContainer = new GenericContainer<>("bonita:latest").withExposedPorts(8080).waitingFor(Wait.forHttp("/bonita"));
        bonitaContainer.start();

        String host = bonitaContainer.getHost();
        Integer port = bonitaContainer.getFirstMappedPort();
        String bonitaUrl = String.format("http://%s:%s/bonita", host, port);

        bonitaClient = BonitaClientBuilder.bonitaClient(bonitaUrl).build();
    }

    @AfterEach
    void tearDown() {
        if (bonitaContainer.isRunning()) {
            bonitaContainer.stop();
        }
    }

    @Test
    void organization_should_be_uploaded() throws Exception {
        // Given

        // - Bonita is running
        assertThat(bonitaContainer.isRunning()).isTrue();

        // - Bonita client is logged as technical user
        Session session = bonitaClient.login("install", "install");
        assertThat(session).isNotNull();
        assertThat(session.getUserName()).isEqualTo("install");

        // When

        // - An organization is deployed
        OrganizationApi organizationApi = bonitaClient.service(OrganizationApi.class);
        File orgFile = new File(getClass().getResource("/Organization_Data.xml").toURI());
        String uploadedFileName = organizationApi.uploadOrganization(orgFile);
        assertThat(uploadedFileName).isNotBlank();
        organizationApi.importOrganization(uploadedFileName, OrganizationImportPolicy.IGNORE_DUPLICATES.name());

        // Then

        // Users are declared in the system
        UserApi userApi = bonitaClient.service(UserApi.class);
        List<User> users = userApi.findUsers(new UserApi.FindUsersQueryParams().p(0).c(10));
        assertThat(users).isNotEmpty();

    }

}