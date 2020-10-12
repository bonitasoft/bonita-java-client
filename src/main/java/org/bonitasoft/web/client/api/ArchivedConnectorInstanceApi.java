package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;

import org.bonitasoft.web.client.model.ArchivedConnectorInstance;
import org.bonitasoft.web.client.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface ArchivedConnectorInstanceApi extends ApiClient.Api {


  /**
   * Finds ArchivedConnectorInstances
   * Finds ArchivedConnectorInstances with pagination params and filters 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return List&lt;ArchivedConnectorInstance&gt;
   */
  @RequestLine("GET /API/bpm/archivedConnectorInstance?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  List<ArchivedConnectorInstance> searchArchivedConnectorInstances(@Param("p") Integer p, @Param("c") Integer c, @Param("f") String f, @Param("o") String o, @Param("s") String s);

  /**
   * Finds ArchivedConnectorInstances
   * Finds ArchivedConnectorInstances with pagination params and filters 
   * Note, this is equivalent to the other <code>searchArchivedConnectorInstances</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchArchivedConnectorInstancesQueryParams} class that allows for
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
   * @return List&lt;ArchivedConnectorInstance&gt;
   */
  @RequestLine("GET /API/bpm/archivedConnectorInstance?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
  "Accept: application/json",
  })
  List<ArchivedConnectorInstance> searchArchivedConnectorInstances(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>searchArchivedConnectorInstances</code> method in a fluent style.
   */
  public static class SearchArchivedConnectorInstancesQueryParams extends HashMap<String, Object> {
    public SearchArchivedConnectorInstancesQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public SearchArchivedConnectorInstancesQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public SearchArchivedConnectorInstancesQueryParams f(final String value) {
      put("f", EncodingUtils.encode(value));
      return this;
    }
    public SearchArchivedConnectorInstancesQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
    public SearchArchivedConnectorInstancesQueryParams s(final String value) {
      put("s", EncodingUtils.encode(value));
      return this;
    }
  }
}
