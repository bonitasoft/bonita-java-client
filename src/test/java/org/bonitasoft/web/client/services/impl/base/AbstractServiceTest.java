package org.bonitasoft.web.client.services.impl.base;

import static org.assertj.core.api.Assertions.assertThat;
import static org.bonitasoft.web.client.TestUtils.mockResponseBuilder;
import static org.bonitasoft.web.client.services.impl.base.AbstractService.COMMUNITY_LICENCE;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.bonitasoft.web.client.api.LicenseApi;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.License;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class AbstractServiceTest {

	private final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

	private final ClientContext clientContext = new CachingClientContext();

	private AbstractService service;

	@Mock
	private ApiProvider apiProvider;

	@BeforeEach
	void setUp() {
		clientContext.clear();
		service = new DummyService(apiProvider, objectMapper, clientContext);
	}

	@Test
	void should_get_and_cache_license() throws Exception {
		// Given
		final LicenseApi licenseApi = mock(LicenseApi.class);
		when(apiProvider.get(LicenseApi.class)).thenReturn(licenseApi);
		final License enterprise = new License().edition("Enterprise").expirationDate(System.currentTimeMillis());
		when(licenseApi.getLicense())
				.thenReturn(mockResponseBuilder().status(200).body(objectMapper.writeValueAsBytes(enterprise)).build());

		// When
		final License license = service.getLicense();

		// Then
		assertThat(license).isEqualTo(clientContext.getLicense()).isEqualTo(enterprise);
	}

	@Test
	void should_get_license_only_once() throws Exception {
		// Given
		final LicenseApi licenseApi = mock(LicenseApi.class);
		when(apiProvider.get(LicenseApi.class)).thenReturn(licenseApi);
		final License enterprise = new License().edition("Enterprise").expirationDate(System.currentTimeMillis());
		when(licenseApi.getLicense())
				.thenReturn(mockResponseBuilder().status(200).body(objectMapper.writeValueAsBytes(enterprise)).build());

		// When
		service.getLicense();
		service.getLicense();

		// Then
		verify(licenseApi, atMostOnce()).getLicense();
	}

	@Test
	void should_return_community_license_on_404() throws Exception {
		// Given
		final LicenseApi licenseApi = mock(LicenseApi.class);
		when(apiProvider.get(LicenseApi.class)).thenReturn(licenseApi);
		when(licenseApi.getLicense()).thenReturn(mockResponseBuilder().status(404).build());

		// When
		final License license = service.getLicense();

		// Then
		assertThat(license).isEqualTo(clientContext.getLicense()).isEqualTo(COMMUNITY_LICENCE);
	}

	public static class DummyService extends AbstractService {

		public DummyService(ApiProvider apiProvider, ObjectMapper objectMapper, ClientContext clientContext) {
			super(apiProvider, objectMapper, clientContext);
		}

	}

}
