package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.InlineObject48;
import org.bonitasoft.web.client.internal.model.SystemTenant;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;

public interface SystemTenantApi {
  /**
   * Get the current Tenant
   * Pause and resume tenant services in order to do maintenance on a tenant. 
   * @return Call&lt;SystemTenant&gt;
   */
  @GET("API/system/tenant/unusedid")
  Call<SystemTenant> getSystemTenant();
    

  /**
   * Update the current Tenant
   * Pause or resume the current tenant. 
   * @param inlineObject48  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/system/tenant/unusedid")
  Call<Void> updateSystemTenant(
    @retrofit2.http.Body InlineObject48 inlineObject48
  );

}
