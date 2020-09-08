/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.services;

import com.bonitasoft.web.client.internal.api.ApplicationAPI;
import com.bonitasoft.web.client.internal.security.SecurityContext;
import com.bonitasoft.web.client.model.Application;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import retrofit2.Call;

import java.io.File;
import java.util.Collections;
import java.util.List;

import static com.bonitasoft.web.client.policies.ApplicationImportPolicy.FAIL_ON_DUPLICATES;
import static com.bonitasoft.web.client.policies.ApplicationImportPolicy.REPLACE_DUPLICATES;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * @author Baptiste Mesta.
 */
@ExtendWith(MockitoExtension.class)
class ApplicationServiceTest {

    @Mock(lenient = true)
    private ApplicationAPI applicationAPI;
    @Mock(lenient = true)
    private SecurityContext securityContext;

    @InjectMocks
    private ApplicationService applicationService;

    @BeforeEach
    void before() {
        Call<ResponseBody> ok = TestCall.successCall(ResponseBody.create(MediaType.parse("text/plain"), "ok"));
        doReturn(ok).when(applicationAPI).delete(anyLong());
        doReturn(ok).when(applicationAPI).importFromUploadedFile(anyString(), anyString());
        Mockito.doReturn(TestCall.successCall("uploadedContent")).when(applicationAPI).uploadContent(any());
    }

    @Test
    void should_delete_existing_application_when_policy_is_REPLACE_DUPLICATES() throws Exception {
        File file = getFile("/application.xml");
        doReturn(aCallThatReturnApplication(5L)).when(applicationAPI).search(0, 1, "token=MyApplication_Client_tests");
        doReturn(aCallThatReturnApplication(6L)).when(applicationAPI).search(0, 1, "token=HR-dashboard_Client_tests");

        applicationService.importApplications(file, REPLACE_DUPLICATES);

        verify(applicationAPI).delete(5L);
        verify(applicationAPI).delete(6L);
    }

    @Test
    void should_call_api_with_FAIL_ON_DUPLICATES_policy_when_using_REPLACE_DUPLICATES() throws Exception {
        File file = getFile("/application.xml");
        doReturn(aCallThatReturnApplication(5L)).when(applicationAPI).search(0, 1, "token=MyApplication_Client_tests");
        doReturn(aCallThatReturnApplication(6L)).when(applicationAPI).search(0, 1, "token=HR-dashboard_Client_tests");

        applicationService.importApplications(file, REPLACE_DUPLICATES);

        verify(applicationAPI).importFromUploadedFile(anyString(), eq(FAIL_ON_DUPLICATES.name()));
    }

    @Test
    void should_not_delete_application_with_policy_FAIL_ON_DUPLICATES() throws Exception {
        File file = getFile("/application.xml");

        applicationService.importApplications(file, FAIL_ON_DUPLICATES);

        verify(applicationAPI, never()).delete(anyLong());
    }

    @Test
    void should_return_the_application_having_token() throws Exception {
        Call<List<Application>> call = aCallThatReturnApplication(6L);
        doReturn(call).when(applicationAPI).search(0, 1, "token=tokenOfTheApp");

        Application application = applicationService.getApplication("tokenOfTheApp");

        assertThat(application).isEqualTo(call.execute().body().get(0));
    }

    @Test
    void should_return_null_if_application_do_not_exists() throws Exception {
        Call<List<Application>> call = TestCall.successCall(Collections.emptyList());
        doReturn(call).when(applicationAPI).search(0, 1, "token=tokenOfTheApp");

        Application application = applicationService.getApplication("tokenOfTheApp");

        assertThat(application).isNull();
    }

    @Test
    void should_delete_unexisting_application() throws Exception {
        Mockito.doReturn(TestCall.successCall(emptyList())).when(applicationAPI).search(0, 1, "token=tokenOfTheApp");

        boolean result = applicationService.deleteApplication("tokenOfTheApp");

        assertThat(result).isFalse();
    }

    @Test
    void should_delete_existing_application() throws Exception {
        doReturn(aCallThatReturnApplication(123L)).when(applicationAPI).search(0, 1, "token=tokenOfTheApp");
        Mockito.doReturn(TestCall.successCall("success")).when(applicationAPI).delete(123L);

        boolean result = applicationService.deleteApplication("tokenOfTheApp");

        verify(applicationAPI).delete(123L);
        assertThat(result).isTrue();
    }

    private Call<List<Application>> aCallThatReturnApplication(Long id) {
        Application application = new Application();
        application.setId(id);
        return TestCall.successCall(Collections.singletonList(application));
    }

    private File getFile(String name) {
        return new File(this.getClass().getResource(name).getFile());
    }

}
