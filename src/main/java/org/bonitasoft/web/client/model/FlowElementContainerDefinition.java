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
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Allows to access all flow elements (activities, gateways, events and transitions) of a process or sub-process.
 */
@JsonPropertyOrder({
        FlowElementContainerDefinition.JSON_PROPERTY_ACTIVITIES,
        FlowElementContainerDefinition.JSON_PROPERTY_TRANSITIONS,
        FlowElementContainerDefinition.JSON_PROPERTY_GATEWAYS_LIST,
        FlowElementContainerDefinition.JSON_PROPERTY_START_EVENTS,
        FlowElementContainerDefinition.JSON_PROPERTY_INTERMEDIATE_CATCH_EVENTS,
        FlowElementContainerDefinition.JSON_PROPERTY_INTERMEDIATE_THROW_EVENTS,
        FlowElementContainerDefinition.JSON_PROPERTY_END_EVENTS,
        FlowElementContainerDefinition.JSON_PROPERTY_DATA_DEFINITIONS,
        FlowElementContainerDefinition.JSON_PROPERTY_DOCUMENT_DEFINITIONS,
        FlowElementContainerDefinition.JSON_PROPERTY_CONNECTORS,
        FlowElementContainerDefinition.JSON_PROPERTY_BUSINESS_DATA_DEFINITIONS,
        FlowElementContainerDefinition.JSON_PROPERTY_DOCUMENT_LIST_DEFINITIONS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class FlowElementContainerDefinition implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ACTIVITIES = "activities";
    @jakarta.annotation.Nullable
    private List<Map<String, Object>> activities = new ArrayList<>();

    public static final String JSON_PROPERTY_TRANSITIONS = "transitions";
    @jakarta.annotation.Nullable
    private List<Map<String, Object>> transitions = new ArrayList<>();

    public static final String JSON_PROPERTY_GATEWAYS_LIST = "gatewaysList";
    @jakarta.annotation.Nullable
    private List<Map<String, Object>> gatewaysList = new ArrayList<>();

    public static final String JSON_PROPERTY_START_EVENTS = "startEvents";
    @jakarta.annotation.Nullable
    private List<Map<String, Object>> startEvents = new ArrayList<>();

    public static final String JSON_PROPERTY_INTERMEDIATE_CATCH_EVENTS = "intermediateCatchEvents";
    @jakarta.annotation.Nullable
    private List<Map<String, Object>> intermediateCatchEvents = new ArrayList<>();

    public static final String JSON_PROPERTY_INTERMEDIATE_THROW_EVENTS = "intermediateThrowEvents";
    @jakarta.annotation.Nullable
    private List<Map<String, Object>> intermediateThrowEvents = new ArrayList<>();

    public static final String JSON_PROPERTY_END_EVENTS = "endEvents";
    @jakarta.annotation.Nullable
    private List<Map<String, Object>> endEvents = new ArrayList<>();

    public static final String JSON_PROPERTY_DATA_DEFINITIONS = "dataDefinitions";
    @jakarta.annotation.Nullable
    private List<Map<String, Object>> dataDefinitions = new ArrayList<>();

    public static final String JSON_PROPERTY_DOCUMENT_DEFINITIONS = "documentDefinitions";
    @jakarta.annotation.Nullable
    private List<Map<String, Object>> documentDefinitions = new ArrayList<>();

    public static final String JSON_PROPERTY_CONNECTORS = "connectors";
    @jakarta.annotation.Nullable
    private List<Map<String, Object>> connectors = new ArrayList<>();

    public static final String JSON_PROPERTY_BUSINESS_DATA_DEFINITIONS = "businessDataDefinitions";
    @jakarta.annotation.Nullable
    private List<Map<String, Object>> businessDataDefinitions = new ArrayList<>();

    public static final String JSON_PROPERTY_DOCUMENT_LIST_DEFINITIONS = "documentListDefinitions";
    @jakarta.annotation.Nullable
    private List<Map<String, Object>> documentListDefinitions = new ArrayList<>();

    public FlowElementContainerDefinition() {
    }

    public FlowElementContainerDefinition activities(
            @jakarta.annotation.Nullable List<Map<String, Object>> activities) {

        this.activities = activities;
        return this;
    }

    public FlowElementContainerDefinition addActivitiesItem(Map<String, Object> activitiesItem) {
        if (this.activities == null) {
            this.activities = new ArrayList<>();
        }
        this.activities.add(activitiesItem);
        return this;
    }

    /**
     * Get activities
     * 
     * @return activities
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ACTIVITIES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Map<String, Object>> getActivities() {
        return activities;
    }

    @JsonProperty(JSON_PROPERTY_ACTIVITIES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setActivities(@jakarta.annotation.Nullable List<Map<String, Object>> activities) {
        this.activities = activities;
    }

    public FlowElementContainerDefinition transitions(
            @jakarta.annotation.Nullable List<Map<String, Object>> transitions) {

        this.transitions = transitions;
        return this;
    }

    public FlowElementContainerDefinition addTransitionsItem(Map<String, Object> transitionsItem) {
        if (this.transitions == null) {
            this.transitions = new ArrayList<>();
        }
        this.transitions.add(transitionsItem);
        return this;
    }

    /**
     * Get transitions
     * 
     * @return transitions
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TRANSITIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Map<String, Object>> getTransitions() {
        return transitions;
    }

    @JsonProperty(JSON_PROPERTY_TRANSITIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTransitions(@jakarta.annotation.Nullable List<Map<String, Object>> transitions) {
        this.transitions = transitions;
    }

    public FlowElementContainerDefinition gatewaysList(
            @jakarta.annotation.Nullable List<Map<String, Object>> gatewaysList) {

        this.gatewaysList = gatewaysList;
        return this;
    }

    public FlowElementContainerDefinition addGatewaysListItem(Map<String, Object> gatewaysListItem) {
        if (this.gatewaysList == null) {
            this.gatewaysList = new ArrayList<>();
        }
        this.gatewaysList.add(gatewaysListItem);
        return this;
    }

    /**
     * Get gatewaysList
     * 
     * @return gatewaysList
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_GATEWAYS_LIST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Map<String, Object>> getGatewaysList() {
        return gatewaysList;
    }

    @JsonProperty(JSON_PROPERTY_GATEWAYS_LIST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setGatewaysList(@jakarta.annotation.Nullable List<Map<String, Object>> gatewaysList) {
        this.gatewaysList = gatewaysList;
    }

    public FlowElementContainerDefinition startEvents(
            @jakarta.annotation.Nullable List<Map<String, Object>> startEvents) {

        this.startEvents = startEvents;
        return this;
    }

    public FlowElementContainerDefinition addStartEventsItem(Map<String, Object> startEventsItem) {
        if (this.startEvents == null) {
            this.startEvents = new ArrayList<>();
        }
        this.startEvents.add(startEventsItem);
        return this;
    }

    /**
     * Get startEvents
     * 
     * @return startEvents
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_START_EVENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Map<String, Object>> getStartEvents() {
        return startEvents;
    }

    @JsonProperty(JSON_PROPERTY_START_EVENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStartEvents(@jakarta.annotation.Nullable List<Map<String, Object>> startEvents) {
        this.startEvents = startEvents;
    }

    public FlowElementContainerDefinition intermediateCatchEvents(
            @jakarta.annotation.Nullable List<Map<String, Object>> intermediateCatchEvents) {

        this.intermediateCatchEvents = intermediateCatchEvents;
        return this;
    }

    public FlowElementContainerDefinition addIntermediateCatchEventsItem(
            Map<String, Object> intermediateCatchEventsItem) {
        if (this.intermediateCatchEvents == null) {
            this.intermediateCatchEvents = new ArrayList<>();
        }
        this.intermediateCatchEvents.add(intermediateCatchEventsItem);
        return this;
    }

    /**
     * Get intermediateCatchEvents
     * 
     * @return intermediateCatchEvents
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INTERMEDIATE_CATCH_EVENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Map<String, Object>> getIntermediateCatchEvents() {
        return intermediateCatchEvents;
    }

    @JsonProperty(JSON_PROPERTY_INTERMEDIATE_CATCH_EVENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIntermediateCatchEvents(
            @jakarta.annotation.Nullable List<Map<String, Object>> intermediateCatchEvents) {
        this.intermediateCatchEvents = intermediateCatchEvents;
    }

    public FlowElementContainerDefinition intermediateThrowEvents(
            @jakarta.annotation.Nullable List<Map<String, Object>> intermediateThrowEvents) {

        this.intermediateThrowEvents = intermediateThrowEvents;
        return this;
    }

    public FlowElementContainerDefinition addIntermediateThrowEventsItem(
            Map<String, Object> intermediateThrowEventsItem) {
        if (this.intermediateThrowEvents == null) {
            this.intermediateThrowEvents = new ArrayList<>();
        }
        this.intermediateThrowEvents.add(intermediateThrowEventsItem);
        return this;
    }

    /**
     * Get intermediateThrowEvents
     * 
     * @return intermediateThrowEvents
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INTERMEDIATE_THROW_EVENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Map<String, Object>> getIntermediateThrowEvents() {
        return intermediateThrowEvents;
    }

    @JsonProperty(JSON_PROPERTY_INTERMEDIATE_THROW_EVENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIntermediateThrowEvents(
            @jakarta.annotation.Nullable List<Map<String, Object>> intermediateThrowEvents) {
        this.intermediateThrowEvents = intermediateThrowEvents;
    }

    public FlowElementContainerDefinition endEvents(@jakarta.annotation.Nullable List<Map<String, Object>> endEvents) {

        this.endEvents = endEvents;
        return this;
    }

    public FlowElementContainerDefinition addEndEventsItem(Map<String, Object> endEventsItem) {
        if (this.endEvents == null) {
            this.endEvents = new ArrayList<>();
        }
        this.endEvents.add(endEventsItem);
        return this;
    }

    /**
     * Get endEvents
     * 
     * @return endEvents
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_END_EVENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Map<String, Object>> getEndEvents() {
        return endEvents;
    }

    @JsonProperty(JSON_PROPERTY_END_EVENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEndEvents(@jakarta.annotation.Nullable List<Map<String, Object>> endEvents) {
        this.endEvents = endEvents;
    }

    public FlowElementContainerDefinition dataDefinitions(
            @jakarta.annotation.Nullable List<Map<String, Object>> dataDefinitions) {

        this.dataDefinitions = dataDefinitions;
        return this;
    }

    public FlowElementContainerDefinition addDataDefinitionsItem(Map<String, Object> dataDefinitionsItem) {
        if (this.dataDefinitions == null) {
            this.dataDefinitions = new ArrayList<>();
        }
        this.dataDefinitions.add(dataDefinitionsItem);
        return this;
    }

    /**
     * Get dataDefinitions
     * 
     * @return dataDefinitions
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DATA_DEFINITIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Map<String, Object>> getDataDefinitions() {
        return dataDefinitions;
    }

    @JsonProperty(JSON_PROPERTY_DATA_DEFINITIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDataDefinitions(@jakarta.annotation.Nullable List<Map<String, Object>> dataDefinitions) {
        this.dataDefinitions = dataDefinitions;
    }

    public FlowElementContainerDefinition documentDefinitions(
            @jakarta.annotation.Nullable List<Map<String, Object>> documentDefinitions) {

        this.documentDefinitions = documentDefinitions;
        return this;
    }

    public FlowElementContainerDefinition addDocumentDefinitionsItem(Map<String, Object> documentDefinitionsItem) {
        if (this.documentDefinitions == null) {
            this.documentDefinitions = new ArrayList<>();
        }
        this.documentDefinitions.add(documentDefinitionsItem);
        return this;
    }

    /**
     * Get documentDefinitions
     * 
     * @return documentDefinitions
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DOCUMENT_DEFINITIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Map<String, Object>> getDocumentDefinitions() {
        return documentDefinitions;
    }

    @JsonProperty(JSON_PROPERTY_DOCUMENT_DEFINITIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDocumentDefinitions(@jakarta.annotation.Nullable List<Map<String, Object>> documentDefinitions) {
        this.documentDefinitions = documentDefinitions;
    }

    public FlowElementContainerDefinition connectors(
            @jakarta.annotation.Nullable List<Map<String, Object>> connectors) {

        this.connectors = connectors;
        return this;
    }

    public FlowElementContainerDefinition addConnectorsItem(Map<String, Object> connectorsItem) {
        if (this.connectors == null) {
            this.connectors = new ArrayList<>();
        }
        this.connectors.add(connectorsItem);
        return this;
    }

    /**
     * Get connectors
     * 
     * @return connectors
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONNECTORS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Map<String, Object>> getConnectors() {
        return connectors;
    }

    @JsonProperty(JSON_PROPERTY_CONNECTORS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setConnectors(@jakarta.annotation.Nullable List<Map<String, Object>> connectors) {
        this.connectors = connectors;
    }

    public FlowElementContainerDefinition businessDataDefinitions(
            @jakarta.annotation.Nullable List<Map<String, Object>> businessDataDefinitions) {

        this.businessDataDefinitions = businessDataDefinitions;
        return this;
    }

    public FlowElementContainerDefinition addBusinessDataDefinitionsItem(
            Map<String, Object> businessDataDefinitionsItem) {
        if (this.businessDataDefinitions == null) {
            this.businessDataDefinitions = new ArrayList<>();
        }
        this.businessDataDefinitions.add(businessDataDefinitionsItem);
        return this;
    }

    /**
     * Get businessDataDefinitions
     * 
     * @return businessDataDefinitions
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_BUSINESS_DATA_DEFINITIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Map<String, Object>> getBusinessDataDefinitions() {
        return businessDataDefinitions;
    }

    @JsonProperty(JSON_PROPERTY_BUSINESS_DATA_DEFINITIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBusinessDataDefinitions(
            @jakarta.annotation.Nullable List<Map<String, Object>> businessDataDefinitions) {
        this.businessDataDefinitions = businessDataDefinitions;
    }

    public FlowElementContainerDefinition documentListDefinitions(
            @jakarta.annotation.Nullable List<Map<String, Object>> documentListDefinitions) {

        this.documentListDefinitions = documentListDefinitions;
        return this;
    }

    public FlowElementContainerDefinition addDocumentListDefinitionsItem(
            Map<String, Object> documentListDefinitionsItem) {
        if (this.documentListDefinitions == null) {
            this.documentListDefinitions = new ArrayList<>();
        }
        this.documentListDefinitions.add(documentListDefinitionsItem);
        return this;
    }

    /**
     * Get documentListDefinitions
     * 
     * @return documentListDefinitions
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DOCUMENT_LIST_DEFINITIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Map<String, Object>> getDocumentListDefinitions() {
        return documentListDefinitions;
    }

    @JsonProperty(JSON_PROPERTY_DOCUMENT_LIST_DEFINITIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDocumentListDefinitions(
            @jakarta.annotation.Nullable List<Map<String, Object>> documentListDefinitions) {
        this.documentListDefinitions = documentListDefinitions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FlowElementContainerDefinition flowElementContainerDefinition = (FlowElementContainerDefinition) o;
        return Objects.equals(this.activities, flowElementContainerDefinition.activities) &&
                Objects.equals(this.transitions, flowElementContainerDefinition.transitions) &&
                Objects.equals(this.gatewaysList, flowElementContainerDefinition.gatewaysList) &&
                Objects.equals(this.startEvents, flowElementContainerDefinition.startEvents) &&
                Objects.equals(this.intermediateCatchEvents, flowElementContainerDefinition.intermediateCatchEvents) &&
                Objects.equals(this.intermediateThrowEvents, flowElementContainerDefinition.intermediateThrowEvents) &&
                Objects.equals(this.endEvents, flowElementContainerDefinition.endEvents) &&
                Objects.equals(this.dataDefinitions, flowElementContainerDefinition.dataDefinitions) &&
                Objects.equals(this.documentDefinitions, flowElementContainerDefinition.documentDefinitions) &&
                Objects.equals(this.connectors, flowElementContainerDefinition.connectors) &&
                Objects.equals(this.businessDataDefinitions, flowElementContainerDefinition.businessDataDefinitions) &&
                Objects.equals(this.documentListDefinitions, flowElementContainerDefinition.documentListDefinitions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activities, transitions, gatewaysList, startEvents, intermediateCatchEvents,
                intermediateThrowEvents, endEvents, dataDefinitions, documentDefinitions, connectors,
                businessDataDefinitions, documentListDefinitions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FlowElementContainerDefinition {\n");
        sb.append("    activities: ").append(toIndentedString(activities)).append("\n");
        sb.append("    transitions: ").append(toIndentedString(transitions)).append("\n");
        sb.append("    gatewaysList: ").append(toIndentedString(gatewaysList)).append("\n");
        sb.append("    startEvents: ").append(toIndentedString(startEvents)).append("\n");
        sb.append("    intermediateCatchEvents: ").append(toIndentedString(intermediateCatchEvents)).append("\n");
        sb.append("    intermediateThrowEvents: ").append(toIndentedString(intermediateThrowEvents)).append("\n");
        sb.append("    endEvents: ").append(toIndentedString(endEvents)).append("\n");
        sb.append("    dataDefinitions: ").append(toIndentedString(dataDefinitions)).append("\n");
        sb.append("    documentDefinitions: ").append(toIndentedString(documentDefinitions)).append("\n");
        sb.append("    connectors: ").append(toIndentedString(connectors)).append("\n");
        sb.append("    businessDataDefinitions: ").append(toIndentedString(businessDataDefinitions)).append("\n");
        sb.append("    documentListDefinitions: ").append(toIndentedString(documentListDefinitions)).append("\n");
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
