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
import org.bonitasoft.web.client.model.Actor;
import org.bonitasoft.web.client.model.ActorUpdateRequest;
import org.bonitasoft.web.client.model.ApiResponse;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public interface ActorApi extends ApiClient.Api {

    /**
     * Finds the Actor by ID
     * Returns the single Actor for the given ID
     * 
     * @param id ID of the Actor to return (required)
     * @return Actor
     */
    @RequestLine("GET /API/bpm/actor/{id}")
    @Headers({
            "Accept: application/json",
    })
    Actor getActorById(@Param("id") String id);

    /**
     * Finds the Actor by ID
     * Similar to <code>getActorById</code> but it also returns the http response headers .
     * Returns the single Actor for the given ID
     * 
     * @param id ID of the Actor to return (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/actor/{id}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<Actor> getActorByIdWithHttpInfo(@Param("id") String id);

    /**
     * Finds Actors
     * Finds Actors with pagination params and filters
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @return List&lt;Actor&gt;
     */
    @RequestLine("GET /API/bpm/actor?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    List<Actor> searchActors(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f,
            @Param("o") String o);

    /**
     * Finds Actors
     * Similar to <code>searchActors</code> but it also returns the http response headers .
     * Finds Actors with pagination params and filters
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/actor?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<Actor>> searchActorsWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c,
            @Param("f") List<String> f, @Param("o") String o);

    /**
     * Finds Actors
     * Finds Actors with pagination params and filters
     * Note, this is equivalent to the other <code>searchActors</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchActorsQueryParams} class that allows for
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
     *        </ul>
     * @return List&lt;Actor&gt;
     */
    @RequestLine("GET /API/bpm/actor?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    List<Actor> searchActors(@QueryMap(encoded = true) SearchActorsQueryParams queryParams);

    /**
     * Finds Actors
     * Finds Actors with pagination params and filters
     * Note, this is equivalent to the other <code>searchActors</code> that receives the query parameters as a map,
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
     *        </ul>
     * @return List&lt;Actor&gt;
     */
    @RequestLine("GET /API/bpm/actor?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<Actor>> searchActorsWithHttpInfo(@QueryMap(encoded = true) SearchActorsQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>searchActors</code> method in a fluent style.
     */
    public static class SearchActorsQueryParams extends HashMap<String, Object> {

        public SearchActorsQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchActorsQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchActorsQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }

        public SearchActorsQueryParams o(final String value) {
            put("o", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Update the Actor by ID
     * Update the Actor for the given ID Warning: as of 9.0.0, updating an Actor using this API is deprecated.
     * 
     * @param id ID of the Actor to return (required)
     * @param actorUpdateRequest Fields that can be upated are &#x60;displayName&#x60; and &#x60;description&#x60; (required)
     * @deprecated
     */
    @Deprecated
    @RequestLine("PUT /API/bpm/actor/{id}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void updateActorById(@Param("id") String id, ActorUpdateRequest actorUpdateRequest);

    /**
     * Update the Actor by ID
     * Similar to <code>updateActorById</code> but it also returns the http response headers .
     * Update the Actor for the given ID Warning: as of 9.0.0, updating an Actor using this API is deprecated.
     * 
     * @param id ID of the Actor to return (required)
     * @param actorUpdateRequest Fields that can be upated are &#x60;displayName&#x60; and &#x60;description&#x60; (required)
     * @deprecated
     */
    @Deprecated
    @RequestLine("PUT /API/bpm/actor/{id}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<Void> updateActorByIdWithHttpInfo(@Param("id") String id, ActorUpdateRequest actorUpdateRequest);

}
