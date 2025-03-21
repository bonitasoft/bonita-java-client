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
import org.bonitasoft.web.client.model.ArchivedFlowNode;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public interface ArchivedFlowNodeApi extends ApiClient.Api {

    /**
     * Finds the ArchivedFlowNode by ID
     * Returns the single ArchivedFlowNode for the given ID
     * 
     * @param id ID of the ArchivedFlowNode to return (required)
     * @return ArchivedFlowNode
     */
    @RequestLine("GET /API/bpm/archivedFlowNode/{id}")
    @Headers({
            "Accept: application/json",
    })
    ArchivedFlowNode getArchivedFlowNodeById(@Param("id") String id);

    /**
     * Finds the ArchivedFlowNode by ID
     * Similar to <code>getArchivedFlowNodeById</code> but it also returns the http response headers .
     * Returns the single ArchivedFlowNode for the given ID
     * 
     * @param id ID of the ArchivedFlowNode to return (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/archivedFlowNode/{id}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<ArchivedFlowNode> getArchivedFlowNodeByIdWithHttpInfo(@Param("id") String id);

    /**
     * Finds ArchivedFlowNodes
     * Finds ArchivedFlowNodes with pagination params and filters - can order on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;type&#x60;,
     * &#x60;isTerminal&#x60;, &#x60;processId&#x60;, &#x60;caseId&#x60;, &#x60;archivedDate&#x60; - can search on any field that can be used to order results - can
     * filter on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;stateId&#x60;, &#x60;kind&#x60;, &#x60;terminal&#x60;,
     * &#x60;processDefinitionId&#x60;, &#x60;parentProcessInstanceId&#x60;, &#x60;rootProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60;,
     * &#x60;archivedDate&#x60;, &#x60;reachedStateDate&#x60;, &#x60;sourceObjectId&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return List&lt;ArchivedFlowNode&gt;
     */
    @RequestLine("GET /API/bpm/archivedFlowNode?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<ArchivedFlowNode> searchArchivedFlowNodes(@Param("p") Integer p, @Param("c") Integer c,
            @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

    /**
     * Finds ArchivedFlowNodes
     * Similar to <code>searchArchivedFlowNodes</code> but it also returns the http response headers .
     * Finds ArchivedFlowNodes with pagination params and filters - can order on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;type&#x60;,
     * &#x60;isTerminal&#x60;, &#x60;processId&#x60;, &#x60;caseId&#x60;, &#x60;archivedDate&#x60; - can search on any field that can be used to order results - can
     * filter on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;stateId&#x60;, &#x60;kind&#x60;, &#x60;terminal&#x60;,
     * &#x60;processDefinitionId&#x60;, &#x60;parentProcessInstanceId&#x60;, &#x60;rootProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60;,
     * &#x60;archivedDate&#x60;, &#x60;reachedStateDate&#x60;, &#x60;sourceObjectId&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/archivedFlowNode?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ArchivedFlowNode>> searchArchivedFlowNodesWithHttpInfo(@Param("p") Integer p,
            @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

    /**
     * Finds ArchivedFlowNodes
     * Finds ArchivedFlowNodes with pagination params and filters - can order on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;type&#x60;,
     * &#x60;isTerminal&#x60;, &#x60;processId&#x60;, &#x60;caseId&#x60;, &#x60;archivedDate&#x60; - can search on any field that can be used to order results - can
     * filter on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;stateId&#x60;, &#x60;kind&#x60;, &#x60;terminal&#x60;,
     * &#x60;processDefinitionId&#x60;, &#x60;parentProcessInstanceId&#x60;, &#x60;rootProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60;,
     * &#x60;archivedDate&#x60;, &#x60;reachedStateDate&#x60;, &#x60;sourceObjectId&#x60;
     * Note, this is equivalent to the other <code>searchArchivedFlowNodes</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchArchivedFlowNodesQueryParams} class that allows for
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
     * @return List&lt;ArchivedFlowNode&gt;
     */
    @RequestLine("GET /API/bpm/archivedFlowNode?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<ArchivedFlowNode> searchArchivedFlowNodes(
            @QueryMap(encoded = true) SearchArchivedFlowNodesQueryParams queryParams);

    /**
     * Finds ArchivedFlowNodes
     * Finds ArchivedFlowNodes with pagination params and filters - can order on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;type&#x60;,
     * &#x60;isTerminal&#x60;, &#x60;processId&#x60;, &#x60;caseId&#x60;, &#x60;archivedDate&#x60; - can search on any field that can be used to order results - can
     * filter on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;stateId&#x60;, &#x60;kind&#x60;, &#x60;terminal&#x60;,
     * &#x60;processDefinitionId&#x60;, &#x60;parentProcessInstanceId&#x60;, &#x60;rootProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60;,
     * &#x60;archivedDate&#x60;, &#x60;reachedStateDate&#x60;, &#x60;sourceObjectId&#x60;
     * Note, this is equivalent to the other <code>searchArchivedFlowNodes</code> that receives the query parameters as a map,
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
     * @return List&lt;ArchivedFlowNode&gt;
     */
    @RequestLine("GET /API/bpm/archivedFlowNode?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ArchivedFlowNode>> searchArchivedFlowNodesWithHttpInfo(
            @QueryMap(encoded = true) SearchArchivedFlowNodesQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>searchArchivedFlowNodes</code> method in a fluent style.
     */
    public static class SearchArchivedFlowNodesQueryParams extends HashMap<String, Object> {

        public SearchArchivedFlowNodesQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchArchivedFlowNodesQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchArchivedFlowNodesQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }

        public SearchArchivedFlowNodesQueryParams o(final String value) {
            put("o", EncodingUtils.encode(value));
            return this;
        }

        public SearchArchivedFlowNodesQueryParams s(final String value) {
            put("s", EncodingUtils.encode(value));
            return this;
        }
    }
}
