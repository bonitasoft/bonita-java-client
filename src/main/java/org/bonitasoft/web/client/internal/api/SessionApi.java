package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Session;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
public interface SessionApi extends ApiClient.Api {


  /**
   * Get the current user session
   * Returns session information for the current user 
   * @return Session
   */
  @RequestLine("GET /API/system/session/unusedId")
  @Headers({
    "Accept: application/json",
  })
  Session getSession();
}
