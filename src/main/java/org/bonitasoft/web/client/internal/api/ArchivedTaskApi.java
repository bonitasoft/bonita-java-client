package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.ArchivedTask;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ArchivedTaskApi {
  /**
   * Finds ArchivedTasks
   * Finds ArchivedTasks with pagination params and filters  - Can order on &#x60;caseId&#x60;, &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;processId&#x60;, &#x60;state&#x60;, &#x60;type&#x60;, &#x60;archivedDate&#x60;, &#x60;reached_state_date&#x60;, &#x60;assigned_id&#x60; - Can filter on &#x60;caseId&#x60;, &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;processId&#x60;, &#x60;state&#x60;, &#x60;type&#x60;, &#x60;archivedDate&#x60;, &#x60;reached_state_date&#x60;, &#x60;assigned_id&#x60;, &#x60;isTerminal&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return Call&lt;List&lt;ArchivedTask&gt;&gt;
   */
  @GET("API/bpm/archivedTask")
  Call<List<ArchivedTask>> findArchivedTasks(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o
  );

  /**
   * Finds the ArchivedTask by ID
   * Returns the single ArchivedTask for the given ID 
   * @param id ID of the ArchivedTask to return (required)
   * @return Call&lt;ArchivedTask&gt;
   */
  @GET("API/bpm/archivedTask/{id}")
  Call<ArchivedTask> getArchivedTaskById(
    @retrofit2.http.Path("id") String id
  );

}
