package org.bonitasoft.web.client;

import org.bonitasoft.web.client.api.PortalAuthenticationApi;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.services.DeploymentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class BonitaClientTest {

    @InjectMocks
    private BonitaClient client;
    @Mock
    private ApiClient apiClient;

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