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
import org.bonitasoft.web.client.model.CustomUserDefinition;
import org.bonitasoft.web.client.model.CustomUserDefinitionCreateRequest;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public interface CustomUserDefinitionApi extends ApiClient.Api {

    /**
     * Create the CustomUserDefinition
     * Create the CustomUserDefinition
     * 
     * @param body Partial CustomUserDefinition description (required)
     * @return CustomUserDefinition
     */
    @RequestLine("POST /API/customuserinfo/definition")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    CustomUserDefinition createCustomUserDefinition(CustomUserDefinitionCreateRequest body);

    /**
     * Create the CustomUserDefinition
     * Similar to <code>createCustomUserDefinition</code> but it also returns the http response headers .
     * Create the CustomUserDefinition
     * 
     * @param body Partial CustomUserDefinition description (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("POST /API/customuserinfo/definition")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<CustomUserDefinition> createCustomUserDefinitionWithHttpInfo(CustomUserDefinitionCreateRequest body);

    /**
     * Delete the CustomUserDefinition by ID
     * Delete the single CustomUserDefinition for the given ID
     * 
     * @param id ID of the CustomUserDefinition to delete (required)
     */
    @RequestLine("DELETE /API/customuserinfo/definition/{id}")
    @Headers({
            "Accept: application/json",
    })
    void deleteCustomUserDefinitionById(@Param("id") String id);

    /**
     * Delete the CustomUserDefinition by ID
     * Similar to <code>deleteCustomUserDefinitionById</code> but it also returns the http response headers .
     * Delete the single CustomUserDefinition for the given ID
     * 
     * @param id ID of the CustomUserDefinition to delete (required)
     */
    @RequestLine("DELETE /API/customuserinfo/definition/{id}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<Void> deleteCustomUserDefinitionByIdWithHttpInfo(@Param("id") String id);

    /**
     * Finds the CustomUserDefinition by ID
     * Returns the single CustomUserDefinition for the given ID
     * 
     * @param id ID of the CustomUserDefinition to return (required)
     * @return CustomUserDefinition
     */
    @RequestLine("GET /API/customuserinfo/definition/{id}")
    @Headers({
            "Accept: application/json",
    })
    CustomUserDefinition getCustomUserDefinitionById(@Param("id") String id);

    /**
     * Finds the CustomUserDefinition by ID
     * Similar to <code>getCustomUserDefinitionById</code> but it also returns the http response headers .
     * Returns the single CustomUserDefinition for the given ID
     * 
     * @param id ID of the CustomUserDefinition to return (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/customuserinfo/definition/{id}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<CustomUserDefinition> getCustomUserDefinitionByIdWithHttpInfo(@Param("id") String id);

    /**
     * Finds CustomUserDefinitions
     * Finds CustomUserDefinitions. There are no filters, and no search terms. All the definitions are returned.
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @return List&lt;CustomUserDefinition&gt;
     */
    @RequestLine("GET /API/customuserinfo/definition?p={p}&c={c}")
    @Headers({
            "Accept: application/json",
    })
    List<CustomUserDefinition> searchCustomUserDefinitions(@Param("p") Integer p, @Param("c") Integer c);

    /**
     * Finds CustomUserDefinitions
     * Similar to <code>searchCustomUserDefinitions</code> but it also returns the http response headers .
     * Finds CustomUserDefinitions. There are no filters, and no search terms. All the definitions are returned.
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/customuserinfo/definition?p={p}&c={c}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<CustomUserDefinition>> searchCustomUserDefinitionsWithHttpInfo(@Param("p") Integer p,
            @Param("c") Integer c);

    /**
     * Finds CustomUserDefinitions
     * Finds CustomUserDefinitions. There are no filters, and no search terms. All the definitions are returned.
     * Note, this is equivalent to the other <code>searchCustomUserDefinitions</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchCustomUserDefinitionsQueryParams} class that allows for
     * building up this map in a fluent style.
     * 
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>p - index of the page to display (required)</li>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        </ul>
     * @return List&lt;CustomUserDefinition&gt;
     */
    @RequestLine("GET /API/customuserinfo/definition?p={p}&c={c}")
    @Headers({
            "Accept: application/json",
    })
    List<CustomUserDefinition> searchCustomUserDefinitions(
            @QueryMap(encoded = true) SearchCustomUserDefinitionsQueryParams queryParams);

    /**
     * Finds CustomUserDefinitions
     * Finds CustomUserDefinitions. There are no filters, and no search terms. All the definitions are returned.
     * Note, this is equivalent to the other <code>searchCustomUserDefinitions</code> that receives the query parameters as a map,
     * but this one also exposes the Http response headers
     * 
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>p - index of the page to display (required)</li>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        </ul>
     * @return List&lt;CustomUserDefinition&gt;
     */
    @RequestLine("GET /API/customuserinfo/definition?p={p}&c={c}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<CustomUserDefinition>> searchCustomUserDefinitionsWithHttpInfo(
            @QueryMap(encoded = true) SearchCustomUserDefinitionsQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>searchCustomUserDefinitions</code> method in a fluent style.
     */
    public static class SearchCustomUserDefinitionsQueryParams extends HashMap<String, Object> {

        public SearchCustomUserDefinitionsQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchCustomUserDefinitionsQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }
    }
}
