package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.ProcessInstanceDocument;
import org.bonitasoft.web.client.model.ProcessInstanceDocumentCreateRequest;
import org.bonitasoft.web.client.model.ProcessInstanceDocumentUpdateRequest;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ProcessInstanceDocumentApi extends ApiClient.Api {


  /**
   * Create the ProcessInstanceDocument
   * Create the ProcessInstanceDocument.  Use a POST method to add a document to a process instances. You can upload a document from the local file system or by URL. Specify the process instance id and the document name in the payload. The document description is optional: if you do not specify a description, the description in the response is empty. The response contains a version, which is managed automatically. You cannot currently retrieve a specific version of a document, only the most recent version. To retrieve earlier versions of a ProcessInstanceDocument, use the archivedProcessInstanceDocument resource. 
   * @param body Partial ProcessInstanceDocument description (required)
   * @return ProcessInstanceDocument
   */
  @RequestLine("POST /API/bpm/caseDocument")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ProcessInstanceDocument createProcessInstanceDocument(ProcessInstanceDocumentCreateRequest body);

  /**
   * Create the ProcessInstanceDocument
   * Similar to <code>createProcessInstanceDocument</code> but it also returns the http response headers .
   * Create the ProcessInstanceDocument.  Use a POST method to add a document to a process instances. You can upload a document from the local file system or by URL. Specify the process instance id and the document name in the payload. The document description is optional: if you do not specify a description, the description in the response is empty. The response contains a version, which is managed automatically. You cannot currently retrieve a specific version of a document, only the most recent version. To retrieve earlier versions of a ProcessInstanceDocument, use the archivedProcessInstanceDocument resource. 
   * @param body Partial ProcessInstanceDocument description (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /API/bpm/caseDocument")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<ProcessInstanceDocument> createProcessInstanceDocumentWithHttpInfo(ProcessInstanceDocumentCreateRequest body);



  /**
   * Delete the ProcessInstanceDocument by ID
   * Delete the single ProcessInstanceDocument for the given ID 
   * @param id ID of the ProcessInstanceDocument to delete (required)
   */
  @RequestLine("DELETE /API/bpm/caseDocument/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteProcessInstanceDocumentById(@Param("id") String id);

  /**
   * Delete the ProcessInstanceDocument by ID
   * Similar to <code>deleteProcessInstanceDocumentById</code> but it also returns the http response headers .
   * Delete the single ProcessInstanceDocument for the given ID 
   * @param id ID of the ProcessInstanceDocument to delete (required)
   */
  @RequestLine("DELETE /API/bpm/caseDocument/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteProcessInstanceDocumentByIdWithHttpInfo(@Param("id") String id);



  /**
   * Finds the ProcessInstanceDocument by ID
   * Returns the single ProcessInstanceDocument for the given ID. Use a GET method to get a document from a process instances. First you get the document information, then you download the content. To get the document information, specify the document id in the URL. The document id is created when you upload a document to a process instances. There is no payload. 
   * @param id ID of the ProcessInstanceDocument to return (required)
   * @return ProcessInstanceDocument
   */
  @RequestLine("GET /API/bpm/caseDocument/{id}")
  @Headers({
    "Accept: application/json",
  })
  ProcessInstanceDocument getProcessInstanceDocumentById(@Param("id") String id);

  /**
   * Finds the ProcessInstanceDocument by ID
   * Similar to <code>getProcessInstanceDocumentById</code> but it also returns the http response headers .
   * Returns the single ProcessInstanceDocument for the given ID. Use a GET method to get a document from a process instances. First you get the document information, then you download the content. To get the document information, specify the document id in the URL. The document id is created when you upload a document to a process instances. There is no payload. 
   * @param id ID of the ProcessInstanceDocument to return (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/caseDocument/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<ProcessInstanceDocument> getProcessInstanceDocumentByIdWithHttpInfo(@Param("id") String id);



  /**
   * Finds ProcessInstanceDocuments
   * Finds ProcessInstanceDocuments with pagination params and filters  It is possible to filter on three parameters: &#x60;submittedBy&#x60;, &#x60;name&#x60; and &#x60;description&#x60;.   * &#x60;submittedBy&#x3D;\&quot;id\&quot;&#x60;: search for documents that were submitted by the user with the specified identifier.  * &#x60;name&#x3D;\&quot;string\&quot;&#x60;: search for documents with names that contain _string_.    Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the name or the start of a word in the name.  * &#x60;description&#x3D;\&quot;string\&quot;&#x60;: search for documents with descriptions that contain _string_.    Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the description or the start of a word in the description. 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return List&lt;ProcessInstanceDocument&gt;
   */
  @RequestLine("GET /API/bpm/caseDocument?p={p}&c={c}&f={f}&o={o}")
  @Headers({
    "Accept: application/json",
  })
  List<ProcessInstanceDocument> searchProcessInstanceDocuments(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o);

  /**
   * Finds ProcessInstanceDocuments
   * Similar to <code>searchProcessInstanceDocuments</code> but it also returns the http response headers .
   * Finds ProcessInstanceDocuments with pagination params and filters  It is possible to filter on three parameters: &#x60;submittedBy&#x60;, &#x60;name&#x60; and &#x60;description&#x60;.   * &#x60;submittedBy&#x3D;\&quot;id\&quot;&#x60;: search for documents that were submitted by the user with the specified identifier.  * &#x60;name&#x3D;\&quot;string\&quot;&#x60;: search for documents with names that contain _string_.    Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the name or the start of a word in the name.  * &#x60;description&#x3D;\&quot;string\&quot;&#x60;: search for documents with descriptions that contain _string_.    Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the description or the start of a word in the description. 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /API/bpm/caseDocument?p={p}&c={c}&f={f}&o={o}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<ProcessInstanceDocument>> searchProcessInstanceDocumentsWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o);


  /**
   * Finds ProcessInstanceDocuments
   * Finds ProcessInstanceDocuments with pagination params and filters  It is possible to filter on three parameters: &#x60;submittedBy&#x60;, &#x60;name&#x60; and &#x60;description&#x60;.   * &#x60;submittedBy&#x3D;\&quot;id\&quot;&#x60;: search for documents that were submitted by the user with the specified identifier.  * &#x60;name&#x3D;\&quot;string\&quot;&#x60;: search for documents with names that contain _string_.    Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the name or the start of a word in the name.  * &#x60;description&#x3D;\&quot;string\&quot;&#x60;: search for documents with descriptions that contain _string_.    Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the description or the start of a word in the description. 
   * Note, this is equivalent to the other <code>searchProcessInstanceDocuments</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchProcessInstanceDocumentsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   <li>o - can order on attributes (optional)</li>
   *   </ul>
   * @return List&lt;ProcessInstanceDocument&gt;
   */
  @RequestLine("GET /API/bpm/caseDocument?p={p}&c={c}&f={f}&o={o}")
  @Headers({
  "Accept: application/json",
  })
  List<ProcessInstanceDocument> searchProcessInstanceDocuments(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
  * Finds ProcessInstanceDocuments
  * Finds ProcessInstanceDocuments with pagination params and filters  It is possible to filter on three parameters: &#x60;submittedBy&#x60;, &#x60;name&#x60; and &#x60;description&#x60;.   * &#x60;submittedBy&#x3D;\&quot;id\&quot;&#x60;: search for documents that were submitted by the user with the specified identifier.  * &#x60;name&#x3D;\&quot;string\&quot;&#x60;: search for documents with names that contain _string_.    Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the name or the start of a word in the name.  * &#x60;description&#x3D;\&quot;string\&quot;&#x60;: search for documents with descriptions that contain _string_.    Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the description or the start of a word in the description. 
  * Note, this is equivalent to the other <code>searchProcessInstanceDocuments</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>p - index of the page to display (required)</li>
          *   <li>c - maximum number of elements to retrieve (required)</li>
          *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
          *   <li>o - can order on attributes (optional)</li>
      *   </ul>
          * @return List&lt;ProcessInstanceDocument&gt;
      */
      @RequestLine("GET /API/bpm/caseDocument?p={p}&c={c}&f={f}&o={o}")
      @Headers({
    "Accept: application/json",
      })
   ApiResponse<List<ProcessInstanceDocument>> searchProcessInstanceDocumentsWithHttpInfo(@QueryMap(encoded=true) Map<String, Object> queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>searchProcessInstanceDocuments</code> method in a fluent style.
   */
  public static class SearchProcessInstanceDocumentsQueryParams extends HashMap<String, Object> {
    public SearchProcessInstanceDocumentsQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public SearchProcessInstanceDocumentsQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public SearchProcessInstanceDocumentsQueryParams f(final List<String> value) {
      put("f", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public SearchProcessInstanceDocumentsQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Update the ProcessInstanceDocument by ID
   * Update the ProcessInstanceDocument for the given ID  You update a document in a process instance by uploading a new version of the document using a PUT method. You can upload a document version from the local file system or by URL. The document name will be used in all the process instances of the process, but the combination of process instance id and document name is unique. In the URL, you specify to supply the document id. This is included in the response when you first add a document to a process instances. The response to PUT methods is the same as for POST methods. 
   * @param id ID of the ProcessInstanceDocument to return (required)
   * @param processInstanceDocumentUpdateRequest Partial ProcessInstanceDocument description (required)
   */
  @RequestLine("PUT /API/bpm/caseDocument/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updateProcessInstanceDocumentById(@Param("id") String id, ProcessInstanceDocumentUpdateRequest processInstanceDocumentUpdateRequest);

  /**
   * Update the ProcessInstanceDocument by ID
   * Similar to <code>updateProcessInstanceDocumentById</code> but it also returns the http response headers .
   * Update the ProcessInstanceDocument for the given ID  You update a document in a process instance by uploading a new version of the document using a PUT method. You can upload a document version from the local file system or by URL. The document name will be used in all the process instances of the process, but the combination of process instance id and document name is unique. In the URL, you specify to supply the document id. This is included in the response when you first add a document to a process instances. The response to PUT methods is the same as for POST methods. 
   * @param id ID of the ProcessInstanceDocument to return (required)
   * @param processInstanceDocumentUpdateRequest Partial ProcessInstanceDocument description (required)
   */
  @RequestLine("PUT /API/bpm/caseDocument/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Void> updateProcessInstanceDocumentByIdWithHttpInfo(@Param("id") String id, ProcessInstanceDocumentUpdateRequest processInstanceDocumentUpdateRequest);


}
