package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.ActorMember;
import org.bonitasoft.web.client.internal.model.Error;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ActorMemberApi
 */
public class ActorMemberApiTest {

    private ActorMemberApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ActorMemberApi.class);
    }

    /**
     * Delete the ActorMember by ID
     *
     * Delete the single ActorMember for the given ID 
     */
    @Test
    public void deleteActorMemberByIdTest() {
        String id = null;
        // api.deleteActorMemberById(id);

        // TODO: test validations
    }
    /**
     * Finds ActorMembers
     *
     * Finds ActorMembers with pagination params and filters  There is a **mandatory** filter on:  * &#x60;actor_id&#x60; For example, retrieve the actorMembers related to the specified actor_id. http://localhost:8080/bonita/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1  You can also filter also on:  * &#x60;member_type&#x60; (user|role|group|roleAndGroup) retrieve only the actorMembers of type user. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;member_type%3duser&#x60; * &#x60;user_id&#x60;: retrieve only the actorMembers related to the specified user_id. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;user_id%3d101&#x60; * &#x60;role_id&#x60;: retrieve only the actorMembers related to the specified role_id. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;role_id%3d101&#x60; * &#x60;group_id&#x60;: retrieve only the actorMembers related to the specified group_id. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;group_id%3d101&#x60; 
     */
    @Test
    public void findActorMembersTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        // List<ActorMember> response = api.findActorMembers(p, c, f, o);

        // TODO: test validations
    }
    /**
     * Finds the ActorMember by ID
     *
     * Returns the single ActorMember for the given ID 
     */
    @Test
    public void getActorMemberByIdTest() {
        String id = null;
        // ActorMember response = api.getActorMemberById(id);

        // TODO: test validations
    }
}
