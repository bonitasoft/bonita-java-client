package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.EncodingUtils;

import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.SystemTenant;
import org.bonitasoft.web.client.internal.model.TenantPauseRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface SystemTenantApi extends ApiClient.Api {


  /**
   * Get the current Tenant
   * Pause and resume tenant services in order to do maintenance on a tenant. 
   * @return SystemTenant
   */
  @RequestLine("GET /API/system/tenant/unusedid")
  @Headers({
    "Accept: application/json",
  })
  SystemTenant getSystemTenant();

  /**
   * Update the current Tenant
   * Pause or resume the current tenant. 
   * @param tenantPauseRequest Partial SystemTenant description (required)
   */
  @RequestLine("PUT /API/system/tenant/unusedid")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateSystemTenant(TenantPauseRequest tenantPauseRequest);
}
