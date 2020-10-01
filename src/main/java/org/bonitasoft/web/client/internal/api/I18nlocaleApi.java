package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.EncodingUtils;
import org.bonitasoft.web.client.internal.model.I18nlocale;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
public interface I18nlocaleApi extends ApiClient.Api {


  /**
   * Finds I18nlocales
   * List the available I18nlocales with pagination params and filters 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @return List&lt;I18nlocale&gt;
   */
  @RequestLine("GET /API/system/i18nlocale?p={p}&c={c}")
  @Headers({
    "Accept: application/json",
  })
  List<I18nlocale> findI18nlocales(@Param("p") Integer p, @Param("c") Integer c);

  /**
   * Finds I18nlocales
   * List the available I18nlocales with pagination params and filters 
   * Note, this is equivalent to the other <code>findI18nlocales</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindI18nlocalesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   </ul>
   * @return List&lt;I18nlocale&gt;
   */
  @RequestLine("GET /API/system/i18nlocale?p={p}&c={c}")
  @Headers({
  "Accept: application/json",
  })
  List<I18nlocale> findI18nlocales(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findI18nlocales</code> method in a fluent style.
   */
  public static class FindI18nlocalesQueryParams extends HashMap<String, Object> {
    public FindI18nlocalesQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public FindI18nlocalesQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
  }
}
