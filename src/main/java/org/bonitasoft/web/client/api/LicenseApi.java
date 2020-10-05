package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;

import org.bonitasoft.web.client.model.Error;
import org.bonitasoft.web.client.model.License;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


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
