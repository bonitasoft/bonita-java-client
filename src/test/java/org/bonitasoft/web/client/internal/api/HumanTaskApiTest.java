package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.HumanTask;
import org.bonitasoft.web.client.internal.model.InlineObject7;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for HumanTaskApi
 */
public class HumanTaskApiTest {

    private HumanTaskApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(HumanTaskApi.class);
    }

    /**
     * Finds HumanTasks
     *
     * Finds HumanTasks with pagination params and filters  - can order on &#x60;name&#x60;, &#x60;priority&#x60;, &#x60;dueDate&#x60;, &#x60;state&#x60;, &#x60;userId&#x60;, &#x60;groupId&#x60;, &#x60;roleId&#x60;, &#x60;processDefinitionId&#x60;, &#x60;processInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60;, &#x60;assigneeId&#x60;, &#x60;parentContainerId&#x60;, &#x60;displayName&#x60;, &#x60;reachedStateDate&#x60; - can search on any field that can be used to order results - can filter on &#x60;assigned_id&#x60;, &#x60;state&#x60;, &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;processDefinitionId&#x60;, &#x60;parentContainerId&#x60; 
     */
    @Test
    public void findHumanTasksTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<HumanTask> response = api.findHumanTasks(p, c, f, o, s);

        // TODO: test validations
    }
    /**
     * Finds the HumanTask by ID
     *
     * Returns the single HumanTask for the given ID 
     */
    @Test
    public void getHumanTaskByIdTest() {
        String id = null;
        // HumanTask response = api.getHumanTaskById(id);

        // TODO: test validations
    }
    /**
     * Update the HumanTask by ID
     *
     * Update the HumanTask for the given ID 
     */
    @Test
    public void updateHumanTaskByIdTest() {
        String id = null;
        InlineObject7 inlineObject7 = null;
        // api.updateHumanTaskById(id, inlineObject7);

        // TODO: test validations
    }
}
