package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.ActivityVariable;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
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
}
