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
package org.bonitasoft.web.client.invoker.auth;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;

import java.util.Collection;
import java.util.Map;

import feign.RequestInterceptor;
import feign.RequestTemplate;

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
