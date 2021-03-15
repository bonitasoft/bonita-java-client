/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package org.bonitasoft.web.client.invoker.auth;

import static java.lang.String.format;

import java.io.IOException;
import java.io.InputStream;

import org.bonitasoft.web.client.api.PortalAuthenticationApi;
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
    public Session login(String username, String password, String tenant) {
        log.debug("Login with user '{}' on tenant '{}'...", username, tenant);

        boolean loginSucceeded;
        int loginStatus;
        String loginReason = "";

        final PortalAuthenticationApi portalAuthenticationApi = apiProvider.get(PortalAuthenticationApi.class);
        try (Response loginResponse = portalAuthenticationApi.login(username, password, tenant, "false", "")) {
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
        apiProvider.get(PortalAuthenticationApi.class).logout("false");
        bonitaCookieAuth.clearSessionCookie();
        log.debug("Logout completed.");
    }
}
