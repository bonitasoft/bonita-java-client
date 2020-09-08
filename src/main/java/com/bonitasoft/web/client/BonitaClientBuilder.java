/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client;

import com.bonitasoft.web.client.event.ImportNotifier;
import com.bonitasoft.web.client.event.LogOnlyImportNotifier;
import com.bonitasoft.web.client.internal.api.*;
import com.bonitasoft.web.client.internal.security.OkHttpSecurityContextInterceptor;
import com.bonitasoft.web.client.internal.services.*;
import com.bonitasoft.web.client.utils.Json;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

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
@RequiredArgsConstructor(staticName = "bonitaClient")
public class BonitaClientBuilder {

    @NonNull
    private final String url;

    @Setter
    private ImportNotifier importNotifier;
    @Setter
    private int connectTimeoutInSeconds = 10;
    @Setter
    private int readTimeoutInSeconds = 10;
    @Setter
    private int writeTimeoutInSeconds = 10;
    @Setter
    private boolean disableCertificateCheck = false;

    private static String addTrailingSlashIfNeeded(String url) {
        return url.endsWith("/") ? url : url + "/";
    }

    public BonitaClient build() {

        OkHttpSecurityContextInterceptor securityContext = new OkHttpSecurityContextInterceptor();

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(securityContext)
                .connectTimeout(connectTimeoutInSeconds, SECONDS)
                .readTimeout(readTimeoutInSeconds, SECONDS)
                .writeTimeout(writeTimeoutInSeconds, SECONDS);
        if (disableCertificateCheck) {
            addTrustAllCertificateManager(builder);
        }
        OkHttpClient okHttpClient = builder.build();

        String validUrl = addTrailingSlashIfNeeded(url);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(validUrl)
                .callFactory(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create(Json.DEFAULT_MAPPER))
                .build();

        importNotifier = ofNullable(importNotifier).orElseGet(LogOnlyImportNotifier::new);

        LoginService loginService = new LoginService(securityContext, retrofit.create(LoginAPI.class));
        ApplicationService applicationService = new ApplicationService(securityContext, retrofit.create(ApplicationAPI.class));
        OrganizationService organizationService = new OrganizationService(securityContext, retrofit.create(OrganizationAPI.class));
        IdentityService identityService = new IdentityService(securityContext, retrofit.create(IdentityAPI.class));
        ProfileService profileService = new ProfileService(securityContext, retrofit.create(ProfileAPI.class), identityService, importNotifier);
        PageService pageService = new PageService(securityContext, retrofit.create(PageAPI.class));
        ProcessService processService = new ProcessService(securityContext, retrofit.create(ProcessAPI.class), importNotifier);
        SystemService systemService = new SystemService(securityContext, retrofit.create(SystemAPI.class));
        BdmAccessControlService bdmAccessControlService = new BdmAccessControlService(securityContext, retrofit.create(BdmAccessControlAPI.class), systemService, importNotifier);
        BdmService bdmService = new BdmService(securityContext, retrofit.create(BdmAPI.class), systemService, bdmAccessControlService);
        UserTaskService userTaskService = new UserTaskService(securityContext, retrofit.create(UserTaskAPI.class));
        ConfigurationService configurationService = new ConfigurationService(securityContext, systemService, retrofit.create(ConfigurationAPI.class), importNotifier);

        BonitaClient bonitaClient = new BonitaClient(loginService,
                applicationService,
                organizationService,
                pageService,
                profileService,
                processService,
                bdmService,
                systemService,
                bdmAccessControlService,
                identityService,
                userTaskService,
                configurationService);
        bonitaClient.setUrl(validUrl);
        return bonitaClient;
    }

    private OkHttpClient.Builder addTrustAllCertificateManager(OkHttpClient.Builder builder) {
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
            return builder;
        } catch (Exception e) {
            throw new RuntimeException("An internal error has occurred while building the insecure HttpClient", e);
        }
    }

}
