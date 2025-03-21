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
 * UserCreateRequest
 */
@JsonPropertyOrder({
        UserCreateRequest.JSON_PROPERTY_USER_NAME,
        UserCreateRequest.JSON_PROPERTY_FIRSTNAME,
        UserCreateRequest.JSON_PROPERTY_LASTNAME,
        UserCreateRequest.JSON_PROPERTY_PASSWORD,
        UserCreateRequest.JSON_PROPERTY_PASSWORD_CONFIRM,
        UserCreateRequest.JSON_PROPERTY_ICON,
        UserCreateRequest.JSON_PROPERTY_TITLE,
        UserCreateRequest.JSON_PROPERTY_JOB_TITLE,
        UserCreateRequest.JSON_PROPERTY_MANAGER_ID,
        UserCreateRequest.JSON_PROPERTY_ENABLED
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class UserCreateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_USER_NAME = "userName";
    @jakarta.annotation.Nonnull
    private String userName;

    public static final String JSON_PROPERTY_FIRSTNAME = "firstname";
    @jakarta.annotation.Nonnull
    private String firstname;

    public static final String JSON_PROPERTY_LASTNAME = "lastname";
    @jakarta.annotation.Nonnull
    private String lastname;

    public static final String JSON_PROPERTY_PASSWORD = "password";
    @jakarta.annotation.Nonnull
    private String password;

    public static final String JSON_PROPERTY_PASSWORD_CONFIRM = "password_confirm";
    @jakarta.annotation.Nonnull
    private String passwordConfirm;

    public static final String JSON_PROPERTY_ICON = "icon";
    @jakarta.annotation.Nullable
    private String icon;

    public static final String JSON_PROPERTY_TITLE = "title";
    @jakarta.annotation.Nullable
    private String title;

    public static final String JSON_PROPERTY_JOB_TITLE = "job_title";
    @jakarta.annotation.Nullable
    private String jobTitle;

    public static final String JSON_PROPERTY_MANAGER_ID = "manager_id";
    @jakarta.annotation.Nullable
    private String managerId;

    public static final String JSON_PROPERTY_ENABLED = "enabled";
    @jakarta.annotation.Nonnull
    private String enabled;

    public UserCreateRequest() {
    }

    public UserCreateRequest userName(@jakarta.annotation.Nonnull String userName) {

        this.userName = userName;
        return this;
    }

    /**
     * user name
     * 
     * @return userName
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_USER_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getUserName() {
        return userName;
    }

    @JsonProperty(JSON_PROPERTY_USER_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setUserName(@jakarta.annotation.Nonnull String userName) {
        this.userName = userName;
    }

    public UserCreateRequest firstname(@jakarta.annotation.Nonnull String firstname) {

        this.firstname = firstname;
        return this;
    }

    /**
     * user last name
     * 
     * @return firstname
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_FIRSTNAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getFirstname() {
        return firstname;
    }

    @JsonProperty(JSON_PROPERTY_FIRSTNAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setFirstname(@jakarta.annotation.Nonnull String firstname) {
        this.firstname = firstname;
    }

    public UserCreateRequest lastname(@jakarta.annotation.Nonnull String lastname) {

        this.lastname = lastname;
        return this;
    }

    /**
     * user last name
     * 
     * @return lastname
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_LASTNAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getLastname() {
        return lastname;
    }

    @JsonProperty(JSON_PROPERTY_LASTNAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setLastname(@jakarta.annotation.Nonnull String lastname) {
        this.lastname = lastname;
    }

    public UserCreateRequest password(@jakarta.annotation.Nonnull String password) {

        this.password = password;
        return this;
    }

    /**
     * user password
     * 
     * @return password
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_PASSWORD)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getPassword() {
        return password;
    }

    @JsonProperty(JSON_PROPERTY_PASSWORD)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setPassword(@jakarta.annotation.Nonnull String password) {
        this.password = password;
    }

    public UserCreateRequest passwordConfirm(@jakarta.annotation.Nonnull String passwordConfirm) {

        this.passwordConfirm = passwordConfirm;
        return this;
    }

    /**
     * user password confirmation
     * 
     * @return passwordConfirm
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_PASSWORD_CONFIRM)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    @JsonProperty(JSON_PROPERTY_PASSWORD_CONFIRM)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setPasswordConfirm(@jakarta.annotation.Nonnull String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public UserCreateRequest icon(@jakarta.annotation.Nullable String icon) {

        this.icon = icon;
        return this;
    }

    /**
     * bonita icon path (ie. /default/icon_user.png)
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

    public UserCreateRequest title(@jakarta.annotation.Nullable String title) {

        this.title = title;
        return this;
    }

    /**
     * user title
     * 
     * @return title
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TITLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTitle() {
        return title;
    }

    @JsonProperty(JSON_PROPERTY_TITLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTitle(@jakarta.annotation.Nullable String title) {
        this.title = title;
    }

    public UserCreateRequest jobTitle(@jakarta.annotation.Nullable String jobTitle) {

        this.jobTitle = jobTitle;
        return this;
    }

    /**
     * user job title
     * 
     * @return jobTitle
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_JOB_TITLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getJobTitle() {
        return jobTitle;
    }

    @JsonProperty(JSON_PROPERTY_JOB_TITLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setJobTitle(@jakarta.annotation.Nullable String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public UserCreateRequest managerId(@jakarta.annotation.Nullable String managerId) {

        this.managerId = managerId;
        return this;
    }

    /**
     * user manager id
     * 
     * @return managerId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MANAGER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getManagerId() {
        return managerId;
    }

    @JsonProperty(JSON_PROPERTY_MANAGER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setManagerId(@jakarta.annotation.Nullable String managerId) {
        this.managerId = managerId;
    }

    public UserCreateRequest enabled(@jakarta.annotation.Nonnull String enabled) {

        this.enabled = enabled;
        return this;
    }

    /**
     * true|false if the user is enabled or not
     * 
     * @return enabled
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ENABLED)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getEnabled() {
        return enabled;
    }

    @JsonProperty(JSON_PROPERTY_ENABLED)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setEnabled(@jakarta.annotation.Nonnull String enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserCreateRequest userCreateRequest = (UserCreateRequest) o;
        return Objects.equals(this.userName, userCreateRequest.userName) &&
                Objects.equals(this.firstname, userCreateRequest.firstname) &&
                Objects.equals(this.lastname, userCreateRequest.lastname) &&
                Objects.equals(this.password, userCreateRequest.password) &&
                Objects.equals(this.passwordConfirm, userCreateRequest.passwordConfirm) &&
                Objects.equals(this.icon, userCreateRequest.icon) &&
                Objects.equals(this.title, userCreateRequest.title) &&
                Objects.equals(this.jobTitle, userCreateRequest.jobTitle) &&
                Objects.equals(this.managerId, userCreateRequest.managerId) &&
                Objects.equals(this.enabled, userCreateRequest.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, firstname, lastname, password, passwordConfirm, icon, title, jobTitle, managerId,
                enabled);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserCreateRequest {\n");
        sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
        sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
        sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
        sb.append("    password: ").append("*").append("\n");
        sb.append("    passwordConfirm: ").append("*").append("\n");
        sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    jobTitle: ").append(toIndentedString(jobTitle)).append("\n");
        sb.append("    managerId: ").append(toIndentedString(managerId)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
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
