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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Error
 */
@JsonPropertyOrder({
        Error.JSON_PROPERTY_MESSAGE,
        Error.JSON_PROPERTY_EXCEPTION,
        Error.JSON_PROPERTY_EXPLANATIONS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class Error extends HashMap<String, Object> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_MESSAGE = "message";
    private String message;

    public static final String JSON_PROPERTY_EXCEPTION = "exception";
    private String exception;

    public static final String JSON_PROPERTY_EXPLANATIONS = "explanations";
    private List<String> explanations = new ArrayList<>();

    public Error() {

    }

    public Error message(String message) {

        this.message = message;
        return this;
    }

    /**
     * The error message
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

    public Error exception(String exception) {

        this.exception = exception;
        return this;
    }

    /**
     * The exception type
     * 
     * @return exception
     **/
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

    public Error explanations(List<String> explanations) {

        this.explanations = explanations;
        return this;
    }

    public Error addExplanationsItem(String explanationsItem) {
        if (this.explanations == null) {
            this.explanations = new ArrayList<>();
        }
        this.explanations.add(explanationsItem);
        return this;
    }

    /**
     * Further details on the error
     * 
     * @return explanations
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EXPLANATIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getExplanations() {
        return explanations;
    }

    @JsonProperty(JSON_PROPERTY_EXPLANATIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setExplanations(List<String> explanations) {
        this.explanations = explanations;
    }

    /**
     * A container for additional, undeclared properties.
     * This is a holder for any undeclared properties as specified with
     * the 'additionalProperties' keyword in the OAS document.
     */
    private Map<String, Object> additionalProperties;

    /**
     * Set the additional (undeclared) property with the specified name and value.
     * If the property does not already exist, create it otherwise replace it.
     * 
     * @param key the name of the property
     * @param value the value of the property
     * @return self reference
     */
    @JsonAnySetter
    public Error putAdditionalProperty(String key, Object value) {
        if (this.additionalProperties == null) {
            this.additionalProperties = new HashMap<String, Object>();
        }
        this.additionalProperties.put(key, value);
        return this;
    }

    /**
     * Return the additional (undeclared) properties.
     * 
     * @return the additional (undeclared) properties
     */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    /**
     * Return the additional (undeclared) property with the specified name.
     * 
     * @param key the name of the property
     * @return the additional (undeclared) property with the specified name
     */
    public Object getAdditionalProperty(String key) {
        if (this.additionalProperties == null) {
            return null;
        }
        return this.additionalProperties.get(key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Error error = (Error) o;
        return Objects.equals(this.message, error.message) &&
                Objects.equals(this.exception, error.exception) &&
                Objects.equals(this.explanations, error.explanations) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, exception, explanations, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Error {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    exception: ").append(toIndentedString(exception)).append("\n");
        sb.append("    explanations: ").append(toIndentedString(explanations)).append("\n");
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
