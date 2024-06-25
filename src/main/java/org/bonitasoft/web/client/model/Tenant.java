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
 * Since Bonita 7.12, tenant management is deprecated
 * 
 * @deprecated
 */
@Deprecated
@JsonPropertyOrder({
        Tenant.JSON_PROPERTY_ID,
        Tenant.JSON_PROPERTY_CREATION,
        Tenant.JSON_PROPERTY_ICON,
        Tenant.JSON_PROPERTY_NAME,
        Tenant.JSON_PROPERTY_DESCRIPTION,
        Tenant.JSON_PROPERTY_USERNAME,
        Tenant.JSON_PROPERTY_PASSWORD,
        Tenant.JSON_PROPERTY_STATE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class Tenant implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_CREATION = "creation";
    private String creation;

    public static final String JSON_PROPERTY_ICON = "icon";
    private String icon;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_USERNAME = "username";
    private String username;

    public static final String JSON_PROPERTY_PASSWORD = "password";
    private String password;

    /**
     * the tenant state
     */
    public enum StateEnum {

        ACTIVATED("ACTIVATED"),

        DEACTIVATED("DEACTIVATED");

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

    public Tenant() {
    }

    public Tenant id(String id) {

        this.id = id;
        return this;
    }

    /**
     * id of the tenant
     * 
     * @return id
     **/
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

    public Tenant creation(String creation) {

        this.creation = creation;
        return this;
    }

    /**
     * the creation date
     * 
     * @return creation
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCreation() {
        return creation;
    }

    @JsonProperty(JSON_PROPERTY_CREATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreation(String creation) {
        this.creation = creation;
    }

    public Tenant icon(String icon) {

        this.icon = icon;
        return this;
    }

    /**
     * the path of the icon
     * 
     * @return icon
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ICON)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getIcon() {
        return icon;
    }

    @JsonProperty(JSON_PROPERTY_ICON)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Tenant name(String name) {

        this.name = name;
        return this;
    }

    /**
     * the name of the tenant
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

    public Tenant description(String description) {

        this.description = description;
        return this;
    }

    /**
     * the description
     * 
     * @return description
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDescription() {
        return description;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDescription(String description) {
        this.description = description;
    }

    public Tenant username(String username) {

        this.username = username;
        return this;
    }

    /**
     * the username
     * 
     * @return username
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_USERNAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUsername() {
        return username;
    }

    @JsonProperty(JSON_PROPERTY_USERNAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUsername(String username) {
        this.username = username;
    }

    public Tenant password(String password) {

        this.password = password;
        return this;
    }

    /**
     * the password
     * 
     * @return password
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PASSWORD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPassword() {
        return password;
    }

    @JsonProperty(JSON_PROPERTY_PASSWORD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPassword(String password) {
        this.password = password;
    }

    public Tenant state(StateEnum state) {

        this.state = state;
        return this;
    }

    /**
     * the tenant state
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tenant tenant = (Tenant) o;
        return Objects.equals(this.id, tenant.id) &&
                Objects.equals(this.creation, tenant.creation) &&
                Objects.equals(this.icon, tenant.icon) &&
                Objects.equals(this.name, tenant.name) &&
                Objects.equals(this.description, tenant.description) &&
                Objects.equals(this.username, tenant.username) &&
                Objects.equals(this.password, tenant.password) &&
                Objects.equals(this.state, tenant.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creation, icon, name, description, username, password, state);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Tenant {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    creation: ").append(toIndentedString(creation)).append("\n");
        sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    password: ").append("*").append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
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
