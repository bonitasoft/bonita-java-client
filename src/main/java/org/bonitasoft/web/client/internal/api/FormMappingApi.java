package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.FormMapping;
import org.bonitasoft.web.client.internal.model.FormMappingUpdateRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface FormMappingApi {
  /**
   * Finds FormMappings
   * Finds FormMappings with pagination params and filters  - can filter on &#x60;processDefinitionId&#x60;,&#x60;type&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;FormMapping&gt;&gt;
   */
  @GET("API/form/mapping")
  Call<List<FormMapping>> findFormMappings(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

  /**
   * Update the FormMapping by ID
   * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Update the FormMapping for the given ID 
   * @param id ID of the FormMapping to return (required)
   * @param formMappingUpdateRequest Representation of the form mapping attribute to update - {&#39;pageId&#39;: (long)} or {&#39;url&#39;: (string)} or {} to set the mapping type to NONE (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/form/mapping/{id}")
  Call<Void> updateFormMappingById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body FormMappingUpdateRequest formMappingUpdateRequest
  );

}
