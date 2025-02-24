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
import org.bonitasoft.web.client.model.ArchivedBPMFailure;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public interface ArchivedFailureApi extends ApiClient.Api {

    /**
     * Retrieve the archived failures of an archived flownode instance by it&#39;s sourceObjectID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent failures for the given archived flownode sourceObjectID
     * 
     * @param flowNodeInstanceId The original identifier (sourceObjectID) of the flownode instance from which to retrieve the failures (required)
     * @param c maximum number of elements to retrieve (required)
     * @return List&lt;ArchivedBPMFailure&gt;
     */
    @RequestLine("GET /API/bpm/achivedFailure/flowNode/{flowNodeInstanceId}?c={c}")
    @Headers({
            "Accept: application/json",
    })
    List<ArchivedBPMFailure> getArchivedBPMFailuresByFlowNodeInstanceId(
            @Param("flowNodeInstanceId") String flowNodeInstanceId, @Param("c") Integer c);

    /**
     * Retrieve the archived failures of an archived flownode instance by it&#39;s sourceObjectID
     * Similar to <code>getArchivedBPMFailuresByFlowNodeInstanceId</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent failures for the given archived flownode sourceObjectID
     * 
     * @param flowNodeInstanceId The original identifier (sourceObjectID) of the flownode instance from which to retrieve the failures (required)
     * @param c maximum number of elements to retrieve (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/achivedFailure/flowNode/{flowNodeInstanceId}?c={c}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ArchivedBPMFailure>> getArchivedBPMFailuresByFlowNodeInstanceIdWithHttpInfo(
            @Param("flowNodeInstanceId") String flowNodeInstanceId, @Param("c") Integer c);

    /**
     * Retrieve the archived failures of an archived flownode instance by it&#39;s sourceObjectID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent failures for the given archived flownode sourceObjectID
     * Note, this is equivalent to the other <code>getArchivedBPMFailuresByFlowNodeInstanceId</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link GetArchivedBPMFailuresByFlowNodeInstanceIdQueryParams} class that allows for
     * building up this map in a fluent style.
     * 
     * @param flowNodeInstanceId The original identifier (sourceObjectID) of the flownode instance from which to retrieve the failures (required)
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        </ul>
     * @return List&lt;ArchivedBPMFailure&gt;
     */
    @RequestLine("GET /API/bpm/achivedFailure/flowNode/{flowNodeInstanceId}?c={c}")
    @Headers({
            "Accept: application/json",
    })
    List<ArchivedBPMFailure> getArchivedBPMFailuresByFlowNodeInstanceId(
            @Param("flowNodeInstanceId") String flowNodeInstanceId,
            @QueryMap(encoded = true) GetArchivedBPMFailuresByFlowNodeInstanceIdQueryParams queryParams);

    /**
     * Retrieve the archived failures of an archived flownode instance by it&#39;s sourceObjectID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent failures for the given archived flownode sourceObjectID
     * Note, this is equivalent to the other <code>getArchivedBPMFailuresByFlowNodeInstanceId</code> that receives the query parameters as a map,
     * but this one also exposes the Http response headers
     * 
     * @param flowNodeInstanceId The original identifier (sourceObjectID) of the flownode instance from which to retrieve the failures (required)
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        </ul>
     * @return List&lt;ArchivedBPMFailure&gt;
     */
    @RequestLine("GET /API/bpm/achivedFailure/flowNode/{flowNodeInstanceId}?c={c}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ArchivedBPMFailure>> getArchivedBPMFailuresByFlowNodeInstanceIdWithHttpInfo(
            @Param("flowNodeInstanceId") String flowNodeInstanceId,
            @QueryMap(encoded = true) GetArchivedBPMFailuresByFlowNodeInstanceIdQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>getArchivedBPMFailuresByFlowNodeInstanceId</code> method in a fluent style.
     */
    public static class GetArchivedBPMFailuresByFlowNodeInstanceIdQueryParams extends HashMap<String, Object> {

        public GetArchivedBPMFailuresByFlowNodeInstanceIdQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }
    }
}
