package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject45;
import org.bonitasoft.web.client.internal.model.ProfileMember;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ProfileMemberApi
 */
public class ProfileMemberApiTest {

    private ProfileMemberApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ProfileMemberApi.class);
    }

    /**
     * Create the ProfileMember
     *
     * Create the ProfileMember 
     */
    @Test
    public void createProfileMemberTest() {
        InlineObject45 body = null;
        // ProfileMember response = api.createProfileMember(body);

        // TODO: test validations
    }
    /**
     * Delete the ProfileMember by ID
     *
     * Delete the single ProfileMember for the given ID 
     */
    @Test
    public void deleteProfileMemberByIdTest() {
        String id = null;
        // api.deleteProfileMemberById(id);

        // TODO: test validations
    }
    /**
     * Finds ProfileMembers
     *
     * Finds ProfileMembers with pagination params and filters  **Filter &#x60;member_type&#x60; is mandatory**  You can filter on &#x60;profile_id&#x60;, &#x60;user_id&#x60;, &#x60;role_id&#x60; and &#x60;group_id&#x60; 
     */
    @Test
    public void findProfileMembersTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        // List<ProfileMember> response = api.findProfileMembers(p, c, f);

        // TODO: test validations
    }
    /**
     * Finds the ProfileMember by ID
     *
     * Returns the single ProfileMember for the given ID 
     */
    @Test
    public void getProfileMemberByIdTest() {
        String id = null;
        // ProfileMember response = api.getProfileMemberById(id);

        // TODO: test validations
    }
}
