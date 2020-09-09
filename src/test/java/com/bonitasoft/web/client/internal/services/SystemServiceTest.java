/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.services;

import com.bonitasoft.web.client.internal.api.SystemAPI;
import com.bonitasoft.web.client.internal.security.SecurityContext;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import retrofit2.mock.Calls;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SystemServiceTest {

    @Mock
    private SystemAPI systemAPI;

    @Mock
    private SecurityContext securityContext;

    @InjectMocks
    private SystemService systemService;

    @Test
    void should_return_false_if_tenant_is_not_in_pause() throws Exception {
        when(systemAPI.getCurrentTenant()).thenReturn(Calls.response(ResponseBody.create(MediaType.parse("plain/test"), "{\"paused\":\"false\",\"id\":\"1\"}")));
        assertThat(systemService.isTenantPaused()).isFalse();
    }

    @Test
    void should_return_true_if_tenant_is_in_pause() throws Exception {
        when(systemAPI.getCurrentTenant()).thenReturn(Calls.response((ResponseBody.create(MediaType.parse("plain/test"), "{\"paused\":\"true\",\"id\":\"1\"}"))));
        assertThat(systemService.isTenantPaused()).isTrue();
    }

}
