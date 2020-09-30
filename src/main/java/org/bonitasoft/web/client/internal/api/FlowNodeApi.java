package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.FlowNode;
import org.bonitasoft.web.client.internal.model.FlowNodeUpdateRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface FlowNodeApi {
  /**
   * Finds FlowNodes
   * Finds FlowNodes with pagination params and filters  - can order on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;processDefinitionId&#x60;, &#x60;parentProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60; (if the retrieved flow nodes are activities, order by parent activity id), &#x60;rootProcessInstanceId&#x60;, &#x60;lastUpdateDate&#x60; - can search on any field that can be used to order results - can filter on &#x60;name&#x60;, &#x60;state&#x60;, &#x60;processId&#x60;, &#x60;parentCaseId&#x60;, &#x60;rootCaseId&#x60;, &#x60;last_update_date&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;FlowNode&gt;&gt;
   */
  @GET("API/bpm/flowNode")
  Call<List<FlowNode>> findFlowNodes(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

  /**
   * Finds the FlowNode by ID
   * Returns the single FlowNode for the given ID 
   * @param id ID of the FlowNode to return (required)
   * @return Call&lt;FlowNode&gt;
   */
  @GET("API/bpm/flowNode/{id}")
  Call<FlowNode> getFlowNodeById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Update the FlowNode by ID
   * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Replay the flow node for the given ID. 
   * @param id ID of the FlowNode to return (required)
   * @param flowNodeUpdateRequest Replay the flow node. (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/bpm/flowNode/{id}")
  Call<Void> updateFlowNodeById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body FlowNodeUpdateRequest flowNodeUpdateRequest
  );

}
