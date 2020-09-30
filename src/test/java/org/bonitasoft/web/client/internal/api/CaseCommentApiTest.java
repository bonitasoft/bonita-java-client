package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.CaseComment;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject17;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CaseCommentApi
 */
public class CaseCommentApiTest {

    private CaseCommentApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(CaseCommentApi.class);
    }

    /**
     * Create the CaseComment
     *
     * Create the CaseComment 
     */
    @Test
    public void createCaseCommentTest() {
        InlineObject17 body = null;
        // CaseComment response = api.createCaseComment(body);

        // TODO: test validations
    }
    /**
     * Finds CaseComments
     *
     * Finds CaseComments with pagination params and filters  - can order on &#x60;postDate&#x60; - can filter on &#x60;supervisor_id&#x60;,&#x60;user_id&#x60;,&#x60;processInstanceId&#x60; - You cannot use supervisor_id and user_id filter at the same time 
     */
    @Test
    public void findCaseCommentsTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        // List<CaseComment> response = api.findCaseComments(p, c, f, o);

        // TODO: test validations
    }
}
