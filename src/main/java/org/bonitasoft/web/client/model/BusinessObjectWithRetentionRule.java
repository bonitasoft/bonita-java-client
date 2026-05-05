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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * A business object type defined in the Business Data Model (BDM) along with its optional data retention rule and composition tree. The
 * &#x60;dataRetentionRule&#x60; field is &#x60;null&#x60; when no retention rule has been configured for this business object type.
 */
@JsonPropertyOrder({
        BusinessObjectWithRetentionRule.JSON_PROPERTY_QUALIFIED_NAME,
        BusinessObjectWithRetentionRule.JSON_PROPERTY_COMPOSITIONS,
        BusinessObjectWithRetentionRule.JSON_PROPERTY_DATA_RETENTION_RULE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class BusinessObjectWithRetentionRule implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_QUALIFIED_NAME = "qualifiedName";
    @jakarta.annotation.Nonnull
    private String qualifiedName;

    public static final String JSON_PROPERTY_COMPOSITIONS = "compositions";
    @jakarta.annotation.Nonnull
    private List<CompositionNode> compositions = new ArrayList<>();

    public static final String JSON_PROPERTY_DATA_RETENTION_RULE = "dataRetentionRule";
    @jakarta.annotation.Nullable
    private DataRetentionConfig dataRetentionRule;

    public BusinessObjectWithRetentionRule() {
    }

    public BusinessObjectWithRetentionRule qualifiedName(@jakarta.annotation.Nonnull String qualifiedName) {

        this.qualifiedName = qualifiedName;
        return this;
    }

    /**
     * Fully qualified Java class name of the business object type.
     * 
     * @return qualifiedName
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_QUALIFIED_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getQualifiedName() {
        return qualifiedName;
    }

    @JsonProperty(JSON_PROPERTY_QUALIFIED_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setQualifiedName(@jakarta.annotation.Nonnull String qualifiedName) {
        this.qualifiedName = qualifiedName;
    }

    public BusinessObjectWithRetentionRule compositions(
            @jakarta.annotation.Nonnull List<CompositionNode> compositions) {

        this.compositions = compositions;
        return this;
    }

    public BusinessObjectWithRetentionRule addCompositionsItem(CompositionNode compositionsItem) {
        if (this.compositions == null) {
            this.compositions = new ArrayList<>();
        }
        this.compositions.add(compositionsItem);
        return this;
    }

    /**
     * Direct composition children of this business object type as a recursive tree.
     * 
     * @return compositions
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_COMPOSITIONS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<CompositionNode> getCompositions() {
        return compositions;
    }

    @JsonProperty(JSON_PROPERTY_COMPOSITIONS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setCompositions(@jakarta.annotation.Nonnull List<CompositionNode> compositions) {
        this.compositions = compositions;
    }

    public BusinessObjectWithRetentionRule dataRetentionRule(
            @jakarta.annotation.Nullable DataRetentionConfig dataRetentionRule) {

        this.dataRetentionRule = dataRetentionRule;
        return this;
    }

    /**
     * Get dataRetentionRule
     * 
     * @return dataRetentionRule
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DATA_RETENTION_RULE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public DataRetentionConfig getDataRetentionRule() {
        return dataRetentionRule;
    }

    @JsonProperty(JSON_PROPERTY_DATA_RETENTION_RULE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDataRetentionRule(@jakarta.annotation.Nullable DataRetentionConfig dataRetentionRule) {
        this.dataRetentionRule = dataRetentionRule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BusinessObjectWithRetentionRule businessObjectWithRetentionRule = (BusinessObjectWithRetentionRule) o;
        return Objects.equals(this.qualifiedName, businessObjectWithRetentionRule.qualifiedName) &&
                Objects.equals(this.compositions, businessObjectWithRetentionRule.compositions) &&
                Objects.equals(this.dataRetentionRule, businessObjectWithRetentionRule.dataRetentionRule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qualifiedName, compositions, dataRetentionRule);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BusinessObjectWithRetentionRule {\n");
        sb.append("    qualifiedName: ").append(toIndentedString(qualifiedName)).append("\n");
        sb.append("    compositions: ").append(toIndentedString(compositions)).append("\n");
        sb.append("    dataRetentionRule: ").append(toIndentedString(dataRetentionRule)).append("\n");
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
