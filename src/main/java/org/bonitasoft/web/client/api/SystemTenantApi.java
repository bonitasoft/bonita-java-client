package org.bonitasoft.web.client.api;

import feign.*;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.SystemTenant;
import org.bonitasoft.web.client.model.TenantPauseRequest;

public interface SystemTenantApi extends ApiClient.Api {

  /**
   * Get the current Tenant Pause and resume tenant services in order to do maintenance on a tenant.
   *
   * @param id ID of the tenant (required)
   * @return SystemTenant
   */
  @RequestLine("GET /API/system/tenant/{id}")
  @Headers({
    "Accept: application/json",
  })
  SystemTenant getSystemTenant(@Param("id") String id);

  /**
   * Update the current Tenant Pause or resume the current tenant.
   *
   * @param id ID of the tenant (required)
   * @param tenantPauseRequest Partial SystemTenant description (required)
   */
  @RequestLine("PUT /API/system/tenant/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateSystemTenant(@Param("id") String id, TenantPauseRequest tenantPauseRequest);
}
