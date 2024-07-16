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
 * BPM timer event triggers
 */
@JsonPropertyOrder({
        TimerEventTrigger.JSON_PROPERTY_ID,
        TimerEventTrigger.JSON_PROPERTY_ID_STRING,
        TimerEventTrigger.JSON_PROPERTY_EVENT_INSTANCE_ID,
        TimerEventTrigger.JSON_PROPERTY_EVENT_INSTANCE_ID_STRING,
        TimerEventTrigger.JSON_PROPERTY_EXECUTION_DATE,
        TimerEventTrigger.JSON_PROPERTY_EVENT_INSTANCE_NAME
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class TimerEventTrigger implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_ID_STRING = "id_string";
    private String idString;

    public static final String JSON_PROPERTY_EVENT_INSTANCE_ID = "eventInstanceId";
    private String eventInstanceId;

    public static final String JSON_PROPERTY_EVENT_INSTANCE_ID_STRING = "eventInstanceId_string";
    private String eventInstanceIdString;

    public static final String JSON_PROPERTY_EXECUTION_DATE = "executionDate";
    private String executionDate;

    public static final String JSON_PROPERTY_EVENT_INSTANCE_NAME = "eventInstanceName";
    private String eventInstanceName;

    public TimerEventTrigger() {
    }

    public TimerEventTrigger id(String id) {

        this.id = id;
        return this;
    }

    /**
     * the ID of the timer returned
     * 
     * @return id
     */
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

    public TimerEventTrigger idString(String idString) {

        this.idString = idString;
        return this;
    }

    /**
     * the ID of the timer returned
     * 
     * @return idString
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID_STRING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getIdString() {
        return idString;
    }

    @JsonProperty(JSON_PROPERTY_ID_STRING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIdString(String idString) {
        this.idString = idString;
    }

    public TimerEventTrigger eventInstanceId(String eventInstanceId) {

        this.eventInstanceId = eventInstanceId;
        return this;
    }

    /**
     * the ID of the event instance to which this trigger is related
     * 
     * @return eventInstanceId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EVENT_INSTANCE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getEventInstanceId() {
        return eventInstanceId;
    }

    @JsonProperty(JSON_PROPERTY_EVENT_INSTANCE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEventInstanceId(String eventInstanceId) {
        this.eventInstanceId = eventInstanceId;
    }

    public TimerEventTrigger eventInstanceIdString(String eventInstanceIdString) {

        this.eventInstanceIdString = eventInstanceIdString;
        return this;
    }

    /**
     * the ID of the event instance to which this trigger is related
     * 
     * @return eventInstanceIdString
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EVENT_INSTANCE_ID_STRING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getEventInstanceIdString() {
        return eventInstanceIdString;
    }

    @JsonProperty(JSON_PROPERTY_EVENT_INSTANCE_ID_STRING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEventInstanceIdString(String eventInstanceIdString) {
        this.eventInstanceIdString = eventInstanceIdString;
    }

    public TimerEventTrigger executionDate(String executionDate) {

        this.executionDate = executionDate;
        return this;
    }

    /**
     * the long value of the next execution date (number of milliseconds from January 1st, 1970 00:00:00)
     * 
     * @return executionDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EXECUTION_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getExecutionDate() {
        return executionDate;
    }

    @JsonProperty(JSON_PROPERTY_EXECUTION_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setExecutionDate(String executionDate) {
        this.executionDate = executionDate;
    }

    public TimerEventTrigger eventInstanceName(String eventInstanceName) {

        this.eventInstanceName = eventInstanceName;
        return this;
    }

    /**
     * the name of the event instance to which this trigger is related
     * 
     * @return eventInstanceName
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EVENT_INSTANCE_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getEventInstanceName() {
        return eventInstanceName;
    }

    @JsonProperty(JSON_PROPERTY_EVENT_INSTANCE_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEventInstanceName(String eventInstanceName) {
        this.eventInstanceName = eventInstanceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TimerEventTrigger timerEventTrigger = (TimerEventTrigger) o;
        return Objects.equals(this.id, timerEventTrigger.id) &&
                Objects.equals(this.idString, timerEventTrigger.idString) &&
                Objects.equals(this.eventInstanceId, timerEventTrigger.eventInstanceId) &&
                Objects.equals(this.eventInstanceIdString, timerEventTrigger.eventInstanceIdString) &&
                Objects.equals(this.executionDate, timerEventTrigger.executionDate) &&
                Objects.equals(this.eventInstanceName, timerEventTrigger.eventInstanceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idString, eventInstanceId, eventInstanceIdString, executionDate, eventInstanceName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TimerEventTrigger {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    idString: ").append(toIndentedString(idString)).append("\n");
        sb.append("    eventInstanceId: ").append(toIndentedString(eventInstanceId)).append("\n");
        sb.append("    eventInstanceIdString: ").append(toIndentedString(eventInstanceIdString)).append("\n");
        sb.append("    executionDate: ").append(toIndentedString(executionDate)).append("\n");
        sb.append("    eventInstanceName: ").append(toIndentedString(eventInstanceName)).append("\n");
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
