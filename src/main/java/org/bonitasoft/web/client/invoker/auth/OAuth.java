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

import java.util.Collection;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.oauth.OAuth20Service;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public abstract class OAuth implements RequestInterceptor {

    //https://datatracker.ietf.org/doc/html/rfc7519#section-4.1.4
    static final int LEEWAY_SECONDS = 10;

    static final int MILLIS_PER_SECOND = 1000;

    public interface AccessTokenListener {

        void notify(OAuth2AccessToken token);
    }

    private volatile String accessToken;
    private Long expirationTimeSeconds;
    private AccessTokenListener accessTokenListener;

    protected OAuth20Service service;
    protected String scopes;
    protected String authorizationUrl;
    protected String tokenUrl;

    public OAuth(String authorizationUrl, String tokenUrl, String scopes) {
        this.scopes = scopes;
        this.authorizationUrl = authorizationUrl;
        this.tokenUrl = tokenUrl;
    }

    @Override
    public void apply(RequestTemplate template) {
        // If the request already have an authorization (eg. Basic auth), do nothing
        if (requestContainsNonOauthAuthorization(template)) {
            return;
        }
        String accessToken = getAccessToken();
        if (accessToken != null) {
            template.removeHeader("Authorization");
            template.header("Authorization", "Bearer " + accessToken);
        }
    }

    private boolean requestContainsNonOauthAuthorization(RequestTemplate template) {
        Collection<String> authorizations = template.headers().get("Authorization");
        if (authorizations == null) {
            return false;
        }
        return !authorizations.stream()
                .anyMatch(authHeader -> !authHeader.equalsIgnoreCase("Bearer"));
    }

    private synchronized void updateAccessToken() {
        OAuth2AccessToken accessTokenResponse;
        accessTokenResponse = getOAuth2AccessToken();
        if (accessTokenResponse != null && accessTokenResponse.getAccessToken() != null) {
            setAccessToken(accessTokenResponse.getAccessToken(), accessTokenResponse.getExpiresIn());
            if (accessTokenListener != null) {
                accessTokenListener.notify(accessTokenResponse);
            }
        }
    }

    abstract OAuth2AccessToken getOAuth2AccessToken();

    abstract OAuthFlow getFlow();

    public synchronized void registerAccessTokenListener(AccessTokenListener accessTokenListener) {
        this.accessTokenListener = accessTokenListener;
    }

    public synchronized String getAccessToken() {
        // If first time, get the token
        if (expirationTimeSeconds == null || System.currentTimeMillis() >= expirationTimeSeconds * MILLIS_PER_SECOND) {
            updateAccessToken();
        }
        return accessToken;
    }

    /**
     * Manually sets the access token
     * 
     * @param accessToken The access token
     * @param expiresIn Seconds until the token expires
     */
    public synchronized void setAccessToken(String accessToken, Integer expiresIn) {
        this.accessToken = accessToken;
        this.expirationTimeSeconds = expiresIn == null ? null
                : System.currentTimeMillis() / MILLIS_PER_SECOND + expiresIn - LEEWAY_SECONDS;
    }

}
