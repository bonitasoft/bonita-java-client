package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.EncodingUtils;
import org.bonitasoft.web.client.internal.model.CustomUserValue;
import org.bonitasoft.web.client.internal.model.CustomUserValueUpdateRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
public interface CustomUserValueApi extends ApiClient.Api {


  /**
   * Finds CustomUserValues
   * Finds CustomUserValues with pagination params and filters  You can filter on &#x60;userId&#x60;, &#x60;value&#x60;, &#x60;definitionId&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @return List&lt;CustomUserValue&gt;
   */
  @RequestLine("GET /API/customuserinfo/value?p={p}&c={c}&f={f}")
  @Headers({
    "Accept: application/json",
  })
  List<CustomUserValue> findCustomUserValues(@Param("p") Integer p, @Param("c") Integer c, @Param("f") String f);

  /**
   * Finds CustomUserValues
   * Finds CustomUserValues with pagination params and filters  You can filter on &#x60;userId&#x60;, &#x60;value&#x60;, &#x60;definitionId&#x60; 
   * Note, this is equivalent to the other <code>findCustomUserValues</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindCustomUserValuesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   </ul>
   * @return List&lt;CustomUserValue&gt;
   */
  @RequestLine("GET /API/customuserinfo/value?p={p}&c={c}&f={f}")
  @Headers({
  "Accept: application/json",
  })
  List<CustomUserValue> findCustomUserValues(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findCustomUserValues</code> method in a fluent style.
   */
  public static class FindCustomUserValuesQueryParams extends HashMap<String, Object> {
    public FindCustomUserValuesQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public FindCustomUserValuesQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public FindCustomUserValuesQueryParams f(final String value) {
      put("f", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Update the CustomUserValue by ID
   * Update the CustomUserValue for the given ID 
   * @param userId User ID (required)
   * @param definitionId definition ID (required)
   * @param customUserValueUpdateRequest Custom user defition Value (required)
   */
  @RequestLine("PUT /API/customuserinfo/value/{userId}/{definitionId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateCustomUserValueById(@Param("userId") String userId, @Param("definitionId") String definitionId, CustomUserValueUpdateRequest customUserValueUpdateRequest);
}
