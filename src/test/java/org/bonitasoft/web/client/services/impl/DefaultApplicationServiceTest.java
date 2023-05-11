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
package org.bonitasoft.web.client.services.impl;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.bonitasoft.web.client.api.ApplicationApi;
import org.bonitasoft.web.client.api.PageApi;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.services.impl.base.CachingClientContext;
import org.bonitasoft.web.client.services.impl.base.ClientContext;
import org.bonitasoft.web.client.services.policies.ApplicationImportPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class DefaultApplicationServiceTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ClientContext clientContext = new CachingClientContext();

    @Mock
    private ApiProvider apiProvider;
    @Mock
    private ApplicationApi applicationApi;
    @Mock
    private PageApi pageApi;

    private DefaultApplicationService applicationService;

    @BeforeEach
    void setUp() {
        clientContext.clear();
        applicationService = spy(new DefaultApplicationService(clientContext, apiProvider, objectMapper));

        lenient().when(apiProvider.get(ApplicationApi.class)).thenReturn(applicationApi);
        lenient().when(apiProvider.get(PageApi.class)).thenReturn(pageApi);
    }

    @Test
    void should_import_configuration_if_enterprise_edition() {
        // Given
        File configurationFile = new File("./dummy.bconf");
        final ArgumentCaptor<File> captor = ArgumentCaptor.forClass(File.class);

        doReturn(false).when(applicationService).isCommunity();

        // When
        applicationService.importBonitaConfiguration(configurationFile);

        // Then
        verify(applicationApi).uploadApplicationConfiguration(captor.capture());
        assertThat(captor.getValue()).isEqualTo(configurationFile);
    }

    @Test
    void import_application_replace_dups_should_first_delete() {
        // Given
        File dummyApps = new File("/dummyApp.xml");
        when(applicationApi.uploadApplication(dummyApps)).thenReturn(UUID.randomUUID().toString());

        final ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        final List<String> fakeAppTokens = asList("app1", "app2");
        doReturn(fakeAppTokens).when(applicationService).readApplicationTokensFromFile(any());

        // When
        applicationService.importApplications(dummyApps, ApplicationImportPolicy.REPLACE_DUPLICATES);

        // Then
        verify(applicationApi, atLeast(fakeAppTokens.size())).searchApplications(anyMap());
        verify(applicationService, times(fakeAppTokens.size())).silentDeleteApplication(anyString());
        verify(applicationApi).uploadApplication(dummyApps);
        verify(applicationApi).importApplication(anyString(), captor.capture());
        assertThat(captor.getValue()).isEqualTo(ApplicationImportPolicy.FAIL_ON_DUPLICATES.name());
    }
}
