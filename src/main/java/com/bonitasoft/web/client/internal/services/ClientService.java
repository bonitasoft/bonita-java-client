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
import java.util.HashMap;

import  com.bonitasoft.web.client.exception.UnauthorizedException;
import com.fasterxml.jackson.databind.ObjectMapper;
import retrofit2.Response;

/**
 * @author Baptiste Mesta.
 */
public abstract class ClientService {

    protected final static ObjectMapper objectMapper = new ObjectMapper();

    protected void checkResponse(Response<?> response) throws UnauthorizedException, IOException {
        if (!response.isSuccessful()) {
            throw new IOException(toErrorMessage(response));
        }
    }

    protected String toErrorMessage(Response<?> response) throws UnauthorizedException {
        if (response.code() == 403) {
            throw new UnauthorizedException();
        }
        String message;
        String errorBody = null;
        try {
            errorBody = response.errorBody().string();
            HashMap map = objectMapper.readValue(errorBody, HashMap.class);
            message = String.format(
                    "Error happened server side, error code: %s, message: %s (exception: %s)",
                    response.code(),
                    map.get("message"),
                    map.get("exception"));
        } catch (Exception ignored) {
            message = String.format(
                    "Error happened server side , error code: %s, response body: %s",
                    response.code(),
                    errorBody);
        }
        return message;
    }

}
