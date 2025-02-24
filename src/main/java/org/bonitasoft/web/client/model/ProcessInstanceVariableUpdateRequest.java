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
 * ProcessInstanceVariableUpdateRequest
 */
@JsonPropertyOrder({
        ProcessInstanceVariableUpdateRequest.JSON_PROPERTY_TYPE,
        ProcessInstanceVariableUpdateRequest.JSON_PROPERTY_VALUE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class ProcessInstanceVariableUpdateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_TYPE = "type";
    @jakarta.annotation.Nullable
    private String type;

    public static final String JSON_PROPERTY_VALUE = "value";
    @jakarta.annotation.Nullable
    private String value;

    public ProcessInstanceVariableUpdateRequest() {
    }

    public ProcessInstanceVariableUpdateRequest type(@jakarta.annotation.Nullable String type) {

        this.type = type;
        return this;
    }

    /**
     * the java class name
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

    public ProcessInstanceVariableUpdateRequest value(@jakarta.annotation.Nullable String value) {

        this.value = value;
        return this;
    }

    /**
     * the new value
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProcessInstanceVariableUpdateRequest processInstanceVariableUpdateRequest = (ProcessInstanceVariableUpdateRequest) o;
        return Objects.equals(this.type, processInstanceVariableUpdateRequest.type) &&
                Objects.equals(this.value, processInstanceVariableUpdateRequest.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessInstanceVariableUpdateRequest {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
