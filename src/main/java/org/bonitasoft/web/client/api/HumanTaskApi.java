package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.HumanTask;
import org.bonitasoft.web.client.model.HumanTaskUpdateRequest;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface HumanTaskApi extends ApiClient.Api {


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
   * Finds the HumanTask by ID
   * Similar to <code>getHumanTaskById</code> but it also returns the http response headers .
   * Returns the single HumanTask for the given ID 
   * @param id ID of the HumanTask to return (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/humanTask/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<HumanTask> getHumanTaskByIdWithHttpInfo(@Param("id") String id);



  /**
   * Finds HumanTasks
   * Finds HumanTasks with pagination params and filters  - can order on &#x60;name&#x60;, &#x60;priority&#x60;, &#x60;dueDate&#x60;, &#x60;state&#x60;, &#x60;processDefinitionId&#x60;, &#x60;processInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60;, &#x60;assigneeId&#x60;, &#x60;parentContainerId&#x60;, &#x60;displayName&#x60;, &#x60;reachedStateDate&#x60; - can search on any field that can be used to order results - can filter on &#x60;assigned_id&#x60;, &#x60;state&#x60;, &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;processDefinitionId&#x60;, &#x60;caseId&#x60;, &#x60;rootProcessInstanceId&#x60;, &#x60;parentProcessInstanceId&#x60; 
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
  List<HumanTask> searchHumanTasks(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

  /**
   * Finds HumanTasks
   * Similar to <code>searchHumanTasks</code> but it also returns the http response headers .
   * Finds HumanTasks with pagination params and filters  - can order on &#x60;name&#x60;, &#x60;priority&#x60;, &#x60;dueDate&#x60;, &#x60;state&#x60;, &#x60;processDefinitionId&#x60;, &#x60;processInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60;, &#x60;assigneeId&#x60;, &#x60;parentContainerId&#x60;, &#x60;displayName&#x60;, &#x60;reachedStateDate&#x60; - can search on any field that can be used to order results - can filter on &#x60;assigned_id&#x60;, &#x60;state&#x60;, &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;processDefinitionId&#x60;, &#x60;caseId&#x60;, &#x60;rootProcessInstanceId&#x60;, &#x60;parentProcessInstanceId&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/humanTask?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<HumanTask>> searchHumanTasksWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);


  /**
   * Finds HumanTasks
   * Finds HumanTasks with pagination params and filters  - can order on &#x60;name&#x60;, &#x60;priority&#x60;, &#x60;dueDate&#x60;, &#x60;state&#x60;, &#x60;processDefinitionId&#x60;, &#x60;processInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60;, &#x60;assigneeId&#x60;, &#x60;parentContainerId&#x60;, &#x60;displayName&#x60;, &#x60;reachedStateDate&#x60; - can search on any field that can be used to order results - can filter on &#x60;assigned_id&#x60;, &#x60;state&#x60;, &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;processDefinitionId&#x60;, &#x60;caseId&#x60;, &#x60;rootProcessInstanceId&#x60;, &#x60;parentProcessInstanceId&#x60; 
   * Note, this is equivalent to the other <code>searchHumanTasks</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchHumanTasksQueryParams} class that allows for
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
  List<HumanTask> searchHumanTasks(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
  * Finds HumanTasks
  * Finds HumanTasks with pagination params and filters  - can order on &#x60;name&#x60;, &#x60;priority&#x60;, &#x60;dueDate&#x60;, &#x60;state&#x60;, &#x60;processDefinitionId&#x60;, &#x60;processInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60;, &#x60;assigneeId&#x60;, &#x60;parentContainerId&#x60;, &#x60;displayName&#x60;, &#x60;reachedStateDate&#x60; - can search on any field that can be used to order results - can filter on &#x60;assigned_id&#x60;, &#x60;state&#x60;, &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;processDefinitionId&#x60;, &#x60;caseId&#x60;, &#x60;rootProcessInstanceId&#x60;, &#x60;parentProcessInstanceId&#x60; 
  * Note, this is equivalent to the other <code>searchHumanTasks</code> that receives the query parameters as a map,
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
          * @return List&lt;HumanTask&gt;
      */
      @RequestLine("GET /API/bpm/humanTask?p={p}&c={c}&f={f}&o={o}&s={s}")
      @Headers({
    "Accept: application/json",
      })
   ApiResponse<List<HumanTask>> searchHumanTasksWithHttpInfo(@QueryMap(encoded=true) Map<String, Object> queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>searchHumanTasks</code> method in a fluent style.
   */
  public static class SearchHumanTasksQueryParams extends HashMap<String, Object> {
    public SearchHumanTasksQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public SearchHumanTasksQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public SearchHumanTasksQueryParams f(final List<String> value) {
      put("f", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public SearchHumanTasksQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
    public SearchHumanTasksQueryParams s(final String value) {
      put("s", EncodingUtils.encode(value));
      return this;
    }
  }

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

  /**
   * Update the HumanTask by ID
   * Similar to <code>updateHumanTaskById</code> but it also returns the http response headers .
   * Update the HumanTask for the given ID 
   * @param id ID of the HumanTask to return (required)
   * @param humanTaskUpdateRequest Fields that can be updated are &#x60;assignedId&#x60; and &#x60;state&#x60;. Specify only those fields that you want to change. (required)
   */
  @RequestLine("PUT /API/bpm/humanTask/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Void> updateHumanTaskByIdWithHttpInfo(@Param("id") String id, HumanTaskUpdateRequest humanTaskUpdateRequest);


}
