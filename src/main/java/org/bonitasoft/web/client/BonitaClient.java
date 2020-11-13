package org.bonitasoft.web.client;

import org.bonitasoft.web.client.feign.BonitaFeignClientBuilderImpl;
import org.bonitasoft.web.client.model.Session;
import org.bonitasoft.web.client.services.*;

/** A Bonita client that communicate via http request with a Bonita running instance. */
public interface BonitaClient {

  String DEFAULT_TENANT_ID = "1";
  String USER_PROFILE_NAME = "User";
  String ADMIN_PROFILE_NAME = "Administrator";

  /**
   * Create a client builder for the given bonita URL
   *
   * @param url the bonita instance url
   * @return a builder instance
   */
  static BonitaClientBuilder<?> builder(String url) {
    return new BonitaFeignClientBuilderImpl(url);
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
   * /** Perform client authentication. Authentication will be stored internally to be used for the
   * future requests
   *
   * @param username Account username
   * @param password Account password
   * @throws org.bonitasoft.web.client.exception.UnauthorizedException if authentication failed
   * @param tenant Account tenant
   * @return A session with the authenticated user info
   */
  Session login(String username, String password, String tenant);

  void logout();

  void logoutSilent();

  boolean isPlatformUpAndRunning();

  String getUrl();

  String getVersion();

  ApplicationService applications();

  BdmService bdm();

  UserService users();

  ProcessService processes();

  SystemService system();
}
