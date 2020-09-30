package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject20;
import org.bonitasoft.web.client.internal.model.ProcessParameter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ProcessParameterApi
 */
public class ProcessParameterApiTest {

    private ProcessParameterApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ProcessParameterApi.class);
    }

    /**
     * Finds ProcessParameters
     *
     * Finds ProcessParameters with pagination params and filters. 
     */
    @Test
    public void findProcessParametersTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<ProcessParameter> response = api.findProcessParameters(p, c, f, o, s);

        // TODO: test validations
    }
    /**
     * Finds the ProcessParameter by ID
     *
     * Returns the single ProcessParameter for the given ID 
     */
    @Test
    public void getProcessParameterByIdTest() {
        String id = null;
        String name = null;
        // ProcessParameter response = api.getProcessParameterById(id, name);

        // TODO: test validations
    }
    /**
     * Update the ProcessParameter by ID
     *
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Update the ProcessParameter for the given ID 
     */
    @Test
    public void updateProcessParameterByIdTest() {
        String id = null;
        String name = null;
        InlineObject20 inlineObject20 = null;
        // api.updateProcessParameterById(id, name, inlineObject20);

        // TODO: test validations
    }
}
