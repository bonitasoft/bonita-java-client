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
 * Contains the meta information of a legacy Bonita Living Application.
 */
@JsonPropertyOrder({
        LegacyApplication.JSON_PROPERTY_CREATED_BY,
        LegacyApplication.JSON_PROPERTY_CREATION_DATE,
        LegacyApplication.JSON_PROPERTY_DESCRIPTION,
        LegacyApplication.JSON_PROPERTY_DISPLAY_NAME,
        LegacyApplication.JSON_PROPERTY_ID,
        LegacyApplication.JSON_PROPERTY_LAST_UPDATE_DATE,
        LegacyApplication.JSON_PROPERTY_PROFILE_ID,
        LegacyApplication.JSON_PROPERTY_TOKEN,
        LegacyApplication.JSON_PROPERTY_UPDATED_BY,
        LegacyApplication.JSON_PROPERTY_VERSION,
        LegacyApplication.JSON_PROPERTY_STATE,
        LegacyApplication.JSON_PROPERTY_VISIBILITY,
        LegacyApplication.JSON_PROPERTY_EDITABLE,
        LegacyApplication.JSON_PROPERTY_LINK,
        LegacyApplication.JSON_PROPERTY_HOME_PAGE_ID,
        LegacyApplication.JSON_PROPERTY_LAYOUT_ID,
        LegacyApplication.JSON_PROPERTY_THEME_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class LegacyApplication implements Serializable, Application {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_CREATED_BY = "createdBy";
    private String createdBy;

    public static final String JSON_PROPERTY_CREATION_DATE = "creationDate";
    private String creationDate;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    private String displayName;

    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_LAST_UPDATE_DATE = "lastUpdateDate";
    private String lastUpdateDate;

    public static final String JSON_PROPERTY_PROFILE_ID = "profileId";
    private String profileId;

    public static final String JSON_PROPERTY_TOKEN = "token";
    private String token;

    public static final String JSON_PROPERTY_UPDATED_BY = "updatedBy";
    private String updatedBy;

    public static final String JSON_PROPERTY_VERSION = "version";
    private String version;

    /**
     * application state
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

    /**
     * visibility of the Application. This value is purely indicative, changing it in the application object won&#39;t change the accessibility to the actual
     * application.
     */
    public enum VisibilityEnum {

        ALL("ALL"),

        TECHNICAL_USER("TECHNICAL_USER"),

        RESTRICTED("RESTRICTED");

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
    private VisibilityEnum visibility;

    public static final String JSON_PROPERTY_EDITABLE = "editable";
    private Boolean editable;

    public static final String JSON_PROPERTY_LINK = "link";
    private Boolean link;

    public static final String JSON_PROPERTY_HOME_PAGE_ID = "homePageId";
    private String homePageId;

    public static final String JSON_PROPERTY_LAYOUT_ID = "layoutId";
    private String layoutId;

    public static final String JSON_PROPERTY_THEME_ID = "themeId";
    private String themeId;

    public LegacyApplication() {
    }

    public LegacyApplication createdBy(String createdBy) {

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
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LegacyApplication creationDate(String creationDate) {

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
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public LegacyApplication description(String description) {

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
    public void setDescription(String description) {
        this.description = description;
    }

    public LegacyApplication displayName(String displayName) {

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
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public LegacyApplication id(String id) {

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
    public void setId(String id) {
        this.id = id;
    }

    public LegacyApplication lastUpdateDate(String lastUpdateDate) {

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
    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public LegacyApplication profileId(String profileId) {

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
    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public LegacyApplication token(String token) {

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
    public void setToken(String token) {
        this.token = token;
    }

    public LegacyApplication updatedBy(String updatedBy) {

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
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LegacyApplication version(String version) {

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
    public void setVersion(String version) {
        this.version = version;
    }

    public LegacyApplication state(StateEnum state) {

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
    public void setState(StateEnum state) {
        this.state = state;
    }

    public LegacyApplication visibility(VisibilityEnum visibility) {

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
    public void setVisibility(VisibilityEnum visibility) {
        this.visibility = visibility;
    }

    public LegacyApplication editable(Boolean editable) {

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
    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public LegacyApplication link(Boolean link) {

        this.link = link;
        return this;
    }

    /**
     * false for a legacy application
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
    public void setLink(Boolean link) {
        this.link = link;
    }

    public LegacyApplication homePageId(String homePageId) {

        this.homePageId = homePageId;
        return this;
    }

    /**
     * id of the application page used as the home page
     * 
     * @return homePageId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_HOME_PAGE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getHomePageId() {
        return homePageId;
    }

    @JsonProperty(JSON_PROPERTY_HOME_PAGE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setHomePageId(String homePageId) {
        this.homePageId = homePageId;
    }

    public LegacyApplication layoutId(String layoutId) {

        this.layoutId = layoutId;
        return this;
    }

    /**
     * id of the layout used by the application
     * 
     * @return layoutId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LAYOUT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLayoutId() {
        return layoutId;
    }

    @JsonProperty(JSON_PROPERTY_LAYOUT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLayoutId(String layoutId) {
        this.layoutId = layoutId;
    }

    public LegacyApplication themeId(String themeId) {

        this.themeId = themeId;
        return this;
    }

    /**
     * id of the theme used by the application
     * 
     * @return themeId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_THEME_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getThemeId() {
        return themeId;
    }

    @JsonProperty(JSON_PROPERTY_THEME_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LegacyApplication legacyApplication = (LegacyApplication) o;
        return Objects.equals(this.createdBy, legacyApplication.createdBy) &&
                Objects.equals(this.creationDate, legacyApplication.creationDate) &&
                Objects.equals(this.description, legacyApplication.description) &&
                Objects.equals(this.displayName, legacyApplication.displayName) &&
                Objects.equals(this.id, legacyApplication.id) &&
                Objects.equals(this.lastUpdateDate, legacyApplication.lastUpdateDate) &&
                Objects.equals(this.profileId, legacyApplication.profileId) &&
                Objects.equals(this.token, legacyApplication.token) &&
                Objects.equals(this.updatedBy, legacyApplication.updatedBy) &&
                Objects.equals(this.version, legacyApplication.version) &&
                Objects.equals(this.state, legacyApplication.state) &&
                Objects.equals(this.visibility, legacyApplication.visibility) &&
                Objects.equals(this.editable, legacyApplication.editable) &&
                Objects.equals(this.link, legacyApplication.link) &&
                Objects.equals(this.homePageId, legacyApplication.homePageId) &&
                Objects.equals(this.layoutId, legacyApplication.layoutId) &&
                Objects.equals(this.themeId, legacyApplication.themeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdBy, creationDate, description, displayName, id, lastUpdateDate, profileId, token,
                updatedBy, version, state, visibility, editable, link, homePageId, layoutId, themeId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LegacyApplication {\n");
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
        sb.append("    homePageId: ").append(toIndentedString(homePageId)).append("\n");
        sb.append("    layoutId: ").append(toIndentedString(layoutId)).append("\n");
        sb.append("    themeId: ").append(toIndentedString(themeId)).append("\n");
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
