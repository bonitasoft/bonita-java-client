/** 
 * Copyright (C) 2018 BonitaSoft S.A.
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

import static java.lang.String.format;

import java.io.IOException;
import java.io.InputStream;

import org.bonitasoft.web.client.api.AuthenticationApi;
import org.bonitasoft.web.client.api.SessionApi;
import org.bonitasoft.web.client.exception.ClientException;
import org.bonitasoft.web.client.exception.UnauthorizedException;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.Session;
import org.bonitasoft.web.client.services.LoginService;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class BonitaLoginService implements LoginService {

    private final ApiProvider apiProvider;

    private final ObjectMapper objectMapper;

    private final BonitaCookieAuth bonitaCookieAuth;

    @Override
    public Session login(String username, String password) {
        log.debug("Login with user '{}'...", username);

        boolean loginSucceeded;
        int loginStatus;
        String loginReason = "";

        final AuthenticationApi portalAuthenticationApi = apiProvider.get(AuthenticationApi.class);
        try (Response loginResponse = portalAuthenticationApi.login(username, password, "false", "")) {
            loginStatus = loginResponse.status();
            loginSucceeded = (loginStatus == 200 || loginStatus == 204);
            if (loginSucceeded) {
                bonitaCookieAuth.initFrom(loginResponse.headers());
            } else {
                loginReason = loginResponse.reason();
            }
        } catch (Exception e) {
            throw new ClientException("Login failed", e);
        }

        if (!loginSucceeded) {
            throw new UnauthorizedException(
                    format("Login failed, status: %s %s", loginStatus, loginReason));
        }

        // check the session is ok + it will trigger the loading of servlets
        Session session = getSession();
        log.debug("Login completed. Session: {}", session);
        return session;
    }

    @Override
    public Session getSession() {
        Response response = apiProvider.get(SessionApi.class).getSession();
        try (final Response.Body body = response.body()) {
            InputStream inputStream = body.asInputStream();
            return objectMapper.readValue(inputStream, Session.class);
        } catch (IOException e) {
            throw new ClientException("Failed to parse response as a Session:", e);
        }
    }

    @Override
    public void logout() {
        log.debug("Logout...");
        apiProvider.get(AuthenticationApi.class).logout("false");
        bonitaCookieAuth.clearSessionCookie();
        log.debug("Logout completed.");
    }
}
