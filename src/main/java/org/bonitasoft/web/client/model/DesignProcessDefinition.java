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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Represents the Design Definition of a process. It gives access to process attributes.
 */
@JsonPropertyOrder({
        DesignProcessDefinition.JSON_PROPERTY_DISPLAY_NAME,
        DesignProcessDefinition.JSON_PROPERTY_DISPLAY_DESCRIPTION,
        DesignProcessDefinition.JSON_PROPERTY_FLOW_ELEMENT_CONTAINER,
        DesignProcessDefinition.JSON_PROPERTY_PARAMETERS,
        DesignProcessDefinition.JSON_PROPERTY_ACTORS_LIST,
        DesignProcessDefinition.JSON_PROPERTY_ACTOR_INITIATOR,
        DesignProcessDefinition.JSON_PROPERTY_STRING_INDEX_LABELS,
        DesignProcessDefinition.JSON_PROPERTY_STRING_INDEX_VALUES,
        DesignProcessDefinition.JSON_PROPERTY_CONTRACT,
        DesignProcessDefinition.JSON_PROPERTY_CONTEXT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class DesignProcessDefinition implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    private String displayName;

    public static final String JSON_PROPERTY_DISPLAY_DESCRIPTION = "displayDescription";
    private String displayDescription;

    public static final String JSON_PROPERTY_FLOW_ELEMENT_CONTAINER = "flowElementContainer";
    private FlowElementContainerDefinition flowElementContainer;

    public static final String JSON_PROPERTY_PARAMETERS = "parameters";
    private List<DesignProcessDefinitionParamater> parameters;

    public static final String JSON_PROPERTY_ACTORS_LIST = "actorsList";
    private List<ActorDefinition> actorsList;

    public static final String JSON_PROPERTY_ACTOR_INITIATOR = "actorInitiator";
    private ActorDefinition actorInitiator;

    public static final String JSON_PROPERTY_STRING_INDEX_LABELS = "stringIndexLabels";
    private List<String> stringIndexLabels;

    public static final String JSON_PROPERTY_STRING_INDEX_VALUES = "stringIndexValues";
    private List<Expression> stringIndexValues;

    public static final String JSON_PROPERTY_CONTRACT = "contract";
    private Contract contract;

    public static final String JSON_PROPERTY_CONTEXT = "context";
    private List<DesignProcessDefinitionContext> context;

    public DesignProcessDefinition() {
    }

    public DesignProcessDefinition displayName(String displayName) {

        this.displayName = displayName;
        return this;
    }

    /**
     * The process definition display name
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

    public DesignProcessDefinition displayDescription(String displayDescription) {

        this.displayDescription = displayDescription;
        return this;
    }

    /**
     * The process definition display description name
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

    public DesignProcessDefinition flowElementContainer(FlowElementContainerDefinition flowElementContainer) {

        this.flowElementContainer = flowElementContainer;
        return this;
    }

    /**
     * Get flowElementContainer
     * 
     * @return flowElementContainer
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FLOW_ELEMENT_CONTAINER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public FlowElementContainerDefinition getFlowElementContainer() {
        return flowElementContainer;
    }

    @JsonProperty(JSON_PROPERTY_FLOW_ELEMENT_CONTAINER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFlowElementContainer(FlowElementContainerDefinition flowElementContainer) {
        this.flowElementContainer = flowElementContainer;
    }

    public DesignProcessDefinition parameters(List<DesignProcessDefinitionParamater> parameters) {

        this.parameters = parameters;
        return this;
    }

    public DesignProcessDefinition addParametersItem(DesignProcessDefinitionParamater parametersItem) {
        if (this.parameters == null) {
            this.parameters = new ArrayList<>();
        }
        this.parameters.add(parametersItem);
        return this;
    }

    /**
     * The process parameter definitions
     * 
     * @return parameters
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PARAMETERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<DesignProcessDefinitionParamater> getParameters() {
        return parameters;
    }

    @JsonProperty(JSON_PROPERTY_PARAMETERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setParameters(List<DesignProcessDefinitionParamater> parameters) {
        this.parameters = parameters;
    }

    public DesignProcessDefinition actorsList(List<ActorDefinition> actorsList) {

        this.actorsList = actorsList;
        return this;
    }

    public DesignProcessDefinition addActorsListItem(ActorDefinition actorsListItem) {
        if (this.actorsList == null) {
            this.actorsList = new ArrayList<>();
        }
        this.actorsList.add(actorsListItem);
        return this;
    }

    /**
     * The list of process actor definitions
     * 
     * @return actorsList
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ACTORS_LIST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<ActorDefinition> getActorsList() {
        return actorsList;
    }

    @JsonProperty(JSON_PROPERTY_ACTORS_LIST)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setActorsList(List<ActorDefinition> actorsList) {
        this.actorsList = actorsList;
    }

    public DesignProcessDefinition actorInitiator(ActorDefinition actorInitiator) {

        this.actorInitiator = actorInitiator;
        return this;
    }

    /**
     * Get actorInitiator
     * 
     * @return actorInitiator
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ACTOR_INITIATOR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ActorDefinition getActorInitiator() {
        return actorInitiator;
    }

    @JsonProperty(JSON_PROPERTY_ACTOR_INITIATOR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setActorInitiator(ActorDefinition actorInitiator) {
        this.actorInitiator = actorInitiator;
    }

    public DesignProcessDefinition stringIndexLabels(List<String> stringIndexLabels) {

        this.stringIndexLabels = stringIndexLabels;
        return this;
    }

    public DesignProcessDefinition addStringIndexLabelsItem(String stringIndexLabelsItem) {
        if (this.stringIndexLabels == null) {
            this.stringIndexLabels = new ArrayList<>();
        }
        this.stringIndexLabels.add(stringIndexLabelsItem);
        return this;
    }

    /**
     * The process definition labels
     * 
     * @return stringIndexLabels
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STRING_INDEX_LABELS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getStringIndexLabels() {
        return stringIndexLabels;
    }

    @JsonProperty(JSON_PROPERTY_STRING_INDEX_LABELS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStringIndexLabels(List<String> stringIndexLabels) {
        this.stringIndexLabels = stringIndexLabels;
    }

    public DesignProcessDefinition stringIndexValues(List<Expression> stringIndexValues) {

        this.stringIndexValues = stringIndexValues;
        return this;
    }

    public DesignProcessDefinition addStringIndexValuesItem(Expression stringIndexValuesItem) {
        if (this.stringIndexValues == null) {
            this.stringIndexValues = new ArrayList<>();
        }
        this.stringIndexValues.add(stringIndexValuesItem);
        return this;
    }

    /**
     * The process definition expressions
     * 
     * @return stringIndexValues
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STRING_INDEX_VALUES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Expression> getStringIndexValues() {
        return stringIndexValues;
    }

    @JsonProperty(JSON_PROPERTY_STRING_INDEX_VALUES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStringIndexValues(List<Expression> stringIndexValues) {
        this.stringIndexValues = stringIndexValues;
    }

    public DesignProcessDefinition contract(Contract contract) {

        this.contract = contract;
        return this;
    }

    /**
     * Get contract
     * 
     * @return contract
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONTRACT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Contract getContract() {
        return contract;
    }

    @JsonProperty(JSON_PROPERTY_CONTRACT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public DesignProcessDefinition context(List<DesignProcessDefinitionContext> context) {

        this.context = context;
        return this;
    }

    public DesignProcessDefinition addContextItem(DesignProcessDefinitionContext contextItem) {
        if (this.context == null) {
            this.context = new ArrayList<>();
        }
        this.context.add(contextItem);
        return this;
    }

    /**
     * The process definition expressions
     * 
     * @return context
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONTEXT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<DesignProcessDefinitionContext> getContext() {
        return context;
    }

    @JsonProperty(JSON_PROPERTY_CONTEXT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContext(List<DesignProcessDefinitionContext> context) {
        this.context = context;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DesignProcessDefinition designProcessDefinition = (DesignProcessDefinition) o;
        return Objects.equals(this.displayName, designProcessDefinition.displayName) &&
                Objects.equals(this.displayDescription, designProcessDefinition.displayDescription) &&
                Objects.equals(this.flowElementContainer, designProcessDefinition.flowElementContainer) &&
                Objects.equals(this.parameters, designProcessDefinition.parameters) &&
                Objects.equals(this.actorsList, designProcessDefinition.actorsList) &&
                Objects.equals(this.actorInitiator, designProcessDefinition.actorInitiator) &&
                Objects.equals(this.stringIndexLabels, designProcessDefinition.stringIndexLabels) &&
                Objects.equals(this.stringIndexValues, designProcessDefinition.stringIndexValues) &&
                Objects.equals(this.contract, designProcessDefinition.contract) &&
                Objects.equals(this.context, designProcessDefinition.context);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, displayDescription, flowElementContainer, parameters, actorsList,
                actorInitiator, stringIndexLabels, stringIndexValues, contract, context);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DesignProcessDefinition {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    displayDescription: ").append(toIndentedString(displayDescription)).append("\n");
        sb.append("    flowElementContainer: ").append(toIndentedString(flowElementContainer)).append("\n");
        sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
        sb.append("    actorsList: ").append(toIndentedString(actorsList)).append("\n");
        sb.append("    actorInitiator: ").append(toIndentedString(actorInitiator)).append("\n");
        sb.append("    stringIndexLabels: ").append(toIndentedString(stringIndexLabels)).append("\n");
        sb.append("    stringIndexValues: ").append(toIndentedString(stringIndexValues)).append("\n");
        sb.append("    contract: ").append(toIndentedString(contract)).append("\n");
        sb.append("    context: ").append(toIndentedString(context)).append("\n");
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
