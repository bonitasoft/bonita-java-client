package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;

import org.bonitasoft.web.client.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


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
}
