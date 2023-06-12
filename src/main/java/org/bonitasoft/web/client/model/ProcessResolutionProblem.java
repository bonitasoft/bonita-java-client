/** 
 * Copyright (C) 2022 BonitaSoft S.A.
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
 * This resource represents a problem in a process that needs to be resolved for the process to run. It can be an actor, a connector implementation, or a
 * parameter (in the Enterprise, Performance, Efficiency, or Teamwork edition).
 */
@JsonPropertyOrder({
        ProcessResolutionProblem.JSON_PROPERTY_MESSAGE,
        ProcessResolutionProblem.JSON_PROPERTY_RESOURCE_ID,
        ProcessResolutionProblem.JSON_PROPERTY_TARGET_TYPE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ProcessResolutionProblem implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_MESSAGE = "message";
    private String message;

    public static final String JSON_PROPERTY_RESOURCE_ID = "resource_id";
    private String resourceId;

    public static final String JSON_PROPERTY_TARGET_TYPE = "target_type";
    private String targetType;

    public ProcessResolutionProblem() {
    }

    public ProcessResolutionProblem message(String message) {

        this.message = message;
        return this;
    }

    /**
     * resolution problem
     * 
     * @return message
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getMessage() {
        return message;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMessage(String message) {
        this.message = message;
    }

    public ProcessResolutionProblem resourceId(String resourceId) {

        this.resourceId = resourceId;
        return this;
    }

    /**
     * id of the unresolved resource
     * 
     * @return resourceId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_RESOURCE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getResourceId() {
        return resourceId;
    }

    @JsonProperty(JSON_PROPERTY_RESOURCE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public ProcessResolutionProblem targetType(String targetType) {

        this.targetType = targetType;
        return this;
    }

    /**
     * the type of the unresolved resource (parameter, actor, or connector)
     * 
     * @return targetType
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TARGET_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTargetType() {
        return targetType;
    }

    @JsonProperty(JSON_PROPERTY_TARGET_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProcessResolutionProblem processResolutionProblem = (ProcessResolutionProblem) o;
        return Objects.equals(this.message, processResolutionProblem.message) &&
                Objects.equals(this.resourceId, processResolutionProblem.resourceId) &&
                Objects.equals(this.targetType, processResolutionProblem.targetType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, resourceId, targetType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessResolutionProblem {\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    resourceId: ").append(toIndentedString(resourceId)).append("\n");
        sb.append("    targetType: ").append(toIndentedString(targetType)).append("\n");
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
