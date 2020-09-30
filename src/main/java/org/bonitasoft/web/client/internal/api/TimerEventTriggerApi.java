package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.TimerEventTrigger;
import org.bonitasoft.web.client.internal.model.TimerEventTriggerUpdateRequest;
import org.bonitasoft.web.client.internal.model.TimerEventTriggerUpdateResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
   * @param timerEventTriggerUpdateRequest a long value with attribute name \&quot;executionDate\&quot; (required)
   * @return Call&lt;TimerEventTriggerUpdateResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/bpm/timerEventTrigger/{id}")
  Call<TimerEventTriggerUpdateResponse> updateTimerEventTriggerById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body TimerEventTriggerUpdateRequest timerEventTriggerUpdateRequest
  );

}
