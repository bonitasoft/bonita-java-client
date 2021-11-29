/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package org.bonitasoft.web.client.invoker.auth;

import java.util.Collection;
import java.util.Map;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;

public class BonitaCookieAuth implements RequestInterceptor {

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

    public void initFrom(Map<String, Collection<String>> loginHeaders) {
        Map<String, String> cookies = loginHeaders.getOrDefault("set-cookie", emptyList()).stream()
                .map(cookieHeader -> cookieHeader.split("=", 2))
                .collect(
                        toMap(
                                cookieHeaderPair -> cookieHeaderPair[0],
                                cookieHeaderPair -> cookieHeaderPair[1].split(";")[0],
                                (oldValue, newValue) -> newValue));

        this.csrfHeader = cookies.remove(CSRF_TOKEN_HEADER);

        this.cookie = cookies.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(joining(";"));
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (this.cookie != null) {
            requestTemplate.header("Cookie", cookie);
        }
        if (this.csrfHeader != null) {
            requestTemplate.header(CSRF_TOKEN_HEADER, csrfHeader);
        }
    }
}
