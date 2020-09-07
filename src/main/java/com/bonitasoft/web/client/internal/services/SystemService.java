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
import java.util.Objects;

import  com.bonitasoft.web.client.exception.UnauthorizedException;
import  com.bonitasoft.web.client.internal.BonitaCookieInterceptor;
import  com.bonitasoft.web.client.internal.api.SystemAPI;
import  com.bonitasoft.web.client.internal.converters.RestApiConverter;
import  com.bonitasoft.web.client.model.License;
import com.github.zafarkhaja.semver.Version;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

public class SystemService extends ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemService.class);
    private final static String PAUSED = "paused";

    private final RestApiConverter restApiConverter;
    private BonitaCookieInterceptor bonitaCookieInterceptor;
    private final SystemAPI systemAPI;

    public SystemService(RestApiConverter restApiConverter, BonitaCookieInterceptor bonitaCookieInterceptor,
            SystemAPI systemAPI) {
        this.restApiConverter = restApiConverter;
        this.bonitaCookieInterceptor = bonitaCookieInterceptor;
        this.systemAPI = systemAPI;
    }

    public boolean isTenantPaused() throws UnauthorizedException, IOException {
        LOGGER.debug("Retrieving tenant status...");
        bonitaCookieInterceptor.checkLogged();
        Response<ResponseBody> response = systemAPI.getCurrentTenant().execute();
        checkResponse(response);
        HashMap<String, String> responseMap = objectMapper.readValue(response.body().string(), HashMap.class);
        boolean tenantIsPaused = Objects.equals(responseMap.get(PAUSED), "true");
        LOGGER.debug("Tenant is {}.", tenantIsPaused ? "paused" : "not paused");
        return tenantIsPaused;
    }

    public String pauseTenant() throws IOException, UnauthorizedException {
        LOGGER.info("Pausing tenant...");
        bonitaCookieInterceptor.checkLogged();
        Response<ResponseBody> response = systemAPI.pauseOrResumeCurrentTenant(generateJson(true)).execute();
        checkResponse(response);
        LOGGER.info("Tenant is paused.");
        return response.body().toString();
    }

    public String resumeTenant() throws IOException, UnauthorizedException {
        LOGGER.info("Resuming tenant...");
        bonitaCookieInterceptor.checkLogged();
        Response<ResponseBody> response = systemAPI.pauseOrResumeCurrentTenant(generateJson(false)).execute();
        checkResponse(response);
        LOGGER.info("Tenant is resumed.");
        return response.body().toString();
    }

    public Version getVersion() throws IOException {
        bonitaCookieInterceptor.checkLogged();
        return systemAPI.getVersion().execute().body();
    }

    public License getLicense() throws IOException {
        bonitaCookieInterceptor.checkLogged();
        return systemAPI.getLicense().execute().body();
    }

    private String generateJson(Boolean pauseTenant) throws IOException {
        return restApiConverter.buildSimpleJson(PAUSED, pauseTenant.toString());
    }

}
