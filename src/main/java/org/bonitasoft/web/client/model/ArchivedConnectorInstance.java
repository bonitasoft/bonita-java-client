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
 * ArchivedConnectorInstance
 */
@JsonPropertyOrder({
        ArchivedConnectorInstance.JSON_PROPERTY_CONTAINER_TYPE,
        ArchivedConnectorInstance.JSON_PROPERTY_CONNECTOR_ID,
        ArchivedConnectorInstance.JSON_PROPERTY_ID,
        ArchivedConnectorInstance.JSON_PROPERTY_NAME,
        ArchivedConnectorInstance.JSON_PROPERTY_ACTIVATION_EVENT,
        ArchivedConnectorInstance.JSON_PROPERTY_STATE,
        ArchivedConnectorInstance.JSON_PROPERTY_CONTAINER_ID,
        ArchivedConnectorInstance.JSON_PROPERTY_VERSION,
        ArchivedConnectorInstance.JSON_PROPERTY_ARCHIVED_DATE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class ArchivedConnectorInstance implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_CONTAINER_TYPE = "containerType";
    private String containerType;

    public static final String JSON_PROPERTY_CONNECTOR_ID = "connectorId";
    private String connectorId;

    public static final String JSON_PROPERTY_ID = "id";
    private Long id;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    /**
     * the name of the event that activated the connector instance
     */
    public enum ActivationEventEnum {

        ENTER("ON_ENTER"),

        FINISH("ON_FINISH");

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
    private ActivationEventEnum activationEvent;

    /**
     * the connector state
     */
    public enum StateEnum {

        TO_BE_EXECUTED("TO_BE_EXECUTED"),

        EXECUTING("EXECUTING"),

        TO_RE_EXECUTE("TO_RE_EXECUTE"),

        DONE("DONE"),

        FAILED("FAILED"),

        SKIPPED("SKIPPED");

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
    private StateEnum state;

    public static final String JSON_PROPERTY_CONTAINER_ID = "containerId";
    private String containerId;

    public static final String JSON_PROPERTY_VERSION = "version";
    private String version;

    public static final String JSON_PROPERTY_ARCHIVED_DATE = "archivedDate";
    private String archivedDate;

    public ArchivedConnectorInstance() {
    }

    public ArchivedConnectorInstance containerType(String containerType) {

        this.containerType = containerType;
        return this;
    }

    /**
     * the type of the containing activity
     * 
     * @return containerType
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONTAINER_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getContainerType() {
        return containerType;
    }

    @JsonProperty(JSON_PROPERTY_CONTAINER_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public ArchivedConnectorInstance connectorId(String connectorId) {

        this.connectorId = connectorId;
        return this;
    }

    /**
     * the connector id
     * 
     * @return connectorId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONNECTOR_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getConnectorId() {
        return connectorId;
    }

    @JsonProperty(JSON_PROPERTY_CONNECTOR_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setConnectorId(String connectorId) {
        this.connectorId = connectorId;
    }

    public ArchivedConnectorInstance id(Long id) {

        this.id = id;
        return this;
    }

    /**
     * the connector instance id
     * 
     * @return id
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setId(Long id) {
        this.id = id;
    }

    public ArchivedConnectorInstance name(String name) {

        this.name = name;
        return this;
    }

    /**
     * the connector name
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

    public ArchivedConnectorInstance activationEvent(ActivationEventEnum activationEvent) {

        this.activationEvent = activationEvent;
        return this;
    }

    /**
     * the name of the event that activated the connector instance
     * 
     * @return activationEvent
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ACTIVATION_EVENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ActivationEventEnum getActivationEvent() {
        return activationEvent;
    }

    @JsonProperty(JSON_PROPERTY_ACTIVATION_EVENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setActivationEvent(ActivationEventEnum activationEvent) {
        this.activationEvent = activationEvent;
    }

    public ArchivedConnectorInstance state(StateEnum state) {

        this.state = state;
        return this;
    }

    /**
     * the connector state
     * 
     * @return state
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public StateEnum getState() {
        return state;
    }

    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setState(StateEnum state) {
        this.state = state;
    }

    public ArchivedConnectorInstance containerId(String containerId) {

        this.containerId = containerId;
        return this;
    }

    /**
     * the containing activity instance id
     * 
     * @return containerId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONTAINER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getContainerId() {
        return containerId;
    }

    @JsonProperty(JSON_PROPERTY_CONTAINER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public ArchivedConnectorInstance version(String version) {

        this.version = version;
        return this;
    }

    /**
     * the connector version
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

    public ArchivedConnectorInstance archivedDate(String archivedDate) {

        this.archivedDate = archivedDate;
        return this;
    }

    /**
     * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when the current task was assigned for example &#39;2014-10-17 16:05:42.626&#39;
     * 
     * @return archivedDate
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ARCHIVED_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getArchivedDate() {
        return archivedDate;
    }

    @JsonProperty(JSON_PROPERTY_ARCHIVED_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setArchivedDate(String archivedDate) {
        this.archivedDate = archivedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArchivedConnectorInstance archivedConnectorInstance = (ArchivedConnectorInstance) o;
        return Objects.equals(this.containerType, archivedConnectorInstance.containerType) &&
                Objects.equals(this.connectorId, archivedConnectorInstance.connectorId) &&
                Objects.equals(this.id, archivedConnectorInstance.id) &&
                Objects.equals(this.name, archivedConnectorInstance.name) &&
                Objects.equals(this.activationEvent, archivedConnectorInstance.activationEvent) &&
                Objects.equals(this.state, archivedConnectorInstance.state) &&
                Objects.equals(this.containerId, archivedConnectorInstance.containerId) &&
                Objects.equals(this.version, archivedConnectorInstance.version) &&
                Objects.equals(this.archivedDate, archivedConnectorInstance.archivedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(containerType, connectorId, id, name, activationEvent, state, containerId, version,
                archivedDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ArchivedConnectorInstance {\n");
        sb.append("    containerType: ").append(toIndentedString(containerType)).append("\n");
        sb.append("    connectorId: ").append(toIndentedString(connectorId)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    activationEvent: ").append(toIndentedString(activationEvent)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    containerId: ").append(toIndentedString(containerId)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    archivedDate: ").append(toIndentedString(archivedDate)).append("\n");
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
