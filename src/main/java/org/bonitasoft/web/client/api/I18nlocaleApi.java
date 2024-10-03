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
import org.bonitasoft.web.client.model.I18nlocale;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.8.0")
public interface I18nlocaleApi extends ApiClient.Api {

    /**
     * Finds I18nlocales
     * List the available I18nlocales with pagination params and filters
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @return List&lt;I18nlocale&gt;
     */
    @RequestLine("GET /API/system/i18nlocale?p={p}&c={c}")
    @Headers({
            "Accept: application/json",
    })
    List<I18nlocale> searchI18nlocales(@Param("p") Integer p, @Param("c") Integer c);

    /**
     * Finds I18nlocales
     * Similar to <code>searchI18nlocales</code> but it also returns the http response headers .
     * List the available I18nlocales with pagination params and filters
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/system/i18nlocale?p={p}&c={c}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<I18nlocale>> searchI18nlocalesWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c);

    /**
     * Finds I18nlocales
     * List the available I18nlocales with pagination params and filters
     * Note, this is equivalent to the other <code>searchI18nlocales</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchI18nlocalesQueryParams} class that allows for
     * building up this map in a fluent style.
     * 
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>p - index of the page to display (required)</li>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        </ul>
     * @return List&lt;I18nlocale&gt;
     */
    @RequestLine("GET /API/system/i18nlocale?p={p}&c={c}")
    @Headers({
            "Accept: application/json",
    })
    List<I18nlocale> searchI18nlocales(@QueryMap(encoded = true) SearchI18nlocalesQueryParams queryParams);

    /**
     * Finds I18nlocales
     * List the available I18nlocales with pagination params and filters
     * Note, this is equivalent to the other <code>searchI18nlocales</code> that receives the query parameters as a map,
     * but this one also exposes the Http response headers
     * 
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>p - index of the page to display (required)</li>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        </ul>
     * @return List&lt;I18nlocale&gt;
     */
    @RequestLine("GET /API/system/i18nlocale?p={p}&c={c}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<I18nlocale>> searchI18nlocalesWithHttpInfo(
            @QueryMap(encoded = true) SearchI18nlocalesQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>searchI18nlocales</code> method in a fluent style.
     */
    public static class SearchI18nlocalesQueryParams extends HashMap<String, Object> {

        public SearchI18nlocalesQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchI18nlocalesQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }
    }
}
