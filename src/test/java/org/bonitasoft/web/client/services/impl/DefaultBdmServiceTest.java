package org.bonitasoft.web.client.services.impl;

import static org.bonitasoft.web.client.TestUtils.getClasspathFile;
import static org.bonitasoft.web.client.TestUtils.mockResponseBuilder;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import org.bonitasoft.web.client.BonitaClient;
import org.bonitasoft.web.client.api.BdmApi;
import org.bonitasoft.web.client.api.LicenseApi;
import org.bonitasoft.web.client.api.SystemTenantApi;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.TenantPauseRequest;
import org.bonitasoft.web.client.services.impl.base.CachingClientContext;
import org.bonitasoft.web.client.services.impl.base.ClientContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DefaultBdmServiceTest {

  private final ObjectMapper objectMapper = new ObjectMapper();
  private final ClientContext clientContext = new CachingClientContext();

  @Mock private ApiProvider apiProvider;
  @Mock private BdmApi bdmApi;
  @Mock private SystemTenantApi tenantApi;

  private DefaultBdmService bdmService;
  @Mock private LicenseApi licenseApi;

  @BeforeEach
  void setUp() {
    clientContext.clear();
    bdmService = new DefaultBdmService(clientContext, apiProvider, objectMapper);

    when(apiProvider.get(LicenseApi.class)).thenReturn(licenseApi);
    when(apiProvider.get(SystemTenantApi.class)).thenReturn(tenantApi);
    when(apiProvider.get(BdmApi.class)).thenReturn(bdmApi);

    when(licenseApi.getLicense()).thenReturn(mockResponseBuilder().status(404).build());
  }

  @Test
  void should_import_bdm() throws Exception {
    // Given
    File bdmFile = getClasspathFile("/bdm.zip");

    // When
    bdmService.importBDM(bdmFile);

    // Then
    verify(tenantApi)
        .updateSystemTenant(
            BonitaClient.DEFAULT_TENANT_ID, new TenantPauseRequest().paused("true"));
    //        deleteBdmAccessControlIfNeeded();
    verify(bdmApi).uploadBDM(any());
    verify(bdmApi).installBDM(any());
    // Restart tenant
    verify(tenantApi)
        .updateSystemTenant(
            BonitaClient.DEFAULT_TENANT_ID, new TenantPauseRequest().paused("false"));
  }
}
