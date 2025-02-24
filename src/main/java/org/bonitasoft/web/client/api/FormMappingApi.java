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
import org.bonitasoft.web.client.model.FormMapping;
import org.bonitasoft.web.client.model.FormMappingUpdateRequest;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public interface FormMappingApi extends ApiClient.Api {

    /**
     * Finds FormMappings
     * Finds FormMappings with pagination params and filters - can filter on &#x60;processDefinitionId&#x60;,&#x60;type&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return List&lt;FormMapping&gt;
     */
    @RequestLine("GET /API/form/mapping?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<FormMapping> searchFormMappings(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f,
            @Param("o") String o, @Param("s") String s);

    /**
     * Finds FormMappings
     * Similar to <code>searchFormMappings</code> but it also returns the http response headers .
     * Finds FormMappings with pagination params and filters - can filter on &#x60;processDefinitionId&#x60;,&#x60;type&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/form/mapping?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<FormMapping>> searchFormMappingsWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c,
            @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

    /**
     * Finds FormMappings
     * Finds FormMappings with pagination params and filters - can filter on &#x60;processDefinitionId&#x60;,&#x60;type&#x60;
     * Note, this is equivalent to the other <code>searchFormMappings</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchFormMappingsQueryParams} class that allows for
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
     * @return List&lt;FormMapping&gt;
     */
    @RequestLine("GET /API/form/mapping?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<FormMapping> searchFormMappings(@QueryMap(encoded = true) SearchFormMappingsQueryParams queryParams);

    /**
     * Finds FormMappings
     * Finds FormMappings with pagination params and filters - can filter on &#x60;processDefinitionId&#x60;,&#x60;type&#x60;
     * Note, this is equivalent to the other <code>searchFormMappings</code> that receives the query parameters as a map,
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
     * @return List&lt;FormMapping&gt;
     */
    @RequestLine("GET /API/form/mapping?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<FormMapping>> searchFormMappingsWithHttpInfo(
            @QueryMap(encoded = true) SearchFormMappingsQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>searchFormMappings</code> method in a fluent style.
     */
    public static class SearchFormMappingsQueryParams extends HashMap<String, Object> {

        public SearchFormMappingsQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchFormMappingsQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchFormMappingsQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }

        public SearchFormMappingsQueryParams o(final String value) {
            put("o", EncodingUtils.encode(value));
            return this;
        }

        public SearchFormMappingsQueryParams s(final String value) {
            put("s", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Update the FormMapping by ID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Update the FormMapping for the given ID Warning: as of 9.0.0, updating a Form Mapping using
     * this API is deprecated.
     * 
     * @param id ID of the FormMapping to return (required)
     * @param formMappingUpdateRequest Representation of the form mapping attribute to update - {&#39;pageId&#39;: (long)} or {&#39;url&#39;: (string)} or {} to set
     *        the mapping type to NONE (required)
     * @deprecated
     */
    @Deprecated
    @RequestLine("PUT /API/form/mapping/{id}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void updateFormMappingById(@Param("id") String id, FormMappingUpdateRequest formMappingUpdateRequest);

    /**
     * Update the FormMapping by ID
     * Similar to <code>updateFormMappingById</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Update the FormMapping for the given ID Warning: as of 9.0.0, updating a Form Mapping using
     * this API is deprecated.
     * 
     * @param id ID of the FormMapping to return (required)
     * @param formMappingUpdateRequest Representation of the form mapping attribute to update - {&#39;pageId&#39;: (long)} or {&#39;url&#39;: (string)} or {} to set
     *        the mapping type to NONE (required)
     * @deprecated
     */
    @Deprecated
    @RequestLine("PUT /API/form/mapping/{id}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<Void> updateFormMappingByIdWithHttpInfo(@Param("id") String id,
            FormMappingUpdateRequest formMappingUpdateRequest);

}
