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
 * A failure that happened during a BPM instance (flow node, process) execution that led to the instance being in a failed state.
 */
@JsonPropertyOrder({
        BPMFailure.JSON_PROPERTY_CASE_ID,
        BPMFailure.JSON_PROPERTY_ROOT_CASE_ID,
        BPMFailure.JSON_PROPERTY_CONTEXT,
        BPMFailure.JSON_PROPERTY_ERROR_MESSAGE,
        BPMFailure.JSON_PROPERTY_FAILURE_DATE,
        BPMFailure.JSON_PROPERTY_FLOW_NODE_INSTANCE_ID,
        BPMFailure.JSON_PROPERTY_ID,
        BPMFailure.JSON_PROPERTY_PROCESS_DEFINITION_ID,
        BPMFailure.JSON_PROPERTY_SCOPE,
        BPMFailure.JSON_PROPERTY_STACK_TRACE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class BPMFailure implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_CASE_ID = "caseId";
    @jakarta.annotation.Nullable
    private String caseId;

    public static final String JSON_PROPERTY_ROOT_CASE_ID = "rootCaseId";
    @jakarta.annotation.Nullable
    private String rootCaseId;

    public static final String JSON_PROPERTY_CONTEXT = "context";
    @jakarta.annotation.Nullable
    private String context;

    public static final String JSON_PROPERTY_ERROR_MESSAGE = "errorMessage";
    @jakarta.annotation.Nullable
    private String errorMessage;

    public static final String JSON_PROPERTY_FAILURE_DATE = "failureDate";
    @jakarta.annotation.Nullable
    private String failureDate;

    public static final String JSON_PROPERTY_FLOW_NODE_INSTANCE_ID = "flowNodeInstanceId";
    @jakarta.annotation.Nullable
    private String flowNodeInstanceId;

    public static final String JSON_PROPERTY_ID = "id";
    @jakarta.annotation.Nullable
    private String id;

    public static final String JSON_PROPERTY_PROCESS_DEFINITION_ID = "processDefinitionId";
    @jakarta.annotation.Nullable
    private String processDefinitionId;

    public static final String JSON_PROPERTY_SCOPE = "scope";
    @jakarta.annotation.Nullable
    private String scope;

    public static final String JSON_PROPERTY_STACK_TRACE = "stackTrace";
    @jakarta.annotation.Nullable
    private String stackTrace;

    public BPMFailure() {
    }

    public BPMFailure caseId(@jakarta.annotation.Nullable String caseId) {

        this.caseId = caseId;
        return this;
    }

    /**
     * the id of the process instance in which that failure occurred
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

    public BPMFailure rootCaseId(@jakarta.annotation.Nullable String rootCaseId) {

        this.rootCaseId = rootCaseId;
        return this;
    }

    /**
     * the id of the root process instance in which that failure occurred
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

    public BPMFailure context(@jakarta.annotation.Nullable String context) {

        this.context = context;
        return this;
    }

    /**
     * Context of the failure
     * 
     * @return context
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONTEXT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getContext() {
        return context;
    }

    @JsonProperty(JSON_PROPERTY_CONTEXT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContext(@jakarta.annotation.Nullable String context) {
        this.context = context;
    }

    public BPMFailure errorMessage(@jakarta.annotation.Nullable String errorMessage) {

        this.errorMessage = errorMessage;
        return this;
    }

    /**
     * the message of the exception
     * 
     * @return errorMessage
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ERROR_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getErrorMessage() {
        return errorMessage;
    }

    @JsonProperty(JSON_PROPERTY_ERROR_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setErrorMessage(@jakarta.annotation.Nullable String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public BPMFailure failureDate(@jakarta.annotation.Nullable String failureDate) {

        this.failureDate = failureDate;
        return this;
    }

    /**
     * the date when the failure occurred in milliseconds since epoch
     * 
     * @return failureDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FAILURE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFailureDate() {
        return failureDate;
    }

    @JsonProperty(JSON_PROPERTY_FAILURE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFailureDate(@jakarta.annotation.Nullable String failureDate) {
        this.failureDate = failureDate;
    }

    public BPMFailure flowNodeInstanceId(@jakarta.annotation.Nullable String flowNodeInstanceId) {

        this.flowNodeInstanceId = flowNodeInstanceId;
        return this;
    }

    /**
     * the id of the flow node instance in which the failure occurred
     * 
     * @return flowNodeInstanceId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FLOW_NODE_INSTANCE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFlowNodeInstanceId() {
        return flowNodeInstanceId;
    }

    @JsonProperty(JSON_PROPERTY_FLOW_NODE_INSTANCE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFlowNodeInstanceId(@jakarta.annotation.Nullable String flowNodeInstanceId) {
        this.flowNodeInstanceId = flowNodeInstanceId;
    }

    public BPMFailure id(@jakarta.annotation.Nullable String id) {

        this.id = id;
        return this;
    }

    /**
     * the failure id
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

    public BPMFailure processDefinitionId(@jakarta.annotation.Nullable String processDefinitionId) {

        this.processDefinitionId = processDefinitionId;
        return this;
    }

    /**
     * the process id that is associated with the flow node or case instance of the failure
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

    public BPMFailure scope(@jakarta.annotation.Nullable String scope) {

        this.scope = scope;
        return this;
    }

    /**
     * the scope of the failure (General information, Operation, Event, Iteration, Connector, Data initialization, Actor mapping, Outgoing transition, or UNKNOWN)
     * 
     * @return scope
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SCOPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getScope() {
        return scope;
    }

    @JsonProperty(JSON_PROPERTY_SCOPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setScope(@jakarta.annotation.Nullable String scope) {
        this.scope = scope;
    }

    public BPMFailure stackTrace(@jakarta.annotation.Nullable String stackTrace) {

        this.stackTrace = stackTrace;
        return this;
    }

    /**
     * the stack trace of the exception
     * 
     * @return stackTrace
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STACK_TRACE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getStackTrace() {
        return stackTrace;
    }

    @JsonProperty(JSON_PROPERTY_STACK_TRACE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStackTrace(@jakarta.annotation.Nullable String stackTrace) {
        this.stackTrace = stackTrace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BPMFailure bpMFailure = (BPMFailure) o;
        return Objects.equals(this.caseId, bpMFailure.caseId) &&
                Objects.equals(this.rootCaseId, bpMFailure.rootCaseId) &&
                Objects.equals(this.context, bpMFailure.context) &&
                Objects.equals(this.errorMessage, bpMFailure.errorMessage) &&
                Objects.equals(this.failureDate, bpMFailure.failureDate) &&
                Objects.equals(this.flowNodeInstanceId, bpMFailure.flowNodeInstanceId) &&
                Objects.equals(this.id, bpMFailure.id) &&
                Objects.equals(this.processDefinitionId, bpMFailure.processDefinitionId) &&
                Objects.equals(this.scope, bpMFailure.scope) &&
                Objects.equals(this.stackTrace, bpMFailure.stackTrace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseId, rootCaseId, context, errorMessage, failureDate, flowNodeInstanceId, id,
                processDefinitionId, scope, stackTrace);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BPMFailure {\n");
        sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
        sb.append("    rootCaseId: ").append(toIndentedString(rootCaseId)).append("\n");
        sb.append("    context: ").append(toIndentedString(context)).append("\n");
        sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
        sb.append("    failureDate: ").append(toIndentedString(failureDate)).append("\n");
        sb.append("    flowNodeInstanceId: ").append(toIndentedString(flowNodeInstanceId)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    processDefinitionId: ").append(toIndentedString(processDefinitionId)).append("\n");
        sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
        sb.append("    stackTrace: ").append(toIndentedString(stackTrace)).append("\n");
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
