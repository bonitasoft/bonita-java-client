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

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.bonitasoft.web.client.api.UserTaskApi;
import org.bonitasoft.web.client.exception.NotFoundException;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.services.impl.base.ClientContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class DefaultProcessServiceTest {

    @InjectMocks
    private DefaultProcessService processService;

    @Mock
    private ClientContext clientContext;
    @Mock
    private ApiProvider apiProvider;
    @Mock
    private ObjectMapper objectMapper;

    @Test
    void none_user_task_should_raise_not_found_ex() {
        // Given
        final UserTaskApi userTaskApi = mock(UserTaskApi.class);
        when(apiProvider.get(UserTaskApi.class)).thenReturn(userTaskApi);

        String id = UUID.randomUUID().toString();

        // When
        assertThatThrownBy(() -> processService.getUserTask(id)).isInstanceOf(NotFoundException.class);
    }
}
