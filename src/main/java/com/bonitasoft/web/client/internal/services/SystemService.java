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
import com.bonitasoft.web.client.internal.api.SystemAPI;
import com.bonitasoft.web.client.internal.security.SecurityContext;
import com.bonitasoft.web.client.model.License;
import com.bonitasoft.web.client.utils.Json;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.github.zafarkhaja.semver.Version;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import retrofit2.Response;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class SystemService extends ClientService {

    private final static String PAUSED = "paused";

    private final SystemAPI systemAPI;

    public SystemService(SecurityContext securityContext, SystemAPI systemAPI) {
        super(securityContext);
        this.systemAPI = systemAPI;
    }

    public boolean isTenantPaused() throws UnauthorizedException, IOException {
        log.debug("Retrieving tenant status...");
        securityContext.isAuthenticated();
        Response<ResponseBody> response = systemAPI.getCurrentTenant().execute();
        checkResponse(response);
        MapLikeType type = objectMapper.getTypeFactory().constructMapLikeType(Map.class, String.class, String.class);
        Map<String, String> responseMap = objectMapper.readValue(response.body().string(), type);
        boolean tenantIsPaused = Objects.equals(responseMap.get(PAUSED), "true");
        log.debug("Tenant is {}.", tenantIsPaused ? "paused" : "not paused");
        return tenantIsPaused;
    }

    public String pauseTenant() throws IOException, UnauthorizedException {
        log.info("Pausing tenant...");
        securityContext.isAuthenticated();
        Response<ResponseBody> response = systemAPI.pauseOrResumeCurrentTenant(generateJson(true)).execute();
        checkResponse(response);
        log.info("Tenant is paused.");
        return response.body().toString();
    }

    public String resumeTenant() throws IOException, UnauthorizedException {
        log.info("Resuming tenant...");
        securityContext.isAuthenticated();
        Response<ResponseBody> response = systemAPI.pauseOrResumeCurrentTenant(generateJson(false)).execute();
        checkResponse(response);
        log.info("Tenant is resumed.");
        return response.body().toString();
    }

    public Version getVersion() throws IOException {
        securityContext.isAuthenticated();
        return systemAPI.getVersion().execute().body();
    }

    public License getLicense() throws IOException {
        securityContext.isAuthenticated();
        return systemAPI.getLicense().execute().body();
    }

    private Map<String, Serializable> generateJson(Boolean pauseTenant) throws IOException {
        return Json.asMap(PAUSED, pauseTenant.toString());
    }

}
