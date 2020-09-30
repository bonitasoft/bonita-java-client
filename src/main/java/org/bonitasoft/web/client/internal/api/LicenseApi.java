package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.License;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LicenseApi {
  /**
   * Get the platform License
   * Returns the current platform License. This requires a platform session. Log in using the platform login service. 
   * @return Call&lt;License&gt;
   */
  @GET("API/platform/license")
  Call<License> getLicense();
    

}
