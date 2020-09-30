package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.ProcessConnectorDependency;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ProcessConnectorDependencyApi
 */
public class ProcessConnectorDependencyApiTest {

    private ProcessConnectorDependencyApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ProcessConnectorDependencyApi.class);
    }

    /**
     * Finds ProcessConnectorDependencys
     *
     * Finds ProcessConnectorDependencys with pagination params and filters  **Mandatory filters: &#x60;connector_process_id&#x60;, &#x60;connector_name&#x60;, &#x60;connector_version&#x60;** 
     */
    @Test
    public void findProcessConnectorDependencysTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<ProcessConnectorDependency> response = api.findProcessConnectorDependencys(p, c, f, o, s);

        // TODO: test validations
    }
}
