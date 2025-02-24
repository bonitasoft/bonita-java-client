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
 * Group
 */
@JsonPropertyOrder({
        Group.JSON_PROPERTY_ID,
        Group.JSON_PROPERTY_NAME,
        Group.JSON_PROPERTY_DISPLAY_NAME,
        Group.JSON_PROPERTY_PARENT_PATH,
        Group.JSON_PROPERTY_PARENT_GROUP_ID,
        Group.JSON_PROPERTY_PATH,
        Group.JSON_PROPERTY_DESCRIPTION,
        Group.JSON_PROPERTY_CREATION_DATE,
        Group.JSON_PROPERTY_CREATED_BY_USER_ID,
        Group.JSON_PROPERTY_LAST_UPDATE_DATE,
        Group.JSON_PROPERTY_ICON
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    @jakarta.annotation.Nullable
    private String id;

    public static final String JSON_PROPERTY_NAME = "name";
    @jakarta.annotation.Nonnull
    private String name;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    @jakarta.annotation.Nullable
    private String displayName;

    public static final String JSON_PROPERTY_PARENT_PATH = "parent_path";
    @jakarta.annotation.Nullable
    private String parentPath;

    public static final String JSON_PROPERTY_PARENT_GROUP_ID = "parent_group_id";
    @jakarta.annotation.Nullable
    private String parentGroupId;

    public static final String JSON_PROPERTY_PATH = "path";
    @jakarta.annotation.Nullable
    private String path;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    @jakarta.annotation.Nullable
    private String description;

    public static final String JSON_PROPERTY_CREATION_DATE = "creation_date";
    @jakarta.annotation.Nullable
    private String creationDate;

    public static final String JSON_PROPERTY_CREATED_BY_USER_ID = "created_by_user_id";
    @jakarta.annotation.Nullable
    private String createdByUserId;

    public static final String JSON_PROPERTY_LAST_UPDATE_DATE = "last_update_date";
    @jakarta.annotation.Nullable
    private String lastUpdateDate;

    public static final String JSON_PROPERTY_ICON = "icon";
    @jakarta.annotation.Nullable
    private String icon;

    public Group() {
    }

    public Group id(@jakarta.annotation.Nullable String id) {

        this.id = id;
        return this;
    }

    /**
     * group ID
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

    public Group name(@jakarta.annotation.Nonnull String name) {

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

    public Group displayName(@jakarta.annotation.Nullable String displayName) {

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

    public Group parentPath(@jakarta.annotation.Nullable String parentPath) {

        this.parentPath = parentPath;
        return this;
    }

    /**
     * the path of the parent group of this group (empty if the group has no parent)
     * 
     * @return parentPath
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PARENT_PATH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getParentPath() {
        return parentPath;
    }

    @JsonProperty(JSON_PROPERTY_PARENT_PATH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setParentPath(@jakarta.annotation.Nullable String parentPath) {
        this.parentPath = parentPath;
    }

    public Group parentGroupId(@jakarta.annotation.Nullable String parentGroupId) {

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
    public void setParentGroupId(@jakarta.annotation.Nullable String parentGroupId) {
        this.parentGroupId = parentGroupId;
    }

    public Group path(@jakarta.annotation.Nullable String path) {

        this.path = path;
        return this;
    }

    /**
     * the full path of the group (including its parent path)
     * 
     * @return path
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PATH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPath() {
        return path;
    }

    @JsonProperty(JSON_PROPERTY_PATH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPath(@jakarta.annotation.Nullable String path) {
        this.path = path;
    }

    public Group description(@jakarta.annotation.Nullable String description) {

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

    public Group creationDate(@jakarta.annotation.Nullable String creationDate) {

        this.creationDate = creationDate;
        return this;
    }

    /**
     * creation date (format: &#x60;2014-12-31 15:17:24.736&#x60;)
     * 
     * @return creationDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATION_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCreationDate() {
        return creationDate;
    }

    @JsonProperty(JSON_PROPERTY_CREATION_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreationDate(@jakarta.annotation.Nullable String creationDate) {
        this.creationDate = creationDate;
    }

    public Group createdByUserId(@jakarta.annotation.Nullable String createdByUserId) {

        this.createdByUserId = createdByUserId;
        return this;
    }

    /**
     * id of the user who created the group (-1 if the group was created by the technical admin or by an organisation import)
     * 
     * @return createdByUserId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_BY_USER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCreatedByUserId() {
        return createdByUserId;
    }

    @JsonProperty(JSON_PROPERTY_CREATED_BY_USER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreatedByUserId(@jakarta.annotation.Nullable String createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public Group lastUpdateDate(@jakarta.annotation.Nullable String lastUpdateDate) {

        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    /**
     * last update date (format: &#x60;2014-12-31 15:17:24.736&#x60;)
     * 
     * @return lastUpdateDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LAST_UPDATE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    @JsonProperty(JSON_PROPERTY_LAST_UPDATE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLastUpdateDate(@jakarta.annotation.Nullable String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Group icon(@jakarta.annotation.Nullable String icon) {

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
        Group group = (Group) o;
        return Objects.equals(this.id, group.id) &&
                Objects.equals(this.name, group.name) &&
                Objects.equals(this.displayName, group.displayName) &&
                Objects.equals(this.parentPath, group.parentPath) &&
                Objects.equals(this.parentGroupId, group.parentGroupId) &&
                Objects.equals(this.path, group.path) &&
                Objects.equals(this.description, group.description) &&
                Objects.equals(this.creationDate, group.creationDate) &&
                Objects.equals(this.createdByUserId, group.createdByUserId) &&
                Objects.equals(this.lastUpdateDate, group.lastUpdateDate) &&
                Objects.equals(this.icon, group.icon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, displayName, parentPath, parentGroupId, path, description, creationDate,
                createdByUserId, lastUpdateDate, icon);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Group {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    parentPath: ").append(toIndentedString(parentPath)).append("\n");
        sb.append("    parentGroupId: ").append(toIndentedString(parentGroupId)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    createdByUserId: ").append(toIndentedString(createdByUserId)).append("\n");
        sb.append("    lastUpdateDate: ").append(toIndentedString(lastUpdateDate)).append("\n");
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
