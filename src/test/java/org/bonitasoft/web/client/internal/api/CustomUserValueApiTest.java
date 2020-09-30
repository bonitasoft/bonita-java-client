package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.CustomUserValue;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject24;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CustomUserValueApi
 */
public class CustomUserValueApiTest {

    private CustomUserValueApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(CustomUserValueApi.class);
    }

    /**
     * Finds CustomUserValues
     *
     * Finds CustomUserValues with pagination params and filters  You can filter on &#x60;userId&#x60;, &#x60;value&#x60;, &#x60;definitionId&#x60; 
     */
    @Test
    public void findCustomUserValuesTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        // List<CustomUserValue> response = api.findCustomUserValues(p, c, f);

        // TODO: test validations
    }
    /**
     * Update the CustomUserValue by ID
     *
     * Update the CustomUserValue for the given ID 
     */
    @Test
    public void updateCustomUserValueByIdTest() {
        String userId = null;
        String definitionId = null;
        InlineObject24 inlineObject24 = null;
        // api.updateCustomUserValueById(userId, definitionId, inlineObject24);

        // TODO: test validations
    }
}
