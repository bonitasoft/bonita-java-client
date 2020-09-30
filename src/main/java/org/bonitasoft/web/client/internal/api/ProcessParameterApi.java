package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.InlineObject20;
import org.bonitasoft.web.client.internal.model.ProcessParameter;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;

import java.util.List;

public interface ProcessParameterApi {
  /**
   * Finds ProcessParameters
   * Finds ProcessParameters with pagination params and filters. 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;ProcessParameter&gt;&gt;
   */
  @GET("API/bpm/processParameter")
  Call<List<ProcessParameter>> findProcessParameters(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

  /**
   * Finds the ProcessParameter by ID
   * Returns the single ProcessParameter for the given ID 
   * @param id ID of the process to get parameter from (required)
   * @param name Name of the process parameter to return (required)
   * @return Call&lt;ProcessParameter&gt;
   */
  @GET("API/bpm/processParameter/{id}/{name}")
  Call<ProcessParameter> getProcessParameterById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Path("name") String name
  );

  /**
   * Update the ProcessParameter by ID
   * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Update the ProcessParameter for the given ID 
   * @param id ID of the process to get parameter from (required)
   * @param name Name of the process parameter to return (required)
   * @param inlineObject20  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/bpm/processParameter/{id}/{name}")
  Call<Void> updateProcessParameterById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Path("name") String name, @retrofit2.http.Body InlineObject20 inlineObject20
  );

}
