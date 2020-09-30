package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.Message;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for MessageApi
 */
public class MessageApiTest {

    private MessageApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(MessageApi.class);
    }

    /**
     * Send BPM message events
     *
     * Use this resource to send BPM message events. Message events are caught by processes using &#x60;catch message event&#x60; flow nodes (Start, intermediate, boundary or receive tasks). 
     */
    @Test
    public void createMessageTest() {
        Message body = null;
        // api.createMessage(body);

        // TODO: test validations
    }
}
