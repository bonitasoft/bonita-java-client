package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.EncodingUtils;

import org.bonitasoft.web.client.internal.model.CustomUserDefinition;
import org.bonitasoft.web.client.internal.model.CustomUserDefinitionCreateRequest;
import org.bonitasoft.web.client.internal.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface CustomUserDefinitionApi extends ApiClient.Api {


  /**
   * Create the CustomUserDefinition
   * Create the CustomUserDefinition 
   * @param body Partial CustomUserDefinition description (required)
   * @return CustomUserDefinition
   */
  @RequestLine("POST /API/customuserinfo/definition")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  CustomUserDefinition createCustomUserDefinition(CustomUserDefinitionCreateRequest body);

  /**
   * Delete the CustomUserDefinition by ID
   * Delete the single CustomUserDefinition for the given ID 
   * @param id ID of the CustomUserDefinition to delete (required)
   */
  @RequestLine("DELETE /API/customuserinfo/definition/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteCustomUserDefinitionById(@Param("id") String id);

  /**
   * Finds CustomUserDefinitions
   * Finds CustomUserDefinitions. There are no filters, and no search terms. All the definitions are returned. 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @return List&lt;CustomUserDefinition&gt;
   */
  @RequestLine("GET /API/customuserinfo/definition?p={p}&c={c}")
  @Headers({
    "Accept: application/json",
  })
  List<CustomUserDefinition> findCustomUserDefinitions(@Param("p") Integer p, @Param("c") Integer c);

  /**
   * Finds CustomUserDefinitions
   * Finds CustomUserDefinitions. There are no filters, and no search terms. All the definitions are returned. 
   * Note, this is equivalent to the other <code>findCustomUserDefinitions</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindCustomUserDefinitionsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   </ul>
   * @return List&lt;CustomUserDefinition&gt;
   */
  @RequestLine("GET /API/customuserinfo/definition?p={p}&c={c}")
  @Headers({
  "Accept: application/json",
  })
  List<CustomUserDefinition> findCustomUserDefinitions(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findCustomUserDefinitions</code> method in a fluent style.
   */
  public static class FindCustomUserDefinitionsQueryParams extends HashMap<String, Object> {
    public FindCustomUserDefinitionsQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public FindCustomUserDefinitionsQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Finds the CustomUserDefinition by ID
   * Returns the single CustomUserDefinition for the given ID 
   * @param id ID of the CustomUserDefinition to return (required)
   * @return CustomUserDefinition
   */
  @RequestLine("GET /API/customuserinfo/definition/{id}")
  @Headers({
    "Accept: application/json",
  })
  CustomUserDefinition getCustomUserDefinitionById(@Param("id") String id);
}
