package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.HumanTask;
import org.bonitasoft.web.client.internal.model.HumanTaskUpdateRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface HumanTaskApi {
  /**
   * Finds HumanTasks
   * Finds HumanTasks with pagination params and filters  - can order on &#x60;name&#x60;, &#x60;priority&#x60;, &#x60;dueDate&#x60;, &#x60;state&#x60;, &#x60;userId&#x60;, &#x60;groupId&#x60;, &#x60;roleId&#x60;, &#x60;processDefinitionId&#x60;, &#x60;processInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60;, &#x60;assigneeId&#x60;, &#x60;parentContainerId&#x60;, &#x60;displayName&#x60;, &#x60;reachedStateDate&#x60; - can search on any field that can be used to order results - can filter on &#x60;assigned_id&#x60;, &#x60;state&#x60;, &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;processDefinitionId&#x60;, &#x60;parentContainerId&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;HumanTask&gt;&gt;
   */
  @GET("API/bpm/humanTask")
  Call<List<HumanTask>> findHumanTasks(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

  /**
   * Finds the HumanTask by ID
   * Returns the single HumanTask for the given ID 
   * @param id ID of the HumanTask to return (required)
   * @return Call&lt;HumanTask&gt;
   */
  @GET("API/bpm/humanTask/{id}")
  Call<HumanTask> getHumanTaskById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Update the HumanTask by ID
   * Update the HumanTask for the given ID 
   * @param id ID of the HumanTask to return (required)
   * @param humanTaskUpdateRequest Fields that can be updated are &#x60;assignedId&#x60; and &#x60;state&#x60;. Specify only those fields that you want to change. (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/bpm/humanTask/{id}")
  Call<Void> updateHumanTaskById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body HumanTaskUpdateRequest humanTaskUpdateRequest
  );

}
