package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.CustomUserDefinition;
import org.bonitasoft.web.client.model.CustomUserDefinitionCreateRequest;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface CustomUserDefinitionApi extends ApiClient.Api {

	/**
	 * Create the CustomUserDefinition Create the CustomUserDefinition
	 * @param body Partial CustomUserDefinition description (required)
	 * @return CustomUserDefinition
	 */
	@RequestLine("POST /API/customuserinfo/definition")
	@Headers({ "Content-Type: application/json", "Accept: application/json", })
	CustomUserDefinition createCustomUserDefinition(CustomUserDefinitionCreateRequest body);

	/**
	 * Delete the CustomUserDefinition by ID Delete the single CustomUserDefinition for
	 * the given ID
	 * @param id ID of the CustomUserDefinition to delete (required)
	 */
	@RequestLine("DELETE /API/customuserinfo/definition/{id}")
	@Headers({ "Accept: application/json", })
	void deleteCustomUserDefinitionById(@Param("id") String id);

	/**
	 * Finds the CustomUserDefinition by ID Returns the single CustomUserDefinition for
	 * the given ID
	 * @param id ID of the CustomUserDefinition to return (required)
	 * @return CustomUserDefinition
	 */
	@RequestLine("GET /API/customuserinfo/definition/{id}")
	@Headers({ "Accept: application/json", })
	CustomUserDefinition getCustomUserDefinitionById(@Param("id") String id);

	/**
	 * Finds CustomUserDefinitions Finds CustomUserDefinitions. There are no filters, and
	 * no search terms. All the definitions are returned.
	 * @param p index of the page to display (required)
	 * @param c maximum number of elements to retrieve (required)
	 * @return List&lt;CustomUserDefinition&gt;
	 */
	@RequestLine("GET /API/customuserinfo/definition?p={p}&c={c}")
	@Headers({ "Accept: application/json", })
	List<CustomUserDefinition> searchCustomUserDefinitions(@Param("p") Integer p, @Param("c") Integer c);

	/**
	 * Finds CustomUserDefinitions Finds CustomUserDefinitions. There are no filters, and
	 * no search terms. All the definitions are returned. Note, this is equivalent to the
	 * other <code>
	 * searchCustomUserDefinitions</code> method, but with the query parameters collected
	 * into a single Map parameter. This is convenient for services with optional query
	 * parameters, especially when used with the
	 * {@link SearchCustomUserDefinitionsQueryParams} class that allows for building up
	 * this map in a fluent style.
	 * @param queryParams Map of query parameters as name-value pairs
	 * <p>
	 * The following elements may be specified in the query map:
	 * <ul>
	 * <li>p - index of the page to display (required)
	 * <li>c - maximum number of elements to retrieve (required)
	 * </ul>
	 * @return List&lt;CustomUserDefinition&gt;
	 */
	@RequestLine("GET /API/customuserinfo/definition?p={p}&c={c}")
	@Headers({ "Accept: application/json", })
	List<CustomUserDefinition> searchCustomUserDefinitions(@QueryMap(encoded = true) Map<String, Object> queryParams);

	/**
	 * A convenience class for generating query parameters for the
	 * <code>searchCustomUserDefinitions
	 * </code> method in a fluent style.
	 */
	class SearchCustomUserDefinitionsQueryParams extends HashMap<String, Object> {

		public SearchCustomUserDefinitionsQueryParams p(final Integer value) {
			put("p", EncodingUtils.encode(value));
			return this;
		}

		public SearchCustomUserDefinitionsQueryParams c(final Integer value) {
			put("c", EncodingUtils.encode(value));
			return this;
		}

	}

}
