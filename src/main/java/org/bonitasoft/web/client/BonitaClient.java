package org.bonitasoft.web.client;

import org.bonitasoft.web.client.exception.UnauthorizedException;
import org.bonitasoft.web.client.feign.BonitaFeignClientBuilder;
import org.bonitasoft.web.client.feign.BonitaFeignClientBuilderImpl;
import org.bonitasoft.web.client.model.Session;
import org.bonitasoft.web.client.services.*;

import java.io.IOException;

public interface BonitaClient extends
        ApplicationService,
        BdmService,
        ConfigurationService,
        OrganizationService,
        PageService,
        ProcessService,
        ProfileService,
        SystemService,
        UserTaskService {

    String DEFAULT_TENANT_ID = "1";
    String USER_PROFILE_NAME = "User";
    String ADMIN_PROFILE_NAME = "Administrator";


    static BonitaFeignClientBuilder newFeignBuilder(String url) {
        return new BonitaFeignClientBuilderImpl(url);
    }

    boolean isPlatformUpAndRunning();

    Session login(String username, String password);

    Session login(String username, String password, String tenant);

    void logout() throws IOException, UnauthorizedException;

    void logoutSilent();
}
