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
import org.bonitasoft.web.client.model.MaintenanceDetails;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public interface MaintenanceApi extends ApiClient.Api {

    /**
     * Get the maintenance details
     * Returns maintenance details of the platform
     * 
     * @return MaintenanceDetails
     */
    @RequestLine("GET /API/system/maintenance")
    @Headers({
            "Accept: application/json",
    })
    MaintenanceDetails getMaintenanceDetails();

    /**
     * Get the maintenance details
     * Similar to <code>getMaintenanceDetails</code> but it also returns the http response headers .
     * Returns maintenance details of the platform
     * 
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/system/maintenance")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<MaintenanceDetails> getMaintenanceDetailsWithHttpInfo();

    /**
     * Update the maintenance details
     * Update maintenance details
     * 
     * @param maintenanceDetails Maintenance details; One or all attributes can be updated (required)
     * @return MaintenanceDetails
     */
    @RequestLine("PUT /API/system/maintenance")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    MaintenanceDetails updateMaintenanceDetails(MaintenanceDetails maintenanceDetails);

    /**
     * Update the maintenance details
     * Similar to <code>updateMaintenanceDetails</code> but it also returns the http response headers .
     * Update maintenance details
     * 
     * @param maintenanceDetails Maintenance details; One or all attributes can be updated (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("PUT /API/system/maintenance")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<MaintenanceDetails> updateMaintenanceDetailsWithHttpInfo(MaintenanceDetails maintenanceDetails);

}
