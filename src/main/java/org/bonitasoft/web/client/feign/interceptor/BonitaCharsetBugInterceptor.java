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
package org.bonitasoft.web.client.feign.interceptor;

import static java.util.Collections.emptyList;
import static java.util.Collections.singleton;

import java.io.IOException;
import java.util.Optional;

import org.jetbrains.annotations.NotNull;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Class to fix bad charset handling in bonita version. Fixed in 7.11.3 This issue prevent client to
 * log in when sending charset info in request.
 */
public class BonitaCharsetBugInterceptor implements Interceptor, RequestInterceptor {

    static final String CONTENT_TYPE_HEADER = "Content-Type";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String contentType = request.header(CONTENT_TYPE_HEADER);
        if (contentType != null) {
            // Bonita does not understand content-type when charset is added :(
            Request.Builder builder = request.newBuilder();
            builder.removeHeader(CONTENT_TYPE_HEADER);
            builder.header(CONTENT_TYPE_HEADER, cleanContentType(contentType));
            request = builder.build();
        }
        return chain.proceed(request);
    }

    @NotNull
    String cleanContentType(String contentType) {
        return contentType
                .replace("; charset=utf-8", "")
                .replace(";charset=utf-8", "")
                .replace("; charset=UTF-8", "")
                .replace(";charset=UTF-8", "")
                .replace("; Charset=utf-8", "")
                .replace(";Charset=utf-8", "")
                .replace("; Charset=UTF-8", "")
                .replace(";Charset=UTF-8", "");
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        Optional<String> contentTypeHeader = requestTemplate.headers().getOrDefault(CONTENT_TYPE_HEADER, emptyList())
                .stream()
                .findFirst();
        contentTypeHeader.ifPresent(
                contentType ->
                // Bonita does not understand content-type when charset is added :(
                requestTemplate.header(CONTENT_TYPE_HEADER, singleton(cleanContentType(contentType))));
    }
}
