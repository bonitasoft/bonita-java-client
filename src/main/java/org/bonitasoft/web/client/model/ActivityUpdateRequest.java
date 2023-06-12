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
 * ActivityUpdateRequest
 */
@JsonPropertyOrder({
        ActivityUpdateRequest.JSON_PROPERTY_VARIABLES,
        ActivityUpdateRequest.JSON_PROPERTY_STATE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ActivityUpdateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_VARIABLES = "variables";
    private String variables;

    public static final String JSON_PROPERTY_STATE = "state";
    private String state;

    public ActivityUpdateRequest() {
    }

    public ActivityUpdateRequest variables(String variables) {

        this.variables = variables;
        return this;
    }

    /**
     * Activity variables to update. **Note**: if there is no data with the specified name in the activity, the update will be applied to the process data if a
     * variable with the specified name exists. **Note**: if the task definition includes a connector that is executed on finish and updates the value of a
     * variable, the value set by the REST API call is overwritten.
     * 
     * @return variables
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VARIABLES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getVariables() {
        return variables;
    }

    @JsonProperty(JSON_PROPERTY_VARIABLES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVariables(String variables) {
        this.variables = variables;
    }

    public ActivityUpdateRequest state(String state) {

        this.state = state;
        return this;
    }

    /**
     * The target state of the activity - Execute a task: &#x60;completed&#x60; - Skip activity: &#x60;skipped&#x60; - Make this call after all failed connectors
     * have been reset ![edition](https://img.shields.io/badge/edition-entreprise-blue) - Replay activity: &#x60;replay&#x60;
     * 
     * @return state
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getState() {
        return state;
    }

    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ActivityUpdateRequest activityUpdateRequest = (ActivityUpdateRequest) o;
        return Objects.equals(this.variables, activityUpdateRequest.variables) &&
                Objects.equals(this.state, activityUpdateRequest.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variables, state);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ActivityUpdateRequest {\n");
        sb.append("    variables: ").append(toIndentedString(variables)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
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
