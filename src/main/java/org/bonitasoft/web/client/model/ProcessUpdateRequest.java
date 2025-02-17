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
 * ProcessUpdateRequest
 */
@JsonPropertyOrder({
        ProcessUpdateRequest.JSON_PROPERTY_DISPLAYDESCRIPTION,
        ProcessUpdateRequest.JSON_PROPERTY_DISPLAY_NAME,
        ProcessUpdateRequest.JSON_PROPERTY_ACTIVATION_STATE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.8.0")
public class ProcessUpdateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_DISPLAYDESCRIPTION = "displaydescription";
    private String displaydescription;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    private String displayName;

    public static final String JSON_PROPERTY_ACTIVATION_STATE = "activationState";
    private ActivationState activationState;

    public ProcessUpdateRequest() {
    }

    public ProcessUpdateRequest displaydescription(String displaydescription) {

        this.displaydescription = displaydescription;
        return this;
    }

    /**
     * description of the Process
     * 
     * @return displaydescription
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DISPLAYDESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDisplaydescription() {
        return displaydescription;
    }

    @JsonProperty(JSON_PROPERTY_DISPLAYDESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDisplaydescription(String displaydescription) {
        this.displaydescription = displaydescription;
    }

    public ProcessUpdateRequest displayName(String displayName) {

        this.displayName = displayName;
        return this;
    }

    /**
     * display name of the Process
     * 
     * @return displayName
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public ProcessUpdateRequest activationState(ActivationState activationState) {

        this.activationState = activationState;
        return this;
    }

    /**
     * Get activationState
     * 
     * @return activationState
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ACTIVATION_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ActivationState getActivationState() {
        return activationState;
    }

    @JsonProperty(JSON_PROPERTY_ACTIVATION_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setActivationState(ActivationState activationState) {
        this.activationState = activationState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProcessUpdateRequest processUpdateRequest = (ProcessUpdateRequest) o;
        return Objects.equals(this.displaydescription, processUpdateRequest.displaydescription) &&
                Objects.equals(this.displayName, processUpdateRequest.displayName) &&
                Objects.equals(this.activationState, processUpdateRequest.activationState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displaydescription, displayName, activationState);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessUpdateRequest {\n");
        sb.append("    displaydescription: ").append(toIndentedString(displaydescription)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    activationState: ").append(toIndentedString(activationState)).append("\n");
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
