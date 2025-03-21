/** 
 * Copyright (C) 2018 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.bonitasoft.web.client.feign;

import static java.util.Optional.ofNullable;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.security.cert.CertificateException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.bonitasoft.web.client.BonitaClient;
import org.bonitasoft.web.client.exception.ClientException;
import org.bonitasoft.web.client.feign.decoder.BonitaErrorDecoder;
import org.bonitasoft.web.client.feign.decoder.DelegatingDecoder;
import org.bonitasoft.web.client.feign.interceptor.BonitaCharsetBugInterceptor;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.ApiResponseDecoder;
import org.bonitasoft.web.client.invoker.auth.BonitaCookieAuth;
import org.bonitasoft.web.client.invoker.auth.BonitaLoginService;
import org.bonitasoft.web.client.invoker.auth.HttpBearerAuth;
import org.bonitasoft.web.client.log.LogContentLevel;
import org.bonitasoft.web.client.services.ApplicationService;
import org.bonitasoft.web.client.services.BdmService;
import org.bonitasoft.web.client.services.LoginService;
import org.bonitasoft.web.client.services.ProcessService;
import org.bonitasoft.web.client.services.SystemService;
import org.bonitasoft.web.client.services.UserService;
import org.bonitasoft.web.client.services.impl.DefaultApplicationService;
import org.bonitasoft.web.client.services.impl.DefaultBdmService;
import org.bonitasoft.web.client.services.impl.DefaultProcessService;
import org.bonitasoft.web.client.services.impl.DefaultSystemService;
import org.bonitasoft.web.client.services.impl.DefaultUserService;
import org.bonitasoft.web.client.services.impl.base.CachingClientContext;
import org.bonitasoft.web.client.services.impl.base.ClientContext;
import org.bonitasoft.web.client.services.impl.bdm.BdmResponseConverter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Feign;
import feign.Request;
import feign.Retryer;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Slf4j
@Accessors(fluent = true)
@RequiredArgsConstructor
public class BonitaFeignClientBuilderImpl implements BonitaFeignClientBuilder {

    @NonNull
    @Setter(AccessLevel.NONE)
    private final String url;

    /** Note about timeouts: default values are the same as in OkHttpClient (10 seconds). */
    @Setter
    private int connectTimeoutInSeconds = 10;

    @Setter
    private int readTimeoutInSeconds = 10;

    @Setter
    private int writeTimeoutInSeconds = 10;

    @Setter
    private boolean disableRetry = false;

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

    @Override
    public BonitaClient build() {

        ApiClient apiClient = new ApiClient();

        // Bonita url
        apiClient.setBasePath(url);

        // OkHttp
        okHttpClient = ofNullable(okHttpClient)
                .orElseGet(() -> configureHttpClient(new OkHttpClient.Builder()).build());

        // Jackson
        objectMapper = configureJackson(ofNullable(this.objectMapper).orElseGet(apiClient::getObjectMapper));

        // Feign
        feignBuilder = ofNullable(feignBuilder).orElseGet(() -> configureFeign(apiClient.getFeignBuilder()));
        apiClient.setFeignBuilder(feignBuilder);

        // Http proxies
        ApiProvider apiProvider = new CachingApiProvider(apiClient);

        // Bonita Auth
        BonitaCookieAuth authorization = new BonitaCookieAuth();
        apiClient.addAuthorization("bonita", authorization);
        LoginService loginService = new BonitaLoginService(apiProvider, this.objectMapper, authorization);

        // Delegate services
        final ClientContext clientContext = new CachingClientContext();
        ApplicationService applicationService = new DefaultApplicationService(clientContext, apiProvider,
                this.objectMapper);

        BdmResponseConverter bdmResponseConverter = new BdmResponseConverter(this.objectMapper, apiProvider);
        BdmService bdmService = new DefaultBdmService(clientContext, apiProvider, bdmResponseConverter);

        UserService userService = new DefaultUserService(clientContext, apiProvider, this.objectMapper);
        ProcessService processService = new DefaultProcessService(clientContext, apiProvider, this.objectMapper);
        SystemService systemService = new DefaultSystemService(clientContext, apiProvider, this.objectMapper);

        HttpBearerAuth bearerAuth = (HttpBearerAuth) apiClient.getAuthorization("bearer_auth");

        return new BonitaFeignClient(
                apiClient.getBasePath(),
                apiProvider,
                loginService,
                applicationService,
                bdmService,
                userService,
                processService,
                systemService,
                bearerAuth);
    }

    Feign.Builder configureFeign(Feign.Builder feignBuilder) {
        log.debug("Configuring Feign builder ...");
        return feignBuilder
                .client(new feign.okhttp.OkHttpClient(okHttpClient))
                .options(new Request.Options(okHttpClient.connectTimeoutMillis(), TimeUnit.MILLISECONDS,
                        okHttpClient.readTimeoutMillis(), TimeUnit.MILLISECONDS,
                        okHttpClient.followRedirects()))
                .decoder(
                        new DelegatingDecoder()
                                // Register custom decoders for certain content-type
                                .register("application/json", new ApiResponseDecoder(objectMapper)))
                // Map feign exception to ours
                .errorDecoder(new BonitaErrorDecoder())
                // bad charset handling in bonita version. Fixed in 7.11.3
                .requestInterceptor(new BonitaCharsetBugInterceptor())
                .retryer(disableRetry ? Retryer.NEVER_RETRY : new Retryer.Default());
    }

    ObjectMapper configureJackson(ObjectMapper objectMapper) {
        log.debug("Configuring Object mapper ...");
        objectMapper
                .findAndRegisterModules()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // Contracts are serialized as Map and null values must be kept in the request body
        objectMapper.configOverride(Map.class)
                .setInclude(JsonInclude.Value.construct(JsonInclude.Include.ALWAYS, JsonInclude.Include.ALWAYS));
        return objectMapper;
    }

    OkHttpClient.Builder configureHttpClient(OkHttpClient.Builder builder) {
        log.debug("Configuring OkHttp client ...");
        OkHttpClient.Builder okHttpClientBuilder = addTrustAllCertificateManagerIfNeeded(builder)
                .connectTimeout(connectTimeoutInSeconds, SECONDS)
                .readTimeout(readTimeoutInSeconds, SECONDS)
                .writeTimeout(writeTimeoutInSeconds, SECONDS)
                .followRedirects(Boolean.TRUE);

        if (!LogContentLevel.OFF.equals(logContentLevel)) {
            HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(
                    message -> LoggerFactory.getLogger(BonitaClient.class).info(message));
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

    OkHttpClient.Builder addTrustAllCertificateManagerIfNeeded(OkHttpClient.Builder builder) {
        if (disableCertificateCheck) {
            log.debug("Configuring client Certificate manager ...");
            try {
                // Create a trust manager that does not validate certificate chains
                final TrustManager[] trustAllCerts = new TrustManager[] { newTrustAllCertManager() };

                // Install the all-trusting trust manager
                final SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
                sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

                // Create an ssl socket factory with our all-trusting manager
                final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

                builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
                builder.hostnameVerifier((hostname, session) -> true);

            } catch (Exception e) {
                throw new ClientException(
                        "An internal error has occurred while building the insecure HttpClient", e);
            }
            log.warn("Certificate Manager is configured to trust all ! (no check)");
        }
        return builder;
    }

    @NotNull
    TrustManager newTrustAllCertManager() {
        return new X509TrustManager() {

            @Override
            public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
                    throws CertificateException {
                // noop
            }

            @Override
            public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
                    throws CertificateException {
                // noop
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[] {};
            }
        };
    }

}
