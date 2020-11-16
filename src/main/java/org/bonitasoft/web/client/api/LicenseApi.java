package org.bonitasoft.web.client.api;

import feign.*;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.PlatformLicense;

public interface LicenseApi extends ApiClient.Api {

  /**
   * Get the current server license Returns license information for the current server
   *
   * @return License
   */
  @RequestLine("GET /API/system/license/unusedid")
  @Headers({
    "Accept: application/json",
  })
  Response getLicense();

  /**
   * Get the platform License Returns the current platform License. This requires a platform
   * session. Log in using the platform login service.
   *
   * @return PlatformLicense
   */
  @RequestLine("GET /API/platform/license")
  @Headers({
    "Accept: application/json",
  })
  PlatformLicense getPlatformLicense();
}
