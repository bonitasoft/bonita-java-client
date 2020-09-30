package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.ProfileEntry;
import org.bonitasoft.web.client.internal.model.ProfileEntryCreateRequest;
import org.bonitasoft.web.client.internal.model.ProfileEntryUpdateRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProfileEntryApi {
  /**
   * Create the ProfileEntry
   * Create the ProfileEntry 
   * @param body Partial ProfileEntry description (required)
   * @return Call&lt;ProfileEntry&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/portal/profileEntry")
  Call<ProfileEntry> createProfileEntry(
    @retrofit2.http.Body ProfileEntryCreateRequest body
  );

  /**
   * Delete the ProfileEntry by ID
   * Delete the single ProfileEntry for the given ID 
   * @param id ID of the ProfileEntry to delete (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("API/portal/profileEntry/{id}")
  Call<Void> deleteProfileEntryById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Finds ProfileEntries
   * Finds ProfileEntries with pagination params and filters  - can search on &#x60;name&#x60; - can filter on &#x60;page&#x60;,&#x60;name&#x60; and &#x60;parent_id&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;ProfileEntry&gt;&gt;
   */
  @GET("API/portal/profileEntry")
  Call<List<ProfileEntry>> findProfileEntries(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("s") String s
  );

  /**
   * Finds the ProfileEntry by ID
   * Returns the single ProfileEntry for the given ID 
   * @param id ID of the ProfileEntry to return (required)
   * @return Call&lt;ProfileEntry&gt;
   */
  @GET("API/portal/profileEntry/{id}")
  Call<ProfileEntry> getProfileEntryById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Update the ProfileEntry by ID
   * Update the ProfileEntry for the given ID 
   * @param id ID of the ProfileEntry to return (required)
   * @param profileEntryUpdateRequest Partial ProfileEntry description (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/portal/profileEntry/{id}")
  Call<Void> updateProfileEntryById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body ProfileEntryUpdateRequest profileEntryUpdateRequest
  );

}
