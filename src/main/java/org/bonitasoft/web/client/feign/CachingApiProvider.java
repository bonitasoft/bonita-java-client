package org.bonitasoft.web.client.feign;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import org.bonitasoft.web.client.invoker.ApiClient;

@RequiredArgsConstructor
public class CachingApiProvider implements ApiProvider {

  private final ApiClient apiClient;

  private final Map<Class<? extends ApiClient.Api>, ApiClient.Api> apiCache =
      new ConcurrentHashMap<>();

  @Override
  public <T extends ApiClient.Api> T get(Class<T> apiClass) {
    return (T) apiCache.computeIfAbsent(apiClass, apiClient::buildClient);
  }
}
