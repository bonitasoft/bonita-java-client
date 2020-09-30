package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Application;
import org.bonitasoft.web.client.internal.model.ApplicationUpdateRequest;
import org.bonitasoft.web.client.internal.model.CreateApplicationRequest;
import org.bonitasoft.web.client.internal.model.Error;
import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ApplicationApi {
  /**
   * Create a living applications
   * Create a living applications 
   * @param body Partial living application description (required)
   * @return Call&lt;Application&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/living/application")
  Call<Application> createApplication(
    @retrofit2.http.Body CreateApplicationRequest body
  );

  /**
   * Delete a living application by ID
   * Delete a single application for the given ID 
   * @param id ID of application to delete (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("API/living/application/{id}")
  Call<Void> deleteApplicationById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Finds living applications
   * Finds living applications with pagination params and filters  - can order on &#x60;id&#x60;,&#x60;creationDate&#x60;, &#x60;createdBy&#x60;, &#x60;profileId&#x60;, &#x60;token&#x60;, &#x60;displayName&#x60;, &#x60;updatedBy&#x60;, &#x60;lastUpdateDate&#x60;, &#x60;version&#x60; - can search on &#x60;token&#x60;, &#x60;displayName&#x60;, &#x60;version&#x60; - can filter on &#x60;token&#x60;, &#x60;displayName&#x60;, &#x60;version&#x60;, &#x60;profileId&#x60;, &#x60;creationDate&#x60;, &#x60;createdBy&#x60;, &#x60;updatedBy&#x60; , &#x60;lastUpdateDate&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;Application&gt;&gt;
   */
  @GET("API/living/application")
  Call<List<Application>> findApplications(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

  /**
   * Finds a living application by ID
   * Returns a single application for the given ID 
   * @param id ID of application to return (required)
   * @return Call&lt;Application&gt;
   */
  @GET("API/living/application/{id}")
  Call<Application> getApplicationById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Import a living application
   * Import a single application 
   * @param applicationsDataUpload Uploaded file (optional)
   * @param importPolicy Import policy (optional)
   * @return Call&lt;Void&gt;
   */
  @retrofit2.http.FormUrlEncoded
  @POST("services/application/import")
  Call<Void> importApplication(
    @retrofit2.http.Field("applicationsDataUpload") String applicationsDataUpload, @retrofit2.http.Field("importPolicy") String importPolicy
  );

  /**
   * Update a living application by ID
   * Update a single application for the given ID 
   * @param id ID of application to return (required)
   * @param applicationUpdateRequest Partial living application description (required)
   * @return Call&lt;Application&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/living/application/{id}")
  Call<Application> updateApplicationById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body ApplicationUpdateRequest applicationUpdateRequest
  );

  /**
   * Upload a living application
   * Upload application 
   * @param file  (optional)
   * @return Call&lt;Void&gt;
   */
  @retrofit2.http.Multipart
  @POST("portal/applicationsUpload")
  Call<Void> uploadApplication(
    @retrofit2.http.Part MultipartBody.Part file
  );

}
