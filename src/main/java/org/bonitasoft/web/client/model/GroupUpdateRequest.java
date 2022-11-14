/*
 * Bonita HTTP API
 *  The REST API lets you access the data with HTTP requests; it is useful when implementing rich web forms / pages for a good user experience.  If your application is using a technology other than Java, you can integrate it with the Bonita solution using the Web REST API. This API provides access to all Bonita objects (like processes, tasks, users, connectors etc.), to execute operations on them (create, retrieve, update, delete). You can use these operations to create a workflow with Bonita and integrate it into your application. The Bonita Engine remains responsible for executing the workflow logic (connectors, gateways with conditions, messages, timers etc.) while your application gives access to the workflow. Users can manage processes and tasks, and perform administrative activities.  ![diagram of architecture of a REST client integrated with Bonita](images/rest_overview_v2.png)  ### API Extensions  You can create [Rest API Extensions](rest-api-extensions.md) to extend the Rest API by adding missing ressources (not provided by the Rest API). It is possible for an extension to interact with the engine (via the API) or with any other external service (for example a database, a directory, or a web service).  ### Create a resource  | Request URL | `http://.../API/{API_name}/{resource_name}/  `| |:-|:-| | Request Method | POST| | Request Payload | an item in JSON| | Response | the same item in JSON, containing the values provided in the posted item, completed with default values and identifiers provided by Bonita Engine.|  ### Read a resource  | Request URL | `http://.../API/{API_name}/{resource_name}/{id} `| |:-|:-| | Request Method | GET| | Response | an item in JSON|  Example `http://.../API/identity/user/5 `  #### Extend resource response  On some resources, in GET methods the `d` (deploy) URL query parameter can be used to extend the response objects. The value of this parameter consists of an attribute for which you want to make an extended request (called a deploy) and retrieve attributes of a linked resource. This means that instead of retrieving the ID or a parent or referenced resource, you can retrieve the full object.  For example, when you retrieve a task, you can also retrieve the process definition attributes in addition to the process definition ID that is already part of the task resource. The supported deploy values for a task include its process (d=processId).  Specifiy multiple `d` parameter to extend several resources. For instance, to retrieve the flow node of id 143 and the associated process, process instance and assigned user, call `/API/bpm/flowNode/143?d=processId&d=caseId&d=assigned_id`  #### With compound identifier  The order of the identifier parts for each resource type is given in the table above.  | Request URL | `http://.../API/{API_name}/{resource_name}/{id_part1}/{id_part2} `| |:-|:-| | Request Method | GET| | Response | an item in JSON|  Example `http://.../API/identity/membership/5/12/24 `  ### Update a resource  | Request URL | `http://.../API/{API_name}/{resource_name}/{id} `| |:-|:-| | Request Method | PUT| | Request Payload | a map in JSON containing the new values for the attributes you want to change.| | Response | the corresponding item in JSON with new values where you requested a modification|  Example `http://.../API/identity/user/5`  #### With compound identifier:  Response: the corresponding item in JSON with new values where you requested a modification.  | Request URL | `http://.../API/{API_name}/{resource_name}/{id_part1}/{id_part2} `| |:-|:-| | Request Method | PUT| | Request Payload | ` a map in JSON containing the new values for the attributes you want to change `| | Response | ` the corresponding item in JSON with new values where you requested a modification`|  Example `http://.../API/identity/membership/5/12/24 `  ### Delete resources  Use the DELETE request to remove multiple resources.  | Request URL | `http://.../API/{API_name}/{resource_name}/ `| |:-|:-| | Request Method | DELETE| | Request Payload | A list of identifiers in JSON, for example `[\"id1\",\"id2\",\"id3\"]`. Compound identifiers are separated by '/' characters.| | Response | `empty `|  Example `http://.../API/identity/membership/ `  ### Search for a resource  The required object is specified with a set of filters in the request URL. The URL parameters must be URL-encoded.  Results are returned in a paged list, so you have to specify the page (counting from zero), and the number of results per page (count), additionally you can define a sort key (order). You can see the total number of matching results in the HTTP response header Content-Range. If you are searching for business data using a custom query, there must be a [count query in the BDM](define-and-deploy-the-bdm.md). If there is no count query, results from a custom query on business data cannot be paged properly (the header Content-Range will be absent). For business data default queries, the count query is defined automatically.  The available filters are the attributes of the item plus some specific filters defined by each item.  | Request URL | `http://.../API/{API_name}/{resource_name}?p={page}&c={count}&o={order}&s={query}&f={filter_name}={filter_value}&f=... `| |:-|:-| | Request Method | GET| | Response | an array of items in JSON|  Example `/API/identity/user?p=0&c=10&o=firstname&s=test&f=manager_id=3`  For a GET method that retrieves more than one instance of a resource, you can specify the following request parameters:  * p (Mandatory): index of the page to display * c (Mandatory): maximum number of elements to retrieve * o: order of presentation of values in response: must be either `attributeName ASC` or `attributeName DESC`. The final order parameter value must be URL encoded. * f: list of filters, specified as `attributeName=attributeValue`. To filter on more than one attribute, specify an f parameters for each attribute. The final filter parameter value must be URL encoded.   The attributes you can filter on are specific to the resource. * s: search on name or search indexes. The matching policy depends on the configuration of [word-based search](using-list-and-search-methods.md).   For example, if word-based search is enabled, `s=Valid` returns matches containing the string \"valid\" at the start of any word in the attribute value word,   such as \"Valid address\", \"Not a valid address\", and \"Validated request\" but not \"Invalid request\".   If word-based search is disabled, `s=Valid` returns matches containing the string \"valid\" at the start of the attribute value, such as \"Valid address\" or \"Validated request\" but not \"Not a valid address\" or \"Invalid request\".  ### Errors  The API uses standard HTTP status codes to indicate the success or failure of the API call.  If you get a `401` response code :   - make sure that the cookies have been transfered with the call   - make sure that the cookies transfered are the ones generated during the last sucessfull login call   - if one of the PUT, DELETE or POST method is used, make sure that the `X-Bonita-API-Token` header is included   - if the X-Bonita-API-Token header is included, make sure that the value is the same as the one of the cookie generated during the last login   - Maybe a logout was issued or the session has expired; try to log in again, and re run the request with the new cookies and the new value for the `X-Bonita-API-Token` header.
 *
 * The version of the OpenAPI document: 0.0.10
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
import io.swagger.annotations.ApiModelProperty;

/**
 * GroupUpdateRequest
 */
