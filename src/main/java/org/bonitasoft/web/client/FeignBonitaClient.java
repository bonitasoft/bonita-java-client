/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package org.bonitasoft.web.client;

import lombok.extern.slf4j.Slf4j;
import org.bonitasoft.web.client.api.PortalAuthenticationApi;
import org.bonitasoft.web.client.exception.UnauthorizedException;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.Session;
import org.bonitasoft.web.client.services.DeploymentService;
import org.bonitasoft.web.client.services.LoginService;

import java.io.IOException;

/**
 * Entry point to interact with the REST API of bonita. <br>
 * Instances of BonitaClient can be created with the {@link FeignBonitaClientBuilder} class.
 */
@Slf4j
class FeignBonitaClient extends BonitaClient {

    private final LoginService loginService;
    private final ApiClient apiClient;
    private final DeploymentService deploymentService;

    FeignBonitaClient(ApiClient apiClient, LoginService loginService) {
        this.loginService = loginService;
        this.apiClient = apiClient;
        this.deploymentService = new DeploymentService(apiClient);
    }

    @Override
    public boolean isPlatformUpAndRunning() {
        return loginService.isPlatformUpAndRunning();
    }

    @Override
    public Session login(String username, String password) {
        //check the session is ok + it will trigger the loading of servlets
        return loginService.login(username, password);
    }

    @Override
    public Session login(String username, String password, String tenant) {
        //check the session is ok + it will trigger the loading of servlets
        return loginService.login(username, password, tenant);
    }

    @Override
    public void logout() throws IOException, UnauthorizedException {
        loginService.logout();
    }

    @Override
    public void logoutSilent() {
        try {
            loginService.logout();
        } catch (Exception e) {
            log.debug("Ignoring error as we are performing a silent logout", e);
        }
    }

    @Override
    public <T extends ApiClient.Api> T service(Class<T> serviceClass) {
        if (serviceClass.isAssignableFrom(PortalAuthenticationApi.class)) {
            throw new RuntimeException("Direct use of PortalAuthenticationApi is not allowed. Use BonitaClient#login method instead");
        }
        if (serviceClass.isAssignableFrom(DeploymentService.class)) {
            return (T) this.deploymentService;
        }
        return apiClient.buildClient(serviceClass);
    }
}
