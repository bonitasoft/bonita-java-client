package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.License;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for LicenseApi
 */
public class LicenseApiTest {

    private LicenseApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(LicenseApi.class);
    }

    /**
     * Get the platform License
     *
     * Returns the current platform License. This requires a platform session. Log in using the platform login service. 
     */
    @Test
    public void getLicenseTest() {
        // License response = api.getLicense();

        // TODO: test validations
    }
}
