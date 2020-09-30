package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.License;
import retrofit2.Call;
import retrofit2.http.GET;

public interface LicenseApi {
  /**
   * Get the platform License
   * Returns the current platform License. This requires a platform session. Log in using the platform login service. 
   * @return Call&lt;License&gt;
   */
  @GET("API/platform/license")
  Call<License> getLicense();
    

}
