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
 * 
 */
@JsonPropertyOrder({
        ProcessParameter.JSON_PROPERTY_PROCESS_ID,
        ProcessParameter.JSON_PROPERTY_PROCESS_NAME,
        ProcessParameter.JSON_PROPERTY_DESCRIPTION,
        ProcessParameter.JSON_PROPERTY_NAME,
        ProcessParameter.JSON_PROPERTY_VALUE,
        ProcessParameter.JSON_PROPERTY_PROCESS_VERSION,
        ProcessParameter.JSON_PROPERTY_TYPE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class ProcessParameter implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_PROCESS_ID = "process_id";
    private String processId;

    public static final String JSON_PROPERTY_PROCESS_NAME = "process_name";
    private String processName;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_VALUE = "value";
    private String value;

    public static final String JSON_PROPERTY_PROCESS_VERSION = "process_version";
    private String processVersion;

    public static final String JSON_PROPERTY_TYPE = "type";
    private String type;

    public ProcessParameter() {
    }

    public ProcessParameter processId(String processId) {

        this.processId = processId;
        return this;
    }

    /**
     * the identifier of the process definition
     * 
     * @return processId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PROCESS_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getProcessId() {
        return processId;
    }

    @JsonProperty(JSON_PROPERTY_PROCESS_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public ProcessParameter processName(String processName) {

        this.processName = processName;
        return this;
    }

    /**
     * the name of the related process
     * 
     * @return processName
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PROCESS_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getProcessName() {
        return processName;
    }

    @JsonProperty(JSON_PROPERTY_PROCESS_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public ProcessParameter description(String description) {

        this.description = description;
        return this;
    }

    /**
     * the description of the parameter
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

    public ProcessParameter name(String name) {

        this.name = name;
        return this;
    }

    /**
     * the name of the parameter
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

    public ProcessParameter value(String value) {

        this.value = value;
        return this;
    }

    /**
     * the value of the parameter
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

    public ProcessParameter processVersion(String processVersion) {

        this.processVersion = processVersion;
        return this;
    }

    /**
     * the version of the process
     * 
     * @return processVersion
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PROCESS_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getProcessVersion() {
        return processVersion;
    }

    @JsonProperty(JSON_PROPERTY_PROCESS_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProcessVersion(String processVersion) {
        this.processVersion = processVersion;
    }

    public ProcessParameter type(String type) {

        this.type = type;
        return this;
    }

    /**
     * the type of the parameter
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProcessParameter processParameter = (ProcessParameter) o;
        return Objects.equals(this.processId, processParameter.processId) &&
                Objects.equals(this.processName, processParameter.processName) &&
                Objects.equals(this.description, processParameter.description) &&
                Objects.equals(this.name, processParameter.name) &&
                Objects.equals(this.value, processParameter.value) &&
                Objects.equals(this.processVersion, processParameter.processVersion) &&
                Objects.equals(this.type, processParameter.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(processId, processName, description, name, value, processVersion, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessParameter {\n");
        sb.append("    processId: ").append(toIndentedString(processId)).append("\n");
        sb.append("    processName: ").append(toIndentedString(processName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    processVersion: ").append(toIndentedString(processVersion)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
