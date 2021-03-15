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

    String DEFAULT_TENANT_ID = "1";
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
     * Account tenant default to 1
     *
     * @param username Account username
     * @param password Account password
     * @return A session with the authenticated user info
     * @throws org.bonitasoft.web.client.exception.UnauthorizedException if authentication failed
     */
    Session login(String username, String password);

    /**
     * Perform client authentication. Authentication will be stored internally to be used for the
     * future requests
     *
     * @param username Account username
     * @param password Account password
     * @param tenant Account tenant
     * @return A session with the authenticated user info
     * @throws org.bonitasoft.web.client.exception.UnauthorizedException if authentication failed
     */
    Session login(String username, String password, String tenant);

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
     * Return the system tenant API
     *
     * @return
     */
    SystemService system();
}
