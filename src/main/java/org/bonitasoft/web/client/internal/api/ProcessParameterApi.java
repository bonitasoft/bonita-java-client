package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.ProcessParameter;
import org.bonitasoft.web.client.internal.model.ProcessParameterUpdateRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
   * @param processParameterUpdateRequest You can update only a process parameter value using the API. If you specify values for other fields in the update request, they are ignored. (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/bpm/processParameter/{id}/{name}")
  Call<Void> updateProcessParameterById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Path("name") String name, @retrofit2.http.Body ProcessParameterUpdateRequest processParameterUpdateRequest
  );

}
