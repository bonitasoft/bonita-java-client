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
import org.bonitasoft.web.client.model.TimerEventTrigger;
import org.bonitasoft.web.client.model.TimerEventTriggerUpdateRequest;
import org.bonitasoft.web.client.model.TimerEventTriggerUpdateResponse;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface TimerEventTriggerApi extends ApiClient.Api {


  /**
   * Finds the TimerEventTrigger by ID
   * Returns the single TimerEventTrigger for the given ID 
   * @param id ID of the TimerEventTrigger to return (required)
   * @return TimerEventTrigger
   */
  @RequestLine("GET /API/bpm/timerEventTrigger/{id}")
  @Headers({
    "Accept: application/json",
  })
  TimerEventTrigger getTimerEventTriggerById(@Param("id") String id);

  /**
   * Finds the TimerEventTrigger by ID
   * Similar to <code>getTimerEventTriggerById</code> but it also returns the http response headers .
   * Returns the single TimerEventTrigger for the given ID 
   * @param id ID of the TimerEventTrigger to return (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/timerEventTrigger/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<TimerEventTrigger> getTimerEventTriggerByIdWithHttpInfo(@Param("id") String id);



  /**
   * Finds TimerEventTriggers
   * Finds TimerEventTriggers with pagination params and filters  - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param caseId the process instance id (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return List&lt;TimerEventTrigger&gt;
   */
  @RequestLine("GET /API/bpm/timerEventTrigger?p={p}&c={c}&f={f}&o={o}&s={s}&caseId={caseId}")
  @Headers({
    "Accept: application/json",
  })
  List<TimerEventTrigger> searchTimerEventTriggers(@Param("p") Integer p, @Param("c") Integer c, @Param("caseId") String caseId, @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

  /**
   * Finds TimerEventTriggers
   * Similar to <code>searchTimerEventTriggers</code> but it also returns the http response headers .
   * Finds TimerEventTriggers with pagination params and filters  - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param caseId the process instance id (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/timerEventTrigger?p={p}&c={c}&f={f}&o={o}&s={s}&caseId={caseId}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<TimerEventTrigger>> searchTimerEventTriggersWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c, @Param("caseId") String caseId, @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);


  /**
   * Finds TimerEventTriggers
   * Finds TimerEventTriggers with pagination params and filters  - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60; 
   * Note, this is equivalent to the other <code>searchTimerEventTriggers</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchTimerEventTriggersQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   <li>o - can order on attributes (optional)</li>
   *   <li>s - can search on attributes (optional)</li>
   *   <li>caseId - the process instance id (required)</li>
   *   </ul>
   * @return List&lt;TimerEventTrigger&gt;
   */
  @RequestLine("GET /API/bpm/timerEventTrigger?p={p}&c={c}&f={f}&o={o}&s={s}&caseId={caseId}")
  @Headers({
  "Accept: application/json",
  })
  List<TimerEventTrigger> searchTimerEventTriggers(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
  * Finds TimerEventTriggers
  * Finds TimerEventTriggers with pagination params and filters  - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60; 
  * Note, this is equivalent to the other <code>searchTimerEventTriggers</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>p - index of the page to display (required)</li>
          *   <li>c - maximum number of elements to retrieve (required)</li>
          *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
          *   <li>o - can order on attributes (optional)</li>
          *   <li>s - can search on attributes (optional)</li>
          *   <li>caseId - the process instance id (required)</li>
      *   </ul>
          * @return List&lt;TimerEventTrigger&gt;
      */
      @RequestLine("GET /API/bpm/timerEventTrigger?p={p}&c={c}&f={f}&o={o}&s={s}&caseId={caseId}")
      @Headers({
    "Accept: application/json",
      })
   ApiResponse<List<TimerEventTrigger>> searchTimerEventTriggersWithHttpInfo(@QueryMap(encoded=true) Map<String, Object> queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>searchTimerEventTriggers</code> method in a fluent style.
   */
  public static class SearchTimerEventTriggersQueryParams extends HashMap<String, Object> {
    public SearchTimerEventTriggersQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public SearchTimerEventTriggersQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public SearchTimerEventTriggersQueryParams f(final List<String> value) {
      put("f", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public SearchTimerEventTriggersQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
    public SearchTimerEventTriggersQueryParams s(final String value) {
      put("s", EncodingUtils.encode(value));
      return this;
    }
    public SearchTimerEventTriggersQueryParams caseId(final String value) {
      put("caseId", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Update the TimerEventTrigger by ID
   * Update the TimerEventTrigger for the given ID 
   * @param id ID of the TimerEventTrigger to return (required)
   * @param timerEventTriggerUpdateRequest a long value with attribute name \&quot;executionDate\&quot; (required)
   * @return TimerEventTriggerUpdateResponse
   */
  @RequestLine("PUT /API/bpm/timerEventTrigger/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  TimerEventTriggerUpdateResponse updateTimerEventTriggerById(@Param("id") String id, TimerEventTriggerUpdateRequest timerEventTriggerUpdateRequest);

  /**
   * Update the TimerEventTrigger by ID
   * Similar to <code>updateTimerEventTriggerById</code> but it also returns the http response headers .
   * Update the TimerEventTrigger for the given ID 
   * @param id ID of the TimerEventTrigger to return (required)
   * @param timerEventTriggerUpdateRequest a long value with attribute name \&quot;executionDate\&quot; (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /API/bpm/timerEventTrigger/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<TimerEventTriggerUpdateResponse> updateTimerEventTriggerByIdWithHttpInfo(@Param("id") String id, TimerEventTriggerUpdateRequest timerEventTriggerUpdateRequest);


}
