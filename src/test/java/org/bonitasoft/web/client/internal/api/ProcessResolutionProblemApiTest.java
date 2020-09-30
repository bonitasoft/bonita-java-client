package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.ProcessResolutionProblem;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ProcessResolutionProblemApi
 */
public class ProcessResolutionProblemApiTest {

    private ProcessResolutionProblemApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ProcessResolutionProblemApi.class);
    }

    /**
     * Finds ProcessResolutionProblems
     *
     * Finds ProcessResolutionProblems with pagination params and filters to list the problems that need to be solved before a process can be used.  **Filtering on the process definition ID is mandatory.** 
     */
    @Test
    public void findProcessResolutionProblemsTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<ProcessResolutionProblem> response = api.findProcessResolutionProblems(p, c, f, o, s);

        // TODO: test validations
    }
}
