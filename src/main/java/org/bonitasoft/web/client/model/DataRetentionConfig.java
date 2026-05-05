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
 * A data retention rule configured for a specific business object type. It defines when and how business data of that type are automatically deleted by the
 * data retention service.
 */
@JsonPropertyOrder({
        DataRetentionConfig.JSON_PROPERTY_ID,
        DataRetentionConfig.JSON_PROPERTY_DATA_CLASSNAME,
        DataRetentionConfig.JSON_PROPERTY_REFERENCE_DATE,
        DataRetentionConfig.JSON_PROPERTY_RETENTION_DAYS,
        DataRetentionConfig.JSON_PROPERTY_CREATED_AT,
        DataRetentionConfig.JSON_PROPERTY_UPDATED_AT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class DataRetentionConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    @jakarta.annotation.Nonnull
    private String id;

    public static final String JSON_PROPERTY_DATA_CLASSNAME = "dataClassname";
    @jakarta.annotation.Nonnull
    private String dataClassname;

    public static final String JSON_PROPERTY_REFERENCE_DATE = "referenceDate";
    @jakarta.annotation.Nonnull
    private ReferenceDate referenceDate;

    public static final String JSON_PROPERTY_RETENTION_DAYS = "retentionDays";
    @jakarta.annotation.Nonnull
    private Integer retentionDays;

    public static final String JSON_PROPERTY_CREATED_AT = "createdAt";
    @jakarta.annotation.Nonnull
    private String createdAt;

    public static final String JSON_PROPERTY_UPDATED_AT = "updatedAt";
    @jakarta.annotation.Nonnull
    private String updatedAt;

    public DataRetentionConfig() {
    }

    public DataRetentionConfig id(@jakarta.annotation.Nonnull String id) {

        this.id = id;
        return this;
    }

    /**
     * Identifier of the retention rule. Serialized as a string to avoid JavaScript precision loss on large &#x60;long&#x60; values.
     * 
     * @return id
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setId(@jakarta.annotation.Nonnull String id) {
        this.id = id;
    }

    public DataRetentionConfig dataClassname(@jakarta.annotation.Nonnull String dataClassname) {

        this.dataClassname = dataClassname;
        return this;
    }

    /**
     * Fully qualified Java class name of the business object type this rule applies to. Note the lowercase &#x60;n&#x60; (the create-rule request body uses
     * &#x60;dataClassName&#x60; instead).
     * 
     * @return dataClassname
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DATA_CLASSNAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getDataClassname() {
        return dataClassname;
    }

    @JsonProperty(JSON_PROPERTY_DATA_CLASSNAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDataClassname(@jakarta.annotation.Nonnull String dataClassname) {
        this.dataClassname = dataClassname;
    }

    public DataRetentionConfig referenceDate(@jakarta.annotation.Nonnull ReferenceDate referenceDate) {

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

    public DataRetentionConfig retentionDays(@jakarta.annotation.Nonnull Integer retentionDays) {

        this.retentionDays = retentionDays;
        return this;
    }

    /**
     * Duration of the retention period, in days. Always strictly positive — enforced by the engine on create and update.
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

    public DataRetentionConfig createdAt(@jakarta.annotation.Nonnull String createdAt) {

        this.createdAt = createdAt;
        return this;
    }

    /**
     * Creation timestamp of this retention rule, in epoch milliseconds. Serialized as a string to avoid JavaScript precision loss.
     * 
     * @return createdAt
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setCreatedAt(@jakarta.annotation.Nonnull String createdAt) {
        this.createdAt = createdAt;
    }

    public DataRetentionConfig updatedAt(@jakarta.annotation.Nonnull String updatedAt) {

        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Last update timestamp of this retention rule, in epoch milliseconds. Serialized as a string to avoid JavaScript precision loss.
     * 
     * @return updatedAt
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setUpdatedAt(@jakarta.annotation.Nonnull String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DataRetentionConfig dataRetentionConfig = (DataRetentionConfig) o;
        return Objects.equals(this.id, dataRetentionConfig.id) &&
                Objects.equals(this.dataClassname, dataRetentionConfig.dataClassname) &&
                Objects.equals(this.referenceDate, dataRetentionConfig.referenceDate) &&
                Objects.equals(this.retentionDays, dataRetentionConfig.retentionDays) &&
                Objects.equals(this.createdAt, dataRetentionConfig.createdAt) &&
                Objects.equals(this.updatedAt, dataRetentionConfig.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataClassname, referenceDate, retentionDays, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataRetentionConfig {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    dataClassname: ").append(toIndentedString(dataClassname)).append("\n");
        sb.append("    referenceDate: ").append(toIndentedString(referenceDate)).append("\n");
        sb.append("    retentionDays: ").append(toIndentedString(retentionDays)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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
