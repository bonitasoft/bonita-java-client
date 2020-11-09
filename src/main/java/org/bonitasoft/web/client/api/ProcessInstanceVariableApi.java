package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;

import org.bonitasoft.web.client.model.Error;
import org.bonitasoft.web.client.model.ProcessInstanceVariable;
import org.bonitasoft.web.client.model.ProcessInstanceVariableUpdateRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface ProcessInstanceVariableApi extends ApiClient.Api {


  /**
   * Finds the Variable by ProcessInstance ID
   * Returns the single Variable for the given ProcessInstance ID 
   * @param id The identifier of the process instance from which to retrieve the variable (required)
   * @param variableName The name of the variable to retrieve (required)
   * @return ProcessInstanceVariable
   */
  @RequestLine("GET /API/bpm/caseVariable/{id}/{variableName}")
  @Headers({
    "Accept: application/json",
  })
  ProcessInstanceVariable getVariableByProcessInstanceId(@Param("id") String id, @Param("variableName") String variableName);

  /**
   * Finds ProcessInstance Variables
   * Finds ProcessInstance Variables with pagination params and filters 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return List&lt;ProcessInstanceVariable&gt;
   */
  @RequestLine("GET /API/bpm/caseVariable?p={p}&c={c}&f={f}&o={o}")
  @Headers({
    "Accept: application/json",
  })
  List<ProcessInstanceVariable> searchProcessInstanceVariables(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o);

  /**
   * Finds ProcessInstance Variables
   * Finds ProcessInstance Variables with pagination params and filters 
   * Note, this is equivalent to the other <code>searchProcessInstanceVariables</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchProcessInstanceVariablesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   <li>o - can order on attributes (optional)</li>
   *   </ul>
   * @return List&lt;ProcessInstanceVariable&gt;
   */
  @RequestLine("GET /API/bpm/caseVariable?p={p}&c={c}&f={f}&o={o}")
  @Headers({
  "Accept: application/json",
  })
  List<ProcessInstanceVariable> searchProcessInstanceVariables(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>searchProcessInstanceVariables</code> method in a fluent style.
   */
  public static class SearchProcessInstanceVariablesQueryParams extends HashMap<String, Object> {
    public SearchProcessInstanceVariablesQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public SearchProcessInstanceVariablesQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public SearchProcessInstanceVariablesQueryParams f(final List<String> value) {
      put("f", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public SearchProcessInstanceVariablesQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Update a Variable by ProcessInstance ID
   * Update the variable for the given ProcessInstance ID.  **Warning** : only following types are supported for javaTypeclassname: &#x60;java.lang.String&#x60;, &#x60;java.lang.Integer&#x60;, &#x60;java.lang.Double&#x60;, &#x60;java.lang.Long&#x60;, &#x60;java.lang.Boolean&#x60;, &#x60;java.util.Date&#x60; 
   * @param id The identifier of the process instance from which to retrieve the variable (required)
   * @param variableName The name of the variable to retrieve (required)
   * @param processInstanceVariableUpdateRequest Partial ProcessInstance variables description (required)
   */
  @RequestLine("PUT /API/bpm/caseVariable/{id}/{variableName}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateVariableByProcessInstanceId(@Param("id") String id, @Param("variableName") String variableName, ProcessInstanceVariableUpdateRequest processInstanceVariableUpdateRequest);
}
