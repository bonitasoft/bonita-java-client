package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.Platform;
import org.bonitasoft.web.client.internal.model.PlatformUpdateRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PlatformApi {
  /**
   * Finds the Platform by ID
   * Returns the current Platform 
   * @return Call&lt;Platform&gt;
   */
  @GET("API/platform/platform/unusedid")
  Call<Platform> getPlatformById();
    

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
    

  /**
   * Update the Platform by ID
   * Start or stop the current node, that is, start or stop all services of the current JVM. 
   * @param platformUpdateRequest Start or stop all services of the current JVM. (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/platform/platform/unusedid")
  Call<Void> updatePlatformById(
    @retrofit2.http.Body PlatformUpdateRequest platformUpdateRequest
  );

}
