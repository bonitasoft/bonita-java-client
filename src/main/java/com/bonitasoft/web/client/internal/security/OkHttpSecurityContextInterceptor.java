/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;

/**
 * Created by laurentleseigneur on 29/06/2017.
 */
@Slf4j
@RequiredArgsConstructor
public class OkHttpSecurityContextInterceptor implements Interceptor, SecurityContext {

    public static final String CSRF_TOKEN_HEADER = "X-Bonita-API-Token";

    @Getter
    private String csrfHeader;
    @Getter
    private String cookie;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        if (this.cookie != null) {
            builder.header("Cookie", this.cookie);
        }
        if (this.csrfHeader != null) {
            builder.header(CSRF_TOKEN_HEADER, this.csrfHeader);
        }
        request = builder.build();
        return chain.proceed(request);
    }

    @Override
    public void authenticate(retrofit2.Response<ResponseBody> response) {
        Map<String, String> cookies = response.headers().toMultimap().get("set-cookie")
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

    @Override
    public void clear() {
        this.csrfHeader = null;
        this.cookie = null;
    }

    @Override
    public void isAuthenticated() {
        if (cookie == null) {
            throw new IllegalStateException("Not logged");
        }
    }

}
