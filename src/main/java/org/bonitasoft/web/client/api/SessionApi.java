package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;

import org.bonitasoft.web.client.model.Error;
import org.bonitasoft.web.client.model.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


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
