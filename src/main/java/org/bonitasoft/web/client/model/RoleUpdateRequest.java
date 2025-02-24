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
 * RoleUpdateRequest
 */
@JsonPropertyOrder({
        RoleUpdateRequest.JSON_PROPERTY_NAME,
        RoleUpdateRequest.JSON_PROPERTY_DISPLAY_NAME,
        RoleUpdateRequest.JSON_PROPERTY_DESCRIPTION,
        RoleUpdateRequest.JSON_PROPERTY_ICON
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class RoleUpdateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_NAME = "name";
    @jakarta.annotation.Nonnull
    private String name;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    @jakarta.annotation.Nullable
    private String displayName;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    @jakarta.annotation.Nullable
    private String description;

    public static final String JSON_PROPERTY_ICON = "icon";
    @jakarta.annotation.Nullable
    private String icon;

    public RoleUpdateRequest() {
    }

    public RoleUpdateRequest name(@jakarta.annotation.Nonnull String name) {

        this.name = name;
        return this;
    }

    /**
     * name
     * 
     * @return name
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setName(@jakarta.annotation.Nonnull String name) {
        this.name = name;
    }

    public RoleUpdateRequest displayName(@jakarta.annotation.Nullable String displayName) {

        this.displayName = displayName;
        return this;
    }

    /**
     * display name
     * 
     * @return displayName
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDisplayName(@jakarta.annotation.Nullable String displayName) {
        this.displayName = displayName;
    }

    public RoleUpdateRequest description(@jakarta.annotation.Nullable String description) {

        this.description = description;
        return this;
    }

    /**
     * description
     * 
     * @return description
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDescription() {
        return description;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDescription(@jakarta.annotation.Nullable String description) {
        this.description = description;
    }

    public RoleUpdateRequest icon(@jakarta.annotation.Nullable String icon) {

        this.icon = icon;
        return this;
    }

    /**
     * icon path
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
        RoleUpdateRequest roleUpdateRequest = (RoleUpdateRequest) o;
        return Objects.equals(this.name, roleUpdateRequest.name) &&
                Objects.equals(this.displayName, roleUpdateRequest.displayName) &&
                Objects.equals(this.description, roleUpdateRequest.description) &&
                Objects.equals(this.icon, roleUpdateRequest.icon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, displayName, description, icon);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RoleUpdateRequest {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
