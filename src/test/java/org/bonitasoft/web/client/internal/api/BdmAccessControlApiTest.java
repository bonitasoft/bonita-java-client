package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.BDMAccessControl;
import org.bonitasoft.web.client.internal.model.Error;
import java.io.File;
import org.bonitasoft.web.client.internal.model.InlineResponse200;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for BdmAccessControlApi
 */
public class BdmAccessControlApiTest {

    private BdmAccessControlApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(BdmAccessControlApi.class);
    }

    /**
     * Delete the BDM Access Control
     *
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Delete the BDM access control 
     */
    @Test
    public void deleteBDMAccessControlTest() {
        // api.deleteBDMAccessControl();

        // TODO: test validations
    }
    /**
     * BDM access control status
     *
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Get the BDM access control status. 
     */
    @Test
    public void getDBMAccessControlStatusTest() {
        // BDMAccessControl response = api.getDBMAccessControlStatus();

        // TODO: test validations
    }
    /**
     * Import a BDM Access Control
     *
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Import a BDM Access Control 
     */
    @Test
    public void importBDMAccessControlTest() {
        String bdmAccessControlUpload = null;
        // api.importBDMAccessControl(bdmAccessControlUpload);

        // TODO: test validations
    }
    /**
     * Upload a BDM Access Control
     *
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Upload BDM Access Control 
     */
    @Test
    public void uploadBDMAccessControlTest() {
        File file = null;
        // InlineResponse200 response = api.uploadBDMAccessControl(file);

        // TODO: test validations
    }
}
