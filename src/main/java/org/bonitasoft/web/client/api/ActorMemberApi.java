package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.List;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ActorMember;
import org.bonitasoft.web.client.model.ApiResponse;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ActorMemberApi extends ApiClient.Api {


  /**
   * Delete the ActorMember by ID
   * Delete the single ActorMember for the given ID 
   * @param id ID of the ActorMember to delete (required)
   */
  @RequestLine("DELETE /API/bpm/actorMember/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteActorMemberById(@Param("id") String id);

  /**
   * Delete the ActorMember by ID
   * Similar to <code>deleteActorMemberById</code> but it also returns the http response headers .
   * Delete the single ActorMember for the given ID 
   * @param id ID of the ActorMember to delete (required)
   */
  @RequestLine("DELETE /API/bpm/actorMember/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteActorMemberByIdWithHttpInfo(@Param("id") String id);



  /**
   * Finds the ActorMember by ID
   * Returns the single ActorMember for the given ID 
   * @param id ID of the ActorMember to return (required)
   * @return ActorMember
   */
  @RequestLine("GET /API/bpm/actorMember/{id}")
  @Headers({
    "Accept: application/json",
  })
  ActorMember getActorMemberById(@Param("id") String id);

  /**
   * Finds the ActorMember by ID
   * Similar to <code>getActorMemberById</code> but it also returns the http response headers .
   * Returns the single ActorMember for the given ID 
   * @param id ID of the ActorMember to return (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/actorMember/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<ActorMember> getActorMemberByIdWithHttpInfo(@Param("id") String id);



  /**
   * Finds ActorMembers
   * Finds ActorMembers with pagination params and filters  There is a **mandatory** filter on:  * &#x60;actor_id&#x60; For example, retrieve the actorMembers related to the specified actor_id. http://localhost:8080/bonita/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1  You can also filter also on:  * &#x60;member_type&#x60; (user|role|group|roleAndGroup) retrieve only the actorMembers of type user. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;member_type%3duser&#x60; * &#x60;user_id&#x60;: retrieve only the actorMembers related to the specified user_id. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;user_id%3d101&#x60; * &#x60;role_id&#x60;: retrieve only the actorMembers related to the specified role_id. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;role_id%3d101&#x60; * &#x60;group_id&#x60;: retrieve only the actorMembers related to the specified group_id. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;group_id%3d101&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return List&lt;ActorMember&gt;
   */
  @RequestLine("GET /API/bpm/actorMember?p={p}&c={c}&f={f}&o={o}")
  @Headers({
    "Accept: application/json",
  })
  List<ActorMember> searchActorMembers(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o);

  /**
   * Finds ActorMembers
   * Similar to <code>searchActorMembers</code> but it also returns the http response headers .
   * Finds ActorMembers with pagination params and filters  There is a **mandatory** filter on:  * &#x60;actor_id&#x60; For example, retrieve the actorMembers related to the specified actor_id. http://localhost:8080/bonita/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1  You can also filter also on:  * &#x60;member_type&#x60; (user|role|group|roleAndGroup) retrieve only the actorMembers of type user. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;member_type%3duser&#x60; * &#x60;user_id&#x60;: retrieve only the actorMembers related to the specified user_id. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;user_id%3d101&#x60; * &#x60;role_id&#x60;: retrieve only the actorMembers related to the specified role_id. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;role_id%3d101&#x60; * &#x60;group_id&#x60;: retrieve only the actorMembers related to the specified group_id. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;group_id%3d101&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/actorMember?p={p}&c={c}&f={f}&o={o}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<ActorMember>> searchActorMembersWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o);


  /**
   * Finds ActorMembers
   * Finds ActorMembers with pagination params and filters  There is a **mandatory** filter on:  * &#x60;actor_id&#x60; For example, retrieve the actorMembers related to the specified actor_id. http://localhost:8080/bonita/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1  You can also filter also on:  * &#x60;member_type&#x60; (user|role|group|roleAndGroup) retrieve only the actorMembers of type user. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;member_type%3duser&#x60; * &#x60;user_id&#x60;: retrieve only the actorMembers related to the specified user_id. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;user_id%3d101&#x60; * &#x60;role_id&#x60;: retrieve only the actorMembers related to the specified role_id. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;role_id%3d101&#x60; * &#x60;group_id&#x60;: retrieve only the actorMembers related to the specified group_id. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;group_id%3d101&#x60; 
   * Note, this is equivalent to the other <code>searchActorMembers</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchActorMembersQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   <li>o - can order on attributes (optional)</li>
   *   </ul>
   * @return List&lt;ActorMember&gt;
   */
  @RequestLine("GET /API/bpm/actorMember?p={p}&c={c}&f={f}&o={o}")
  @Headers({
  "Accept: application/json",
  })
  List<ActorMember> searchActorMembers(@QueryMap(encoded=true) SearchActorMembersQueryParams queryParams);

  /**
  * Finds ActorMembers
  * Finds ActorMembers with pagination params and filters  There is a **mandatory** filter on:  * &#x60;actor_id&#x60; For example, retrieve the actorMembers related to the specified actor_id. http://localhost:8080/bonita/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1  You can also filter also on:  * &#x60;member_type&#x60; (user|role|group|roleAndGroup) retrieve only the actorMembers of type user. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;member_type%3duser&#x60; * &#x60;user_id&#x60;: retrieve only the actorMembers related to the specified user_id. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;user_id%3d101&#x60; * &#x60;role_id&#x60;: retrieve only the actorMembers related to the specified role_id. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;role_id%3d101&#x60; * &#x60;group_id&#x60;: retrieve only the actorMembers related to the specified group_id. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;group_id%3d101&#x60; 
  * Note, this is equivalent to the other <code>searchActorMembers</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>p - index of the page to display (required)</li>
          *   <li>c - maximum number of elements to retrieve (required)</li>
          *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
          *   <li>o - can order on attributes (optional)</li>
      *   </ul>
          * @return List&lt;ActorMember&gt;
      */
      @RequestLine("GET /API/bpm/actorMember?p={p}&c={c}&f={f}&o={o}")
      @Headers({
    "Accept: application/json",
      })
   ApiResponse<List<ActorMember>> searchActorMembersWithHttpInfo(@QueryMap(encoded=true) SearchActorMembersQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>searchActorMembers</code> method in a fluent style.
   */
  public static class SearchActorMembersQueryParams extends HashMap<String, Object> {
    public SearchActorMembersQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public SearchActorMembersQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public SearchActorMembersQueryParams f(final List<String> value) {
      put("f", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public SearchActorMembersQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
  }
}
