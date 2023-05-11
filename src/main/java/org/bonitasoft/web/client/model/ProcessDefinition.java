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
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 */
@JsonPropertyOrder({
        ProcessDefinition.JSON_PROPERTY_ID,
        ProcessDefinition.JSON_PROPERTY_ICON,
        ProcessDefinition.JSON_PROPERTY_DISPLAY_DESCRIPTION,
        ProcessDefinition.JSON_PROPERTY_DEPLOYMENT_DATE,
        ProcessDefinition.JSON_PROPERTY_DESCRIPTION,
        ProcessDefinition.JSON_PROPERTY_ACTIVATION_STATE,
        ProcessDefinition.JSON_PROPERTY_NAME,
        ProcessDefinition.JSON_PROPERTY_DEPLOYED_BY,
        ProcessDefinition.JSON_PROPERTY_DISPLAY_NAME,
        ProcessDefinition.JSON_PROPERTY_ACTORINITIATORID,
        ProcessDefinition.JSON_PROPERTY_LAST_UPDATE_DATE,
        ProcessDefinition.JSON_PROPERTY_CONFIGURATION_STATE,
        ProcessDefinition.JSON_PROPERTY_VERSION
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ProcessDefinition implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_ICON = "icon";
    private String icon;

    public static final String JSON_PROPERTY_DISPLAY_DESCRIPTION = "displayDescription";
    private String displayDescription;

    public static final String JSON_PROPERTY_DEPLOYMENT_DATE = "deploymentDate";
    private String deploymentDate;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_ACTIVATION_STATE = "activationState";
    private ActivationState activationState;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_DEPLOYED_BY = "deployedBy";
    private String deployedBy;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    private String displayName;

    public static final String JSON_PROPERTY_ACTORINITIATORID = "actorinitiatorid";
    private String actorinitiatorid;

    public static final String JSON_PROPERTY_LAST_UPDATE_DATE = "last_update_date";
    private String lastUpdateDate;

    public static final String JSON_PROPERTY_CONFIGURATION_STATE = "configurationState";
    private ConfigurationState configurationState;

    public static final String JSON_PROPERTY_VERSION = "version";
    private String version;

    public ProcessDefinition() {
    }

    public ProcessDefinition id(String id) {

        this.id = id;
        return this;
    }

    /**
     * the identifier of the process definition (long)
     * 
     * @return id
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setId(String id) {
        this.id = id;
    }

    public ProcessDefinition icon(String icon) {

        this.icon = icon;
        return this;
    }

    /**
     * icon path
     * 
     * @return icon
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ICON)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getIcon() {
        return icon;
    }

    @JsonProperty(JSON_PROPERTY_ICON)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public ProcessDefinition displayDescription(String displayDescription) {

        this.displayDescription = displayDescription;
        return this;
    }

    /**
     * the human readable activity description
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

    public ProcessDefinition deploymentDate(String deploymentDate) {

        this.deploymentDate = deploymentDate;
        return this;
    }

    /**
     * the date when the process definition was deployed
     * 
     * @return deploymentDate
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DEPLOYMENT_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDeploymentDate() {
        return deploymentDate;
    }

    @JsonProperty(JSON_PROPERTY_DEPLOYMENT_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDeploymentDate(String deploymentDate) {
        this.deploymentDate = deploymentDate;
    }

    public ProcessDefinition description(String description) {

        this.description = description;
        return this;
    }

    /**
     * the process description
     * 
     * @return description
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDescription() {
        return description;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDescription(String description) {
        this.description = description;
    }

    public ProcessDefinition activationState(ActivationState activationState) {

        this.activationState = activationState;
        return this;
    }

    /**
     * Get activationState
     * 
     * @return activationState
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ACTIVATION_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ActivationState getActivationState() {
        return activationState;
    }

    @JsonProperty(JSON_PROPERTY_ACTIVATION_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setActivationState(ActivationState activationState) {
        this.activationState = activationState;
    }

    public ProcessDefinition name(String name) {

        this.name = name;
        return this;
    }

    /**
     * the process name
     * 
     * @return name
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setName(String name) {
        this.name = name;
    }

    public ProcessDefinition deployedBy(String deployedBy) {

        this.deployedBy = deployedBy;
        return this;
    }

    /**
     * the id of the user who deployed the process
     * 
     * @return deployedBy
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DEPLOYED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDeployedBy() {
        return deployedBy;
    }

    @JsonProperty(JSON_PROPERTY_DEPLOYED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDeployedBy(String deployedBy) {
        this.deployedBy = deployedBy;
    }

    public ProcessDefinition displayName(String displayName) {

        this.displayName = displayName;
        return this;
    }

    /**
     * the human readable process description
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

    public ProcessDefinition actorinitiatorid(String actorinitiatorid) {

        this.actorinitiatorid = actorinitiatorid;
        return this;
    }

    /**
     * the id of the actor that can initiate process instances of the process
     * 
     * @return actorinitiatorid
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ACTORINITIATORID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getActorinitiatorid() {
        return actorinitiatorid;
    }

    @JsonProperty(JSON_PROPERTY_ACTORINITIATORID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setActorinitiatorid(String actorinitiatorid) {
        this.actorinitiatorid = actorinitiatorid;
    }

    public ProcessDefinition lastUpdateDate(String lastUpdateDate) {

        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    /**
     * the date when the process definition was last updated
     * 
     * @return lastUpdateDate
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LAST_UPDATE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    @JsonProperty(JSON_PROPERTY_LAST_UPDATE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public ProcessDefinition configurationState(ConfigurationState configurationState) {

        this.configurationState = configurationState;
        return this;
    }

    /**
     * Get configurationState
     * 
     * @return configurationState
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONFIGURATION_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ConfigurationState getConfigurationState() {
        return configurationState;
    }

    @JsonProperty(JSON_PROPERTY_CONFIGURATION_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setConfigurationState(ConfigurationState configurationState) {
        this.configurationState = configurationState;
    }

    public ProcessDefinition version(String version) {

        this.version = version;
        return this;
    }

    /**
     * the version of the process
     * 
     * @return version
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getVersion() {
        return version;
    }

    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProcessDefinition processDefinition = (ProcessDefinition) o;
        return Objects.equals(this.id, processDefinition.id) &&
                Objects.equals(this.icon, processDefinition.icon) &&
                Objects.equals(this.displayDescription, processDefinition.displayDescription) &&
                Objects.equals(this.deploymentDate, processDefinition.deploymentDate) &&
                Objects.equals(this.description, processDefinition.description) &&
                Objects.equals(this.activationState, processDefinition.activationState) &&
                Objects.equals(this.name, processDefinition.name) &&
                Objects.equals(this.deployedBy, processDefinition.deployedBy) &&
                Objects.equals(this.displayName, processDefinition.displayName) &&
                Objects.equals(this.actorinitiatorid, processDefinition.actorinitiatorid) &&
                Objects.equals(this.lastUpdateDate, processDefinition.lastUpdateDate) &&
                Objects.equals(this.configurationState, processDefinition.configurationState) &&
                Objects.equals(this.version, processDefinition.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, icon, displayDescription, deploymentDate, description, activationState, name,
                deployedBy, displayName, actorinitiatorid, lastUpdateDate, configurationState, version);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessDefinition {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
        sb.append("    displayDescription: ").append(toIndentedString(displayDescription)).append("\n");
        sb.append("    deploymentDate: ").append(toIndentedString(deploymentDate)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    activationState: ").append(toIndentedString(activationState)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    deployedBy: ").append(toIndentedString(deployedBy)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    actorinitiatorid: ").append(toIndentedString(actorinitiatorid)).append("\n");
        sb.append("    lastUpdateDate: ").append(toIndentedString(lastUpdateDate)).append("\n");
        sb.append("    configurationState: ").append(toIndentedString(configurationState)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
