package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.License;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
public interface LicenseApi extends ApiClient.Api {


  /**
   * Get the platform License
   * Returns the current platform License. This requires a platform session. Log in using the platform login service. 
   * @return License
   */
  @RequestLine("GET /API/platform/license")
  @Headers({
    "Accept: application/json",
  })
  License getLicense();
}
