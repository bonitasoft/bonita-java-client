/** 
 * Copyright (C) 2024 BonitaSoft S.A.
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
 * Use this resource to retrieve finished activities (human or service tasks), call activities, and subprocesses.
 */
@JsonPropertyOrder({
        ArchivedActivity.JSON_PROPERTY_ID,
        ArchivedActivity.JSON_PROPERTY_TYPE,
        ArchivedActivity.JSON_PROPERTY_NAME,
        ArchivedActivity.JSON_PROPERTY_DISPLAY_NAME,
        ArchivedActivity.JSON_PROPERTY_DESCRIPTION,
        ArchivedActivity.JSON_PROPERTY_DISPLAY_DESCRIPTION,
        ArchivedActivity.JSON_PROPERTY_STATE,
        ArchivedActivity.JSON_PROPERTY_REACHED_STATE_DATE,
        ArchivedActivity.JSON_PROPERTY_LAST_UPDATE_DATE,
        ArchivedActivity.JSON_PROPERTY_DUE_DATE,
        ArchivedActivity.JSON_PROPERTY_PRIORITY,
        ArchivedActivity.JSON_PROPERTY_PROCESS_ID,
        ArchivedActivity.JSON_PROPERTY_PARENT_CASE_ID,
        ArchivedActivity.JSON_PROPERTY_ROOT_CASE_ID,
        ArchivedActivity.JSON_PROPERTY_ROOT_CONTAINER_ID,
        ArchivedActivity.JSON_PROPERTY_EXECUTED_BY,
        ArchivedActivity.JSON_PROPERTY_EXECUTED_BY_SUBSTITUTE,
        ArchivedActivity.JSON_PROPERTY_ACTOR_ID,
        ArchivedActivity.JSON_PROPERTY_ASSIGNED_ID,
        ArchivedActivity.JSON_PROPERTY_ASSIGNED_DATE,
        ArchivedActivity.JSON_PROPERTY_SOURCE_OBJECT_ID,
        ArchivedActivity.JSON_PROPERTY_ARCHIVED_DATE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class ArchivedActivity implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_TYPE = "type";
    private ActivityType type;

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
    private ActivityPriority priority;

    public static final String JSON_PROPERTY_PROCESS_ID = "processId";
    private String processId;

    public static final String JSON_PROPERTY_PARENT_CASE_ID = "parentCaseId";
    private String parentCaseId;

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

    public static final String JSON_PROPERTY_SOURCE_OBJECT_ID = "sourceObjectId";
    private String sourceObjectId;

    public static final String JSON_PROPERTY_ARCHIVED_DATE = "archivedDate";
    private String archivedDate;

    public ArchivedActivity() {
    }

    public ArchivedActivity id(String id) {

        this.id = id;
        return this;
    }

    /**
     * the archived activity id
     * 
     * @return id
     **/
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

    public ArchivedActivity type(ActivityType type) {

        this.type = type;
        return this;
    }

    /**
     * Get type
     * 
     * @return type
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ActivityType getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setType(ActivityType type) {
        this.type = type;
    }

    public ArchivedActivity name(String name) {

        this.name = name;
        return this;
    }

    /**
     * the archived activity technical name
     * 
     * @return name
     **/
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

    public ArchivedActivity displayName(String displayName) {

        this.displayName = displayName;
        return this;
    }

    /**
     * the human readable archived activity name
     * 
     * @return displayName
     **/
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

    public ArchivedActivity description(String description) {

        this.description = description;
        return this;
    }

    /**
     * the archived activity description
     * 
     * @return description
     **/
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

    public ArchivedActivity displayDescription(String displayDescription) {

        this.displayDescription = displayDescription;
        return this;
    }

    /**
     * the human readable archived activity description
     * 
     * @return displayDescription
     **/
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

    public ArchivedActivity state(ActivityState state) {

        this.state = state;
        return this;
    }

    /**
     * Get state
     * 
     * @return state
     **/
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

    public ArchivedActivity reachedStateDate(String reachedStateDate) {

        this.reachedStateDate = reachedStateDate;
        return this;
    }

    /**
     * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this archived activity reached the current state, for example &#39;2014-10-17 16:05:42.626&#39;
     * 
     * @return reachedStateDate
     **/
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

    public ArchivedActivity lastUpdateDate(String lastUpdateDate) {

        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    /**
     * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this archived activity was last updated, for example &#39;2014-10-17 16:05:42.626)
     * 
     * @return lastUpdateDate
     **/
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

    public ArchivedActivity dueDate(String dueDate) {

        this.dueDate = dueDate;
        return this;
    }

    /**
     * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this archived activity is due, for example &#39;2014-10-17 16:05:42.626&#39;
     * 
     * @return dueDate
     **/
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

    public ArchivedActivity priority(ActivityPriority priority) {

        this.priority = priority;
        return this;
    }

    /**
     * Get priority
     * 
     * @return priority
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PRIORITY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ActivityPriority getPriority() {
        return priority;
    }

    @JsonProperty(JSON_PROPERTY_PRIORITY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPriority(ActivityPriority priority) {
        this.priority = priority;
    }

    public ArchivedActivity processId(String processId) {

        this.processId = processId;
        return this;
    }

    /**
     * the process definition id of the process instance which define this archived activity
     * 
     * @return processId
     **/
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

    public ArchivedActivity parentCaseId(String parentCaseId) {

        this.parentCaseId = parentCaseId;
        return this;
    }

    /**
     * the immediate containing process instance id (a.k.a case id)
     * 
     * @return parentCaseId
     **/
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

    public ArchivedActivity rootCaseId(String rootCaseId) {

        this.rootCaseId = rootCaseId;
        return this;
    }

    /**
     * the top/root process instance id (a.k.a case id). In case of an \&quot;event sub process\&quot;, &#x60;parentCaseId&#x60; will the id of the process instance
     * called while &#x60;rootCaseId&#x60; will be the one from the caller case
     * 
     * @return rootCaseId
     **/
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

    public ArchivedActivity rootContainerId(String rootContainerId) {

        this.rootContainerId = rootContainerId;
        return this;
    }

    /**
     * same as &#x60;rootCaseId&#x60;
     * 
     * @return rootContainerId
     **/
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

    public ArchivedActivity executedBy(String executedBy) {

        this.executedBy = executedBy;
        return this;
    }

    /**
     * the id of the user who performed this archived activity. The archived activity has to be a human task otherwise its value will be 0
     * 
     * @return executedBy
     **/
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

    public ArchivedActivity executedBySubstitute(String executedBySubstitute) {

        this.executedBySubstitute = executedBySubstitute;
        return this;
    }

    /**
     * the id of the user who did actually performed the archived activity when it has been done in the name of someone else. Value is 0 otherwise
     * 
     * @return executedBySubstitute
     **/
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

    public ArchivedActivity actorId(String actorId) {

        this.actorId = actorId;
        return this;
    }

    /**
     * the id of the actor that can execute this archived activity, null otherwise
     * 
     * @return actorId
     **/
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

    public ArchivedActivity assignedId(String assignedId) {

        this.assignedId = assignedId;
        return this;
    }

    /**
     * the user id that this archived activity is assigned to, or 0 if it is unassigned
     * 
     * @return assignedId
     **/
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

    public ArchivedActivity assignedDate(String assignedDate) {

        this.assignedDate = assignedDate;
        return this;
    }

    /**
     * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when the current archived activity was assigned, for example &#39;2014-10-17 16:05:42.626&#39;
     * 
     * @return assignedDate
     **/
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

    public ArchivedActivity sourceObjectId(String sourceObjectId) {

        this.sourceObjectId = sourceObjectId;
        return this;
    }

    /**
     * the original id of the archived activity before it was archived
     * 
     * @return sourceObjectId
     **/
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

    public ArchivedActivity archivedDate(String archivedDate) {

        this.archivedDate = archivedDate;
        return this;
    }

    /**
     * the date ((&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;)) when this archived activity was archived, for example &#39;2014-10-17 16:05:42.626&#39;
     * 
     * @return archivedDate
     **/
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
        ArchivedActivity archivedActivity = (ArchivedActivity) o;
        return Objects.equals(this.id, archivedActivity.id) &&
                Objects.equals(this.type, archivedActivity.type) &&
                Objects.equals(this.name, archivedActivity.name) &&
                Objects.equals(this.displayName, archivedActivity.displayName) &&
                Objects.equals(this.description, archivedActivity.description) &&
                Objects.equals(this.displayDescription, archivedActivity.displayDescription) &&
                Objects.equals(this.state, archivedActivity.state) &&
                Objects.equals(this.reachedStateDate, archivedActivity.reachedStateDate) &&
                Objects.equals(this.lastUpdateDate, archivedActivity.lastUpdateDate) &&
                Objects.equals(this.dueDate, archivedActivity.dueDate) &&
                Objects.equals(this.priority, archivedActivity.priority) &&
                Objects.equals(this.processId, archivedActivity.processId) &&
                Objects.equals(this.parentCaseId, archivedActivity.parentCaseId) &&
                Objects.equals(this.rootCaseId, archivedActivity.rootCaseId) &&
                Objects.equals(this.rootContainerId, archivedActivity.rootContainerId) &&
                Objects.equals(this.executedBy, archivedActivity.executedBy) &&
                Objects.equals(this.executedBySubstitute, archivedActivity.executedBySubstitute) &&
                Objects.equals(this.actorId, archivedActivity.actorId) &&
                Objects.equals(this.assignedId, archivedActivity.assignedId) &&
                Objects.equals(this.assignedDate, archivedActivity.assignedDate) &&
                Objects.equals(this.sourceObjectId, archivedActivity.sourceObjectId) &&
                Objects.equals(this.archivedDate, archivedActivity.archivedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, displayName, description, displayDescription, state, reachedStateDate,
                lastUpdateDate, dueDate, priority, processId, parentCaseId, rootCaseId, rootContainerId, executedBy,
                executedBySubstitute, actorId, assignedId, assignedDate, sourceObjectId, archivedDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ArchivedActivity {\n");
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
        sb.append("    rootCaseId: ").append(toIndentedString(rootCaseId)).append("\n");
        sb.append("    rootContainerId: ").append(toIndentedString(rootContainerId)).append("\n");
        sb.append("    executedBy: ").append(toIndentedString(executedBy)).append("\n");
        sb.append("    executedBySubstitute: ").append(toIndentedString(executedBySubstitute)).append("\n");
        sb.append("    actorId: ").append(toIndentedString(actorId)).append("\n");
        sb.append("    assignedId: ").append(toIndentedString(assignedId)).append("\n");
        sb.append("    assignedDate: ").append(toIndentedString(assignedDate)).append("\n");
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
