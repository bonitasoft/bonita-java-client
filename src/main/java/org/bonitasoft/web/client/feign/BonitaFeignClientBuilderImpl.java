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
import org.bonitasoft.web.client.auth.BonitaLoginService;
import org.bonitasoft.web.client.feign.decoder.BonitaErrorDecoder;
import org.bonitasoft.web.client.feign.decoder.DelegatingDecoder;
import org.bonitasoft.web.client.feign.interceptor.BonitaCharsetBugInterceptor;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.log.LogContentLevel;
import org.bonitasoft.web.client.services.*;
import org.bonitasoft.web.client.services.impl.*;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;

import static java.util.Optional.ofNullable;
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
    private LogContentLevel logContentLevel = LogContentLevel.OFF;

    private static String addTrailingSlashIfNeeded(String url) {
        return url.endsWith("/") ? url : url + "/";
    }

    @Override
    public BonitaClient build() {

        ApiClient apiClient = new ApiClient();
        // Bonita url
        apiClient.setBasePath(addTrailingSlashIfNeeded(url));

        // OkHttp
        okHttpClient = ofNullable(okHttpClient)
                .orElseGet(() -> configureHttpClient(new OkHttpClient.Builder()).build());

        // Jackson
        objectMapper = configureJackson(ofNullable(this.objectMapper).orElse(apiClient.getObjectMapper()));

        // Feign
        feignBuilder = ofNullable(feignBuilder)
                .orElse(configureFeign(apiClient.getFeignBuilder()));
        apiClient.setFeignBuilder(feignBuilder);

        // Http proxies
        ApiProvider apiProvider = new CachingApiProvider(apiClient);

        // Bonita Auth
        BonitaCookieInterceptor authorization = new BonitaCookieInterceptor();
        apiClient.addAuthorization("bonita", authorization);
        LoginService loginService = new BonitaLoginService(apiProvider, this.objectMapper, authorization);

        // Delegate services
        final ClientContext clientContext = new CachingClientContext();
        ApplicationService applicationService = new DefaultApplicationService(clientContext, apiProvider, this.objectMapper);
        BdmService bdmService = new DefaultBdmService(clientContext, apiProvider, this.objectMapper);
        UserService userService = new DefaultUserService(clientContext, apiProvider, this.objectMapper);
        ProcessService processService = new DefaultProcessService(clientContext, apiProvider, this.objectMapper);
        SystemService systemService = new DefaultSystemService(clientContext, apiProvider, this.objectMapper);

        return new BonitaFeignClient(apiClient.getBasePath(), apiClient, loginService, applicationService, bdmService, userService, processService, systemService);
    }

    private Feign.Builder configureFeign(Feign.Builder feignBuilder) {
        return feignBuilder.client(new feign.okhttp.OkHttpClient(okHttpClient))
                .decode404()
                .decoder(new DelegatingDecoder().register("application/json", new JacksonDecoder(objectMapper)))
                // Map feign exception to ours
                .errorDecoder(new BonitaErrorDecoder())
                // Fixme: bad charset handling in bonita version. Fixed in 7.11.3
                .requestInterceptor(new BonitaCharsetBugInterceptor());
    }

    private ObjectMapper configureJackson(ObjectMapper objectMapper) {
        return objectMapper.findAndRegisterModules()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private OkHttpClient.Builder configureHttpClient(OkHttpClient.Builder builder) {
        OkHttpClient.Builder okHttpClientBuilder = addTrustAllCertificateManagerIfNeeded(builder)
                .connectTimeout(connectTimeoutInSeconds, SECONDS)
                .readTimeout(readTimeoutInSeconds, SECONDS)
                .writeTimeout(writeTimeoutInSeconds, SECONDS);

        if (!LogContentLevel.OFF.equals(logContentLevel)) {
            HttpLoggingInterceptor logInterceptor =
                    new HttpLoggingInterceptor(message -> LoggerFactory.getLogger(BonitaClient.class).info(message));
            switch (logContentLevel) {
                case FULL:
                    logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    break;
                case HEADER:
                    logInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
                    break;
                default:
                    logInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
                    break;
            }
            okHttpClientBuilder.addInterceptor(logInterceptor);
        }

        return okHttpClientBuilder;
    }

    private OkHttpClient.Builder addTrustAllCertificateManagerIfNeeded(OkHttpClient.Builder builder) {
        if (disableCertificateCheck) {
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
        return builder;
    }

}
