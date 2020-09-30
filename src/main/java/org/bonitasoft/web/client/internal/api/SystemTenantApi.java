package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.SystemTenant;
import org.bonitasoft.web.client.internal.model.TenantPauseRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
   * @param tenantPauseRequest Partial SystemTenant description (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/system/tenant/unusedid")
  Call<Void> updateSystemTenant(
    @retrofit2.http.Body TenantPauseRequest tenantPauseRequest
  );

}
