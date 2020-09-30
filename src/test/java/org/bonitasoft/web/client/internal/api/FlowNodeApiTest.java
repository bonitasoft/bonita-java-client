package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.FlowNode;
import org.bonitasoft.web.client.internal.model.InlineObject21;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for FlowNodeApi
 */
public class FlowNodeApiTest {

    private FlowNodeApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(FlowNodeApi.class);
    }

    /**
     * Finds FlowNodes
     *
     * Finds FlowNodes with pagination params and filters  - can order on &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;state&#x60;, &#x60;processDefinitionId&#x60;, &#x60;parentProcessInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60; (if the retrieved flow nodes are activities, order by parent activity id), &#x60;rootProcessInstanceId&#x60;, &#x60;lastUpdateDate&#x60; - can search on any field that can be used to order results - can filter on &#x60;name&#x60;, &#x60;state&#x60;, &#x60;processId&#x60;, &#x60;parentCaseId&#x60;, &#x60;rootCaseId&#x60;, &#x60;last_update_date&#x60; 
     */
    @Test
    public void findFlowNodesTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<FlowNode> response = api.findFlowNodes(p, c, f, o, s);

        // TODO: test validations
    }
    /**
     * Finds the FlowNode by ID
     *
     * Returns the single FlowNode for the given ID 
     */
    @Test
    public void getFlowNodeByIdTest() {
        String id = null;
        // FlowNode response = api.getFlowNodeById(id);

        // TODO: test validations
    }
    /**
     * Update the FlowNode by ID
     *
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Replay the flow node for the given ID. 
     */
    @Test
    public void updateFlowNodeByIdTest() {
        String id = null;
        InlineObject21 inlineObject21 = null;
        // api.updateFlowNodeById(id, inlineObject21);

        // TODO: test validations
    }
}
