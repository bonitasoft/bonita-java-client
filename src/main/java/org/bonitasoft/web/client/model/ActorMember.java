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
 * An actor member represents the association between the organization and the actor af a process. In an organization we have four member_types &#x3D; USER,
 * GROUP, ROLE and MEMBERSHIP (role in a group). You can assign a actor to a user by specifying a role and or a group, or specific user.
 */
@JsonPropertyOrder({
        ActorMember.JSON_PROPERTY_ID,
        ActorMember.JSON_PROPERTY_ACTOR_ID,
        ActorMember.JSON_PROPERTY_ROLE_ID,
        ActorMember.JSON_PROPERTY_GROUP_ID,
        ActorMember.JSON_PROPERTY_USER_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.8.0")
public class ActorMember implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_ACTOR_ID = "actor_id";
    private String actorId;

    public static final String JSON_PROPERTY_ROLE_ID = "role_id";
    private String roleId;

    public static final String JSON_PROPERTY_GROUP_ID = "group_id";
    private String groupId;

    public static final String JSON_PROPERTY_USER_ID = "user_id";
    private String userId;

    public ActorMember() {
    }

    public ActorMember id(String id) {

        this.id = id;
        return this;
    }

    /**
     * actor member id
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
    public void setId(String id) {
        this.id = id;
    }

    public ActorMember actorId(String actorId) {

        this.actorId = actorId;
        return this;
    }

    /**
     * id of the actor for this mapping
     * 
     * @return actorId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ACTOR_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getActorId() {
        return actorId;
    }

    @JsonProperty(JSON_PROPERTY_ACTOR_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public ActorMember roleId(String roleId) {

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
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public ActorMember groupId(String groupId) {

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
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public ActorMember userId(String userId) {

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
        ActorMember actorMember = (ActorMember) o;
        return Objects.equals(this.id, actorMember.id) &&
                Objects.equals(this.actorId, actorMember.actorId) &&
                Objects.equals(this.roleId, actorMember.roleId) &&
                Objects.equals(this.groupId, actorMember.groupId) &&
                Objects.equals(this.userId, actorMember.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actorId, roleId, groupId, userId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ActorMember {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    actorId: ").append(toIndentedString(actorId)).append("\n");
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
