/*
 * Bonita API
 * <p>  <a download=\"openapi.yaml\" href=\"./openapi.yaml\" target=\"_blank\" class=\"btn-download\">Download OpenAPI specification</a> <a download=\"postman.json\" href=\"./postman.json\" target=\"_blank\" class=\"btn-download\">Download Postman collection</a> </p>  <hr>  The REST API lets you access the data with HTTP requests; it is useful when implementing rich web forms / pages for a good user experience.  An open source [java client](https://github.com/bonitasoft/bonita-java-client) is implemented above the HTTP API. It is available on [Maven central](https://search.maven.org/search?q=g:%22org.bonitasoft.web%22%20AND%20a:%22bonita-java-client%22).  If your application is using a technology other than Java, you can integrate it with the Bonita solution using the Web REST API. This API provides access to all Bonita objects (like processes, tasks, users, connectors etc.), to execute operations on them (create, retrieve, update, delete). You can use these operations to create a workflow with Bonita and integrate it into your application. The Bonita Engine remains responsible for executing the workflow logic (connectors, gateways with conditions, messages, timers etc.) while your application gives access to the workflow. Users can manage processes and tasks, and perform administrative activities.  ### API Extensions  You can create [Rest API Extensions](https://documentation.bonitasoft.com/bonita/latest/api/rest-api-extensions) to extend the Rest API by adding missing resources (not provided by the Rest API). It is possible for an extension to interact with the engine (via the API) or with any other external service (for example a database, a directory, or a web service).  ### Create a resource  | Request URL | `http://.../API/{API_name}/{resource_name}/  `| |:-|:-| | Request Method | POST| | Request Payload | an item in JSON| | Response | the same item in JSON, containing the values provided in the posted item, completed with default values and identifiers provided by Bonita Engine.|  ### Read a resource  | Request URL | `http://.../API/{API_name}/{resource_name}/{id} `| |:-|:-| | Request Method | GET| | Response | an item in JSON|  Example `http://.../API/identity/user/5 `  #### Extend resource response  On some resources, in GET methods the `d` (deploy) URL query parameter can be used to extend the response objects. The value of this parameter consists of an attribute for which you want to make an extended request (called a deploy) and retrieve attributes of a linked resource. This means that instead of retrieving the ID or a parent or referenced resource, you can retrieve the full object.  For example, when you retrieve a task, you can also retrieve the process definition attributes in addition to the process definition ID that is already part of the task resource. The supported deploy values for a task include its process (d=processId).  Specifiy multiple `d` parameter to extend several resources. For instance, to retrieve the flow node of id 143 and the associated process, process instance and assigned user, call `/API/bpm/flowNode/143?d=processId&d=caseId&d=assigned_id`  #### With compound identifier  The order of the identifier parts for each resource type is given in the table above.  | Request URL | `http://.../API/{API_name}/{resource_name}/{id_part1}/{id_part2} `| |:-|:-| | Request Method | GET| | Response | an item in JSON|  Example `http://.../API/identity/membership/5/12/24 `  ### Update a resource  | Request URL | `http://.../API/{API_name}/{resource_name}/{id} `| |:-|:-| | Request Method | PUT| | Request Payload | a map in JSON containing the new values for the attributes you want to change.| | Response | the corresponding item in JSON with new values where you requested a modification|  Example `http://.../API/identity/user/5`  #### With compound identifier:  Response: the corresponding item in JSON with new values where you requested a modification.  | Request URL | `http://.../API/{API_name}/{resource_name}/{id_part1}/{id_part2} `| |:-|:-| | Request Method | PUT| | Request Payload | ` a map in JSON containing the new values for the attributes you want to change `| | Response | ` the corresponding item in JSON with new values where you requested a modification`|  Example `http://.../API/identity/membership/5/12/24 `  ### Delete resources  Use the DELETE request to remove multiple resources.  | Request URL | `http://.../API/{API_name}/{resource_name}/ `| |:-|:-| | Request Method | DELETE| | Request Payload | A list of identifiers in JSON, for example `[\"id1\",\"id2\",\"id3\"]`. Compound identifiers are separated by '/' characters.| | Response | `empty `|  Example `http://.../API/identity/membership/ `  ### Search for a resource  The required object is specified with a set of filters in the request URL. The URL parameters must be URL-encoded.  Results are returned in a paged list, so you have to specify the page (counting from zero), and the number of results per page (count), additionally you can define a sort key (order). You can see the total number of matching results in the HTTP response header Content-Range. If you are searching for business data using a custom query, there must be a [count query in the BDM](https://documentation.bonitasoft.com/bonita/latest/data/define-and-deploy-the-bdm). If there is no count query, results from a custom query on business data cannot be paged properly (the header Content-Range will be absent). For business data default queries, the count query is defined automatically.  The available filters are the attributes of the item plus some specific filters defined by each item.  | Request URL | `http://.../API/{API_name}/{resource_name}?p={page}&c={count}&o={order}&s={query}&f={filter_name}={filter_value}&f=... `| |:-|:-| | Request Method | GET| | Response | an array of items in JSON|  Example `/API/identity/user?p=0&c=10&o=firstname&s=test&f=manager_id=3`  For a GET method that retrieves more than one instance of a resource, you can specify the following request parameters:  * p (Mandatory): index of the page to display * c (Mandatory): maximum number of elements to retrieve * o: order of presentation of values in response: must be either `attributeName ASC` or `attributeName DESC`. The final order parameter value must be URL encoded. * f: list of filters, specified as `attributeName=attributeValue`. To filter on more than one attribute, specify an f parameters for each attribute. The final filter parameter value must be URL encoded.   The attributes you can filter on are specific to the resource. * s: search on name or search indexes. The matching policy depends on the configuration of [word-based search](https://documentation.bonitasoft.com/bonita/2022.2/api/using-list-and-search-methods#word_based_search).   For example, if word-based search is enabled, `s=Valid` returns matches containing the string \"valid\" at the start of any word in the attribute value word,   such as \"Valid address\", \"Not a valid address\", and \"Validated request\" but not \"Invalid request\".   If word-based search is disabled, `s=Valid` returns matches containing the string \"valid\" at the start of the attribute value, such as \"Valid address\" or \"Validated request\" but not \"Not a valid address\" or \"Invalid request\".  ### Errors  The API uses standard HTTP status codes to indicate the success or failure of the API call.  If you get a `401` response code :   - make sure that the cookies have been transfered with the call   - make sure that the cookies transfered are the ones generated during the last sucessfull login call   - if one of the PUT, DELETE or POST method is used, make sure that the `X-Bonita-API-Token` header is included   - if the X-Bonita-API-Token header is included, make sure that the value is the same as the one of the cookie generated during the last login   - Maybe a logout was issued or the session has expired; try to log in again, and re run the request with the new cookies and the new value for the `X-Bonita-API-Token` header. 
 *
 * The version of the OpenAPI document: 0.0.13
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

/**
 * Use this resource to retrieve activities (human or service tasks), call activities, and subprocesses currently running on the platform. It enables you to perform maintenance tasks like skipping or replaying a failed task and modifying variables. 
 */
