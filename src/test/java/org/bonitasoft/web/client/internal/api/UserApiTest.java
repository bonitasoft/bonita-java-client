package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject31;
import org.bonitasoft.web.client.internal.model.InlineObject32;
import org.bonitasoft.web.client.internal.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for UserApi
 */
public class UserApiTest {

    private UserApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(UserApi.class);
    }

    /**
     * Create the User
     *
     * Create the User 
     */
    @Test
    public void createUserTest() {
        InlineObject31 body = null;
        // User response = api.createUser(body);

        // TODO: test validations
    }
    /**
     * Delete the User by ID
     *
     * Delete the single User for the given ID.  **Use this method with caution**: some artifacts like applications, cases or users may present display problems in the Bonita Portal if the referenced user was deleted. Note that you can disable a user instead of deleting it. To do so, use the UPDATE method and set the attribute &#39;enabled&#39; to false 
     */
    @Test
    public void deleteUserByIdTest() {
        String id = null;
        // api.deleteUserById(id);

        // TODO: test validations
    }
    /**
     * Finds Users
     *
     * Finds Users with pagination params and filters  - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60; 
     */
    @Test
    public void findUsersTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<User> response = api.findUsers(p, c, f, o, s);

        // TODO: test validations
    }
    /**
     * Finds the User by ID
     *
     * Returns the single User for the given ID 
     */
    @Test
    public void getUserByIdTest() {
        String id = null;
        // User response = api.getUserById(id);

        // TODO: test validations
    }
    /**
     * Update the User by ID
     *
     * Update the User for the given ID 
     */
    @Test
    public void updateUserByIdTest() {
        String id = null;
        InlineObject32 inlineObject32 = null;
        // api.updateUserById(id, inlineObject32);

        // TODO: test validations
    }
}
