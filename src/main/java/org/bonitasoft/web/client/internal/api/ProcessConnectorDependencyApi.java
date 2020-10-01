package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.EncodingUtils;
import org.bonitasoft.web.client.internal.model.ProcessConnectorDependency;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
public interface ProcessConnectorDependencyApi extends ApiClient.Api {


  /**
   * Finds ProcessConnectorDependencys
   * Finds ProcessConnectorDependencys with pagination params and filters  **Mandatory filters: &#x60;connector_process_id&#x60;, &#x60;connector_name&#x60;, &#x60;connector_version&#x60;** 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return List&lt;ProcessConnectorDependency&gt;
   */
  @RequestLine("GET /API/bpm/processConnectorDependency?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  List<ProcessConnectorDependency> findProcessConnectorDependencys(@Param("p") Integer p, @Param("c") Integer c, @Param("f") String f, @Param("o") String o, @Param("s") String s);

  /**
   * Finds ProcessConnectorDependencys
   * Finds ProcessConnectorDependencys with pagination params and filters  **Mandatory filters: &#x60;connector_process_id&#x60;, &#x60;connector_name&#x60;, &#x60;connector_version&#x60;** 
   * Note, this is equivalent to the other <code>findProcessConnectorDependencys</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindProcessConnectorDependencysQueryParams} class that allows for
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
   * @return List&lt;ProcessConnectorDependency&gt;
   */
  @RequestLine("GET /API/bpm/processConnectorDependency?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
  "Accept: application/json",
  })
  List<ProcessConnectorDependency> findProcessConnectorDependencys(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findProcessConnectorDependencys</code> method in a fluent style.
   */
  public static class FindProcessConnectorDependencysQueryParams extends HashMap<String, Object> {
    public FindProcessConnectorDependencysQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public FindProcessConnectorDependencysQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public FindProcessConnectorDependencysQueryParams f(final String value) {
      put("f", EncodingUtils.encode(value));
      return this;
    }
    public FindProcessConnectorDependencysQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
    public FindProcessConnectorDependencysQueryParams s(final String value) {
      put("s", EncodingUtils.encode(value));
      return this;
    }
  }
}
