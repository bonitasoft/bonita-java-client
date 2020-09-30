package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TaskApi {
  /**
   * Finds Tasks
   * Finds Tasks with pagination params and filters  - can order on &#x60;caseId&#x60;, &#x60;processId&#x60;, &#x60;state&#x60;, &#x60;type&#x60;, &#x60;supervisor_id&#x60;, &#x60;last_update_date&#x60; - can filter on &#x60;caseId&#x60;, &#x60;processId&#x60;, &#x60;state&#x60;, &#x60;type&#x60;, &#x60;supervisor_id&#x60;, &#x60;last_update_date&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return Call&lt;List&lt;Task&gt;&gt;
   */
  @GET("API/bpm/task")
  Call<List<Task>> findTasks(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o
  );

  /**
   * Finds the Task by ID
   * Returns the single Task for the given ID 
   * @param id ID of the Task to return (required)
   * @return Call&lt;Task&gt;
   */
  @GET("API/bpm/task/{id}")
  Call<Task> getTaskById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Update the Task by ID
   * Update the Task for the given ID 
   * @param id ID of the Task to return (required)
   * @param requestBody Task fields to update (forbidden fields are : &#x60;caseId&#x60;, &#x60;processId&#x60;, &#x60;name&#x60;, &#x60;executedBy&#x60;, &#x60;type&#x60;, &#x60;id&#x60;, &#x60;reached_state_date&#x60;, &#x60;last_update_date&#x60;) (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/bpm/task/{id}")
  Call<Void> updateTaskById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body Map<String, Object> requestBody
  );

}
