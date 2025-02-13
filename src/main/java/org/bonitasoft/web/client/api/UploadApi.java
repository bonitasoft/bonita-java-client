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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.8.0")
public interface UploadApi extends ApiClient.Api {

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
     * Upload a BDM Access Control
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Upload BDM Access Control Warning: as of 9.0.0, uploading a BDM Access Control using the
     * portal is deprecated.
     * 
     * @param file (optional)
     * @return String
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /portal/bdmAccessControlUpload")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json,text/plain",
    })
    String uploadBDMAccessControl(@Param("file") File file);

    /**
     * Upload a BDM Access Control
     * Similar to <code>uploadBDMAccessControl</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Upload BDM Access Control Warning: as of 9.0.0, uploading a BDM Access Control using the
     * portal is deprecated.
     * 
     * @param file (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /portal/bdmAccessControlUpload")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json,text/plain",
    })
    ApiResponse<String> uploadBDMAccessControlWithHttpInfo(@Param("file") File file);

    /**
     * Upload a file
     * Upload file. **NOTE:** If this file is a BDM zip, to do this, your tenant services need to be paused. In Enterprise editions, if you have an access control
     * file installed on your tenant, you need to delete it before installing or updating your BDM.
     * 
     * @param file (optional)
     * @return String
     */
    @RequestLine("POST /portal/fileUpload")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json,text/plain",
    })
    String uploadFile(@Param("file") File file);

    /**
     * Upload a file
     * Similar to <code>uploadFile</code> but it also returns the http response headers .
     * Upload file. **NOTE:** If this file is a BDM zip, to do this, your tenant services need to be paused. In Enterprise editions, if you have an access control
     * file installed on your tenant, you need to delete it before installing or updating your BDM.
     * 
     * @param file (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("POST /portal/fileUpload")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json,text/plain",
    })
    ApiResponse<String> uploadFileWithHttpInfo(@Param("file") File file);

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

    /**
     * Upload a Page
     * Upload Page Warning: as of 9.0.0, uploading a page using the portal is deprecated.
     * 
     * @param file (optional)
     * @return String
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /portal/pageUpload")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json,text/plain",
    })
    String uploadPage(@Param("file") File file);

    /**
     * Upload a Page
     * Similar to <code>uploadPage</code> but it also returns the http response headers .
     * Upload Page Warning: as of 9.0.0, uploading a page using the portal is deprecated.
     * 
     * @param file (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /portal/pageUpload")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json,text/plain",
    })
    ApiResponse<String> uploadPageWithHttpInfo(@Param("file") File file);

    /**
     * Upload a bar file
     * Upload a bar file Warning: as of 9.0.0, uploading a bar file using the portal is deprecated.
     * 
     * @param file (optional)
     * @return String
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /portal/processUpload")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json,text/plain",
    })
    String uploadProcess(@Param("file") File file);

    /**
     * Upload a bar file
     * Similar to <code>uploadProcess</code> but it also returns the http response headers .
     * Upload a bar file Warning: as of 9.0.0, uploading a bar file using the portal is deprecated.
     * 
     * @param file (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /portal/processUpload")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json,text/plain",
    })
    ApiResponse<String> uploadProcessWithHttpInfo(@Param("file") File file);

    /**
     * Upload profiles
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Upload profiles Warning: as of 9.0.0, uploading profiles using the portal is deprecated.
     * 
     * @param file (optional)
     * @return String
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /portal/profilesUpload")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json,text/plain",
    })
    String uploadprofiles(@Param("file") File file);

    /**
     * Upload profiles
     * Similar to <code>uploadprofiles</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Upload profiles Warning: as of 9.0.0, uploading profiles using the portal is deprecated.
     * 
     * @param file (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /portal/profilesUpload")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json,text/plain",
    })
    ApiResponse<String> uploadprofilesWithHttpInfo(@Param("file") File file);

}
