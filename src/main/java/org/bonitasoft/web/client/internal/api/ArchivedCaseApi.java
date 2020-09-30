package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.ArchivedCase;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;

import java.util.List;
import java.util.Map;

public interface ArchivedCaseApi {
  /**
   * Delete the ArchivedCase by ID
   * Delete the single ArchivedCase for the given ID 
   * @param id ID of the ArchivedCase to delete (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("API/bpm/archivedCase/{id}")
  Call<Void> deleteArchivedCaseById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Finds ArchivedCases
   * Finds ArchivedCases with pagination params and filters  You can order on &#x60;id&#x60;, &#x60;processDefinitionId&#x60;, &#x60;startedBy&#x60;, &#x60;startedBySubstitute&#x60;, &#x60;startDate&#x60;, &#x60;endDate&#x60;, &#x60;lastUpdate&#x60;, &#x60;archivedDate&#x60;, &#x60;sourceObjectId&#x60;  You can filter on :  * &#x60;sourceObjectId&#x60;: The original case ID before the case was archived * &#x60;processDefinitionId&#x60;: The process derfinition ID * &#x60;name&#x60;: the process name * &#x60;started_by&#x60;: the ID of the user who started the process * &#x60;team_manager_id&#x60;: allow to retrieve the cases in which all users with this manager ID ar involved) * &#x60;supervisor_id&#x60;: allow the retrived the cases of all processes the user with this ID is supervisor of) beware you cannot use team_manager_id and supervisor_id at the same time 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return Call&lt;List&lt;ArchivedCase&gt;&gt;
   */
  @GET("API/bpm/archivedCase")
  Call<List<ArchivedCase>> findArchivedCases(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o
  );

  /**
   * Finds the ArchivedCase by ID
   * Returns the single ArchivedCase for the given ID 
   * @param id ID of the ArchivedCase to return (required)
   * @return Call&lt;ArchivedCase&gt;
   */
  @GET("API/bpm/archivedCase/{id}")
  Call<ArchivedCase> getArchivedCaseById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Finds the Context by ArchivedCase ID
   * Returns the Context for the given ArchivedCase ID 
   * @param id ID of the ArchivedCase that has the Context to return (required)
   * @return Call&lt;Map&lt;String, Object&gt;&gt;
   */
  @GET("API/bpm/archivedCase/{id}/context")
  Call<Map<String, Object>> getContextByArchivedCaseId(
    @retrofit2.http.Path("id") String id
  );

}
