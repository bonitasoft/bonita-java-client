package com.bonitasoft.web.client;

import com.bonitasoft.web.client.policies.OrganizationImportPolicy;
import org.bonitasoft.web.client.internal.api.OrganizationApi;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import java.io.File;

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
    void should_be_running() throws Exception {
        assertThat(bonitaContainer.isRunning()).isTrue();

        bonitaClient.login("install", "install");
        assertThat(bonitaClient.isPlatformUpAndRunning()).isTrue();

        OrganizationApi organizationApi = bonitaClient.service(OrganizationApi.class);

        File orgFile = new File(getClass().getResource("/Organization_Data.xml").toURI());
        String uploadedFileName = organizationApi.uploadOrganization(orgFile);

        assertThat(uploadedFileName).isNotBlank();

        organizationApi.importOrganization(uploadedFileName, OrganizationImportPolicy.IGNORE_DUPLICATES.name());

    }

}