package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.ActivityVariable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ActivityVariableApi {
  /**
   * Finds the ActivityVariable by ID
   * Returns the single ActivityVariable for the given ID 
   * @param id The identifier of the activity from which to retrieve the variable (required)
   * @param variableName The name of the variable to retrieve (required)
   * @return Call&lt;ActivityVariable&gt;
   */
  @GET("API/bpm/activityVariable/{id}/{variableName}")
  Call<ActivityVariable> getActivityVariableById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Path("variableName") oas_any_type_not_mapped variableName
  );

}
