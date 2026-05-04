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
 * Page
 */
@JsonPropertyOrder({
        Page.JSON_PROPERTY_ID,
        Page.JSON_PROPERTY_CREATION_DATE,
        Page.JSON_PROPERTY_CREATED_BY,
        Page.JSON_PROPERTY_IS_PROVIDED,
        Page.JSON_PROPERTY_DESCRIPTION,
        Page.JSON_PROPERTY_CONTENT_NAME,
        Page.JSON_PROPERTY_DISPLAY_NAME,
        Page.JSON_PROPERTY_UPDATED_BY,
        Page.JSON_PROPERTY_LAST_UPDATE_DATE,
        Page.JSON_PROPERTY_URL_TOKEN
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class Page implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    @jakarta.annotation.Nullable
    private String id;

    public static final String JSON_PROPERTY_CREATION_DATE = "creationDate";
    @jakarta.annotation.Nullable
    private String creationDate;

    public static final String JSON_PROPERTY_CREATED_BY = "createdBy";
    @jakarta.annotation.Nullable
    private String createdBy;

    public static final String JSON_PROPERTY_IS_PROVIDED = "isProvided";
    @jakarta.annotation.Nullable
    private Boolean isProvided;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    @jakarta.annotation.Nullable
    private String description;

    public static final String JSON_PROPERTY_CONTENT_NAME = "contentName";
    @jakarta.annotation.Nullable
    private String contentName;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    @jakarta.annotation.Nullable
    private String displayName;

    public static final String JSON_PROPERTY_UPDATED_BY = "updatedBy";
    @jakarta.annotation.Nullable
    private String updatedBy;

    public static final String JSON_PROPERTY_LAST_UPDATE_DATE = "lastUpdateDate";
    @jakarta.annotation.Nullable
    private String lastUpdateDate;

    public static final String JSON_PROPERTY_URL_TOKEN = "urlToken";
    @jakarta.annotation.Nullable
    private String urlToken;

    public Page() {
    }

    public Page id(@jakarta.annotation.Nullable String id) {

        this.id = id;
        return this;
    }

    /**
     * page id
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

    public Page creationDate(@jakarta.annotation.Nullable String creationDate) {

        this.creationDate = creationDate;
        return this;
    }

    /**
     * date and time
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

    public Page createdBy(@jakarta.annotation.Nullable String createdBy) {

        this.createdBy = createdBy;
        return this;
    }

    /**
     * created by user id
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

    public Page isProvided(@jakarta.annotation.Nullable Boolean isProvided) {

        this.isProvided = isProvided;
        return this;
    }

    /**
     * is provided
     * 
     * @return isProvided
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_IS_PROVIDED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getIsProvided() {
        return isProvided;
    }

    @JsonProperty(JSON_PROPERTY_IS_PROVIDED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIsProvided(@jakarta.annotation.Nullable Boolean isProvided) {
        this.isProvided = isProvided;
    }

    public Page description(@jakarta.annotation.Nullable String description) {

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

    public Page contentName(@jakarta.annotation.Nullable String contentName) {

        this.contentName = contentName;
        return this;
    }

    /**
     * content name
     * 
     * @return contentName
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONTENT_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getContentName() {
        return contentName;
    }

    @JsonProperty(JSON_PROPERTY_CONTENT_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContentName(@jakarta.annotation.Nullable String contentName) {
        this.contentName = contentName;
    }

    public Page displayName(@jakarta.annotation.Nullable String displayName) {

        this.displayName = displayName;
        return this;
    }

    /**
     * custom page display name
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

    public Page updatedBy(@jakarta.annotation.Nullable String updatedBy) {

        this.updatedBy = updatedBy;
        return this;
    }

    /**
     * updated by user id
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

    public Page lastUpdateDate(@jakarta.annotation.Nullable String lastUpdateDate) {

        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    /**
     * date and time
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

    public Page urlToken(@jakarta.annotation.Nullable String urlToken) {

        this.urlToken = urlToken;
        return this;
    }

    /**
     * custom page urlToken
     * 
     * @return urlToken
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_URL_TOKEN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUrlToken() {
        return urlToken;
    }

    @JsonProperty(JSON_PROPERTY_URL_TOKEN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUrlToken(@jakarta.annotation.Nullable String urlToken) {
        this.urlToken = urlToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Page page = (Page) o;
        return Objects.equals(this.id, page.id) &&
                Objects.equals(this.creationDate, page.creationDate) &&
                Objects.equals(this.createdBy, page.createdBy) &&
                Objects.equals(this.isProvided, page.isProvided) &&
                Objects.equals(this.description, page.description) &&
                Objects.equals(this.contentName, page.contentName) &&
                Objects.equals(this.displayName, page.displayName) &&
                Objects.equals(this.updatedBy, page.updatedBy) &&
                Objects.equals(this.lastUpdateDate, page.lastUpdateDate) &&
                Objects.equals(this.urlToken, page.urlToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, createdBy, isProvided, description, contentName, displayName, updatedBy,
                lastUpdateDate, urlToken);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Page {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    isProvided: ").append(toIndentedString(isProvided)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    contentName: ").append(toIndentedString(contentName)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    updatedBy: ").append(toIndentedString(updatedBy)).append("\n");
        sb.append("    lastUpdateDate: ").append(toIndentedString(lastUpdateDate)).append("\n");
        sb.append("    urlToken: ").append(toIndentedString(urlToken)).append("\n");
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
