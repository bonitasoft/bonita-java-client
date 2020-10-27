/*
 * Bonita 7.11 HTTP API
 *  The REST API lets you access the data with HTTP requests; it is useful when implementing rich web forms / pages for a good user experience.  If your application is using a technology other than Java, you can integrate it with the Bonita solution using the Web REST API. This API provides access to all Bonita objects (like processes, tasks, users, connectors etc.), to execute operations on them (create, retrieve, update, delete). You can use these operations to create a workflow with Bonita and integrate it into your application. The Bonita Engine remains responsible for executing the workflow logic (connectors, gateways with conditions, messages, timers etc.) while your application gives access to the workflow. Users can manage processes and tasks, and perform administrative activities.  ![diagram of architecture of a REST client integrated with Bonita](images/rest_overview_v2.png)  ### API Extensions  You can create [Rest API Extensions](rest-api-extensions.md) to extend the Rest API by adding missing ressources (not provided by the Rest API). It is possible for an extension to interact with the engine (via the API) or with any other external service (for example a database, a directory, or a web service).  ### Create a resource  | Request URL | `http://.../API/{API_name}/{resource_name}/  `| |:-|:-| | Request Method | POST| | Request Payload | an item in JSON| | Response | the same item in JSON, containing the values provided in the posted item, completed with default values and identifiers provided by Bonita Engine.|  ### Read a resource  | Request URL | `http://.../API/{API_name}/{resource_name}/{id} `| |:-|:-| | Request Method | GET| | Response | an item in JSON|  Example `http://.../API/identity/user/5 `  #### Extend resource response  On some resources, in GET methods the `d` (deploy) URL query parameter can be used to extend the response objects. The value of this parameter consists of an attribute for which you want to make an extended request (called a deploy) and retrieve attributes of a linked resource. This means that instead of retrieving the ID or a parent or referenced resource, you can retrieve the full object.  For example, when you retrieve a task, you can also retrieve the process definition attributes in addition to the process definition ID that is already part of the task resource. The supported deploy values for a task include its process (d=processId).  Specifiy multiple `d` parameter to extend several resources. For instance, to retrieve the flow node of id 143 and the associated process, case and assigned user, call `/API/bpm/flowNode/143?d=processId&d=caseId&d=assigned_id`  #### With compound identifier  The order of the identifier parts for each resource type is given in the table above.  | Request URL | `http://.../API/{API_name}/{resource_name}/{id_part1}/{id_part2} `| |:-|:-| | Request Method | GET| | Response | an item in JSON|  Example `http://.../API/identity/membership/5/12/24 `  ### Update a resource  | Request URL | `http://.../API/{API_name}/{resource_name}/{id} `| |:-|:-| | Request Method | PUT| | Request Payload | a map in JSON containing the new values for the attributes you want to change.| | Response | the corresponding item in JSON with new values where you requested a modification|  Example `http://.../API/identity/user/5`  #### With compound identifier:  Response: the corresponding item in JSON with new values where you requested a modification.  | Request URL | `http://.../API/{API_name}/{resource_name}/{id_part1}/{id_part2} `| |:-|:-| | Request Method | PUT| | Request Payload | ` a map in JSON containing the new values for the attributes you want to change `| | Response | ` the corresponding item in JSON with new values where you requested a modification`|  Example `http://.../API/identity/membership/5/12/24 `  ### Delete resources  Use the DELETE request to remove multiple resources.  | Request URL | `http://.../API/{API_name}/{resource_name}/ `| |:-|:-| | Request Method | DELETE| | Request Payload | A list of identifiers in JSON, for example `[\"id1\",\"id2\",\"id3\"]`. Compound identifiers are separated by '/' characters.| | Response | `empty `|  Example `http://.../API/identity/membership/ `  ### Search for a resource  The required object is specified with a set of filters in the request URL. The URL parameters must be URL-encoded.  Results are returned in a paged list, so you have to specify the page (counting from zero), and the number of results per page (count), additionally you can define a sort key (order). You can see the total number of matching results in the HTTP response header Content-Range. If you are searching for business data using a custom query, there must be a [count query in the BDM](define-and-deploy-the-bdm.md). If there is no count query, results from a custom query on business data cannot be paged properly (the header Content-Range will be absent). For business data default queries, the count query is defined automatically.  The available filters are the attributes of the item plus some specific filters defined by each item.  | Request URL | `http://.../API/{API_name}/{resource_name}?p={page}&c={count}&o={order}&s={query}&f={filter_name}={filter_value}&f=... `| |:-|:-| | Request Method | GET| | Response | an array of items in JSON|  Example `/API/identity/user?p=0&c=10&o=firstname&s=test&f=manager_id=3`  For a GET method that retrieves more than one instance of a resource, you can specify the following request parameters:  * p (Mandatory): index of the page to display * c (Mandatory): maximum number of elements to retrieve * o: order of presentation of values in response: must be either `attributeName ASC` or `attributeName DESC`. The final order parameter value must be URL encoded. * f: list of filters, specified as `attributeName=attributeValue`. To filter on more than one attribute, specify an f parameters for each attribute. The final filter parameter value must be URL encoded.   The attributes you can filter on are specific to the resource. * s: search on name or search indexes. The matching policy depends on the configuration of [word-based search](using-list-and-search-methods.md).   For example, if word-based search is enabled, `s=Valid` returns matches containing the string \"valid\" at the start of any word in the attribute value word,   such as \"Valid address\", \"Not a valid address\", and \"Validated request\" but not \"Invalid request\".   If word-based search is disabled, `s=Valid` returns matches containing the string \"valid\" at the start of the attribute value, such as \"Valid address\" or \"Validated request\" but not \"Not a valid address\" or \"Invalid request\".  ### Errors  The API uses standard HTTP status codes to indicate the success or failure of the API call.  If you get a `401` response code :   - make sure that the cookies have been transfered with the call   - make sure that the cookies transfered are the ones generated during the last sucessfull login call   - if one of the PUT, DELETE or POST method is used, make sure that the `X-Bonita-API-Token` header is included   - if the X-Bonita-API-Token header is included, make sure that the value is the same as the one of the cookie generated during the last login   - Maybe a logout was issued or the session has expired; try to log in again, and re run the request with the new cookies and the new value for the `X-Bonita-API-Token` header.
 *
 * The version of the OpenAPI document: 0.0.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.bonitasoft.web.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The process supervisor has management rights over a process. He can configure and monitor it. You can give the ProcessSupervisor rights to some users by specifying a role and or a group, or a specific user. In order to be able to manage the processes he supervises in the portal, a user should also have the profile &#x60;Process Manager&#x60;
 */
