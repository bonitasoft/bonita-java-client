package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import java.io.File;
import org.bonitasoft.web.client.internal.model.InlineObject41;
import org.bonitasoft.web.client.internal.model.InlineObject42;
import org.bonitasoft.web.client.internal.model.Profile;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ProfileApi
 */
public class ProfileApiTest {

    private ProfileApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ProfileApi.class);
    }

    /**
     * Create the Profile
     *
     * Create the Profile 
     */
    @Test
    public void createProfileTest() {
        InlineObject41 body = null;
        // Profile response = api.createProfile(body);

        // TODO: test validations
    }
    /**
     * Delete the Profile by ID
     *
     * Delete the single Profile for the given ID 
     */
    @Test
    public void deleteProfileByIdTest() {
        String id = null;
        // api.deleteProfileById(id);

        // TODO: test validations
    }
    /**
     * Finds Profiles
     *
     * Finds Profiles with pagination params and filters  - can search on &#x60;name&#x60; - can filter on &#x60;name&#x60;,&#x60;hasNavigation&#x60; 
     */
    @Test
    public void findProfilesTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String s = null;
        // List<Profile> response = api.findProfiles(p, c, f, s);

        // TODO: test validations
    }
    /**
     * Finds the Profile by ID
     *
     * Returns the single Profile for the given ID 
     */
    @Test
    public void getProfileByIdTest() {
        String id = null;
        // Profile response = api.getProfileById(id);

        // TODO: test validations
    }
    /**
     * Import profiles
     *
     * Import profiles 
     */
    @Test
    public void importProfilesTest() {
        String profileDataUpload = null;
        String importPolicy = null;
        // api.importProfiles(profileDataUpload, importPolicy);

        // TODO: test validations
    }
    /**
     * Update the Profile by ID
     *
     * Update the Profile for the given ID 
     */
    @Test
    public void updateProfileByIdTest() {
        String id = null;
        InlineObject42 inlineObject42 = null;
        // api.updateProfileById(id, inlineObject42);

        // TODO: test validations
    }
    /**
     * Upload profiles
     *
     * Upload profiles 
     */
    @Test
    public void uploadprofilesTest() {
        File file = null;
        // api.uploadprofiles(file);

        // TODO: test validations
    }
}
