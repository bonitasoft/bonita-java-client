package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.Role;
import org.bonitasoft.web.client.model.RoleCreateRequest;
import org.bonitasoft.web.client.model.RoleUpdateRequest;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface RoleApi extends ApiClient.Api {


  /**
   * Create the Role
   * Create the Role 
   * @param body Partial Role description (required)
   * @return Role
   */
  @RequestLine("POST /API/identity/role")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Role createRole(RoleCreateRequest body);

  /**
   * Create the Role
   * Similar to <code>createRole</code> but it also returns the http response headers .
   * Create the Role 
   * @param body Partial Role description (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /API/identity/role")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Role> createRoleWithHttpInfo(RoleCreateRequest body);



  /**
   * Delete the Role by ID
   * Delete the single Role for the given ID 
   * @param id ID of the Role to delete (required)
   */
  @RequestLine("DELETE /API/identity/role/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteRoleById(@Param("id") String id);

  /**
   * Delete the Role by ID
   * Similar to <code>deleteRoleById</code> but it also returns the http response headers .
   * Delete the single Role for the given ID 
   * @param id ID of the Role to delete (required)
   */
  @RequestLine("DELETE /API/identity/role/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteRoleByIdWithHttpInfo(@Param("id") String id);



  /**
   * Finds the Role by ID
   * Returns the single Role for the given ID 
   * @param id ID of the Role to return (required)
   * @return Role
   */
  @RequestLine("GET /API/identity/role/{id}")
  @Headers({
    "Accept: application/json",
  })
  Role getRoleById(@Param("id") String id);

  /**
   * Finds the Role by ID
   * Similar to <code>getRoleById</code> but it also returns the http response headers .
   * Returns the single Role for the given ID 
   * @param id ID of the Role to return (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/identity/role/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Role> getRoleByIdWithHttpInfo(@Param("id") String id);



  /**
   * Finds Roles
   * Finds Roles with pagination params and filters  - can order on &#x60;id&#x60;, &#x60;name&#x60; and &#x60;displayName&#x60; - can filter on &#x60;name&#x60; and &#x60;displayName&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return List&lt;Role&gt;
   */
  @RequestLine("GET /API/identity/role?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  List<Role> searchRoles(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

  /**
   * Finds Roles
   * Similar to <code>searchRoles</code> but it also returns the http response headers .
   * Finds Roles with pagination params and filters  - can order on &#x60;id&#x60;, &#x60;name&#x60; and &#x60;displayName&#x60; - can filter on &#x60;name&#x60; and &#x60;displayName&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/identity/role?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<Role>> searchRolesWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);


  /**
   * Finds Roles
   * Finds Roles with pagination params and filters  - can order on &#x60;id&#x60;, &#x60;name&#x60; and &#x60;displayName&#x60; - can filter on &#x60;name&#x60; and &#x60;displayName&#x60; 
   * Note, this is equivalent to the other <code>searchRoles</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchRolesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   <li>o - can order on attributes (optional)</li>
   *   <li>s - can search on attributes (optional)</li>
   *   </ul>
   * @return List&lt;Role&gt;
   */
  @RequestLine("GET /API/identity/role?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
  "Accept: application/json",
  })
  List<Role> searchRoles(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
  * Finds Roles
  * Finds Roles with pagination params and filters  - can order on &#x60;id&#x60;, &#x60;name&#x60; and &#x60;displayName&#x60; - can filter on &#x60;name&#x60; and &#x60;displayName&#x60; 
  * Note, this is equivalent to the other <code>searchRoles</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>p - index of the page to display (required)</li>
          *   <li>c - maximum number of elements to retrieve (required)</li>
          *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
          *   <li>o - can order on attributes (optional)</li>
          *   <li>s - can search on attributes (optional)</li>
      *   </ul>
          * @return List&lt;Role&gt;
      */
      @RequestLine("GET /API/identity/role?p={p}&c={c}&f={f}&o={o}&s={s}")
      @Headers({
    "Accept: application/json",
      })
   ApiResponse<List<Role>> searchRolesWithHttpInfo(@QueryMap(encoded=true) Map<String, Object> queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>searchRoles</code> method in a fluent style.
   */
  public static class SearchRolesQueryParams extends HashMap<String, Object> {
    public SearchRolesQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public SearchRolesQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public SearchRolesQueryParams f(final List<String> value) {
      put("f", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public SearchRolesQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
    public SearchRolesQueryParams s(final String value) {
      put("s", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Update the Role by ID
   * Update the Role for the given ID 
   * @param id ID of the Role to return (required)
   * @param roleUpdateRequest Partial Role description (required)
   */
  @RequestLine("PUT /API/identity/role/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateRoleById(@Param("id") String id, RoleUpdateRequest roleUpdateRequest);

  /**
   * Update the Role by ID
   * Similar to <code>updateRoleById</code> but it also returns the http response headers .
   * Update the Role for the given ID 
   * @param id ID of the Role to return (required)
   * @param roleUpdateRequest Partial Role description (required)
   */
  @RequestLine("PUT /API/identity/role/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Void> updateRoleByIdWithHttpInfo(@Param("id") String id, RoleUpdateRequest roleUpdateRequest);


}
