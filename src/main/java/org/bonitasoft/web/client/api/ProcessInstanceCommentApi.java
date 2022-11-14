package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;

import org.bonitasoft.web.client.model.Error;
import org.bonitasoft.web.client.model.ProcessInstanceComment;
import org.bonitasoft.web.client.model.ProcessInstanceCommentCreateRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ProcessInstanceCommentApi extends ApiClient.Api {


  /**
   * Create the ProcessInstanceComment
   * Create the ProcessInstanceComment 
   * @param body The process instance (case) id and the comment content, in JSON (required)
   * @return ProcessInstanceComment
   */
  @RequestLine("POST /API/bpm/comment")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ProcessInstanceComment createProcessInstanceComment(ProcessInstanceCommentCreateRequest body);

  /**
   * Create the ProcessInstanceComment
   * Similar to <code>createProcessInstanceComment</code> but it also returns the http response headers .
   * Create the ProcessInstanceComment 
   * @param body The process instance (case) id and the comment content, in JSON (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /API/bpm/comment")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<ProcessInstanceComment> createProcessInstanceCommentWithHttpInfo(ProcessInstanceCommentCreateRequest body);



  /**
   * Finds ProcessInstanceComments
   * Finds ProcessInstanceComments with pagination params and filters  - can order on &#x60;postDate&#x60; - can filter on &#x60;supervisor_id&#x60;,&#x60;user_id&#x60;,&#x60;processInstanceId&#x60; - You cannot use supervisor_id and user_id filter at the same time 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return List&lt;ProcessInstanceComment&gt;
   */
  @RequestLine("GET /API/bpm/comment?p={p}&c={c}&f={f}&o={o}")
  @Headers({
    "Accept: application/json",
  })
  List<ProcessInstanceComment> searchProcessInstanceComments(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o);

  /**
   * Finds ProcessInstanceComments
   * Similar to <code>searchProcessInstanceComments</code> but it also returns the http response headers .
   * Finds ProcessInstanceComments with pagination params and filters  - can order on &#x60;postDate&#x60; - can filter on &#x60;supervisor_id&#x60;,&#x60;user_id&#x60;,&#x60;processInstanceId&#x60; - You cannot use supervisor_id and user_id filter at the same time 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/comment?p={p}&c={c}&f={f}&o={o}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<ProcessInstanceComment>> searchProcessInstanceCommentsWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o);


  /**
   * Finds ProcessInstanceComments
   * Finds ProcessInstanceComments with pagination params and filters  - can order on &#x60;postDate&#x60; - can filter on &#x60;supervisor_id&#x60;,&#x60;user_id&#x60;,&#x60;processInstanceId&#x60; - You cannot use supervisor_id and user_id filter at the same time 
   * Note, this is equivalent to the other <code>searchProcessInstanceComments</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchProcessInstanceCommentsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   <li>o - can order on attributes (optional)</li>
   *   </ul>
   * @return List&lt;ProcessInstanceComment&gt;
   */
  @RequestLine("GET /API/bpm/comment?p={p}&c={c}&f={f}&o={o}")
  @Headers({
  "Accept: application/json",
  })
  List<ProcessInstanceComment> searchProcessInstanceComments(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
  * Finds ProcessInstanceComments
  * Finds ProcessInstanceComments with pagination params and filters  - can order on &#x60;postDate&#x60; - can filter on &#x60;supervisor_id&#x60;,&#x60;user_id&#x60;,&#x60;processInstanceId&#x60; - You cannot use supervisor_id and user_id filter at the same time 
  * Note, this is equivalent to the other <code>searchProcessInstanceComments</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>p - index of the page to display (required)</li>
          *   <li>c - maximum number of elements to retrieve (required)</li>
          *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
          *   <li>o - can order on attributes (optional)</li>
      *   </ul>
          * @return List&lt;ProcessInstanceComment&gt;
      */
      @RequestLine("GET /API/bpm/comment?p={p}&c={c}&f={f}&o={o}")
      @Headers({
    "Accept: application/json",
      })
   ApiResponse<List<ProcessInstanceComment>> searchProcessInstanceCommentsWithHttpInfo(@QueryMap(encoded=true) Map<String, Object> queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>searchProcessInstanceComments</code> method in a fluent style.
   */
  public static class SearchProcessInstanceCommentsQueryParams extends HashMap<String, Object> {
    public SearchProcessInstanceCommentsQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public SearchProcessInstanceCommentsQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public SearchProcessInstanceCommentsQueryParams f(final List<String> value) {
      put("f", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public SearchProcessInstanceCommentsQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
  }
}
