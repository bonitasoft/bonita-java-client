package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.ArchivedCaseDocument;
import org.bonitasoft.web.client.internal.model.Error;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ArchivedCaseDocumentApi
 */
public class ArchivedCaseDocumentApiTest {

    private ArchivedCaseDocumentApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ArchivedCaseDocumentApi.class);
    }

    /**
     * Delete the ArchivedCaseDocument by ID
     *
     * Delete the single ArchivedCaseDocument for the given ID 
     */
    @Test
    public void deleteArchivedCaseDocumentByIdTest() {
        String id = null;
        // api.deleteArchivedCaseDocumentById(id);

        // TODO: test validations
    }
    /**
     * Finds ArchivedCaseDocuments
     *
     * Finds ArchivedCaseDocuments with pagination params and filters  You can filter on :  * &#x60;sourceObjectId&#x3D;\&quot;id\&quot;&#x60;: search for documents by specifying the original document id.   This is useful if you know the id of a caseDocument and you wish to retrieve all its previous versions.. * &#x60;caseId&#x3D;\&quot;id\&quot;&#x60;: search for documents with the specified open case id. * &#x60;archivedCaseId&#x3D;\&quot;id\&quot;&#x60;: search for documents with the specified archvied case id. * &#x60;submittedBy&#x3D;\&quot;id\&quot;&#x60;: search for documents that were submitted by the user with the specified identifier. * &#x60;name&#x3D;\&quot;string\&quot;&#x60;: search for documents with names that contain _string_.   Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the name or the start of a word in the name. * &#x60;description&#x3D;\&quot;string\&quot;&#x60;: search for documents with descriptions that contain _string_.   Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the description or the start of a word in the description. 
     */
    @Test
    public void findArchivedCaseDocumentsTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        // List<ArchivedCaseDocument> response = api.findArchivedCaseDocuments(p, c, f, o);

        // TODO: test validations
    }
}
