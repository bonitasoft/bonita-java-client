package org.bonitasoft.web.client.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.bonitasoft.web.client.api.*;
import org.bonitasoft.web.client.exception.ClientException;
import org.bonitasoft.web.client.exception.LicenseException;
import org.bonitasoft.web.client.exception.NotFoundException;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.*;
import org.bonitasoft.web.client.services.UserService;
import org.bonitasoft.web.client.services.policies.OrganizationImportPolicy;
import org.bonitasoft.web.client.services.policies.ProfileImportPolicy;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
            String message = format("Profile import of %s file skipped: your current Bonita license is 'Community' and this feature is only supported in 'Subscription' editions.", profiles.getName());
            throw new LicenseException(message);
        }
        log.info("Importing profiles from {} with {}...", profiles.getName(), policy);

        if (ProfileImportPolicy.IGNORE_IF_ANY_EXISTS.equals(policy)) {
            List<String> profilesNames = getProfilesNames(profiles);
            List<String> existingProfiles = new ArrayList<>();
            for (String profileName : profilesNames) {
                if (getProfileByName(profileName) != null) {
                    existingProfiles.add(profileName);
                }
            }
            if (!existingProfiles.isEmpty()) {
                // Skip all if any exist
                return;
            }
            //replace by policy supported by Bonita portal
            policy = ProfileImportPolicy.REPLACE_DUPLICATES;
        }

        ProfileApi profileApi = apiProvider.get(ProfileApi.class);
        log.debug("Uploading profiles file...");
        String uploadedFileName = profileApi.uploadprofiles(profiles);
        log.debug("Installing profiles file...");
        profileApi.importProfiles(uploadedFileName, policy.name());
        log.info("Profiles imported");
    }

    private List<String> getProfilesNames(File profiles) {
        List<String> tokens = new ArrayList<>();
        try {
            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setNamespaceAware(false);
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document doc = builder.parse(profiles);
            XPath xPath = XPathFactory.newInstance().newXPath();
            XPathExpression compile = xPath.compile("/profiles/profile/@name");
            NodeList evaluate1 = (NodeList) compile.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < evaluate1.getLength(); i++) {
                Node item = evaluate1.item(i);
                tokens.add(item.getNodeValue());
            }
        } catch (XPathExpressionException | IOException | SAXException | ParserConfigurationException e) {
            throw new ClientException("Failed to read profile names from file: " + profiles.getName(), e);
        }
        return tokens;
    }

    @Override
    public List<Profile> searchProfiles(int page, int count) {
        ProfileApi.SearchProfilesQueryParams params = new ProfileApi.SearchProfilesQueryParams()
                .p(page).c(count)
                .o("name ASC");
        return searchProfiles(params);
    }

    @Override
    public Role getRoleByName(String name) {
        return searchRoles(new RoleApi.SearchRolesQueryParams()
                .p(0).c(1)
                .f(singletonList("name=" + name))
        ).stream().findFirst().orElseThrow(() -> new NotFoundException("Role with name '" + name + "' not found"));
    }

    @Override
    public Profile getProfileByName(String name) {
        return searchProfiles(new ProfileApi.SearchProfilesQueryParams()
                .p(0).c(1)
                .f(singletonList("name=" + name))
        ).stream().findFirst().orElseThrow(() -> new NotFoundException("Profile with name  '" + name + "' not found"));
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
                .memberType(ProfileMemberCreateRequest.MemberTypeEnum.USER)
                .userId(userId)
                .profileId(profileId)
        );
        log.info("User membership added to profile {}. Membership: {}", profileId, profileMember);
        return profileMember.getId();
    }

    @Override
    public String addRoleToProfile(String roleId, String profileId) {
        log.info("Add role {} to profile {}...", roleId, profileId);
        ProfileMemberApi profileMemberApi = apiProvider.get(ProfileMemberApi.class);
        ProfileMember profileMember = profileMemberApi.createProfileMember(new ProfileMemberCreateRequest()
                .memberType(ProfileMemberCreateRequest.MemberTypeEnum.ROLE)
                .roleId(roleId)
                .profileId(profileId)
        );
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
