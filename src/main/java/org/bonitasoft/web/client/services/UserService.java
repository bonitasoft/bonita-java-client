package org.bonitasoft.web.client.services;

import java.io.File;
import java.util.List;
import org.bonitasoft.web.client.api.ProfileApi;
import org.bonitasoft.web.client.api.RoleApi;
import org.bonitasoft.web.client.api.UserApi;
import org.bonitasoft.web.client.model.Profile;
import org.bonitasoft.web.client.model.Role;
import org.bonitasoft.web.client.model.User;
import org.bonitasoft.web.client.model.UserCreateRequest;
import org.bonitasoft.web.client.services.policies.OrganizationImportPolicy;
import org.bonitasoft.web.client.services.policies.ProfileImportPolicy;

public interface UserService {

  void importOrganization(File organization, OrganizationImportPolicy policy);

  User getUser(String username);

  User createUser(UserCreateRequest userCreateRequest);

  List<User> searchUsers(UserApi.SearchUsersQueryParams params);

  void importProfiles(File profiles, ProfileImportPolicy policy);

  List<Profile> searchProfiles(int page, int count);

  List<Profile> searchProfiles(ProfileApi.SearchProfilesQueryParams params);

  String addUserToProfile(String userId, String profileId);

  List<Role> searchRoles(RoleApi.SearchRolesQueryParams params);

  Role getRoleByName(String name);

  Profile getProfileByName(String name);

  String addRoleToProfile(String roleId, String profileId);

  String addUserToProfileByNames(String username, String profileName);
}
