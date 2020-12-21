package org.bonitasoft.web.client.api;

import feign.*;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.ConnectorFailure;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ConnectorFailureApi extends ApiClient.Api {

  /**
   * Finds the ConnectorFailure by ID Returns the single ConnectorFailure for the given ID
   *
   * @param id ID of the ConnectorFailure to return (required)
   * @return ConnectorFailure
   */
  @RequestLine("GET /API/bpm/connectorFailure/{id}")
  @Headers({
    "Accept: application/json",
  })
  ConnectorFailure getConnectorFailureById(@Param("id") String id);
}
