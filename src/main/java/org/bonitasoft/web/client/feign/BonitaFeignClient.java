/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package org.bonitasoft.web.client.feign;

import feign.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bonitasoft.web.client.BonitaClient;
import org.bonitasoft.web.client.api.SessionApi;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.Session;
import org.bonitasoft.web.client.services.ApplicationService;
import org.bonitasoft.web.client.services.BdmService;
import org.bonitasoft.web.client.services.LoginService;
import org.bonitasoft.web.client.services.ProcessService;
import org.bonitasoft.web.client.services.SystemService;
import org.bonitasoft.web.client.services.UserService;

/**
 * Entry point to interact with the REST API of bonita. <br>
 * Instances of BonitaClient can be created with the {@link BonitaFeignClientBuilderImpl}
 * class.
 */
@Slf4j
@RequiredArgsConstructor
class BonitaFeignClient implements BonitaClient {

	private final String url;

	private final ApiProvider apiProvider;

	private final LoginService loginService;

	private final ApplicationService applicationService;

	private final BdmService bdmService;

	private final UserService userService;

	private final ProcessService processService;

	private final SystemService systemService;

	@Override
	public String getUrl() {
		return this.url;
	}

	@Override
	public Session login(String username, String password) {
		return login(username, password, DEFAULT_TENANT_ID);
	}

	@Override
	public Session login(String username, String password, String tenant) {
		log.info("Try login user {} on tenant {}", username, tenant);
		Session session = loginService.login(username, password, tenant);
		log.debug("User logged in: {}", session);
		return session;
	}

	@Override
	public void logout() {
		log.info("Logout user");
		loginService.logout();
	}

	@Override
	public void logoutSilent() {
		try {
			logout();
		}
		catch (Exception e) {
			log.debug("Ignoring error as we are performing a silent logout", e);
		}
	}

	@Override
	public boolean isPlatformUpAndRunning() {
		try (Response response = apiProvider.get(SessionApi.class).getSession()) {
			return response.status() == 401 || response.status() == 200;
		}
		catch (Exception e) {
			return false;
		}
	}

	@Override
	public String getVersion() {
		log.info("Get Bonita version");
		Session session = loginService.getSession();
		String version = session.getVersion();
		log.debug("Bonita version: {}", version);
		return version;
	}

	@Override
	public <T extends ApiClient.Api> T get(Class<T> apiClass) {
		log.debug("Access http api: {}", apiClass.getName());
		return apiProvider.get(apiClass);
	}

	@Override
	public ApplicationService applications() {
		return applicationService;
	}

	@Override
	public BdmService bdm() {
		return bdmService;
	}

	@Override
	public UserService users() {
		return userService;
	}

	@Override
	public ProcessService processes() {
		return processService;
	}

	@Override
	public SystemService system() {
		return systemService;
	}

}
