/** 
 * Copyright (C) 2022 BonitaSoft S.A.
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
 * ProfileEntryCreateRequest
 */
@JsonPropertyOrder({
        ProfileEntryCreateRequest.JSON_PROPERTY_PROFILE_ID,
        ProfileEntryCreateRequest.JSON_PROPERTY_PAGE,
        ProfileEntryCreateRequest.JSON_PROPERTY_DESCRIPTION,
        ProfileEntryCreateRequest.JSON_PROPERTY_NAME,
        ProfileEntryCreateRequest.JSON_PROPERTY_TYPE,
        ProfileEntryCreateRequest.JSON_PROPERTY_IS_CUSTOM,
        ProfileEntryCreateRequest.JSON_PROPERTY_PARENT_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ProfileEntryCreateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_PROFILE_ID = "profile_id";
    private String profileId;

    public static final String JSON_PROPERTY_PAGE = "page";
    private String page;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_TYPE = "type";
    private String type;

    public static final String JSON_PROPERTY_IS_CUSTOM = "isCustom";
    private Boolean isCustom;

    public static final String JSON_PROPERTY_PARENT_ID = "parent_id";
    private String parentId;

    public ProfileEntryCreateRequest() {
    }

    public ProfileEntryCreateRequest profileId(String profileId) {

        this.profileId = profileId;
        return this;
    }

    /**
     * id of the profile that contains this profileEntry
     * 
     * @return profileId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PROFILE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getProfileId() {
        return profileId;
    }

    @JsonProperty(JSON_PROPERTY_PROFILE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public ProfileEntryCreateRequest page(String page) {

        this.page = page;
        return this;
    }

    /**
     * pageToken (menu name or menu item name) used in a portal menu to identify the page associated with the profileEntry
     * 
     * @return page
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPage() {
        return page;
    }

    @JsonProperty(JSON_PROPERTY_PAGE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPage(String page) {
        this.page = page;
    }

    public ProfileEntryCreateRequest description(String description) {

        this.description = description;
        return this;
    }

    /**
     * description
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

    public ProfileEntryCreateRequest name(String name) {

        this.name = name;
        return this;
    }

    /**
     * name of the profileEntry
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

    public ProfileEntryCreateRequest type(String type) {

        this.type = type;
        return this;
    }

    /**
     * link (if menu item) | folder (if menu)
     * 
     * @return type
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setType(String type) {
        this.type = type;
    }

    public ProfileEntryCreateRequest isCustom(Boolean isCustom) {

        this.isCustom = isCustom;
        return this;
    }

    /**
     * true | false
     * 
     * @return isCustom
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_IS_CUSTOM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getIsCustom() {
        return isCustom;
    }

    @JsonProperty(JSON_PROPERTY_IS_CUSTOM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIsCustom(Boolean isCustom) {
        this.isCustom = isCustom;
    }

    public ProfileEntryCreateRequest parentId(String parentId) {

        this.parentId = parentId;
        return this;
    }

    /**
     * id or parent profileEntry if in a folder
     * 
     * @return parentId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PARENT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getParentId() {
        return parentId;
    }

    @JsonProperty(JSON_PROPERTY_PARENT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setParentId(String parentId) {
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
        ProfileEntryCreateRequest profileEntryCreateRequest = (ProfileEntryCreateRequest) o;
        return Objects.equals(this.profileId, profileEntryCreateRequest.profileId) &&
                Objects.equals(this.page, profileEntryCreateRequest.page) &&
                Objects.equals(this.description, profileEntryCreateRequest.description) &&
                Objects.equals(this.name, profileEntryCreateRequest.name) &&
                Objects.equals(this.type, profileEntryCreateRequest.type) &&
                Objects.equals(this.isCustom, profileEntryCreateRequest.isCustom) &&
                Objects.equals(this.parentId, profileEntryCreateRequest.parentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profileId, page, description, name, type, isCustom, parentId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProfileEntryCreateRequest {\n");
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
