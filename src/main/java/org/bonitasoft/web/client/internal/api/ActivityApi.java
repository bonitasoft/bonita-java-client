package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.Activity;
import org.bonitasoft.web.client.internal.model.InlineObject6;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;

import java.util.List;

public interface ActivityApi {
  /**
   * Finds Activities
   * Finds Activities with pagination params and filters. Activities in states completed, cancelled, or aborted are not retrieved. The search returns an array of activities.  - can order on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;processDefinitionId&#x60;, &#x60;parentProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60; (order by parent activity id), &#x60;rootProcessInstanceId&#x60;, &#x60;lastUpdateDate&#x60; - can search on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;processDefinitionId&#x60;, &#x60;parentProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60; (order by parent activity id), &#x60;rootProcessInstanceId&#x60;, &#x60;lastUpdateDate&#x60; - can filter on &#x60;name&#x60;, &#x60;state&#x60;, &#x60;processId&#x60;, &#x60;parentCaseId&#x60;, &#x60;rootCaseId&#x60;, &#x60;last_update_date&#x60;, &#x60;supervisor_id&#x60; (only in Enterprise editions) 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;Activity&gt;&gt;
   */
  @GET("API/bpm/activity")
  Call<List<Activity>> findActivities(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

  /**
   * Finds the Activity by ID
   * Returns the single Activity for the given ID 
   * @param id ID of the Activity to return (required)
   * @return Call&lt;Activity&gt;
   */
  @GET("API/bpm/activity/{id}")
  Call<Activity> getActivityById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Update the Activity by ID
   * Update the Activity for the given ID 
   * @param id ID of the Activity to return (required)
   * @param inlineObject6  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/bpm/activity/{id}")
  Call<Void> updateActivityById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body InlineObject6 inlineObject6
  );

}
