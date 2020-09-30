package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject43;
import org.bonitasoft.web.client.internal.model.InlineObject44;
import org.bonitasoft.web.client.internal.model.ProfileEntry;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ProfileEntryApi
 */
public class ProfileEntryApiTest {

    private ProfileEntryApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ProfileEntryApi.class);
    }

    /**
     * Create the ProfileEntry
     *
     * Create the ProfileEntry 
     */
    @Test
    public void createProfileEntryTest() {
        InlineObject43 body = null;
        // ProfileEntry response = api.createProfileEntry(body);

        // TODO: test validations
    }
    /**
     * Delete the ProfileEntry by ID
     *
     * Delete the single ProfileEntry for the given ID 
     */
    @Test
    public void deleteProfileEntryByIdTest() {
        String id = null;
        // api.deleteProfileEntryById(id);

        // TODO: test validations
    }
    /**
     * Finds ProfileEntries
     *
     * Finds ProfileEntries with pagination params and filters  - can search on &#x60;name&#x60; - can filter on &#x60;page&#x60;,&#x60;name&#x60; and &#x60;parent_id&#x60; 
     */
    @Test
    public void findProfileEntriesTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String s = null;
        // List<ProfileEntry> response = api.findProfileEntries(p, c, f, s);

        // TODO: test validations
    }
    /**
     * Finds the ProfileEntry by ID
     *
     * Returns the single ProfileEntry for the given ID 
     */
    @Test
    public void getProfileEntryByIdTest() {
        String id = null;
        // ProfileEntry response = api.getProfileEntryById(id);

        // TODO: test validations
    }
    /**
     * Update the ProfileEntry by ID
     *
     * Update the ProfileEntry for the given ID 
     */
    @Test
    public void updateProfileEntryByIdTest() {
        String id = null;
        InlineObject44 inlineObject44 = null;
        // api.updateProfileEntryById(id, inlineObject44);

        // TODO: test validations
    }
}
