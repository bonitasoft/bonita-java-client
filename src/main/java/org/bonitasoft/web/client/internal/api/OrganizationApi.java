package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;
import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrganizationApi {
  /**
   * Import an organization
   * Import an organization 
   * @param organizationDataUpload Uploaded file (optional)
   * @param importPolicy Import policy (optional)
   * @return Call&lt;Void&gt;
   */
  @retrofit2.http.FormUrlEncoded
  @POST("services/organization/import")
  Call<Void> importOrganization(
    @retrofit2.http.Field("organizationDataUpload") String organizationDataUpload, @retrofit2.http.Field("importPolicy") String importPolicy
  );

  /**
   * Import an organization
   * Upload organization 
   * @param file  (optional)
   * @return Call&lt;Void&gt;
   */
  @retrofit2.http.Multipart
  @POST("portal/organizationUpload")
  Call<Void> uploadOrganization(
    @retrofit2.http.Part MultipartBody.Part file
  );

}
