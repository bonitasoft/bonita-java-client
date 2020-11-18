package org.bonitasoft.web.client.services.impl.base;

import static org.assertj.core.api.Assertions.assertThat;
import static org.bonitasoft.web.client.services.impl.base.AbstractService.COMMUNITY_LICENCE;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import org.bonitasoft.web.client.model.License;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CachingClientContextTest {

	private CachingClientContext context;

	@Test
	void get_licence_should_use_lambda_if_none() {
		// Given
		context = new CachingClientContext();

		// When
		final License license = context.getLicense(s -> COMMUNITY_LICENCE);

		// Then
		assertThat(license).isEqualTo(context.getLicense()).isEqualTo(COMMUNITY_LICENCE);
	}

	@Test
	void get_licence_should_return_licence() {
		// Given
		context = new CachingClientContext();
		final License enterprise = new License().edition("Enterprise")
				.expirationDate(LocalDate.now().plus(1, ChronoUnit.MONTHS).toEpochDay());
		context.setLicense(enterprise);

		// When
		final License license = context.getLicense(s -> COMMUNITY_LICENCE);

		// Then
		assertThat(license).isEqualTo(enterprise);
	}

	@Test
	void should_store_context_data() {
		// Given
		context = new CachingClientContext();
		UUID data = UUID.randomUUID();
		String key = data.toString();

		// When
		context.put(key, data);

		// Then
		final UUID storedData = context.get(key);
		assertThat(storedData).isEqualTo(data);
	}

	@Test
	void should_allow_remove_context_data() {
		// Given
		context = new CachingClientContext();
		String unknownKey = UUID.randomUUID().toString();
		UUID dataToRemove = UUID.randomUUID();
		String keyToRemove = dataToRemove.toString();
		context.put(keyToRemove, dataToRemove);

		// When
		final UUID removed = context.remove(keyToRemove);
		final UUID unknown = context.remove(unknownKey);

		// Then
		assertThat(removed).isEqualTo(dataToRemove);
		assertThat(unknown).isNull();
	}

}
