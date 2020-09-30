package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Application;
import org.bonitasoft.web.client.internal.model.CreateApplicationRequest;
import org.bonitasoft.web.client.internal.model.Error;
import java.io.File;
import org.bonitasoft.web.client.internal.model.InlineObject;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ApplicationApi
 */
public class ApplicationApiTest {

    private ApplicationApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ApplicationApi.class);
    }

    /**
     * Create a living applications
     *
     * Create a living applications 
     */
    @Test
    public void createApplicationTest() {
        CreateApplicationRequest body = null;
        // Application response = api.createApplication(body);

        // TODO: test validations
    }
    /**
     * Delete a living application by ID
     *
     * Delete a single application for the given ID 
     */
    @Test
    public void deleteApplicationByIdTest() {
        String id = null;
        // api.deleteApplicationById(id);

        // TODO: test validations
    }
    /**
     * Finds living applications
     *
     * Finds living applications with pagination params and filters  - can order on &#x60;id&#x60;,&#x60;creationDate&#x60;, &#x60;createdBy&#x60;, &#x60;profileId&#x60;, &#x60;token&#x60;, &#x60;displayName&#x60;, &#x60;updatedBy&#x60;, &#x60;lastUpdateDate&#x60;, &#x60;version&#x60; - can search on &#x60;token&#x60;, &#x60;displayName&#x60;, &#x60;version&#x60; - can filter on &#x60;token&#x60;, &#x60;displayName&#x60;, &#x60;version&#x60;, &#x60;profileId&#x60;, &#x60;creationDate&#x60;, &#x60;createdBy&#x60;, &#x60;updatedBy&#x60; , &#x60;lastUpdateDate&#x60; 
     */
    @Test
    public void findApplicationsTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<Application> response = api.findApplications(p, c, f, o, s);

        // TODO: test validations
    }
    /**
     * Finds a living application by ID
     *
     * Returns a single application for the given ID 
     */
    @Test
    public void getApplicationByIdTest() {
        String id = null;
        // Application response = api.getApplicationById(id);

        // TODO: test validations
    }
    /**
     * Import a living application
     *
     * Import a single application 
     */
    @Test
    public void importApplicationTest() {
        String applicationsDataUpload = null;
        String importPolicy = null;
        // api.importApplication(applicationsDataUpload, importPolicy);

        // TODO: test validations
    }
    /**
     * Update a living application by ID
     *
     * Update a single application for the given ID 
     */
    @Test
    public void updateApplicationByIdTest() {
        String id = null;
        InlineObject inlineObject = null;
        // Application response = api.updateApplicationById(id, inlineObject);

        // TODO: test validations
    }
    /**
     * Upload a living application
     *
     * Upload application 
     */
    @Test
    public void uploadApplicationTest() {
        File file = null;
        // api.uploadApplication(file);

        // TODO: test validations
    }
}
