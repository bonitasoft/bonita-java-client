package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.Contract;
import org.bonitasoft.web.client.model.UserTask;
import org.bonitasoft.web.client.model.UserTaskUpdateRequest;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface UserTaskApi extends ApiClient.Api {

    /**
     * Execute the UserTask Execute the UserTask. In order to execute a task, the task contract values
     * have to be provided.
     *
     * @param id ID of the UserTask to execute (required)
     * @param body A JSON object matching task contract. Execute a task providing correct contract
     *        values. (required)
     * @param assign if true, assign the task to the current user and execute the task (optional)
     */
    @RequestLine("POST /API/bpm/userTask/{id}/execution?assign={assign}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void executeUserTask(
            @Param("id") String id, Map<String, Object> body, @Param("assign") Boolean assign);

    /**
     * Execute the UserTask Execute the UserTask. In order to execute a task, the task contract values
     * have to be provided. Note, this is equivalent to the other <code>executeUserTask</code> method,
     * but with the query parameters collected into a single Map parameter. This is convenient for
     * services with optional query parameters, especially when used with the {@link
     * ExecuteUserTaskQueryParams} class that allows for building up this map in a fluent style.
     *
     * @param id ID of the UserTask to execute (required)
     * @param body A JSON object matching task contract. Execute a task providing correct contract
     *        values. (required)
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:
     *        <ul>
     *        <li>assign - if true, assign the task to the current user and execute the task (optional)
     *        </ul>
     */
    @RequestLine("POST /API/bpm/userTask/{id}/execution?assign={assign}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void executeUserTask(
            @Param("id") String id,
            Map<String, Object> body,
            @QueryMap(encoded = true) Map<String, Object> queryParams);

    /**
     * A convenience class for generating query parameters for the <code>executeUserTask</code> method
     * in a fluent style.
     */
    public static class ExecuteUserTaskQueryParams extends HashMap<String, Object> {

        public ExecuteUserTaskQueryParams assign(final Boolean value) {
            put("assign", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Finds the Context by UserTask ID Returns the Context for the given UserTask ID
     *
     * @param id ID of the UserTask that has the Context to return (required)
     * @return Map&lt;String, Object&gt;
     */
    @RequestLine("GET /API/bpm/userTask/{id}/context")
    @Headers({
            "Accept: application/json",
    })
    Map<String, Object> getContextByUserTaskId(@Param("id") String id);

    /**
     * Finds the Contract by UserTask ID Returns the Contract for the given UserTask ID
     *
     * @param id ID of the UserTask that has the Contract to return (required)
     * @return Contract
     */
    @RequestLine("GET /API/bpm/userTask/{id}/contract")
    @Headers({
            "Accept: application/json",
    })
    Contract getContractByUserTaskId(@Param("id") String id);

    /**
     * Finds the UserTask by ID Returns the single UserTask for the given ID
     *
     * @param id ID of the UserTask to return (required)
     * @return UserTask
     */
    @RequestLine("GET /API/bpm/userTask/{id}")
    @Headers({
            "Accept: application/json",
    })
    UserTask getUserTaskById(@Param("id") String id);

    /**
     * Finds UserTasks Finds UserTasks with pagination params and filters - can order on
     * &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60;
     *
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value}
     *        with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return List&lt;UserTask&gt;
     */
    @RequestLine("GET /API/bpm/userTask?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<UserTask> searchUserTasks(
            @Param("p") Integer p,
            @Param("c") Integer c,
            @Param("f") List<String> f,
            @Param("o") String o,
            @Param("s") String s);

    /**
     * Finds UserTasks Finds UserTasks with pagination params and filters - can order on
     * &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60;
     * Note, this is equivalent to the other <code>searchUserTasks</code> method, but with the query
     * parameters collected into a single Map parameter. This is convenient for services with optional
     * query parameters, especially when used with the {@link SearchUserTasksQueryParams} class that
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
     *        <li>s - can search on attributes (optional)
     *        </ul>
     * @return List&lt;UserTask&gt;
     */
    @RequestLine("GET /API/bpm/userTask?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<UserTask> searchUserTasks(@QueryMap(encoded = true) Map<String, Object> queryParams);

    /**
     * A convenience class for generating query parameters for the <code>searchUserTasks</code> method
     * in a fluent style.
     */
    public static class SearchUserTasksQueryParams extends HashMap<String, Object> {

        public SearchUserTasksQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchUserTasksQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchUserTasksQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }

        public SearchUserTasksQueryParams o(final String value) {
            put("o", EncodingUtils.encode(value));
            return this;
        }

        public SearchUserTasksQueryParams s(final String value) {
            put("s", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Update the UserTask by ID Update the UserTask for the given ID. Fields that can be updated are
     * &#x60;assigned_id&#x60; and &#x60;state&#x60;. The only value that can be set for the state is
     * &#x60;skipped&#x60;. You only need to specify the fields that are to be updated.
     *
     * @param id ID of the UserTask to return (required)
     * @param userTaskUpdateRequest Partial UserTask description (required)
     */
    @RequestLine("PUT /API/bpm/userTask/{id}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void updateUserTaskById(@Param("id") String id, UserTaskUpdateRequest userTaskUpdateRequest);
}
