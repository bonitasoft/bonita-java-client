package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.ArchivedHumanTask;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ArchivedHumanTaskApi {
  /**
   * Finds ArchivedHumanTasks
   * Finds ArchivedHumanTasks with pagination params and filters  You can filter on:  * &#x60;assigned_id&#x3D;{user_id}&#x60;: retrieve only the human tasks assigned to the specified ID. For example, retrieve the human tasks assigned to user with id 2: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;assigned_id%3d2&#x60; * &#x60;state&#x3D;&#x60;: retrieve only the archived user tasks with the specified state. For example, retrieve the skipped tasks: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;state&#x3D;skipped&#x60; * &#x60;name&#x3D;&#x60;: retrieve only the human tasks with the specified name. For example, retrieve the human tasks with the name \&quot;Analyse Case\&quot;: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;name&#x3D;Analyse Case&#x60; * &#x60;displayName&#x3D;&#x60;: retrieve only the archived user tasks with the specified displayName. For example, retrieve the human tasks with the displayName \&quot;Analyse Case\&quot;: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;displayName&#x3D;Analyse Case&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return Call&lt;List&lt;ArchivedHumanTask&gt;&gt;
   */
  @GET("API/bpm/archivedHumanTask")
  Call<List<ArchivedHumanTask>> findArchivedHumanTasks(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o
  );

  /**
   * Finds the ArchivedHumanTask by ID
   * Returns the single ArchivedHumanTask for the given ID 
   * @param id ID of the ArchivedHumanTask to return (required)
   * @return Call&lt;ArchivedHumanTask&gt;
   */
  @GET("API/bpm/archivedHumanTask/{id}")
  Call<ArchivedHumanTask> getArchivedHumanTaskById(
    @retrofit2.http.Path("id") String id
  );

}
