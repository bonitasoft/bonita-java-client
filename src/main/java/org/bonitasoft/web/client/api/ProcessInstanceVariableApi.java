/** 
 * Copyright (C) 2025 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.List;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.ProcessInstanceVariable;
import org.bonitasoft.web.client.model.ProcessInstanceVariableUpdateRequest;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public interface ProcessInstanceVariableApi extends ApiClient.Api {

    /**
     * Finds the Variable by ProcessInstance ID
     * Returns the single Variable for the given ProcessInstance ID
     * 
     * @param id The identifier of the process instance from which to retrieve the variable (required)
     * @param variableName The name of the variable to retrieve (required)
     * @return ProcessInstanceVariable
     */
    @RequestLine("GET /API/bpm/caseVariable/{id}/{variableName}")
    @Headers({
            "Accept: application/json",
    })
    ProcessInstanceVariable getVariableByProcessInstanceId(@Param("id") String id,
            @Param("variableName") String variableName);

    /**
     * Finds the Variable by ProcessInstance ID
     * Similar to <code>getVariableByProcessInstanceId</code> but it also returns the http response headers .
     * Returns the single Variable for the given ProcessInstance ID
     * 
     * @param id The identifier of the process instance from which to retrieve the variable (required)
     * @param variableName The name of the variable to retrieve (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/caseVariable/{id}/{variableName}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<ProcessInstanceVariable> getVariableByProcessInstanceIdWithHttpInfo(@Param("id") String id,
            @Param("variableName") String variableName);

    /**
     * Finds ProcessInstance Variables
     * Finds ProcessInstance Variables with pagination params and filters
     * 
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
    List<ProcessInstanceVariable> searchProcessInstanceVariables(@Param("p") Integer p, @Param("c") Integer c,
            @Param("f") List<String> f, @Param("o") String o);

    /**
     * Finds ProcessInstance Variables
     * Similar to <code>searchProcessInstanceVariables</code> but it also returns the http response headers .
     * Finds ProcessInstance Variables with pagination params and filters
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/caseVariable?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ProcessInstanceVariable>> searchProcessInstanceVariablesWithHttpInfo(@Param("p") Integer p,
            @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o);

    /**
     * Finds ProcessInstance Variables
     * Finds ProcessInstance Variables with pagination params and filters
     * Note, this is equivalent to the other <code>searchProcessInstanceVariables</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchProcessInstanceVariablesQueryParams} class that allows for
     * building up this map in a fluent style.
     * 
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>p - index of the page to display (required)</li>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string.
     *        (optional)</li>
     *        <li>o - can order on attributes (optional)</li>
     *        </ul>
     * @return List&lt;ProcessInstanceVariable&gt;
     */
    @RequestLine("GET /API/bpm/caseVariable?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    List<ProcessInstanceVariable> searchProcessInstanceVariables(
            @QueryMap(encoded = true) SearchProcessInstanceVariablesQueryParams queryParams);

    /**
     * Finds ProcessInstance Variables
     * Finds ProcessInstance Variables with pagination params and filters
     * Note, this is equivalent to the other <code>searchProcessInstanceVariables</code> that receives the query parameters as a map,
     * but this one also exposes the Http response headers
     * 
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>p - index of the page to display (required)</li>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string.
     *        (optional)</li>
     *        <li>o - can order on attributes (optional)</li>
     *        </ul>
     * @return List&lt;ProcessInstanceVariable&gt;
     */
    @RequestLine("GET /API/bpm/caseVariable?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ProcessInstanceVariable>> searchProcessInstanceVariablesWithHttpInfo(
            @QueryMap(encoded = true) SearchProcessInstanceVariablesQueryParams queryParams);

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
     * Update the variable for the given ProcessInstance ID. **Warning** : only following types are supported for javaTypeclassname: &#x60;java.lang.String&#x60;,
     * &#x60;java.lang.Integer&#x60;, &#x60;java.lang.Double&#x60;, &#x60;java.lang.Long&#x60;, &#x60;java.lang.Boolean&#x60;, &#x60;java.util.Date&#x60;
     * 
     * @param id The identifier of the process instance from which to retrieve the variable (required)
     * @param variableName The name of the variable to retrieve (required)
     * @param processInstanceVariableUpdateRequest Partial ProcessInstance variables description (required)
     */
    @RequestLine("PUT /API/bpm/caseVariable/{id}/{variableName}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void updateVariableByProcessInstanceId(@Param("id") String id, @Param("variableName") String variableName,
            ProcessInstanceVariableUpdateRequest processInstanceVariableUpdateRequest);

    /**
     * Update a Variable by ProcessInstance ID
     * Similar to <code>updateVariableByProcessInstanceId</code> but it also returns the http response headers .
     * Update the variable for the given ProcessInstance ID. **Warning** : only following types are supported for javaTypeclassname: &#x60;java.lang.String&#x60;,
     * &#x60;java.lang.Integer&#x60;, &#x60;java.lang.Double&#x60;, &#x60;java.lang.Long&#x60;, &#x60;java.lang.Boolean&#x60;, &#x60;java.util.Date&#x60;
     * 
     * @param id The identifier of the process instance from which to retrieve the variable (required)
     * @param variableName The name of the variable to retrieve (required)
     * @param processInstanceVariableUpdateRequest Partial ProcessInstance variables description (required)
     */
    @RequestLine("PUT /API/bpm/caseVariable/{id}/{variableName}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<Void> updateVariableByProcessInstanceIdWithHttpInfo(@Param("id") String id,
            @Param("variableName") String variableName,
            ProcessInstanceVariableUpdateRequest processInstanceVariableUpdateRequest);

}
