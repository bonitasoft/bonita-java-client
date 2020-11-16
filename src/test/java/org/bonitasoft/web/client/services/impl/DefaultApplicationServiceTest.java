package org.bonitasoft.web.client.services.impl;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.databind.ObjectMapper;
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

@ExtendWith(MockitoExtension.class)
class DefaultApplicationServiceTest {

  private final ObjectMapper objectMapper = new ObjectMapper();
  private final ClientContext clientContext = new CachingClientContext();

  @Mock private ApiProvider apiProvider;
  @Mock private ApplicationApi applicationApi;
  @Mock private PageApi pageApi;

  private DefaultApplicationService applicationService;

  @BeforeEach
  void setUp() {
    clientContext.clear();
    applicationService =
        spy(new DefaultApplicationService(clientContext, apiProvider, objectMapper));

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
