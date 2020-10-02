package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.EncodingUtils;

import org.bonitasoft.web.client.internal.model.CaseComment;
import org.bonitasoft.web.client.internal.model.CaseCommentCreateRequest;
import org.bonitasoft.web.client.internal.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface CaseCommentApi extends ApiClient.Api {


  /**
   * Create the CaseComment
   * Create the CaseComment 
   * @param body The process instance (case) id and the comment content, in JSON (required)
   * @return CaseComment
   */
  @RequestLine("POST /API/bpm/comment")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  CaseComment createCaseComment(CaseCommentCreateRequest body);

  /**
   * Finds CaseComments
   * Finds CaseComments with pagination params and filters  - can order on &#x60;postDate&#x60; - can filter on &#x60;supervisor_id&#x60;,&#x60;user_id&#x60;,&#x60;processInstanceId&#x60; - You cannot use supervisor_id and user_id filter at the same time 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return List&lt;CaseComment&gt;
   */
  @RequestLine("GET /API/bpm/comment?p={p}&c={c}&f={f}&o={o}")
  @Headers({
    "Accept: application/json",
  })
  List<CaseComment> findCaseComments(@Param("p") Integer p, @Param("c") Integer c, @Param("f") String f, @Param("o") String o);

  /**
   * Finds CaseComments
   * Finds CaseComments with pagination params and filters  - can order on &#x60;postDate&#x60; - can filter on &#x60;supervisor_id&#x60;,&#x60;user_id&#x60;,&#x60;processInstanceId&#x60; - You cannot use supervisor_id and user_id filter at the same time 
   * Note, this is equivalent to the other <code>findCaseComments</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindCaseCommentsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   <li>o - can order on attributes (optional)</li>
   *   </ul>
   * @return List&lt;CaseComment&gt;
   */
  @RequestLine("GET /API/bpm/comment?p={p}&c={c}&f={f}&o={o}")
  @Headers({
  "Accept: application/json",
  })
  List<CaseComment> findCaseComments(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findCaseComments</code> method in a fluent style.
   */
  public static class FindCaseCommentsQueryParams extends HashMap<String, Object> {
    public FindCaseCommentsQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public FindCaseCommentsQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public FindCaseCommentsQueryParams f(final String value) {
      put("f", EncodingUtils.encode(value));
      return this;
    }
    public FindCaseCommentsQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
  }
}
