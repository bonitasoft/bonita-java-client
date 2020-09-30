package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.FormMapping;
import org.bonitasoft.web.client.internal.model.InlineObject25;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;

import java.util.List;

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
   * @param inlineObject25  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/form/mapping/{id}")
  Call<Void> updateFormMappingById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body InlineObject25 inlineObject25
  );

}
