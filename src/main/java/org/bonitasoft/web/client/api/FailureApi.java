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
import org.bonitasoft.web.client.model.BPMFailure;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public interface FailureApi extends ApiClient.Api {

    /**
     * Retrieve the archived failures of an archived case (process instance) by it&#39;s sourceObjectID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent archived failures for the given archived case sourceObjectID
     * 
     * @param caseId The original identifier (sourceObjectID) of the case from which to retrieve the failures (required)
     * @param c maximum number of elements to retrieve (required)
     * @return List&lt;ArchivedBPMFailure&gt;
     */
    @RequestLine("GET /API/bpm/achivedFailure/case/{caseId}?c={c}")
    @Headers({
            "Accept: application/json",
    })
    List<ArchivedBPMFailure> getArchivedBPMFailuresByCaseId(@Param("caseId") String caseId, @Param("c") Integer c);

    /**
     * Retrieve the archived failures of an archived case (process instance) by it&#39;s sourceObjectID
     * Similar to <code>getArchivedBPMFailuresByCaseId</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent archived failures for the given archived case sourceObjectID
     * 
     * @param caseId The original identifier (sourceObjectID) of the case from which to retrieve the failures (required)
     * @param c maximum number of elements to retrieve (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/achivedFailure/case/{caseId}?c={c}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ArchivedBPMFailure>> getArchivedBPMFailuresByCaseIdWithHttpInfo(@Param("caseId") String caseId,
            @Param("c") Integer c);

    /**
     * Retrieve the archived failures of an archived case (process instance) by it&#39;s sourceObjectID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent archived failures for the given archived case sourceObjectID
     * Note, this is equivalent to the other <code>getArchivedBPMFailuresByCaseId</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link GetArchivedBPMFailuresByCaseIdQueryParams} class that allows for
     * building up this map in a fluent style.
     * 
     * @param caseId The original identifier (sourceObjectID) of the case from which to retrieve the failures (required)
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        </ul>
     * @return List&lt;ArchivedBPMFailure&gt;
     */
    @RequestLine("GET /API/bpm/achivedFailure/case/{caseId}?c={c}")
    @Headers({
            "Accept: application/json",
    })
    List<ArchivedBPMFailure> getArchivedBPMFailuresByCaseId(@Param("caseId") String caseId,
            @QueryMap(encoded = true) GetArchivedBPMFailuresByCaseIdQueryParams queryParams);

    /**
     * Retrieve the archived failures of an archived case (process instance) by it&#39;s sourceObjectID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent archived failures for the given archived case sourceObjectID
     * Note, this is equivalent to the other <code>getArchivedBPMFailuresByCaseId</code> that receives the query parameters as a map,
     * but this one also exposes the Http response headers
     * 
     * @param caseId The original identifier (sourceObjectID) of the case from which to retrieve the failures (required)
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        </ul>
     * @return List&lt;ArchivedBPMFailure&gt;
     */
    @RequestLine("GET /API/bpm/achivedFailure/case/{caseId}?c={c}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ArchivedBPMFailure>> getArchivedBPMFailuresByCaseIdWithHttpInfo(@Param("caseId") String caseId,
            @QueryMap(encoded = true) GetArchivedBPMFailuresByCaseIdQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>getArchivedBPMFailuresByCaseId</code> method in a fluent style.
     */
    public static class GetArchivedBPMFailuresByCaseIdQueryParams extends HashMap<String, Object> {

        public GetArchivedBPMFailuresByCaseIdQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Retrieve the archived failures of the archived child cases of a root case (process instance) by it&#39;s ID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent archived failures among all the archived child cases (started by
     * call activities) of a case
     * 
     * @param rootCaseId The identifier of the root case from which to retrieve the archived failures (its sourceObjectID if the root case is archived) (required)
     * @param c maximum number of elements to retrieve (required)
     * @return List&lt;ArchivedBPMFailure&gt;
     */
    @RequestLine("GET /API/bpm/achivedFailure/case/{rootCaseId}/childCases?c={c}")
    @Headers({
            "Accept: application/json",
    })
    List<ArchivedBPMFailure> getArchivedBPMFailuresByRootCaseId(@Param("rootCaseId") String rootCaseId,
            @Param("c") Integer c);

    /**
     * Retrieve the archived failures of the archived child cases of a root case (process instance) by it&#39;s ID
     * Similar to <code>getArchivedBPMFailuresByRootCaseId</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent archived failures among all the archived child cases (started by
     * call activities) of a case
     * 
     * @param rootCaseId The identifier of the root case from which to retrieve the archived failures (its sourceObjectID if the root case is archived) (required)
     * @param c maximum number of elements to retrieve (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/achivedFailure/case/{rootCaseId}/childCases?c={c}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ArchivedBPMFailure>> getArchivedBPMFailuresByRootCaseIdWithHttpInfo(
            @Param("rootCaseId") String rootCaseId, @Param("c") Integer c);

    /**
     * Retrieve the archived failures of the archived child cases of a root case (process instance) by it&#39;s ID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent archived failures among all the archived child cases (started by
     * call activities) of a case
     * Note, this is equivalent to the other <code>getArchivedBPMFailuresByRootCaseId</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link GetArchivedBPMFailuresByRootCaseIdQueryParams} class that allows for
     * building up this map in a fluent style.
     * 
     * @param rootCaseId The identifier of the root case from which to retrieve the archived failures (its sourceObjectID if the root case is archived) (required)
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        </ul>
     * @return List&lt;ArchivedBPMFailure&gt;
     */
    @RequestLine("GET /API/bpm/achivedFailure/case/{rootCaseId}/childCases?c={c}")
    @Headers({
            "Accept: application/json",
    })
    List<ArchivedBPMFailure> getArchivedBPMFailuresByRootCaseId(@Param("rootCaseId") String rootCaseId,
            @QueryMap(encoded = true) GetArchivedBPMFailuresByRootCaseIdQueryParams queryParams);

    /**
     * Retrieve the archived failures of the archived child cases of a root case (process instance) by it&#39;s ID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent archived failures among all the archived child cases (started by
     * call activities) of a case
     * Note, this is equivalent to the other <code>getArchivedBPMFailuresByRootCaseId</code> that receives the query parameters as a map,
     * but this one also exposes the Http response headers
     * 
     * @param rootCaseId The identifier of the root case from which to retrieve the archived failures (its sourceObjectID if the root case is archived) (required)
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        </ul>
     * @return List&lt;ArchivedBPMFailure&gt;
     */
    @RequestLine("GET /API/bpm/achivedFailure/case/{rootCaseId}/childCases?c={c}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ArchivedBPMFailure>> getArchivedBPMFailuresByRootCaseIdWithHttpInfo(
            @Param("rootCaseId") String rootCaseId,
            @QueryMap(encoded = true) GetArchivedBPMFailuresByRootCaseIdQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>getArchivedBPMFailuresByRootCaseId</code> method in a fluent style.
     */
    public static class GetArchivedBPMFailuresByRootCaseIdQueryParams extends HashMap<String, Object> {

        public GetArchivedBPMFailuresByRootCaseIdQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Retrieve the failures of a case (process instance) by it&#39;s ID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent failures for the given case
     * 
     * @param caseId The identifier of the case from which to retrieve the failures (required)
     * @param c maximum number of elements to retrieve (required)
     * @return List&lt;BPMFailure&gt;
     */
    @RequestLine("GET /API/bpm/failure/case/{caseId}?c={c}")
    @Headers({
            "Accept: application/json",
    })
    List<BPMFailure> getBPMFailuresByCaseId(@Param("caseId") String caseId, @Param("c") Integer c);

    /**
     * Retrieve the failures of a case (process instance) by it&#39;s ID
     * Similar to <code>getBPMFailuresByCaseId</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent failures for the given case
     * 
     * @param caseId The identifier of the case from which to retrieve the failures (required)
     * @param c maximum number of elements to retrieve (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/failure/case/{caseId}?c={c}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<BPMFailure>> getBPMFailuresByCaseIdWithHttpInfo(@Param("caseId") String caseId,
            @Param("c") Integer c);

    /**
     * Retrieve the failures of a case (process instance) by it&#39;s ID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent failures for the given case
     * Note, this is equivalent to the other <code>getBPMFailuresByCaseId</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link GetBPMFailuresByCaseIdQueryParams} class that allows for
     * building up this map in a fluent style.
     * 
     * @param caseId The identifier of the case from which to retrieve the failures (required)
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        </ul>
     * @return List&lt;BPMFailure&gt;
     */
    @RequestLine("GET /API/bpm/failure/case/{caseId}?c={c}")
    @Headers({
            "Accept: application/json",
    })
    List<BPMFailure> getBPMFailuresByCaseId(@Param("caseId") String caseId,
            @QueryMap(encoded = true) GetBPMFailuresByCaseIdQueryParams queryParams);

    /**
     * Retrieve the failures of a case (process instance) by it&#39;s ID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent failures for the given case
     * Note, this is equivalent to the other <code>getBPMFailuresByCaseId</code> that receives the query parameters as a map,
     * but this one also exposes the Http response headers
     * 
     * @param caseId The identifier of the case from which to retrieve the failures (required)
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        </ul>
     * @return List&lt;BPMFailure&gt;
     */
    @RequestLine("GET /API/bpm/failure/case/{caseId}?c={c}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<BPMFailure>> getBPMFailuresByCaseIdWithHttpInfo(@Param("caseId") String caseId,
            @QueryMap(encoded = true) GetBPMFailuresByCaseIdQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>getBPMFailuresByCaseId</code> method in a fluent style.
     */
    public static class GetBPMFailuresByCaseIdQueryParams extends HashMap<String, Object> {

        public GetBPMFailuresByCaseIdQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Retrieve the failures of a flownode instance by it&#39;s ID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent failures for the given flownode ID
     * 
     * @param flowNodeInstanceId The identifier of the flownode instance from which to retrieve the failures (required)
     * @param c maximum number of elements to retrieve (required)
     * @return List&lt;BPMFailure&gt;
     */
    @RequestLine("GET /API/bpm/failure/flowNode/{flowNodeInstanceId}?c={c}")
    @Headers({
            "Accept: application/json",
    })
    List<BPMFailure> getBPMFailuresByFlowNodeInstanceId(@Param("flowNodeInstanceId") String flowNodeInstanceId,
            @Param("c") Integer c);

    /**
     * Retrieve the failures of a flownode instance by it&#39;s ID
     * Similar to <code>getBPMFailuresByFlowNodeInstanceId</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent failures for the given flownode ID
     * 
     * @param flowNodeInstanceId The identifier of the flownode instance from which to retrieve the failures (required)
     * @param c maximum number of elements to retrieve (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/failure/flowNode/{flowNodeInstanceId}?c={c}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<BPMFailure>> getBPMFailuresByFlowNodeInstanceIdWithHttpInfo(
            @Param("flowNodeInstanceId") String flowNodeInstanceId, @Param("c") Integer c);

    /**
     * Retrieve the failures of a flownode instance by it&#39;s ID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent failures for the given flownode ID
     * Note, this is equivalent to the other <code>getBPMFailuresByFlowNodeInstanceId</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link GetBPMFailuresByFlowNodeInstanceIdQueryParams} class that allows for
     * building up this map in a fluent style.
     * 
     * @param flowNodeInstanceId The identifier of the flownode instance from which to retrieve the failures (required)
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        </ul>
     * @return List&lt;BPMFailure&gt;
     */
    @RequestLine("GET /API/bpm/failure/flowNode/{flowNodeInstanceId}?c={c}")
    @Headers({
            "Accept: application/json",
    })
    List<BPMFailure> getBPMFailuresByFlowNodeInstanceId(@Param("flowNodeInstanceId") String flowNodeInstanceId,
            @QueryMap(encoded = true) GetBPMFailuresByFlowNodeInstanceIdQueryParams queryParams);

    /**
     * Retrieve the failures of a flownode instance by it&#39;s ID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent failures for the given flownode ID
     * Note, this is equivalent to the other <code>getBPMFailuresByFlowNodeInstanceId</code> that receives the query parameters as a map,
     * but this one also exposes the Http response headers
     * 
     * @param flowNodeInstanceId The identifier of the flownode instance from which to retrieve the failures (required)
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        </ul>
     * @return List&lt;BPMFailure&gt;
     */
    @RequestLine("GET /API/bpm/failure/flowNode/{flowNodeInstanceId}?c={c}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<BPMFailure>> getBPMFailuresByFlowNodeInstanceIdWithHttpInfo(
            @Param("flowNodeInstanceId") String flowNodeInstanceId,
            @QueryMap(encoded = true) GetBPMFailuresByFlowNodeInstanceIdQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>getBPMFailuresByFlowNodeInstanceId</code> method in a fluent style.
     */
    public static class GetBPMFailuresByFlowNodeInstanceIdQueryParams extends HashMap<String, Object> {

        public GetBPMFailuresByFlowNodeInstanceIdQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Retrieve the failures of the child cases of a root case (process instance) by it&#39;s ID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent failures among all the child cases (started by call activities) of a
     * case
     * 
     * @param rootCaseId The identifier of the root case from which to retrieve the failures (its sourceObjectID if the root case is archived) (required)
     * @param c maximum number of elements to retrieve (required)
     * @return List&lt;BPMFailure&gt;
     */
    @RequestLine("GET /API/bpm/failure/case/{rootCaseId}/childCases?c={c}")
    @Headers({
            "Accept: application/json",
    })
    List<BPMFailure> getBPMFailuresByRootCaseId(@Param("rootCaseId") String rootCaseId, @Param("c") Integer c);

    /**
     * Retrieve the failures of the child cases of a root case (process instance) by it&#39;s ID
     * Similar to <code>getBPMFailuresByRootCaseId</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent failures among all the child cases (started by call activities) of a
     * case
     * 
     * @param rootCaseId The identifier of the root case from which to retrieve the failures (its sourceObjectID if the root case is archived) (required)
     * @param c maximum number of elements to retrieve (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/failure/case/{rootCaseId}/childCases?c={c}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<BPMFailure>> getBPMFailuresByRootCaseIdWithHttpInfo(@Param("rootCaseId") String rootCaseId,
            @Param("c") Integer c);

    /**
     * Retrieve the failures of the child cases of a root case (process instance) by it&#39;s ID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent failures among all the child cases (started by call activities) of a
     * case
     * Note, this is equivalent to the other <code>getBPMFailuresByRootCaseId</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link GetBPMFailuresByRootCaseIdQueryParams} class that allows for
     * building up this map in a fluent style.
     * 
     * @param rootCaseId The identifier of the root case from which to retrieve the failures (its sourceObjectID if the root case is archived) (required)
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        </ul>
     * @return List&lt;BPMFailure&gt;
     */
    @RequestLine("GET /API/bpm/failure/case/{rootCaseId}/childCases?c={c}")
    @Headers({
            "Accept: application/json",
    })
    List<BPMFailure> getBPMFailuresByRootCaseId(@Param("rootCaseId") String rootCaseId,
            @QueryMap(encoded = true) GetBPMFailuresByRootCaseIdQueryParams queryParams);

    /**
     * Retrieve the failures of the child cases of a root case (process instance) by it&#39;s ID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the most recent failures among all the child cases (started by call activities) of a
     * case
     * Note, this is equivalent to the other <code>getBPMFailuresByRootCaseId</code> that receives the query parameters as a map,
     * but this one also exposes the Http response headers
     * 
     * @param rootCaseId The identifier of the root case from which to retrieve the failures (its sourceObjectID if the root case is archived) (required)
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        </ul>
     * @return List&lt;BPMFailure&gt;
     */
    @RequestLine("GET /API/bpm/failure/case/{rootCaseId}/childCases?c={c}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<BPMFailure>> getBPMFailuresByRootCaseIdWithHttpInfo(@Param("rootCaseId") String rootCaseId,
            @QueryMap(encoded = true) GetBPMFailuresByRootCaseIdQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>getBPMFailuresByRootCaseId</code> method in a fluent style.
     */
    public static class GetBPMFailuresByRootCaseIdQueryParams extends HashMap<String, Object> {

        public GetBPMFailuresByRootCaseIdQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }
    }
}
