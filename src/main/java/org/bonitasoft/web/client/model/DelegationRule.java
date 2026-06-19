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
 * A task delegation rule: a user (the delegator) grants another user (the delegate) the ability to see and execute the delegator&#39;s human tasks during a
 * bounded period, for a whitelist of processes. Delegation is not reassignment: tasks stay assigned to the delegator, and the delegate only gains visibility
 * and execution rights through dedicated views. A user can hold at most one delegation rule at a time.
 */
@JsonPropertyOrder({
        DelegationRule.JSON_PROPERTY_ID,
        DelegationRule.JSON_PROPERTY_DELEGATOR,
        DelegationRule.JSON_PROPERTY_DELEGATE,
        DelegationRule.JSON_PROPERTY_START_DATE,
        DelegationRule.JSON_PROPERTY_END_DATE,
        DelegationRule.JSON_PROPERTY_PROCESSES,
        DelegationRule.JSON_PROPERTY_STATUS,
        DelegationRule.JSON_PROPERTY_LAST_UPDATED_BY,
        DelegationRule.JSON_PROPERTY_LAST_UPDATED_AT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class DelegationRule implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    @jakarta.annotation.Nonnull
    private String id;

    public static final String JSON_PROPERTY_DELEGATOR = "delegator";
    @jakarta.annotation.Nonnull
    private DelegationUser delegator;

    public static final String JSON_PROPERTY_DELEGATE = "delegate";
    @jakarta.annotation.Nonnull
    private DelegationUser delegate;

    public static final String JSON_PROPERTY_START_DATE = "startDate";
    @jakarta.annotation.Nonnull
    private Long startDate;

    public static final String JSON_PROPERTY_END_DATE = "endDate";
    @jakarta.annotation.Nonnull
    private Long endDate;

    public static final String JSON_PROPERTY_PROCESSES = "processes";
    @jakarta.annotation.Nonnull
    private List<String> processes = new ArrayList<>();

    public static final String JSON_PROPERTY_STATUS = "status";
    @jakarta.annotation.Nonnull
    private DelegationStatus status;

    public static final String JSON_PROPERTY_LAST_UPDATED_BY = "lastUpdatedBy";
    @jakarta.annotation.Nonnull
    private DelegationUser lastUpdatedBy;

    public static final String JSON_PROPERTY_LAST_UPDATED_AT = "lastUpdatedAt";
    @jakarta.annotation.Nonnull
    private Long lastUpdatedAt;

    public DelegationRule() {
    }

    public DelegationRule id(@jakarta.annotation.Nonnull String id) {

        this.id = id;
        return this;
    }

    /**
     * Identifier of the delegation rule. Serialized as a string to avoid JavaScript precision loss on large &#x60;long&#x60; values.
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

    public DelegationRule delegator(@jakarta.annotation.Nonnull DelegationUser delegator) {

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

    public DelegationRule delegate(@jakarta.annotation.Nonnull DelegationUser delegate) {

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

    public DelegationRule startDate(@jakarta.annotation.Nonnull Long startDate) {

        this.startDate = startDate;
        return this;
    }

    /**
     * Start of the delegation period, inclusive, in milliseconds since epoch.
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

    public DelegationRule endDate(@jakarta.annotation.Nonnull Long endDate) {

        this.endDate = endDate;
        return this;
    }

    /**
     * End of the delegation period, inclusive, in milliseconds since epoch.
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

    public DelegationRule processes(@jakarta.annotation.Nonnull List<String> processes) {

        this.processes = processes;
        return this;
    }

    public DelegationRule addProcessesItem(String processesItem) {
        if (this.processes == null) {
            this.processes = new ArrayList<>();
        }
        this.processes.add(processesItem);
        return this;
    }

    /**
     * Process whitelist for this rule. Each entry is a process name; a name covers every deployed version of that process. Always contains at least one entry.
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

    public DelegationRule status(@jakarta.annotation.Nonnull DelegationStatus status) {

        this.status = status;
        return this;
    }

    /**
     * Get status
     * 
     * @return status
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public DelegationStatus getStatus() {
        return status;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setStatus(@jakarta.annotation.Nonnull DelegationStatus status) {
        this.status = status;
    }

    public DelegationRule lastUpdatedBy(@jakarta.annotation.Nonnull DelegationUser lastUpdatedBy) {

        this.lastUpdatedBy = lastUpdatedBy;
        return this;
    }

    /**
     * Get lastUpdatedBy
     * 
     * @return lastUpdatedBy
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_LAST_UPDATED_BY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public DelegationUser getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    @JsonProperty(JSON_PROPERTY_LAST_UPDATED_BY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setLastUpdatedBy(@jakarta.annotation.Nonnull DelegationUser lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public DelegationRule lastUpdatedAt(@jakarta.annotation.Nonnull Long lastUpdatedAt) {

        this.lastUpdatedAt = lastUpdatedAt;
        return this;
    }

    /**
     * Timestamp of the last modification, in milliseconds since epoch.
     * 
     * @return lastUpdatedAt
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_LAST_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Long getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    @JsonProperty(JSON_PROPERTY_LAST_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setLastUpdatedAt(@jakarta.annotation.Nonnull Long lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DelegationRule delegationRule = (DelegationRule) o;
        return Objects.equals(this.id, delegationRule.id) &&
                Objects.equals(this.delegator, delegationRule.delegator) &&
                Objects.equals(this.delegate, delegationRule.delegate) &&
                Objects.equals(this.startDate, delegationRule.startDate) &&
                Objects.equals(this.endDate, delegationRule.endDate) &&
                Objects.equals(this.processes, delegationRule.processes) &&
                Objects.equals(this.status, delegationRule.status) &&
                Objects.equals(this.lastUpdatedBy, delegationRule.lastUpdatedBy) &&
                Objects.equals(this.lastUpdatedAt, delegationRule.lastUpdatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, delegator, delegate, startDate, endDate, processes, status, lastUpdatedBy,
                lastUpdatedAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DelegationRule {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    delegator: ").append(toIndentedString(delegator)).append("\n");
        sb.append("    delegate: ").append(toIndentedString(delegate)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    processes: ").append(toIndentedString(processes)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    lastUpdatedBy: ").append(toIndentedString(lastUpdatedBy)).append("\n");
        sb.append("    lastUpdatedAt: ").append(toIndentedString(lastUpdatedAt)).append("\n");
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
