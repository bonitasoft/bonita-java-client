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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.bonitasoft.web.client.BonitaClient;
import org.bonitasoft.web.client.log.LogContentLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Feign;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@ExtendWith(MockitoExtension.class)
class BonitaFeignClientBuilderImplTest {

    public static final String DUMMY_URL = "http://dummy.org/bonita/";
    private BonitaFeignClientBuilderImpl clientBuilder;

    @BeforeEach
    void setUp() {
        clientBuilder = spy(new BonitaFeignClientBuilderImpl(DUMMY_URL));
    }

    @Test
    void should_configure_object_mapper() {
        // Given

        // When
        final BonitaClient client = clientBuilder.build();

        // Then
        verify(clientBuilder).configureFeign(any());
        verify(clientBuilder).configureJackson(any());
        verify(clientBuilder).configureHttpClient(any());
        verify(clientBuilder).addTrustAllCertificateManagerIfNeeded(any());

        assertThat(client).isNotNull();
        assertThat(client.getUrl()).isEqualTo(DUMMY_URL);
    }

    @Test
    void can_provide_custom_object_mapper() {
        // Given
        final ObjectMapper customMapper = new ObjectMapper();
        clientBuilder.objectMapper(customMapper);

        // When
        clientBuilder.build();

        // Then
        verify(clientBuilder).configureJackson(customMapper);
    }

    @Test
    void can_provide_custom_http_client() {
        // Given
        final OkHttpClient customHttpClient = new OkHttpClient();
        clientBuilder.okHttpClient(customHttpClient);

        // When
        clientBuilder.build();

        // Then
        verify(clientBuilder, never()).configureHttpClient(any());
    }

    @Test
    void can_provide_custom_feign_builder() {
        // Given
        final Feign.Builder builder = new Feign.Builder();
        clientBuilder.feignBuilder(builder);

        // When
        clientBuilder.build();

        // Then
        verify(clientBuilder, never()).configureFeign(any());
    }

    @ParameterizedTest
    @EnumSource(value = LogContentLevel.class, names = { "FULL", "HEADER", "BASIC" })
    void log_should_be_configured(LogContentLevel logContentLevel) {
        // Given
        clientBuilder.logContentLevel(logContentLevel);

        // When
        final OkHttpClient.Builder builder = clientBuilder.configureHttpClient(new OkHttpClient.Builder());

        // Then
        assertThat(builder.interceptors())
                .anyMatch(interceptor -> (interceptor instanceof HttpLoggingInterceptor))
                .isNotEmpty();
    }

    @Test
    void trust_all_certs_should_be_configured() {
        // Given
        clientBuilder.disableCertificateCheck(true);

        // When
        clientBuilder.addTrustAllCertificateManagerIfNeeded(new OkHttpClient.Builder());

        // Then
        verify(clientBuilder, atMostOnce()).newTrustAllCertManager();
    }
}
