/** 
 * Copyright (C) 2022 BonitaSoft S.A.
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
 * Retrieves the execution data of all open cases of a process. It returns counters for each flow node in the process, showing the number of flow node instances
 * that are in an non-final state (possible states are: ready, executing, waiting, initializing, failed, completing). If there are no flow node instances in a
 * given state, no counter is returned for that state for the flow node.
 */
@JsonPropertyOrder({
        ProcessInfo.JSON_PROPERTY_PROCESS_DEFINITION_ID,
        ProcessInfo.JSON_PROPERTY_FLOW_NODE_STATES_COUNTERS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ProcessInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_PROCESS_DEFINITION_ID = "processDefinitionId";
    private String processDefinitionId;

    public static final String JSON_PROPERTY_FLOW_NODE_STATES_COUNTERS = "flowNodeStatesCounters";
    private Map<String, ProcessInfoFlowNodeStatesCountersValue> flowNodeStatesCounters = new HashMap<>();

    public ProcessInfo() {
    }

    public ProcessInfo processDefinitionId(String processDefinitionId) {

        this.processDefinitionId = processDefinitionId;
        return this;
    }

    /**
     * process identifier
     * 
     * @return processDefinitionId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PROCESS_DEFINITION_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    @JsonProperty(JSON_PROPERTY_PROCESS_DEFINITION_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public ProcessInfo flowNodeStatesCounters(
            Map<String, ProcessInfoFlowNodeStatesCountersValue> flowNodeStatesCounters) {

        this.flowNodeStatesCounters = flowNodeStatesCounters;
        return this;
    }

    public ProcessInfo putFlowNodeStatesCountersItem(String key,
            ProcessInfoFlowNodeStatesCountersValue flowNodeStatesCountersItem) {
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
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FLOW_NODE_STATES_COUNTERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Map<String, ProcessInfoFlowNodeStatesCountersValue> getFlowNodeStatesCounters() {
        return flowNodeStatesCounters;
    }

    @JsonProperty(JSON_PROPERTY_FLOW_NODE_STATES_COUNTERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFlowNodeStatesCounters(Map<String, ProcessInfoFlowNodeStatesCountersValue> flowNodeStatesCounters) {
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
        ProcessInfo processInfo = (ProcessInfo) o;
        return Objects.equals(this.processDefinitionId, processInfo.processDefinitionId) &&
                Objects.equals(this.flowNodeStatesCounters, processInfo.flowNodeStatesCounters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(processDefinitionId, flowNodeStatesCounters);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessInfo {\n");
        sb.append("    processDefinitionId: ").append(toIndentedString(processDefinitionId)).append("\n");
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
