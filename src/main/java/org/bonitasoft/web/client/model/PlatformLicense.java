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
import io.swagger.annotations.ApiModelProperty;

/** PlatformLicense */
@JsonPropertyOrder({ PlatformLicense.JSON_PROPERTY_LICENSE_START_DATE, PlatformLicense.JSON_PROPERTY_DURATION,
		PlatformLicense.JSON_PROPERTY_LICENSE_EXPIRATION_DATE, PlatformLicense.JSON_PROPERTY_NUMBER_OF_C_P_U_CORES,
		PlatformLicense.JSON_PROPERTY_EDITION, PlatformLicense.JSON_PROPERTY_LICENSE_MODE,
		PlatformLicense.JSON_PROPERTY_REQUEST_KEY, PlatformLicense.JSON_PROPERTY_SUBSCRIPTION_START_PERIOD,
		PlatformLicense.JSON_PROPERTY_SUBSCRIPTION_END_PERIOD, PlatformLicense.JSON_PROPERTY_CASE_COUNTER_LIMIT,
		PlatformLicense.JSON_PROPERTY_CASE_COUNTER })
@JsonTypeName("PlatformLicense")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class PlatformLicense implements Serializable {

	public static final String JSON_PROPERTY_LICENSE_START_DATE = "licenseStartDate";

	public static final String JSON_PROPERTY_DURATION = "duration";

	public static final String JSON_PROPERTY_LICENSE_EXPIRATION_DATE = "licenseExpirationDate";

	public static final String JSON_PROPERTY_NUMBER_OF_C_P_U_CORES = "numberOfCPUCores";

	public static final String JSON_PROPERTY_EDITION = "edition";

	public static final String JSON_PROPERTY_LICENSE_MODE = "licenseMode";

	public static final String JSON_PROPERTY_REQUEST_KEY = "requestKey";

	public static final String JSON_PROPERTY_SUBSCRIPTION_START_PERIOD = "subscriptionStartPeriod";

	public static final String JSON_PROPERTY_SUBSCRIPTION_END_PERIOD = "subscriptionEndPeriod";

	public static final String JSON_PROPERTY_CASE_COUNTER_LIMIT = "caseCounterLimit";

	public static final String JSON_PROPERTY_CASE_COUNTER = "caseCounter";

	private static final long serialVersionUID = 1L;

	private String licenseStartDate;

	private String duration;

	private String licenseExpirationDate;

	private String numberOfCPUCores;

	private String edition;

	private String licenseMode;

	private String requestKey;

	private String subscriptionStartPeriod;

	private String subscriptionEndPeriod;

	private Long caseCounterLimit;

	private Long caseCounter;

	public PlatformLicense licenseStartDate(String licenseStartDate) {

		this.licenseStartDate = licenseStartDate;
		return this;
	}

	/**
	 * date with format &#x60;yyyy-MM-dd&#x60; - first day (included) of license file
	 * validity
	 * @return licenseStartDate
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "date with format `yyyy-MM-dd` - first day (included) of license file validity")
	@JsonProperty(JSON_PROPERTY_LICENSE_START_DATE)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getLicenseStartDate() {
		return licenseStartDate;
	}

	public void setLicenseStartDate(String licenseStartDate) {
		this.licenseStartDate = licenseStartDate;
	}

	public PlatformLicense duration(String duration) {

		this.duration = duration;
		return this;
	}

	/**
	 * number of days for license file validity
	 * @return duration
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "number of days for license file validity")
	@JsonProperty(JSON_PROPERTY_DURATION)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public PlatformLicense licenseExpirationDate(String licenseExpirationDate) {

		this.licenseExpirationDate = licenseExpirationDate;
		return this;
	}

	/**
	 * date with format &#x60;yyyy-MM-dd&#x60; - last day (included) of license file
	 * validity
	 * @return licenseExpirationDate
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "date with format `yyyy-MM-dd` - last day (included) of license file validity")
	@JsonProperty(JSON_PROPERTY_LICENSE_EXPIRATION_DATE)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getLicenseExpirationDate() {
		return licenseExpirationDate;
	}

	public void setLicenseExpirationDate(String licenseExpirationDate) {
		this.licenseExpirationDate = licenseExpirationDate;
	}

	public PlatformLicense numberOfCPUCores(String numberOfCPUCores) {

		this.numberOfCPUCores = numberOfCPUCores;
		return this;
	}

	/**
	 * number of CPUs
	 * @return numberOfCPUCores
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "number of CPUs")
	@JsonProperty(JSON_PROPERTY_NUMBER_OF_C_P_U_CORES)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getNumberOfCPUCores() {
		return numberOfCPUCores;
	}

	public void setNumberOfCPUCores(String numberOfCPUCores) {
		this.numberOfCPUCores = numberOfCPUCores;
	}

	public PlatformLicense edition(String edition) {

		this.edition = edition;
		return this;
	}

	/**
	 * name of the Bonita edition enabled by the license
	 * @return edition
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "name of the Bonita edition enabled by the license")
	@JsonProperty(JSON_PROPERTY_EDITION)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public PlatformLicense licenseMode(String licenseMode) {

		this.licenseMode = licenseMode;
		return this;
	}

	/**
	 * available mode enabled by the license
	 * @return licenseMode
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(value = "available mode enabled by the license")
	@JsonProperty(JSON_PROPERTY_LICENSE_MODE)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getLicenseMode() {
		return licenseMode;
	}

	public void setLicenseMode(String licenseMode) {
		this.licenseMode = licenseMode;
	}

	public PlatformLicense requestKey(String requestKey) {

		this.requestKey = requestKey;
		return this;
	}

	/**
	 * request key to use to generate a new license on the customer portal If you have a
	 * subscription that specifies case-counter licensing, additional fields are present:
	 * @return requestKey
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(
			value = "request key to use to generate a new license on the customer portal If you have a subscription that specifies case-counter licensing, additional fields are present: ")
	@JsonProperty(JSON_PROPERTY_REQUEST_KEY)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getRequestKey() {
		return requestKey;
	}

	public void setRequestKey(String requestKey) {
		this.requestKey = requestKey;
	}

	public PlatformLicense subscriptionStartPeriod(String subscriptionStartPeriod) {

		this.subscriptionStartPeriod = subscriptionStartPeriod;
		return this;
	}

	/**
	 * date with format &#x60;yyyy-MM-dd&#x60; - first day (included) of current period
	 * for number of process instances provisioned
	 * @return subscriptionStartPeriod
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(
			value = "date with format `yyyy-MM-dd` - first day (included) of current period for number of process instances provisioned")
	@JsonProperty(JSON_PROPERTY_SUBSCRIPTION_START_PERIOD)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getSubscriptionStartPeriod() {
		return subscriptionStartPeriod;
	}

	public void setSubscriptionStartPeriod(String subscriptionStartPeriod) {
		this.subscriptionStartPeriod = subscriptionStartPeriod;
	}

	public PlatformLicense subscriptionEndPeriod(String subscriptionEndPeriod) {

		this.subscriptionEndPeriod = subscriptionEndPeriod;
		return this;
	}

	/**
	 * date with format &#x60;yyyy-MM-dd&#x60; - last day (included) of current period for
	 * number of process instances provisioned
	 * @return subscriptionEndPeriod
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(
			value = "date with format `yyyy-MM-dd` - last day (included) of current period for number of process instances provisioned")
	@JsonProperty(JSON_PROPERTY_SUBSCRIPTION_END_PERIOD)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public String getSubscriptionEndPeriod() {
		return subscriptionEndPeriod;
	}

	public void setSubscriptionEndPeriod(String subscriptionEndPeriod) {
		this.subscriptionEndPeriod = subscriptionEndPeriod;
	}

	public PlatformLicense caseCounterLimit(Long caseCounterLimit) {

		this.caseCounterLimit = caseCounterLimit;
		return this;
	}

	/**
	 * number of process instances provisioned for period between
	 * &#x60;subscriptionStartPeriod&#x60; and &#x60;subscriptionEndPeriod&#x60;
	 * @return caseCounterLimit
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(
			value = "number of process instances provisioned for period between `subscriptionStartPeriod` and `subscriptionEndPeriod`")
	@JsonProperty(JSON_PROPERTY_CASE_COUNTER_LIMIT)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public Long getCaseCounterLimit() {
		return caseCounterLimit;
	}

	public void setCaseCounterLimit(Long caseCounterLimit) {
		this.caseCounterLimit = caseCounterLimit;
	}

	public PlatformLicense caseCounter(Long caseCounter) {

		this.caseCounter = caseCounter;
		return this;
	}

	/**
	 * number of consumed process instances for period between
	 * &#x60;subscriptionStartPeriod&#x60; and &#x60;subscriptionEndPeriod&#x60;
	 * @return caseCounter
	 */
	@javax.annotation.Nullable
	@ApiModelProperty(
			value = "number of consumed process instances for period between `subscriptionStartPeriod` and `subscriptionEndPeriod`")
	@JsonProperty(JSON_PROPERTY_CASE_COUNTER)
	@JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
	public Long getCaseCounter() {
		return caseCounter;
	}

	public void setCaseCounter(Long caseCounter) {
		this.caseCounter = caseCounter;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PlatformLicense platformLicense = (PlatformLicense) o;
		return Objects.equals(this.licenseStartDate, platformLicense.licenseStartDate)
				&& Objects.equals(this.duration, platformLicense.duration)
				&& Objects.equals(this.licenseExpirationDate, platformLicense.licenseExpirationDate)
				&& Objects.equals(this.numberOfCPUCores, platformLicense.numberOfCPUCores)
				&& Objects.equals(this.edition, platformLicense.edition)
				&& Objects.equals(this.licenseMode, platformLicense.licenseMode)
				&& Objects.equals(this.requestKey, platformLicense.requestKey)
				&& Objects.equals(this.subscriptionStartPeriod, platformLicense.subscriptionStartPeriod)
				&& Objects.equals(this.subscriptionEndPeriod, platformLicense.subscriptionEndPeriod)
				&& Objects.equals(this.caseCounterLimit, platformLicense.caseCounterLimit)
				&& Objects.equals(this.caseCounter, platformLicense.caseCounter);
	}

	@Override
	public int hashCode() {
		return Objects.hash(licenseStartDate, duration, licenseExpirationDate, numberOfCPUCores, edition, licenseMode,
				requestKey, subscriptionStartPeriod, subscriptionEndPeriod, caseCounterLimit, caseCounter);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PlatformLicense {\n");
		sb.append("    licenseStartDate: ").append(toIndentedString(licenseStartDate)).append("\n");
		sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
		sb.append("    licenseExpirationDate: ").append(toIndentedString(licenseExpirationDate)).append("\n");
		sb.append("    numberOfCPUCores: ").append(toIndentedString(numberOfCPUCores)).append("\n");
		sb.append("    edition: ").append(toIndentedString(edition)).append("\n");
		sb.append("    licenseMode: ").append(toIndentedString(licenseMode)).append("\n");
		sb.append("    requestKey: ").append(toIndentedString(requestKey)).append("\n");
		sb.append("    subscriptionStartPeriod: ").append(toIndentedString(subscriptionStartPeriod)).append("\n");
		sb.append("    subscriptionEndPeriod: ").append(toIndentedString(subscriptionEndPeriod)).append("\n");
		sb.append("    caseCounterLimit: ").append(toIndentedString(caseCounterLimit)).append("\n");
		sb.append("    caseCounter: ").append(toIndentedString(caseCounter)).append("\n");
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
