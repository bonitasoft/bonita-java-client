package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.AnyValue;
import org.bonitasoft.web.client.internal.model.Contract;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject10;
import org.bonitasoft.web.client.internal.model.InlineObject11;
import org.bonitasoft.web.client.internal.model.UserTask;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for UserTaskApi
 */
public class UserTaskApiTest {

    private UserTaskApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(UserTaskApi.class);
    }

    /**
     * Create the UserTask
     *
     * Create the UserTask 
     */
    @Test
    public void createUserTaskTest() {
        InlineObject10 body = null;
        // UserTask response = api.createUserTask(body);

        // TODO: test validations
    }
    /**
     * Execute the UserTask
     *
     * Execute the UserTask. In order to execute a task, the task contract values have to be provided. 
     */
    @Test
    public void executeUserTaskTest() {
        String id = null;
        Map<String, Object> body = null;
        Boolean assign = null;
        // api.executeUserTask(id, body, assign);

        // TODO: test validations
    }
    /**
     * Finds UserTasks
     *
     * Finds UserTasks with pagination params and filters  - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60; 
     */
    @Test
    public void findUserTasksTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<UserTask> response = api.findUserTasks(p, c, f, o, s);

        // TODO: test validations
    }
    /**
     * Finds the Context by UserTask ID
     *
     * Returns the Context for the given UserTask ID 
     */
    @Test
    public void getContextByUserTaskIdTest() {
        String id = null;
        // AnyValue response = api.getContextByUserTaskId(id);

        // TODO: test validations
    }
    /**
     * Finds the Contract by UserTask ID
     *
     * Returns the Contract for the given UserTask ID 
     */
    @Test
    public void getContractByUserTaskIdTest() {
        String id = null;
        // Contract response = api.getContractByUserTaskId(id);

        // TODO: test validations
    }
    /**
     * Finds the UserTask by ID
     *
     * Returns the single UserTask for the given ID 
     */
    @Test
    public void getUserTaskByIdTest() {
        String id = null;
        // UserTask response = api.getUserTaskById(id);

        // TODO: test validations
    }
    /**
     * Update the UserTask by ID
     *
     * Update the UserTask for the given ID.  Fields that can be updated are assignedId and state. The only value that can be set for the state is \&quot;skipped\&quot;. You only need to specify the fields that are to be updated. 
     */
    @Test
    public void updateUserTaskByIdTest() {
        String id = null;
        InlineObject11 inlineObject11 = null;
        // api.updateUserTaskById(id, inlineObject11);

        // TODO: test validations
    }
}
