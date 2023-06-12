/** 
 * Copyright (C) 2022 BonitaSoft S.A.
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
 * MembershipCreateRequest
 */
@JsonPropertyOrder({
        MembershipCreateRequest.JSON_PROPERTY_ROLE_ID,
        MembershipCreateRequest.JSON_PROPERTY_GROUP_ID,
        MembershipCreateRequest.JSON_PROPERTY_USER_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class MembershipCreateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ROLE_ID = "role_id";
    private String roleId;

    public static final String JSON_PROPERTY_GROUP_ID = "group_id";
    private String groupId;

    public static final String JSON_PROPERTY_USER_ID = "user_id";
    private String userId;

    public MembershipCreateRequest() {
    }

    public MembershipCreateRequest roleId(String roleId) {

        this.roleId = roleId;
        return this;
    }

    /**
     * id of the role of this membership
     * 
     * @return roleId
     **/
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ROLE_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getRoleId() {
        return roleId;
    }

    @JsonProperty(JSON_PROPERTY_ROLE_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public MembershipCreateRequest groupId(String groupId) {

        this.groupId = groupId;
        return this;
    }

    /**
     * id of the group of this membership
     * 
     * @return groupId
     **/
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_GROUP_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getGroupId() {
        return groupId;
    }

    @JsonProperty(JSON_PROPERTY_GROUP_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public MembershipCreateRequest userId(String userId) {

        this.userId = userId;
        return this;
    }

    /**
     * id of the user in this membership
     * 
     * @return userId
     **/
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_USER_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getUserId() {
        return userId;
    }

    @JsonProperty(JSON_PROPERTY_USER_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setUserId(String userId) {
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
        MembershipCreateRequest membershipCreateRequest = (MembershipCreateRequest) o;
        return Objects.equals(this.roleId, membershipCreateRequest.roleId) &&
                Objects.equals(this.groupId, membershipCreateRequest.groupId) &&
                Objects.equals(this.userId, membershipCreateRequest.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, groupId, userId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MembershipCreateRequest {\n");
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
