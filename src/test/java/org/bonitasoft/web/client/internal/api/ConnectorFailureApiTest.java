package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.ConnectorFailure;
import org.bonitasoft.web.client.internal.model.Error;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ConnectorFailureApi
 */
public class ConnectorFailureApiTest {

    private ConnectorFailureApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ConnectorFailureApi.class);
    }

    /**
     * Finds the ConnectorFailure by ID
     *
     * Returns the single ConnectorFailure for the given ID 
     */
    @Test
    public void getConnectorFailureByIdTest() {
        String id = null;
        // ConnectorFailure response = api.getConnectorFailureById(id);

        // TODO: test validations
    }
}
