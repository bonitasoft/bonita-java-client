/*
 * Bonita 7.11 HTTP API
 *  The REST API lets you access the data with HTTP requests; it is useful when implementing rich web forms / pages for a good user experience.  If your application is using a technology other than Java, you can integrate it with the Bonita solution using the Web REST API. This API provides access to all Bonita objects (like processes, tasks, users, connectors etc.), to execute operations on them (create, retrieve, update, delete). You can use these operations to create a workflow with Bonita and integrate it into your application. The Bonita Engine remains responsible for executing the workflow logic (connectors, gateways with conditions, messages, timers etc.) while your application gives access to the workflow. Users can manage processes and tasks, and perform administrative activities.  ![diagram of architecture of a REST client integrated with Bonita](images/rest_overview_v2.png)  ### API Extensions  You can create [Rest API Extensions](rest-api-extensions.md) to extend the Rest API by adding missing ressources (not provided by the Rest API). It is possible for an extension to interact with the engine (via the API) or with any other external service (for example a database, a directory, or a web service).  ### Create a resource  | | | |:-|:-| | Request URL | `http://.../API/{API_name}/{resource_name}/  `| | Request Method | POST| | Request Payload | an item in JSON| | Response | the same item in JSON, containing the values provided in the posted item, completed with default values and identifiers provided by Bonita Engine.|  ### Read a resource  | | | |:-|:-| | Request URL | `http://.../API/{API_name}/{resource_name}/{id} `| | Request Method | GET| | Response | an item in JSON|  Example `http://.../API/identity/user/5 `  #### Extend resource response  On some resources, in GET methods the `d` (deploy) URL query parameter can be used to extend the response objects. The value of this parameter consists of an attribute for which you want to make an extended request (called a deploy) and retrieve attributes of a linked resource. This means that instead of retrieving the ID or a parent or referenced resource, you can retrieve the full object.  For example, when you retrieve a task, you can also retrieve the process definition attributes in addition to the process definition ID that is already part of the task resource. The supported deploy values for a task include its process (d=processId).  Specifiy multiple `d` parameter to extend several resources. For instance, to retrieve the flow node of id 143 and the associated process, case and assigned user, call `/API/bpm/flowNode/143?d=processId&d=caseId&d=assigned_id`  #### With compound identifier  The order of the identifier parts for each resource type is given in the table above.  | | | |:-|:-| | Request URL | `http://.../API/{API_name}/{resource_name}/{id_part1}/{id_part2} `| | Request Method | GET| | Response | an item in JSON|  Example `http://.../API/identity/membership/5/12/24 `  ### Update a resource  | | | |:-|:-| | Request URL | `http://.../API/{API_name}/{resource_name}/{id} `| | Request Method | PUT| | Request Payload | a map in JSON containing the new values for the attributes you want to change.| | Response | the corresponding item in JSON with new values where you requested a modification|  Example `http://.../API/identity/user/5`  #### With compound identifier:  Response: the corresponding item in JSON with new values where you requested a modification.  | | | |:-|:-| | Request URL | `http://.../API/{API_name}/{resource_name}/{id_part1}/{id_part2} `| | Request Method | PUT| | Request Payload | ` a map in JSON containing the new values for the attributes you want to change `| | Response | ` the corresponding item in JSON with new values where you requested a modification`|  Example `http://.../API/identity/membership/5/12/24 `  ### Delete resources  Use the DELETE request to remove multiple resources.  | | | |:-|:-| | Request URL | `http://.../API/{API_name}/{resource_name}/ `| | Request Method | DELETE| | Request Payload | A list of identifiers in JSON, for example `[\"id1\",\"id2\",\"id3\"]`. Compound identifiers are separated by '/' characters.| | Response | `empty `|  Example `http://.../API/identity/membership/ `  ### Search for a resource  The required object is specified with a set of filters in the request URL. The URL parameters must be URL-encoded.  Results are returned in a paged list, so you have to specify the page (counting from zero), and the number of results per page (count), additionally you can define a sort key (order). You can see the total number of matching results in the HTTP response header Content-Range. If you are searching for business data using a custom query, there must be a [count query in the BDM](define-and-deploy-the-bdm.md). If there is no count query, results from a custom query on business data cannot be paged properly (the header Content-Range will be absent). For business data default queries, the count query is defined automatically.  The available filters are the attributes of the item plus some specific filters defined by each item.  | | | |:-|:-| | Request URL | `http://.../API/{API_name}/{resource_name}?p={page}&c={count}&o={order}&s={query}&f={filter_name}={filter_value}&f=... `| | Request Method | GET| | Response | an array of items in JSON|  Example `/API/identity/user?p=0&c=10&o=firstname&s=test&f=manager_id=3`  For a GET method that retrieves more than one instance of a resource, you can specify the following request parameters:  * p (Mandatory): index of the page to display * c (Mandatory): maximum number of elements to retrieve * o: order of presentation of values in response: must be either `attributeName ASC` or `attributeName DESC`. The final order parameter value must be URL encoded. * f: list of filters, specified as `attributeName=attributeValue`. To filter on more than one attribute, specify an f parameters for each attribute. The final filter parameter value must be URL encoded.   The attributes you can filter on are specific to the resource. * s: search on name or search indexes. The matching policy depends on the configuration of [word-based search](using-list-and-search-methods.md).   For example, if word-based search is enabled, `s=Valid` returns matches containing the string \"valid\" at the start of any word in the attribute value word,   such as \"Valid address\", \"Not a valid address\", and \"Validated request\" but not \"Invalid request\".   If word-based search is disabled, `s=Valid` returns matches containing the string \"valid\" at the start of the attribute value, such as \"Valid address\" or \"Validated request\" but not \"Not a valid address\" or \"Invalid request\".  ### Errors  The API uses standard HTTP status codes to indicate the success or failure of the API call.  If you get a `401` response code :   - make sure that the cookies have been transfered with the call   - make sure that the cookies transfered are the ones generated during the last sucessfull login call   - if one of the PUT, DELETE or POST method is used, make sure that the `X-Bonita-API-Token` header is included   - if the X-Bonita-API-Token header is included, make sure that the value is the same as the one of the cookie generated during the last login   - Maybe a logout was issued or the session has expired; try to log in again, and re run the request with the new cookies and the new value for the `X-Bonita-API-Token` header.
 *
 * The version of the OpenAPI document: 0.0.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.bonitasoft.web.client.internal.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.bonitasoft.web.client.internal.model.ArchivedCaseDocumentAllOf;
import org.bonitasoft.web.client.internal.model.CaseDocument;
import java.io.Serializable;

/**
 * ArchivedCaseDocument
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-09-30T18:19:33.829914+02:00[Europe/Paris]")
public class ArchivedCaseDocument implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_CREATION_DATE = "creationDate";
  @SerializedName(SERIALIZED_NAME_CREATION_DATE)
  private String creationDate;

  public static final String SERIALIZED_NAME_AUTHOR = "author";
  @SerializedName(SERIALIZED_NAME_AUTHOR)
  private String author;

  public static final String SERIALIZED_NAME_INDEX = "index";
  @SerializedName(SERIALIZED_NAME_INDEX)
  private String index;

  public static final String SERIALIZED_NAME_CONTENT_MIMETYPE = "contentMimetype";
  @SerializedName(SERIALIZED_NAME_CONTENT_MIMETYPE)
  private String contentMimetype;

  public static final String SERIALIZED_NAME_CASE_ID = "caseId";
  @SerializedName(SERIALIZED_NAME_CASE_ID)
  private String caseId;

  public static final String SERIALIZED_NAME_CONTENT_STORAGE_ID = "contentStorageId";
  @SerializedName(SERIALIZED_NAME_CONTENT_STORAGE_ID)
  private String contentStorageId;

  public static final String SERIALIZED_NAME_IS_INTERNAL = "isInternal";
  @SerializedName(SERIALIZED_NAME_IS_INTERNAL)
  private Boolean isInternal;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_FILE_NAME = "fileName";
  @SerializedName(SERIALIZED_NAME_FILE_NAME)
  private String fileName;

  public static final String SERIALIZED_NAME_SUBMITTED_BY = "submittedBy";
  @SerializedName(SERIALIZED_NAME_SUBMITTED_BY)
  private String submittedBy;

  public static final String SERIALIZED_NAME_URL = "url";
  @SerializedName(SERIALIZED_NAME_URL)
  private String url;

  public static final String SERIALIZED_NAME_VERSION = "version";
  @SerializedName(SERIALIZED_NAME_VERSION)
  private String version;

  public static final String SERIALIZED_NAME_SOURCE_OBJECT_ID = "sourceObjectId";
  @SerializedName(SERIALIZED_NAME_SOURCE_OBJECT_ID)
  private String sourceObjectId;

  public static final String SERIALIZED_NAME_ARCHIVED_DATE = "archivedDate";
  @SerializedName(SERIALIZED_NAME_ARCHIVED_DATE)
  private String archivedDate;


  public ArchivedCaseDocument id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * documentId
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "documentId")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public ArchivedCaseDocument creationDate(String creationDate) {
    
    this.creationDate = creationDate;
    return this;
  }

   /**
   * date and time
   * @return creationDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "date and time")

  public String getCreationDate() {
    return creationDate;
  }


  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }


  public ArchivedCaseDocument author(String author) {
    
    this.author = author;
    return this;
  }

   /**
   * submittorUserId
   * @return author
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "submittorUserId")

  public String getAuthor() {
    return author;
  }


  public void setAuthor(String author) {
    this.author = author;
  }


  public ArchivedCaseDocument index(String index) {
    
    this.index = index;
    return this;
  }

   /**
   * index in a list of documents, or -1 for a single document
   * @return index
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "index in a list of documents, or -1 for a single document")

  public String getIndex() {
    return index;
  }


  public void setIndex(String index) {
    this.index = index;
  }


  public ArchivedCaseDocument contentMimetype(String contentMimetype) {
    
    this.contentMimetype = contentMimetype;
    return this;
  }

   /**
   * MIME type
   * @return contentMimetype
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "MIME type")

  public String getContentMimetype() {
    return contentMimetype;
  }


  public void setContentMimetype(String contentMimetype) {
    this.contentMimetype = contentMimetype;
  }


  public ArchivedCaseDocument caseId(String caseId) {
    
    this.caseId = caseId;
    return this;
  }

   /**
   * caseId
   * @return caseId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "caseId")

  public String getCaseId() {
    return caseId;
  }


  public void setCaseId(String caseId) {
    this.caseId = caseId;
  }


  public ArchivedCaseDocument contentStorageId(String contentStorageId) {
    
    this.contentStorageId = contentStorageId;
    return this;
  }

   /**
   * storageId
   * @return contentStorageId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "storageId")

  public String getContentStorageId() {
    return contentStorageId;
  }


  public void setContentStorageId(String contentStorageId) {
    this.contentStorageId = contentStorageId;
  }


  public ArchivedCaseDocument isInternal(Boolean isInternal) {
    
    this.isInternal = isInternal;
    return this;
  }

   /**
   * &#x60;true&#x60; if  the the document object contains the content directly. &#x60;false&#x60; if the document is specified by URL so the document object contains a reference to the content, not the content itself.
   * @return isInternal
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "`true` if  the the document object contains the content directly. `false` if the document is specified by URL so the document object contains a reference to the content, not the content itself.")

  public Boolean getIsInternal() {
    return isInternal;
  }


  public void setIsInternal(Boolean isInternal) {
    this.isInternal = isInternal;
  }


  public ArchivedCaseDocument description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "description")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public ArchivedCaseDocument name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "name")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public ArchivedCaseDocument fileName(String fileName) {
    
    this.fileName = fileName;
    return this;
  }

   /**
   * filename
   * @return fileName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "filename")

  public String getFileName() {
    return fileName;
  }


  public void setFileName(String fileName) {
    this.fileName = fileName;
  }


  public ArchivedCaseDocument submittedBy(String submittedBy) {
    
    this.submittedBy = submittedBy;
    return this;
  }

   /**
   * submittorUserId
   * @return submittedBy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "submittorUserId")

  public String getSubmittedBy() {
    return submittedBy;
  }


  public void setSubmittedBy(String submittedBy) {
    this.submittedBy = submittedBy;
  }


  public ArchivedCaseDocument url(String url) {
    
    this.url = url;
    return this;
  }

   /**
   * urlForDownload
   * @return url
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "urlForDownload")

  public String getUrl() {
    return url;
  }


  public void setUrl(String url) {
    this.url = url;
  }


  public ArchivedCaseDocument version(String version) {
    
    this.version = version;
    return this;
  }

   /**
   * version
   * @return version
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "version")

  public String getVersion() {
    return version;
  }


  public void setVersion(String version) {
    this.version = version;
  }


  public ArchivedCaseDocument sourceObjectId(String sourceObjectId) {
    
    this.sourceObjectId = sourceObjectId;
    return this;
  }

   /**
   * original document id
   * @return sourceObjectId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "original document id")

  public String getSourceObjectId() {
    return sourceObjectId;
  }


  public void setSourceObjectId(String sourceObjectId) {
    this.sourceObjectId = sourceObjectId;
  }


  public ArchivedCaseDocument archivedDate(String archivedDate) {
    
    this.archivedDate = archivedDate;
    return this;
  }

   /**
   * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when the current task was assigned for example &#39;2014-10-17 16:05:42.626&#39;
   * @return archivedDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the date ('yyyy-MM-dd HH:mm:ss.SSS') when the current task was assigned for example '2014-10-17 16:05:42.626'")

  public String getArchivedDate() {
    return archivedDate;
  }


  public void setArchivedDate(String archivedDate) {
    this.archivedDate = archivedDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArchivedCaseDocument archivedCaseDocument = (ArchivedCaseDocument) o;
    return Objects.equals(this.id, archivedCaseDocument.id) &&
        Objects.equals(this.creationDate, archivedCaseDocument.creationDate) &&
        Objects.equals(this.author, archivedCaseDocument.author) &&
        Objects.equals(this.index, archivedCaseDocument.index) &&
        Objects.equals(this.contentMimetype, archivedCaseDocument.contentMimetype) &&
        Objects.equals(this.caseId, archivedCaseDocument.caseId) &&
        Objects.equals(this.contentStorageId, archivedCaseDocument.contentStorageId) &&
        Objects.equals(this.isInternal, archivedCaseDocument.isInternal) &&
        Objects.equals(this.description, archivedCaseDocument.description) &&
        Objects.equals(this.name, archivedCaseDocument.name) &&
        Objects.equals(this.fileName, archivedCaseDocument.fileName) &&
        Objects.equals(this.submittedBy, archivedCaseDocument.submittedBy) &&
        Objects.equals(this.url, archivedCaseDocument.url) &&
        Objects.equals(this.version, archivedCaseDocument.version) &&
        Objects.equals(this.sourceObjectId, archivedCaseDocument.sourceObjectId) &&
        Objects.equals(this.archivedDate, archivedCaseDocument.archivedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, creationDate, author, index, contentMimetype, caseId, contentStorageId, isInternal, description, name, fileName, submittedBy, url, version, sourceObjectId, archivedDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArchivedCaseDocument {\n");
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

