package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.ManualTask;
import org.bonitasoft.web.client.internal.model.ManualTaskCreateRequest;
import org.bonitasoft.web.client.internal.model.ManualTaskUpdateRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ManualTaskApi {
  /**
   * Create the ManualTask
   * Create the ManualTask. Use a POST method to create a new subtask. A subtask is attached to a parent task and it needs to be immediately assigned to a user. 
   * @param body Partial ManualTask description (required)
   * @return Call&lt;ManualTask&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/bpm/manualTask")
  Call<ManualTask> createManualTask(
    @retrofit2.http.Body ManualTaskCreateRequest body
  );

  /**
   * Finds ManualTasks
   * Finds ManualTasks with pagination params and filters  You can filter on:  * &#x60;assigned_id&#x3D;{user_id}&#x60;: retrieve only the manual tasks assigned to the specified user. For example, retrieve the manual tasks assigned to user with id 1: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;assigned_id%3d1&#x60;. * &#x60;state&#x3D;skipped | ready | completed | failed&#x60; : retrieve only the manual tasks with the specified state. For example, retrieve the ready tasks: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;state%3dready&#x60;. * &#x60;caseId&#x3D;{case_id}&#x60;: retrieve only the manual tasks created in the specified case. For example, retrieve the manual tasks for the case\\_id 2: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;caseId%3d2&#x60;. * &#x60;parentTaskId&#x3D;{parentTask_id}&#x60;: retrieve only the manual tasks for a specific parentTask. For example, retrieve the manual tasks for the parentTask\\_id 40001: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;parentTaskId%3d40001&#x60;.  You can search on:  * name: search all manual tasks with a name that starts with the search string. For example, search for all manual tasks that have a name that starts with MySubTask: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;s&#x3D;MySubTask&#x60;. 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;ManualTask&gt;&gt;
   */
  @GET("API/bpm/manualTask")
  Call<List<ManualTask>> findManualTasks(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

  /**
   * Finds the ManualTask by ID
   * Returns the single ManualTask for the given ID 
   * @param id ID of the ManualTask to return (required)
   * @return Call&lt;ManualTask&gt;
   */
  @GET("API/bpm/manualTask/{id}")
  Call<ManualTask> getManualTaskById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Update the ManualTask by ID
   * Update the ManualTask for the given ID. Use a PUT method to execute a subtask. Executing a subtask basically means changing its state to completed and providing an executedBy value. 
   * @param id ID of the ManualTask to return (required)
   * @param manualTaskUpdateRequest Partial ManualTask description (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/bpm/manualTask/{id}")
  Call<Void> updateManualTaskById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body ManualTaskUpdateRequest manualTaskUpdateRequest
  );

}
