package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.ArchivedActivityVariable;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ArchivedActivityVariableApi extends ApiClient.Api {


  /**
   * Finds the ArchivedActivityVariable by case ID and name
   * Since 2022.1  Returns the single ActivityVariable for the given case ID and variable name 
   * @param id The identifier of the case from which to retrieve the variable (required)
   * @param variableName The name of the variable to retrieve (required)
   * @return ArchivedActivityVariable
   */
  @RequestLine("GET /API/bpm/archivedActivityVariable/{id}/{variableName}")
  @Headers({
    "Accept: application/json",
  })
  ArchivedActivityVariable getArchivedActivityVariable(@Param("id") String id, @Param("variableName") String variableName);

  /**
   * Finds the ArchivedActivityVariable by case ID and name
   * Similar to <code>getArchivedActivityVariable</code> but it also returns the http response headers .
   * Since 2022.1  Returns the single ActivityVariable for the given case ID and variable name 
   * @param id The identifier of the case from which to retrieve the variable (required)
   * @param variableName The name of the variable to retrieve (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/archivedActivityVariable/{id}/{variableName}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<ArchivedActivityVariable> getArchivedActivityVariableWithHttpInfo(@Param("id") String id, @Param("variableName") String variableName);


}
