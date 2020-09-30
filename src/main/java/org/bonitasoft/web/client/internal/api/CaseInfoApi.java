package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.CaseInfo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CaseInfoApi {
  /**
   * Finds the CaseInfo by ID
   * Returns the single CaseInfo for the given ID 
   * @param id ID of the CaseInfo to return (required)
   * @return Call&lt;CaseInfo&gt;
   */
  @GET("API/bpm/caseInfo/{id}")
  Call<CaseInfo> getCaseInfoById(
    @retrofit2.http.Path("id") String id
  );

}
