/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package org.bonitasoft.web.client.feign;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.bonitasoft.web.client.BonitaClient;
import org.bonitasoft.web.client.auth.BonitaCookieInterceptor;
import org.bonitasoft.web.client.exception.ClientException;
import org.bonitasoft.web.client.exception.NotFoundException;
import org.bonitasoft.web.client.exception.UnauthorizedException;
import org.bonitasoft.web.client.feign.decoder.DelegatingDecoder;
import org.bonitasoft.web.client.feign.interceptor.BonitaCharsetBugInterceptor;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.services.LoginService;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;

import static feign.FeignException.errorStatus;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Note about timeouts: default values are the same as in OkHttpClient (10 seconds).
 */
@Accessors(fluent = true)
@RequiredArgsConstructor
public class BonitaFeignClientBuilderImpl implements BonitaFeignClientBuilder {

    @NonNull
    @Setter(AccessLevel.NONE)
    private final String url;

    @Setter
    private int connectTimeoutInSeconds = 10;
    @Setter
    private int readTimeoutInSeconds = 10;
    @Setter
    private int writeTimeoutInSeconds = 10;
    @Setter
    private boolean disableCertificateCheck = false;

    @Setter
    private Feign.Builder feignBuilder;
    @Setter
    private OkHttpClient okHttpClient;
    @Setter
    private ObjectMapper objectMapper;
    @Setter
    private HttpLoggingInterceptor logInterceptor;

    private static String addTrailingSlashIfNeeded(String url) {
        return url.endsWith("/") ? url : url + "/";
    }

    @Override
    public BonitaClient build() {

        ApiClient apiClient = new ApiClient();

        // OkHttp
        if (okHttpClient == null) {
            OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                    .connectTimeout(connectTimeoutInSeconds, SECONDS)
                    .readTimeout(readTimeoutInSeconds, SECONDS)
                    .writeTimeout(writeTimeoutInSeconds, SECONDS);
            if (disableCertificateCheck) {
                addTrustAllCertificateManager(okHttpClientBuilder);
            }
            if (logInterceptor != null) {
                okHttpClientBuilder.addInterceptor(logInterceptor);
            }
            okHttpClient = okHttpClientBuilder.build();
        }

        // Jackson
        if (objectMapper == null) {
            objectMapper = apiClient.getObjectMapper().findAndRegisterModules()
                    .setSerializationInclusion(JsonInclude.Include.NON_NULL);
        }

        // Decoder
        if (feignBuilder == null) {
            feignBuilder = apiClient.getFeignBuilder()
                    .client(new feign.okhttp.OkHttpClient(okHttpClient))
                    .decode404()
                    .decoder(new DelegatingDecoder().register("application/json", new JacksonDecoder(objectMapper)))
                    // Map feign exception to ours
                    .errorDecoder((methodKey, response) -> {
                        switch (response.status()) {
                            case 401:
                                return new UnauthorizedException();
                            case 404:
                                return new NotFoundException(response.reason());
                        }
                        if (response.status() >= 400 && response.status() <= 599) {
                            return new ClientException(String.format("status: %s %s", response.status(), response.reason()));
                        }
                        return errorStatus(methodKey, response);
                    })
            ;
        } else {
            apiClient.setFeignBuilder(feignBuilder);
        }
        // Fixme: bad charset handling in bonita version. Fixed in 7.11.3
        apiClient.getFeignBuilder().requestInterceptor(new BonitaCharsetBugInterceptor());

        // Bonita url
        apiClient.setBasePath(addTrailingSlashIfNeeded(url));

        // Bonita Auth
        BonitaCookieInterceptor authorization = new BonitaCookieInterceptor();
        apiClient.addAuthorization("bonita", authorization);

        LoginService loginService = new LoginService(apiClient, authorization);
        ApiLocator apiLocator = new CachingApiLocator(apiClient);

        return new BonitaFeignClient(loginService, apiLocator, objectMapper);
    }

    private void addTrustAllCertificateManager(OkHttpClient.Builder builder) {
        try {

            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {

                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
                                throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
                                throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier((hostname, session) -> true);

        } catch (Exception e) {
            throw new RuntimeException("An internal error has occurred while building the insecure HttpClient", e);
        }
    }

}
