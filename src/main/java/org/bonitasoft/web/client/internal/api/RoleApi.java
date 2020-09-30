package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.InlineObject29;
import org.bonitasoft.web.client.internal.model.InlineObject30;
import org.bonitasoft.web.client.internal.model.Role;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface RoleApi {
  /**
   * Create the Role
   * Create the Role 
   * @param body  (required)
   * @return Call&lt;Role&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/identity/role")
  Call<Role> createRole(
    @retrofit2.http.Body InlineObject29 body
  );

  /**
   * Delete the Role by ID
   * Delete the single Role for the given ID 
   * @param id ID of the Role to delete (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("API/identity/role/{id}")
  Call<Void> deleteRoleById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Finds Roles
   * Finds Roles with pagination params and filters  - can order on &#x60;id&#x60;, &#x60;name&#x60; and &#x60;displayName&#x60; - can filter on &#x60;name&#x60; and &#x60;displayName&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;Role&gt;&gt;
   */
  @GET("API/identity/role")
  Call<List<Role>> findRoles(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

  /**
   * Finds the Role by ID
   * Returns the single Role for the given ID 
   * @param id ID of the Role to return (required)
   * @return Call&lt;Role&gt;
   */
  @GET("API/identity/role/{id}")
  Call<Role> getRoleById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Update the Role by ID
   * Update the Role for the given ID 
   * @param id ID of the Role to return (required)
   * @param inlineObject30  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/identity/role/{id}")
  Call<Void> updateRoleById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body InlineObject30 inlineObject30
  );

}
