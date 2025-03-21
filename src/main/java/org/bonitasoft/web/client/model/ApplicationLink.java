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
 * Contains the meta information of a Bonita Living Application Link.
 */
@JsonPropertyOrder({
        ApplicationLink.JSON_PROPERTY_CREATED_BY,
        ApplicationLink.JSON_PROPERTY_CREATION_DATE,
        ApplicationLink.JSON_PROPERTY_DESCRIPTION,
        ApplicationLink.JSON_PROPERTY_DISPLAY_NAME,
        ApplicationLink.JSON_PROPERTY_ID,
        ApplicationLink.JSON_PROPERTY_LAST_UPDATE_DATE,
        ApplicationLink.JSON_PROPERTY_PROFILE_ID,
        ApplicationLink.JSON_PROPERTY_TOKEN,
        ApplicationLink.JSON_PROPERTY_UPDATED_BY,
        ApplicationLink.JSON_PROPERTY_VERSION,
        ApplicationLink.JSON_PROPERTY_STATE,
        ApplicationLink.JSON_PROPERTY_VISIBILITY,
        ApplicationLink.JSON_PROPERTY_EDITABLE,
        ApplicationLink.JSON_PROPERTY_LINK
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class ApplicationLink implements Serializable, Application {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_CREATED_BY = "createdBy";
    @jakarta.annotation.Nullable
    private String createdBy;

    public static final String JSON_PROPERTY_CREATION_DATE = "creationDate";
    @jakarta.annotation.Nullable
    private String creationDate;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    @jakarta.annotation.Nullable
    private String description;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    @jakarta.annotation.Nullable
    private String displayName;

    public static final String JSON_PROPERTY_ID = "id";
    @jakarta.annotation.Nullable
    private String id;

    public static final String JSON_PROPERTY_LAST_UPDATE_DATE = "lastUpdateDate";
    @jakarta.annotation.Nullable
    private String lastUpdateDate;

    public static final String JSON_PROPERTY_PROFILE_ID = "profileId";
    @jakarta.annotation.Nullable
    private String profileId;

    public static final String JSON_PROPERTY_TOKEN = "token";
    @jakarta.annotation.Nullable
    private String token;

    public static final String JSON_PROPERTY_UPDATED_BY = "updatedBy";
    @jakarta.annotation.Nullable
    private String updatedBy;

    public static final String JSON_PROPERTY_VERSION = "version";
    @jakarta.annotation.Nullable
    private String version;

    /**
     * application state
     */
    public enum StateEnum {

        ACTIVATED(String.valueOf("ACTIVATED")),

        DEACTIVATED(String.valueOf("DEACTIVATED"));

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
    @jakarta.annotation.Nullable
    private StateEnum state;

    /**
     * visibility of the Application. This value is purely indicative, changing it in the application object won&#39;t change the accessibility to the actual
     * application.
     */
    public enum VisibilityEnum {

        ALL(String.valueOf("ALL")),

        TECHNICAL_USER(String.valueOf("TECHNICAL_USER")),

        RESTRICTED(String.valueOf("RESTRICTED"));

        private String value;

        VisibilityEnum(String value) {
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
        public static VisibilityEnum fromValue(String value) {
            for (VisibilityEnum b : VisibilityEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_VISIBILITY = "visibility";
    @jakarta.annotation.Nullable
    private VisibilityEnum visibility;

    public static final String JSON_PROPERTY_EDITABLE = "editable";
    @jakarta.annotation.Nullable
    private Boolean editable;

    public static final String JSON_PROPERTY_LINK = "link";
    @jakarta.annotation.Nullable
    private Boolean link;

    public ApplicationLink() {
    }

    public ApplicationLink createdBy(@jakarta.annotation.Nullable String createdBy) {

        this.createdBy = createdBy;
        return this;
    }

    /**
     * Author user ID
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

    public ApplicationLink creationDate(@jakarta.annotation.Nullable String creationDate) {

        this.creationDate = creationDate;
        return this;
    }

    /**
     * creation date of the application
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

    public ApplicationLink description(@jakarta.annotation.Nullable String description) {

        this.description = description;
        return this;
    }

    /**
     * description of the application
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

    public ApplicationLink displayName(@jakarta.annotation.Nullable String displayName) {

        this.displayName = displayName;
        return this;
    }

    /**
     * display name of the application
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

    public ApplicationLink id(@jakarta.annotation.Nullable String id) {

        this.id = id;
        return this;
    }

    /**
     * id of the application
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

    public ApplicationLink lastUpdateDate(@jakarta.annotation.Nullable String lastUpdateDate) {

        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    /**
     * last update date of the application
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

    public ApplicationLink profileId(@jakarta.annotation.Nullable String profileId) {

        this.profileId = profileId;
        return this;
    }

    /**
     * profile authorized to access this application
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

    public ApplicationLink token(@jakarta.annotation.Nullable String token) {

        this.token = token;
        return this;
    }

    /**
     * token of the application used to build the application URL
     * 
     * @return token
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TOKEN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getToken() {
        return token;
    }

    @JsonProperty(JSON_PROPERTY_TOKEN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setToken(@jakarta.annotation.Nullable String token) {
        this.token = token;
    }

    public ApplicationLink updatedBy(@jakarta.annotation.Nullable String updatedBy) {

        this.updatedBy = updatedBy;
        return this;
    }

    /**
     * Last updating user ID
     * 
     * @return updatedBy
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUpdatedBy() {
        return updatedBy;
    }

    @JsonProperty(JSON_PROPERTY_UPDATED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUpdatedBy(@jakarta.annotation.Nullable String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public ApplicationLink version(@jakarta.annotation.Nullable String version) {

        this.version = version;
        return this;
    }

    /**
     * version of the application
     * 
     * @return version
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getVersion() {
        return version;
    }

    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVersion(@jakarta.annotation.Nullable String version) {
        this.version = version;
    }

    public ApplicationLink state(@jakarta.annotation.Nullable StateEnum state) {

        this.state = state;
        return this;
    }

    /**
     * application state
     * 
     * @return state
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public StateEnum getState() {
        return state;
    }

    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setState(@jakarta.annotation.Nullable StateEnum state) {
        this.state = state;
    }

    public ApplicationLink visibility(@jakarta.annotation.Nullable VisibilityEnum visibility) {

        this.visibility = visibility;
        return this;
    }

    /**
     * visibility of the Application. This value is purely indicative, changing it in the application object won&#39;t change the accessibility to the actual
     * application.
     * 
     * @return visibility
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VISIBILITY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public VisibilityEnum getVisibility() {
        return visibility;
    }

    @JsonProperty(JSON_PROPERTY_VISIBILITY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVisibility(@jakarta.annotation.Nullable VisibilityEnum visibility) {
        this.visibility = visibility;
    }

    public ApplicationLink editable(@jakarta.annotation.Nullable Boolean editable) {

        this.editable = editable;
        return this;
    }

    /**
     * Indicates whether the application can be modified
     * 
     * @return editable
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EDITABLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getEditable() {
        return editable;
    }

    @JsonProperty(JSON_PROPERTY_EDITABLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEditable(@jakarta.annotation.Nullable Boolean editable) {
        this.editable = editable;
    }

    public ApplicationLink link(@jakarta.annotation.Nullable Boolean link) {

        this.link = link;
        return this;
    }

    /**
     * true for an application link
     * 
     * @return link
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LINK)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getLink() {
        return link;
    }

    @JsonProperty(JSON_PROPERTY_LINK)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLink(@jakarta.annotation.Nullable Boolean link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApplicationLink applicationLink = (ApplicationLink) o;
        return Objects.equals(this.createdBy, applicationLink.createdBy) &&
                Objects.equals(this.creationDate, applicationLink.creationDate) &&
                Objects.equals(this.description, applicationLink.description) &&
                Objects.equals(this.displayName, applicationLink.displayName) &&
                Objects.equals(this.id, applicationLink.id) &&
                Objects.equals(this.lastUpdateDate, applicationLink.lastUpdateDate) &&
                Objects.equals(this.profileId, applicationLink.profileId) &&
                Objects.equals(this.token, applicationLink.token) &&
                Objects.equals(this.updatedBy, applicationLink.updatedBy) &&
                Objects.equals(this.version, applicationLink.version) &&
                Objects.equals(this.state, applicationLink.state) &&
                Objects.equals(this.visibility, applicationLink.visibility) &&
                Objects.equals(this.editable, applicationLink.editable) &&
                Objects.equals(this.link, applicationLink.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdBy, creationDate, description, displayName, id, lastUpdateDate, profileId, token,
                updatedBy, version, state, visibility, editable, link);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApplicationLink {\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    lastUpdateDate: ").append(toIndentedString(lastUpdateDate)).append("\n");
        sb.append("    profileId: ").append(toIndentedString(profileId)).append("\n");
        sb.append("    token: ").append(toIndentedString(token)).append("\n");
        sb.append("    updatedBy: ").append(toIndentedString(updatedBy)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    visibility: ").append(toIndentedString(visibility)).append("\n");
        sb.append("    editable: ").append(toIndentedString(editable)).append("\n");
        sb.append("    link: ").append(toIndentedString(link)).append("\n");
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
