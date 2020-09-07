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
import com.bonitasoft.web.client.internal.BonitaCookieInterceptor;
import com.bonitasoft.web.client.internal.api.*;
import com.bonitasoft.web.client.internal.converters.RestApiConverter;
import com.bonitasoft.web.client.internal.services.*;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class BonitaClientBuilder {

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

    private BonitaClientBuilder(String url) {
        if (url == null) {
            throw new NullPointerException("url parameter cannot be null");
        }
        this.url = url;
    }

    // TODO use lombok instead (when activated compilation failed with gradle)
    // on class @RequiredArgsConstructor(staticName = "bonitaClient")
    // on field @NonNull
    public static BonitaClientBuilder bonitaClient(String url) {
        return new BonitaClientBuilder(url);
    }

    private static String addTrailingSlashIfNeeded(String url) {
        return url.endsWith("/") ? url : url + "/";
    }

    public BonitaClient build() {
        BonitaCookieInterceptor bonitaCookieInterceptor = new BonitaCookieInterceptor();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(bonitaCookieInterceptor)
                .connectTimeout(connectTimeoutInSeconds, SECONDS)
                .readTimeout(readTimeoutInSeconds, SECONDS)
                .writeTimeout(writeTimeoutInSeconds, SECONDS);
        if (disableCertificateCheck) {
            addTrustAllCertificateManager(builder);
        }
        OkHttpClient okHttpClient = builder.build();

        ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();

        RestApiConverter restApiConverter = RestApiConverter.INSTANCE;
        String validUrl = addTrailingSlashIfNeeded(url);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(validUrl)
                .callFactory(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(new RetrofitRestApiConverter())
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .build();

        importNotifier = ofNullable(importNotifier).orElseGet(LogOnlyImportNotifier::new);

        LoginService loginService = new LoginService(retrofit.create(LoginAPI.class), bonitaCookieInterceptor);
        ApplicationService applicationService = new ApplicationService(bonitaCookieInterceptor, retrofit.create(ApplicationAPI.class));
        OrganizationService organizationService = new OrganizationService(bonitaCookieInterceptor, retrofit.create(OrganizationAPI.class));
        IdentityService identityService = new IdentityService(bonitaCookieInterceptor, retrofit.create(IdentityAPI.class));
        ProfileService profileService = new ProfileService(bonitaCookieInterceptor, retrofit.create(ProfileAPI.class), identityService, importNotifier);
        PageService pageService = new PageService(restApiConverter, bonitaCookieInterceptor, retrofit.create(PageAPI.class));
        ProcessService processService = new ProcessService(restApiConverter, bonitaCookieInterceptor, retrofit.create(ProcessAPI.class), importNotifier);
        SystemService systemService = new SystemService(restApiConverter, bonitaCookieInterceptor, retrofit.create(SystemAPI.class));
        BdmAccessControlService bdmAccessControlService = new BdmAccessControlService(bonitaCookieInterceptor, systemService, retrofit.create(BdmAccessControlAPI.class), importNotifier);
        BdmService bdmService = new BdmService(bonitaCookieInterceptor, systemService, bdmAccessControlService, retrofit.create(BdmAPI.class), restApiConverter);
        UserTaskService userTaskService = new UserTaskService(retrofit.create(UserTaskAPI.class), restApiConverter, bonitaCookieInterceptor);
        ConfigurationService configurationService = new ConfigurationService(bonitaCookieInterceptor, systemService, retrofit.create(ConfigurationAPI.class), importNotifier);

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
