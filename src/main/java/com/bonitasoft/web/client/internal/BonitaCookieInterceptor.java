/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;

import java.io.IOException;
import java.util.Map;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by laurentleseigneur on 29/06/2017.
 */
public class BonitaCookieInterceptor implements Interceptor {

    public static final String CSRF_TOKEN_HEADER = "X-Bonita-API-Token";

    private String cookie;

    private String csrfHeader;

    public String getCookie() {
        return cookie;
    }

    public String getCsrfHeader() {
        return csrfHeader;
    }

    public void clearSessionCookie() {
        this.cookie = null;
        this.csrfHeader = null;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        if (this.cookie != null) {
            builder.header("Cookie", cookie);
        }
        if (this.csrfHeader != null) {
            builder.header(CSRF_TOKEN_HEADER, csrfHeader);
        }
        request = builder.build();
        return chain.proceed(request);
    }

    public void setSessionCookies(Headers loginHeaders) {
        Map<String, String> cookies = loginHeaders.toMultimap().get("set-cookie")
                .stream()
                .map(item -> item.split("=", 2))
                .collect(
                        toMap(
                                split -> split[0],
                                split -> split[1].split(";")[0],
                                (oldValue, newValue) -> newValue));

        this.csrfHeader = cookies.remove(CSRF_TOKEN_HEADER);

        this.cookie = cookies.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(joining(";"));
    }

    public void checkLogged() {
        if (cookie == null) {
            throw new IllegalStateException("Not logged");
        }
    }
}
