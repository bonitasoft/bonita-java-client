/*
 * Bonita 7.11 HTTP API
 *  The REST API lets you access the data with HTTP requests; it is useful when implementing rich web forms / pages for a good user experience.  If your application is using a technology other than Java, you can integrate it with the Bonita solution using the Web REST API. This API provides access to all Bonita objects (like processes, tasks, users, connectors etc.), to execute operations on them (create, retrieve, update, delete). You can use these operations to create a workflow with Bonita and integrate it into your application. The Bonita Engine remains responsible for executing the workflow logic (connectors, gateways with conditions, messages, timers etc.) while your application gives access to the workflow. Users can manage processes and tasks, and perform administrative activities.  ![diagram of architecture of a REST client integrated with Bonita](images/rest_overview_v2.png)  ### API Extensions  You can create [Rest API Extensions](rest-api-extensions.md) to extend the Rest API by adding missing ressources (not provided by the Rest API). It is possible for an extension to interact with the engine (via the API) or with any other external service (for example a database, a directory, or a web service).  ### Create a resource  | Request URL | `http://.../API/{API_name}/{resource_name}/  `| |:-|:-| | Request Method | POST| | Request Payload | an item in JSON| | Response | the same item in JSON, containing the values provided in the posted item, completed with default values and identifiers provided by Bonita Engine.|  ### Read a resource  | Request URL | `http://.../API/{API_name}/{resource_name}/{id} `| |:-|:-| | Request Method | GET| | Response | an item in JSON|  Example `http://.../API/identity/user/5 `  #### Extend resource response  On some resources, in GET methods the `d` (deploy) URL query parameter can be used to extend the response objects. The value of this parameter consists of an attribute for which you want to make an extended request (called a deploy) and retrieve attributes of a linked resource. This means that instead of retrieving the ID or a parent or referenced resource, you can retrieve the full object.  For example, when you retrieve a task, you can also retrieve the process definition attributes in addition to the process definition ID that is already part of the task resource. The supported deploy values for a task include its process (d=processId).  Specifiy multiple `d` parameter to extend several resources. For instance, to retrieve the flow node of id 143 and the associated process, process instance and assigned user, call `/API/bpm/flowNode/143?d=processId&d=caseId&d=assigned_id`  #### With compound identifier  The order of the identifier parts for each resource type is given in the table above.  | Request URL | `http://.../API/{API_name}/{resource_name}/{id_part1}/{id_part2} `| |:-|:-| | Request Method | GET| | Response | an item in JSON|  Example `http://.../API/identity/membership/5/12/24 `  ### Update a resource  | Request URL | `http://.../API/{API_name}/{resource_name}/{id} `| |:-|:-| | Request Method | PUT| | Request Payload | a map in JSON containing the new values for the attributes you want to change.| | Response | the corresponding item in JSON with new values where you requested a modification|  Example `http://.../API/identity/user/5`  #### With compound identifier:  Response: the corresponding item in JSON with new values where you requested a modification.  | Request URL | `http://.../API/{API_name}/{resource_name}/{id_part1}/{id_part2} `| |:-|:-| | Request Method | PUT| | Request Payload | ` a map in JSON containing the new values for the attributes you want to change `| | Response | ` the corresponding item in JSON with new values where you requested a modification`|  Example `http://.../API/identity/membership/5/12/24 `  ### Delete resources  Use the DELETE request to remove multiple resources.  | Request URL | `http://.../API/{API_name}/{resource_name}/ `| |:-|:-| | Request Method | DELETE| | Request Payload | A list of identifiers in JSON, for example `[\"id1\",\"id2\",\"id3\"]`. Compound identifiers are separated by '/' characters.| | Response | `empty `|  Example `http://.../API/identity/membership/ `  ### Search for a resource  The required object is specified with a set of filters in the request URL. The URL parameters must be URL-encoded.  Results are returned in a paged list, so you have to specify the page (counting from zero), and the number of results per page (count), additionally you can define a sort key (order). You can see the total number of matching results in the HTTP response header Content-Range. If you are searching for business data using a custom query, there must be a [count query in the BDM](define-and-deploy-the-bdm.md). If there is no count query, results from a custom query on business data cannot be paged properly (the header Content-Range will be absent). For business data default queries, the count query is defined automatically.  The available filters are the attributes of the item plus some specific filters defined by each item.  | Request URL | `http://.../API/{API_name}/{resource_name}?p={page}&c={count}&o={order}&s={query}&f={filter_name}={filter_value}&f=... `| |:-|:-| | Request Method | GET| | Response | an array of items in JSON|  Example `/API/identity/user?p=0&c=10&o=firstname&s=test&f=manager_id=3`  For a GET method that retrieves more than one instance of a resource, you can specify the following request parameters:  * p (Mandatory): index of the page to display * c (Mandatory): maximum number of elements to retrieve * o: order of presentation of values in response: must be either `attributeName ASC` or `attributeName DESC`. The final order parameter value must be URL encoded. * f: list of filters, specified as `attributeName=attributeValue`. To filter on more than one attribute, specify an f parameters for each attribute. The final filter parameter value must be URL encoded.   The attributes you can filter on are specific to the resource. * s: search on name or search indexes. The matching policy depends on the configuration of [word-based search](using-list-and-search-methods.md).   For example, if word-based search is enabled, `s=Valid` returns matches containing the string \"valid\" at the start of any word in the attribute value word,   such as \"Valid address\", \"Not a valid address\", and \"Validated request\" but not \"Invalid request\".   If word-based search is disabled, `s=Valid` returns matches containing the string \"valid\" at the start of the attribute value, such as \"Valid address\" or \"Validated request\" but not \"Not a valid address\" or \"Invalid request\".  ### Errors  The API uses standard HTTP status codes to indicate the success or failure of the API call.  If you get a `401` response code :   - make sure that the cookies have been transfered with the call   - make sure that the cookies transfered are the ones generated during the last sucessfull login call   - if one of the PUT, DELETE or POST method is used, make sure that the `X-Bonita-API-Token` header is included   - if the X-Bonita-API-Token header is included, make sure that the value is the same as the one of the cookie generated during the last login   - Maybe a logout was issued or the session has expired; try to log in again, and re run the request with the new cookies and the new value for the `X-Bonita-API-Token` header.
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
import org.bonitasoft.web.client.model.ActivationState;
import org.bonitasoft.web.client.model.ConfigurationState;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ProcessDefinition
 */
