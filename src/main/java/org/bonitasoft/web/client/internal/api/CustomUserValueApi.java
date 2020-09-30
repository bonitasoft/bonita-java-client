package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.CustomUserValue;
import org.bonitasoft.web.client.internal.model.InlineObject24;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;

import java.util.List;

public interface CustomUserValueApi {
  /**
   * Finds CustomUserValues
   * Finds CustomUserValues with pagination params and filters  You can filter on &#x60;userId&#x60;, &#x60;value&#x60;, &#x60;definitionId&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @return Call&lt;List&lt;CustomUserValue&gt;&gt;
   */
  @GET("API/customuserinfo/value")
  Call<List<CustomUserValue>> findCustomUserValues(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f
  );

  /**
   * Update the CustomUserValue by ID
   * Update the CustomUserValue for the given ID 
   * @param userId User ID (required)
   * @param definitionId definition ID (required)
   * @param inlineObject24  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/customuserinfo/value/{userId}/{definitionId}")
  Call<Void> updateCustomUserValueById(
    @retrofit2.http.Path("userId") String userId, @retrofit2.http.Path("definitionId") String definitionId, @retrofit2.http.Body InlineObject24 inlineObject24
  );

}
