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
package org.bonitasoft.web.client.services;

import java.io.File;
import java.util.List;

import org.bonitasoft.web.client.api.ProfileApi;
import org.bonitasoft.web.client.api.RoleApi;
import org.bonitasoft.web.client.api.UserApi;
import org.bonitasoft.web.client.model.Group;
import org.bonitasoft.web.client.model.GroupCreateRequest;
import org.bonitasoft.web.client.model.Profile;
import org.bonitasoft.web.client.model.ProfileCreateRequest;
import org.bonitasoft.web.client.model.Role;
import org.bonitasoft.web.client.model.RoleCreateRequest;
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

    Role createRole(RoleCreateRequest roleCreateRequest);

    Role getRoleByName(String name);

    Group createGroup(GroupCreateRequest groupCreateRequest);

    Profile getProfileByName(String name);

    Profile createProfile(ProfileCreateRequest profileCreateRequest);

    String addRoleToProfile(String roleId, String profileId);

    String addUserToProfileByNames(String username, String profileName);
}
