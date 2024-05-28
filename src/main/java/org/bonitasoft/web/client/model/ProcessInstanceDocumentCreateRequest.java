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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ProcessInstanceDocumentCreateRequest
 */
@JsonPropertyOrder({
        ProcessInstanceDocumentCreateRequest.JSON_PROPERTY_CASE_ID,
        ProcessInstanceDocumentCreateRequest.JSON_PROPERTY_FILE,
        ProcessInstanceDocumentCreateRequest.JSON_PROPERTY_URL,
        ProcessInstanceDocumentCreateRequest.JSON_PROPERTY_NAME,
        ProcessInstanceDocumentCreateRequest.JSON_PROPERTY_FILE_NAME,
        ProcessInstanceDocumentCreateRequest.JSON_PROPERTY_DESCRIPTION
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class ProcessInstanceDocumentCreateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_CASE_ID = "caseId";
    private String caseId;

    public static final String JSON_PROPERTY_FILE = "file";
    private String file;

    public static final String JSON_PROPERTY_URL = "url";
    private String url;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_FILE_NAME = "fileName";
    private String fileName;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public ProcessInstanceDocumentCreateRequest() {
    }

    public ProcessInstanceDocumentCreateRequest caseId(String caseId) {

        this.caseId = caseId;
        return this;
    }

    /**
     * The process instance id
     * 
     * @return caseId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CASE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCaseId() {
        return caseId;
    }

    @JsonProperty(JSON_PROPERTY_CASE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public ProcessInstanceDocumentCreateRequest file(String file) {

        this.file = file;
        return this;
    }

    /**
     * The local file name to upload from (as from the temp upload folder)
     * 
     * @return file
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FILE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFile() {
        return file;
    }

    @JsonProperty(JSON_PROPERTY_FILE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFile(String file) {
        this.file = file;
    }

    public ProcessInstanceDocumentCreateRequest url(String url) {

        this.url = url;
        return this;
    }

    /**
     * The remote url to upload from
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

    public ProcessInstanceDocumentCreateRequest name(String name) {

        this.name = name;
        return this;
    }

    /**
     * The file display name
     * 
     * @return name
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setName(String name) {
        this.name = name;
    }

    public ProcessInstanceDocumentCreateRequest fileName(String fileName) {

        this.fileName = fileName;
        return this;
    }

    /**
     * The target file name
     * 
     * @return fileName
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FILE_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFileName() {
        return fileName;
    }

    @JsonProperty(JSON_PROPERTY_FILE_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ProcessInstanceDocumentCreateRequest description(String description) {

        this.description = description;
        return this;
    }

    /**
     * The document description
     * 
     * @return description
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDescription() {
        return description;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProcessInstanceDocumentCreateRequest processInstanceDocumentCreateRequest = (ProcessInstanceDocumentCreateRequest) o;
        return Objects.equals(this.caseId, processInstanceDocumentCreateRequest.caseId) &&
                Objects.equals(this.file, processInstanceDocumentCreateRequest.file) &&
                Objects.equals(this.url, processInstanceDocumentCreateRequest.url) &&
                Objects.equals(this.name, processInstanceDocumentCreateRequest.name) &&
                Objects.equals(this.fileName, processInstanceDocumentCreateRequest.fileName) &&
                Objects.equals(this.description, processInstanceDocumentCreateRequest.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseId, file, url, name, fileName, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessInstanceDocumentCreateRequest {\n");
        sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
        sb.append("    file: ").append(toIndentedString(file)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
