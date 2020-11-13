package org.bonitasoft.web.client.invoker.auth;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Request;
import feign.RequestTemplate;
import feign.Response;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.bonitasoft.web.client.api.PortalAuthenticationApi;
import org.bonitasoft.web.client.api.SessionApi;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BonitaLoginServiceTest {

  private final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
  private BonitaLoginService loginService;
  @Mock private ApiProvider apiProvider;
  @Mock private BonitaCookieAuth bonitaCookieAuth;
  @Mock private PortalAuthenticationApi authenticationApi;
  @Mock private SessionApi sessionApi;

  @BeforeEach
  void setUp() {
    loginService = new BonitaLoginService(apiProvider, objectMapper, bonitaCookieAuth);
    lenient().when(apiProvider.get(PortalAuthenticationApi.class)).thenReturn(authenticationApi);
    lenient().when(apiProvider.get(SessionApi.class)).thenReturn(sessionApi);
  }

  private Response mockResponse(int status, Map<String, Collection<String>> headers, Object body)
      throws JsonProcessingException {
    final Response.Builder builder =
        Response.builder()
            .status(status)
            .headers(headers)
            .request(
                Request.create(
                    Request.HttpMethod.POST,
                    "http://dummy.com/login",
                    new HashMap<>(),
                    null,
                    new RequestTemplate()));
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

    final Response loginResponse = mockResponse(204, new HashMap<>(), null);
    when(authenticationApi.login(anyString(), anyString(), anyString(), anyString(), anyString()))
        .thenReturn(loginResponse);

    final Response sessionResponse =
        mockResponse(200, new HashMap<>(), new Session().userName(username));
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

    final Response loginResponse = mockResponse(200, new HashMap<>(), null);
    when(authenticationApi.login(anyString(), anyString(), anyString(), anyString(), anyString()))
        .thenReturn(loginResponse);

    final Response sessionResponse =
        mockResponse(200, new HashMap<>(), new Session().userName(username));
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
        mockResponse(200, new HashMap<>(), new Session().userName(username));
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
