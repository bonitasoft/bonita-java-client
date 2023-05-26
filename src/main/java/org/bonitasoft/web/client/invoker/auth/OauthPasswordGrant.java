/** 
 * Copyright (C) 2023 BonitaSoft S.A.
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

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.oauth.OAuth20Service;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class OauthPasswordGrant extends OAuth {

    private String username;
    private String password;

    public OauthPasswordGrant(String tokenUrl, String scopes) {
        super(null, tokenUrl, scopes);
    }

    @Override
    protected OAuth2AccessToken getOAuth2AccessToken() {
        try {
            return service.getAccessTokenPasswordGrant(username, password);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get oauth token", e);
        }
    }

    @Override
    protected OAuthFlow getFlow() {
        return OAuthFlow.PASSWORD;
    }

    /**
     * Configures Oauth password grant flow
     * Note: this flow is deprecated.
     *
     * @param username
     * @param password
     * @param clientId
     * @param clientSecret
     */
    public void configure(String username, String password, String clientId, String clientSecret) {
        this.username = username;
        this.password = password;
        //TODO the clientId and secret are optional according with the RFC
        service = getAuth20Service(clientId, clientSecret);
    }

	OAuth20Service getAuth20Service(String clientId, String clientSecret) {
		return new ServiceBuilder(clientId)
				.apiSecret(clientSecret)
				.defaultScope(scopes)
				.build(new DefaultApi20Impl(authorizationUrl, tokenUrl));
	}
}
