package org.bonitasoft.web.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public interface BonitaClientBuilder<T extends BonitaClientBuilder> {

    BonitaClient build();

    T connectTimeoutInSeconds(int connectTimeoutInSeconds);

    T readTimeoutInSeconds(int readTimeoutInSeconds);

    T writeTimeoutInSeconds(int writeTimeoutInSeconds);

    T disableCertificateCheck(boolean disableCertificateCheck);

    T okHttpClient(OkHttpClient okHttpClient);

    T objectMapper(ObjectMapper objectMapper);

    T logInterceptor(HttpLoggingInterceptor loggingInterceptor);
}
