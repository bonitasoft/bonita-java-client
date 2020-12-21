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

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ProcessInstance (Case) is an instance of a process. When you start a process, it
 * creates a process instances.
 */
@ApiModel(
		description = "ProcessInstance (Case) is an instance of a process. When you start a process, it creates a process instances.")
@JsonPropertyOrder({ ProcessInstance.JSON_PROPERTY_ID, ProcessInstance.JSON_PROPERTY_END_DATE,
		ProcessInstance.JSON_PROPERTY_FAILED_FLOW_NODES, ProcessInstance.JSON_PROPERTY_STARTED_BY_SUBSTITUTE,
		ProcessInstance.JSON_PROPERTY_START, ProcessInstance.JSON_PROPERTY_ACTIVE_FLOW_NODES,
		ProcessInstance.JSON_PROPERTY_STATE, ProcessInstance.JSON_PROPERTY_ROOT_CASE_ID,
		ProcessInstance.JSON_PROPERTY_STARTED_BY, ProcessInstance.JSON_PROPERTY_PROCESS_DEFINITION_ID,
		ProcessInstance.JSON_PROPERTY_LAST_UPDATE_DATE, ProcessInstance.JSON_PROPERTY_SEARCH_INDEX1_LABEL,
		ProcessInstance.JSON_PROPERTY_SEARCH_INDEX2_LABEL, ProcessInstance.JSON_PROPERTY_SEARCH_INDEX3_LABEL,
		ProcessInstance.JSON_PROPERTY_SEARCH_INDEX4_LABEL, ProcessInstance.JSON_PROPERTY_SEARCH_INDEX5_LABEL,
		ProcessInstance.JSON_PROPERTY_SEARCH_INDEX1_VALUE, ProcessInstance.JSON_PROPERTY_SEARCH_INDEX2_VALUE,
		ProcessInstance.JSON_PROPERTY_SEARCH_INDEX3_VALUE, ProcessInstance.JSON_PROPERTY_SEARCH_INDEX4_VALUE,
		ProcessInstance.JSON_PROPERTY_SEARCH_INDEX5_VALUE })
