package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.CustomUser;
import org.bonitasoft.web.client.internal.model.Error;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CustomUserApi
 */
public class CustomUserApiTest {

    private CustomUserApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(CustomUserApi.class);
    }

    /**
     * Finds CustomUsers
     *
     * Finds CustomUsers with pagination params and filters  **The filter &#x60;userId&#x60; is mandatory** 
     */
    @Test
    public void findCustomUsersTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        // List<CustomUser> response = api.findCustomUsers(p, c, f);

        // TODO: test validations
    }
}
