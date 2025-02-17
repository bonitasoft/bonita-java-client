/** 
 * Copyright (C) 2025 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.bonitasoft.web.client.api;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.Application;
import org.bonitasoft.web.client.model.ApplicationUpdateRequest;
import org.bonitasoft.web.client.model.CreateApplicationRequest;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.8.0")
public interface ApplicationApi extends ApiClient.Api {

    /**
     * Create a living application
     * Create a living application (legacy application or application link). Warning: as of 9.0.0, creating a living application using this API is deprecated.
     * 
     * @param body Partial living application description (required)
     * @return Application
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /API/living/application")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    Application createApplication(CreateApplicationRequest body);

    /**
     * Create a living application
     * Similar to <code>createApplication</code> but it also returns the http response headers .
     * Create a living application (legacy application or application link). Warning: as of 9.0.0, creating a living application using this API is deprecated.
     * 
     * @param body Partial living application description (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /API/living/application")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<Application> createApplicationWithHttpInfo(CreateApplicationRequest body);

    /**
     * Delete a living application by ID
     * Delete a single application for the given ID
     * 
     * @param id ID of application to delete (required)
     */
    @RequestLine("DELETE /API/living/application/{id}")
    @Headers({
            "Accept: application/json",
    })
    void deleteApplicationById(@Param("id") String id);

    /**
     * Delete a living application by ID
     * Similar to <code>deleteApplicationById</code> but it also returns the http response headers .
     * Delete a single application for the given ID
     * 
     * @param id ID of application to delete (required)
     */
    @RequestLine("DELETE /API/living/application/{id}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<Void> deleteApplicationByIdWithHttpInfo(@Param("id") String id);

    /**
     * Finds a living application by ID
     * Returns a single application for the given ID
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
     * Finds a living application by ID
     * Similar to <code>getApplicationById</code> but it also returns the http response headers .
     * Returns a single application for the given ID
     * 
     * @param id ID of application to return (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/living/application/{id}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<Application> getApplicationByIdWithHttpInfo(@Param("id") String id);

    /**
     * Import a living application
     * Import a single application Warning: as of 9.0.0, importing a living application using this service is deprecated.
     * 
     * @param applicationsDataUpload Uploaded file (optional)
     * @param importPolicy Import policy (optional)
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /services/application/import")
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "Accept: application/json",
    })
    void importApplication(@Param("applicationsDataUpload") String applicationsDataUpload,
            @Param("importPolicy") String importPolicy);

    /**
     * Import a living application
     * Similar to <code>importApplication</code> but it also returns the http response headers .
     * Import a single application Warning: as of 9.0.0, importing a living application using this service is deprecated.
     * 
     * @param applicationsDataUpload Uploaded file (optional)
     * @param importPolicy Import policy (optional)
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /services/application/import")
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "Accept: application/json",
    })
    ApiResponse<Void> importApplicationWithHttpInfo(@Param("applicationsDataUpload") String applicationsDataUpload,
            @Param("importPolicy") String importPolicy);

    /**
     * Finds living applications
     * Finds living applications with pagination params and filters - can order on &#x60;id&#x60;,&#x60;creationDate&#x60;, &#x60;createdBy&#x60;,
     * &#x60;profileId&#x60;, &#x60;token&#x60;, &#x60;displayName&#x60;, &#x60;updatedBy&#x60;, &#x60;lastUpdateDate&#x60;, &#x60;version&#x60;, &#x60;link&#x60; -
     * can search on &#x60;token&#x60;, &#x60;displayName&#x60;, &#x60;version&#x60;, &#x60;link&#x60; - can filter on &#x60;token&#x60;, &#x60;displayName&#x60;,
     * &#x60;version&#x60;, &#x60;link&#x60;, &#x60;profileId&#x60;, &#x60;creationDate&#x60;, &#x60;createdBy&#x60;, &#x60;updatedBy&#x60; ,
     * &#x60;lastUpdateDate&#x60;, &#x60;userId&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return List&lt;Application&gt;
     */
    @RequestLine("GET /API/living/application?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<Application> searchApplications(@Param("p") Integer p, @Param("c") Integer c, @Param("f") List<String> f,
            @Param("o") String o, @Param("s") String s);

    /**
     * Finds living applications
     * Similar to <code>searchApplications</code> but it also returns the http response headers .
     * Finds living applications with pagination params and filters - can order on &#x60;id&#x60;,&#x60;creationDate&#x60;, &#x60;createdBy&#x60;,
     * &#x60;profileId&#x60;, &#x60;token&#x60;, &#x60;displayName&#x60;, &#x60;updatedBy&#x60;, &#x60;lastUpdateDate&#x60;, &#x60;version&#x60;, &#x60;link&#x60; -
     * can search on &#x60;token&#x60;, &#x60;displayName&#x60;, &#x60;version&#x60;, &#x60;link&#x60; - can filter on &#x60;token&#x60;, &#x60;displayName&#x60;,
     * &#x60;version&#x60;, &#x60;link&#x60;, &#x60;profileId&#x60;, &#x60;creationDate&#x60;, &#x60;createdBy&#x60;, &#x60;updatedBy&#x60; ,
     * &#x60;lastUpdateDate&#x60;, &#x60;userId&#x60;
     * 
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/living/application?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<Application>> searchApplicationsWithHttpInfo(@Param("p") Integer p, @Param("c") Integer c,
            @Param("f") List<String> f, @Param("o") String o, @Param("s") String s);

    /**
     * Finds living applications
     * Finds living applications with pagination params and filters - can order on &#x60;id&#x60;,&#x60;creationDate&#x60;, &#x60;createdBy&#x60;,
     * &#x60;profileId&#x60;, &#x60;token&#x60;, &#x60;displayName&#x60;, &#x60;updatedBy&#x60;, &#x60;lastUpdateDate&#x60;, &#x60;version&#x60;, &#x60;link&#x60; -
     * can search on &#x60;token&#x60;, &#x60;displayName&#x60;, &#x60;version&#x60;, &#x60;link&#x60; - can filter on &#x60;token&#x60;, &#x60;displayName&#x60;,
     * &#x60;version&#x60;, &#x60;link&#x60;, &#x60;profileId&#x60;, &#x60;creationDate&#x60;, &#x60;createdBy&#x60;, &#x60;updatedBy&#x60; ,
     * &#x60;lastUpdateDate&#x60;, &#x60;userId&#x60;
     * Note, this is equivalent to the other <code>searchApplications</code> method,
     * but with the query parameters collected into a single Map parameter. This
     * is convenient for services with optional query parameters, especially when
     * used with the {@link SearchApplicationsQueryParams} class that allows for
     * building up this map in a fluent style.
     * 
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>p - index of the page to display (required)</li>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string.
     *        (optional)</li>
     *        <li>o - can order on attributes (optional)</li>
     *        <li>s - can search on attributes (optional)</li>
     *        </ul>
     * @return List&lt;Application&gt;
     */
    @RequestLine("GET /API/living/application?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<Application> searchApplications(@QueryMap(encoded = true) SearchApplicationsQueryParams queryParams);

    /**
     * Finds living applications
     * Finds living applications with pagination params and filters - can order on &#x60;id&#x60;,&#x60;creationDate&#x60;, &#x60;createdBy&#x60;,
     * &#x60;profileId&#x60;, &#x60;token&#x60;, &#x60;displayName&#x60;, &#x60;updatedBy&#x60;, &#x60;lastUpdateDate&#x60;, &#x60;version&#x60;, &#x60;link&#x60; -
     * can search on &#x60;token&#x60;, &#x60;displayName&#x60;, &#x60;version&#x60;, &#x60;link&#x60; - can filter on &#x60;token&#x60;, &#x60;displayName&#x60;,
     * &#x60;version&#x60;, &#x60;link&#x60;, &#x60;profileId&#x60;, &#x60;creationDate&#x60;, &#x60;createdBy&#x60;, &#x60;updatedBy&#x60; ,
     * &#x60;lastUpdateDate&#x60;, &#x60;userId&#x60;
     * Note, this is equivalent to the other <code>searchApplications</code> that receives the query parameters as a map,
     * but this one also exposes the Http response headers
     * 
     * @param queryParams Map of query parameters as name-value pairs
     *        <p>The following elements may be specified in the query map:</p>
     *        <ul>
     *        <li>p - index of the page to display (required)</li>
     *        <li>c - maximum number of elements to retrieve (required)</li>
     *        <li>f - can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string.
     *        (optional)</li>
     *        <li>o - can order on attributes (optional)</li>
     *        <li>s - can search on attributes (optional)</li>
     *        </ul>
     * @return List&lt;Application&gt;
     */
    @RequestLine("GET /API/living/application?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<List<Application>> searchApplicationsWithHttpInfo(
            @QueryMap(encoded = true) SearchApplicationsQueryParams queryParams);

    /**
     * A convenience class for generating query parameters for the
     * <code>searchApplications</code> method in a fluent style.
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
     * Update a living application by ID
     * Update a single application for the given ID (legacy application or application link). Warning: as of 9.0.0, updating a living application using this API is
     * deprecated.
     * 
     * @param id ID of application to return (required)
     * @param applicationUpdateRequest Partial living application description (required)
     * @return Application
     * @deprecated
     */
    @Deprecated
    @RequestLine("PUT /API/living/application/{id}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    Application updateApplicationById(@Param("id") String id, ApplicationUpdateRequest applicationUpdateRequest);

    /**
     * Update a living application by ID
     * Similar to <code>updateApplicationById</code> but it also returns the http response headers .
     * Update a single application for the given ID (legacy application or application link). Warning: as of 9.0.0, updating a living application using this API is
     * deprecated.
     * 
     * @param id ID of application to return (required)
     * @param applicationUpdateRequest Partial living application description (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     * @deprecated
     */
    @Deprecated
    @RequestLine("PUT /API/living/application/{id}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<Application> updateApplicationByIdWithHttpInfo(@Param("id") String id,
            ApplicationUpdateRequest applicationUpdateRequest);

    /**
     * Upload a living application
     * Upload application Warning: as of 9.0.0, uploading a living application using the portal is deprecated.
     * 
     * @param file (optional)
     * @return String
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /portal/applicationsUpload")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json,text/plain",
    })
    String uploadApplication(@Param("file") File file);

    /**
     * Upload a living application
     * Similar to <code>uploadApplication</code> but it also returns the http response headers .
     * Upload application Warning: as of 9.0.0, uploading a living application using the portal is deprecated.
     * 
     * @param file (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /portal/applicationsUpload")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json,text/plain",
    })
    ApiResponse<String> uploadApplicationWithHttpInfo(@Param("file") File file);

    /**
     * Upload an application configuration file
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Upload an application configuration file in the &#x60;bconf&#x60; format. Warning: as of
     * 9.0.0, uploading an application configuration file using this API is deprecated.
     * 
     * @param _configuration (required)
     * @return String
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /APIv2/service/install")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json,text/plain",
    })
    String uploadApplicationConfiguration(@Param("configuration") File _configuration);

    /**
     * Upload an application configuration file
     * Similar to <code>uploadApplicationConfiguration</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Upload an application configuration file in the &#x60;bconf&#x60; format. Warning: as of
     * 9.0.0, uploading an application configuration file using this API is deprecated.
     * 
     * @param _configuration (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /APIv2/service/install")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json,text/plain",
    })
    ApiResponse<String> uploadApplicationConfigurationWithHttpInfo(@Param("configuration") File _configuration);

}
