/*
 * Bonita HTTP API
 *  The REST API lets you access the data with HTTP requests; it is useful when implementing rich web forms / pages for a good user experience.  If your application is using a technology other than Java, you can integrate it with the Bonita solution using the Web REST API. This API provides access to all Bonita objects (like processes, tasks, users, connectors etc.), to execute operations on them (create, retrieve, update, delete). You can use these operations to create a workflow with Bonita and integrate it into your application. The Bonita Engine remains responsible for executing the workflow logic (connectors, gateways with conditions, messages, timers etc.) while your application gives access to the workflow. Users can manage processes and tasks, and perform administrative activities.  ![diagram of architecture of a REST client integrated with Bonita](images/rest_overview_v2.png)  ### API Extensions  You can create [Rest API Extensions](rest-api-extensions.md) to extend the Rest API by adding missing ressources (not provided by the Rest API). It is possible for an extension to interact with the engine (via the API) or with any other external service (for example a database, a directory, or a web service).  ### Create a resource  | Request URL | `http://.../API/{API_name}/{resource_name}/  `| |:-|:-| | Request Method | POST| | Request Payload | an item in JSON| | Response | the same item in JSON, containing the values provided in the posted item, completed with default values and identifiers provided by Bonita Engine.|  ### Read a resource  | Request URL | `http://.../API/{API_name}/{resource_name}/{id} `| |:-|:-| | Request Method | GET| | Response | an item in JSON|  Example `http://.../API/identity/user/5 `  #### Extend resource response  On some resources, in GET methods the `d` (deploy) URL query parameter can be used to extend the response objects. The value of this parameter consists of an attribute for which you want to make an extended request (called a deploy) and retrieve attributes of a linked resource. This means that instead of retrieving the ID or a parent or referenced resource, you can retrieve the full object.  For example, when you retrieve a task, you can also retrieve the process definition attributes in addition to the process definition ID that is already part of the task resource. The supported deploy values for a task include its process (d=processId).  Specifiy multiple `d` parameter to extend several resources. For instance, to retrieve the flow node of id 143 and the associated process, process instance and assigned user, call `/API/bpm/flowNode/143?d=processId&d=caseId&d=assigned_id`  #### With compound identifier  The order of the identifier parts for each resource type is given in the table above.  | Request URL | `http://.../API/{API_name}/{resource_name}/{id_part1}/{id_part2} `| |:-|:-| | Request Method | GET| | Response | an item in JSON|  Example `http://.../API/identity/membership/5/12/24 `  ### Update a resource  | Request URL | `http://.../API/{API_name}/{resource_name}/{id} `| |:-|:-| | Request Method | PUT| | Request Payload | a map in JSON containing the new values for the attributes you want to change.| | Response | the corresponding item in JSON with new values where you requested a modification|  Example `http://.../API/identity/user/5`  #### With compound identifier:  Response: the corresponding item in JSON with new values where you requested a modification.  | Request URL | `http://.../API/{API_name}/{resource_name}/{id_part1}/{id_part2} `| |:-|:-| | Request Method | PUT| | Request Payload | ` a map in JSON containing the new values for the attributes you want to change `| | Response | ` the corresponding item in JSON with new values where you requested a modification`|  Example `http://.../API/identity/membership/5/12/24 `  ### Delete resources  Use the DELETE request to remove multiple resources.  | Request URL | `http://.../API/{API_name}/{resource_name}/ `| |:-|:-| | Request Method | DELETE| | Request Payload | A list of identifiers in JSON, for example `[\"id1\",\"id2\",\"id3\"]`. Compound identifiers are separated by '/' characters.| | Response | `empty `|  Example `http://.../API/identity/membership/ `  ### Search for a resource  The required object is specified with a set of filters in the request URL. The URL parameters must be URL-encoded.  Results are returned in a paged list, so you have to specify the page (counting from zero), and the number of results per page (count), additionally you can define a sort key (order). You can see the total number of matching results in the HTTP response header Content-Range. If you are searching for business data using a custom query, there must be a [count query in the BDM](define-and-deploy-the-bdm.md). If there is no count query, results from a custom query on business data cannot be paged properly (the header Content-Range will be absent). For business data default queries, the count query is defined automatically.  The available filters are the attributes of the item plus some specific filters defined by each item.  | Request URL | `http://.../API/{API_name}/{resource_name}?p={page}&c={count}&o={order}&s={query}&f={filter_name}={filter_value}&f=... `| |:-|:-| | Request Method | GET| | Response | an array of items in JSON|  Example `/API/identity/user?p=0&c=10&o=firstname&s=test&f=manager_id=3`  For a GET method that retrieves more than one instance of a resource, you can specify the following request parameters:  * p (Mandatory): index of the page to display * c (Mandatory): maximum number of elements to retrieve * o: order of presentation of values in response: must be either `attributeName ASC` or `attributeName DESC`. The final order parameter value must be URL encoded. * f: list of filters, specified as `attributeName=attributeValue`. To filter on more than one attribute, specify an f parameters for each attribute. The final filter parameter value must be URL encoded.   The attributes you can filter on are specific to the resource. * s: search on name or search indexes. The matching policy depends on the configuration of [word-based search](using-list-and-search-methods.md).   For example, if word-based search is enabled, `s=Valid` returns matches containing the string \"valid\" at the start of any word in the attribute value word,   such as \"Valid address\", \"Not a valid address\", and \"Validated request\" but not \"Invalid request\".   If word-based search is disabled, `s=Valid` returns matches containing the string \"valid\" at the start of the attribute value, such as \"Valid address\" or \"Validated request\" but not \"Not a valid address\" or \"Invalid request\".  ### Errors  The API uses standard HTTP status codes to indicate the success or failure of the API call.  If you get a `401` response code :   - make sure that the cookies have been transfered with the call   - make sure that the cookies transfered are the ones generated during the last sucessfull login call   - if one of the PUT, DELETE or POST method is used, make sure that the `X-Bonita-API-Token` header is included   - if the X-Bonita-API-Token header is included, make sure that the value is the same as the one of the cookie generated during the last login   - Maybe a logout was issued or the session has expired; try to log in again, and re run the request with the new cookies and the new value for the `X-Bonita-API-Token` header.
 *
 * The version of the OpenAPI document: 0.0.6
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.bonitasoft.web.client.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.annotations.ApiModelProperty;

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
@JsonTypeName("ArchivedProcessInstanceDocument")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
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
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "documentId")
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
   * @return creationDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "date and time")
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
   * @return author
   * @deprecated
  **/
  @Deprecated
  @javax.annotation.Nullable
  @ApiModelProperty(value = "submittorUserId")
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
   * @return index
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "index in a list of documents, or -1 for a single document")
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
   * @return contentMimetype
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "MIME type")
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
   * @return caseId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "caseId")
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
   * @return contentStorageId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "storageId")
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
   * &#x60;true&#x60; if  the the document object contains the content directly. &#x60;false&#x60; if the document is specified by URL so the document object contains a reference to the content, not the content itself.
   * @return isInternal
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "`true` if  the the document object contains the content directly. `false` if the document is specified by URL so the document object contains a reference to the content, not the content itself.")
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
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "description")
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
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "name")
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
   * @return fileName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "filename")
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
   * @return submittedBy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "submittorUserId")
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
   * @return url
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "urlForDownload")
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
   * @return version
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "version")
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
   * @return sourceObjectId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "original document id")
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
   * @return archivedDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the date ('yyyy-MM-dd HH:mm:ss.SSS') when the current task was assigned for example '2014-10-17 16:05:42.626'")
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
    return Objects.hash(id, creationDate, author, index, contentMimetype, caseId, contentStorageId, isInternal, description, name, fileName, submittedBy, url, version, sourceObjectId, archivedDate);
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

