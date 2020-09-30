package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
