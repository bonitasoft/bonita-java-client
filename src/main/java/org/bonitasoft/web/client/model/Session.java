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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Objects;

/** Session */
@JsonPropertyOrder({ Session.JSON_PROPERTY_USER_ID, Session.JSON_PROPERTY_USER_NAME, Session.JSON_PROPERTY_SESSION_ID,
		Session.JSON_PROPERTY_CONF, Session.JSON_PROPERTY_IS_TECHNICAL_USER, Session.JSON_PROPERTY_IS_GUEST_USER,
		Session.JSON_PROPERTY_VERSION, Session.JSON_PROPERTY_COPYRIGHT })
@JsonTypeName("Session")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Session implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String JSON_PROPERTY_USER_ID = "user_id";

	private String userId;

	public static final String JSON_PROPERTY_USER_NAME = "user_name";

	private String userName;

	public static final String JSON_PROPERTY_SESSION_ID = "session_id";

	private String sessionId;

	public static final String JSON_PROPERTY_CONF = "conf";

	private String conf;

	public static final String JSON_PROPERTY_IS_TECHNICAL_USER = "is_technical_user";

	private Boolean isTechnicalUser;

	public static final String JSON_PROPERTY_IS_GUEST_USER = "is_guest_user";

	private Boolean isGuestUser;

	public static final String JSON_PROPERTY_VERSION = "version";

	private String version;

	public static final String JSON_PROPERTY_COPYRIGHT = "copyright";

	private String copyright;

	public Session userId(String userId) {

		this.userId = userId;
		return this;
	}

	/**
	 * user id
	 * @return userId
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "user id")
	@JsonProperty(JSON_PROPERTY_USER_ID)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Session userName(String userName) {

		this.userName = userName;
		return this;
	}

	/**
	 * user name
	 * @return userName
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "user name")
	@JsonProperty(JSON_PROPERTY_USER_NAME)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Session sessionId(String sessionId) {

		this.sessionId = sessionId;
		return this;
	}

	/**
	 * the session id
	 * @return sessionId
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "the session id")
	@JsonProperty(JSON_PROPERTY_SESSION_ID)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Session conf(String conf) {

		this.conf = conf;
		return this;
	}

	/**
	 * conf
	 * @return conf
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "conf")
	@JsonProperty(JSON_PROPERTY_CONF)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getConf() {
		return conf;
	}

	public void setConf(String conf) {
		this.conf = conf;
	}

	public Session isTechnicalUser(Boolean isTechnicalUser) {

		this.isTechnicalUser = isTechnicalUser;
		return this;
	}

	/**
	 * is technical user: true|false
	 * @return isTechnicalUser
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "is technical user: true|false")
	@JsonProperty(JSON_PROPERTY_IS_TECHNICAL_USER)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public Boolean getIsTechnicalUser() {
		return isTechnicalUser;
	}

	public void setIsTechnicalUser(Boolean isTechnicalUser) {
		this.isTechnicalUser = isTechnicalUser;
	}

	public Session isGuestUser(Boolean isGuestUser) {

		this.isGuestUser = isGuestUser;
		return this;
	}

	/**
	 * is technical user: true|false
	 * @return isGuestUser
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "is technical user: true|false")
	@JsonProperty(JSON_PROPERTY_IS_GUEST_USER)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public Boolean getIsGuestUser() {
		return isGuestUser;
	}

	public void setIsGuestUser(Boolean isGuestUser) {
		this.isGuestUser = isGuestUser;
	}

	public Session version(String version) {

		this.version = version;
		return this;
	}

	/**
	 * bonita version
	 * @return version
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "bonita version")
	@JsonProperty(JSON_PROPERTY_VERSION)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Session copyright(String copyright) {

		this.copyright = copyright;
		return this;
	}

	/**
	 * bonita copyright
	 * @return copyright
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "bonita copyright")
	@JsonProperty(JSON_PROPERTY_COPYRIGHT)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Session session = (Session) o;
		return Objects.equals(this.userId, session.userId) && Objects.equals(this.userName, session.userName)
				&& Objects.equals(this.sessionId, session.sessionId) && Objects.equals(this.conf, session.conf)
				&& Objects.equals(this.isTechnicalUser, session.isTechnicalUser)
				&& Objects.equals(this.isGuestUser, session.isGuestUser)
				&& Objects.equals(this.version, session.version) && Objects.equals(this.copyright, session.copyright);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, userName, sessionId, conf, isTechnicalUser, isGuestUser, version, copyright);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Session {\n");
		sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
		sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
		sb.append("    sessionId: ").append(toIndentedString(sessionId)).append("\n");
		sb.append("    conf: ").append(toIndentedString(conf)).append("\n");
		sb.append("    isTechnicalUser: ").append(toIndentedString(isTechnicalUser)).append("\n");
		sb.append("    isGuestUser: ").append(toIndentedString(isGuestUser)).append("\n");
		sb.append("    version: ").append(toIndentedString(version)).append("\n");
		sb.append("    copyright: ").append(toIndentedString(copyright)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces (except the
	 * first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

}
