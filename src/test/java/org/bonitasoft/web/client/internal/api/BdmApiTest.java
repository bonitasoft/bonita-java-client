package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Bdm;
import org.bonitasoft.web.client.internal.model.BusinessData;
import org.bonitasoft.web.client.internal.model.Error;
import java.io.File;
import org.bonitasoft.web.client.internal.model.InlineObject50;
import org.bonitasoft.web.client.internal.model.InlineResponse200;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for BdmApi
 */
public class BdmApiTest {

    private BdmApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(BdmApi.class);
    }

    /**
     * Finds business data attribute by id
     *
     * Gets the business data attribute of business data according to its identifier and attribute name. Request url. 
     */
    @Test
    public void findBusinessDataAttributeByIdTest() {
        String businessDataType = null;
        String persistenceId = null;
        String attributeName = null;
        // BusinessData response = api.findBusinessDataAttributeById(businessDataType, persistenceId, attributeName);

        // TODO: test validations
    }
    /**
     * Finds business data by Id
     *
     * Finds business data specified by its identifier. 
     */
    @Test
    public void findBusinessDataByIdTest() {
        String businessDataType = null;
        String persistenceId = null;
        // BusinessData response = api.findBusinessDataById(businessDataType, persistenceId);

        // TODO: test validations
    }
    /**
     * Finds business data By Ids
     *
     * Finds business data specified by their identifiers. 
     */
    @Test
    public void findBusinessDataByIdsTest() {
        String businessDataType = null;
        String ids = null;
        // List<BusinessData> response = api.findBusinessDataByIds(businessDataType, ids);

        // TODO: test validations
    }
    /**
     * Get the BDM
     *
     * Returns the current BDM. Make this call to get the status the BDM. 
     */
    @Test
    public void getBdmTest() {
        // Bdm response = api.getBdm();

        // TODO: test validations
    }
    /**
     * Install a BDM
     *
     * Install a BDM 
     */
    @Test
    public void installBDMTest() {
        InlineObject50 inlineObject50 = null;
        // api.installBDM(inlineObject50);

        // TODO: test validations
    }
    /**
     * Upload a BDM
     *
     * Upload BDM 
     */
    @Test
    public void uploadBDMTest() {
        File file = null;
        // InlineResponse200 response = api.uploadBDM(file);

        // TODO: test validations
    }
}
