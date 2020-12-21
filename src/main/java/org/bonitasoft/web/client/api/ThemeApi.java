package org.bonitasoft.web.client.api;

import feign.*;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.ThemeCreateRequest;
import org.bonitasoft.web.client.model.ThemeRestoreRequest;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ThemeApi extends ApiClient.Api {

  /**
   * Create the Theme Create the Theme
   *
   * @param body Partial Theme description (required)
   */
  @RequestLine("POST /API/portal/theme")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void createTheme(ThemeCreateRequest body);

  /**
   * Restore default Theme Restore the default theme
   *
   * @param themeRestoreRequest Partial Theme description (required)
   */
  @RequestLine("PUT /API/portal/theme/unusedId")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void restoreTheme(ThemeRestoreRequest themeRestoreRequest);
}
