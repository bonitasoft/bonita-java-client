package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.ProcessSupervisor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProcessSupervisorApi {
  /**
   * Create the ProcessSupervisor
   * Create the ProcessSupervisor 
   * @param body The process definition id and either the user, role and/or group id. (required)
   * @return Call&lt;ProcessSupervisor&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/bpm/processSupervisor")
  Call<ProcessSupervisor> createProcessSupervisor(
    @retrofit2.http.Body ProcessSupervisor body
  );

  /**
   * Delete the ProcessSupervisor by ID
   * Delete the ProcessSupervisor for the given compoound IDs  You can delete a process supervisor by specifying its compound Id in the body of the request with the following format: &#x60;process_id/user_id/role_id/group_id&#x60; 
   * @param requestBody The process definition id and either the user, role and/or group id. (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("API/bpm/processSupervisor")
  Call<Void> deleteProcessSupervisorById(
    @retrofit2.http.Body List<String> requestBody
  );

  /**
   * Finds ProcessSupervisors
   * Finds ProcessSupervisors with pagination params and filters  To filter, you need to specify the &#x60;process_id&#x60;, and then the &#x60;user_id&#x60;, &#x60;group_id&#x60; and &#x60;role_id&#x60; with one of them (two if you want to filter on group and role) set to &#x60;&gt;0&#x60; and the other ones set to &#x60;-1&#x60;. E.g.: &#x60;f&#x3D;process_id%3D8040901857674754544&amp;f&#x3D;user_id%3D&gt;0&amp;f&#x3D;group_id%3D-1&amp;f&#x3D;role_id%3D-1&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;ProcessSupervisor&gt;&gt;
   */
  @GET("API/bpm/processSupervisor")
  Call<List<ProcessSupervisor>> findProcessSupervisors(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

}
