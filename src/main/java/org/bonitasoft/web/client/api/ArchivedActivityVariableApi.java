package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;

import org.bonitasoft.web.client.model.ArchivedActivityVariable;
import org.bonitasoft.web.client.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ArchivedActivityVariableApi extends ApiClient.Api {


  /**
   * Finds the ArchivedActivityVariable by case ID and name
   * Since 2022.1  Returns the single ArchivedActivityVariable for the given activity ID and variable name 
   * @param id The identifier of the activity from which to retrieve the variable (required)
   * @param variableName The name of the variable to retrieve (required)
   * @return ArchivedActivityVariable
   */
  @RequestLine("GET /API/bpm/archivedActivityVariable/{id}/{variableName}")
  @Headers({
    "Accept: application/json",
  })
  ArchivedActivityVariable getArchivedActivityInstanceVariable(@Param("id") String id, @Param("variableName") String variableName);

  /**
   * Finds the ArchivedActivityVariable by case ID and name
   * Similar to <code>getArchivedActivityInstanceVariable</code> but it also returns the http response headers .
   * Since 2022.1  Returns the single ArchivedActivityVariable for the given activity ID and variable name 
   * @param id The identifier of the activity from which to retrieve the variable (required)
   * @param variableName The name of the variable to retrieve (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/archivedActivityVariable/{id}/{variableName}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<ArchivedActivityVariable> getArchivedActivityInstanceVariableWithHttpInfo(@Param("id") String id, @Param("variableName") String variableName);


}
