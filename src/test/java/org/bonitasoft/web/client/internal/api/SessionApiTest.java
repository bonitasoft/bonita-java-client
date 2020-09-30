package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.Session;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for SessionApi
 */
public class SessionApiTest {

    private SessionApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(SessionApi.class);
    }

    /**
     * Get the current user session
     *
     * Returns session information for the current user 
     */
    @Test
    public void getSessionTest() {
        // Session response = api.getSession();

        // TODO: test validations
    }
}
