package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.BDMAccessControl;
import org.bonitasoft.web.client.internal.model.BDMAccessControlUploadResponse;
import org.bonitasoft.web.client.internal.model.Error;
import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BdmAccessControlApi {
  /**
   * Delete the BDM Access Control
   * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Delete the BDM access control 
   * @return Call&lt;Void&gt;
   */
  @DELETE("API/accessControl/bdm")
  Call<Void> deleteBDMAccessControl();
    

  /**
   * BDM access control status
   * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Get the BDM access control status. 
   * @return Call&lt;BDMAccessControl&gt;
   */
  @GET("API/accessControl/bdm")
  Call<BDMAccessControl> getDBMAccessControlStatus();
    

  /**
   * Import a BDM Access Control
   * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Import a BDM Access Control 
   * @param bdmAccessControlUpload The temporary name of the previously uploaded file to install (optional)
   * @return Call&lt;Void&gt;
   */
  @retrofit2.http.FormUrlEncoded
  @POST("services/bdmAccessControl/install")
  Call<Void> importBDMAccessControl(
    @retrofit2.http.Field("bdmAccessControlUpload") String bdmAccessControlUpload
  );

  /**
   * Upload a BDM Access Control
   * ![edition](https://img.shields.io/badge/edition-entreprise-blue)  Upload BDM Access Control 
   * @param file  (optional)
   * @return Call&lt;BDMAccessControlUploadResponse&gt;
   */
  @retrofit2.http.Multipart
  @POST("portal/bdmAccessControlUpload")
  Call<BDMAccessControlUploadResponse> uploadBDMAccessControl(
    @retrofit2.http.Part MultipartBody.Part file
  );

}
