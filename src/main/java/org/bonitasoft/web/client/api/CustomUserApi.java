package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;

import org.bonitasoft.web.client.model.CustomUser;
import org.bonitasoft.web.client.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface CustomUserApi extends ApiClient.Api {


  /**
   * Finds CustomUsers
   * Finds CustomUsers with pagination params and filters  **The filter &#x60;userId&#x60; is mandatory** 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @return List&lt;CustomUser&gt;
   */
  @RequestLine("GET /API/customuserinfo/user?p={p}&c={c}&f={f}")
  @Headers({
    "Accept: application/json",
  })
  List<CustomUser> searchCustomUsers(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f);

  /**
   * Finds CustomUsers
   * Finds CustomUsers with pagination params and filters  **The filter &#x60;userId&#x60; is mandatory** 
   * Note, this is equivalent to the other <code>searchCustomUsers</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchCustomUsersQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   </ul>
   * @return List&lt;CustomUser&gt;
   */
  @RequestLine("GET /API/customuserinfo/user?p={p}&c={c}&f={f}")
  @Headers({
  "Accept: application/json",
  })
  List<CustomUser> searchCustomUsers(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>searchCustomUsers</code> method in a fluent style.
   */
  public static class SearchCustomUsersQueryParams extends HashMap<String, Object> {
    public SearchCustomUsersQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public SearchCustomUsersQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public SearchCustomUsersQueryParams f(final List<String> value) {
      put("f", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
  }
}
