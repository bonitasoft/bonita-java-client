package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.ProcessResolutionProblem;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ProcessResolutionProblemApi {
  /**
   * Finds ProcessResolutionProblems
   * Finds ProcessResolutionProblems with pagination params and filters to list the problems that need to be solved before a process can be used.  **Filtering on the process definition ID is mandatory.** 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;ProcessResolutionProblem&gt;&gt;
   */
  @GET("API/bpm/processResolutionProblem")
  Call<List<ProcessResolutionProblem>> findProcessResolutionProblems(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

}
