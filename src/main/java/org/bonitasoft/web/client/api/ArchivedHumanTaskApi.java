package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.ArchivedHumanTask;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ArchivedHumanTaskApi extends ApiClient.Api {


	/**
	 * Finds the ArchivedHumanTask by ID
	 * Returns the single ArchivedHumanTask for the given ID
	 * @param id ID of the ArchivedHumanTask to return (required)
	 * @return ArchivedHumanTask
	 */
	@RequestLine("GET /API/bpm/archivedHumanTask/{id}")
	@Headers({
			"Accept: application/json",
	})
	ArchivedHumanTask getArchivedHumanTaskById(@Param("id") String id);

	/**
	 * Finds the ArchivedHumanTask by ID
	 * Similar to <code>getArchivedHumanTaskById</code> but it also returns the http response headers .
	 * Returns the single ArchivedHumanTask for the given ID
	 * @param id ID of the ArchivedHumanTask to return (required)
	 * @return A ApiResponse that wraps the response boyd and the http headers.
	 */
	@RequestLine("GET /API/bpm/archivedHumanTask/{id}")
	@Headers({
			"Accept: application/json",
	})
	ApiResponse<ArchivedHumanTask> getArchivedHumanTaskByIdWithHttpInfo(@Param("id") String id);


	/**
	 * Finds ArchivedHumanTasks
	 * Finds ArchivedHumanTasks with pagination params and filters  You can filter on:  * &#x60;assigned_id&#x3D;{user_id}&#x60;: retrieve only the human tasks assigned to the specified ID. For example, retrieve the human tasks assigned to user with id 2: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;assigned_id%3d2&#x60; * &#x60;state&#x3D;&#x60;: retrieve only the archived user tasks with the specified state. For example, retrieve the skipped tasks: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;state&#x3D;skipped&#x60; * &#x60;name&#x3D;&#x60;: retrieve only the human tasks with the specified name. For example, retrieve the human tasks with the name \&quot;Analyse ProcessInstance\&quot;: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;name&#x3D;Analyse ProcessInstance&#x60; * &#x60;displayName&#x3D;&#x60;: retrieve only the archived user tasks with the specified displayName. For example, retrieve the human tasks with the displayName \&quot;Analyse ProcessInstance\&quot;: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;displayName&#x3D;Analyse ProcessInstance&#x60;
	 * @param p index of the page to display (required)
	 * @param c maximum number of elements to retrieve (required)
	 * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
	 * @param o can order on attributes (optional)
	 * @return List&lt;ArchivedHumanTask&gt;
	 */
	@RequestLine("GET /API/bpm/archivedHumanTask?p={p}&c={c}&f={f}&o={o}")
	@Headers({
			"Accept: application/json",
	})
	List<ArchivedHumanTask> searchArchivedHumanTasks(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o);

	/**
	 * Finds ArchivedHumanTasks
	 * Similar to <code>searchArchivedHumanTasks</code> but it also returns the http response headers .
	 * Finds ArchivedHumanTasks with pagination params and filters  You can filter on:  * &#x60;assigned_id&#x3D;{user_id}&#x60;: retrieve only the human tasks assigned to the specified ID. For example, retrieve the human tasks assigned to user with id 2: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;assigned_id%3d2&#x60; * &#x60;state&#x3D;&#x60;: retrieve only the archived user tasks with the specified state. For example, retrieve the skipped tasks: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;state&#x3D;skipped&#x60; * &#x60;name&#x3D;&#x60;: retrieve only the human tasks with the specified name. For example, retrieve the human tasks with the name \&quot;Analyse ProcessInstance\&quot;: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;name&#x3D;Analyse ProcessInstance&#x60; * &#x60;displayName&#x3D;&#x60;: retrieve only the archived user tasks with the specified displayName. For example, retrieve the human tasks with the displayName \&quot;Analyse ProcessInstance\&quot;: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;displayName&#x3D;Analyse ProcessInstance&#x60;
	 * @param p index of the page to display (required)
	 * @param c maximum number of elements to retrieve (required)
	 * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
	 * @param o can order on attributes (optional)
	 * @return A ApiResponse that wraps the response boyd and the http headers.
	 */
	@RequestLine("GET /API/bpm/archivedHumanTask?p={p}&c={c}&f={f}&o={o}")
	@Headers({
			"Accept: application/json",
	})
	ApiResponse<List<ArchivedHumanTask>> searchArchivedHumanTasksWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o);


	/**
	 * Finds ArchivedHumanTasks
	 * Finds ArchivedHumanTasks with pagination params and filters  You can filter on:  * &#x60;assigned_id&#x3D;{user_id}&#x60;: retrieve only the human tasks assigned to the specified ID. For example, retrieve the human tasks assigned to user with id 2: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;assigned_id%3d2&#x60; * &#x60;state&#x3D;&#x60;: retrieve only the archived user tasks with the specified state. For example, retrieve the skipped tasks: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;state&#x3D;skipped&#x60; * &#x60;name&#x3D;&#x60;: retrieve only the human tasks with the specified name. For example, retrieve the human tasks with the name \&quot;Analyse ProcessInstance\&quot;: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;name&#x3D;Analyse ProcessInstance&#x60; * &#x60;displayName&#x3D;&#x60;: retrieve only the archived user tasks with the specified displayName. For example, retrieve the human tasks with the displayName \&quot;Analyse ProcessInstance\&quot;: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;displayName&#x3D;Analyse ProcessInstance&#x60;
	 * Note, this is equivalent to the other <code>searchArchivedHumanTasks</code> method,
	 * but with the query parameters collected into a single Map parameter. This
	 * is convenient for services with optional query parameters, especially when
	 * used with the {@link SearchArchivedHumanTasksQueryParams} class that allows for
	 * building up this map in a fluent style.
	 * @param queryParams Map of query parameters as name-value pairs
	 *   <p>The following elements may be specified in the query map:</p>
	 *   <ul>
	 *   <li>p - index of the page to display (required)</li>
	 *   <li>c - maximum number of elements to retrieve (required)</li>
	 *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
	 *   <li>o - can order on attributes (optional)</li>
	 *   </ul>
	 * @return List&lt;ArchivedHumanTask&gt;
	 */
	@RequestLine("GET /API/bpm/archivedHumanTask?p={p}&c={c}&f={f}&o={o}")
	@Headers({
			"Accept: application/json",
	})
	List<ArchivedHumanTask> searchArchivedHumanTasks(@QueryMap(encoded = true) Map<String, Object> queryParams);

	/**
	 * Finds ArchivedHumanTasks
	 * Finds ArchivedHumanTasks with pagination params and filters  You can filter on:  * &#x60;assigned_id&#x3D;{user_id}&#x60;: retrieve only the human tasks assigned to the specified ID. For example, retrieve the human tasks assigned to user with id 2: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;assigned_id%3d2&#x60; * &#x60;state&#x3D;&#x60;: retrieve only the archived user tasks with the specified state. For example, retrieve the skipped tasks: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;state&#x3D;skipped&#x60; * &#x60;name&#x3D;&#x60;: retrieve only the human tasks with the specified name. For example, retrieve the human tasks with the name \&quot;Analyse ProcessInstance\&quot;: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;name&#x3D;Analyse ProcessInstance&#x60; * &#x60;displayName&#x3D;&#x60;: retrieve only the archived user tasks with the specified displayName. For example, retrieve the human tasks with the displayName \&quot;Analyse ProcessInstance\&quot;: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;displayName&#x3D;Analyse ProcessInstance&#x60;
	 * Note, this is equivalent to the other <code>searchArchivedHumanTasks</code> that receives the query parameters as a map,
	 * but this one also exposes the Http response headers
	 * @param queryParams Map of query parameters as name-value pairs
	 *   <p>The following elements may be specified in the query map:</p>
	 *   <ul>
	 *   <li>p - index of the page to display (required)</li>
	 *   <li>c - maximum number of elements to retrieve (required)</li>
	 *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
	 *   <li>o - can order on attributes (optional)</li>
	 *   </ul>
	 * @return List&lt;ArchivedHumanTask&gt;
	 */
	@RequestLine("GET /API/bpm/archivedHumanTask?p={p}&c={c}&f={f}&o={o}")
	@Headers({
			"Accept: application/json",
	})
	ApiResponse<List<ArchivedHumanTask>> searchArchivedHumanTasksWithHttpInfo(@QueryMap(encoded = true) Map<String, Object> queryParams);


	/**
	 * A convenience class for generating query parameters for the
	 * <code>searchArchivedHumanTasks</code> method in a fluent style.
	 */
	public static class SearchArchivedHumanTasksQueryParams extends HashMap<String, Object> {
		public SearchArchivedHumanTasksQueryParams p(final Integer value) {
			put("p", EncodingUtils.encode(value));
			return this;
		}

		public SearchArchivedHumanTasksQueryParams c(final Integer value) {
			put("c", EncodingUtils.encode(value));
			return this;
		}

		public SearchArchivedHumanTasksQueryParams f(final List<String> value) {
			put("f", EncodingUtils.encodeCollection(value, "multi"));
			return this;
		}

		public SearchArchivedHumanTasksQueryParams o(final String value) {
			put("o", EncodingUtils.encode(value));
			return this;
		}
	}
}
