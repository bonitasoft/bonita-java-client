package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.ActivityVariable;
import org.bonitasoft.web.client.internal.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @retrofit2.http.Path("id") String id, @retrofit2.http.Path("variableName") String variableName
  );

}
