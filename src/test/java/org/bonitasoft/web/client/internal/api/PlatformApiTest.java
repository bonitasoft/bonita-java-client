package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject34;
import org.bonitasoft.web.client.internal.model.Platform;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PlatformApi
 */
public class PlatformApiTest {

    private PlatformApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(PlatformApi.class);
    }

    /**
     * Finds the Platform by ID
     *
     * Returns the current Platform 
     */
    @Test
    public void getPlatformByIdTest() {
        // Platform response = api.getPlatformById();

        // TODO: test validations
    }
    /**
     * Platform Login
     *
     * The username and password are in &#x60;bonita-platform-community-custom.properties&#x60; file. 
     */
    @Test
    public void platformLoginTest() {
        String username = null;
        String password = null;
        String redirect = null;
        // api.platformLogin(username, password, redirect);

        // TODO: test validations
    }
    /**
     * Platform Logout
     *
     * 
     */
    @Test
    public void platformLogoutTest() {
        // api.platformLogout();

        // TODO: test validations
    }
    /**
     * Update the Platform by ID
     *
     * Start or stop the current node, that is, start or stop all services of the current JVM. 
     */
    @Test
    public void updatePlatformByIdTest() {
        InlineObject34 inlineObject34 = null;
        // api.updatePlatformById(inlineObject34);

        // TODO: test validations
    }
}
