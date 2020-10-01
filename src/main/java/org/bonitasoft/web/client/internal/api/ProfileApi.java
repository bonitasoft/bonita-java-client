package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.EncodingUtils;
import org.bonitasoft.web.client.internal.model.Profile;
import org.bonitasoft.web.client.internal.model.ProfileCreateRequest;
import org.bonitasoft.web.client.internal.model.ProfileUpdateRequest;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
public interface ProfileApi extends ApiClient.Api {


  /**
   * Create the Profile
   * Create the Profile 
   * @param body Partial Profile description (required)
   * @return Profile
   */
  @RequestLine("POST /API/portal/profile")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Profile createProfile(ProfileCreateRequest body);

  /**
   * Delete the Profile by ID
   * Delete the single Profile for the given ID 
   * @param id ID of the Profile to delete (required)
   */
  @RequestLine("DELETE /API/portal/profile/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteProfileById(@Param("id") String id);

  /**
   * Finds Profiles
   * Finds Profiles with pagination params and filters  - can search on &#x60;name&#x60; - can filter on &#x60;name&#x60;,&#x60;hasNavigation&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param s can search on attributes (optional)
   * @return List&lt;Profile&gt;
   */
  @RequestLine("GET /API/portal/profile?p={p}&c={c}&f={f}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  List<Profile> findProfiles(@Param("p") Integer p, @Param("c") Integer c, @Param("f") String f, @Param("s") String s);

  /**
   * Finds Profiles
   * Finds Profiles with pagination params and filters  - can search on &#x60;name&#x60; - can filter on &#x60;name&#x60;,&#x60;hasNavigation&#x60; 
   * Note, this is equivalent to the other <code>findProfiles</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindProfilesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   <li>s - can search on attributes (optional)</li>
   *   </ul>
   * @return List&lt;Profile&gt;
   */
  @RequestLine("GET /API/portal/profile?p={p}&c={c}&f={f}&s={s}")
  @Headers({
  "Accept: application/json",
  })
  List<Profile> findProfiles(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findProfiles</code> method in a fluent style.
   */
  public static class FindProfilesQueryParams extends HashMap<String, Object> {
    public FindProfilesQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public FindProfilesQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public FindProfilesQueryParams f(final String value) {
      put("f", EncodingUtils.encode(value));
      return this;
    }
    public FindProfilesQueryParams s(final String value) {
      put("s", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Finds the Profile by ID
   * Returns the single Profile for the given ID 
   * @param id ID of the Profile to return (required)
   * @return Profile
   */
  @RequestLine("GET /API/portal/profile/{id}")
  @Headers({
    "Accept: application/json",
  })
  Profile getProfileById(@Param("id") String id);

  /**
   * Import profiles
   * Import profiles 
   * @param profileDataUpload Uploaded file (optional)
   * @param importPolicy Import policy (optional)
   */
  @RequestLine("POST /services/profile/import")
  @Headers({
    "Content-Type: application/x-www-form-urlencoded",
    "Accept: application/json",
  })
  void importProfiles(@Param("profileDataUpload") String profileDataUpload, @Param("importPolicy") String importPolicy);

  /**
   * Update the Profile by ID
   * Update the Profile for the given ID 
   * @param id ID of the Profile to return (required)
   * @param profileUpdateRequest Partial Profile description (required)
   */
  @RequestLine("PUT /API/portal/profile/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateProfileById(@Param("id") String id, ProfileUpdateRequest profileUpdateRequest);

  /**
   * Upload profiles
   * Upload profiles 
   * @param file  (optional)
   */
  @RequestLine("POST /portal/profilesUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  void uploadprofiles(@Param("file") File file);
}
