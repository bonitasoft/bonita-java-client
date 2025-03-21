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
package org.bonitasoft.web.client.feign;

import org.bonitasoft.web.client.BonitaClient;
import org.bonitasoft.web.client.api.SessionApi;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.invoker.auth.HttpBearerAuth;
import org.bonitasoft.web.client.model.Session;
import org.bonitasoft.web.client.services.ApplicationService;
import org.bonitasoft.web.client.services.BdmService;
import org.bonitasoft.web.client.services.LoginService;
import org.bonitasoft.web.client.services.ProcessService;
import org.bonitasoft.web.client.services.SystemService;
import org.bonitasoft.web.client.services.UserService;

import feign.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Entry point to interact with the REST API of bonita. <br>
 * Instances of BonitaClient can be created with the {@link BonitaFeignClientBuilderImpl} class.
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

    private final HttpBearerAuth bearerAuth;

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public Session login(String username, String password) {
        log.info("Try login user {}", username);
        Session session = loginService.login(username, password);
        log.debug("User logged in: {}", session);
        return session;
    }

    @Override
    public void setBearerToken(String token) {
        log.info("Set bearer token");
        bearerAuth.setBearerToken(token);
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
        } catch (Exception e) {
            log.debug("Ignoring error as we are performing a silent logout", e);
        }
    }

    @Override
    public boolean isPlatformUpAndRunning() {
        try (Response response = apiProvider.get(SessionApi.class).getSession()) {
            return response.status() == 401 || response.status() == 200;
        } catch (Exception e) {
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
