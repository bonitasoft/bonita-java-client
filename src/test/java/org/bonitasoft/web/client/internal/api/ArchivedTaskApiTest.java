package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.ArchivedTask;
import org.bonitasoft.web.client.internal.model.Error;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ArchivedTaskApi
 */
public class ArchivedTaskApiTest {

    private ArchivedTaskApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ArchivedTaskApi.class);
    }

    /**
     * Finds ArchivedTasks
     *
     * Finds ArchivedTasks with pagination params and filters  - Can order on &#x60;caseId&#x60;, &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;processId&#x60;, &#x60;state&#x60;, &#x60;type&#x60;, &#x60;archivedDate&#x60;, &#x60;reached_state_date&#x60;, &#x60;assigned_id&#x60; - Can filter on &#x60;caseId&#x60;, &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;processId&#x60;, &#x60;state&#x60;, &#x60;type&#x60;, &#x60;archivedDate&#x60;, &#x60;reached_state_date&#x60;, &#x60;assigned_id&#x60;, &#x60;isTerminal&#x60; 
     */
    @Test
    public void findArchivedTasksTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        // List<ArchivedTask> response = api.findArchivedTasks(p, c, f, o);

        // TODO: test validations
    }
    /**
     * Finds the ArchivedTask by ID
     *
     * Returns the single ArchivedTask for the given ID 
     */
    @Test
    public void getArchivedTaskByIdTest() {
        String id = null;
        // ArchivedTask response = api.getArchivedTaskById(id);

        // TODO: test validations
    }
}
