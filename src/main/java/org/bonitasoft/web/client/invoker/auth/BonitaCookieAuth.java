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

import java.util.Collection;
import java.util.Map;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bonitasoft.web.client.api.PortalAuthenticationApi;
import org.bonitasoft.web.client.exception.ClientException;
import org.bonitasoft.web.client.exception.UnauthorizedException;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.feign.auth.Credentials;
import org.bonitasoft.web.client.feign.auth.UsernamePasswordCredentials;

import static java.lang.String.format;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;

@Slf4j
@RequiredArgsConstructor
public class BonitaCookieAuth implements RequestInterceptor, Auth {

	public static final String CSRF_TOKEN_HEADER = "X-Bonita-API-Token";

	private String cookie;

	private String csrfHeader;

	public String getCookie() {
		return cookie;
	}

	public String getCsrfHeader() {
		return csrfHeader;
	}

	private final ApiProvider apiProvider;

	void initFrom(Map<String, Collection<String>> loginHeaders) {
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

	@Override
	public void login(Credentials credentials) {

		//TODO: use generics or better checks
		var creds = (UsernamePasswordCredentials) credentials;

		log.debug("Login with user '{}' on tenant '{}'...", creds.getUsername(), creds.getTenant());

		boolean loginSucceeded;
		int loginStatus;
		String loginReason = "";

		final PortalAuthenticationApi portalAuthenticationApi = apiProvider.get(PortalAuthenticationApi.class);
		try (Response loginResponse = portalAuthenticationApi.login(creds.getUsername(), creds.getPassword(), creds.getTenant(), "false", "")) {
			loginStatus = loginResponse.status();
			loginSucceeded = (loginStatus == 200 || loginStatus == 204);
			if (loginSucceeded) {
				this.initFrom(loginResponse.headers());
			}
			else {
				loginReason = loginResponse.reason();
			}
		}
		catch (Exception e) {
			throw new ClientException("Login failed", e);
		}

		if (!loginSucceeded) {
			throw new UnauthorizedException(
					format("Login failed, status: %s %s", loginStatus, loginReason));
		}
	}

	@Override
	public void logout() {
		apiProvider.get(PortalAuthenticationApi.class).logout("false");
		this.cookie = null;
		this.csrfHeader = null;
	}
}
