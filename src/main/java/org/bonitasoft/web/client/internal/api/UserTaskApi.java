package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.EncodingUtils;
import org.bonitasoft.web.client.internal.model.Contract;
import org.bonitasoft.web.client.internal.model.UserTask;
import org.bonitasoft.web.client.internal.model.UserTaskUpdateRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
public interface UserTaskApi extends ApiClient.Api {


  /**
   * Execute the UserTask
   * Execute the UserTask. In order to execute a task, the task contract values have to be provided. 
   * @param id ID of the UserTask to execute (required)
   * @param body A JSON object matching task contract. Execute a task providing correct contract values. (required)
   * @param assign if true, assign the task to the current user and execute the task (optional)
   */
  @RequestLine("POST /API/bpm/userTask/{id}/execution?assign={assign}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void executeUserTask(@Param("id") String id, Map<String, Object> body, @Param("assign") Boolean assign);

  /**
   * Execute the UserTask
   * Execute the UserTask. In order to execute a task, the task contract values have to be provided. 
   * Note, this is equivalent to the other <code>executeUserTask</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link ExecuteUserTaskQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param id ID of the UserTask to execute (required)
   * @param body A JSON object matching task contract. Execute a task providing correct contract values. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>assign - if true, assign the task to the current user and execute the task (optional)</li>
   *   </ul>
   */
  @RequestLine("POST /API/bpm/userTask/{id}/execution?assign={assign}")
  @Headers({
  "Content-Type: application/json",
  "Accept: application/json",
  })
  void executeUserTask(@Param("id") String id, Map<String, Object> body, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>executeUserTask</code> method in a fluent style.
   */
  public static class ExecuteUserTaskQueryParams extends HashMap<String, Object> {
    public ExecuteUserTaskQueryParams assign(final Boolean value) {
      put("assign", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Finds UserTasks
   * Finds UserTasks with pagination params and filters  - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return List&lt;UserTask&gt;
   */
  @RequestLine("GET /API/bpm/userTask?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  List<UserTask> findUserTasks(@Param("p") Integer p, @Param("c") Integer c, @Param("f") String f, @Param("o") String o, @Param("s") String s);

  /**
   * Finds UserTasks
   * Finds UserTasks with pagination params and filters  - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60; 
   * Note, this is equivalent to the other <code>findUserTasks</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindUserTasksQueryParams} class that allows for
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
   * @return List&lt;UserTask&gt;
   */
  @RequestLine("GET /API/bpm/userTask?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
  "Accept: application/json",
  })
  List<UserTask> findUserTasks(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findUserTasks</code> method in a fluent style.
   */
  public static class FindUserTasksQueryParams extends HashMap<String, Object> {
    public FindUserTasksQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public FindUserTasksQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public FindUserTasksQueryParams f(final String value) {
      put("f", EncodingUtils.encode(value));
      return this;
    }
    public FindUserTasksQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
    public FindUserTasksQueryParams s(final String value) {
      put("s", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Finds the Context by UserTask ID
   * Returns the Context for the given UserTask ID 
   * @param id ID of the UserTask that has the Context to return (required)
   * @return Map&lt;String, Object&gt;
   */
  @RequestLine("GET /API/bpm/userTask/{id}/context")
  @Headers({
    "Accept: application/json",
  })
  Map<String, Object> getContextByUserTaskId(@Param("id") String id);

  /**
   * Finds the Contract by UserTask ID
   * Returns the Contract for the given UserTask ID 
   * @param id ID of the UserTask that has the Contract to return (required)
   * @return Contract
   */
  @RequestLine("GET /API/bpm/userTask/{id}/contract")
  @Headers({
    "Accept: application/json",
  })
  Contract getContractByUserTaskId(@Param("id") String id);

  /**
   * Finds the UserTask by ID
   * Returns the single UserTask for the given ID 
   * @param id ID of the UserTask to return (required)
   * @return UserTask
   */
  @RequestLine("GET /API/bpm/userTask/{id}")
  @Headers({
    "Accept: application/json",
  })
  UserTask getUserTaskById(@Param("id") String id);

  /**
   * Update the UserTask by ID
   * Update the UserTask for the given ID.  Fields that can be updated are assignedId and state. The only value that can be set for the state is \&quot;skipped\&quot;. You only need to specify the fields that are to be updated. 
   * @param id ID of the UserTask to return (required)
   * @param userTaskUpdateRequest Partial UserTask description (required)
   */
  @RequestLine("PUT /API/bpm/userTask/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateUserTaskById(@Param("id") String id, UserTaskUpdateRequest userTaskUpdateRequest);
}
