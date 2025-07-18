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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * An object containing: * the list of IDs of all the newly created Business Data, under the name of \&quot;createdIds\&quot; * the list of unknown fields,
 * provided as an array of names, under the name of \&quot;unknownFields\&quot;
 */
@JsonPropertyOrder({
        BusinessDataImportResult.JSON_PROPERTY_CREATED_IDS,
        BusinessDataImportResult.JSON_PROPERTY_UNKNOWN_FIELDS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class BusinessDataImportResult implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_CREATED_IDS = "createdIds";
    @jakarta.annotation.Nullable
    private List<BigDecimal> createdIds = new ArrayList<>();

    public static final String JSON_PROPERTY_UNKNOWN_FIELDS = "unknownFields";
    @jakarta.annotation.Nullable
    private List<String> unknownFields = new ArrayList<>();

    public BusinessDataImportResult() {
    }

    public BusinessDataImportResult createdIds(@jakarta.annotation.Nullable List<BigDecimal> createdIds) {

        this.createdIds = createdIds;
        return this;
    }

    public BusinessDataImportResult addCreatedIdsItem(BigDecimal createdIdsItem) {
        if (this.createdIds == null) {
            this.createdIds = new ArrayList<>();
        }
        this.createdIds.add(createdIdsItem);
        return this;
    }

    /**
     * List of IDs of the newly created Business Data
     * 
     * @return createdIds
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_IDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<BigDecimal> getCreatedIds() {
        return createdIds;
    }

    @JsonProperty(JSON_PROPERTY_CREATED_IDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreatedIds(@jakarta.annotation.Nullable List<BigDecimal> createdIds) {
        this.createdIds = createdIds;
    }

    public BusinessDataImportResult unknownFields(@jakarta.annotation.Nullable List<String> unknownFields) {

        this.unknownFields = unknownFields;
        return this;
    }

    public BusinessDataImportResult addUnknownFieldsItem(String unknownFieldsItem) {
        if (this.unknownFields == null) {
            this.unknownFields = new ArrayList<>();
        }
        this.unknownFields.add(unknownFieldsItem);
        return this;
    }

    /**
     * list of unknown input fields that are not declared in the Business Data type
     * 
     * @return unknownFields
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_UNKNOWN_FIELDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getUnknownFields() {
        return unknownFields;
    }

    @JsonProperty(JSON_PROPERTY_UNKNOWN_FIELDS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUnknownFields(@jakarta.annotation.Nullable List<String> unknownFields) {
        this.unknownFields = unknownFields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BusinessDataImportResult businessDataImportResult = (BusinessDataImportResult) o;
        return Objects.equals(this.createdIds, businessDataImportResult.createdIds) &&
                Objects.equals(this.unknownFields, businessDataImportResult.unknownFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdIds, unknownFields);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BusinessDataImportResult {\n");
        sb.append("    createdIds: ").append(toIndentedString(createdIds)).append("\n");
        sb.append("    unknownFields: ").append(toIndentedString(unknownFields)).append("\n");
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
