package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.EncodingUtils;
import org.bonitasoft.web.client.internal.model.Page;
import org.bonitasoft.web.client.internal.model.PageCreateRequest;
import org.bonitasoft.web.client.internal.model.PageUpdateRequest;
import org.bonitasoft.web.client.internal.model.PageUploadResponse;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
public interface PageApi extends ApiClient.Api {


  /**
   * Create the Page
   * Upload the page content using the &#x60;portal/pageUpload&#x60; . This returns a temporary file name that can be used as input for this operation. 
   * @param body Zip name as named in the temp folder after upload (required)
   * @return Page
   */
  @RequestLine("POST /API/portal/page")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Page createPage(PageCreateRequest body);

  /**
   * Delete the Page by ID
   * Delete the single Page for the given ID 
   * @param id ID of the Page to delete (required)
   */
  @RequestLine("DELETE /API/portal/page/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deletePageById(@Param("id") String id);

  /**
   * Finds Pages
   * Finds Pages with pagination params and filters  - can search on &#x60;displayName&#x60;,&#x60;description&#x60; - can filter on &#x60;createdBy&#x60;,&#x60;contentType&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @param o can order on attributes (optional)
   * @param s can search on attributes (optional)
   * @return List&lt;Page&gt;
   */
  @RequestLine("GET /API/portal/page?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
    "Accept: application/json",
  })
  List<Page> findPages(@Param("p") Integer p, @Param("c") Integer c, @Param("f") String f, @Param("o") String o, @Param("s") String s);

  /**
   * Finds Pages
   * Finds Pages with pagination params and filters  - can search on &#x60;displayName&#x60;,&#x60;description&#x60; - can filter on &#x60;createdBy&#x60;,&#x60;contentType&#x60; 
   * Note, this is equivalent to the other <code>findPages</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link FindPagesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>p - index of the page to display (required)</li>
   *   <li>c - maximum number of elements to retrieve (required)</li>
   *   <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)</li>
   *   <li>o - can order on attributes (optional)</li>
   *   <li>s - can search on attributes (optional)</li>
   *   </ul>
   * @return List&lt;Page&gt;
   */
  @RequestLine("GET /API/portal/page?p={p}&c={c}&f={f}&o={o}&s={s}")
  @Headers({
  "Accept: application/json",
  })
  List<Page> findPages(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>findPages</code> method in a fluent style.
   */
  public static class FindPagesQueryParams extends HashMap<String, Object> {
    public FindPagesQueryParams p(final Integer value) {
      put("p", EncodingUtils.encode(value));
      return this;
    }
    public FindPagesQueryParams c(final Integer value) {
      put("c", EncodingUtils.encode(value));
      return this;
    }
    public FindPagesQueryParams f(final String value) {
      put("f", EncodingUtils.encode(value));
      return this;
    }
    public FindPagesQueryParams o(final String value) {
      put("o", EncodingUtils.encode(value));
      return this;
    }
    public FindPagesQueryParams s(final String value) {
      put("s", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Finds the Page by ID
   * Returns the single Page for the given ID 
   * @param id ID of the Page to return (required)
   * @return Page
   */
  @RequestLine("GET /API/portal/page/{id}")
  @Headers({
    "Accept: application/json",
  })
  Page getPageById(@Param("id") String id);

  /**
   * Update the Page by ID
   * Use the PUT method to update an existing custom page. To update a custom page, upload the new page content using the pageUpload servlet, which returns a temporary file name, and then call this API with the temporary file name. 
   * @param id ID of the Page to return (required)
   * @param pageUpdateRequest Partial Page description (required)
   */
  @RequestLine("PUT /API/portal/page/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  void updatePageById(@Param("id") String id, PageUpdateRequest pageUpdateRequest);

  /**
   * Upload a Page
   * Upload Page 
   * @param file  (optional)
   * @return PageUploadResponse
   */
  @RequestLine("POST /portal/pageUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  PageUploadResponse uploadPage(@Param("file") File file);
}
