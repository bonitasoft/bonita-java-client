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
 * ApplicationUpdateRequest
 */
@JsonPropertyOrder({
        ApplicationUpdateRequest.JSON_PROPERTY_DESCRIPTION,
        ApplicationUpdateRequest.JSON_PROPERTY_DISPLAY_NAME,
        ApplicationUpdateRequest.JSON_PROPERTY_PROFILE_ID,
        ApplicationUpdateRequest.JSON_PROPERTY_TOKEN,
        ApplicationUpdateRequest.JSON_PROPERTY_VERSION,
        ApplicationUpdateRequest.JSON_PROPERTY_THEME_ID,
        ApplicationUpdateRequest.JSON_PROPERTY_LAYOUT_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class ApplicationUpdateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    private String displayName;

    public static final String JSON_PROPERTY_PROFILE_ID = "profileId";
    private String profileId;

    public static final String JSON_PROPERTY_TOKEN = "token";
    private String token;

    public static final String JSON_PROPERTY_VERSION = "version";
    private String version;

    public static final String JSON_PROPERTY_THEME_ID = "themeId";
    private String themeId;

    public static final String JSON_PROPERTY_LAYOUT_ID = "layoutId";
    private String layoutId;

    public ApplicationUpdateRequest() {
    }

    public ApplicationUpdateRequest description(String description) {

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

    public ApplicationUpdateRequest displayName(String displayName) {

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

    public ApplicationUpdateRequest profileId(String profileId) {

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

    public ApplicationUpdateRequest token(String token) {

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

    public ApplicationUpdateRequest version(String version) {

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

    public ApplicationUpdateRequest themeId(String themeId) {

        this.themeId = themeId;
        return this;
    }

    /**
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) theme id for the application
     * 
     * @return themeId
     **/
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

    public ApplicationUpdateRequest layoutId(String layoutId) {

        this.layoutId = layoutId;
        return this;
    }

    /**
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) layout id for the application
     * 
     * @return layoutId
     **/
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApplicationUpdateRequest applicationUpdateRequest = (ApplicationUpdateRequest) o;
        return Objects.equals(this.description, applicationUpdateRequest.description) &&
                Objects.equals(this.displayName, applicationUpdateRequest.displayName) &&
                Objects.equals(this.profileId, applicationUpdateRequest.profileId) &&
                Objects.equals(this.token, applicationUpdateRequest.token) &&
                Objects.equals(this.version, applicationUpdateRequest.version) &&
                Objects.equals(this.themeId, applicationUpdateRequest.themeId) &&
                Objects.equals(this.layoutId, applicationUpdateRequest.layoutId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, displayName, profileId, token, version, themeId, layoutId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApplicationUpdateRequest {\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    profileId: ").append(toIndentedString(profileId)).append("\n");
        sb.append("    token: ").append(toIndentedString(token)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    themeId: ").append(toIndentedString(themeId)).append("\n");
        sb.append("    layoutId: ").append(toIndentedString(layoutId)).append("\n");
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
