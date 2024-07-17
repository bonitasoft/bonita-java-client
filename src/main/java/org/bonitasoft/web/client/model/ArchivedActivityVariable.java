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
 * This resource enables you to retrieve the value of a specific archived variable name for a specific case (or process instance). Only persistent variables are
 * concerned by this resource, not transient variables.
 */
@JsonPropertyOrder({
        ArchivedActivityVariable.JSON_PROPERTY_NAME,
        ArchivedActivityVariable.JSON_PROPERTY_DESCRIPTION,
        ArchivedActivityVariable.JSON_PROPERTY_TYPE,
        ArchivedActivityVariable.JSON_PROPERTY_CONTAINER_ID,
        ArchivedActivityVariable.JSON_PROPERTY_CONTAINER_TYPE,
        ArchivedActivityVariable.JSON_PROPERTY_VALUE,
        ArchivedActivityVariable.JSON_PROPERTY_ARCHIVED_DATE,
        ArchivedActivityVariable.JSON_PROPERTY_SOURCED_OBJECT_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class ArchivedActivityVariable implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_TYPE = "type";
    private String type;

    public static final String JSON_PROPERTY_CONTAINER_ID = "containerId";
    private String containerId;

    public static final String JSON_PROPERTY_CONTAINER_TYPE = "containerType";
    private String containerType;

    public static final String JSON_PROPERTY_VALUE = "value";
    private String value;

    public static final String JSON_PROPERTY_ARCHIVED_DATE = "archivedDate";
    private String archivedDate;

    public static final String JSON_PROPERTY_SOURCED_OBJECT_ID = "sourcedObjectId";
    private String sourcedObjectId;

    public ArchivedActivityVariable() {
    }

    public ArchivedActivityVariable name(String name) {

        this.name = name;
        return this;
    }

    /**
     * The name of the archived activity variable
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
    public void setName(String name) {
        this.name = name;
    }

    public ArchivedActivityVariable description(String description) {

        this.description = description;
        return this;
    }

    /**
     * The description of the variable if any
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
    public void setDescription(String description) {
        this.description = description;
    }

    public ArchivedActivityVariable type(String type) {

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
    public void setType(String type) {
        this.type = type;
    }

    public ArchivedActivityVariable containerId(String containerId) {

        this.containerId = containerId;
        return this;
    }

    /**
     * The ID of the activity containing this variable (same as the one passed as parameter)
     * 
     * @return containerId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONTAINER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getContainerId() {
        return containerId;
    }

    @JsonProperty(JSON_PROPERTY_CONTAINER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public ArchivedActivityVariable containerType(String containerType) {

        this.containerType = containerType;
        return this;
    }

    /**
     * ACTIVITY_INSTANCE
     * 
     * @return containerType
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONTAINER_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getContainerType() {
        return containerType;
    }

    @JsonProperty(JSON_PROPERTY_CONTAINER_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public ArchivedActivityVariable value(String value) {

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
    public void setValue(String value) {
        this.value = value;
    }

    public ArchivedActivityVariable archivedDate(String archivedDate) {

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
    public void setArchivedDate(String archivedDate) {
        this.archivedDate = archivedDate;
    }

    public ArchivedActivityVariable sourcedObjectId(String sourcedObjectId) {

        this.sourcedObjectId = sourcedObjectId;
        return this;
    }

    /**
     * The id of the activity variable before it was archived
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
    public void setSourcedObjectId(String sourcedObjectId) {
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
        ArchivedActivityVariable archivedActivityVariable = (ArchivedActivityVariable) o;
        return Objects.equals(this.name, archivedActivityVariable.name) &&
                Objects.equals(this.description, archivedActivityVariable.description) &&
                Objects.equals(this.type, archivedActivityVariable.type) &&
                Objects.equals(this.containerId, archivedActivityVariable.containerId) &&
                Objects.equals(this.containerType, archivedActivityVariable.containerType) &&
                Objects.equals(this.value, archivedActivityVariable.value) &&
                Objects.equals(this.archivedDate, archivedActivityVariable.archivedDate) &&
                Objects.equals(this.sourcedObjectId, archivedActivityVariable.sourcedObjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, type, containerId, containerType, value, archivedDate, sourcedObjectId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ArchivedActivityVariable {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    containerId: ").append(toIndentedString(containerId)).append("\n");
        sb.append("    containerType: ").append(toIndentedString(containerType)).append("\n");
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
