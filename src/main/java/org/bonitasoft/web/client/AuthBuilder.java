package org.bonitasoft.web.client;

import feign.RequestInterceptor;
import org.bonitasoft.web.client.feign.auth.AccessCodeFeignAuthBuilder;
import org.bonitasoft.web.client.feign.auth.BonitaCookieFeignAuthBuilder;

public interface AuthBuilder {

	static BonitaCookieAuthBuilder cookieAuth() {
		return new BonitaCookieFeignAuthBuilder();
	}

	static AccessCodeAuthBuilder accessCodeAuth() {
		return new AccessCodeFeignAuthBuilder();

	}

	RequestInterceptor build();
}
