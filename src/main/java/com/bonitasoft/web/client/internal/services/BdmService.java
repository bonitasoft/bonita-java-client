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
import com.bonitasoft.web.client.internal.api.BdmAPI;
import com.bonitasoft.web.client.internal.security.SecurityContext;
import com.bonitasoft.web.client.model.TenantResourceStatus;
import com.bonitasoft.web.client.utils.Json;
import com.github.zafarkhaja.semver.Version;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;

import java.io.File;
import java.io.IOException;

@Slf4j
public class BdmService extends ClientService {

    private final static String FILE_UPLOAD = "fileUpload";

    private final Version version7_7_0 = new Version.Builder("7.7.0").build();

    private final BdmAPI bdmAPI;
    private final SystemService systemService;
    private final BdmAccessControlService bdmAccessControlService;

    public BdmService(SecurityContext securityContext, BdmAPI bdmAPI, SystemService systemService, BdmAccessControlService bdmAccessControlService) {
        super(securityContext);
        this.bdmAPI = bdmAPI;
        this.systemService = systemService;
        this.bdmAccessControlService = bdmAccessControlService;
    }

    public String importBdm(File content) throws IOException, UnauthorizedException {
        log.info("Deploying Business Data Model...");
        securityContext.isAuthenticated();

        if (bdmAccessControlService.getBdmAccessControlStatus().isStateInstalled()) {
            bdmAccessControlService.uninstallBdmAccessControl();
        }

        RequestBody requestFile = RequestBody.create(MultipartBody.FORM, content);
        MultipartBody.Part body = MultipartBody.Part.createFormData("bdm.zip", "bdm.zip",
                requestFile);

        log.debug("Uploading Business Data Model file...");
        Response<ResponseBody> responseUpload = bdmAPI.uploadContent(body).execute();
        checkResponse(responseUpload);
        log.debug("Business Data Model file uploaded successfully.");

        String uploadedFile = responseUpload.body().string();
        Response<ResponseBody> responseImport = bdmAPI.importFromUploadedFile(Json.asMap(FILE_UPLOAD, uploadedFile)).execute();
        checkResponse(responseImport);
        log.info("Business Data Model deployed successfully.");
        return responseImport.body().string();
    }

    /**
     * @return {@link TenantResourceStatus} , containing the BDM state if the Bonita version is at least 7.7.0, or a
     * state UNKNOWN for other versions
     */
    public TenantResourceStatus getBdmStatus() throws IOException, UnauthorizedException {
        securityContext.isAuthenticated();
        if (systemService.getVersion().lessThan(version7_7_0)) {
            return TenantResourceStatus.UNKNOWN;
        }
        log.debug("Retrieving Business Data Model status...");
        Response<TenantResourceStatus> response = bdmAPI.getBdmStatus().execute();
        checkResponse(response);
        log.debug("Business Data Model status retrieved successfully.");
        return response.body();
    }

}
