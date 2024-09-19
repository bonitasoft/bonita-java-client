/** 
 * Copyright (C) 2024 BonitaSoft S.A.
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
import org.bonitasoft.web.client.model.SystemInformation;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public interface InformationApi extends ApiClient.Api {

    /**
     * Get the system information
     * Returns system information details of the platform. Requires to be logged in as a user having the Admin profile.
     * 
     * @return SystemInformation
     */
    @RequestLine("GET /API/system/information")
    @Headers({
            "Accept: application/json",
    })
    SystemInformation getSystemInformation();

    /**
     * Get the system information
     * Similar to <code>getSystemInformation</code> but it also returns the http response headers .
     * Returns system information details of the platform. Requires to be logged in as a user having the Admin profile.
     * 
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/system/information")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<SystemInformation> getSystemInformationWithHttpInfo();

}
