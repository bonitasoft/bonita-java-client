package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.Actor;
import org.bonitasoft.web.client.internal.model.InlineObject15;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;

import java.util.List;

public interface ActorApi {
  /**
   * Finds Actors
   * Finds Actors with pagination params and filters 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @return Call&lt;List&lt;Actor&gt;&gt;
   */
  @GET("API/bpm/actor")
  Call<List<Actor>> findActors(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f, @retrofit2.http.Query("o") String o
  );

  /**
   * Finds the Actor by ID
   * Returns the single Actor for the given ID 
   * @param id ID of the Actor to return (required)
   * @return Call&lt;Actor&gt;
   */
  @GET("API/bpm/actor/{id}")
  Call<Actor> getActorById(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Update the Actor by ID
   * Update the Actor for the given ID 
   * @param id ID of the Actor to return (required)
   * @param inlineObject15  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PUT("API/bpm/actor/{id}")
  Call<Void> updateActorById(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body InlineObject15 inlineObject15
  );

}
