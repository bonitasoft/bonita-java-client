package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.ApiResponse;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface PlatformAuthenticationApi extends ApiClient.Api {


  /**
   * Platform Login
   * The username and password are in &#x60;bonita-platform-community-custom.properties&#x60; file. 
   * @param username the username (optional)
   * @param password the password (optional)
   * @param redirect \\\&quot;true\\\&quot; or \\\&quot;false\\\&quot;. \\\&quot;false\\\&quot; indicates that the service should not redirect to Bonita Portal (after a successful login) or to the login page (after a login failure). (optional)
   */
  @RequestLine("POST /platformloginservice")
  @Headers({
    "Content-Type: application/x-www-form-urlencoded",
    "Accept: application/json",
  })
  void platformLogin(@Param("username") String username, @Param("password") String password, @Param("redirect") String redirect);

  /**
   * Platform Login
   * Similar to <code>platformLogin</code> but it also returns the http response headers .
   * The username and password are in &#x60;bonita-platform-community-custom.properties&#x60; file. 
   * @param username the username (optional)
   * @param password the password (optional)
   * @param redirect \\\&quot;true\\\&quot; or \\\&quot;false\\\&quot;. \\\&quot;false\\\&quot; indicates that the service should not redirect to Bonita Portal (after a successful login) or to the login page (after a login failure). (optional)
   */
  @RequestLine("POST /platformloginservice")
  @Headers({
    "Content-Type: application/x-www-form-urlencoded",
    "Accept: application/json",
  })
  ApiResponse<Void> platformLoginWithHttpInfo(@Param("username") String username, @Param("password") String password, @Param("redirect") String redirect);



  /**
   * Platform Logout
   * 
   */
  @RequestLine("POST /platformlogoutservice")
  @Headers({
    "Accept: application/json",
  })
  void platformLogout();

  /**
   * Platform Logout
   * Similar to <code>platformLogout</code> but it also returns the http response headers .
   * 
   */
  @RequestLine("POST /platformlogoutservice")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> platformLogoutWithHttpInfo();


}
