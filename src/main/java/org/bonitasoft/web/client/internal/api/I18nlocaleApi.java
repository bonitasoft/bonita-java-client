package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import org.bonitasoft.web.client.internal.model.Error;
import org.bonitasoft.web.client.internal.model.I18nlocale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface I18nlocaleApi {
  /**
   * Finds I18nlocales
   * List the available I18nlocales with pagination params and filters 
   * @param p index of the page to display (required)
   * @param c maximum number of elements to retrieve (required)
   * @return Call&lt;List&lt;I18nlocale&gt;&gt;
   */
  @GET("API/system/i18nlocale")
  Call<List<I18nlocale>> findI18nlocales(
    @retrofit2.http.Query("p") Integer p, @retrofit2.http.Query("c") Integer c
  );

}
