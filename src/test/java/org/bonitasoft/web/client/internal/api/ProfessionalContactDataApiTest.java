package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.ProfessionalContactData;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ProfessionalContactDataApi
 */
public class ProfessionalContactDataApiTest {

    private ProfessionalContactDataApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ProfessionalContactDataApi.class);
    }

    /**
     * Create the ProfessionalContactData
     *
     * Create the ProfessionalContactData 
     */
    @Test
    public void createProfessionalContactDataTest() {
        ProfessionalContactData body = null;
        // ProfessionalContactData response = api.createProfessionalContactData(body);

        // TODO: test validations
    }
    /**
     * Finds ProfessionalContactData
     *
     * Finds ProfessionalContactData with pagination params and filters  - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60; 
     */
    @Test
    public void findProfessionalContactDatasTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<ProfessionalContactData> response = api.findProfessionalContactDatas(p, c, f, o, s);

        // TODO: test validations
    }
    /**
     * Finds the PersonalContactData by ID
     *
     * Returns the single PersonalContactData for the given ID 
     */
    @Test
    public void getPersonalContactDataByIdTest() {
        String userId = null;
        // ProfessionalContactData response = api.getPersonalContactDataById(userId);

        // TODO: test validations
    }
    /**
     * Finds the ProfessionalContactData by ID
     *
     * Returns the single ProfessionalContactData for the given ID 
     */
    @Test
    public void getProfessionalContactDataByIdTest() {
        String userId = null;
        // ProfessionalContactData response = api.getProfessionalContactDataById(userId);

        // TODO: test validations
    }
    /**
     * Update the PersonalContactData by ID
     *
     * Update the PersonalContactData for the given ID 
     */
    @Test
    public void updatePersonalContactDataByIdTest() {
        String userId = null;
        ProfessionalContactData professionalContactData = null;
        // api.updatePersonalContactDataById(userId, professionalContactData);

        // TODO: test validations
    }
    /**
     * Update the ProfessionalContactData by ID
     *
     * Update the ProfessionalContactData for the given ID 
     */
    @Test
    public void updateProfessionalContactDataByIdTest() {
        String userId = null;
        ProfessionalContactData professionalContactData = null;
        // api.updateProfessionalContactDataById(userId, professionalContactData);

        // TODO: test validations
    }
}
