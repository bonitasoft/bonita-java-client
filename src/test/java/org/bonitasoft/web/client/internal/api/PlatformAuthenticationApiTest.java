package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PlatformAuthenticationApi
 */
public class PlatformAuthenticationApiTest {

    private PlatformAuthenticationApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(PlatformAuthenticationApi.class);
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
}
