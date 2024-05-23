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
 * ApplicationMenuUpdateRequest
 */
@JsonPropertyOrder({
        ApplicationMenuUpdateRequest.JSON_PROPERTY_PARENT_MENU_ID,
        ApplicationMenuUpdateRequest.JSON_PROPERTY_APPLICATION_PAGE_ID,
        ApplicationMenuUpdateRequest.JSON_PROPERTY_APPLICATION_ID,
        ApplicationMenuUpdateRequest.JSON_PROPERTY_MENU_INDEX,
        ApplicationMenuUpdateRequest.JSON_PROPERTY_DISPLAY_NAME
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.5.0")
public class ApplicationMenuUpdateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_PARENT_MENU_ID = "parentMenuId";
    private String parentMenuId;

    public static final String JSON_PROPERTY_APPLICATION_PAGE_ID = "applicationPageId";
    private String applicationPageId;

    public static final String JSON_PROPERTY_APPLICATION_ID = "applicationId";
    private String applicationId;

    public static final String JSON_PROPERTY_MENU_INDEX = "menuIndex";
    private String menuIndex;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    private String displayName;

    public ApplicationMenuUpdateRequest() {
    }

    public ApplicationMenuUpdateRequest parentMenuId(String parentMenuId) {

        this.parentMenuId = parentMenuId;
        return this;
    }

    /**
     * id of the parent menu of this menu item, or -1 for a top-level item
     * 
     * @return parentMenuId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PARENT_MENU_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getParentMenuId() {
        return parentMenuId;
    }

    @JsonProperty(JSON_PROPERTY_PARENT_MENU_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setParentMenuId(String parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public ApplicationMenuUpdateRequest applicationPageId(String applicationPageId) {

        this.applicationPageId = applicationPageId;
        return this;
    }

    /**
     * id of the application page targeted by this menu item, or -1 if there is no targeted page (that is, the item is a parent menu)
     * 
     * @return applicationPageId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_APPLICATION_PAGE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getApplicationPageId() {
        return applicationPageId;
    }

    @JsonProperty(JSON_PROPERTY_APPLICATION_PAGE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setApplicationPageId(String applicationPageId) {
        this.applicationPageId = applicationPageId;
    }

    public ApplicationMenuUpdateRequest applicationId(String applicationId) {

        this.applicationId = applicationId;
        return this;
    }

    /**
     * id of the application related to this menu item
     * 
     * @return applicationId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_APPLICATION_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getApplicationId() {
        return applicationId;
    }

    @JsonProperty(JSON_PROPERTY_APPLICATION_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public ApplicationMenuUpdateRequest menuIndex(String menuIndex) {

        this.menuIndex = menuIndex;
        return this;
    }

    /**
     * index of the menu item
     * 
     * @return menuIndex
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MENU_INDEX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getMenuIndex() {
        return menuIndex;
    }

    @JsonProperty(JSON_PROPERTY_MENU_INDEX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMenuIndex(String menuIndex) {
        this.menuIndex = menuIndex;
    }

    public ApplicationMenuUpdateRequest displayName(String displayName) {

        this.displayName = displayName;
        return this;
    }

    /**
     * label to display for this menu in the application navigation bar or menu
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApplicationMenuUpdateRequest applicationMenuUpdateRequest = (ApplicationMenuUpdateRequest) o;
        return Objects.equals(this.parentMenuId, applicationMenuUpdateRequest.parentMenuId) &&
                Objects.equals(this.applicationPageId, applicationMenuUpdateRequest.applicationPageId) &&
                Objects.equals(this.applicationId, applicationMenuUpdateRequest.applicationId) &&
                Objects.equals(this.menuIndex, applicationMenuUpdateRequest.menuIndex) &&
                Objects.equals(this.displayName, applicationMenuUpdateRequest.displayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentMenuId, applicationPageId, applicationId, menuIndex, displayName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApplicationMenuUpdateRequest {\n");
        sb.append("    parentMenuId: ").append(toIndentedString(parentMenuId)).append("\n");
        sb.append("    applicationPageId: ").append(toIndentedString(applicationPageId)).append("\n");
        sb.append("    applicationId: ").append(toIndentedString(applicationId)).append("\n");
        sb.append("    menuIndex: ").append(toIndentedString(menuIndex)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
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
