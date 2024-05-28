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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * MaintenanceDetails
 */
@JsonPropertyOrder({
        MaintenanceDetails.JSON_PROPERTY_MAINTENANCE_STATE,
        MaintenanceDetails.JSON_PROPERTY_MAINTENANCE_MESSAGE,
        MaintenanceDetails.JSON_PROPERTY_MAINTENANCE_MESSAGE_ACTIVE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class MaintenanceDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * maintenance state
     */
    public enum MaintenanceStateEnum {

        ENABLED("ENABLED"),

        DISABLED("DISABLED");

        private String value;

        MaintenanceStateEnum(String value) {
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
        public static MaintenanceStateEnum fromValue(String value) {
            for (MaintenanceStateEnum b : MaintenanceStateEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_MAINTENANCE_STATE = "maintenanceState";
    private MaintenanceStateEnum maintenanceState;

    public static final String JSON_PROPERTY_MAINTENANCE_MESSAGE = "maintenanceMessage";
    private String maintenanceMessage;

    public static final String JSON_PROPERTY_MAINTENANCE_MESSAGE_ACTIVE = "maintenanceMessageActive";
    private Boolean maintenanceMessageActive;

    public MaintenanceDetails() {
    }

    public MaintenanceDetails maintenanceState(MaintenanceStateEnum maintenanceState) {

        this.maintenanceState = maintenanceState;
        return this;
    }

    /**
     * maintenance state
     * 
     * @return maintenanceState
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAINTENANCE_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public MaintenanceStateEnum getMaintenanceState() {
        return maintenanceState;
    }

    @JsonProperty(JSON_PROPERTY_MAINTENANCE_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaintenanceState(MaintenanceStateEnum maintenanceState) {
        this.maintenanceState = maintenanceState;
    }

    public MaintenanceDetails maintenanceMessage(String maintenanceMessage) {

        this.maintenanceMessage = maintenanceMessage;
        return this;
    }

    /**
     * maintenance message
     * 
     * @return maintenanceMessage
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAINTENANCE_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getMaintenanceMessage() {
        return maintenanceMessage;
    }

    @JsonProperty(JSON_PROPERTY_MAINTENANCE_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaintenanceMessage(String maintenanceMessage) {
        this.maintenanceMessage = maintenanceMessage;
    }

    public MaintenanceDetails maintenanceMessageActive(Boolean maintenanceMessageActive) {

        this.maintenanceMessageActive = maintenanceMessageActive;
        return this;
    }

    /**
     * is maintenance message active
     * 
     * @return maintenanceMessageActive
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAINTENANCE_MESSAGE_ACTIVE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getMaintenanceMessageActive() {
        return maintenanceMessageActive;
    }

    @JsonProperty(JSON_PROPERTY_MAINTENANCE_MESSAGE_ACTIVE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMaintenanceMessageActive(Boolean maintenanceMessageActive) {
        this.maintenanceMessageActive = maintenanceMessageActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MaintenanceDetails maintenanceDetails = (MaintenanceDetails) o;
        return Objects.equals(this.maintenanceState, maintenanceDetails.maintenanceState) &&
                Objects.equals(this.maintenanceMessage, maintenanceDetails.maintenanceMessage) &&
                Objects.equals(this.maintenanceMessageActive, maintenanceDetails.maintenanceMessageActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maintenanceState, maintenanceMessage, maintenanceMessageActive);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MaintenanceDetails {\n");
        sb.append("    maintenanceState: ").append(toIndentedString(maintenanceState)).append("\n");
        sb.append("    maintenanceMessage: ").append(toIndentedString(maintenanceMessage)).append("\n");
        sb.append("    maintenanceMessageActive: ").append(toIndentedString(maintenanceMessageActive)).append("\n");
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
