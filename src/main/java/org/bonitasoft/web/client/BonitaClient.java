package org.bonitasoft.web.client;

import org.bonitasoft.web.client.feign.BonitaFeignClientBuilderImpl;
import org.bonitasoft.web.client.model.Session;
import org.bonitasoft.web.client.services.*;

public interface BonitaClient {

    String DEFAULT_TENANT_ID = "1";
    String USER_PROFILE_NAME = "User";
    String ADMIN_PROFILE_NAME = "Administrator";

    static BonitaClientBuilder builder(String url) {
        return new BonitaFeignClientBuilderImpl(url);
    }

    Session login(String username, String password);

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
