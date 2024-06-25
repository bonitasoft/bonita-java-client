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
 * TimerEventTriggerUpdateResponse
 */
@JsonPropertyOrder({
        TimerEventTriggerUpdateResponse.JSON_PROPERTY_EXECUTION_DATE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class TimerEventTriggerUpdateResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_EXECUTION_DATE = "executionDate";
    private Long executionDate;

    public TimerEventTriggerUpdateResponse() {
    }

    public TimerEventTriggerUpdateResponse executionDate(Long executionDate) {

        this.executionDate = executionDate;
        return this;
    }

    /**
     * executionDate of the TimerEventTrigger
     * 
     * @return executionDate
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EXECUTION_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getExecutionDate() {
        return executionDate;
    }

    @JsonProperty(JSON_PROPERTY_EXECUTION_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setExecutionDate(Long executionDate) {
        this.executionDate = executionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TimerEventTriggerUpdateResponse timerEventTriggerUpdateResponse = (TimerEventTriggerUpdateResponse) o;
        return Objects.equals(this.executionDate, timerEventTriggerUpdateResponse.executionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(executionDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TimerEventTriggerUpdateResponse {\n");
        sb.append("    executionDate: ").append(toIndentedString(executionDate)).append("\n");
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
