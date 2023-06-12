/** 
 * Copyright (C) 2023 BonitaSoft S.A.
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
import org.bonitasoft.web.client.model.PlatformLicense;

import feign.Headers;
import feign.RequestLine;
import feign.Response;

public interface LicenseApi extends ApiClient.Api {

    /**
     * Get the current server license Returns license information for the current server
     *
     * @return License
     */
    @RequestLine("GET /API/system/license/unusedid")
    @Headers({
            "Accept: application/json",
    })
    Response getLicense();

    /**
     * Get the platform License Returns the current platform License. This requires a platform
     * session. Log in using the platform login service.
     *
     * @return PlatformLicense
     */
    @RequestLine("GET /API/platform/license")
    @Headers({
            "Accept: application/json",
    })
    PlatformLicense getPlatformLicense();
}
