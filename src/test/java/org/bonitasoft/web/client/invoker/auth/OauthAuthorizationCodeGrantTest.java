package org.bonitasoft.web.client.invoker.auth;

import com.github.scribejava.core.model.OAuth2AccessToken;
import feign.RequestTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

@ExtendWith(MockitoExtension.class)
public class OauthAuthorizationCodeGrantTest {


	private OauthAuthorizationCodeGrant auth;

	@BeforeEach
	void setUp() {
		auth = new OauthAuthorizationCodeGrant("authz", "tokenUrl", "");
	}

	@Test
	void authorization_header_should_be_bearer() {
		// Given
		auth = spy(auth);
		var accessToken = "abcd1234";
		doReturn(new OAuth2AccessToken(accessToken)).when(auth).getOAuth2AccessToken();
		var template = new RequestTemplate();

		// When
		auth.apply(template);

		// Then
		assertThat(template.headers().get("Authorization").iterator().next()).isEqualTo("Bearer abcd1234");
	}

}
