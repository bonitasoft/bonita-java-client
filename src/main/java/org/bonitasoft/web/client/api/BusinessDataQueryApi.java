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

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public interface BusinessDataQueryApi extends ApiClient.Api {

    /**
     * Finds Business Data
     * Finds Business Data with pagination params and filters by calling a &#x60;Named Query&#x60;. The business data query REST API resource is used to call a
     * default or custom business data query. It is available from version 6.5. **Data parameters**: * businessDataType - the fully-qualified business data type
     * name * q&#x3D;queryName - the query name * p&#x3D;0 - the page number * c&#x3D;10 - the maximum number of results in the page * f&#x3D;parameter&#x3D;value -
     * sets the parameter value according to business data query parameters defined in Bonita Studio For a Boolean parameter, the accepted values are
     * &#x60;true&#x60; or &#x60;false&#x60;. By default, for a Date parameter can use the following formats: * yyyy-MM-dd * HH:mm:ss * yyyy-MM-dd HH:mm:ss *
     * yyyy-MM-dd&#39;T&#39;HH:mm:ss * yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSS
     * 
     * @param businessDataType Business Data Type (required)
     * @param q Named query to use (required)
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @return List&lt;Object&gt;
     */
    @RequestLine("GET /API/bdm/businessData/{businessDataType}?q={q}&p={p}&c={c}&f={f}")
    @Headers({
            "Accept: application/json",
    })
    List<Object> searchBusinessData(@Param("businessDataType") String businessDataType, @Param("q") String q,
            @Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f);

    /**
     * Finds Business Data
     * Similar to <code>searchBusinessData</code> but it also returns the http response headers .
     * Finds Business Data with pagination params and filters by calling a &#x60;Named Query&#x60;. The business data query REST API resource is used to call a
     * default or custom business data query. It is available from version 6.5. **Data parameters**: * businessDataType - the fully-qualified business data type
     * name * q&#x3D;queryName - the query name * p&#x3D;0 - the page number * c&#x3D;10 - the maximum number of results in the page * f&#x3D;parameter&#x3D;value -
     * sets the parameter value according to business data query parameters defined in Bonita Studio For a Boolean parameter, the accepted values are
     * &#x60;true&#x60; or &#x60;false&#x60;. By default, for a Date parameter can use the following formats: * yyyy-MM-dd * HH:mm:ss * yyyy-MM-dd HH:mm:ss *
     * yyyy-MM-dd&#39;T&#39;HH:mm:ss * yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSS
     * 
     * @param businessDataType Business Data Type (required)
     * @param q Named query to use (required)
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bdm/businessData/{businessDataType}?q={q}&p={p}&c={c}&f={f}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<Object>> searchBusinessDataWithHttpInfo(@Param("businessDataType") String businessDataType,
            @Param("q") String q, @Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f);

    /**
     * Finds Business Data
     * Finds Business Data with pagination params and filters by calling a &#x60;Named Query&#x60;. The business data query REST API resource is used to call a
     * default or custom business data query. It is available from version 6.5. **Data parameters**: * businessDataType - the fully-qualified business data type
     * name * q&#x3D;queryName - the query name * p&#x3D;0 - the page number * c&#x3D;10 - the maximum number of results in the page * f&#x3D;parameter&#x3D;value -
     * sets the parameter value according to business data query parameters defined in Bonita Studio For a Boolean parameter, the accepted values are
     * &#x60;true&#x60; or &#x60;false&#x60;. By default, for a Date parameter can use the following formats: * yyyy-MM-dd * HH:mm:ss * yyyy-MM-dd HH:mm:ss *
     * yyyy-MM-dd&#39;T&#39;HH:mm:ss * yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSS
     * Note, this is equivalent to the other <code>searchBusinessData</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchBusinessDataQueryParams} class that allows for
     * building up this map in a fluent style.
     * 
     * @param businessDataType Business Data Type (required)
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>q - Named query to use (required)</li>
     *        <li>p - index of the page to display (required)</li>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string.
     *        (optional)</li>
     *        </ul>
     * @return List&lt;Object&gt;
     */
    @RequestLine("GET /API/bdm/businessData/{businessDataType}?q={q}&p={p}&c={c}&f={f}")
    @Headers({
            "Accept: application/json",
    })
    List<Object> searchBusinessData(@Param("businessDataType") String businessDataType,
            @QueryMap(encoded = true) SearchBusinessDataQueryParams queryParams);

    /**
     * Finds Business Data
     * Finds Business Data with pagination params and filters by calling a &#x60;Named Query&#x60;. The business data query REST API resource is used to call a
     * default or custom business data query. It is available from version 6.5. **Data parameters**: * businessDataType - the fully-qualified business data type
     * name * q&#x3D;queryName - the query name * p&#x3D;0 - the page number * c&#x3D;10 - the maximum number of results in the page * f&#x3D;parameter&#x3D;value -
     * sets the parameter value according to business data query parameters defined in Bonita Studio For a Boolean parameter, the accepted values are
     * &#x60;true&#x60; or &#x60;false&#x60;. By default, for a Date parameter can use the following formats: * yyyy-MM-dd * HH:mm:ss * yyyy-MM-dd HH:mm:ss *
     * yyyy-MM-dd&#39;T&#39;HH:mm:ss * yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSS
     * Note, this is equivalent to the other <code>searchBusinessData</code> that receives the query parameters as a map,
     * but this one also exposes the Http response headers
     * 
     * @param businessDataType Business Data Type (required)
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>q - Named query to use (required)</li>
     *        <li>p - index of the page to display (required)</li>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string.
     *        (optional)</li>
     *        </ul>
     * @return List&lt;Object&gt;
     */
    @RequestLine("GET /API/bdm/businessData/{businessDataType}?q={q}&p={p}&c={c}&f={f}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<Object>> searchBusinessDataWithHttpInfo(@Param("businessDataType") String businessDataType,
            @QueryMap(encoded = true) SearchBusinessDataQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>searchBusinessData</code> method in a fluent style.
     */
    public static class SearchBusinessDataQueryParams extends HashMap<String, Object> {

        public SearchBusinessDataQueryParams q(final String value) {
            put("q", EncodingUtils.encode(value));
            return this;
        }

        public SearchBusinessDataQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchBusinessDataQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchBusinessDataQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }
    }
}
