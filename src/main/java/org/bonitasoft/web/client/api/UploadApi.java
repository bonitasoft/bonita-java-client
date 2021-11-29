package org.bonitasoft.web.client.api;

import java.io.File;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.ApiResponse;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface UploadApi extends ApiClient.Api {


  /**
   * Upload a living application
   * Upload application 
   * @param file  (optional)
   * @return String
   */
  @RequestLine("POST /portal/applicationsUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  String uploadApplication(@Param("file") File file);

  /**
   * Upload a living application
   * Similar to <code>uploadApplication</code> but it also returns the http response headers .
   * Upload application 
   * @param file  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /portal/applicationsUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  ApiResponse<String> uploadApplicationWithHttpInfo(@Param("file") File file);



  /**
   * Upload a BDM Access Control
   * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Upload BDM Access Control 
   * @param file  (optional)
   * @return String
   */
  @RequestLine("POST /portal/bdmAccessControlUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  String uploadBDMAccessControl(@Param("file") File file);

  /**
   * Upload a BDM Access Control
   * Similar to <code>uploadBDMAccessControl</code> but it also returns the http response headers .
   * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Upload BDM Access Control 
   * @param file  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /portal/bdmAccessControlUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  ApiResponse<String> uploadBDMAccessControlWithHttpInfo(@Param("file") File file);



  /**
   * Upload a file
   * Upload file.  **NOTE:** If this file is a BDM zip, to do this, your tenant services need to be paused. In Enterprise editions, if you have an access control file installed on your tenant, you need to delete it before installing or updating your BDM. 
   * @param file  (optional)
   * @return String
   */
  @RequestLine("POST /portal/fileUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  String uploadFile(@Param("file") File file);

  /**
   * Upload a file
   * Similar to <code>uploadFile</code> but it also returns the http response headers .
   * Upload file.  **NOTE:** If this file is a BDM zip, to do this, your tenant services need to be paused. In Enterprise editions, if you have an access control file installed on your tenant, you need to delete it before installing or updating your BDM. 
   * @param file  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /portal/fileUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  ApiResponse<String> uploadFileWithHttpInfo(@Param("file") File file);



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



  /**
   * Upload a Page
   * Upload Page 
   * @param file  (optional)
   * @return String
   */
  @RequestLine("POST /portal/pageUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  String uploadPage(@Param("file") File file);

  /**
   * Upload a Page
   * Similar to <code>uploadPage</code> but it also returns the http response headers .
   * Upload Page 
   * @param file  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /portal/pageUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  ApiResponse<String> uploadPageWithHttpInfo(@Param("file") File file);



  /**
   * Upload a bar file
   * Upload a bar file 
   * @param file  (optional)
   * @return String
   */
  @RequestLine("POST /portal/processUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  String uploadProcess(@Param("file") File file);

  /**
   * Upload a bar file
   * Similar to <code>uploadProcess</code> but it also returns the http response headers .
   * Upload a bar file 
   * @param file  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /portal/processUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  ApiResponse<String> uploadProcessWithHttpInfo(@Param("file") File file);



  /**
   * Upload profiles
   * Upload profiles 
   * @param file  (optional)
   * @return String
   */
  @RequestLine("POST /portal/profilesUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  String uploadprofiles(@Param("file") File file);

  /**
   * Upload profiles
   * Similar to <code>uploadprofiles</code> but it also returns the http response headers .
   * Upload profiles 
   * @param file  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /portal/profilesUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  ApiResponse<String> uploadprofilesWithHttpInfo(@Param("file") File file);


}
