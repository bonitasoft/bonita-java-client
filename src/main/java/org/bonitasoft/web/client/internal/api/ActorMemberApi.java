package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.ActorMember;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;

import java.util.List;

public interface ActorMemberApi {
  /**
   * Delete the ActorMember by ID
   * Delete the single ActorMember for the given ID 
   * @param id ID of the ActorMember to delete (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("API/bpm/actorMemberEntry/{id}")
  Call<Void> deleteActorMemberById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Finds ActorMembers
   * Finds ActorMembers with pagination params and filters  There is a **mandatory** filter on:  * &#x60;actor_id&#x60; For example, retrieve the actorMembers related to the specified actor_id. http://localhost:8080/bonita/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1  You can also filter also on:  * &#x60;member_type&#x60; (user|role|group|roleAndGroup) retrieve only the actorMembers of type user. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;member_type%3duser&#x60; * &#x60;user_id&#x60;: retrieve only the actorMembers related to the specified user_id. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;user_id%3d101&#x60; * &#x60;role_id&#x60;: retrieve only the actorMembers related to the specified role_id. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;role_id%3d101&#x60; * &#x60;group_id&#x60;: retrieve only the actorMembers related to the specified group_id. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;group_id%3d101&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return Call&lt;List&lt;ActorMember&gt;&gt;
   */
  @GET("API/bpm/actorMemberEntry")
  Call<List<ActorMember>> findActorMembers(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o
  );

  /**
   * Finds the ActorMember by ID
   * Returns the single ActorMember for the given ID 
   * @param id ID of the ActorMember to return (required)
   * @return Call&lt;ActorMember&gt;
   */
  @GET("API/bpm/actorMemberEntry/{id}")
  Call<ActorMember> getActorMemberById(
    @retrofit2.http.Path("id") String id
  );

}
