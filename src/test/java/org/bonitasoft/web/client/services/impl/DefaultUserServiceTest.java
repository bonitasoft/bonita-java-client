package org.bonitasoft.web.client.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bonitasoft.web.client.api.OrganizationApi;
import org.bonitasoft.web.client.api.UserApi;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.User;
import org.bonitasoft.web.client.services.policies.OrganizationImportPolicy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.AbstractMap.SimpleEntry;
import java.util.UUID;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.bonitasoft.web.client.TestUtils.getClasspathFile;
import static org.bonitasoft.web.client.invoker.EncodingUtils.encode;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

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

    @Test
    void orga_should_be_imported() throws Exception {
        // Given
        final OrganizationApi organizationApi = mock(OrganizationApi.class);
        when(apiProvider.get(eq(OrganizationApi.class))).thenReturn(organizationApi);
        when(organizationApi.uploadOrganization(any())).thenReturn(UUID.randomUUID().toString());

        final File organization = getClasspathFile("/Organization_Data.xml");
        // When
        service.importOrganization(organization, OrganizationImportPolicy.MERGE_DUPLICATES);
        // Then
        verify(organizationApi).uploadOrganization(organization);
        verify(organizationApi).importOrganization(anyString(), eq(OrganizationImportPolicy.MERGE_DUPLICATES.name()));
    }

    @Test
    void user_should_be_found_by_name() {
        // Given
        UserApi userApi = mock(UserApi.class);
        when(apiProvider.get(UserApi.class)).thenReturn(userApi);
        final User mockUser = mock(User.class);
        when(userApi.searchUsers(anyMap())).thenReturn(singletonList(mockUser));
        final ArgumentCaptor<UserApi.SearchUsersQueryParams> captor = ArgumentCaptor.forClass(UserApi.SearchUsersQueryParams.class);
        final String username = "walter.bates";

        // When
        final User user = service.getUser(username);

        // Then
        verify(userApi).searchUsers(captor.capture());
        final UserApi.SearchUsersQueryParams searchParams = captor.getValue();
        assertThat(searchParams).contains(new SimpleEntry<>("p", "0"));
        assertThat(searchParams).contains(new SimpleEntry<>("c", "1"));
        assertThat(searchParams).contains(new SimpleEntry<>("f", singletonList(encode("userName=" + username))));
    }

}