/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal;

import com.bonitasoft.web.client.internal.security.OkHttpSecurityContextInterceptor;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.stubbing.Scenario;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static com.bonitasoft.web.client.internal.security.OkHttpSecurityContextInterceptor.CSRF_TOKEN_HEADER;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static okhttp3.Request.Builder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by laurentleseigneur on 01/07/2017.
 */
class SecurityContextTest {

    private WireMockServer server;

    @BeforeEach
    void setUp() {
        server = new WireMockServer(WireMockConfiguration.options().dynamicPort());
        server.start();
    }

    @AfterEach
    void tearDown() {
        server.stop();
    }

    @Test
    void should_set_cookie() {
        //given
        Response<ResponseBody> loginResponse = getResponse();
        OkHttpSecurityContextInterceptor interceptor = new OkHttpSecurityContextInterceptor();

        //when
        interceptor.authenticate(loginResponse);

        //then
        assertThat(interceptor.getCsrfHeader()).as("should not set CSRF header").isNull();
        assertThat(interceptor.getCookie()).isEqualTo("cookie1=value1;cookie3=value3;cookie2=value2");
    }

    @Test
    void should_set_cookie_with_equals_character() {
        //given
        Response<ResponseBody> loginResponse = getResponse("cookieWithEquals", "valueWithEquals==/; path=/");
        OkHttpSecurityContextInterceptor interceptor = new OkHttpSecurityContextInterceptor();

        //when
        interceptor.authenticate(loginResponse);

        //then
        assertThat(interceptor.getCookie())
                .isEqualTo("cookie1=value1;cookieWithEquals=valueWithEquals==/;cookie2=value2");
    }

    @Test
    void should_set_cookie_when_a_cookie_entry_appears_several_times() {
        //given
        Response<ResponseBody> loginResponse = getResponse("cookie1", "value1_duplicated");
        OkHttpSecurityContextInterceptor interceptor = new OkHttpSecurityContextInterceptor();

        //when
        interceptor.authenticate(loginResponse);

        //then
        assertThat(interceptor.getCsrfHeader()).as("should not set CSRF header").isNull();
        assertThat(interceptor.getCookie()).isEqualTo("cookie1=value1_duplicated;cookie2=value2");
    }

    @Test
    void should_set_cookie_when_an_cookie_entry_has_multiple_values() {
        //given
        Response<ResponseBody> loginResponse = getResponse("cookie3", "value31;value32");
        OkHttpSecurityContextInterceptor interceptor = new OkHttpSecurityContextInterceptor();

        //when
        interceptor.authenticate(loginResponse);

        //then
        assertThat(interceptor.getCsrfHeader()).as("should not set CSRF header").isNull();
        assertThat(interceptor.getCookie()).isEqualTo("cookie1=value1;cookie3=value31;cookie2=value2");
    }

    @Test
    void should_exclude_csrf_token() {
        //given
        Response<ResponseBody> loginResponse = getResponse(CSRF_TOKEN_HEADER, "abcd");
        OkHttpSecurityContextInterceptor interceptor = new OkHttpSecurityContextInterceptor();

        //when
        interceptor.authenticate(loginResponse);

        //then
        assertThat(interceptor.getCsrfHeader()).as("should set CSRF header").isEqualTo("abcd");
        assertThat(interceptor.getCookie()).as("should exclude CSRF from cookies")
                .isEqualTo("cookie1=value1;cookie2=value2");
    }

    @Test
    void should_reset_cookie() {
        //given
        Response<ResponseBody> loginResponse = getResponse(CSRF_TOKEN_HEADER, "abcd");
        OkHttpSecurityContextInterceptor interceptor = new OkHttpSecurityContextInterceptor();

        //when
        interceptor.authenticate(loginResponse);
        interceptor.clear();

        //then
        assertThat(interceptor.getCookie()).isNull();
        assertThat(interceptor.getCsrfHeader()).isNull();

    }

    @Test
    void should_add_required_cookie_and_csrf_header() throws Exception {
        //given
        Response<ResponseBody> loginResponse = getResponse(CSRF_TOKEN_HEADER, "secret");
        OkHttpSecurityContextInterceptor interceptor = new OkHttpSecurityContextInterceptor();
        interceptor.authenticate(loginResponse);

        server.stubFor(get(urlEqualTo("/"))
                .willReturn(aResponse().withBody("ok")));

        //expect
        Interceptor checkInterceptor = chain -> {
            Headers requestHeaders = chain.request().headers();
            assertThat(requestHeaders.get("Cookie")).isEqualTo("cookie1=value1;cookie2=value2");
            assertThat(requestHeaders.get(CSRF_TOKEN_HEADER)).isEqualTo("secret");
            return chain.proceed(chain.request());
        };

        //where
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(checkInterceptor)
                .build();

        okHttpClient.newCall(new Builder()
                .url(server.url("/"))
                .build()).execute();

    }


    private retrofit2.Response<ResponseBody> getResponse() {
        return Response.success(new RealResponseBody("application/json", 0, null), getHeaders("cookie3", "value3"));
    }

    private retrofit2.Response<ResponseBody> getResponse(String cookieName, String cookieValue) {
        return Response.success(new RealResponseBody("application/json", 0, null), getHeaders(cookieName, cookieValue));
    }

    private Headers getHeaders(String cookieName, String cookieValue) {
        return new Headers.Builder()
                .add("Set-Cookie", "cookie1=value1")
                .add("Set-Cookie", "cookie2=value2")
                .add("Set-Cookie", cookieName + "=" + cookieValue)
                .build();
    }

}
