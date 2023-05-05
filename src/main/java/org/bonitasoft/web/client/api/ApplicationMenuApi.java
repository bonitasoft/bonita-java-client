package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.List;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.ApplicationMenu;
import org.bonitasoft.web.client.model.ApplicationMenuCreateRequest;
import org.bonitasoft.web.client.model.ApplicationMenuUpdateRequest;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ApplicationMenuApi extends ApiClient.Api {


  /**
   * New application menu item
   * Create an application menu item 
   * @param applicationMenuCreateRequest A partial representation of an application menu in JSON (optional)
   * @return ApplicationMenu
   */
  @RequestLine("POST /API/living/application-menu")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApplicationMenu createApplicationMenu(ApplicationMenuCreateRequest applicationMenuCreateRequest);

  /**
   * New application menu item
   * Similar to <code>createApplicationMenu</code> but it also returns the http response headers .
   * Create an application menu item 
   * @param applicationMenuCreateRequest A partial representation of an application menu in JSON (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /API/living/application-menu")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<ApplicationMenu> createApplicationMenuWithHttpInfo(ApplicationMenuCreateRequest applicationMenuCreateRequest);



  /**
   * Delete an application menu by ID
   * Delete a single application menu for the given ID
   * @param id ID of the application menu to delete (required)
   */
  @RequestLine("DELETE /API/living/application-menu/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteApplicationMenuById(@Param("id") String id);

  /**
   * Delete an application menu by ID
   * Similar to <code>deleteApplicationMenuById</code> but it also returns the http response headers .
   * Delete a single application menu for the given ID
   * @param id ID of the application menu to delete (required)
   */
  @RequestLine("DELETE /API/living/application-menu/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteApplicationMenuByIdWithHttpInfo(@Param("id") String id);



  /**
   * Finds a application menu by ID
   * Returns a single application menu for the given ID 
   * @param id ID of application menu to return (required)
   * @return ApplicationMenu
   */
  @RequestLine("GET /API/living/application-menu/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApplicationMenu geApplicationMenuById(@Param("id") String id);

  /**
   * Finds a application menu by ID
   * Similar to <code>geApplicationMenuById</code> but it also returns the http response headers .
   * Returns a single application menu for the given ID 
   * @param id ID of application menu to return (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/living/application-menu/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<ApplicationMenu> geApplicationMenuByIdWithHttpInfo(@Param("id") String id);



  /**
   * Finds application menus
   * Returns application menus with pagination params and filters  - can order on &#x60;id&#x60;, &#x60;displayName&#x60;, &#x60;applicationId&#x60;, &#x60;applicationPageId&#x60;, &#x60;menuIndex&#x60;, &#x60;parentMenuId&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;id&#x60;, &#x60;displayName&#x60;, &#x60;applicationId&#x60;, &#x60;applicationPageId&#x60;, &#x60;menuIndex&#x60;, &#x60;parentMenuId&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return List&lt;ApplicationMenu&gt;
   */
  @RequestLine("GET /API/living/application-menu?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  List<ApplicationMenu> searchApplicationMenus(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

  /**
   * Finds application menus
   * Similar to <code>searchApplicationMenus</code> but it also returns the http response headers .
   * Returns application menus with pagination params and filters  - can order on &#x60;id&#x60;, &#x60;displayName&#x60;, &#x60;applicationId&#x60;, &#x60;applicationPageId&#x60;, &#x60;menuIndex&#x60;, &#x60;parentMenuId&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;id&#x60;, &#x60;displayName&#x60;, &#x60;applicationId&#x60;, &#x60;applicationPageId&#x60;, &#x60;menuIndex&#x60;, &#x60;parentMenuId&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/living/application-menu?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<ApplicationMenu>> searchApplicationMenusWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);


  /**
   * Finds application menus
   * Returns application menus with pagination params and filters  - can order on &#x60;id&#x60;, &#x60;displayName&#x60;, &#x60;applicationId&#x60;, &#x60;applicationPageId&#x60;, &#x60;menuIndex&#x60;, &#x60;parentMenuId&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;id&#x60;, &#x60;displayName&#x60;, &#x60;applicationId&#x60;, &#x60;applicationPageId&#x60;, &#x60;menuIndex&#x60;, &#x60;parentMenuId&#x60; 
   * Note, this is equivalent to the other <code>searchApplicationMenus</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchApplicationMenusQueryParams} class that allows for
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
   * @return List&lt;ApplicationMenu&gt;
   */
  @RequestLine("GET /API/living/application-menu?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
  "Accept: application/json",
  })
  List<ApplicationMenu> searchApplicationMenus(@QueryMap(encoded=true) SearchApplicationMenusQueryParams queryParams);

  /**
  * Finds application menus
  * Returns application menus with pagination params and filters  - can order on &#x60;id&#x60;, &#x60;displayName&#x60;, &#x60;applicationId&#x60;, &#x60;applicationPageId&#x60;, &#x60;menuIndex&#x60;, &#x60;parentMenuId&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;id&#x60;, &#x60;displayName&#x60;, &#x60;applicationId&#x60;, &#x60;applicationPageId&#x60;, &#x60;menuIndex&#x60;, &#x60;parentMenuId&#x60; 
  * Note, this is equivalent to the other <code>searchApplicationMenus</code> that receives the query parameters as a map,
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
          * @return List&lt;ApplicationMenu&gt;
      */
      @RequestLine("GET /API/living/application-menu?p={p}&c={c}&f={f}&o={o}&s={s}")
      @Headers({
    "Accept: application/json",
      })
   ApiResponse<List<ApplicationMenu>> searchApplicationMenusWithHttpInfo(@QueryMap(encoded=true) SearchApplicationMenusQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>searchApplicationMenus</code> method in a fluent style.
   */
  public static class SearchApplicationMenusQueryParams extends HashMap<String, Object> {
    public SearchApplicationMenusQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public SearchApplicationMenusQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public SearchApplicationMenusQueryParams f(final List<String> value) {
      put("f", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public SearchApplicationMenusQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
    public SearchApplicationMenusQueryParams s(final String value) {
      put("s", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Update a application menu by ID
   * Update a application menu for the given ID
   * @param id ID of the application menu to return (required)
   * @param applicationMenuUpdateRequest Partial application menu description (required)
   */
  @RequestLine("PUT /API/living/application-menu/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateApplicationMenuById(@Param("id") String id, ApplicationMenuUpdateRequest applicationMenuUpdateRequest);

  /**
   * Update a application menu by ID
   * Similar to <code>updateApplicationMenuById</code> but it also returns the http response headers .
   * Update a application menu for the given ID
   * @param id ID of the application menu to return (required)
   * @param applicationMenuUpdateRequest Partial application menu description (required)
   */
  @RequestLine("PUT /API/living/application-menu/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Void> updateApplicationMenuByIdWithHttpInfo(@Param("id") String id, ApplicationMenuUpdateRequest applicationMenuUpdateRequest);


}
