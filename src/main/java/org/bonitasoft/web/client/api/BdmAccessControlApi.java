package org.bonitasoft.web.client.api;

import java.io.File;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.BDMAccessControl;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface BdmAccessControlApi extends ApiClient.Api {

    /**
     * Delete the BDM Access Control ![edition](https://img.shields.io/badge/edition-entreprise-blue)
     * Delete the BDM access control
     */
    @RequestLine("DELETE /API/accessControl/bdm")
    @Headers({
            "Accept: application/json",
    })
    void deleteBDMAccessControl();

    /**
     * BDM access control status ![edition](https://img.shields.io/badge/edition-entreprise-blue) Get
     * the BDM access control status.
     *
     * @return BDMAccessControl
     */
    @RequestLine("GET /API/accessControl/bdm")
    @Headers({
            "Accept: application/json",
    })
    BDMAccessControl getBDMAccessControlStatus();

    /**
     * Import a BDM Access Control ![edition](https://img.shields.io/badge/edition-entreprise-blue)
     * Import a BDM Access Control
     *
     * @param bdmAccessControlUpload The temporary name of the previously uploaded file to install
     *        (optional)
     */
    @RequestLine("POST /services/bdmAccessControl/install")
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "Accept: application/json",
    })
    void importBDMAccessControl(@Param("bdmAccessControlUpload") String bdmAccessControlUpload);

    /**
     * Upload a BDM Access Control ![edition](https://img.shields.io/badge/edition-entreprise-blue)
     * Upload BDM Access Control
     *
     * @param file (optional)
     * @return String
     */
    @RequestLine("POST /portal/bdmAccessControlUpload")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json",
    })
    String uploadBDMAccessControl(@Param("file") File file);
}
