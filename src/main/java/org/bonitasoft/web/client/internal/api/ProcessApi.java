package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Contract;
import org.bonitasoft.web.client.internal.model.DesignProcessDefinition;
import org.bonitasoft.web.client.internal.model.Error;
import java.io.File;
import org.bonitasoft.web.client.internal.model.Process;
import org.bonitasoft.web.client.internal.model.ProcessCreateRequest;
import org.bonitasoft.web.client.internal.model.ProcessInstantiationResponse;
import org.bonitasoft.web.client.internal.model.ProcessUpdateRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProcessApi {
  /**
   * Create the Process
   * Create the Process. A process resource is created using the content of a .bar file that has previously been uploaded, using the [processUpload servlet](#operation/uploadProcess), to get the process archive path. 
   * @param body Partial Process description (required)
   * @return Call&lt;Process&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/bpm/process")
  Call<Process> createProcess(
    @retrofit2.http.Body ProcessCreateRequest body
  );

  /**
   * Delete the Process by ID
   * Delete the single Process for the given ID.  **Warning: Beware! Data loss risk!**  Deleting a process will automatically delete all its cases (on-going and archived alike). Thus, the operation may take a long time, and fail if the transaction timeout is not large enough. This feature should only be used on non-production environments.  **Please proceed at your own risk.** 
   * @param id ID of the Process to delete (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("API/bpm/process/{id}")
  Call<Void> deleteProcessById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Delete the Process by IDs
   * Delete Process for the given list of ID.  **Warning: Beware! Data loss risk!**  Deleting a process will automatically delete all its cases (on-going and archived alike). Thus, the operation may take a long time, and fail if the transaction timeout is not large enough. This feature should only be used on non-production environments.  **Please proceed at your own risk.** 
   * @param requestBody  (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("API/bpm/process")
  Call<Void> deleteProcessByIds(
    @retrofit2.http.Body List<String> requestBody
  );

  /**
   * Finds Processs
   * Finds Processs with pagination params and filters  - can order (default is ASC) on &#x60;name&#x60;, &#x60;version&#x60;, &#x60;deploymentDate&#x60;, &#x60;deployedBy&#x60;, &#x60;activationState&#x60;, &#x60;configurationState&#x60;, &#x60;processId&#x60;, &#x60;displayName&#x60;, &#x60;lastUpdateDate&#x60;, &#x60;categoryId&#x60;, &#x60;label&#x60; - can search on &#x60;name&#x60;, &#x60;displayName&#x60; or &#x60;version&#x60; - can filter on &#x60;name&#x60;, &#x60;version&#x60;, &#x60;deploymentDate&#x60;, &#x60;deployedBy&#x60;, &#x60;activationState&#x60; with the value DISABLED or ENABLED, &#x60;configurationState&#x60; with the value UNRESOLVED, or RESOLVED, &#x60;processId&#x60;, &#x60;displayName&#x60;, &#x60;lastUpdateDate&#x60;, &#x60;categoryId&#x60;, &#x60;label&#x60;, &#x60;supervisor_id&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;Process&gt;&gt;
   */
  @GET("API/bpm/process")
  Call<List<Process>> findProcesss(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

  /**
   * Finds the Process by ID
   * Returns the single Process for the given ID 
   * @param id ID of the Process to return (required)
   * @return Call&lt;Process&gt;
   */
  @GET("API/bpm/process/{id}")
  Call<Process> getProcessById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Finds the Process contract by ID
   * Returns the process contract for the given ID 
   * @param id ID of the Process to get the contract from (required)
   * @return Call&lt;Contract&gt;
   */
  @GET("API/bpm/process/{id}/contract")
  Call<Contract> getProcessContractById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Finds the Process design by ID
   * Returns the single Process design for the given ID 
   * @param id ID of the Process to get the design from (required)
   * @return Call&lt;DesignProcessDefinition&gt;
   */
  @GET("API/bpm/process/{id}/design")
  Call<DesignProcessDefinition> getProcessDesignById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Instanciate the process
   * Instanciate the process with the provided contract values. 
   * @param id ID of the process to instanciate (required)
   * @param body A JSON object matching process contract. (required)
   * @return Call&lt;ProcessInstantiationResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/bpm/process/{id}/instantiation")
  Call<ProcessInstantiationResponse> instanciateProcess(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body Map<String, Object> body
  );

  /**
   * Update the Process by ID
   * Update the Process for the given ID 
   * @param id ID of the Process to return (required)
   * @param processUpdateRequest Partial Process description (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/bpm/process/{id}")
  Call<Void> updateProcessById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body ProcessUpdateRequest processUpdateRequest
  );

  /**
   * Upload a bar file
   * Upload a bar file 
   * @param file  (optional)
   * @return Call&lt;String&gt;
   */
  @retrofit2.http.Multipart
  @POST("portal/processUpload")
  Call<String> uploadProcess(
    @retrofit2.http.Part MultipartBody.Part file
  );

}
