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
 * The bonita platform
 */
@JsonPropertyOrder({
        Platform.JSON_PROPERTY_STATE,
        Platform.JSON_PROPERTY_VERSION,
        Platform.JSON_PROPERTY_INITIAL_VERSION,
        Platform.JSON_PROPERTY_PREVIOUS_VERSION,
        Platform.JSON_PROPERTY_CREATED_BY,
        Platform.JSON_PROPERTY_CREATED
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class Platform implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * platform state
     */
    public enum StateEnum {

        STARTED("STARTED"),

        STOPPED("STOPPED");

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

    public static final String JSON_PROPERTY_VERSION = "version";
    private String version;

    public static final String JSON_PROPERTY_INITIAL_VERSION = "initialVersion";
    private String initialVersion;

    public static final String JSON_PROPERTY_PREVIOUS_VERSION = "previousVersion";
    private String previousVersion;

    public static final String JSON_PROPERTY_CREATED_BY = "createdBy";
    private String createdBy;

    public static final String JSON_PROPERTY_CREATED = "created";
    private String created;

    public Platform() {
    }

    public Platform state(StateEnum state) {

        this.state = state;
        return this;
    }

    /**
     * platform state
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

    public Platform version(String version) {

        this.version = version;
        return this;
    }

    /**
     * the current version of the platform
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

    public Platform initialVersion(String initialVersion) {

        this.initialVersion = initialVersion;
        return this;
    }

    /**
     * the version in which the platform was created
     * 
     * @return initialVersion
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INITIAL_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getInitialVersion() {
        return initialVersion;
    }

    @JsonProperty(JSON_PROPERTY_INITIAL_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInitialVersion(String initialVersion) {
        this.initialVersion = initialVersion;
    }

    public Platform previousVersion(String previousVersion) {

        this.previousVersion = previousVersion;
        return this;
    }

    /**
     * the previous version the platform was in or empty if there is none
     * 
     * @return previousVersion
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PREVIOUS_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPreviousVersion() {
        return previousVersion;
    }

    @JsonProperty(JSON_PROPERTY_PREVIOUS_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPreviousVersion(String previousVersion) {
        this.previousVersion = previousVersion;
    }

    public Platform createdBy(String createdBy) {

        this.createdBy = createdBy;
        return this;
    }

    /**
     * the user name of the platform administrator
     * 
     * @return createdBy
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCreatedBy() {
        return createdBy;
    }

    @JsonProperty(JSON_PROPERTY_CREATED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Platform created(String created) {

        this.created = created;
        return this;
    }

    /**
     * the creation date
     * 
     * @return created
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCreated() {
        return created;
    }

    @JsonProperty(JSON_PROPERTY_CREATED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Platform platform = (Platform) o;
        return Objects.equals(this.state, platform.state) &&
                Objects.equals(this.version, platform.version) &&
                Objects.equals(this.initialVersion, platform.initialVersion) &&
                Objects.equals(this.previousVersion, platform.previousVersion) &&
                Objects.equals(this.createdBy, platform.createdBy) &&
                Objects.equals(this.created, platform.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, version, initialVersion, previousVersion, createdBy, created);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Platform {\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    initialVersion: ").append(toIndentedString(initialVersion)).append("\n");
        sb.append("    previousVersion: ").append(toIndentedString(previousVersion)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    created: ").append(toIndentedString(created)).append("\n");
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
