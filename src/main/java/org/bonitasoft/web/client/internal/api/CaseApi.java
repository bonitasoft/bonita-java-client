package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.EncodingUtils;
import org.bonitasoft.web.client.internal.model.CaseCreateRequest;
import org.bonitasoft.web.client.internal.model.ModelCase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
public interface CaseApi extends ApiClient.Api {


  /**
   * Create the Case
   * ![edition](https://img.shields.io/badge/edition-entreprise-blue) ![edition](https://img.shields.io/badge/edition-community-brightgreen)  Create the Case This way of creating a case using this method will only work for processes in which no contract is defined. To instantiate a process with a contract, check the process instantiation resource documentation. 
   * @param body **Warning**: The attribute &#x60;variables&#x60; on the request payload is used to initialize the process variables (not BDM variables). If you want to initialize BDM variables at process instantiation, add a contract on the process and map BDM variables to the contract data. See Start a process using an instantiation contract for usage.  (required)
   * @return ModelCase
   */
  @RequestLine("POST /API/bpm/case")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ModelCase createCase(CaseCreateRequest body);

  /**
   * Delete the Case by ID
   * Delete the single Case for the given ID 
   * @param id ID of the Case to delete (required)
   */
  @RequestLine("DELETE /API/bpm/case/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteCaseById(@Param("id") String id);

  /**
   * Delete the Case by batch
   * ![edition](https://img.shields.io/badge/edition-entreprise-blue) ![edition](https://img.shields.io/badge/edition-community-brightgreen)  Delete a list of Cases for the given IDs 
   * @param requestBody  (optional)
   */
  @RequestLine("DELETE /API/bpm/case")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void deleteCaseByIds(List<String> requestBody);

  /**
   * Finds Cases
   * Finds Cases with pagination params and filters  You can filter on:  * &#x60;processDefinitionId&#x60;: The process derfinition ID * &#x60;name&#x60;: the process name * &#x60;started_by&#x60;: the ID of the user who started the process * &#x60;team_manager_id&#x60;: allow to retrieve the cases in which all users with this manager ID ar involved) * &#x60;supervisor_id&#x60;: allow the retrived the cases of all processes the user with this ID is supervisor of) beware you cannot use team_manager_id and supervisor_id at the same time 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return List&lt;ModelCase&gt;
   */
  @RequestLine("GET /API/bpm/case?p={p}&c={c}&f={f}&o={o}")
  @Headers({
    "Accept: application/json",
  })
  List<ModelCase> findCases(@Param("p") Integer p, @Param("c") Integer c, @Param("f") String f, @Param("o") String o);

  /**
   * Finds Cases
   * Finds Cases with pagination params and filters  You can filter on:  * &#x60;processDefinitionId&#x60;: The process derfinition ID * &#x60;name&#x60;: the process name * &#x60;started_by&#x60;: the ID of the user who started the process * &#x60;team_manager_id&#x60;: allow to retrieve the cases in which all users with this manager ID ar involved) * &#x60;supervisor_id&#x60;: allow the retrived the cases of all processes the user with this ID is supervisor of) beware you cannot use team_manager_id and supervisor_id at the same time 
   * Note, this is equivalent to the other <code>findCases</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindCasesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   <li>o - can order on attributes (optional)</li>
   *   </ul>
   * @return List&lt;ModelCase&gt;
   */
  @RequestLine("GET /API/bpm/case?p={p}&c={c}&f={f}&o={o}")
  @Headers({
  "Accept: application/json",
  })
  List<ModelCase> findCases(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findCases</code> method in a fluent style.
   */
  public static class FindCasesQueryParams extends HashMap<String, Object> {
    public FindCasesQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public FindCasesQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public FindCasesQueryParams f(final String value) {
      put("f", EncodingUtils.encode(value));
      return this;
    }
    public FindCasesQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Finds the Case by ID
   * Returns the single Case for the given ID 
   * @param id ID of the Case to return (required)
   * @param n Count of related resources (optional)
   * @return ModelCase
   */
  @RequestLine("GET /API/bpm/case/{id}?n={n}")
  @Headers({
    "Accept: application/json",
  })
  ModelCase getCaseById(@Param("id") String id, @Param("n") String n);

  /**
   * Finds the Case by ID
   * Returns the single Case for the given ID 
   * Note, this is equivalent to the other <code>getCaseById</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetCaseByIdQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param id ID of the Case to return (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>n - Count of related resources (optional)</li>
   *   </ul>
   * @return ModelCase
   */
  @RequestLine("GET /API/bpm/case/{id}?n={n}")
  @Headers({
  "Accept: application/json",
  })
  ModelCase getCaseById(@Param("id") String id, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>getCaseById</code> method in a fluent style.
   */
  public static class GetCaseByIdQueryParams extends HashMap<String, Object> {
    public GetCaseByIdQueryParams n(final String value) {
      put("n", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Finds the Context by Case ID
   * Returns the Context for the given Case ID 
   * @param id ID of the Case that has the Context to return (required)
   * @return Map&lt;String, Object&gt;
   */
  @RequestLine("GET /API/bpm/case/{id}/context")
  @Headers({
    "Accept: application/json",
  })
  Map<String, Object> getContextByCaseId(@Param("id") String id);
}
