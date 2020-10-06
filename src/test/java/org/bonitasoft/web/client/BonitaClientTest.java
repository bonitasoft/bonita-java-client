package org.bonitasoft.web.client;

import org.bonitasoft.web.client.api.PortalAuthenticationApi;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.services.DeploymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class BonitaClientTest {

    private BonitaClient client;

    @BeforeEach
    void setUp() {
        client = BonitaClient.newBuilder("http://somewhere.org").build();
    }

    @Test
    void should_return_deployment_service() {
        DeploymentService deploymentService = client.service(DeploymentService.class);
        assertThat(deploymentService).isNotNull();
    }

    @Test
    void should_not_return_PortalAuthenticationApi_service() {
        assertThatThrownBy(() -> {
            PortalAuthenticationApi portalAuthenticationApi = client.service(PortalAuthenticationApi.class);
        }).isInstanceOf(RuntimeException.class);
    }
}