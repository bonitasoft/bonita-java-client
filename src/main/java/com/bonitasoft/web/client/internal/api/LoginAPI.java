/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @author Baptiste Mesta.
 */
public interface LoginAPI {

    @GET("API/system/session/unusedId")
    Call<ResponseBody> getSession();

    @FormUrlEncoded
    @POST("loginservice")
    Call<ResponseBody> login(@Field("username") String username, @Field("password") String password,
            @Field("redirect") Boolean redirect, @Field("tenantId") String tenantId);

    @FormUrlEncoded
    @POST("logoutservice")
    Call<ResponseBody> logout(@Field("redirect") Boolean redirect);
}
