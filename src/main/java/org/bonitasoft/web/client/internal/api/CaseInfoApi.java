package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.CaseInfo;
import org.bonitasoft.web.client.internal.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
