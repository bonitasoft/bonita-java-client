package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;

import org.bonitasoft.web.client.model.ArchivedUserTask;
import org.bonitasoft.web.client.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface ArchivedUserTaskApi extends ApiClient.Api {


  /**
   * Finds the ArchivedUserTask by ID
   * Returns the single ArchivedUserTask for the given ID 
   * @param id ID of the ArchivedUserTask to return (required)
   * @return ArchivedUserTask
   */
  @RequestLine("GET /API/bpm/archivedUserTask/{id}")
  @Headers({
    "Accept: application/json",
  })
  ArchivedUserTask getArchivedUserTaskById(@Param("id") String id);

  /**
   * Finds ArchivedUserTasks
   * Finds ArchivedUserTasks with pagination params and filters. An ArchivedUserTask is an executable task that has been performed by a user or skipped and is archived.  You can filter on:  * &#x60;assigned_id&#x3D;{user_id}&#x60;: retrieve only the user tasks assigned to the specified ID. For example, retrieve the user tasks assigned to user with id 2: &#x60;/API/bpm/archivedUserTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;assigned_id%3d2&#x60; * &#x60;state&#x3D;&#x60;: retrieve only the archived user tasks with the specified state. For example, retrieve the skipped tasks: &#x60;/API/bpm/archivedUserTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;state&#x3D;skipped&#x60; * &#x60;name&#x3D;&#x60;: retrieve only the user tasks with the specified name. For example, retrieve the user tasks with the name \&quot;Analyse ProcessInstance\&quot;: &#x60;/API/bpm/archivedUserTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;name&#x3D;Analyse ProcessInstance&#x60; * &#x60;displayName&#x3D;&#x60;: retrieve only the archived user tasks with the specified displayName. For example, retrieve the user tasks with the displayName \&quot;Analyse ProcessInstance\&quot;: &#x60;/API/bpm/archivedUserTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;displayName&#x3D;Analyse ProcessInstance&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return List&lt;ArchivedUserTask&gt;
   */
  @RequestLine("GET /API/bpm/archivedUserTask?p={p}&c={c}&f={f}&o={o}")
  @Headers({
    "Accept: application/json",
  })
  List<ArchivedUserTask> searchArchivedUserTasks(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o);

  /**
   * Finds ArchivedUserTasks
   * Finds ArchivedUserTasks with pagination params and filters. An ArchivedUserTask is an executable task that has been performed by a user or skipped and is archived.  You can filter on:  * &#x60;assigned_id&#x3D;{user_id}&#x60;: retrieve only the user tasks assigned to the specified ID. For example, retrieve the user tasks assigned to user with id 2: &#x60;/API/bpm/archivedUserTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;assigned_id%3d2&#x60; * &#x60;state&#x3D;&#x60;: retrieve only the archived user tasks with the specified state. For example, retrieve the skipped tasks: &#x60;/API/bpm/archivedUserTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;state&#x3D;skipped&#x60; * &#x60;name&#x3D;&#x60;: retrieve only the user tasks with the specified name. For example, retrieve the user tasks with the name \&quot;Analyse ProcessInstance\&quot;: &#x60;/API/bpm/archivedUserTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;name&#x3D;Analyse ProcessInstance&#x60; * &#x60;displayName&#x3D;&#x60;: retrieve only the archived user tasks with the specified displayName. For example, retrieve the user tasks with the displayName \&quot;Analyse ProcessInstance\&quot;: &#x60;/API/bpm/archivedUserTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;displayName&#x3D;Analyse ProcessInstance&#x60; 
   * Note, this is equivalent to the other <code>searchArchivedUserTasks</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchArchivedUserTasksQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   <li>o - can order on attributes (optional)</li>
   *   </ul>
   * @return List&lt;ArchivedUserTask&gt;
   */
  @RequestLine("GET /API/bpm/archivedUserTask?p={p}&c={c}&f={f}&o={o}")
  @Headers({
  "Accept: application/json",
  })
  List<ArchivedUserTask> searchArchivedUserTasks(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>searchArchivedUserTasks</code> method in a fluent style.
   */
  public static class SearchArchivedUserTasksQueryParams extends HashMap<String, Object> {
    public SearchArchivedUserTasksQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public SearchArchivedUserTasksQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public SearchArchivedUserTasksQueryParams f(final List<String> value) {
      put("f", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public SearchArchivedUserTasksQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
  }
}
