package org.bonitasoft.web.client.feign;

import lombok.RequiredArgsConstructor;
import org.bonitasoft.web.client.api.PortalAuthenticationApi;
import org.bonitasoft.web.client.invoker.ApiClient;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
public class CachingApiProvider implements ApiProvider {

    private final ApiClient apiClient;

    private final Map<Class<?>, ApiClient.Api> apiCache = new ConcurrentHashMap<>();

    @Override
    public <T extends ApiClient.Api> T get(Class<T> apiClass) {
        if (apiClass.isAssignableFrom(PortalAuthenticationApi.class)) {
            throw new RuntimeException("Direct use of PortalAuthenticationApi is not allowed. Use BonitaClient#login method instead");
        }
        if (!apiCache.containsKey(apiClass)) {
            T service = apiClient.buildClient(apiClass);
            apiCache.put(apiClass, service);
        }
        return (T) apiCache.get(apiClass);
    }
}
