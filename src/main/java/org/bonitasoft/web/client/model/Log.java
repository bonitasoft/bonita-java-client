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
import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * A log entry recorded by the Bonita Engine during execution. Logs capture actions performed on the platform such as process deployments, task executions, or
 * configuration changes. This Web REST API is available in **Enterprise editions only**.
 */
@JsonPropertyOrder({
        Log.JSON_PROPERTY_ID,
        Log.JSON_PROPERTY_CREATION_DATE,
        Log.JSON_PROPERTY_CREATED_BY,
        Log.JSON_PROPERTY_SEVERITY,
        Log.JSON_PROPERTY_MESSAGE,
        Log.JSON_PROPERTY_ACTION_SCOPE,
        Log.JSON_PROPERTY_ICON
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    @jakarta.annotation.Nullable
    private String id;

    public static final String JSON_PROPERTY_CREATION_DATE = "creation_date";
    @jakarta.annotation.Nullable
    private OffsetDateTime creationDate;

    public static final String JSON_PROPERTY_CREATED_BY = "createdBy";
    @jakarta.annotation.Nullable
    private String createdBy;

    public static final String JSON_PROPERTY_SEVERITY = "severity";
    @jakarta.annotation.Nullable
    private LogSeverityLevel severity;

    public static final String JSON_PROPERTY_MESSAGE = "message";
    @jakarta.annotation.Nullable
    private String message;

    public static final String JSON_PROPERTY_ACTION_SCOPE = "action_scope";
    @jakarta.annotation.Nullable
    private String actionScope;

    public static final String JSON_PROPERTY_ICON = "icon";
    @jakarta.annotation.Nullable
    private String icon;

    public Log() {
    }

    public Log id(@jakarta.annotation.Nullable String id) {

        this.id = id;
        return this;
    }

    /**
     * the log id
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
    public void setId(@jakarta.annotation.Nullable String id) {
        this.id = id;
    }

    public Log creationDate(@jakarta.annotation.Nullable OffsetDateTime creationDate) {

        this.creationDate = creationDate;
        return this;
    }

    /**
     * the UTC date and time in ISO-8601 format (&#39;yyyy-MM-ddTHH:mm:ss.SSSZ&#39;) when this log was created, for example &#39;2024-10-17T16:05:42.626Z&#39;
     * 
     * @return creationDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATION_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    @JsonProperty(JSON_PROPERTY_CREATION_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreationDate(@jakarta.annotation.Nullable OffsetDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Log createdBy(@jakarta.annotation.Nullable String createdBy) {

        this.createdBy = createdBy;
        return this;
    }

    /**
     * the name of the user who triggered the logged action
     * 
     * @return createdBy
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCreatedBy() {
        return createdBy;
    }

    @JsonProperty(JSON_PROPERTY_CREATED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreatedBy(@jakarta.annotation.Nullable String createdBy) {
        this.createdBy = createdBy;
    }

    public Log severity(@jakarta.annotation.Nullable LogSeverityLevel severity) {

        this.severity = severity;
        return this;
    }

    /**
     * Get severity
     * 
     * @return severity
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SEVERITY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public LogSeverityLevel getSeverity() {
        return severity;
    }

    @JsonProperty(JSON_PROPERTY_SEVERITY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSeverity(@jakarta.annotation.Nullable LogSeverityLevel severity) {
        this.severity = severity;
    }

    public Log message(@jakarta.annotation.Nullable String message) {

        this.message = message;
        return this;
    }

    /**
     * the log message describing the action
     * 
     * @return message
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getMessage() {
        return message;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMessage(@jakarta.annotation.Nullable String message) {
        this.message = message;
    }

    public Log actionScope(@jakarta.annotation.Nullable String actionScope) {

        this.actionScope = actionScope;
        return this;
    }

    /**
     * the scope of the logged action
     * 
     * @return actionScope
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ACTION_SCOPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getActionScope() {
        return actionScope;
    }

    @JsonProperty(JSON_PROPERTY_ACTION_SCOPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setActionScope(@jakarta.annotation.Nullable String actionScope) {
        this.actionScope = actionScope;
    }

    public Log icon(@jakarta.annotation.Nullable String icon) {

        this.icon = icon;
        return this;
    }

    /**
     * the icon path for this log entry
     * 
     * @return icon
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ICON)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getIcon() {
        return icon;
    }

    @JsonProperty(JSON_PROPERTY_ICON)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIcon(@jakarta.annotation.Nullable String icon) {
        this.icon = icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Log log = (Log) o;
        return Objects.equals(this.id, log.id) &&
                Objects.equals(this.creationDate, log.creationDate) &&
                Objects.equals(this.createdBy, log.createdBy) &&
                Objects.equals(this.severity, log.severity) &&
                Objects.equals(this.message, log.message) &&
                Objects.equals(this.actionScope, log.actionScope) &&
                Objects.equals(this.icon, log.icon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, createdBy, severity, message, actionScope, icon);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Log {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    actionScope: ").append(toIndentedString(actionScope)).append("\n");
        sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
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
