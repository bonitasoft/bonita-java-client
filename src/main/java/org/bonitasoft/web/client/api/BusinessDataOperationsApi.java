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
import java.math.BigDecimal;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.ApiResponse;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public interface BusinessDataOperationsApi extends ApiClient.Api {

    /**
     * Delete an existing Business Data
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Delete an existing Business Data.
     * 
     * @param businessDataType The Business Data type to delete (required)
     * @param persistenceId Business data ID to delete (required)
     */
    @RequestLine("DELETE /API/bdm/businessData/{businessDataType}/{persistenceId}")
    @Headers({
            "Accept: application/json",
    })
    void deleteBusinessData(@Param("businessDataType") String businessDataType,
            @Param("persistenceId") BigDecimal persistenceId);

    /**
     * Delete an existing Business Data
     * Similar to <code>deleteBusinessData</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Delete an existing Business Data.
     * 
     * @param businessDataType The Business Data type to delete (required)
     * @param persistenceId Business data ID to delete (required)
     */
    @RequestLine("DELETE /API/bdm/businessData/{businessDataType}/{persistenceId}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<Void> deleteBusinessDataWithHttpInfo(@Param("businessDataType") String businessDataType,
            @Param("persistenceId") BigDecimal persistenceId);

    /**
     * Import Business Data by bulk
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Allows to import business data in bulk by uploading a file containing the data, in CSV
     * format. Example CSV file content: &#x60;&#x60;&#x60;csv firstName,lastName,department, dptReference
     * \&quot;John\&quot;,\&quot;Doe\&quot;,\&quot;Engineering\&quot;, 14 \&quot;Jane\&quot;,\&quot;Smith\&quot;, \&quot;Marketing\&quot;, 17 &#x60;&#x60;&#x60;
     * Field separator can be comma (&#x60;,&#x60;) or semicolon (&#x60;;&#x60;). Space characters around the separator will be ignored (trimmed). The first line of
     * the CSV file is considered as the header, and must contain the field names, with the exact same upper/lower case. String Fields must be enclosed in double
     * quotes (&#x60;\&quot;&#x60;), numeric / boolean fields must not.
     * 
     * @param businessDataType Business Data Type (required)
     * @param dataset (optional)
     * @return Object
     */
    @RequestLine("POST /API/bdm/businessData/{businessDataType}/import")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json",
    })
    Object importBusinessData(@Param("businessDataType") String businessDataType, @Param("dataset") File dataset);

    /**
     * Import Business Data by bulk
     * Similar to <code>importBusinessData</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Allows to import business data in bulk by uploading a file containing the data, in CSV
     * format. Example CSV file content: &#x60;&#x60;&#x60;csv firstName,lastName,department, dptReference
     * \&quot;John\&quot;,\&quot;Doe\&quot;,\&quot;Engineering\&quot;, 14 \&quot;Jane\&quot;,\&quot;Smith\&quot;, \&quot;Marketing\&quot;, 17 &#x60;&#x60;&#x60;
     * Field separator can be comma (&#x60;,&#x60;) or semicolon (&#x60;;&#x60;). Space characters around the separator will be ignored (trimmed). The first line of
     * the CSV file is considered as the header, and must contain the field names, with the exact same upper/lower case. String Fields must be enclosed in double
     * quotes (&#x60;\&quot;&#x60;), numeric / boolean fields must not.
     * 
     * @param businessDataType Business Data Type (required)
     * @param dataset (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("POST /API/bdm/businessData/{businessDataType}/import")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json",
    })
    ApiResponse<Object> importBusinessDataWithHttpInfo(@Param("businessDataType") String businessDataType,
            @Param("dataset") File dataset);

    /**
     * Create new Business Data
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Create (Insert) new Business Data. Obviously, all mandatory fields of the given business
     * data type must be provided in the request body, to ensure data integrity. Any input fields that are NOT part of the business data type will be simply
     * ignored, and returned in the response, as an informative list.
     * 
     * @param businessDataType The Business Data type to create (required)
     * @param body The flat JSON object representing the business data to create. The fields to provide depends on the business data type. (required)
     * @return Object
     */
    @RequestLine("POST /API/bdm/businessData/{businessDataType}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    Object insertBusinessData(@Param("businessDataType") String businessDataType, Object body);

    /**
     * Create new Business Data
     * Similar to <code>insertBusinessData</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Create (Insert) new Business Data. Obviously, all mandatory fields of the given business
     * data type must be provided in the request body, to ensure data integrity. Any input fields that are NOT part of the business data type will be simply
     * ignored, and returned in the response, as an informative list.
     * 
     * @param businessDataType The Business Data type to create (required)
     * @param body The flat JSON object representing the business data to create. The fields to provide depends on the business data type. (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("POST /API/bdm/businessData/{businessDataType}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<Object> insertBusinessDataWithHttpInfo(@Param("businessDataType") String businessDataType, Object body);

    /**
     * Update an existing Business Data
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Update an existing Business Data. Any input fields that are NOT part of the business data
     * type will be simply ignored, and returned in the response, as an informative list.
     * 
     * @param businessDataType The Business Data type to update (required)
     * @param persistenceId Business data ID (required)
     * @param body The flat JSON object representing the fields of the business data to update. The fields to provide depends on the business data type. Any field
     *        not provided will be left unchanged. (required)
     * @return Object
     */
    @RequestLine("PUT /API/bdm/businessData/{businessDataType}/{persistenceId}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    Object updateBusinessData(@Param("businessDataType") String businessDataType,
            @Param("persistenceId") BigDecimal persistenceId, Object body);

    /**
     * Update an existing Business Data
     * Similar to <code>updateBusinessData</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Update an existing Business Data. Any input fields that are NOT part of the business data
     * type will be simply ignored, and returned in the response, as an informative list.
     * 
     * @param businessDataType The Business Data type to update (required)
     * @param persistenceId Business data ID (required)
     * @param body The flat JSON object representing the fields of the business data to update. The fields to provide depends on the business data type. Any field
     *        not provided will be left unchanged. (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("PUT /API/bdm/businessData/{businessDataType}/{persistenceId}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<Object> updateBusinessDataWithHttpInfo(@Param("businessDataType") String businessDataType,
            @Param("persistenceId") BigDecimal persistenceId, Object body);

}
