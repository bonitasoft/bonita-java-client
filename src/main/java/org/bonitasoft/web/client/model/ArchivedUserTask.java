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
 * ArchivedUserTask
 */
@JsonPropertyOrder({
        ArchivedUserTask.JSON_PROPERTY_ID,
        ArchivedUserTask.JSON_PROPERTY_TYPE,
        ArchivedUserTask.JSON_PROPERTY_NAME,
        ArchivedUserTask.JSON_PROPERTY_DISPLAY_NAME,
        ArchivedUserTask.JSON_PROPERTY_DESCRIPTION,
        ArchivedUserTask.JSON_PROPERTY_DISPLAY_DESCRIPTION,
        ArchivedUserTask.JSON_PROPERTY_STATE,
        ArchivedUserTask.JSON_PROPERTY_REACHED_STATE_DATE,
        ArchivedUserTask.JSON_PROPERTY_LAST_UPDATE_DATE,
        ArchivedUserTask.JSON_PROPERTY_DUE_DATE,
        ArchivedUserTask.JSON_PROPERTY_PRIORITY,
        ArchivedUserTask.JSON_PROPERTY_PROCESS_ID,
        ArchivedUserTask.JSON_PROPERTY_PARENT_CASE_ID,
        ArchivedUserTask.JSON_PROPERTY_PARENT_TASK_ID,
        ArchivedUserTask.JSON_PROPERTY_ROOT_CASE_ID,
        ArchivedUserTask.JSON_PROPERTY_ROOT_CONTAINER_ID,
        ArchivedUserTask.JSON_PROPERTY_EXECUTED_BY,
        ArchivedUserTask.JSON_PROPERTY_EXECUTED_BY_SUBSTITUTE,
        ArchivedUserTask.JSON_PROPERTY_ACTOR_ID,
        ArchivedUserTask.JSON_PROPERTY_ASSIGNED_ID,
        ArchivedUserTask.JSON_PROPERTY_ASSIGNED_DATE,
        ArchivedUserTask.JSON_PROPERTY_IS_TERMINAL,
        ArchivedUserTask.JSON_PROPERTY_SOURCE_OBJECT_ID,
        ArchivedUserTask.JSON_PROPERTY_ARCHIVED_DATE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.8.0")
public class ArchivedUserTask implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_TYPE = "type";
    private String type;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    private String displayName;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_DISPLAY_DESCRIPTION = "displayDescription";
    private String displayDescription;

    public static final String JSON_PROPERTY_STATE = "state";
    private ActivityState state;

    public static final String JSON_PROPERTY_REACHED_STATE_DATE = "reached_state_date";
    private String reachedStateDate;

    public static final String JSON_PROPERTY_LAST_UPDATE_DATE = "last_update_date";
    private String lastUpdateDate;

    public static final String JSON_PROPERTY_DUE_DATE = "dueDate";
    private String dueDate;

    public static final String JSON_PROPERTY_PRIORITY = "priority";
    private String priority;

    public static final String JSON_PROPERTY_PROCESS_ID = "processId";
    private String processId;

    public static final String JSON_PROPERTY_PARENT_CASE_ID = "parentCaseId";
    private String parentCaseId;

    public static final String JSON_PROPERTY_PARENT_TASK_ID = "parentTaskId";
    private String parentTaskId;

    public static final String JSON_PROPERTY_ROOT_CASE_ID = "rootCaseId";
    private String rootCaseId;

    public static final String JSON_PROPERTY_ROOT_CONTAINER_ID = "rootContainerId";
    private String rootContainerId;

    public static final String JSON_PROPERTY_EXECUTED_BY = "executedBy";
    private String executedBy;

    public static final String JSON_PROPERTY_EXECUTED_BY_SUBSTITUTE = "executedBySubstitute";
    private String executedBySubstitute;

    public static final String JSON_PROPERTY_ACTOR_ID = "actorId";
    private String actorId;

    public static final String JSON_PROPERTY_ASSIGNED_ID = "assigned_id";
    private String assignedId;

    public static final String JSON_PROPERTY_ASSIGNED_DATE = "assigned_date";
    private String assignedDate;

    public static final String JSON_PROPERTY_IS_TERMINAL = "isTerminal";
    private Boolean isTerminal;

    public static final String JSON_PROPERTY_SOURCE_OBJECT_ID = "sourceObjectId";
    private String sourceObjectId;

    public static final String JSON_PROPERTY_ARCHIVED_DATE = "archivedDate";
    private String archivedDate;

    public ArchivedUserTask() {
    }

    public ArchivedUserTask id(String id) {

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
    public void setId(String id) {
        this.id = id;
    }

    public ArchivedUserTask type(String type) {

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
    public void setType(String type) {
        this.type = type;
    }

    public ArchivedUserTask name(String name) {

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
    public void setName(String name) {
        this.name = name;
    }

    public ArchivedUserTask displayName(String displayName) {

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
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public ArchivedUserTask description(String description) {

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
    public void setDescription(String description) {
        this.description = description;
    }

    public ArchivedUserTask displayDescription(String displayDescription) {

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
    public void setDisplayDescription(String displayDescription) {
        this.displayDescription = displayDescription;
    }

    public ArchivedUserTask state(ActivityState state) {

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
    public void setState(ActivityState state) {
        this.state = state;
    }

    public ArchivedUserTask reachedStateDate(String reachedStateDate) {

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
    public void setReachedStateDate(String reachedStateDate) {
        this.reachedStateDate = reachedStateDate;
    }

    public ArchivedUserTask lastUpdateDate(String lastUpdateDate) {

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
    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public ArchivedUserTask dueDate(String dueDate) {

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
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public ArchivedUserTask priority(String priority) {

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
    public void setPriority(String priority) {
        this.priority = priority;
    }

    public ArchivedUserTask processId(String processId) {

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
    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public ArchivedUserTask parentCaseId(String parentCaseId) {

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
    public void setParentCaseId(String parentCaseId) {
        this.parentCaseId = parentCaseId;
    }

    public ArchivedUserTask parentTaskId(String parentTaskId) {

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
    public void setParentTaskId(String parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public ArchivedUserTask rootCaseId(String rootCaseId) {

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
    public void setRootCaseId(String rootCaseId) {
        this.rootCaseId = rootCaseId;
    }

    public ArchivedUserTask rootContainerId(String rootContainerId) {

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
    public void setRootContainerId(String rootContainerId) {
        this.rootContainerId = rootContainerId;
    }

    public ArchivedUserTask executedBy(String executedBy) {

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
    public void setExecutedBy(String executedBy) {
        this.executedBy = executedBy;
    }

    public ArchivedUserTask executedBySubstitute(String executedBySubstitute) {

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
    public void setExecutedBySubstitute(String executedBySubstitute) {
        this.executedBySubstitute = executedBySubstitute;
    }

    public ArchivedUserTask actorId(String actorId) {

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
    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public ArchivedUserTask assignedId(String assignedId) {

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
    public void setAssignedId(String assignedId) {
        this.assignedId = assignedId;
    }

    public ArchivedUserTask assignedDate(String assignedDate) {

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
    public void setAssignedDate(String assignedDate) {
        this.assignedDate = assignedDate;
    }

    public ArchivedUserTask isTerminal(Boolean isTerminal) {

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
    public void setIsTerminal(Boolean isTerminal) {
        this.isTerminal = isTerminal;
    }

    public ArchivedUserTask sourceObjectId(String sourceObjectId) {

        this.sourceObjectId = sourceObjectId;
        return this;
    }

    /**
     * the original id of the task before it was archived
     * 
     * @return sourceObjectId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SOURCE_OBJECT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSourceObjectId() {
        return sourceObjectId;
    }

    @JsonProperty(JSON_PROPERTY_SOURCE_OBJECT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSourceObjectId(String sourceObjectId) {
        this.sourceObjectId = sourceObjectId;
    }

    public ArchivedUserTask archivedDate(String archivedDate) {

        this.archivedDate = archivedDate;
        return this;
    }

    /**
     * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when the current task was assigned for example &#39;2014-10-17 16:05:42.626&#39;
     * 
     * @return archivedDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ARCHIVED_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getArchivedDate() {
        return archivedDate;
    }

    @JsonProperty(JSON_PROPERTY_ARCHIVED_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setArchivedDate(String archivedDate) {
        this.archivedDate = archivedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArchivedUserTask archivedUserTask = (ArchivedUserTask) o;
        return Objects.equals(this.id, archivedUserTask.id) &&
                Objects.equals(this.type, archivedUserTask.type) &&
                Objects.equals(this.name, archivedUserTask.name) &&
                Objects.equals(this.displayName, archivedUserTask.displayName) &&
                Objects.equals(this.description, archivedUserTask.description) &&
                Objects.equals(this.displayDescription, archivedUserTask.displayDescription) &&
                Objects.equals(this.state, archivedUserTask.state) &&
                Objects.equals(this.reachedStateDate, archivedUserTask.reachedStateDate) &&
                Objects.equals(this.lastUpdateDate, archivedUserTask.lastUpdateDate) &&
                Objects.equals(this.dueDate, archivedUserTask.dueDate) &&
                Objects.equals(this.priority, archivedUserTask.priority) &&
                Objects.equals(this.processId, archivedUserTask.processId) &&
                Objects.equals(this.parentCaseId, archivedUserTask.parentCaseId) &&
                Objects.equals(this.parentTaskId, archivedUserTask.parentTaskId) &&
                Objects.equals(this.rootCaseId, archivedUserTask.rootCaseId) &&
                Objects.equals(this.rootContainerId, archivedUserTask.rootContainerId) &&
                Objects.equals(this.executedBy, archivedUserTask.executedBy) &&
                Objects.equals(this.executedBySubstitute, archivedUserTask.executedBySubstitute) &&
                Objects.equals(this.actorId, archivedUserTask.actorId) &&
                Objects.equals(this.assignedId, archivedUserTask.assignedId) &&
                Objects.equals(this.assignedDate, archivedUserTask.assignedDate) &&
                Objects.equals(this.isTerminal, archivedUserTask.isTerminal) &&
                Objects.equals(this.sourceObjectId, archivedUserTask.sourceObjectId) &&
                Objects.equals(this.archivedDate, archivedUserTask.archivedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, displayName, description, displayDescription, state, reachedStateDate,
                lastUpdateDate, dueDate, priority, processId, parentCaseId, parentTaskId, rootCaseId, rootContainerId,
                executedBy, executedBySubstitute, actorId, assignedId, assignedDate, isTerminal, sourceObjectId,
                archivedDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ArchivedUserTask {\n");
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
        sb.append("    sourceObjectId: ").append(toIndentedString(sourceObjectId)).append("\n");
        sb.append("    archivedDate: ").append(toIndentedString(archivedDate)).append("\n");
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
