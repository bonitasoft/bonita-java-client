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

/**
 * 
 */
@JsonPropertyOrder({
  ProfessionalContactData.JSON_PROPERTY_ID,
  ProfessionalContactData.JSON_PROPERTY_FAX_NUMBER,
  ProfessionalContactData.JSON_PROPERTY_BUILDING,
  ProfessionalContactData.JSON_PROPERTY_PHONE_NUMBER,
  ProfessionalContactData.JSON_PROPERTY_WEBSITE,
  ProfessionalContactData.JSON_PROPERTY_ZIPCODE,
  ProfessionalContactData.JSON_PROPERTY_STATE,
  ProfessionalContactData.JSON_PROPERTY_CITY,
  ProfessionalContactData.JSON_PROPERTY_COUNTRY,
  ProfessionalContactData.JSON_PROPERTY_MOBILE_NUMBER,
  ProfessionalContactData.JSON_PROPERTY_ADDRESS,
  ProfessionalContactData.JSON_PROPERTY_ROOM,
  ProfessionalContactData.JSON_PROPERTY_EMAIL
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ProfessionalContactData implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_FAX_NUMBER = "fax_number";
  private String faxNumber;

  public static final String JSON_PROPERTY_BUILDING = "building";
  private String building;

  public static final String JSON_PROPERTY_PHONE_NUMBER = "phone_number";
  private String phoneNumber;

  public static final String JSON_PROPERTY_WEBSITE = "website";
  private String website;

  public static final String JSON_PROPERTY_ZIPCODE = "zipcode";
  private String zipcode;

  public static final String JSON_PROPERTY_STATE = "state";
  private String state;

  public static final String JSON_PROPERTY_CITY = "city";
  private String city;

  public static final String JSON_PROPERTY_COUNTRY = "country";
  private String country;

  public static final String JSON_PROPERTY_MOBILE_NUMBER = "mobile_number";
  private String mobileNumber;

  public static final String JSON_PROPERTY_ADDRESS = "address";
  private String address;

  public static final String JSON_PROPERTY_ROOM = "room";
  private String room;

  public static final String JSON_PROPERTY_EMAIL = "email";
  private String email;

  public ProfessionalContactData() {
  }

  public ProfessionalContactData id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * user ID
   * @return id
  **/
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setId(String id) {
    this.id = id;
  }


  public ProfessionalContactData faxNumber(String faxNumber) {
    
    this.faxNumber = faxNumber;
    return this;
  }

   /**
   * fax number
   * @return faxNumber
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_FAX_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFaxNumber() {
    return faxNumber;
  }


  @JsonProperty(JSON_PROPERTY_FAX_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFaxNumber(String faxNumber) {
    this.faxNumber = faxNumber;
  }


  public ProfessionalContactData building(String building) {
    
    this.building = building;
    return this;
  }

   /**
   * building
   * @return building
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_BUILDING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getBuilding() {
    return building;
  }


  @JsonProperty(JSON_PROPERTY_BUILDING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBuilding(String building) {
    this.building = building;
  }


  public ProfessionalContactData phoneNumber(String phoneNumber) {
    
    this.phoneNumber = phoneNumber;
    return this;
  }

   /**
   * phone number
   * @return phoneNumber
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPhoneNumber() {
    return phoneNumber;
  }


  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }


  public ProfessionalContactData website(String website) {
    
    this.website = website;
    return this;
  }

   /**
   * website
   * @return website
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_WEBSITE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getWebsite() {
    return website;
  }


  @JsonProperty(JSON_PROPERTY_WEBSITE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWebsite(String website) {
    this.website = website;
  }


  public ProfessionalContactData zipcode(String zipcode) {
    
    this.zipcode = zipcode;
    return this;
  }

   /**
   * zipcode
   * @return zipcode
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ZIPCODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getZipcode() {
    return zipcode;
  }


  @JsonProperty(JSON_PROPERTY_ZIPCODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }


  public ProfessionalContactData state(String state) {
    
    this.state = state;
    return this;
  }

   /**
   * state
   * @return state
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getState() {
    return state;
  }


  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setState(String state) {
    this.state = state;
  }


  public ProfessionalContactData city(String city) {
    
    this.city = city;
    return this;
  }

   /**
   * city
   * @return city
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCity() {
    return city;
  }


  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCity(String city) {
    this.city = city;
  }


  public ProfessionalContactData country(String country) {
    
    this.country = country;
    return this;
  }

   /**
   * country
   * @return country
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCountry() {
    return country;
  }


  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCountry(String country) {
    this.country = country;
  }


  public ProfessionalContactData mobileNumber(String mobileNumber) {
    
    this.mobileNumber = mobileNumber;
    return this;
  }

   /**
   * mobile phone number
   * @return mobileNumber
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MOBILE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMobileNumber() {
    return mobileNumber;
  }


  @JsonProperty(JSON_PROPERTY_MOBILE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }


  public ProfessionalContactData address(String address) {
    
    this.address = address;
    return this;
  }

   /**
   * address
   * @return address
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAddress() {
    return address;
  }


  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAddress(String address) {
    this.address = address;
  }


  public ProfessionalContactData room(String room) {
    
    this.room = room;
    return this;
  }

   /**
   * room
   * @return room
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_ROOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRoom() {
    return room;
  }


  @JsonProperty(JSON_PROPERTY_ROOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRoom(String room) {
    this.room = room;
  }


  public ProfessionalContactData email(String email) {
    
    this.email = email;
    return this;
  }

   /**
   * email
   * @return email
  **/
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEmail() {
    return email;
  }


  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProfessionalContactData professionalContactData = (ProfessionalContactData) o;
    return Objects.equals(this.id, professionalContactData.id) &&
        Objects.equals(this.faxNumber, professionalContactData.faxNumber) &&
        Objects.equals(this.building, professionalContactData.building) &&
        Objects.equals(this.phoneNumber, professionalContactData.phoneNumber) &&
        Objects.equals(this.website, professionalContactData.website) &&
        Objects.equals(this.zipcode, professionalContactData.zipcode) &&
        Objects.equals(this.state, professionalContactData.state) &&
        Objects.equals(this.city, professionalContactData.city) &&
        Objects.equals(this.country, professionalContactData.country) &&
        Objects.equals(this.mobileNumber, professionalContactData.mobileNumber) &&
        Objects.equals(this.address, professionalContactData.address) &&
        Objects.equals(this.room, professionalContactData.room) &&
        Objects.equals(this.email, professionalContactData.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, faxNumber, building, phoneNumber, website, zipcode, state, city, country, mobileNumber, address, room, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProfessionalContactData {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    faxNumber: ").append(toIndentedString(faxNumber)).append("\n");
    sb.append("    building: ").append(toIndentedString(building)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    website: ").append(toIndentedString(website)).append("\n");
    sb.append("    zipcode: ").append(toIndentedString(zipcode)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    room: ").append(toIndentedString(room)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

