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
 * AbstractTask
 */
@JsonPropertyOrder({
        AbstractTask.JSON_PROPERTY_ID,
        AbstractTask.JSON_PROPERTY_TYPE,
        AbstractTask.JSON_PROPERTY_NAME,
        AbstractTask.JSON_PROPERTY_DISPLAY_NAME,
        AbstractTask.JSON_PROPERTY_DESCRIPTION,
        AbstractTask.JSON_PROPERTY_DISPLAY_DESCRIPTION,
        AbstractTask.JSON_PROPERTY_STATE,
        AbstractTask.JSON_PROPERTY_REACHED_STATE_DATE,
        AbstractTask.JSON_PROPERTY_LAST_UPDATE_DATE,
        AbstractTask.JSON_PROPERTY_DUE_DATE,
        AbstractTask.JSON_PROPERTY_PRIORITY,
        AbstractTask.JSON_PROPERTY_PROCESS_ID,
        AbstractTask.JSON_PROPERTY_PARENT_CASE_ID,
        AbstractTask.JSON_PROPERTY_PARENT_TASK_ID,
        AbstractTask.JSON_PROPERTY_ROOT_CASE_ID,
        AbstractTask.JSON_PROPERTY_ROOT_CONTAINER_ID,
        AbstractTask.JSON_PROPERTY_EXECUTED_BY,
        AbstractTask.JSON_PROPERTY_EXECUTED_BY_SUBSTITUTE,
        AbstractTask.JSON_PROPERTY_ACTOR_ID,
        AbstractTask.JSON_PROPERTY_ASSIGNED_ID,
        AbstractTask.JSON_PROPERTY_ASSIGNED_DATE,
        AbstractTask.JSON_PROPERTY_IS_TERMINAL
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class AbstractTask implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    @jakarta.annotation.Nullable
    private String id;

    public static final String JSON_PROPERTY_TYPE = "type";
    @jakarta.annotation.Nullable
    private String type;

    public static final String JSON_PROPERTY_NAME = "name";
    @jakarta.annotation.Nullable
    private String name;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    @jakarta.annotation.Nullable
    private String displayName;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    @jakarta.annotation.Nullable
    private String description;

    public static final String JSON_PROPERTY_DISPLAY_DESCRIPTION = "displayDescription";
    @jakarta.annotation.Nullable
    private String displayDescription;

    public static final String JSON_PROPERTY_STATE = "state";
    @jakarta.annotation.Nullable
    private ActivityState state;

    public static final String JSON_PROPERTY_REACHED_STATE_DATE = "reached_state_date";
    @jakarta.annotation.Nullable
    private String reachedStateDate;

    public static final String JSON_PROPERTY_LAST_UPDATE_DATE = "last_update_date";
    @jakarta.annotation.Nullable
    private String lastUpdateDate;

    public static final String JSON_PROPERTY_DUE_DATE = "dueDate";
    @jakarta.annotation.Nullable
    private String dueDate;

    public static final String JSON_PROPERTY_PRIORITY = "priority";
    @jakarta.annotation.Nullable
    private String priority;

    public static final String JSON_PROPERTY_PROCESS_ID = "processId";
    @jakarta.annotation.Nullable
    private String processId;

    public static final String JSON_PROPERTY_PARENT_CASE_ID = "parentCaseId";
    @jakarta.annotation.Nullable
    private String parentCaseId;

    public static final String JSON_PROPERTY_PARENT_TASK_ID = "parentTaskId";
    @jakarta.annotation.Nullable
    private String parentTaskId;

    public static final String JSON_PROPERTY_ROOT_CASE_ID = "rootCaseId";
    @jakarta.annotation.Nullable
    private String rootCaseId;

    public static final String JSON_PROPERTY_ROOT_CONTAINER_ID = "rootContainerId";
    @jakarta.annotation.Nullable
    private String rootContainerId;

    public static final String JSON_PROPERTY_EXECUTED_BY = "executedBy";
    @jakarta.annotation.Nullable
    private String executedBy;

    public static final String JSON_PROPERTY_EXECUTED_BY_SUBSTITUTE = "executedBySubstitute";
    @jakarta.annotation.Nullable
    private String executedBySubstitute;

    public static final String JSON_PROPERTY_ACTOR_ID = "actorId";
    @jakarta.annotation.Nullable
    private String actorId;

    public static final String JSON_PROPERTY_ASSIGNED_ID = "assigned_id";
    @jakarta.annotation.Nullable
    private String assignedId;

    public static final String JSON_PROPERTY_ASSIGNED_DATE = "assigned_date";
    @jakarta.annotation.Nullable
    private String assignedDate;

    public static final String JSON_PROPERTY_IS_TERMINAL = "isTerminal";
    @jakarta.annotation.Nullable
    private Boolean isTerminal;

    public AbstractTask() {
    }

    public AbstractTask id(@jakarta.annotation.Nullable String id) {

        this.id = id;
        return this;
    }

    /**
     * the task id
     * 
     * @return id
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setId(@jakarta.annotation.Nullable String id) {
        this.id = id;
    }

    public AbstractTask type(@jakarta.annotation.Nullable String type) {

        this.type = type;
        return this;
    }

    /**
     * the task type
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

    public AbstractTask name(@jakarta.annotation.Nullable String name) {

        this.name = name;
        return this;
    }

    /**
     * the task technical name
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
    public void setName(@jakarta.annotation.Nullable String name) {
        this.name = name;
    }

    public AbstractTask displayName(@jakarta.annotation.Nullable String displayName) {

        this.displayName = displayName;
        return this;
    }

    /**
     * the human readable task name
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
    public void setDisplayName(@jakarta.annotation.Nullable String displayName) {
        this.displayName = displayName;
    }

    public AbstractTask description(@jakarta.annotation.Nullable String description) {

        this.description = description;
        return this;
    }

    /**
     * the task description
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
    public void setDescription(@jakarta.annotation.Nullable String description) {
        this.description = description;
    }

    public AbstractTask displayDescription(@jakarta.annotation.Nullable String displayDescription) {

        this.displayDescription = displayDescription;
        return this;
    }

    /**
     * the human readable task description
     * 
     * @return displayDescription
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DISPLAY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDisplayDescription() {
        return displayDescription;
    }

    @JsonProperty(JSON_PROPERTY_DISPLAY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDisplayDescription(@jakarta.annotation.Nullable String displayDescription) {
        this.displayDescription = displayDescription;
    }

    public AbstractTask state(@jakarta.annotation.Nullable ActivityState state) {

        this.state = state;
        return this;
    }

    /**
     * Get state
     * 
     * @return state
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ActivityState getState() {
        return state;
    }

    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setState(@jakarta.annotation.Nullable ActivityState state) {
        this.state = state;
    }

    public AbstractTask reachedStateDate(@jakarta.annotation.Nullable String reachedStateDate) {

        this.reachedStateDate = reachedStateDate;
        return this;
    }

    /**
     * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this task reached the current state for example &#39;2014-10-17 16:05:42.626&#39;
     * 
     * @return reachedStateDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REACHED_STATE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getReachedStateDate() {
        return reachedStateDate;
    }

    @JsonProperty(JSON_PROPERTY_REACHED_STATE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReachedStateDate(@jakarta.annotation.Nullable String reachedStateDate) {
        this.reachedStateDate = reachedStateDate;
    }

    public AbstractTask lastUpdateDate(@jakarta.annotation.Nullable String lastUpdateDate) {

        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    /**
     * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this task was last updated for example &#39;2014-10-17 16:05:42.626)
     * 
     * @return lastUpdateDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LAST_UPDATE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    @JsonProperty(JSON_PROPERTY_LAST_UPDATE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLastUpdateDate(@jakarta.annotation.Nullable String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public AbstractTask dueDate(@jakarta.annotation.Nullable String dueDate) {

        this.dueDate = dueDate;
        return this;
    }

    /**
     * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this task is due for example &#39;2014-10-17 16:05:42.626&#39;
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
    public void setDueDate(@jakarta.annotation.Nullable String dueDate) {
        this.dueDate = dueDate;
    }

    public AbstractTask priority(@jakarta.annotation.Nullable String priority) {

        this.priority = priority;
        return this;
    }

    /**
     * the priority (string) of the current task
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
    public void setPriority(@jakarta.annotation.Nullable String priority) {
        this.priority = priority;
    }

    public AbstractTask processId(@jakarta.annotation.Nullable String processId) {

        this.processId = processId;
        return this;
    }

    /**
     * the process definition id of the process instance which define this task
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
    public void setProcessId(@jakarta.annotation.Nullable String processId) {
        this.processId = processId;
    }

    public AbstractTask parentCaseId(@jakarta.annotation.Nullable String parentCaseId) {

        this.parentCaseId = parentCaseId;
        return this;
    }

    /**
     * the immediate containing process instance id (case id)
     * 
     * @return parentCaseId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PARENT_CASE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getParentCaseId() {
        return parentCaseId;
    }

    @JsonProperty(JSON_PROPERTY_PARENT_CASE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setParentCaseId(@jakarta.annotation.Nullable String parentCaseId) {
        this.parentCaseId = parentCaseId;
    }

    public AbstractTask parentTaskId(@jakarta.annotation.Nullable String parentTaskId) {

        this.parentTaskId = parentTaskId;
        return this;
    }

    /**
     * the parent Task id
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
    public void setParentTaskId(@jakarta.annotation.Nullable String parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public AbstractTask rootCaseId(@jakarta.annotation.Nullable String rootCaseId) {

        this.rootCaseId = rootCaseId;
        return this;
    }

    /**
     * the top/root process instance id (case id). In case of an \&quot;event sub process\&quot; &#x60;parentCaseId&#x60; will the id of the process instance called
     * while &#x60;rootCaseId&#x60; will be the one from the caller process instance
     * 
     * @return rootCaseId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ROOT_CASE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getRootCaseId() {
        return rootCaseId;
    }

    @JsonProperty(JSON_PROPERTY_ROOT_CASE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRootCaseId(@jakarta.annotation.Nullable String rootCaseId) {
        this.rootCaseId = rootCaseId;
    }

    public AbstractTask rootContainerId(@jakarta.annotation.Nullable String rootContainerId) {

        this.rootContainerId = rootContainerId;
        return this;
    }

    /**
     * same as rootCaseId
     * 
     * @return rootContainerId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ROOT_CONTAINER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getRootContainerId() {
        return rootContainerId;
    }

    @JsonProperty(JSON_PROPERTY_ROOT_CONTAINER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRootContainerId(@jakarta.annotation.Nullable String rootContainerId) {
        this.rootContainerId = rootContainerId;
    }

    public AbstractTask executedBy(@jakarta.annotation.Nullable String executedBy) {

        this.executedBy = executedBy;
        return this;
    }

    /**
     * the id of the user who performed this task. The task has to be a human task otherwise its value will be 0
     * 
     * @return executedBy
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EXECUTED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getExecutedBy() {
        return executedBy;
    }

    @JsonProperty(JSON_PROPERTY_EXECUTED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setExecutedBy(@jakarta.annotation.Nullable String executedBy) {
        this.executedBy = executedBy;
    }

    public AbstractTask executedBySubstitute(@jakarta.annotation.Nullable String executedBySubstitute) {

        this.executedBySubstitute = executedBySubstitute;
        return this;
    }

    /**
     * the id of the user who did actually performed the task when it has been done in the name of someone else. Value is 0 otherwise
     * 
     * @return executedBySubstitute
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EXECUTED_BY_SUBSTITUTE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getExecutedBySubstitute() {
        return executedBySubstitute;
    }

    @JsonProperty(JSON_PROPERTY_EXECUTED_BY_SUBSTITUTE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setExecutedBySubstitute(@jakarta.annotation.Nullable String executedBySubstitute) {
        this.executedBySubstitute = executedBySubstitute;
    }

    public AbstractTask actorId(@jakarta.annotation.Nullable String actorId) {

        this.actorId = actorId;
        return this;
    }

    /**
     * the id of the actor that can execute this task null otherwise
     * 
     * @return actorId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ACTOR_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getActorId() {
        return actorId;
    }

    @JsonProperty(JSON_PROPERTY_ACTOR_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setActorId(@jakarta.annotation.Nullable String actorId) {
        this.actorId = actorId;
    }

    public AbstractTask assignedId(@jakarta.annotation.Nullable String assignedId) {

        this.assignedId = assignedId;
        return this;
    }

    /**
     * the user id that this task is assigned to or 0 if it is unassigned
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

    public AbstractTask assignedDate(@jakarta.annotation.Nullable String assignedDate) {

        this.assignedDate = assignedDate;
        return this;
    }

    /**
     * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when the current task was assigned for example &#39;2014-10-17 16:05:42.626&#39;
     * 
     * @return assignedDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ASSIGNED_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getAssignedDate() {
        return assignedDate;
    }

    @JsonProperty(JSON_PROPERTY_ASSIGNED_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAssignedDate(@jakarta.annotation.Nullable String assignedDate) {
        this.assignedDate = assignedDate;
    }

    public AbstractTask isTerminal(@jakarta.annotation.Nullable Boolean isTerminal) {

        this.isTerminal = isTerminal;
        return this;
    }

    /**
     * True if the task is the last one in a flow
     * 
     * @return isTerminal
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_IS_TERMINAL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getIsTerminal() {
        return isTerminal;
    }

    @JsonProperty(JSON_PROPERTY_IS_TERMINAL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIsTerminal(@jakarta.annotation.Nullable Boolean isTerminal) {
        this.isTerminal = isTerminal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractTask abstractTask = (AbstractTask) o;
        return Objects.equals(this.id, abstractTask.id) &&
                Objects.equals(this.type, abstractTask.type) &&
                Objects.equals(this.name, abstractTask.name) &&
                Objects.equals(this.displayName, abstractTask.displayName) &&
                Objects.equals(this.description, abstractTask.description) &&
                Objects.equals(this.displayDescription, abstractTask.displayDescription) &&
                Objects.equals(this.state, abstractTask.state) &&
                Objects.equals(this.reachedStateDate, abstractTask.reachedStateDate) &&
                Objects.equals(this.lastUpdateDate, abstractTask.lastUpdateDate) &&
                Objects.equals(this.dueDate, abstractTask.dueDate) &&
                Objects.equals(this.priority, abstractTask.priority) &&
                Objects.equals(this.processId, abstractTask.processId) &&
                Objects.equals(this.parentCaseId, abstractTask.parentCaseId) &&
                Objects.equals(this.parentTaskId, abstractTask.parentTaskId) &&
                Objects.equals(this.rootCaseId, abstractTask.rootCaseId) &&
                Objects.equals(this.rootContainerId, abstractTask.rootContainerId) &&
                Objects.equals(this.executedBy, abstractTask.executedBy) &&
                Objects.equals(this.executedBySubstitute, abstractTask.executedBySubstitute) &&
                Objects.equals(this.actorId, abstractTask.actorId) &&
                Objects.equals(this.assignedId, abstractTask.assignedId) &&
                Objects.equals(this.assignedDate, abstractTask.assignedDate) &&
                Objects.equals(this.isTerminal, abstractTask.isTerminal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, displayName, description, displayDescription, state, reachedStateDate,
                lastUpdateDate, dueDate, priority, processId, parentCaseId, parentTaskId, rootCaseId, rootContainerId,
                executedBy, executedBySubstitute, actorId, assignedId, assignedDate, isTerminal);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AbstractTask {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    displayDescription: ").append(toIndentedString(displayDescription)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    reachedStateDate: ").append(toIndentedString(reachedStateDate)).append("\n");
        sb.append("    lastUpdateDate: ").append(toIndentedString(lastUpdateDate)).append("\n");
        sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
        sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
        sb.append("    processId: ").append(toIndentedString(processId)).append("\n");
        sb.append("    parentCaseId: ").append(toIndentedString(parentCaseId)).append("\n");
        sb.append("    parentTaskId: ").append(toIndentedString(parentTaskId)).append("\n");
        sb.append("    rootCaseId: ").append(toIndentedString(rootCaseId)).append("\n");
        sb.append("    rootContainerId: ").append(toIndentedString(rootContainerId)).append("\n");
        sb.append("    executedBy: ").append(toIndentedString(executedBy)).append("\n");
        sb.append("    executedBySubstitute: ").append(toIndentedString(executedBySubstitute)).append("\n");
        sb.append("    actorId: ").append(toIndentedString(actorId)).append("\n");
        sb.append("    assignedId: ").append(toIndentedString(assignedId)).append("\n");
        sb.append("    assignedDate: ").append(toIndentedString(assignedDate)).append("\n");
        sb.append("    isTerminal: ").append(toIndentedString(isTerminal)).append("\n");
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
