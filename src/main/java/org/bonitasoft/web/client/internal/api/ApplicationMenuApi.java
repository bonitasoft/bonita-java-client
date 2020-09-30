package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.ApplicationMenu;
import org.bonitasoft.web.client.internal.model.InlineObject2;
import org.bonitasoft.web.client.internal.model.InlineObject3;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ApplicationMenuApi {
  /**
   * New application menu item
   * Create an application menu item 
   * @param inlineObject2  (optional)
   * @return Call&lt;ApplicationMenu&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/living/application-menu")
  Call<ApplicationMenu> createApplicationMenu(
    @retrofit2.http.Body InlineObject2 inlineObject2
  );

  /**
   * Delete an application menu by ID
   * Delete a single application menu for the given ID
   * @param id ID of the application menu to delete (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("API/living/application-menu/{id}")
  Call<Void> deleteApplicationMenuById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Finds application menus
   * Returns application menus with pagination params and filters  - can order on &#x60;id&#x60;, &#x60;displayName&#x60;, &#x60;applicationId&#x60;, &#x60;applicationPageId&#x60;, &#x60;menuIndex&#x60;, &#x60;parentMenuId&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;id&#x60;, &#x60;displayName&#x60;, &#x60;applicationId&#x60;, &#x60;applicationPageId&#x60;, &#x60;menuIndex&#x60;, &#x60;parentMenuId&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;ApplicationMenu&gt;&gt;
   */
  @GET("API/living/application-menu")
  Call<List<ApplicationMenu>> findApplicationMenus(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

  /**
   * Finds a application menu by ID
   * Returns a single application menu for the given ID 
   * @param id ID of application menu to return (required)
   * @return Call&lt;ApplicationMenu&gt;
   */
  @GET("API/living/application-menu/{id}")
  Call<ApplicationMenu> geApplicationMenuById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Update a application menu by ID
   * Update a application menu for the given ID
   * @param id ID of the application menu to return (required)
   * @param inlineObject3  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/living/application-menu/{id}")
  Call<Void> updateApplicationMenuById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body InlineObject3 inlineObject3
  );

}
