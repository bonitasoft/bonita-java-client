package org.bonitasoft.web.client.services;

import org.bonitasoft.web.client.model.Profile;
import org.bonitasoft.web.client.services.policies.ProfileImportPolicy;

import java.io.File;
import java.util.List;

public interface ProfileService {

    void importProfiles(File content, ProfileImportPolicy policy);

    List<Profile> searchProfiles(int page, int count);

    long addUserToProfile(long userId, long profileId);

    long addUserToProfile(String username, String profileName);
}
