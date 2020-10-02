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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Allows to access all flow elements (activities, gateways, events and transitions) of a process or sub-process.
 */
@ApiModel(description = "Allows to access all flow elements (activities, gateways, events and transitions) of a process or sub-process.")
@JsonPropertyOrder({
  FlowElementContainerDefinition.JSON_PROPERTY_ACTIVITIES,
  FlowElementContainerDefinition.JSON_PROPERTY_TRANSITIONS,
  FlowElementContainerDefinition.JSON_PROPERTY_GATEWAYS_LIST,
  FlowElementContainerDefinition.JSON_PROPERTY_START_EVENTS,
  FlowElementContainerDefinition.JSON_PROPERTY_INTERMEDIATE_CATCH_EVENTS,
  FlowElementContainerDefinition.JSON_PROPERTY_INTERMEDIATE_THROW_EVENTS,
  FlowElementContainerDefinition.JSON_PROPERTY_END_EVENTS,
  FlowElementContainerDefinition.JSON_PROPERTY_DATA_DEFINITIONS,
  FlowElementContainerDefinition.JSON_PROPERTY_DOCUMENT_DEFINITIONS,
  FlowElementContainerDefinition.JSON_PROPERTY_CONNECTORS,
  FlowElementContainerDefinition.JSON_PROPERTY_BUSINESS_DATA_DEFINITIONS,
  FlowElementContainerDefinition.JSON_PROPERTY_DOCUMENT_LIST_DEFINITIONS
})

