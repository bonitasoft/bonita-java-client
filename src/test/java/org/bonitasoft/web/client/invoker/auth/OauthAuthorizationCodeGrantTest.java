/** 
 * Copyright (C) 2025 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.bonitasoft.web.client.invoker.auth;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.scribejava.core.model.OAuth2AccessToken;

import feign.RequestTemplate;

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
