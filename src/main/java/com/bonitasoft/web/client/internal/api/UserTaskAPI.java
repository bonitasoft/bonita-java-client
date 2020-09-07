/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.api;

import java.util.List;

import  com.bonitasoft.web.client.model.UserTask;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserTaskAPI {

    @GET("API/bpm/userTask/{id}")
    Call<UserTask> get(@Path("id") long id);

    // TODO human task api call instead user task api
    @GET("API/bpm/humanTask")
    Call<List<UserTask>> search(@Query("f") String... filters);

    @PUT("API/bpm/userTask/{id}")
    Call<ResponseBody> update(@Path("id") long id, @Body String payload);

    @Headers("Content-Type: application/json")
    @POST("API/bpm/userTask/{id}/execution")
    Call<ResponseBody> execute(@Path("id") long id, @Body String payload);

    @POST("API/bpm/userTask/{id}/execution")
    Call<ResponseBody> execute(@Path("id") long id);

}
