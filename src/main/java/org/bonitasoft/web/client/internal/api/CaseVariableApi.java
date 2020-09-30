package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.CaseVariable;
import org.bonitasoft.web.client.internal.model.InlineObject12;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;

import java.util.List;

public interface CaseVariableApi {
  /**
   * Finds Case Variables
   * Finds Case Variables with pagination params and filters 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return Call&lt;List&lt;CaseVariable&gt;&gt;
   */
  @GET("API/bpm/caseVariable")
  Call<List<CaseVariable>> findCaseVariables(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o
  );

  /**
   * Finds the Variable by Case ID
   * Returns the single Variable for the given Case ID 
   * @param id The identifier of the case from which to retrieve the variable (required)
   * @param variableName The name of the variable to retrieve (required)
   * @return Call&lt;CaseVariable&gt;
   */
  @GET("API/bpm/caseVariable/{id}/{variableName}")
  Call<CaseVariable> getVariableByCaseId(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Path("variableName") oas_any_type_not_mapped variableName
  );

  /**
   * Update a Variable by Case ID
   * Update the variable for the given Case ID.  **Warning** : only following types are supported for javaTypeclassname: &#x60;java.lang.String&#x60;, &#x60;java.lang.Integer&#x60;, &#x60;java.lang.Double&#x60;, &#x60;java.lang.Long&#x60;, &#x60;java.lang.Boolean&#x60;, &#x60;java.util.Date&#x60; 
   * @param id The identifier of the case from which to retrieve the variable (required)
   * @param variableName The name of the variable to retrieve (required)
   * @param inlineObject12  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/bpm/caseVariable/{id}/{variableName}")
  Call<Void> updateVariableByCaseId(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Path("variableName") oas_any_type_not_mapped variableName, @retrofit2.http.Body InlineObject12 inlineObject12
  );

}
