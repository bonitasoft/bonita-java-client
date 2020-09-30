package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject48;
import org.bonitasoft.web.client.internal.model.SystemTenant;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for SystemTenantApi
 */
public class SystemTenantApiTest {

    private SystemTenantApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(SystemTenantApi.class);
    }

    /**
     * Get the current Tenant
     *
     * Pause and resume tenant services in order to do maintenance on a tenant. 
     */
    @Test
    public void getSystemTenantTest() {
        // SystemTenant response = api.getSystemTenant();

        // TODO: test validations
    }
    /**
     * Update the current Tenant
     *
     * Pause or resume the current tenant. 
     */
    @Test
    public void updateSystemTenantTest() {
        InlineObject48 inlineObject48 = null;
        // api.updateSystemTenant(inlineObject48);

        // TODO: test validations
    }
}
