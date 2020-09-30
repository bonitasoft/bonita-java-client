package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.ActivityVariable;
import org.bonitasoft.web.client.internal.model.Error;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ActivityVariableApi
 */
public class ActivityVariableApiTest {

    private ActivityVariableApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ActivityVariableApi.class);
    }

    /**
     * Finds the ActivityVariable by ID
     *
     * Returns the single ActivityVariable for the given ID 
     */
    @Test
    public void getActivityVariableByIdTest() {
        String id = null;
        oas_any_type_not_mapped variableName = null;
        // ActivityVariable response = api.getActivityVariableById(id, variableName);

        // TODO: test validations
    }
}
