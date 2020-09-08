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
import com.bonitasoft.web.client.internal.api.ConfigurationAPI;
import com.bonitasoft.web.client.internal.security.SecurityContext;
import com.bonitasoft.web.client.model.License;
import com.github.zafarkhaja.semver.Version;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConfigurationServiceTest {

    @TempDir
    File temporaryFolder;

    @Mock
    private SystemService systemService;
    @Mock
    private SecurityContext securityContext;
    @Mock
    private ConfigurationAPI configurationAPI;
    @Mock
    private ImportNotifier importNotifier;

    @InjectMocks
    private ConfigurationService configurationService;

    private static Version version(String version) {
        return new Version.Builder(version).build();
    }

    private static License communityLicense() {
        final License license = new License();
        license.setEdition("Community");
        return license;
    }

    private static License enterpriseLicense() {
        final License license = new License();
        license.setEdition("Enterprise");
        return license;
    }

    private static ImportWarningEvent warningEventWithMsgContaining(String cs) {
        return argThat(warningEvent -> warningEvent.getMessage().contains(cs));
    }

    // =================================================================================================================
    // UTILS
    // =================================================================================================================

    @Test
    void should_not_perform_import_configuration_for_Bonita_community_edition() throws Exception {
        //given:
        doReturn(communityLicense()).when(systemService).getLicense();

        //when:
        configurationService.importBonitaConfiguration(new File(temporaryFolder, UUID.randomUUID().toString()));

        //then:
        verify(securityContext).isAuthenticated();
        verify(importNotifier).post(warningEventWithMsgContaining("Community"));
        verifyNoInteractions(configurationAPI);
    }

    @Test
    void should_not_perform_import_configuration_for_lower_Bonita_7_8_0_versions() throws Exception {
        //given:
        doReturn(version("7.7.3")).when(systemService).getVersion();
        doReturn(enterpriseLicense()).when(systemService).getLicense();

        //when:
        configurationService.importBonitaConfiguration(new File(temporaryFolder, UUID.randomUUID().toString()));

        //then:
        verify(securityContext).isAuthenticated();
        verify(importNotifier).post(warningEventWithMsgContaining("7.7.3"));
        verifyNoInteractions(configurationAPI);
    }

    @Test
    void should_perform_import_configuration_for_greater_Bonita_7_8_0_versions() throws Exception {
        //given:
        doReturn(version("7.8.0")).when(systemService).getVersion();
        doReturn(enterpriseLicense()).when(systemService).getLicense();
        Mockito.doReturn(TestCall.successCall(null)).when(configurationAPI).deployConfiguration(any());

        //when:
        configurationService.importBonitaConfiguration(new File(temporaryFolder, UUID.randomUUID().toString()));

        //then:
        verify(securityContext).isAuthenticated();
        verifyNoInteractions(importNotifier);
        verify(configurationAPI).deployConfiguration(any());
    }

    @Test
    void should_import_fail_if_the_api_returns_an_error() throws Exception {
        //given:
        doReturn(version("7.8.2")).when(systemService).getVersion();
        doReturn(enterpriseLicense()).when(systemService).getLicense();
        Mockito.doReturn(TestCall.errorCall(500, "too much data")).when(configurationAPI).deployConfiguration(any());

        //when:
        Throwable thrown = catchThrowable(
                () -> configurationService.importBonitaConfiguration(new File(temporaryFolder, UUID.randomUUID().toString())));

        //then:
        assertThat(thrown).isInstanceOf(IOException.class)
                .hasMessageStartingWith("Error happened server side")
                .hasMessageEndingWith("error code: 500, response body: too much data");
    }

}
