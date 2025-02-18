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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.bonitasoft.web.client.api.MaintenanceApi;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.MaintenanceDetails;
import org.bonitasoft.web.client.services.impl.base.CachingClientContext;
import org.bonitasoft.web.client.services.impl.base.ClientContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class DefaultSystemServiceTest {

    private ObjectMapper objectMapper = new ObjectMapper();
    private ClientContext clientContext = new CachingClientContext();

    @Mock
    private ApiProvider apiProvider;

    private DefaultSystemService systemService;

    @BeforeEach
    void setUp() {
        clientContext.clear();
        systemService = new DefaultSystemService(clientContext, apiProvider, objectMapper);
    }

    @Test
    void should_return_maintenance_mode() {
        // Given
        final MaintenanceApi maintenanceApi = mock(MaintenanceApi.class);
        when(apiProvider.get(MaintenanceApi.class)).thenReturn(maintenanceApi);
        when(maintenanceApi.getMaintenanceDetails())
                .thenReturn(new MaintenanceDetails().maintenanceState(MaintenanceDetails.MaintenanceStateEnum.ENABLED));
        // When
        final boolean isMaintenanceModeEnabled = systemService.isMaintenanceModeEnabled();
        // Then
        assertThat(isMaintenanceModeEnabled).isTrue();
    }

    @Test
    void should_return_false_if_maintenance_mode_not_set() {
        // Given
        final MaintenanceApi maintenanceApi = mock(MaintenanceApi.class);
        when(apiProvider.get(MaintenanceApi.class)).thenReturn(maintenanceApi);
        when(maintenanceApi.getMaintenanceDetails())
                .thenReturn(new MaintenanceDetails().maintenanceState(null));
        // When
        final boolean isMaintenanceModeEnabled = systemService.isMaintenanceModeEnabled();
        // Then
        assertThat(isMaintenanceModeEnabled).isFalse();
    }
}
