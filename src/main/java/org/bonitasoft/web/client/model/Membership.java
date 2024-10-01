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
 * 
 */
@JsonPropertyOrder({
        Membership.JSON_PROPERTY_ASSIGNED_DATE,
        Membership.JSON_PROPERTY_ROLE_ID,
        Membership.JSON_PROPERTY_ASSIGNED_BY_USER_ID,
        Membership.JSON_PROPERTY_GROUP_ID,
        Membership.JSON_PROPERTY_USER_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.8.0")
public class Membership implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ASSIGNED_DATE = "assigned_date";
    private String assignedDate;

    public static final String JSON_PROPERTY_ROLE_ID = "role_id";
    private Long roleId;

    public static final String JSON_PROPERTY_ASSIGNED_BY_USER_ID = "assigned_by_user_id";
    private String assignedByUserId;

    public static final String JSON_PROPERTY_GROUP_ID = "group_id";
    private String groupId;

    public static final String JSON_PROPERTY_USER_ID = "user_id";
    private String userId;

    public Membership() {
    }

    public Membership assignedDate(String assignedDate) {

        this.assignedDate = assignedDate;
        return this;
    }

    /**
     * creation date (format: &#x60;2014-12-31 15:17:24.736&#x60;)
     * 
     * @return assignedDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ASSIGNED_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getAssignedDate() {
        return assignedDate;
    }

    @JsonProperty(JSON_PROPERTY_ASSIGNED_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAssignedDate(String assignedDate) {
        this.assignedDate = assignedDate;
    }

    public Membership roleId(Long roleId) {

        this.roleId = roleId;
        return this;
    }

    /**
     * id of the role of this membership
     * 
     * @return roleId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ROLE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getRoleId() {
        return roleId;
    }

    @JsonProperty(JSON_PROPERTY_ROLE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Membership assignedByUserId(String assignedByUserId) {

        this.assignedByUserId = assignedByUserId;
        return this;
    }

    /**
     * id of the user who created the membership (-1 if the role was created by the tenant admin or by an organisation import)
     * 
     * @return assignedByUserId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ASSIGNED_BY_USER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getAssignedByUserId() {
        return assignedByUserId;
    }

    @JsonProperty(JSON_PROPERTY_ASSIGNED_BY_USER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAssignedByUserId(String assignedByUserId) {
        this.assignedByUserId = assignedByUserId;
    }

    public Membership groupId(String groupId) {

        this.groupId = groupId;
        return this;
    }

    /**
     * id of the group of this membership
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
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Membership userId(String userId) {

        this.userId = userId;
        return this;
    }

    /**
     * id of the user in this membership
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
        Membership membership = (Membership) o;
        return Objects.equals(this.assignedDate, membership.assignedDate) &&
                Objects.equals(this.roleId, membership.roleId) &&
                Objects.equals(this.assignedByUserId, membership.assignedByUserId) &&
                Objects.equals(this.groupId, membership.groupId) &&
                Objects.equals(this.userId, membership.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assignedDate, roleId, assignedByUserId, groupId, userId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Membership {\n");
        sb.append("    assignedDate: ").append(toIndentedString(assignedDate)).append("\n");
        sb.append("    roleId: ").append(toIndentedString(roleId)).append("\n");
        sb.append("    assignedByUserId: ").append(toIndentedString(assignedByUserId)).append("\n");
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
