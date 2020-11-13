package org.bonitasoft.web.client.api;

import feign.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.FlowNode;
import org.bonitasoft.web.client.model.FlowNodeUpdateRequest;

public interface FlowNodeApi extends ApiClient.Api {

  /**
   * Finds the FlowNode by ID Returns the single FlowNode for the given ID
   *
   * @param id ID of the FlowNode to return (required)
   * @return FlowNode
   */
  @RequestLine("GET /API/bpm/flowNode/{id}")
  @Headers({
    "Accept: application/json",
  })
  FlowNode getFlowNodeById(@Param("id") String id);

  /**
   * Finds FlowNodes Finds FlowNodes with pagination params and filters - can order on
   * &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;processDefinitionId&#x60;,
   * &#x60;parentProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60; (if the retrieved
   * flow nodes are activities, order by parent activity id), &#x60;rootProcessInstanceId&#x60;,
   * &#x60;lastUpdateDate&#x60; - can search on any field that can be used to order results - can
   * filter on &#x60;name&#x60;, &#x60;state&#x60;, &#x60;processId&#x60;,
   * &#x60;parentProcessInstanceId&#x60;, &#x60;rootProcessInstanceId&#x60;,
   * &#x60;last_update_date&#x60;
   *
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value}
   *     with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return List&lt;FlowNode&gt;
   */
  @RequestLine("GET /API/bpm/flowNode?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  List<FlowNode> searchFlowNodes(
      @Param("p") Integer p,
      @Param("c") Integer c,
      @Param("f") List<String> f,
      @Param("o") String o,
      @Param("s") String s);

  /**
   * Finds FlowNodes Finds FlowNodes with pagination params and filters - can order on
   * &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;processDefinitionId&#x60;,
   * &#x60;parentProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60; (if the retrieved
   * flow nodes are activities, order by parent activity id), &#x60;rootProcessInstanceId&#x60;,
   * &#x60;lastUpdateDate&#x60; - can search on any field that can be used to order results - can
   * filter on &#x60;name&#x60;, &#x60;state&#x60;, &#x60;processId&#x60;,
   * &#x60;parentProcessInstanceId&#x60;, &#x60;rootProcessInstanceId&#x60;,
   * &#x60;last_update_date&#x60; Note, this is equivalent to the other <code>searchFlowNodes</code>
   * method, but with the query parameters collected into a single Map parameter. This is convenient
   * for services with optional query parameters, especially when used with the {@link
   * SearchFlowNodesQueryParams} class that allows for building up this map in a fluent style.
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
   *       <li>s - can search on attributes (optional)
   *     </ul>
   *
   * @return List&lt;FlowNode&gt;
   */
  @RequestLine("GET /API/bpm/flowNode?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  List<FlowNode> searchFlowNodes(@QueryMap(encoded = true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the <code>searchFlowNodes</code> method
   * in a fluent style.
   */
  public static class SearchFlowNodesQueryParams extends HashMap<String, Object> {
    public SearchFlowNodesQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }

    public SearchFlowNodesQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }

    public SearchFlowNodesQueryParams f(final List<String> value) {
      put("f", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }

    public SearchFlowNodesQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }

    public SearchFlowNodesQueryParams s(final String value) {
      put("s", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Update the FlowNode by ID ![edition](https://img.shields.io/badge/edition-entreprise-blue)
   * Replay the flow node for the given ID.
   *
   * @param id ID of the FlowNode to return (required)
   * @param flowNodeUpdateRequest Replay the flow node. (required)
   */
  @RequestLine("PUT /API/bpm/flowNode/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateFlowNodeById(@Param("id") String id, FlowNodeUpdateRequest flowNodeUpdateRequest);
}
