package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;

import org.bonitasoft.web.client.model.ConnectorFailure;
import org.bonitasoft.web.client.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ConnectorFailureApi extends ApiClient.Api {


  /**
   * Finds the ConnectorFailure by ID
   * Returns the single ConnectorFailure for the given ID 
   * @param id ID of the ConnectorFailure to return (required)
   * @return ConnectorFailure
   */
  @RequestLine("GET /API/bpm/connectorFailure/{id}")
  @Headers({
    "Accept: application/json",
  })
  ConnectorFailure getConnectorFailureById(@Param("id") String id);

  /**
   * Finds the ConnectorFailure by ID
   * Similar to <code>getConnectorFailureById</code> but it also returns the http response headers .
   * Returns the single ConnectorFailure for the given ID 
   * @param id ID of the ConnectorFailure to return (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/connectorFailure/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<ConnectorFailure> getConnectorFailureByIdWithHttpInfo(@Param("id") String id);


}
