package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.ProcessResolutionProblem;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ProcessResolutionProblemApi extends ApiClient.Api {


  /**
   * Finds ProcessResolutionProblems
   * Finds ProcessResolutionProblems with pagination params and filters to list the problems that need to be solved before a process can be used.  **Filtering on the process definition ID is mandatory.** 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return List&lt;ProcessResolutionProblem&gt;
   */
  @RequestLine("GET /API/bpm/processResolutionProblem?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  List<ProcessResolutionProblem> searchProcessResolutionProblems(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

  /**
   * Finds ProcessResolutionProblems
   * Similar to <code>searchProcessResolutionProblems</code> but it also returns the http response headers .
   * Finds ProcessResolutionProblems with pagination params and filters to list the problems that need to be solved before a process can be used.  **Filtering on the process definition ID is mandatory.** 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/processResolutionProblem?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<ProcessResolutionProblem>> searchProcessResolutionProblemsWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);


  /**
   * Finds ProcessResolutionProblems
   * Finds ProcessResolutionProblems with pagination params and filters to list the problems that need to be solved before a process can be used.  **Filtering on the process definition ID is mandatory.** 
   * Note, this is equivalent to the other <code>searchProcessResolutionProblems</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchProcessResolutionProblemsQueryParams} class that allows for
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
   * @return List&lt;ProcessResolutionProblem&gt;
   */
  @RequestLine("GET /API/bpm/processResolutionProblem?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
  "Accept: application/json",
  })
  List<ProcessResolutionProblem> searchProcessResolutionProblems(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
  * Finds ProcessResolutionProblems
  * Finds ProcessResolutionProblems with pagination params and filters to list the problems that need to be solved before a process can be used.  **Filtering on the process definition ID is mandatory.** 
  * Note, this is equivalent to the other <code>searchProcessResolutionProblems</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>p - index of the page to display (required)</li>
          *   <li>c - maximum number of elements to retrieve (required)</li>
          *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
          *   <li>o - can order on attributes (optional)</li>
          *   <li>s - can search on attributes (optional)</li>
      *   </ul>
          * @return List&lt;ProcessResolutionProblem&gt;
      */
      @RequestLine("GET /API/bpm/processResolutionProblem?p={p}&c={c}&f={f}&o={o}&s={s}")
      @Headers({
    "Accept: application/json",
      })
   ApiResponse<List<ProcessResolutionProblem>> searchProcessResolutionProblemsWithHttpInfo(@QueryMap(encoded=true) Map<String, Object> queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>searchProcessResolutionProblems</code> method in a fluent style.
   */
  public static class SearchProcessResolutionProblemsQueryParams extends HashMap<String, Object> {
    public SearchProcessResolutionProblemsQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public SearchProcessResolutionProblemsQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public SearchProcessResolutionProblemsQueryParams f(final List<String> value) {
      put("f", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public SearchProcessResolutionProblemsQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
    public SearchProcessResolutionProblemsQueryParams s(final String value) {
      put("s", EncodingUtils.encode(value));
      return this;
    }
  }
}
