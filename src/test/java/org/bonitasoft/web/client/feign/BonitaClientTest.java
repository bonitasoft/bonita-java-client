package org.bonitasoft.web.client.feign;

import org.bonitasoft.web.client.BonitaClient;
import org.bonitasoft.web.client.services.ApplicationService;
import org.bonitasoft.web.client.services.BdmService;
import org.bonitasoft.web.client.services.LoginService;
import org.bonitasoft.web.client.services.ProcessService;
import org.bonitasoft.web.client.services.SystemService;
import org.bonitasoft.web.client.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BonitaClientTest {

    @InjectMocks
    private BonitaFeignClient client;

    @Mock
    private LoginService loginService;
    @Mock
    private ApplicationService applicationService;
    @Mock
    private BdmService bdmService;
    @Mock
    private UserService userService;
    @Mock
    private ProcessService processService;
    @Mock
    private SystemService systemService;

    @Test
    void mocks_are_in_place() {
        assertThat(client.applications()).isNotNull();
        assertThat(client.users()).isNotNull();
        assertThat(client.system()).isNotNull();
        assertThat(client.bdm()).isNotNull();
        assertThat(client.processes()).isNotNull();
    }

    @Test
    void when_no_tenant_provided_should_log_with_default_tenant() {
        // Given
        client = spy(client);
        String username = "test";
        String password = "123";

        // When
        client.login(username, password);

        // Then
        verify(client).login(username, password, BonitaClient.DEFAULT_TENANT_ID);
        verify(loginService).login(username, password, BonitaClient.DEFAULT_TENANT_ID);
    }

    @Test
    void should_delegate_logout() {
        // Given

        // When
        client.logout();

        // Then
        verify(loginService).logout();
    }

    @Test
    void should_logout_with_no_exceptions() {
        // Given
        doThrow(new RuntimeException("Should be ignored exc")).when(loginService).logout();

        // When
        client.logoutSilent();

        // Then
        verify(loginService).logout();
    }
}
