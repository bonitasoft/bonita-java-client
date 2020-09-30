package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.CaseComment;
import org.bonitasoft.web.client.internal.model.CaseCommentCreateRequest;
import org.bonitasoft.web.client.internal.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CaseCommentApi {
  /**
   * Create the CaseComment
   * Create the CaseComment 
   * @param body The process instance (case) id and the comment content, in JSON (required)
   * @return Call&lt;CaseComment&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/bpm/comment")
  Call<CaseComment> createCaseComment(
    @retrofit2.http.Body CaseCommentCreateRequest body
  );

  /**
   * Finds CaseComments
   * Finds CaseComments with pagination params and filters  - can order on &#x60;postDate&#x60; - can filter on &#x60;supervisor_id&#x60;,&#x60;user_id&#x60;,&#x60;processInstanceId&#x60; - You cannot use supervisor_id and user_id filter at the same time 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return Call&lt;List&lt;CaseComment&gt;&gt;
   */
  @GET("API/bpm/comment")
  Call<List<CaseComment>> findCaseComments(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o
  );

}
