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
 * AbstractArchivedTask
 */
@JsonPropertyOrder({
        AbstractArchivedTask.JSON_PROPERTY_ID,
        AbstractArchivedTask.JSON_PROPERTY_TYPE,
        AbstractArchivedTask.JSON_PROPERTY_NAME,
        AbstractArchivedTask.JSON_PROPERTY_DISPLAY_NAME,
        AbstractArchivedTask.JSON_PROPERTY_DESCRIPTION,
        AbstractArchivedTask.JSON_PROPERTY_DISPLAY_DESCRIPTION,
        AbstractArchivedTask.JSON_PROPERTY_STATE,
        AbstractArchivedTask.JSON_PROPERTY_REACHED_STATE_DATE,
        AbstractArchivedTask.JSON_PROPERTY_LAST_UPDATE_DATE,
        AbstractArchivedTask.JSON_PROPERTY_DUE_DATE,
        AbstractArchivedTask.JSON_PROPERTY_PRIORITY,
        AbstractArchivedTask.JSON_PROPERTY_PROCESS_ID,
        AbstractArchivedTask.JSON_PROPERTY_PARENT_CASE_ID,
        AbstractArchivedTask.JSON_PROPERTY_PARENT_TASK_ID,
        AbstractArchivedTask.JSON_PROPERTY_ROOT_CASE_ID,
        AbstractArchivedTask.JSON_PROPERTY_ROOT_CONTAINER_ID,
        AbstractArchivedTask.JSON_PROPERTY_EXECUTED_BY,
        AbstractArchivedTask.JSON_PROPERTY_EXECUTED_BY_SUBSTITUTE,
        AbstractArchivedTask.JSON_PROPERTY_ACTOR_ID,
        AbstractArchivedTask.JSON_PROPERTY_ASSIGNED_ID,
        AbstractArchivedTask.JSON_PROPERTY_ASSIGNED_DATE,
        AbstractArchivedTask.JSON_PROPERTY_IS_TERMINAL,
        AbstractArchivedTask.JSON_PROPERTY_SOURCE_OBJECT_ID,
        AbstractArchivedTask.JSON_PROPERTY_ARCHIVED_DATE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class AbstractArchivedTask implements Serializable {

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

    public static final String JSON_PROPERTY_SOURCE_OBJECT_ID = "sourceObjectId";
    @jakarta.annotation.Nullable
    private String sourceObjectId;

    public static final String JSON_PROPERTY_ARCHIVED_DATE = "archivedDate";
    @jakarta.annotation.Nullable
    private String archivedDate;

    public AbstractArchivedTask() {
    }

    public AbstractArchivedTask id(@jakarta.annotation.Nullable String id) {

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

    public AbstractArchivedTask type(@jakarta.annotation.Nullable String type) {

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

    public AbstractArchivedTask name(@jakarta.annotation.Nullable String name) {

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

    public AbstractArchivedTask displayName(@jakarta.annotation.Nullable String displayName) {

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

    public AbstractArchivedTask description(@jakarta.annotation.Nullable String description) {

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

    public AbstractArchivedTask displayDescription(@jakarta.annotation.Nullable String displayDescription) {

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

    public AbstractArchivedTask state(@jakarta.annotation.Nullable ActivityState state) {

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

    public AbstractArchivedTask reachedStateDate(@jakarta.annotation.Nullable String reachedStateDate) {

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

    public AbstractArchivedTask lastUpdateDate(@jakarta.annotation.Nullable String lastUpdateDate) {

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

    public AbstractArchivedTask dueDate(@jakarta.annotation.Nullable String dueDate) {

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

    public AbstractArchivedTask priority(@jakarta.annotation.Nullable String priority) {

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

    public AbstractArchivedTask processId(@jakarta.annotation.Nullable String processId) {

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

    public AbstractArchivedTask parentCaseId(@jakarta.annotation.Nullable String parentCaseId) {

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

    public AbstractArchivedTask parentTaskId(@jakarta.annotation.Nullable String parentTaskId) {

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

    public AbstractArchivedTask rootCaseId(@jakarta.annotation.Nullable String rootCaseId) {

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

    public AbstractArchivedTask rootContainerId(@jakarta.annotation.Nullable String rootContainerId) {

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

    public AbstractArchivedTask executedBy(@jakarta.annotation.Nullable String executedBy) {

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

    public AbstractArchivedTask executedBySubstitute(@jakarta.annotation.Nullable String executedBySubstitute) {

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

    public AbstractArchivedTask actorId(@jakarta.annotation.Nullable String actorId) {

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

    public AbstractArchivedTask assignedId(@jakarta.annotation.Nullable String assignedId) {

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

    public AbstractArchivedTask assignedDate(@jakarta.annotation.Nullable String assignedDate) {

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

    public AbstractArchivedTask isTerminal(@jakarta.annotation.Nullable Boolean isTerminal) {

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

    public AbstractArchivedTask sourceObjectId(@jakarta.annotation.Nullable String sourceObjectId) {

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
    public void setSourceObjectId(@jakarta.annotation.Nullable String sourceObjectId) {
        this.sourceObjectId = sourceObjectId;
    }

    public AbstractArchivedTask archivedDate(@jakarta.annotation.Nullable String archivedDate) {

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
    public void setArchivedDate(@jakarta.annotation.Nullable String archivedDate) {
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
        AbstractArchivedTask abstractArchivedTask = (AbstractArchivedTask) o;
        return Objects.equals(this.id, abstractArchivedTask.id) &&
                Objects.equals(this.type, abstractArchivedTask.type) &&
                Objects.equals(this.name, abstractArchivedTask.name) &&
                Objects.equals(this.displayName, abstractArchivedTask.displayName) &&
                Objects.equals(this.description, abstractArchivedTask.description) &&
                Objects.equals(this.displayDescription, abstractArchivedTask.displayDescription) &&
                Objects.equals(this.state, abstractArchivedTask.state) &&
                Objects.equals(this.reachedStateDate, abstractArchivedTask.reachedStateDate) &&
                Objects.equals(this.lastUpdateDate, abstractArchivedTask.lastUpdateDate) &&
                Objects.equals(this.dueDate, abstractArchivedTask.dueDate) &&
                Objects.equals(this.priority, abstractArchivedTask.priority) &&
                Objects.equals(this.processId, abstractArchivedTask.processId) &&
                Objects.equals(this.parentCaseId, abstractArchivedTask.parentCaseId) &&
                Objects.equals(this.parentTaskId, abstractArchivedTask.parentTaskId) &&
                Objects.equals(this.rootCaseId, abstractArchivedTask.rootCaseId) &&
                Objects.equals(this.rootContainerId, abstractArchivedTask.rootContainerId) &&
                Objects.equals(this.executedBy, abstractArchivedTask.executedBy) &&
                Objects.equals(this.executedBySubstitute, abstractArchivedTask.executedBySubstitute) &&
                Objects.equals(this.actorId, abstractArchivedTask.actorId) &&
                Objects.equals(this.assignedId, abstractArchivedTask.assignedId) &&
                Objects.equals(this.assignedDate, abstractArchivedTask.assignedDate) &&
                Objects.equals(this.isTerminal, abstractArchivedTask.isTerminal) &&
                Objects.equals(this.sourceObjectId, abstractArchivedTask.sourceObjectId) &&
                Objects.equals(this.archivedDate, abstractArchivedTask.archivedDate);
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
        sb.append("class AbstractArchivedTask {\n");
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
