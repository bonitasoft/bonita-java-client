package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ArchivedTask;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ArchivedTaskApi extends ApiClient.Api {

	/**
	 * Finds the ArchivedTask by ID Returns the single ArchivedTask for the given ID
	 * @param id ID of the ArchivedTask to return (required)
	 * @return ArchivedTask
	 */
	@RequestLine("GET /API/bpm/archivedTask/{id}")
	@Headers({ "Accept: application/json", })
	ArchivedTask getArchivedTaskById(@Param("id") String id);

	/**
	 * Finds ArchivedTasks Finds ArchivedTasks with pagination params and filters - Can
	 * order on &#x60;caseId&#x60;, &#x60;name&#x60;, &#x60;displayName&#x60;,
	 * &#x60;processId&#x60;, &#x60;state&#x60;, &#x60;type&#x60;,
	 * &#x60;archivedDate&#x60;, &#x60;reached_state_date&#x60;, &#x60;assigned_id&#x60; -
	 * Can filter on &#x60;caseId&#x60;, &#x60;name&#x60;, &#x60;displayName&#x60;,
	 * &#x60;processId&#x60;, &#x60;state&#x60;, &#x60;type&#x60;,
	 * &#x60;archivedDate&#x60;, &#x60;reached_state_date&#x60;, &#x60;assigned_id&#x60;,
	 * &#x60;isTerminal&#x60;
	 * @param p index of the page to display (required)
	 * @param c maximum number of elements to retrieve (required)
	 * @param f can filter on attributes with the format
	 * f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url
	 * encoded string. (optional)
	 * @param o can order on attributes (optional)
	 * @return List&lt;ArchivedTask&gt;
	 */
	@RequestLine("GET /API/bpm/archivedTask?p={p}&c={c}&f={f}&o={o}")
	@Headers({ "Accept: application/json", })
	List<ArchivedTask> searchArchivedTasks(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f,
			@Param("o") String o);

	/**
	 * Finds ArchivedTasks Finds ArchivedTasks with pagination params and filters - Can
	 * order on &#x60;caseId&#x60;, &#x60;name&#x60;, &#x60;displayName&#x60;,
	 * &#x60;processId&#x60;, &#x60;state&#x60;, &#x60;type&#x60;,
	 * &#x60;archivedDate&#x60;, &#x60;reached_state_date&#x60;, &#x60;assigned_id&#x60; -
	 * Can filter on &#x60;caseId&#x60;, &#x60;name&#x60;, &#x60;displayName&#x60;,
	 * &#x60;processId&#x60;, &#x60;state&#x60;, &#x60;type&#x60;,
	 * &#x60;archivedDate&#x60;, &#x60;reached_state_date&#x60;, &#x60;assigned_id&#x60;,
	 * &#x60;isTerminal&#x60; Note, this is equivalent to the other
	 * <code>searchArchivedTasks</code> method, but with the query parameters collected
	 * into a single Map parameter. This is convenient for services with optional query
	 * parameters, especially when used with the {@link SearchArchivedTasksQueryParams}
	 * class that allows for building up this map in a fluent style.
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
	 * @return List&lt;ArchivedTask&gt;
	 */
	@RequestLine("GET /API/bpm/archivedTask?p={p}&c={c}&f={f}&o={o}")
	@Headers({ "Accept: application/json", })
	List<ArchivedTask> searchArchivedTasks(@QueryMap(encoded = true) Map<String, Object> queryParams);

	/**
	 * A convenience class for generating query parameters for the
	 * <code>searchArchivedTasks</code> method in a fluent style.
	 */
	class SearchArchivedTasksQueryParams extends HashMap<String, Object> {

		public SearchArchivedTasksQueryParams p(final Integer value) {
			put("p", EncodingUtils.encode(value));
			return this;
		}

		public SearchArchivedTasksQueryParams c(final Integer value) {
			put("c", EncodingUtils.encode(value));
			return this;
		}

		public SearchArchivedTasksQueryParams f(final List<String> value) {
			put("f", EncodingUtils.encodeCollection(value, "multi"));
			return this;
		}

		public SearchArchivedTasksQueryParams o(final String value) {
			put("o", EncodingUtils.encode(value));
			return this;
		}

	}

}
