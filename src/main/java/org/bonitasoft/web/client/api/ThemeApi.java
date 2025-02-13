/** 
 * Copyright (C) 2025 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.ThemeCreateRequest;
import org.bonitasoft.web.client.model.ThemeRestoreRequest;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.8.0")
public interface ThemeApi extends ApiClient.Api {

    /**
     * Create the Theme
     * Create the Theme Warning: Since Bonita 7.13, theme management is deprecated
     * 
     * @param body Partial Theme description (required)
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /API/portal/theme")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void createTheme(ThemeCreateRequest body);

    /**
     * Create the Theme
     * Similar to <code>createTheme</code> but it also returns the http response headers .
     * Create the Theme Warning: Since Bonita 7.13, theme management is deprecated
     * 
     * @param body Partial Theme description (required)
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /API/portal/theme")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<Void> createThemeWithHttpInfo(ThemeCreateRequest body);

    /**
     * Restore default Theme
     * Restore the default theme Warning: Since Bonita 7.13, theme management is deprecated
     * 
     * @param themeRestoreRequest Partial Theme description (required)
     * @deprecated
     */
    @Deprecated
    @RequestLine("PUT /API/portal/theme/unusedId")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void restoreTheme(ThemeRestoreRequest themeRestoreRequest);

    /**
     * Restore default Theme
     * Similar to <code>restoreTheme</code> but it also returns the http response headers .
     * Restore the default theme Warning: Since Bonita 7.13, theme management is deprecated
     * 
     * @param themeRestoreRequest Partial Theme description (required)
     * @deprecated
     */
    @Deprecated
    @RequestLine("PUT /API/portal/theme/unusedId")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<Void> restoreThemeWithHttpInfo(ThemeRestoreRequest themeRestoreRequest);

}
