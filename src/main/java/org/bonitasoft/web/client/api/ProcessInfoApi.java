package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;

import org.bonitasoft.web.client.model.Error;
import org.bonitasoft.web.client.model.ProcessInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ProcessInfoApi extends ApiClient.Api {


  /**
   * Finds the ProcessInfo by ID
   * Since 2022.2 ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Returns the single ProcessInfo for the given ID 
   * @param id ID of the ProcessInfo to return (required)
   * @return ProcessInfo
   */
  @RequestLine("GET /API/bpm/processInfo/{id}")
  @Headers({
    "Accept: application/json",
  })
  ProcessInfo getProcessInfoById(@Param("id") String id);

  /**
   * Finds the ProcessInfo by ID
   * Similar to <code>getProcessInfoById</code> but it also returns the http response headers .
   * Since 2022.2 ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Returns the single ProcessInfo for the given ID 
   * @param id ID of the ProcessInfo to return (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/processInfo/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<ProcessInfo> getProcessInfoByIdWithHttpInfo(@Param("id") String id);


}
