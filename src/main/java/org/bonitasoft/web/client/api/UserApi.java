/** 
 * Copyright (C) 2025 BonitaSoft S.A.
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
import org.bonitasoft.web.client.model.User;
import org.bonitasoft.web.client.model.UserCreateRequest;
import org.bonitasoft.web.client.model.UserUpdateRequest;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public interface UserApi extends ApiClient.Api {

    /**
     * Create the User
     * Create the User
     * 
     * @param body Partial User description (required)
     * @return User
     */
    @RequestLine("POST /API/identity/user")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    User createUser(UserCreateRequest body);

    /**
     * Create the User
     * Similar to <code>createUser</code> but it also returns the http response headers .
     * Create the User
     * 
     * @param body Partial User description (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("POST /API/identity/user")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<User> createUserWithHttpInfo(UserCreateRequest body);

    /**
     * Delete the User by ID
     * Delete the single User for the given ID. **Use this method with caution**: some artifacts like applications, process instances or users may present display
     * problems in the Bonita Portal if the referenced user was deleted. Note that you can disable a user instead of deleting it. To do so, use the UPDATE method
     * and set the attribute &#39;enabled&#39; to false
     * 
     * @param id ID of the User to delete (required)
     */
    @RequestLine("DELETE /API/identity/user/{id}")
    @Headers({
            "Accept: application/json",
    })
    void deleteUserById(@Param("id") String id);

    /**
     * Delete the User by ID
     * Similar to <code>deleteUserById</code> but it also returns the http response headers .
     * Delete the single User for the given ID. **Use this method with caution**: some artifacts like applications, process instances or users may present display
     * problems in the Bonita Portal if the referenced user was deleted. Note that you can disable a user instead of deleting it. To do so, use the UPDATE method
     * and set the attribute &#39;enabled&#39; to false
     * 
     * @param id ID of the User to delete (required)
     */
    @RequestLine("DELETE /API/identity/user/{id}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<Void> deleteUserByIdWithHttpInfo(@Param("id") String id);

    /**
     * Finds the User by ID
     * Returns the single User for the given ID
     * 
     * @param id ID of the User to return (required)
     * @return User
     */
    @RequestLine("GET /API/identity/user/{id}")
    @Headers({
            "Accept: application/json",
    })
    User getUserById(@Param("id") String id);

    /**
     * Finds the User by ID
     * Similar to <code>getUserById</code> but it also returns the http response headers .
     * Returns the single User for the given ID
     * 
     * @param id ID of the User to return (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/identity/user/{id}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<User> getUserByIdWithHttpInfo(@Param("id") String id);

    /**
     * Finds Users
     * Finds Users with pagination params and filters - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return List&lt;User&gt;
     */
    @RequestLine("GET /API/identity/user?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<User> searchUsers(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f,
            @Param("o") String o, @Param("s") String s);

    /**
     * Finds Users
     * Similar to <code>searchUsers</code> but it also returns the http response headers .
     * Finds Users with pagination params and filters - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/identity/user?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<User>> searchUsersWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c,
            @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

    /**
     * Finds Users
     * Finds Users with pagination params and filters - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60;
     * Note, this is equivalent to the other <code>searchUsers</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchUsersQueryParams} class that allows for
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
     *        <li>s - can search on attributes (optional)</li>
     *        </ul>
     * @return List&lt;User&gt;
     */
    @RequestLine("GET /API/identity/user?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<User> searchUsers(@QueryMap(encoded = true) SearchUsersQueryParams queryParams);

    /**
     * Finds Users
     * Finds Users with pagination params and filters - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60;
     * Note, this is equivalent to the other <code>searchUsers</code> that receives the query parameters as a map,
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
     *        <li>s - can search on attributes (optional)</li>
     *        </ul>
     * @return List&lt;User&gt;
     */
    @RequestLine("GET /API/identity/user?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<User>> searchUsersWithHttpInfo(@QueryMap(encoded = true) SearchUsersQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>searchUsers</code> method in a fluent style.
     */
    public static class SearchUsersQueryParams extends HashMap<String, Object> {

        public SearchUsersQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchUsersQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchUsersQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }

        public SearchUsersQueryParams o(final String value) {
            put("o", EncodingUtils.encode(value));
            return this;
        }

        public SearchUsersQueryParams s(final String value) {
            put("s", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Update the User by ID
     * Update the User for the given ID
     * 
     * @param id ID of the User to return (required)
     * @param userUpdateRequest Partial User description (required)
     */
    @RequestLine("PUT /API/identity/user/{id}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void updateUserById(@Param("id") String id, UserUpdateRequest userUpdateRequest);

    /**
     * Update the User by ID
     * Similar to <code>updateUserById</code> but it also returns the http response headers .
     * Update the User for the given ID
     * 
     * @param id ID of the User to return (required)
     * @param userUpdateRequest Partial User description (required)
     */
    @RequestLine("PUT /API/identity/user/{id}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<Void> updateUserByIdWithHttpInfo(@Param("id") String id, UserUpdateRequest userUpdateRequest);

}
