package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.EncodingUtils;

import org.bonitasoft.web.client.internal.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface I18ntranslationApi extends ApiClient.Api {


  /**
   * Finds I18ntranslations
   * List the available I18ntranslations with pagination params and filters Returns all translations of the product. If a locale is specified in the filter, that translation for that locale are returned. If no locale is specified, the translations in English are returned.  You can filter on &#x60;locale&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @return List&lt;Map&lt;String, String&gt;&gt;
   */
  @RequestLine("GET /API/system/i18ntranslation?p={p}&c={c}&f={f}")
  @Headers({
    "Accept: application/json",
  })
  List<Map<String, String>> findI18ntranslations(@Param("p") Integer p, @Param("c") Integer c, @Param("f") String f);

  /**
   * Finds I18ntranslations
   * List the available I18ntranslations with pagination params and filters Returns all translations of the product. If a locale is specified in the filter, that translation for that locale are returned. If no locale is specified, the translations in English are returned.  You can filter on &#x60;locale&#x60; 
   * Note, this is equivalent to the other <code>findI18ntranslations</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindI18ntranslationsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   </ul>
   * @return List&lt;Map&lt;String, String&gt;&gt;
   */
  @RequestLine("GET /API/system/i18ntranslation?p={p}&c={c}&f={f}")
  @Headers({
  "Accept: application/json",
  })
  List<Map<String, String>> findI18ntranslations(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findI18ntranslations</code> method in a fluent style.
   */
  public static class FindI18ntranslationsQueryParams extends HashMap<String, Object> {
    public FindI18ntranslationsQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public FindI18ntranslationsQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public FindI18ntranslationsQueryParams f(final String value) {
      put("f", EncodingUtils.encode(value));
      return this;
    }
  }
}
