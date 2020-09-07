/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.bonitasoft.web.client.internal.BonitaCookieInterceptor.CSRF_TOKEN_HEADER;
import static okhttp3.Request.Builder;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by laurentleseigneur on 01/07/2017.
 */
class BonitaCookieInterceptorTest {

    private MockWebServer server;

    @BeforeEach
    void setup() throws Exception {
        server = new MockWebServer();
        server.start();
    }

    @Test
    void should_set_cookie() {
        //given
        Headers headers = getHeaders();
        BonitaCookieInterceptor bonitaCookieInterceptor = new BonitaCookieInterceptor();

        //when
        bonitaCookieInterceptor.setSessionCookies(headers);

        //then
        assertThat(bonitaCookieInterceptor.getCsrfHeader()).as("should not set CSRF header").isNull();
        assertThat(bonitaCookieInterceptor.getCookie()).isEqualTo("cookie1=value1;cookie3=value3;cookie2=value2");
    }

    @Test
    void should_set_cookie_with_equals_character() {
        //given
        Headers headers = getHeaders("cookieWithEquals", "valueWithEquals==/; path=/");
        BonitaCookieInterceptor bonitaCookieInterceptor = new BonitaCookieInterceptor();

        //when
        bonitaCookieInterceptor.setSessionCookies(headers);

        //then
        assertThat(bonitaCookieInterceptor.getCookie())
                .isEqualTo("cookie1=value1;cookieWithEquals=valueWithEquals==/;cookie2=value2");
    }

    @Test
    void should_set_cookie_when_a_cookie_entry_appears_several_times() {
        //given
        Headers headers = getHeaders("cookie1", "value1_duplicated");
        BonitaCookieInterceptor bonitaCookieInterceptor = new BonitaCookieInterceptor();

        //when
        bonitaCookieInterceptor.setSessionCookies(headers);

        //then
        assertThat(bonitaCookieInterceptor.getCsrfHeader()).as("should not set CSRF header").isNull();
        assertThat(bonitaCookieInterceptor.getCookie()).isEqualTo("cookie1=value1_duplicated;cookie2=value2");
    }

    @Test
    void should_set_cookie_when_an_cookie_entry_has_multiple_values() {
        //given
        Headers headers = getHeaders("cookie3", "value31;value32");
        BonitaCookieInterceptor bonitaCookieInterceptor = new BonitaCookieInterceptor();

        //when
        bonitaCookieInterceptor.setSessionCookies(headers);

        //then
        assertThat(bonitaCookieInterceptor.getCsrfHeader()).as("should not set CSRF header").isNull();
        assertThat(bonitaCookieInterceptor.getCookie()).isEqualTo("cookie1=value1;cookie3=value31;cookie2=value2");
    }

    @Test
    void should_exclude_csrf_token() {
        //given
        Headers headers = getHeaders(CSRF_TOKEN_HEADER, "abcd");
        BonitaCookieInterceptor bonitaCookieInterceptor = new BonitaCookieInterceptor();

        //when
        bonitaCookieInterceptor.setSessionCookies(headers);

        //then
        assertThat(bonitaCookieInterceptor.getCsrfHeader()).as("should set CSRF header").isEqualTo("abcd");
        assertThat(bonitaCookieInterceptor.getCookie()).as("should exclude CSRF from cookies")
                .isEqualTo("cookie1=value1;cookie2=value2");
    }

    @Test
    void should_reset_cookie() {
        //given
        Headers headers = getHeaders(CSRF_TOKEN_HEADER, "abcd");
        BonitaCookieInterceptor bonitaCookieInterceptor = new BonitaCookieInterceptor();

        //when
        bonitaCookieInterceptor.setSessionCookies(headers);
        bonitaCookieInterceptor.clearSessionCookie();

        //then
        assertThat(bonitaCookieInterceptor.getCookie()).isNull();
        assertThat(bonitaCookieInterceptor.getCsrfHeader()).isNull();

    }

    @Test
    void should_add_required_cookie_and_csrf_header() throws Exception {
        //given
        Headers headers = getHeaders(CSRF_TOKEN_HEADER, "secret");
        BonitaCookieInterceptor bonitaCookieInterceptor = new BonitaCookieInterceptor();
        bonitaCookieInterceptor.setSessionCookies(headers);

        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("ok"));

        //expect
        Interceptor checkInterceptor = chain -> {
            Headers requestHeaders = chain.request().headers();
            assertThat(requestHeaders.get("Cookie")).isEqualTo("cookie1=value1;cookie2=value2");
            assertThat(requestHeaders.get(CSRF_TOKEN_HEADER)).isEqualTo("secret");
            return chain.proceed(chain.request());
        };

        //where
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(bonitaCookieInterceptor)
                .addInterceptor(checkInterceptor)
                .build();

        okHttpClient.newCall(new Builder()
                .url(server.url("/"))
                .build()).execute();

    }

    private Headers getHeaders() {
        return getHeaders("cookie3", "value3");
    }

    private Headers getHeaders(String cookieName, String cookieValue) {
        return new Headers.Builder()
                .add("Set-Cookie", "cookie1=value1")
                .add("Set-Cookie", "cookie2=value2")
                .add("Set-Cookie", cookieName + "=" + cookieValue)
                .build();
    }

}
