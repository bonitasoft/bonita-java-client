/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.api;

import com.bonitasoft.web.client.model.License;
import com.github.zafarkhaja.semver.Version;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;

import java.io.Serializable;
import java.util.Map;

public interface SystemAPI {

    @GET("API/system/tenant/unusedid")
    Call<ResponseBody> getCurrentTenant();

    @PUT("API/system/tenant/unusedid")
    Call<ResponseBody> pauseOrResumeCurrentTenant(@Body Map<String, Serializable> pauseCurrentTenant);

    @GET("API/system/session/unusedid")
    Call<Version> getVersion();

    @GET("API/system/license/unusedid")
    Call<License> getLicense();

}
