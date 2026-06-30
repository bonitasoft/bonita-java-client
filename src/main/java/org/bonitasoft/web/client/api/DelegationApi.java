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
import org.bonitasoft.web.client.model.DelegatedTask;
import org.bonitasoft.web.client.model.DelegationRule;
import org.bonitasoft.web.client.model.DelegationRuleCreateRequest;
import org.bonitasoft.web.client.model.DelegationRuleUpdateRequest;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public interface DelegationApi extends ApiClient.Api {

    /**
     * Create or replace a delegation rule
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Creates a delegation rule. &#x60;delegatorId&#x60; is optional and resolved from the session
     * when omitted (self-service); administrators may set it to create a rule on behalf of another user. A user can hold at most one delegation rule: posting a
     * rule for a delegator who already has one replaces the existing rule (upsert). Available in Enterprise editions only, since Bonita 2026.2.
     * 
     * @param body (required)
     * @return DelegationRule
     */
    @RequestLine("POST /API/delegation/rule")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    DelegationRule createDelegationRule(DelegationRuleCreateRequest body);

    /**
     * Create or replace a delegation rule
     * Similar to <code>createDelegationRule</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Creates a delegation rule. &#x60;delegatorId&#x60; is optional and resolved from the session
     * when omitted (self-service); administrators may set it to create a rule on behalf of another user. A user can hold at most one delegation rule: posting a
     * rule for a delegator who already has one replaces the existing rule (upsert). Available in Enterprise editions only, since Bonita 2026.2.
     * 
     * @param body (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("POST /API/delegation/rule")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<DelegationRule> createDelegationRuleWithHttpInfo(DelegationRuleCreateRequest body);

    /**
     * Delete a delegation rule by ID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Deletes the delegation rule with the given ID. This is the only deactivation mechanism:
     * there is no soft delete or activation flag. Deleting a rule does not affect the underlying tasks, which remain assigned to the delegator. Available in
     * Enterprise editions only, since Bonita 2026.2.
     * 
     * @param ruleId Numeric ID of the delegation rule to delete (the &#x60;id&#x60; field returned by &#x60;DelegationRule&#x60;). (required)
     */
    @RequestLine("DELETE /API/delegation/rule/{ruleId}")
    @Headers({
            "Accept: application/json",
    })
    void deleteDelegationRuleById(@Param("ruleId") String ruleId);

    /**
     * Delete a delegation rule by ID
     * Similar to <code>deleteDelegationRuleById</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Deletes the delegation rule with the given ID. This is the only deactivation mechanism:
     * there is no soft delete or activation flag. Deleting a rule does not affect the underlying tasks, which remain assigned to the delegator. Available in
     * Enterprise editions only, since Bonita 2026.2.
     * 
     * @param ruleId Numeric ID of the delegation rule to delete (the &#x60;id&#x60; field returned by &#x60;DelegationRule&#x60;). (required)
     */
    @RequestLine("DELETE /API/delegation/rule/{ruleId}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<Void> deleteDelegationRuleByIdWithHttpInfo(@Param("ruleId") String ruleId);

    /**
     * Search delegated tasks
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Searches the human tasks a user can act on through an active delegation rule. Only tasks
     * covered by an &#x60;active&#x60; rule are returned: scheduled and expired rules yield nothing. Tasks should be assigned to the delegator and remain assigned
     * to them; the delegate gains visibility and execution rights without reassignment. - can order on &#x60;dueDate&#x60;, &#x60;priority&#x60;,
     * &#x60;reachedStateDate&#x60; - can search (&#x60;s&#x60;) on the task name and display name - can filter on &#x60;delegateId&#x60; (must be numeric; scopes
     * results to a delegate, enforced against the session user by (dynamic) authorization rules unless the caller is an administrator) and on
     * &#x60;rootProcessName&#x60; (narrows results to a specific root process) Available in Enterprise editions only, since Bonita 2026.2.
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return List&lt;DelegatedTask&gt;
     */
    @RequestLine("GET /API/delegation/task?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<DelegatedTask> searchDelegatedTasks(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f,
            @Param("o") String o, @Param("s") String s);

    /**
     * Search delegated tasks
     * Similar to <code>searchDelegatedTasks</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Searches the human tasks a user can act on through an active delegation rule. Only tasks
     * covered by an &#x60;active&#x60; rule are returned: scheduled and expired rules yield nothing. Tasks should be assigned to the delegator and remain assigned
     * to them; the delegate gains visibility and execution rights without reassignment. - can order on &#x60;dueDate&#x60;, &#x60;priority&#x60;,
     * &#x60;reachedStateDate&#x60; - can search (&#x60;s&#x60;) on the task name and display name - can filter on &#x60;delegateId&#x60; (must be numeric; scopes
     * results to a delegate, enforced against the session user by (dynamic) authorization rules unless the caller is an administrator) and on
     * &#x60;rootProcessName&#x60; (narrows results to a specific root process) Available in Enterprise editions only, since Bonita 2026.2.
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/delegation/task?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<DelegatedTask>> searchDelegatedTasksWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c,
            @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

    /**
     * Search delegated tasks
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Searches the human tasks a user can act on through an active delegation rule. Only tasks
     * covered by an &#x60;active&#x60; rule are returned: scheduled and expired rules yield nothing. Tasks should be assigned to the delegator and remain assigned
     * to them; the delegate gains visibility and execution rights without reassignment. - can order on &#x60;dueDate&#x60;, &#x60;priority&#x60;,
     * &#x60;reachedStateDate&#x60; - can search (&#x60;s&#x60;) on the task name and display name - can filter on &#x60;delegateId&#x60; (must be numeric; scopes
     * results to a delegate, enforced against the session user by (dynamic) authorization rules unless the caller is an administrator) and on
     * &#x60;rootProcessName&#x60; (narrows results to a specific root process) Available in Enterprise editions only, since Bonita 2026.2.
     * Note, this is equivalent to the other <code>searchDelegatedTasks</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchDelegatedTasksQueryParams} class that allows for
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
     * @return List&lt;DelegatedTask&gt;
     */
    @RequestLine("GET /API/delegation/task?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<DelegatedTask> searchDelegatedTasks(@QueryMap(encoded = true) SearchDelegatedTasksQueryParams queryParams);

    /**
     * Search delegated tasks
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Searches the human tasks a user can act on through an active delegation rule. Only tasks
     * covered by an &#x60;active&#x60; rule are returned: scheduled and expired rules yield nothing. Tasks should be assigned to the delegator and remain assigned
     * to them; the delegate gains visibility and execution rights without reassignment. - can order on &#x60;dueDate&#x60;, &#x60;priority&#x60;,
     * &#x60;reachedStateDate&#x60; - can search (&#x60;s&#x60;) on the task name and display name - can filter on &#x60;delegateId&#x60; (must be numeric; scopes
     * results to a delegate, enforced against the session user by (dynamic) authorization rules unless the caller is an administrator) and on
     * &#x60;rootProcessName&#x60; (narrows results to a specific root process) Available in Enterprise editions only, since Bonita 2026.2.
     * Note, this is equivalent to the other <code>searchDelegatedTasks</code> that receives the query parameters as a map,
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
     * @return List&lt;DelegatedTask&gt;
     */
    @RequestLine("GET /API/delegation/task?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<DelegatedTask>> searchDelegatedTasksWithHttpInfo(
            @QueryMap(encoded = true) SearchDelegatedTasksQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>searchDelegatedTasks</code> method in a fluent style.
     */
    public static class SearchDelegatedTasksQueryParams extends HashMap<String, Object> {

        public SearchDelegatedTasksQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchDelegatedTasksQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchDelegatedTasksQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }

        public SearchDelegatedTasksQueryParams o(final String value) {
            put("o", EncodingUtils.encode(value));
            return this;
        }

        public SearchDelegatedTasksQueryParams s(final String value) {
            put("s", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Search delegation rules
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Searches delegation rules with pagination and filters. The same endpoint serves regular
     * users (who see their own rule) and administrators (who see rules across users); authorization is enforced by the engine. - can order on &#x60;id&#x60;,
     * &#x60;delegatorId&#x60;, &#x60;delegateId&#x60;, &#x60;startDate&#x60;, &#x60;endDate&#x60;, &#x60;lastUpdatedBy&#x60;, &#x60;lastUpdatedAt&#x60; - can
     * filter on &#x60;id&#x60;, &#x60;delegatorId&#x60;, &#x60;delegateId&#x60;, &#x60;startDate&#x60;, &#x60;endDate&#x60;, &#x60;lastUpdatedBy&#x60;,
     * &#x60;lastUpdatedAt&#x60; and on &#x60;status&#x60; (a virtual filter accepting &#x60;scheduled&#x60;, &#x60;active&#x60; or &#x60;expired&#x60;) - the
     * free-text search term (&#x60;s&#x60;) is matched by the engine against the delegator and delegate user name, first name and last name Available in Enterprise
     * editions only, since Bonita 2026.2.
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return List&lt;DelegationRule&gt;
     */
    @RequestLine("GET /API/delegation/rule?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<DelegationRule> searchDelegationRules(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f,
            @Param("o") String o, @Param("s") String s);

    /**
     * Search delegation rules
     * Similar to <code>searchDelegationRules</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Searches delegation rules with pagination and filters. The same endpoint serves regular
     * users (who see their own rule) and administrators (who see rules across users); authorization is enforced by the engine. - can order on &#x60;id&#x60;,
     * &#x60;delegatorId&#x60;, &#x60;delegateId&#x60;, &#x60;startDate&#x60;, &#x60;endDate&#x60;, &#x60;lastUpdatedBy&#x60;, &#x60;lastUpdatedAt&#x60; - can
     * filter on &#x60;id&#x60;, &#x60;delegatorId&#x60;, &#x60;delegateId&#x60;, &#x60;startDate&#x60;, &#x60;endDate&#x60;, &#x60;lastUpdatedBy&#x60;,
     * &#x60;lastUpdatedAt&#x60; and on &#x60;status&#x60; (a virtual filter accepting &#x60;scheduled&#x60;, &#x60;active&#x60; or &#x60;expired&#x60;) - the
     * free-text search term (&#x60;s&#x60;) is matched by the engine against the delegator and delegate user name, first name and last name Available in Enterprise
     * editions only, since Bonita 2026.2.
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/delegation/rule?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<DelegationRule>> searchDelegationRulesWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c,
            @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

    /**
     * Search delegation rules
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Searches delegation rules with pagination and filters. The same endpoint serves regular
     * users (who see their own rule) and administrators (who see rules across users); authorization is enforced by the engine. - can order on &#x60;id&#x60;,
     * &#x60;delegatorId&#x60;, &#x60;delegateId&#x60;, &#x60;startDate&#x60;, &#x60;endDate&#x60;, &#x60;lastUpdatedBy&#x60;, &#x60;lastUpdatedAt&#x60; - can
     * filter on &#x60;id&#x60;, &#x60;delegatorId&#x60;, &#x60;delegateId&#x60;, &#x60;startDate&#x60;, &#x60;endDate&#x60;, &#x60;lastUpdatedBy&#x60;,
     * &#x60;lastUpdatedAt&#x60; and on &#x60;status&#x60; (a virtual filter accepting &#x60;scheduled&#x60;, &#x60;active&#x60; or &#x60;expired&#x60;) - the
     * free-text search term (&#x60;s&#x60;) is matched by the engine against the delegator and delegate user name, first name and last name Available in Enterprise
     * editions only, since Bonita 2026.2.
     * Note, this is equivalent to the other <code>searchDelegationRules</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchDelegationRulesQueryParams} class that allows for
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
     * @return List&lt;DelegationRule&gt;
     */
    @RequestLine("GET /API/delegation/rule?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<DelegationRule> searchDelegationRules(@QueryMap(encoded = true) SearchDelegationRulesQueryParams queryParams);

    /**
     * Search delegation rules
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Searches delegation rules with pagination and filters. The same endpoint serves regular
     * users (who see their own rule) and administrators (who see rules across users); authorization is enforced by the engine. - can order on &#x60;id&#x60;,
     * &#x60;delegatorId&#x60;, &#x60;delegateId&#x60;, &#x60;startDate&#x60;, &#x60;endDate&#x60;, &#x60;lastUpdatedBy&#x60;, &#x60;lastUpdatedAt&#x60; - can
     * filter on &#x60;id&#x60;, &#x60;delegatorId&#x60;, &#x60;delegateId&#x60;, &#x60;startDate&#x60;, &#x60;endDate&#x60;, &#x60;lastUpdatedBy&#x60;,
     * &#x60;lastUpdatedAt&#x60; and on &#x60;status&#x60; (a virtual filter accepting &#x60;scheduled&#x60;, &#x60;active&#x60; or &#x60;expired&#x60;) - the
     * free-text search term (&#x60;s&#x60;) is matched by the engine against the delegator and delegate user name, first name and last name Available in Enterprise
     * editions only, since Bonita 2026.2.
     * Note, this is equivalent to the other <code>searchDelegationRules</code> that receives the query parameters as a map,
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
     * @return List&lt;DelegationRule&gt;
     */
    @RequestLine("GET /API/delegation/rule?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<DelegationRule>> searchDelegationRulesWithHttpInfo(
            @QueryMap(encoded = true) SearchDelegationRulesQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>searchDelegationRules</code> method in a fluent style.
     */
    public static class SearchDelegationRulesQueryParams extends HashMap<String, Object> {

        public SearchDelegationRulesQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchDelegationRulesQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchDelegationRulesQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }

        public SearchDelegationRulesQueryParams o(final String value) {
            put("o", EncodingUtils.encode(value));
            return this;
        }

        public SearchDelegationRulesQueryParams s(final String value) {
            put("s", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Update a delegation rule by ID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Replaces the &#x60;delegateId&#x60;, &#x60;startDate&#x60;, &#x60;endDate&#x60; and
     * &#x60;processes&#x60; of an existing delegation rule. The delegator of the rule cannot be changed. Available in Enterprise editions only, since Bonita
     * 2026.2.
     * 
     * @param ruleId Numeric ID of the delegation rule to update (the &#x60;id&#x60; field returned by &#x60;DelegationRule&#x60;). (required)
     * @param body (required)
     * @return DelegationRule
     */
    @RequestLine("PUT /API/delegation/rule/{ruleId}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    DelegationRule updateDelegationRuleById(@Param("ruleId") String ruleId, DelegationRuleUpdateRequest body);

    /**
     * Update a delegation rule by ID
     * Similar to <code>updateDelegationRuleById</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Replaces the &#x60;delegateId&#x60;, &#x60;startDate&#x60;, &#x60;endDate&#x60; and
     * &#x60;processes&#x60; of an existing delegation rule. The delegator of the rule cannot be changed. Available in Enterprise editions only, since Bonita
     * 2026.2.
     * 
     * @param ruleId Numeric ID of the delegation rule to update (the &#x60;id&#x60; field returned by &#x60;DelegationRule&#x60;). (required)
     * @param body (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("PUT /API/delegation/rule/{ruleId}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<DelegationRule> updateDelegationRuleByIdWithHttpInfo(@Param("ruleId") String ruleId,
            DelegationRuleUpdateRequest body);

}
