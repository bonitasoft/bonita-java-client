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
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.bonitasoft.web.client.BonitaClient;
import org.bonitasoft.web.client.services.ApplicationService;
import org.bonitasoft.web.client.services.BdmService;
import org.bonitasoft.web.client.services.LoginService;
import org.bonitasoft.web.client.services.ProcessService;
import org.bonitasoft.web.client.services.SystemService;
import org.bonitasoft.web.client.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BonitaClientTest {

    @InjectMocks
    private BonitaFeignClient client;

    @Mock
    private LoginService loginService;
    @Mock
    private ApplicationService applicationService;
    @Mock
    private BdmService bdmService;
    @Mock
    private UserService userService;
    @Mock
    private ProcessService processService;
    @Mock
    private SystemService systemService;

    @Test
    void mocks_are_in_place() {
        assertThat(client.applications()).isNotNull();
        assertThat(client.users()).isNotNull();
        assertThat(client.system()).isNotNull();
        assertThat(client.bdm()).isNotNull();
        assertThat(client.processes()).isNotNull();
    }

    @Test
    void when_no_tenant_provided_should_log_with_default_tenant() {
        // Given
        client = spy(client);
        String username = "test";
        String password = "123";

        // When
        client.login(username, password);

        // Then
        verify(client).login(username, password, BonitaClient.DEFAULT_TENANT_ID);
        verify(loginService).login(username, password, BonitaClient.DEFAULT_TENANT_ID);
    }

    @Test
    void should_delegate_logout() {
        // Given

        // When
        client.logout();

        // Then
        verify(loginService).logout();
    }

    @Test
    void should_logout_with_no_exceptions() {
        // Given
        doThrow(new RuntimeException("Should be ignored exc")).when(loginService).logout();

        // When
        client.logoutSilent();

        // Then
        verify(loginService).logout();
    }
}
