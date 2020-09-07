/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.services;

import  com.bonitasoft.web.client.exception.UnauthorizedException;
import  com.bonitasoft.web.client.internal.BonitaCookieInterceptor;
import  com.bonitasoft.web.client.internal.services.model.CreateUser;
import  com.bonitasoft.web.client.internal.api.IdentityAPI;
import  com.bonitasoft.web.client.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class IdentityService extends ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IdentityService.class);
    private final IdentityAPI identityAPI;
    private final BonitaCookieInterceptor bonitaCookieInterceptor;

    public IdentityService(BonitaCookieInterceptor bonitaCookieInterceptor, IdentityAPI identityAPI) {
        this.bonitaCookieInterceptor = bonitaCookieInterceptor;
        this.identityAPI = identityAPI;
    }

    public User getUser(String username) throws UnauthorizedException, IOException {
        LOGGER.debug("Retrieving user '{}'...", username);
        bonitaCookieInterceptor.checkLogged();
        Response<List<User>> response = identityAPI.searchUser(0, 1, "userName=" + username).execute();
        checkResponse(response);
        List<User> body = response.body();
        if (body != null && body.isEmpty()) {
            LOGGER.debug("User '{}' can't be found.", username);
            return null;
        }
        LOGGER.debug("User '{}' retrieved successfully.", username);
        return body.get(0);
    }

    public User createUser(CreateUser user) throws UnauthorizedException, IOException {
        LOGGER.debug("Create user '{}'...", user);
        bonitaCookieInterceptor.checkLogged();
        Response<User> response = identityAPI.createUser(user).execute();
        checkResponse(response);
        User body = response.body();
        LOGGER.debug("User '{}' retrieved successfully.", body);
        return body;
    }

}
