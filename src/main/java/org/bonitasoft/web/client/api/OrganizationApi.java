package org.bonitasoft.web.client.api;

import java.io.File;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.ApiResponse;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface OrganizationApi extends ApiClient.Api {


  /**
   * Import an organization
   * Import an organization 
   * @param organizationDataUpload Uploaded file (optional)
   * @param importPolicy Import policy (optional)
   */
  @RequestLine("POST /services/organization/import")
  @Headers({
    "Content-Type: application/x-www-form-urlencoded",
    "Accept: application/json",
  })
  void importOrganization(@Param("organizationDataUpload") String organizationDataUpload, @Param("importPolicy") String importPolicy);

  /**
   * Import an organization
   * Similar to <code>importOrganization</code> but it also returns the http response headers .
   * Import an organization 
   * @param organizationDataUpload Uploaded file (optional)
   * @param importPolicy Import policy (optional)
   */
  @RequestLine("POST /services/organization/import")
  @Headers({
    "Content-Type: application/x-www-form-urlencoded",
    "Accept: application/json",
  })
  ApiResponse<Void> importOrganizationWithHttpInfo(@Param("organizationDataUpload") String organizationDataUpload, @Param("importPolicy") String importPolicy);



  /**
   * Import an organization
   * Upload organization 
   * @param file  (optional)
   * @return String
   */
  @RequestLine("POST /portal/organizationUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  String uploadOrganization(@Param("file") File file);

  /**
   * Import an organization
   * Similar to <code>uploadOrganization</code> but it also returns the http response headers .
   * Upload organization 
   * @param file  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /portal/organizationUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  ApiResponse<String> uploadOrganizationWithHttpInfo(@Param("file") File file);


}
