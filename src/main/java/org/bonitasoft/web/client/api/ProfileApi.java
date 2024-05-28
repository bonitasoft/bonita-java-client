/** 
 * Copyright (C) 2024 BonitaSoft S.A.
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

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.Profile;
import org.bonitasoft.web.client.model.ProfileCreateRequest;
import org.bonitasoft.web.client.model.ProfileUpdateRequest;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public interface ProfileApi extends ApiClient.Api {

    /**
     * Create the Profile
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Create the Profile Warning: as of 9.0.0, creating profiles using this API is deprecated.
     * 
     * @param body Partial Profile description (required)
     * @return Profile
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /API/portal/profile")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    Profile createProfile(ProfileCreateRequest body);

    /**
     * Create the Profile
     * Similar to <code>createProfile</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Create the Profile Warning: as of 9.0.0, creating profiles using this API is deprecated.
     * 
     * @param body Partial Profile description (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /API/portal/profile")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<Profile> createProfileWithHttpInfo(ProfileCreateRequest body);

    /**
     * Delete the Profile by ID
     * Delete the single Profile for the given ID
     * 
     * @param id ID of the Profile to delete (required)
     */
    @RequestLine("DELETE /API/portal/profile/{id}")
    @Headers({
            "Accept: application/json",
    })
    void deleteProfileById(@Param("id") String id);

    /**
     * Delete the Profile by ID
     * Similar to <code>deleteProfileById</code> but it also returns the http response headers .
     * Delete the single Profile for the given ID
     * 
     * @param id ID of the Profile to delete (required)
     */
    @RequestLine("DELETE /API/portal/profile/{id}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<Void> deleteProfileByIdWithHttpInfo(@Param("id") String id);

    /**
     * Finds the Profile by ID
     * Returns the single Profile for the given ID
     * 
     * @param id ID of the Profile to return (required)
     * @return Profile
     */
    @RequestLine("GET /API/portal/profile/{id}")
    @Headers({
            "Accept: application/json",
    })
    Profile getProfileById(@Param("id") String id);

    /**
     * Finds the Profile by ID
     * Similar to <code>getProfileById</code> but it also returns the http response headers .
     * Returns the single Profile for the given ID
     * 
     * @param id ID of the Profile to return (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/portal/profile/{id}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<Profile> getProfileByIdWithHttpInfo(@Param("id") String id);

    /**
     * Import profiles
     * Import profiles Warning: as of 9.0.0, importing profiles using this service is deprecated.
     * 
     * @param profilesDataUpload Uploaded file (optional)
     * @param importPolicy Import policy (optional)
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /services/profile/import")
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "Accept: application/json",
    })
    void importProfiles(@Param("profilesDataUpload") String profilesDataUpload,
            @Param("importPolicy") String importPolicy);

    /**
     * Import profiles
     * Similar to <code>importProfiles</code> but it also returns the http response headers .
     * Import profiles Warning: as of 9.0.0, importing profiles using this service is deprecated.
     * 
     * @param profilesDataUpload Uploaded file (optional)
     * @param importPolicy Import policy (optional)
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /services/profile/import")
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "Accept: application/json",
    })
    ApiResponse<Void> importProfilesWithHttpInfo(@Param("profilesDataUpload") String profilesDataUpload,
            @Param("importPolicy") String importPolicy);

    /**
     * Finds Profiles
     * Finds Profiles with pagination params and filters - can search on &#x60;name&#x60; - can filter on &#x60;name&#x60;,&#x60;hasNavigation&#x60; - can order on
     * &#x60;name&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param s can search on attributes (optional)
     * @param o can order on attributes (optional)
     * @return List&lt;Profile&gt;
     */
    @RequestLine("GET /API/portal/profile?p={p}&c={c}&f={f}&s={s}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    List<Profile> searchProfiles(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f,
            @Param("s") String s, @Param("o") String o);

    /**
     * Finds Profiles
     * Similar to <code>searchProfiles</code> but it also returns the http response headers .
     * Finds Profiles with pagination params and filters - can search on &#x60;name&#x60; - can filter on &#x60;name&#x60;,&#x60;hasNavigation&#x60; - can order on
     * &#x60;name&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param s can search on attributes (optional)
     * @param o can order on attributes (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/portal/profile?p={p}&c={c}&f={f}&s={s}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<Profile>> searchProfilesWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c,
            @Param("f") List<String> f, @Param("s") String s, @Param("o") String o);

    /**
     * Finds Profiles
     * Finds Profiles with pagination params and filters - can search on &#x60;name&#x60; - can filter on &#x60;name&#x60;,&#x60;hasNavigation&#x60; - can order on
     * &#x60;name&#x60;
     * Note, this is equivalent to the other <code>searchProfiles</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchProfilesQueryParams} class that allows for
     * building up this map in a fluent style.
     * 
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>p - index of the page to display (required)</li>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string.
     *        (optional)</li>
     *        <li>s - can search on attributes (optional)</li>
     *        <li>o - can order on attributes (optional)</li>
     *        </ul>
     * @return List&lt;Profile&gt;
     */
    @RequestLine("GET /API/portal/profile?p={p}&c={c}&f={f}&s={s}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    List<Profile> searchProfiles(@QueryMap(encoded = true) SearchProfilesQueryParams queryParams);

    /**
     * Finds Profiles
     * Finds Profiles with pagination params and filters - can search on &#x60;name&#x60; - can filter on &#x60;name&#x60;,&#x60;hasNavigation&#x60; - can order on
     * &#x60;name&#x60;
     * Note, this is equivalent to the other <code>searchProfiles</code> that receives the query parameters as a map,
     * but this one also exposes the Http response headers
     * 
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>p - index of the page to display (required)</li>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string.
     *        (optional)</li>
     *        <li>s - can search on attributes (optional)</li>
     *        <li>o - can order on attributes (optional)</li>
     *        </ul>
     * @return List&lt;Profile&gt;
     */
    @RequestLine("GET /API/portal/profile?p={p}&c={c}&f={f}&s={s}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<Profile>> searchProfilesWithHttpInfo(
            @QueryMap(encoded = true) SearchProfilesQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>searchProfiles</code> method in a fluent style.
     */
    public static class SearchProfilesQueryParams extends HashMap<String, Object> {

        public SearchProfilesQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchProfilesQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchProfilesQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }

        public SearchProfilesQueryParams s(final String value) {
            put("s", EncodingUtils.encode(value));
            return this;
        }

        public SearchProfilesQueryParams o(final String value) {
            put("o", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Update the Profile by ID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Update the Profile for the given ID Warning: as of 9.0.0, updating a profile using this API
     * is deprecated.
     * 
     * @param id ID of the Profile to return (required)
     * @param profileUpdateRequest Partial Profile description (required)
     * @deprecated
     */
    @Deprecated
    @RequestLine("PUT /API/portal/profile/{id}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void updateProfileById(@Param("id") String id, ProfileUpdateRequest profileUpdateRequest);

    /**
     * Update the Profile by ID
     * Similar to <code>updateProfileById</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Update the Profile for the given ID Warning: as of 9.0.0, updating a profile using this API
     * is deprecated.
     * 
     * @param id ID of the Profile to return (required)
     * @param profileUpdateRequest Partial Profile description (required)
     * @deprecated
     */
    @Deprecated
    @RequestLine("PUT /API/portal/profile/{id}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<Void> updateProfileByIdWithHttpInfo(@Param("id") String id, ProfileUpdateRequest profileUpdateRequest);

    /**
     * Upload profiles
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Upload profiles Warning: as of 9.0.0, uploading profiles using the portal is deprecated.
     * 
     * @param file (optional)
     * @return String
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /portal/profilesUpload")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json,text/plain",
    })
    String uploadprofiles(@Param("file") File file);

    /**
     * Upload profiles
     * Similar to <code>uploadprofiles</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Upload profiles Warning: as of 9.0.0, uploading profiles using the portal is deprecated.
     * 
     * @param file (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /portal/profilesUpload")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json,text/plain",
    })
    ApiResponse<String> uploadprofilesWithHttpInfo(@Param("file") File file);

}
