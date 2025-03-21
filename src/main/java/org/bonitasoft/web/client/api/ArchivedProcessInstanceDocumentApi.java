/** 
 * Copyright (C) 2025 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.List;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.ArchivedProcessInstanceDocument;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public interface ArchivedProcessInstanceDocumentApi extends ApiClient.Api {

    /**
     * Delete the ArchivedProcessInstanceDocument by ID
     * Delete the single ArchivedProcessInstanceDocument for the given ID
     * 
     * @param id ID of the ArchivedProcessInstanceDocument to delete (required)
     */
    @RequestLine("DELETE /API/bpm/archivedCaseDocument/{id}")
    @Headers({
            "Accept: application/json",
    })
    void deleteArchivedProcessInstanceDocumentById(@Param("id") String id);

    /**
     * Delete the ArchivedProcessInstanceDocument by ID
     * Similar to <code>deleteArchivedProcessInstanceDocumentById</code> but it also returns the http response headers .
     * Delete the single ArchivedProcessInstanceDocument for the given ID
     * 
     * @param id ID of the ArchivedProcessInstanceDocument to delete (required)
     */
    @RequestLine("DELETE /API/bpm/archivedCaseDocument/{id}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<Void> deleteArchivedProcessInstanceDocumentByIdWithHttpInfo(@Param("id") String id);

    /**
     * Finds ArchivedProcessInstanceDocuments
     * Finds ArchivedProcessInstanceDocuments with pagination params and filters You can filter on : * &#x60;sourceObjectId&#x3D;\&quot;id\&quot;&#x60;: search for
     * documents by specifying the original document id. This is useful if you know the id of a ProcessInstanceDocument and you wish to retrieve all its previous
     * versions.. * &#x60;caseId&#x3D;\&quot;id\&quot;&#x60;: search for documents with the specified open process instance id. *
     * &#x60;archivedCaseId&#x3D;\&quot;id\&quot;&#x60;: search for documents with the specified archived process instance id. *
     * &#x60;submittedBy&#x3D;\&quot;id\&quot;&#x60;: search for documents that were submitted by the user with the specified identifier. *
     * &#x60;name&#x3D;\&quot;string\&quot;&#x60;: search for documents with names that contain _string_. Depending on the setting for [word-based
     * search](https://documentation.bonitasoft.com/bonita/latest/api/using-list-and-search-methods#word_based_search), the search returns documents with _string_
     * at the start of the name or the start of a word in the name. * &#x60;description&#x3D;\&quot;string\&quot;&#x60;: search for documents with descriptions that
     * contain _string_. Depending on the setting for [word-based
     * search](https://documentation.bonitasoft.com/bonita/latest/api/using-list-and-search-methods#word_based_search), the search returns documents with _string_
     * at the start of the description or the start of a word in the description.
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @return List&lt;ArchivedProcessInstanceDocument&gt;
     */
    @RequestLine("GET /API/bpm/archivedCaseDocument?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    List<ArchivedProcessInstanceDocument> searchArchivedProcessInstanceDocuments(@Param("p") Integer p,
            @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o);

    /**
     * Finds ArchivedProcessInstanceDocuments
     * Similar to <code>searchArchivedProcessInstanceDocuments</code> but it also returns the http response headers .
     * Finds ArchivedProcessInstanceDocuments with pagination params and filters You can filter on : * &#x60;sourceObjectId&#x3D;\&quot;id\&quot;&#x60;: search for
     * documents by specifying the original document id. This is useful if you know the id of a ProcessInstanceDocument and you wish to retrieve all its previous
     * versions.. * &#x60;caseId&#x3D;\&quot;id\&quot;&#x60;: search for documents with the specified open process instance id. *
     * &#x60;archivedCaseId&#x3D;\&quot;id\&quot;&#x60;: search for documents with the specified archived process instance id. *
     * &#x60;submittedBy&#x3D;\&quot;id\&quot;&#x60;: search for documents that were submitted by the user with the specified identifier. *
     * &#x60;name&#x3D;\&quot;string\&quot;&#x60;: search for documents with names that contain _string_. Depending on the setting for [word-based
     * search](https://documentation.bonitasoft.com/bonita/latest/api/using-list-and-search-methods#word_based_search), the search returns documents with _string_
     * at the start of the name or the start of a word in the name. * &#x60;description&#x3D;\&quot;string\&quot;&#x60;: search for documents with descriptions that
     * contain _string_. Depending on the setting for [word-based
     * search](https://documentation.bonitasoft.com/bonita/latest/api/using-list-and-search-methods#word_based_search), the search returns documents with _string_
     * at the start of the description or the start of a word in the description.
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/archivedCaseDocument?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ArchivedProcessInstanceDocument>> searchArchivedProcessInstanceDocumentsWithHttpInfo(
            @Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f, @Param("o") String o);

    /**
     * Finds ArchivedProcessInstanceDocuments
     * Finds ArchivedProcessInstanceDocuments with pagination params and filters You can filter on : * &#x60;sourceObjectId&#x3D;\&quot;id\&quot;&#x60;: search for
     * documents by specifying the original document id. This is useful if you know the id of a ProcessInstanceDocument and you wish to retrieve all its previous
     * versions.. * &#x60;caseId&#x3D;\&quot;id\&quot;&#x60;: search for documents with the specified open process instance id. *
     * &#x60;archivedCaseId&#x3D;\&quot;id\&quot;&#x60;: search for documents with the specified archived process instance id. *
     * &#x60;submittedBy&#x3D;\&quot;id\&quot;&#x60;: search for documents that were submitted by the user with the specified identifier. *
     * &#x60;name&#x3D;\&quot;string\&quot;&#x60;: search for documents with names that contain _string_. Depending on the setting for [word-based
     * search](https://documentation.bonitasoft.com/bonita/latest/api/using-list-and-search-methods#word_based_search), the search returns documents with _string_
     * at the start of the name or the start of a word in the name. * &#x60;description&#x3D;\&quot;string\&quot;&#x60;: search for documents with descriptions that
     * contain _string_. Depending on the setting for [word-based
     * search](https://documentation.bonitasoft.com/bonita/latest/api/using-list-and-search-methods#word_based_search), the search returns documents with _string_
     * at the start of the description or the start of a word in the description.
     * Note, this is equivalent to the other <code>searchArchivedProcessInstanceDocuments</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchArchivedProcessInstanceDocumentsQueryParams} class that allows for
     * building up this map in a fluent style.
     * 
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>p - index of the page to display (required)</li>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string.
     *        (optional)</li>
     *        <li>o - can order on attributes (optional)</li>
     *        </ul>
     * @return List&lt;ArchivedProcessInstanceDocument&gt;
     */
    @RequestLine("GET /API/bpm/archivedCaseDocument?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    List<ArchivedProcessInstanceDocument> searchArchivedProcessInstanceDocuments(
            @QueryMap(encoded = true) SearchArchivedProcessInstanceDocumentsQueryParams queryParams);

    /**
     * Finds ArchivedProcessInstanceDocuments
     * Finds ArchivedProcessInstanceDocuments with pagination params and filters You can filter on : * &#x60;sourceObjectId&#x3D;\&quot;id\&quot;&#x60;: search for
     * documents by specifying the original document id. This is useful if you know the id of a ProcessInstanceDocument and you wish to retrieve all its previous
     * versions.. * &#x60;caseId&#x3D;\&quot;id\&quot;&#x60;: search for documents with the specified open process instance id. *
     * &#x60;archivedCaseId&#x3D;\&quot;id\&quot;&#x60;: search for documents with the specified archived process instance id. *
     * &#x60;submittedBy&#x3D;\&quot;id\&quot;&#x60;: search for documents that were submitted by the user with the specified identifier. *
     * &#x60;name&#x3D;\&quot;string\&quot;&#x60;: search for documents with names that contain _string_. Depending on the setting for [word-based
     * search](https://documentation.bonitasoft.com/bonita/latest/api/using-list-and-search-methods#word_based_search), the search returns documents with _string_
     * at the start of the name or the start of a word in the name. * &#x60;description&#x3D;\&quot;string\&quot;&#x60;: search for documents with descriptions that
     * contain _string_. Depending on the setting for [word-based
     * search](https://documentation.bonitasoft.com/bonita/latest/api/using-list-and-search-methods#word_based_search), the search returns documents with _string_
     * at the start of the description or the start of a word in the description.
     * Note, this is equivalent to the other <code>searchArchivedProcessInstanceDocuments</code> that receives the query parameters as a map,
     * but this one also exposes the Http response headers
     * 
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>p - index of the page to display (required)</li>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string.
     *        (optional)</li>
     *        <li>o - can order on attributes (optional)</li>
     *        </ul>
     * @return List&lt;ArchivedProcessInstanceDocument&gt;
     */
    @RequestLine("GET /API/bpm/archivedCaseDocument?p={p}&c={c}&f={f}&o={o}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<ArchivedProcessInstanceDocument>> searchArchivedProcessInstanceDocumentsWithHttpInfo(
            @QueryMap(encoded = true) SearchArchivedProcessInstanceDocumentsQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>searchArchivedProcessInstanceDocuments</code> method in a fluent style.
     */
    public static class SearchArchivedProcessInstanceDocumentsQueryParams extends HashMap<String, Object> {

        public SearchArchivedProcessInstanceDocumentsQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchArchivedProcessInstanceDocumentsQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchArchivedProcessInstanceDocumentsQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }

        public SearchArchivedProcessInstanceDocumentsQueryParams o(final String value) {
            put("o", EncodingUtils.encode(value));
            return this;
        }
    }
}
