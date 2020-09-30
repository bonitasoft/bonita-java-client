package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.AnyValue;
import org.bonitasoft.web.client.internal.model.ArchivedCase;
import org.bonitasoft.web.client.internal.model.Error;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ArchivedCaseApi
 */
public class ArchivedCaseApiTest {

    private ArchivedCaseApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ArchivedCaseApi.class);
    }

    /**
     * Delete the ArchivedCase by ID
     *
     * Delete the single ArchivedCase for the given ID 
     */
    @Test
    public void deleteArchivedCaseByIdTest() {
        String id = null;
        // api.deleteArchivedCaseById(id);

        // TODO: test validations
    }
    /**
     * Finds ArchivedCases
     *
     * Finds ArchivedCases with pagination params and filters  You can order on &#x60;id&#x60;, &#x60;processDefinitionId&#x60;, &#x60;startedBy&#x60;, &#x60;startedBySubstitute&#x60;, &#x60;startDate&#x60;, &#x60;endDate&#x60;, &#x60;lastUpdate&#x60;, &#x60;archivedDate&#x60;, &#x60;sourceObjectId&#x60;  You can filter on :  * &#x60;sourceObjectId&#x60;: The original case ID before the case was archived * &#x60;processDefinitionId&#x60;: The process derfinition ID * &#x60;name&#x60;: the process name * &#x60;started_by&#x60;: the ID of the user who started the process * &#x60;team_manager_id&#x60;: allow to retrieve the cases in which all users with this manager ID ar involved) * &#x60;supervisor_id&#x60;: allow the retrived the cases of all processes the user with this ID is supervisor of) beware you cannot use team_manager_id and supervisor_id at the same time 
     */
    @Test
    public void findArchivedCasesTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        // List<ArchivedCase> response = api.findArchivedCases(p, c, f, o);

        // TODO: test validations
    }
    /**
     * Finds the ArchivedCase by ID
     *
     * Returns the single ArchivedCase for the given ID 
     */
    @Test
    public void getArchivedCaseByIdTest() {
        String id = null;
        // ArchivedCase response = api.getArchivedCaseById(id);

        // TODO: test validations
    }
    /**
     * Finds the Context by ArchivedCase ID
     *
     * Returns the Context for the given ArchivedCase ID 
     */
    @Test
    public void getContextByArchivedCaseIdTest() {
        String id = null;
        // AnyValue response = api.getContextByArchivedCaseId(id);

        // TODO: test validations
    }
}
