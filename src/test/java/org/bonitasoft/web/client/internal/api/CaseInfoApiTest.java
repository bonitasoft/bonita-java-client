package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.CaseInfo;
import org.bonitasoft.web.client.internal.model.Error;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CaseInfoApi
 */
public class CaseInfoApiTest {

    private CaseInfoApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(CaseInfoApi.class);
    }

    /**
     * Finds the CaseInfo by ID
     *
     * Returns the single CaseInfo for the given ID 
     */
    @Test
    public void getCaseInfoByIdTest() {
        String id = null;
        // CaseInfo response = api.getCaseInfoById(id);

        // TODO: test validations
    }
}
