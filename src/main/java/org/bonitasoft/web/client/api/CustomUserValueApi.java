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
import org.bonitasoft.web.client.model.CustomUserValue;
import org.bonitasoft.web.client.model.CustomUserValueUpdateRequest;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.8.0")
public interface CustomUserValueApi extends ApiClient.Api {

    /**
     * Finds CustomUserValues
     * Finds CustomUserValues with pagination params and filters You can filter on &#x60;userId&#x60;, &#x60;value&#x60;, &#x60;definitionId&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @return List&lt;CustomUserValue&gt;
     */
    @RequestLine("GET /API/customuserinfo/value?p={p}&c={c}&f={f}")
    @Headers({
            "Accept: application/json",
    })
    List<CustomUserValue> searchCustomUserValues(@Param("p") Integer p, @Param("c") Integer c,
            @Param("f") List<String> f);

    /**
     * Finds CustomUserValues
     * Similar to <code>searchCustomUserValues</code> but it also returns the http response headers .
     * Finds CustomUserValues with pagination params and filters You can filter on &#x60;userId&#x60;, &#x60;value&#x60;, &#x60;definitionId&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/customuserinfo/value?p={p}&c={c}&f={f}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<CustomUserValue>> searchCustomUserValuesWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c,
            @Param("f") List<String> f);

    /**
     * Finds CustomUserValues
     * Finds CustomUserValues with pagination params and filters You can filter on &#x60;userId&#x60;, &#x60;value&#x60;, &#x60;definitionId&#x60;
     * Note, this is equivalent to the other <code>searchCustomUserValues</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchCustomUserValuesQueryParams} class that allows for
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
     * @return List&lt;CustomUserValue&gt;
     */
    @RequestLine("GET /API/customuserinfo/value?p={p}&c={c}&f={f}")
    @Headers({
            "Accept: application/json",
    })
    List<CustomUserValue> searchCustomUserValues(
            @QueryMap(encoded = true) SearchCustomUserValuesQueryParams queryParams);

    /**
     * Finds CustomUserValues
     * Finds CustomUserValues with pagination params and filters You can filter on &#x60;userId&#x60;, &#x60;value&#x60;, &#x60;definitionId&#x60;
     * Note, this is equivalent to the other <code>searchCustomUserValues</code> that receives the query parameters as a map,
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
     * @return List&lt;CustomUserValue&gt;
     */
    @RequestLine("GET /API/customuserinfo/value?p={p}&c={c}&f={f}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<CustomUserValue>> searchCustomUserValuesWithHttpInfo(
            @QueryMap(encoded = true) SearchCustomUserValuesQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>searchCustomUserValues</code> method in a fluent style.
     */
    public static class SearchCustomUserValuesQueryParams extends HashMap<String, Object> {

        public SearchCustomUserValuesQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchCustomUserValuesQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchCustomUserValuesQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }
    }

    /**
     * Update the CustomUserValue by ID
     * Update the CustomUserValue for the given ID
     * 
     * @param userId User ID (required)
     * @param definitionId definition ID (required)
     * @param customUserValueUpdateRequest Custom user defition Value (required)
     */
    @RequestLine("PUT /API/customuserinfo/value/{userId}/{definitionId}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void updateCustomUserValueById(@Param("userId") String userId, @Param("definitionId") String definitionId,
            CustomUserValueUpdateRequest customUserValueUpdateRequest);

    /**
     * Update the CustomUserValue by ID
     * Similar to <code>updateCustomUserValueById</code> but it also returns the http response headers .
     * Update the CustomUserValue for the given ID
     * 
     * @param userId User ID (required)
     * @param definitionId definition ID (required)
     * @param customUserValueUpdateRequest Custom user defition Value (required)
     */
    @RequestLine("PUT /API/customuserinfo/value/{userId}/{definitionId}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<Void> updateCustomUserValueByIdWithHttpInfo(@Param("userId") String userId,
            @Param("definitionId") String definitionId, CustomUserValueUpdateRequest customUserValueUpdateRequest);

}
