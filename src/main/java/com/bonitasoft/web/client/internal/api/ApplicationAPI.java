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

import com.bonitasoft.web.client.model.Application;
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
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Baptiste Mesta.
 */
public interface ApplicationAPI {

    @Multipart
    @POST("portal/applicationsUpload")
    Call<String> uploadContent(@Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST("services/application/import")
    Call<ResponseBody> importFromUploadedFile(@Field("applicationsDataUpload") String uploadedFile,
            @Field("importPolicy") String importPolicy);

    @GET("API/living/application")
    Call<List<Application>> search(@Query("p") int page, @Query("c") int count);

    @GET("API/living/application")
    Call<List<Application>> search(@Query("p") int page, @Query("c") int count, @Query("f") String filters);

    @DELETE("API/living/application/{id}")
    Call<ResponseBody> delete(@Path("id") long id);
}
