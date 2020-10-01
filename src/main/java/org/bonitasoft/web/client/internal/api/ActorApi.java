package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.EncodingUtils;
import org.bonitasoft.web.client.internal.model.Actor;
import org.bonitasoft.web.client.internal.model.ActorUpdateRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
public interface ActorApi extends ApiClient.Api {


  /**
   * Finds Actors
   * Finds Actors with pagination params and filters 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return List&lt;Actor&gt;
   */
  @RequestLine("GET /API/bpm/actor?p={p}&c={c}&f={f}&o={o}")
  @Headers({
    "Accept: application/json",
  })
  List<Actor> findActors(@Param("p") Integer p, @Param("c") Integer c, @Param("f") String f, @Param("o") String o);

  /**
   * Finds Actors
   * Finds Actors with pagination params and filters 
   * Note, this is equivalent to the other <code>findActors</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindActorsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   <li>o - can order on attributes (optional)</li>
   *   </ul>
   * @return List&lt;Actor&gt;
   */
  @RequestLine("GET /API/bpm/actor?p={p}&c={c}&f={f}&o={o}")
  @Headers({
  "Accept: application/json",
  })
  List<Actor> findActors(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findActors</code> method in a fluent style.
   */
  public static class FindActorsQueryParams extends HashMap<String, Object> {
    public FindActorsQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public FindActorsQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public FindActorsQueryParams f(final String value) {
      put("f", EncodingUtils.encode(value));
      return this;
    }
    public FindActorsQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Finds the Actor by ID
   * Returns the single Actor for the given ID 
   * @param id ID of the Actor to return (required)
   * @return Actor
   */
  @RequestLine("GET /API/bpm/actor/{id}")
  @Headers({
    "Accept: application/json",
  })
  Actor getActorById(@Param("id") String id);

  /**
   * Update the Actor by ID
   * Update the Actor for the given ID 
   * @param id ID of the Actor to return (required)
   * @param actorUpdateRequest Fields that can be upated are &#x60;displayName&#x60; and &#x60;description&#x60; (required)
   */
  @RequestLine("PUT /API/bpm/actor/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateActorById(@Param("id") String id, ActorUpdateRequest actorUpdateRequest);
}
