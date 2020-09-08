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
import com.bonitasoft.web.client.internal.api.IdentityAPI;
import com.bonitasoft.web.client.internal.security.SecurityContext;
import com.bonitasoft.web.client.internal.services.model.CreateUser;
import com.bonitasoft.web.client.model.User;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Slf4j
public class IdentityService extends ClientService {

    private final IdentityAPI identityAPI;

    public IdentityService(SecurityContext securityContext, IdentityAPI identityAPI) {
        super(securityContext);
        this.identityAPI = identityAPI;
    }

    public User getUser(String username) throws UnauthorizedException, IOException {
        log.debug("Retrieving user '{}'...", username);
        securityContext.isAuthenticated();
        Response<List<User>> response = identityAPI.searchUser(0, 1, "userName=" + username).execute();
        checkResponse(response);
        List<User> body = response.body();
        if (body != null && body.isEmpty()) {
            log.debug("User '{}' can't be found.", username);
            return null;
        }
        log.debug("User '{}' retrieved successfully.", username);
        return body.get(0);
    }

    public User createUser(CreateUser user) throws UnauthorizedException, IOException {
        log.debug("Create user '{}'...", user);
        securityContext.isAuthenticated();
        Response<User> response = identityAPI.createUser(user).execute();
        checkResponse(response);
        User body = response.body();
        log.debug("User '{}' retrieved successfully.", body);
        return body;
    }

}
