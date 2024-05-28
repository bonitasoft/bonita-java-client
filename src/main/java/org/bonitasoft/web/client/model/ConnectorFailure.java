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

/**
 * 
 */
@JsonPropertyOrder({
        ConnectorFailure.JSON_PROPERTY_ERROR_MESSAGE,
        ConnectorFailure.JSON_PROPERTY_CONNECTOR_INSTANCE_ID,
        ConnectorFailure.JSON_PROPERTY_ERROR_STACK_TRACE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class ConnectorFailure implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ERROR_MESSAGE = "errorMessage";
    private String errorMessage;

    public static final String JSON_PROPERTY_CONNECTOR_INSTANCE_ID = "connectorInstanceId";
    private String connectorInstanceId;

    public static final String JSON_PROPERTY_ERROR_STACK_TRACE = "errorStackTrace";
    private String errorStackTrace;

    public ConnectorFailure() {
    }

    public ConnectorFailure errorMessage(String errorMessage) {

        this.errorMessage = errorMessage;
        return this;
    }

    /**
     * the message of the connector failure
     * 
     * @return errorMessage
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ERROR_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getErrorMessage() {
        return errorMessage;
    }

    @JsonProperty(JSON_PROPERTY_ERROR_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ConnectorFailure connectorInstanceId(String connectorInstanceId) {

        this.connectorInstanceId = connectorInstanceId;
        return this;
    }

    /**
     * the ID of the connector instance (see connectorInstance resource documentation)
     * 
     * @return connectorInstanceId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONNECTOR_INSTANCE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getConnectorInstanceId() {
        return connectorInstanceId;
    }

    @JsonProperty(JSON_PROPERTY_CONNECTOR_INSTANCE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setConnectorInstanceId(String connectorInstanceId) {
        this.connectorInstanceId = connectorInstanceId;
    }

    public ConnectorFailure errorStackTrace(String errorStackTrace) {

        this.errorStackTrace = errorStackTrace;
        return this;
    }

    /**
     * the stack trace of the error
     * 
     * @return errorStackTrace
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ERROR_STACK_TRACE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getErrorStackTrace() {
        return errorStackTrace;
    }

    @JsonProperty(JSON_PROPERTY_ERROR_STACK_TRACE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setErrorStackTrace(String errorStackTrace) {
        this.errorStackTrace = errorStackTrace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConnectorFailure connectorFailure = (ConnectorFailure) o;
        return Objects.equals(this.errorMessage, connectorFailure.errorMessage) &&
                Objects.equals(this.connectorInstanceId, connectorFailure.connectorInstanceId) &&
                Objects.equals(this.errorStackTrace, connectorFailure.errorStackTrace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorMessage, connectorInstanceId, errorStackTrace);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ConnectorFailure {\n");
        sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
        sb.append("    connectorInstanceId: ").append(toIndentedString(connectorInstanceId)).append("\n");
        sb.append("    errorStackTrace: ").append(toIndentedString(errorStackTrace)).append("\n");
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
