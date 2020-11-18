package org.bonitasoft.web.client.feign;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.bonitasoft.web.client.invoker.ApiClient;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CachingApiProvider implements ApiProvider {

	private final ApiClient apiClient;

	private final Map<Class<?>, ApiClient.Api> apiCache = new ConcurrentHashMap<>();

	@Override
	public <T extends ApiClient.Api> T get(Class<T> apiClass) {
		if (!apiCache.containsKey(apiClass)) {
			T service = apiClient.buildClient(apiClass);
			apiCache.put(apiClass, service);
		}
		return (T) apiCache.get(apiClass);
	}

}
