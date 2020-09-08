/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.api;

import com.bonitasoft.web.client.model.Process;
import com.bonitasoft.web.client.model.ProcessParameter;
import com.bonitasoft.web.client.model.ProcessResolutionProblem;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Laurent Leseigneur
 */
public interface ProcessAPI {

    @Multipart
    @POST("portal/processUpload")
    Call<String> uploadContent(@Part MultipartBody.Part file);

    @POST("API/bpm/process")
    Call<Process> add(@Body Map<String, Serializable> params);

    @PUT("API/bpm/process/{id}")
    Call<ResponseBody> update(@Path("id") long id, @Body Map<String, Serializable> params);

    @GET("API/bpm/process")
    Call<List<Process>> search(@Query("p") int page, @Query("c") int count);

    @GET("API/bpm/process")
    Call<List<Process>> search(@Query("p") int page, @Query("c") int count, @Query("f") String... filters);

    @GET("API/bpm/processResolutionProblem")
    Call<List<ProcessResolutionProblem>> processResolutionProblem(@Query("p") int page, @Query("c") int count,
                                                                  @Query("f") String... filters);

    // https://stackoverflow.com/questions/37942474/delete-method-is-not-supportingnon-body-http-method-cannot-contain-body-or-t
    @HTTP(method = "DELETE", path = "API/bpm/process", hasBody = true)
    Call<ResponseBody> delete(@Body List<Long> params);

    @Headers("Content-Type: application/json")
    @POST("API/bpm/process/{id}/instantiation")
    Call<ResponseBody> start(@Path("id") long id, @Body Map<String, Serializable> params);

    @GET("API/bpm/processParameter")
    Call<List<ProcessParameter>> searchParameters(@Query("p") int page, @Query("c") int count,
                                                  @Query("f") String... filters);

}
