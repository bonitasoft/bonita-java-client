package org.bonitasoft.web.client.internal.api;

import okhttp3.MultipartBody;
import org.bonitasoft.web.client.internal.model.InlineObject41;
import org.bonitasoft.web.client.internal.model.InlineObject42;
import org.bonitasoft.web.client.internal.model.Profile;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ProfileApi {
  /**
   * Create the Profile
   * Create the Profile 
   * @param body  (required)
   * @return Call&lt;Profile&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/portal/profile")
  Call<Profile> createProfile(
    @retrofit2.http.Body InlineObject41 body
  );

  /**
   * Delete the Profile by ID
   * Delete the single Profile for the given ID 
   * @param id ID of the Profile to delete (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("API/portal/profile/{id}")
  Call<Void> deleteProfileById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Finds Profiles
   * Finds Profiles with pagination params and filters  - can search on &#x60;name&#x60; - can filter on &#x60;name&#x60;,&#x60;hasNavigation&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;Profile&gt;&gt;
   */
  @GET("API/portal/profile")
  Call<List<Profile>> findProfiles(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("s") String s
  );

  /**
   * Finds the Profile by ID
   * Returns the single Profile for the given ID 
   * @param id ID of the Profile to return (required)
   * @return Call&lt;Profile&gt;
   */
  @GET("API/portal/profile/{id}")
  Call<Profile> getProfileById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Import profiles
   * Import profiles 
   * @param profileDataUpload Uploaded file (optional)
   * @param importPolicy Import policy (optional)
   * @return Call&lt;Void&gt;
   */
  @retrofit2.http.FormUrlEncoded
  @POST("services/profile/import")
  Call<Void> importProfiles(
    @retrofit2.http.Field("profileDataUpload") String profileDataUpload, @retrofit2.http.Field("importPolicy") String importPolicy
  );

  /**
   * Update the Profile by ID
   * Update the Profile for the given ID 
   * @param id ID of the Profile to return (required)
   * @param inlineObject42  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/portal/profile/{id}")
  Call<Void> updateProfileById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body InlineObject42 inlineObject42
  );

  /**
   * Upload profiles
   * Upload profiles 
   * @param file  (optional)
   * @return Call&lt;Void&gt;
   */
  @retrofit2.http.Multipart
  @POST("portal/profilesUpload")
  Call<Void> uploadprofiles(
    @retrofit2.http.Part MultipartBody.Part file
  );

}
