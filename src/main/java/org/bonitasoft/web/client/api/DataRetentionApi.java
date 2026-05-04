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

import java.util.List;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.BusinessObjectWithRetentionRule;
import org.bonitasoft.web.client.model.DataRetentionConfig;
import org.bonitasoft.web.client.model.RetentionRuleCreateRequest;
import org.bonitasoft.web.client.model.RetentionRuleUpdateRequest;
import org.bonitasoft.web.client.model.RetentionSchedule;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public interface DataRetentionApi extends ApiClient.Api {

    /**
     * Create a retention rule
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Creates a data retention rule for a business object type. Once created, the data retention
     * service will automatically delete business data of &#x60;dataClassName&#x60; whose &#x60;referenceDate&#x60; is older than &#x60;retentionDays&#x60; days.
     * Only one retention rule can exist per BDM class name. Posting a second rule for a &#x60;dataClassName&#x60; that already has one returns &#x60;409
     * Conflict&#x60;. Requires the &#x60;DATA_RETENTION&#x60; feature to be active in the platform license. Available since Bonita 11.0.
     * 
     * @param body (required)
     * @return DataRetentionConfig
     */
    @RequestLine("POST /API/retention/rule")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    DataRetentionConfig createRetentionRule(RetentionRuleCreateRequest body);

    /**
     * Create a retention rule
     * Similar to <code>createRetentionRule</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Creates a data retention rule for a business object type. Once created, the data retention
     * service will automatically delete business data of &#x60;dataClassName&#x60; whose &#x60;referenceDate&#x60; is older than &#x60;retentionDays&#x60; days.
     * Only one retention rule can exist per BDM class name. Posting a second rule for a &#x60;dataClassName&#x60; that already has one returns &#x60;409
     * Conflict&#x60;. Requires the &#x60;DATA_RETENTION&#x60; feature to be active in the platform license. Available since Bonita 11.0.
     * 
     * @param body (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("POST /API/retention/rule")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<DataRetentionConfig> createRetentionRuleWithHttpInfo(RetentionRuleCreateRequest body);

    /**
     * Delete a retention rule by ID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Deletes the retention rule with the given ID. Existing BDM object instances of the
     * underlying type are not deleted by this operation; only the retention rule itself is removed. Requires the &#x60;DATA_RETENTION&#x60; feature to be active in
     * the platform license. Available since Bonita 11.0.
     * 
     * @param ruleId Numeric ID of the retention rule to delete (the &#x60;id&#x60; field returned by &#x60;DataRetentionConfig&#x60;). (required)
     */
    @RequestLine("DELETE /API/retention/rule/{ruleId}")
    @Headers({
            "Accept: application/json",
    })
    void deleteRetentionRuleById(@Param("ruleId") String ruleId);

    /**
     * Delete a retention rule by ID
     * Similar to <code>deleteRetentionRuleById</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Deletes the retention rule with the given ID. Existing BDM object instances of the
     * underlying type are not deleted by this operation; only the retention rule itself is removed. Requires the &#x60;DATA_RETENTION&#x60; feature to be active in
     * the platform license. Available since Bonita 11.0.
     * 
     * @param ruleId Numeric ID of the retention rule to delete (the &#x60;id&#x60; field returned by &#x60;DataRetentionConfig&#x60;). (required)
     */
    @RequestLine("DELETE /API/retention/rule/{ruleId}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<Void> deleteRetentionRuleByIdWithHttpInfo(@Param("ruleId") String ruleId);

    /**
     * List business object types with their retention rules
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the list of all business object types defined in the deployed Business Data Model
     * (BDM), each enriched with its composition tree and the retention rule that may apply to it. The full list is returned in a single response. Pagination is not
     * applied because the BDM is a bounded set defined at deployment time. Requires the &#x60;DATA_RETENTION&#x60; feature to be active in the platform license.
     * Available since Bonita 11.0.
     * 
     * @return List&lt;BusinessObjectWithRetentionRule&gt;
     */
    @RequestLine("GET /API/retention/object")
    @Headers({
            "Accept: application/json",
    })
    List<BusinessObjectWithRetentionRule> findObjectsWithRetentionRules();

    /**
     * List business object types with their retention rules
     * Similar to <code>findObjectsWithRetentionRules</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the list of all business object types defined in the deployed Business Data Model
     * (BDM), each enriched with its composition tree and the retention rule that may apply to it. The full list is returned in a single response. Pagination is not
     * applied because the BDM is a bounded set defined at deployment time. Requires the &#x60;DATA_RETENTION&#x60; feature to be active in the platform license.
     * Available since Bonita 11.0.
     * 
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/retention/object")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<BusinessObjectWithRetentionRule>> findObjectsWithRetentionRulesWithHttpInfo();

    /**
     * Get the data retention schedule
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the cron expression that triggers the data retention job. The expression is
     * configured via the &#x60;bonita.runtime.retention.schedule.cron&#x60; platform property and is read-only at runtime. Requires the &#x60;DATA_RETENTION&#x60;
     * feature to be active in the platform license. Available since Bonita 11.0.
     * 
     * @return RetentionSchedule
     */
    @RequestLine("GET /API/retention/schedule")
    @Headers({
            "Accept: application/json",
    })
    RetentionSchedule getRetentionSchedule();

    /**
     * Get the data retention schedule
     * Similar to <code>getRetentionSchedule</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns the cron expression that triggers the data retention job. The expression is
     * configured via the &#x60;bonita.runtime.retention.schedule.cron&#x60; platform property and is read-only at runtime. Requires the &#x60;DATA_RETENTION&#x60;
     * feature to be active in the platform license. Available since Bonita 11.0.
     * 
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/retention/schedule")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<RetentionSchedule> getRetentionScheduleWithHttpInfo();

    /**
     * Update a retention rule by ID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Updates the &#x60;referenceDate&#x60; and &#x60;retentionDays&#x60; of an existing retention
     * rule. Requires the &#x60;DATA_RETENTION&#x60; feature to be active in the platform license. Available since Bonita 11.0.
     * 
     * @param ruleId Numeric ID of the retention rule to update (the &#x60;id&#x60; field returned by &#x60;DataRetentionConfig&#x60;). (required)
     * @param body (required)
     * @return DataRetentionConfig
     */
    @RequestLine("PUT /API/retention/rule/{ruleId}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    DataRetentionConfig updateRetentionRuleById(@Param("ruleId") String ruleId, RetentionRuleUpdateRequest body);

    /**
     * Update a retention rule by ID
     * Similar to <code>updateRetentionRuleById</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Updates the &#x60;referenceDate&#x60; and &#x60;retentionDays&#x60; of an existing retention
     * rule. Requires the &#x60;DATA_RETENTION&#x60; feature to be active in the platform license. Available since Bonita 11.0.
     * 
     * @param ruleId Numeric ID of the retention rule to update (the &#x60;id&#x60; field returned by &#x60;DataRetentionConfig&#x60;). (required)
     * @param body (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("PUT /API/retention/rule/{ruleId}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<DataRetentionConfig> updateRetentionRuleByIdWithHttpInfo(@Param("ruleId") String ruleId,
            RetentionRuleUpdateRequest body);

}
