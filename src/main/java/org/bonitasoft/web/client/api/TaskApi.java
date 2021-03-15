package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.Task;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface TaskApi extends ApiClient.Api {

    /**
     * Finds the Task by ID Returns the single Task for the given ID
     *
     * @param id ID of the Task to return (required)
     * @return Task
     */
    @RequestLine("GET /API/bpm/task/{id}")
    @Headers({
            "Accept: application/json",
    })
    Task getTaskById(@Param("id") String id);

    /**
     * Finds Tasks Finds Tasks with pagination params and filters - can order on &#x60;caseId&#x60;,
     * &#x60;processId&#x60;, &#x60;state&#x60;, &#x60;type&#x60;, &#x60;supervisor_id&#x60;,
     * &#x60;last_update_date&#x60; - can filter on &#x60;caseId&#x60;, &#x60;processId&#x60;,
     * &#x60;state&#x60;, &#x60;type&#x60;, &#x60;supervisor_id&#x60;, &#x60;last_update_date&#x60;
     *
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value}
     *        with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @return List&lt;Task&gt;
     */
    @RequestLine("GET /API/bpm/task?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    List<Task> searchTasks(
            @Param("p") Integer p,
            @Param("c") Integer c,
            @Param("f") List<String> f,
            @Param("o") String o);

    /**
     * Finds Tasks Finds Tasks with pagination params and filters - can order on &#x60;caseId&#x60;,
     * &#x60;processId&#x60;, &#x60;state&#x60;, &#x60;type&#x60;, &#x60;supervisor_id&#x60;,
     * &#x60;last_update_date&#x60; - can filter on &#x60;caseId&#x60;, &#x60;processId&#x60;,
     * &#x60;state&#x60;, &#x60;type&#x60;, &#x60;supervisor_id&#x60;, &#x60;last_update_date&#x60;
     * Note, this is equivalent to the other <code>searchTasks</code> method, but with the query
     * parameters collected into a single Map parameter. This is convenient for services with optional
     * query parameters, especially when used with the {@link SearchTasksQueryParams} class that
     * allows for building up this map in a fluent style.
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
     * @return List&lt;Task&gt;
     */
    @RequestLine("GET /API/bpm/task?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    List<Task> searchTasks(@QueryMap(encoded = true) Map<String, Object> queryParams);

    /**
     * A convenience class for generating query parameters for the <code>searchTasks</code> method in
     * a fluent style.
     */
    public static class SearchTasksQueryParams extends HashMap<String, Object> {

        public SearchTasksQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchTasksQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchTasksQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }

        public SearchTasksQueryParams o(final String value) {
            put("o", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Update the Task by ID Update the Task for the given ID
     *
     * @param id ID of the Task to return (required)
     * @param requestBody Task fields to update (forbidden fields are : &#x60;caseId&#x60;,
     *        &#x60;processId&#x60;, &#x60;name&#x60;, &#x60;executedBy&#x60;, &#x60;type&#x60;,
     *        &#x60;id&#x60;, &#x60;reached_state_date&#x60;, &#x60;last_update_date&#x60;) (required)
     */
    @RequestLine("PUT /API/bpm/task/{id}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void updateTaskById(@Param("id") String id, Map<String, Object> requestBody);
}
