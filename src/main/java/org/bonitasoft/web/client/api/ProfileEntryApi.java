package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.ProfileEntry;
import org.bonitasoft.web.client.model.ProfileEntryCreateRequest;
import org.bonitasoft.web.client.model.ProfileEntryUpdateRequest;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ProfileEntryApi extends ApiClient.Api {


  /**
   * Create the ProfileEntry
   * Create the ProfileEntry 
   * @param body Partial ProfileEntry description (required)
   * @return ProfileEntry
   */
  @RequestLine("POST /API/portal/profileEntry")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ProfileEntry createProfileEntry(ProfileEntryCreateRequest body);

  /**
   * Create the ProfileEntry
   * Similar to <code>createProfileEntry</code> but it also returns the http response headers .
   * Create the ProfileEntry 
   * @param body Partial ProfileEntry description (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /API/portal/profileEntry")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<ProfileEntry> createProfileEntryWithHttpInfo(ProfileEntryCreateRequest body);



  /**
   * Delete the ProfileEntry by ID
   * Delete the single ProfileEntry for the given ID 
   * @param id ID of the ProfileEntry to delete (required)
   */
  @RequestLine("DELETE /API/portal/profileEntry/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteProfileEntryById(@Param("id") String id);

  /**
   * Delete the ProfileEntry by ID
   * Similar to <code>deleteProfileEntryById</code> but it also returns the http response headers .
   * Delete the single ProfileEntry for the given ID 
   * @param id ID of the ProfileEntry to delete (required)
   */
  @RequestLine("DELETE /API/portal/profileEntry/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteProfileEntryByIdWithHttpInfo(@Param("id") String id);



  /**
   * Finds the ProfileEntry by ID
   * Returns the single ProfileEntry for the given ID 
   * @param id ID of the ProfileEntry to return (required)
   * @return ProfileEntry
   */
  @RequestLine("GET /API/portal/profileEntry/{id}")
  @Headers({
    "Accept: application/json",
  })
  ProfileEntry getProfileEntryById(@Param("id") String id);

  /**
   * Finds the ProfileEntry by ID
   * Similar to <code>getProfileEntryById</code> but it also returns the http response headers .
   * Returns the single ProfileEntry for the given ID 
   * @param id ID of the ProfileEntry to return (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/portal/profileEntry/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<ProfileEntry> getProfileEntryByIdWithHttpInfo(@Param("id") String id);



  /**
   * Finds ProfileEntries
   * Finds ProfileEntries with pagination params and filters  - can search on &#x60;name&#x60; - can filter on &#x60;page&#x60;,&#x60;name&#x60; and &#x60;parent_id&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param s can search on attributes (optional)
   * @return List&lt;ProfileEntry&gt;
   */
  @RequestLine("GET /API/portal/profileEntry?p={p}&c={c}&f={f}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  List<ProfileEntry> searchProfileEntries(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("s") String s);

  /**
   * Finds ProfileEntries
   * Similar to <code>searchProfileEntries</code> but it also returns the http response headers .
   * Finds ProfileEntries with pagination params and filters  - can search on &#x60;name&#x60; - can filter on &#x60;page&#x60;,&#x60;name&#x60; and &#x60;parent_id&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param s can search on attributes (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/portal/profileEntry?p={p}&c={c}&f={f}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<ProfileEntry>> searchProfileEntriesWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("s") String s);


  /**
   * Finds ProfileEntries
   * Finds ProfileEntries with pagination params and filters  - can search on &#x60;name&#x60; - can filter on &#x60;page&#x60;,&#x60;name&#x60; and &#x60;parent_id&#x60; 
   * Note, this is equivalent to the other <code>searchProfileEntries</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchProfileEntriesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   <li>s - can search on attributes (optional)</li>
   *   </ul>
   * @return List&lt;ProfileEntry&gt;
   */
  @RequestLine("GET /API/portal/profileEntry?p={p}&c={c}&f={f}&s={s}")
  @Headers({
  "Accept: application/json",
  })
  List<ProfileEntry> searchProfileEntries(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
  * Finds ProfileEntries
  * Finds ProfileEntries with pagination params and filters  - can search on &#x60;name&#x60; - can filter on &#x60;page&#x60;,&#x60;name&#x60; and &#x60;parent_id&#x60; 
  * Note, this is equivalent to the other <code>searchProfileEntries</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>p - index of the page to display (required)</li>
          *   <li>c - maximum number of elements to retrieve (required)</li>
          *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
          *   <li>s - can search on attributes (optional)</li>
      *   </ul>
          * @return List&lt;ProfileEntry&gt;
      */
      @RequestLine("GET /API/portal/profileEntry?p={p}&c={c}&f={f}&s={s}")
      @Headers({
    "Accept: application/json",
      })
   ApiResponse<List<ProfileEntry>> searchProfileEntriesWithHttpInfo(@QueryMap(encoded=true) Map<String, Object> queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>searchProfileEntries</code> method in a fluent style.
   */
  public static class SearchProfileEntriesQueryParams extends HashMap<String, Object> {
    public SearchProfileEntriesQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public SearchProfileEntriesQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public SearchProfileEntriesQueryParams f(final List<String> value) {
      put("f", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public SearchProfileEntriesQueryParams s(final String value) {
      put("s", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Update the ProfileEntry by ID
   * Update the ProfileEntry for the given ID 
   * @param id ID of the ProfileEntry to return (required)
   * @param profileEntryUpdateRequest Partial ProfileEntry description (required)
   */
  @RequestLine("PUT /API/portal/profileEntry/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateProfileEntryById(@Param("id") String id, ProfileEntryUpdateRequest profileEntryUpdateRequest);

  /**
   * Update the ProfileEntry by ID
   * Similar to <code>updateProfileEntryById</code> but it also returns the http response headers .
   * Update the ProfileEntry for the given ID 
   * @param id ID of the ProfileEntry to return (required)
   * @param profileEntryUpdateRequest Partial ProfileEntry description (required)
   */
  @RequestLine("PUT /API/portal/profileEntry/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Void> updateProfileEntryByIdWithHttpInfo(@Param("id") String id, ProfileEntryUpdateRequest profileEntryUpdateRequest);


}
