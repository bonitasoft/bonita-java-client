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
import java.util.Arrays;
import java.util.Objects;

import org.openapitools.jackson.nullable.JsonNullable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Deployment information of a process: its name, version, activation and configuration state, and deployment metadata. This is a general-purpose embedding
 * shape, not delegation-specific; it currently appears under the &#x60;rootProcessInfo&#x60; field of a delegated task. The internal deployment-info row id is
 * intentionally not exposed; callers identify the process through &#x60;processId&#x60;. The &#x60;processId&#x60; and &#x60;deployedBy&#x60; long ids are
 * serialized as strings to avoid JavaScript precision loss, while date fields are serialized as numeric epoch milliseconds.
 */
@JsonPropertyOrder({
        ProcessDeploymentInfo.JSON_PROPERTY_PROCESS_ID,
        ProcessDeploymentInfo.JSON_PROPERTY_NAME,
        ProcessDeploymentInfo.JSON_PROPERTY_VERSION,
        ProcessDeploymentInfo.JSON_PROPERTY_DISPLAY_NAME,
        ProcessDeploymentInfo.JSON_PROPERTY_DESCRIPTION,
        ProcessDeploymentInfo.JSON_PROPERTY_DISPLAY_DESCRIPTION,
        ProcessDeploymentInfo.JSON_PROPERTY_DEPLOYMENT_DATE,
        ProcessDeploymentInfo.JSON_PROPERTY_DEPLOYED_BY,
        ProcessDeploymentInfo.JSON_PROPERTY_LAST_UPDATE_DATE,
        ProcessDeploymentInfo.JSON_PROPERTY_ACTIVATION_STATE,
        ProcessDeploymentInfo.JSON_PROPERTY_CONFIGURATION_STATE,
        ProcessDeploymentInfo.JSON_PROPERTY_ICON_PATH
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class ProcessDeploymentInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_PROCESS_ID = "processId";
    @jakarta.annotation.Nonnull
    private String processId;

    public static final String JSON_PROPERTY_NAME = "name";
    @jakarta.annotation.Nonnull
    private String name;

    public static final String JSON_PROPERTY_VERSION = "version";
    @jakarta.annotation.Nonnull
    private String version;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    private JsonNullable<String> displayName = JsonNullable.<String> undefined();

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private JsonNullable<String> description = JsonNullable.<String> undefined();

    public static final String JSON_PROPERTY_DISPLAY_DESCRIPTION = "displayDescription";
    private JsonNullable<String> displayDescription = JsonNullable.<String> undefined();

    public static final String JSON_PROPERTY_DEPLOYMENT_DATE = "deploymentDate";
    @jakarta.annotation.Nullable
    private Long deploymentDate;

    public static final String JSON_PROPERTY_DEPLOYED_BY = "deployedBy";
    @jakarta.annotation.Nullable
    private String deployedBy;

    public static final String JSON_PROPERTY_LAST_UPDATE_DATE = "lastUpdateDate";
    @jakarta.annotation.Nullable
    private Long lastUpdateDate;

    public static final String JSON_PROPERTY_ACTIVATION_STATE = "activationState";
    @jakarta.annotation.Nonnull
    private ActivationState activationState;

    public static final String JSON_PROPERTY_CONFIGURATION_STATE = "configurationState";
    @jakarta.annotation.Nonnull
    private ConfigurationState configurationState;

    public static final String JSON_PROPERTY_ICON_PATH = "iconPath";
    private JsonNullable<String> iconPath = JsonNullable.<String> undefined();

    public ProcessDeploymentInfo() {
    }

    public ProcessDeploymentInfo processId(@jakarta.annotation.Nonnull String processId) {

        this.processId = processId;
        return this;
    }

    /**
     * Identifier of the process definition. Serialized as a string to avoid JavaScript precision loss.
     * 
     * @return processId
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_PROCESS_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getProcessId() {
        return processId;
    }

    @JsonProperty(JSON_PROPERTY_PROCESS_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setProcessId(@jakarta.annotation.Nonnull String processId) {
        this.processId = processId;
    }

    public ProcessDeploymentInfo name(@jakarta.annotation.Nonnull String name) {

        this.name = name;
        return this;
    }

    /**
     * Technical name of the process.
     * 
     * @return name
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setName(@jakarta.annotation.Nonnull String name) {
        this.name = name;
    }

    public ProcessDeploymentInfo version(@jakarta.annotation.Nonnull String version) {

        this.version = version;
        return this;
    }

    /**
     * Version of the process.
     * 
     * @return version
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getVersion() {
        return version;
    }

    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setVersion(@jakarta.annotation.Nonnull String version) {
        this.version = version;
    }

    public ProcessDeploymentInfo displayName(@jakarta.annotation.Nullable String displayName) {
        this.displayName = JsonNullable.<String> of(displayName);

        return this;
    }

    /**
     * Human-readable name of the process.
     * 
     * @return displayName
     */
    @jakarta.annotation.Nullable
    @JsonIgnore

    public String getDisplayName() {
        return displayName.orElse(null);
    }

    @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public JsonNullable<String> getDisplayName_JsonNullable() {
        return displayName;
    }

    @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
    public void setDisplayName_JsonNullable(JsonNullable<String> displayName) {
        this.displayName = displayName;
    }

    public void setDisplayName(@jakarta.annotation.Nullable String displayName) {
        this.displayName = JsonNullable.<String> of(displayName);
    }

    public ProcessDeploymentInfo description(@jakarta.annotation.Nullable String description) {
        this.description = JsonNullable.<String> of(description);

        return this;
    }

    /**
     * Description of the process.
     * 
     * @return description
     */
    @jakarta.annotation.Nullable
    @JsonIgnore

    public String getDescription() {
        return description.orElse(null);
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public JsonNullable<String> getDescription_JsonNullable() {
        return description;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    public void setDescription_JsonNullable(JsonNullable<String> description) {
        this.description = description;
    }

    public void setDescription(@jakarta.annotation.Nullable String description) {
        this.description = JsonNullable.<String> of(description);
    }

    public ProcessDeploymentInfo displayDescription(@jakarta.annotation.Nullable String displayDescription) {
        this.displayDescription = JsonNullable.<String> of(displayDescription);

        return this;
    }

    /**
     * Human-readable description of the process.
     * 
     * @return displayDescription
     */
    @jakarta.annotation.Nullable
    @JsonIgnore

    public String getDisplayDescription() {
        return displayDescription.orElse(null);
    }

    @JsonProperty(JSON_PROPERTY_DISPLAY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public JsonNullable<String> getDisplayDescription_JsonNullable() {
        return displayDescription;
    }

    @JsonProperty(JSON_PROPERTY_DISPLAY_DESCRIPTION)
    public void setDisplayDescription_JsonNullable(JsonNullable<String> displayDescription) {
        this.displayDescription = displayDescription;
    }

    public void setDisplayDescription(@jakarta.annotation.Nullable String displayDescription) {
        this.displayDescription = JsonNullable.<String> of(displayDescription);
    }

    public ProcessDeploymentInfo deploymentDate(@jakarta.annotation.Nullable Long deploymentDate) {

        this.deploymentDate = deploymentDate;
        return this;
    }

    /**
     * Deployment timestamp of the process, in epoch milliseconds.
     * 
     * @return deploymentDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DEPLOYMENT_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getDeploymentDate() {
        return deploymentDate;
    }

    @JsonProperty(JSON_PROPERTY_DEPLOYMENT_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDeploymentDate(@jakarta.annotation.Nullable Long deploymentDate) {
        this.deploymentDate = deploymentDate;
    }

    public ProcessDeploymentInfo deployedBy(@jakarta.annotation.Nullable String deployedBy) {

        this.deployedBy = deployedBy;
        return this;
    }

    /**
     * Id of the user who deployed the process. Serialized as a string.
     * 
     * @return deployedBy
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DEPLOYED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDeployedBy() {
        return deployedBy;
    }

    @JsonProperty(JSON_PROPERTY_DEPLOYED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDeployedBy(@jakarta.annotation.Nullable String deployedBy) {
        this.deployedBy = deployedBy;
    }

    public ProcessDeploymentInfo lastUpdateDate(@jakarta.annotation.Nullable Long lastUpdateDate) {

        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    /**
     * Timestamp of the last update of the deployment information, in epoch milliseconds.
     * 
     * @return lastUpdateDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LAST_UPDATE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getLastUpdateDate() {
        return lastUpdateDate;
    }

    @JsonProperty(JSON_PROPERTY_LAST_UPDATE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLastUpdateDate(@jakarta.annotation.Nullable Long lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public ProcessDeploymentInfo activationState(@jakarta.annotation.Nonnull ActivationState activationState) {

        this.activationState = activationState;
        return this;
    }

    /**
     * Get activationState
     * 
     * @return activationState
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ACTIVATION_STATE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public ActivationState getActivationState() {
        return activationState;
    }

    @JsonProperty(JSON_PROPERTY_ACTIVATION_STATE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setActivationState(@jakarta.annotation.Nonnull ActivationState activationState) {
        this.activationState = activationState;
    }

    public ProcessDeploymentInfo configurationState(@jakarta.annotation.Nonnull ConfigurationState configurationState) {

        this.configurationState = configurationState;
        return this;
    }

    /**
     * Get configurationState
     * 
     * @return configurationState
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_CONFIGURATION_STATE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public ConfigurationState getConfigurationState() {
        return configurationState;
    }

    @JsonProperty(JSON_PROPERTY_CONFIGURATION_STATE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setConfigurationState(@jakarta.annotation.Nonnull ConfigurationState configurationState) {
        this.configurationState = configurationState;
    }

    public ProcessDeploymentInfo iconPath(@jakarta.annotation.Nullable String iconPath) {
        this.iconPath = JsonNullable.<String> of(iconPath);

        return this;
    }

    /**
     * Path to the process icon, or &#x60;null&#x60; when none is set.
     * 
     * @return iconPath
     */
    @jakarta.annotation.Nullable
    @JsonIgnore

    public String getIconPath() {
        return iconPath.orElse(null);
    }

    @JsonProperty(JSON_PROPERTY_ICON_PATH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public JsonNullable<String> getIconPath_JsonNullable() {
        return iconPath;
    }

    @JsonProperty(JSON_PROPERTY_ICON_PATH)
    public void setIconPath_JsonNullable(JsonNullable<String> iconPath) {
        this.iconPath = iconPath;
    }

    public void setIconPath(@jakarta.annotation.Nullable String iconPath) {
        this.iconPath = JsonNullable.<String> of(iconPath);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProcessDeploymentInfo processDeploymentInfo = (ProcessDeploymentInfo) o;
        return Objects.equals(this.processId, processDeploymentInfo.processId) &&
                Objects.equals(this.name, processDeploymentInfo.name) &&
                Objects.equals(this.version, processDeploymentInfo.version) &&
                equalsNullable(this.displayName, processDeploymentInfo.displayName) &&
                equalsNullable(this.description, processDeploymentInfo.description) &&
                equalsNullable(this.displayDescription, processDeploymentInfo.displayDescription) &&
                Objects.equals(this.deploymentDate, processDeploymentInfo.deploymentDate) &&
                Objects.equals(this.deployedBy, processDeploymentInfo.deployedBy) &&
                Objects.equals(this.lastUpdateDate, processDeploymentInfo.lastUpdateDate) &&
                Objects.equals(this.activationState, processDeploymentInfo.activationState) &&
                Objects.equals(this.configurationState, processDeploymentInfo.configurationState) &&
                equalsNullable(this.iconPath, processDeploymentInfo.iconPath);
    }

    private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
        return a == b
                || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(processId, name, version, hashCodeNullable(displayName), hashCodeNullable(description),
                hashCodeNullable(displayDescription), deploymentDate, deployedBy, lastUpdateDate, activationState,
                configurationState, hashCodeNullable(iconPath));
    }

    private static <T> int hashCodeNullable(JsonNullable<T> a) {
        if (a == null) {
            return 1;
        }
        return a.isPresent() ? Arrays.deepHashCode(new Object[] { a.get() }) : 31;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessDeploymentInfo {\n");
        sb.append("    processId: ").append(toIndentedString(processId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    displayDescription: ").append(toIndentedString(displayDescription)).append("\n");
        sb.append("    deploymentDate: ").append(toIndentedString(deploymentDate)).append("\n");
        sb.append("    deployedBy: ").append(toIndentedString(deployedBy)).append("\n");
        sb.append("    lastUpdateDate: ").append(toIndentedString(lastUpdateDate)).append("\n");
        sb.append("    activationState: ").append(toIndentedString(activationState)).append("\n");
        sb.append("    configurationState: ").append(toIndentedString(configurationState)).append("\n");
        sb.append("    iconPath: ").append(toIndentedString(iconPath)).append("\n");
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
