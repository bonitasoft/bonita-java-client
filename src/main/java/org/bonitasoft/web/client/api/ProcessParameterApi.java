package org.bonitasoft.web.client.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.EncodingUtils;
import org.bonitasoft.web.client.model.ProcessParameter;
import org.bonitasoft.web.client.model.ProcessParameterUpdateRequest;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ProcessParameterApi extends ApiClient.Api {

    /**
     * Finds the ProcessParameter by ID Returns the single ProcessParameter for the given ID
     *
     * @param id ID of the process to get parameter from (required)
     * @param name Name of the process parameter to return (required)
     * @return ProcessParameter
     */
    @RequestLine("GET /API/bpm/processParameter/{id}/{name}")
    @Headers({
            "Accept: application/json",
    })
    ProcessParameter getProcessParameterById(@Param("id") String id, @Param("name") String name);

    /**
     * Finds ProcessParameters Finds ProcessParameters with pagination params and filters.
     *
     * @param p index of the page to display (required)
     * @param c maximum number of elements to retrieve (required)
     * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value}
     *        with the name/value pair as url encoded string. (optional)
     * @param o can order on attributes (optional)
     * @param s can search on attributes (optional)
     * @return List&lt;ProcessParameter&gt;
     */
    @RequestLine("GET /API/bpm/processParameter?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<ProcessParameter> searchProcessParameters(
            @Param("p") Integer p,
            @Param("c") Integer c,
            @Param("f") List<String> f,
            @Param("o") String o,
            @Param("s") String s);

    /**
     * Finds ProcessParameters Finds ProcessParameters with pagination params and filters. Note, this
     * is equivalent to the other <code>searchProcessParameters</code> method, but with the query
     * parameters collected into a single Map parameter. This is convenient for services with optional
     * query parameters, especially when used with the {@link SearchProcessParametersQueryParams}
     * class that allows for building up this map in a fluent style.
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
     * @return List&lt;ProcessParameter&gt;
     */
    @RequestLine("GET /API/bpm/processParameter?p={p}&c={c}&f={f}&o={o}&s={s}")
    @Headers({
            "Accept: application/json",
    })
    List<ProcessParameter> searchProcessParameters(
            @QueryMap(encoded = true) Map<String, Object> queryParams);

    /**
     * A convenience class for generating query parameters for the <code>searchProcessParameters
     * </code> method in a fluent style.
     */
    public static class SearchProcessParametersQueryParams extends HashMap<String, Object> {

        public SearchProcessParametersQueryParams p(final Integer value) {
            put("p", EncodingUtils.encode(value));
            return this;
        }

        public SearchProcessParametersQueryParams c(final Integer value) {
            put("c", EncodingUtils.encode(value));
            return this;
        }

        public SearchProcessParametersQueryParams f(final List<String> value) {
            put("f", EncodingUtils.encodeCollection(value, "multi"));
            return this;
        }

        public SearchProcessParametersQueryParams o(final String value) {
            put("o", EncodingUtils.encode(value));
            return this;
        }

        public SearchProcessParametersQueryParams s(final String value) {
            put("s", EncodingUtils.encode(value));
            return this;
        }
    }

    /**
     * Update the ProcessParameter by ID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Update the ProcessParameter
     * for the given ID
     *
     * @param id ID of the process to get parameter from (required)
     * @param name Name of the process parameter to return (required)
     * @param processParameterUpdateRequest You can update only a process parameter value using the
     *        API. If you specify values for other fields in the update request, they are ignored.
     *        (required)
     */
    @RequestLine("PUT /API/bpm/processParameter/{id}/{name}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void updateProcessParameterById(
            @Param("id") String id,
            @Param("name") String name,
            ProcessParameterUpdateRequest processParameterUpdateRequest);
}
