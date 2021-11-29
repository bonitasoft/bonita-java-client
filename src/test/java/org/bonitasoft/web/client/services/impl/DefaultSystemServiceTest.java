package org.bonitasoft.web.client.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bonitasoft.web.client.api.SystemTenantApi;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.SystemTenant;
import org.bonitasoft.web.client.services.impl.base.CachingClientContext;
import org.bonitasoft.web.client.services.impl.base.ClientContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.bonitasoft.web.client.BonitaClient.DEFAULT_TENANT_ID;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    void should_return_tenant_status() {
        // Given
        final SystemTenantApi systemTenantApi = mock(SystemTenantApi.class);
        when(apiProvider.get(SystemTenantApi.class)).thenReturn(systemTenantApi);
        when(systemTenantApi.getSystemTenant(DEFAULT_TENANT_ID))
                .thenReturn(new SystemTenant().paused(true));
        // When
        final boolean tenantPaused = systemService.isTenantPaused();
        // Then
        assertThat(tenantPaused).isTrue();
    }

    @Test
    void should_return_false_if_tenant_status_not_set() {
        // Given
        final SystemTenantApi systemTenantApi = mock(SystemTenantApi.class);
        when(apiProvider.get(SystemTenantApi.class)).thenReturn(systemTenantApi);
        when(systemTenantApi.getSystemTenant(DEFAULT_TENANT_ID))
                .thenReturn(new SystemTenant().paused(null));
        // When
        final boolean tenantPaused = systemService.isTenantPaused();
        // Then
        assertThat(tenantPaused).isFalse();
    }
}
