package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.Group;
import org.bonitasoft.web.client.internal.model.InlineObject26;
import org.bonitasoft.web.client.internal.model.InlineObject27;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface GroupApi {
  /**
   * Create the Group
   * Create the Group 
   * @param body  (required)
   * @return Call&lt;Group&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/identity/group")
  Call<Group> createGroup(
    @retrofit2.http.Body InlineObject26 body
  );

  /**
   * Delete the Group by ID
   * Delete the single Group for the given ID 
   * @param id ID of the Group to delete (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("API/identity/group/{id}")
  Call<Void> deleteGroupById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Finds Groups
   * Finds Groups with pagination params and filters.  - can order on &#x60;id&#x60;,&#x60;name&#x60;,&#x60;displayName&#x60; - can filter on &#x60;name&#x60;,&#x60;displayName&#x60;,&#x60;parent_path&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return Call&lt;List&lt;Group&gt;&gt;
   */
  @GET("API/identity/group")
  Call<List<Group>> findGroups(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o
  );

  /**
   * Finds the Group by ID
   * Returns the single Group for the given ID 
   * @param id ID of the Group to return (required)
   * @return Call&lt;Group&gt;
   */
  @GET("API/identity/group/{id}")
  Call<Group> getGroupById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Update the Group by ID
   * Update the Group for the given ID 
   * @param id ID of the Group to return (required)
   * @param inlineObject27  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/identity/group/{id}")
  Call<Void> updateGroupById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body InlineObject27 inlineObject27
  );

}
