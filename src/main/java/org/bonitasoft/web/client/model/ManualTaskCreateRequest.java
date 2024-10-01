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
 * ManualTaskCreateRequest
 */
@JsonPropertyOrder({
        ManualTaskCreateRequest.JSON_PROPERTY_PARENT_TASK_ID,
        ManualTaskCreateRequest.JSON_PROPERTY_STATE,
        ManualTaskCreateRequest.JSON_PROPERTY_NAME,
        ManualTaskCreateRequest.JSON_PROPERTY_DESCRIPTION,
        ManualTaskCreateRequest.JSON_PROPERTY_PRIORITY,
        ManualTaskCreateRequest.JSON_PROPERTY_DUE_DATE,
        ManualTaskCreateRequest.JSON_PROPERTY_ASSIGNED_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.8.0")
public class ManualTaskCreateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_PARENT_TASK_ID = "parentTaskId";
    private String parentTaskId;

    public static final String JSON_PROPERTY_STATE = "state";
    private String state;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_PRIORITY = "priority";
    private String priority;

    public static final String JSON_PROPERTY_DUE_DATE = "dueDate";
    private String dueDate;

    public static final String JSON_PROPERTY_ASSIGNED_ID = "assigned_id";
    private String assignedId;

    public ManualTaskCreateRequest() {
    }

    public ManualTaskCreateRequest parentTaskId(String parentTaskId) {

        this.parentTaskId = parentTaskId;
        return this;
    }

    /**
     * The parent task ID
     * 
     * @return parentTaskId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PARENT_TASK_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getParentTaskId() {
        return parentTaskId;
    }

    @JsonProperty(JSON_PROPERTY_PARENT_TASK_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setParentTaskId(String parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public ManualTaskCreateRequest state(String state) {

        this.state = state;
        return this;
    }

    /**
     * The task state
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
    public void setState(String state) {
        this.state = state;
    }

    public ManualTaskCreateRequest name(String name) {

        this.name = name;
        return this;
    }

    /**
     * The task name
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

    public ManualTaskCreateRequest description(String description) {

        this.description = description;
        return this;
    }

    /**
     * The task description
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

    public ManualTaskCreateRequest priority(String priority) {

        this.priority = priority;
        return this;
    }

    /**
     * The task priority
     * 
     * @return priority
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PRIORITY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPriority() {
        return priority;
    }

    @JsonProperty(JSON_PROPERTY_PRIORITY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPriority(String priority) {
        this.priority = priority;
    }

    public ManualTaskCreateRequest dueDate(String dueDate) {

        this.dueDate = dueDate;
        return this;
    }

    /**
     * The task due date
     * 
     * @return dueDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DUE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDueDate() {
        return dueDate;
    }

    @JsonProperty(JSON_PROPERTY_DUE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public ManualTaskCreateRequest assignedId(String assignedId) {

        this.assignedId = assignedId;
        return this;
    }

    /**
     * The id of the user assigned to the task
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
    public void setAssignedId(String assignedId) {
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
        ManualTaskCreateRequest manualTaskCreateRequest = (ManualTaskCreateRequest) o;
        return Objects.equals(this.parentTaskId, manualTaskCreateRequest.parentTaskId) &&
                Objects.equals(this.state, manualTaskCreateRequest.state) &&
                Objects.equals(this.name, manualTaskCreateRequest.name) &&
                Objects.equals(this.description, manualTaskCreateRequest.description) &&
                Objects.equals(this.priority, manualTaskCreateRequest.priority) &&
                Objects.equals(this.dueDate, manualTaskCreateRequest.dueDate) &&
                Objects.equals(this.assignedId, manualTaskCreateRequest.assignedId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentTaskId, state, name, description, priority, dueDate, assignedId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ManualTaskCreateRequest {\n");
        sb.append("    parentTaskId: ").append(toIndentedString(parentTaskId)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
        sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
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
