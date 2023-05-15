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

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class OauthClientCredentialsGrant extends OAuth {

    public OauthClientCredentialsGrant(String authorizationUrl, String tokenUrl, String scopes) {
        super(authorizationUrl, tokenUrl, scopes);
    }

    @Override
    protected OAuth2AccessToken getOAuth2AccessToken() {
        try {
            return service.getAccessTokenClientCredentialsGrant(scopes);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get oauth token", e);
        }
    }

    @Override
    protected OAuthFlow getFlow() {
        return OAuthFlow.APPLICATION;
    }

    /**
     * Configures the client credentials flow
     *
     * @param clientId
     * @param clientSecret
     */
    public void configure(String clientId, String clientSecret) {
        service = new ServiceBuilder(clientId)
                .apiSecret(clientSecret)
                .defaultScope(scopes)
                .build(new DefaultApi20Impl(authorizationUrl, tokenUrl));
    }
}
