/** 
 * Copyright (C) 2023 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.List;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.Group;
import org.bonitasoft.web.client.model.GroupCreateRequest;
import org.bonitasoft.web.client.model.GroupUpdateRequest;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface GroupApi extends ApiClient.Api {

    /**
     * Create the Group
     * Create the Group
     * 
     * @param body Partial Group description (required)
     * @return Group
     */
    @RequestLine("POST /API/identity/group")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    Group createGroup(GroupCreateRequest body);

    /**
     * Create the Group
     * Similar to <code>createGroup</code> but it also returns the http response headers .
     * Create the Group
     * 
     * @param body Partial Group description (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("POST /API/identity/group")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<Group> createGroupWithHttpInfo(GroupCreateRequest body);

    /**
     * Delete the Group by ID
     * Delete the single Group for the given ID
     * 
     * @param id ID of the Group to delete (required)
     */
    @RequestLine("DELETE /API/identity/group/{id}")
    @Headers({
            "Accept: application/json",
    })
    void deleteGroupById(@Param("id") String id);

    /**
     * Delete the Group by ID
     * Similar to <code>deleteGroupById</code> but it also returns the http response headers .
     * Delete the single Group for the given ID
     * 
     * @param id ID of the Group to delete (required)
     */
    @RequestLine("DELETE /API/identity/group/{id}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<Void> deleteGroupByIdWithHttpInfo(@Param("id") String id);

    /**
     * Finds the Group by ID
     * Returns the single Group for the given ID
     * 
     * @param id ID of the Group to return (required)
     * @return Group
     */
    @RequestLine("GET /API/identity/group/{id}")
    @Headers({
            "Accept: application/json",
    })
    Group getGroupById(@Param("id") String id);

    /**
     * Finds the Group by ID
     * Similar to <code>getGroupById</code> but it also returns the http response headers .
     * Returns the single Group for the given ID
     * 
     * @param id ID of the Group to return (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/identity/group/{id}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<Group> getGroupByIdWithHttpInfo(@Param("id") String id);

    /**
     * Finds Groups
     * Finds Groups with pagination params and filters. - can order on &#x60;id&#x60;,&#x60;name&#x60;,&#x60;displayName&#x60; - can filter on
     * &#x60;name&#x60;,&#x60;displayName&#x60;,&#x60;parent_path&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @return List&lt;Group&gt;
     */
    @RequestLine("GET /API/identity/group?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    List<Group> searchGroups(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f,
            @Param("o") String o);

    /**
     * Finds Groups
     * Similar to <code>searchGroups</code> but it also returns the http response headers .
     * Finds Groups with pagination params and filters. - can order on &#x60;id&#x60;,&#x60;name&#x60;,&#x60;displayName&#x60; - can filter on
     * &#x60;name&#x60;,&#x60;displayName&#x60;,&#x60;parent_path&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/identity/group?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<Group>> searchGroupsWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c,
            @Param("f") List<String> f, @Param("o") String o);

    /**
     * Finds Groups
     * Finds Groups with pagination params and filters. - can order on &#x60;id&#x60;,&#x60;name&#x60;,&#x60;displayName&#x60; - can filter on
     * &#x60;name&#x60;,&#x60;displayName&#x60;,&#x60;parent_path&#x60;
     * Note, this is equivalent to the other <code>searchGroups</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchGroupsQueryParams} class that allows for
     * building up this map in a fluent style.
     * 
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>p - index of the page to display (required)</li>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string.
     *        (optional)</li>
     *        <li>o - can order on attributes (optional)</li>
     *        </ul>
     * @return List&lt;Group&gt;
     */
    @RequestLine("GET /API/identity/group?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    List<Group> searchGroups(@QueryMap(encoded = true) SearchGroupsQueryParams queryParams);

    /**
     * Finds Groups
     * Finds Groups with pagination params and filters. - can order on &#x60;id&#x60;,&#x60;name&#x60;,&#x60;displayName&#x60; - can filter on
     * &#x60;name&#x60;,&#x60;displayName&#x60;,&#x60;parent_path&#x60;
     * Note, this is equivalent to the other <code>searchGroups</code> that receives the query parameters as a map,
     * but this one also exposes the Http response headers
     * 
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>p - index of the page to display (required)</li>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string.
     *        (optional)</li>
     *        <li>o - can order on attributes (optional)</li>
     *        </ul>
     * @return List&lt;Group&gt;
     */
    @RequestLine("GET /API/identity/group?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<Group>> searchGroupsWithHttpInfo(@QueryMap(encoded = true) SearchGroupsQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>searchGroups</code> method in a fluent style.
     */
    public static class SearchGroupsQueryParams extends HashMap<String, Object> {

        public SearchGroupsQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchGroupsQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchGroupsQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }

        public SearchGroupsQueryParams o(final String value) {
            put("o", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Update the Group by ID
     * Update the Group for the given ID
     * 
     * @param id ID of the Group to return (required)
     * @param groupUpdateRequest Partial Group description (required)
     */
    @RequestLine("PUT /API/identity/group/{id}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void updateGroupById(@Param("id") String id, GroupUpdateRequest groupUpdateRequest);

    /**
     * Update the Group by ID
     * Similar to <code>updateGroupById</code> but it also returns the http response headers .
     * Update the Group for the given ID
     * 
     * @param id ID of the Group to return (required)
     * @param groupUpdateRequest Partial Group description (required)
     */
    @RequestLine("PUT /API/identity/group/{id}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<Void> updateGroupByIdWithHttpInfo(@Param("id") String id, GroupUpdateRequest groupUpdateRequest);

}
