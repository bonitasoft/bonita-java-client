/** 
 * Copyright (C) 2026 BonitaSoft S.A.
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
import org.bonitasoft.web.client.model.Log;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public interface LogApi extends ApiClient.Api {

    /**
     * Finds the Log by ID
     * Returns the single Log for the given ID. This Web REST API is available in **Enterprise editions only**.
     * 
     * @param id ID of the Log to return (required)
     * @return Log
     */
    @RequestLine("GET /API/system/log/{id}")
    @Headers({
            "Accept: application/json",
    })
    Log getLogById(@Param("id") String id);

    /**
     * Finds the Log by ID
     * Similar to <code>getLogById</code> but it also returns the http response headers .
     * Returns the single Log for the given ID. This Web REST API is available in **Enterprise editions only**.
     * 
     * @param id ID of the Log to return (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/system/log/{id}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<Log> getLogByIdWithHttpInfo(@Param("id") String id);

    /**
     * Finds Logs
     * Finds Logs with pagination params and filters. The search returns an array of log entries. This Web REST API is available in **Enterprise editions only**. -
     * can filter on &#x60;action_scope&#x60;, &#x60;action_type&#x60;, &#x60;createdBy&#x60;, &#x60;message&#x60;, &#x60;severity&#x60; value - can search by text
     * on &#x60;action_scope&#x60;, &#x60;action_type&#x60;, &#x60;createdBy&#x60;, &#x60;message&#x60;, &#x60;severity&#x60; - can order on
     * &#x60;action_scope&#x60;, &#x60;action_type&#x60;, &#x60;creation_date&#x60;, &#x60;createdBy&#x60;, &#x60;message&#x60;, &#x60;severity&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return List&lt;Log&gt;
     */
    @RequestLine("GET /API/system/log?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<Log> searchLogs(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o,
            @Param("s") String s);

    /**
     * Finds Logs
     * Similar to <code>searchLogs</code> but it also returns the http response headers .
     * Finds Logs with pagination params and filters. The search returns an array of log entries. This Web REST API is available in **Enterprise editions only**. -
     * can filter on &#x60;action_scope&#x60;, &#x60;action_type&#x60;, &#x60;createdBy&#x60;, &#x60;message&#x60;, &#x60;severity&#x60; value - can search by text
     * on &#x60;action_scope&#x60;, &#x60;action_type&#x60;, &#x60;createdBy&#x60;, &#x60;message&#x60;, &#x60;severity&#x60; - can order on
     * &#x60;action_scope&#x60;, &#x60;action_type&#x60;, &#x60;creation_date&#x60;, &#x60;createdBy&#x60;, &#x60;message&#x60;, &#x60;severity&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/system/log?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<Log>> searchLogsWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c,
            @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

    /**
     * Finds Logs
     * Finds Logs with pagination params and filters. The search returns an array of log entries. This Web REST API is available in **Enterprise editions only**. -
     * can filter on &#x60;action_scope&#x60;, &#x60;action_type&#x60;, &#x60;createdBy&#x60;, &#x60;message&#x60;, &#x60;severity&#x60; value - can search by text
     * on &#x60;action_scope&#x60;, &#x60;action_type&#x60;, &#x60;createdBy&#x60;, &#x60;message&#x60;, &#x60;severity&#x60; - can order on
     * &#x60;action_scope&#x60;, &#x60;action_type&#x60;, &#x60;creation_date&#x60;, &#x60;createdBy&#x60;, &#x60;message&#x60;, &#x60;severity&#x60;
     * Note, this is equivalent to the other <code>searchLogs</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchLogsQueryParams} class that allows for
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
     * @return List&lt;Log&gt;
     */
    @RequestLine("GET /API/system/log?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<Log> searchLogs(@QueryMap(encoded = true) SearchLogsQueryParams queryParams);

    /**
     * Finds Logs
     * Finds Logs with pagination params and filters. The search returns an array of log entries. This Web REST API is available in **Enterprise editions only**. -
     * can filter on &#x60;action_scope&#x60;, &#x60;action_type&#x60;, &#x60;createdBy&#x60;, &#x60;message&#x60;, &#x60;severity&#x60; value - can search by text
     * on &#x60;action_scope&#x60;, &#x60;action_type&#x60;, &#x60;createdBy&#x60;, &#x60;message&#x60;, &#x60;severity&#x60; - can order on
     * &#x60;action_scope&#x60;, &#x60;action_type&#x60;, &#x60;creation_date&#x60;, &#x60;createdBy&#x60;, &#x60;message&#x60;, &#x60;severity&#x60;
     * Note, this is equivalent to the other <code>searchLogs</code> that receives the query parameters as a map,
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
     * @return List&lt;Log&gt;
     */
    @RequestLine("GET /API/system/log?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<Log>> searchLogsWithHttpInfo(@QueryMap(encoded = true) SearchLogsQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>searchLogs</code> method in a fluent style.
     */
    public static class SearchLogsQueryParams extends HashMap<String, Object> {

        public SearchLogsQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchLogsQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchLogsQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }

        public SearchLogsQueryParams o(final String value) {
            put("o", EncodingUtils.encode(value));
            return this;
        }

        public SearchLogsQueryParams s(final String value) {
            put("s", EncodingUtils.encode(value));
            return this;
        }
    }
}
