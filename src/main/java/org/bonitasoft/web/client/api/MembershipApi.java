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
import org.bonitasoft.web.client.model.Membership;
import org.bonitasoft.web.client.model.MembershipCreateRequest;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface MembershipApi extends ApiClient.Api {


	/**
	 * Create the Membership
	 * Create the Membership
	 * @param body Partial Membership description (required)
	 * @return Membership
	 */
	@RequestLine("POST /API/identity/membership")
	@Headers({
			"Content-Type: application/json",
			"Accept: application/json",
	})
	Membership createMembership(MembershipCreateRequest body);

	/**
	 * Create the Membership
	 * Similar to <code>createMembership</code> but it also returns the http response headers .
	 * Create the Membership
	 * @param body Partial Membership description (required)
	 * @return A ApiResponse that wraps the response boyd and the http headers.
	 */
	@RequestLine("POST /API/identity/membership")
	@Headers({
			"Content-Type: application/json",
			"Accept: application/json",
	})
	ApiResponse<Membership> createMembershipWithHttpInfo(MembershipCreateRequest body);


	/**
	 * Delete the Membership by ID
	 * Delete a membership of a user using the group id and role id.
	 * @param userId User ID of the Membership to delete (required)
	 * @param groupId Group ID of the Membership to delete (required)
	 * @param roleId Role ID of the Membership to delete (required)
	 */
	@RequestLine("DELETE /API/identity/membership/{userId}/{groupId}/{roleId}")
	@Headers({
			"Accept: application/json",
	})
	void deleteMembershipById(@Param("userId") String userId, @Param("groupId") String groupId, @Param("roleId") String roleId);

	/**
	 * Delete the Membership by ID
	 * Similar to <code>deleteMembershipById</code> but it also returns the http response headers .
	 * Delete a membership of a user using the group id and role id.
	 * @param userId User ID of the Membership to delete (required)
	 * @param groupId Group ID of the Membership to delete (required)
	 * @param roleId Role ID of the Membership to delete (required)
	 */
	@RequestLine("DELETE /API/identity/membership/{userId}/{groupId}/{roleId}")
	@Headers({
			"Accept: application/json",
	})
	ApiResponse<Void> deleteMembershipByIdWithHttpInfo(@Param("userId") String userId, @Param("groupId") String groupId, @Param("roleId") String roleId);


	/**
	 * Finds Memberships
	 * Finds Memberships with pagination params and filters  **Filter &#x60;user_id&#x60; is mandatory**  You can order with the values: &#x60;ROLE_NAME_ASC&#x60;,&#x60;ROLE_NAME_DESC&#x60;, &#x60;GROUP_NAME_ASC&#x60;,&#x60;GROUP_NAME_DESC&#x60;, &#x60;ASSIGNED_DATE_ASC&#x60;, &#x60;ASSIGNED_DATE_DESC&#x60;
	 * @param p index of the page to display (required)
	 * @param c maximum number of elements to retrieve (required)
	 * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
	 * @param o can order on attributes (optional)
	 * @param s can search on attributes (optional)
	 * @return List&lt;Membership&gt;
	 */
	@RequestLine("GET /API/identity/membership?p={p}&c={c}&f={f}&o={o}&s={s}")
	@Headers({
			"Accept: application/json",
	})
	List<Membership> searchMemberships(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

	/**
	 * Finds Memberships
	 * Similar to <code>searchMemberships</code> but it also returns the http response headers .
	 * Finds Memberships with pagination params and filters  **Filter &#x60;user_id&#x60; is mandatory**  You can order with the values: &#x60;ROLE_NAME_ASC&#x60;,&#x60;ROLE_NAME_DESC&#x60;, &#x60;GROUP_NAME_ASC&#x60;,&#x60;GROUP_NAME_DESC&#x60;, &#x60;ASSIGNED_DATE_ASC&#x60;, &#x60;ASSIGNED_DATE_DESC&#x60;
	 * @param p index of the page to display (required)
	 * @param c maximum number of elements to retrieve (required)
	 * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
	 * @param o can order on attributes (optional)
	 * @param s can search on attributes (optional)
	 * @return A ApiResponse that wraps the response boyd and the http headers.
	 */
	@RequestLine("GET /API/identity/membership?p={p}&c={c}&f={f}&o={o}&s={s}")
	@Headers({
			"Accept: application/json",
	})
	ApiResponse<List<Membership>> searchMembershipsWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);


	/**
	 * Finds Memberships
	 * Finds Memberships with pagination params and filters  **Filter &#x60;user_id&#x60; is mandatory**  You can order with the values: &#x60;ROLE_NAME_ASC&#x60;,&#x60;ROLE_NAME_DESC&#x60;, &#x60;GROUP_NAME_ASC&#x60;,&#x60;GROUP_NAME_DESC&#x60;, &#x60;ASSIGNED_DATE_ASC&#x60;, &#x60;ASSIGNED_DATE_DESC&#x60;
	 * Note, this is equivalent to the other <code>searchMemberships</code> method,
	 * but with the query parameters collected into a single Map parameter. This
	 * is convenient for services with optional query parameters, especially when
	 * used with the {@link SearchMembershipsQueryParams} class that allows for
	 * building up this map in a fluent style.
	 * @param queryParams Map of query parameters as name-value pairs
	 *   <p>The following elements may be specified in the query map:</p>
	 *   <ul>
	 *   <li>p - index of the page to display (required)</li>
	 *   <li>c - maximum number of elements to retrieve (required)</li>
	 *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
	 *   <li>o - can order on attributes (optional)</li>
	 *   <li>s - can search on attributes (optional)</li>
	 *   </ul>
	 * @return List&lt;Membership&gt;
	 */
	@RequestLine("GET /API/identity/membership?p={p}&c={c}&f={f}&o={o}&s={s}")
	@Headers({
			"Accept: application/json",
	})
	List<Membership> searchMemberships(@QueryMap(encoded = true) Map<String, Object> queryParams);

	/**
	 * Finds Memberships
	 * Finds Memberships with pagination params and filters  **Filter &#x60;user_id&#x60; is mandatory**  You can order with the values: &#x60;ROLE_NAME_ASC&#x60;,&#x60;ROLE_NAME_DESC&#x60;, &#x60;GROUP_NAME_ASC&#x60;,&#x60;GROUP_NAME_DESC&#x60;, &#x60;ASSIGNED_DATE_ASC&#x60;, &#x60;ASSIGNED_DATE_DESC&#x60;
	 * Note, this is equivalent to the other <code>searchMemberships</code> that receives the query parameters as a map,
	 * but this one also exposes the Http response headers
	 * @param queryParams Map of query parameters as name-value pairs
	 *   <p>The following elements may be specified in the query map:</p>
	 *   <ul>
	 *   <li>p - index of the page to display (required)</li>
	 *   <li>c - maximum number of elements to retrieve (required)</li>
	 *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
	 *   <li>o - can order on attributes (optional)</li>
	 *   <li>s - can search on attributes (optional)</li>
	 *   </ul>
	 * @return List&lt;Membership&gt;
	 */
	@RequestLine("GET /API/identity/membership?p={p}&c={c}&f={f}&o={o}&s={s}")
	@Headers({
			"Accept: application/json",
	})
	ApiResponse<List<Membership>> searchMembershipsWithHttpInfo(@QueryMap(encoded = true) Map<String, Object> queryParams);


	/**
	 * A convenience class for generating query parameters for the
	 * <code>searchMemberships</code> method in a fluent style.
	 */
	public static class SearchMembershipsQueryParams extends HashMap<String, Object> {
		public SearchMembershipsQueryParams p(final Integer value) {
			put("p", EncodingUtils.encode(value));
			return this;
		}

		public SearchMembershipsQueryParams c(final Integer value) {
			put("c", EncodingUtils.encode(value));
			return this;
		}

		public SearchMembershipsQueryParams f(final List<String> value) {
			put("f", EncodingUtils.encodeCollection(value, "multi"));
			return this;
		}

		public SearchMembershipsQueryParams o(final String value) {
			put("o", EncodingUtils.encode(value));
			return this;
		}

		public SearchMembershipsQueryParams s(final String value) {
			put("s", EncodingUtils.encode(value));
			return this;
		}
	}
}
