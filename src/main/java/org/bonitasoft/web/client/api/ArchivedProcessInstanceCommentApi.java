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
import org.bonitasoft.web.client.model.ArchivedProcessInstanceComment;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public interface ArchivedProcessInstanceCommentApi extends ApiClient.Api {

    /**
     * Finds ArchivedProcessInstanceComments
     * Finds ArchivedProcessInstanceComments with pagination params and filters - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter
     * on &#x60;displayName&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return List&lt;ArchivedProcessInstanceComment&gt;
     */
    @RequestLine("GET /API/bpm/archivedComment?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<ArchivedProcessInstanceComment> searchArchivedProcessInstanceComments(@Param("p") Integer p,
            @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

    /**
     * Finds ArchivedProcessInstanceComments
     * Similar to <code>searchArchivedProcessInstanceComments</code> but it also returns the http response headers .
     * Finds ArchivedProcessInstanceComments with pagination params and filters - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter
     * on &#x60;displayName&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/archivedComment?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ArchivedProcessInstanceComment>> searchArchivedProcessInstanceCommentsWithHttpInfo(
            @Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o,
            @Param("s") String s);

    /**
     * Finds ArchivedProcessInstanceComments
     * Finds ArchivedProcessInstanceComments with pagination params and filters - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter
     * on &#x60;displayName&#x60;
     * Note, this is equivalent to the other <code>searchArchivedProcessInstanceComments</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchArchivedProcessInstanceCommentsQueryParams} class that allows for
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
     * @return List&lt;ArchivedProcessInstanceComment&gt;
     */
    @RequestLine("GET /API/bpm/archivedComment?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<ArchivedProcessInstanceComment> searchArchivedProcessInstanceComments(
            @QueryMap(encoded = true) SearchArchivedProcessInstanceCommentsQueryParams queryParams);

    /**
     * Finds ArchivedProcessInstanceComments
     * Finds ArchivedProcessInstanceComments with pagination params and filters - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter
     * on &#x60;displayName&#x60;
     * Note, this is equivalent to the other <code>searchArchivedProcessInstanceComments</code> that receives the query parameters as a map,
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
     * @return List&lt;ArchivedProcessInstanceComment&gt;
     */
    @RequestLine("GET /API/bpm/archivedComment?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ArchivedProcessInstanceComment>> searchArchivedProcessInstanceCommentsWithHttpInfo(
            @QueryMap(encoded = true) SearchArchivedProcessInstanceCommentsQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>searchArchivedProcessInstanceComments</code> method in a fluent style.
     */
    public static class SearchArchivedProcessInstanceCommentsQueryParams extends HashMap<String, Object> {

        public SearchArchivedProcessInstanceCommentsQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchArchivedProcessInstanceCommentsQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchArchivedProcessInstanceCommentsQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }

        public SearchArchivedProcessInstanceCommentsQueryParams o(final String value) {
            put("o", EncodingUtils.encode(value));
            return this;
        }

        public SearchArchivedProcessInstanceCommentsQueryParams s(final String value) {
            put("s", EncodingUtils.encode(value));
            return this;
        }
    }
}
