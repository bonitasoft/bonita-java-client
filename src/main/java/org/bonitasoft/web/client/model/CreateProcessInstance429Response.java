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
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * CreateProcessInstance429Response
 */
@JsonPropertyOrder({
        CreateProcessInstance429Response.JSON_PROPERTY_MESSAGE,
        CreateProcessInstance429Response.JSON_PROPERTY_EXCEPTION
})
@JsonTypeName("createProcessInstance_429_response")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.8.0")
public class CreateProcessInstance429Response implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_MESSAGE = "message";
    private String message;

    public static final String JSON_PROPERTY_EXCEPTION = "exception";
    private String exception;

    public CreateProcessInstance429Response() {
    }

    public CreateProcessInstance429Response message(String message) {

        this.message = message;
        return this;
    }

    /**
     * The error message
     * 
     * @return message
     */
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

    public CreateProcessInstance429Response exception(String exception) {

        this.exception = exception;
        return this;
    }

    /**
     * The exception type
     * 
     * @return exception
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EXCEPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getException() {
        return exception;
    }

    @JsonProperty(JSON_PROPERTY_EXCEPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setException(String exception) {
        this.exception = exception;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateProcessInstance429Response createProcessInstance429Response = (CreateProcessInstance429Response) o;
        return Objects.equals(this.message, createProcessInstance429Response.message) &&
                Objects.equals(this.exception, createProcessInstance429Response.exception);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, exception);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateProcessInstance429Response {\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    exception: ").append(toIndentedString(exception)).append("\n");
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
