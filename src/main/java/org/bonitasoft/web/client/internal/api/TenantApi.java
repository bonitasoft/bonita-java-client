package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.InlineObject35;
import org.bonitasoft.web.client.internal.model.InlineObject36;
import org.bonitasoft.web.client.internal.model.Tenant;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface TenantApi {
  /**
   * Create the Tenant
   * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Create the Tenant 
   * @param body  (required)
   * @return Call&lt;Tenant&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/platform/tenant")
  Call<Tenant> createTenant(
    @retrofit2.http.Body InlineObject35 body
  );

  /**
   * Delete the Tenant by ID
   * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Delete the single Tenant for the given ID 
   * @param id ID of the Tenant to delete (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("API/platform/tenant/{id}")
  Call<Void> deleteTenantById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Finds Tenants
   * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Finds Tenants with pagination params and filters  - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;Tenant&gt;&gt;
   */
  @GET("API/platform/tenant")
  Call<List<Tenant>> findTenants(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

  /**
   * Finds the Tenant by ID
   * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Returns the single Tenant for the given ID 
   * @param id ID of the Tenant to return (required)
   * @return Call&lt;Tenant&gt;
   */
  @GET("API/platform/tenant/{id}")
  Call<Tenant> getTenantById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Update the Tenant by ID
   * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Update the Tenant for the given ID 
   * @param id ID of the Tenant to return (required)
   * @param inlineObject36  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/platform/tenant/{id}")
  Call<Void> updateTenantById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body InlineObject36 inlineObject36
  );

}
