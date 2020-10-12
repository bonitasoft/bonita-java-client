package org.bonitasoft.web.client.services;

import org.bonitasoft.web.client.api.UserApi;
import org.bonitasoft.web.client.model.User;
import org.bonitasoft.web.client.model.UserCreateRequest;
import org.bonitasoft.web.client.services.policies.OrganizationImportPolicy;

import java.io.File;
import java.util.List;

public interface OrganizationService {
    void importOrganization(File content, OrganizationImportPolicy policy);

    User getUser(String username);

    User createUser(UserCreateRequest userCreateRequest);

    List<User> searchUsers(UserApi.SearchUsersQueryParams params);
}
