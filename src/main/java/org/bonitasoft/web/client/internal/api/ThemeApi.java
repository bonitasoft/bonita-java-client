package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.InlineObject46;
import org.bonitasoft.web.client.internal.model.InlineObject47;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ThemeApi {
  /**
   * Create the Theme
   * Create the Theme 
   * @param body  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/portal/theme")
  Call<Void> createTheme(
    @retrofit2.http.Body InlineObject46 body
  );

  /**
   * Update the Theme by ID
   * Restore a default theme 
   * @param inlineObject47  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/portal/theme/unusedId")
  Call<Void> updateTheme(
    @retrofit2.http.Body InlineObject47 inlineObject47
  );

}
