/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.api;

import  com.bonitasoft.web.client.model.TenantResourceStatus;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * The whole API doesn't exist until Bonita 7.7.0. It requires an edition Efficiency or Performance.
 */
public interface BdmAccessControlAPI {

    @Multipart
    @POST("portal/bdmAccessControlUpload")
    Call<String> uploadContent(@Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST("services/bdmAccessControl/install")
    Call<ResponseBody> importBdmAccessControl(@Field("bdmAccessControlUpload") String uploadedFile);

    @DELETE("API/accessControl/bdm")
    Call<ResponseBody> unInstallBdmAccessControl();

    @GET("API/accessControl/bdm")
    Call<TenantResourceStatus> getBdmAccessControlStatus();

}
