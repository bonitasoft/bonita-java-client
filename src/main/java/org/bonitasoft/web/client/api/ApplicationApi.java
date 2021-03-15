package org.bonitasoft.web.client.api;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.Application;
import org.bonitasoft.web.client.model.ApplicationUpdateRequest;
import org.bonitasoft.web.client.model.CreateApplicationRequest;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

public interface ApplicationApi extends ApiClient.Api {

    /**
     * Create a living applications Create a living applications
     *
     * @param body Partial living application description (required)
     * @return Application
     */
    @RequestLine("POST /API/living/application")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    Application createApplication(CreateApplicationRequest body);

    /**
     * Delete a living application by ID Delete a single application for the given ID
     *
     * @param id ID of application to delete (required)
     */
    @RequestLine("DELETE /API/living/application/{id}")
    @Headers({
            "Accept: application/json",
    })
    void deleteApplicationById(@Param("id") String id);

    /**
     * Finds a living application by ID Returns a single application for the given ID
     *
     * @param id ID of application to return (required)
     * @return Application
     */
    @RequestLine("GET /API/living/application/{id}")
    @Headers({
            "Accept: application/json",
    })
    Application getApplicationById(@Param("id") String id);

    /**
     * Import a living application Import a single application
     *
     * @param applicationsDataUpload Uploaded file (optional)
     * @param importPolicy Import policy (optional)
     */
    @RequestLine("POST /services/application/import")
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "Accept: application/json",
    })
    void importApplication(
            @Param("applicationsDataUpload") String applicationsDataUpload,
            @Param("importPolicy") String importPolicy);

    /**
     * Finds living applications Finds living applications with pagination params and filters - can
     * order on &#x60;id&#x60;,&#x60;creationDate&#x60;, &#x60;createdBy&#x60;, &#x60;profileId&#x60;,
     * &#x60;token&#x60;, &#x60;displayName&#x60;, &#x60;updatedBy&#x60;, &#x60;lastUpdateDate&#x60;,
     * &#x60;version&#x60; - can search on &#x60;token&#x60;, &#x60;displayName&#x60;,
     * &#x60;version&#x60; - can filter on &#x60;token&#x60;, &#x60;displayName&#x60;,
     * &#x60;version&#x60;, &#x60;profileId&#x60;, &#x60;creationDate&#x60;, &#x60;createdBy&#x60;,
     * &#x60;updatedBy&#x60; , &#x60;lastUpdateDate&#x60;
     *
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value}
     *        with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return List&lt;Application&gt;
     */
    @RequestLine("GET /API/living/application?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<Application> searchApplications(
            @Param("p") Integer p,
            @Param("c") Integer c,
            @Param("f") List<String> f,
            @Param("o") String o,
            @Param("s") String s);

    /**
     * Finds living applications Finds living applications with pagination params and filters - can
     * order on &#x60;id&#x60;,&#x60;creationDate&#x60;, &#x60;createdBy&#x60;, &#x60;profileId&#x60;,
     * &#x60;token&#x60;, &#x60;displayName&#x60;, &#x60;updatedBy&#x60;, &#x60;lastUpdateDate&#x60;,
     * &#x60;version&#x60; - can search on &#x60;token&#x60;, &#x60;displayName&#x60;,
     * &#x60;version&#x60; - can filter on &#x60;token&#x60;, &#x60;displayName&#x60;,
     * &#x60;version&#x60;, &#x60;profileId&#x60;, &#x60;creationDate&#x60;, &#x60;createdBy&#x60;,
     * &#x60;updatedBy&#x60; , &#x60;lastUpdateDate&#x60; Note, this is equivalent to the other <code>
     * searchApplications</code> method, but with the query parameters collected into a single Map
     * parameter. This is convenient for services with optional query parameters, especially when used
     * with the {@link SearchApplicationsQueryParams} class that allows for building up this map in a
     * fluent style.
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
     * @return List&lt;Application&gt;
     */
    @RequestLine("GET /API/living/application?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<Application> searchApplications(@QueryMap(encoded = true) Map<String, Object> queryParams);

    /**
     * A convenience class for generating query parameters for the <code>searchApplications</code>
     * method in a fluent style.
     */
    public static class SearchApplicationsQueryParams extends HashMap<String, Object> {

        public SearchApplicationsQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchApplicationsQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchApplicationsQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }

        public SearchApplicationsQueryParams o(final String value) {
            put("o", EncodingUtils.encode(value));
            return this;
        }

        public SearchApplicationsQueryParams s(final String value) {
            put("s", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Update a living application by ID Update a single application for the given ID
     *
     * @param id ID of application to return (required)
     * @param applicationUpdateRequest Partial living application description (required)
     * @return Application
     */
    @RequestLine("PUT /API/living/application/{id}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    Application updateApplicationById(
            @Param("id") String id, ApplicationUpdateRequest applicationUpdateRequest);

    /**
     * Upload a living application Upload application
     *
     * @param file (optional)
     * @return String
     */
    @RequestLine("POST /portal/applicationsUpload")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json",
    })
    String uploadApplication(@Param("file") File file);

    /**
     * Upload an application configuration file
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Upload an application
     * configuration file in the &#x60;bconf&#x60; format.
     *
     * @param configuration (required)
     * @return String
     */
    @RequestLine("POST /APIv2/service/install")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json",
    })
    String uploadApplicationConfiguration(@Param("configuration") File configuration);
}
