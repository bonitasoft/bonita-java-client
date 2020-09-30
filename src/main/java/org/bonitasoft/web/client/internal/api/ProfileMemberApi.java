package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.InlineObject45;
import org.bonitasoft.web.client.internal.model.ProfileMember;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import java.util.List;

public interface ProfileMemberApi {
  /**
   * Create the ProfileMember
   * Create the ProfileMember 
   * @param body  (required)
   * @return Call&lt;ProfileMember&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/portal/profileMember")
  Call<ProfileMember> createProfileMember(
    @retrofit2.http.Body InlineObject45 body
  );

  /**
   * Delete the ProfileMember by ID
   * Delete the single ProfileMember for the given ID 
   * @param id ID of the ProfileMember to delete (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("API/portal/profileMember/{id}")
  Call<Void> deleteProfileMemberById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Finds ProfileMembers
   * Finds ProfileMembers with pagination params and filters  **Filter &#x60;member_type&#x60; is mandatory**  You can filter on &#x60;profile_id&#x60;, &#x60;user_id&#x60;, &#x60;role_id&#x60; and &#x60;group_id&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @return Call&lt;List&lt;ProfileMember&gt;&gt;
   */
  @GET("API/portal/profileMember")
  Call<List<ProfileMember>> findProfileMembers(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f
  );

  /**
   * Finds the ProfileMember by ID
   * Returns the single ProfileMember for the given ID 
   * @param id ID of the ProfileMember to return (required)
   * @return Call&lt;ProfileMember&gt;
   */
  @GET("API/portal/profileMember/{id}")
  Call<ProfileMember> getProfileMemberById(
    @retrofit2.http.Path("id") String id
  );

}
