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
import org.bonitasoft.web.client.model.ProfileMember;
import org.bonitasoft.web.client.model.ProfileMemberCreateRequest;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public interface ProfileMemberApi extends ApiClient.Api {

    /**
     * Create the ProfileMember
     * Create the ProfileMember
     * 
     * @param body Partial ProfileMember description (required)
     * @return ProfileMember
     */
    @RequestLine("POST /API/portal/profileMember")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ProfileMember createProfileMember(ProfileMemberCreateRequest body);

    /**
     * Create the ProfileMember
     * Similar to <code>createProfileMember</code> but it also returns the http response headers .
     * Create the ProfileMember
     * 
     * @param body Partial ProfileMember description (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("POST /API/portal/profileMember")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<ProfileMember> createProfileMemberWithHttpInfo(ProfileMemberCreateRequest body);

    /**
     * Delete the ProfileMember by ID
     * Delete the single ProfileMember for the given ID
     * 
     * @param id ID of the ProfileMember to delete (required)
     */
    @RequestLine("DELETE /API/portal/profileMember/{id}")
    @Headers({
            "Accept: application/json",
    })
    void deleteProfileMemberById(@Param("id") String id);

    /**
     * Delete the ProfileMember by ID
     * Similar to <code>deleteProfileMemberById</code> but it also returns the http response headers .
     * Delete the single ProfileMember for the given ID
     * 
     * @param id ID of the ProfileMember to delete (required)
     */
    @RequestLine("DELETE /API/portal/profileMember/{id}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<Void> deleteProfileMemberByIdWithHttpInfo(@Param("id") String id);

    /**
     * Finds the ProfileMember by ID
     * Returns the single ProfileMember for the given ID
     * 
     * @param id ID of the ProfileMember to return (required)
     * @return ProfileMember
     */
    @RequestLine("GET /API/portal/profileMember/{id}")
    @Headers({
            "Accept: application/json",
    })
    ProfileMember getProfileMemberById(@Param("id") String id);

    /**
     * Finds the ProfileMember by ID
     * Similar to <code>getProfileMemberById</code> but it also returns the http response headers .
     * Returns the single ProfileMember for the given ID
     * 
     * @param id ID of the ProfileMember to return (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/portal/profileMember/{id}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<ProfileMember> getProfileMemberByIdWithHttpInfo(@Param("id") String id);

    /**
     * Finds ProfileMembers
     * Finds ProfileMembers with pagination params and filters **Filter &#x60;member_type&#x60; is mandatory** You can filter on &#x60;profile_id&#x60;,
     * &#x60;user_id&#x60;, &#x60;role_id&#x60; and &#x60;group_id&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @return List&lt;ProfileMember&gt;
     */
    @RequestLine("GET /API/portal/profileMember?p={p}&c={c}&f={f}")
    @Headers({
            "Accept: application/json",
    })
    List<ProfileMember> searchProfileMembers(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f);

    /**
     * Finds ProfileMembers
     * Similar to <code>searchProfileMembers</code> but it also returns the http response headers .
     * Finds ProfileMembers with pagination params and filters **Filter &#x60;member_type&#x60; is mandatory** You can filter on &#x60;profile_id&#x60;,
     * &#x60;user_id&#x60;, &#x60;role_id&#x60; and &#x60;group_id&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/portal/profileMember?p={p}&c={c}&f={f}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ProfileMember>> searchProfileMembersWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c,
            @Param("f") List<String> f);

    /**
     * Finds ProfileMembers
     * Finds ProfileMembers with pagination params and filters **Filter &#x60;member_type&#x60; is mandatory** You can filter on &#x60;profile_id&#x60;,
     * &#x60;user_id&#x60;, &#x60;role_id&#x60; and &#x60;group_id&#x60;
     * Note, this is equivalent to the other <code>searchProfileMembers</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchProfileMembersQueryParams} class that allows for
     * building up this map in a fluent style.
     * 
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>p - index of the page to display (required)</li>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string.
     *        (optional)</li>
     *        </ul>
     * @return List&lt;ProfileMember&gt;
     */
    @RequestLine("GET /API/portal/profileMember?p={p}&c={c}&f={f}")
    @Headers({
            "Accept: application/json",
    })
    List<ProfileMember> searchProfileMembers(@QueryMap(encoded = true) SearchProfileMembersQueryParams queryParams);

    /**
     * Finds ProfileMembers
     * Finds ProfileMembers with pagination params and filters **Filter &#x60;member_type&#x60; is mandatory** You can filter on &#x60;profile_id&#x60;,
     * &#x60;user_id&#x60;, &#x60;role_id&#x60; and &#x60;group_id&#x60;
     * Note, this is equivalent to the other <code>searchProfileMembers</code> that receives the query parameters as a map,
     * but this one also exposes the Http response headers
     * 
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>p - index of the page to display (required)</li>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string.
     *        (optional)</li>
     *        </ul>
     * @return List&lt;ProfileMember&gt;
     */
    @RequestLine("GET /API/portal/profileMember?p={p}&c={c}&f={f}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ProfileMember>> searchProfileMembersWithHttpInfo(
            @QueryMap(encoded = true) SearchProfileMembersQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>searchProfileMembers</code> method in a fluent style.
     */
    public static class SearchProfileMembersQueryParams extends HashMap<String, Object> {

        public SearchProfileMembersQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchProfileMembersQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchProfileMembersQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }
    }
}
