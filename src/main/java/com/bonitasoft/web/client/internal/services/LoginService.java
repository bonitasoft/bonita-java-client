/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.services;

import com.bonitasoft.web.client.exception.UnauthorizedException;
import com.bonitasoft.web.client.internal.BonitaCookieInterceptor;
import feign.Response;
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.api.PortalAuthenticationApi;
import org.bonitasoft.web.client.internal.api.SessionApi;
import org.bonitasoft.web.client.internal.model.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LoginService {

    private static final Logger log = LoggerFactory.getLogger(LoginService.class);

    private PortalAuthenticationApi loginApi;
    private SessionApi sessionApi;

    private BonitaCookieInterceptor bonitaCookieInterceptor;

    public LoginService(ApiClient apiClient, BonitaCookieInterceptor bonitaCookieInterceptor) {
        this.loginApi = apiClient.buildClient(PortalAuthenticationApi.class);
        this.sessionApi = apiClient.buildClient(SessionApi.class);
        this.bonitaCookieInterceptor = bonitaCookieInterceptor;
    }

    public boolean isPlatformUpAndRunning() {
        try {
            Session session = sessionApi.getSession();
            return session != null;
        } catch (Exception e) {
            return false;
        }
    }

    public void login(String username, String password) {
        final String defaultTenantId = "1";
        log.debug("Login with user '{}' on tenant '{}'...", username, defaultTenantId);
        Response loginResponse = loginApi.login(username, password, "false", "", defaultTenantId);
        bonitaCookieInterceptor.setSessionCookies(loginResponse.headers());

        //check the session is ok + it will trigger the loading of servlets
        Session session = sessionApi.getSession();
        log.debug("Login completed. Session id: {}", session.getSessionId());
    }

    public void logout() throws IOException, UnauthorizedException {
        log.debug("Logout...");
        loginApi.logout("false");
        bonitaCookieInterceptor.clearSessionCookie();
        log.debug("Logout completed.");
    }
}
