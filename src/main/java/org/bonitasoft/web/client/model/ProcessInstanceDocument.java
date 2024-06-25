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
 * A document in an active case
 */
@JsonPropertyOrder({
        ProcessInstanceDocument.JSON_PROPERTY_ID,
        ProcessInstanceDocument.JSON_PROPERTY_CREATION_DATE,
        ProcessInstanceDocument.JSON_PROPERTY_AUTHOR,
        ProcessInstanceDocument.JSON_PROPERTY_INDEX,
        ProcessInstanceDocument.JSON_PROPERTY_CONTENT_MIMETYPE,
        ProcessInstanceDocument.JSON_PROPERTY_CASE_ID,
        ProcessInstanceDocument.JSON_PROPERTY_CONTENT_STORAGE_ID,
        ProcessInstanceDocument.JSON_PROPERTY_IS_INTERNAL,
        ProcessInstanceDocument.JSON_PROPERTY_DESCRIPTION,
        ProcessInstanceDocument.JSON_PROPERTY_NAME,
        ProcessInstanceDocument.JSON_PROPERTY_FILE_NAME,
        ProcessInstanceDocument.JSON_PROPERTY_SUBMITTED_BY,
        ProcessInstanceDocument.JSON_PROPERTY_URL,
        ProcessInstanceDocument.JSON_PROPERTY_VERSION
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class ProcessInstanceDocument implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_CREATION_DATE = "creationDate";
    private String creationDate;

    public static final String JSON_PROPERTY_AUTHOR = "author";
    private String author;

    public static final String JSON_PROPERTY_INDEX = "index";
    private String index;

    public static final String JSON_PROPERTY_CONTENT_MIMETYPE = "contentMimetype";
    private String contentMimetype;

    public static final String JSON_PROPERTY_CASE_ID = "caseId";
    private String caseId;

    public static final String JSON_PROPERTY_CONTENT_STORAGE_ID = "contentStorageId";
    private String contentStorageId;

    public static final String JSON_PROPERTY_IS_INTERNAL = "isInternal";
    private Boolean isInternal;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_FILE_NAME = "fileName";
    private String fileName;

    public static final String JSON_PROPERTY_SUBMITTED_BY = "submittedBy";
    private String submittedBy;

    public static final String JSON_PROPERTY_URL = "url";
    private String url;

    public static final String JSON_PROPERTY_VERSION = "version";
    private String version;

    public ProcessInstanceDocument() {
    }

    public ProcessInstanceDocument id(String id) {

        this.id = id;
        return this;
    }

    /**
     * documentId
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

    public ProcessInstanceDocument creationDate(String creationDate) {

        this.creationDate = creationDate;
        return this;
    }

    /**
     * date and time
     * 
     * @return creationDate
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATION_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCreationDate() {
        return creationDate;
    }

    @JsonProperty(JSON_PROPERTY_CREATION_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public ProcessInstanceDocument author(String author) {

        this.author = author;
        return this;
    }

    /**
     * submittorUserId
     * 
     * @return author
     * @deprecated
     **/
    @Deprecated
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_AUTHOR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getAuthor() {
        return author;
    }

    @JsonProperty(JSON_PROPERTY_AUTHOR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAuthor(String author) {
        this.author = author;
    }

    public ProcessInstanceDocument index(String index) {

        this.index = index;
        return this;
    }

    /**
     * index in a list of documents, or -1 for a single document
     * 
     * @return index
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INDEX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getIndex() {
        return index;
    }

    @JsonProperty(JSON_PROPERTY_INDEX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIndex(String index) {
        this.index = index;
    }

    public ProcessInstanceDocument contentMimetype(String contentMimetype) {

        this.contentMimetype = contentMimetype;
        return this;
    }

    /**
     * MIME type
     * 
     * @return contentMimetype
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONTENT_MIMETYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getContentMimetype() {
        return contentMimetype;
    }

    @JsonProperty(JSON_PROPERTY_CONTENT_MIMETYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContentMimetype(String contentMimetype) {
        this.contentMimetype = contentMimetype;
    }

    public ProcessInstanceDocument caseId(String caseId) {

        this.caseId = caseId;
        return this;
    }

    /**
     * caseId
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

    public ProcessInstanceDocument contentStorageId(String contentStorageId) {

        this.contentStorageId = contentStorageId;
        return this;
    }

    /**
     * storageId
     * 
     * @return contentStorageId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONTENT_STORAGE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getContentStorageId() {
        return contentStorageId;
    }

    @JsonProperty(JSON_PROPERTY_CONTENT_STORAGE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContentStorageId(String contentStorageId) {
        this.contentStorageId = contentStorageId;
    }

    public ProcessInstanceDocument isInternal(Boolean isInternal) {

        this.isInternal = isInternal;
        return this;
    }

    /**
     * &#x60;true&#x60; if the the document object contains the content directly. &#x60;false&#x60; if the document is specified by URL so the document object
     * contains a reference to the content, not the content itself.
     * 
     * @return isInternal
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_IS_INTERNAL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getIsInternal() {
        return isInternal;
    }

    @JsonProperty(JSON_PROPERTY_IS_INTERNAL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIsInternal(Boolean isInternal) {
        this.isInternal = isInternal;
    }

    public ProcessInstanceDocument description(String description) {

        this.description = description;
        return this;
    }

    /**
     * description
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

    public ProcessInstanceDocument name(String name) {

        this.name = name;
        return this;
    }

    /**
     * name
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

    public ProcessInstanceDocument fileName(String fileName) {

        this.fileName = fileName;
        return this;
    }

    /**
     * filename
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

    public ProcessInstanceDocument submittedBy(String submittedBy) {

        this.submittedBy = submittedBy;
        return this;
    }

    /**
     * submittorUserId
     * 
     * @return submittedBy
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SUBMITTED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSubmittedBy() {
        return submittedBy;
    }

    @JsonProperty(JSON_PROPERTY_SUBMITTED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public ProcessInstanceDocument url(String url) {

        this.url = url;
        return this;
    }

    /**
     * urlForDownload
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

    public ProcessInstanceDocument version(String version) {

        this.version = version;
        return this;
    }

    /**
     * version
     * 
     * @return version
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getVersion() {
        return version;
    }

    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProcessInstanceDocument processInstanceDocument = (ProcessInstanceDocument) o;
        return Objects.equals(this.id, processInstanceDocument.id) &&
                Objects.equals(this.creationDate, processInstanceDocument.creationDate) &&
                Objects.equals(this.author, processInstanceDocument.author) &&
                Objects.equals(this.index, processInstanceDocument.index) &&
                Objects.equals(this.contentMimetype, processInstanceDocument.contentMimetype) &&
                Objects.equals(this.caseId, processInstanceDocument.caseId) &&
                Objects.equals(this.contentStorageId, processInstanceDocument.contentStorageId) &&
                Objects.equals(this.isInternal, processInstanceDocument.isInternal) &&
                Objects.equals(this.description, processInstanceDocument.description) &&
                Objects.equals(this.name, processInstanceDocument.name) &&
                Objects.equals(this.fileName, processInstanceDocument.fileName) &&
                Objects.equals(this.submittedBy, processInstanceDocument.submittedBy) &&
                Objects.equals(this.url, processInstanceDocument.url) &&
                Objects.equals(this.version, processInstanceDocument.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, author, index, contentMimetype, caseId, contentStorageId, isInternal,
                description, name, fileName, submittedBy, url, version);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessInstanceDocument {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    author: ").append(toIndentedString(author)).append("\n");
        sb.append("    index: ").append(toIndentedString(index)).append("\n");
        sb.append("    contentMimetype: ").append(toIndentedString(contentMimetype)).append("\n");
        sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
        sb.append("    contentStorageId: ").append(toIndentedString(contentStorageId)).append("\n");
        sb.append("    isInternal: ").append(toIndentedString(isInternal)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
        sb.append("    submittedBy: ").append(toIndentedString(submittedBy)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
