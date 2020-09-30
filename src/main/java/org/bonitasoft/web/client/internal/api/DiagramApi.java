package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DiagramApi {
  /**
   * Finds the diagram process by ID
   * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Use the diagram resource to access the process diagram xml representation. This is necessary for drawing the diagram. 
   * @param id ID of the process to get the diagram from (required)
   * @return Call&lt;Map&lt;String, Object&gt;&gt;
   */
  @GET("API/bpm/diagram/{id}")
  Call<Map<String, Object>> getProcessDiagramById(
    @retrofit2.http.Path("id") String id
  );

}
