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
 * Schedule on which the data retention service runs. The cron expression is configured via the &#x60;bonita.runtime.retention.schedule.cron&#x60; platform
 * property.
 */
@JsonPropertyOrder({
        RetentionSchedule.JSON_PROPERTY_CRON_EXPRESSION
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class RetentionSchedule implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_CRON_EXPRESSION = "cronExpression";
    @jakarta.annotation.Nonnull
    private String cronExpression;

    public RetentionSchedule() {
    }

    public RetentionSchedule cronExpression(@jakarta.annotation.Nonnull String cronExpression) {

        this.cronExpression = cronExpression;
        return this;
    }

    /**
     * Cron expression that defines when the data retention job is triggered.
     * 
     * @return cronExpression
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_CRON_EXPRESSION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getCronExpression() {
        return cronExpression;
    }

    @JsonProperty(JSON_PROPERTY_CRON_EXPRESSION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setCronExpression(@jakarta.annotation.Nonnull String cronExpression) {
        this.cronExpression = cronExpression;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RetentionSchedule retentionSchedule = (RetentionSchedule) o;
        return Objects.equals(this.cronExpression, retentionSchedule.cronExpression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cronExpression);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RetentionSchedule {\n");
        sb.append("    cronExpression: ").append(toIndentedString(cronExpression)).append("\n");
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
