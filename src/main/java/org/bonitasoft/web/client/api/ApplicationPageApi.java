package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApplicationPage;
import org.bonitasoft.web.client.model.ApplicationPageCreateRequest;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ApplicationPageApi extends ApiClient.Api {

    /**
     * Create an application page Create an application page
     *
     * @param body Partial application page description (required)
     * @return ApplicationPage
     */
    @RequestLine("POST /API/living/application-page")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApplicationPage createApplicationPage(ApplicationPageCreateRequest body);

    /**
     * Delete an application page by ID Delete a single application page for the given ID
     *
     * @param id ID of application page to delete (required)
     */
    @RequestLine("DELETE /API/living/application-page/{id}")
    @Headers({
            "Accept: application/json",
    })
    void deleteApplicationPageById(@Param("id") String id);

    /**
     * Finds an application page by ID Returns a single application page for the given ID
     *
     * @param id ID of application page to return (required)
     * @return ApplicationPage
     */
    @RequestLine("GET /API/living/application-page/{id}")
    @Headers({
            "Accept: application/json",
    })
    ApplicationPage getApplicationPageById(@Param("id") String id);

    /**
     * Finds application pages Finds application pages with pagination params and filters - can order
     * on &#x60;id&#x60;, &#x60;token&#x60;, &#x60;applicationId&#x60;, &#x60;pageId&#x60; - can
     * search on &#x60;token&#x60; - can filter on &#x60;id&#x60;, &#x60;token&#x60;,
     * &#x60;applicationId&#x60;, &#x60;pageId&#x60;
     *
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value}
     *        with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return List&lt;ApplicationPage&gt;
     */
    @RequestLine("GET /API/living/application-page?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<ApplicationPage> searchApplicationPages(
            @Param("p") Integer p,
            @Param("c") Integer c,
            @Param("f") List<String> f,
            @Param("o") String o,
            @Param("s") String s);

    /**
     * Finds application pages Finds application pages with pagination params and filters - can order
     * on &#x60;id&#x60;, &#x60;token&#x60;, &#x60;applicationId&#x60;, &#x60;pageId&#x60; - can
     * search on &#x60;token&#x60; - can filter on &#x60;id&#x60;, &#x60;token&#x60;,
     * &#x60;applicationId&#x60;, &#x60;pageId&#x60; Note, this is equivalent to the other <code>
     * searchApplicationPages</code> method, but with the query parameters collected into a single Map
     * parameter. This is convenient for services with optional query parameters, especially when used
     * with the {@link SearchApplicationPagesQueryParams} class that allows for building up this map
     * in a fluent style.
     *
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:
     *        <ul>
     *        <li>p - index of the page to display (required)
     *        <li>c - maximum number of elements to retrieve (required)
     *        <li>f - can filter on attributes with the format
     *        f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded
     *        string. (optional)
     *        <li>o - can order on attributes (optional)
     *        <li>s - can search on attributes (optional)
     *        </ul>
     * @return List&lt;ApplicationPage&gt;
     */
    @RequestLine("GET /API/living/application-page?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<ApplicationPage> searchApplicationPages(
            @QueryMap(encoded = true) Map<String, Object> queryParams);

    /**
     * A convenience class for generating query parameters for the <code>searchApplicationPages</code>
     * method in a fluent style.
     */
    public static class SearchApplicationPagesQueryParams extends HashMap<String, Object> {

        public SearchApplicationPagesQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchApplicationPagesQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchApplicationPagesQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }

        public SearchApplicationPagesQueryParams o(final String value) {
            put("o", EncodingUtils.encode(value));
            return this;
        }

        public SearchApplicationPagesQueryParams s(final String value) {
            put("s", EncodingUtils.encode(value));
            return this;
        }
    }
}
