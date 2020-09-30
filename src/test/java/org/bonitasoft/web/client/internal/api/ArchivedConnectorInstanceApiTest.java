package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.ArchivedConnectorInstance;
import org.bonitasoft.web.client.internal.model.Error;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ArchivedConnectorInstanceApi
 */
public class ArchivedConnectorInstanceApiTest {

    private ArchivedConnectorInstanceApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ArchivedConnectorInstanceApi.class);
    }

    /**
     * Finds ArchivedConnectorInstances
     *
     * Finds ArchivedConnectorInstances with pagination params and filters 
     */
    @Test
    public void findArchivedConnectorInstancesTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<ArchivedConnectorInstance> response = api.findArchivedConnectorInstances(p, c, f, o, s);

        // TODO: test validations
    }
}
