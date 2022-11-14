package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;

import org.bonitasoft.web.client.model.Error;
import org.bonitasoft.web.client.model.ManualTask;
import org.bonitasoft.web.client.model.ManualTaskCreateRequest;
import org.bonitasoft.web.client.model.ManualTaskUpdateRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ManualTaskApi extends ApiClient.Api {


  /**
   * Create the ManualTask
   * Create the ManualTask. Use a POST method to create a new subtask. A subtask is attached to a parent task and it needs to be immediately assigned to a user. 
   * @param body Partial ManualTask description (required)
   * @return ManualTask
   */
  @RequestLine("POST /API/bpm/manualTask")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ManualTask createManualTask(ManualTaskCreateRequest body);

  /**
   * Create the ManualTask
   * Similar to <code>createManualTask</code> but it also returns the http response headers .
   * Create the ManualTask. Use a POST method to create a new subtask. A subtask is attached to a parent task and it needs to be immediately assigned to a user. 
   * @param body Partial ManualTask description (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /API/bpm/manualTask")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<ManualTask> createManualTaskWithHttpInfo(ManualTaskCreateRequest body);



  /**
   * Finds the ManualTask by ID
   * Returns the single ManualTask for the given ID 
   * @param id ID of the ManualTask to return (required)
   * @return ManualTask
   */
  @RequestLine("GET /API/bpm/manualTask/{id}")
  @Headers({
    "Accept: application/json",
  })
  ManualTask getManualTaskById(@Param("id") String id);

  /**
   * Finds the ManualTask by ID
   * Similar to <code>getManualTaskById</code> but it also returns the http response headers .
   * Returns the single ManualTask for the given ID 
   * @param id ID of the ManualTask to return (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/manualTask/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<ManualTask> getManualTaskByIdWithHttpInfo(@Param("id") String id);



  /**
   * Finds ManualTasks
   * Finds ManualTasks with pagination params and filters  You can filter on:  * &#x60;assigned_id&#x3D;{user_id}&#x60;: retrieve only the manual tasks assigned to the specified user. For example, retrieve the manual tasks assigned to user with id 1: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;assigned_id%3d1&#x60;. * &#x60;state&#x3D;skipped | ready | completed | failed&#x60; : retrieve only the manual tasks with the specified state. For example, retrieve the ready tasks: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;state%3dready&#x60;. * &#x60;caseId&#x3D;{case_id}&#x60;: retrieve only the manual tasks created in the specified process instances. For example, retrieve the manual tasks for the case\\_id 2: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;caseId%3d2&#x60;. * &#x60;parentTaskId&#x3D;{parentTask_id}&#x60;: retrieve only the manual tasks for a specific parentTask. For example, retrieve the manual tasks for the parentTask\\_id 40001: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;parentTaskId%3d40001&#x60;.  You can search on:  * name: search all manual tasks with a name that starts with the search string. For example, search for all manual tasks that have a name that starts with MySubTask: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;s&#x3D;MySubTask&#x60;. 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return List&lt;ManualTask&gt;
   */
  @RequestLine("GET /API/bpm/manualTask?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  List<ManualTask> searchManualTasks(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

  /**
   * Finds ManualTasks
   * Similar to <code>searchManualTasks</code> but it also returns the http response headers .
   * Finds ManualTasks with pagination params and filters  You can filter on:  * &#x60;assigned_id&#x3D;{user_id}&#x60;: retrieve only the manual tasks assigned to the specified user. For example, retrieve the manual tasks assigned to user with id 1: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;assigned_id%3d1&#x60;. * &#x60;state&#x3D;skipped | ready | completed | failed&#x60; : retrieve only the manual tasks with the specified state. For example, retrieve the ready tasks: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;state%3dready&#x60;. * &#x60;caseId&#x3D;{case_id}&#x60;: retrieve only the manual tasks created in the specified process instances. For example, retrieve the manual tasks for the case\\_id 2: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;caseId%3d2&#x60;. * &#x60;parentTaskId&#x3D;{parentTask_id}&#x60;: retrieve only the manual tasks for a specific parentTask. For example, retrieve the manual tasks for the parentTask\\_id 40001: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;parentTaskId%3d40001&#x60;.  You can search on:  * name: search all manual tasks with a name that starts with the search string. For example, search for all manual tasks that have a name that starts with MySubTask: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;s&#x3D;MySubTask&#x60;. 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/manualTask?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<ManualTask>> searchManualTasksWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);


  /**
   * Finds ManualTasks
   * Finds ManualTasks with pagination params and filters  You can filter on:  * &#x60;assigned_id&#x3D;{user_id}&#x60;: retrieve only the manual tasks assigned to the specified user. For example, retrieve the manual tasks assigned to user with id 1: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;assigned_id%3d1&#x60;. * &#x60;state&#x3D;skipped | ready | completed | failed&#x60; : retrieve only the manual tasks with the specified state. For example, retrieve the ready tasks: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;state%3dready&#x60;. * &#x60;caseId&#x3D;{case_id}&#x60;: retrieve only the manual tasks created in the specified process instances. For example, retrieve the manual tasks for the case\\_id 2: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;caseId%3d2&#x60;. * &#x60;parentTaskId&#x3D;{parentTask_id}&#x60;: retrieve only the manual tasks for a specific parentTask. For example, retrieve the manual tasks for the parentTask\\_id 40001: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;parentTaskId%3d40001&#x60;.  You can search on:  * name: search all manual tasks with a name that starts with the search string. For example, search for all manual tasks that have a name that starts with MySubTask: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;s&#x3D;MySubTask&#x60;. 
   * Note, this is equivalent to the other <code>searchManualTasks</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchManualTasksQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   <li>o - can order on attributes (optional)</li>
   *   <li>s - can search on attributes (optional)</li>
   *   </ul>
   * @return List&lt;ManualTask&gt;
   */
  @RequestLine("GET /API/bpm/manualTask?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
  "Accept: application/json",
  })
  List<ManualTask> searchManualTasks(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
  * Finds ManualTasks
  * Finds ManualTasks with pagination params and filters  You can filter on:  * &#x60;assigned_id&#x3D;{user_id}&#x60;: retrieve only the manual tasks assigned to the specified user. For example, retrieve the manual tasks assigned to user with id 1: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;assigned_id%3d1&#x60;. * &#x60;state&#x3D;skipped | ready | completed | failed&#x60; : retrieve only the manual tasks with the specified state. For example, retrieve the ready tasks: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;state%3dready&#x60;. * &#x60;caseId&#x3D;{case_id}&#x60;: retrieve only the manual tasks created in the specified process instances. For example, retrieve the manual tasks for the case\\_id 2: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;caseId%3d2&#x60;. * &#x60;parentTaskId&#x3D;{parentTask_id}&#x60;: retrieve only the manual tasks for a specific parentTask. For example, retrieve the manual tasks for the parentTask\\_id 40001: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;parentTaskId%3d40001&#x60;.  You can search on:  * name: search all manual tasks with a name that starts with the search string. For example, search for all manual tasks that have a name that starts with MySubTask: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;s&#x3D;MySubTask&#x60;. 
  * Note, this is equivalent to the other <code>searchManualTasks</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>p - index of the page to display (required)</li>
          *   <li>c - maximum number of elements to retrieve (required)</li>
          *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
          *   <li>o - can order on attributes (optional)</li>
          *   <li>s - can search on attributes (optional)</li>
      *   </ul>
          * @return List&lt;ManualTask&gt;
      */
      @RequestLine("GET /API/bpm/manualTask?p={p}&c={c}&f={f}&o={o}&s={s}")
      @Headers({
    "Accept: application/json",
      })
   ApiResponse<List<ManualTask>> searchManualTasksWithHttpInfo(@QueryMap(encoded=true) Map<String, Object> queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>searchManualTasks</code> method in a fluent style.
   */
  public static class SearchManualTasksQueryParams extends HashMap<String, Object> {
    public SearchManualTasksQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public SearchManualTasksQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public SearchManualTasksQueryParams f(final List<String> value) {
      put("f", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public SearchManualTasksQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
    public SearchManualTasksQueryParams s(final String value) {
      put("s", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Update the ManualTask by ID
   * Update the ManualTask for the given ID. Use a PUT method to execute a subtask. Executing a subtask basically means changing its state to completed and providing an executedBy value. 
   * @param id ID of the ManualTask to return (required)
   * @param manualTaskUpdateRequest Partial ManualTask description (required)
   */
  @RequestLine("PUT /API/bpm/manualTask/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateManualTaskById(@Param("id") String id, ManualTaskUpdateRequest manualTaskUpdateRequest);

  /**
   * Update the ManualTask by ID
   * Similar to <code>updateManualTaskById</code> but it also returns the http response headers .
   * Update the ManualTask for the given ID. Use a PUT method to execute a subtask. Executing a subtask basically means changing its state to completed and providing an executedBy value. 
   * @param id ID of the ManualTask to return (required)
   * @param manualTaskUpdateRequest Partial ManualTask description (required)
   */
  @RequestLine("PUT /API/bpm/manualTask/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Void> updateManualTaskByIdWithHttpInfo(@Param("id") String id, ManualTaskUpdateRequest manualTaskUpdateRequest);


}
