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
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * ProcessInfoFlowNodeStatesCountersValue
 */
@JsonPropertyOrder({
  ProcessInfoFlowNodeStatesCountersValue.JSON_PROPERTY_READY,
  ProcessInfoFlowNodeStatesCountersValue.JSON_PROPERTY_FAILED,
  ProcessInfoFlowNodeStatesCountersValue.JSON_PROPERTY_EXECUTING,
  ProcessInfoFlowNodeStatesCountersValue.JSON_PROPERTY_WAITING,
  ProcessInfoFlowNodeStatesCountersValue.JSON_PROPERTY_INITIALIZING,
  ProcessInfoFlowNodeStatesCountersValue.JSON_PROPERTY_COMPLETING
})
@JsonTypeName("ProcessInfo_flowNodeStatesCounters_value")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ProcessInfoFlowNodeStatesCountersValue implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_READY = "ready";
  private Long ready;

  public static final String JSON_PROPERTY_FAILED = "failed";
  private Long failed;

  public static final String JSON_PROPERTY_EXECUTING = "executing";
  private Long executing;

  public static final String JSON_PROPERTY_WAITING = "waiting";
  private Long waiting;

  public static final String JSON_PROPERTY_INITIALIZING = "initializing";
  private Long initializing;

  public static final String JSON_PROPERTY_COMPLETING = "completing";
  private Long completing;

  public ProcessInfoFlowNodeStatesCountersValue() {
  }

  public ProcessInfoFlowNodeStatesCountersValue ready(Long ready) {
    
    this.ready = ready;
    return this;
  }

   /**
   * number of instance of the given Flow Node in ready state
   * @return ready
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_READY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getReady() {
    return ready;
  }


  @JsonProperty(JSON_PROPERTY_READY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReady(Long ready) {
    this.ready = ready;
  }


  public ProcessInfoFlowNodeStatesCountersValue failed(Long failed) {
    
    this.failed = failed;
    return this;
  }

   /**
   * number of instance of the given Flow Node in failed state
   * @return failed
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_FAILED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getFailed() {
    return failed;
  }


  @JsonProperty(JSON_PROPERTY_FAILED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFailed(Long failed) {
    this.failed = failed;
  }


  public ProcessInfoFlowNodeStatesCountersValue executing(Long executing) {
    
    this.executing = executing;
    return this;
  }

   /**
   * number of instance of the given Flow Node in executing state
   * @return executing
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EXECUTING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getExecuting() {
    return executing;
  }


  @JsonProperty(JSON_PROPERTY_EXECUTING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExecuting(Long executing) {
    this.executing = executing;
  }


  public ProcessInfoFlowNodeStatesCountersValue waiting(Long waiting) {
    
    this.waiting = waiting;
    return this;
  }

   /**
   * number of instance of the given Flow Node in waiting state
   * @return waiting
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_WAITING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getWaiting() {
    return waiting;
  }


  @JsonProperty(JSON_PROPERTY_WAITING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWaiting(Long waiting) {
    this.waiting = waiting;
  }


  public ProcessInfoFlowNodeStatesCountersValue initializing(Long initializing) {
    
    this.initializing = initializing;
    return this;
  }

   /**
   * number of instance of the given Flow Node in initializing state
   * @return initializing
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_INITIALIZING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getInitializing() {
    return initializing;
  }


  @JsonProperty(JSON_PROPERTY_INITIALIZING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInitializing(Long initializing) {
    this.initializing = initializing;
  }


  public ProcessInfoFlowNodeStatesCountersValue completing(Long completing) {
    
    this.completing = completing;
    return this;
  }

   /**
   * number of instance of the given Flow Node in completing state
   * @return completing
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_COMPLETING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getCompleting() {
    return completing;
  }


  @JsonProperty(JSON_PROPERTY_COMPLETING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCompleting(Long completing) {
    this.completing = completing;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProcessInfoFlowNodeStatesCountersValue processInfoFlowNodeStatesCountersValue = (ProcessInfoFlowNodeStatesCountersValue) o;
    return Objects.equals(this.ready, processInfoFlowNodeStatesCountersValue.ready) &&
        Objects.equals(this.failed, processInfoFlowNodeStatesCountersValue.failed) &&
        Objects.equals(this.executing, processInfoFlowNodeStatesCountersValue.executing) &&
        Objects.equals(this.waiting, processInfoFlowNodeStatesCountersValue.waiting) &&
        Objects.equals(this.initializing, processInfoFlowNodeStatesCountersValue.initializing) &&
        Objects.equals(this.completing, processInfoFlowNodeStatesCountersValue.completing);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ready, failed, executing, waiting, initializing, completing);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcessInfoFlowNodeStatesCountersValue {\n");
    sb.append("    ready: ").append(toIndentedString(ready)).append("\n");
    sb.append("    failed: ").append(toIndentedString(failed)).append("\n");
    sb.append("    executing: ").append(toIndentedString(executing)).append("\n");
    sb.append("    waiting: ").append(toIndentedString(waiting)).append("\n");
    sb.append("    initializing: ").append(toIndentedString(initializing)).append("\n");
    sb.append("    completing: ").append(toIndentedString(completing)).append("\n");
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

