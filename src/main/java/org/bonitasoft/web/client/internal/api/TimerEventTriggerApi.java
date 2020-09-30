package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.InlineObject22;
import org.bonitasoft.web.client.internal.model.InlineResponse2001;
import org.bonitasoft.web.client.internal.model.TimerEventTrigger;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;

import java.util.List;

public interface TimerEventTriggerApi {
  /**
   * Finds TimerEventTriggers
   * Finds TimerEventTriggers with pagination params and filters  - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param caseId the case id (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;TimerEventTrigger&gt;&gt;
   */
  @GET("API/bpm/timerEventTrigger")
  Call<List<TimerEventTrigger>> findTimerEventTriggers(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("caseId") String caseId, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

  /**
   * Finds the TimerEventTrigger by ID
   * Returns the single TimerEventTrigger for the given ID 
   * @param id ID of the TimerEventTrigger to return (required)
   * @return Call&lt;TimerEventTrigger&gt;
   */
  @GET("API/bpm/timerEventTrigger/{id}")
  Call<TimerEventTrigger> getTimerEventTriggerById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Update the TimerEventTrigger by ID
   * Update the TimerEventTrigger for the given ID 
   * @param id ID of the TimerEventTrigger to return (required)
   * @param inlineObject22  (required)
   * @return Call&lt;InlineResponse2001&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/bpm/timerEventTrigger/{id}")
  Call<InlineResponse2001> updateTimerEventTriggerById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body InlineObject22 inlineObject22
  );

}
