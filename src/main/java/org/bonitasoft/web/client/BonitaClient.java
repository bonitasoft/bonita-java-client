package org.bonitasoft.web.client;

import org.bonitasoft.web.client.exception.UnauthorizedException;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.Session;

import java.io.IOException;

public abstract class BonitaClient {

    public static BonitaClientBuilder newBuilder(String url) {
        return new FeignBonitaClientBuilder(url);
    }

    public abstract boolean isPlatformUpAndRunning();

    public abstract Session login(String username, String password);

    public abstract Session login(String username, String password, String tenant);

    public abstract void logout() throws IOException, UnauthorizedException;

    public abstract void logoutSilent();

    public abstract <T extends ApiClient.Api> T service(Class<T> serviceClass);
}
