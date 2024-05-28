/** 
 * Copyright (C) 2024 BonitaSoft S.A.
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
 * Form Mapping specifies the mapping of a form to a process or a task. The mapping indicates the technology used to create the form, in the &#x60;target&#x60;
 * attribute.
 */
@JsonPropertyOrder({
        FormMapping.JSON_PROPERTY_ID,
        FormMapping.JSON_PROPERTY_PROCESS_DEFINITION_ID,
        FormMapping.JSON_PROPERTY_TYPE,
        FormMapping.JSON_PROPERTY_TARGET,
        FormMapping.JSON_PROPERTY_TASK,
        FormMapping.JSON_PROPERTY_PAGE_ID,
        FormMapping.JSON_PROPERTY_PAGE_MAPPING_KEY,
        FormMapping.JSON_PROPERTY_LAST_UPDATE_BY,
        FormMapping.JSON_PROPERTY_LAST_UPDATE_DATE,
        FormMapping.JSON_PROPERTY_URL
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class FormMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_PROCESS_DEFINITION_ID = "processDefinitionId";
    private String processDefinitionId;

    /**
     * the form mapping type
     */
    public enum TypeEnum {

        PROCESSSTART("PROCESSSTART"),

        PROCESSOVERVIEW("PROCESSOVERVIEW"),

        TASK("TASK");

        private String value;

        TypeEnum(String value) {
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
        public static TypeEnum fromValue(String value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_TYPE = "type";
    private TypeEnum type;

    /**
     * the target
     */
    public enum TargetEnum {

        URL("URL"),

        INTERNAL("INTERNAL"),

        LEGACY("LEGACY"),

        UNDEFINED("UNDEFINED"),

        NONE("NONE");

        private String value;

        TargetEnum(String value) {
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
        public static TargetEnum fromValue(String value) {
            for (TargetEnum b : TargetEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_TARGET = "target";
    private TargetEnum target;

    public static final String JSON_PROPERTY_TASK = "task";
    private String task;

    public static final String JSON_PROPERTY_PAGE_ID = "pageId";
    private String pageId;

    public static final String JSON_PROPERTY_PAGE_MAPPING_KEY = "pageMappingKey";
    private String pageMappingKey;

    public static final String JSON_PROPERTY_LAST_UPDATE_BY = "lastUpdateBy";
    private String lastUpdateBy;

    public static final String JSON_PROPERTY_LAST_UPDATE_DATE = "lastUpdateDate";
    private String lastUpdateDate;

    public static final String JSON_PROPERTY_URL = "url";
    private String url;

    public FormMapping() {
    }

    public FormMapping id(String id) {

        this.id = id;
        return this;
    }

    /**
     * the form mapping identifier
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

    public FormMapping processDefinitionId(String processDefinitionId) {

        this.processDefinitionId = processDefinitionId;
        return this;
    }

    /**
     * the process identifier related to this form mapping
     * 
     * @return processDefinitionId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PROCESS_DEFINITION_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    @JsonProperty(JSON_PROPERTY_PROCESS_DEFINITION_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public FormMapping type(TypeEnum type) {

        this.type = type;
        return this;
    }

    /**
     * the form mapping type
     * 
     * @return type
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public TypeEnum getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setType(TypeEnum type) {
        this.type = type;
    }

    public FormMapping target(TargetEnum target) {

        this.target = target;
        return this;
    }

    /**
     * the target
     * 
     * @return target
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TARGET)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public TargetEnum getTarget() {
        return target;
    }

    @JsonProperty(JSON_PROPERTY_TARGET)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTarget(TargetEnum target) {
        this.target = target;
    }

    public FormMapping task(String task) {

        this.task = task;
        return this;
    }

    /**
     * the task name when type is TASK - null otherwise
     * 
     * @return task
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TASK)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTask() {
        return task;
    }

    @JsonProperty(JSON_PROPERTY_TASK)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTask(String task) {
        this.task = task;
    }

    public FormMapping pageId(String pageId) {

        this.pageId = pageId;
        return this;
    }

    /**
     * the custom page identifier when type is INTERNAL - null otherwise
     * 
     * @return pageId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PAGE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPageId() {
        return pageId;
    }

    @JsonProperty(JSON_PROPERTY_PAGE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public FormMapping pageMappingKey(String pageMappingKey) {

        this.pageMappingKey = pageMappingKey;
        return this;
    }

    /**
     * the page mapping key part used to generate the form URL
     * 
     * @return pageMappingKey
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PAGE_MAPPING_KEY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPageMappingKey() {
        return pageMappingKey;
    }

    @JsonProperty(JSON_PROPERTY_PAGE_MAPPING_KEY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPageMappingKey(String pageMappingKey) {
        this.pageMappingKey = pageMappingKey;
    }

    public FormMapping lastUpdateBy(String lastUpdateBy) {

        this.lastUpdateBy = lastUpdateBy;
        return this;
    }

    /**
     * the identifier of the user who last updated this form mapping - 0 if no update has been done yet
     * 
     * @return lastUpdateBy
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LAST_UPDATE_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    @JsonProperty(JSON_PROPERTY_LAST_UPDATE_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public FormMapping lastUpdateDate(String lastUpdateDate) {

        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    /**
     * the last update date in milliseconds - null if no update has been done yet
     * 
     * @return lastUpdateDate
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LAST_UPDATE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    @JsonProperty(JSON_PROPERTY_LAST_UPDATE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public FormMapping url(String url) {

        this.url = url;
        return this;
    }

    /**
     * the external URL (string) when type is URL - null otherwise
     * 
     * @return url
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUrl() {
        return url;
    }

    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FormMapping formMapping = (FormMapping) o;
        return Objects.equals(this.id, formMapping.id) &&
                Objects.equals(this.processDefinitionId, formMapping.processDefinitionId) &&
                Objects.equals(this.type, formMapping.type) &&
                Objects.equals(this.target, formMapping.target) &&
                Objects.equals(this.task, formMapping.task) &&
                Objects.equals(this.pageId, formMapping.pageId) &&
                Objects.equals(this.pageMappingKey, formMapping.pageMappingKey) &&
                Objects.equals(this.lastUpdateBy, formMapping.lastUpdateBy) &&
                Objects.equals(this.lastUpdateDate, formMapping.lastUpdateDate) &&
                Objects.equals(this.url, formMapping.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, processDefinitionId, type, target, task, pageId, pageMappingKey, lastUpdateBy,
                lastUpdateDate, url);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FormMapping {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    processDefinitionId: ").append(toIndentedString(processDefinitionId)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    target: ").append(toIndentedString(target)).append("\n");
        sb.append("    task: ").append(toIndentedString(task)).append("\n");
        sb.append("    pageId: ").append(toIndentedString(pageId)).append("\n");
        sb.append("    pageMappingKey: ").append(toIndentedString(pageMappingKey)).append("\n");
        sb.append("    lastUpdateBy: ").append(toIndentedString(lastUpdateBy)).append("\n");
        sb.append("    lastUpdateDate: ").append(toIndentedString(lastUpdateDate)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
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
