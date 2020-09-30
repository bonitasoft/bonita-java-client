package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.InlineObject28;
import org.bonitasoft.web.client.internal.model.Membership;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import java.util.List;

public interface MembershipApi {
  /**
   * Create the Membership
   * Create the Membership 
   * @param body  (required)
   * @return Call&lt;Membership&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/identity/membership")
  Call<Membership> createMembership(
    @retrofit2.http.Body InlineObject28 body
  );

  /**
   * Delete the Membership by ID
   * Delete a membership of a user using the group id and role id. 
   * @param userId User ID of the Membership to delete (required)
   * @param groupId Group ID of the Membership to delete (required)
   * @param roleId Role ID of the Membership to delete (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("API/identity/membership/{userId}/{groupId}/{roleId}")
  Call<Void> deleteMembershipById(
    @retrofit2.http.Path("userId") String userId, @retrofit2.http.Path("groupId") String groupId, @retrofit2.http.Path("roleId") String roleId
  );

  /**
   * Finds Memberships
   * Finds Memberships with pagination params and filters  **Filter &#x60;user_id&#x60; is mandatory**  You can order with the values: &#x60;ROLE_NAME_ASC&#x60;,&#x60;ROLE_NAME_DESC&#x60;, &#x60;GROUP_NAME_ASC&#x60;,&#x60;GROUP_NAME_DESC&#x60;, &#x60;ASSIGNED_DATE_ASC&#x60;, &#x60;ASSIGNED_DATE_DESC&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;Membership&gt;&gt;
   */
  @GET("API/identity/membership")
  Call<List<Membership>> findMemberships(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

}
