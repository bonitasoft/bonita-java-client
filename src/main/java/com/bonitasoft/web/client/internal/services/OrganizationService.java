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
import com.bonitasoft.web.client.internal.api.OrganizationAPI;
import com.bonitasoft.web.client.internal.security.SecurityContext;
import com.bonitasoft.web.client.policies.OrganizationImportPolicy;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;

import java.io.File;
import java.io.IOException;

@Slf4j
public class OrganizationService extends ClientService {

    public final OrganizationAPI organizationAPI;

    public OrganizationService(SecurityContext securityContext, OrganizationAPI organizationAPI) {
        super(securityContext);
        this.organizationAPI = organizationAPI;
    }

    public String importOrganization(File content, OrganizationImportPolicy policy)
            throws IOException, UnauthorizedException {
        log.info("Deploying organization '{}' using policy {}...", content.getName(), policy.name());
        securityContext.isAuthenticated();
        RequestBody requestFile = RequestBody.create(MultipartBody.FORM, content);
        MultipartBody.Part body = MultipartBody.Part.createFormData("Organization_Data.xml", "Organization_Data.xml",
                requestFile);

        log.debug("Uploading organization file...");
        Response<ResponseBody> responseUpload = organizationAPI.uploadContent(body).execute();
        checkResponse(responseUpload);
        log.debug("Organization file uploaded successfully.");

        String uploadedFile = responseUpload.body().string();

        Response<ResponseBody> responseImport = organizationAPI.importFromUploadedFile(uploadedFile, policy.name())
                .execute();

        checkResponse(responseImport);
        log.info("Organization deployed successfully.");
        return responseImport.body().string();
    }
}
