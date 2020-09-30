package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import java.io.File;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for OrganizationApi
 */
public class OrganizationApiTest {

    private OrganizationApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(OrganizationApi.class);
    }

    /**
     * Import an organization
     *
     * Import an organization 
     */
    @Test
    public void importOrganizationTest() {
        String organizationDataUpload = null;
        String importPolicy = null;
        // api.importOrganization(organizationDataUpload, importPolicy);

        // TODO: test validations
    }
    /**
     * Import an organization
     *
     * Upload organization 
     */
    @Test
    public void uploadOrganizationTest() {
        File file = null;
        // api.uploadOrganization(file);

        // TODO: test validations
    }
}
