package org.bonitasoft.web.client.api;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.Contract;
import org.bonitasoft.web.client.model.DesignProcessDefinition;
import org.bonitasoft.web.client.model.ProcessCreateRequest;
import org.bonitasoft.web.client.model.ProcessDefinition;
import org.bonitasoft.web.client.model.ProcessInstantiationResponse;
import org.bonitasoft.web.client.model.ProcessUpdateRequest;
import org.bonitasoft.web.client.model.UpdateProcessConnectorByProcessIdRequest;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ProcessApi extends ApiClient.Api {


  /**
   * Create the Process
   * Create the Process. A process resource is created using the content of a .bar file that has previously been uploaded, using the [processUpload servlet](#operation/uploadProcess), to get the process archive path. 
   * @param body Partial Process description (required)
   * @return ProcessDefinition
   */
  @RequestLine("POST /API/bpm/process")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ProcessDefinition createProcess(ProcessCreateRequest body);

  /**
   * Create the Process
   * Similar to <code>createProcess</code> but it also returns the http response headers .
   * Create the Process. A process resource is created using the content of a .bar file that has previously been uploaded, using the [processUpload servlet](#operation/uploadProcess), to get the process archive path. 
   * @param body Partial Process description (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /API/bpm/process")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<ProcessDefinition> createProcessWithHttpInfo(ProcessCreateRequest body);



  /**
   * Delete the Process by ID
   * Delete the single Process for the given ID.  **Warning: Beware! Data loss risk!**  Deleting a process will automatically delete all its process instances (on-going and archived alike). Thus, the operation may take a long time, and fail if the transaction timeout is not large enough. This feature should only be used on non-production environments.  **Please proceed at your own risk.** 
   * @param id ID of the Process to delete (required)
   */
  @RequestLine("DELETE /API/bpm/process/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteProcessById(@Param("id") String id);

  /**
   * Delete the Process by ID
   * Similar to <code>deleteProcessById</code> but it also returns the http response headers .
   * Delete the single Process for the given ID.  **Warning: Beware! Data loss risk!**  Deleting a process will automatically delete all its process instances (on-going and archived alike). Thus, the operation may take a long time, and fail if the transaction timeout is not large enough. This feature should only be used on non-production environments.  **Please proceed at your own risk.** 
   * @param id ID of the Process to delete (required)
   */
  @RequestLine("DELETE /API/bpm/process/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteProcessByIdWithHttpInfo(@Param("id") String id);



  /**
   * Delete the Process by IDs
   * Delete Process for the given list of ID.  **Warning: Beware! Data loss risk!**  Deleting a process will automatically delete all its process instances (on-going and archived alike). Thus, the operation may take a long time, and fail if the transaction timeout is not large enough. This feature should only be used on non-production environments.  **Please proceed at your own risk.** 
   * @param requestBody  (optional)
   */
  @RequestLine("DELETE /API/bpm/process")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void deleteProcessByIds(List<String> requestBody);

  /**
   * Delete the Process by IDs
   * Similar to <code>deleteProcessByIds</code> but it also returns the http response headers .
   * Delete Process for the given list of ID.  **Warning: Beware! Data loss risk!**  Deleting a process will automatically delete all its process instances (on-going and archived alike). Thus, the operation may take a long time, and fail if the transaction timeout is not large enough. This feature should only be used on non-production environments.  **Please proceed at your own risk.** 
   * @param requestBody  (optional)
   */
  @RequestLine("DELETE /API/bpm/process")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Void> deleteProcessByIdsWithHttpInfo(List<String> requestBody);



  /**
   * Finds the Process by ID
   * Returns the single Process for the given ID 
   * @param id ID of the Process to return (required)
   * @return ProcessDefinition
   */
  @RequestLine("GET /API/bpm/process/{id}")
  @Headers({
    "Accept: application/json",
  })
  ProcessDefinition getProcessById(@Param("id") String id);

  /**
   * Finds the Process by ID
   * Similar to <code>getProcessById</code> but it also returns the http response headers .
   * Returns the single Process for the given ID 
   * @param id ID of the Process to return (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/process/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<ProcessDefinition> getProcessByIdWithHttpInfo(@Param("id") String id);



  /**
   * Finds the Process contract by ID
   * Returns the process contract for the given ID 
   * @param id ID of the Process to get the contract from (required)
   * @return Contract
   */
  @RequestLine("GET /API/bpm/process/{id}/contract")
  @Headers({
    "Accept: application/json",
  })
  Contract getProcessContractById(@Param("id") String id);

  /**
   * Finds the Process contract by ID
   * Similar to <code>getProcessContractById</code> but it also returns the http response headers .
   * Returns the process contract for the given ID 
   * @param id ID of the Process to get the contract from (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/process/{id}/contract")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Contract> getProcessContractByIdWithHttpInfo(@Param("id") String id);



  /**
   * Finds the Process design by ID
   * Returns the single Process design for the given ID 
   * @param id ID of the Process to get the design from (required)
   * @return DesignProcessDefinition
   */
  @RequestLine("GET /API/bpm/process/{id}/design")
  @Headers({
    "Accept: application/json",
  })
  DesignProcessDefinition getProcessDesignById(@Param("id") String id);

  /**
   * Finds the Process design by ID
   * Similar to <code>getProcessDesignById</code> but it also returns the http response headers .
   * Returns the single Process design for the given ID 
   * @param id ID of the Process to get the design from (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/process/{id}/design")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<DesignProcessDefinition> getProcessDesignByIdWithHttpInfo(@Param("id") String id);



  /**
   * Instanciate the process
   * Instanciate the process with the provided contract values. 
   * @param id ID of the process to instanciate (required)
   * @param body A JSON object matching process contract. (required)
   * @return ProcessInstantiationResponse
   */
  @RequestLine("POST /API/bpm/process/{id}/instantiation")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ProcessInstantiationResponse instanciateProcess(@Param("id") String id, Map<String, Object> body);

  /**
   * Instanciate the process
   * Similar to <code>instanciateProcess</code> but it also returns the http response headers .
   * Instanciate the process with the provided contract values. 
   * @param id ID of the process to instanciate (required)
   * @param body A JSON object matching process contract. (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /API/bpm/process/{id}/instantiation")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<ProcessInstantiationResponse> instanciateProcessWithHttpInfo(@Param("id") String id, Map<String, Object> body);



  /**
   * Finds Processes
   * Finds Processes with pagination params and filters  - can order (default is ASC) on &#x60;name&#x60;, &#x60;version&#x60;, &#x60;deploymentDate&#x60;, &#x60;deployedBy&#x60;, &#x60;activationState&#x60;, &#x60;configurationState&#x60;, &#x60;processId&#x60;, &#x60;displayName&#x60;, &#x60;lastUpdateDate&#x60;, &#x60;categoryId&#x60;, &#x60;label&#x60; - can search on &#x60;name&#x60;, &#x60;displayName&#x60; or &#x60;version&#x60; - can filter on &#x60;name&#x60;, &#x60;version&#x60;, &#x60;deploymentDate&#x60;, &#x60;deployedBy&#x60;, &#x60;activationState&#x60; with the value DISABLED or ENABLED, &#x60;configurationState&#x60; with the value UNRESOLVED, or RESOLVED, &#x60;processId&#x60;, &#x60;displayName&#x60;, &#x60;lastUpdateDate&#x60;, &#x60;categoryId&#x60;, &#x60;label&#x60;, &#x60;supervisor_id&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return List&lt;ProcessDefinition&gt;
   */
  @RequestLine("GET /API/bpm/process?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  List<ProcessDefinition> searchProcesses(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

  /**
   * Finds Processes
   * Similar to <code>searchProcesses</code> but it also returns the http response headers .
   * Finds Processes with pagination params and filters  - can order (default is ASC) on &#x60;name&#x60;, &#x60;version&#x60;, &#x60;deploymentDate&#x60;, &#x60;deployedBy&#x60;, &#x60;activationState&#x60;, &#x60;configurationState&#x60;, &#x60;processId&#x60;, &#x60;displayName&#x60;, &#x60;lastUpdateDate&#x60;, &#x60;categoryId&#x60;, &#x60;label&#x60; - can search on &#x60;name&#x60;, &#x60;displayName&#x60; or &#x60;version&#x60; - can filter on &#x60;name&#x60;, &#x60;version&#x60;, &#x60;deploymentDate&#x60;, &#x60;deployedBy&#x60;, &#x60;activationState&#x60; with the value DISABLED or ENABLED, &#x60;configurationState&#x60; with the value UNRESOLVED, or RESOLVED, &#x60;processId&#x60;, &#x60;displayName&#x60;, &#x60;lastUpdateDate&#x60;, &#x60;categoryId&#x60;, &#x60;label&#x60;, &#x60;supervisor_id&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/process?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<ProcessDefinition>> searchProcessesWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);


  /**
   * Finds Processes
   * Finds Processes with pagination params and filters  - can order (default is ASC) on &#x60;name&#x60;, &#x60;version&#x60;, &#x60;deploymentDate&#x60;, &#x60;deployedBy&#x60;, &#x60;activationState&#x60;, &#x60;configurationState&#x60;, &#x60;processId&#x60;, &#x60;displayName&#x60;, &#x60;lastUpdateDate&#x60;, &#x60;categoryId&#x60;, &#x60;label&#x60; - can search on &#x60;name&#x60;, &#x60;displayName&#x60; or &#x60;version&#x60; - can filter on &#x60;name&#x60;, &#x60;version&#x60;, &#x60;deploymentDate&#x60;, &#x60;deployedBy&#x60;, &#x60;activationState&#x60; with the value DISABLED or ENABLED, &#x60;configurationState&#x60; with the value UNRESOLVED, or RESOLVED, &#x60;processId&#x60;, &#x60;displayName&#x60;, &#x60;lastUpdateDate&#x60;, &#x60;categoryId&#x60;, &#x60;label&#x60;, &#x60;supervisor_id&#x60; 
   * Note, this is equivalent to the other <code>searchProcesses</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchProcessesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   <li>o - can order on attributes (optional)</li>
   *   <li>s - can search on attributes (optional)</li>
   *   </ul>
   * @return List&lt;ProcessDefinition&gt;
   */
  @RequestLine("GET /API/bpm/process?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
  "Accept: application/json",
  })
  List<ProcessDefinition> searchProcesses(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
  * Finds Processes
  * Finds Processes with pagination params and filters  - can order (default is ASC) on &#x60;name&#x60;, &#x60;version&#x60;, &#x60;deploymentDate&#x60;, &#x60;deployedBy&#x60;, &#x60;activationState&#x60;, &#x60;configurationState&#x60;, &#x60;processId&#x60;, &#x60;displayName&#x60;, &#x60;lastUpdateDate&#x60;, &#x60;categoryId&#x60;, &#x60;label&#x60; - can search on &#x60;name&#x60;, &#x60;displayName&#x60; or &#x60;version&#x60; - can filter on &#x60;name&#x60;, &#x60;version&#x60;, &#x60;deploymentDate&#x60;, &#x60;deployedBy&#x60;, &#x60;activationState&#x60; with the value DISABLED or ENABLED, &#x60;configurationState&#x60; with the value UNRESOLVED, or RESOLVED, &#x60;processId&#x60;, &#x60;displayName&#x60;, &#x60;lastUpdateDate&#x60;, &#x60;categoryId&#x60;, &#x60;label&#x60;, &#x60;supervisor_id&#x60; 
  * Note, this is equivalent to the other <code>searchProcesses</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>p - index of the page to display (required)</li>
          *   <li>c - maximum number of elements to retrieve (required)</li>
          *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
          *   <li>o - can order on attributes (optional)</li>
          *   <li>s - can search on attributes (optional)</li>
      *   </ul>
          * @return List&lt;ProcessDefinition&gt;
      */
      @RequestLine("GET /API/bpm/process?p={p}&c={c}&f={f}&o={o}&s={s}")
      @Headers({
    "Accept: application/json",
      })
   ApiResponse<List<ProcessDefinition>> searchProcessesWithHttpInfo(@QueryMap(encoded=true) Map<String, Object> queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>searchProcesses</code> method in a fluent style.
   */
  public static class SearchProcessesQueryParams extends HashMap<String, Object> {
    public SearchProcessesQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public SearchProcessesQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public SearchProcessesQueryParams f(final List<String> value) {
      put("f", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public SearchProcessesQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
    public SearchProcessesQueryParams s(final String value) {
      put("s", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Update the Process by ID
   * Update the Process for the given ID 
   * @param id ID of the Process to return (required)
   * @param processUpdateRequest Partial Process description (required)
   */
  @RequestLine("PUT /API/bpm/process/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateProcessById(@Param("id") String id, ProcessUpdateRequest processUpdateRequest);

  /**
   * Update the Process by ID
   * Similar to <code>updateProcessById</code> but it also returns the http response headers .
   * Update the Process for the given ID 
   * @param id ID of the Process to return (required)
   * @param processUpdateRequest Partial Process description (required)
   */
  @RequestLine("PUT /API/bpm/process/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Void> updateProcessByIdWithHttpInfo(@Param("id") String id, ProcessUpdateRequest processUpdateRequest);



  /**
   * Update the Process Connector by Process ID
   * Update the ProcessConnector for the given ID 
   * @param id ID of the process to update (required)
   * @param connectorImplId ID of the Process Connector implementation to update (required)
   * @param connectorImplVersion Version of the Process Connector implementation to update (required)
   * @param updateProcessConnectorByProcessIdRequest Partial ProcessConnector description (required)
   */
  @RequestLine("PUT /API/bpm/processConnector/{id}/{connectorImplId}/{connectorImplVersion}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateProcessConnectorByProcessId(@Param("id") String id, @Param("connectorImplId") String connectorImplId, @Param("connectorImplVersion") String connectorImplVersion, UpdateProcessConnectorByProcessIdRequest updateProcessConnectorByProcessIdRequest);

  /**
   * Update the Process Connector by Process ID
   * Similar to <code>updateProcessConnectorByProcessId</code> but it also returns the http response headers .
   * Update the ProcessConnector for the given ID 
   * @param id ID of the process to update (required)
   * @param connectorImplId ID of the Process Connector implementation to update (required)
   * @param connectorImplVersion Version of the Process Connector implementation to update (required)
   * @param updateProcessConnectorByProcessIdRequest Partial ProcessConnector description (required)
   */
  @RequestLine("PUT /API/bpm/processConnector/{id}/{connectorImplId}/{connectorImplVersion}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Void> updateProcessConnectorByProcessIdWithHttpInfo(@Param("id") String id, @Param("connectorImplId") String connectorImplId, @Param("connectorImplVersion") String connectorImplVersion, UpdateProcessConnectorByProcessIdRequest updateProcessConnectorByProcessIdRequest);



  /**
   * Upload a bar file
   * Upload a bar file 
   * @param file  (optional)
   * @return String
   */
  @RequestLine("POST /portal/processUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  String uploadProcess(@Param("file") File file);

  /**
   * Upload a bar file
   * Similar to <code>uploadProcess</code> but it also returns the http response headers .
   * Upload a bar file 
   * @param file  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /portal/processUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  ApiResponse<String> uploadProcessWithHttpInfo(@Param("file") File file);


}
