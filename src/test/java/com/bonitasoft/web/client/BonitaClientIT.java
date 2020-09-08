package com.bonitasoft.web.client;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import static com.bonitasoft.web.client.BonitaClientBuilder.bonitaClient;
import static org.assertj.core.api.Assertions.assertThat;

class BonitaClientIT {

    private GenericContainer bonitaContainer;

    private BonitaClient bonitaClient;

    @BeforeEach
    void setUp() {
        bonitaContainer = new GenericContainer<>("bonita:latest").withExposedPorts(8080).waitingFor(Wait.forHttp("/bonita"));
        bonitaContainer.start();

        String bonitaUrl = String.format("http://%s:%s/bonita", bonitaContainer.getHost(), bonitaContainer.getFirstMappedPort());
        bonitaClient = bonitaClient(bonitaUrl).build();
    }

    @AfterEach
    void tearDown() {
        if (bonitaContainer.isRunning()) {
            bonitaContainer.stop();
        }
    }

    @Test
    void should_be_running() {
        assertThat(bonitaContainer.isRunning()).isTrue();
        assertThat(bonitaClient.isPlatformUpAndRunning()).isTrue();
    }
}
