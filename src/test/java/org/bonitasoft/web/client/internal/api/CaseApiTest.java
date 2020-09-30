package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.AnyValue;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject16;
import org.bonitasoft.web.client.internal.model.ModelCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CaseApi
 */
public class CaseApiTest {

    private CaseApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(CaseApi.class);
    }

    /**
     * Create the Case
     *
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) ![edition](https://img.shields.io/badge/edition-community-brightgreen)  Create the Case This way of creating a case using this method will only work for processes in which no contract is defined. To instantiate a process with a contract, check the process instantiation resource documentation. 
     */
    @Test
    public void createCaseTest() {
        InlineObject16 body = null;
        // ModelCase response = api.createCase(body);

        // TODO: test validations
    }
    /**
     * Delete the Case by ID
     *
     * Delete the single Case for the given ID 
     */
    @Test
    public void deleteCaseByIdTest() {
        String id = null;
        // api.deleteCaseById(id);

        // TODO: test validations
    }
    /**
     * Delete the Case by batch
     *
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) ![edition](https://img.shields.io/badge/edition-community-brightgreen)  Delete a list of Cases for the given IDs 
     */
    @Test
    public void deleteCaseByIdsTest() {
        List<String> requestBody = null;
        // api.deleteCaseByIds(requestBody);

        // TODO: test validations
    }
    /**
     * Finds Cases
     *
     * Finds Cases with pagination params and filters  You can filter on:  * &#x60;processDefinitionId&#x60;: The process derfinition ID * &#x60;name&#x60;: the process name * &#x60;started_by&#x60;: the ID of the user who started the process * &#x60;team_manager_id&#x60;: allow to retrieve the cases in which all users with this manager ID ar involved) * &#x60;supervisor_id&#x60;: allow the retrived the cases of all processes the user with this ID is supervisor of) beware you cannot use team_manager_id and supervisor_id at the same time 
     */
    @Test
    public void findCasesTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        // List<ModelCase> response = api.findCases(p, c, f, o);

        // TODO: test validations
    }
    /**
     * Finds the Case by ID
     *
     * Returns the single Case for the given ID 
     */
    @Test
    public void getCaseByIdTest() {
        String id = null;
        String n = null;
        // ModelCase response = api.getCaseById(id, n);

        // TODO: test validations
    }
    /**
     * Finds the Context by Case ID
     *
     * Returns the Context for the given Case ID 
     */
    @Test
    public void getContextByCaseIdTest() {
        String id = null;
        // AnyValue response = api.getContextByCaseId(id);

        // TODO: test validations
    }
}
