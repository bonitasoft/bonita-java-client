package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.CaseDocument;
import org.bonitasoft.web.client.internal.model.InlineObject13;
import org.bonitasoft.web.client.internal.model.InlineObject14;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface CaseDocumentApi {
  /**
   * Create the CaseDocument
   * Create the CaseDocument.  Use a POST method to add a document to a case. You can upload a document from the local file system or by URL. Specify the case id and the document name in the payload. The document description is optional: if you do not specify a description, the description in the response is empty. The response contains a version, which is managed automatically. You cannot currently retrieve a specific version of a document, only the most recent version. To retrieve earlier versions of a caseDocument, use the archivedCaseDocument resource. 
   * @param body  (required)
   * @return Call&lt;CaseDocument&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("API/bpm/caseDocument")
  Call<CaseDocument> createCaseDocument(
    @retrofit2.http.Body InlineObject13 body
  );

  /**
   * Delete the CaseDocument by ID
   * Delete the single CaseDocument for the given ID 
   * @param id ID of the CaseDocument to delete (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("API/bpm/caseDocument/{id}")
  Call<Void> deleteCaseDocumentById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Finds CaseDocuments
   * Finds CaseDocuments with pagination params and filters  It is possible to filter on three parameters: &#x60;submittedBy&#x60;, &#x60;name&#x60; and &#x60;description&#x60;.   * &#x60;submittedBy&#x3D;\&quot;id\&quot;&#x60;: search for documents that were submitted by the user with the specified identifier.  * &#x60;name&#x3D;\&quot;string\&quot;&#x60;: search for documents with names that contain _string_.    Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the name or the start of a word in the name.  * &#x60;description&#x3D;\&quot;string\&quot;&#x60;: search for documents with descriptions that contain _string_.    Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the description or the start of a word in the description. 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return Call&lt;List&lt;CaseDocument&gt;&gt;
   */
  @GET("API/bpm/caseDocument")
  Call<List<CaseDocument>> findCaseDocuments(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o
  );

  /**
   * Finds the CaseDocument by ID
   * Returns the single CaseDocument for the given ID. Use a GET method to get a document from a case. First you get the document information, then you download the content. To get the document information, specify the document id in the URL. The document id is created when you upload a document to a case. There is no payload. 
   * @param id ID of the CaseDocument to return (required)
   * @return Call&lt;CaseDocument&gt;
   */
  @GET("API/bpm/caseDocument/{id}")
  Call<CaseDocument> getCaseDocumentById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Update the CaseDocument by ID
   * Update the CaseDocument for the given ID  You update a document in a case by uploading a new version of the document using a PUT method. You can upload a document version from the local file system or by URL. The document name will be used in all the cases of the process, but the combination of case id and document name is unique. In the URL, you specify to supply the document id. This is included in the response when you first add a document to a case. The response to PUT methods is the same as for POST methods. 
   * @param id ID of the CaseDocument to return (required)
   * @param inlineObject14  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/bpm/caseDocument/{id}")
  Call<Void> updateCaseDocumentById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body InlineObject14 inlineObject14
  );

}
