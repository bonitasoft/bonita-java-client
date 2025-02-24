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
import org.bonitasoft.web.client.model.ConnectorInstance;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public interface ConnectorInstanceApi extends ApiClient.Api {

    /**
     * Finds ConnectorInstances
     * Finds ConnectorInstances attached to a process or a flow node with pagination params and filters. You can filter on: * &#x60;containerId&#x60;: the process
     * instance or flow node instance ID * &#x60;state&#x60;: the connector state &#x60;TO_BE_EXECUTED&#x60;, &#x60;EXECUTING&#x60;, &#x60;TO_RE_EXECUTE&#x60;,
     * &#x60;DONE&#x60;, &#x60;FAILED&#x60;, &#x60;SKIPPED&#x60; * &#x60;containerType&#x60;: the type of container: either &#x60;flowNode&#x60; or
     * &#x60;process&#x60; (since version 10.3 - 2025.1) * &#x60;name&#x60;: the connector name (since version 10.3 - 2025.1) * &#x60;version&#x60;: the connector
     * version (since version 10.3 - 2025.1) * &#x60;connectorId&#x60;: the connector definition ID (since version 10.3 - 2025.1) * &#x60;activationEvent&#x60;: the
     * container event on which the connector is instanciated: either &#x60;ON_ENTER&#x60; or &#x60;ON_FINISH&#x60; (since version 10.3 - 2025.1)
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return List&lt;ConnectorInstance&gt;
     */
    @RequestLine("GET /API/bpm/connectorInstance?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<ConnectorInstance> searchConnectorInstances(@Param("p") Integer p, @Param("c") Integer c,
            @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

    /**
     * Finds ConnectorInstances
     * Similar to <code>searchConnectorInstances</code> but it also returns the http response headers .
     * Finds ConnectorInstances attached to a process or a flow node with pagination params and filters. You can filter on: * &#x60;containerId&#x60;: the process
     * instance or flow node instance ID * &#x60;state&#x60;: the connector state &#x60;TO_BE_EXECUTED&#x60;, &#x60;EXECUTING&#x60;, &#x60;TO_RE_EXECUTE&#x60;,
     * &#x60;DONE&#x60;, &#x60;FAILED&#x60;, &#x60;SKIPPED&#x60; * &#x60;containerType&#x60;: the type of container: either &#x60;flowNode&#x60; or
     * &#x60;process&#x60; (since version 10.3 - 2025.1) * &#x60;name&#x60;: the connector name (since version 10.3 - 2025.1) * &#x60;version&#x60;: the connector
     * version (since version 10.3 - 2025.1) * &#x60;connectorId&#x60;: the connector definition ID (since version 10.3 - 2025.1) * &#x60;activationEvent&#x60;: the
     * container event on which the connector is instanciated: either &#x60;ON_ENTER&#x60; or &#x60;ON_FINISH&#x60; (since version 10.3 - 2025.1)
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/connectorInstance?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ConnectorInstance>> searchConnectorInstancesWithHttpInfo(@Param("p") Integer p,
            @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

    /**
     * Finds ConnectorInstances
     * Finds ConnectorInstances attached to a process or a flow node with pagination params and filters. You can filter on: * &#x60;containerId&#x60;: the process
     * instance or flow node instance ID * &#x60;state&#x60;: the connector state &#x60;TO_BE_EXECUTED&#x60;, &#x60;EXECUTING&#x60;, &#x60;TO_RE_EXECUTE&#x60;,
     * &#x60;DONE&#x60;, &#x60;FAILED&#x60;, &#x60;SKIPPED&#x60; * &#x60;containerType&#x60;: the type of container: either &#x60;flowNode&#x60; or
     * &#x60;process&#x60; (since version 10.3 - 2025.1) * &#x60;name&#x60;: the connector name (since version 10.3 - 2025.1) * &#x60;version&#x60;: the connector
     * version (since version 10.3 - 2025.1) * &#x60;connectorId&#x60;: the connector definition ID (since version 10.3 - 2025.1) * &#x60;activationEvent&#x60;: the
     * container event on which the connector is instanciated: either &#x60;ON_ENTER&#x60; or &#x60;ON_FINISH&#x60; (since version 10.3 - 2025.1)
     * Note, this is equivalent to the other <code>searchConnectorInstances</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchConnectorInstancesQueryParams} class that allows for
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
     * @return List&lt;ConnectorInstance&gt;
     */
    @RequestLine("GET /API/bpm/connectorInstance?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<ConnectorInstance> searchConnectorInstances(
            @QueryMap(encoded = true) SearchConnectorInstancesQueryParams queryParams);

    /**
     * Finds ConnectorInstances
     * Finds ConnectorInstances attached to a process or a flow node with pagination params and filters. You can filter on: * &#x60;containerId&#x60;: the process
     * instance or flow node instance ID * &#x60;state&#x60;: the connector state &#x60;TO_BE_EXECUTED&#x60;, &#x60;EXECUTING&#x60;, &#x60;TO_RE_EXECUTE&#x60;,
     * &#x60;DONE&#x60;, &#x60;FAILED&#x60;, &#x60;SKIPPED&#x60; * &#x60;containerType&#x60;: the type of container: either &#x60;flowNode&#x60; or
     * &#x60;process&#x60; (since version 10.3 - 2025.1) * &#x60;name&#x60;: the connector name (since version 10.3 - 2025.1) * &#x60;version&#x60;: the connector
     * version (since version 10.3 - 2025.1) * &#x60;connectorId&#x60;: the connector definition ID (since version 10.3 - 2025.1) * &#x60;activationEvent&#x60;: the
     * container event on which the connector is instanciated: either &#x60;ON_ENTER&#x60; or &#x60;ON_FINISH&#x60; (since version 10.3 - 2025.1)
     * Note, this is equivalent to the other <code>searchConnectorInstances</code> that receives the query parameters as a map,
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
     * @return List&lt;ConnectorInstance&gt;
     */
    @RequestLine("GET /API/bpm/connectorInstance?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ConnectorInstance>> searchConnectorInstancesWithHttpInfo(
            @QueryMap(encoded = true) SearchConnectorInstancesQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>searchConnectorInstances</code> method in a fluent style.
     */
    public static class SearchConnectorInstancesQueryParams extends HashMap<String, Object> {

        public SearchConnectorInstancesQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchConnectorInstancesQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchConnectorInstancesQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }

        public SearchConnectorInstancesQueryParams o(final String value) {
            put("o", EncodingUtils.encode(value));
            return this;
        }

        public SearchConnectorInstancesQueryParams s(final String value) {
            put("s", EncodingUtils.encode(value));
            return this;
        }
    }
}
