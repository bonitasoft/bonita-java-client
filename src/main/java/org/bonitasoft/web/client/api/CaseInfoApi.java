package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;

import org.bonitasoft.web.client.model.CaseInfo;
import org.bonitasoft.web.client.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface CaseInfoApi extends ApiClient.Api {


  /**
   * Finds the CaseInfo by ID
   * Returns the single CaseInfo for the given ID 
   * @param id ID of the CaseInfo to return (required)
   * @return CaseInfo
   */
  @RequestLine("GET /API/bpm/caseInfo/{id}")
  @Headers({
    "Accept: application/json",
  })
  CaseInfo getCaseInfoById(@Param("id") String id);
}
