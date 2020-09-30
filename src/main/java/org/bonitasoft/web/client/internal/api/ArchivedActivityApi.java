package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.ArchivedActivity;
import org.bonitasoft.web.client.internal.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ArchivedActivityApi {
  /**
   * Finds Archived Activities
   * Finds Archived  Activities with pagination params and filters. Activities in states completed, cancelled, or aborted are not retrieved. The search returns an array of activities.  Can order on:   - &#x60;name&#x60; : the name of this activity   - &#x60;displayName&#x60; : the display name of this activity   - &#x60;state&#x60; : the current state of the activity   - &#x60;type&#x60; : the activity type   - &#x60;isTerminal&#x60; : say whether or not the activity is in a terminal state   - &#x60;processId&#x60; : the process this activity is associated to   - &#x60;caseId&#x60; : the case initiator this activity is associated to   - &#x60;reached_state_date&#x60; : the date when this activity arrived in this state  Can filter on:   - &#x60;supervisor_id&#x60;: retrieve the information the process manager associated to this id has access to (only in Enterprise editions)   - f: same as the sort order fields 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;ArchivedActivity&gt;&gt;
   */
  @GET("API/bpm/archivedActivity")
  Call<List<ArchivedActivity>> findArchivedActivities(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

  /**
   * Finds the Archived Activity by ID
   * Returns the single Archived Activity for the given ID 
   * @param id ID of the Archived Activity to return (required)
   * @return Call&lt;ArchivedActivity&gt;
   */
  @GET("API/bpm/archivedActivity/{id}")
  Call<ArchivedActivity> getArchivedActivityById(
    @retrofit2.http.Path("id") String id
  );

}
