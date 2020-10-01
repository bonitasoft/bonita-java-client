package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.ThemeCreateRequest;
import org.bonitasoft.web.client.internal.model.ThemeRestoreRequest;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
public interface ThemeApi extends ApiClient.Api {


  /**
   * Create the Theme
   * Create the Theme 
   * @param body Partial Theme description (required)
   */
  @RequestLine("POST /API/portal/theme")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void createTheme(ThemeCreateRequest body);

  /**
   * Restore default Theme
   * Restore the default theme 
   * @param themeRestoreRequest Partial Theme description (required)
   */
  @RequestLine("PUT /API/portal/theme/unusedId")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void restoreTheme(ThemeRestoreRequest themeRestoreRequest);
}
