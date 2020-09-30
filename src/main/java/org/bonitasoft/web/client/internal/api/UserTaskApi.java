package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.Contract;
import org.bonitasoft.web.client.internal.model.InlineObject10;
import org.bonitasoft.web.client.internal.model.InlineObject11;
import org.bonitasoft.web.client.internal.model.UserTask;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

import java.util.List;
import java.util.Map;

public interface UserTaskApi {
  /**
   * Create the UserTask
   * Create the UserTask 
   * @param body  (required)
   * @return Call&lt;UserTask&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/bpm/userTask")
  Call<UserTask> createUserTask(
    @retrofit2.http.Body InlineObject10 body
  );

  /**
   * Execute the UserTask
   * Execute the UserTask. In order to execute a task, the task contract values have to be provided. 
   * @param id ID of the UserTask to execute (required)
   * @param body A JSON object matching task contract. Execute a task providing correct contract values. (required)
   * @param assign if true, assign the task to the current user and execute the task (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/bpm/userTask/{id}/execution")
  Call<Void> executeUserTask(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body Map<String, Object> body, @retrofit2.http.Query("assign") Boolean assign
  );

  /**
   * Finds UserTasks
   * Finds UserTasks with pagination params and filters  - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;UserTask&gt;&gt;
   */
  @GET("API/bpm/userTask")
  Call<List<UserTask>> findUserTasks(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

  /**
   * Finds the Context by UserTask ID
   * Returns the Context for the given UserTask ID 
   * @param id ID of the UserTask that has the Context to return (required)
   * @return Call&lt;Map&lt;String, Object&gt;&gt;
   */
  @GET("API/bpm/userTask/{id}/context")
  Call<Map<String, Object>> getContextByUserTaskId(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Finds the Contract by UserTask ID
   * Returns the Contract for the given UserTask ID 
   * @param id ID of the UserTask that has the Contract to return (required)
   * @return Call&lt;Contract&gt;
   */
  @GET("API/bpm/userTask/{id}/contract")
  Call<Contract> getContractByUserTaskId(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Finds the UserTask by ID
   * Returns the single UserTask for the given ID 
   * @param id ID of the UserTask to return (required)
   * @return Call&lt;UserTask&gt;
   */
  @GET("API/bpm/userTask/{id}")
  Call<UserTask> getUserTaskById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Update the UserTask by ID
   * Update the UserTask for the given ID.  Fields that can be updated are assignedId and state. The only value that can be set for the state is \&quot;skipped\&quot;. You only need to specify the fields that are to be updated. 
   * @param id ID of the UserTask to return (required)
   * @param inlineObject11  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/bpm/userTask/{id}")
  Call<Void> updateUserTaskById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body InlineObject11 inlineObject11
  );

}
