package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Activity;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject6;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ActivityApi
 */
public class ActivityApiTest {

    private ActivityApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ActivityApi.class);
    }

    /**
     * Finds Activities
     *
     * Finds Activities with pagination params and filters. Activities in states completed, cancelled, or aborted are not retrieved. The search returns an array of activities.  - can order on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;processDefinitionId&#x60;, &#x60;parentProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60; (order by parent activity id), &#x60;rootProcessInstanceId&#x60;, &#x60;lastUpdateDate&#x60; - can search on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;processDefinitionId&#x60;, &#x60;parentProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60; (order by parent activity id), &#x60;rootProcessInstanceId&#x60;, &#x60;lastUpdateDate&#x60; - can filter on &#x60;name&#x60;, &#x60;state&#x60;, &#x60;processId&#x60;, &#x60;parentCaseId&#x60;, &#x60;rootCaseId&#x60;, &#x60;last_update_date&#x60;, &#x60;supervisor_id&#x60; (only in Enterprise editions) 
     */
    @Test
    public void findActivitiesTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<Activity> response = api.findActivities(p, c, f, o, s);

        // TODO: test validations
    }
    /**
     * Finds the Activity by ID
     *
     * Returns the single Activity for the given ID 
     */
    @Test
    public void getActivityByIdTest() {
        String id = null;
        // Activity response = api.getActivityById(id);

        // TODO: test validations
    }
    /**
     * Update the Activity by ID
     *
     * Update the Activity for the given ID 
     */
    @Test
    public void updateActivityByIdTest() {
        String id = null;
        InlineObject6 inlineObject6 = null;
        // api.updateActivityById(id, inlineObject6);

        // TODO: test validations
    }
}
