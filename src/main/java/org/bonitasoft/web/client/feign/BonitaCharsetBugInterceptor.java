/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static java.util.Collections.singleton;

public class BonitaCharsetBugInterceptor implements Interceptor, RequestInterceptor {

    private static final String CONTENT_TYPE_HEADER = "Content-Type";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String contentType = request.header(CONTENT_TYPE_HEADER);
        if (contentType != null) {
            // FIXME: Bonita does not understand content-type when charset is added :(
            Request.Builder builder = request.newBuilder();
            builder.removeHeader(CONTENT_TYPE_HEADER);
            builder.header(CONTENT_TYPE_HEADER, contentType
                    .replace("; charset=utf-8", "")
                    .replace(";charset=utf-8", "")
                    .replace("; charset=UTF-8", "")
                    .replace(";charset=UTF-8", ""));
            request = builder.build();
        }
        return chain.proceed(request);
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        Optional<String> contentTypeHeader = requestTemplate.headers().getOrDefault(CONTENT_TYPE_HEADER, emptyList()).stream().findFirst();
        contentTypeHeader.ifPresent(contentType -> {
            // FIXME: Bonita does not understand content-type when charset is added :(
            requestTemplate.header(CONTENT_TYPE_HEADER, singleton(contentType
                    .replace("; charset=utf-8", "")
                    .replace(";charset=utf-8", "")
                    .replace("; charset=UTF-8", "")
                    .replace(";charset=UTF-8", "")
            ));
        });
    }

}
