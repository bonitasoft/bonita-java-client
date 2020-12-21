package org.bonitasoft.web.client.services.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.bonitasoft.web.client.api.OrganizationApi;
import org.bonitasoft.web.client.api.ProfileApi;
import org.bonitasoft.web.client.api.ProfileMemberApi;
import org.bonitasoft.web.client.api.RoleApi;
import org.bonitasoft.web.client.api.UserApi;
import org.bonitasoft.web.client.exception.LicenseException;
import org.bonitasoft.web.client.exception.NotFoundException;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.Profile;
import org.bonitasoft.web.client.model.ProfileMember;
import org.bonitasoft.web.client.model.ProfileMemberCreateRequest;
import org.bonitasoft.web.client.model.Role;
import org.bonitasoft.web.client.model.User;
import org.bonitasoft.web.client.model.UserCreateRequest;
import org.bonitasoft.web.client.services.UserService;
import org.bonitasoft.web.client.services.impl.base.AbstractService;
import org.bonitasoft.web.client.services.impl.base.ClientContext;
import org.bonitasoft.web.client.services.impl.xml.XmlDocumentParser;
import org.bonitasoft.web.client.services.policies.OrganizationImportPolicy;
import org.bonitasoft.web.client.services.policies.ProfileImportPolicy;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static java.lang.String.format;
import static java.util.Collections.singletonList;

@Slf4j
public class DefaultUserService extends AbstractService implements UserService {

	public DefaultUserService(ClientContext clientContext, ApiProvider apiProvider, ObjectMapper objectMapper) {
		super(apiProvider, objectMapper, clientContext);
	}

	@Override
	public void importOrganization(File organization, OrganizationImportPolicy policy) {
		log.info("Importing organization file: {} with policy: {}", organization.getName(), policy);
		OrganizationApi organizationApi = apiProvider.get(OrganizationApi.class);
		String uploadedFileName = organizationApi.uploadOrganization(organization);
		log.debug("Organization file uploaded");
		organizationApi.importOrganization(uploadedFileName, policy.name());
		log.debug("Organization file installed");
		log.info("Organization file imported successfully");
	}

	@Override
	public User getUser(String username) {
		log.info("Get user with username: {}", username);
		UserApi userApi = apiProvider.get(UserApi.class);
		List<String> filter = singletonList("userName=" + username);
		return userApi.searchUsers(new UserApi.SearchUsersQueryParams().p(0).c(1).f(filter)).stream().findFirst()
				.orElseThrow(() -> new NotFoundException("No user found for the username: " + username));
	}

	@Override
	public User createUser(UserCreateRequest userCreateRequest) {
		log.info("Create user with params: {}", userCreateRequest);
		UserApi userApi = apiProvider.get(UserApi.class);
		return userApi.createUser(userCreateRequest);
	}

	@Override
	public List<User> searchUsers(UserApi.SearchUsersQueryParams params) {
		log.info("Search users with params: {}", params);
		UserApi userApi = apiProvider.get(UserApi.class);
		return userApi.searchUsers(params);
	}

	@Override
	public void importProfiles(File profiles, ProfileImportPolicy policy) {
		if (isCommunity()) {
			String message = format(
					"Profile import of %s file skipped: your current Bonita license is 'Community' and this feature is only supported in 'Subscription' editions.",
					profiles.getName());
			throw new LicenseException(message);
		}
		log.info("Importing profiles from {} with {}...", profiles.getName(), policy);

		if (ProfileImportPolicy.IGNORE_IF_ANY_EXISTS.equals(policy)) {
			List<String> profilesToDeployNames = getProfilesNames(profiles);
			if (anyProfileExist(profilesToDeployNames)) {
				// Skip all if any exist
				return;
			}
			// replace by policy supported by Bonita portal
			policy = ProfileImportPolicy.REPLACE_DUPLICATES;
		}

		ProfileApi profileApi = apiProvider.get(ProfileApi.class);
		log.debug("Uploading profiles file...");
		String uploadedFileName = profileApi.uploadprofiles(profiles);
		log.debug("Installing profiles file...");
		profileApi.importProfiles(uploadedFileName, policy.name());
		log.info("Profiles imported");
	}

