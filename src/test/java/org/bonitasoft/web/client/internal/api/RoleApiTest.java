package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject29;
import org.bonitasoft.web.client.internal.model.InlineObject30;
import org.bonitasoft.web.client.internal.model.Role;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for RoleApi
 */
public class RoleApiTest {

    private RoleApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(RoleApi.class);
    }

    /**
     * Create the Role
     *
     * Create the Role 
     */
    @Test
    public void createRoleTest() {
        InlineObject29 body = null;
        // Role response = api.createRole(body);

        // TODO: test validations
    }
    /**
     * Delete the Role by ID
     *
     * Delete the single Role for the given ID 
     */
    @Test
    public void deleteRoleByIdTest() {
        String id = null;
        // api.deleteRoleById(id);

        // TODO: test validations
    }
    /**
     * Finds Roles
     *
     * Finds Roles with pagination params and filters  - can order on &#x60;id&#x60;, &#x60;name&#x60; and &#x60;displayName&#x60; - can filter on &#x60;name&#x60; and &#x60;displayName&#x60; 
     */
    @Test
    public void findRolesTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<Role> response = api.findRoles(p, c, f, o, s);

        // TODO: test validations
    }
    /**
     * Finds the Role by ID
     *
     * Returns the single Role for the given ID 
     */
    @Test
    public void getRoleByIdTest() {
        String id = null;
        // Role response = api.getRoleById(id);

        // TODO: test validations
    }
    /**
     * Update the Role by ID
     *
     * Update the Role for the given ID 
     */
    @Test
    public void updateRoleByIdTest() {
        String id = null;
        InlineObject30 inlineObject30 = null;
        // api.updateRoleById(id, inlineObject30);

        // TODO: test validations
    }
}
