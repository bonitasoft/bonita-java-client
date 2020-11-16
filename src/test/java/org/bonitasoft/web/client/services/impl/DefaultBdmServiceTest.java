package org.bonitasoft.web.client.services.impl;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.bonitasoft.web.client.TestUtils.getClasspathFile;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import org.bonitasoft.web.client.BonitaClient;
import org.bonitasoft.web.client.api.BdmAccessControlApi;
import org.bonitasoft.web.client.api.BdmApi;
import org.bonitasoft.web.client.api.LicenseApi;
import org.bonitasoft.web.client.api.SystemTenantApi;
import org.bonitasoft.web.client.exception.LicenseException;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.BDMAccessControl;
import org.bonitasoft.web.client.model.TenantPauseRequest;
import org.bonitasoft.web.client.model.TenantResourceState;
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

  private DefaultBdmService bdmService;

  @Mock private ApiProvider apiProvider;
  @Mock private BdmApi bdmApi;
  @Mock private SystemTenantApi tenantApi;
  @Mock private LicenseApi licenseApi;
  @Mock private BdmAccessControlApi accessControlApi;

  @BeforeEach
  void setUp() {
    clientContext.clear();
    bdmService = spy(new DefaultBdmService(clientContext, apiProvider, objectMapper));

    lenient().when(apiProvider.get(LicenseApi.class)).thenReturn(licenseApi);
    lenient().when(apiProvider.get(SystemTenantApi.class)).thenReturn(tenantApi);
    lenient().when(apiProvider.get(BdmApi.class)).thenReturn(bdmApi);
    lenient().when(apiProvider.get(BdmAccessControlApi.class)).thenReturn(accessControlApi);

    lenient().doReturn(true).when(bdmService).isCommunity();
  }

  @Test
  void should_import_bdm() throws Exception {
    // Given
    File bdmFile = getClasspathFile("/bdm.zip");

    // When
    bdmService.importBDM(bdmFile);

    // Then
    // tenant paused
    verify(tenantApi)
        .updateSystemTenant(
            BonitaClient.DEFAULT_TENANT_ID, new TenantPauseRequest().paused("true"));
    verify(bdmService).deleteBdmAccessControlIfNeeded();
    // bdm installed
    verify(bdmApi).uploadBDM(any());
    verify(bdmApi).installBDM(any());
    // tenant restarted
    verify(tenantApi)
        .updateSystemTenant(
            BonitaClient.DEFAULT_TENANT_ID, new TenantPauseRequest().paused("false"));
  }

  @Test
  void access_control_should_be_deleted_when_not_community_and_installed() {
    // Given
    doReturn(false).when(bdmService).isCommunity();
    doReturn(new BDMAccessControl().state(TenantResourceState.INSTALLED))
        .when(bdmService)
        .getBdmAccessControlStatus();

    // When
    bdmService.deleteBdmAccessControlIfNeeded();

    // Then
    verify(accessControlApi).deleteBDMAccessControl();
  }

  @Test
  void access_control_should_not_be_deleted_when_community() {
    // Given
    doReturn(true).when(bdmService).isCommunity();

    // When
    bdmService.deleteBdmAccessControlIfNeeded();

    // Then
    verify(accessControlApi, never()).deleteBDMAccessControl();
  }

  @Test
  void access_control_should_be_fetched_when_not_community() {
    // Given
    doReturn(false).when(bdmService).isCommunity();

    // When
    bdmService.getBdmAccessControlStatus();

    // Then
    verify(accessControlApi).getBDMAccessControlStatus();
  }

  @Test
  void access_control_should_not_be_fetched_when_not_community() {
    // Given
    doReturn(true).when(bdmService).isCommunity();

    // When
    assertThatThrownBy(() -> bdmService.getBdmAccessControlStatus())
        .isInstanceOf(LicenseException.class);
  }
}
