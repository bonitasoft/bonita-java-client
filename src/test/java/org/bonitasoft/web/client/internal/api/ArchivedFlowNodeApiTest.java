package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.ArchivedFlowNode;
import org.bonitasoft.web.client.internal.model.Error;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ArchivedFlowNodeApi
 */
public class ArchivedFlowNodeApiTest {

    private ArchivedFlowNodeApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ArchivedFlowNodeApi.class);
    }

    /**
     * Finds ArchivedFlowNodes
     *
     * Finds ArchivedFlowNodes with pagination params and filters  - can order on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;type&#x60;, &#x60;isTerminal&#x60;, &#x60;processId&#x60;, &#x60;caseId&#x60;, &#x60;archivedDate&#x60; - can search on any field that can be used to order results - can filter on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;stateId&#x60;, &#x60;kind&#x60;, &#x60;terminal&#x60;, &#x60;processDefinitionId&#x60;, &#x60;parentProcessInstanceId&#x60;, &#x60;rootProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60;, &#x60;archivedDate&#x60;, &#x60;reachedStateDate&#x60;, &#x60;sourceObjectId&#x60; 
     */
    @Test
    public void findArchivedFlowNodesTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<ArchivedFlowNode> response = api.findArchivedFlowNodes(p, c, f, o, s);

        // TODO: test validations
    }
    /**
     * Finds the ArchivedFlowNode by ID
     *
     * Returns the single ArchivedFlowNode for the given ID 
     */
    @Test
    public void getArchivedFlowNodeByIdTest() {
        String id = null;
        // ArchivedFlowNode response = api.getArchivedFlowNodeById(id);

        // TODO: test validations
    }
}
