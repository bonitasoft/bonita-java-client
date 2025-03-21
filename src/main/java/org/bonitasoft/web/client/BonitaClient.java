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
package org.bonitasoft.web.client;

import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.feign.BonitaFeignClientBuilderImpl;
import org.bonitasoft.web.client.model.Session;
import org.bonitasoft.web.client.services.ApplicationService;
import org.bonitasoft.web.client.services.BdmService;
import org.bonitasoft.web.client.services.ProcessService;
import org.bonitasoft.web.client.services.SystemService;
import org.bonitasoft.web.client.services.UserService;

/** A Bonita client that communicate via http request with a Bonita running instance. */
public interface BonitaClient extends ApiProvider {

    String USER_PROFILE_NAME = "User";

    String ADMIN_PROFILE_NAME = "Administrator";

    /**
     * Create a client builder for the given bonita URL
     *
     * @param url the bonita instance url
     * @return a builder instance
     */
    static <T extends BonitaClientBuilder<T>> BonitaClientBuilder<T> builder(String url) {
        return (BonitaClientBuilder<T>) new BonitaFeignClientBuilderImpl(url);
    }

    /**
     * Perform client authentication. Authentication will be stored internally to be used for the
     * future requests <br>
     *
     * @param username Account username
     * @param password Account password
     * @return A session with the authenticated user info
     * @throws org.bonitasoft.web.client.exception.UnauthorizedException if authentication failed
     */
    Session login(String username, String password);

    /**
     * Set Bearer authorization header token
     * Can be used to pass an Oauth2 access token when Bonita is configured for SSO with OpenID Connect
     *
     * @param token the bearer token (Oauth2 access token)
     */
    void setBearerToken(String token);

    /** Logout the current user */
    void logout();

    /** Logout the current user (with no exceptions) */
    void logoutSilent();

    /**
     * Return true if platform is up
     *
     * @return
     */
    boolean isPlatformUpAndRunning();

    /**
     * The Bonita target url (ie. http://localhost:8080/bonita/)
     *
     * @return
     */
    String getUrl();

    /**
     * The targeted Bonita version
     *
     * @return
     */
    String getVersion();

    /**
     * Return the application API
     *
     * @return
     */
    ApplicationService applications();

    /**
     * Return the BDM API
     *
     * @return
     */
    BdmService bdm();

    /**
     * Return the user API
     *
     * @return
     */
    UserService users();

    /**
     * Return the process API
     *
     * @return
     */
    ProcessService processes();

    /**
     * Return the system service
     *
     * @return
     */
    SystemService system();
}
