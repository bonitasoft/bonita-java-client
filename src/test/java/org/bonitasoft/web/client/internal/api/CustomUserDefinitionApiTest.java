package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.CustomUserDefinition;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject23;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CustomUserDefinitionApi
 */
public class CustomUserDefinitionApiTest {

    private CustomUserDefinitionApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(CustomUserDefinitionApi.class);
    }

    /**
     * Create the CustomUserDefinition
     *
     * Create the CustomUserDefinition 
     */
    @Test
    public void createCustomUserDefinitionTest() {
        InlineObject23 body = null;
        // CustomUserDefinition response = api.createCustomUserDefinition(body);

        // TODO: test validations
    }
    /**
     * Delete the CustomUserDefinition by ID
     *
     * Delete the single CustomUserDefinition for the given ID 
     */
    @Test
    public void deleteCustomUserDefinitionByIdTest() {
        String id = null;
        // api.deleteCustomUserDefinitionById(id);

        // TODO: test validations
    }
    /**
     * Finds CustomUserDefinitions
     *
     * Finds CustomUserDefinitions. There are no filters, and no search terms. All the definitions are returned. 
     */
    @Test
    public void findCustomUserDefinitionsTest() {
        Integer p = null;
        Integer c = null;
        // List<CustomUserDefinition> response = api.findCustomUserDefinitions(p, c);

        // TODO: test validations
    }
    /**
     * Finds the CustomUserDefinition by ID
     *
     * Returns the single CustomUserDefinition for the given ID 
     */
    @Test
    public void getCustomUserDefinitionByIdTest() {
        String id = null;
        // CustomUserDefinition response = api.getCustomUserDefinitionById(id);

        // TODO: test validations
    }
}
