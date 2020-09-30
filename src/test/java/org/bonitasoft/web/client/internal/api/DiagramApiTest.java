package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DiagramApi
 */
public class DiagramApiTest {

    private DiagramApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DiagramApi.class);
    }

    /**
     * Finds the diagram process by ID
     *
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Use the diagram resource to access the process diagram xml representation. This is necessary for drawing the diagram. 
     */
    @Test
    public void getProcessDiagramByIdTest() {
        String id = null;
        // Map<String, Object> response = api.getProcessDiagramById(id);

        // TODO: test validations
    }
}