	/**
	 * Return true if some profile from the given list exists with the same name in the
	 * server
	 * @param profilesNames
	 * @return
	 */
	protected boolean anyProfileExist(List<String> profilesNames) {
		List<String> existingProfiles = new ArrayList<>();
		for (String profileName : profilesNames) {
			try {
				final Profile profile = getProfileByName(profileName);
				existingProfiles.add(profile.getName());
			}
			catch (NotFoundException e) {
				// Profile not found, continue
			}
		}
		return !existingProfiles.isEmpty();
	}

	protected List<String> getProfilesNames(File profiles) {
		List<String> tokens = new ArrayList<>();
		final XmlDocumentParser documentParser = new XmlDocumentParser();
		Document doc = documentParser.parse(profiles);
		NodeList nodeList = documentParser.queryNodeList(doc, "/profiles/profile/@name");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node item = nodeList.item(i);
			tokens.add(item.getNodeValue());
		}
		return tokens;
	}

	@Override
	public List<Profile> searchProfiles(int page, int count) {
		ProfileApi.SearchProfilesQueryParams params = new ProfileApi.SearchProfilesQueryParams().p(page).c(count)
				.o("name ASC");
		return searchProfiles(params);
	}

	@Override
	public Role getRoleByName(String name) {
		return searchRoles(new RoleApi.SearchRolesQueryParams().p(0).c(1).f(singletonList("name=" + name))).stream()
				.findFirst().orElseThrow(() -> new NotFoundException("Role with name '" + name + "' not found"));
	}

	@Override
	public Profile getProfileByName(String name) {
		return searchProfiles(new ProfileApi.SearchProfilesQueryParams().p(0).c(1).f(singletonList("name=" + name)))
				.stream().findFirst()
				.orElseThrow(() -> new NotFoundException("Profile with name  '" + name + "' not found"));
	}

	@Override
	public List<Role> searchRoles(RoleApi.SearchRolesQueryParams params) {
		log.info("Search roles with params: {}", params);
		return apiProvider.get(RoleApi.class).searchRoles(params);
	}

	public List<Profile> searchProfiles(ProfileApi.SearchProfilesQueryParams params) {
		log.info("Search profiles with params: {}", params);
		return apiProvider.get(ProfileApi.class).searchProfiles(params);
	}

	@Override
	public String addUserToProfile(String userId, String profileId) {
		log.info("Add user {} to profile {}...", userId, profileId);
		ProfileMemberApi profileMemberApi = apiProvider.get(ProfileMemberApi.class);
		ProfileMember profileMember = profileMemberApi.createProfileMember(new ProfileMemberCreateRequest()
				.memberType(ProfileMemberCreateRequest.MemberTypeEnum.USER).userId(userId).profileId(profileId));
		log.info("User membership added to profile {}. Membership: {}", profileId, profileMember);
		return profileMember.getId();
	}

	@Override
	public String addRoleToProfile(String roleId, String profileId) {
		log.info("Add role {} to profile {}...", roleId, profileId);
		ProfileMemberApi profileMemberApi = apiProvider.get(ProfileMemberApi.class);
		ProfileMember profileMember = profileMemberApi.createProfileMember(new ProfileMemberCreateRequest()
				.memberType(ProfileMemberCreateRequest.MemberTypeEnum.ROLE).roleId(roleId).profileId(profileId));
		log.info("Role membership added to profile {}. Membership: {}", profileId, profileMember);
		return profileMember.getId();
	}

	@Override
	public String addUserToProfileByNames(String username, String profileName) {
		User user = getUser(username);
		Profile profile = getProfileByName(profileName);
		return addUserToProfile(user.getId(), profile.getId());
	}

}
