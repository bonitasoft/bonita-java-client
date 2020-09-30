package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import java.io.File;
import org.bonitasoft.web.client.internal.model.InlineObject39;
import org.bonitasoft.web.client.internal.model.InlineObject40;
import org.bonitasoft.web.client.internal.model.InlineResponse2002;
import org.bonitasoft.web.client.internal.model.Page;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PageApi
 */
public class PageApiTest {

    private PageApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(PageApi.class);
    }

    /**
     * Create the Page
     *
     * Upload the page content using the &#x60;portal/pageUpload&#x60; . This returns a temporary file name that can be used as input for this operation. 
     */
    @Test
    public void createPageTest() {
        InlineObject39 body = null;
        // Page response = api.createPage(body);

        // TODO: test validations
    }
    /**
     * Delete the Page by ID
     *
     * Delete the single Page for the given ID 
     */
    @Test
    public void deletePageByIdTest() {
        String id = null;
        // api.deletePageById(id);

        // TODO: test validations
    }
    /**
     * Finds Pages
     *
     * Finds Pages with pagination params and filters  - can search on &#x60;displayName&#x60;,&#x60;description&#x60; - can filter on &#x60;createdBy&#x60;,&#x60;contentType&#x60; 
     */
    @Test
    public void findPagesTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<Page> response = api.findPages(p, c, f, o, s);

        // TODO: test validations
    }
    /**
     * Finds the Page by ID
     *
     * Returns the single Page for the given ID 
     */
    @Test
    public void getPageByIdTest() {
        String id = null;
        // Page response = api.getPageById(id);

        // TODO: test validations
    }
    /**
     * Update the Page by ID
     *
     * Use the PUT method to update an existing custom page. To update a custom page, upload the new page content using the pageUpload servlet, which returns a temporary file name, and then call this API with the temporary file name. 
     */
    @Test
    public void updatePageByIdTest() {
        String id = null;
        InlineObject40 inlineObject40 = null;
        // api.updatePageById(id, inlineObject40);

        // TODO: test validations
    }
    /**
     * Upload a Page
     *
     * Upload Page 
     */
    @Test
    public void uploadPageTest() {
        File file = null;
        // InlineResponse2002 response = api.uploadPage(file);

        // TODO: test validations
    }
}
