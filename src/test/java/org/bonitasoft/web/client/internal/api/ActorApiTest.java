package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Actor;
import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.InlineObject15;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ActorApi
 */
public class ActorApiTest {

    private ActorApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ActorApi.class);
    }

    /**
     * Finds Actors
     *
     * Finds Actors with pagination params and filters 
     */
    @Test
    public void findActorsTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        // List<Actor> response = api.findActors(p, c, f, o);

        // TODO: test validations
    }
    /**
     * Finds the Actor by ID
     *
     * Returns the single Actor for the given ID 
     */
    @Test
    public void getActorByIdTest() {
        String id = null;
        // Actor response = api.getActorById(id);

        // TODO: test validations
    }
    /**
     * Update the Actor by ID
     *
     * Update the Actor for the given ID 
     */
    @Test
    public void updateActorByIdTest() {
        String id = null;
        InlineObject15 inlineObject15 = null;
        // api.updateActorById(id, inlineObject15);

        // TODO: test validations
    }
}
