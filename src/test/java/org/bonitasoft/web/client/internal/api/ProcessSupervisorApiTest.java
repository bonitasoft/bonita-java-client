package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.ProcessSupervisor;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ProcessSupervisorApi
 */
public class ProcessSupervisorApiTest {

    private ProcessSupervisorApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ProcessSupervisorApi.class);
    }

    /**
     * Create the ProcessSupervisor
     *
     * Create the ProcessSupervisor 
     */
    @Test
    public void createProcessSupervisorTest() {
        ProcessSupervisor body = null;
        // ProcessSupervisor response = api.createProcessSupervisor(body);

        // TODO: test validations
    }
    /**
     * Delete the ProcessSupervisor by ID
     *
     * Delete the ProcessSupervisor for the given compoound IDs  You can delete a process supervisor by specifying its compound Id in the body of the request with the following format: &#x60;process_id/user_id/role_id/group_id&#x60; 
     */
    @Test
    public void deleteProcessSupervisorByIdTest() {
        List<String> requestBody = null;
        // api.deleteProcessSupervisorById(requestBody);

        // TODO: test validations
    }
    /**
     * Finds ProcessSupervisors
     *
     * Finds ProcessSupervisors with pagination params and filters  To filter, you need to specify the &#x60;process_id&#x60;, and then the &#x60;user_id&#x60;, &#x60;group_id&#x60; and &#x60;role_id&#x60; with one of them (two if you want to filter on group and role) set to &#x60;&gt;0&#x60; and the other ones set to &#x60;-1&#x60;. E.g.: &#x60;f&#x3D;process_id%3D8040901857674754544&amp;f&#x3D;user_id%3D&gt;0&amp;f&#x3D;group_id%3D-1&amp;f&#x3D;role_id%3D-1&#x60; 
     */
    @Test
    public void findProcessSupervisorsTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<ProcessSupervisor> response = api.findProcessSupervisors(p, c, f, o, s);

        // TODO: test validations
    }
}
