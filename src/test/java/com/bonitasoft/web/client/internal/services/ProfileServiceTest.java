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
import com.bonitasoft.web.client.internal.api.ProfileAPI;
import com.bonitasoft.web.client.internal.security.SecurityContext;
import com.bonitasoft.web.client.model.Profile;
import com.bonitasoft.web.client.policies.ProfileImportPolicy;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import retrofit2.Call;
import retrofit2.mock.Calls;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProfileServiceTest {

    private final String profileTestXmlFile = "" +
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<profiles:profiles xmlns:profiles=\"http://www.bonitasoft.org/ns/profile/6.1\">\n" +
            "    <profile name=\"P1\">\n" +
            "    </profile>\n" +
            "    <profile name=\"P2\">\n" +
            "    </profile>\n" +
            "    <profile name=\"P3\">\n" +
            "    </profile>\n" +
            "</profiles:profiles>";
    @TempDir
    File temporaryFolder;
    @Mock
    private ProfileAPI profileAPI;
    @Mock
    private SecurityContext securityContext;
    @Mock
    private ImportNotifier importNotifier;
    @InjectMocks
    private ProfileService profileService;

    @Test
    void should_not_import_profile_if_some_already_exists_with_policy_IGNORE_IF_ANY_EXISTS() throws Exception {
        when(profileAPI.search(0, 1, "name=P1")).thenReturn(Calls.response(emptyList()));
        when(profileAPI.search(0, 1, "name=P2")).thenReturn(aCallThatReturnAProfile(2L));
        when(profileAPI.search(0, 1, "name=P3")).thenReturn(aCallThatReturnAProfile(3L));

        profileService.importProfiles(getTestFile(), ProfileImportPolicy.IGNORE_IF_ANY_EXISTS);

        verify(profileAPI, never()).uploadContent(any());
        verify(profileAPI, never()).importFromUploadedFile(any(), anyString());
        verify(importNotifier).post(argThat(warn -> warn.getMessage().contains("P2, P3")));
    }

    @Test
    void should_import_profile_if_none_already_exists_with_policy_IGNORE_IF_ANY_EXISTS() throws Exception {
        when(profileAPI.search(0, 1, "name=P1")).thenReturn(Calls.response(emptyList()));
        when(profileAPI.search(0, 1, "name=P2")).thenReturn(Calls.response(emptyList()));
        when(profileAPI.search(0, 1, "name=P3")).thenReturn(Calls.response(emptyList()));

        when(profileAPI.uploadContent(any())).thenReturn(Calls.response("uploaded"));
        when(profileAPI.importFromUploadedFile(any(), anyString())).thenReturn(Calls.response(ResponseBody.create(MediaType.parse("plain/test"), "done")));

        profileService.importProfiles(getTestFile(), ProfileImportPolicy.IGNORE_IF_ANY_EXISTS);

        verify(profileAPI).uploadContent(any());
        verify(profileAPI).importFromUploadedFile(any(), eq(ProfileImportPolicy.REPLACE_DUPLICATES.name()));
    }

    @Test
    void should_import_profile_even_if_some_already_exists_with_policy_REPLACE_DUPLICATES() throws Exception {
        when(profileAPI.uploadContent(any())).thenReturn(Calls.response("uploaded"));
        when(profileAPI.importFromUploadedFile(any(), anyString())).thenReturn(Calls.response(ResponseBody.create(MediaType.parse("plain/test"), "done")));

        profileService.importProfiles(getTestFile(), ProfileImportPolicy.REPLACE_DUPLICATES);

        verify(profileAPI).uploadContent(any());
        verify(profileAPI).importFromUploadedFile(any(), anyString());
        verify(profileAPI, never()).search(anyInt(), anyInt(), any());
    }

    private File getTestFile() throws IOException {
        File file = new File(temporaryFolder, "profiles.xml");
        Files.write(file.toPath(), profileTestXmlFile.getBytes(StandardCharsets.UTF_8));
        return file;
    }

    private Call<List<Profile>> aCallThatReturnAProfile(Long id) {
        Profile profile = new Profile();
        profile.setId(id);
        return Calls.response(singletonList(profile));
    }

}
