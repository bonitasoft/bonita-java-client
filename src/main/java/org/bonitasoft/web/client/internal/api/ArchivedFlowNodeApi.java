package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.ArchivedFlowNode;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ArchivedFlowNodeApi {
  /**
   * Finds ArchivedFlowNodes
   * Finds ArchivedFlowNodes with pagination params and filters  - can order on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;type&#x60;, &#x60;isTerminal&#x60;, &#x60;processId&#x60;, &#x60;caseId&#x60;, &#x60;archivedDate&#x60; - can search on any field that can be used to order results - can filter on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;stateId&#x60;, &#x60;kind&#x60;, &#x60;terminal&#x60;, &#x60;processDefinitionId&#x60;, &#x60;parentProcessInstanceId&#x60;, &#x60;rootProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60;, &#x60;archivedDate&#x60;, &#x60;reachedStateDate&#x60;, &#x60;sourceObjectId&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;ArchivedFlowNode&gt;&gt;
   */
  @GET("API/bpm/archivedFlowNode")
  Call<List<ArchivedFlowNode>> findArchivedFlowNodes(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

  /**
   * Finds the ArchivedFlowNode by ID
   * Returns the single ArchivedFlowNode for the given ID 
   * @param id ID of the ArchivedFlowNode to return (required)
   * @return Call&lt;ArchivedFlowNode&gt;
   */
  @GET("API/bpm/archivedFlowNode/{id}")
  Call<ArchivedFlowNode> getArchivedFlowNodeById(
    @retrofit2.http.Path("id") String id
  );

}
