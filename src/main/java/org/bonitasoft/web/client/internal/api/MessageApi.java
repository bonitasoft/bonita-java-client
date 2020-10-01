package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Message;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
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
}
