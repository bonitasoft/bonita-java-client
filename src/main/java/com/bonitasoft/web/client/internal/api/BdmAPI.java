/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.api;

import com.bonitasoft.web.client.model.TenantResourceStatus;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.io.Serializable;
import java.util.Map;

public interface BdmAPI {

    @Multipart
    @POST("portal/fileUpload")
    Call<ResponseBody> uploadContent(@Part MultipartBody.Part file);

    //JSON
    @POST("API/tenant/bdm")
    Call<ResponseBody> importFromUploadedFile(@Body Map<String, Serializable> body);

    /**
     * @return the tenant resource status if the Bonita version is at least 7.7.0, or error if the Bonita version is
     * less than 7.7.0
     */
    @GET("API/tenant/bdm")
    Call<TenantResourceStatus> getBdmStatus();

}
