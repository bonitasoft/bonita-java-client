package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject22;
import org.bonitasoft.web.client.internal.model.InlineResponse2001;
import org.bonitasoft.web.client.internal.model.TimerEventTrigger;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for TimerEventTriggerApi
 */
public class TimerEventTriggerApiTest {

    private TimerEventTriggerApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(TimerEventTriggerApi.class);
    }

    /**
     * Finds TimerEventTriggers
     *
     * Finds TimerEventTriggers with pagination params and filters  - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60; 
     */
    @Test
    public void findTimerEventTriggersTest() {
        Integer p = null;
        Integer c = null;
        String caseId = null;
        String f = null;
        String o = null;
        String s = null;
        // List<TimerEventTrigger> response = api.findTimerEventTriggers(p, c, caseId, f, o, s);

        // TODO: test validations
    }
    /**
     * Finds the TimerEventTrigger by ID
     *
     * Returns the single TimerEventTrigger for the given ID 
     */
    @Test
    public void getTimerEventTriggerByIdTest() {
        String id = null;
        // TimerEventTrigger response = api.getTimerEventTriggerById(id);

        // TODO: test validations
    }
    /**
     * Update the TimerEventTrigger by ID
     *
     * Update the TimerEventTrigger for the given ID 
     */
    @Test
    public void updateTimerEventTriggerByIdTest() {
        String id = null;
        InlineObject22 inlineObject22 = null;
        // InlineResponse2001 response = api.updateTimerEventTriggerById(id, inlineObject22);

        // TODO: test validations
    }
}
