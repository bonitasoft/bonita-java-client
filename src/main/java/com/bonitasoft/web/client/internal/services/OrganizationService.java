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

import com.bonitasoft.web.client.exception.UnauthorizedException;
import com.bonitasoft.web.client.internal.BonitaCookieInterceptor;
import com.bonitasoft.web.client.internal.api.OrganizationAPI;
import com.bonitasoft.web.client.policies.OrganizationImportPolicy;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

public class OrganizationService extends ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationService.class);
    private BonitaCookieInterceptor bonitaCookieInterceptor;
    public final OrganizationAPI organizationAPI;

    public OrganizationService(BonitaCookieInterceptor bonitaCookieInterceptor, OrganizationAPI organizationAPI) {
        this.bonitaCookieInterceptor = bonitaCookieInterceptor;
        this.organizationAPI = organizationAPI;
    }

    public String importOrganization(File content, OrganizationImportPolicy policy)
            throws IOException, UnauthorizedException {
        LOGGER.info("Deploying organization '{}' using policy {}...", content.getName(), policy.name());
        bonitaCookieInterceptor.checkLogged();
        RequestBody requestFile = RequestBody.create(MultipartBody.FORM, content);
        MultipartBody.Part body = MultipartBody.Part.createFormData("Organization_Data.xml", "Organization_Data.xml",
                requestFile);

        LOGGER.debug("Uploading organization file...");
        Response<ResponseBody> responseUpload = organizationAPI.uploadContent(body).execute();
        checkResponse(responseUpload);
        LOGGER.debug("Organization file uploaded successfully.");

        String uploadedFile = responseUpload.body().string();

        Response<ResponseBody> responseImport = organizationAPI.importFromUploadedFile(uploadedFile, policy.name())
                .execute();

        checkResponse(responseImport);
        LOGGER.info("Organization deployed successfully.");
        return responseImport.body().string();
    }
}
