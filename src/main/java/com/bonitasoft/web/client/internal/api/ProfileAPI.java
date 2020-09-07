/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.api;

import  com.bonitasoft.web.client.internal.services.model.CreateProfileMembership;
import  com.bonitasoft.web.client.model.Profile;
import  com.bonitasoft.web.client.model.ProfileMembership;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * @author Laurent Leseigneur
 */
public interface ProfileAPI {

    @Multipart
    @POST("portal/profilesUpload")
    Call<String> uploadContent(@Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST("services/profile/import")
    Call<ResponseBody> importFromUploadedFile(@Field("profilesDataUpload") String uploadedFile, @Field("importPolicy") String importPolicy);

    @GET("API/portal/profile")
    Call<List<Profile>> search(@Query("p") int page, @Query("c") int count);

    @GET("API/portal/profile")
    Call<List<Profile>> search(@Query("p") int page, @Query("c") int count, @Query("f") String filters);

    @POST("API/portal/profileMember")
    Call<ProfileMembership> addProfileMember(@Body CreateProfileMembership createProfileMembership);
}
