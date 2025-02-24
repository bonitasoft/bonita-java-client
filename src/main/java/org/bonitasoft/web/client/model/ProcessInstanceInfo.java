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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Retrieves information about a process instances. It returns counters for each flow node in the process instances, showing the number of flow node instances
 * that are in each state (possible states are: ready, executing, waiting, initializing, failed, completing, completed, skipped, cancelled, aborted). If there
 * are no flow node instances in a given state, no counter is returned for that state for the flow node.
 */
@JsonPropertyOrder({
        ProcessInstanceInfo.JSON_PROPERTY_ID,
        ProcessInstanceInfo.JSON_PROPERTY_FLOW_NODE_STATES_COUNTERS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class ProcessInstanceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    @jakarta.annotation.Nullable
    private String id;

    public static final String JSON_PROPERTY_FLOW_NODE_STATES_COUNTERS = "flowNodeStatesCounters";
    @jakarta.annotation.Nullable
    private Map<String, ProcessInstanceInfoFlowNodeStatesCountersValue> flowNodeStatesCounters = new HashMap<>();

    public ProcessInstanceInfo() {
    }

    public ProcessInstanceInfo id(@jakarta.annotation.Nullable String id) {

        this.id = id;
        return this;
    }

    /**
     * case identifier
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

    public ProcessInstanceInfo flowNodeStatesCounters(
            @jakarta.annotation.Nullable Map<String, ProcessInstanceInfoFlowNodeStatesCountersValue> flowNodeStatesCounters) {

        this.flowNodeStatesCounters = flowNodeStatesCounters;
        return this;
    }

    public ProcessInstanceInfo putFlowNodeStatesCountersItem(String key,
            ProcessInstanceInfoFlowNodeStatesCountersValue flowNodeStatesCountersItem) {
        if (this.flowNodeStatesCounters == null) {
            this.flowNodeStatesCounters = new HashMap<>();
        }
        this.flowNodeStatesCounters.put(key, flowNodeStatesCountersItem);
        return this;
    }

    /**
     * flow nodes counters
     * 
     * @return flowNodeStatesCounters
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FLOW_NODE_STATES_COUNTERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Map<String, ProcessInstanceInfoFlowNodeStatesCountersValue> getFlowNodeStatesCounters() {
        return flowNodeStatesCounters;
    }

    @JsonProperty(JSON_PROPERTY_FLOW_NODE_STATES_COUNTERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFlowNodeStatesCounters(
            @jakarta.annotation.Nullable Map<String, ProcessInstanceInfoFlowNodeStatesCountersValue> flowNodeStatesCounters) {
        this.flowNodeStatesCounters = flowNodeStatesCounters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProcessInstanceInfo processInstanceInfo = (ProcessInstanceInfo) o;
        return Objects.equals(this.id, processInstanceInfo.id) &&
                Objects.equals(this.flowNodeStatesCounters, processInstanceInfo.flowNodeStatesCounters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flowNodeStatesCounters);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessInstanceInfo {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    flowNodeStatesCounters: ").append(toIndentedString(flowNodeStatesCounters)).append("\n");
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
