package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject8;
import org.bonitasoft.web.client.internal.model.InlineObject9;
import org.bonitasoft.web.client.internal.model.ManualTask;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ManualTaskApi
 */
public class ManualTaskApiTest {

    private ManualTaskApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ManualTaskApi.class);
    }

    /**
     * Create the ManualTask
     *
     * Create the ManualTask. Use a POST method to create a new subtask. A subtask is attached to a parent task and it needs to be immediately assigned to a user. 
     */
    @Test
    public void createManualTaskTest() {
        InlineObject8 body = null;
        // ManualTask response = api.createManualTask(body);

        // TODO: test validations
    }
    /**
     * Finds ManualTasks
     *
     * Finds ManualTasks with pagination params and filters  You can filter on:  * &#x60;assigned_id&#x3D;{user_id}&#x60;: retrieve only the manual tasks assigned to the specified user. For example, retrieve the manual tasks assigned to user with id 1: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;assigned_id%3d1&#x60;. * &#x60;state&#x3D;skipped | ready | completed | failed&#x60; : retrieve only the manual tasks with the specified state. For example, retrieve the ready tasks: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;state%3dready&#x60;. * &#x60;caseId&#x3D;{case_id}&#x60;: retrieve only the manual tasks created in the specified case. For example, retrieve the manual tasks for the case\\_id 2: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;caseId%3d2&#x60;. * &#x60;parentTaskId&#x3D;{parentTask_id}&#x60;: retrieve only the manual tasks for a specific parentTask. For example, retrieve the manual tasks for the parentTask\\_id 40001: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;parentTaskId%3d40001&#x60;.  You can search on:  * name: search all manual tasks with a name that starts with the search string. For example, search for all manual tasks that have a name that starts with MySubTask: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;s&#x3D;MySubTask&#x60;. 
     */
    @Test
    public void findManualTasksTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<ManualTask> response = api.findManualTasks(p, c, f, o, s);

        // TODO: test validations
    }
    /**
     * Finds the ManualTask by ID
     *
     * Returns the single ManualTask for the given ID 
     */
    @Test
    public void getManualTaskByIdTest() {
        String id = null;
        // ManualTask response = api.getManualTaskById(id);

        // TODO: test validations
    }
    /**
     * Update the ManualTask by ID
     *
     * Update the ManualTask for the given ID. Use a PUT method to execute a subtask. Executing a subtask basically means changing its state to completed and providing an executedBy value. 
     */
    @Test
    public void updateManualTaskByIdTest() {
        String id = null;
        InlineObject9 inlineObject9 = null;
        // api.updateManualTaskById(id, inlineObject9);

        // TODO: test validations
    }
}