@JsonTypeName("ProcessInstance")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ProcessInstance implements Serializable {

	public static final String JSON_PROPERTY_ID = "id";

	public static final String JSON_PROPERTY_END_DATE = "end_date";

	public static final String JSON_PROPERTY_FAILED_FLOW_NODES = "failedFlowNodes";

	public static final String JSON_PROPERTY_STARTED_BY_SUBSTITUTE = "startedBySubstitute";

	public static final String JSON_PROPERTY_START = "start";

	public static final String JSON_PROPERTY_ACTIVE_FLOW_NODES = "activeFlowNodes";

	public static final String JSON_PROPERTY_STATE = "state";

	public static final String JSON_PROPERTY_ROOT_CASE_ID = "rootCaseId";

	public static final String JSON_PROPERTY_STARTED_BY = "started_by";

	public static final String JSON_PROPERTY_PROCESS_DEFINITION_ID = "processDefinitionId";

	public static final String JSON_PROPERTY_LAST_UPDATE_DATE = "last_update_date";

	public static final String JSON_PROPERTY_SEARCH_INDEX1_LABEL = "searchIndex1Label";

	public static final String JSON_PROPERTY_SEARCH_INDEX2_LABEL = "searchIndex2Label";

	public static final String JSON_PROPERTY_SEARCH_INDEX3_LABEL = "searchIndex3Label";

	public static final String JSON_PROPERTY_SEARCH_INDEX4_LABEL = "searchIndex4Label";

	public static final String JSON_PROPERTY_SEARCH_INDEX5_LABEL = "searchIndex5Label";

	public static final String JSON_PROPERTY_SEARCH_INDEX1_VALUE = "searchIndex1Value";

	public static final String JSON_PROPERTY_SEARCH_INDEX2_VALUE = "searchIndex2Value";

	public static final String JSON_PROPERTY_SEARCH_INDEX3_VALUE = "searchIndex3Value";

	public static final String JSON_PROPERTY_SEARCH_INDEX4_VALUE = "searchIndex4Value";

	public static final String JSON_PROPERTY_SEARCH_INDEX5_VALUE = "searchIndex5Value";

	private static final long serialVersionUID = 1L;

	private String id;

	private String endDate;

	private String failedFlowNodes;

	private String startedBySubstitute;

	private String start;

	private String activeFlowNodes;

	private String state;

	private String rootCaseId;

	private String startedBy;

	private String processDefinitionId;

	private String lastUpdateDate;

	private String searchIndex1Label;

	private String searchIndex2Label;

	private String searchIndex3Label;

	private String searchIndex4Label;

	private String searchIndex5Label;

	private String searchIndex1Value;

	private String searchIndex2Value;

	private String searchIndex3Value;

	private String searchIndex4Value;

	private String searchIndex5Value;

	public ProcessInstance id(String id) {

		this.id = id;
		return this;
	}

	/**
	 * the identifier of the ProcessInstance (Case)
	 * @return id
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "the identifier of the ProcessInstance (Case)")
	@JsonProperty(JSON_PROPERTY_ID)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ProcessInstance endDate(String endDate) {

		this.endDate = endDate;
		return this;
	}

	/**
	 * the date set when the process instance is closed
	 * @return endDate
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "the date set when the process instance is closed")
	@JsonProperty(JSON_PROPERTY_END_DATE)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public ProcessInstance failedFlowNodes(String failedFlowNodes) {

		this.failedFlowNodes = failedFlowNodes;
		return this;
	}

	/**
	 * count of failed flow nodes if parameter n&#x3D;failedFlowNodes is given
	 * @return failedFlowNodes
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "count of failed flow nodes if parameter n=failedFlowNodes is given")
	@JsonProperty(JSON_PROPERTY_FAILED_FLOW_NODES)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getFailedFlowNodes() {
		return failedFlowNodes;
	}

	public void setFailedFlowNodes(String failedFlowNodes) {
		this.failedFlowNodes = failedFlowNodes;
	}

	public ProcessInstance startedBySubstitute(String startedBySubstitute) {

		this.startedBySubstitute = startedBySubstitute;
		return this;
	}

	/**
	 * the identifier of the substitute user (as Process manager or Administrator) who
	 * started the process. It can be also the substitute user if
	 * d&#x3D;startedBySubstitute is given.
	 * @return startedBySubstitute
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(
			value = "the identifier of the substitute user (as Process manager or Administrator) who started the process. It can be also the substitute user if d=startedBySubstitute is given.")
	@JsonProperty(JSON_PROPERTY_STARTED_BY_SUBSTITUTE)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getStartedBySubstitute() {
		return startedBySubstitute;
	}

	public void setStartedBySubstitute(String startedBySubstitute) {
		this.startedBySubstitute = startedBySubstitute;
	}

	public ProcessInstance start(String start) {

		this.start = start;
		return this;
	}

	/**
	 * the starting date of the case
	 * @return start
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "the starting date of the case")
	@JsonProperty(JSON_PROPERTY_START)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public ProcessInstance activeFlowNodes(String activeFlowNodes) {

		this.activeFlowNodes = activeFlowNodes;
		return this;
	}

	/**
	 * count of active flow nodes if parameter n&#x3D;activeFlowNodes is given
	 * @return activeFlowNodes
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "count of active flow nodes if parameter n=activeFlowNodes is given")
	@JsonProperty(JSON_PROPERTY_ACTIVE_FLOW_NODES)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getActiveFlowNodes() {
		return activeFlowNodes;
	}

	public void setActiveFlowNodes(String activeFlowNodes) {
		this.activeFlowNodes = activeFlowNodes;
	}

	public ProcessInstance state(String state) {

		this.state = state;
		return this;
	}

	/**
	 * state: an enum that represent the state of the process instances, it can be
	 * INITIALIZING, STARTED, SUSPENDED, CANCELLED, ABORTED, COMPLETING, COMPLETED, ERROR,
	 * ABORTING
	 * @return state
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(
			value = "state: an enum that represent the state of the process instances, it can be INITIALIZING, STARTED, SUSPENDED, CANCELLED, ABORTED, COMPLETING, COMPLETED, ERROR, ABORTING")
	@JsonProperty(JSON_PROPERTY_STATE)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public ProcessInstance rootCaseId(String rootCaseId) {

		this.rootCaseId = rootCaseId;
		return this;
	}

	/**
	 * the identifier of the container of the case
	 * @return rootCaseId
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "the identifier of the container of the case")
	@JsonProperty(JSON_PROPERTY_ROOT_CASE_ID)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getRootCaseId() {
		return rootCaseId;
	}

	public void setRootCaseId(String rootCaseId) {
		this.rootCaseId = rootCaseId;
	}

	public ProcessInstance startedBy(String startedBy) {

		this.startedBy = startedBy;
		return this;
	}

	/**
	 * the identifier of the user who started the case
	 * @return startedBy
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "the identifier of the user who started the case")
	@JsonProperty(JSON_PROPERTY_STARTED_BY)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getStartedBy() {
		return startedBy;
	}

	public void setStartedBy(String startedBy) {
		this.startedBy = startedBy;
	}

	public ProcessInstance processDefinitionId(String processDefinitionId) {

		this.processDefinitionId = processDefinitionId;
		return this;
	}

	/**
	 * the identifier of the process related of the case
	 * @return processDefinitionId
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "the identifier of the process related of the case")
	@JsonProperty(JSON_PROPERTY_PROCESS_DEFINITION_ID)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getProcessDefinitionId() {
		return processDefinitionId;
	}

	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}

	public ProcessInstance lastUpdateDate(String lastUpdateDate) {

		this.lastUpdateDate = lastUpdateDate;
		return this;
	}

	/**
	 * the date of the last update done on the case
	 * @return lastUpdateDate
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "the date of the last update done on the case")
	@JsonProperty(JSON_PROPERTY_LAST_UPDATE_DATE)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public ProcessInstance searchIndex1Label(String searchIndex1Label) {

		this.searchIndex1Label = searchIndex1Label;
		return this;
	}

	/**
	 * the 1st search index label (from 6.5, in Subscription editions only)
	 * @return searchIndex1Label
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "the 1st search index label (from 6.5, in Subscription editions only)")
	@JsonProperty(JSON_PROPERTY_SEARCH_INDEX1_LABEL)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getSearchIndex1Label() {
		return searchIndex1Label;
	}

	public void setSearchIndex1Label(String searchIndex1Label) {
		this.searchIndex1Label = searchIndex1Label;
	}

	public ProcessInstance searchIndex2Label(String searchIndex2Label) {

		this.searchIndex2Label = searchIndex2Label;
		return this;
	}

	/**
	 * the 2nd search index label (from 6.5, in Subscription editions only)
	 * @return searchIndex2Label
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "the 2nd search index label (from 6.5, in Subscription editions only)")
	@JsonProperty(JSON_PROPERTY_SEARCH_INDEX2_LABEL)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getSearchIndex2Label() {
		return searchIndex2Label;
	}

	public void setSearchIndex2Label(String searchIndex2Label) {
		this.searchIndex2Label = searchIndex2Label;
	}

	public ProcessInstance searchIndex3Label(String searchIndex3Label) {

		this.searchIndex3Label = searchIndex3Label;
		return this;
	}

	/**
	 * the 3rd search index label (from 6.5, in Subscription editions only)
	 * @return searchIndex3Label
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "the 3rd search index label (from 6.5, in Subscription editions only)")
	@JsonProperty(JSON_PROPERTY_SEARCH_INDEX3_LABEL)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getSearchIndex3Label() {
		return searchIndex3Label;
	}

	public void setSearchIndex3Label(String searchIndex3Label) {
		this.searchIndex3Label = searchIndex3Label;
	}

	public ProcessInstance searchIndex4Label(String searchIndex4Label) {

		this.searchIndex4Label = searchIndex4Label;
		return this;
	}

	/**
	 * the 4th search index label (from 6.5, in Subscription editions only)
	 * @return searchIndex4Label
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "the 4th search index label (from 6.5, in Subscription editions only)")
	@JsonProperty(JSON_PROPERTY_SEARCH_INDEX4_LABEL)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getSearchIndex4Label() {
		return searchIndex4Label;
	}

	public void setSearchIndex4Label(String searchIndex4Label) {
		this.searchIndex4Label = searchIndex4Label;
	}

	public ProcessInstance searchIndex5Label(String searchIndex5Label) {

		this.searchIndex5Label = searchIndex5Label;
		return this;
	}

	/**
	 * the 5th search index label (from 6.5, in Subscription editions only)
	 * @return searchIndex5Label
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "the 5th search index label (from 6.5, in Subscription editions only)")
	@JsonProperty(JSON_PROPERTY_SEARCH_INDEX5_LABEL)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getSearchIndex5Label() {
		return searchIndex5Label;
	}

	public void setSearchIndex5Label(String searchIndex5Label) {
		this.searchIndex5Label = searchIndex5Label;
	}

	public ProcessInstance searchIndex1Value(String searchIndex1Value) {

		this.searchIndex1Value = searchIndex1Value;
		return this;
	}

	/**
	 * the 1st search index value (from 6.5, in Subscription editions only)
	 * @return searchIndex1Value
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "the 1st search index value (from 6.5, in Subscription editions only)")
	@JsonProperty(JSON_PROPERTY_SEARCH_INDEX1_VALUE)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getSearchIndex1Value() {
		return searchIndex1Value;
	}

	public void setSearchIndex1Value(String searchIndex1Value) {
		this.searchIndex1Value = searchIndex1Value;
	}

	public ProcessInstance searchIndex2Value(String searchIndex2Value) {

		this.searchIndex2Value = searchIndex2Value;
		return this;
	}

	/**
	 * the 2nd search index value (from 6.5, in Subscription editions only)
	 * @return searchIndex2Value
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "the 2nd search index value (from 6.5, in Subscription editions only)")
	@JsonProperty(JSON_PROPERTY_SEARCH_INDEX2_VALUE)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getSearchIndex2Value() {
		return searchIndex2Value;
	}

	public void setSearchIndex2Value(String searchIndex2Value) {
		this.searchIndex2Value = searchIndex2Value;
	}

	public ProcessInstance searchIndex3Value(String searchIndex3Value) {

		this.searchIndex3Value = searchIndex3Value;
		return this;
	}

	/**
	 * the 3rd search index value (from 6.5, in Subscription editions only)
	 * @return searchIndex3Value
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "the 3rd search index value (from 6.5, in Subscription editions only)")
	@JsonProperty(JSON_PROPERTY_SEARCH_INDEX3_VALUE)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getSearchIndex3Value() {
		return searchIndex3Value;
	}

	public void setSearchIndex3Value(String searchIndex3Value) {
		this.searchIndex3Value = searchIndex3Value;
	}

	public ProcessInstance searchIndex4Value(String searchIndex4Value) {

		this.searchIndex4Value = searchIndex4Value;
		return this;
	}

	/**
	 * the 4th search index value (from 6.5, in Subscription editions only)
	 * @return searchIndex4Value
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "the 4th search index value (from 6.5, in Subscription editions only)")
	@JsonProperty(JSON_PROPERTY_SEARCH_INDEX4_VALUE)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getSearchIndex4Value() {
		return searchIndex4Value;
	}

	public void setSearchIndex4Value(String searchIndex4Value) {
		this.searchIndex4Value = searchIndex4Value;
	}

	public ProcessInstance searchIndex5Value(String searchIndex5Value) {

		this.searchIndex5Value = searchIndex5Value;
		return this;
	}

	/**
	 * the 5th search index value (from 6.5, in Subscription editions only)
	 * @return searchIndex5Value
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "the 5th search index value (from 6.5, in Subscription editions only)")
	@JsonProperty(JSON_PROPERTY_SEARCH_INDEX5_VALUE)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getSearchIndex5Value() {
		return searchIndex5Value;
	}

	public void setSearchIndex5Value(String searchIndex5Value) {
		this.searchIndex5Value = searchIndex5Value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ProcessInstance processInstance = (ProcessInstance) o;
		return Objects.equals(this.id, processInstance.id) && Objects.equals(this.endDate, processInstance.endDate)
				&& Objects.equals(this.failedFlowNodes, processInstance.failedFlowNodes)
				&& Objects.equals(this.startedBySubstitute, processInstance.startedBySubstitute)
				&& Objects.equals(this.start, processInstance.start)
				&& Objects.equals(this.activeFlowNodes, processInstance.activeFlowNodes)
				&& Objects.equals(this.state, processInstance.state)
				&& Objects.equals(this.rootCaseId, processInstance.rootCaseId)
				&& Objects.equals(this.startedBy, processInstance.startedBy)
				&& Objects.equals(this.processDefinitionId, processInstance.processDefinitionId)
				&& Objects.equals(this.lastUpdateDate, processInstance.lastUpdateDate)
				&& Objects.equals(this.searchIndex1Label, processInstance.searchIndex1Label)
				&& Objects.equals(this.searchIndex2Label, processInstance.searchIndex2Label)
				&& Objects.equals(this.searchIndex3Label, processInstance.searchIndex3Label)
				&& Objects.equals(this.searchIndex4Label, processInstance.searchIndex4Label)
				&& Objects.equals(this.searchIndex5Label, processInstance.searchIndex5Label)
				&& Objects.equals(this.searchIndex1Value, processInstance.searchIndex1Value)
				&& Objects.equals(this.searchIndex2Value, processInstance.searchIndex2Value)
				&& Objects.equals(this.searchIndex3Value, processInstance.searchIndex3Value)
				&& Objects.equals(this.searchIndex4Value, processInstance.searchIndex4Value)
				&& Objects.equals(this.searchIndex5Value, processInstance.searchIndex5Value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, endDate, failedFlowNodes, startedBySubstitute, start, activeFlowNodes, state,
				rootCaseId, startedBy, processDefinitionId, lastUpdateDate, searchIndex1Label, searchIndex2Label,
				searchIndex3Label, searchIndex4Label, searchIndex5Label, searchIndex1Value, searchIndex2Value,
				searchIndex3Value, searchIndex4Value, searchIndex5Value);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ProcessInstance {\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
		sb.append("    failedFlowNodes: ").append(toIndentedString(failedFlowNodes)).append("\n");
		sb.append("    startedBySubstitute: ").append(toIndentedString(startedBySubstitute)).append("\n");
		sb.append("    start: ").append(toIndentedString(start)).append("\n");
		sb.append("    activeFlowNodes: ").append(toIndentedString(activeFlowNodes)).append("\n");
		sb.append("    state: ").append(toIndentedString(state)).append("\n");
		sb.append("    rootCaseId: ").append(toIndentedString(rootCaseId)).append("\n");
		sb.append("    startedBy: ").append(toIndentedString(startedBy)).append("\n");
		sb.append("    processDefinitionId: ").append(toIndentedString(processDefinitionId)).append("\n");
		sb.append("    lastUpdateDate: ").append(toIndentedString(lastUpdateDate)).append("\n");
		sb.append("    searchIndex1Label: ").append(toIndentedString(searchIndex1Label)).append("\n");
		sb.append("    searchIndex2Label: ").append(toIndentedString(searchIndex2Label)).append("\n");
		sb.append("    searchIndex3Label: ").append(toIndentedString(searchIndex3Label)).append("\n");
		sb.append("    searchIndex4Label: ").append(toIndentedString(searchIndex4Label)).append("\n");
		sb.append("    searchIndex5Label: ").append(toIndentedString(searchIndex5Label)).append("\n");
		sb.append("    searchIndex1Value: ").append(toIndentedString(searchIndex1Value)).append("\n");
		sb.append("    searchIndex2Value: ").append(toIndentedString(searchIndex2Value)).append("\n");
		sb.append("    searchIndex3Value: ").append(toIndentedString(searchIndex3Value)).append("\n");
		sb.append("    searchIndex4Value: ").append(toIndentedString(searchIndex4Value)).append("\n");
		sb.append("    searchIndex5Value: ").append(toIndentedString(searchIndex5Value)).append("\n");
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
