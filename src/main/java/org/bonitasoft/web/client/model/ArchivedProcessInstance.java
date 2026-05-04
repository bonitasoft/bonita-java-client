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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * ArchivedProcessInstance
 */
@JsonPropertyOrder({
        ArchivedProcessInstance.JSON_PROPERTY_ID,
        ArchivedProcessInstance.JSON_PROPERTY_END_DATE,
        ArchivedProcessInstance.JSON_PROPERTY_FAILED_FLOW_NODES,
        ArchivedProcessInstance.JSON_PROPERTY_STARTED_BY_SUBSTITUTE,
        ArchivedProcessInstance.JSON_PROPERTY_START,
        ArchivedProcessInstance.JSON_PROPERTY_ACTIVE_FLOW_NODES,
        ArchivedProcessInstance.JSON_PROPERTY_STATE,
        ArchivedProcessInstance.JSON_PROPERTY_ROOT_CASE_ID,
        ArchivedProcessInstance.JSON_PROPERTY_STARTED_BY,
        ArchivedProcessInstance.JSON_PROPERTY_PROCESS_DEFINITION_ID,
        ArchivedProcessInstance.JSON_PROPERTY_LAST_UPDATE_DATE,
        ArchivedProcessInstance.JSON_PROPERTY_SEARCH_INDEX1_LABEL,
        ArchivedProcessInstance.JSON_PROPERTY_SEARCH_INDEX2_LABEL,
        ArchivedProcessInstance.JSON_PROPERTY_SEARCH_INDEX3_LABEL,
        ArchivedProcessInstance.JSON_PROPERTY_SEARCH_INDEX4_LABEL,
        ArchivedProcessInstance.JSON_PROPERTY_SEARCH_INDEX5_LABEL,
        ArchivedProcessInstance.JSON_PROPERTY_SEARCH_INDEX1_VALUE,
        ArchivedProcessInstance.JSON_PROPERTY_SEARCH_INDEX2_VALUE,
        ArchivedProcessInstance.JSON_PROPERTY_SEARCH_INDEX3_VALUE,
        ArchivedProcessInstance.JSON_PROPERTY_SEARCH_INDEX4_VALUE,
        ArchivedProcessInstance.JSON_PROPERTY_SEARCH_INDEX5_VALUE,
        ArchivedProcessInstance.JSON_PROPERTY_CALLER_ID,
        ArchivedProcessInstance.JSON_PROPERTY_SOURCE_OBJECT_ID,
        ArchivedProcessInstance.JSON_PROPERTY_ARCHIVED_DATE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class ArchivedProcessInstance implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    @jakarta.annotation.Nullable
    private String id;

    public static final String JSON_PROPERTY_END_DATE = "end_date";
    @jakarta.annotation.Nullable
    private String endDate;

    public static final String JSON_PROPERTY_FAILED_FLOW_NODES = "failedFlowNodes";
    @jakarta.annotation.Nullable
    private String failedFlowNodes;

    public static final String JSON_PROPERTY_STARTED_BY_SUBSTITUTE = "startedBySubstitute";
    @jakarta.annotation.Nullable
    private String startedBySubstitute;

    public static final String JSON_PROPERTY_START = "start";
    @jakarta.annotation.Nullable
    private String start;

    public static final String JSON_PROPERTY_ACTIVE_FLOW_NODES = "activeFlowNodes";
    @jakarta.annotation.Nullable
    private String activeFlowNodes;

    /**
     * state: an enum that represent the state of the process instances
     */
    public enum StateEnum {

        INITIALIZING(String.valueOf("initializing")),

        STARTED(String.valueOf("started")),

        SUSPENDED(String.valueOf("suspended")),

        CANCELLED(String.valueOf("cancelled")),

        ABORTED(String.valueOf("aborted")),

        COMPLETING(String.valueOf("completing")),

        COMPLETED(String.valueOf("completed")),

        ERROR(String.valueOf("error")),

        ABORTING(String.valueOf("aborting"));

        private String value;

        StateEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static StateEnum fromValue(String value) {
            for (StateEnum b : StateEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_STATE = "state";
    @jakarta.annotation.Nullable
    private StateEnum state;

    public static final String JSON_PROPERTY_ROOT_CASE_ID = "rootCaseId";
    @jakarta.annotation.Nullable
    private String rootCaseId;

    public static final String JSON_PROPERTY_STARTED_BY = "started_by";
    @jakarta.annotation.Nullable
    private String startedBy;

    public static final String JSON_PROPERTY_PROCESS_DEFINITION_ID = "processDefinitionId";
    @jakarta.annotation.Nullable
    private String processDefinitionId;

    public static final String JSON_PROPERTY_LAST_UPDATE_DATE = "last_update_date";
    @jakarta.annotation.Nullable
    private String lastUpdateDate;

    public static final String JSON_PROPERTY_SEARCH_INDEX1_LABEL = "searchIndex1Label";
    @jakarta.annotation.Nullable
    private String searchIndex1Label;

    public static final String JSON_PROPERTY_SEARCH_INDEX2_LABEL = "searchIndex2Label";
    @jakarta.annotation.Nullable
    private String searchIndex2Label;

    public static final String JSON_PROPERTY_SEARCH_INDEX3_LABEL = "searchIndex3Label";
    @jakarta.annotation.Nullable
    private String searchIndex3Label;

    public static final String JSON_PROPERTY_SEARCH_INDEX4_LABEL = "searchIndex4Label";
    @jakarta.annotation.Nullable
    private String searchIndex4Label;

    public static final String JSON_PROPERTY_SEARCH_INDEX5_LABEL = "searchIndex5Label";
    @jakarta.annotation.Nullable
    private String searchIndex5Label;

    public static final String JSON_PROPERTY_SEARCH_INDEX1_VALUE = "searchIndex1Value";
    @jakarta.annotation.Nullable
    private String searchIndex1Value;

    public static final String JSON_PROPERTY_SEARCH_INDEX2_VALUE = "searchIndex2Value";
    @jakarta.annotation.Nullable
    private String searchIndex2Value;

    public static final String JSON_PROPERTY_SEARCH_INDEX3_VALUE = "searchIndex3Value";
    @jakarta.annotation.Nullable
    private String searchIndex3Value;

    public static final String JSON_PROPERTY_SEARCH_INDEX4_VALUE = "searchIndex4Value";
    @jakarta.annotation.Nullable
    private String searchIndex4Value;

    public static final String JSON_PROPERTY_SEARCH_INDEX5_VALUE = "searchIndex5Value";
    @jakarta.annotation.Nullable
    private String searchIndex5Value;

    public static final String JSON_PROPERTY_CALLER_ID = "callerId";
    @jakarta.annotation.Nullable
    private String callerId;

    public static final String JSON_PROPERTY_SOURCE_OBJECT_ID = "sourceObjectId";
    @jakarta.annotation.Nullable
    private String sourceObjectId;

    public static final String JSON_PROPERTY_ARCHIVED_DATE = "archivedDate";
    @jakarta.annotation.Nullable
    private String archivedDate;

    public ArchivedProcessInstance() {
    }

    public ArchivedProcessInstance id(@jakarta.annotation.Nullable String id) {

        this.id = id;
        return this;
    }

    /**
     * the identifier of the ProcessInstance (Case)
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

    public ArchivedProcessInstance endDate(@jakarta.annotation.Nullable String endDate) {

        this.endDate = endDate;
        return this;
    }

    /**
     * the date set when the process instance is closed
     * 
     * @return endDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_END_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getEndDate() {
        return endDate;
    }

    @JsonProperty(JSON_PROPERTY_END_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEndDate(@jakarta.annotation.Nullable String endDate) {
        this.endDate = endDate;
    }

    public ArchivedProcessInstance failedFlowNodes(@jakarta.annotation.Nullable String failedFlowNodes) {

        this.failedFlowNodes = failedFlowNodes;
        return this;
    }

    /**
     * count of failed flow nodes if parameter n&#x3D;failedFlowNodes is given
     * 
     * @return failedFlowNodes
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FAILED_FLOW_NODES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFailedFlowNodes() {
        return failedFlowNodes;
    }

    @JsonProperty(JSON_PROPERTY_FAILED_FLOW_NODES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFailedFlowNodes(@jakarta.annotation.Nullable String failedFlowNodes) {
        this.failedFlowNodes = failedFlowNodes;
    }

    public ArchivedProcessInstance startedBySubstitute(@jakarta.annotation.Nullable String startedBySubstitute) {

        this.startedBySubstitute = startedBySubstitute;
        return this;
    }

    /**
     * the identifier of the substitute user (as Process manager or Administrator) who started the process. It can be also the substitute user if
     * d&#x3D;startedBySubstitute is given.
     * 
     * @return startedBySubstitute
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STARTED_BY_SUBSTITUTE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getStartedBySubstitute() {
        return startedBySubstitute;
    }

    @JsonProperty(JSON_PROPERTY_STARTED_BY_SUBSTITUTE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStartedBySubstitute(@jakarta.annotation.Nullable String startedBySubstitute) {
        this.startedBySubstitute = startedBySubstitute;
    }

    public ArchivedProcessInstance start(@jakarta.annotation.Nullable String start) {

        this.start = start;
        return this;
    }

    /**
     * the starting date of the case
     * 
     * @return start
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_START)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getStart() {
        return start;
    }

    @JsonProperty(JSON_PROPERTY_START)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStart(@jakarta.annotation.Nullable String start) {
        this.start = start;
    }

    public ArchivedProcessInstance activeFlowNodes(@jakarta.annotation.Nullable String activeFlowNodes) {

        this.activeFlowNodes = activeFlowNodes;
        return this;
    }

    /**
     * count of active flow nodes if parameter n&#x3D;activeFlowNodes is given
     * 
     * @return activeFlowNodes
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ACTIVE_FLOW_NODES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getActiveFlowNodes() {
        return activeFlowNodes;
    }

    @JsonProperty(JSON_PROPERTY_ACTIVE_FLOW_NODES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setActiveFlowNodes(@jakarta.annotation.Nullable String activeFlowNodes) {
        this.activeFlowNodes = activeFlowNodes;
    }

    public ArchivedProcessInstance state(@jakarta.annotation.Nullable StateEnum state) {

        this.state = state;
        return this;
    }

    /**
     * state: an enum that represent the state of the process instances
     * 
     * @return state
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public StateEnum getState() {
        return state;
    }

    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setState(@jakarta.annotation.Nullable StateEnum state) {
        this.state = state;
    }

    public ArchivedProcessInstance rootCaseId(@jakarta.annotation.Nullable String rootCaseId) {

        this.rootCaseId = rootCaseId;
        return this;
    }

    /**
     * the identifier of the container of the case
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

    public ArchivedProcessInstance startedBy(@jakarta.annotation.Nullable String startedBy) {

        this.startedBy = startedBy;
        return this;
    }

    /**
     * the identifier of the user who started the case
     * 
     * @return startedBy
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STARTED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getStartedBy() {
        return startedBy;
    }

    @JsonProperty(JSON_PROPERTY_STARTED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStartedBy(@jakarta.annotation.Nullable String startedBy) {
        this.startedBy = startedBy;
    }

    public ArchivedProcessInstance processDefinitionId(@jakarta.annotation.Nullable String processDefinitionId) {

        this.processDefinitionId = processDefinitionId;
        return this;
    }

    /**
     * the identifier of the process related of the case
     * 
     * @return processDefinitionId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PROCESS_DEFINITION_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    @JsonProperty(JSON_PROPERTY_PROCESS_DEFINITION_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProcessDefinitionId(@jakarta.annotation.Nullable String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public ArchivedProcessInstance lastUpdateDate(@jakarta.annotation.Nullable String lastUpdateDate) {

        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    /**
     * the date of the last update done on the case
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

    public ArchivedProcessInstance searchIndex1Label(@jakarta.annotation.Nullable String searchIndex1Label) {

        this.searchIndex1Label = searchIndex1Label;
        return this;
    }

    /**
     * the 1st search index label (from 6.5, in Subscription editions only)
     * 
     * @return searchIndex1Label
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SEARCH_INDEX1_LABEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSearchIndex1Label() {
        return searchIndex1Label;
    }

    @JsonProperty(JSON_PROPERTY_SEARCH_INDEX1_LABEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSearchIndex1Label(@jakarta.annotation.Nullable String searchIndex1Label) {
        this.searchIndex1Label = searchIndex1Label;
    }

    public ArchivedProcessInstance searchIndex2Label(@jakarta.annotation.Nullable String searchIndex2Label) {

        this.searchIndex2Label = searchIndex2Label;
        return this;
    }

    /**
     * the 2nd search index label (from 6.5, in Subscription editions only)
     * 
     * @return searchIndex2Label
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SEARCH_INDEX2_LABEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSearchIndex2Label() {
        return searchIndex2Label;
    }

    @JsonProperty(JSON_PROPERTY_SEARCH_INDEX2_LABEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSearchIndex2Label(@jakarta.annotation.Nullable String searchIndex2Label) {
        this.searchIndex2Label = searchIndex2Label;
    }

    public ArchivedProcessInstance searchIndex3Label(@jakarta.annotation.Nullable String searchIndex3Label) {

        this.searchIndex3Label = searchIndex3Label;
        return this;
    }

    /**
     * the 3rd search index label (from 6.5, in Subscription editions only)
     * 
     * @return searchIndex3Label
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SEARCH_INDEX3_LABEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSearchIndex3Label() {
        return searchIndex3Label;
    }

    @JsonProperty(JSON_PROPERTY_SEARCH_INDEX3_LABEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSearchIndex3Label(@jakarta.annotation.Nullable String searchIndex3Label) {
        this.searchIndex3Label = searchIndex3Label;
    }

    public ArchivedProcessInstance searchIndex4Label(@jakarta.annotation.Nullable String searchIndex4Label) {

        this.searchIndex4Label = searchIndex4Label;
        return this;
    }

    /**
     * the 4th search index label (from 6.5, in Subscription editions only)
     * 
     * @return searchIndex4Label
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SEARCH_INDEX4_LABEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSearchIndex4Label() {
        return searchIndex4Label;
    }

    @JsonProperty(JSON_PROPERTY_SEARCH_INDEX4_LABEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSearchIndex4Label(@jakarta.annotation.Nullable String searchIndex4Label) {
        this.searchIndex4Label = searchIndex4Label;
    }

    public ArchivedProcessInstance searchIndex5Label(@jakarta.annotation.Nullable String searchIndex5Label) {

        this.searchIndex5Label = searchIndex5Label;
        return this;
    }

    /**
     * the 5th search index label (from 6.5, in Subscription editions only)
     * 
     * @return searchIndex5Label
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SEARCH_INDEX5_LABEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSearchIndex5Label() {
        return searchIndex5Label;
    }

    @JsonProperty(JSON_PROPERTY_SEARCH_INDEX5_LABEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSearchIndex5Label(@jakarta.annotation.Nullable String searchIndex5Label) {
        this.searchIndex5Label = searchIndex5Label;
    }

    public ArchivedProcessInstance searchIndex1Value(@jakarta.annotation.Nullable String searchIndex1Value) {

        this.searchIndex1Value = searchIndex1Value;
        return this;
    }

    /**
     * the 1st search index value (from 6.5, in Subscription editions only)
     * 
     * @return searchIndex1Value
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SEARCH_INDEX1_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSearchIndex1Value() {
        return searchIndex1Value;
    }

    @JsonProperty(JSON_PROPERTY_SEARCH_INDEX1_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSearchIndex1Value(@jakarta.annotation.Nullable String searchIndex1Value) {
        this.searchIndex1Value = searchIndex1Value;
    }

    public ArchivedProcessInstance searchIndex2Value(@jakarta.annotation.Nullable String searchIndex2Value) {

        this.searchIndex2Value = searchIndex2Value;
        return this;
    }

    /**
     * the 2nd search index value (from 6.5, in Subscription editions only)
     * 
     * @return searchIndex2Value
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SEARCH_INDEX2_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSearchIndex2Value() {
        return searchIndex2Value;
    }

    @JsonProperty(JSON_PROPERTY_SEARCH_INDEX2_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSearchIndex2Value(@jakarta.annotation.Nullable String searchIndex2Value) {
        this.searchIndex2Value = searchIndex2Value;
    }

    public ArchivedProcessInstance searchIndex3Value(@jakarta.annotation.Nullable String searchIndex3Value) {

        this.searchIndex3Value = searchIndex3Value;
        return this;
    }

    /**
     * the 3rd search index value (from 6.5, in Subscription editions only)
     * 
     * @return searchIndex3Value
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SEARCH_INDEX3_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSearchIndex3Value() {
        return searchIndex3Value;
    }

    @JsonProperty(JSON_PROPERTY_SEARCH_INDEX3_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSearchIndex3Value(@jakarta.annotation.Nullable String searchIndex3Value) {
        this.searchIndex3Value = searchIndex3Value;
    }

    public ArchivedProcessInstance searchIndex4Value(@jakarta.annotation.Nullable String searchIndex4Value) {

        this.searchIndex4Value = searchIndex4Value;
        return this;
    }

    /**
     * the 4th search index value (from 6.5, in Subscription editions only)
     * 
     * @return searchIndex4Value
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SEARCH_INDEX4_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSearchIndex4Value() {
        return searchIndex4Value;
    }

    @JsonProperty(JSON_PROPERTY_SEARCH_INDEX4_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSearchIndex4Value(@jakarta.annotation.Nullable String searchIndex4Value) {
        this.searchIndex4Value = searchIndex4Value;
    }

    public ArchivedProcessInstance searchIndex5Value(@jakarta.annotation.Nullable String searchIndex5Value) {

        this.searchIndex5Value = searchIndex5Value;
        return this;
    }

    /**
     * the 5th search index value (from 6.5, in Subscription editions only)
     * 
     * @return searchIndex5Value
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SEARCH_INDEX5_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSearchIndex5Value() {
        return searchIndex5Value;
    }

    @JsonProperty(JSON_PROPERTY_SEARCH_INDEX5_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSearchIndex5Value(@jakarta.annotation.Nullable String searchIndex5Value) {
        this.searchIndex5Value = searchIndex5Value;
    }

    public ArchivedProcessInstance callerId(@jakarta.annotation.Nullable String callerId) {

        this.callerId = callerId;
        return this;
    }

    /**
     * the identifier of the BPM entity who started the process. E.g. the call activity instance Id if it was started by a call activity or -1 if it was started by
     * a user (since version 10.3 - 2025.1)
     * 
     * @return callerId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CALLER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCallerId() {
        return callerId;
    }

    @JsonProperty(JSON_PROPERTY_CALLER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCallerId(@jakarta.annotation.Nullable String callerId) {
        this.callerId = callerId;
    }

    public ArchivedProcessInstance sourceObjectId(@jakarta.annotation.Nullable String sourceObjectId) {

        this.sourceObjectId = sourceObjectId;
        return this;
    }

    /**
     * the id of the process instance before it was archived
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

    public ArchivedProcessInstance archivedDate(@jakarta.annotation.Nullable String archivedDate) {

        this.archivedDate = archivedDate;
        return this;
    }

    /**
     * the date set when the process instance was archived
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
        ArchivedProcessInstance archivedProcessInstance = (ArchivedProcessInstance) o;
        return Objects.equals(this.id, archivedProcessInstance.id) &&
                Objects.equals(this.endDate, archivedProcessInstance.endDate) &&
                Objects.equals(this.failedFlowNodes, archivedProcessInstance.failedFlowNodes) &&
                Objects.equals(this.startedBySubstitute, archivedProcessInstance.startedBySubstitute) &&
                Objects.equals(this.start, archivedProcessInstance.start) &&
                Objects.equals(this.activeFlowNodes, archivedProcessInstance.activeFlowNodes) &&
                Objects.equals(this.state, archivedProcessInstance.state) &&
                Objects.equals(this.rootCaseId, archivedProcessInstance.rootCaseId) &&
                Objects.equals(this.startedBy, archivedProcessInstance.startedBy) &&
                Objects.equals(this.processDefinitionId, archivedProcessInstance.processDefinitionId) &&
                Objects.equals(this.lastUpdateDate, archivedProcessInstance.lastUpdateDate) &&
                Objects.equals(this.searchIndex1Label, archivedProcessInstance.searchIndex1Label) &&
                Objects.equals(this.searchIndex2Label, archivedProcessInstance.searchIndex2Label) &&
                Objects.equals(this.searchIndex3Label, archivedProcessInstance.searchIndex3Label) &&
                Objects.equals(this.searchIndex4Label, archivedProcessInstance.searchIndex4Label) &&
                Objects.equals(this.searchIndex5Label, archivedProcessInstance.searchIndex5Label) &&
                Objects.equals(this.searchIndex1Value, archivedProcessInstance.searchIndex1Value) &&
                Objects.equals(this.searchIndex2Value, archivedProcessInstance.searchIndex2Value) &&
                Objects.equals(this.searchIndex3Value, archivedProcessInstance.searchIndex3Value) &&
                Objects.equals(this.searchIndex4Value, archivedProcessInstance.searchIndex4Value) &&
                Objects.equals(this.searchIndex5Value, archivedProcessInstance.searchIndex5Value) &&
                Objects.equals(this.callerId, archivedProcessInstance.callerId) &&
                Objects.equals(this.sourceObjectId, archivedProcessInstance.sourceObjectId) &&
                Objects.equals(this.archivedDate, archivedProcessInstance.archivedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, endDate, failedFlowNodes, startedBySubstitute, start, activeFlowNodes, state,
                rootCaseId, startedBy, processDefinitionId, lastUpdateDate, searchIndex1Label, searchIndex2Label,
                searchIndex3Label, searchIndex4Label, searchIndex5Label, searchIndex1Value, searchIndex2Value,
                searchIndex3Value, searchIndex4Value, searchIndex5Value, callerId, sourceObjectId, archivedDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ArchivedProcessInstance {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    failedFlowNodes: ").append(toIndentedString(failedFlowNodes)).append("\n");
        sb.append("    startedBySubstitute: ").append(toIndentedString(startedBySubstitute)).append("\n");
        sb.append("    start: ").append(toIndentedString(start)).append("\n");
        sb.append("    activeFlowNodes: ").append(toIndentedString(activeFlowNodes)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    rootCaseId: ").append(toIndentedString(rootCaseId)).append("\n");
        sb.append("    startedBy: ").append(toIndentedString(startedBy)).append("\n");
        sb.append("    processDefinitionId: ").append(toIndentedString(processDefinitionId)).append("\n");
        sb.append("    lastUpdateDate: ").append(toIndentedString(lastUpdateDate)).append("\n");
        sb.append("    searchIndex1Label: ").append(toIndentedString(searchIndex1Label)).append("\n");
        sb.append("    searchIndex2Label: ").append(toIndentedString(searchIndex2Label)).append("\n");
        sb.append("    searchIndex3Label: ").append(toIndentedString(searchIndex3Label)).append("\n");
        sb.append("    searchIndex4Label: ").append(toIndentedString(searchIndex4Label)).append("\n");
        sb.append("    searchIndex5Label: ").append(toIndentedString(searchIndex5Label)).append("\n");
        sb.append("    searchIndex1Value: ").append(toIndentedString(searchIndex1Value)).append("\n");
        sb.append("    searchIndex2Value: ").append(toIndentedString(searchIndex2Value)).append("\n");
        sb.append("    searchIndex3Value: ").append(toIndentedString(searchIndex3Value)).append("\n");
        sb.append("    searchIndex4Value: ").append(toIndentedString(searchIndex4Value)).append("\n");
        sb.append("    searchIndex5Value: ").append(toIndentedString(searchIndex5Value)).append("\n");
        sb.append("    callerId: ").append(toIndentedString(callerId)).append("\n");
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
