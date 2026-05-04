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
 * Profile entry
 */
@JsonPropertyOrder({
        ProfileEntry.JSON_PROPERTY_ID,
        ProfileEntry.JSON_PROPERTY_ICON,
        ProfileEntry.JSON_PROPERTY_INDEX,
        ProfileEntry.JSON_PROPERTY_PROFILE_ID,
        ProfileEntry.JSON_PROPERTY_PAGE,
        ProfileEntry.JSON_PROPERTY_DESCRIPTION,
        ProfileEntry.JSON_PROPERTY_NAME,
        ProfileEntry.JSON_PROPERTY_TYPE,
        ProfileEntry.JSON_PROPERTY_IS_CUSTOM,
        ProfileEntry.JSON_PROPERTY_PARENT_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class ProfileEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    @jakarta.annotation.Nullable
    private String id;

    public static final String JSON_PROPERTY_ICON = "icon";
    @jakarta.annotation.Nullable
    private String icon;

    public static final String JSON_PROPERTY_INDEX = "index";
    @jakarta.annotation.Nullable
    private String index;

    public static final String JSON_PROPERTY_PROFILE_ID = "profile_id";
    @jakarta.annotation.Nullable
    private String profileId;

    public static final String JSON_PROPERTY_PAGE = "page";
    @jakarta.annotation.Nullable
    private String page;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    @jakarta.annotation.Nullable
    private String description;

    public static final String JSON_PROPERTY_NAME = "name";
    @jakarta.annotation.Nullable
    private String name;

    public static final String JSON_PROPERTY_TYPE = "type";
    @jakarta.annotation.Nullable
    private String type;

    public static final String JSON_PROPERTY_IS_CUSTOM = "isCustom";
    @jakarta.annotation.Nullable
    private Boolean isCustom;

    public static final String JSON_PROPERTY_PARENT_ID = "parent_id";
    @jakarta.annotation.Nullable
    private String parentId;

    public ProfileEntry() {
    }

    public ProfileEntry id(@jakarta.annotation.Nullable String id) {

        this.id = id;
        return this;
    }

    /**
     * profileEntry id
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

    public ProfileEntry icon(@jakarta.annotation.Nullable String icon) {

        this.icon = icon;
        return this;
    }

    /**
     * icon used in the portal to represent a profileEntry
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

    public ProfileEntry index(@jakarta.annotation.Nullable String index) {

        this.index = index;
        return this;
    }

    /**
     * position in a menu
     * 
     * @return index
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INDEX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getIndex() {
        return index;
    }

    @JsonProperty(JSON_PROPERTY_INDEX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIndex(@jakarta.annotation.Nullable String index) {
        this.index = index;
    }

    public ProfileEntry profileId(@jakarta.annotation.Nullable String profileId) {

        this.profileId = profileId;
        return this;
    }

    /**
     * id of the profile that contains this profileEntry
     * 
     * @return profileId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PROFILE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getProfileId() {
        return profileId;
    }

    @JsonProperty(JSON_PROPERTY_PROFILE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProfileId(@jakarta.annotation.Nullable String profileId) {
        this.profileId = profileId;
    }

    public ProfileEntry page(@jakarta.annotation.Nullable String page) {

        this.page = page;
        return this;
    }

    /**
     * pageToken (menu name or menu item name) used in a portal menu to identify the page associated with the profileEntry
     * 
     * @return page
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPage() {
        return page;
    }

    @JsonProperty(JSON_PROPERTY_PAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPage(@jakarta.annotation.Nullable String page) {
        this.page = page;
    }

    public ProfileEntry description(@jakarta.annotation.Nullable String description) {

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

    public ProfileEntry name(@jakarta.annotation.Nullable String name) {

        this.name = name;
        return this;
    }

    /**
     * name of the profileEntry
     * 
     * @return name
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setName(@jakarta.annotation.Nullable String name) {
        this.name = name;
    }

    public ProfileEntry type(@jakarta.annotation.Nullable String type) {

        this.type = type;
        return this;
    }

    /**
     * link (if menu item) | folder (if menu)
     * 
     * @return type
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setType(@jakarta.annotation.Nullable String type) {
        this.type = type;
    }

    public ProfileEntry isCustom(@jakarta.annotation.Nullable Boolean isCustom) {

        this.isCustom = isCustom;
        return this;
    }

    /**
     * true | false
     * 
     * @return isCustom
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_IS_CUSTOM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getIsCustom() {
        return isCustom;
    }

    @JsonProperty(JSON_PROPERTY_IS_CUSTOM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIsCustom(@jakarta.annotation.Nullable Boolean isCustom) {
        this.isCustom = isCustom;
    }

    public ProfileEntry parentId(@jakarta.annotation.Nullable String parentId) {

        this.parentId = parentId;
        return this;
    }

    /**
     * id or parent profileEntry if in a folder
     * 
     * @return parentId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PARENT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getParentId() {
        return parentId;
    }

    @JsonProperty(JSON_PROPERTY_PARENT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setParentId(@jakarta.annotation.Nullable String parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProfileEntry profileEntry = (ProfileEntry) o;
        return Objects.equals(this.id, profileEntry.id) &&
                Objects.equals(this.icon, profileEntry.icon) &&
                Objects.equals(this.index, profileEntry.index) &&
                Objects.equals(this.profileId, profileEntry.profileId) &&
                Objects.equals(this.page, profileEntry.page) &&
                Objects.equals(this.description, profileEntry.description) &&
                Objects.equals(this.name, profileEntry.name) &&
                Objects.equals(this.type, profileEntry.type) &&
                Objects.equals(this.isCustom, profileEntry.isCustom) &&
                Objects.equals(this.parentId, profileEntry.parentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, icon, index, profileId, page, description, name, type, isCustom, parentId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProfileEntry {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
        sb.append("    index: ").append(toIndentedString(index)).append("\n");
        sb.append("    profileId: ").append(toIndentedString(profileId)).append("\n");
        sb.append("    page: ").append(toIndentedString(page)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    isCustom: ").append(toIndentedString(isCustom)).append("\n");
        sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
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
