/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
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
 * Class to fix bad charset handling in bonita version. Fixed in 7.11.3 This issue prevent
 * client to log in when sending charset info in request.
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
		return contentType.replace("; charset=utf-8", "").replace(";charset=utf-8", "").replace("; charset=UTF-8", "")
				.replace(";charset=UTF-8", "").replace("; Charset=utf-8", "").replace(";Charset=utf-8", "")
				.replace("; Charset=UTF-8", "").replace(";Charset=UTF-8", "");
	}

	@Override
	public void apply(RequestTemplate requestTemplate) {
		Optional<String> contentTypeHeader = requestTemplate.headers().getOrDefault(CONTENT_TYPE_HEADER, emptyList())
				.stream().findFirst();
		contentTypeHeader.ifPresent(contentType ->
		// Bonita does not understand content-type when charset is added :(
		requestTemplate.header(CONTENT_TYPE_HEADER, singleton(cleanContentType(contentType))));
	}

}
