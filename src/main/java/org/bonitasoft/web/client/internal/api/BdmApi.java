package org.bonitasoft.web.client.internal.api;

import okhttp3.MultipartBody;
import org.bonitasoft.web.client.internal.model.Bdm;
import org.bonitasoft.web.client.internal.model.BusinessData;
import org.bonitasoft.web.client.internal.model.InlineObject50;
import org.bonitasoft.web.client.internal.model.InlineResponse200;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import java.util.List;

public interface BdmApi {
  /**
   * Finds business data attribute by id
   * Gets the business data attribute of business data according to its identifier and attribute name. Request url. 
   * @param businessDataType Business Data Type (required)
   * @param persistenceId Business data ID (required)
   * @param attributeName Business data attribute name (required)
   * @return Call&lt;BusinessData&gt;
   */
  @GET("API/bdm/businessData/{businessDataType}/{persistenceId}/{attributeName}")
  Call<BusinessData> findBusinessDataAttributeById(
    @retrofit2.http.Path("businessDataType") String businessDataType, @retrofit2.http.Path("persistenceId") String persistenceId, @retrofit2.http.Path("attributeName") String attributeName
  );

  /**
   * Finds business data by Id
   * Finds business data specified by its identifier. 
   * @param businessDataType Business Data Type (required)
   * @param persistenceId Business data ID (required)
   * @return Call&lt;BusinessData&gt;
   */
  @GET("API/bdm/businessData/{businessDataType}/{persistenceId}")
  Call<BusinessData> findBusinessDataById(
    @retrofit2.http.Path("businessDataType") String businessDataType, @retrofit2.http.Path("persistenceId") String persistenceId
  );

  /**
   * Finds business data By Ids
   * Finds business data specified by their identifiers. 
   * @param businessDataType Business Data Type (required)
   * @param ids list of persistenceIds (comma separated) (required)
   * @return Call&lt;List&lt;BusinessData&gt;&gt;
   */
  @GET("API/bdm/businessData/{businessDataType}/findByIds")
  Call<List<BusinessData>> findBusinessDataByIds(
    @retrofit2.http.Path("businessDataType") String businessDataType, @retrofit2.http.Query("ids") String ids
  );

  /**
   * Get the BDM
   * Returns the current BDM. Make this call to get the status the BDM. 
   * @return Call&lt;Bdm&gt;
   */
  @GET("API/tenant/bdm")
  Call<Bdm> getBdm();
    

  /**
   * Install a BDM
   * Install a BDM 
   * @param inlineObject50  (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/tenant/bdm")
  Call<Void> installBDM(
    @retrofit2.http.Body InlineObject50 inlineObject50
  );

  /**
   * Upload a BDM
   * Upload BDM 
   * @param file  (optional)
   * @return Call&lt;InlineResponse200&gt;
   */
  @retrofit2.http.Multipart
  @POST("portal/fileUpload")
  Call<InlineResponse200> uploadBDM(
    @retrofit2.http.Part MultipartBody.Part file
  );

}
