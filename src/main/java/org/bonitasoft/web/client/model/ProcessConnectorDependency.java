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

/**
 * Use the processConnectorDependency resource to access connector dependencies.
 */
@JsonPropertyOrder({
        ProcessConnectorDependency.JSON_PROPERTY_CONNECTOR_VERSION,
        ProcessConnectorDependency.JSON_PROPERTY_CONNECTOR_PROCESS_ID,
        ProcessConnectorDependency.JSON_PROPERTY_FILENAME,
        ProcessConnectorDependency.JSON_PROPERTY_CONNECTOR_NAME
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.5.0")
public class ProcessConnectorDependency implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_CONNECTOR_VERSION = "connector_version";
    private String connectorVersion;

    public static final String JSON_PROPERTY_CONNECTOR_PROCESS_ID = "connector_process_id";
    private String connectorProcessId;

    public static final String JSON_PROPERTY_FILENAME = "filename";
    private String filename;

    public static final String JSON_PROPERTY_CONNECTOR_NAME = "connector_name";
    private String connectorName;

    public ProcessConnectorDependency() {
    }

    public ProcessConnectorDependency connectorVersion(String connectorVersion) {

        this.connectorVersion = connectorVersion;
        return this;
    }

    /**
     * &lt;connector version&gt;
     * 
     * @return connectorVersion
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONNECTOR_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getConnectorVersion() {
        return connectorVersion;
    }

    @JsonProperty(JSON_PROPERTY_CONNECTOR_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setConnectorVersion(String connectorVersion) {
        this.connectorVersion = connectorVersion;
    }

    public ProcessConnectorDependency connectorProcessId(String connectorProcessId) {

        this.connectorProcessId = connectorProcessId;
        return this;
    }

    /**
     * &lt;process id&gt;
     * 
     * @return connectorProcessId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONNECTOR_PROCESS_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getConnectorProcessId() {
        return connectorProcessId;
    }

    @JsonProperty(JSON_PROPERTY_CONNECTOR_PROCESS_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setConnectorProcessId(String connectorProcessId) {
        this.connectorProcessId = connectorProcessId;
    }

    public ProcessConnectorDependency filename(String filename) {

        this.filename = filename;
        return this;
    }

    /**
     * &lt;filename representing the connector&gt;
     * 
     * @return filename
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FILENAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFilename() {
        return filename;
    }

    @JsonProperty(JSON_PROPERTY_FILENAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public ProcessConnectorDependency connectorName(String connectorName) {

        this.connectorName = connectorName;
        return this;
    }

    /**
     * &lt;connector name&gt;
     * 
     * @return connectorName
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONNECTOR_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getConnectorName() {
        return connectorName;
    }

    @JsonProperty(JSON_PROPERTY_CONNECTOR_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setConnectorName(String connectorName) {
        this.connectorName = connectorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProcessConnectorDependency processConnectorDependency = (ProcessConnectorDependency) o;
        return Objects.equals(this.connectorVersion, processConnectorDependency.connectorVersion) &&
                Objects.equals(this.connectorProcessId, processConnectorDependency.connectorProcessId) &&
                Objects.equals(this.filename, processConnectorDependency.filename) &&
                Objects.equals(this.connectorName, processConnectorDependency.connectorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectorVersion, connectorProcessId, filename, connectorName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessConnectorDependency {\n");
        sb.append("    connectorVersion: ").append(toIndentedString(connectorVersion)).append("\n");
        sb.append("    connectorProcessId: ").append(toIndentedString(connectorProcessId)).append("\n");
        sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
        sb.append("    connectorName: ").append(toIndentedString(connectorName)).append("\n");
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
