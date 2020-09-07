/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.services;

import com.bonitasoft.web.client.event.ImportNotifier;
import com.bonitasoft.web.client.event.ImportWarningEvent;
import com.bonitasoft.web.client.exception.ClientException;
import com.bonitasoft.web.client.exception.UnauthorizedException;
import com.bonitasoft.web.client.internal.BonitaCookieInterceptor;
import com.bonitasoft.web.client.internal.api.ProfileAPI;
import com.bonitasoft.web.client.internal.services.model.CreateProfileMembership;
import com.bonitasoft.web.client.model.Profile;
import com.bonitasoft.web.client.model.ProfileMembership;
import com.bonitasoft.web.client.model.User;
import com.bonitasoft.web.client.policies.ProfileImportPolicy;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import retrofit2.Response;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfileService extends ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileService.class);
    private final BonitaCookieInterceptor bonitaCookieInterceptor;
    private final ProfileAPI profileAPI;
    private final IdentityService identityService;
    private ImportNotifier importNotifier;

    public ProfileService(BonitaCookieInterceptor bonitaCookieInterceptor, ProfileAPI profileAPI, IdentityService identityService,
                          ImportNotifier importNotifier) {
        this.bonitaCookieInterceptor = bonitaCookieInterceptor;
        this.profileAPI = profileAPI;
        this.identityService = identityService;
        this.importNotifier = importNotifier;
    }

    public Profile getProfile(String name)
            throws UnauthorizedException, IOException {
        LOGGER.debug("Retrieving profile '{}'", name);
        bonitaCookieInterceptor.checkLogged();
        Response<List<Profile>> response = profileAPI.search(0, 1, "name=" + name).execute();
        checkResponse(response);
        List<Profile> body = response.body();
        if (body == null || body.isEmpty()) {
            LOGGER.debug("Can't find any existing profile with the name '{}'.", name);
            return null;
        }
        LOGGER.debug("Profile '{}' retrieved successfully.", name);
        return body.get(0);
    }

    public void importProfiles(File content, ProfileImportPolicy policy)
            throws IOException, UnauthorizedException {
        LOGGER.info("Deploying profiles in '{}' using policy {} ...", content.getName(), policy.name());
        bonitaCookieInterceptor.checkLogged();
        if (policy.equals(ProfileImportPolicy.IGNORE_IF_ANY_EXISTS)) {
            List<String> profilesNames = getProfilesNames(content);
            List<String> existingProfiles = new ArrayList<>();
            for (String profileName : profilesNames) {
                if (getProfile(profileName) != null) {
                    existingProfiles.add(profileName);
                }
            }
            if (!existingProfiles.isEmpty()) {
                importNotifier.post(new ImportWarningEvent(
                        "Profiles not imported because some already exists (policy is IGNORE_IF_ANY_EXISTS): "
                                + existingProfiles));
                return;
            }
            //replace by policy supported by Bonita portal
            policy = ProfileImportPolicy.REPLACE_DUPLICATES;
        }
        RequestBody requestFile = RequestBody.create(MultipartBody.FORM, content);
        MultipartBody.Part body = MultipartBody.Part.createFormData("Profile_Data.xml", "Profile_Data.xml",
                requestFile);

        LOGGER.debug("Uploading profile file...");
        Response<String> responseUpload = profileAPI.uploadContent(body).execute();
        checkResponse(responseUpload);
        LOGGER.debug("Profile file uploaded successfully.");
        String uploadedFile = responseUpload.body();

        Response<ResponseBody> responseImport = profileAPI.importFromUploadedFile(uploadedFile, policy.name())
                .execute();
        checkResponse(responseImport);
        LOGGER.info("Profiles in '{}' deployed successfully.", content.getName());

    }

    private List<String> getProfilesNames(File content) throws IOException {
        List<String> tokens = new ArrayList<>();
        try {
            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setNamespaceAware(false);
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document doc = builder.parse(content);
            XPath xPath = XPathFactory.newInstance().newXPath();
            XPathExpression compile = xPath.compile("/profiles/profile/@name");
            NodeList evaluate1 = (NodeList) compile.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < evaluate1.getLength(); i++) {
                Node item = evaluate1.item(i);
                tokens.add(item.getNodeValue());
            }

        } catch (XPathExpressionException | FileNotFoundException | SAXException | ParserConfigurationException e) {
            throw new IOException(e);
        }
        return tokens;
    }

    public List<Profile> searchProfiles(int page, int count) throws IOException, UnauthorizedException {
        bonitaCookieInterceptor.checkLogged();
        Response<List<Profile>> response = profileAPI.search(page, count).execute();
        checkResponse(response);
        return response.body();

    }

    /**
     * @param userId
     * @param profileId
     * @return return the membership id
     * @throws IOException
     * @throws UnauthorizedException
     */
    public long addUserToProfile(long userId, long profileId) throws ClientException, IOException {
        CreateProfileMembership createProfileMembership = new CreateProfileMembership()
                .setProfileId(profileId)
                .setMembershipType(CreateProfileMembership.Type.USER)
                .setUserId(userId);
        Response<ProfileMembership> response = profileAPI.addProfileMember(createProfileMembership).execute();
        checkResponse(response);
        ProfileMembership membership = response.body();
        if (membership == null) {
            throw new ClientException("Failed to parse membership response");
        }
        return membership.getId();
    }

    public long addUserToProfile(String username, String profileName) throws IOException, ClientException {
        bonitaCookieInterceptor.checkLogged();
        Profile profile = getProfile(profileName);
        User user = identityService.getUser(username);
        return addUserToProfile(user.getId(), profile.getId());
    }
}
