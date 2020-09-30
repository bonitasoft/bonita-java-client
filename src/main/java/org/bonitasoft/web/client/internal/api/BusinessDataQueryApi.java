package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.BusinessData;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface BusinessDataQueryApi {
  /**
   * Finds Business Data
   * Finds Business Data with pagination params and filters by calling a &#x60;Named Query&#x60;. The business data query REST API resource is used to call a default or custom business data query. It is available from version 6.5.  **Data parameters**:    * businessDataType - the fully-qualified business data type name   * q&#x3D;queryName - the query name   * p&#x3D;0 - the page number   * c&#x3D;10 - the maximum number of results in the page   * f&#x3D;parameter&#x3D;value - sets the parameter value according to business data query parameters defined in Bonita Studio   For a Boolean parameter, the accepted values are &#x60;true&#x60; or &#x60;false&#x60;.    By default, for a Date parameter can use the following formats:    * yyyy-MM-dd   * HH:mm:ss   * yyyy-MM-dd HH:mm:ss   * yyyy-MM-dd&#39;T&#39;HH:mm:ss   * yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSS 
   * @param businessDataType Business Data Type (required)
   * @param q Named query to use (required)
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @return Call&lt;List&lt;BusinessData&gt;&gt;
   */
  @GET("API/bdm/businessData/{businessDataType}")
  Call<List<BusinessData>> findBusinessData(
    @retrofit2.http.Path("businessDataType") String businessDataType, @retrofit2.http.Query("q") String q, @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f
  );

}
