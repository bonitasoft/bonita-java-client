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
 * API tests for I18ntranslationApi
 */
public class I18ntranslationApiTest {

    private I18ntranslationApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(I18ntranslationApi.class);
    }

    /**
     * Finds I18ntranslations
     *
     * List the available I18ntranslations with pagination params and filters Returns all translations of the product. If a locale is specified in the filter, that translation for that locale are returned. If no locale is specified, the translations in English are returned.  You can filter on &#x60;locale&#x60; 
     */
    @Test
    public void findI18ntranslationsTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        // List<Map<String, String>> response = api.findI18ntranslations(p, c, f);

        // TODO: test validations
    }
}
