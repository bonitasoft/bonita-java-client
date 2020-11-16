package org.bonitasoft.web.client.invoker.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import org.bonitasoft.web.client.api.PortalAuthenticationApi;
import org.bonitasoft.web.client.api.SessionApi;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.bonitasoft.web.client.TestUtils.mockResponseBuilder;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BonitaLoginServiceTest {

    private final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
    private BonitaLoginService loginService;
    @Mock
    private ApiProvider apiProvider;
    @Mock
    private BonitaCookieAuth bonitaCookieAuth;
    @Mock
    private PortalAuthenticationApi authenticationApi;
    @Mock
    private SessionApi sessionApi;

    @BeforeEach
    void setUp() {
        loginService = new BonitaLoginService(apiProvider, objectMapper, bonitaCookieAuth);
        lenient().when(apiProvider.get(PortalAuthenticationApi.class)).thenReturn(authenticationApi);
        lenient().when(apiProvider.get(SessionApi.class)).thenReturn(sessionApi);
    }

    private Response mockResponse(Object body)
            throws JsonProcessingException {
        final Response.Builder builder = mockResponseBuilder();
        if (body != null) {
            final String json = objectMapper.writeValueAsString(body);
            builder.body(json, StandardCharsets.UTF_8);
        }
        return builder.build();
    }

    @Test
    void login_should_work_with_204_response() throws Exception {
        // Given
        final String username = "someone";

        final Response loginResponse = mockResponseBuilder().status(204).build();
        when(authenticationApi.login(anyString(), anyString(), anyString(), anyString(), anyString()))
                .thenReturn(loginResponse);

        final Response sessionResponse =
                mockResponseBuilder().status(200)
                        .body(objectMapper.writeValueAsBytes(new Session().userName(username)))
                        .build();
        when(sessionApi.getSession()).thenReturn(sessionResponse);

        // When
        final Session session = loginService.login(username, "myPass", "1");

        // Then
        assertThat(session).isNotNull();
        assertThat(session.getUserName()).isEqualTo(username);
    }

    @Test
    void login_should_work_with_200_response() throws Exception {
        // Given
        final String username = "someone";

        final Response loginResponse = mockResponseBuilder().status(200).build();
        when(authenticationApi.login(anyString(), anyString(), anyString(), anyString(), anyString()))
                .thenReturn(loginResponse);

        final Response sessionResponse =
                mockResponseBuilder().status(200)
                        .body(objectMapper.writeValueAsBytes(new Session().userName(username)))
                        .build();
        when(sessionApi.getSession()).thenReturn(sessionResponse);

        // When
        final Session session = loginService.login(username, "myPass", "1");

        // Then
        assertThat(session).isNotNull();
        assertThat(session.getUserName()).isEqualTo(username);
    }

    @Test
    void session_should_be_returned() throws Exception {
        // Given
        final String username = "someone";

        final Response sessionResponse =
                mockResponseBuilder().status(200)
                        .body(objectMapper.writeValueAsBytes(new Session().userName(username)))
                        .build();
        when(sessionApi.getSession()).thenReturn(sessionResponse);

        // When
        final Session session = loginService.getSession();

        // Then
        assertThat(session).isNotNull();
        assertThat(session.getUserName()).isEqualTo(username);
    }

    @Test
    void logout() throws Exception {
        // Given

        // When
        loginService.logout();

        // Then
        verify(authenticationApi).logout(anyString());
        verify(bonitaCookieAuth).clearSessionCookie();
    }
}
