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

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.ApiResponse;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public interface OrganizationApi extends ApiClient.Api {

    /**
     * Import an organization
     * Import an organization
     * 
     * @param organizationDataUpload Uploaded file (optional)
     * @param importPolicy Import policy (optional)
     */
    @RequestLine("POST /services/organization/import")
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "Accept: application/json",
    })
    void importOrganization(@Param("organizationDataUpload") String organizationDataUpload,
            @Param("importPolicy") String importPolicy);

    /**
     * Import an organization
     * Similar to <code>importOrganization</code> but it also returns the http response headers .
     * Import an organization
     * 
     * @param organizationDataUpload Uploaded file (optional)
     * @param importPolicy Import policy (optional)
     */
    @RequestLine("POST /services/organization/import")
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "Accept: application/json",
    })
    ApiResponse<Void> importOrganizationWithHttpInfo(@Param("organizationDataUpload") String organizationDataUpload,
            @Param("importPolicy") String importPolicy);

    /**
     * Import an organization
     * Upload organization
     * 
     * @param file (optional)
     * @return String
     */
    @RequestLine("POST /portal/organizationUpload")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json,text/plain",
    })
    String uploadOrganization(@Param("file") File file);

    /**
     * Import an organization
     * Similar to <code>uploadOrganization</code> but it also returns the http response headers .
     * Upload organization
     * 
     * @param file (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("POST /portal/organizationUpload")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json,text/plain",
    })
    ApiResponse<String> uploadOrganizationWithHttpInfo(@Param("file") File file);

}
