/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.services;

import java.io.IOException;

import com.bonitasoft.web.client.exception.UnauthorizedException;
import com.bonitasoft.web.client.internal.BonitaCookieInterceptor;
import com.bonitasoft.web.client.internal.api.LoginAPI;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

public class LoginService extends ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);
    private LoginAPI loginAPI;
    private BonitaCookieInterceptor bonitaCookieInterceptor;

    public LoginService(LoginAPI loginAPI, BonitaCookieInterceptor bonitaCookieInterceptor) {
        this.loginAPI = loginAPI;
        this.bonitaCookieInterceptor = bonitaCookieInterceptor;
    }

    public boolean isPlatformUpAndRunning() {
        try {
            Response<ResponseBody> execute = loginAPI.getSession().execute();
            return execute.code() == 401 || execute.code() == 200;
        } catch (IOException ignored) {
            return false;
        }
    }

    public void login(String username, String password) throws UnauthorizedException, IOException {
        final String defaultTenantId = "1";
        LOGGER.debug("Login with user '{}' on tenant '{}'...", username, defaultTenantId);
        Response<ResponseBody> loginResponse = loginAPI.login(username, password, false, defaultTenantId).execute();
        checkResponse(loginResponse);
        bonitaCookieInterceptor.setSessionCookies(loginResponse.headers());
        //check the session is ok + it will trigger the loading of servlets
        Response<ResponseBody> checkSession = loginAPI.getSession().execute();
        checkResponse(checkSession);
        LOGGER.debug("Login completed.");
    }

    public void logout() throws IOException, UnauthorizedException {
        LOGGER.debug("Logout...");
        bonitaCookieInterceptor.checkLogged();
        Response<ResponseBody> execute = loginAPI.logout(false).execute();
        checkResponse(execute);
        bonitaCookieInterceptor.clearSessionCookie();
        LOGGER.debug("Logout completed.");
    }
}
