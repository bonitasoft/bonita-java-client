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

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * Use this resource to retrieve finished activities (human or service tasks), call activities, and subprocesses.
 */
@ApiModel(description = "Use this resource to retrieve finished activities (human or service tasks), call activities, and subprocesses.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-09-30T11:56:08.520781+02:00[Europe/Paris]")
public class ArchivedActivity implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private ActivityTypeEnum type;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_DISPLAY_NAME = "displayName";
  @SerializedName(SERIALIZED_NAME_DISPLAY_NAME)
  private String displayName;

  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_DISPLAY_DESCRIPTION = "displayDescription";
  @SerializedName(SERIALIZED_NAME_DISPLAY_DESCRIPTION)
  private String displayDescription;

  public static final String SERIALIZED_NAME_STATE = "state";
  @SerializedName(SERIALIZED_NAME_STATE)
  private ActivityStateEnum state;

  public static final String SERIALIZED_NAME_REACHED_STATE_DATE = "reached_state_date";
  @SerializedName(SERIALIZED_NAME_REACHED_STATE_DATE)
  private String reachedStateDate;

  public static final String SERIALIZED_NAME_LAST_UPDATE_DATE = "last_update_date";
  @SerializedName(SERIALIZED_NAME_LAST_UPDATE_DATE)
  private String lastUpdateDate;

  public static final String SERIALIZED_NAME_DUE_DATE = "dueDate";
  @SerializedName(SERIALIZED_NAME_DUE_DATE)
  private String dueDate;

  public static final String SERIALIZED_NAME_PRIORITY = "priority";
  @SerializedName(SERIALIZED_NAME_PRIORITY)
  private ActivityPriorityEnum priority;

  public static final String SERIALIZED_NAME_PROCESS_ID = "processId";
  @SerializedName(SERIALIZED_NAME_PROCESS_ID)
  private String processId;

  public static final String SERIALIZED_NAME_PARENT_CASE_ID = "parentCaseId";
  @SerializedName(SERIALIZED_NAME_PARENT_CASE_ID)
  private String parentCaseId;

  public static final String SERIALIZED_NAME_ROOT_CASE_ID = "rootCaseId";
  @SerializedName(SERIALIZED_NAME_ROOT_CASE_ID)
  private String rootCaseId;

  public static final String SERIALIZED_NAME_ROOT_CONTAINER_ID = "rootContainerId";
  @SerializedName(SERIALIZED_NAME_ROOT_CONTAINER_ID)
  private String rootContainerId;

  public static final String SERIALIZED_NAME_EXECUTED_BY = "executedBy";
  @SerializedName(SERIALIZED_NAME_EXECUTED_BY)
  private String executedBy;

  public static final String SERIALIZED_NAME_EXECUTED_BY_SUBSTITUTE = "executedBySubstitute";
  @SerializedName(SERIALIZED_NAME_EXECUTED_BY_SUBSTITUTE)
  private String executedBySubstitute;

  public static final String SERIALIZED_NAME_ACTOR_ID = "actorId";
  @SerializedName(SERIALIZED_NAME_ACTOR_ID)
  private String actorId;

  public static final String SERIALIZED_NAME_ASSIGNED_ID = "assigned_id";
  @SerializedName(SERIALIZED_NAME_ASSIGNED_ID)
  private String assignedId;

  public static final String SERIALIZED_NAME_ASSIGNED_DATE = "assigned_date";
  @SerializedName(SERIALIZED_NAME_ASSIGNED_DATE)
  private String assignedDate;

  public static final String SERIALIZED_NAME_SOURCE_OBJECT_ID = "sourceObjectId";
  @SerializedName(SERIALIZED_NAME_SOURCE_OBJECT_ID)
  private String sourceObjectId;

  public static final String SERIALIZED_NAME_ARCHIVED_DATE = "archivedDate";
  @SerializedName(SERIALIZED_NAME_ARCHIVED_DATE)
  private String archivedDate;


  public ArchivedActivity id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * the archived activity id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the archived activity id")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public ArchivedActivity type(ActivityTypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ActivityTypeEnum getType() {
    return type;
  }


  public void setType(ActivityTypeEnum type) {
    this.type = type;
  }


  public ArchivedActivity name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * the archived activity technical name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the archived activity technical name")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public ArchivedActivity displayName(String displayName) {
    
    this.displayName = displayName;
    return this;
  }

   /**
   * the human readable archived activity name
   * @return displayName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the human readable archived activity name")

  public String getDisplayName() {
    return displayName;
  }


  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  public ArchivedActivity description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * the archived activity description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the archived activity description")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public ArchivedActivity displayDescription(String displayDescription) {
    
    this.displayDescription = displayDescription;
    return this;
  }

   /**
   * the human readable archived activity description
   * @return displayDescription
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the human readable archived activity description")

  public String getDisplayDescription() {
    return displayDescription;
  }


  public void setDisplayDescription(String displayDescription) {
    this.displayDescription = displayDescription;
  }


  public ArchivedActivity state(ActivityStateEnum state) {
    
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ActivityStateEnum getState() {
    return state;
  }


  public void setState(ActivityStateEnum state) {
    this.state = state;
  }


  public ArchivedActivity reachedStateDate(String reachedStateDate) {
    
    this.reachedStateDate = reachedStateDate;
    return this;
  }

   /**
   * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this archived activity reached the current state, for example &#39;2014-10-17 16:05:42.626&#39;
   * @return reachedStateDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the date ('yyyy-MM-dd HH:mm:ss.SSS') when this archived activity reached the current state, for example '2014-10-17 16:05:42.626'")

  public String getReachedStateDate() {
    return reachedStateDate;
  }


  public void setReachedStateDate(String reachedStateDate) {
    this.reachedStateDate = reachedStateDate;
  }


  public ArchivedActivity lastUpdateDate(String lastUpdateDate) {
    
    this.lastUpdateDate = lastUpdateDate;
    return this;
  }

   /**
   * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this archived activity was last updated, for example &#39;2014-10-17 16:05:42.626)
   * @return lastUpdateDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the date ('yyyy-MM-dd HH:mm:ss.SSS') when this archived activity was last updated, for example '2014-10-17 16:05:42.626)")

  public String getLastUpdateDate() {
    return lastUpdateDate;
  }


  public void setLastUpdateDate(String lastUpdateDate) {
    this.lastUpdateDate = lastUpdateDate;
  }


  public ArchivedActivity dueDate(String dueDate) {
    
    this.dueDate = dueDate;
    return this;
  }

   /**
   * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this archived activity is due, for example &#39;2014-10-17 16:05:42.626&#39;
   * @return dueDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the date ('yyyy-MM-dd HH:mm:ss.SSS') when this archived activity is due, for example '2014-10-17 16:05:42.626'")

  public String getDueDate() {
    return dueDate;
  }


  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }


  public ArchivedActivity priority(ActivityPriorityEnum priority) {
    
    this.priority = priority;
    return this;
  }

   /**
   * Get priority
   * @return priority
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ActivityPriorityEnum getPriority() {
    return priority;
  }


  public void setPriority(ActivityPriorityEnum priority) {
    this.priority = priority;
  }


  public ArchivedActivity processId(String processId) {
    
    this.processId = processId;
    return this;
  }

   /**
   * the process definition id of the case which define this archived activity
   * @return processId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the process definition id of the case which define this archived activity")

  public String getProcessId() {
    return processId;
  }


  public void setProcessId(String processId) {
    this.processId = processId;
  }


  public ArchivedActivity parentCaseId(String parentCaseId) {
    
    this.parentCaseId = parentCaseId;
    return this;
  }

   /**
   * the immediate containing case id (a.k.a process instance id)
   * @return parentCaseId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the immediate containing case id (a.k.a process instance id)")

  public String getParentCaseId() {
    return parentCaseId;
  }


  public void setParentCaseId(String parentCaseId) {
    this.parentCaseId = parentCaseId;
  }


  public ArchivedActivity rootCaseId(String rootCaseId) {
    
    this.rootCaseId = rootCaseId;
    return this;
  }

   /**
   * the top/root case id (a.k.a process instance id). In the case of an event sub process, &#x60;parentCaseId&#x60; will the id of the case called while &#x60;rootCaseId&#x60; will be the one from the caller case
   * @return rootCaseId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the top/root case id (a.k.a process instance id). In the case of an event sub process, `parentCaseId` will the id of the case called while `rootCaseId` will be the one from the caller case")

  public String getRootCaseId() {
    return rootCaseId;
  }


  public void setRootCaseId(String rootCaseId) {
    this.rootCaseId = rootCaseId;
  }


  public ArchivedActivity rootContainerId(String rootContainerId) {
    
    this.rootContainerId = rootContainerId;
    return this;
  }

   /**
   * same as &#x60;rootCaseId&#x60;
   * @return rootContainerId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "same as `rootCaseId`")

  public String getRootContainerId() {
    return rootContainerId;
  }


  public void setRootContainerId(String rootContainerId) {
    this.rootContainerId = rootContainerId;
  }


  public ArchivedActivity executedBy(String executedBy) {
    
    this.executedBy = executedBy;
    return this;
  }

   /**
   * the id of the user who performed this archived activity. The archived activity has to be a human task otherwise its value will be 0
   * @return executedBy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the id of the user who performed this archived activity. The archived activity has to be a human task otherwise its value will be 0")

  public String getExecutedBy() {
    return executedBy;
  }


  public void setExecutedBy(String executedBy) {
    this.executedBy = executedBy;
  }


  public ArchivedActivity executedBySubstitute(String executedBySubstitute) {
    
    this.executedBySubstitute = executedBySubstitute;
    return this;
  }

   /**
   * the id of the user who did actually performed the archived activity in the case of has been done in the name of someone else. Value is 0 otherwise
   * @return executedBySubstitute
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the id of the user who did actually performed the archived activity in the case of has been done in the name of someone else. Value is 0 otherwise")

  public String getExecutedBySubstitute() {
    return executedBySubstitute;
  }


  public void setExecutedBySubstitute(String executedBySubstitute) {
    this.executedBySubstitute = executedBySubstitute;
  }


  public ArchivedActivity actorId(String actorId) {
    
    this.actorId = actorId;
    return this;
  }

   /**
   * the id of the actor that can execute this archived activity, null otherwise
   * @return actorId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the id of the actor that can execute this archived activity, null otherwise")

  public String getActorId() {
    return actorId;
  }


  public void setActorId(String actorId) {
    this.actorId = actorId;
  }


  public ArchivedActivity assignedId(String assignedId) {
    
    this.assignedId = assignedId;
    return this;
  }

   /**
   * the user id that this archived activity is assigned to, or 0 if it is unassigned
   * @return assignedId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the user id that this archived activity is assigned to, or 0 if it is unassigned")

  public String getAssignedId() {
    return assignedId;
  }


  public void setAssignedId(String assignedId) {
    this.assignedId = assignedId;
  }


  public ArchivedActivity assignedDate(String assignedDate) {
    
    this.assignedDate = assignedDate;
    return this;
  }

   /**
   * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when the current archived activity was assigned, for example &#39;2014-10-17 16:05:42.626&#39;
   * @return assignedDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the date ('yyyy-MM-dd HH:mm:ss.SSS') when the current archived activity was assigned, for example '2014-10-17 16:05:42.626'")

  public String getAssignedDate() {
    return assignedDate;
  }


  public void setAssignedDate(String assignedDate) {
    this.assignedDate = assignedDate;
  }


  public ArchivedActivity sourceObjectId(String sourceObjectId) {
    
    this.sourceObjectId = sourceObjectId;
    return this;
  }

   /**
   * the original id of the archived activity before it was archived
   * @return sourceObjectId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the original id of the archived activity before it was archived")

  public String getSourceObjectId() {
    return sourceObjectId;
  }


  public void setSourceObjectId(String sourceObjectId) {
    this.sourceObjectId = sourceObjectId;
  }


  public ArchivedActivity archivedDate(String archivedDate) {
    
    this.archivedDate = archivedDate;
    return this;
  }

   /**
   * the date ((&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;)) when this archived activity was archived, for example &#39;2014-10-17 16:05:42.626&#39;
   * @return archivedDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the date (('yyyy-MM-dd HH:mm:ss.SSS')) when this archived activity was archived, for example '2014-10-17 16:05:42.626'")

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
    ArchivedActivity archivedActivity = (ArchivedActivity) o;
    return Objects.equals(this.id, archivedActivity.id) &&
        Objects.equals(this.type, archivedActivity.type) &&
        Objects.equals(this.name, archivedActivity.name) &&
        Objects.equals(this.displayName, archivedActivity.displayName) &&
        Objects.equals(this.description, archivedActivity.description) &&
        Objects.equals(this.displayDescription, archivedActivity.displayDescription) &&
        Objects.equals(this.state, archivedActivity.state) &&
        Objects.equals(this.reachedStateDate, archivedActivity.reachedStateDate) &&
        Objects.equals(this.lastUpdateDate, archivedActivity.lastUpdateDate) &&
        Objects.equals(this.dueDate, archivedActivity.dueDate) &&
        Objects.equals(this.priority, archivedActivity.priority) &&
        Objects.equals(this.processId, archivedActivity.processId) &&
        Objects.equals(this.parentCaseId, archivedActivity.parentCaseId) &&
        Objects.equals(this.rootCaseId, archivedActivity.rootCaseId) &&
        Objects.equals(this.rootContainerId, archivedActivity.rootContainerId) &&
        Objects.equals(this.executedBy, archivedActivity.executedBy) &&
        Objects.equals(this.executedBySubstitute, archivedActivity.executedBySubstitute) &&
        Objects.equals(this.actorId, archivedActivity.actorId) &&
        Objects.equals(this.assignedId, archivedActivity.assignedId) &&
        Objects.equals(this.assignedDate, archivedActivity.assignedDate) &&
        Objects.equals(this.sourceObjectId, archivedActivity.sourceObjectId) &&
        Objects.equals(this.archivedDate, archivedActivity.archivedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, name, displayName, description, displayDescription, state, reachedStateDate, lastUpdateDate, dueDate, priority, processId, parentCaseId, rootCaseId, rootContainerId, executedBy, executedBySubstitute, actorId, assignedId, assignedDate, sourceObjectId, archivedDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArchivedActivity {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    displayDescription: ").append(toIndentedString(displayDescription)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    reachedStateDate: ").append(toIndentedString(reachedStateDate)).append("\n");
    sb.append("    lastUpdateDate: ").append(toIndentedString(lastUpdateDate)).append("\n");
    sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    processId: ").append(toIndentedString(processId)).append("\n");
    sb.append("    parentCaseId: ").append(toIndentedString(parentCaseId)).append("\n");
    sb.append("    rootCaseId: ").append(toIndentedString(rootCaseId)).append("\n");
    sb.append("    rootContainerId: ").append(toIndentedString(rootContainerId)).append("\n");
    sb.append("    executedBy: ").append(toIndentedString(executedBy)).append("\n");
    sb.append("    executedBySubstitute: ").append(toIndentedString(executedBySubstitute)).append("\n");
    sb.append("    actorId: ").append(toIndentedString(actorId)).append("\n");
    sb.append("    assignedId: ").append(toIndentedString(assignedId)).append("\n");
    sb.append("    assignedDate: ").append(toIndentedString(assignedDate)).append("\n");
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

