package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Platform;
import org.bonitasoft.web.client.internal.model.PlatformUpdateRequest;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
public interface PlatformApi extends ApiClient.Api {


  /**
   * Finds the Platform by ID
   * Returns the current Platform 
   * @return Platform
   */
  @RequestLine("GET /API/platform/platform/unusedid")
  @Headers({
    "Accept: application/json",
  })
  Platform getPlatformById();

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

  /**
   * Update the Platform by ID
   * Start or stop the current node, that is, start or stop all services of the current JVM. 
   * @param platformUpdateRequest Start or stop all services of the current JVM. (required)
   */
  @RequestLine("PUT /API/platform/platform/unusedid")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updatePlatformById(PlatformUpdateRequest platformUpdateRequest);
}
