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
 * A flow node (gateway, event, or task) in an open instance of a process.
 */
@JsonPropertyOrder({
        FlowNode.JSON_PROPERTY_ID,
        FlowNode.JSON_PROPERTY_DISPLAY_DESCRIPTION,
        FlowNode.JSON_PROPERTY_EXECUTED_BY_SUBSTITUTE,
        FlowNode.JSON_PROPERTY_CASE_ID,
        FlowNode.JSON_PROPERTY_PARENT_CASE_ID,
        FlowNode.JSON_PROPERTY_ROOT_CASE_ID,
        FlowNode.JSON_PROPERTY_PROCESS_ID,
        FlowNode.JSON_PROPERTY_ROOT_CONTAINER_ID,
        FlowNode.JSON_PROPERTY_STATE,
        FlowNode.JSON_PROPERTY_TYPE,
        FlowNode.JSON_PROPERTY_ASSIGNED_ID,
        FlowNode.JSON_PROPERTY_ASSIGNED_DATE,
        FlowNode.JSON_PROPERTY_EXECUTED_BY,
        FlowNode.JSON_PROPERTY_PRIORITY,
        FlowNode.JSON_PROPERTY_ACTOR_ID,
        FlowNode.JSON_PROPERTY_DESCRIPTION,
        FlowNode.JSON_PROPERTY_NAME,
        FlowNode.JSON_PROPERTY_REACHED_STATE_DATE,
        FlowNode.JSON_PROPERTY_DISPLAY_NAME,
        FlowNode.JSON_PROPERTY_DUE_DATE,
        FlowNode.JSON_PROPERTY_LAST_UPDATE_DATE,
        FlowNode.JSON_PROPERTY_PARENT_TASK_ID_DOUBLE_QUOTE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class FlowNode implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    @jakarta.annotation.Nullable
    private String id;

    public static final String JSON_PROPERTY_DISPLAY_DESCRIPTION = "displayDescription";
    @jakarta.annotation.Nullable
    private String displayDescription;

    public static final String JSON_PROPERTY_EXECUTED_BY_SUBSTITUTE = "executedBySubstitute";
    @jakarta.annotation.Nullable
    private String executedBySubstitute;

    public static final String JSON_PROPERTY_CASE_ID = "caseId";
    @jakarta.annotation.Nullable
    private String caseId;

    public static final String JSON_PROPERTY_PARENT_CASE_ID = "parentCaseId";
    @jakarta.annotation.Nullable
    private String parentCaseId;

    public static final String JSON_PROPERTY_ROOT_CASE_ID = "rootCaseId";
    @jakarta.annotation.Nullable
    private String rootCaseId;

    public static final String JSON_PROPERTY_PROCESS_ID = "processId";
    @jakarta.annotation.Nullable
    private String processId;

    public static final String JSON_PROPERTY_ROOT_CONTAINER_ID = "rootContainerId";
    @jakarta.annotation.Nullable
    private String rootContainerId;

    public static final String JSON_PROPERTY_STATE = "state";
    @jakarta.annotation.Nullable
    private String state;

    public static final String JSON_PROPERTY_TYPE = "type";
    @jakarta.annotation.Nullable
    private String type;

    public static final String JSON_PROPERTY_ASSIGNED_ID = "assigned_id";
    @jakarta.annotation.Nullable
    private String assignedId;

    public static final String JSON_PROPERTY_ASSIGNED_DATE = "assigned_date";
    @jakarta.annotation.Nullable
    private String assignedDate;

    public static final String JSON_PROPERTY_EXECUTED_BY = "executedBy";
    @jakarta.annotation.Nullable
    private String executedBy;

    public static final String JSON_PROPERTY_PRIORITY = "priority";
    @jakarta.annotation.Nullable
    private String priority;

    public static final String JSON_PROPERTY_ACTOR_ID = "actorId";
    @jakarta.annotation.Nullable
    private String actorId;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    @jakarta.annotation.Nullable
    private String description;

    public static final String JSON_PROPERTY_NAME = "name";
    @jakarta.annotation.Nullable
    private String name;

    public static final String JSON_PROPERTY_REACHED_STATE_DATE = "reached_state_date";
    @jakarta.annotation.Nullable
    private String reachedStateDate;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    @jakarta.annotation.Nullable
    private String displayName;

    public static final String JSON_PROPERTY_DUE_DATE = "dueDate";
    @jakarta.annotation.Nullable
    private String dueDate;

    public static final String JSON_PROPERTY_LAST_UPDATE_DATE = "last_update_date";
    @jakarta.annotation.Nullable
    private String lastUpdateDate;

    public static final String JSON_PROPERTY_PARENT_TASK_ID_DOUBLE_QUOTE = "parentTaskId&quot;";
    @jakarta.annotation.Nullable
    private String parentTaskIdDoubleQuote;

    public FlowNode() {
    }

    public FlowNode id(@jakarta.annotation.Nullable String id) {

        this.id = id;
        return this;
    }

    /**
     * the flow node id
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

    public FlowNode displayDescription(@jakarta.annotation.Nullable String displayDescription) {

        this.displayDescription = displayDescription;
        return this;
    }

    /**
     * the human readable flow node description
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

    public FlowNode executedBySubstitute(@jakarta.annotation.Nullable String executedBySubstitute) {

        this.executedBySubstitute = executedBySubstitute;
        return this;
    }

    /**
     * the id of the user who really performed this flow node when a substitute did it, or 0 if the flow node was not performed by a substitute
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

    public FlowNode caseId(@jakarta.annotation.Nullable String caseId) {

        this.caseId = caseId;
        return this;
    }

    /**
     * the process instance id that is associated with this flow node
     * 
     * @return caseId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CASE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCaseId() {
        return caseId;
    }

    @JsonProperty(JSON_PROPERTY_CASE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCaseId(@jakarta.annotation.Nullable String caseId) {
        this.caseId = caseId;
    }

    public FlowNode parentCaseId(@jakarta.annotation.Nullable String parentCaseId) {

        this.parentCaseId = parentCaseId;
        return this;
    }

    /**
     * the parent process instance id that is associated with this flow node&#39;s case
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

    public FlowNode rootCaseId(@jakarta.annotation.Nullable String rootCaseId) {

        this.rootCaseId = rootCaseId;
        return this;
    }

    /**
     * the root process instance initiator id that is associated with this flow node&#39;s case
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

    public FlowNode processId(@jakarta.annotation.Nullable String processId) {

        this.processId = processId;
        return this;
    }

    /**
     * the process id that is associated with this flow node
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

    public FlowNode rootContainerId(@jakarta.annotation.Nullable String rootContainerId) {

        this.rootContainerId = rootContainerId;
        return this;
    }

    /**
     * the root process id of the root process instance that is associated with this flow node
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

    public FlowNode state(@jakarta.annotation.Nullable String state) {

        this.state = state;
        return this;
    }

    /**
     * the current state of the flow node (ready, completed, failed)
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

    public FlowNode type(@jakarta.annotation.Nullable String type) {

        this.type = type;
        return this;
    }

    /**
     * the flow node type
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

    public FlowNode assignedId(@jakarta.annotation.Nullable String assignedId) {

        this.assignedId = assignedId;
        return this;
    }

    /**
     * the user id that this flow node is assigned to, or 0 if it is unassigned
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

    public FlowNode assignedDate(@jakarta.annotation.Nullable String assignedDate) {

        this.assignedDate = assignedDate;
        return this;
    }

    /**
     * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when the current flow node was assigned, for example &#39;2014-10-17 16:05:42.626&#39;
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

    public FlowNode executedBy(@jakarta.annotation.Nullable String executedBy) {

        this.executedBy = executedBy;
        return this;
    }

    /**
     * the id of the user who executed the flow node, or 0 if the flow node has not been executed
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

    public FlowNode priority(@jakarta.annotation.Nullable String priority) {

        this.priority = priority;
        return this;
    }

    /**
     * the priority of the current flow node
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

    public FlowNode actorId(@jakarta.annotation.Nullable String actorId) {

        this.actorId = actorId;
        return this;
    }

    /**
     * the id of the actor that can execute this flow node, null otherwise
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

    public FlowNode description(@jakarta.annotation.Nullable String description) {

        this.description = description;
        return this;
    }

    /**
     * the flow node description
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

    public FlowNode name(@jakarta.annotation.Nullable String name) {

        this.name = name;
        return this;
    }

    /**
     * the flow node name
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

    public FlowNode reachedStateDate(@jakarta.annotation.Nullable String reachedStateDate) {

        this.reachedStateDate = reachedStateDate;
        return this;
    }

    /**
     * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this flow node reached the current state, for example &#39;2014-10-17 16:05:42.626&#39;
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

    public FlowNode displayName(@jakarta.annotation.Nullable String displayName) {

        this.displayName = displayName;
        return this;
    }

    /**
     * the display name of this flow node
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

    public FlowNode dueDate(@jakarta.annotation.Nullable String dueDate) {

        this.dueDate = dueDate;
        return this;
    }

    /**
     * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this flow node is due, for example &#39;2014-10-17 16:05:42.626&#39;
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

    public FlowNode lastUpdateDate(@jakarta.annotation.Nullable String lastUpdateDate) {

        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    /**
     * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this flow node was last updated, for example &#39;2014-10-17 16:05:42.626)
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

    public FlowNode parentTaskIdDoubleQuote(@jakarta.annotation.Nullable String parentTaskIdDoubleQuote) {

        this.parentTaskIdDoubleQuote = parentTaskIdDoubleQuote;
        return this;
    }

    /**
     * in case of a subtask, the parent task id
     * 
     * @return parentTaskIdDoubleQuote
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PARENT_TASK_ID_DOUBLE_QUOTE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getParentTaskIdDoubleQuote() {
        return parentTaskIdDoubleQuote;
    }

    @JsonProperty(JSON_PROPERTY_PARENT_TASK_ID_DOUBLE_QUOTE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setParentTaskIdDoubleQuote(@jakarta.annotation.Nullable String parentTaskIdDoubleQuote) {
        this.parentTaskIdDoubleQuote = parentTaskIdDoubleQuote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FlowNode flowNode = (FlowNode) o;
        return Objects.equals(this.id, flowNode.id) &&
                Objects.equals(this.displayDescription, flowNode.displayDescription) &&
                Objects.equals(this.executedBySubstitute, flowNode.executedBySubstitute) &&
                Objects.equals(this.caseId, flowNode.caseId) &&
                Objects.equals(this.parentCaseId, flowNode.parentCaseId) &&
                Objects.equals(this.rootCaseId, flowNode.rootCaseId) &&
                Objects.equals(this.processId, flowNode.processId) &&
                Objects.equals(this.rootContainerId, flowNode.rootContainerId) &&
                Objects.equals(this.state, flowNode.state) &&
                Objects.equals(this.type, flowNode.type) &&
                Objects.equals(this.assignedId, flowNode.assignedId) &&
                Objects.equals(this.assignedDate, flowNode.assignedDate) &&
                Objects.equals(this.executedBy, flowNode.executedBy) &&
                Objects.equals(this.priority, flowNode.priority) &&
                Objects.equals(this.actorId, flowNode.actorId) &&
                Objects.equals(this.description, flowNode.description) &&
                Objects.equals(this.name, flowNode.name) &&
                Objects.equals(this.reachedStateDate, flowNode.reachedStateDate) &&
                Objects.equals(this.displayName, flowNode.displayName) &&
                Objects.equals(this.dueDate, flowNode.dueDate) &&
                Objects.equals(this.lastUpdateDate, flowNode.lastUpdateDate) &&
                Objects.equals(this.parentTaskIdDoubleQuote, flowNode.parentTaskIdDoubleQuote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, displayDescription, executedBySubstitute, caseId, parentCaseId, rootCaseId, processId,
                rootContainerId, state, type, assignedId, assignedDate, executedBy, priority, actorId, description,
                name, reachedStateDate, displayName, dueDate, lastUpdateDate, parentTaskIdDoubleQuote);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FlowNode {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    displayDescription: ").append(toIndentedString(displayDescription)).append("\n");
        sb.append("    executedBySubstitute: ").append(toIndentedString(executedBySubstitute)).append("\n");
        sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
        sb.append("    parentCaseId: ").append(toIndentedString(parentCaseId)).append("\n");
        sb.append("    rootCaseId: ").append(toIndentedString(rootCaseId)).append("\n");
        sb.append("    processId: ").append(toIndentedString(processId)).append("\n");
        sb.append("    rootContainerId: ").append(toIndentedString(rootContainerId)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    assignedId: ").append(toIndentedString(assignedId)).append("\n");
        sb.append("    assignedDate: ").append(toIndentedString(assignedDate)).append("\n");
        sb.append("    executedBy: ").append(toIndentedString(executedBy)).append("\n");
        sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
        sb.append("    actorId: ").append(toIndentedString(actorId)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    reachedStateDate: ").append(toIndentedString(reachedStateDate)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
        sb.append("    lastUpdateDate: ").append(toIndentedString(lastUpdateDate)).append("\n");
        sb.append("    parentTaskIdDoubleQuote: ").append(toIndentedString(parentTaskIdDoubleQuote)).append("\n");
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
