package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.CaseInfo;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
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
