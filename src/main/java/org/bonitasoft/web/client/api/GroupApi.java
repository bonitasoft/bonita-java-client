package org.bonitasoft.web.client.api;

import feign.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.Group;
import org.bonitasoft.web.client.model.GroupCreateRequest;
import org.bonitasoft.web.client.model.GroupUpdateRequest;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface GroupApi extends ApiClient.Api {

  /**
   * Create the Group Create the Group
   *
   * @param body Partial Group description (required)
   * @return Group
   */
  @RequestLine("POST /API/identity/group")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Group createGroup(GroupCreateRequest body);

  /**
   * Delete the Group by ID Delete the single Group for the given ID
   *
   * @param id ID of the Group to delete (required)
   */
  @RequestLine("DELETE /API/identity/group/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteGroupById(@Param("id") String id);

  /**
   * Finds the Group by ID Returns the single Group for the given ID
   *
   * @param id ID of the Group to return (required)
   * @return Group
   */
  @RequestLine("GET /API/identity/group/{id}")
  @Headers({
    "Accept: application/json",
  })
  Group getGroupById(@Param("id") String id);

  /**
   * Finds Groups Finds Groups with pagination params and filters. - can order on
   * &#x60;id&#x60;,&#x60;name&#x60;,&#x60;displayName&#x60; - can filter on
   * &#x60;name&#x60;,&#x60;displayName&#x60;,&#x60;parent_path&#x60;
   *
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value}
   *     with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return List&lt;Group&gt;
   */
  @RequestLine("GET /API/identity/group?p={p}&c={c}&f={f}&o={o}")
  @Headers({
    "Accept: application/json",
  })
  List<Group> searchGroups(
      @Param("p") Integer p,
      @Param("c") Integer c,
      @Param("f") List<String> f,
      @Param("o") String o);

  /**
   * Finds Groups Finds Groups with pagination params and filters. - can order on
   * &#x60;id&#x60;,&#x60;name&#x60;,&#x60;displayName&#x60; - can filter on
   * &#x60;name&#x60;,&#x60;displayName&#x60;,&#x60;parent_path&#x60; Note, this is equivalent to
   * the other <code>searchGroups</code> method, but with the query parameters collected into a
   * single Map parameter. This is convenient for services with optional query parameters,
   * especially when used with the {@link SearchGroupsQueryParams} class that allows for building up
   * this map in a fluent style.
   *
   * @param queryParams Map of query parameters as name-value pairs
   *     <p>The following elements may be specified in the query map:
   *     <ul>
   *       <li>p - index of the page to display (required)
   *       <li>c - maximum number of elements to retrieve (required)
   *       <li>f - can filter on attributes with the format
   *           f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded
   *           string. (optional)
   *       <li>o - can order on attributes (optional)
   *     </ul>
   *
   * @return List&lt;Group&gt;
   */
  @RequestLine("GET /API/identity/group?p={p}&c={c}&f={f}&o={o}")
  @Headers({
    "Accept: application/json",
  })
  List<Group> searchGroups(@QueryMap(encoded = true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the <code>searchGroups</code> method in
   * a fluent style.
   */
  public static class SearchGroupsQueryParams extends HashMap<String, Object> {
    public SearchGroupsQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }

    public SearchGroupsQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }

    public SearchGroupsQueryParams f(final List<String> value) {
      put("f", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }

    public SearchGroupsQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Update the Group by ID Update the Group for the given ID
   *
   * @param id ID of the Group to return (required)
   * @param groupUpdateRequest Partial Group description (required)
   */
  @RequestLine("PUT /API/identity/group/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateGroupById(@Param("id") String id, GroupUpdateRequest groupUpdateRequest);
}
