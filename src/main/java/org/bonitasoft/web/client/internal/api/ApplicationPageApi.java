package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.ApplicationPage;
import org.bonitasoft.web.client.internal.model.InlineObject4;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import java.util.List;

public interface ApplicationPageApi {
  /**
   * Create an application page
   * Create an application page 
   * @param body  (required)
   * @return Call&lt;ApplicationPage&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/living/application-page")
  Call<ApplicationPage> createApplicationPage(
    @retrofit2.http.Body InlineObject4 body
  );

  /**
   * Delete an application page by ID
   * Delete a single application page for the given ID 
   * @param id ID of application page to delete (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("API/living/application-page/{id}")
  Call<Void> deleteApplicationPageById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Finds application pages
   * Finds application pages with pagination params and filters  - can order on &#x60;id&#x60;, &#x60;token&#x60;, &#x60;applicationId&#x60;, &#x60;pageId&#x60; - can search on &#x60;token&#x60; - can filter on &#x60;id&#x60;, &#x60;token&#x60;, &#x60;applicationId&#x60;, &#x60;pageId&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;ApplicationPage&gt;&gt;
   */
  @GET("API/living/application-page")
  Call<List<ApplicationPage>> findApplicationPages(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

  /**
   * Finds an application page by ID
   * Returns a single application page for the given ID 
   * @param id ID of application page to return (required)
   * @return Call&lt;ApplicationPage&gt;
   */
  @GET("API/living/application-page/{id}")
  Call<ApplicationPage> getApplicationPageById(
    @retrofit2.http.Path("id") String id
  );

}
