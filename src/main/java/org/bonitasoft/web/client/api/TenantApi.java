package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.Tenant;
import org.bonitasoft.web.client.model.TenantCreateRequest;
import org.bonitasoft.web.client.model.TenantUpdateRequest;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface TenantApi extends ApiClient.Api {

    /**
     * Create the Tenant ![edition](https://img.shields.io/badge/edition-entreprise-blue) Create the
     * Tenant
     *
     * @param body Partial Tenant description (required)
     * @return Tenant
     */
    @RequestLine("POST /API/platform/tenant")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    Tenant createTenant(TenantCreateRequest body);

    /**
     * Delete the Tenant by ID ![edition](https://img.shields.io/badge/edition-entreprise-blue) Delete
     * the single Tenant for the given ID
     *
     * @param id ID of the Tenant to delete (required)
     */
    @RequestLine("DELETE /API/platform/tenant/{id}")
    @Headers({
            "Accept: application/json",
    })
    void deleteTenantById(@Param("id") String id);

    /**
     * Finds the Tenant by ID ![edition](https://img.shields.io/badge/edition-entreprise-blue) Returns
     * the single Tenant for the given ID
     *
     * @param id ID of the Tenant to return (required)
     * @return Tenant
     */
    @RequestLine("GET /API/platform/tenant/{id}")
    @Headers({
            "Accept: application/json",
    })
    Tenant getTenantById(@Param("id") String id);

    /**
     * Finds Tenants ![edition](https://img.shields.io/badge/edition-entreprise-blue) Finds Tenants
     * with pagination params and filters - can order on &#x60;id&#x60; - can search on
     * &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60;
     *
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value}
     *        with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return List&lt;Tenant&gt;
     */
    @RequestLine("GET /API/platform/tenant?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<Tenant> searchTenants(
            @Param("p") Integer p,
            @Param("c") Integer c,
            @Param("f") List<String> f,
            @Param("o") String o,
            @Param("s") String s);

    /**
     * Finds Tenants ![edition](https://img.shields.io/badge/edition-entreprise-blue) Finds Tenants
     * with pagination params and filters - can order on &#x60;id&#x60; - can search on
     * &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60; Note, this is equivalent to the
     * other <code>searchTenants</code> method, but with the query parameters collected into a single
     * Map parameter. This is convenient for services with optional query parameters, especially when
     * used with the {@link SearchTenantsQueryParams} class that allows for building up this map in a
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
     * @return List&lt;Tenant&gt;
     */
    @RequestLine("GET /API/platform/tenant?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<Tenant> searchTenants(@QueryMap(encoded = true) Map<String, Object> queryParams);

    /**
     * A convenience class for generating query parameters for the <code>searchTenants</code> method
     * in a fluent style.
     */
    public static class SearchTenantsQueryParams extends HashMap<String, Object> {

        public SearchTenantsQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchTenantsQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchTenantsQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }

        public SearchTenantsQueryParams o(final String value) {
            put("o", EncodingUtils.encode(value));
            return this;
        }

        public SearchTenantsQueryParams s(final String value) {
            put("s", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Update the Tenant by ID ![edition](https://img.shields.io/badge/edition-entreprise-blue) Update
     * the Tenant for the given ID
     *
     * @param id ID of the Tenant to return (required)
     * @param tenantUpdateRequest Partial Tenant description (required)
     */
    @RequestLine("PUT /API/platform/tenant/{id}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void updateTenantById(@Param("id") String id, TenantUpdateRequest tenantUpdateRequest);
}
