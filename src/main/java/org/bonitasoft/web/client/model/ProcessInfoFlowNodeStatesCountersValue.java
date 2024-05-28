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
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * ProcessInfoFlowNodeStatesCountersValue
 */
@JsonPropertyOrder({
        ProcessInfoFlowNodeStatesCountersValue.JSON_PROPERTY_READY,
        ProcessInfoFlowNodeStatesCountersValue.JSON_PROPERTY_FAILED,
        ProcessInfoFlowNodeStatesCountersValue.JSON_PROPERTY_EXECUTING,
        ProcessInfoFlowNodeStatesCountersValue.JSON_PROPERTY_WAITING,
        ProcessInfoFlowNodeStatesCountersValue.JSON_PROPERTY_INITIALIZING,
        ProcessInfoFlowNodeStatesCountersValue.JSON_PROPERTY_COMPLETING
})
@JsonTypeName("ProcessInfo_flowNodeStatesCounters_value")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class ProcessInfoFlowNodeStatesCountersValue implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_READY = "ready";
    private Long ready;

    public static final String JSON_PROPERTY_FAILED = "failed";
    private Long failed;

    public static final String JSON_PROPERTY_EXECUTING = "executing";
    private Long executing;

    public static final String JSON_PROPERTY_WAITING = "waiting";
    private Long waiting;

    public static final String JSON_PROPERTY_INITIALIZING = "initializing";
    private Long initializing;

    public static final String JSON_PROPERTY_COMPLETING = "completing";
    private Long completing;

    public ProcessInfoFlowNodeStatesCountersValue() {
    }

    public ProcessInfoFlowNodeStatesCountersValue ready(Long ready) {

        this.ready = ready;
        return this;
    }

    /**
     * number of instance of the given Flow Node in ready state
     * 
     * @return ready
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_READY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getReady() {
        return ready;
    }

    @JsonProperty(JSON_PROPERTY_READY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReady(Long ready) {
        this.ready = ready;
    }

    public ProcessInfoFlowNodeStatesCountersValue failed(Long failed) {

        this.failed = failed;
        return this;
    }

    /**
     * number of instance of the given Flow Node in failed state
     * 
     * @return failed
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FAILED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getFailed() {
        return failed;
    }

    @JsonProperty(JSON_PROPERTY_FAILED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFailed(Long failed) {
        this.failed = failed;
    }

    public ProcessInfoFlowNodeStatesCountersValue executing(Long executing) {

        this.executing = executing;
        return this;
    }

    /**
     * number of instance of the given Flow Node in executing state
     * 
     * @return executing
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EXECUTING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getExecuting() {
        return executing;
    }

    @JsonProperty(JSON_PROPERTY_EXECUTING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setExecuting(Long executing) {
        this.executing = executing;
    }

    public ProcessInfoFlowNodeStatesCountersValue waiting(Long waiting) {

        this.waiting = waiting;
        return this;
    }

    /**
     * number of instance of the given Flow Node in waiting state
     * 
     * @return waiting
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_WAITING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getWaiting() {
        return waiting;
    }

    @JsonProperty(JSON_PROPERTY_WAITING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setWaiting(Long waiting) {
        this.waiting = waiting;
    }

    public ProcessInfoFlowNodeStatesCountersValue initializing(Long initializing) {

        this.initializing = initializing;
        return this;
    }

    /**
     * number of instance of the given Flow Node in initializing state
     * 
     * @return initializing
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INITIALIZING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getInitializing() {
        return initializing;
    }

    @JsonProperty(JSON_PROPERTY_INITIALIZING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInitializing(Long initializing) {
        this.initializing = initializing;
    }

    public ProcessInfoFlowNodeStatesCountersValue completing(Long completing) {

        this.completing = completing;
        return this;
    }

    /**
     * number of instance of the given Flow Node in completing state
     * 
     * @return completing
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_COMPLETING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getCompleting() {
        return completing;
    }

    @JsonProperty(JSON_PROPERTY_COMPLETING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCompleting(Long completing) {
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
        ProcessInfoFlowNodeStatesCountersValue processInfoFlowNodeStatesCountersValue = (ProcessInfoFlowNodeStatesCountersValue) o;
        return Objects.equals(this.ready, processInfoFlowNodeStatesCountersValue.ready) &&
                Objects.equals(this.failed, processInfoFlowNodeStatesCountersValue.failed) &&
                Objects.equals(this.executing, processInfoFlowNodeStatesCountersValue.executing) &&
                Objects.equals(this.waiting, processInfoFlowNodeStatesCountersValue.waiting) &&
                Objects.equals(this.initializing, processInfoFlowNodeStatesCountersValue.initializing) &&
                Objects.equals(this.completing, processInfoFlowNodeStatesCountersValue.completing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ready, failed, executing, waiting, initializing, completing);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessInfoFlowNodeStatesCountersValue {\n");
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
