package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;

import org.bonitasoft.web.client.model.Error;
import org.bonitasoft.web.client.model.ProcessInstanceInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface ProcessInstanceInfoApi extends ApiClient.Api {


  /**
   * Finds the ProcessInstanceInfo by ID
   * Returns the single ProcessInstanceInfo for the given ID 
   * @param id ID of the ProcessInstanceInfo to return (required)
   * @return ProcessInstanceInfo
   */
  @RequestLine("GET /API/bpm/caseInfo/{id}")
  @Headers({
    "Accept: application/json",
  })
  ProcessInstanceInfo getProcessInstanceInfoById(@Param("id") String id);
}
