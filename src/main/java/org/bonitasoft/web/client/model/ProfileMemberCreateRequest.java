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
 * ProfileMemberCreateRequest
 */
@JsonPropertyOrder({
        ProfileMemberCreateRequest.JSON_PROPERTY_PROFILE_ID,
        ProfileMemberCreateRequest.JSON_PROPERTY_ROLE_ID,
        ProfileMemberCreateRequest.JSON_PROPERTY_GROUP_ID,
        ProfileMemberCreateRequest.JSON_PROPERTY_USER_ID,
        ProfileMemberCreateRequest.JSON_PROPERTY_MEMBER_TYPE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class ProfileMemberCreateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_PROFILE_ID = "profile_id";
    private String profileId;

    public static final String JSON_PROPERTY_ROLE_ID = "role_id";
    private String roleId;

    public static final String JSON_PROPERTY_GROUP_ID = "group_id";
    private String groupId;

    public static final String JSON_PROPERTY_USER_ID = "user_id";
    private String userId;

    /**
     * member type
     */
    public enum MemberTypeEnum {

        USER("USER"),

        ROLE("ROLE"),

        GROUP("GROUP");

        private String value;

        MemberTypeEnum(String value) {
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
        public static MemberTypeEnum fromValue(String value) {
            for (MemberTypeEnum b : MemberTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_MEMBER_TYPE = "member_type";
    private MemberTypeEnum memberType;

    public ProfileMemberCreateRequest() {
    }

    public ProfileMemberCreateRequest profileId(String profileId) {

        this.profileId = profileId;
        return this;
    }

    /**
     * id of the profile for this mapping
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

    public ProfileMemberCreateRequest roleId(String roleId) {

        this.roleId = roleId;
        return this;
    }

    /**
     * id of role, or -1 if the member type is not role
     * 
     * @return roleId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ROLE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getRoleId() {
        return roleId;
    }

    @JsonProperty(JSON_PROPERTY_ROLE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public ProfileMemberCreateRequest groupId(String groupId) {

        this.groupId = groupId;
        return this;
    }

    /**
     * id of group, or -1 if the member type is not group
     * 
     * @return groupId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_GROUP_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getGroupId() {
        return groupId;
    }

    @JsonProperty(JSON_PROPERTY_GROUP_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public ProfileMemberCreateRequest userId(String userId) {

        this.userId = userId;
        return this;
    }

    /**
     * id of user, or -1 if the member type is not user
     * 
     * @return userId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_USER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUserId() {
        return userId;
    }

    @JsonProperty(JSON_PROPERTY_USER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ProfileMemberCreateRequest memberType(MemberTypeEnum memberType) {

        this.memberType = memberType;
        return this;
    }

    /**
     * member type
     * 
     * @return memberType
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MEMBER_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public MemberTypeEnum getMemberType() {
        return memberType;
    }

    @JsonProperty(JSON_PROPERTY_MEMBER_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMemberType(MemberTypeEnum memberType) {
        this.memberType = memberType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProfileMemberCreateRequest profileMemberCreateRequest = (ProfileMemberCreateRequest) o;
        return Objects.equals(this.profileId, profileMemberCreateRequest.profileId) &&
                Objects.equals(this.roleId, profileMemberCreateRequest.roleId) &&
                Objects.equals(this.groupId, profileMemberCreateRequest.groupId) &&
                Objects.equals(this.userId, profileMemberCreateRequest.userId) &&
                Objects.equals(this.memberType, profileMemberCreateRequest.memberType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profileId, roleId, groupId, userId, memberType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProfileMemberCreateRequest {\n");
        sb.append("    profileId: ").append(toIndentedString(profileId)).append("\n");
        sb.append("    roleId: ").append(toIndentedString(roleId)).append("\n");
        sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    memberType: ").append(toIndentedString(memberType)).append("\n");
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
