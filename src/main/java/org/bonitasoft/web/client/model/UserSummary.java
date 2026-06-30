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
 * Lightweight projection of a User returned by the &#x60;identity/userSummary&#x60; resource: only the id, user name, first name, last name and job title.
 * Attribute names are kept consistent with the &#x60;identity/user&#x60; resource.
 */
@JsonPropertyOrder({
        UserSummary.JSON_PROPERTY_ID,
        UserSummary.JSON_PROPERTY_USER_NAME,
        UserSummary.JSON_PROPERTY_FIRSTNAME,
        UserSummary.JSON_PROPERTY_LASTNAME,
        UserSummary.JSON_PROPERTY_JOB_TITLE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class UserSummary implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    @jakarta.annotation.Nonnull
    private String id;

    public static final String JSON_PROPERTY_USER_NAME = "userName";
    @jakarta.annotation.Nonnull
    private String userName;

    public static final String JSON_PROPERTY_FIRSTNAME = "firstname";
    @jakarta.annotation.Nonnull
    private String firstname;

    public static final String JSON_PROPERTY_LASTNAME = "lastname";
    @jakarta.annotation.Nonnull
    private String lastname;

    public static final String JSON_PROPERTY_JOB_TITLE = "job_title";
    private JsonNullable<String> jobTitle = JsonNullable.<String> undefined();

    public UserSummary() {
    }

    public UserSummary id(@jakarta.annotation.Nonnull String id) {

        this.id = id;
        return this;
    }

    /**
     * user id
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

    public UserSummary userName(@jakarta.annotation.Nonnull String userName) {

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

    public UserSummary firstname(@jakarta.annotation.Nonnull String firstname) {

        this.firstname = firstname;
        return this;
    }

    /**
     * user first name
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

    public UserSummary lastname(@jakarta.annotation.Nonnull String lastname) {

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

    public UserSummary jobTitle(@jakarta.annotation.Nullable String jobTitle) {
        this.jobTitle = JsonNullable.<String> of(jobTitle);

        return this;
    }

    /**
     * user job title. Optional on a user, &#x60;null&#x60; when unset.
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserSummary userSummary = (UserSummary) o;
        return Objects.equals(this.id, userSummary.id) &&
                Objects.equals(this.userName, userSummary.userName) &&
                Objects.equals(this.firstname, userSummary.firstname) &&
                Objects.equals(this.lastname, userSummary.lastname) &&
                equalsNullable(this.jobTitle, userSummary.jobTitle);
    }

    private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
        return a == b
                || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, firstname, lastname, hashCodeNullable(jobTitle));
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
        sb.append("class UserSummary {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
        sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
        sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
        sb.append("    jobTitle: ").append(toIndentedString(jobTitle)).append("\n");
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
