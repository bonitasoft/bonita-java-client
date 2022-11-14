package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;

import org.bonitasoft.web.client.model.Error;
import org.bonitasoft.web.client.model.Signal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface SignalApi extends ApiClient.Api {


  /**
   * Broadcast BPM signal events
   * Since 2022.1  Use this resource to broadcast BPM signal events. Signal events are caught by processes using &#x60;catch signal event&#x60; flow nodes (Start, intermediate or boundary). 
   * @param body A Signal event (required)
   */
  @RequestLine("POST /API/bpm/signal")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void broadcastSignal(Signal body);

  /**
   * Broadcast BPM signal events
   * Similar to <code>broadcastSignal</code> but it also returns the http response headers .
   * Since 2022.1  Use this resource to broadcast BPM signal events. Signal events are caught by processes using &#x60;catch signal event&#x60; flow nodes (Start, intermediate or boundary). 
   * @param body A Signal event (required)
   */
  @RequestLine("POST /API/bpm/signal")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Void> broadcastSignalWithHttpInfo(Signal body);


}
