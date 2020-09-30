package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.ApplicationPage;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject4;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ApplicationPageApi
 */
public class ApplicationPageApiTest {

    private ApplicationPageApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ApplicationPageApi.class);
    }

    /**
     * Create an application page
     *
     * Create an application page 
     */
    @Test
    public void createApplicationPageTest() {
        InlineObject4 body = null;
        // ApplicationPage response = api.createApplicationPage(body);

        // TODO: test validations
    }
    /**
     * Delete an application page by ID
     *
     * Delete a single application page for the given ID 
     */
    @Test
    public void deleteApplicationPageByIdTest() {
        String id = null;
        // api.deleteApplicationPageById(id);

        // TODO: test validations
    }
    /**
     * Finds application pages
     *
     * Finds application pages with pagination params and filters  - can order on &#x60;id&#x60;, &#x60;token&#x60;, &#x60;applicationId&#x60;, &#x60;pageId&#x60; - can search on &#x60;token&#x60; - can filter on &#x60;id&#x60;, &#x60;token&#x60;, &#x60;applicationId&#x60;, &#x60;pageId&#x60; 
     */
    @Test
    public void findApplicationPagesTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<ApplicationPage> response = api.findApplicationPages(p, c, f, o, s);

        // TODO: test validations
    }
    /**
     * Finds an application page by ID
     *
     * Returns a single application page for the given ID 
     */
    @Test
    public void getApplicationPageByIdTest() {
        String id = null;
        // ApplicationPage response = api.getApplicationPageById(id);

        // TODO: test validations
    }
}
