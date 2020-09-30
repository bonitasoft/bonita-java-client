package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.ConnectorFailure;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ConnectorFailureApi {
  /**
   * Finds the ConnectorFailure by ID
   * Returns the single ConnectorFailure for the given ID 
   * @param id ID of the ConnectorFailure to return (required)
   * @return Call&lt;ConnectorFailure&gt;
   */
  @GET("API/bpm/connectorFailure/{id}")
  Call<ConnectorFailure> getConnectorFailureById(
    @retrofit2.http.Path("id") String id
  );

}
