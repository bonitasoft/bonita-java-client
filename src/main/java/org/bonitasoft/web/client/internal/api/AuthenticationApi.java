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

public interface AuthenticationApi {
  /**
   * Login
   * A call to the &#x60;/loginservice&#x60; will generates a set-cookie header in the response.  The &#x60;JSESSIONID&#x60; cookie must be transfered with each subsequent calls. (If the REST API is used in an application running in a web browser, this is handled automatically by the web browser just like any cookies).  Additional protection agains CSRF attacks is enabled by default for all fresh installations This security relies on &#x60;X-Bonita-API-Token&#x60; information. The &#x60;X-Bonita-API-Token&#x60; value can be found in the cookie named: &#x60;X-Bonita-API-Token&#x60;.  All the subsequence REST API calls performing changes in the system using DELETE, POST, or PUT HTTP methods must contain the **HTTP header** below:  &#x60;&#x60;&#x60; X-Bonita-API-Token: example-dummy-not-be-used-value &#x60;&#x60;&#x60; 
   * @param username the username (optional)
   * @param password the password (optional)
   * @param redirect \\\&quot;true\\\&quot; or \\\&quot;false\\\&quot;. \\\&quot;false\\\&quot; indicates that the service should not redirect to Bonita Portal (after a successful login) or to the login page (after a login failure). (optional)
   * @param redirectURL the URL of the page to be displayed after login (optional)
   * @return Call&lt;Void&gt;
   */
  @retrofit2.http.FormUrlEncoded
  @POST("loginservice")
  Call<Void> login(
    @retrofit2.http.Field("username") String username, @retrofit2.http.Field("password") String password, @retrofit2.http.Field("redirect") String redirect, @retrofit2.http.Field("redirectURL") String redirectURL
  );

  /**
   * Logout the current user
   * Logout the current user from the system 
   * @param redirect Setting the redirect parameter to false indicates that the service should not redirect to the login page after logging out. (optional)
   * @return Call&lt;Void&gt;
   */
  @GET("logoutservice")
  Call<Void> logout(
    @retrofit2.http.Query("redirect") String redirect
  );

}
