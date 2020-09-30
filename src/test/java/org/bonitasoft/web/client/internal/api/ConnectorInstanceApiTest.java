package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.ConnectorInstance;
import org.bonitasoft.web.client.internal.model.Error;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ConnectorInstanceApi
 */
public class ConnectorInstanceApiTest {

    private ConnectorInstanceApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ConnectorInstanceApi.class);
    }

    /**
     * Finds ConnectorInstances
     *
     * Finds ConnectorInstances with pagination params and filters. Retrieve a list of connector instances attached to a process or a flow node. 
     */
    @Test
    public void findConnectorInstancesTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<ConnectorInstance> response = api.findConnectorInstances(p, c, f, o, s);

        // TODO: test validations
    }
}
