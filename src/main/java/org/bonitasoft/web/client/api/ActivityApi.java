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
import org.bonitasoft.web.client.model.Activity;
import org.bonitasoft.web.client.model.ActivityUpdateRequest;
import org.bonitasoft.web.client.model.ApiResponse;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public interface ActivityApi extends ApiClient.Api {

    /**
     * Finds the Activity by ID
     * Returns the single Activity for the given ID
     * 
     * @param id ID of the Activity to return (required)
     * @return Activity
     */
    @RequestLine("GET /API/bpm/activity/{id}")
    @Headers({
            "Accept: application/json",
    })
    Activity getActivityById(@Param("id") String id);

    /**
     * Finds the Activity by ID
     * Similar to <code>getActivityById</code> but it also returns the http response headers .
     * Returns the single Activity for the given ID
     * 
     * @param id ID of the Activity to return (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/activity/{id}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<Activity> getActivityByIdWithHttpInfo(@Param("id") String id);

    /**
     * Finds Activities
     * Finds Activities with pagination params and filters. Activities in states completed, cancelled, or aborted are not retrieved. The search returns an array of
     * activities. - can order on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;processDefinitionId&#x60;,
     * &#x60;parentProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60; (order by parent activity id), &#x60;rootProcessInstanceId&#x60;,
     * &#x60;lastUpdateDate&#x60; - can search on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;processDefinitionId&#x60;,
     * &#x60;parentProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60; (order by parent activity id), &#x60;rootProcessInstanceId&#x60;,
     * &#x60;lastUpdateDate&#x60; - can filter on &#x60;name&#x60;, &#x60;state&#x60;, &#x60;processId&#x60;, &#x60;parentProcessInstanceId&#x60;,
     * &#x60;rootProcessInstanceId&#x60;, &#x60;last_update_date&#x60;, &#x60;supervisor_id&#x60; (only in Enterprise editions)
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return List&lt;Activity&gt;
     */
    @RequestLine("GET /API/bpm/activity?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<Activity> searchActivities(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f,
            @Param("o") String o, @Param("s") String s);

    /**
     * Finds Activities
     * Similar to <code>searchActivities</code> but it also returns the http response headers .
     * Finds Activities with pagination params and filters. Activities in states completed, cancelled, or aborted are not retrieved. The search returns an array of
     * activities. - can order on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;processDefinitionId&#x60;,
     * &#x60;parentProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60; (order by parent activity id), &#x60;rootProcessInstanceId&#x60;,
     * &#x60;lastUpdateDate&#x60; - can search on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;processDefinitionId&#x60;,
     * &#x60;parentProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60; (order by parent activity id), &#x60;rootProcessInstanceId&#x60;,
     * &#x60;lastUpdateDate&#x60; - can filter on &#x60;name&#x60;, &#x60;state&#x60;, &#x60;processId&#x60;, &#x60;parentProcessInstanceId&#x60;,
     * &#x60;rootProcessInstanceId&#x60;, &#x60;last_update_date&#x60;, &#x60;supervisor_id&#x60; (only in Enterprise editions)
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/activity?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<Activity>> searchActivitiesWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c,
            @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

    /**
     * Finds Activities
     * Finds Activities with pagination params and filters. Activities in states completed, cancelled, or aborted are not retrieved. The search returns an array of
     * activities. - can order on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;processDefinitionId&#x60;,
     * &#x60;parentProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60; (order by parent activity id), &#x60;rootProcessInstanceId&#x60;,
     * &#x60;lastUpdateDate&#x60; - can search on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;processDefinitionId&#x60;,
     * &#x60;parentProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60; (order by parent activity id), &#x60;rootProcessInstanceId&#x60;,
     * &#x60;lastUpdateDate&#x60; - can filter on &#x60;name&#x60;, &#x60;state&#x60;, &#x60;processId&#x60;, &#x60;parentProcessInstanceId&#x60;,
     * &#x60;rootProcessInstanceId&#x60;, &#x60;last_update_date&#x60;, &#x60;supervisor_id&#x60; (only in Enterprise editions)
     * Note, this is equivalent to the other <code>searchActivities</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchActivitiesQueryParams} class that allows for
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
     * @return List&lt;Activity&gt;
     */
    @RequestLine("GET /API/bpm/activity?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<Activity> searchActivities(@QueryMap(encoded = true) SearchActivitiesQueryParams queryParams);

    /**
     * Finds Activities
     * Finds Activities with pagination params and filters. Activities in states completed, cancelled, or aborted are not retrieved. The search returns an array of
     * activities. - can order on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;processDefinitionId&#x60;,
     * &#x60;parentProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60; (order by parent activity id), &#x60;rootProcessInstanceId&#x60;,
     * &#x60;lastUpdateDate&#x60; - can search on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;processDefinitionId&#x60;,
     * &#x60;parentProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60; (order by parent activity id), &#x60;rootProcessInstanceId&#x60;,
     * &#x60;lastUpdateDate&#x60; - can filter on &#x60;name&#x60;, &#x60;state&#x60;, &#x60;processId&#x60;, &#x60;parentProcessInstanceId&#x60;,
     * &#x60;rootProcessInstanceId&#x60;, &#x60;last_update_date&#x60;, &#x60;supervisor_id&#x60; (only in Enterprise editions)
     * Note, this is equivalent to the other <code>searchActivities</code> that receives the query parameters as a map,
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
     * @return List&lt;Activity&gt;
     */
    @RequestLine("GET /API/bpm/activity?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<Activity>> searchActivitiesWithHttpInfo(
            @QueryMap(encoded = true) SearchActivitiesQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>searchActivities</code> method in a fluent style.
     */
    public static class SearchActivitiesQueryParams extends HashMap<String, Object> {

        public SearchActivitiesQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchActivitiesQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchActivitiesQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }

        public SearchActivitiesQueryParams o(final String value) {
            put("o", EncodingUtils.encode(value));
            return this;
        }

        public SearchActivitiesQueryParams s(final String value) {
            put("s", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Update the Activity by ID
     * Update the Activity for the given ID
     * 
     * @param id ID of the Activity to return (required)
     * @param activityUpdateRequest Partial Activity description (required)
     */
    @RequestLine("PUT /API/bpm/activity/{id}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void updateActivityById(@Param("id") String id, ActivityUpdateRequest activityUpdateRequest);

    /**
     * Update the Activity by ID
     * Similar to <code>updateActivityById</code> but it also returns the http response headers .
     * Update the Activity for the given ID
     * 
     * @param id ID of the Activity to return (required)
     * @param activityUpdateRequest Partial Activity description (required)
     */
    @RequestLine("PUT /API/bpm/activity/{id}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<Void> updateActivityByIdWithHttpInfo(@Param("id") String id,
            ActivityUpdateRequest activityUpdateRequest);

}
