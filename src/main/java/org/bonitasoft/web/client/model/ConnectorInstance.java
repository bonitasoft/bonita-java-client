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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 
 */
@JsonPropertyOrder({
        ConnectorInstance.JSON_PROPERTY_CONTAINER_TYPE,
        ConnectorInstance.JSON_PROPERTY_CONNECTOR_ID,
        ConnectorInstance.JSON_PROPERTY_ID,
        ConnectorInstance.JSON_PROPERTY_NAME,
        ConnectorInstance.JSON_PROPERTY_ACTIVATION_EVENT,
        ConnectorInstance.JSON_PROPERTY_STATE,
        ConnectorInstance.JSON_PROPERTY_CONTAINER_ID,
        ConnectorInstance.JSON_PROPERTY_VERSION
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class ConnectorInstance implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_CONTAINER_TYPE = "containerType";
    @jakarta.annotation.Nullable
    private String containerType;

    public static final String JSON_PROPERTY_CONNECTOR_ID = "connectorId";
    @jakarta.annotation.Nullable
    private String connectorId;

    public static final String JSON_PROPERTY_ID = "id";
    @jakarta.annotation.Nullable
    private Long id;

    public static final String JSON_PROPERTY_NAME = "name";
    @jakarta.annotation.Nullable
    private String name;

    /**
     * the name of the event that activated the connector instance
     */
    public enum ActivationEventEnum {

        ON_ENTER(String.valueOf("ON_ENTER")),

        ON_FINISH(String.valueOf("ON_FINISH"));

        private String value;

        ActivationEventEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static ActivationEventEnum fromValue(String value) {
            for (ActivationEventEnum b : ActivationEventEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_ACTIVATION_EVENT = "activationEvent";
    @jakarta.annotation.Nullable
    private ActivationEventEnum activationEvent;

    /**
     * the connector state
     */
    public enum StateEnum {

        TO_BE_EXECUTED(String.valueOf("TO_BE_EXECUTED")),

        EXECUTING(String.valueOf("EXECUTING")),

        TO_RE_EXECUTE(String.valueOf("TO_RE_EXECUTE")),

        DONE(String.valueOf("DONE")),

        FAILED(String.valueOf("FAILED")),

        SKIPPED(String.valueOf("SKIPPED"));

        private String value;

        StateEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static StateEnum fromValue(String value) {
            for (StateEnum b : StateEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_STATE = "state";
    @jakarta.annotation.Nullable
    private StateEnum state;

    public static final String JSON_PROPERTY_CONTAINER_ID = "containerId";
    @jakarta.annotation.Nullable
    private String containerId;

    public static final String JSON_PROPERTY_VERSION = "version";
    @jakarta.annotation.Nullable
    private String version;

    public ConnectorInstance() {
    }

    public ConnectorInstance containerType(@jakarta.annotation.Nullable String containerType) {

        this.containerType = containerType;
        return this;
    }

    /**
     * the type of the containing activity
     * 
     * @return containerType
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONTAINER_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getContainerType() {
        return containerType;
    }

    @JsonProperty(JSON_PROPERTY_CONTAINER_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContainerType(@jakarta.annotation.Nullable String containerType) {
        this.containerType = containerType;
    }

    public ConnectorInstance connectorId(@jakarta.annotation.Nullable String connectorId) {

        this.connectorId = connectorId;
        return this;
    }

    /**
     * the connector id
     * 
     * @return connectorId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONNECTOR_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getConnectorId() {
        return connectorId;
    }

    @JsonProperty(JSON_PROPERTY_CONNECTOR_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setConnectorId(@jakarta.annotation.Nullable String connectorId) {
        this.connectorId = connectorId;
    }

    public ConnectorInstance id(@jakarta.annotation.Nullable Long id) {

        this.id = id;
        return this;
    }

    /**
     * the connector instance id
     * 
     * @return id
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setId(@jakarta.annotation.Nullable Long id) {
        this.id = id;
    }

    public ConnectorInstance name(@jakarta.annotation.Nullable String name) {

        this.name = name;
        return this;
    }

    /**
     * the connector name
     * 
     * @return name
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setName(@jakarta.annotation.Nullable String name) {
        this.name = name;
    }

    public ConnectorInstance activationEvent(@jakarta.annotation.Nullable ActivationEventEnum activationEvent) {

        this.activationEvent = activationEvent;
        return this;
    }

    /**
     * the name of the event that activated the connector instance
     * 
     * @return activationEvent
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ACTIVATION_EVENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ActivationEventEnum getActivationEvent() {
        return activationEvent;
    }

    @JsonProperty(JSON_PROPERTY_ACTIVATION_EVENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setActivationEvent(@jakarta.annotation.Nullable ActivationEventEnum activationEvent) {
        this.activationEvent = activationEvent;
    }

    public ConnectorInstance state(@jakarta.annotation.Nullable StateEnum state) {

        this.state = state;
        return this;
    }

    /**
     * the connector state
     * 
     * @return state
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public StateEnum getState() {
        return state;
    }

    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setState(@jakarta.annotation.Nullable StateEnum state) {
        this.state = state;
    }

    public ConnectorInstance containerId(@jakarta.annotation.Nullable String containerId) {

        this.containerId = containerId;
        return this;
    }

    /**
     * the containing activity instance id
     * 
     * @return containerId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONTAINER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getContainerId() {
        return containerId;
    }

    @JsonProperty(JSON_PROPERTY_CONTAINER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContainerId(@jakarta.annotation.Nullable String containerId) {
        this.containerId = containerId;
    }

    public ConnectorInstance version(@jakarta.annotation.Nullable String version) {

        this.version = version;
        return this;
    }

    /**
     * the connector version
     * 
     * @return version
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getVersion() {
        return version;
    }

    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVersion(@jakarta.annotation.Nullable String version) {
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
        ConnectorInstance connectorInstance = (ConnectorInstance) o;
        return Objects.equals(this.containerType, connectorInstance.containerType) &&
                Objects.equals(this.connectorId, connectorInstance.connectorId) &&
                Objects.equals(this.id, connectorInstance.id) &&
                Objects.equals(this.name, connectorInstance.name) &&
                Objects.equals(this.activationEvent, connectorInstance.activationEvent) &&
                Objects.equals(this.state, connectorInstance.state) &&
                Objects.equals(this.containerId, connectorInstance.containerId) &&
                Objects.equals(this.version, connectorInstance.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(containerType, connectorId, id, name, activationEvent, state, containerId, version);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ConnectorInstance {\n");
        sb.append("    containerType: ").append(toIndentedString(containerType)).append("\n");
        sb.append("    connectorId: ").append(toIndentedString(connectorId)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    activationEvent: ").append(toIndentedString(activationEvent)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    containerId: ").append(toIndentedString(containerId)).append("\n");
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
