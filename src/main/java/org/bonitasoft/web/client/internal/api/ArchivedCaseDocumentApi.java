package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.EncodingUtils;

import org.bonitasoft.web.client.internal.model.ArchivedCaseDocument;
import org.bonitasoft.web.client.internal.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface ArchivedCaseDocumentApi extends ApiClient.Api {


  /**
   * Delete the ArchivedCaseDocument by ID
   * Delete the single ArchivedCaseDocument for the given ID 
   * @param id ID of the ArchivedCaseDocument to delete (required)
   */
  @RequestLine("DELETE /API/bpm/archivedCaseDocument/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteArchivedCaseDocumentById(@Param("id") String id);

  /**
   * Finds ArchivedCaseDocuments
   * Finds ArchivedCaseDocuments with pagination params and filters  You can filter on :  * &#x60;sourceObjectId&#x3D;\&quot;id\&quot;&#x60;: search for documents by specifying the original document id.   This is useful if you know the id of a caseDocument and you wish to retrieve all its previous versions.. * &#x60;caseId&#x3D;\&quot;id\&quot;&#x60;: search for documents with the specified open case id. * &#x60;archivedCaseId&#x3D;\&quot;id\&quot;&#x60;: search for documents with the specified archvied case id. * &#x60;submittedBy&#x3D;\&quot;id\&quot;&#x60;: search for documents that were submitted by the user with the specified identifier. * &#x60;name&#x3D;\&quot;string\&quot;&#x60;: search for documents with names that contain _string_.   Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the name or the start of a word in the name. * &#x60;description&#x3D;\&quot;string\&quot;&#x60;: search for documents with descriptions that contain _string_.   Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the description or the start of a word in the description. 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return List&lt;ArchivedCaseDocument&gt;
   */
  @RequestLine("GET /API/bpm/archivedCaseDocument?p={p}&c={c}&f={f}&o={o}")
  @Headers({
    "Accept: application/json",
  })
  List<ArchivedCaseDocument> findArchivedCaseDocuments(@Param("p") Integer p, @Param("c") Integer c, @Param("f") String f, @Param("o") String o);

  /**
   * Finds ArchivedCaseDocuments
   * Finds ArchivedCaseDocuments with pagination params and filters  You can filter on :  * &#x60;sourceObjectId&#x3D;\&quot;id\&quot;&#x60;: search for documents by specifying the original document id.   This is useful if you know the id of a caseDocument and you wish to retrieve all its previous versions.. * &#x60;caseId&#x3D;\&quot;id\&quot;&#x60;: search for documents with the specified open case id. * &#x60;archivedCaseId&#x3D;\&quot;id\&quot;&#x60;: search for documents with the specified archvied case id. * &#x60;submittedBy&#x3D;\&quot;id\&quot;&#x60;: search for documents that were submitted by the user with the specified identifier. * &#x60;name&#x3D;\&quot;string\&quot;&#x60;: search for documents with names that contain _string_.   Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the name or the start of a word in the name. * &#x60;description&#x3D;\&quot;string\&quot;&#x60;: search for documents with descriptions that contain _string_.   Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the description or the start of a word in the description. 
   * Note, this is equivalent to the other <code>findArchivedCaseDocuments</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindArchivedCaseDocumentsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   <li>o - can order on attributes (optional)</li>
   *   </ul>
   * @return List&lt;ArchivedCaseDocument&gt;
   */
  @RequestLine("GET /API/bpm/archivedCaseDocument?p={p}&c={c}&f={f}&o={o}")
  @Headers({
  "Accept: application/json",
  })
  List<ArchivedCaseDocument> findArchivedCaseDocuments(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findArchivedCaseDocuments</code> method in a fluent style.
   */
  public static class FindArchivedCaseDocumentsQueryParams extends HashMap<String, Object> {
    public FindArchivedCaseDocumentsQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public FindArchivedCaseDocumentsQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public FindArchivedCaseDocumentsQueryParams f(final String value) {
      put("f", EncodingUtils.encode(value));
      return this;
    }
    public FindArchivedCaseDocumentsQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
  }
}
