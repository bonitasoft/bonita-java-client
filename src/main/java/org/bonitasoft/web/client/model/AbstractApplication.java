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
 * AbstractApplication
 */
@JsonPropertyOrder({
        AbstractApplication.JSON_PROPERTY_CREATED_BY,
        AbstractApplication.JSON_PROPERTY_CREATION_DATE,
        AbstractApplication.JSON_PROPERTY_DESCRIPTION,
        AbstractApplication.JSON_PROPERTY_DISPLAY_NAME,
        AbstractApplication.JSON_PROPERTY_ID,
        AbstractApplication.JSON_PROPERTY_LAST_UPDATE_DATE,
        AbstractApplication.JSON_PROPERTY_PROFILE_ID,
        AbstractApplication.JSON_PROPERTY_TOKEN,
        AbstractApplication.JSON_PROPERTY_UPDATED_BY,
        AbstractApplication.JSON_PROPERTY_VERSION,
        AbstractApplication.JSON_PROPERTY_STATE,
        AbstractApplication.JSON_PROPERTY_VISIBILITY,
        AbstractApplication.JSON_PROPERTY_EDITABLE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.5.0")
public class AbstractApplication implements Serializable {

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

    public AbstractApplication() {
    }

    public AbstractApplication createdBy(String createdBy) {

        this.createdBy = createdBy;
        return this;
    }

    /**
     * Author user ID
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

    public AbstractApplication creationDate(String creationDate) {

        this.creationDate = creationDate;
        return this;
    }

    /**
     * creation date of the application
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

    public AbstractApplication description(String description) {

        this.description = description;
        return this;
    }

    /**
     * description of the application
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

    public AbstractApplication displayName(String displayName) {

        this.displayName = displayName;
        return this;
    }

    /**
     * display name of the application
     * 
     * @return displayName
     **/
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

    public AbstractApplication id(String id) {

        this.id = id;
        return this;
    }

    /**
     * id of the application
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

    public AbstractApplication lastUpdateDate(String lastUpdateDate) {

        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    /**
     * last update date of the application
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

    public AbstractApplication profileId(String profileId) {

        this.profileId = profileId;
        return this;
    }

    /**
     * profile authorized to access this application
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

    public AbstractApplication token(String token) {

        this.token = token;
        return this;
    }

    /**
     * token of the application used to build the application URL
     * 
     * @return token
     **/
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

    public AbstractApplication updatedBy(String updatedBy) {

        this.updatedBy = updatedBy;
        return this;
    }

    /**
     * Last updating user ID
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

    public AbstractApplication version(String version) {

        this.version = version;
        return this;
    }

    /**
     * version of the application
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

    public AbstractApplication state(StateEnum state) {

        this.state = state;
        return this;
    }

    /**
     * application state
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

    public AbstractApplication visibility(VisibilityEnum visibility) {

        this.visibility = visibility;
        return this;
    }

    /**
     * visibility of the Application. This value is purely indicative, changing it in the application object won&#39;t change the accessibility to the actual
     * application.
     * 
     * @return visibility
     **/
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

    public AbstractApplication editable(Boolean editable) {

        this.editable = editable;
        return this;
    }

    /**
     * Indicates whether the application can be modified
     * 
     * @return editable
     **/
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractApplication abstractApplication = (AbstractApplication) o;
        return Objects.equals(this.createdBy, abstractApplication.createdBy) &&
                Objects.equals(this.creationDate, abstractApplication.creationDate) &&
                Objects.equals(this.description, abstractApplication.description) &&
                Objects.equals(this.displayName, abstractApplication.displayName) &&
                Objects.equals(this.id, abstractApplication.id) &&
                Objects.equals(this.lastUpdateDate, abstractApplication.lastUpdateDate) &&
                Objects.equals(this.profileId, abstractApplication.profileId) &&
                Objects.equals(this.token, abstractApplication.token) &&
                Objects.equals(this.updatedBy, abstractApplication.updatedBy) &&
                Objects.equals(this.version, abstractApplication.version) &&
                Objects.equals(this.state, abstractApplication.state) &&
                Objects.equals(this.visibility, abstractApplication.visibility) &&
                Objects.equals(this.editable, abstractApplication.editable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdBy, creationDate, description, displayName, id, lastUpdateDate, profileId, token,
                updatedBy, version, state, visibility, editable);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AbstractApplication {\n");
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
