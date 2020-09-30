package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.ArchivedActivity;
import org.bonitasoft.web.client.internal.model.Error;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ArchivedActivityApi
 */
public class ArchivedActivityApiTest {

    private ArchivedActivityApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ArchivedActivityApi.class);
    }

    /**
     * Finds Archived Activities
     *
     * Finds Archived  Activities with pagination params and filters. Activities in states completed, cancelled, or aborted are not retrieved. The search returns an array of activities.  Can order on:   - &#x60;name&#x60; : the name of this activity   - &#x60;displayName&#x60; : the display name of this activity   - &#x60;state&#x60; : the current state of the activity   - &#x60;type&#x60; : the activity type   - &#x60;isTerminal&#x60; : say whether or not the activity is in a terminal state   - &#x60;processId&#x60; : the process this activity is associated to   - &#x60;caseId&#x60; : the case initiator this activity is associated to   - &#x60;reached_state_date&#x60; : the date when this activity arrived in this state  Can filter on:   - &#x60;supervisor_id&#x60;: retrieve the information the process manager associated to this id has access to (only in Enterprise editions)   - f: same as the sort order fields 
     */
    @Test
    public void findArchivedActivitiesTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<ArchivedActivity> response = api.findArchivedActivities(p, c, f, o, s);

        // TODO: test validations
    }
    /**
     * Finds the Archived Activity by ID
     *
     * Returns the single Archived Activity for the given ID 
     */
    @Test
    public void getArchivedActivityByIdTest() {
        String id = null;
        // ArchivedActivity response = api.getArchivedActivityById(id);

        // TODO: test validations
    }
}
