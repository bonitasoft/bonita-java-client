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
 * The process supervisor has management rights over a process. He can configure and monitor it. You can give the ProcessSupervisor rights to some users by
 * specifying a role and or a group, or a specific user. In order to be able to manage the processes he supervises in the portal, a user should also have the
 * profile &#x60;Process Manager&#x60;
 */
@JsonPropertyOrder({
        ProcessSupervisor.JSON_PROPERTY_PROCESS_ID,
        ProcessSupervisor.JSON_PROPERTY_ROLE_ID,
        ProcessSupervisor.JSON_PROPERTY_GROUP_ID,
        ProcessSupervisor.JSON_PROPERTY_USER_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public class ProcessSupervisor implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_PROCESS_ID = "process_id";
    private String processId;

    public static final String JSON_PROPERTY_ROLE_ID = "role_id";
    private String roleId;

    public static final String JSON_PROPERTY_GROUP_ID = "group_id";
    private String groupId;

    public static final String JSON_PROPERTY_USER_ID = "user_id";
    private String userId;

    public ProcessSupervisor() {
    }

    public ProcessSupervisor processId(String processId) {

        this.processId = processId;
        return this;
    }

    /**
     * Id of the process
     * 
     * @return processId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PROCESS_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getProcessId() {
        return processId;
    }

    @JsonProperty(JSON_PROPERTY_PROCESS_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public ProcessSupervisor roleId(String roleId) {

        this.roleId = roleId;
        return this;
    }

    /**
     * Id of role, or -1 if the supervisor type is not role or membership
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

    public ProcessSupervisor groupId(String groupId) {

        this.groupId = groupId;
        return this;
    }

    /**
     * Id of group, or -1 if the supervisor type is not group or membership
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

    public ProcessSupervisor userId(String userId) {

        this.userId = userId;
        return this;
    }

    /**
     * Id of user, or -1 if the supervisor type is not user
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
        ProcessSupervisor processSupervisor = (ProcessSupervisor) o;
        return Objects.equals(this.processId, processSupervisor.processId) &&
                Objects.equals(this.roleId, processSupervisor.roleId) &&
                Objects.equals(this.groupId, processSupervisor.groupId) &&
                Objects.equals(this.userId, processSupervisor.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(processId, roleId, groupId, userId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessSupervisor {\n");
        sb.append("    processId: ").append(toIndentedString(processId)).append("\n");
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
