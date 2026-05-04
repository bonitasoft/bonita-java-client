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
 * An archived case variable
 */
@JsonPropertyOrder({
        ArchivedProcessInstanceVariable.JSON_PROPERTY_NAME,
        ArchivedProcessInstanceVariable.JSON_PROPERTY_DESCRIPTION,
        ArchivedProcessInstanceVariable.JSON_PROPERTY_TYPE,
        ArchivedProcessInstanceVariable.JSON_PROPERTY_CASE_ID,
        ArchivedProcessInstanceVariable.JSON_PROPERTY_VALUE,
        ArchivedProcessInstanceVariable.JSON_PROPERTY_ARCHIVED_DATE,
        ArchivedProcessInstanceVariable.JSON_PROPERTY_SOURCED_OBJECT_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class ArchivedProcessInstanceVariable implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_NAME = "name";
    @jakarta.annotation.Nullable
    private String name;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    @jakarta.annotation.Nullable
    private String description;

    public static final String JSON_PROPERTY_TYPE = "type";
    @jakarta.annotation.Nullable
    private String type;

    public static final String JSON_PROPERTY_CASE_ID = "case_id";
    @jakarta.annotation.Nullable
    private String caseId;

    public static final String JSON_PROPERTY_VALUE = "value";
    @jakarta.annotation.Nullable
    private String value;

    public static final String JSON_PROPERTY_ARCHIVED_DATE = "archivedDate";
    @jakarta.annotation.Nullable
    private String archivedDate;

    public static final String JSON_PROPERTY_SOURCED_OBJECT_ID = "sourcedObjectId";
    @jakarta.annotation.Nullable
    private String sourcedObjectId;

    public ArchivedProcessInstanceVariable() {
    }

    public ArchivedProcessInstanceVariable name(@jakarta.annotation.Nullable String name) {

        this.name = name;
        return this;
    }

    /**
     * The name of the variable
     * 
     * @return name
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setName(@jakarta.annotation.Nullable String name) {
        this.name = name;
    }

    public ArchivedProcessInstanceVariable description(@jakarta.annotation.Nullable String description) {

        this.description = description;
        return this;
    }

    /**
     * Detailed description of the case variable, as set in the definition at design-time
     * 
     * @return description
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDescription() {
        return description;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDescription(@jakarta.annotation.Nullable String description) {
        this.description = description;
    }

    public ArchivedProcessInstanceVariable type(@jakarta.annotation.Nullable String type) {

        this.type = type;
        return this;
    }

    /**
     * The fully qualified class name of the variable type
     * 
     * @return type
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setType(@jakarta.annotation.Nullable String type) {
        this.type = type;
    }

    public ArchivedProcessInstanceVariable caseId(@jakarta.annotation.Nullable String caseId) {

        this.caseId = caseId;
        return this;
    }

    /**
     * ID of the case this variable belongs to
     * 
     * @return caseId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CASE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCaseId() {
        return caseId;
    }

    @JsonProperty(JSON_PROPERTY_CASE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCaseId(@jakarta.annotation.Nullable String caseId) {
        this.caseId = caseId;
    }

    public ArchivedProcessInstanceVariable value(@jakarta.annotation.Nullable String value) {

        this.value = value;
        return this;
    }

    /**
     * the value of this variable. The format of the value depends on the type of the variable
     * 
     * @return value
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getValue() {
        return value;
    }

    @JsonProperty(JSON_PROPERTY_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setValue(@jakarta.annotation.Nullable String value) {
        this.value = value;
    }

    public ArchivedProcessInstanceVariable archivedDate(@jakarta.annotation.Nullable String archivedDate) {

        this.archivedDate = archivedDate;
        return this;
    }

    /**
     * The date when this variable was archived. The date format is yyyy-MM-dd HH:mm:ss.SSS
     * 
     * @return archivedDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ARCHIVED_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getArchivedDate() {
        return archivedDate;
    }

    @JsonProperty(JSON_PROPERTY_ARCHIVED_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setArchivedDate(@jakarta.annotation.Nullable String archivedDate) {
        this.archivedDate = archivedDate;
    }

    public ArchivedProcessInstanceVariable sourcedObjectId(@jakarta.annotation.Nullable String sourcedObjectId) {

        this.sourcedObjectId = sourcedObjectId;
        return this;
    }

    /**
     * The id of the variable before it was archived
     * 
     * @return sourcedObjectId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SOURCED_OBJECT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSourcedObjectId() {
        return sourcedObjectId;
    }

    @JsonProperty(JSON_PROPERTY_SOURCED_OBJECT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSourcedObjectId(@jakarta.annotation.Nullable String sourcedObjectId) {
        this.sourcedObjectId = sourcedObjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArchivedProcessInstanceVariable archivedProcessInstanceVariable = (ArchivedProcessInstanceVariable) o;
        return Objects.equals(this.name, archivedProcessInstanceVariable.name) &&
                Objects.equals(this.description, archivedProcessInstanceVariable.description) &&
                Objects.equals(this.type, archivedProcessInstanceVariable.type) &&
                Objects.equals(this.caseId, archivedProcessInstanceVariable.caseId) &&
                Objects.equals(this.value, archivedProcessInstanceVariable.value) &&
                Objects.equals(this.archivedDate, archivedProcessInstanceVariable.archivedDate) &&
                Objects.equals(this.sourcedObjectId, archivedProcessInstanceVariable.sourcedObjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, type, caseId, value, archivedDate, sourcedObjectId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ArchivedProcessInstanceVariable {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    archivedDate: ").append(toIndentedString(archivedDate)).append("\n");
        sb.append("    sourcedObjectId: ").append(toIndentedString(sourcedObjectId)).append("\n");
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
