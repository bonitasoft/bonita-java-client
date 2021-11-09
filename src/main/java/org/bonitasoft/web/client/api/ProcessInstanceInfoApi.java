package org.bonitasoft.web.client.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.ProcessInstanceInfo;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ProcessInstanceInfoApi extends ApiClient.Api {


  /**
   * Finds the ProcessInstanceInfo by ID
   * Returns the single ProcessInstanceInfo for the given ID 
   * @param id ID of the ProcessInstanceInfo to return (required)
   * @return ProcessInstanceInfo
   */
  @RequestLine("GET /API/bpm/caseInfo/{id}")
  @Headers({
    "Accept: application/json",
  })
  ProcessInstanceInfo getProcessInstanceInfoById(@Param("id") String id);

  /**
   * Finds the ProcessInstanceInfo by ID
   * Similar to <code>getProcessInstanceInfoById</code> but it also returns the http response headers .
   * Returns the single ProcessInstanceInfo for the given ID 
   * @param id ID of the ProcessInstanceInfo to return (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/caseInfo/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<ProcessInstanceInfo> getProcessInstanceInfoByIdWithHttpInfo(@Param("id") String id);


}
