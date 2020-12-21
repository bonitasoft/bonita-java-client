package org.bonitasoft.web.client.api;

import feign.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ProcessInstanceComment;
import org.bonitasoft.web.client.model.ProcessInstanceCommentCreateRequest;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ProcessInstanceCommentApi extends ApiClient.Api {

  /**
   * Create the ProcessInstanceComment Create the ProcessInstanceComment
   *
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
   * Finds ProcessInstanceComments Finds ProcessInstanceComments with pagination params and filters
   * - can order on &#x60;postDate&#x60; - can filter on
   * &#x60;supervisor_id&#x60;,&#x60;user_id&#x60;,&#x60;processInstanceId&#x60; - You cannot use
   * supervisor_id and user_id filter at the same time
   *
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value}
   *     with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return List&lt;ProcessInstanceComment&gt;
   */
  @RequestLine("GET /API/bpm/comment?p={p}&c={c}&f={f}&o={o}")
  @Headers({
    "Accept: application/json",
  })
  List<ProcessInstanceComment> searchProcessInstanceComments(
      @Param("p") Integer p,
      @Param("c") Integer c,
      @Param("f") List<String> f,
      @Param("o") String o);

  /**
   * Finds ProcessInstanceComments Finds ProcessInstanceComments with pagination params and filters
   * - can order on &#x60;postDate&#x60; - can filter on
   * &#x60;supervisor_id&#x60;,&#x60;user_id&#x60;,&#x60;processInstanceId&#x60; - You cannot use
   * supervisor_id and user_id filter at the same time Note, this is equivalent to the other <code>
   * searchProcessInstanceComments</code> method, but with the query parameters collected into a
   * single Map parameter. This is convenient for services with optional query parameters,
   * especially when used with the {@link SearchProcessInstanceCommentsQueryParams} class that
   * allows for building up this map in a fluent style.
   *
   * @param queryParams Map of query parameters as name-value pairs
   *     <p>The following elements may be specified in the query map:
   *     <ul>
   *       <li>p - index of the page to display (required)
   *       <li>c - maximum number of elements to retrieve (required)
   *       <li>f - can filter on attributes with the format
   *           f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded
   *           string. (optional)
   *       <li>o - can order on attributes (optional)
   *     </ul>
   *
   * @return List&lt;ProcessInstanceComment&gt;
   */
  @RequestLine("GET /API/bpm/comment?p={p}&c={c}&f={f}&o={o}")
  @Headers({
    "Accept: application/json",
  })
  List<ProcessInstanceComment> searchProcessInstanceComments(
      @QueryMap(encoded = true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the <code>searchProcessInstanceComments
   * </code> method in a fluent style.
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
