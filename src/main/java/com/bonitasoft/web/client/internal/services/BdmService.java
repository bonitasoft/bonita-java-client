/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.services;

import java.io.File;
import java.io.IOException;

import  com.bonitasoft.web.client.exception.UnauthorizedException;
import  com.bonitasoft.web.client.internal.BonitaCookieInterceptor;
import  com.bonitasoft.web.client.internal.api.BdmAPI;
import  com.bonitasoft.web.client.internal.converters.RestApiConverter;
import  com.bonitasoft.web.client.model.TenantResourceStatus;
import com.github.zafarkhaja.semver.Version;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

public class BdmService extends ClientService {

    private final static Logger LOGGER = LoggerFactory.getLogger(BdmService.class);
    private final static String FILE_UPLOAD = "fileUpload";
    private final Version version7_7_0; // some API are only available since bonita 7.7.0

    private BonitaCookieInterceptor bonitaCookieInterceptor;
    private final BdmAPI bdmAPI;
    private final SystemService systemService;
    private final BdmAccessControlService bdmAccessControlService;
    private final RestApiConverter restApiConverter;

    public BdmService(BonitaCookieInterceptor bonitaCookieInterceptor, SystemService systemService,
            BdmAccessControlService bdmAccessControlService, BdmAPI bdmAPI, RestApiConverter restApiConverter) {
        this.bonitaCookieInterceptor = bonitaCookieInterceptor;
        this.systemService = systemService;
        this.bdmAccessControlService = bdmAccessControlService;
        this.bdmAPI = bdmAPI;
        this.restApiConverter = restApiConverter;
        this.version7_7_0 = new Version.Builder("7.7.0").build();
    }

    public String importBdm(File content) throws IOException, UnauthorizedException {
        LOGGER.info("Deploying Business Data Model...");
        bonitaCookieInterceptor.checkLogged();

        if (bdmAccessControlService.getBdmAccessControlStatus().isStateInstalled()) {
            bdmAccessControlService.uninstallBdmAccessControl();
        }

        RequestBody requestFile = RequestBody.create(MultipartBody.FORM, content);
        MultipartBody.Part body = MultipartBody.Part.createFormData("bdm.zip", "bdm.zip",
                requestFile);

        LOGGER.debug("Uploading Business Data Model file...");
        Response<ResponseBody> responseUpload = bdmAPI.uploadContent(body).execute();
        checkResponse(responseUpload);
        LOGGER.debug("Business Data Model file uploaded successfully.");

        String uploadedFile = responseUpload.body().string();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),
                restApiConverter.buildSimpleJson(FILE_UPLOAD, uploadedFile));
        Response<ResponseBody> responseImport = bdmAPI.importFromUploadedFile(requestBody).execute();
        checkResponse(responseImport);
        LOGGER.info("Business Data Model deployed successfully.");
        return responseImport.body().string();
    }

    /**
     * @return {@link TenantResourceStatus} , containing the BDM state if the Bonita version is at least 7.7.0, or a
     *         state UNKNOWN for other versions
     */
    public TenantResourceStatus getBdmStatus() throws IOException, UnauthorizedException {
        bonitaCookieInterceptor.checkLogged();
        if (systemService.getVersion().lessThan(version7_7_0)) {
            return TenantResourceStatus.UNKNOWN;
        }
        LOGGER.debug("Retrieving Business Data Model status...");
        Response<TenantResourceStatus> response = bdmAPI.getBdmStatus().execute();
        checkResponse(response);
        LOGGER.debug("Business Data Model status retrieved successfully.");
        return response.body();
    }

}
