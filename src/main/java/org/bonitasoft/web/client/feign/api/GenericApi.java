package org.bonitasoft.web.client.feign.api;

import java.util.List;
import java.util.Map;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.bonitasoft.web.client.invoker.ApiClient.Api;

/**
 * Generic HTTP interface. This allows to perform query against url not known in advance and benefit from the authenticated client.
 */
public interface GenericApi extends Api {

	/**
	 * Perform a GET request against the given url and expect result to be a list of object
	 * @param url
	 * @return
	 */
	@RequestLine("GET /{url}")
	@Headers({
			"Content-Type: application/json",
			"Accept: application/json",
	})
	List<Map<String, Object>> getList(@Param("url") String url);

	/**
	 * Perform a GET request against the given url and expect result to be a single object
	 * @param url
	 * @return
	 */
	@RequestLine("GET /{url}")
	@Headers({
			"Content-Type: application/json",
			"Accept: application/json",
	})
	Map<String, Object> get(@Param("url") String url);
}
