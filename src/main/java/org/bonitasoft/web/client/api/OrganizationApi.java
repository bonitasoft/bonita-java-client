package org.bonitasoft.web.client.api;

import feign.*;
import java.io.File;
import org.bonitasoft.web.client.invoker.ApiClient;

public interface OrganizationApi extends ApiClient.Api {

  /**
   * Import an organization Import an organization
   *
   * @param organizationDataUpload Uploaded file (optional)
   * @param importPolicy Import policy (optional)
   */
  @RequestLine("POST /services/organization/import")
  @Headers({
    "Content-Type: application/x-www-form-urlencoded",
    "Accept: application/json",
  })
  void importOrganization(
      @Param("organizationDataUpload") String organizationDataUpload,
      @Param("importPolicy") String importPolicy);

  /**
   * Import an organization Upload organization
   *
   * @param file (optional)
   * @return String
   */
  @RequestLine("POST /portal/organizationUpload")
  @Headers({
    "Content-Type: multipart/form-data",
    "Accept: application/json",
  })
  String uploadOrganization(@Param("file") File file);
}
