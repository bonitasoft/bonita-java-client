package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;

import org.bonitasoft.web.client.model.Error;
import org.bonitasoft.web.client.model.ProfileMember;
import org.bonitasoft.web.client.model.ProfileMemberCreateRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface ProfileMemberApi extends ApiClient.Api {


  /**
   * Create the ProfileMember
   * Create the ProfileMember 
   * @param body Partial ProfileMember description (required)
   * @return ProfileMember
   */
  @RequestLine("POST /API/portal/profileMember")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ProfileMember createProfileMember(ProfileMemberCreateRequest body);

  /**
   * Delete the ProfileMember by ID
   * Delete the single ProfileMember for the given ID 
   * @param id ID of the ProfileMember to delete (required)
   */
  @RequestLine("DELETE /API/portal/profileMember/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteProfileMemberById(@Param("id") String id);

  /**
   * Finds ProfileMembers
   * Finds ProfileMembers with pagination params and filters  **Filter &#x60;member_type&#x60; is mandatory**  You can filter on &#x60;profile_id&#x60;, &#x60;user_id&#x60;, &#x60;role_id&#x60; and &#x60;group_id&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @return List&lt;ProfileMember&gt;
   */
  @RequestLine("GET /API/portal/profileMember?p={p}&c={c}&f={f}")
  @Headers({
    "Accept: application/json",
  })
  List<ProfileMember> findProfileMembers(@Param("p") Integer p, @Param("c") Integer c, @Param("f") String f);

  /**
   * Finds ProfileMembers
   * Finds ProfileMembers with pagination params and filters  **Filter &#x60;member_type&#x60; is mandatory**  You can filter on &#x60;profile_id&#x60;, &#x60;user_id&#x60;, &#x60;role_id&#x60; and &#x60;group_id&#x60; 
   * Note, this is equivalent to the other <code>findProfileMembers</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindProfileMembersQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   </ul>
   * @return List&lt;ProfileMember&gt;
   */
  @RequestLine("GET /API/portal/profileMember?p={p}&c={c}&f={f}")
  @Headers({
  "Accept: application/json",
  })
  List<ProfileMember> findProfileMembers(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findProfileMembers</code> method in a fluent style.
   */
  public static class FindProfileMembersQueryParams extends HashMap<String, Object> {
    public FindProfileMembersQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public FindProfileMembersQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public FindProfileMembersQueryParams f(final String value) {
      put("f", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Finds the ProfileMember by ID
   * Returns the single ProfileMember for the given ID 
   * @param id ID of the ProfileMember to return (required)
   * @return ProfileMember
   */
  @RequestLine("GET /API/portal/profileMember/{id}")
  @Headers({
    "Accept: application/json",
  })
  ProfileMember getProfileMemberById(@Param("id") String id);
}
