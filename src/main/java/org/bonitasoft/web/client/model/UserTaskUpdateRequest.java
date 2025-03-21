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
 * UserTaskUpdateRequest
 */
@JsonPropertyOrder({
        UserTaskUpdateRequest.JSON_PROPERTY_STATE,
        UserTaskUpdateRequest.JSON_PROPERTY_ASSIGNED_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class UserTaskUpdateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_STATE = "state";
    @jakarta.annotation.Nullable
    private String state;

    public static final String JSON_PROPERTY_ASSIGNED_ID = "assigned_id";
    @jakarta.annotation.Nullable
    private String assignedId;

    public UserTaskUpdateRequest() {
    }

    public UserTaskUpdateRequest state(@jakarta.annotation.Nullable String state) {

        this.state = state;
        return this;
    }

    /**
     * The UserTask state
     * 
     * @return state
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getState() {
        return state;
    }

    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setState(@jakarta.annotation.Nullable String state) {
        this.state = state;
    }

    public UserTaskUpdateRequest assignedId(@jakarta.annotation.Nullable String assignedId) {

        this.assignedId = assignedId;
        return this;
    }

    /**
     * The id of the user assign to the UserTask
     * 
     * @return assignedId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ASSIGNED_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getAssignedId() {
        return assignedId;
    }

    @JsonProperty(JSON_PROPERTY_ASSIGNED_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAssignedId(@jakarta.annotation.Nullable String assignedId) {
        this.assignedId = assignedId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserTaskUpdateRequest userTaskUpdateRequest = (UserTaskUpdateRequest) o;
        return Objects.equals(this.state, userTaskUpdateRequest.state) &&
                Objects.equals(this.assignedId, userTaskUpdateRequest.assignedId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, assignedId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserTaskUpdateRequest {\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    assignedId: ").append(toIndentedString(assignedId)).append("\n");
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
