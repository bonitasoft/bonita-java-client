package org.bonitasoft.web.client.feign;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.bonitasoft.web.client.api.HumanTaskApi;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CachingApiProviderTest {

    @Test
    void should_create_feign_proxy() {
        // Given
        CachingApiProvider provider = new CachingApiProvider(new ApiClient());

        // When
        final HumanTaskApi humanTaskApi = provider.get(HumanTaskApi.class);

        // Then
        assertThat(humanTaskApi).isNotNull();
    }

    @Test
    void should_create_feign_proxy_only_once() {
        // Given
        final ApiClient apiClient = spy(new ApiClient());
        CachingApiProvider provider = new CachingApiProvider(apiClient);

        final Class<HumanTaskApi> apiClass = HumanTaskApi.class;

        // When
        provider.get(apiClass);
        provider.get(apiClass);

        // Then
        assertThat(apiClass).isNotNull();
        verify(apiClient, atMostOnce()).buildClient(apiClass);
    }
}
