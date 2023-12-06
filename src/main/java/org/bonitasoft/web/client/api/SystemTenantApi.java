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
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.SystemTenant;
import org.bonitasoft.web.client.model.TenantPauseRequest;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface SystemTenantApi extends ApiClient.Api {

    /**
     * Get the current Tenant
     * Pause and resume tenant services in order to do maintenance on a tenant. Warning: since Bonita 9.0.0, /API/system/tenant API resource is deprecated. Use
     * /API/system/maintenance instead to retrieve the maintenance state.
     * 
     * @param id ID of the tenant (required)
     * @return SystemTenant
     * @deprecated
     */
    @Deprecated
    @RequestLine("GET /API/system/tenant/{id}")
    @Headers({
            "Accept: application/json",
    })
    SystemTenant getSystemTenant(@Param("id") String id);

    /**
     * Get the current Tenant
     * Similar to <code>getSystemTenant</code> but it also returns the http response headers .
     * Pause and resume tenant services in order to do maintenance on a tenant. Warning: since Bonita 9.0.0, /API/system/tenant API resource is deprecated. Use
     * /API/system/maintenance instead to retrieve the maintenance state.
     * 
     * @param id ID of the tenant (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     * @deprecated
     */
    @Deprecated
    @RequestLine("GET /API/system/tenant/{id}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<SystemTenant> getSystemTenantWithHttpInfo(@Param("id") String id);

    /**
     * Update the current Tenant
     * Pause or resume the current tenant. Warning: since Bonita 9.0.0, /API/system/tenant API resource is deprecated. Use /API/system/maintenance instead to enable
     * the maintenance mode (same behavior as pausing the tenant).
     * 
     * @param id ID of the tenant (required)
     * @param tenantPauseRequest Partial SystemTenant description (required)
     * @deprecated
     */
    @Deprecated
    @RequestLine("PUT /API/system/tenant/{id}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void updateSystemTenant(@Param("id") String id, TenantPauseRequest tenantPauseRequest);

    /**
     * Update the current Tenant
     * Similar to <code>updateSystemTenant</code> but it also returns the http response headers .
     * Pause or resume the current tenant. Warning: since Bonita 9.0.0, /API/system/tenant API resource is deprecated. Use /API/system/maintenance instead to enable
     * the maintenance mode (same behavior as pausing the tenant).
     * 
     * @param id ID of the tenant (required)
     * @param tenantPauseRequest Partial SystemTenant description (required)
     * @deprecated
     */
    @Deprecated
    @RequestLine("PUT /API/system/tenant/{id}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<Void> updateSystemTenantWithHttpInfo(@Param("id") String id, TenantPauseRequest tenantPauseRequest);

}
