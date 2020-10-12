package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;

import org.bonitasoft.web.client.model.CaseDocument;
import org.bonitasoft.web.client.model.CaseDocumentCreateRequest;
import org.bonitasoft.web.client.model.CaseDocumentUpdateRequest;
import org.bonitasoft.web.client.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface CaseDocumentApi extends ApiClient.Api {


  /**
   * Create the CaseDocument
   * Create the CaseDocument.  Use a POST method to add a document to a case. You can upload a document from the local file system or by URL. Specify the case id and the document name in the payload. The document description is optional: if you do not specify a description, the description in the response is empty. The response contains a version, which is managed automatically. You cannot currently retrieve a specific version of a document, only the most recent version. To retrieve earlier versions of a caseDocument, use the archivedCaseDocument resource. 
   * @param body Partial CaseDocument description (required)
   * @return CaseDocument
   */
  @RequestLine("POST /API/bpm/caseDocument")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  CaseDocument createCaseDocument(CaseDocumentCreateRequest body);

  /**
   * Delete the CaseDocument by ID
   * Delete the single CaseDocument for the given ID 
   * @param id ID of the CaseDocument to delete (required)
   */
  @RequestLine("DELETE /API/bpm/caseDocument/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteCaseDocumentById(@Param("id") String id);

  /**
   * Finds the CaseDocument by ID
   * Returns the single CaseDocument for the given ID. Use a GET method to get a document from a case. First you get the document information, then you download the content. To get the document information, specify the document id in the URL. The document id is created when you upload a document to a case. There is no payload. 
   * @param id ID of the CaseDocument to return (required)
   * @return CaseDocument
   */
  @RequestLine("GET /API/bpm/caseDocument/{id}")
  @Headers({
    "Accept: application/json",
  })
  CaseDocument getCaseDocumentById(@Param("id") String id);

  /**
   * Finds CaseDocuments
   * Finds CaseDocuments with pagination params and filters  It is possible to filter on three parameters: &#x60;submittedBy&#x60;, &#x60;name&#x60; and &#x60;description&#x60;.   * &#x60;submittedBy&#x3D;\&quot;id\&quot;&#x60;: search for documents that were submitted by the user with the specified identifier.  * &#x60;name&#x3D;\&quot;string\&quot;&#x60;: search for documents with names that contain _string_.    Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the name or the start of a word in the name.  * &#x60;description&#x3D;\&quot;string\&quot;&#x60;: search for documents with descriptions that contain _string_.    Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the description or the start of a word in the description. 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return List&lt;CaseDocument&gt;
   */
  @RequestLine("GET /API/bpm/caseDocument?p={p}&c={c}&f={f}&o={o}")
  @Headers({
    "Accept: application/json",
  })
  List<CaseDocument> searchCaseDocuments(@Param("p") Integer p, @Param("c") Integer c, @Param("f") String f, @Param("o") String o);

  /**
   * Finds CaseDocuments
   * Finds CaseDocuments with pagination params and filters  It is possible to filter on three parameters: &#x60;submittedBy&#x60;, &#x60;name&#x60; and &#x60;description&#x60;.   * &#x60;submittedBy&#x3D;\&quot;id\&quot;&#x60;: search for documents that were submitted by the user with the specified identifier.  * &#x60;name&#x3D;\&quot;string\&quot;&#x60;: search for documents with names that contain _string_.    Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the name or the start of a word in the name.  * &#x60;description&#x3D;\&quot;string\&quot;&#x60;: search for documents with descriptions that contain _string_.    Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the description or the start of a word in the description. 
   * Note, this is equivalent to the other <code>searchCaseDocuments</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchCaseDocumentsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   <li>o - can order on attributes (optional)</li>
   *   </ul>
   * @return List&lt;CaseDocument&gt;
   */
  @RequestLine("GET /API/bpm/caseDocument?p={p}&c={c}&f={f}&o={o}")
  @Headers({
  "Accept: application/json",
  })
  List<CaseDocument> searchCaseDocuments(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>searchCaseDocuments</code> method in a fluent style.
   */
  public static class SearchCaseDocumentsQueryParams extends HashMap<String, Object> {
    public SearchCaseDocumentsQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public SearchCaseDocumentsQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public SearchCaseDocumentsQueryParams f(final String value) {
      put("f", EncodingUtils.encode(value));
      return this;
    }
    public SearchCaseDocumentsQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Update the CaseDocument by ID
   * Update the CaseDocument for the given ID  You update a document in a case by uploading a new version of the document using a PUT method. You can upload a document version from the local file system or by URL. The document name will be used in all the cases of the process, but the combination of case id and document name is unique. In the URL, you specify to supply the document id. This is included in the response when you first add a document to a case. The response to PUT methods is the same as for POST methods. 
   * @param id ID of the CaseDocument to return (required)
   * @param caseDocumentUpdateRequest Partial CaseDocument description (required)
   */
  @RequestLine("PUT /API/bpm/caseDocument/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateCaseDocumentById(@Param("id") String id, CaseDocumentUpdateRequest caseDocumentUpdateRequest);
}
