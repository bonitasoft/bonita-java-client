package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.ArchivedCaseComment;
import org.bonitasoft.web.client.internal.model.Error;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ArchivedCaseCommentApi
 */
public class ArchivedCaseCommentApiTest {

    private ArchivedCaseCommentApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ArchivedCaseCommentApi.class);
    }

    /**
     * Finds ArchivedCaseComments
     *
     * Finds ArchivedCaseComments with pagination params and filters  - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60; 
     */
    @Test
    public void findArchivedCaseCommentsTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<ArchivedCaseComment> response = api.findArchivedCaseComments(p, c, f, o, s);

        // TODO: test validations
    }
}
