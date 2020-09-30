package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.CustomUserDefinition;
import org.bonitasoft.web.client.internal.model.CustomUserDefinitionCreateRequest;
import org.bonitasoft.web.client.internal.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CustomUserDefinitionApi {
  /**
   * Create the CustomUserDefinition
   * Create the CustomUserDefinition 
   * @param body Partial CustomUserDefinition description (required)
   * @return Call&lt;CustomUserDefinition&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/customuserinfo/definition")
  Call<CustomUserDefinition> createCustomUserDefinition(
    @retrofit2.http.Body CustomUserDefinitionCreateRequest body
  );

  /**
   * Delete the CustomUserDefinition by ID
   * Delete the single CustomUserDefinition for the given ID 
   * @param id ID of the CustomUserDefinition to delete (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("API/customuserinfo/definition/{id}")
  Call<Void> deleteCustomUserDefinitionById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Finds CustomUserDefinitions
   * Finds CustomUserDefinitions. There are no filters, and no search terms. All the definitions are returned. 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @return Call&lt;List&lt;CustomUserDefinition&gt;&gt;
   */
  @GET("API/customuserinfo/definition")
  Call<List<CustomUserDefinition>> findCustomUserDefinitions(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c
  );

  /**
   * Finds the CustomUserDefinition by ID
   * Returns the single CustomUserDefinition for the given ID 
   * @param id ID of the CustomUserDefinition to return (required)
   * @return Call&lt;CustomUserDefinition&gt;
   */
  @GET("API/customuserinfo/definition/{id}")
  Call<CustomUserDefinition> getCustomUserDefinitionById(
    @retrofit2.http.Path("id") String id
  );

}
