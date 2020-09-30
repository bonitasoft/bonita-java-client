package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.ArchivedUserTask;
import org.bonitasoft.web.client.internal.model.Error;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ArchivedUserTaskApi
 */
public class ArchivedUserTaskApiTest {

    private ArchivedUserTaskApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ArchivedUserTaskApi.class);
    }

    /**
     * Finds ArchivedUserTasks
     *
     * Finds ArchivedUserTasks with pagination params and filters. An ArchivedUserTask is an executable task that has been performed by a user or skipped and is archived.  You can filter on:  * &#x60;assigned_id&#x3D;{user_id}&#x60;: retrieve only the user tasks assigned to the specified ID. For example, retrieve the user tasks assigned to user with id 2: &#x60;/API/bpm/archivedUserTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;assigned_id%3d2&#x60; * &#x60;state&#x3D;&#x60;: retrieve only the archived user tasks with the specified state. For example, retrieve the skipped tasks: &#x60;/API/bpm/archivedUserTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;state&#x3D;skipped&#x60; * &#x60;name&#x3D;&#x60;: retrieve only the user tasks with the specified name. For example, retrieve the user tasks with the name \&quot;Analyse Case\&quot;: &#x60;/API/bpm/archivedUserTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;name&#x3D;Analyse Case&#x60; * &#x60;displayName&#x3D;&#x60;: retrieve only the archived user tasks with the specified displayName. For example, retrieve the user tasks with the displayName \&quot;Analyse Case\&quot;: &#x60;/API/bpm/archivedUserTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;displayName&#x3D;Analyse Case&#x60; 
     */
    @Test
    public void findArchivedUserTasksTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        // List<ArchivedUserTask> response = api.findArchivedUserTasks(p, c, f, o);

        // TODO: test validations
    }
    /**
     * Finds the ArchivedUserTask by ID
     *
     * Returns the single ArchivedUserTask for the given ID 
     */
    @Test
    public void getArchivedUserTaskByIdTest() {
        String id = null;
        // ArchivedUserTask response = api.getArchivedUserTaskById(id);

        // TODO: test validations
    }
}
