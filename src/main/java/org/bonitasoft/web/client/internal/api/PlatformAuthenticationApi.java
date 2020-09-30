package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PlatformAuthenticationApi {
  /**
   * Platform Login
   * The username and password are in &#x60;bonita-platform-community-custom.properties&#x60; file. 
   * @param username the username (optional)
   * @param password the password (optional)
   * @param redirect \\\&quot;true\\\&quot; or \\\&quot;false\\\&quot;. \\\&quot;false\\\&quot; indicates that the service should not redirect to Bonita Portal (after a successful login) or to the login page (after a login failure). (optional)
   * @return Call&lt;Void&gt;
   */
  @retrofit2.http.FormUrlEncoded
  @POST("platformloginservice")
  Call<Void> platformLogin(
    @retrofit2.http.Field("username") String username, @retrofit2.http.Field("password") String password, @retrofit2.http.Field("redirect") String redirect
  );

  /**
   * Platform Logout
   * 
   * @return Call&lt;Void&gt;
   */
  @POST("platformlogoutservice")
  Call<Void> platformLogout();
    

}
