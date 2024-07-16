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
 * GroupCreateRequest
 */
@JsonPropertyOrder({
        GroupCreateRequest.JSON_PROPERTY_NAME,
        GroupCreateRequest.JSON_PROPERTY_DISPLAY_NAME,
        GroupCreateRequest.JSON_PROPERTY_PARENT_GROUP_ID,
        GroupCreateRequest.JSON_PROPERTY_DESCRIPTION,
        GroupCreateRequest.JSON_PROPERTY_ICON
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class GroupCreateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    private String displayName;

    public static final String JSON_PROPERTY_PARENT_GROUP_ID = "parent_group_id";
    private String parentGroupId;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_ICON = "icon";
    private String icon;

    public GroupCreateRequest() {
    }

    public GroupCreateRequest name(String name) {

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
    public void setName(String name) {
        this.name = name;
    }

    public GroupCreateRequest displayName(String displayName) {

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
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public GroupCreateRequest parentGroupId(String parentGroupId) {

        this.parentGroupId = parentGroupId;
        return this;
    }

    /**
     * the id of the parent group of this group (empty if the group has no parent)
     * 
     * @return parentGroupId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PARENT_GROUP_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getParentGroupId() {
        return parentGroupId;
    }

    @JsonProperty(JSON_PROPERTY_PARENT_GROUP_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setParentGroupId(String parentGroupId) {
        this.parentGroupId = parentGroupId;
    }

    public GroupCreateRequest description(String description) {

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
    public void setDescription(String description) {
        this.description = description;
    }

    public GroupCreateRequest icon(String icon) {

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
    public void setIcon(String icon) {
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
        GroupCreateRequest groupCreateRequest = (GroupCreateRequest) o;
        return Objects.equals(this.name, groupCreateRequest.name) &&
                Objects.equals(this.displayName, groupCreateRequest.displayName) &&
                Objects.equals(this.parentGroupId, groupCreateRequest.parentGroupId) &&
                Objects.equals(this.description, groupCreateRequest.description) &&
                Objects.equals(this.icon, groupCreateRequest.icon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, displayName, parentGroupId, description, icon);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GroupCreateRequest {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    parentGroupId: ").append(toIndentedString(parentGroupId)).append("\n");
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
