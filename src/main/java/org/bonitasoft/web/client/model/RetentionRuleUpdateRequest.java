/** 
 * Copyright (C) 2024-2023 BonitaSoft S.A.
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
package org.bonitasoft.web.client.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Body of &#x60;PUT /API/retention/rule/{ruleId}&#x60;. Replaces the mutable fields of an existing retention rule. This is a full replacement of
 * &#x60;referenceDate&#x60; and &#x60;retentionDays&#x60;, not a partial update — both fields must be provided on every call. The &#x60;dataClassName&#x60; of
 * an existing rule cannot be changed.
 */
@JsonPropertyOrder({
        RetentionRuleUpdateRequest.JSON_PROPERTY_REFERENCE_DATE,
        RetentionRuleUpdateRequest.JSON_PROPERTY_RETENTION_DAYS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class RetentionRuleUpdateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_REFERENCE_DATE = "referenceDate";
    @jakarta.annotation.Nonnull
    private ReferenceDate referenceDate;

    public static final String JSON_PROPERTY_RETENTION_DAYS = "retentionDays";
    @jakarta.annotation.Nonnull
    private Integer retentionDays;

    public RetentionRuleUpdateRequest() {
    }

    public RetentionRuleUpdateRequest referenceDate(@jakarta.annotation.Nonnull ReferenceDate referenceDate) {

        this.referenceDate = referenceDate;
        return this;
    }

    /**
     * Get referenceDate
     * 
     * @return referenceDate
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_REFERENCE_DATE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public ReferenceDate getReferenceDate() {
        return referenceDate;
    }

    @JsonProperty(JSON_PROPERTY_REFERENCE_DATE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setReferenceDate(@jakarta.annotation.Nonnull ReferenceDate referenceDate) {
        this.referenceDate = referenceDate;
    }

    public RetentionRuleUpdateRequest retentionDays(@jakarta.annotation.Nonnull Integer retentionDays) {

        this.retentionDays = retentionDays;
        return this;
    }

    /**
     * Duration of the retention period, in days. Must be strictly positive.
     * minimum: 1
     * 
     * @return retentionDays
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_RETENTION_DAYS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Integer getRetentionDays() {
        return retentionDays;
    }

    @JsonProperty(JSON_PROPERTY_RETENTION_DAYS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setRetentionDays(@jakarta.annotation.Nonnull Integer retentionDays) {
        this.retentionDays = retentionDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RetentionRuleUpdateRequest retentionRuleUpdateRequest = (RetentionRuleUpdateRequest) o;
        return Objects.equals(this.referenceDate, retentionRuleUpdateRequest.referenceDate) &&
                Objects.equals(this.retentionDays, retentionRuleUpdateRequest.retentionDays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(referenceDate, retentionDays);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RetentionRuleUpdateRequest {\n");
        sb.append("    referenceDate: ").append(toIndentedString(referenceDate)).append("\n");
        sb.append("    retentionDays: ").append(toIndentedString(retentionDays)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
