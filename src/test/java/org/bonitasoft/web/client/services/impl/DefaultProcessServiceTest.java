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
