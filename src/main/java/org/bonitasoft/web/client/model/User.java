/** 
 * Copyright (C) 2024 BonitaSoft S.A.
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
 * User
 */
@JsonPropertyOrder({
        User.JSON_PROPERTY_ID,
        User.JSON_PROPERTY_ENABLED,
        User.JSON_PROPERTY_USER_NAME,
        User.JSON_PROPERTY_FIRSTNAME,
        User.JSON_PROPERTY_LASTNAME,
        User.JSON_PROPERTY_PASSWORD,
        User.JSON_PROPERTY_ICON,
        User.JSON_PROPERTY_TITLE,
        User.JSON_PROPERTY_JOB_TITLE,
        User.JSON_PROPERTY_MANAGER_ID,
        User.JSON_PROPERTY_LAST_CONNECTION,
        User.JSON_PROPERTY_CREATED_BY_USER_ID,
        User.JSON_PROPERTY_CREATION_DATE,
        User.JSON_PROPERTY_LAST_UPDATE_DATE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_ENABLED = "enabled";
    private String enabled;

    public static final String JSON_PROPERTY_USER_NAME = "userName";
    private String userName;

    public static final String JSON_PROPERTY_FIRSTNAME = "firstname";
    private String firstname;

    public static final String JSON_PROPERTY_LASTNAME = "lastname";
    private String lastname;

    public static final String JSON_PROPERTY_PASSWORD = "password";
    private String password;

    public static final String JSON_PROPERTY_ICON = "icon";
    private String icon;

    public static final String JSON_PROPERTY_TITLE = "title";
    private String title;

    public static final String JSON_PROPERTY_JOB_TITLE = "job_title";
    private String jobTitle;

    public static final String JSON_PROPERTY_MANAGER_ID = "manager_id";
    private String managerId;

    public static final String JSON_PROPERTY_LAST_CONNECTION = "last_connection";
    private String lastConnection;

    public static final String JSON_PROPERTY_CREATED_BY_USER_ID = "created_by_user_id";
    private String createdByUserId;

    public static final String JSON_PROPERTY_CREATION_DATE = "creation_date";
    private String creationDate;

    public static final String JSON_PROPERTY_LAST_UPDATE_DATE = "last_update_date";
    private String lastUpdateDate;

    public User() {
    }

    public User id(String id) {

        this.id = id;
        return this;
    }

    /**
     * user id
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

    public User enabled(String enabled) {

        this.enabled = enabled;
        return this;
    }

    /**
     * if \&quot;true\&quot;, user is active.
     * 
     * @return enabled
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ENABLED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getEnabled() {
        return enabled;
    }

    @JsonProperty(JSON_PROPERTY_ENABLED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public User userName(String userName) {

        this.userName = userName;
        return this;
    }

    /**
     * user name
     * 
     * @return userName
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_USER_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUserName() {
        return userName;
    }

    @JsonProperty(JSON_PROPERTY_USER_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User firstname(String firstname) {

        this.firstname = firstname;
        return this;
    }

    /**
     * user last name
     * 
     * @return firstname
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FIRSTNAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFirstname() {
        return firstname;
    }

    @JsonProperty(JSON_PROPERTY_FIRSTNAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public User lastname(String lastname) {

        this.lastname = lastname;
        return this;
    }

    /**
     * user last name
     * 
     * @return lastname
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LASTNAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLastname() {
        return lastname;
    }

    @JsonProperty(JSON_PROPERTY_LASTNAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public User password(String password) {

        this.password = password;
        return this;
    }

    /**
     * user password
     * 
     * @return password
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PASSWORD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPassword() {
        return password;
    }

    @JsonProperty(JSON_PROPERTY_PASSWORD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPassword(String password) {
        this.password = password;
    }

    public User icon(String icon) {

        this.icon = icon;
        return this;
    }

    /**
     * bonita icon path (ie. /default/icon_user.png)
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

    public User title(String title) {

        this.title = title;
        return this;
    }

    /**
     * user title
     * 
     * @return title
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TITLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTitle() {
        return title;
    }

    @JsonProperty(JSON_PROPERTY_TITLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTitle(String title) {
        this.title = title;
    }

    public User jobTitle(String jobTitle) {

        this.jobTitle = jobTitle;
        return this;
    }

    /**
     * user job title
     * 
     * @return jobTitle
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_JOB_TITLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getJobTitle() {
        return jobTitle;
    }

    @JsonProperty(JSON_PROPERTY_JOB_TITLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public User managerId(String managerId) {

        this.managerId = managerId;
        return this;
    }

    /**
     * user manager id
     * 
     * @return managerId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MANAGER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getManagerId() {
        return managerId;
    }

    @JsonProperty(JSON_PROPERTY_MANAGER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public User lastConnection(String lastConnection) {

        this.lastConnection = lastConnection;
        return this;
    }

    /**
     * last connection date
     * 
     * @return lastConnection
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LAST_CONNECTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLastConnection() {
        return lastConnection;
    }

    @JsonProperty(JSON_PROPERTY_LAST_CONNECTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLastConnection(String lastConnection) {
        this.lastConnection = lastConnection;
    }

    public User createdByUserId(String createdByUserId) {

        this.createdByUserId = createdByUserId;
        return this;
    }

    /**
     * created by
     * 
     * @return createdByUserId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_BY_USER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCreatedByUserId() {
        return createdByUserId;
    }

    @JsonProperty(JSON_PROPERTY_CREATED_BY_USER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreatedByUserId(String createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public User creationDate(String creationDate) {

        this.creationDate = creationDate;
        return this;
    }

    /**
     * creation date
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

    public User lastUpdateDate(String lastUpdateDate) {

        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    /**
     * user last update date
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(this.id, user.id) &&
                Objects.equals(this.enabled, user.enabled) &&
                Objects.equals(this.userName, user.userName) &&
                Objects.equals(this.firstname, user.firstname) &&
                Objects.equals(this.lastname, user.lastname) &&
                Objects.equals(this.password, user.password) &&
                Objects.equals(this.icon, user.icon) &&
                Objects.equals(this.title, user.title) &&
                Objects.equals(this.jobTitle, user.jobTitle) &&
                Objects.equals(this.managerId, user.managerId) &&
                Objects.equals(this.lastConnection, user.lastConnection) &&
                Objects.equals(this.createdByUserId, user.createdByUserId) &&
                Objects.equals(this.creationDate, user.creationDate) &&
                Objects.equals(this.lastUpdateDate, user.lastUpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, enabled, userName, firstname, lastname, password, icon, title, jobTitle, managerId,
                lastConnection, createdByUserId, creationDate, lastUpdateDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class User {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
        sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
        sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
        sb.append("    password: ").append("*").append("\n");
        sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    jobTitle: ").append(toIndentedString(jobTitle)).append("\n");
        sb.append("    managerId: ").append(toIndentedString(managerId)).append("\n");
        sb.append("    lastConnection: ").append(toIndentedString(lastConnection)).append("\n");
        sb.append("    createdByUserId: ").append(toIndentedString(createdByUserId)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    lastUpdateDate: ").append(toIndentedString(lastUpdateDate)).append("\n");
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
