package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.EncodingUtils;
import org.bonitasoft.web.client.internal.model.ArchivedCase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
public interface ArchivedCaseApi extends ApiClient.Api {


  /**
   * Delete the ArchivedCase by ID
   * Delete the single ArchivedCase for the given ID 
   * @param id ID of the ArchivedCase to delete (required)
   */
  @RequestLine("DELETE /API/bpm/archivedCase/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteArchivedCaseById(@Param("id") String id);

  /**
   * Finds ArchivedCases
   * Finds ArchivedCases with pagination params and filters  You can order on &#x60;id&#x60;, &#x60;processDefinitionId&#x60;, &#x60;startedBy&#x60;, &#x60;startedBySubstitute&#x60;, &#x60;startDate&#x60;, &#x60;endDate&#x60;, &#x60;lastUpdate&#x60;, &#x60;archivedDate&#x60;, &#x60;sourceObjectId&#x60;  You can filter on :  * &#x60;sourceObjectId&#x60;: The original case ID before the case was archived * &#x60;processDefinitionId&#x60;: The process derfinition ID * &#x60;name&#x60;: the process name * &#x60;started_by&#x60;: the ID of the user who started the process * &#x60;team_manager_id&#x60;: allow to retrieve the cases in which all users with this manager ID ar involved) * &#x60;supervisor_id&#x60;: allow the retrived the cases of all processes the user with this ID is supervisor of) beware you cannot use team_manager_id and supervisor_id at the same time 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return List&lt;ArchivedCase&gt;
   */
  @RequestLine("GET /API/bpm/archivedCase?p={p}&c={c}&f={f}&o={o}")
  @Headers({
    "Accept: application/json",
  })
  List<ArchivedCase> findArchivedCases(@Param("p") Integer p, @Param("c") Integer c, @Param("f") String f, @Param("o") String o);

  /**
   * Finds ArchivedCases
   * Finds ArchivedCases with pagination params and filters  You can order on &#x60;id&#x60;, &#x60;processDefinitionId&#x60;, &#x60;startedBy&#x60;, &#x60;startedBySubstitute&#x60;, &#x60;startDate&#x60;, &#x60;endDate&#x60;, &#x60;lastUpdate&#x60;, &#x60;archivedDate&#x60;, &#x60;sourceObjectId&#x60;  You can filter on :  * &#x60;sourceObjectId&#x60;: The original case ID before the case was archived * &#x60;processDefinitionId&#x60;: The process derfinition ID * &#x60;name&#x60;: the process name * &#x60;started_by&#x60;: the ID of the user who started the process * &#x60;team_manager_id&#x60;: allow to retrieve the cases in which all users with this manager ID ar involved) * &#x60;supervisor_id&#x60;: allow the retrived the cases of all processes the user with this ID is supervisor of) beware you cannot use team_manager_id and supervisor_id at the same time 
   * Note, this is equivalent to the other <code>findArchivedCases</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindArchivedCasesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   <li>o - can order on attributes (optional)</li>
   *   </ul>
   * @return List&lt;ArchivedCase&gt;
   */
  @RequestLine("GET /API/bpm/archivedCase?p={p}&c={c}&f={f}&o={o}")
  @Headers({
  "Accept: application/json",
  })
  List<ArchivedCase> findArchivedCases(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findArchivedCases</code> method in a fluent style.
   */
  public static class FindArchivedCasesQueryParams extends HashMap<String, Object> {
    public FindArchivedCasesQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public FindArchivedCasesQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public FindArchivedCasesQueryParams f(final String value) {
      put("f", EncodingUtils.encode(value));
      return this;
    }
    public FindArchivedCasesQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Finds the ArchivedCase by ID
   * Returns the single ArchivedCase for the given ID 
   * @param id ID of the ArchivedCase to return (required)
   * @return ArchivedCase
   */
  @RequestLine("GET /API/bpm/archivedCase/{id}")
  @Headers({
    "Accept: application/json",
  })
  ArchivedCase getArchivedCaseById(@Param("id") String id);

  /**
   * Finds the Context by ArchivedCase ID
   * Returns the Context for the given ArchivedCase ID 
   * @param id ID of the ArchivedCase that has the Context to return (required)
   * @return Map&lt;String, Object&gt;
   */
  @RequestLine("GET /API/bpm/archivedCase/{id}/context")
  @Headers({
    "Accept: application/json",
  })
  Map<String, Object> getContextByArchivedCaseId(@Param("id") String id);
}
