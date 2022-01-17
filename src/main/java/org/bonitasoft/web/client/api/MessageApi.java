package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.Message;

import feign.Headers;
import feign.RequestLine;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface MessageApi extends ApiClient.Api {


  /**
   * Send BPM message events
   * Use this resource to send BPM message events. Message events are caught by processes using &#x60;catch message event&#x60; flow nodes (Start, intermediate, boundary or receive tasks). 
   * @param body A Message event (required)
   */
  @RequestLine("POST /API/bpm/message")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void createMessage(Message body);

  /**
   * Send BPM message events
   * Similar to <code>createMessage</code> but it also returns the http response headers .
   * Use this resource to send BPM message events. Message events are caught by processes using &#x60;catch message event&#x60; flow nodes (Start, intermediate, boundary or receive tasks). 
   * @param body A Message event (required)
   */
  @RequestLine("POST /API/bpm/message")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Void> createMessageWithHttpInfo(Message body);


}
