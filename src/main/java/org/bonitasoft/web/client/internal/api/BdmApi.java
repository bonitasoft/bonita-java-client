package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.EncodingUtils;
import org.bonitasoft.web.client.internal.model.BDMInstallRequest;
import org.bonitasoft.web.client.internal.model.BDMUploadResponse;
import org.bonitasoft.web.client.internal.model.Bdm;
import org.bonitasoft.web.client.internal.model.BusinessData;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
public interface BdmApi extends ApiClient.Api {


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
  BusinessData findBusinessDataAttributeById(@Param("businessDataType") String businessDataType, @Param("persistenceId") String persistenceId, @Param("attributeName") String attributeName);

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
  BusinessData findBusinessDataById(@Param("businessDataType") String businessDataType, @Param("persistenceId") String persistenceId);

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
  List<BusinessData> findBusinessDataByIds(@Param("businessDataType") String businessDataType, @Param("ids") String ids);

  /**
   * Finds business data By Ids
   * Finds business data specified by their identifiers. 
   * Note, this is equivalent to the other <code>findBusinessDataByIds</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindBusinessDataByIdsQueryParams} class that allows for
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
  List<BusinessData> findBusinessDataByIds(@Param("businessDataType") String businessDataType, @QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findBusinessDataByIds</code> method in a fluent style.
   */
  public static class FindBusinessDataByIdsQueryParams extends HashMap<String, Object> {
    public FindBusinessDataByIdsQueryParams ids(final String value) {
      put("ids", EncodingUtils.encode(value));
      return this;
    }
  }

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
   * Upload a BDM
   * Upload BDM 
   * @param file  (optional)
   * @return BDMUploadResponse
   */
  @RequestLine("POST /portal/fileUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  BDMUploadResponse uploadBDM(@Param("file") File file);
}
