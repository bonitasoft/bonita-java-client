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
import org.bonitasoft.web.client.model.ArchivedProcessInstanceVariable;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public interface ArchivedProcessInstanceVariableApi extends ApiClient.Api {

    /**
     * Finds ArchivedProcessInstance Variables
     * Since 2022.1 Finds ArchivedProcessInstance Variables with pagination params and filters
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f Filter for the case id before it was archived (eg: case_id&#x3D;10001 ) (required)
     * @return List&lt;ArchivedProcessInstanceVariable&gt;
     */
    @RequestLine("GET /API/bpm/archivedCaseVariable?p={p}&c={c}&f={f}")
    @Headers({
            "Accept: application/json",
    })
    List<ArchivedProcessInstanceVariable> getArchivedProcessInstanceVariables(@Param("p") Integer p,
            @Param("c") Integer c, @Param("f") String f);

    /**
     * Finds ArchivedProcessInstance Variables
     * Similar to <code>getArchivedProcessInstanceVariables</code> but it also returns the http response headers .
     * Since 2022.1 Finds ArchivedProcessInstance Variables with pagination params and filters
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f Filter for the case id before it was archived (eg: case_id&#x3D;10001 ) (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/archivedCaseVariable?p={p}&c={c}&f={f}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ArchivedProcessInstanceVariable>> getArchivedProcessInstanceVariablesWithHttpInfo(
            @Param("p") Integer p, @Param("c") Integer c, @Param("f") String f);

    /**
     * Finds ArchivedProcessInstance Variables
     * Since 2022.1 Finds ArchivedProcessInstance Variables with pagination params and filters
     * Note, this is equivalent to the other <code>getArchivedProcessInstanceVariables</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link GetArchivedProcessInstanceVariablesQueryParams} class that allows for
     * building up this map in a fluent style.
     * 
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>p - index of the page to display (required)</li>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        <li>f - Filter for the case id before it was archived (eg: case_id&#x3D;10001 ) (required)</li>
     *        </ul>
     * @return List&lt;ArchivedProcessInstanceVariable&gt;
     */
    @RequestLine("GET /API/bpm/archivedCaseVariable?p={p}&c={c}&f={f}")
    @Headers({
            "Accept: application/json",
    })
    List<ArchivedProcessInstanceVariable> getArchivedProcessInstanceVariables(
            @QueryMap(encoded = true) GetArchivedProcessInstanceVariablesQueryParams queryParams);

    /**
     * Finds ArchivedProcessInstance Variables
     * Since 2022.1 Finds ArchivedProcessInstance Variables with pagination params and filters
     * Note, this is equivalent to the other <code>getArchivedProcessInstanceVariables</code> that receives the query parameters as a map,
     * but this one also exposes the Http response headers
     * 
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>p - index of the page to display (required)</li>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        <li>f - Filter for the case id before it was archived (eg: case_id&#x3D;10001 ) (required)</li>
     *        </ul>
     * @return List&lt;ArchivedProcessInstanceVariable&gt;
     */
    @RequestLine("GET /API/bpm/archivedCaseVariable?p={p}&c={c}&f={f}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ArchivedProcessInstanceVariable>> getArchivedProcessInstanceVariablesWithHttpInfo(
            @QueryMap(encoded = true) GetArchivedProcessInstanceVariablesQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>getArchivedProcessInstanceVariables</code> method in a fluent style.
     */
    public static class GetArchivedProcessInstanceVariablesQueryParams extends HashMap<String, Object> {

        public GetArchivedProcessInstanceVariablesQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public GetArchivedProcessInstanceVariablesQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public GetArchivedProcessInstanceVariablesQueryParams f(final String value) {
            put("f", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Finds an archived Variable by ProcessInstance ID and variable name
     * Since 2022.1 Returns the single ArchivedProcessInstanceVariable for the given ProcessInstance ID and variable name
     * 
     * @param id The identifier of the process instance from which to retrieve the archived variable (required)
     * @param variableName The name of the archived variable to retrieve (required)
     * @return ArchivedProcessInstanceVariable
     */
    @RequestLine("GET /API/bpm/archivedCaseVariable/{id}/{variableName}")
    @Headers({
            "Accept: application/json",
    })
    ArchivedProcessInstanceVariable getArchivedVariableByProcessInstance(@Param("id") String id,
            @Param("variableName") String variableName);

    /**
     * Finds an archived Variable by ProcessInstance ID and variable name
     * Similar to <code>getArchivedVariableByProcessInstance</code> but it also returns the http response headers .
     * Since 2022.1 Returns the single ArchivedProcessInstanceVariable for the given ProcessInstance ID and variable name
     * 
     * @param id The identifier of the process instance from which to retrieve the archived variable (required)
     * @param variableName The name of the archived variable to retrieve (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/archivedCaseVariable/{id}/{variableName}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<ArchivedProcessInstanceVariable> getArchivedVariableByProcessInstanceWithHttpInfo(
            @Param("id") String id, @Param("variableName") String variableName);

}
