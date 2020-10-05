/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package org.bonitasoft.web.client.services;

import org.bonitasoft.web.client.auth.BonitaCookieInterceptor;
import feign.Response;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.api.PortalAuthenticationApi;
import org.bonitasoft.web.client.api.SessionApi;
import org.bonitasoft.web.client.model.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginService {

    public static final String DEFAULT_TENANT = "1";
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

    public Session login(String username, String password, String tenant) {
        log.debug("Login with user '{}' on tenant '{}'...", username, tenant);
        Response loginResponse = loginApi.login(username, password, tenant, "false", "");
        bonitaCookieInterceptor.setSessionCookies(loginResponse.headers());

        //check the session is ok + it will trigger the loading of servlets
        Session session = sessionApi.getSession();
        log.debug("Login completed. Session id: {}", session.getSessionId());

        return session;
    }

    public Session login(String username, String password) {
        return login(username, password, DEFAULT_TENANT);
    }

    public void logout() {
        log.debug("Logout...");
        loginApi.logout("false");
        bonitaCookieInterceptor.clearSessionCookie();
        log.debug("Logout completed.");
    }
}
