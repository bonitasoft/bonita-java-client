package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.ArchivedCaseDocument;
import org.bonitasoft.web.client.internal.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ArchivedCaseDocumentApi {
  /**
   * Delete the ArchivedCaseDocument by ID
   * Delete the single ArchivedCaseDocument for the given ID 
   * @param id ID of the ArchivedCaseDocument to delete (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("API/bpm/archivedCaseDocument/{id}")
  Call<Void> deleteArchivedCaseDocumentById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Finds ArchivedCaseDocuments
   * Finds ArchivedCaseDocuments with pagination params and filters  You can filter on :  * &#x60;sourceObjectId&#x3D;\&quot;id\&quot;&#x60;: search for documents by specifying the original document id.   This is useful if you know the id of a caseDocument and you wish to retrieve all its previous versions.. * &#x60;caseId&#x3D;\&quot;id\&quot;&#x60;: search for documents with the specified open case id. * &#x60;archivedCaseId&#x3D;\&quot;id\&quot;&#x60;: search for documents with the specified archvied case id. * &#x60;submittedBy&#x3D;\&quot;id\&quot;&#x60;: search for documents that were submitted by the user with the specified identifier. * &#x60;name&#x3D;\&quot;string\&quot;&#x60;: search for documents with names that contain _string_.   Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the name or the start of a word in the name. * &#x60;description&#x3D;\&quot;string\&quot;&#x60;: search for documents with descriptions that contain _string_.   Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the description or the start of a word in the description. 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return Call&lt;List&lt;ArchivedCaseDocument&gt;&gt;
   */
  @GET("API/bpm/archivedCaseDocument")
  Call<List<ArchivedCaseDocument>> findArchivedCaseDocuments(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o
  );

}
