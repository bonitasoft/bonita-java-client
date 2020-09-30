package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.ProcessConnectorDependency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProcessConnectorDependencyApi {
  /**
   * Finds ProcessConnectorDependencys
   * Finds ProcessConnectorDependencys with pagination params and filters  **Mandatory filters: &#x60;connector_process_id&#x60;, &#x60;connector_name&#x60;, &#x60;connector_version&#x60;** 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;ProcessConnectorDependency&gt;&gt;
   */
  @GET("API/bpm/processConnectorDependency")
  Call<List<ProcessConnectorDependency>> findProcessConnectorDependencys(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

}