@JsonPropertyOrder({
  Activity.JSON_PROPERTY_ID,
  Activity.JSON_PROPERTY_TYPE,
  Activity.JSON_PROPERTY_NAME,
  Activity.JSON_PROPERTY_DISPLAY_NAME,
  Activity.JSON_PROPERTY_DESCRIPTION,
  Activity.JSON_PROPERTY_DISPLAY_DESCRIPTION,
  Activity.JSON_PROPERTY_STATE,
  Activity.JSON_PROPERTY_REACHED_STATE_DATE,
  Activity.JSON_PROPERTY_LAST_UPDATE_DATE,
  Activity.JSON_PROPERTY_DUE_DATE,
  Activity.JSON_PROPERTY_PRIORITY,
  Activity.JSON_PROPERTY_PROCESS_ID,
  Activity.JSON_PROPERTY_PARENT_CASE_ID,
  Activity.JSON_PROPERTY_ROOT_CASE_ID,
  Activity.JSON_PROPERTY_ROOT_CONTAINER_ID,
  Activity.JSON_PROPERTY_EXECUTED_BY,
  Activity.JSON_PROPERTY_EXECUTED_BY_SUBSTITUTE,
  Activity.JSON_PROPERTY_ACTOR_ID,
  Activity.JSON_PROPERTY_ASSIGNED_ID,
  Activity.JSON_PROPERTY_ASSIGNED_DATE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Activity implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_TYPE = "type";
  private ActivityType type;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  private String displayName;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_DISPLAY_DESCRIPTION = "displayDescription";
  private String displayDescription;

  public static final String JSON_PROPERTY_STATE = "state";
  private ActivityState state;

  public static final String JSON_PROPERTY_REACHED_STATE_DATE = "reached_state_date";
  private String reachedStateDate;

  public static final String JSON_PROPERTY_LAST_UPDATE_DATE = "last_update_date";
  private String lastUpdateDate;

  public static final String JSON_PROPERTY_DUE_DATE = "dueDate";
  private String dueDate;

  public static final String JSON_PROPERTY_PRIORITY = "priority";
  private ActivityPriority priority;

  public static final String JSON_PROPERTY_PROCESS_ID = "processId";
  private String processId;

  public static final String JSON_PROPERTY_PARENT_CASE_ID = "parentCaseId";
  private String parentCaseId;

  public static final String JSON_PROPERTY_ROOT_CASE_ID = "rootCaseId";
  private String rootCaseId;

  public static final String JSON_PROPERTY_ROOT_CONTAINER_ID = "rootContainerId";
  private String rootContainerId;

  public static final String JSON_PROPERTY_EXECUTED_BY = "executedBy";
  private String executedBy;

  public static final String JSON_PROPERTY_EXECUTED_BY_SUBSTITUTE = "executedBySubstitute";
  private String executedBySubstitute;

  public static final String JSON_PROPERTY_ACTOR_ID = "actorId";
  private String actorId;

  public static final String JSON_PROPERTY_ASSIGNED_ID = "assigned_id";
  private String assignedId;

  public static final String JSON_PROPERTY_ASSIGNED_DATE = "assigned_date";
  private String assignedDate;

  public Activity() {
  }

  public Activity id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * the activity id
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


  public Activity type(ActivityType type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ActivityType getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(ActivityType type) {
    this.type = type;
  }


  public Activity name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * the activity technical name
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


  public Activity displayName(String displayName) {
    
    this.displayName = displayName;
    return this;
  }

   /**
   * the human readable activity name
   * @return displayName
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDisplayName() {
    return displayName;
  }


  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  public Activity description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * the activity description
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


  public Activity displayDescription(String displayDescription) {
    
    this.displayDescription = displayDescription;
    return this;
  }

   /**
   * the human readable activity description
   * @return displayDescription
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DISPLAY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDisplayDescription() {
    return displayDescription;
  }


  @JsonProperty(JSON_PROPERTY_DISPLAY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisplayDescription(String displayDescription) {
    this.displayDescription = displayDescription;
  }


  public Activity state(ActivityState state) {
    
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ActivityState getState() {
    return state;
  }


  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setState(ActivityState state) {
    this.state = state;
  }


  public Activity reachedStateDate(String reachedStateDate) {
    
    this.reachedStateDate = reachedStateDate;
    return this;
  }

   /**
   * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this activity reached the current state, for example &#39;2014-10-17 16:05:42.626&#39;
   * @return reachedStateDate
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_REACHED_STATE_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getReachedStateDate() {
    return reachedStateDate;
  }


  @JsonProperty(JSON_PROPERTY_REACHED_STATE_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReachedStateDate(String reachedStateDate) {
    this.reachedStateDate = reachedStateDate;
  }


  public Activity lastUpdateDate(String lastUpdateDate) {
    
    this.lastUpdateDate = lastUpdateDate;
    return this;
  }

   /**
   * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this activity was last updated, for example &#39;2014-10-17 16:05:42.626)
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


  public Activity dueDate(String dueDate) {
    
    this.dueDate = dueDate;
    return this;
  }

   /**
   * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this activity is due, for example &#39;2014-10-17 16:05:42.626&#39;
   * @return dueDate
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DUE_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDueDate() {
    return dueDate;
  }


  @JsonProperty(JSON_PROPERTY_DUE_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }


  public Activity priority(ActivityPriority priority) {
    
    this.priority = priority;
    return this;
  }

   /**
   * Get priority
   * @return priority
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PRIORITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ActivityPriority getPriority() {
    return priority;
  }


  @JsonProperty(JSON_PROPERTY_PRIORITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPriority(ActivityPriority priority) {
    this.priority = priority;
  }


  public Activity processId(String processId) {
    
    this.processId = processId;
    return this;
  }

   /**
   * the process definition id of the process instance which define this activity
   * @return processId
  **/
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


  public Activity parentCaseId(String parentCaseId) {
    
    this.parentCaseId = parentCaseId;
    return this;
  }

   /**
   * the immediate containing process instance id (long, a.k.a process instance id)
   * @return parentCaseId
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PARENT_CASE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getParentCaseId() {
    return parentCaseId;
  }


  @JsonProperty(JSON_PROPERTY_PARENT_CASE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setParentCaseId(String parentCaseId) {
    this.parentCaseId = parentCaseId;
  }


  public Activity rootCaseId(String rootCaseId) {
    
    this.rootCaseId = rootCaseId;
    return this;
  }

   /**
   * the top/root process instance id (long, a.k.a case id). In case of an event sub process, &#x60;parentCaseId&#x60; will the id of the process instance called while &#x60;rootCaseId&#x60; will be the one from the caller process instance
   * @return rootCaseId
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ROOT_CASE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRootCaseId() {
    return rootCaseId;
  }


  @JsonProperty(JSON_PROPERTY_ROOT_CASE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRootCaseId(String rootCaseId) {
    this.rootCaseId = rootCaseId;
  }


  public Activity rootContainerId(String rootContainerId) {
    
    this.rootContainerId = rootContainerId;
    return this;
  }

   /**
   * same as rootCaseId
   * @return rootContainerId
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ROOT_CONTAINER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRootContainerId() {
    return rootContainerId;
  }


  @JsonProperty(JSON_PROPERTY_ROOT_CONTAINER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRootContainerId(String rootContainerId) {
    this.rootContainerId = rootContainerId;
  }


  public Activity executedBy(String executedBy) {
    
    this.executedBy = executedBy;
    return this;
  }

   /**
   * the id of the user who performed this activity. The activity has to be a human task otherwise its value will be 0
   * @return executedBy
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EXECUTED_BY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getExecutedBy() {
    return executedBy;
  }


  @JsonProperty(JSON_PROPERTY_EXECUTED_BY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExecutedBy(String executedBy) {
    this.executedBy = executedBy;
  }


  public Activity executedBySubstitute(String executedBySubstitute) {
    
    this.executedBySubstitute = executedBySubstitute;
    return this;
  }

   /**
   * the id of the user who did actually performed the activity when it has been done in the name of someone else. Value is 0 otherwise
   * @return executedBySubstitute
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EXECUTED_BY_SUBSTITUTE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getExecutedBySubstitute() {
    return executedBySubstitute;
  }


  @JsonProperty(JSON_PROPERTY_EXECUTED_BY_SUBSTITUTE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExecutedBySubstitute(String executedBySubstitute) {
    this.executedBySubstitute = executedBySubstitute;
  }


  public Activity actorId(String actorId) {
    
    this.actorId = actorId;
    return this;
  }

   /**
   * the id of the actor that can execute this activity, null otherwise
   * @return actorId
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ACTOR_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getActorId() {
    return actorId;
  }


  @JsonProperty(JSON_PROPERTY_ACTOR_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setActorId(String actorId) {
    this.actorId = actorId;
  }


  public Activity assignedId(String assignedId) {
    
    this.assignedId = assignedId;
    return this;
  }

   /**
   * the user id that this activity is assigned to, or 0 if it is unassigned
   * @return assignedId
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ASSIGNED_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAssignedId() {
    return assignedId;
  }


  @JsonProperty(JSON_PROPERTY_ASSIGNED_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAssignedId(String assignedId) {
    this.assignedId = assignedId;
  }


  public Activity assignedDate(String assignedDate) {
    
    this.assignedDate = assignedDate;
    return this;
  }

   /**
   * the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when the current activity was assigned, for example &#39;2014-10-17 16:05:42.626&#39;
   * @return assignedDate
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ASSIGNED_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAssignedDate() {
    return assignedDate;
  }


  @JsonProperty(JSON_PROPERTY_ASSIGNED_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAssignedDate(String assignedDate) {
    this.assignedDate = assignedDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Activity activity = (Activity) o;
    return Objects.equals(this.id, activity.id) &&
        Objects.equals(this.type, activity.type) &&
        Objects.equals(this.name, activity.name) &&
        Objects.equals(this.displayName, activity.displayName) &&
        Objects.equals(this.description, activity.description) &&
        Objects.equals(this.displayDescription, activity.displayDescription) &&
        Objects.equals(this.state, activity.state) &&
        Objects.equals(this.reachedStateDate, activity.reachedStateDate) &&
        Objects.equals(this.lastUpdateDate, activity.lastUpdateDate) &&
        Objects.equals(this.dueDate, activity.dueDate) &&
        Objects.equals(this.priority, activity.priority) &&
        Objects.equals(this.processId, activity.processId) &&
        Objects.equals(this.parentCaseId, activity.parentCaseId) &&
        Objects.equals(this.rootCaseId, activity.rootCaseId) &&
        Objects.equals(this.rootContainerId, activity.rootContainerId) &&
        Objects.equals(this.executedBy, activity.executedBy) &&
        Objects.equals(this.executedBySubstitute, activity.executedBySubstitute) &&
        Objects.equals(this.actorId, activity.actorId) &&
        Objects.equals(this.assignedId, activity.assignedId) &&
        Objects.equals(this.assignedDate, activity.assignedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, name, displayName, description, displayDescription, state, reachedStateDate, lastUpdateDate, dueDate, priority, processId, parentCaseId, rootCaseId, rootContainerId, executedBy, executedBySubstitute, actorId, assignedId, assignedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Activity {\n");
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

