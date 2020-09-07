/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.api;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * @author Laurent Leseigneur
 */
public interface OrganizationAPI {

    @Multipart
    @POST("portal/organizationUpload")
    Call<ResponseBody> uploadContent(@Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST("services/organization/import")
    Call<ResponseBody> importFromUploadedFile(@Field("organizationDataUpload") String uploadedFile,
            @Field("importPolicy") String importPolicy);
}
