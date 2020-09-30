package org.bonitasoft.web.client.internal.api;

import retrofit2.Call;
import retrofit2.http.POST;

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
