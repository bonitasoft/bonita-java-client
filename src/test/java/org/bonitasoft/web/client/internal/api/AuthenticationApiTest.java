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
 * API tests for AuthenticationApi
 */
public class AuthenticationApiTest {

    private AuthenticationApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(AuthenticationApi.class);
    }

    /**
     * Login
     *
     * A call to the &#x60;/loginservice&#x60; will generates a set-cookie header in the response.  The &#x60;JSESSIONID&#x60; cookie must be transfered with each subsequent calls. (If the REST API is used in an application running in a web browser, this is handled automatically by the web browser just like any cookies).  Additional protection agains CSRF attacks is enabled by default for all fresh installations This security relies on &#x60;X-Bonita-API-Token&#x60; information. The &#x60;X-Bonita-API-Token&#x60; value can be found in the cookie named: &#x60;X-Bonita-API-Token&#x60;.  All the subsequence REST API calls performing changes in the system using DELETE, POST, or PUT HTTP methods must contain the **HTTP header** below:  &#x60;&#x60;&#x60; X-Bonita-API-Token: example-dummy-not-be-used-value &#x60;&#x60;&#x60; 
     */
    @Test
    public void loginTest() {
        String username = null;
        String password = null;
        String redirect = null;
        String redirectURL = null;
        // api.login(username, password, redirect, redirectURL);

        // TODO: test validations
    }
    /**
     * Logout the current user
     *
     * Logout the current user from the system 
     */
    @Test
    public void logoutTest() {
        String redirect = null;
        // api.logout(redirect);

        // TODO: test validations
    }
}