@JsonPropertyOrder({
		GroupUpdateRequest.JSON_PROPERTY_NAME,
		GroupUpdateRequest.JSON_PROPERTY_DISPLAY_NAME,
		GroupUpdateRequest.JSON_PROPERTY_PARENT_PATH,
		GroupUpdateRequest.JSON_PROPERTY_PATH,
		GroupUpdateRequest.JSON_PROPERTY_DESCRIPTION,
		GroupUpdateRequest.JSON_PROPERTY_CREATION_DATE,
		GroupUpdateRequest.JSON_PROPERTY_CREATED_BY_USER_ID,
		GroupUpdateRequest.JSON_PROPERTY_LAST_UPDATE_DATE,
		GroupUpdateRequest.JSON_PROPERTY_ICON
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class GroupUpdateRequest implements Serializable {
	public static final String JSON_PROPERTY_NAME = "name";

	public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";

	public static final String JSON_PROPERTY_PARENT_PATH = "parent_path";

	public static final String JSON_PROPERTY_PATH = "path";

	public static final String JSON_PROPERTY_DESCRIPTION = "description";

	public static final String JSON_PROPERTY_CREATION_DATE = "creation_date";

	public static final String JSON_PROPERTY_CREATED_BY_USER_ID = "created_by_user_id";

	public static final String JSON_PROPERTY_LAST_UPDATE_DATE = "last_update_date";

	public static final String JSON_PROPERTY_ICON = "icon";

	private static final long serialVersionUID = 1L;

	private String name;

	private String displayName;

	private String parentPath;

	private String path;

	private String description;

	private String creationDate;

	private String createdByUserId;

	private String lastUpdateDate;

	private String icon;

	public GroupUpdateRequest() {
	}

	public GroupUpdateRequest name(String name) {

		this.name = name;
		return this;
	}

	/**
	 * name
	 * @return name
	 **/
	@javax.annotation.Nonnull
	@ApiModelProperty(required = true, value = "name")
	@JsonProperty(JSON_PROPERTY_NAME)
	@JsonInclude(value = JsonInclude.Include.ALWAYS)

	public String getName() {
		return name;
	}


	@JsonProperty(JSON_PROPERTY_NAME)
	@JsonInclude(value = JsonInclude.Include.ALWAYS)
	public void setName(String name) {
		this.name = name;
	}


	public GroupUpdateRequest displayName(String displayName) {

		this.displayName = displayName;
		return this;
	}

	/**
	 * display name
	 * @return displayName
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "display name")
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


	public GroupUpdateRequest parentPath(String parentPath) {

		this.parentPath = parentPath;
		return this;
	}

	/**
	 * the path of the parent group of this group (empty if the group has no parent)
	 * @return parentPath
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "the path of the parent group of this group (empty if the group has no parent)")
	@JsonProperty(JSON_PROPERTY_PARENT_PATH)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

	public String getParentPath() {
		return parentPath;
	}


	@JsonProperty(JSON_PROPERTY_PARENT_PATH)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public void setParentPath(String parentPath) {
		this.parentPath = parentPath;
	}


	public GroupUpdateRequest path(String path) {

		this.path = path;
		return this;
	}

	/**
	 * the full path of the group (including its parent path)
	 * @return path
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "the full path of the group (including its parent path)")
	@JsonProperty(JSON_PROPERTY_PATH)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

	public String getPath() {
		return path;
	}


	@JsonProperty(JSON_PROPERTY_PATH)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public void setPath(String path) {
		this.path = path;
	}


	public GroupUpdateRequest description(String description) {

		this.description = description;
		return this;
	}

	/**
	 * description
	 * @return description
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "description")
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


	public GroupUpdateRequest creationDate(String creationDate) {

		this.creationDate = creationDate;
		return this;
	}

	/**
	 * creation date (format: &#x60;2014-12-31 15:17:24.736&#x60;)
	 * @return creationDate
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "creation date (format: `2014-12-31 15:17:24.736`)")
	@JsonProperty(JSON_PROPERTY_CREATION_DATE)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

	public String getCreationDate() {
		return creationDate;
	}


	@JsonProperty(JSON_PROPERTY_CREATION_DATE)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}


	public GroupUpdateRequest createdByUserId(String createdByUserId) {

		this.createdByUserId = createdByUserId;
		return this;
	}

	/**
	 * id of the user who created the group (-1 if the group was created by the tenant admin or by an organisation import)
	 * @return createdByUserId
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "id of the user who created the group (-1 if the group was created by the tenant admin or by an organisation import)")
	@JsonProperty(JSON_PROPERTY_CREATED_BY_USER_ID)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

	public String getCreatedByUserId() {
		return createdByUserId;
	}


	@JsonProperty(JSON_PROPERTY_CREATED_BY_USER_ID)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public void setCreatedByUserId(String createdByUserId) {
		this.createdByUserId = createdByUserId;
	}


	public GroupUpdateRequest lastUpdateDate(String lastUpdateDate) {

		this.lastUpdateDate = lastUpdateDate;
		return this;
	}

	/**
	 * last update date (format: &#x60;2014-12-31 15:17:24.736&#x60;)
	 * @return lastUpdateDate
	 **/
	@javax.annotation.Nullable
	@ApiModelProperty(value = "last update date (format: `2014-12-31 15:17:24.736`)")
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


	public GroupUpdateRequest icon(String icon) {

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


	@JsonProperty(JSON_PROPERTY_ICON)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public void setIcon(String icon) {
		this.icon = icon;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GroupUpdateRequest groupUpdateRequest = (GroupUpdateRequest) o;
		return Objects.equals(this.name, groupUpdateRequest.name) &&
				Objects.equals(this.displayName, groupUpdateRequest.displayName) &&
				Objects.equals(this.parentPath, groupUpdateRequest.parentPath) &&
				Objects.equals(this.path, groupUpdateRequest.path) &&
				Objects.equals(this.description, groupUpdateRequest.description) &&
				Objects.equals(this.creationDate, groupUpdateRequest.creationDate) &&
				Objects.equals(this.createdByUserId, groupUpdateRequest.createdByUserId) &&
				Objects.equals(this.lastUpdateDate, groupUpdateRequest.lastUpdateDate) &&
				Objects.equals(this.icon, groupUpdateRequest.icon);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, displayName, parentPath, path, description, creationDate, createdByUserId, lastUpdateDate, icon);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GroupUpdateRequest {\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
		sb.append("    parentPath: ").append(toIndentedString(parentPath)).append("\n");
		sb.append("    path: ").append(toIndentedString(path)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
		sb.append("    createdByUserId: ").append(toIndentedString(createdByUserId)).append("\n");
		sb.append("    lastUpdateDate: ").append(toIndentedString(lastUpdateDate)).append("\n");
		sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
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

