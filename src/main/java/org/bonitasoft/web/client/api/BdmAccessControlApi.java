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
import org.bonitasoft.web.client.model.BDMAccessControl;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public interface BdmAccessControlApi extends ApiClient.Api {

    /**
     * Delete the BDM Access Control
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Delete the BDM access control
     */
    @RequestLine("DELETE /API/accessControl/bdm")
    @Headers({
            "Accept: application/json",
    })
    void deleteBDMAccessControl();

    /**
     * Delete the BDM Access Control
     * Similar to <code>deleteBDMAccessControl</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Delete the BDM access control
     */
    @RequestLine("DELETE /API/accessControl/bdm")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<Void> deleteBDMAccessControlWithHttpInfo();

    /**
     * BDM access control status
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Get the BDM access control status.
     * 
     * @return BDMAccessControl
     */
    @RequestLine("GET /API/accessControl/bdm")
    @Headers({
            "Accept: application/json",
    })
    BDMAccessControl getBDMAccessControlStatus();

    /**
     * BDM access control status
     * Similar to <code>getBDMAccessControlStatus</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Get the BDM access control status.
     * 
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/accessControl/bdm")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<BDMAccessControl> getBDMAccessControlStatusWithHttpInfo();

    /**
     * Import a BDM Access Control
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Import a BDM Access Control Warning: as of 9.0.0, importing a BDM Access Control using this
     * service is deprecated.
     * 
     * @param bdmAccessControlUpload The temporary name of the previously uploaded file to install (optional)
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /services/bdmAccessControl/install")
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "Accept: application/json",
    })
    void importBDMAccessControl(@Param("bdmAccessControlUpload") String bdmAccessControlUpload);

    /**
     * Import a BDM Access Control
     * Similar to <code>importBDMAccessControl</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Import a BDM Access Control Warning: as of 9.0.0, importing a BDM Access Control using this
     * service is deprecated.
     * 
     * @param bdmAccessControlUpload The temporary name of the previously uploaded file to install (optional)
     * @deprecated
     */
    @Deprecated
    @RequestLine("POST /services/bdmAccessControl/install")
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "Accept: application/json",
    })
    ApiResponse<Void> importBDMAccessControlWithHttpInfo(
            @Param("bdmAccessControlUpload") String bdmAccessControlUpload);

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

}
