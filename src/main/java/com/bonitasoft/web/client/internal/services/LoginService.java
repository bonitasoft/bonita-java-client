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
import com.bonitasoft.web.client.internal.api.LoginAPI;
import com.bonitasoft.web.client.internal.security.SecurityContext;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import retrofit2.Response;

import java.io.IOException;

@Slf4j
public class LoginService extends ClientService {

    private final LoginAPI loginAPI;

    public LoginService(SecurityContext securityContext, LoginAPI loginAPI) {
        super(securityContext);
        this.loginAPI = loginAPI;
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
        log.debug("Login with user '{}' on tenant '{}'...", username, defaultTenantId);
        Response<ResponseBody> loginResponse = loginAPI.login(username, password, false, defaultTenantId).execute();
        checkResponse(loginResponse);
        securityContext.authenticate(loginResponse);
        //check the session is ok + it will trigger the loading of servlets
        Response<ResponseBody> checkSession = loginAPI.getSession().execute();
        checkResponse(checkSession);
        log.debug("Login completed.");
    }

    public void logout() throws IOException, UnauthorizedException {
        log.debug("Logout...");
        securityContext.isAuthenticated();
        Response<ResponseBody> execute = loginAPI.logout(false).execute();
        checkResponse(execute);
        securityContext.clear();
        log.debug("Logout completed.");
    }
}
