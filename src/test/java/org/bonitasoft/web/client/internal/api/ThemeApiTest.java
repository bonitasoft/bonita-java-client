package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject46;
import org.bonitasoft.web.client.internal.model.InlineObject47;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ThemeApi
 */
public class ThemeApiTest {

    private ThemeApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ThemeApi.class);
    }

    /**
     * Create the Theme
     *
     * Create the Theme 
     */
    @Test
    public void createThemeTest() {
        InlineObject46 body = null;
        // api.createTheme(body);

        // TODO: test validations
    }
    /**
     * Update the Theme by ID
     *
     * Restore a default theme 
     */
    @Test
    public void updateThemeTest() {
        InlineObject47 inlineObject47 = null;
        // api.updateTheme(inlineObject47);

        // TODO: test validations
    }
}
