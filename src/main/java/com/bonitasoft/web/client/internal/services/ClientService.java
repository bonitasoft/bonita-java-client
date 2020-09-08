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
import com.bonitasoft.web.client.internal.security.SecurityContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapLikeType;
import lombok.RequiredArgsConstructor;
import retrofit2.Response;

import java.io.IOException;
import java.util.Map;

/**
 * @author Baptiste Mesta.
 */
@RequiredArgsConstructor
public abstract class ClientService {

    protected final SecurityContext securityContext;

    protected ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    public <T extends ClientService> T setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        return (T) this;
    }

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
            MapLikeType type = objectMapper.getTypeFactory().constructMapLikeType(Map.class, String.class, String.class);
            Map<String, String> map = objectMapper.readValue(errorBody, type);
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
