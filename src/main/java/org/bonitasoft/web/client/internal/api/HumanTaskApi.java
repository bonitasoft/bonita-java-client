package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.EncodingUtils;
import org.bonitasoft.web.client.internal.model.HumanTask;
import org.bonitasoft.web.client.internal.model.HumanTaskUpdateRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
public interface HumanTaskApi extends ApiClient.Api {


  /**
   * Finds HumanTasks
   * Finds HumanTasks with pagination params and filters  - can order on &#x60;name&#x60;, &#x60;priority&#x60;, &#x60;dueDate&#x60;, &#x60;state&#x60;, &#x60;userId&#x60;, &#x60;groupId&#x60;, &#x60;roleId&#x60;, &#x60;processDefinitionId&#x60;, &#x60;processInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60;, &#x60;assigneeId&#x60;, &#x60;parentContainerId&#x60;, &#x60;displayName&#x60;, &#x60;reachedStateDate&#x60; - can search on any field that can be used to order results - can filter on &#x60;assigned_id&#x60;, &#x60;state&#x60;, &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;processDefinitionId&#x60;, &#x60;parentContainerId&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return List&lt;HumanTask&gt;
   */
  @RequestLine("GET /API/bpm/humanTask?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  List<HumanTask> findHumanTasks(@Param("p") Integer p, @Param("c") Integer c, @Param("f") String f, @Param("o") String o, @Param("s") String s);

  /**
   * Finds HumanTasks
   * Finds HumanTasks with pagination params and filters  - can order on &#x60;name&#x60;, &#x60;priority&#x60;, &#x60;dueDate&#x60;, &#x60;state&#x60;, &#x60;userId&#x60;, &#x60;groupId&#x60;, &#x60;roleId&#x60;, &#x60;processDefinitionId&#x60;, &#x60;processInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60;, &#x60;assigneeId&#x60;, &#x60;parentContainerId&#x60;, &#x60;displayName&#x60;, &#x60;reachedStateDate&#x60; - can search on any field that can be used to order results - can filter on &#x60;assigned_id&#x60;, &#x60;state&#x60;, &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;processDefinitionId&#x60;, &#x60;parentContainerId&#x60; 
   * Note, this is equivalent to the other <code>findHumanTasks</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindHumanTasksQueryParams} class that allows for
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
   * @return List&lt;HumanTask&gt;
   */
  @RequestLine("GET /API/bpm/humanTask?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
  "Accept: application/json",
  })
  List<HumanTask> findHumanTasks(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findHumanTasks</code> method in a fluent style.
   */
  public static class FindHumanTasksQueryParams extends HashMap<String, Object> {
    public FindHumanTasksQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public FindHumanTasksQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public FindHumanTasksQueryParams f(final String value) {
      put("f", EncodingUtils.encode(value));
      return this;
    }
    public FindHumanTasksQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
    public FindHumanTasksQueryParams s(final String value) {
      put("s", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Finds the HumanTask by ID
   * Returns the single HumanTask for the given ID 
   * @param id ID of the HumanTask to return (required)
   * @return HumanTask
   */
  @RequestLine("GET /API/bpm/humanTask/{id}")
  @Headers({
    "Accept: application/json",
  })
  HumanTask getHumanTaskById(@Param("id") String id);

  /**
   * Update the HumanTask by ID
   * Update the HumanTask for the given ID 
   * @param id ID of the HumanTask to return (required)
   * @param humanTaskUpdateRequest Fields that can be updated are &#x60;assignedId&#x60; and &#x60;state&#x60;. Specify only those fields that you want to change. (required)
   */
  @RequestLine("PUT /API/bpm/humanTask/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateHumanTaskById(@Param("id") String id, HumanTaskUpdateRequest humanTaskUpdateRequest);
}
