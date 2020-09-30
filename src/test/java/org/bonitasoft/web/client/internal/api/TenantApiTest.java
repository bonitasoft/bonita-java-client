package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject35;
import org.bonitasoft.web.client.internal.model.InlineObject36;
import org.bonitasoft.web.client.internal.model.Tenant;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for TenantApi
 */
public class TenantApiTest {

    private TenantApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(TenantApi.class);
    }

    /**
     * Create the Tenant
     *
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Create the Tenant 
     */
    @Test
    public void createTenantTest() {
        InlineObject35 body = null;
        // Tenant response = api.createTenant(body);

        // TODO: test validations
    }
    /**
     * Delete the Tenant by ID
     *
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Delete the single Tenant for the given ID 
     */
    @Test
    public void deleteTenantByIdTest() {
        String id = null;
        // api.deleteTenantById(id);

        // TODO: test validations
    }
    /**
     * Finds Tenants
     *
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Finds Tenants with pagination params and filters  - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60; 
     */
    @Test
    public void findTenantsTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<Tenant> response = api.findTenants(p, c, f, o, s);

        // TODO: test validations
    }
    /**
     * Finds the Tenant by ID
     *
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Returns the single Tenant for the given ID 
     */
    @Test
    public void getTenantByIdTest() {
        String id = null;
        // Tenant response = api.getTenantById(id);

        // TODO: test validations
    }
    /**
     * Update the Tenant by ID
     *
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Update the Tenant for the given ID 
     */
    @Test
    public void updateTenantByIdTest() {
        String id = null;
        InlineObject36 inlineObject36 = null;
        // api.updateTenantById(id, inlineObject36);

        // TODO: test validations
    }
}
