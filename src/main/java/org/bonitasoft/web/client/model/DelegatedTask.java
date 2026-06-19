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
import java.util.Arrays;
import java.util.Objects;

import org.openapitools.jackson.nullable.JsonNullable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * A human task that a user is allowed to act on through an active delegation rule, returned by &#x60;GET /API/delegation/task&#x60;. The task is still assigned
 * to the delegator; delegation grants the delegate visibility and execution rights but does not reassign ownership. The shape aligns with the legacy human-task
 * REST format (modernised to camelCase): &#x60;processDefinitionId&#x60; is exposed as &#x60;processId&#x60;, &#x60;parentProcessInstanceId&#x60; as
 * &#x60;parentCaseId&#x60;, &#x60;rootContainerId&#x60; as &#x60;rootCaseId&#x60;, &#x60;expectedEndDate&#x60; as &#x60;dueDate&#x60; and
 * &#x60;claimedDate&#x60; as &#x60;assignedDate&#x60;. The delegator, delegate and delegation window are added on top so the front-end can render the
 * delegation context without a second round-trip. All long id fields are serialized as strings to avoid JavaScript precision loss. Date fields
 * (&#x60;dueDate&#x60;, &#x60;assignedDate&#x60;, &#x60;reachedStateDate&#x60;, &#x60;lastUpdateDate&#x60;, &#x60;delegationStart&#x60;,
 * &#x60;delegationEnd&#x60;) are numeric, in milliseconds since epoch; some (such as &#x60;dueDate&#x60; and &#x60;assignedDate&#x60;) may be &#x60;null&#x60;.
 */
@JsonPropertyOrder({
        DelegatedTask.JSON_PROPERTY_ID,
        DelegatedTask.JSON_PROPERTY_NAME,
        DelegatedTask.JSON_PROPERTY_DISPLAY_NAME,
        DelegatedTask.JSON_PROPERTY_DESCRIPTION,
        DelegatedTask.JSON_PROPERTY_DISPLAY_DESCRIPTION,
        DelegatedTask.JSON_PROPERTY_STATE,
        DelegatedTask.JSON_PROPERTY_TYPE,
        DelegatedTask.JSON_PROPERTY_PRIORITY,
        DelegatedTask.JSON_PROPERTY_DUE_DATE,
        DelegatedTask.JSON_PROPERTY_ASSIGNED_DATE,
        DelegatedTask.JSON_PROPERTY_REACHED_STATE_DATE,
        DelegatedTask.JSON_PROPERTY_LAST_UPDATE_DATE,
        DelegatedTask.JSON_PROPERTY_PROCESS_ID,
        DelegatedTask.JSON_PROPERTY_PARENT_CASE_ID,
        DelegatedTask.JSON_PROPERTY_ROOT_CASE_ID,
        DelegatedTask.JSON_PROPERTY_ACTOR_ID,
        DelegatedTask.JSON_PROPERTY_ASSIGNEE_ID,
        DelegatedTask.JSON_PROPERTY_EXECUTED_BY,
        DelegatedTask.JSON_PROPERTY_EXECUTED_BY_SUBSTITUTE,
        DelegatedTask.JSON_PROPERTY_FLOWNODE_DEFINITION_ID,
        DelegatedTask.JSON_PROPERTY_DELEGATOR,
        DelegatedTask.JSON_PROPERTY_DELEGATE,
        DelegatedTask.JSON_PROPERTY_DELEGATION_START,
        DelegatedTask.JSON_PROPERTY_DELEGATION_END,
        DelegatedTask.JSON_PROPERTY_ROOT_PROCESS_INFO
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class DelegatedTask implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    @jakarta.annotation.Nonnull
    private String id;

    public static final String JSON_PROPERTY_NAME = "name";
    @jakarta.annotation.Nonnull
    private String name;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    @jakarta.annotation.Nullable
    private String displayName;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private JsonNullable<String> description = JsonNullable.<String> undefined();

    public static final String JSON_PROPERTY_DISPLAY_DESCRIPTION = "displayDescription";
    private JsonNullable<String> displayDescription = JsonNullable.<String> undefined();

    public static final String JSON_PROPERTY_STATE = "state";
    @jakarta.annotation.Nonnull
    private String state;

    public static final String JSON_PROPERTY_TYPE = "type";
    @jakarta.annotation.Nonnull
    private String type;

    public static final String JSON_PROPERTY_PRIORITY = "priority";
    @jakarta.annotation.Nullable
    private String priority;

    public static final String JSON_PROPERTY_DUE_DATE = "dueDate";
    private JsonNullable<Long> dueDate = JsonNullable.<Long> undefined();

    public static final String JSON_PROPERTY_ASSIGNED_DATE = "assignedDate";
    private JsonNullable<Long> assignedDate = JsonNullable.<Long> undefined();

    public static final String JSON_PROPERTY_REACHED_STATE_DATE = "reachedStateDate";
    @jakarta.annotation.Nullable
    private Long reachedStateDate;

    public static final String JSON_PROPERTY_LAST_UPDATE_DATE = "lastUpdateDate";
    @jakarta.annotation.Nullable
    private Long lastUpdateDate;

    public static final String JSON_PROPERTY_PROCESS_ID = "processId";
    @jakarta.annotation.Nonnull
    private String processId;

    public static final String JSON_PROPERTY_PARENT_CASE_ID = "parentCaseId";
    @jakarta.annotation.Nonnull
    private String parentCaseId;

    public static final String JSON_PROPERTY_ROOT_CASE_ID = "rootCaseId";
    @jakarta.annotation.Nonnull
    private String rootCaseId;

    public static final String JSON_PROPERTY_ACTOR_ID = "actorId";
    @jakarta.annotation.Nonnull
    private String actorId;

    public static final String JSON_PROPERTY_ASSIGNEE_ID = "assigneeId";
    @jakarta.annotation.Nonnull
    private String assigneeId;

    public static final String JSON_PROPERTY_EXECUTED_BY = "executedBy";
    @jakarta.annotation.Nonnull
    private String executedBy;

    public static final String JSON_PROPERTY_EXECUTED_BY_SUBSTITUTE = "executedBySubstitute";
    @jakarta.annotation.Nonnull
    private String executedBySubstitute;

    public static final String JSON_PROPERTY_FLOWNODE_DEFINITION_ID = "flownodeDefinitionId";
    @jakarta.annotation.Nonnull
    private String flownodeDefinitionId;

    public static final String JSON_PROPERTY_DELEGATOR = "delegator";
    @jakarta.annotation.Nonnull
    private DelegationUser delegator;

    public static final String JSON_PROPERTY_DELEGATE = "delegate";
    @jakarta.annotation.Nonnull
    private DelegationUser delegate;

    public static final String JSON_PROPERTY_DELEGATION_START = "delegationStart";
    @jakarta.annotation.Nonnull
    private Long delegationStart;

    public static final String JSON_PROPERTY_DELEGATION_END = "delegationEnd";
    @jakarta.annotation.Nonnull
    private Long delegationEnd;

    public static final String JSON_PROPERTY_ROOT_PROCESS_INFO = "rootProcessInfo";
    @jakarta.annotation.Nonnull
    private ProcessDeploymentInfo rootProcessInfo;

    public DelegatedTask() {
    }

    public DelegatedTask id(@jakarta.annotation.Nonnull String id) {

        this.id = id;
        return this;
    }

    /**
     * Identifier of the task instance. Serialized as a string to avoid JavaScript precision loss.
     * 
     * @return id
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setId(@jakarta.annotation.Nonnull String id) {
        this.id = id;
    }

    public DelegatedTask name(@jakarta.annotation.Nonnull String name) {

        this.name = name;
        return this;
    }

    /**
     * Technical name of the task.
     * 
     * @return name
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setName(@jakarta.annotation.Nonnull String name) {
        this.name = name;
    }

    public DelegatedTask displayName(@jakarta.annotation.Nullable String displayName) {

        this.displayName = displayName;
        return this;
    }

    /**
     * Human-readable name of the task.
     * 
     * @return displayName
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDisplayName(@jakarta.annotation.Nullable String displayName) {
        this.displayName = displayName;
    }

    public DelegatedTask description(@jakarta.annotation.Nullable String description) {
        this.description = JsonNullable.<String> of(description);

        return this;
    }

    /**
     * Description of the task.
     * 
     * @return description
     */
    @jakarta.annotation.Nullable
    @JsonIgnore

    public String getDescription() {
        return description.orElse(null);
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public JsonNullable<String> getDescription_JsonNullable() {
        return description;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    public void setDescription_JsonNullable(JsonNullable<String> description) {
        this.description = description;
    }

    public void setDescription(@jakarta.annotation.Nullable String description) {
        this.description = JsonNullable.<String> of(description);
    }

    public DelegatedTask displayDescription(@jakarta.annotation.Nullable String displayDescription) {
        this.displayDescription = JsonNullable.<String> of(displayDescription);

        return this;
    }

    /**
     * Human-readable description of the task.
     * 
     * @return displayDescription
     */
    @jakarta.annotation.Nullable
    @JsonIgnore

    public String getDisplayDescription() {
        return displayDescription.orElse(null);
    }

    @JsonProperty(JSON_PROPERTY_DISPLAY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public JsonNullable<String> getDisplayDescription_JsonNullable() {
        return displayDescription;
    }

    @JsonProperty(JSON_PROPERTY_DISPLAY_DESCRIPTION)
    public void setDisplayDescription_JsonNullable(JsonNullable<String> displayDescription) {
        this.displayDescription = displayDescription;
    }

    public void setDisplayDescription(@jakarta.annotation.Nullable String displayDescription) {
        this.displayDescription = JsonNullable.<String> of(displayDescription);
    }

    public DelegatedTask state(@jakarta.annotation.Nonnull String state) {

        this.state = state;
        return this;
    }

    /**
     * Current state of the task (e.g. &#x60;ready&#x60;).
     * 
     * @return state
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getState() {
        return state;
    }

    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setState(@jakarta.annotation.Nonnull String state) {
        this.state = state;
    }

    public DelegatedTask type(@jakarta.annotation.Nonnull String type) {

        this.type = type;
        return this;
    }

    /**
     * Flow node type (e.g. &#x60;USER_TASK&#x60;).
     * 
     * @return type
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setType(@jakarta.annotation.Nonnull String type) {
        this.type = type;
    }

    public DelegatedTask priority(@jakarta.annotation.Nullable String priority) {

        this.priority = priority;
        return this;
    }

    /**
     * Priority of the task (e.g. &#x60;NORMAL&#x60;).
     * 
     * @return priority
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PRIORITY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getPriority() {
        return priority;
    }

    @JsonProperty(JSON_PROPERTY_PRIORITY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setPriority(@jakarta.annotation.Nullable String priority) {
        this.priority = priority;
    }

    public DelegatedTask dueDate(@jakarta.annotation.Nullable Long dueDate) {
        this.dueDate = JsonNullable.<Long> of(dueDate);

        return this;
    }

    /**
     * Expected end date of the task, in epoch milliseconds, or &#x60;null&#x60; when none is set. (Maps to the engine &#x60;expectedEndDate&#x60;.)
     * 
     * @return dueDate
     */
    @jakarta.annotation.Nullable
    @JsonIgnore

    public Long getDueDate() {
        return dueDate.orElse(null);
    }

    @JsonProperty(JSON_PROPERTY_DUE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public JsonNullable<Long> getDueDate_JsonNullable() {
        return dueDate;
    }

    @JsonProperty(JSON_PROPERTY_DUE_DATE)
    public void setDueDate_JsonNullable(JsonNullable<Long> dueDate) {
        this.dueDate = dueDate;
    }

    public void setDueDate(@jakarta.annotation.Nullable Long dueDate) {
        this.dueDate = JsonNullable.<Long> of(dueDate);
    }

    public DelegatedTask assignedDate(@jakarta.annotation.Nullable Long assignedDate) {
        this.assignedDate = JsonNullable.<Long> of(assignedDate);

        return this;
    }

    /**
     * Date the task was claimed by its assignee, in epoch milliseconds, or &#x60;null&#x60; when unassigned. (Maps to the engine &#x60;claimedDate&#x60;.)
     * 
     * @return assignedDate
     */
    @jakarta.annotation.Nullable
    @JsonIgnore

    public Long getAssignedDate() {
        return assignedDate.orElse(null);
    }

    @JsonProperty(JSON_PROPERTY_ASSIGNED_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public JsonNullable<Long> getAssignedDate_JsonNullable() {
        return assignedDate;
    }

    @JsonProperty(JSON_PROPERTY_ASSIGNED_DATE)
    public void setAssignedDate_JsonNullable(JsonNullable<Long> assignedDate) {
        this.assignedDate = assignedDate;
    }

    public void setAssignedDate(@jakarta.annotation.Nullable Long assignedDate) {
        this.assignedDate = JsonNullable.<Long> of(assignedDate);
    }

    public DelegatedTask reachedStateDate(@jakarta.annotation.Nullable Long reachedStateDate) {

        this.reachedStateDate = reachedStateDate;
        return this;
    }

    /**
     * Date the task reached its current state, in epoch milliseconds.
     * 
     * @return reachedStateDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REACHED_STATE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getReachedStateDate() {
        return reachedStateDate;
    }

    @JsonProperty(JSON_PROPERTY_REACHED_STATE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReachedStateDate(@jakarta.annotation.Nullable Long reachedStateDate) {
        this.reachedStateDate = reachedStateDate;
    }

    public DelegatedTask lastUpdateDate(@jakarta.annotation.Nullable Long lastUpdateDate) {

        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    /**
     * Date the task was last updated, in epoch milliseconds.
     * 
     * @return lastUpdateDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LAST_UPDATE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getLastUpdateDate() {
        return lastUpdateDate;
    }

    @JsonProperty(JSON_PROPERTY_LAST_UPDATE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLastUpdateDate(@jakarta.annotation.Nullable Long lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public DelegatedTask processId(@jakarta.annotation.Nonnull String processId) {

        this.processId = processId;
        return this;
    }

    /**
     * Identifier of the process definition. Serialized as a string. (Maps to the engine &#x60;processDefinitionId&#x60;.)
     * 
     * @return processId
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_PROCESS_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getProcessId() {
        return processId;
    }

    @JsonProperty(JSON_PROPERTY_PROCESS_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setProcessId(@jakarta.annotation.Nonnull String processId) {
        this.processId = processId;
    }

    public DelegatedTask parentCaseId(@jakarta.annotation.Nonnull String parentCaseId) {

        this.parentCaseId = parentCaseId;
        return this;
    }

    /**
     * Identifier of the immediate containing process instance. Serialized as a string. (Maps to the engine &#x60;parentProcessInstanceId&#x60;.)
     * 
     * @return parentCaseId
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_PARENT_CASE_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getParentCaseId() {
        return parentCaseId;
    }

    @JsonProperty(JSON_PROPERTY_PARENT_CASE_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setParentCaseId(@jakarta.annotation.Nonnull String parentCaseId) {
        this.parentCaseId = parentCaseId;
    }

    public DelegatedTask rootCaseId(@jakarta.annotation.Nonnull String rootCaseId) {

        this.rootCaseId = rootCaseId;
        return this;
    }

    /**
     * Identifier of the root process instance. Serialized as a string. (Maps to the engine &#x60;rootContainerId&#x60;.)
     * 
     * @return rootCaseId
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ROOT_CASE_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getRootCaseId() {
        return rootCaseId;
    }

    @JsonProperty(JSON_PROPERTY_ROOT_CASE_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setRootCaseId(@jakarta.annotation.Nonnull String rootCaseId) {
        this.rootCaseId = rootCaseId;
    }

    public DelegatedTask actorId(@jakarta.annotation.Nonnull String actorId) {

        this.actorId = actorId;
        return this;
    }

    /**
     * Id of the actor that can execute this task. Serialized as a string.
     * 
     * @return actorId
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ACTOR_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getActorId() {
        return actorId;
    }

    @JsonProperty(JSON_PROPERTY_ACTOR_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setActorId(@jakarta.annotation.Nonnull String actorId) {
        this.actorId = actorId;
    }

    public DelegatedTask assigneeId(@jakarta.annotation.Nonnull String assigneeId) {

        this.assigneeId = assigneeId;
        return this;
    }

    /**
     * Id of the user this task is assigned to, or &#x60;0&#x60; if unassigned. Serialized as a string.
     * 
     * @return assigneeId
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ASSIGNEE_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getAssigneeId() {
        return assigneeId;
    }

    @JsonProperty(JSON_PROPERTY_ASSIGNEE_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setAssigneeId(@jakarta.annotation.Nonnull String assigneeId) {
        this.assigneeId = assigneeId;
    }

    public DelegatedTask executedBy(@jakarta.annotation.Nonnull String executedBy) {

        this.executedBy = executedBy;
        return this;
    }

    /**
     * Id of the user who performed the task, or &#x60;0&#x60; if not yet executed. Serialized as a string.
     * 
     * @return executedBy
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_EXECUTED_BY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getExecutedBy() {
        return executedBy;
    }

    @JsonProperty(JSON_PROPERTY_EXECUTED_BY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setExecutedBy(@jakarta.annotation.Nonnull String executedBy) {
        this.executedBy = executedBy;
    }

    public DelegatedTask executedBySubstitute(@jakarta.annotation.Nonnull String executedBySubstitute) {

        this.executedBySubstitute = executedBySubstitute;
        return this;
    }

    /**
     * Id of the user who performed the task on behalf of someone else, or &#x60;0&#x60; otherwise. Serialized as a string.
     * 
     * @return executedBySubstitute
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_EXECUTED_BY_SUBSTITUTE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getExecutedBySubstitute() {
        return executedBySubstitute;
    }

    @JsonProperty(JSON_PROPERTY_EXECUTED_BY_SUBSTITUTE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setExecutedBySubstitute(@jakarta.annotation.Nonnull String executedBySubstitute) {
        this.executedBySubstitute = executedBySubstitute;
    }

    public DelegatedTask flownodeDefinitionId(@jakarta.annotation.Nonnull String flownodeDefinitionId) {

        this.flownodeDefinitionId = flownodeDefinitionId;
        return this;
    }

    /**
     * Identifier of the flow node definition. Serialized as a string.
     * 
     * @return flownodeDefinitionId
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_FLOWNODE_DEFINITION_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getFlownodeDefinitionId() {
        return flownodeDefinitionId;
    }

    @JsonProperty(JSON_PROPERTY_FLOWNODE_DEFINITION_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setFlownodeDefinitionId(@jakarta.annotation.Nonnull String flownodeDefinitionId) {
        this.flownodeDefinitionId = flownodeDefinitionId;
    }

    public DelegatedTask delegator(@jakarta.annotation.Nonnull DelegationUser delegator) {

        this.delegator = delegator;
        return this;
    }

    /**
     * Get delegator
     * 
     * @return delegator
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DELEGATOR)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public DelegationUser getDelegator() {
        return delegator;
    }

    @JsonProperty(JSON_PROPERTY_DELEGATOR)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDelegator(@jakarta.annotation.Nonnull DelegationUser delegator) {
        this.delegator = delegator;
    }

    public DelegatedTask delegate(@jakarta.annotation.Nonnull DelegationUser delegate) {

        this.delegate = delegate;
        return this;
    }

    /**
     * Get delegate
     * 
     * @return delegate
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DELEGATE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public DelegationUser getDelegate() {
        return delegate;
    }

    @JsonProperty(JSON_PROPERTY_DELEGATE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDelegate(@jakarta.annotation.Nonnull DelegationUser delegate) {
        this.delegate = delegate;
    }

    public DelegatedTask delegationStart(@jakarta.annotation.Nonnull Long delegationStart) {

        this.delegationStart = delegationStart;
        return this;
    }

    /**
     * Start of the delegation period, inclusive, in milliseconds since epoch. Same value as the delegation rule&#39;s &#x60;startDate&#x60;.
     * 
     * @return delegationStart
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DELEGATION_START)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Long getDelegationStart() {
        return delegationStart;
    }

    @JsonProperty(JSON_PROPERTY_DELEGATION_START)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDelegationStart(@jakarta.annotation.Nonnull Long delegationStart) {
        this.delegationStart = delegationStart;
    }

    public DelegatedTask delegationEnd(@jakarta.annotation.Nonnull Long delegationEnd) {

        this.delegationEnd = delegationEnd;
        return this;
    }

    /**
     * End of the delegation period, inclusive, in milliseconds since epoch. Same value as the delegation rule&#39;s &#x60;endDate&#x60;.
     * 
     * @return delegationEnd
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DELEGATION_END)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Long getDelegationEnd() {
        return delegationEnd;
    }

    @JsonProperty(JSON_PROPERTY_DELEGATION_END)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDelegationEnd(@jakarta.annotation.Nonnull Long delegationEnd) {
        this.delegationEnd = delegationEnd;
    }

    public DelegatedTask rootProcessInfo(@jakarta.annotation.Nonnull ProcessDeploymentInfo rootProcessInfo) {

        this.rootProcessInfo = rootProcessInfo;
        return this;
    }

    /**
     * Get rootProcessInfo
     * 
     * @return rootProcessInfo
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ROOT_PROCESS_INFO)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public ProcessDeploymentInfo getRootProcessInfo() {
        return rootProcessInfo;
    }

    @JsonProperty(JSON_PROPERTY_ROOT_PROCESS_INFO)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setRootProcessInfo(@jakarta.annotation.Nonnull ProcessDeploymentInfo rootProcessInfo) {
        this.rootProcessInfo = rootProcessInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DelegatedTask delegatedTask = (DelegatedTask) o;
        return Objects.equals(this.id, delegatedTask.id) &&
                Objects.equals(this.name, delegatedTask.name) &&
                Objects.equals(this.displayName, delegatedTask.displayName) &&
                equalsNullable(this.description, delegatedTask.description) &&
                equalsNullable(this.displayDescription, delegatedTask.displayDescription) &&
                Objects.equals(this.state, delegatedTask.state) &&
                Objects.equals(this.type, delegatedTask.type) &&
                Objects.equals(this.priority, delegatedTask.priority) &&
                equalsNullable(this.dueDate, delegatedTask.dueDate) &&
                equalsNullable(this.assignedDate, delegatedTask.assignedDate) &&
                Objects.equals(this.reachedStateDate, delegatedTask.reachedStateDate) &&
                Objects.equals(this.lastUpdateDate, delegatedTask.lastUpdateDate) &&
                Objects.equals(this.processId, delegatedTask.processId) &&
                Objects.equals(this.parentCaseId, delegatedTask.parentCaseId) &&
                Objects.equals(this.rootCaseId, delegatedTask.rootCaseId) &&
                Objects.equals(this.actorId, delegatedTask.actorId) &&
                Objects.equals(this.assigneeId, delegatedTask.assigneeId) &&
                Objects.equals(this.executedBy, delegatedTask.executedBy) &&
                Objects.equals(this.executedBySubstitute, delegatedTask.executedBySubstitute) &&
                Objects.equals(this.flownodeDefinitionId, delegatedTask.flownodeDefinitionId) &&
                Objects.equals(this.delegator, delegatedTask.delegator) &&
                Objects.equals(this.delegate, delegatedTask.delegate) &&
                Objects.equals(this.delegationStart, delegatedTask.delegationStart) &&
                Objects.equals(this.delegationEnd, delegatedTask.delegationEnd) &&
                Objects.equals(this.rootProcessInfo, delegatedTask.rootProcessInfo);
    }

    private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
        return a == b
                || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, displayName, hashCodeNullable(description), hashCodeNullable(displayDescription),
                state, type, priority, hashCodeNullable(dueDate), hashCodeNullable(assignedDate), reachedStateDate,
                lastUpdateDate, processId, parentCaseId, rootCaseId, actorId, assigneeId, executedBy,
                executedBySubstitute, flownodeDefinitionId, delegator, delegate, delegationStart, delegationEnd,
                rootProcessInfo);
    }

    private static <T> int hashCodeNullable(JsonNullable<T> a) {
        if (a == null) {
            return 1;
        }
        return a.isPresent() ? Arrays.deepHashCode(new Object[] { a.get() }) : 31;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DelegatedTask {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    displayDescription: ").append(toIndentedString(displayDescription)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
        sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
        sb.append("    assignedDate: ").append(toIndentedString(assignedDate)).append("\n");
        sb.append("    reachedStateDate: ").append(toIndentedString(reachedStateDate)).append("\n");
        sb.append("    lastUpdateDate: ").append(toIndentedString(lastUpdateDate)).append("\n");
        sb.append("    processId: ").append(toIndentedString(processId)).append("\n");
        sb.append("    parentCaseId: ").append(toIndentedString(parentCaseId)).append("\n");
        sb.append("    rootCaseId: ").append(toIndentedString(rootCaseId)).append("\n");
        sb.append("    actorId: ").append(toIndentedString(actorId)).append("\n");
        sb.append("    assigneeId: ").append(toIndentedString(assigneeId)).append("\n");
        sb.append("    executedBy: ").append(toIndentedString(executedBy)).append("\n");
        sb.append("    executedBySubstitute: ").append(toIndentedString(executedBySubstitute)).append("\n");
        sb.append("    flownodeDefinitionId: ").append(toIndentedString(flownodeDefinitionId)).append("\n");
        sb.append("    delegator: ").append(toIndentedString(delegator)).append("\n");
        sb.append("    delegate: ").append(toIndentedString(delegate)).append("\n");
        sb.append("    delegationStart: ").append(toIndentedString(delegationStart)).append("\n");
        sb.append("    delegationEnd: ").append(toIndentedString(delegationEnd)).append("\n");
        sb.append("    rootProcessInfo: ").append(toIndentedString(rootProcessInfo)).append("\n");
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
