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
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * ProcessInstanceInfoFlowNodeStatesCountersValue
 */
@JsonPropertyOrder({
        ProcessInstanceInfoFlowNodeStatesCountersValue.JSON_PROPERTY_COMPLETED,
        ProcessInstanceInfoFlowNodeStatesCountersValue.JSON_PROPERTY_SKIPPED,
        ProcessInstanceInfoFlowNodeStatesCountersValue.JSON_PROPERTY_CANCELLED,
        ProcessInstanceInfoFlowNodeStatesCountersValue.JSON_PROPERTY_ABORTED,
        ProcessInstanceInfoFlowNodeStatesCountersValue.JSON_PROPERTY_READY,
        ProcessInstanceInfoFlowNodeStatesCountersValue.JSON_PROPERTY_FAILED,
        ProcessInstanceInfoFlowNodeStatesCountersValue.JSON_PROPERTY_EXECUTING,
        ProcessInstanceInfoFlowNodeStatesCountersValue.JSON_PROPERTY_WAITING,
        ProcessInstanceInfoFlowNodeStatesCountersValue.JSON_PROPERTY_INITIALIZING,
        ProcessInstanceInfoFlowNodeStatesCountersValue.JSON_PROPERTY_COMPLETING
})
@JsonTypeName("ProcessInstanceInfo_flowNodeStatesCounters_value")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class ProcessInstanceInfoFlowNodeStatesCountersValue implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_COMPLETED = "completed";
    @jakarta.annotation.Nullable
    private Long completed;

    public static final String JSON_PROPERTY_SKIPPED = "skipped";
    @jakarta.annotation.Nullable
    private Long skipped;

    public static final String JSON_PROPERTY_CANCELLED = "cancelled";
    @jakarta.annotation.Nullable
    private Long cancelled;

    public static final String JSON_PROPERTY_ABORTED = "aborted";
    @jakarta.annotation.Nullable
    private Long aborted;

    public static final String JSON_PROPERTY_READY = "ready";
    @jakarta.annotation.Nullable
    private Long ready;

    public static final String JSON_PROPERTY_FAILED = "failed";
    @jakarta.annotation.Nullable
    private Long failed;

    public static final String JSON_PROPERTY_EXECUTING = "executing";
    @jakarta.annotation.Nullable
    private Long executing;

    public static final String JSON_PROPERTY_WAITING = "waiting";
    @jakarta.annotation.Nullable
    private Long waiting;

    public static final String JSON_PROPERTY_INITIALIZING = "initializing";
    @jakarta.annotation.Nullable
    private Long initializing;

    public static final String JSON_PROPERTY_COMPLETING = "completing";
    @jakarta.annotation.Nullable
    private Long completing;

    public ProcessInstanceInfoFlowNodeStatesCountersValue() {
    }

    public ProcessInstanceInfoFlowNodeStatesCountersValue completed(@jakarta.annotation.Nullable Long completed) {

        this.completed = completed;
        return this;
    }

    /**
     * number of instance of the given Flow Node in completed state
     * 
     * @return completed
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_COMPLETED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getCompleted() {
        return completed;
    }

    @JsonProperty(JSON_PROPERTY_COMPLETED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCompleted(@jakarta.annotation.Nullable Long completed) {
        this.completed = completed;
    }

    public ProcessInstanceInfoFlowNodeStatesCountersValue skipped(@jakarta.annotation.Nullable Long skipped) {

        this.skipped = skipped;
        return this;
    }

    /**
     * number of instance of the given Flow Node in skipped state
     * 
     * @return skipped
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SKIPPED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getSkipped() {
        return skipped;
    }

    @JsonProperty(JSON_PROPERTY_SKIPPED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSkipped(@jakarta.annotation.Nullable Long skipped) {
        this.skipped = skipped;
    }

    public ProcessInstanceInfoFlowNodeStatesCountersValue cancelled(@jakarta.annotation.Nullable Long cancelled) {

        this.cancelled = cancelled;
        return this;
    }

    /**
     * number of instance of the given Flow Node in cancelled state
     * 
     * @return cancelled
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CANCELLED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getCancelled() {
        return cancelled;
    }

    @JsonProperty(JSON_PROPERTY_CANCELLED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCancelled(@jakarta.annotation.Nullable Long cancelled) {
        this.cancelled = cancelled;
    }

    public ProcessInstanceInfoFlowNodeStatesCountersValue aborted(@jakarta.annotation.Nullable Long aborted) {

        this.aborted = aborted;
        return this;
    }

    /**
     * number of instance of the given Flow Node in aborted state
     * 
     * @return aborted
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ABORTED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getAborted() {
        return aborted;
    }

    @JsonProperty(JSON_PROPERTY_ABORTED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAborted(@jakarta.annotation.Nullable Long aborted) {
        this.aborted = aborted;
    }

    public ProcessInstanceInfoFlowNodeStatesCountersValue ready(@jakarta.annotation.Nullable Long ready) {

        this.ready = ready;
        return this;
    }

    /**
     * number of instance of the given Flow Node in ready state
     * 
     * @return ready
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_READY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getReady() {
        return ready;
    }

    @JsonProperty(JSON_PROPERTY_READY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReady(@jakarta.annotation.Nullable Long ready) {
        this.ready = ready;
    }

    public ProcessInstanceInfoFlowNodeStatesCountersValue failed(@jakarta.annotation.Nullable Long failed) {

        this.failed = failed;
        return this;
    }

    /**
     * number of instance of the given Flow Node in failed state
     * 
     * @return failed
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FAILED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getFailed() {
        return failed;
    }

    @JsonProperty(JSON_PROPERTY_FAILED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFailed(@jakarta.annotation.Nullable Long failed) {
        this.failed = failed;
    }

    public ProcessInstanceInfoFlowNodeStatesCountersValue executing(@jakarta.annotation.Nullable Long executing) {

        this.executing = executing;
        return this;
    }

    /**
     * number of instance of the given Flow Node in executing state
     * 
     * @return executing
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EXECUTING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getExecuting() {
        return executing;
    }

    @JsonProperty(JSON_PROPERTY_EXECUTING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setExecuting(@jakarta.annotation.Nullable Long executing) {
        this.executing = executing;
    }

    public ProcessInstanceInfoFlowNodeStatesCountersValue waiting(@jakarta.annotation.Nullable Long waiting) {

        this.waiting = waiting;
        return this;
    }

    /**
     * number of instance of the given Flow Node in waiting state
     * 
     * @return waiting
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_WAITING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getWaiting() {
        return waiting;
    }

    @JsonProperty(JSON_PROPERTY_WAITING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setWaiting(@jakarta.annotation.Nullable Long waiting) {
        this.waiting = waiting;
    }

    public ProcessInstanceInfoFlowNodeStatesCountersValue initializing(@jakarta.annotation.Nullable Long initializing) {

        this.initializing = initializing;
        return this;
    }

    /**
     * number of instance of the given Flow Node in initializing state
     * 
     * @return initializing
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INITIALIZING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getInitializing() {
        return initializing;
    }

    @JsonProperty(JSON_PROPERTY_INITIALIZING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInitializing(@jakarta.annotation.Nullable Long initializing) {
        this.initializing = initializing;
    }

    public ProcessInstanceInfoFlowNodeStatesCountersValue completing(@jakarta.annotation.Nullable Long completing) {

        this.completing = completing;
        return this;
    }

    /**
     * number of instance of the given Flow Node in completing state
     * 
     * @return completing
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_COMPLETING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getCompleting() {
        return completing;
    }

    @JsonProperty(JSON_PROPERTY_COMPLETING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCompleting(@jakarta.annotation.Nullable Long completing) {
        this.completing = completing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProcessInstanceInfoFlowNodeStatesCountersValue processInstanceInfoFlowNodeStatesCountersValue = (ProcessInstanceInfoFlowNodeStatesCountersValue) o;
        return Objects.equals(this.completed, processInstanceInfoFlowNodeStatesCountersValue.completed) &&
                Objects.equals(this.skipped, processInstanceInfoFlowNodeStatesCountersValue.skipped) &&
                Objects.equals(this.cancelled, processInstanceInfoFlowNodeStatesCountersValue.cancelled) &&
                Objects.equals(this.aborted, processInstanceInfoFlowNodeStatesCountersValue.aborted) &&
                Objects.equals(this.ready, processInstanceInfoFlowNodeStatesCountersValue.ready) &&
                Objects.equals(this.failed, processInstanceInfoFlowNodeStatesCountersValue.failed) &&
                Objects.equals(this.executing, processInstanceInfoFlowNodeStatesCountersValue.executing) &&
                Objects.equals(this.waiting, processInstanceInfoFlowNodeStatesCountersValue.waiting) &&
                Objects.equals(this.initializing, processInstanceInfoFlowNodeStatesCountersValue.initializing) &&
                Objects.equals(this.completing, processInstanceInfoFlowNodeStatesCountersValue.completing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(completed, skipped, cancelled, aborted, ready, failed, executing, waiting, initializing,
                completing);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessInstanceInfoFlowNodeStatesCountersValue {\n");
        sb.append("    completed: ").append(toIndentedString(completed)).append("\n");
        sb.append("    skipped: ").append(toIndentedString(skipped)).append("\n");
        sb.append("    cancelled: ").append(toIndentedString(cancelled)).append("\n");
        sb.append("    aborted: ").append(toIndentedString(aborted)).append("\n");
        sb.append("    ready: ").append(toIndentedString(ready)).append("\n");
        sb.append("    failed: ").append(toIndentedString(failed)).append("\n");
        sb.append("    executing: ").append(toIndentedString(executing)).append("\n");
        sb.append("    waiting: ").append(toIndentedString(waiting)).append("\n");
        sb.append("    initializing: ").append(toIndentedString(initializing)).append("\n");
        sb.append("    completing: ").append(toIndentedString(completing)).append("\n");
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
