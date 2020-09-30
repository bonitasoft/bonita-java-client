package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.ThemeCreateRequest;
import org.bonitasoft.web.client.internal.model.ThemeRestoreRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ThemeApi {
  /**
   * Create the Theme
   * Create the Theme 
   * @param body Partial Theme description (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/portal/theme")
  Call<Void> createTheme(
    @retrofit2.http.Body ThemeCreateRequest body
  );

  /**
   * Restore default Theme
   * Restore the default theme 
   * @param themeRestoreRequest Partial Theme description (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/portal/theme/unusedId")
  Call<Void> restoreTheme(
    @retrofit2.http.Body ThemeRestoreRequest themeRestoreRequest
  );

}