@ApiModel(description = "The process supervisor has management rights over a process. He can configure and monitor it. You can give the ProcessSupervisor rights to some users by specifying a role and or a group, or a specific user. In order to be able to manage the processes he supervises in the portal, a user should also have the profile `Process Manager`")
@JsonPropertyOrder({
  ProcessSupervisor.JSON_PROPERTY_PROCESS_ID,
  ProcessSupervisor.JSON_PROPERTY_ROLE_ID,
  ProcessSupervisor.JSON_PROPERTY_GROUP_ID,
  ProcessSupervisor.JSON_PROPERTY_USER_ID
})

public class ProcessSupervisor implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PROCESS_ID = "process_id";
  private String processId;

  public static final String JSON_PROPERTY_ROLE_ID = "role_id";
  private String roleId;

  public static final String JSON_PROPERTY_GROUP_ID = "group_id";
  private String groupId;

  public static final String JSON_PROPERTY_USER_ID = "user_id";
  private String userId;


  public ProcessSupervisor processId(String processId) {
    
    this.processId = processId;
    return this;
  }

   /**
   * Id of the process
   * @return processId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Id of the process")
  @JsonProperty(JSON_PROPERTY_PROCESS_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getProcessId() {
    return processId;
  }


  public void setProcessId(String processId) {
    this.processId = processId;
  }


  public ProcessSupervisor roleId(String roleId) {
    
    this.roleId = roleId;
    return this;
  }

   /**
   * Id of role, or -1 if the supervisor type is not role or membership
   * @return roleId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Id of role, or -1 if the supervisor type is not role or membership")
  @JsonProperty(JSON_PROPERTY_ROLE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRoleId() {
    return roleId;
  }


  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }


  public ProcessSupervisor groupId(String groupId) {
    
    this.groupId = groupId;
    return this;
  }

   /**
   * Id of group, or -1 if the supervisor type is not group or membership
   * @return groupId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Id of group, or -1 if the supervisor type is not group or membership")
  @JsonProperty(JSON_PROPERTY_GROUP_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getGroupId() {
    return groupId;
  }


  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }


  public ProcessSupervisor userId(String userId) {
    
    this.userId = userId;
    return this;
  }

   /**
   * Id of user, or -1 if the supervisor type is not user
   * @return userId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Id of user, or -1 if the supervisor type is not user")
  @JsonProperty(JSON_PROPERTY_USER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getUserId() {
    return userId;
  }


  public void setUserId(String userId) {
    this.userId = userId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProcessSupervisor processSupervisor = (ProcessSupervisor) o;
    return Objects.equals(this.processId, processSupervisor.processId) &&
        Objects.equals(this.roleId, processSupervisor.roleId) &&
        Objects.equals(this.groupId, processSupervisor.groupId) &&
        Objects.equals(this.userId, processSupervisor.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(processId, roleId, groupId, userId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcessSupervisor {\n");
    sb.append("    processId: ").append(toIndentedString(processId)).append("\n");
    sb.append("    roleId: ").append(toIndentedString(roleId)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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
