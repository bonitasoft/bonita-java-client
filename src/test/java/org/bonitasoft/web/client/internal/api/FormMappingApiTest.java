package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.FormMapping;
import org.bonitasoft.web.client.internal.model.InlineObject25;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for FormMappingApi
 */
public class FormMappingApiTest {

    private FormMappingApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(FormMappingApi.class);
    }

    /**
     * Finds FormMappings
     *
     * Finds FormMappings with pagination params and filters  - can filter on &#x60;processDefinitionId&#x60;,&#x60;type&#x60; 
     */
    @Test
    public void findFormMappingsTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<FormMapping> response = api.findFormMappings(p, c, f, o, s);

        // TODO: test validations
    }
    /**
     * Update the FormMapping by ID
     *
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Update the FormMapping for the given ID 
     */
    @Test
    public void updateFormMappingByIdTest() {
        String id = null;
        InlineObject25 inlineObject25 = null;
        // api.updateFormMappingById(id, inlineObject25);

        // TODO: test validations
    }
}
