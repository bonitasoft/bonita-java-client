package org.bonitasoft.web.client.feign;

import static org.assertj.core.api.Assertions.assertThat;
import static org.bonitasoft.web.client.TestUtils.mockResponseBuilder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.bonitasoft.web.client.api.HumanTaskApi;
import org.bonitasoft.web.client.api.SessionApi;
import org.bonitasoft.web.client.model.Session;
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

import feign.FeignException;

@ExtendWith(MockitoExtension.class)
class BonitaFeignClientTest {

    @InjectMocks
    private BonitaFeignClient feignClient;

    @Mock
    private ApiProvider apiProvider;
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
    void should_return_up_on_401() {
        // Given
        final SessionApi sessionApi = mock(SessionApi.class);
        when(apiProvider.get(SessionApi.class)).thenReturn(sessionApi);
        when(sessionApi.getSession()).thenReturn(mockResponseBuilder().status(401).build());

        // When
        final boolean running = feignClient.isPlatformUpAndRunning();
        // Then
        assertThat(running).isTrue();
    }

    @Test
    void should_return_up_on_200() {
        // Given
        final SessionApi sessionApi = mock(SessionApi.class);
        when(apiProvider.get(SessionApi.class)).thenReturn(sessionApi);
        when(sessionApi.getSession()).thenReturn(mockResponseBuilder().status(200).build());

        // When
        final boolean running = feignClient.isPlatformUpAndRunning();
        // Then
        assertThat(running).isTrue();
    }

    @Test
    void should_return_down_on_500() {
        // Given
        final SessionApi sessionApi = mock(SessionApi.class);
        when(apiProvider.get(SessionApi.class)).thenReturn(sessionApi);
        when(sessionApi.getSession()).thenReturn(mockResponseBuilder().status(500).build());

        // When
        final boolean running = feignClient.isPlatformUpAndRunning();
        // Then
        assertThat(running).isFalse();
    }

    @Test
    void should_return_down_on_timeout() {
        // Given
        final SessionApi sessionApi = mock(SessionApi.class);
        when(apiProvider.get(SessionApi.class)).thenReturn(sessionApi);
        when(sessionApi.getSession())
                .thenThrow(
                        new FeignException.GatewayTimeout(
                                "Timeout", mockResponseBuilder().build().request(), null));

        // When
        final boolean running = feignClient.isPlatformUpAndRunning();
        // Then
        assertThat(running).isFalse();
    }

    @Test
    void should_return_server_version() {
        // Given
        final String version = "7.12.0";
        when(loginService.getSession()).thenReturn(new Session().version(version));
        // When
        final String serverVersion = feignClient.getVersion();
        // Then
        assertThat(serverVersion).isEqualTo(version);
    }

    @Test
    void should_return_raw_api() {
        // Given
        final Class<HumanTaskApi> apiClass = HumanTaskApi.class;
        when(apiProvider.get(apiClass)).thenReturn(mock(apiClass));

        // When
        final HumanTaskApi humanTaskApi = feignClient.get(apiClass);

        // Then
        assertThat(humanTaskApi).isNotNull();
    }
}
