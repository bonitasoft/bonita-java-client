package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ProcessSupervisor;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ProcessSupervisorApi extends ApiClient.Api {

	/**
	 * Create the ProcessSupervisor Create the ProcessSupervisor
	 * @param body The process definition id and either the user, role and/or group id.
	 * (required)
	 * @return ProcessSupervisor
	 */
	@RequestLine("POST /API/bpm/processSupervisor")
	@Headers({ "Content-Type: application/json", "Accept: application/json", })
	ProcessSupervisor createProcessSupervisor(ProcessSupervisor body);

	/**
	 * Delete the ProcessSupervisor by ID Delete the ProcessSupervisor for the given
	 * compoound IDs You can delete a process supervisor by specifying its compound Id in
	 * the body of the request with the following format:
	 * &#x60;process_id/user_id/role_id/group_id&#x60;
	 * @param requestBody The process definition id and either the user, role and/or group
	 * id. (required)
	 */
	@RequestLine("DELETE /API/bpm/processSupervisor")
	@Headers({ "Content-Type: application/json", "Accept: application/json", })
	void deleteProcessSupervisorById(List<String> requestBody);

	/**
	 * Finds ProcessSupervisors Finds ProcessSupervisors with pagination params and
	 * filters To filter, you need to specify the &#x60;process_id&#x60;, and then the
	 * &#x60;user_id&#x60;, &#x60;group_id&#x60; and &#x60;role_id&#x60; with one of them
	 * (two if you want to filter on group and role) set to &#x60;&gt;0&#x60; and the
	 * other ones set to &#x60;-1&#x60;. E.g.:
	 * &#x60;f&#x3D;process_id%3D8040901857674754544&amp;f&#x3D;user_id%3D&gt;0&amp;f&#x3D;group_id%3D-1&amp;f&#x3D;role_id%3D-1&#x60;
	 * @param p index of the page to display (required)
	 * @param c maximum number of elements to retrieve (required)
	 * @param f can filter on attributes with the format
	 * f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url
	 * encoded string. (optional)
	 * @param o can order on attributes (optional)
	 * @param s can search on attributes (optional)
	 * @return List&lt;ProcessSupervisor&gt;
	 */
	@RequestLine("GET /API/bpm/processSupervisor?p={p}&c={c}&f={f}&o={o}&s={s}")
	@Headers({ "Accept: application/json", })
	List<ProcessSupervisor> searchProcessSupervisors(@Param("p") Integer p, @Param("c") Integer c,
			@Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

	/**
	 * Finds ProcessSupervisors Finds ProcessSupervisors with pagination params and
	 * filters To filter, you need to specify the &#x60;process_id&#x60;, and then the
	 * &#x60;user_id&#x60;, &#x60;group_id&#x60; and &#x60;role_id&#x60; with one of them
	 * (two if you want to filter on group and role) set to &#x60;&gt;0&#x60; and the
	 * other ones set to &#x60;-1&#x60;. E.g.:
	 * &#x60;f&#x3D;process_id%3D8040901857674754544&amp;f&#x3D;user_id%3D&gt;0&amp;f&#x3D;group_id%3D-1&amp;f&#x3D;role_id%3D-1&#x60;
	 * Note, this is equivalent to the other <code>searchProcessSupervisors</code> method,
	 * but with the query parameters collected into a single Map parameter. This is
	 * convenient for services with optional query parameters, especially when used with
	 * the {@link SearchProcessSupervisorsQueryParams} class that allows for building up
	 * this map in a fluent style.
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
	 * <li>s - can search on attributes (optional)
	 * </ul>
	 * @return List&lt;ProcessSupervisor&gt;
	 */
	@RequestLine("GET /API/bpm/processSupervisor?p={p}&c={c}&f={f}&o={o}&s={s}")
	@Headers({ "Accept: application/json", })
	List<ProcessSupervisor> searchProcessSupervisors(@QueryMap(encoded = true) Map<String, Object> queryParams);

	/**
	 * A convenience class for generating query parameters for the
	 * <code>searchProcessSupervisors
	 * </code> method in a fluent style.
	 */
	class SearchProcessSupervisorsQueryParams extends HashMap<String, Object> {

		public SearchProcessSupervisorsQueryParams p(final Integer value) {
			put("p", EncodingUtils.encode(value));
			return this;
		}

		public SearchProcessSupervisorsQueryParams c(final Integer value) {
			put("c", EncodingUtils.encode(value));
			return this;
		}

		public SearchProcessSupervisorsQueryParams f(final List<String> value) {
			put("f", EncodingUtils.encodeCollection(value, "multi"));
			return this;
		}

		public SearchProcessSupervisorsQueryParams o(final String value) {
			put("o", EncodingUtils.encode(value));
			return this;
		}

		public SearchProcessSupervisorsQueryParams s(final String value) {
			put("s", EncodingUtils.encode(value));
			return this;
		}

	}

}
