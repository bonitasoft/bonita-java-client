/** 
 * Copyright (C) 2023 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.bonitasoft.web.client.invoker.auth;

import static org.assertj.core.api.Assertions.assertThat;
import static org.bonitasoft.web.client.TestUtils.mockResponseBuilder;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.nio.charset.StandardCharsets;

import org.bonitasoft.web.client.api.AuthenticationApi;
import org.bonitasoft.web.client.api.SessionApi;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;

@ExtendWith(MockitoExtension.class)
class BonitaLoginServiceTest {

    private final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
    private BonitaLoginService loginService;
    @Mock
    private ApiProvider apiProvider;
    @Mock
    private BonitaCookieAuth bonitaCookieAuth;
    @Mock
    private AuthenticationApi authenticationApi;
    @Mock
    private SessionApi sessionApi;

    @BeforeEach
    void setUp() {
        loginService = new BonitaLoginService(apiProvider, objectMapper, bonitaCookieAuth);
        lenient().when(apiProvider.get(AuthenticationApi.class)).thenReturn(authenticationApi);
        lenient().when(apiProvider.get(SessionApi.class)).thenReturn(sessionApi);
    }

    private Response mockResponse(Object body) throws JsonProcessingException {
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
        when(authenticationApi.login(anyString(), anyString(), anyString(), anyString()))
                .thenReturn(loginResponse);

        final Response sessionResponse = mockResponseBuilder()
                .status(200)
                .body(objectMapper.writeValueAsBytes(new Session().userName(username)))
                .build();
        when(sessionApi.getSession()).thenReturn(sessionResponse);

        // When
        final Session session = loginService.login(username, "myPass");

        // Then
        assertThat(session).isNotNull();
        assertThat(session.getUserName()).isEqualTo(username);
    }

    @Test
    void session_should_be_returned() throws Exception {
        // Given
        final String username = "someone";

        final Response sessionResponse = mockResponseBuilder()
                .status(200)
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
