package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.Task;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for TaskApi
 */
public class TaskApiTest {

    private TaskApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(TaskApi.class);
    }

    /**
     * Finds Tasks
     *
     * Finds Tasks with pagination params and filters  - can order on &#x60;caseId&#x60;, &#x60;processId&#x60;, &#x60;state&#x60;, &#x60;type&#x60;, &#x60;supervisor_id&#x60;, &#x60;last_update_date&#x60; - can filter on &#x60;caseId&#x60;, &#x60;processId&#x60;, &#x60;state&#x60;, &#x60;type&#x60;, &#x60;supervisor_id&#x60;, &#x60;last_update_date&#x60; 
     */
    @Test
    public void findTasksTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        // List<Task> response = api.findTasks(p, c, f, o);

        // TODO: test validations
    }
    /**
     * Finds the Task by ID
     *
     * Returns the single Task for the given ID 
     */
    @Test
    public void getTaskByIdTest() {
        String id = null;
        // Task response = api.getTaskById(id);

        // TODO: test validations
    }
    /**
     * Update the Task by ID
     *
     * Update the Task for the given ID 
     */
    @Test
    public void updateTaskByIdTest() {
        String id = null;
        Map<String, Object> requestBody = null;
        // api.updateTaskById(id, requestBody);

        // TODO: test validations
    }
}
