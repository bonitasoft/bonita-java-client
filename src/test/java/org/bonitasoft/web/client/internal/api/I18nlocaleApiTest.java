package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.I18nlocale;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for I18nlocaleApi
 */
public class I18nlocaleApiTest {

    private I18nlocaleApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(I18nlocaleApi.class);
    }

    /**
     * Finds I18nlocales
     *
     * List the available I18nlocales with pagination params and filters 
     */
    @Test
    public void findI18nlocalesTest() {
        Integer p = null;
        Integer c = null;
        // List<I18nlocale> response = api.findI18nlocales(p, c);

        // TODO: test validations
    }
}
