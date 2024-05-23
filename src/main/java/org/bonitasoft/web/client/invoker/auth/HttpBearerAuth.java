/** 
 * Copyright (C) 2024 BonitaSoft S.A.
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

import java.util.Optional;
import java.util.function.Supplier;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * An interceptor that adds the request header needed to use HTTP bearer authentication.
 */
public class HttpBearerAuth implements RequestInterceptor {

    private final String scheme;
    private Supplier<String> tokenSupplier;

    public HttpBearerAuth(String scheme) {
        this.scheme = scheme;
    }

    /**
     * Gets the token, which together with the scheme, will be sent as the value of the Authorization header.
     *
     * @return The bearer token
     */
    public String getBearerToken() {
        return tokenSupplier.get();
    }

    /**
     * Sets the token, which together with the scheme, will be sent as the value of the Authorization header.
     *
     * @param bearerToken The bearer token to send in the Authorization header
     */
    public void setBearerToken(String bearerToken) {
        this.tokenSupplier = () -> bearerToken;
    }

    /**
     * Sets the supplier of tokens, which together with the scheme, will be sent as the value of the Authorization header.
     *
     * @param tokenSupplier The supplier of bearer tokens to send in the Authorization header
     */
    public void setBearerToken(Supplier<String> tokenSupplier) {
        this.tokenSupplier = tokenSupplier;
    }

    @Override
    public void apply(RequestTemplate template) {
        String bearerToken = Optional.ofNullable(tokenSupplier).map(Supplier::get).orElse(null);
        if (bearerToken == null) {
            return;
        }

        template.header("Authorization", (scheme != null ? upperCaseBearer(scheme) + " " : "") + bearerToken);
    }

    private static String upperCaseBearer(String scheme) {
        return ("bearer".equalsIgnoreCase(scheme)) ? "Bearer" : scheme;
    }
}
