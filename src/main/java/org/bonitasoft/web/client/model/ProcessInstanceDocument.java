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
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class ProcessInstanceDocument implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    @jakarta.annotation.Nullable
    private String id;

    public static final String JSON_PROPERTY_CREATION_DATE = "creationDate";
    @jakarta.annotation.Nullable
    private String creationDate;

    public static final String JSON_PROPERTY_AUTHOR = "author";
    @jakarta.annotation.Nullable
    private String author;

    public static final String JSON_PROPERTY_INDEX = "index";
    @jakarta.annotation.Nullable
    private String index;

    public static final String JSON_PROPERTY_CONTENT_MIMETYPE = "contentMimetype";
    @jakarta.annotation.Nullable
    private String contentMimetype;

    public static final String JSON_PROPERTY_CASE_ID = "caseId";
    @jakarta.annotation.Nullable
    private String caseId;

    public static final String JSON_PROPERTY_CONTENT_STORAGE_ID = "contentStorageId";
    @jakarta.annotation.Nullable
    private String contentStorageId;

    public static final String JSON_PROPERTY_IS_INTERNAL = "isInternal";
    @jakarta.annotation.Nullable
    private Boolean isInternal;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    @jakarta.annotation.Nullable
    private String description;

    public static final String JSON_PROPERTY_NAME = "name";
    @jakarta.annotation.Nullable
    private String name;

    public static final String JSON_PROPERTY_FILE_NAME = "fileName";
    @jakarta.annotation.Nullable
    private String fileName;

    public static final String JSON_PROPERTY_SUBMITTED_BY = "submittedBy";
    @jakarta.annotation.Nullable
    private String submittedBy;

    public static final String JSON_PROPERTY_URL = "url";
    @jakarta.annotation.Nullable
    private String url;

    public static final String JSON_PROPERTY_VERSION = "version";
    @jakarta.annotation.Nullable
    private String version;

    public ProcessInstanceDocument() {
    }

    public ProcessInstanceDocument id(@jakarta.annotation.Nullable String id) {

        this.id = id;
        return this;
    }

    /**
     * documentId
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

    public ProcessInstanceDocument creationDate(@jakarta.annotation.Nullable String creationDate) {

        this.creationDate = creationDate;
        return this;
    }

    /**
     * date and time
     * 
     * @return creationDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CREATION_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCreationDate() {
        return creationDate;
    }

    @JsonProperty(JSON_PROPERTY_CREATION_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCreationDate(@jakarta.annotation.Nullable String creationDate) {
        this.creationDate = creationDate;
    }

    public ProcessInstanceDocument author(@jakarta.annotation.Nullable String author) {

        this.author = author;
        return this;
    }

    /**
     * submittorUserId
     * 
     * @return author
     * @deprecated
     */
    @Deprecated
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_AUTHOR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getAuthor() {
        return author;
    }

    @JsonProperty(JSON_PROPERTY_AUTHOR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAuthor(@jakarta.annotation.Nullable String author) {
        this.author = author;
    }

    public ProcessInstanceDocument index(@jakarta.annotation.Nullable String index) {

        this.index = index;
        return this;
    }

    /**
     * index in a list of documents, or -1 for a single document
     * 
     * @return index
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INDEX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getIndex() {
        return index;
    }

    @JsonProperty(JSON_PROPERTY_INDEX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIndex(@jakarta.annotation.Nullable String index) {
        this.index = index;
    }

    public ProcessInstanceDocument contentMimetype(@jakarta.annotation.Nullable String contentMimetype) {

        this.contentMimetype = contentMimetype;
        return this;
    }

    /**
     * MIME type
     * 
     * @return contentMimetype
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONTENT_MIMETYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getContentMimetype() {
        return contentMimetype;
    }

    @JsonProperty(JSON_PROPERTY_CONTENT_MIMETYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContentMimetype(@jakarta.annotation.Nullable String contentMimetype) {
        this.contentMimetype = contentMimetype;
    }

    public ProcessInstanceDocument caseId(@jakarta.annotation.Nullable String caseId) {

        this.caseId = caseId;
        return this;
    }

    /**
     * caseId
     * 
     * @return caseId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CASE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCaseId() {
        return caseId;
    }

    @JsonProperty(JSON_PROPERTY_CASE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCaseId(@jakarta.annotation.Nullable String caseId) {
        this.caseId = caseId;
    }

    public ProcessInstanceDocument contentStorageId(@jakarta.annotation.Nullable String contentStorageId) {

        this.contentStorageId = contentStorageId;
        return this;
    }

    /**
     * storageId
     * 
     * @return contentStorageId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONTENT_STORAGE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getContentStorageId() {
        return contentStorageId;
    }

    @JsonProperty(JSON_PROPERTY_CONTENT_STORAGE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContentStorageId(@jakarta.annotation.Nullable String contentStorageId) {
        this.contentStorageId = contentStorageId;
    }

    public ProcessInstanceDocument isInternal(@jakarta.annotation.Nullable Boolean isInternal) {

        this.isInternal = isInternal;
        return this;
    }

    /**
     * &#x60;true&#x60; if the the document object contains the content directly. &#x60;false&#x60; if the document is specified by URL so the document object
     * contains a reference to the content, not the content itself.
     * 
     * @return isInternal
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_IS_INTERNAL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getIsInternal() {
        return isInternal;
    }

    @JsonProperty(JSON_PROPERTY_IS_INTERNAL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIsInternal(@jakarta.annotation.Nullable Boolean isInternal) {
        this.isInternal = isInternal;
    }

    public ProcessInstanceDocument description(@jakarta.annotation.Nullable String description) {

        this.description = description;
        return this;
    }

    /**
     * description
     * 
     * @return description
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDescription() {
        return description;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDescription(@jakarta.annotation.Nullable String description) {
        this.description = description;
    }

    public ProcessInstanceDocument name(@jakarta.annotation.Nullable String name) {

        this.name = name;
        return this;
    }

    /**
     * name
     * 
     * @return name
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setName(@jakarta.annotation.Nullable String name) {
        this.name = name;
    }

    public ProcessInstanceDocument fileName(@jakarta.annotation.Nullable String fileName) {

        this.fileName = fileName;
        return this;
    }

    /**
     * filename
     * 
     * @return fileName
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FILE_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFileName() {
        return fileName;
    }

    @JsonProperty(JSON_PROPERTY_FILE_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFileName(@jakarta.annotation.Nullable String fileName) {
        this.fileName = fileName;
    }

    public ProcessInstanceDocument submittedBy(@jakarta.annotation.Nullable String submittedBy) {

        this.submittedBy = submittedBy;
        return this;
    }

    /**
     * submittorUserId
     * 
     * @return submittedBy
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SUBMITTED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSubmittedBy() {
        return submittedBy;
    }

    @JsonProperty(JSON_PROPERTY_SUBMITTED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSubmittedBy(@jakarta.annotation.Nullable String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public ProcessInstanceDocument url(@jakarta.annotation.Nullable String url) {

        this.url = url;
        return this;
    }

    /**
     * urlForDownload
     * 
     * @return url
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUrl() {
        return url;
    }

    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUrl(@jakarta.annotation.Nullable String url) {
        this.url = url;
    }

    public ProcessInstanceDocument version(@jakarta.annotation.Nullable String version) {

        this.version = version;
        return this;
    }

    /**
     * version
     * 
     * @return version
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getVersion() {
        return version;
    }

    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVersion(@jakarta.annotation.Nullable String version) {
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