public class FlowElementContainerDefinition implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ACTIVITIES = "activities";
  private List<Map<String, Object>> activities = null;

  public static final String JSON_PROPERTY_TRANSITIONS = "transitions";
  private List<Map<String, Object>> transitions = null;

  public static final String JSON_PROPERTY_GATEWAYS_LIST = "gatewaysList";
  private List<Map<String, Object>> gatewaysList = null;

  public static final String JSON_PROPERTY_START_EVENTS = "startEvents";
  private List<Map<String, Object>> startEvents = null;

  public static final String JSON_PROPERTY_INTERMEDIATE_CATCH_EVENTS = "intermediateCatchEvents";
  private List<Map<String, Object>> intermediateCatchEvents = null;

  public static final String JSON_PROPERTY_INTERMEDIATE_THROW_EVENTS = "intermediateThrowEvents";
  private List<Map<String, Object>> intermediateThrowEvents = null;

  public static final String JSON_PROPERTY_END_EVENTS = "endEvents";
  private List<Map<String, Object>> endEvents = null;

  public static final String JSON_PROPERTY_DATA_DEFINITIONS = "dataDefinitions";
  private List<Map<String, Object>> dataDefinitions = null;

  public static final String JSON_PROPERTY_DOCUMENT_DEFINITIONS = "documentDefinitions";
  private List<Map<String, Object>> documentDefinitions = null;

  public static final String JSON_PROPERTY_CONNECTORS = "connectors";
  private List<Map<String, Object>> connectors = null;

  public static final String JSON_PROPERTY_BUSINESS_DATA_DEFINITIONS = "businessDataDefinitions";
  private List<Map<String, Object>> businessDataDefinitions = null;

  public static final String JSON_PROPERTY_DOCUMENT_LIST_DEFINITIONS = "documentListDefinitions";
  private List<Map<String, Object>> documentListDefinitions = null;


  public FlowElementContainerDefinition activities(List<Map<String, Object>> activities) {
    
    this.activities = activities;
    return this;
  }

  public FlowElementContainerDefinition addActivitiesItem(Map<String, Object> activitiesItem) {
    if (this.activities == null) {
      this.activities = new ArrayList<>();
    }
    this.activities.add(activitiesItem);
    return this;
  }

   /**
   * Get activities
   * @return activities
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ACTIVITIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Map<String, Object>> getActivities() {
    return activities;
  }


  public void setActivities(List<Map<String, Object>> activities) {
    this.activities = activities;
  }


  public FlowElementContainerDefinition transitions(List<Map<String, Object>> transitions) {
    
    this.transitions = transitions;
    return this;
  }

  public FlowElementContainerDefinition addTransitionsItem(Map<String, Object> transitionsItem) {
    if (this.transitions == null) {
      this.transitions = new ArrayList<>();
    }
    this.transitions.add(transitionsItem);
    return this;
  }

   /**
   * Get transitions
   * @return transitions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TRANSITIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Map<String, Object>> getTransitions() {
    return transitions;
  }


  public void setTransitions(List<Map<String, Object>> transitions) {
    this.transitions = transitions;
  }


  public FlowElementContainerDefinition gatewaysList(List<Map<String, Object>> gatewaysList) {
    
    this.gatewaysList = gatewaysList;
    return this;
  }

  public FlowElementContainerDefinition addGatewaysListItem(Map<String, Object> gatewaysListItem) {
    if (this.gatewaysList == null) {
      this.gatewaysList = new ArrayList<>();
    }
    this.gatewaysList.add(gatewaysListItem);
    return this;
  }

   /**
   * Get gatewaysList
   * @return gatewaysList
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_GATEWAYS_LIST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Map<String, Object>> getGatewaysList() {
    return gatewaysList;
  }


  public void setGatewaysList(List<Map<String, Object>> gatewaysList) {
    this.gatewaysList = gatewaysList;
  }


  public FlowElementContainerDefinition startEvents(List<Map<String, Object>> startEvents) {
    
    this.startEvents = startEvents;
    return this;
  }

  public FlowElementContainerDefinition addStartEventsItem(Map<String, Object> startEventsItem) {
    if (this.startEvents == null) {
      this.startEvents = new ArrayList<>();
    }
    this.startEvents.add(startEventsItem);
    return this;
  }

   /**
   * Get startEvents
   * @return startEvents
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_START_EVENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Map<String, Object>> getStartEvents() {
    return startEvents;
  }


  public void setStartEvents(List<Map<String, Object>> startEvents) {
    this.startEvents = startEvents;
  }


  public FlowElementContainerDefinition intermediateCatchEvents(List<Map<String, Object>> intermediateCatchEvents) {
    
    this.intermediateCatchEvents = intermediateCatchEvents;
    return this;
  }

  public FlowElementContainerDefinition addIntermediateCatchEventsItem(Map<String, Object> intermediateCatchEventsItem) {
    if (this.intermediateCatchEvents == null) {
      this.intermediateCatchEvents = new ArrayList<>();
    }
    this.intermediateCatchEvents.add(intermediateCatchEventsItem);
    return this;
  }

   /**
   * Get intermediateCatchEvents
   * @return intermediateCatchEvents
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INTERMEDIATE_CATCH_EVENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Map<String, Object>> getIntermediateCatchEvents() {
    return intermediateCatchEvents;
  }


  public void setIntermediateCatchEvents(List<Map<String, Object>> intermediateCatchEvents) {
    this.intermediateCatchEvents = intermediateCatchEvents;
  }


  public FlowElementContainerDefinition intermediateThrowEvents(List<Map<String, Object>> intermediateThrowEvents) {
    
    this.intermediateThrowEvents = intermediateThrowEvents;
    return this;
  }

  public FlowElementContainerDefinition addIntermediateThrowEventsItem(Map<String, Object> intermediateThrowEventsItem) {
    if (this.intermediateThrowEvents == null) {
      this.intermediateThrowEvents = new ArrayList<>();
    }
    this.intermediateThrowEvents.add(intermediateThrowEventsItem);
    return this;
  }

   /**
   * Get intermediateThrowEvents
   * @return intermediateThrowEvents
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INTERMEDIATE_THROW_EVENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Map<String, Object>> getIntermediateThrowEvents() {
    return intermediateThrowEvents;
  }


  public void setIntermediateThrowEvents(List<Map<String, Object>> intermediateThrowEvents) {
    this.intermediateThrowEvents = intermediateThrowEvents;
  }


  public FlowElementContainerDefinition endEvents(List<Map<String, Object>> endEvents) {
    
    this.endEvents = endEvents;
    return this;
  }

  public FlowElementContainerDefinition addEndEventsItem(Map<String, Object> endEventsItem) {
    if (this.endEvents == null) {
      this.endEvents = new ArrayList<>();
    }
    this.endEvents.add(endEventsItem);
    return this;
  }

   /**
   * Get endEvents
   * @return endEvents
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_END_EVENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Map<String, Object>> getEndEvents() {
    return endEvents;
  }


  public void setEndEvents(List<Map<String, Object>> endEvents) {
    this.endEvents = endEvents;
  }


  public FlowElementContainerDefinition dataDefinitions(List<Map<String, Object>> dataDefinitions) {
    
    this.dataDefinitions = dataDefinitions;
    return this;
  }

  public FlowElementContainerDefinition addDataDefinitionsItem(Map<String, Object> dataDefinitionsItem) {
    if (this.dataDefinitions == null) {
      this.dataDefinitions = new ArrayList<>();
    }
    this.dataDefinitions.add(dataDefinitionsItem);
    return this;
  }

   /**
   * Get dataDefinitions
   * @return dataDefinitions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DATA_DEFINITIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Map<String, Object>> getDataDefinitions() {
    return dataDefinitions;
  }


  public void setDataDefinitions(List<Map<String, Object>> dataDefinitions) {
    this.dataDefinitions = dataDefinitions;
  }


  public FlowElementContainerDefinition documentDefinitions(List<Map<String, Object>> documentDefinitions) {
    
    this.documentDefinitions = documentDefinitions;
    return this;
  }

  public FlowElementContainerDefinition addDocumentDefinitionsItem(Map<String, Object> documentDefinitionsItem) {
    if (this.documentDefinitions == null) {
      this.documentDefinitions = new ArrayList<>();
    }
    this.documentDefinitions.add(documentDefinitionsItem);
    return this;
  }

   /**
   * Get documentDefinitions
   * @return documentDefinitions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DOCUMENT_DEFINITIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Map<String, Object>> getDocumentDefinitions() {
    return documentDefinitions;
  }


  public void setDocumentDefinitions(List<Map<String, Object>> documentDefinitions) {
    this.documentDefinitions = documentDefinitions;
  }


  public FlowElementContainerDefinition connectors(List<Map<String, Object>> connectors) {
    
    this.connectors = connectors;
    return this;
  }

  public FlowElementContainerDefinition addConnectorsItem(Map<String, Object> connectorsItem) {
    if (this.connectors == null) {
      this.connectors = new ArrayList<>();
    }
    this.connectors.add(connectorsItem);
    return this;
  }

   /**
   * Get connectors
   * @return connectors
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CONNECTORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Map<String, Object>> getConnectors() {
    return connectors;
  }


  public void setConnectors(List<Map<String, Object>> connectors) {
    this.connectors = connectors;
  }


  public FlowElementContainerDefinition businessDataDefinitions(List<Map<String, Object>> businessDataDefinitions) {
    
    this.businessDataDefinitions = businessDataDefinitions;
    return this;
  }

  public FlowElementContainerDefinition addBusinessDataDefinitionsItem(Map<String, Object> businessDataDefinitionsItem) {
    if (this.businessDataDefinitions == null) {
      this.businessDataDefinitions = new ArrayList<>();
    }
    this.businessDataDefinitions.add(businessDataDefinitionsItem);
    return this;
  }

   /**
   * Get businessDataDefinitions
   * @return businessDataDefinitions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BUSINESS_DATA_DEFINITIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Map<String, Object>> getBusinessDataDefinitions() {
    return businessDataDefinitions;
  }


  public void setBusinessDataDefinitions(List<Map<String, Object>> businessDataDefinitions) {
    this.businessDataDefinitions = businessDataDefinitions;
  }


  public FlowElementContainerDefinition documentListDefinitions(List<Map<String, Object>> documentListDefinitions) {
    
    this.documentListDefinitions = documentListDefinitions;
    return this;
  }

  public FlowElementContainerDefinition addDocumentListDefinitionsItem(Map<String, Object> documentListDefinitionsItem) {
    if (this.documentListDefinitions == null) {
      this.documentListDefinitions = new ArrayList<>();
    }
    this.documentListDefinitions.add(documentListDefinitionsItem);
    return this;
  }

   /**
   * Get documentListDefinitions
   * @return documentListDefinitions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DOCUMENT_LIST_DEFINITIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Map<String, Object>> getDocumentListDefinitions() {
    return documentListDefinitions;
  }


  public void setDocumentListDefinitions(List<Map<String, Object>> documentListDefinitions) {
    this.documentListDefinitions = documentListDefinitions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlowElementContainerDefinition flowElementContainerDefinition = (FlowElementContainerDefinition) o;
    return Objects.equals(this.activities, flowElementContainerDefinition.activities) &&
        Objects.equals(this.transitions, flowElementContainerDefinition.transitions) &&
        Objects.equals(this.gatewaysList, flowElementContainerDefinition.gatewaysList) &&
        Objects.equals(this.startEvents, flowElementContainerDefinition.startEvents) &&
        Objects.equals(this.intermediateCatchEvents, flowElementContainerDefinition.intermediateCatchEvents) &&
        Objects.equals(this.intermediateThrowEvents, flowElementContainerDefinition.intermediateThrowEvents) &&
        Objects.equals(this.endEvents, flowElementContainerDefinition.endEvents) &&
        Objects.equals(this.dataDefinitions, flowElementContainerDefinition.dataDefinitions) &&
        Objects.equals(this.documentDefinitions, flowElementContainerDefinition.documentDefinitions) &&
        Objects.equals(this.connectors, flowElementContainerDefinition.connectors) &&
        Objects.equals(this.businessDataDefinitions, flowElementContainerDefinition.businessDataDefinitions) &&
        Objects.equals(this.documentListDefinitions, flowElementContainerDefinition.documentListDefinitions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(activities, transitions, gatewaysList, startEvents, intermediateCatchEvents, intermediateThrowEvents, endEvents, dataDefinitions, documentDefinitions, connectors, businessDataDefinitions, documentListDefinitions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlowElementContainerDefinition {\n");
    sb.append("    activities: ").append(toIndentedString(activities)).append("\n");
    sb.append("    transitions: ").append(toIndentedString(transitions)).append("\n");
    sb.append("    gatewaysList: ").append(toIndentedString(gatewaysList)).append("\n");
    sb.append("    startEvents: ").append(toIndentedString(startEvents)).append("\n");
    sb.append("    intermediateCatchEvents: ").append(toIndentedString(intermediateCatchEvents)).append("\n");
    sb.append("    intermediateThrowEvents: ").append(toIndentedString(intermediateThrowEvents)).append("\n");
    sb.append("    endEvents: ").append(toIndentedString(endEvents)).append("\n");
    sb.append("    dataDefinitions: ").append(toIndentedString(dataDefinitions)).append("\n");
    sb.append("    documentDefinitions: ").append(toIndentedString(documentDefinitions)).append("\n");
    sb.append("    connectors: ").append(toIndentedString(connectors)).append("\n");
    sb.append("    businessDataDefinitions: ").append(toIndentedString(businessDataDefinitions)).append("\n");
    sb.append("    documentListDefinitions: ").append(toIndentedString(documentListDefinitions)).append("\n");
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

