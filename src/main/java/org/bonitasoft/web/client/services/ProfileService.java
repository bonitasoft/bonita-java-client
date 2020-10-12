package org.bonitasoft.web.client.services;

import org.bonitasoft.web.client.api.ProfileApi;
import org.bonitasoft.web.client.api.RoleApi;
import org.bonitasoft.web.client.model.Profile;
import org.bonitasoft.web.client.model.Role;
import org.bonitasoft.web.client.services.policies.ProfileImportPolicy;

import java.io.File;
import java.util.List;

public interface ProfileService {

    void importProfiles(File content, ProfileImportPolicy policy);

    List<Profile> searchProfiles(int page, int count);

    List<Profile> searchProfiles(ProfileApi.SearchProfilesQueryParams params);

    String addUserToProfile(String userId, String profileId);

    List<Role> searchRoles(RoleApi.SearchRolesQueryParams params);

    Role getRoleByName(String name);

    Profile getProfileByName(String name);

    String addRoleToProfile(String roleId, String profileId);

    String addUserToProfileByNames(String username, String profileName);
}
