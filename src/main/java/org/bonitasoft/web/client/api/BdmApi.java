package org.bonitasoft.web.client.api;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.BDMInstallRequest;
import org.bonitasoft.web.client.model.Bdm;
import org.bonitasoft.web.client.model.BusinessData;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface BdmApi extends ApiClient.Api {


  /**
   * Get the BDM
   * Returns the current BDM. Make this call to get the status the BDM. 
   * @return Bdm
   */
  @RequestLine("GET /API/tenant/bdm")
  @Headers({
    "Accept: application/json",
  })
  Bdm getBdm();

  /**
   * Get the BDM
   * Similar to <code>getBdm</code> but it also returns the http response headers .
   * Returns the current BDM. Make this call to get the status the BDM. 
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/tenant/bdm")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Bdm> getBdmWithHttpInfo();



  /**
   * Install a BDM
   * Install a BDM 
   * @param bdMInstallRequest  (optional)
   */
  @RequestLine("POST /API/tenant/bdm")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void installBDM(BDMInstallRequest bdMInstallRequest);

  /**
   * Install a BDM
   * Similar to <code>installBDM</code> but it also returns the http response headers .
   * Install a BDM 
   * @param bdMInstallRequest  (optional)
   */
  @RequestLine("POST /API/tenant/bdm")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Void> installBDMWithHttpInfo(BDMInstallRequest bdMInstallRequest);



  /**
   * Finds business data attribute by id
   * Gets the business data attribute of business data according to its identifier and attribute name. Request url. 
   * @param businessDataType Business Data Type (required)
   * @param persistenceId Business data ID (required)
   * @param attributeName Business data attribute name (required)
   * @return BusinessData
   */
  @RequestLine("GET /API/bdm/businessData/{businessDataType}/{persistenceId}/{attributeName}")
  @Headers({
    "Accept: application/json",
  })
  BusinessData searchBusinessDataAttributeById(@Param("businessDataType") String businessDataType, @Param("persistenceId") String persistenceId, @Param("attributeName") String attributeName);

  /**
   * Finds business data attribute by id
   * Similar to <code>searchBusinessDataAttributeById</code> but it also returns the http response headers .
   * Gets the business data attribute of business data according to its identifier and attribute name. Request url. 
   * @param businessDataType Business Data Type (required)
   * @param persistenceId Business data ID (required)
   * @param attributeName Business data attribute name (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bdm/businessData/{businessDataType}/{persistenceId}/{attributeName}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<BusinessData> searchBusinessDataAttributeByIdWithHttpInfo(@Param("businessDataType") String businessDataType, @Param("persistenceId") String persistenceId, @Param("attributeName") String attributeName);



  /**
   * Finds business data by Id
   * Finds business data specified by its identifier. 
   * @param businessDataType Business Data Type (required)
   * @param persistenceId Business data ID (required)
   * @return BusinessData
   */
  @RequestLine("GET /API/bdm/businessData/{businessDataType}/{persistenceId}")
  @Headers({
    "Accept: application/json",
  })
  BusinessData searchBusinessDataById(@Param("businessDataType") String businessDataType, @Param("persistenceId") String persistenceId);

  /**
   * Finds business data by Id
   * Similar to <code>searchBusinessDataById</code> but it also returns the http response headers .
   * Finds business data specified by its identifier. 
   * @param businessDataType Business Data Type (required)
   * @param persistenceId Business data ID (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bdm/businessData/{businessDataType}/{persistenceId}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<BusinessData> searchBusinessDataByIdWithHttpInfo(@Param("businessDataType") String businessDataType, @Param("persistenceId") String persistenceId);



  /**
   * Finds business data By Ids
   * Finds business data specified by their identifiers. 
   * @param businessDataType Business Data Type (required)
   * @param ids list of persistenceIds (comma separated) (required)
   * @return List&lt;BusinessData&gt;
   */
  @RequestLine("GET /API/bdm/businessData/{businessDataType}/findByIds?ids={ids}")
  @Headers({
    "Accept: application/json",
  })
  List<BusinessData> searchBusinessDataByIds(@Param("businessDataType") String businessDataType, @Param("ids") String ids);

  /**
   * Finds business data By Ids
   * Similar to <code>searchBusinessDataByIds</code> but it also returns the http response headers .
   * Finds business data specified by their identifiers. 
   * @param businessDataType Business Data Type (required)
   * @param ids list of persistenceIds (comma separated) (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bdm/businessData/{businessDataType}/findByIds?ids={ids}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<BusinessData>> searchBusinessDataByIdsWithHttpInfo(@Param("businessDataType") String businessDataType, @Param("ids") String ids);


  /**
   * Finds business data By Ids
   * Finds business data specified by their identifiers. 
   * Note, this is equivalent to the other <code>searchBusinessDataByIds</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchBusinessDataByIdsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param businessDataType Business Data Type (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>ids - list of persistenceIds (comma separated) (required)</li>
   *   </ul>
   * @return List&lt;BusinessData&gt;
   */
  @RequestLine("GET /API/bdm/businessData/{businessDataType}/findByIds?ids={ids}")
  @Headers({
  "Accept: application/json",
  })
  List<BusinessData> searchBusinessDataByIds(@Param("businessDataType") String businessDataType, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
  * Finds business data By Ids
  * Finds business data specified by their identifiers. 
  * Note, this is equivalent to the other <code>searchBusinessDataByIds</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
              * @param businessDataType Business Data Type (required)
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>ids - list of persistenceIds (comma separated) (required)</li>
      *   </ul>
          * @return List&lt;BusinessData&gt;
      */
      @RequestLine("GET /API/bdm/businessData/{businessDataType}/findByIds?ids={ids}")
      @Headers({
    "Accept: application/json",
      })
   ApiResponse<List<BusinessData>> searchBusinessDataByIdsWithHttpInfo(@Param("businessDataType") String businessDataType, @QueryMap(encoded=true) Map<String, Object> queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>searchBusinessDataByIds</code> method in a fluent style.
   */
  public static class SearchBusinessDataByIdsQueryParams extends HashMap<String, Object> {
    public SearchBusinessDataByIdsQueryParams ids(final String value) {
      put("ids", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Upload a file
   * Upload file.  **NOTE:** If this file is a BDM zip, to do this, your tenant services need to be paused. In Enterprise editions, if you have an access control file installed on your tenant, you need to delete it before installing or updating your BDM. 
   * @param file  (optional)
   * @return String
   */
  @RequestLine("POST /portal/fileUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  String uploadFile(@Param("file") File file);

  /**
   * Upload a file
   * Similar to <code>uploadFile</code> but it also returns the http response headers .
   * Upload file.  **NOTE:** If this file is a BDM zip, to do this, your tenant services need to be paused. In Enterprise editions, if you have an access control file installed on your tenant, you need to delete it before installing or updating your BDM. 
   * @param file  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /portal/fileUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  ApiResponse<String> uploadFileWithHttpInfo(@Param("file") File file);


}
