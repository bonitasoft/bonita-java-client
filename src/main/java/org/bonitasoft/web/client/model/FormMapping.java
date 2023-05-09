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
 * Form Mapping specifies the mapping of a form to a process or a task. The mapping indicates the technology used to create the form, in the &#x60;target&#x60; attribute.
 */
@JsonPropertyOrder({
  FormMapping.JSON_PROPERTY_ID,
  FormMapping.JSON_PROPERTY_PROCESS_DEFINITION_ID,
  FormMapping.JSON_PROPERTY_TYPE,
  FormMapping.JSON_PROPERTY_TARGET,
  FormMapping.JSON_PROPERTY_TASK,
  FormMapping.JSON_PROPERTY_PAGE_ID,
  FormMapping.JSON_PROPERTY_PAGE_MAPPING_KEY,
  FormMapping.JSON_PROPERTY_LAST_UPDATE_BY,
  FormMapping.JSON_PROPERTY_LAST_UPDATE_DATE,
  FormMapping.JSON_PROPERTY_URL
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class FormMapping implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_PROCESS_DEFINITION_ID = "processDefinitionId";
  private String processDefinitionId;

  /**
   * the form mapping type
   */
  public enum TypeEnum {
    PROCESSSTART("PROCESSSTART"),
    
    PROCESSOVERVIEW("PROCESSOVERVIEW"),
    
    TASK("TASK");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  private TypeEnum type;

  /**
   * the target
   */
  public enum TargetEnum {
    URL("URL"),
    
    INTERNAL("INTERNAL"),
    
    LEGACY("LEGACY"),
    
    UNDEFINED("UNDEFINED"),
    
    NONE("NONE");

    private String value;

    TargetEnum(String value) {
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
    public static TargetEnum fromValue(String value) {
      for (TargetEnum b : TargetEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_TARGET = "target";
  private TargetEnum target;

  public static final String JSON_PROPERTY_TASK = "task";
  private String task;

  public static final String JSON_PROPERTY_PAGE_ID = "pageId";
  private String pageId;

  public static final String JSON_PROPERTY_PAGE_MAPPING_KEY = "pageMappingKey";
  private String pageMappingKey;

  public static final String JSON_PROPERTY_LAST_UPDATE_BY = "lastUpdateBy";
  private String lastUpdateBy;

  public static final String JSON_PROPERTY_LAST_UPDATE_DATE = "lastUpdateDate";
  private String lastUpdateDate;

  public static final String JSON_PROPERTY_URL = "url";
  private String url;

  public FormMapping() {
  }

  public FormMapping id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * the form mapping identifier
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


  public FormMapping processDefinitionId(String processDefinitionId) {
    
    this.processDefinitionId = processDefinitionId;
    return this;
  }

   /**
   * the process identifier related to this form mapping
   * @return processDefinitionId
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PROCESS_DEFINITION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getProcessDefinitionId() {
    return processDefinitionId;
  }


  @JsonProperty(JSON_PROPERTY_PROCESS_DEFINITION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProcessDefinitionId(String processDefinitionId) {
    this.processDefinitionId = processDefinitionId;
  }


  public FormMapping type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * the form mapping type
   * @return type
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TypeEnum getType() {
    return type;
  }


  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(TypeEnum type) {
    this.type = type;
  }


  public FormMapping target(TargetEnum target) {
    
    this.target = target;
    return this;
  }

   /**
   * the target
   * @return target
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TARGET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TargetEnum getTarget() {
    return target;
  }


  @JsonProperty(JSON_PROPERTY_TARGET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTarget(TargetEnum target) {
    this.target = target;
  }


  public FormMapping task(String task) {
    
    this.task = task;
    return this;
  }

   /**
   * the task name when type is TASK - null otherwise
   * @return task
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TASK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTask() {
    return task;
  }


  @JsonProperty(JSON_PROPERTY_TASK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTask(String task) {
    this.task = task;
  }


  public FormMapping pageId(String pageId) {
    
    this.pageId = pageId;
    return this;
  }

   /**
   * the custom page identifier when type is INTERNAL - null otherwise
   * @return pageId
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PAGE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPageId() {
    return pageId;
  }


  @JsonProperty(JSON_PROPERTY_PAGE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPageId(String pageId) {
    this.pageId = pageId;
  }


  public FormMapping pageMappingKey(String pageMappingKey) {
    
    this.pageMappingKey = pageMappingKey;
    return this;
  }

   /**
   * the page mapping key part used to generate the form URL
   * @return pageMappingKey
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PAGE_MAPPING_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPageMappingKey() {
    return pageMappingKey;
  }


  @JsonProperty(JSON_PROPERTY_PAGE_MAPPING_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPageMappingKey(String pageMappingKey) {
    this.pageMappingKey = pageMappingKey;
  }


  public FormMapping lastUpdateBy(String lastUpdateBy) {
    
    this.lastUpdateBy = lastUpdateBy;
    return this;
  }

   /**
   * the identifier of the user who last updated this form mapping - 0 if no update has been done yet
   * @return lastUpdateBy
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LAST_UPDATE_BY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLastUpdateBy() {
    return lastUpdateBy;
  }


  @JsonProperty(JSON_PROPERTY_LAST_UPDATE_BY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLastUpdateBy(String lastUpdateBy) {
    this.lastUpdateBy = lastUpdateBy;
  }


  public FormMapping lastUpdateDate(String lastUpdateDate) {
    
    this.lastUpdateDate = lastUpdateDate;
    return this;
  }

   /**
   * the last update date in milliseconds - null if no update has been done yet
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


  public FormMapping url(String url) {
    
    this.url = url;
    return this;
  }

   /**
   * the external URL (string) when type is URL - null otherwise
   * @return url
  **/
  @jakarta.annotation.Nullable
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FormMapping formMapping = (FormMapping) o;
    return Objects.equals(this.id, formMapping.id) &&
        Objects.equals(this.processDefinitionId, formMapping.processDefinitionId) &&
        Objects.equals(this.type, formMapping.type) &&
        Objects.equals(this.target, formMapping.target) &&
        Objects.equals(this.task, formMapping.task) &&
        Objects.equals(this.pageId, formMapping.pageId) &&
        Objects.equals(this.pageMappingKey, formMapping.pageMappingKey) &&
        Objects.equals(this.lastUpdateBy, formMapping.lastUpdateBy) &&
        Objects.equals(this.lastUpdateDate, formMapping.lastUpdateDate) &&
        Objects.equals(this.url, formMapping.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, processDefinitionId, type, target, task, pageId, pageMappingKey, lastUpdateBy, lastUpdateDate, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormMapping {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    processDefinitionId: ").append(toIndentedString(processDefinitionId)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    task: ").append(toIndentedString(task)).append("\n");
    sb.append("    pageId: ").append(toIndentedString(pageId)).append("\n");
    sb.append("    pageMappingKey: ").append(toIndentedString(pageMappingKey)).append("\n");
    sb.append("    lastUpdateBy: ").append(toIndentedString(lastUpdateBy)).append("\n");
    sb.append("    lastUpdateDate: ").append(toIndentedString(lastUpdateDate)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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

