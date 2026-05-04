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
 * Body of &#x60;POST /API/retention/rule&#x60;. Defines a new data retention rule for the business object type identified by &#x60;dataClassName&#x60;. All
 * three fields are required.
 */
@JsonPropertyOrder({
        RetentionRuleCreateRequest.JSON_PROPERTY_DATA_CLASS_NAME,
        RetentionRuleCreateRequest.JSON_PROPERTY_REFERENCE_DATE,
        RetentionRuleCreateRequest.JSON_PROPERTY_RETENTION_DAYS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class RetentionRuleCreateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_DATA_CLASS_NAME = "dataClassName";
    @jakarta.annotation.Nonnull
    private String dataClassName;

    public static final String JSON_PROPERTY_REFERENCE_DATE = "referenceDate";
    @jakarta.annotation.Nonnull
    private ReferenceDate referenceDate;

    public static final String JSON_PROPERTY_RETENTION_DAYS = "retentionDays";
    @jakarta.annotation.Nonnull
    private Integer retentionDays;

    public RetentionRuleCreateRequest() {
    }

    public RetentionRuleCreateRequest dataClassName(@jakarta.annotation.Nonnull String dataClassName) {

        this.dataClassName = dataClassName;
        return this;
    }

    /**
     * Fully qualified Java class name of the business object type this rule applies to. Note the uppercase &#x60;N&#x60;. The corresponding field returned in the
     * &#x60;DataRetentionConfig&#x60; response of this endpoint and of &#x60;PUT /API/retention/rule/{ruleId}&#x60;, &#x60;GET /API/retention/object&#x60; is named
     * &#x60;dataClassname&#x60; (lowercase &#x60;n&#x60;).
     * 
     * @return dataClassName
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DATA_CLASS_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getDataClassName() {
        return dataClassName;
    }

    @JsonProperty(JSON_PROPERTY_DATA_CLASS_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDataClassName(@jakarta.annotation.Nonnull String dataClassName) {
        this.dataClassName = dataClassName;
    }

    public RetentionRuleCreateRequest referenceDate(@jakarta.annotation.Nonnull ReferenceDate referenceDate) {

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

    public RetentionRuleCreateRequest retentionDays(@jakarta.annotation.Nonnull Integer retentionDays) {

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
        RetentionRuleCreateRequest retentionRuleCreateRequest = (RetentionRuleCreateRequest) o;
        return Objects.equals(this.dataClassName, retentionRuleCreateRequest.dataClassName) &&
                Objects.equals(this.referenceDate, retentionRuleCreateRequest.referenceDate) &&
                Objects.equals(this.retentionDays, retentionRuleCreateRequest.retentionDays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataClassName, referenceDate, retentionDays);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RetentionRuleCreateRequest {\n");
        sb.append("    dataClassName: ").append(toIndentedString(dataClassName)).append("\n");
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
