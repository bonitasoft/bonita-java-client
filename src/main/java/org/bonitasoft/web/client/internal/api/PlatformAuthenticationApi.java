package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
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
   * Platform Logout
   * 
   */
  @RequestLine("POST /platformlogoutservice")
  @Headers({
    "Accept: application/json",
  })
  void platformLogout();
}
