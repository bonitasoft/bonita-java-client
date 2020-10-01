package org.bonitasoft.web.client.internal.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.bonitasoft.web.client.ApiClient;

import java.io.File;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-10-01T10:13:11.246508+02:00[Europe/Paris]")
public interface OrganizationApi extends ApiClient.Api {


    /**
     * Import an organization
     * Import an organization
     *
     * @param organizationDataUpload Uploaded file (optional)
     * @param importPolicy           Import policy (optional)
     */
    @RequestLine("POST /services/organization/import")
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "Accept: text/plain",
    })
    String importOrganization(@Param("organizationDataUpload") String organizationDataUpload, @Param("importPolicy") String importPolicy);

    /**
     * Import an organization
     * Upload organization
     *
     * @param file (optional)
     */
    @RequestLine("POST /portal/organizationUpload")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: text/plain",
    })
    String uploadOrganization(@Param("file") File file);
}
