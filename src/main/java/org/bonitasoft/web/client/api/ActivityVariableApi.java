package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.ActivityVariable;
import org.bonitasoft.web.client.model.ApiResponse;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ActivityVariableApi extends ApiClient.Api {


  /**
   * Finds the ActivityVariable by ID
   * Returns the single ActivityVariable for the given ID 
   * @param id The identifier of the activity from which to retrieve the variable (required)
   * @param variableName The name of the variable to retrieve (required)
   * @return ActivityVariable
   */
  @RequestLine("GET /API/bpm/activityVariable/{id}/{variableName}")
  @Headers({
    "Accept: application/json",
  })
  ActivityVariable getActivityVariableById(@Param("id") String id, @Param("variableName") String variableName);

  /**
   * Finds the ActivityVariable by ID
   * Similar to <code>getActivityVariableById</code> but it also returns the http response headers .
   * Returns the single ActivityVariable for the given ID 
   * @param id The identifier of the activity from which to retrieve the variable (required)
   * @param variableName The name of the variable to retrieve (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/activityVariable/{id}/{variableName}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<ActivityVariable> getActivityVariableByIdWithHttpInfo(@Param("id") String id, @Param("variableName") String variableName);


}
