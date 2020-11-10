package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;

import org.bonitasoft.web.client.model.Error;
import org.bonitasoft.web.client.model.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


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
