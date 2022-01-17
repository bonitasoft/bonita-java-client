package org.bonitasoft.web.client.services.impl;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.bonitasoft.web.client.TestUtils.getClasspathFile;
import static org.bonitasoft.web.client.invoker.EncodingUtils.encode;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.UUID;

import org.bonitasoft.web.client.api.OrganizationApi;
import org.bonitasoft.web.client.api.ProfileApi;
import org.bonitasoft.web.client.api.RoleApi;
import org.bonitasoft.web.client.api.UserApi;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.Profile;
import org.bonitasoft.web.client.model.RoleCreateRequest;
import org.bonitasoft.web.client.model.User;
import org.bonitasoft.web.client.services.impl.base.ClientContext;
import org.bonitasoft.web.client.services.policies.OrganizationImportPolicy;
import org.bonitasoft.web.client.services.policies.ProfileImportPolicy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class DefaultUserServiceTest {

    @InjectMocks
    private DefaultUserService service;
    @Mock
    private ClientContext clientContext;
    @Mock
    private ApiProvider apiProvider;
    @Mock
    private ObjectMapper objectMapper;
    @Mock
    private RoleApi roleApi;



    @Test
    void orga_should_be_imported() throws Exception {
        // Given
        final OrganizationApi organizationApi = mock(OrganizationApi.class);
        when(apiProvider.get(OrganizationApi.class)).thenReturn(organizationApi);
        when(organizationApi.uploadOrganization(any())).thenReturn(UUID.randomUUID().toString());

        final File organization = getClasspathFile("/Organization_Data.xml");
        // When
        service.importOrganization(organization, OrganizationImportPolicy.MERGE_DUPLICATES);
        // Then
        verify(organizationApi).uploadOrganization(organization);
        verify(organizationApi)
                .importOrganization(anyString(), eq(OrganizationImportPolicy.MERGE_DUPLICATES.name()));
    }

    @Test
    void user_should_be_found_by_name() {
        // Given
        UserApi userApi = mock(UserApi.class);
        when(apiProvider.get(UserApi.class)).thenReturn(userApi);
        final User mockUser = mock(User.class);
        when(userApi.searchUsers(anyMap())).thenReturn(singletonList(mockUser));
        final ArgumentCaptor<UserApi.SearchUsersQueryParams> captor = ArgumentCaptor
                .forClass(UserApi.SearchUsersQueryParams.class);
        final String username = "walter.bates";

        // When
        service.getUser(username);

        // Then
        verify(userApi).searchUsers(captor.capture());
        final UserApi.SearchUsersQueryParams searchParams = captor.getValue();
        assertThat(searchParams)
                .contains(new SimpleEntry<>("p", "0"))
                .contains(new SimpleEntry<>("c", "1"))
                .contains(new SimpleEntry<>("f", singletonList(encode("userName=" + username))));
    }

    @Test
    void no_profiles_exist_should_not_raise_not_found_ex() {
        // Given
        ProfileApi profileApi = mock(ProfileApi.class);
        when(apiProvider.get(ProfileApi.class)).thenReturn(profileApi);

        final String profile1name = "profile1name";
        final String profile2name = "profile2name";
        when(profileApi.searchProfiles(anyMap())).thenReturn(emptyList());

        // When
        final boolean anyProfileExist = service.anyProfileExist(asList(profile1name, profile2name));

        // Then
        assertThat(anyProfileExist).isFalse();
    }

    @Test
    void one_profiles_exist_should_not_raise_not_found_ex() {
        // Given
        ProfileApi profileApi = mock(ProfileApi.class);
        when(apiProvider.get(ProfileApi.class)).thenReturn(profileApi);

        final String profile1name = "profile1name";
        final String profile2name = "profile2name";
        when(profileApi.searchProfiles(anyMap()))
                // first call
                .thenReturn(emptyList())
                // second call
                .thenReturn(singletonList(new Profile().name(profile2name)));

        // When
        final boolean anyProfileExist = service.anyProfileExist(asList(profile1name, profile2name));

        // Then
        assertThat(anyProfileExist).isTrue();
    }

    @Test
    void importProfiles_with_IGNORE_IF_ANY_EXISTS_on_existing_should_skip_import() throws Exception {
        // Given
        ProfileApi profileApi = mock(ProfileApi.class);
        when(apiProvider.get(ProfileApi.class)).thenReturn(profileApi);
        // Enterprise feature only
        service = spy(service);
        doReturn(false).when(service).isCommunity();

        // pretend profile exist
        when(profileApi.searchProfiles(anyMap())).thenReturn(singletonList(new Profile()));

        // When
        final File profileFile = getClasspathFile("/CustomProfile_Data.xml");
        final ProfileImportPolicy importPolicy = ProfileImportPolicy.IGNORE_IF_ANY_EXISTS;
        service.importProfiles(profileFile, importPolicy);

        // Then
        verify(profileApi, never()).uploadprofiles(profileFile);
        verify(profileApi, never()).importProfiles(anyString(), eq(importPolicy.name()));
    }

    @Test
    void importProfiles_with_IGNORE_IF_ANY_EXISTS_none_existing_should_use_REPLACE_DUPLICATES()
            throws Exception {
        // Given
        ProfileApi profileApi = mock(ProfileApi.class);
        when(apiProvider.get(ProfileApi.class)).thenReturn(profileApi);

        when(profileApi.uploadprofiles(any())).thenReturn(UUID.randomUUID().toString());

        // Enterprise feature only
        service = spy(service);
        doReturn(false).when(service).isCommunity();
        // pretend no profile exist
        doReturn(false).when(service).anyProfileExist(anyList());

        // When
        final File profileFile = getClasspathFile("/CustomProfile_Data.xml");
        service.importProfiles(profileFile, ProfileImportPolicy.IGNORE_IF_ANY_EXISTS);

        // Then
        verify(profileApi).uploadprofiles(profileFile);

        final ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(profileApi).importProfiles(anyString(), captor.capture());
        assertThat(captor.getValue()).isEqualTo(ProfileImportPolicy.REPLACE_DUPLICATES.name());
    }

    @Test
    void can_read_profile_file() throws Exception {
        // Given
        final File profileFile = getClasspathFile("/CustomProfile_Data.xml");
        // When
        final List<String> profilesNames = service.getProfilesNames(profileFile);
        // Then
        assertThat(profilesNames)
                .hasSize(7)
                .contains(
                        "Administrator",
                        "HR",
                        "HRManager",
                        "Process manager",
                        "TahitiUser",
                        "TeamManager",
                        "User");
    }

    @Test
    void should_create_role() {
        when(apiProvider.get(RoleApi.class)).thenReturn(roleApi);
        RoleCreateRequest createRequest = new RoleCreateRequest().name("newRole");

        service.createRole(createRequest);

        verify(roleApi).createRole(createRequest);
    }
}
