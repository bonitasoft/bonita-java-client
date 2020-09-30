package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.CaseDocument;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject13;
import org.bonitasoft.web.client.internal.model.InlineObject14;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CaseDocumentApi
 */
public class CaseDocumentApiTest {

    private CaseDocumentApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(CaseDocumentApi.class);
    }

    /**
     * Create the CaseDocument
     *
     * Create the CaseDocument.  Use a POST method to add a document to a case. You can upload a document from the local file system or by URL. Specify the case id and the document name in the payload. The document description is optional: if you do not specify a description, the description in the response is empty. The response contains a version, which is managed automatically. You cannot currently retrieve a specific version of a document, only the most recent version. To retrieve earlier versions of a caseDocument, use the archivedCaseDocument resource. 
     */
    @Test
    public void createCaseDocumentTest() {
        InlineObject13 body = null;
        // CaseDocument response = api.createCaseDocument(body);

        // TODO: test validations
    }
    /**
     * Delete the CaseDocument by ID
     *
     * Delete the single CaseDocument for the given ID 
     */
    @Test
    public void deleteCaseDocumentByIdTest() {
        String id = null;
        // api.deleteCaseDocumentById(id);

        // TODO: test validations
    }
    /**
     * Finds CaseDocuments
     *
     * Finds CaseDocuments with pagination params and filters  It is possible to filter on three parameters: &#x60;submittedBy&#x60;, &#x60;name&#x60; and &#x60;description&#x60;.   * &#x60;submittedBy&#x3D;\&quot;id\&quot;&#x60;: search for documents that were submitted by the user with the specified identifier.  * &#x60;name&#x3D;\&quot;string\&quot;&#x60;: search for documents with names that contain _string_.    Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the name or the start of a word in the name.  * &#x60;description&#x3D;\&quot;string\&quot;&#x60;: search for documents with descriptions that contain _string_.    Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the description or the start of a word in the description. 
     */
    @Test
    public void findCaseDocumentsTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        // List<CaseDocument> response = api.findCaseDocuments(p, c, f, o);

        // TODO: test validations
    }
    /**
     * Finds the CaseDocument by ID
     *
     * Returns the single CaseDocument for the given ID. Use a GET method to get a document from a case. First you get the document information, then you download the content. To get the document information, specify the document id in the URL. The document id is created when you upload a document to a case. There is no payload. 
     */
    @Test
    public void getCaseDocumentByIdTest() {
        String id = null;
        // CaseDocument response = api.getCaseDocumentById(id);

        // TODO: test validations
    }
    /**
     * Update the CaseDocument by ID
     *
     * Update the CaseDocument for the given ID  You update a document in a case by uploading a new version of the document using a PUT method. You can upload a document version from the local file system or by URL. The document name will be used in all the cases of the process, but the combination of case id and document name is unique. In the URL, you specify to supply the document id. This is included in the response when you first add a document to a case. The response to PUT methods is the same as for POST methods. 
     */
    @Test
    public void updateCaseDocumentByIdTest() {
        String id = null;
        InlineObject14 inlineObject14 = null;
        // api.updateCaseDocumentById(id, inlineObject14);

        // TODO: test validations
    }
}
