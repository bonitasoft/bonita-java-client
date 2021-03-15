package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ProcessInstance;
import org.bonitasoft.web.client.model.ProcessInstanceCreateRequest;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ProcessInstanceApi extends ApiClient.Api {

    /**
     * Create the ProcessInstance ![edition](https://img.shields.io/badge/edition-entreprise-blue)
     * ![edition](https://img.shields.io/badge/edition-community-brightgreen) Create the
     * ProcessInstance This way of creating a process instance using this method will only work for
     * processes in which no contract is defined. To instantiate a process with a contract, check the
     * process instantiation resource documentation.
     *
     * @param body **Warning**: The attribute &#x60;variables&#x60; on the request payload is used to
     *        initialize the process variables (not BDM variables). If you want to initialize BDM
     *        variables at process instantiation, add a contract on the process and map BDM variables to
     *        the contract data. See Start a process using an instantiation contract for usage.
     *        (required)
     * @return ProcessInstance
     */
    @RequestLine("POST /API/bpm/case")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ProcessInstance createProcessInstance(ProcessInstanceCreateRequest body);

    /**
     * Delete the ProcessInstance by ID Delete the single ProcessInstance for the given ID
     *
     * @param id ID of the ProcessInstance to delete (required)
     */
    @RequestLine("DELETE /API/bpm/case/{id}")
    @Headers({
            "Accept: application/json",
    })
    void deleteProcessInstanceById(@Param("id") String id);

    /**
     * Delete the ProcessInstance by batch
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue)
     * ![edition](https://img.shields.io/badge/edition-community-brightgreen) Delete a list of
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
     * Finds the Context by ProcessInstance ID Returns the Context for the given ProcessInstance ID
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
     * Finds the ProcessInstance by ID Returns the single ProcessInstance for the given ID
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
     * Finds the ProcessInstance by ID Returns the single ProcessInstance for the given ID Note, this
     * is equivalent to the other <code>getProcessInstanceById</code> method, but with the query
     * parameters collected into a single Map parameter. This is convenient for services with optional
     * query parameters, especially when used with the {@link GetProcessInstanceByIdQueryParams} class
     * that allows for building up this map in a fluent style.
     *
     * @param id ID of the ProcessInstance to return (required)
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:
     *        <ul>
     *        <li>n - Count of related resources (optional)
     *        </ul>
     * @return ProcessInstance
     */
    @RequestLine("GET /API/bpm/case/{id}?n={n}")
    @Headers({
            "Accept: application/json",
    })
    ProcessInstance getProcessInstanceById(
            @Param("id") String id, @QueryMap(encoded = true) Map<String, Object> queryParams);

    /**
     * A convenience class for generating query parameters for the <code>getProcessInstanceById</code>
     * method in a fluent style.
     */
    public static class GetProcessInstanceByIdQueryParams extends HashMap<String, Object> {

        public GetProcessInstanceByIdQueryParams n(final String value) {
            put("n", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Finds ProcessInstances Finds ProcessInstances with pagination params and filters You can filter
     * on: * &#x60;processDefinitionId&#x60;: The process derfinition ID * &#x60;name&#x60;: the
     * process name * &#x60;started_by&#x60;: the ID of the user who started the process *
     * &#x60;team_manager_id&#x60;: allow to retrieve the process instances in which all users with
     * this manager ID ar involved) * &#x60;supervisor_id&#x60;: allow the retrived the process
     * instances of all processes the user with this ID is supervisor of) beware you cannot use
     * team_manager_id and supervisor_id at the same time
     *
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value}
     *        with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @return List&lt;ProcessInstance&gt;
     */
    @RequestLine("GET /API/bpm/case?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    List<ProcessInstance> searchProcessInstances(
            @Param("p") Integer p,
            @Param("c") Integer c,
            @Param("f") List<String> f,
            @Param("o") String o);

    /**
     * Finds ProcessInstances Finds ProcessInstances with pagination params and filters You can filter
     * on: * &#x60;processDefinitionId&#x60;: The process derfinition ID * &#x60;name&#x60;: the
     * process name * &#x60;started_by&#x60;: the ID of the user who started the process *
     * &#x60;team_manager_id&#x60;: allow to retrieve the process instances in which all users with
     * this manager ID ar involved) * &#x60;supervisor_id&#x60;: allow the retrived the process
     * instances of all processes the user with this ID is supervisor of) beware you cannot use
     * team_manager_id and supervisor_id at the same time Note, this is equivalent to the other <code>
     * searchProcessInstances</code> method, but with the query parameters collected into a single Map
     * parameter. This is convenient for services with optional query parameters, especially when used
     * with the {@link SearchProcessInstancesQueryParams} class that allows for building up this map
     * in a fluent style.
     *
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:
     *        <ul>
     *        <li>p - index of the page to display (required)
     *        <li>c - maximum number of elements to retrieve (required)
     *        <li>f - can filter on attributes with the format
     *        f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded
     *        string. (optional)
     *        <li>o - can order on attributes (optional)
     *        </ul>
     * @return List&lt;ProcessInstance&gt;
     */
    @RequestLine("GET /API/bpm/case?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    List<ProcessInstance> searchProcessInstances(
            @QueryMap(encoded = true) Map<String, Object> queryParams);

    /**
     * A convenience class for generating query parameters for the <code>searchProcessInstances</code>
     * method in a fluent style.
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
