package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;

import org.bonitasoft.web.client.model.CaseVariable;
import org.bonitasoft.web.client.model.CaseVariableUpdateRequest;
import org.bonitasoft.web.client.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface CaseVariableApi extends ApiClient.Api {


  /**
   * Finds the Variable by Case ID
   * Returns the single Variable for the given Case ID 
   * @param id The identifier of the case from which to retrieve the variable (required)
   * @param variableName The name of the variable to retrieve (required)
   * @return CaseVariable
   */
  @RequestLine("GET /API/bpm/caseVariable/{id}/{variableName}")
  @Headers({
    "Accept: application/json",
  })
  CaseVariable getVariableByCaseId(@Param("id") String id, @Param("variableName") String variableName);

  /**
   * Finds Case Variables
   * Finds Case Variables with pagination params and filters 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return List&lt;CaseVariable&gt;
   */
  @RequestLine("GET /API/bpm/caseVariable?p={p}&c={c}&f={f}&o={o}")
  @Headers({
    "Accept: application/json",
  })
  List<CaseVariable> searchCaseVariables(@Param("p") Integer p, @Param("c") Integer c, @Param("f") String f, @Param("o") String o);

  /**
   * Finds Case Variables
   * Finds Case Variables with pagination params and filters 
   * Note, this is equivalent to the other <code>searchCaseVariables</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchCaseVariablesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   <li>o - can order on attributes (optional)</li>
   *   </ul>
   * @return List&lt;CaseVariable&gt;
   */
  @RequestLine("GET /API/bpm/caseVariable?p={p}&c={c}&f={f}&o={o}")
  @Headers({
  "Accept: application/json",
  })
  List<CaseVariable> searchCaseVariables(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>searchCaseVariables</code> method in a fluent style.
   */
  public static class SearchCaseVariablesQueryParams extends HashMap<String, Object> {
    public SearchCaseVariablesQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public SearchCaseVariablesQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public SearchCaseVariablesQueryParams f(final String value) {
      put("f", EncodingUtils.encode(value));
      return this;
    }
    public SearchCaseVariablesQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Update a Variable by Case ID
   * Update the variable for the given Case ID.  **Warning** : only following types are supported for javaTypeclassname: &#x60;java.lang.String&#x60;, &#x60;java.lang.Integer&#x60;, &#x60;java.lang.Double&#x60;, &#x60;java.lang.Long&#x60;, &#x60;java.lang.Boolean&#x60;, &#x60;java.util.Date&#x60; 
   * @param id The identifier of the case from which to retrieve the variable (required)
   * @param variableName The name of the variable to retrieve (required)
   * @param caseVariableUpdateRequest Partial XXX description (required)
   */
  @RequestLine("PUT /API/bpm/caseVariable/{id}/{variableName}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateVariableByCaseId(@Param("id") String id, @Param("variableName") String variableName, CaseVariableUpdateRequest caseVariableUpdateRequest);
}
