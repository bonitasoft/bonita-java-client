package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface I18ntranslationApi {
  /**
   * Finds I18ntranslations
   * List the available I18ntranslations with pagination params and filters Returns all translations of the product. If a locale is specified in the filter, that translation for that locale are returned. If no locale is specified, the translations in English are returned.  You can filter on &#x60;locale&#x60; 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @param f can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. (optional)
   * @return Call&lt;List&lt;Map&lt;String, String&gt;&gt;&gt;
   */
  @GET("API/system/i18ntranslation")
  Call<List<Map<String, String>>> findI18ntranslations(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c, @retrofit2.http.Query("f") String f
  );

}
