package org.bonitasoft.web.client.api;

import feign.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ArchivedProcessInstance;

public interface ArchivedProcessInstanceApi extends ApiClient.Api {

  /**
   * Delete the ArchivedProcessInstance by ID Delete the single ArchivedProcessInstance for the
   * given ID
   *
   * @param id ID of the ArchivedProcessInstance to delete (required)
   */
  @RequestLine("DELETE /API/bpm/archivedCase/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteArchivedProcessInstanceById(@Param("id") String id);

  /**
   * Finds the ArchivedProcessInstance by ID Returns the single ArchivedProcessInstance for the
   * given ID
   *
   * @param id ID of the ArchivedProcessInstance to return (required)
   * @return ArchivedProcessInstance
   */
  @RequestLine("GET /API/bpm/archivedCase/{id}")
  @Headers({
    "Accept: application/json",
  })
  ArchivedProcessInstance getArchivedProcessInstanceById(@Param("id") String id);

  /**
   * Finds the Context by ArchivedProcessInstance ID Returns the Context for the given
   * ArchivedProcessInstance ID
   *
   * @param id ID of the ArchivedProcessInstance that has the Context to return (required)
   * @return Map&lt;String, Object&gt;
   */
  @RequestLine("GET /API/bpm/archivedCase/{id}/context")
  @Headers({
    "Accept: application/json",
  })
  Map<String, Object> getContextByArchivedProcessInstanceId(@Param("id") String id);

  /**
   * Finds ArchivedProcessInstances Finds archived ProcessInstances (or ProcessInstance) with
   * pagination params and filters You can order on &#x60;id&#x60;, &#x60;processDefinitionId&#x60;,
   * &#x60;startedBy&#x60;, &#x60;startedBySubstitute&#x60;, &#x60;startDate&#x60;,
   * &#x60;endDate&#x60;, &#x60;lastUpdate&#x60;, &#x60;archivedDate&#x60;,
   * &#x60;sourceObjectId&#x60; You can filter on : * &#x60;sourceObjectId&#x60;: The original
   * process instance ID before the process instance was archived * &#x60;processDefinitionId&#x60;:
   * The process derfinition ID * &#x60;name&#x60;: the process name * &#x60;started_by&#x60;: the
   * ID of the user who started the process * &#x60;team_manager_id&#x60;: allow to retrieve the
   * process instances in which all users with this manager ID ar involved) *
   * &#x60;supervisor_id&#x60;: allow the retrived the process instances of all processes the user
   * with this ID is supervisor of) beware you cannot use team_manager_id and supervisor_id at the
   * same time
   *
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value}
   *     with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return List&lt;ArchivedProcessInstance&gt;
   */
  @RequestLine("GET /API/bpm/archivedCase?p={p}&c={c}&f={f}&o={o}")
  @Headers({
    "Accept: application/json",
  })
  List<ArchivedProcessInstance> searchArchivedProcessInstances(
      @Param("p") Integer p,
      @Param("c") Integer c,
      @Param("f") List<String> f,
      @Param("o") String o);

  /**
   * Finds ArchivedProcessInstances Finds archived ProcessInstances (or ProcessInstance) with
   * pagination params and filters You can order on &#x60;id&#x60;, &#x60;processDefinitionId&#x60;,
   * &#x60;startedBy&#x60;, &#x60;startedBySubstitute&#x60;, &#x60;startDate&#x60;,
   * &#x60;endDate&#x60;, &#x60;lastUpdate&#x60;, &#x60;archivedDate&#x60;,
   * &#x60;sourceObjectId&#x60; You can filter on : * &#x60;sourceObjectId&#x60;: The original
   * process instance ID before the process instance was archived * &#x60;processDefinitionId&#x60;:
   * The process derfinition ID * &#x60;name&#x60;: the process name * &#x60;started_by&#x60;: the
   * ID of the user who started the process * &#x60;team_manager_id&#x60;: allow to retrieve the
   * process instances in which all users with this manager ID ar involved) *
   * &#x60;supervisor_id&#x60;: allow the retrived the process instances of all processes the user
   * with this ID is supervisor of) beware you cannot use team_manager_id and supervisor_id at the
   * same time Note, this is equivalent to the other <code>searchArchivedProcessInstances</code>
   * method, but with the query parameters collected into a single Map parameter. This is convenient
   * for services with optional query parameters, especially when used with the {@link
   * SearchArchivedProcessInstancesQueryParams} class that allows for building up this map in a
   * fluent style.
   *
   * @param queryParams Map of query parameters as name-value pairs
   *     <p>The following elements may be specified in the query map:
   *     <ul>
   *       <li>p - index of the page to display (required)
   *       <li>c - maximum number of elements to retrieve (required)
   *       <li>f - can filter on attributes with the format
   *           f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded
   *           string. (optional)
   *       <li>o - can order on attributes (optional)
   *     </ul>
   *
   * @return List&lt;ArchivedProcessInstance&gt;
   */
  @RequestLine("GET /API/bpm/archivedCase?p={p}&c={c}&f={f}&o={o}")
  @Headers({
    "Accept: application/json",
  })
  List<ArchivedProcessInstance> searchArchivedProcessInstances(
      @QueryMap(encoded = true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the <code>
   * searchArchivedProcessInstances</code> method in a fluent style.
   */
  public static class SearchArchivedProcessInstancesQueryParams extends HashMap<String, Object> {
    public SearchArchivedProcessInstancesQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }

    public SearchArchivedProcessInstancesQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }

    public SearchArchivedProcessInstancesQueryParams f(final List<String> value) {
      put("f", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }

    public SearchArchivedProcessInstancesQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
  }
}
