package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.ArchivedManualTask;
import org.bonitasoft.web.client.internal.model.Error;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ArchivedManualTaskApi
 */
public class ArchivedManualTaskApiTest {

    private ArchivedManualTaskApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ArchivedManualTaskApi.class);
    }

    /**
     * Finds ArchivedManualTasks
     *
     * Finds ArchivedManualTasks with pagination params and filters  You can filter on:  * &#x60;assigned_id&#x3D;{user_id}&#x60;: retrieve only the human tasks assigned to the specified ID. For example, retrieve the human tasks assigned to user with id 2: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;assigned_id%3d2&#x60; * &#x60;state&#x3D;&#x60;: retrieve only the archived user tasks with the specified state. For example, retrieve the skipped tasks: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;state&#x3D;skipped&#x60; * &#x60;name&#x3D;&#x60;: retrieve only the human tasks with the specified name. For example, retrieve the human tasks with the name \&quot;Analyse Case\&quot;: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;name&#x3D;Analyse Case&#x60; * &#x60;displayName&#x3D;&#x60;: retrieve only the archived user tasks with the specified displayName. For example, retrieve the human tasks with the displayName \&quot;Analyse Case\&quot;: &#x60;/API/bpm/archivedHumanTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;displayName&#x3D;Analyse Case&#x60; 
     */
    @Test
    public void findArchivedManualTasksTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        // List<ArchivedManualTask> response = api.findArchivedManualTasks(p, c, f, o);

        // TODO: test validations
    }
    /**
     * Finds the ArchivedManualTask by ID
     *
     * Returns the single ArchivedManualTask for the given ID 
     */
    @Test
    public void getArchivedManualTaskByIdTest() {
        String id = null;
        // ArchivedManualTask response = api.getArchivedManualTaskById(id);

        // TODO: test validations
    }
}