@JsonPropertyOrder({
  ProcessDefinition.JSON_PROPERTY_ID,
  ProcessDefinition.JSON_PROPERTY_ICON,
  ProcessDefinition.JSON_PROPERTY_DISPLAY_DESCRIPTION,
  ProcessDefinition.JSON_PROPERTY_DEPLOYMENT_DATE,
  ProcessDefinition.JSON_PROPERTY_DESCRIPTION,
  ProcessDefinition.JSON_PROPERTY_ACTIVATION_STATE,
  ProcessDefinition.JSON_PROPERTY_NAME,
  ProcessDefinition.JSON_PROPERTY_DEPLOYED_BY,
  ProcessDefinition.JSON_PROPERTY_DISPLAY_NAME,
  ProcessDefinition.JSON_PROPERTY_ACTORINITIATORID,
  ProcessDefinition.JSON_PROPERTY_LAST_UPDATE_DATE,
  ProcessDefinition.JSON_PROPERTY_CONFIGURATION_STATE,
  ProcessDefinition.JSON_PROPERTY_VERSION
})

public class ProcessDefinition implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_ICON = "icon";
  private String icon;

  public static final String JSON_PROPERTY_DISPLAY_DESCRIPTION = "displayDescription";
  private String displayDescription;

  public static final String JSON_PROPERTY_DEPLOYMENT_DATE = "deploymentDate";
  private String deploymentDate;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_ACTIVATION_STATE = "activationState";
  private ActivationState activationState;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_DEPLOYED_BY = "deployedBy";
  private String deployedBy;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  private String displayName;

  public static final String JSON_PROPERTY_ACTORINITIATORID = "actorinitiatorid";
  private String actorinitiatorid;

  public static final String JSON_PROPERTY_LAST_UPDATE_DATE = "last_update_date";
  private String lastUpdateDate;

  public static final String JSON_PROPERTY_CONFIGURATION_STATE = "configurationState";
  private ConfigurationState configurationState;

  public static final String JSON_PROPERTY_VERSION = "version";
  private String version;


  public ProcessDefinition id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * the identifier of the process definition (long)
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the identifier of the process definition (long)")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public ProcessDefinition icon(String icon) {
    
    this.icon = icon;
    return this;
  }

   /**
   * icon path
   * @return icon
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "icon path")
  @JsonProperty(JSON_PROPERTY_ICON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getIcon() {
    return icon;
  }


  public void setIcon(String icon) {
    this.icon = icon;
  }


  public ProcessDefinition displayDescription(String displayDescription) {
    
    this.displayDescription = displayDescription;
    return this;
  }

   /**
   * the human readable activity description
   * @return displayDescription
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the human readable activity description")
  @JsonProperty(JSON_PROPERTY_DISPLAY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDisplayDescription() {
    return displayDescription;
  }


  public void setDisplayDescription(String displayDescription) {
    this.displayDescription = displayDescription;
  }


  public ProcessDefinition deploymentDate(String deploymentDate) {
    
    this.deploymentDate = deploymentDate;
    return this;
  }

   /**
   * the date when the process definition was deployed
   * @return deploymentDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the date when the process definition was deployed")
  @JsonProperty(JSON_PROPERTY_DEPLOYMENT_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDeploymentDate() {
    return deploymentDate;
  }


  public void setDeploymentDate(String deploymentDate) {
    this.deploymentDate = deploymentDate;
  }


  public ProcessDefinition description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * the process description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the process description")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public ProcessDefinition activationState(ActivationState activationState) {
    
    this.activationState = activationState;
    return this;
  }

   /**
   * Get activationState
   * @return activationState
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ACTIVATION_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ActivationState getActivationState() {
    return activationState;
  }


  public void setActivationState(ActivationState activationState) {
    this.activationState = activationState;
  }


  public ProcessDefinition name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * the process name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the process name")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public ProcessDefinition deployedBy(String deployedBy) {
    
    this.deployedBy = deployedBy;
    return this;
  }

   /**
   * the id of the user who deployed the process
   * @return deployedBy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the id of the user who deployed the process")
  @JsonProperty(JSON_PROPERTY_DEPLOYED_BY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDeployedBy() {
    return deployedBy;
  }


  public void setDeployedBy(String deployedBy) {
    this.deployedBy = deployedBy;
  }


  public ProcessDefinition displayName(String displayName) {
    
    this.displayName = displayName;
    return this;
  }

   /**
   * the human readable process description
   * @return displayName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the human readable process description")
  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDisplayName() {
    return displayName;
  }


  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  public ProcessDefinition actorinitiatorid(String actorinitiatorid) {
    
    this.actorinitiatorid = actorinitiatorid;
    return this;
  }

   /**
   * the id of the actor that can initiate process instances of the process
   * @return actorinitiatorid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the id of the actor that can initiate process instances of the process")
  @JsonProperty(JSON_PROPERTY_ACTORINITIATORID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getActorinitiatorid() {
    return actorinitiatorid;
  }


  public void setActorinitiatorid(String actorinitiatorid) {
    this.actorinitiatorid = actorinitiatorid;
  }


  public ProcessDefinition lastUpdateDate(String lastUpdateDate) {
    
    this.lastUpdateDate = lastUpdateDate;
    return this;
  }

   /**
   * the date when the process definition was last updated
   * @return lastUpdateDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the date when the process definition was last updated")
  @JsonProperty(JSON_PROPERTY_LAST_UPDATE_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLastUpdateDate() {
    return lastUpdateDate;
  }


  public void setLastUpdateDate(String lastUpdateDate) {
    this.lastUpdateDate = lastUpdateDate;
  }


  public ProcessDefinition configurationState(ConfigurationState configurationState) {
    
    this.configurationState = configurationState;
    return this;
  }

   /**
   * Get configurationState
   * @return configurationState
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CONFIGURATION_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ConfigurationState getConfigurationState() {
    return configurationState;
  }


  public void setConfigurationState(ConfigurationState configurationState) {
    this.configurationState = configurationState;
  }


  public ProcessDefinition version(String version) {
    
    this.version = version;
    return this;
  }

   /**
   * the version of the process
   * @return version
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "the version of the process")
  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getVersion() {
    return version;
  }


  public void setVersion(String version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProcessDefinition processDefinition = (ProcessDefinition) o;
    return Objects.equals(this.id, processDefinition.id) &&
        Objects.equals(this.icon, processDefinition.icon) &&
        Objects.equals(this.displayDescription, processDefinition.displayDescription) &&
        Objects.equals(this.deploymentDate, processDefinition.deploymentDate) &&
        Objects.equals(this.description, processDefinition.description) &&
        Objects.equals(this.activationState, processDefinition.activationState) &&
        Objects.equals(this.name, processDefinition.name) &&
        Objects.equals(this.deployedBy, processDefinition.deployedBy) &&
        Objects.equals(this.displayName, processDefinition.displayName) &&
        Objects.equals(this.actorinitiatorid, processDefinition.actorinitiatorid) &&
        Objects.equals(this.lastUpdateDate, processDefinition.lastUpdateDate) &&
        Objects.equals(this.configurationState, processDefinition.configurationState) &&
        Objects.equals(this.version, processDefinition.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, icon, displayDescription, deploymentDate, description, activationState, name, deployedBy, displayName, actorinitiatorid, lastUpdateDate, configurationState, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcessDefinition {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
    sb.append("    displayDescription: ").append(toIndentedString(displayDescription)).append("\n");
    sb.append("    deploymentDate: ").append(toIndentedString(deploymentDate)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    activationState: ").append(toIndentedString(activationState)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    deployedBy: ").append(toIndentedString(deployedBy)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    actorinitiatorid: ").append(toIndentedString(actorinitiatorid)).append("\n");
    sb.append("    lastUpdateDate: ").append(toIndentedString(lastUpdateDate)).append("\n");
    sb.append("    configurationState: ").append(toIndentedString(configurationState)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

