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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents the Design Definition of a process. It gives access to process attributes.
 */
@ApiModel(description = "Represents the Design Definition of a process. It gives access to process attributes.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-09-30T11:56:08.520781+02:00[Europe/Paris]")
public class DesignProcessDefinition implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String SERIALIZED_NAME_DISPLAY_NAME = "displayName";
  @SerializedName(SERIALIZED_NAME_DISPLAY_NAME)
  private String displayName;

  public static final String SERIALIZED_NAME_DISPLAY_DESCRIPTION = "displayDescription";
  @SerializedName(SERIALIZED_NAME_DISPLAY_DESCRIPTION)
  private String displayDescription;

  public static final String SERIALIZED_NAME_FLOW_ELEMENT_CONTAINER = "flowElementContainer";
  @SerializedName(SERIALIZED_NAME_FLOW_ELEMENT_CONTAINER)
  private FlowElementContainerDefinition flowElementContainer;

  public static final String SERIALIZED_NAME_PARAMETERS = "parameters";
  @SerializedName(SERIALIZED_NAME_PARAMETERS)
  private List<DesignProcessDefinitionParameters> parameters = null;

  public static final String SERIALIZED_NAME_ACTORS_LIST = "actorsList";
  @SerializedName(SERIALIZED_NAME_ACTORS_LIST)
  private List<ActorDefinition> actorsList = null;

  public static final String SERIALIZED_NAME_ACTOR_INITIATOR = "actorInitiator";
  @SerializedName(SERIALIZED_NAME_ACTOR_INITIATOR)
  private ActorDefinition actorInitiator;

  public static final String SERIALIZED_NAME_STRING_INDEX_LABELS = "stringIndexLabels";
  @SerializedName(SERIALIZED_NAME_STRING_INDEX_LABELS)
  private List<String> stringIndexLabels = null;

  public static final String SERIALIZED_NAME_STRING_INDEX_VALUES = "stringIndexValues";
  @SerializedName(SERIALIZED_NAME_STRING_INDEX_VALUES)
  private List<Expression> stringIndexValues = null;

  public static final String SERIALIZED_NAME_CONTRACT = "contract";
  @SerializedName(SERIALIZED_NAME_CONTRACT)
  private DesignProcessDefinitionContract contract;

  public static final String SERIALIZED_NAME_CONTEXT = "context";
  @SerializedName(SERIALIZED_NAME_CONTEXT)
  private List<DesignProcessDefinitionContext> context = null;


  public DesignProcessDefinition displayName(String displayName) {
    
    this.displayName = displayName;
    return this;
  }

   /**
   * The process definition display name
   * @return displayName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The process definition display name")

  public String getDisplayName() {
    return displayName;
  }


  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  public DesignProcessDefinition displayDescription(String displayDescription) {
    
    this.displayDescription = displayDescription;
    return this;
  }

   /**
   * The process definition display description name
   * @return displayDescription
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The process definition display description name")

  public String getDisplayDescription() {
    return displayDescription;
  }


  public void setDisplayDescription(String displayDescription) {
    this.displayDescription = displayDescription;
  }


  public DesignProcessDefinition flowElementContainer(FlowElementContainerDefinition flowElementContainer) {
    
    this.flowElementContainer = flowElementContainer;
    return this;
  }

   /**
   * Get flowElementContainer
   * @return flowElementContainer
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public FlowElementContainerDefinition getFlowElementContainer() {
    return flowElementContainer;
  }


  public void setFlowElementContainer(FlowElementContainerDefinition flowElementContainer) {
    this.flowElementContainer = flowElementContainer;
  }


  public DesignProcessDefinition parameters(List<DesignProcessDefinitionParameters> parameters) {
    
    this.parameters = parameters;
    return this;
  }

  public DesignProcessDefinition addParametersItem(DesignProcessDefinitionParameters parametersItem) {
    if (this.parameters == null) {
      this.parameters = new ArrayList<>();
    }
    this.parameters.add(parametersItem);
    return this;
  }

   /**
   * The process parameter definitions
   * @return parameters
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The process parameter definitions")

  public List<DesignProcessDefinitionParameters> getParameters() {
    return parameters;
  }


  public void setParameters(List<DesignProcessDefinitionParameters> parameters) {
    this.parameters = parameters;
  }


  public DesignProcessDefinition actorsList(List<ActorDefinition> actorsList) {
    
    this.actorsList = actorsList;
    return this;
  }

  public DesignProcessDefinition addActorsListItem(ActorDefinition actorsListItem) {
    if (this.actorsList == null) {
      this.actorsList = new ArrayList<>();
    }
    this.actorsList.add(actorsListItem);
    return this;
  }

   /**
   * The list of process actor definitions
   * @return actorsList
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The list of process actor definitions")

  public List<ActorDefinition> getActorsList() {
    return actorsList;
  }


  public void setActorsList(List<ActorDefinition> actorsList) {
    this.actorsList = actorsList;
  }


  public DesignProcessDefinition actorInitiator(ActorDefinition actorInitiator) {
    
    this.actorInitiator = actorInitiator;
    return this;
  }

   /**
   * Get actorInitiator
   * @return actorInitiator
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ActorDefinition getActorInitiator() {
    return actorInitiator;
  }


  public void setActorInitiator(ActorDefinition actorInitiator) {
    this.actorInitiator = actorInitiator;
  }


  public DesignProcessDefinition stringIndexLabels(List<String> stringIndexLabels) {
    
    this.stringIndexLabels = stringIndexLabels;
    return this;
  }

  public DesignProcessDefinition addStringIndexLabelsItem(String stringIndexLabelsItem) {
    if (this.stringIndexLabels == null) {
      this.stringIndexLabels = new ArrayList<>();
    }
    this.stringIndexLabels.add(stringIndexLabelsItem);
    return this;
  }

   /**
   * The process definition labels
   * @return stringIndexLabels
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The process definition labels")

  public List<String> getStringIndexLabels() {
    return stringIndexLabels;
  }


  public void setStringIndexLabels(List<String> stringIndexLabels) {
    this.stringIndexLabels = stringIndexLabels;
  }


  public DesignProcessDefinition stringIndexValues(List<Expression> stringIndexValues) {
    
    this.stringIndexValues = stringIndexValues;
    return this;
  }

  public DesignProcessDefinition addStringIndexValuesItem(Expression stringIndexValuesItem) {
    if (this.stringIndexValues == null) {
      this.stringIndexValues = new ArrayList<>();
    }
    this.stringIndexValues.add(stringIndexValuesItem);
    return this;
  }

   /**
   * The process definition expressions
   * @return stringIndexValues
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The process definition expressions")

  public List<Expression> getStringIndexValues() {
    return stringIndexValues;
  }


  public void setStringIndexValues(List<Expression> stringIndexValues) {
    this.stringIndexValues = stringIndexValues;
  }


  public DesignProcessDefinition contract(DesignProcessDefinitionContract contract) {
    
    this.contract = contract;
    return this;
  }

   /**
   * Get contract
   * @return contract
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public DesignProcessDefinitionContract getContract() {
    return contract;
  }


  public void setContract(DesignProcessDefinitionContract contract) {
    this.contract = contract;
  }


  public DesignProcessDefinition context(List<DesignProcessDefinitionContext> context) {
    
    this.context = context;
    return this;
  }

  public DesignProcessDefinition addContextItem(DesignProcessDefinitionContext contextItem) {
    if (this.context == null) {
      this.context = new ArrayList<>();
    }
    this.context.add(contextItem);
    return this;
  }

   /**
   * The process definition expressions
   * @return context
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The process definition expressions")

  public List<DesignProcessDefinitionContext> getContext() {
    return context;
  }


  public void setContext(List<DesignProcessDefinitionContext> context) {
    this.context = context;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DesignProcessDefinition designProcessDefinition = (DesignProcessDefinition) o;
    return Objects.equals(this.displayName, designProcessDefinition.displayName) &&
        Objects.equals(this.displayDescription, designProcessDefinition.displayDescription) &&
        Objects.equals(this.flowElementContainer, designProcessDefinition.flowElementContainer) &&
        Objects.equals(this.parameters, designProcessDefinition.parameters) &&
        Objects.equals(this.actorsList, designProcessDefinition.actorsList) &&
        Objects.equals(this.actorInitiator, designProcessDefinition.actorInitiator) &&
        Objects.equals(this.stringIndexLabels, designProcessDefinition.stringIndexLabels) &&
        Objects.equals(this.stringIndexValues, designProcessDefinition.stringIndexValues) &&
        Objects.equals(this.contract, designProcessDefinition.contract) &&
        Objects.equals(this.context, designProcessDefinition.context);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, displayDescription, flowElementContainer, parameters, actorsList, actorInitiator, stringIndexLabels, stringIndexValues, contract, context);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DesignProcessDefinition {\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    displayDescription: ").append(toIndentedString(displayDescription)).append("\n");
    sb.append("    flowElementContainer: ").append(toIndentedString(flowElementContainer)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
    sb.append("    actorsList: ").append(toIndentedString(actorsList)).append("\n");
    sb.append("    actorInitiator: ").append(toIndentedString(actorInitiator)).append("\n");
    sb.append("    stringIndexLabels: ").append(toIndentedString(stringIndexLabels)).append("\n");
    sb.append("    stringIndexValues: ").append(toIndentedString(stringIndexValues)).append("\n");
    sb.append("    contract: ").append(toIndentedString(contract)).append("\n");
    sb.append("    context: ").append(toIndentedString(context)).append("\n");
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

