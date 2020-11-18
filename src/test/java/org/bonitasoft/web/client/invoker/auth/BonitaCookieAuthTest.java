package org.bonitasoft.web.client.invoker.auth;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BonitaCookieAuthTest {

	private BonitaCookieAuth auth;

	@BeforeEach
	void setUp() {
		auth = new BonitaCookieAuth();
	}

	@Test
	void cookie_and_csrf_token_should_be_extracted() {
		// Given
		Map<String, Collection<String>> headers = new HashMap<>();
		headers.put("set-cookie",
				asList("JSESSIONID=C5385BFEE2969D9E46F0160C1952B0F1; Path=/bonita;HttpOnly; SameSite=Lax",
						BonitaCookieAuth.CSRF_TOKEN_HEADER + "=ed27cbeb-9953-4d77-b5a2-1f62a6c2e0bb"));

		// When
		auth.initFrom(headers);

		// Then
		assertThat(auth.getCookie()).isNotNull().isNotEmpty();
		assertThat(auth.getCsrfHeader()).isNotNull().isNotEmpty();
	}

}
