package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.SystemTenant;
import org.bonitasoft.web.client.internal.model.TenantPauseRequest;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
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
