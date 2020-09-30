package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.ApplicationMenu;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject2;
import org.bonitasoft.web.client.internal.model.InlineObject3;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ApplicationMenuApi
 */
public class ApplicationMenuApiTest {

    private ApplicationMenuApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ApplicationMenuApi.class);
    }

    /**
     * New application menu item
     *
     * Create an application menu item 
     */
    @Test
    public void createApplicationMenuTest() {
        InlineObject2 inlineObject2 = null;
        // ApplicationMenu response = api.createApplicationMenu(inlineObject2);

        // TODO: test validations
    }
    /**
     * Delete an application menu by ID
     *
     * Delete a single application menu for the given ID
     */
    @Test
    public void deleteApplicationMenuByIdTest() {
        String id = null;
        // api.deleteApplicationMenuById(id);

        // TODO: test validations
    }
    /**
     * Finds application menus
     *
     * Returns application menus with pagination params and filters  - can order on &#x60;id&#x60;, &#x60;displayName&#x60;, &#x60;applicationId&#x60;, &#x60;applicationPageId&#x60;, &#x60;menuIndex&#x60;, &#x60;parentMenuId&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;id&#x60;, &#x60;displayName&#x60;, &#x60;applicationId&#x60;, &#x60;applicationPageId&#x60;, &#x60;menuIndex&#x60;, &#x60;parentMenuId&#x60; 
     */
    @Test
    public void findApplicationMenusTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<ApplicationMenu> response = api.findApplicationMenus(p, c, f, o, s);

        // TODO: test validations
    }
    /**
     * Finds a application menu by ID
     *
     * Returns a single application menu for the given ID 
     */
    @Test
    public void geApplicationMenuByIdTest() {
        String id = null;
        // ApplicationMenu response = api.geApplicationMenuById(id);

        // TODO: test validations
    }
    /**
     * Update a application menu by ID
     *
     * Update a application menu for the given ID
     */
    @Test
    public void updateApplicationMenuByIdTest() {
        String id = null;
        InlineObject3 inlineObject3 = null;
        // api.updateApplicationMenuById(id, inlineObject3);

        // TODO: test validations
    }
}
