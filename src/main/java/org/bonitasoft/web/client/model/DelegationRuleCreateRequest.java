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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Body of &#x60;POST /API/delegation/rule&#x60;. Defines a new delegation rule. &#x60;delegatorId&#x60; is optional: when omitted it is resolved from the
 * current session (self-service creation). An administrator creating a rule on behalf of another user provides &#x60;delegatorId&#x60; explicitly. The values
 * must satisfy: &#x60;endDate&#x60; strictly after &#x60;startDate&#x60;, &#x60;delegateId&#x60; different from the delegator, and a non-empty
 * &#x60;processes&#x60; list. A violation is reported as &#x60;400&#x60;. A user can hold at most one delegation rule: posting a rule for a delegator who
 * already has one replaces the existing rule (upsert).
 */
@JsonPropertyOrder({
        DelegationRuleCreateRequest.JSON_PROPERTY_DELEGATOR_ID,
        DelegationRuleCreateRequest.JSON_PROPERTY_DELEGATE_ID,
        DelegationRuleCreateRequest.JSON_PROPERTY_START_DATE,
        DelegationRuleCreateRequest.JSON_PROPERTY_END_DATE,
        DelegationRuleCreateRequest.JSON_PROPERTY_PROCESSES
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class DelegationRuleCreateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_DELEGATOR_ID = "delegatorId";
    @jakarta.annotation.Nullable
    private Long delegatorId;

    public static final String JSON_PROPERTY_DELEGATE_ID = "delegateId";
    @jakarta.annotation.Nonnull
    private Long delegateId;

    public static final String JSON_PROPERTY_START_DATE = "startDate";
    @jakarta.annotation.Nonnull
    private Long startDate;

    public static final String JSON_PROPERTY_END_DATE = "endDate";
    @jakarta.annotation.Nonnull
    private Long endDate;

    public static final String JSON_PROPERTY_PROCESSES = "processes";
    @jakarta.annotation.Nonnull
    private List<String> processes = new ArrayList<>();

    public DelegationRuleCreateRequest() {
    }

    public DelegationRuleCreateRequest delegatorId(@jakarta.annotation.Nullable Long delegatorId) {

        this.delegatorId = delegatorId;
        return this;
    }

    /**
     * Id of the user whose tasks are delegated. Optional; resolved from the session when omitted.
     * 
     * @return delegatorId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DELEGATOR_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getDelegatorId() {
        return delegatorId;
    }

    @JsonProperty(JSON_PROPERTY_DELEGATOR_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDelegatorId(@jakarta.annotation.Nullable Long delegatorId) {
        this.delegatorId = delegatorId;
    }

    public DelegationRuleCreateRequest delegateId(@jakarta.annotation.Nonnull Long delegateId) {

        this.delegateId = delegateId;
        return this;
    }

    /**
     * Id of the user receiving access. Must differ from the delegator.
     * 
     * @return delegateId
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DELEGATE_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Long getDelegateId() {
        return delegateId;
    }

    @JsonProperty(JSON_PROPERTY_DELEGATE_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDelegateId(@jakarta.annotation.Nonnull Long delegateId) {
        this.delegateId = delegateId;
    }

    public DelegationRuleCreateRequest startDate(@jakarta.annotation.Nonnull Long startDate) {

        this.startDate = startDate;
        return this;
    }

    /**
     * Start of the delegation period, inclusive, in epoch milliseconds.
     * 
     * @return startDate
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_START_DATE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Long getStartDate() {
        return startDate;
    }

    @JsonProperty(JSON_PROPERTY_START_DATE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setStartDate(@jakarta.annotation.Nonnull Long startDate) {
        this.startDate = startDate;
    }

    public DelegationRuleCreateRequest endDate(@jakarta.annotation.Nonnull Long endDate) {

        this.endDate = endDate;
        return this;
    }

    /**
     * End of the delegation period, inclusive, in epoch milliseconds. Must be strictly after &#x60;startDate&#x60;.
     * 
     * @return endDate
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_END_DATE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Long getEndDate() {
        return endDate;
    }

    @JsonProperty(JSON_PROPERTY_END_DATE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setEndDate(@jakarta.annotation.Nonnull Long endDate) {
        this.endDate = endDate;
    }

    public DelegationRuleCreateRequest processes(@jakarta.annotation.Nonnull List<String> processes) {

        this.processes = processes;
        return this;
    }

    public DelegationRuleCreateRequest addProcessesItem(String processesItem) {
        if (this.processes == null) {
            this.processes = new ArrayList<>();
        }
        this.processes.add(processesItem);
        return this;
    }

    /**
     * Process whitelist. Each entry is a process name covering every deployed version. Must contain at least one entry.
     * 
     * @return processes
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_PROCESSES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<String> getProcesses() {
        return processes;
    }

    @JsonProperty(JSON_PROPERTY_PROCESSES)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setProcesses(@jakarta.annotation.Nonnull List<String> processes) {
        this.processes = processes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DelegationRuleCreateRequest delegationRuleCreateRequest = (DelegationRuleCreateRequest) o;
        return Objects.equals(this.delegatorId, delegationRuleCreateRequest.delegatorId) &&
                Objects.equals(this.delegateId, delegationRuleCreateRequest.delegateId) &&
                Objects.equals(this.startDate, delegationRuleCreateRequest.startDate) &&
                Objects.equals(this.endDate, delegationRuleCreateRequest.endDate) &&
                Objects.equals(this.processes, delegationRuleCreateRequest.processes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delegatorId, delegateId, startDate, endDate, processes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DelegationRuleCreateRequest {\n");
        sb.append("    delegatorId: ").append(toIndentedString(delegatorId)).append("\n");
        sb.append("    delegateId: ").append(toIndentedString(delegateId)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    processes: ").append(toIndentedString(processes)).append("\n");
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
