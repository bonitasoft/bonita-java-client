package org.bonitasoft.web.client.api;

import java.util.Map;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.ApiResponse;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface DiagramApi extends ApiClient.Api {


  /**
   * Finds the diagram process by ID
   * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Use the diagram resource to access the process diagram xml representation. This is necessary for drawing the diagram. 
   * @param id ID of the process to get the diagram from (required)
   * @return Map&lt;String, Object&gt;
   */
  @RequestLine("GET /API/bpm/diagram/{id}")
  @Headers({
    "Accept: application/json",
  })
  Map<String, Object> getProcessDiagramById(@Param("id") String id);

  /**
   * Finds the diagram process by ID
   * Similar to <code>getProcessDiagramById</code> but it also returns the http response headers .
   * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Use the diagram resource to access the process diagram xml representation. This is necessary for drawing the diagram. 
   * @param id ID of the process to get the diagram from (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/diagram/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Map<String, Object>> getProcessDiagramByIdWithHttpInfo(@Param("id") String id);


}
