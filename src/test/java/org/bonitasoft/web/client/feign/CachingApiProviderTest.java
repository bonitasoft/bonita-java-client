/** 
 * Copyright (C) 2023 BonitaSoft S.A.
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
