package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.CaseCreateRequest;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.ModelCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CaseApi {
  /**
   * Create the Case
   * ![edition](https://img.shields.io/badge/edition-entreprise-blue) ![edition](https://img.shields.io/badge/edition-community-brightgreen)  Create the Case This way of creating a case using this method will only work for processes in which no contract is defined. To instantiate a process with a contract, check the process instantiation resource documentation. 
   * @param body **Warning**: The attribute &#x60;variables&#x60; on the request payload is used to initialize the process variables (not BDM variables). If you want to initialize BDM variables at process instantiation, add a contract on the process and map BDM variables to the contract data. See Start a process using an instantiation contract for usage.  (required)
   * @return Call&lt;ModelCase&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/bpm/case")
  Call<ModelCase> createCase(
    @retrofit2.http.Body CaseCreateRequest body
  );

  /**
   * Delete the Case by ID
   * Delete the single Case for the given ID 
   * @param id ID of the Case to delete (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("API/bpm/case/{id}")
  Call<Void> deleteCaseById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Delete the Case by batch
   * ![edition](https://img.shields.io/badge/edition-entreprise-blue) ![edition](https://img.shields.io/badge/edition-community-brightgreen)  Delete a list of Cases for the given IDs 
   * @param requestBody  (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("API/bpm/case")
  Call<Void> deleteCaseByIds(
    @retrofit2.http.Body List<String> requestBody
  );

  /**
   * Finds Cases
   * Finds Cases with pagination params and filters  You can filter on:  * &#x60;processDefinitionId&#x60;: The process derfinition ID * &#x60;name&#x60;: the process name * &#x60;started_by&#x60;: the ID of the user who started the process * &#x60;team_manager_id&#x60;: allow to retrieve the cases in which all users with this manager ID ar involved) * &#x60;supervisor_id&#x60;: allow the retrived the cases of all processes the user with this ID is supervisor of) beware you cannot use team_manager_id and supervisor_id at the same time 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return Call&lt;List&lt;ModelCase&gt;&gt;
   */
  @GET("API/bpm/case")
  Call<List<ModelCase>> findCases(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o
  );

  /**
   * Finds the Case by ID
   * Returns the single Case for the given ID 
   * @param id ID of the Case to return (required)
   * @param n Count of related resources (optional)
   * @return Call&lt;ModelCase&gt;
   */
  @GET("API/bpm/case/{id}")
  Call<ModelCase> getCaseById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("n") String n
  );

  /**
   * Finds the Context by Case ID
   * Returns the Context for the given Case ID 
   * @param id ID of the Case that has the Context to return (required)
   * @return Call&lt;Map&lt;String, Object&gt;&gt;
   */
  @GET("API/bpm/case/{id}/context")
  Call<Map<String, Object>> getContextByCaseId(
    @retrofit2.http.Path("id") String id
  );

}
