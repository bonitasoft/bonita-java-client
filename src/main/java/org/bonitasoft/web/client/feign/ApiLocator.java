package org.bonitasoft.web.client.feign;

import org.bonitasoft.web.client.invoker.ApiClient;

public interface ApiLocator {

    <T extends ApiClient.Api> T getApi(Class<T> apiClass);

}
