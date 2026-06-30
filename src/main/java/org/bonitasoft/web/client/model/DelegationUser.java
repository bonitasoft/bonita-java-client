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
import java.util.Arrays;
import java.util.Objects;

import org.openapitools.jackson.nullable.JsonNullable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * User embedded in a delegation rule or a delegated task (delegator, delegate or last updater). This is the engine &#x60;User&#x60; model serialized directly,
 * so its field names (&#x60;userName&#x60;, &#x60;managerUserId&#x60;, &#x60;creationDate&#x60;, ...) differ from the legacy snake_case &#x60;User&#x60; schema
 * returned by the &#x60;/API/identity/user&#x60; endpoints. The long id fields (&#x60;id&#x60;, &#x60;createdBy&#x60;, &#x60;managerUserId&#x60;) are
 * serialized as strings to avoid JavaScript precision loss, while the date fields (&#x60;creationDate&#x60;, &#x60;lastUpdate&#x60;,
 * &#x60;lastConnection&#x60;) are serialized as numeric epoch milliseconds.
 */
@JsonPropertyOrder({
        DelegationUser.JSON_PROPERTY_ID,
        DelegationUser.JSON_PROPERTY_USER_NAME,
        DelegationUser.JSON_PROPERTY_FIRST_NAME,
        DelegationUser.JSON_PROPERTY_LAST_NAME,
        DelegationUser.JSON_PROPERTY_TITLE,
        DelegationUser.JSON_PROPERTY_JOB_TITLE,
        DelegationUser.JSON_PROPERTY_ICON_ID,
        DelegationUser.JSON_PROPERTY_MANAGER_USER_ID,
        DelegationUser.JSON_PROPERTY_CREATED_BY,
        DelegationUser.JSON_PROPERTY_CREATION_DATE,
        DelegationUser.JSON_PROPERTY_LAST_UPDATE,
        DelegationUser.JSON_PROPERTY_LAST_CONNECTION,
        DelegationUser.JSON_PROPERTY_ENABLED
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class DelegationUser implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    @jakarta.annotation.Nonnull
    private String id;

    public static final String JSON_PROPERTY_USER_NAME = "userName";
    @jakarta.annotation.Nonnull
    private String userName;

    public static final String JSON_PROPERTY_FIRST_NAME = "firstName";
    @jakarta.annotation.Nullable
    private String firstName;

    public static final String JSON_PROPERTY_LAST_NAME = "lastName";
    @jakarta.annotation.Nullable
    private String lastName;

    public static final String JSON_PROPERTY_TITLE = "title";
    private JsonNullable<String> title = JsonNullable.<String> undefined();

    public static final String JSON_PROPERTY_JOB_TITLE = "jobTitle";
    private JsonNullable<String> jobTitle = JsonNullable.<String> undefined();

    public static final String JSON_PROPERTY_ICON_ID = "iconId";
    private JsonNullable<String> iconId = JsonNullable.<String> undefined();

    public static final String JSON_PROPERTY_MANAGER_USER_ID = "managerUserId";
    @jakarta.annotation.Nullable
    private String managerUserId;

    public static final String JSON_PROPERTY_CREATED_BY = "createdBy";
    @jakarta.annotation.Nullable
    private String createdBy;

    public static final String JSON_PROPERTY_CREATION_DATE = "creationDate";
    @jakarta.annotation.Nullable
    private Long creationDate;

    public static final String JSON_PROPERTY_LAST_UPDATE = "lastUpdate";
    @jakarta.annotation.Nullable
    private Long lastUpdate;

    public static final String JSON_PROPERTY_LAST_CONNECTION = "lastConnection";
    private JsonNullable<Long> lastConnection = JsonNullable.<Long> undefined();

    public static final String JSON_PROPERTY_ENABLED = "enabled";
    @jakarta.annotation.Nonnull
    private Boolean enabled;

    public DelegationUser() {
    }

    public DelegationUser id(@jakarta.annotation.Nonnull String id) {

        this.id = id;
        return this;
    }

    /**
     * User id. Serialized as a string to avoid JavaScript precision loss on large &#x60;long&#x60; values.
     * 
     * @return id
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setId(@jakarta.annotation.Nonnull String id) {
        this.id = id;
    }

    public DelegationUser userName(@jakarta.annotation.Nonnull String userName) {

        this.userName = userName;
        return this;
    }

    /**
     * Login name of the user.
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

    public DelegationUser firstName(@jakarta.annotation.Nullable String firstName) {

        this.firstName = firstName;
        return this;
    }

    /**
     * First name of the user.
     * 
     * @return firstName
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FIRST_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getFirstName() {
        return firstName;
    }

    @JsonProperty(JSON_PROPERTY_FIRST_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setFirstName(@jakarta.annotation.Nullable String firstName) {
        this.firstName = firstName;
    }

    public DelegationUser lastName(@jakarta.annotation.Nullable String lastName) {

        this.lastName = lastName;
        return this;
    }

    /**
     * Last name of the user.
     * 
     * @return lastName
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LAST_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getLastName() {
        return lastName;
    }

    @JsonProperty(JSON_PROPERTY_LAST_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setLastName(@jakarta.annotation.Nullable String lastName) {
        this.lastName = lastName;
    }

    public DelegationUser title(@jakarta.annotation.Nullable String title) {
        this.title = JsonNullable.<String> of(title);

        return this;
    }

    /**
     * Civility title of the user.
     * 
     * @return title
     */
    @jakarta.annotation.Nullable
    @JsonIgnore

    public String getTitle() {
        return title.orElse(null);
    }

    @JsonProperty(JSON_PROPERTY_TITLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public JsonNullable<String> getTitle_JsonNullable() {
        return title;
    }

    @JsonProperty(JSON_PROPERTY_TITLE)
    public void setTitle_JsonNullable(JsonNullable<String> title) {
        this.title = title;
    }

    public void setTitle(@jakarta.annotation.Nullable String title) {
        this.title = JsonNullable.<String> of(title);
    }

    public DelegationUser jobTitle(@jakarta.annotation.Nullable String jobTitle) {
        this.jobTitle = JsonNullable.<String> of(jobTitle);

        return this;
    }

    /**
     * Job title of the user.
     * 
     * @return jobTitle
     */
    @jakarta.annotation.Nullable
    @JsonIgnore

    public String getJobTitle() {
        return jobTitle.orElse(null);
    }

    @JsonProperty(JSON_PROPERTY_JOB_TITLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public JsonNullable<String> getJobTitle_JsonNullable() {
        return jobTitle;
    }

    @JsonProperty(JSON_PROPERTY_JOB_TITLE)
    public void setJobTitle_JsonNullable(JsonNullable<String> jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setJobTitle(@jakarta.annotation.Nullable String jobTitle) {
        this.jobTitle = JsonNullable.<String> of(jobTitle);
    }

    public DelegationUser iconId(@jakarta.annotation.Nullable String iconId) {
        this.iconId = JsonNullable.<String> of(iconId);

        return this;
    }

    /**
     * Id of the icon row used as avatar, or &#x60;null&#x60; when no icon is set. Serialized as a string when present.
     * 
     * @return iconId
     */
    @jakarta.annotation.Nullable
    @JsonIgnore

    public String getIconId() {
        return iconId.orElse(null);
    }

    @JsonProperty(JSON_PROPERTY_ICON_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public JsonNullable<String> getIconId_JsonNullable() {
        return iconId;
    }

    @JsonProperty(JSON_PROPERTY_ICON_ID)
    public void setIconId_JsonNullable(JsonNullable<String> iconId) {
        this.iconId = iconId;
    }

    public void setIconId(@jakarta.annotation.Nullable String iconId) {
        this.iconId = JsonNullable.<String> of(iconId);
    }

    public DelegationUser managerUserId(@jakarta.annotation.Nullable String managerUserId) {

        this.managerUserId = managerUserId;
        return this;
    }

    /**
     * Id of this user&#39;s manager, or &#x60;0&#x60; when none. Serialized as a string.
     * 
     * @return managerUserId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MANAGER_USER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getManagerUserId() {
        return managerUserId;
    }

    @JsonProperty(JSON_PROPERTY_MANAGER_USER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setManagerUserId(@jakarta.annotation.Nullable String managerUserId) {
        this.managerUserId = managerUserId;
    }

    public DelegationUser createdBy(@jakarta.annotation.Nullable String createdBy) {

        this.createdBy = createdBy;
        return this;
    }

    /**
     * Id of the user who created this account (&#x60;-1&#x60; for system-created accounts). Serialized as a string.
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

    public DelegationUser creationDate(@jakarta.annotation.Nullable Long creationDate) {

        this.creationDate = creationDate;
        return this;
    }

    /**
     * Creation timestamp of the user account, in epoch milliseconds.
     * 
     * @return creationDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATION_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getCreationDate() {
        return creationDate;
    }

    @JsonProperty(JSON_PROPERTY_CREATION_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreationDate(@jakarta.annotation.Nullable Long creationDate) {
        this.creationDate = creationDate;
    }

    public DelegationUser lastUpdate(@jakarta.annotation.Nullable Long lastUpdate) {

        this.lastUpdate = lastUpdate;
        return this;
    }

    /**
     * Last update timestamp of the user account, in epoch milliseconds.
     * 
     * @return lastUpdate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LAST_UPDATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getLastUpdate() {
        return lastUpdate;
    }

    @JsonProperty(JSON_PROPERTY_LAST_UPDATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLastUpdate(@jakarta.annotation.Nullable Long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public DelegationUser lastConnection(@jakarta.annotation.Nullable Long lastConnection) {
        this.lastConnection = JsonNullable.<Long> of(lastConnection);

        return this;
    }

    /**
     * Last connection timestamp, in epoch milliseconds, or &#x60;null&#x60; if the user never logged in.
     * 
     * @return lastConnection
     */
    @jakarta.annotation.Nullable
    @JsonIgnore

    public Long getLastConnection() {
        return lastConnection.orElse(null);
    }

    @JsonProperty(JSON_PROPERTY_LAST_CONNECTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public JsonNullable<Long> getLastConnection_JsonNullable() {
        return lastConnection;
    }

    @JsonProperty(JSON_PROPERTY_LAST_CONNECTION)
    public void setLastConnection_JsonNullable(JsonNullable<Long> lastConnection) {
        this.lastConnection = lastConnection;
    }

    public void setLastConnection(@jakarta.annotation.Nullable Long lastConnection) {
        this.lastConnection = JsonNullable.<Long> of(lastConnection);
    }

    public DelegationUser enabled(@jakarta.annotation.Nonnull Boolean enabled) {

        this.enabled = enabled;
        return this;
    }

    /**
     * Whether the user account is enabled.
     * 
     * @return enabled
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ENABLED)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Boolean getEnabled() {
        return enabled;
    }

    @JsonProperty(JSON_PROPERTY_ENABLED)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setEnabled(@jakarta.annotation.Nonnull Boolean enabled) {
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
        DelegationUser delegationUser = (DelegationUser) o;
        return Objects.equals(this.id, delegationUser.id) &&
                Objects.equals(this.userName, delegationUser.userName) &&
                Objects.equals(this.firstName, delegationUser.firstName) &&
                Objects.equals(this.lastName, delegationUser.lastName) &&
                equalsNullable(this.title, delegationUser.title) &&
                equalsNullable(this.jobTitle, delegationUser.jobTitle) &&
                equalsNullable(this.iconId, delegationUser.iconId) &&
                Objects.equals(this.managerUserId, delegationUser.managerUserId) &&
                Objects.equals(this.createdBy, delegationUser.createdBy) &&
                Objects.equals(this.creationDate, delegationUser.creationDate) &&
                Objects.equals(this.lastUpdate, delegationUser.lastUpdate) &&
                equalsNullable(this.lastConnection, delegationUser.lastConnection) &&
                Objects.equals(this.enabled, delegationUser.enabled);
    }

    private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
        return a == b
                || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, firstName, lastName, hashCodeNullable(title), hashCodeNullable(jobTitle),
                hashCodeNullable(iconId), managerUserId, createdBy, creationDate, lastUpdate,
                hashCodeNullable(lastConnection), enabled);
    }

    private static <T> int hashCodeNullable(JsonNullable<T> a) {
        if (a == null) {
            return 1;
        }
        return a.isPresent() ? Arrays.deepHashCode(new Object[] { a.get() }) : 31;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DelegationUser {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    jobTitle: ").append(toIndentedString(jobTitle)).append("\n");
        sb.append("    iconId: ").append(toIndentedString(iconId)).append("\n");
        sb.append("    managerUserId: ").append(toIndentedString(managerUserId)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
        sb.append("    lastConnection: ").append(toIndentedString(lastConnection)).append("\n");
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
