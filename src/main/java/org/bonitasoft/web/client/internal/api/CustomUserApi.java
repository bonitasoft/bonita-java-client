package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.internal.model.CustomUser;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface CustomUserApi {
  /**
   * Finds CustomUsers
   * Finds CustomUsers with pagination params and filters  **The filter &#x60;userId&#x60; is mandatory** 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @return Call&lt;List&lt;CustomUser&gt;&gt;
   */
  @GET("API/customuserinfo/user")
  Call<List<CustomUser>> findCustomUsers(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f
  );

}
