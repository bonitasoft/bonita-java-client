package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.User;
import org.bonitasoft.web.client.internal.model.UserCreateRequest;
import org.bonitasoft.web.client.internal.model.UserUpdateRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserApi {
  /**
   * Create the User
   * Create the User 
   * @param body Partial User description (required)
   * @return Call&lt;User&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/identity/user")
  Call<User> createUser(
    @retrofit2.http.Body UserCreateRequest body
  );

  /**
   * Delete the User by ID
   * Delete the single User for the given ID.  **Use this method with caution**: some artifacts like applications, cases or users may present display problems in the Bonita Portal if the referenced user was deleted. Note that you can disable a user instead of deleting it. To do so, use the UPDATE method and set the attribute &#39;enabled&#39; to false 
   * @param id ID of the User to delete (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("API/identity/user/{id}")
  Call<Void> deleteUserById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Finds Users
   * Finds Users with pagination params and filters  - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;User&gt;&gt;
   */
  @GET("API/identity/user")
  Call<List<User>> findUsers(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

  /**
   * Finds the User by ID
   * Returns the single User for the given ID 
   * @param id ID of the User to return (required)
   * @return Call&lt;User&gt;
   */
  @GET("API/identity/user/{id}")
  Call<User> getUserById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Update the User by ID
   * Update the User for the given ID 
   * @param id ID of the User to return (required)
   * @param userUpdateRequest Partial User description (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/identity/user/{id}")
  Call<Void> updateUserById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body UserUpdateRequest userUpdateRequest
  );

}
