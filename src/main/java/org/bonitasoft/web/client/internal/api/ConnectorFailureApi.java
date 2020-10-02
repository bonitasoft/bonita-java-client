package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.EncodingUtils;

import org.bonitasoft.web.client.internal.model.ConnectorFailure;
import org.bonitasoft.web.client.internal.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


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
}
