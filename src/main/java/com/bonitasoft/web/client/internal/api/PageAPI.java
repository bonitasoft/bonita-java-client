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

import  com.bonitasoft.web.client.model.Page;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Laurent Leseigneur
 */
public interface PageAPI {

    @Multipart
    @POST("portal/pageUpload")
    Call<String> uploadContent(@Part MultipartBody.Part file, @Query("action") String action);

    @POST("API/portal/page")
    Call<ResponseBody> add(@Body String params);

    @PUT("API/portal/page/{id}")
    Call<ResponseBody> update(@Path("id") long id, @Body String params);

    @GET("API/portal/page")
    Call<List<Page>> search(@Query("p") int page, @Query("c") int count);

    @GET("API/portal/page")
    Call<List<Page>> search(@Query("p") int page, @Query("c") int count, @Query("f") String filters);

    @DELETE("API/portal/page/{id}")
    Call<ResponseBody> delete(@Path("id") long id);
}
