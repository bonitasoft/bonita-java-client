package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.Message;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface MessageApi {
  /**
   * Send BPM message events
   * Use this resource to send BPM message events. Message events are caught by processes using &#x60;catch message event&#x60; flow nodes (Start, intermediate, boundary or receive tasks). 
   * @param body A Message event (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/bpm/message")
  Call<Void> createMessage(
    @retrofit2.http.Body Message body
  );

}
