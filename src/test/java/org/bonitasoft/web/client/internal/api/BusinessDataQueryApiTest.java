package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.BusinessData;
import org.bonitasoft.web.client.internal.model.Error;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for BusinessDataQueryApi
 */
public class BusinessDataQueryApiTest {

    private BusinessDataQueryApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(BusinessDataQueryApi.class);
    }

    /**
     * Finds Business Data
     *
     * Finds Business Data with pagination params and filters by calling a &#x60;Named Query&#x60;. The business data query REST API resource is used to call a default or custom business data query. It is available from version 6.5.  **Data parameters**:    * businessDataType - the fully-qualified business data type name   * q&#x3D;queryName - the query name   * p&#x3D;0 - the page number   * c&#x3D;10 - the maximum number of results in the page   * f&#x3D;parameter&#x3D;value - sets the parameter value according to business data query parameters defined in Bonita Studio   For a Boolean parameter, the accepted values are &#x60;true&#x60; or &#x60;false&#x60;.    By default, for a Date parameter can use the following formats:    * yyyy-MM-dd   * HH:mm:ss   * yyyy-MM-dd HH:mm:ss   * yyyy-MM-dd&#39;T&#39;HH:mm:ss   * yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSS 
     */
    @Test
    public void findBusinessDataTest() {
        String businessDataType = null;
        String q = null;
        Integer p = null;
        Integer c = null;
        String f = null;
        // List<BusinessData> response = api.findBusinessData(businessDataType, q, p, c, f);

        // TODO: test validations
    }
}
