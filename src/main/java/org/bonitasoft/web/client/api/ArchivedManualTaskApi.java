package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ArchivedManualTask;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ArchivedManualTaskApi extends ApiClient.Api {

	/**
	 * Finds the ArchivedManualTask by ID Returns the single ArchivedManualTask for the
	 * given ID
	 * @param id ID of the ArchivedManualTask to return (required)
	 * @return ArchivedManualTask
	 */
	@RequestLine("GET /API/bpm/archivedManualTask/{id}")
	@Headers({ "Accept: application/json", })
	ArchivedManualTask getArchivedManualTaskById(@Param("id") String id);

	/**
	 * Finds ArchivedManualTasks Finds ArchivedManualTasks with pagination params and
	 * filters You can filter on: * &#x60;assigned_id&#x3D;{user_id}&#x60;: retrieve only
	 * the human tasks assigned to the specified ID. For example, retrieve the human tasks
	 * assigned to user with id 2:
	 * &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;assigned_id%3d2&#x60;
	 * * &#x60;state&#x3D;&#x60;: retrieve only the archived user tasks with the specified
	 * state. For example, retrieve the skipped tasks:
	 * &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;state&#x3D;skipped&#x60;
	 * * &#x60;name&#x3D;&#x60;: retrieve only the human tasks with the specified name.
	 * For example, retrieve the human tasks with the name \&quot;Analyse
	 * ProcessInstance\&quot;:
	 * &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;name&#x3D;Analyse
	 * ProcessInstance&#x60; * &#x60;displayName&#x3D;&#x60;: retrieve only the archived
	 * user tasks with the specified displayName. For example, retrieve the human tasks
	 * with the displayName \&quot;Analyse ProcessInstance\&quot;:
	 * &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;displayName&#x3D;Analyse
	 * ProcessInstance&#x60;
	 * @param p index of the page to display (required)
	 * @param c maximum number of elements to retrieve (required)
	 * @param f can filter on attributes with the format
	 * f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url
	 * encoded string. (optional)
	 * @param o can order on attributes (optional)
	 * @return List&lt;ArchivedManualTask&gt;
	 */
	@RequestLine("GET /API/bpm/archivedManualTask?p={p}&c={c}&f={f}&o={o}")
	@Headers({ "Accept: application/json", })
	List<ArchivedManualTask> searchArchivedManualTasks(@Param("p") Integer p, @Param("c") Integer c,
			@Param("f") List<String> f, @Param("o") String o);

	/**
	 * Finds ArchivedManualTasks Finds ArchivedManualTasks with pagination params and
	 * filters You can filter on: * &#x60;assigned_id&#x3D;{user_id}&#x60;: retrieve only
	 * the human tasks assigned to the specified ID. For example, retrieve the human tasks
	 * assigned to user with id 2:
	 * &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;assigned_id%3d2&#x60;
	 * * &#x60;state&#x3D;&#x60;: retrieve only the archived user tasks with the specified
	 * state. For example, retrieve the skipped tasks:
	 * &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;state&#x3D;skipped&#x60;
	 * * &#x60;name&#x3D;&#x60;: retrieve only the human tasks with the specified name.
	 * For example, retrieve the human tasks with the name \&quot;Analyse
	 * ProcessInstance\&quot;:
	 * &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;name&#x3D;Analyse
	 * ProcessInstance&#x60; * &#x60;displayName&#x3D;&#x60;: retrieve only the archived
	 * user tasks with the specified displayName. For example, retrieve the human tasks
	 * with the displayName \&quot;Analyse ProcessInstance\&quot;:
	 * &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;displayName&#x3D;Analyse
	 * ProcessInstance&#x60; Note, this is equivalent to the other
	 * <code>searchArchivedManualTasks
	 * </code> method, but with the query parameters collected into a single Map
	 * parameter. This is convenient for services with optional query parameters,
	 * especially when used with the {@link SearchArchivedManualTasksQueryParams} class
	 * that allows for building up this map in a fluent style.
	 * @param queryParams Map of query parameters as name-value pairs
	 * <p>
	 * The following elements may be specified in the query map:
	 * <ul>
	 * <li>p - index of the page to display (required)
	 * <li>c - maximum number of elements to retrieve (required)
	 * <li>f - can filter on attributes with the format
	 * f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url
	 * encoded string. (optional)
	 * <li>o - can order on attributes (optional)
	 * </ul>
	 * @return List&lt;ArchivedManualTask&gt;
	 */
	@RequestLine("GET /API/bpm/archivedManualTask?p={p}&c={c}&f={f}&o={o}")
	@Headers({ "Accept: application/json", })
	List<ArchivedManualTask> searchArchivedManualTasks(@QueryMap(encoded = true) Map<String, Object> queryParams);

	/**
	 * A convenience class for generating query parameters for the
	 * <code>searchArchivedManualTasks
	 * </code> method in a fluent style.
	 */
	class SearchArchivedManualTasksQueryParams extends HashMap<String, Object> {

		public SearchArchivedManualTasksQueryParams p(final Integer value) {
			put("p", EncodingUtils.encode(value));
			return this;
		}

		public SearchArchivedManualTasksQueryParams c(final Integer value) {
			put("c", EncodingUtils.encode(value));
			return this;
		}

		public SearchArchivedManualTasksQueryParams f(final List<String> value) {
			put("f", EncodingUtils.encodeCollection(value, "multi"));
			return this;
		}

		public SearchArchivedManualTasksQueryParams o(final String value) {
			put("o", EncodingUtils.encode(value));
			return this;
		}

	}

}
