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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * This resource enables you to retrieve the value of a specific variable name for a specific process instance (or case). Only persistent variables are concerned by this resource, not transient variables.
 */
@JsonPropertyOrder({
  ActivityVariable.JSON_PROPERTY_TENANT_ID,
  ActivityVariable.JSON_PROPERTY_TENANT_ID_STRING,
  ActivityVariable.JSON_PROPERTY_ID,
  ActivityVariable.JSON_PROPERTY_ID_STRING,
  ActivityVariable.JSON_PROPERTY_NAME,
  ActivityVariable.JSON_PROPERTY_DESCRIPTION,
  ActivityVariable.JSON_PROPERTY_TRANSIENT_DATA,
  ActivityVariable.JSON_PROPERTY_CLASS_NAME,
  ActivityVariable.JSON_PROPERTY_CONTAINER_ID,
  ActivityVariable.JSON_PROPERTY_CONTAINER_ID_STRING,
  ActivityVariable.JSON_PROPERTY_CONTAINER_TYPE,
  ActivityVariable.JSON_PROPERTY_VALUE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ActivityVariable implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TENANT_ID = "tenantId";
  private String tenantId;

  public static final String JSON_PROPERTY_TENANT_ID_STRING = "tenantId_string";
  private String tenantIdString;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_ID_STRING = "id_string";
  private String idString;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_TRANSIENT_DATA = "transientData";
  private String transientData;

  public static final String JSON_PROPERTY_CLASS_NAME = "className";
  private String className;

  public static final String JSON_PROPERTY_CONTAINER_ID = "containerId";
  private String containerId;

  public static final String JSON_PROPERTY_CONTAINER_ID_STRING = "containerId_string";
  private String containerIdString;

  /**
   * ACTIVITY_INSTANCE | PROCESS_INSTANCE depending on whether the variable is defined at activity or process level.
   */
  public enum ContainerTypeEnum {
    ACTIVITY_INSTANCE("ACTIVITY_INSTANCE"),
    
    PROCESS_INSTANCE("PROCESS_INSTANCE");

    private String value;

    ContainerTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ContainerTypeEnum fromValue(String value) {
      for (ContainerTypeEnum b : ContainerTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_CONTAINER_TYPE = "containerType";
  private ContainerTypeEnum containerType;

  public static final String JSON_PROPERTY_VALUE = "value";
  private String value;

  public ActivityVariable() {
  }

  public ActivityVariable tenantId(String tenantId) {
    
    this.tenantId = tenantId;
    return this;
  }

   /**
   * The ID of the tenant where the current user is logged in (technical information)
   * @return tenantId
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TENANT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTenantId() {
    return tenantId;
  }


  @JsonProperty(JSON_PROPERTY_TENANT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }


  public ActivityVariable tenantIdString(String tenantIdString) {
    
    this.tenantIdString = tenantIdString;
    return this;
  }

   /**
   * number (since 7.0.1)
   * @return tenantIdString
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TENANT_ID_STRING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTenantIdString() {
    return tenantIdString;
  }


  @JsonProperty(JSON_PROPERTY_TENANT_ID_STRING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTenantIdString(String tenantIdString) {
    this.tenantIdString = tenantIdString;
  }


  public ActivityVariable id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * The identifier of the variable
   * @return id
  **/
  @javax.annotation.Nullable
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


  public ActivityVariable idString(String idString) {
    
    this.idString = idString;
    return this;
  }

   /**
   * number (since 7.0.1)
   * @return idString
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ID_STRING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getIdString() {
    return idString;
  }


  @JsonProperty(JSON_PROPERTY_ID_STRING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIdString(String idString) {
    this.idString = idString;
  }


  public ActivityVariable name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * The name of the activity variable
   * @return name
  **/
  @javax.annotation.Nullable
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


  public ActivityVariable description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * The description of the variable if any
   * @return description
  **/
  @javax.annotation.Nullable
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


  public ActivityVariable transientData(String transientData) {
    
    this.transientData = transientData;
    return this;
  }

   /**
   * FALSE
   * @return transientData
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TRANSIENT_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTransientData() {
    return transientData;
  }


  @JsonProperty(JSON_PROPERTY_TRANSIENT_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTransientData(String transientData) {
    this.transientData = transientData;
  }


  public ActivityVariable className(String className) {
    
    this.className = className;
    return this;
  }

   /**
   * The fully qualified class name of the variable type
   * @return className
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CLASS_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getClassName() {
    return className;
  }


  @JsonProperty(JSON_PROPERTY_CLASS_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setClassName(String className) {
    this.className = className;
  }


  public ActivityVariable containerId(String containerId) {
    
    this.containerId = containerId;
    return this;
  }

   /**
   * The ID of the activity containing this variable (same as the one passed as parameter) if the variable is defined at activity level or ID of the process instance if the variable is defined on the process
   * @return containerId
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CONTAINER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getContainerId() {
    return containerId;
  }


  @JsonProperty(JSON_PROPERTY_CONTAINER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setContainerId(String containerId) {
    this.containerId = containerId;
  }


  public ActivityVariable containerIdString(String containerIdString) {
    
    this.containerIdString = containerIdString;
    return this;
  }

   /**
   * number (since 7.0.1)
   * @return containerIdString
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CONTAINER_ID_STRING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getContainerIdString() {
    return containerIdString;
  }


  @JsonProperty(JSON_PROPERTY_CONTAINER_ID_STRING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setContainerIdString(String containerIdString) {
    this.containerIdString = containerIdString;
  }


  public ActivityVariable containerType(ContainerTypeEnum containerType) {
    
    this.containerType = containerType;
    return this;
  }

   /**
   * ACTIVITY_INSTANCE | PROCESS_INSTANCE depending on whether the variable is defined at activity or process level.
   * @return containerType
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CONTAINER_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ContainerTypeEnum getContainerType() {
    return containerType;
  }


  @JsonProperty(JSON_PROPERTY_CONTAINER_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setContainerType(ContainerTypeEnum containerType) {
    this.containerType = containerType;
  }


  public ActivityVariable value(String value) {
    
    this.value = value;
    return this;
  }

   /**
   * the value of this variable. The format of the value depends on the type of the variable
   * @return value
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getValue() {
    return value;
  }


  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActivityVariable activityVariable = (ActivityVariable) o;
    return Objects.equals(this.tenantId, activityVariable.tenantId) &&
        Objects.equals(this.tenantIdString, activityVariable.tenantIdString) &&
        Objects.equals(this.id, activityVariable.id) &&
        Objects.equals(this.idString, activityVariable.idString) &&
        Objects.equals(this.name, activityVariable.name) &&
        Objects.equals(this.description, activityVariable.description) &&
        Objects.equals(this.transientData, activityVariable.transientData) &&
        Objects.equals(this.className, activityVariable.className) &&
        Objects.equals(this.containerId, activityVariable.containerId) &&
        Objects.equals(this.containerIdString, activityVariable.containerIdString) &&
        Objects.equals(this.containerType, activityVariable.containerType) &&
        Objects.equals(this.value, activityVariable.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tenantId, tenantIdString, id, idString, name, description, transientData, className, containerId, containerIdString, containerType, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActivityVariable {\n");
    sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
    sb.append("    tenantIdString: ").append(toIndentedString(tenantIdString)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idString: ").append(toIndentedString(idString)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    transientData: ").append(toIndentedString(transientData)).append("\n");
    sb.append("    className: ").append(toIndentedString(className)).append("\n");
    sb.append("    containerId: ").append(toIndentedString(containerId)).append("\n");
    sb.append("    containerIdString: ").append(toIndentedString(containerIdString)).append("\n");
    sb.append("    containerType: ").append(toIndentedString(containerType)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

