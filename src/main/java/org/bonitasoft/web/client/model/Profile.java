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
 * Profile
 */
@JsonPropertyOrder({
        Profile.JSON_PROPERTY_ID,
        Profile.JSON_PROPERTY_CREATION_DATE,
        Profile.JSON_PROPERTY_ICON,
        Profile.JSON_PROPERTY_CREATED_BY,
        Profile.JSON_PROPERTY_DESCRIPTION,
        Profile.JSON_PROPERTY_NAME,
        Profile.JSON_PROPERTY_ISDEFAULT,
        Profile.JSON_PROPERTY_LAST_UPDATE_DATE,
        Profile.JSON_PROPERTY_UPDATED_BY
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_CREATION_DATE = "creationDate";
    private String creationDate;

    public static final String JSON_PROPERTY_ICON = "icon";
    private String icon;

    public static final String JSON_PROPERTY_CREATED_BY = "createdBy";
    private String createdBy;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_ISDEFAULT = "isdefault";
    private Boolean isdefault;

    public static final String JSON_PROPERTY_LAST_UPDATE_DATE = "lastUpdateDate";
    private String lastUpdateDate;

    public static final String JSON_PROPERTY_UPDATED_BY = "updatedBy";
    private String updatedBy;

    public Profile() {
    }

    public Profile id(String id) {

        this.id = id;
        return this;
    }

    /**
     * profile id
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

    public Profile creationDate(String creationDate) {

        this.creationDate = creationDate;
        return this;
    }

    /**
     * date and time of profile creation
     * 
     * @return creationDate
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATION_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCreationDate() {
        return creationDate;
    }

    @JsonProperty(JSON_PROPERTY_CREATION_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Profile icon(String icon) {

        this.icon = icon;
        return this;
    }

    /**
     * icon used in the portal to represent the profile
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

    public Profile createdBy(String createdBy) {

        this.createdBy = createdBy;
        return this;
    }

    /**
     * id of the uer who created the profile
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

    public Profile description(String description) {

        this.description = description;
        return this;
    }

    /**
     * a description of the profile
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

    public Profile name(String name) {

        this.name = name;
        return this;
    }

    /**
     * profile name
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

    public Profile isdefault(Boolean isdefault) {

        this.isdefault = isdefault;
        return this;
    }

    /**
     * true | false
     * 
     * @return isdefault
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ISDEFAULT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getIsdefault() {
        return isdefault;
    }

    @JsonProperty(JSON_PROPERTY_ISDEFAULT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIsdefault(Boolean isdefault) {
        this.isdefault = isdefault;
    }

    public Profile lastUpdateDate(String lastUpdateDate) {

        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    /**
     * date and time of the last update to the profile
     * 
     * @return lastUpdateDate
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LAST_UPDATE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    @JsonProperty(JSON_PROPERTY_LAST_UPDATE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Profile updatedBy(String updatedBy) {

        this.updatedBy = updatedBy;
        return this;
    }

    /**
     * the id of the user who last updated the profile
     * 
     * @return updatedBy
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUpdatedBy() {
        return updatedBy;
    }

    @JsonProperty(JSON_PROPERTY_UPDATED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profile profile = (Profile) o;
        return Objects.equals(this.id, profile.id) &&
                Objects.equals(this.creationDate, profile.creationDate) &&
                Objects.equals(this.icon, profile.icon) &&
                Objects.equals(this.createdBy, profile.createdBy) &&
                Objects.equals(this.description, profile.description) &&
                Objects.equals(this.name, profile.name) &&
                Objects.equals(this.isdefault, profile.isdefault) &&
                Objects.equals(this.lastUpdateDate, profile.lastUpdateDate) &&
                Objects.equals(this.updatedBy, profile.updatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, icon, createdBy, description, name, isdefault, lastUpdateDate, updatedBy);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Profile {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    isdefault: ").append(toIndentedString(isdefault)).append("\n");
        sb.append("    lastUpdateDate: ").append(toIndentedString(lastUpdateDate)).append("\n");
        sb.append("    updatedBy: ").append(toIndentedString(updatedBy)).append("\n");
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
