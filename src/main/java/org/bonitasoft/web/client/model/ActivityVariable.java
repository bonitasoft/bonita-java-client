/** 
 * Copyright (C) 2024 BonitaSoft S.A.
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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This resource enables you to retrieve the value of a specific variable name for a specific process instance (or case). Only persistent variables are
 * concerned by this resource, not transient variables.
 */
@JsonPropertyOrder({
        ActivityVariable.JSON_PROPERTY_TENANT_ID,
        ActivityVariable.JSON_PROPERTY_TENANT_ID_STRING,
        ActivityVariable.JSON_PROPERTY_ID,
        ActivityVariable.JSON_PROPERTY_ID_STRING,
        ActivityVariable.JSON_PROPERTY_NAME,
        ActivityVariable.JSON_PROPERTY_DESCRIPTION,
        ActivityVariable.JSON_PROPERTY_TRANSIENT_DATA,
        ActivityVariable.JSON_PROPERTY_CLASS_NAME,
        ActivityVariable.JSON_PROPERTY_CONTAINER_ID,
        ActivityVariable.JSON_PROPERTY_CONTAINER_ID_STRING,
        ActivityVariable.JSON_PROPERTY_CONTAINER_TYPE,
        ActivityVariable.JSON_PROPERTY_VALUE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class ActivityVariable implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_TENANT_ID = "tenantId";
    private String tenantId;

    public static final String JSON_PROPERTY_TENANT_ID_STRING = "tenantId_string";
    private String tenantIdString;

    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_ID_STRING = "id_string";
    private String idString;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_TRANSIENT_DATA = "transientData";
    private String transientData;

    public static final String JSON_PROPERTY_CLASS_NAME = "className";
    private String className;

    public static final String JSON_PROPERTY_CONTAINER_ID = "containerId";
    private String containerId;

    public static final String JSON_PROPERTY_CONTAINER_ID_STRING = "containerId_string";
    private String containerIdString;

    /**
     * ACTIVITY_INSTANCE | PROCESS_INSTANCE depending on whether the variable is defined at activity or process level.
     */
    public enum ContainerTypeEnum {

        ACTIVITY_INSTANCE("ACTIVITY_INSTANCE"),

        PROCESS_INSTANCE("PROCESS_INSTANCE");

        private String value;

        ContainerTypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static ContainerTypeEnum fromValue(String value) {
            for (ContainerTypeEnum b : ContainerTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_CONTAINER_TYPE = "containerType";
    private ContainerTypeEnum containerType;

    public static final String JSON_PROPERTY_VALUE = "value";
    private String value;

    public ActivityVariable() {
    }

    public ActivityVariable tenantId(String tenantId) {

        this.tenantId = tenantId;
        return this;
    }

    /**
     * The ID of the tenant where the current user is logged in (technical information)
     * 
     * @return tenantId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TENANT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTenantId() {
        return tenantId;
    }

    @JsonProperty(JSON_PROPERTY_TENANT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public ActivityVariable tenantIdString(String tenantIdString) {

        this.tenantIdString = tenantIdString;
        return this;
    }

    /**
     * number (since 7.0.1)
     * 
     * @return tenantIdString
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TENANT_ID_STRING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTenantIdString() {
        return tenantIdString;
    }

    @JsonProperty(JSON_PROPERTY_TENANT_ID_STRING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTenantIdString(String tenantIdString) {
        this.tenantIdString = tenantIdString;
    }

    public ActivityVariable id(String id) {

        this.id = id;
        return this;
    }

    /**
     * The identifier of the variable
     * 
     * @return id
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setId(String id) {
        this.id = id;
    }

    public ActivityVariable idString(String idString) {

        this.idString = idString;
        return this;
    }

    /**
     * number (since 7.0.1)
     * 
     * @return idString
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID_STRING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getIdString() {
        return idString;
    }

    @JsonProperty(JSON_PROPERTY_ID_STRING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIdString(String idString) {
        this.idString = idString;
    }

    public ActivityVariable name(String name) {

        this.name = name;
        return this;
    }

    /**
     * The name of the activity variable
     * 
     * @return name
     **/
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

    public ActivityVariable description(String description) {

        this.description = description;
        return this;
    }

    /**
     * The description of the variable if any
     * 
     * @return description
     **/
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

    public ActivityVariable transientData(String transientData) {

        this.transientData = transientData;
        return this;
    }

    /**
     * FALSE
     * 
     * @return transientData
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TRANSIENT_DATA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTransientData() {
        return transientData;
    }

    @JsonProperty(JSON_PROPERTY_TRANSIENT_DATA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTransientData(String transientData) {
        this.transientData = transientData;
    }

    public ActivityVariable className(String className) {

        this.className = className;
        return this;
    }

    /**
     * The fully qualified class name of the variable type
     * 
     * @return className
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CLASS_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getClassName() {
        return className;
    }

    @JsonProperty(JSON_PROPERTY_CLASS_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setClassName(String className) {
        this.className = className;
    }

    public ActivityVariable containerId(String containerId) {

        this.containerId = containerId;
        return this;
    }

    /**
     * The ID of the activity containing this variable (same as the one passed as parameter) if the variable is defined at activity level or ID of the process
     * instance if the variable is defined on the process
     * 
     * @return containerId
     **/
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

    public ActivityVariable containerIdString(String containerIdString) {

        this.containerIdString = containerIdString;
        return this;
    }

    /**
     * number (since 7.0.1)
     * 
     * @return containerIdString
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONTAINER_ID_STRING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getContainerIdString() {
        return containerIdString;
    }

    @JsonProperty(JSON_PROPERTY_CONTAINER_ID_STRING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContainerIdString(String containerIdString) {
        this.containerIdString = containerIdString;
    }

    public ActivityVariable containerType(ContainerTypeEnum containerType) {

        this.containerType = containerType;
        return this;
    }

    /**
     * ACTIVITY_INSTANCE | PROCESS_INSTANCE depending on whether the variable is defined at activity or process level.
     * 
     * @return containerType
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONTAINER_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ContainerTypeEnum getContainerType() {
        return containerType;
    }

    @JsonProperty(JSON_PROPERTY_CONTAINER_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContainerType(ContainerTypeEnum containerType) {
        this.containerType = containerType;
    }

    public ActivityVariable value(String value) {

        this.value = value;
        return this;
    }

    /**
     * the value of this variable. The format of the value depends on the type of the variable
     * 
     * @return value
     **/
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ActivityVariable activityVariable = (ActivityVariable) o;
        return Objects.equals(this.tenantId, activityVariable.tenantId) &&
                Objects.equals(this.tenantIdString, activityVariable.tenantIdString) &&
                Objects.equals(this.id, activityVariable.id) &&
                Objects.equals(this.idString, activityVariable.idString) &&
                Objects.equals(this.name, activityVariable.name) &&
                Objects.equals(this.description, activityVariable.description) &&
                Objects.equals(this.transientData, activityVariable.transientData) &&
                Objects.equals(this.className, activityVariable.className) &&
                Objects.equals(this.containerId, activityVariable.containerId) &&
                Objects.equals(this.containerIdString, activityVariable.containerIdString) &&
                Objects.equals(this.containerType, activityVariable.containerType) &&
                Objects.equals(this.value, activityVariable.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenantId, tenantIdString, id, idString, name, description, transientData, className,
                containerId, containerIdString, containerType, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ActivityVariable {\n");
        sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
        sb.append("    tenantIdString: ").append(toIndentedString(tenantIdString)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    idString: ").append(toIndentedString(idString)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    transientData: ").append(toIndentedString(transientData)).append("\n");
        sb.append("    className: ").append(toIndentedString(className)).append("\n");
        sb.append("    containerId: ").append(toIndentedString(containerId)).append("\n");
        sb.append("    containerIdString: ").append(toIndentedString(containerIdString)).append("\n");
        sb.append("    containerType: ").append(toIndentedString(containerType)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
