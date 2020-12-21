package org.bonitasoft.web.client.api;

import feign.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.BusinessData;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface BusinessDataQueryApi extends ApiClient.Api {

  /**
   * Finds Business Data Finds Business Data with pagination params and filters by calling a
   * &#x60;Named Query&#x60;. The business data query REST API resource is used to call a default or
   * custom business data query. It is available from version 6.5. **Data parameters**: *
   * businessDataType - the fully-qualified business data type name * q&#x3D;queryName - the query
   * name * p&#x3D;0 - the page number * c&#x3D;10 - the maximum number of results in the page *
   * f&#x3D;parameter&#x3D;value - sets the parameter value according to business data query
   * parameters defined in Bonita Studio For a Boolean parameter, the accepted values are
   * &#x60;true&#x60; or &#x60;false&#x60;. By default, for a Date parameter can use the following
   * formats: * yyyy-MM-dd * HH:mm:ss * yyyy-MM-dd HH:mm:ss * yyyy-MM-dd&#39;T&#39;HH:mm:ss *
   * yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSS
   *
   * @param businessDataType Business Data Type (required)
   * @param q Named query to use (required)
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value}
   *     with the name/value pair as url encoded string. (optional)
   * @return List&lt;BusinessData&gt;
   */
  @RequestLine("GET /API/bdm/businessData/{businessDataType}?q={q}&p={p}&c={c}&f={f}")
  @Headers({
    "Accept: application/json",
  })
  List<BusinessData> searchBusinessData(
      @Param("businessDataType") String businessDataType,
      @Param("q") String q,
      @Param("p") Integer p,
      @Param("c") Integer c,
      @Param("f") List<String> f);

  /**
   * Finds Business Data Finds Business Data with pagination params and filters by calling a
   * &#x60;Named Query&#x60;. The business data query REST API resource is used to call a default or
   * custom business data query. It is available from version 6.5. **Data parameters**: *
   * businessDataType - the fully-qualified business data type name * q&#x3D;queryName - the query
   * name * p&#x3D;0 - the page number * c&#x3D;10 - the maximum number of results in the page *
   * f&#x3D;parameter&#x3D;value - sets the parameter value according to business data query
   * parameters defined in Bonita Studio For a Boolean parameter, the accepted values are
   * &#x60;true&#x60; or &#x60;false&#x60;. By default, for a Date parameter can use the following
   * formats: * yyyy-MM-dd * HH:mm:ss * yyyy-MM-dd HH:mm:ss * yyyy-MM-dd&#39;T&#39;HH:mm:ss *
   * yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSS Note, this is equivalent to the other <code>
   * searchBusinessData</code> method, but with the query parameters collected into a single Map
   * parameter. This is convenient for services with optional query parameters, especially when used
   * with the {@link SearchBusinessDataQueryParams} class that allows for building up this map in a
   * fluent style.
   *
   * @param businessDataType Business Data Type (required)
   * @param queryParams Map of query parameters as name-value pairs
   *     <p>The following elements may be specified in the query map:
   *     <ul>
   *       <li>q - Named query to use (required)
   *       <li>p - index of the page to display (required)
   *       <li>c - maximum number of elements to retrieve (required)
   *       <li>f - can filter on attributes with the format
   *           f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded
   *           string. (optional)
   *     </ul>
   *
   * @return List&lt;BusinessData&gt;
   */
  @RequestLine("GET /API/bdm/businessData/{businessDataType}?q={q}&p={p}&c={c}&f={f}")
  @Headers({
    "Accept: application/json",
  })
  List<BusinessData> searchBusinessData(
      @Param("businessDataType") String businessDataType,
      @QueryMap(encoded = true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the <code>searchBusinessData</code>
   * method in a fluent style.
   */
  public static class SearchBusinessDataQueryParams extends HashMap<String, Object> {
    public SearchBusinessDataQueryParams q(final String value) {
      put("q", EncodingUtils.encode(value));
      return this;
    }

    public SearchBusinessDataQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }

    public SearchBusinessDataQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }

    public SearchBusinessDataQueryParams f(final List<String> value) {
      put("f", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
  }
}
