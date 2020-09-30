package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.Session;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SessionApi {
  /**
   * Get the current user session
   * Returns session information for the current user 
   * @return Call&lt;Session&gt;
   */
  @GET("API/system/session/unusedId")
  Call<Session> getSession();
    

}
