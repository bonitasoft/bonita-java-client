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

import java.util.HashMap;
import java.util.List;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.ProfessionalContactData;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public interface ProfessionalContactDataApi extends ApiClient.Api {

    /**
     * Create the ProfessionalContactData
     * Create the ProfessionalContactData
     * 
     * @param body Partial ProfessionalContactData description including the user ID (required)
     * @return ProfessionalContactData
     */
    @RequestLine("POST /API/identity/professionalcontactdata")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ProfessionalContactData createProfessionalContactData(ProfessionalContactData body);

    /**
     * Create the ProfessionalContactData
     * Similar to <code>createProfessionalContactData</code> but it also returns the http response headers .
     * Create the ProfessionalContactData
     * 
     * @param body Partial ProfessionalContactData description including the user ID (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("POST /API/identity/professionalcontactdata")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<ProfessionalContactData> createProfessionalContactDataWithHttpInfo(ProfessionalContactData body);

    /**
     * Finds the PersonalContactData by ID
     * Returns the single PersonalContactData for the given ID
     * 
     * @param userId User ID of the PersonalContactData to return (required)
     * @return ProfessionalContactData
     */
    @RequestLine("GET /API/identity/personalcontactdata/{userId}")
    @Headers({
            "Accept: application/json",
    })
    ProfessionalContactData getPersonalContactDataById(@Param("userId") String userId);

    /**
     * Finds the PersonalContactData by ID
     * Similar to <code>getPersonalContactDataById</code> but it also returns the http response headers .
     * Returns the single PersonalContactData for the given ID
     * 
     * @param userId User ID of the PersonalContactData to return (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/identity/personalcontactdata/{userId}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<ProfessionalContactData> getPersonalContactDataByIdWithHttpInfo(@Param("userId") String userId);

    /**
     * Finds the ProfessionalContactData by ID
     * Returns the single ProfessionalContactData for the given ID
     * 
     * @param userId User ID of the ProfessionalContactData to return (required)
     * @return ProfessionalContactData
     */
    @RequestLine("GET /API/identity/professionalcontactdata/{userId}")
    @Headers({
            "Accept: application/json",
    })
    ProfessionalContactData getProfessionalContactDataById(@Param("userId") String userId);

    /**
     * Finds the ProfessionalContactData by ID
     * Similar to <code>getProfessionalContactDataById</code> but it also returns the http response headers .
     * Returns the single ProfessionalContactData for the given ID
     * 
     * @param userId User ID of the ProfessionalContactData to return (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/identity/professionalcontactdata/{userId}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<ProfessionalContactData> getProfessionalContactDataByIdWithHttpInfo(@Param("userId") String userId);

    /**
     * Finds ProfessionalContactData
     * Finds ProfessionalContactData with pagination params and filters - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on
     * &#x60;displayName&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return List&lt;ProfessionalContactData&gt;
     */
    @RequestLine("GET /API/identity/professionalcontactdata?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<ProfessionalContactData> searchProfessionalContactDatas(@Param("p") Integer p, @Param("c") Integer c,
            @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

    /**
     * Finds ProfessionalContactData
     * Similar to <code>searchProfessionalContactDatas</code> but it also returns the http response headers .
     * Finds ProfessionalContactData with pagination params and filters - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on
     * &#x60;displayName&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/identity/professionalcontactdata?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ProfessionalContactData>> searchProfessionalContactDatasWithHttpInfo(@Param("p") Integer p,
            @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

    /**
     * Finds ProfessionalContactData
     * Finds ProfessionalContactData with pagination params and filters - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on
     * &#x60;displayName&#x60;
     * Note, this is equivalent to the other <code>searchProfessionalContactDatas</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchProfessionalContactDatasQueryParams} class that allows for
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
     * @return List&lt;ProfessionalContactData&gt;
     */
    @RequestLine("GET /API/identity/professionalcontactdata?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<ProfessionalContactData> searchProfessionalContactDatas(
            @QueryMap(encoded = true) SearchProfessionalContactDatasQueryParams queryParams);

    /**
     * Finds ProfessionalContactData
     * Finds ProfessionalContactData with pagination params and filters - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on
     * &#x60;displayName&#x60;
     * Note, this is equivalent to the other <code>searchProfessionalContactDatas</code> that receives the query parameters as a map,
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
     * @return List&lt;ProfessionalContactData&gt;
     */
    @RequestLine("GET /API/identity/professionalcontactdata?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ProfessionalContactData>> searchProfessionalContactDatasWithHttpInfo(
            @QueryMap(encoded = true) SearchProfessionalContactDatasQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>searchProfessionalContactDatas</code> method in a fluent style.
     */
    public static class SearchProfessionalContactDatasQueryParams extends HashMap<String, Object> {

        public SearchProfessionalContactDatasQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchProfessionalContactDatasQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchProfessionalContactDatasQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }

        public SearchProfessionalContactDatasQueryParams o(final String value) {
            put("o", EncodingUtils.encode(value));
            return this;
        }

        public SearchProfessionalContactDatasQueryParams s(final String value) {
            put("s", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Update the PersonalContactData by ID
     * Update the PersonalContactData for the given ID
     * 
     * @param userId User ID of the PersonalContactData to update (required)
     * @param professionalContactData Partial PersonalContactData description including the user ID (required)
     */
    @RequestLine("PUT /API/identity/personalcontactdata/{userId}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void updatePersonalContactDataById(@Param("userId") String userId, ProfessionalContactData professionalContactData);

    /**
     * Update the PersonalContactData by ID
     * Similar to <code>updatePersonalContactDataById</code> but it also returns the http response headers .
     * Update the PersonalContactData for the given ID
     * 
     * @param userId User ID of the PersonalContactData to update (required)
     * @param professionalContactData Partial PersonalContactData description including the user ID (required)
     */
    @RequestLine("PUT /API/identity/personalcontactdata/{userId}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<Void> updatePersonalContactDataByIdWithHttpInfo(@Param("userId") String userId,
            ProfessionalContactData professionalContactData);

    /**
     * Update the ProfessionalContactData by ID
     * Update the ProfessionalContactData for the given ID
     * 
     * @param userId User ID of the ProfessionalContactData to update (required)
     * @param professionalContactData Partial ProfessionalContactData description including the user ID (required)
     */
    @RequestLine("PUT /API/identity/professionalcontactdata/{userId}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void updateProfessionalContactDataById(@Param("userId") String userId,
            ProfessionalContactData professionalContactData);

    /**
     * Update the ProfessionalContactData by ID
     * Similar to <code>updateProfessionalContactDataById</code> but it also returns the http response headers .
     * Update the ProfessionalContactData for the given ID
     * 
     * @param userId User ID of the ProfessionalContactData to update (required)
     * @param professionalContactData Partial ProfessionalContactData description including the user ID (required)
     */
    @RequestLine("PUT /API/identity/professionalcontactdata/{userId}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<Void> updateProfessionalContactDataByIdWithHttpInfo(@Param("userId") String userId,
            ProfessionalContactData professionalContactData);

}
