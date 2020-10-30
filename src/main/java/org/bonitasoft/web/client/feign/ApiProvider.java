package org.bonitasoft.web.client.feign;

import org.bonitasoft.web.client.invoker.ApiClient;

public interface ApiProvider {

    <T extends ApiClient.Api> T get(Class<T> apiClass);

}
