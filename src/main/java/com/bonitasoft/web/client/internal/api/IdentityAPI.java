/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.api;

import com.bonitasoft.web.client.internal.services.model.CreateUser;
import com.bonitasoft.web.client.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

public interface IdentityAPI {

    @GET("API/identity/user")
    Call<List<User>> searchUser(@Query("p") int page, @Query("c") int count, @Query("f") String filters);

    @POST("API/identity/user")
    Call<User> createUser(@Body CreateUser createUser);

}
