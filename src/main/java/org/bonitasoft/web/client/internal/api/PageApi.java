package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;
import java.io.File;
import org.bonitasoft.web.client.internal.model.Page;
import org.bonitasoft.web.client.internal.model.PageCreateRequest;
import org.bonitasoft.web.client.internal.model.PageUpdateRequest;
import org.bonitasoft.web.client.internal.model.PageUploadResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PageApi {
  /**
   * Create the Page
   * Upload the page content using the &#x60;portal/pageUpload&#x60; . This returns a temporary file name that can be used as input for this operation. 
   * @param body Zip name as named in the temp folder after upload (required)
   * @return Call&lt;Page&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/portal/page")
  Call<Page> createPage(
    @retrofit2.http.Body PageCreateRequest body
  );

  /**
   * Delete the Page by ID
   * Delete the single Page for the given ID 
   * @param id ID of the Page to delete (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("API/portal/page/{id}")
  Call<Void> deletePageById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Finds Pages
   * Finds Pages with pagination params and filters  - can search on &#x60;displayName&#x60;,&#x60;description&#x60; - can filter on &#x60;createdBy&#x60;,&#x60;contentType&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return Call&lt;List&lt;Page&gt;&gt;
   */
  @GET("API/portal/page")
  Call<List<Page>> findPages(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o, @retrofit2.http.Query("s") String s
  );

  /**
   * Finds the Page by ID
   * Returns the single Page for the given ID 
   * @param id ID of the Page to return (required)
   * @return Call&lt;Page&gt;
   */
  @GET("API/portal/page/{id}")
  Call<Page> getPageById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Update the Page by ID
   * Use the PUT method to update an existing custom page. To update a custom page, upload the new page content using the pageUpload servlet, which returns a temporary file name, and then call this API with the temporary file name. 
   * @param id ID of the Page to return (required)
   * @param pageUpdateRequest Partial Page description (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/portal/page/{id}")
  Call<Void> updatePageById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body PageUpdateRequest pageUpdateRequest
  );

  /**
   * Upload a Page
   * Upload Page 
   * @param file  (optional)
   * @return Call&lt;PageUploadResponse&gt;
   */
  @retrofit2.http.Multipart
  @POST("portal/pageUpload")
  Call<PageUploadResponse> uploadPage(
    @retrofit2.http.Part MultipartBody.Part file
  );

}
