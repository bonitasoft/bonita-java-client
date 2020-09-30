package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.CaseVariable;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject12;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CaseVariableApi
 */
public class CaseVariableApiTest {

    private CaseVariableApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(CaseVariableApi.class);
    }

    /**
     * Finds Case Variables
     *
     * Finds Case Variables with pagination params and filters 
     */
    @Test
    public void findCaseVariablesTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        // List<CaseVariable> response = api.findCaseVariables(p, c, f, o);

        // TODO: test validations
    }
    /**
     * Finds the Variable by Case ID
     *
     * Returns the single Variable for the given Case ID 
     */
    @Test
    public void getVariableByCaseIdTest() {
        String id = null;
        oas_any_type_not_mapped variableName = null;
        // CaseVariable response = api.getVariableByCaseId(id, variableName);

        // TODO: test validations
    }
    /**
     * Update a Variable by Case ID
     *
     * Update the variable for the given Case ID.  **Warning** : only following types are supported for javaTypeclassname: &#x60;java.lang.String&#x60;, &#x60;java.lang.Integer&#x60;, &#x60;java.lang.Double&#x60;, &#x60;java.lang.Long&#x60;, &#x60;java.lang.Boolean&#x60;, &#x60;java.util.Date&#x60; 
     */
    @Test
    public void updateVariableByCaseIdTest() {
        String id = null;
        oas_any_type_not_mapped variableName = null;
        InlineObject12 inlineObject12 = null;
        // api.updateVariableByCaseId(id, variableName, inlineObject12);

        // TODO: test validations
    }
}
