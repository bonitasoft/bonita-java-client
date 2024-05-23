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
 * ArchivedProcessInstanceComment
 */
@JsonPropertyOrder({
        ArchivedProcessInstanceComment.JSON_PROPERTY_ID,
        ArchivedProcessInstanceComment.JSON_PROPERTY_CONTENT,
        ArchivedProcessInstanceComment.JSON_PROPERTY_TENANT_ID,
        ArchivedProcessInstanceComment.JSON_PROPERTY_PROCESS_INSTANCE_ID,
        ArchivedProcessInstanceComment.JSON_PROPERTY_POST_DATE,
        ArchivedProcessInstanceComment.JSON_PROPERTY_USER_ID,
        ArchivedProcessInstanceComment.JSON_PROPERTY_ARCHIVED_DATE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.5.0")
public class ArchivedProcessInstanceComment implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_CONTENT = "content";
    private String content;

    public static final String JSON_PROPERTY_TENANT_ID = "tenantId";
    private String tenantId;

    public static final String JSON_PROPERTY_PROCESS_INSTANCE_ID = "processInstanceId";
    private String processInstanceId;

    public static final String JSON_PROPERTY_POST_DATE = "postDate";
    private String postDate;

    public static final String JSON_PROPERTY_USER_ID = "userId";
    private String userId;

    public static final String JSON_PROPERTY_ARCHIVED_DATE = "archivedDate";
    private String archivedDate;

    public ArchivedProcessInstanceComment() {
    }

    public ArchivedProcessInstanceComment id(String id) {

        this.id = id;
        return this;
    }

    /**
     * the comment id
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

    public ArchivedProcessInstanceComment content(String content) {

        this.content = content;
        return this;
    }

    /**
     * the comment content
     * 
     * @return content
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONTENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getContent() {
        return content;
    }

    @JsonProperty(JSON_PROPERTY_CONTENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContent(String content) {
        this.content = content;
    }

    public ArchivedProcessInstanceComment tenantId(String tenantId) {

        this.tenantId = tenantId;
        return this;
    }

    /**
     * the id of the tenant the comment is associated to
     * 
     * @return tenantId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TENANT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTenantId() {
        return tenantId;
    }

    @JsonProperty(JSON_PROPERTY_TENANT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public ArchivedProcessInstanceComment processInstanceId(String processInstanceId) {

        this.processInstanceId = processInstanceId;
        return this;
    }

    /**
     * the process instance (case) the comment is associated to
     * 
     * @return processInstanceId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PROCESS_INSTANCE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    @JsonProperty(JSON_PROPERTY_PROCESS_INSTANCE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public ArchivedProcessInstanceComment postDate(String postDate) {

        this.postDate = postDate;
        return this;
    }

    /**
     * the comment creation date
     * 
     * @return postDate
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_POST_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPostDate() {
        return postDate;
    }

    @JsonProperty(JSON_PROPERTY_POST_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public ArchivedProcessInstanceComment userId(String userId) {

        this.userId = userId;
        return this;
    }

    /**
     * the user that created the comment
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

    public ArchivedProcessInstanceComment archivedDate(String archivedDate) {

        this.archivedDate = archivedDate;
        return this;
    }

    /**
     * the date set when the process instance comment was archived
     * 
     * @return archivedDate
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ARCHIVED_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getArchivedDate() {
        return archivedDate;
    }

    @JsonProperty(JSON_PROPERTY_ARCHIVED_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setArchivedDate(String archivedDate) {
        this.archivedDate = archivedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArchivedProcessInstanceComment archivedProcessInstanceComment = (ArchivedProcessInstanceComment) o;
        return Objects.equals(this.id, archivedProcessInstanceComment.id) &&
                Objects.equals(this.content, archivedProcessInstanceComment.content) &&
                Objects.equals(this.tenantId, archivedProcessInstanceComment.tenantId) &&
                Objects.equals(this.processInstanceId, archivedProcessInstanceComment.processInstanceId) &&
                Objects.equals(this.postDate, archivedProcessInstanceComment.postDate) &&
                Objects.equals(this.userId, archivedProcessInstanceComment.userId) &&
                Objects.equals(this.archivedDate, archivedProcessInstanceComment.archivedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, tenantId, processInstanceId, postDate, userId, archivedDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ArchivedProcessInstanceComment {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
        sb.append("    processInstanceId: ").append(toIndentedString(processInstanceId)).append("\n");
        sb.append("    postDate: ").append(toIndentedString(postDate)).append("\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    archivedDate: ").append(toIndentedString(archivedDate)).append("\n");
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
