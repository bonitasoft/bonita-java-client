package org.bonitasoft.web.client.feign;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.bonitasoft.web.client.BonitaClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BonitaFeignClientBuilderImplTest {

  public static final String DUMMY_URL = "http://dummy.org/bonita";
  private BonitaFeignClientBuilderImpl clientBuilder;

  @BeforeEach
  void setUp() {
    clientBuilder = spy(new BonitaFeignClientBuilderImpl(DUMMY_URL));
  }

  @Test
  void should_configure_object_mapper() {
    // Given

    // When
    final BonitaClient client = clientBuilder.build();

    // Then
    verify(clientBuilder).addTrailingSlashIfNeeded(eq(DUMMY_URL));
    verify(clientBuilder).configureFeign(any());
    verify(clientBuilder).configureJackson(any());
    verify(clientBuilder).configureHttpClient(any());
    verify(clientBuilder).addTrustAllCertificateManagerIfNeeded(any());

    assertThat(client).isNotNull();
  }
}
