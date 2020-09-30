package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.ProfessionalContactData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProfessionalContactDataApi {
  /**
   * Create the ProfessionalContactData
   * Create the ProfessionalContactData 
   * @param body Partial ProfessionalContactData description including the user ID (required)
   * @return Call&lt;ProfessionalContactData&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/identity/professionalcontactdata")
  Call<ProfessionalContactData> createProfessionalContactData(
    @retrofit2.http.Body ProfessionalContactData body
  );

  /**
   * Finds ProfessionalContactData
   * Finds ProfessionalContactData with pagination params and filters  - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;ProfessionalContactData&gt;&gt;
   */
  @GET("API/identity/professionalcontactdata")
  Call<List<ProfessionalContactData>> findProfessionalContactDatas(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

  /**
   * Finds the PersonalContactData by ID
   * Returns the single PersonalContactData for the given ID 
   * @param userId User ID of the PersonalContactData to return (required)
   * @return Call&lt;ProfessionalContactData&gt;
   */
  @GET("API/identity/personalcontactdata/{userId}")
  Call<ProfessionalContactData> getPersonalContactDataById(
    @retrofit2.http.Path("userId") String userId
  );

  /**
   * Finds the ProfessionalContactData by ID
   * Returns the single ProfessionalContactData for the given ID 
   * @param userId User ID of the ProfessionalContactData to return (required)
   * @return Call&lt;ProfessionalContactData&gt;
   */
  @GET("API/identity/professionalcontactdata/{userId}")
  Call<ProfessionalContactData> getProfessionalContactDataById(
    @retrofit2.http.Path("userId") String userId
  );

  /**
   * Update the PersonalContactData by ID
   * Update the PersonalContactData for the given ID 
   * @param userId User ID of the PersonalContactData to update (required)
   * @param professionalContactData Partial PersonalContactData description including the user ID (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/identity/personalcontactdata/{userId}")
  Call<Void> updatePersonalContactDataById(
    @retrofit2.http.Path("userId") String userId, @retrofit2.http.Body ProfessionalContactData professionalContactData
  );

  /**
   * Update the ProfessionalContactData by ID
   * Update the ProfessionalContactData for the given ID 
   * @param userId User ID of the ProfessionalContactData to update (required)
   * @param professionalContactData Partial ProfessionalContactData description including the user ID (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/identity/professionalcontactdata/{userId}")
  Call<Void> updateProfessionalContactDataById(
    @retrofit2.http.Path("userId") String userId, @retrofit2.http.Body ProfessionalContactData professionalContactData
  );

}
