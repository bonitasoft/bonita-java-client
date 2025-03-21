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
import java.util.Map;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.ProcessInstance;
import org.bonitasoft.web.client.model.ProcessInstanceCreateRequest;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public interface ProcessInstanceApi extends ApiClient.Api {

    /**
     * Create the ProcessInstance
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) ![edition](https://img.shields.io/badge/edition-community-brightgreen) Create the
     * ProcessInstance This way of creating a process instance using this method will only work for processes in which no contract is defined. To instantiate a
     * process with a contract, check the process instantiation resource documentation.
     * 
     * @param body **Warning**: The attribute &#x60;variables&#x60; on the request payload is used to initialize the process variables (not BDM variables). If you
     *        want to initialize BDM variables at process instantiation, add a contract on the process and map BDM variables to the contract data. See Start a
     *        process using an instantiation contract for usage. (required)
     * @return ProcessInstance
     */
    @RequestLine("POST /API/bpm/case")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ProcessInstance createProcessInstance(ProcessInstanceCreateRequest body);

    /**
     * Create the ProcessInstance
     * Similar to <code>createProcessInstance</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) ![edition](https://img.shields.io/badge/edition-community-brightgreen) Create the
     * ProcessInstance This way of creating a process instance using this method will only work for processes in which no contract is defined. To instantiate a
     * process with a contract, check the process instantiation resource documentation.
     * 
     * @param body **Warning**: The attribute &#x60;variables&#x60; on the request payload is used to initialize the process variables (not BDM variables). If you
     *        want to initialize BDM variables at process instantiation, add a contract on the process and map BDM variables to the contract data. See Start a
     *        process using an instantiation contract for usage. (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("POST /API/bpm/case")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<ProcessInstance> createProcessInstanceWithHttpInfo(ProcessInstanceCreateRequest body);

    /**
     * Delete the ProcessInstance by ID
     * Delete the single ProcessInstance for the given ID
     * 
     * @param id ID of the ProcessInstance to delete (required)
     */
    @RequestLine("DELETE /API/bpm/case/{id}")
    @Headers({
            "Accept: application/json",
    })
    void deleteProcessInstanceById(@Param("id") String id);

    /**
     * Delete the ProcessInstance by ID
     * Similar to <code>deleteProcessInstanceById</code> but it also returns the http response headers .
     * Delete the single ProcessInstance for the given ID
     * 
     * @param id ID of the ProcessInstance to delete (required)
     */
    @RequestLine("DELETE /API/bpm/case/{id}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<Void> deleteProcessInstanceByIdWithHttpInfo(@Param("id") String id);

    /**
     * Delete the ProcessInstance by batch
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) ![edition](https://img.shields.io/badge/edition-community-brightgreen) Delete a list of
     * ProcessInstances for the given IDs
     * 
     * @param requestBody (optional)
     */
    @RequestLine("DELETE /API/bpm/case")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void deleteProcessInstanceByIds(List<String> requestBody);

    /**
     * Delete the ProcessInstance by batch
     * Similar to <code>deleteProcessInstanceByIds</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) ![edition](https://img.shields.io/badge/edition-community-brightgreen) Delete a list of
     * ProcessInstances for the given IDs
     * 
     * @param requestBody (optional)
     */
    @RequestLine("DELETE /API/bpm/case")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<Void> deleteProcessInstanceByIdsWithHttpInfo(List<String> requestBody);

    /**
     * Finds the Context by ProcessInstance ID
     * Returns the Context for the given ProcessInstance ID
     * 
     * @param id ID of the ProcessInstance that has the Context to return (required)
     * @return Map&lt;String, Object&gt;
     */
    @RequestLine("GET /API/bpm/case/{id}/context")
    @Headers({
            "Accept: application/json",
    })
    Map<String, Object> getContextByProcessInstanceId(@Param("id") String id);

    /**
     * Finds the Context by ProcessInstance ID
     * Similar to <code>getContextByProcessInstanceId</code> but it also returns the http response headers .
     * Returns the Context for the given ProcessInstance ID
     * 
     * @param id ID of the ProcessInstance that has the Context to return (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/case/{id}/context")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<Map<String, Object>> getContextByProcessInstanceIdWithHttpInfo(@Param("id") String id);

    /**
     * Finds the ProcessInstance by ID
     * Returns the single ProcessInstance for the given ID
     * 
     * @param id ID of the ProcessInstance to return (required)
     * @param n Count of related resources (optional)
     * @return ProcessInstance
     */
    @RequestLine("GET /API/bpm/case/{id}?n={n}")
    @Headers({
            "Accept: application/json",
    })
    ProcessInstance getProcessInstanceById(@Param("id") String id, @Param("n") String n);

    /**
     * Finds the ProcessInstance by ID
     * Similar to <code>getProcessInstanceById</code> but it also returns the http response headers .
     * Returns the single ProcessInstance for the given ID
     * 
     * @param id ID of the ProcessInstance to return (required)
     * @param n Count of related resources (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/case/{id}?n={n}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<ProcessInstance> getProcessInstanceByIdWithHttpInfo(@Param("id") String id, @Param("n") String n);

    /**
     * Finds the ProcessInstance by ID
     * Returns the single ProcessInstance for the given ID
     * Note, this is equivalent to the other <code>getProcessInstanceById</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link GetProcessInstanceByIdQueryParams} class that allows for
     * building up this map in a fluent style.
     * 
     * @param id ID of the ProcessInstance to return (required)
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>n - Count of related resources (optional)</li>
     *        </ul>
     * @return ProcessInstance
     */
    @RequestLine("GET /API/bpm/case/{id}?n={n}")
    @Headers({
            "Accept: application/json",
    })
    ProcessInstance getProcessInstanceById(@Param("id") String id,
            @QueryMap(encoded = true) GetProcessInstanceByIdQueryParams queryParams);

    /**
     * Finds the ProcessInstance by ID
     * Returns the single ProcessInstance for the given ID
     * Note, this is equivalent to the other <code>getProcessInstanceById</code> that receives the query parameters as a map,
     * but this one also exposes the Http response headers
     * 
     * @param id ID of the ProcessInstance to return (required)
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>n - Count of related resources (optional)</li>
     *        </ul>
     * @return ProcessInstance
     */
    @RequestLine("GET /API/bpm/case/{id}?n={n}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<ProcessInstance> getProcessInstanceByIdWithHttpInfo(@Param("id") String id,
            @QueryMap(encoded = true) GetProcessInstanceByIdQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>getProcessInstanceById</code> method in a fluent style.
     */
    public static class GetProcessInstanceByIdQueryParams extends HashMap<String, Object> {

        public GetProcessInstanceByIdQueryParams n(final String value) {
            put("n", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Finds ProcessInstances
     * Finds ProcessInstances with pagination params and filters You can filter on: * &#x60;processDefinitionId&#x60;: The process definition ID *
     * &#x60;rootCaseId&#x60;: the root process instance ID (since version 10.3 - 2025.1) * &#x60;name&#x60;: the process name * &#x60;started_by&#x60;: the ID of
     * the user who started the process * &#x60;team_manager_id&#x60;: allow to retrieve the process instances in which all users with this manager ID ar involved)
     * * &#x60;supervisor_id&#x60;: allow the retrived the process instances of all processes the user with this ID is supervisor of) beware you cannot use
     * team_manager_id and supervisor_id at the same time * &#x60;searchIndex1Value&#x60;, &#x60;searchIndex2Value&#x60;, &#x60;searchIndex3Value&#x60;,
     * &#x60;searchIndex4Value&#x60;, &#x60;searchIndex5Value&#x60;: the value of the corresponding search index (since version 10.3 - 2025.1)
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @return List&lt;ProcessInstance&gt;
     */
    @RequestLine("GET /API/bpm/case?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    List<ProcessInstance> searchProcessInstances(@Param("p") Integer p, @Param("c") Integer c,
            @Param("f") List<String> f, @Param("o") String o);

    /**
     * Finds ProcessInstances
     * Similar to <code>searchProcessInstances</code> but it also returns the http response headers .
     * Finds ProcessInstances with pagination params and filters You can filter on: * &#x60;processDefinitionId&#x60;: The process definition ID *
     * &#x60;rootCaseId&#x60;: the root process instance ID (since version 10.3 - 2025.1) * &#x60;name&#x60;: the process name * &#x60;started_by&#x60;: the ID of
     * the user who started the process * &#x60;team_manager_id&#x60;: allow to retrieve the process instances in which all users with this manager ID ar involved)
     * * &#x60;supervisor_id&#x60;: allow the retrived the process instances of all processes the user with this ID is supervisor of) beware you cannot use
     * team_manager_id and supervisor_id at the same time * &#x60;searchIndex1Value&#x60;, &#x60;searchIndex2Value&#x60;, &#x60;searchIndex3Value&#x60;,
     * &#x60;searchIndex4Value&#x60;, &#x60;searchIndex5Value&#x60;: the value of the corresponding search index (since version 10.3 - 2025.1)
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/case?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ProcessInstance>> searchProcessInstancesWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c,
            @Param("f") List<String> f, @Param("o") String o);

    /**
     * Finds ProcessInstances
     * Finds ProcessInstances with pagination params and filters You can filter on: * &#x60;processDefinitionId&#x60;: The process definition ID *
     * &#x60;rootCaseId&#x60;: the root process instance ID (since version 10.3 - 2025.1) * &#x60;name&#x60;: the process name * &#x60;started_by&#x60;: the ID of
     * the user who started the process * &#x60;team_manager_id&#x60;: allow to retrieve the process instances in which all users with this manager ID ar involved)
     * * &#x60;supervisor_id&#x60;: allow the retrived the process instances of all processes the user with this ID is supervisor of) beware you cannot use
     * team_manager_id and supervisor_id at the same time * &#x60;searchIndex1Value&#x60;, &#x60;searchIndex2Value&#x60;, &#x60;searchIndex3Value&#x60;,
     * &#x60;searchIndex4Value&#x60;, &#x60;searchIndex5Value&#x60;: the value of the corresponding search index (since version 10.3 - 2025.1)
     * Note, this is equivalent to the other <code>searchProcessInstances</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchProcessInstancesQueryParams} class that allows for
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
     * @return List&lt;ProcessInstance&gt;
     */
    @RequestLine("GET /API/bpm/case?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    List<ProcessInstance> searchProcessInstances(
            @QueryMap(encoded = true) SearchProcessInstancesQueryParams queryParams);

    /**
     * Finds ProcessInstances
     * Finds ProcessInstances with pagination params and filters You can filter on: * &#x60;processDefinitionId&#x60;: The process definition ID *
     * &#x60;rootCaseId&#x60;: the root process instance ID (since version 10.3 - 2025.1) * &#x60;name&#x60;: the process name * &#x60;started_by&#x60;: the ID of
     * the user who started the process * &#x60;team_manager_id&#x60;: allow to retrieve the process instances in which all users with this manager ID ar involved)
     * * &#x60;supervisor_id&#x60;: allow the retrived the process instances of all processes the user with this ID is supervisor of) beware you cannot use
     * team_manager_id and supervisor_id at the same time * &#x60;searchIndex1Value&#x60;, &#x60;searchIndex2Value&#x60;, &#x60;searchIndex3Value&#x60;,
     * &#x60;searchIndex4Value&#x60;, &#x60;searchIndex5Value&#x60;: the value of the corresponding search index (since version 10.3 - 2025.1)
     * Note, this is equivalent to the other <code>searchProcessInstances</code> that receives the query parameters as a map,
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
     * @return List&lt;ProcessInstance&gt;
     */
    @RequestLine("GET /API/bpm/case?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ProcessInstance>> searchProcessInstancesWithHttpInfo(
            @QueryMap(encoded = true) SearchProcessInstancesQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>searchProcessInstances</code> method in a fluent style.
     */
    public static class SearchProcessInstancesQueryParams extends HashMap<String, Object> {

        public SearchProcessInstancesQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchProcessInstancesQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchProcessInstancesQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }

        public SearchProcessInstancesQueryParams o(final String value) {
            put("o", EncodingUtils.encode(value));
            return this;
        }
    }
}
