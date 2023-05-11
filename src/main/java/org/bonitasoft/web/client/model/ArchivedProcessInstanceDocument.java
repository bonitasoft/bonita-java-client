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
 * ArchivedProcessInstanceDocument
 */
@JsonPropertyOrder({
        ArchivedProcessInstanceDocument.JSON_PROPERTY_ID,
        ArchivedProcessInstanceDocument.JSON_PROPERTY_CREATION_DATE,
        ArchivedProcessInstanceDocument.JSON_PROPERTY_AUTHOR,
        ArchivedProcessInstanceDocument.JSON_PROPERTY_INDEX,
        ArchivedProcessInstanceDocument.JSON_PROPERTY_CONTENT_MIMETYPE,
        ArchivedProcessInstanceDocument.JSON_PROPERTY_CASE_ID,
        ArchivedProcessInstanceDocument.JSON_PROPERTY_CONTENT_STORAGE_ID,
        ArchivedProcessInstanceDocument.JSON_PROPERTY_IS_INTERNAL,
        ArchivedProcessInstanceDocument.JSON_PROPERTY_DESCRIPTION,
        ArchivedProcessInstanceDocument.JSON_PROPERTY_NAME,
        ArchivedProcessInstanceDocument.JSON_PROPERTY_FILE_NAME,
        ArchivedProcessInstanceDocument.JSON_PROPERTY_SUBMITTED_BY,
        ArchivedProcessInstanceDocument.JSON_PROPERTY_URL,
        ArchivedProcessInstanceDocument.JSON_PROPERTY_VERSION,
        ArchivedProcessInstanceDocument.JSON_PROPERTY_SOURCE_OBJECT_ID,
        ArchivedProcessInstanceDocument.JSON_PROPERTY_ARCHIVED_DATE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ArchivedProcessInstanceDocument implements Serializable {

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

    public static final String JSON_PROPERTY_SOURCE_OBJECT_ID = "sourceObjectId";
    private String sourceObjectId;

    public static final String JSON_PROPERTY_ARCHIVED_DATE = "archivedDate";
    private String archivedDate;

    public ArchivedProcessInstanceDocument() {
    }

    public ArchivedProcessInstanceDocument id(String id) {

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

    public ArchivedProcessInstanceDocument creationDate(String creationDate) {

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

    public ArchivedProcessInstanceDocument author(String author) {

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

    public ArchivedProcessInstanceDocument index(String index) {

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

    public ArchivedProcessInstanceDocument contentMimetype(String contentMimetype) {

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

    public ArchivedProcessInstanceDocument caseId(String caseId) {

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

    public ArchivedProcessInstanceDocument contentStorageId(String contentStorageId) {

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

    public ArchivedProcessInstanceDocument isInternal(Boolean isInternal) {

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

    public ArchivedProcessInstanceDocument description(String description) {

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

    public ArchivedProcessInstanceDocument name(String name) {

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

    public ArchivedProcessInstanceDocument fileName(String fileName) {

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

    public ArchivedProcessInstanceDocument submittedBy(String submittedBy) {

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

    public ArchivedProcessInstanceDocument url(String url) {

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

    public ArchivedProcessInstanceDocument version(String version) {

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

    public ArchivedProcessInstanceDocument sourceObjectId(String sourceObjectId) {

        this.sourceObjectId = sourceObjectId;
        return this;
    }

    /**
     * original document id
     * 
     * @return sourceObjectId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SOURCE_OBJECT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSourceObjectId() {
        return sourceObjectId;
    }

    @JsonProperty(JSON_PROPERTY_SOURCE_OBJECT_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSourceObjectId(String sourceObjectId) {
        this.sourceObjectId = sourceObjectId;
    }

    public ArchivedProcessInstanceDocument archivedDate(String archivedDate) {

        this.archivedDate = archivedDate;
        return this;
    }

    /**
     * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when the current task was assigned for example &#39;2014-10-17 16:05:42.626&#39;
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
        ArchivedProcessInstanceDocument archivedProcessInstanceDocument = (ArchivedProcessInstanceDocument) o;
        return Objects.equals(this.id, archivedProcessInstanceDocument.id) &&
                Objects.equals(this.creationDate, archivedProcessInstanceDocument.creationDate) &&
                Objects.equals(this.author, archivedProcessInstanceDocument.author) &&
                Objects.equals(this.index, archivedProcessInstanceDocument.index) &&
                Objects.equals(this.contentMimetype, archivedProcessInstanceDocument.contentMimetype) &&
                Objects.equals(this.caseId, archivedProcessInstanceDocument.caseId) &&
                Objects.equals(this.contentStorageId, archivedProcessInstanceDocument.contentStorageId) &&
                Objects.equals(this.isInternal, archivedProcessInstanceDocument.isInternal) &&
                Objects.equals(this.description, archivedProcessInstanceDocument.description) &&
                Objects.equals(this.name, archivedProcessInstanceDocument.name) &&
                Objects.equals(this.fileName, archivedProcessInstanceDocument.fileName) &&
                Objects.equals(this.submittedBy, archivedProcessInstanceDocument.submittedBy) &&
                Objects.equals(this.url, archivedProcessInstanceDocument.url) &&
                Objects.equals(this.version, archivedProcessInstanceDocument.version) &&
                Objects.equals(this.sourceObjectId, archivedProcessInstanceDocument.sourceObjectId) &&
                Objects.equals(this.archivedDate, archivedProcessInstanceDocument.archivedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, author, index, contentMimetype, caseId, contentStorageId, isInternal,
                description, name, fileName, submittedBy, url, version, sourceObjectId, archivedDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ArchivedProcessInstanceDocument {\n");
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
        sb.append("    sourceObjectId: ").append(toIndentedString(sourceObjectId)).append("\n");
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
