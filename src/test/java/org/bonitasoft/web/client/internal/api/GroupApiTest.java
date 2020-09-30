package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.Group;
import org.bonitasoft.web.client.internal.model.InlineObject26;
import org.bonitasoft.web.client.internal.model.InlineObject27;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for GroupApi
 */
public class GroupApiTest {

    private GroupApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(GroupApi.class);
    }

    /**
     * Create the Group
     *
     * Create the Group 
     */
    @Test
    public void createGroupTest() {
        InlineObject26 body = null;
        // Group response = api.createGroup(body);

        // TODO: test validations
    }
    /**
     * Delete the Group by ID
     *
     * Delete the single Group for the given ID 
     */
    @Test
    public void deleteGroupByIdTest() {
        String id = null;
        // api.deleteGroupById(id);

        // TODO: test validations
    }
    /**
     * Finds Groups
     *
     * Finds Groups with pagination params and filters.  - can order on &#x60;id&#x60;,&#x60;name&#x60;,&#x60;displayName&#x60; - can filter on &#x60;name&#x60;,&#x60;displayName&#x60;,&#x60;parent_path&#x60; 
     */
    @Test
    public void findGroupsTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        // List<Group> response = api.findGroups(p, c, f, o);

        // TODO: test validations
    }
    /**
     * Finds the Group by ID
     *
     * Returns the single Group for the given ID 
     */
    @Test
    public void getGroupByIdTest() {
        String id = null;
        // Group response = api.getGroupById(id);

        // TODO: test validations
    }
    /**
     * Update the Group by ID
     *
     * Update the Group for the given ID 
     */
    @Test
    public void updateGroupByIdTest() {
        String id = null;
        InlineObject27 inlineObject27 = null;
        // api.updateGroupById(id, inlineObject27);

        // TODO: test validations
    }
}
