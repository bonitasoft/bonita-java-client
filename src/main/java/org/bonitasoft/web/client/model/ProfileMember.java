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
 * Profile member
 */
@JsonPropertyOrder({
        ProfileMember.JSON_PROPERTY_ID,
        ProfileMember.JSON_PROPERTY_PROFILE_ID,
        ProfileMember.JSON_PROPERTY_ROLE_ID,
        ProfileMember.JSON_PROPERTY_GROUP_ID,
        ProfileMember.JSON_PROPERTY_USER_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class ProfileMember implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    @jakarta.annotation.Nullable
    private String id;

    public static final String JSON_PROPERTY_PROFILE_ID = "profile_id";
    @jakarta.annotation.Nullable
    private String profileId;

    public static final String JSON_PROPERTY_ROLE_ID = "role_id";
    @jakarta.annotation.Nullable
    private String roleId;

    public static final String JSON_PROPERTY_GROUP_ID = "group_id";
    @jakarta.annotation.Nullable
    private String groupId;

    public static final String JSON_PROPERTY_USER_ID = "user_id";
    @jakarta.annotation.Nullable
    private String userId;

    public ProfileMember() {
    }

    public ProfileMember id(@jakarta.annotation.Nullable String id) {

        this.id = id;
        return this;
    }

    /**
     * profile member id
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

    public ProfileMember profileId(@jakarta.annotation.Nullable String profileId) {

        this.profileId = profileId;
        return this;
    }

    /**
     * id of the profile for this mapping
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

    public ProfileMember roleId(@jakarta.annotation.Nullable String roleId) {

        this.roleId = roleId;
        return this;
    }

    /**
     * id of role, or -1 if the member type is not role
     * 
     * @return roleId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ROLE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getRoleId() {
        return roleId;
    }

    @JsonProperty(JSON_PROPERTY_ROLE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRoleId(@jakarta.annotation.Nullable String roleId) {
        this.roleId = roleId;
    }

    public ProfileMember groupId(@jakarta.annotation.Nullable String groupId) {

        this.groupId = groupId;
        return this;
    }

    /**
     * id of group, or -1 if the member type is not group
     * 
     * @return groupId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_GROUP_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getGroupId() {
        return groupId;
    }

    @JsonProperty(JSON_PROPERTY_GROUP_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setGroupId(@jakarta.annotation.Nullable String groupId) {
        this.groupId = groupId;
    }

    public ProfileMember userId(@jakarta.annotation.Nullable String userId) {

        this.userId = userId;
        return this;
    }

    /**
     * id of user, or -1 if the member type is not user
     * 
     * @return userId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_USER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUserId() {
        return userId;
    }

    @JsonProperty(JSON_PROPERTY_USER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUserId(@jakarta.annotation.Nullable String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProfileMember profileMember = (ProfileMember) o;
        return Objects.equals(this.id, profileMember.id) &&
                Objects.equals(this.profileId, profileMember.profileId) &&
                Objects.equals(this.roleId, profileMember.roleId) &&
                Objects.equals(this.groupId, profileMember.groupId) &&
                Objects.equals(this.userId, profileMember.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, profileId, roleId, groupId, userId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProfileMember {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    profileId: ").append(toIndentedString(profileId)).append("\n");
        sb.append("    roleId: ").append(toIndentedString(roleId)).append("\n");
        sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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
