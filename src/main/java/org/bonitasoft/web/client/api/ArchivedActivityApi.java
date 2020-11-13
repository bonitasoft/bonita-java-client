package org.bonitasoft.web.client.api;

import feign.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ArchivedActivity;

public interface ArchivedActivityApi extends ApiClient.Api {

  /**
   * Finds the Archived Activity by ID Returns the single Archived Activity for the given ID
   *
   * @param id ID of the Archived Activity to return (required)
   * @return ArchivedActivity
   */
  @RequestLine("GET /API/bpm/archivedActivity/{id}")
  @Headers({
    "Accept: application/json",
  })
  ArchivedActivity getArchivedActivityById(@Param("id") String id);

  /**
   * Finds Archived Activities Finds Archived Activities with pagination params and filters.
   * Activities in states completed, cancelled, or aborted are not retrieved. The search returns an
   * array of activities. Can order on: - &#x60;name&#x60; : the name of this activity -
   * &#x60;displayName&#x60; : the display name of this activity - &#x60;state&#x60; : the current
   * state of the activity - &#x60;type&#x60; : the activity type - &#x60;isTerminal&#x60; : say
   * whether or not the activity is in a terminal state - &#x60;processId&#x60; : the process this
   * activity is associated to - &#x60;caseId&#x60; : the process instance initiator this activity
   * is associated to - &#x60;reached_state_date&#x60; : the date when this activity arrived in this
   * state Can filter on: - &#x60;supervisor_id&#x60;: retrieve the information the process manager
   * associated to this id has access to (only in Enterprise editions) - f: same as the sort order
   * fields
   *
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value}
   *     with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return List&lt;ArchivedActivity&gt;
   */
  @RequestLine("GET /API/bpm/archivedActivity?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  List<ArchivedActivity> searchArchivedActivities(
      @Param("p") Integer p,
      @Param("c") Integer c,
      @Param("f") List<String> f,
      @Param("o") String o,
      @Param("s") String s);

  /**
   * Finds Archived Activities Finds Archived Activities with pagination params and filters.
   * Activities in states completed, cancelled, or aborted are not retrieved. The search returns an
   * array of activities. Can order on: - &#x60;name&#x60; : the name of this activity -
   * &#x60;displayName&#x60; : the display name of this activity - &#x60;state&#x60; : the current
   * state of the activity - &#x60;type&#x60; : the activity type - &#x60;isTerminal&#x60; : say
   * whether or not the activity is in a terminal state - &#x60;processId&#x60; : the process this
   * activity is associated to - &#x60;caseId&#x60; : the process instance initiator this activity
   * is associated to - &#x60;reached_state_date&#x60; : the date when this activity arrived in this
   * state Can filter on: - &#x60;supervisor_id&#x60;: retrieve the information the process manager
   * associated to this id has access to (only in Enterprise editions) - f: same as the sort order
   * fields Note, this is equivalent to the other <code>searchArchivedActivities</code> method, but
   * with the query parameters collected into a single Map parameter. This is convenient for
   * services with optional query parameters, especially when used with the {@link
   * SearchArchivedActivitiesQueryParams} class that allows for building up this map in a fluent
   * style.
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
   *       <li>s - can search on attributes (optional)
   *     </ul>
   *
   * @return List&lt;ArchivedActivity&gt;
   */
  @RequestLine("GET /API/bpm/archivedActivity?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  List<ArchivedActivity> searchArchivedActivities(
      @QueryMap(encoded = true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the <code>searchArchivedActivities
   * </code> method in a fluent style.
   */
  public static class SearchArchivedActivitiesQueryParams extends HashMap<String, Object> {
    public SearchArchivedActivitiesQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }

    public SearchArchivedActivitiesQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }

    public SearchArchivedActivitiesQueryParams f(final List<String> value) {
      put("f", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }

    public SearchArchivedActivitiesQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }

    public SearchArchivedActivitiesQueryParams s(final String value) {
      put("s", EncodingUtils.encode(value));
      return this;
    }
  }
}
