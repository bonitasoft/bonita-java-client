package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.EncodingUtils;
import org.bonitasoft.web.client.internal.model.User;
import org.bonitasoft.web.client.internal.model.UserCreateRequest;
import org.bonitasoft.web.client.internal.model.UserUpdateRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
public interface UserApi extends ApiClient.Api {


  /**
   * Create the User
   * Create the User 
   * @param body Partial User description (required)
   * @return User
   */
  @RequestLine("POST /API/identity/user")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  User createUser(UserCreateRequest body);

  /**
   * Delete the User by ID
   * Delete the single User for the given ID.  **Use this method with caution**: some artifacts like applications, cases or users may present display problems in the Bonita Portal if the referenced user was deleted. Note that you can disable a user instead of deleting it. To do so, use the UPDATE method and set the attribute &#39;enabled&#39; to false 
   * @param id ID of the User to delete (required)
   */
  @RequestLine("DELETE /API/identity/user/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteUserById(@Param("id") String id);

  /**
   * Finds Users
   * Finds Users with pagination params and filters  - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return List&lt;User&gt;
   */
  @RequestLine("GET /API/identity/user?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  List<User> findUsers(@Param("p") Integer p, @Param("c") Integer c, @Param("f") String f, @Param("o") String o, @Param("s") String s);

  /**
   * Finds Users
   * Finds Users with pagination params and filters  - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60; 
   * Note, this is equivalent to the other <code>findUsers</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindUsersQueryParams} class that allows for
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
   * @return List&lt;User&gt;
   */
  @RequestLine("GET /API/identity/user?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
  "Accept: application/json",
  })
  List<User> findUsers(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findUsers</code> method in a fluent style.
   */
  public static class FindUsersQueryParams extends HashMap<String, Object> {
    public FindUsersQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public FindUsersQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public FindUsersQueryParams f(final String value) {
      put("f", EncodingUtils.encode(value));
      return this;
    }
    public FindUsersQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
    public FindUsersQueryParams s(final String value) {
      put("s", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Finds the User by ID
   * Returns the single User for the given ID 
   * @param id ID of the User to return (required)
   * @return User
   */
  @RequestLine("GET /API/identity/user/{id}")
  @Headers({
    "Accept: application/json",
  })
  User getUserById(@Param("id") String id);

  /**
   * Update the User by ID
   * Update the User for the given ID 
   * @param id ID of the User to return (required)
   * @param userUpdateRequest Partial User description (required)
   */
  @RequestLine("PUT /API/identity/user/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateUserById(@Param("id") String id, UserUpdateRequest userUpdateRequest);
}
