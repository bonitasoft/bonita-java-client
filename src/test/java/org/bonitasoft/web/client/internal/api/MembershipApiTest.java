package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject28;
import org.bonitasoft.web.client.internal.model.Membership;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for MembershipApi
 */
public class MembershipApiTest {

    private MembershipApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(MembershipApi.class);
    }

    /**
     * Create the Membership
     *
     * Create the Membership 
     */
    @Test
    public void createMembershipTest() {
        InlineObject28 body = null;
        // Membership response = api.createMembership(body);

        // TODO: test validations
    }
    /**
     * Delete the Membership by ID
     *
     * Delete a membership of a user using the group id and role id. 
     */
    @Test
    public void deleteMembershipByIdTest() {
        String userId = null;
        String groupId = null;
        String roleId = null;
        // api.deleteMembershipById(userId, groupId, roleId);

        // TODO: test validations
    }
    /**
     * Finds Memberships
     *
     * Finds Memberships with pagination params and filters  **Filter &#x60;user_id&#x60; is mandatory**  You can order with the values: &#x60;ROLE_NAME_ASC&#x60;,&#x60;ROLE_NAME_DESC&#x60;, &#x60;GROUP_NAME_ASC&#x60;,&#x60;GROUP_NAME_DESC&#x60;, &#x60;ASSIGNED_DATE_ASC&#x60;, &#x60;ASSIGNED_DATE_DESC&#x60; 
     */
    @Test
    public void findMembershipsTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<Membership> response = api.findMemberships(p, c, f, o, s);

        // TODO: test validations
    }
}
