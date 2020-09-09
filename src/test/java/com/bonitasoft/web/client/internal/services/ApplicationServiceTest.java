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
import org.mockito.junit.jupiter.MockitoExtension;
import retrofit2.Call;
import retrofit2.mock.Calls;

import java.io.File;
import java.util.List;

import static com.bonitasoft.web.client.policies.ApplicationImportPolicy.FAIL_ON_DUPLICATES;
import static com.bonitasoft.web.client.policies.ApplicationImportPolicy.REPLACE_DUPLICATES;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
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
        Call<ResponseBody> ok = Calls.response(ResponseBody.create(MediaType.parse("text/plain"), "ok"));
        when(applicationAPI.delete(anyLong())).thenReturn(ok);
        when(applicationAPI.importFromUploadedFile(anyString(), anyString())).thenReturn(ok);
        when(applicationAPI.uploadContent(any())).thenReturn(Calls.response("uploadedContent"));
    }

    @Test
    void should_delete_existing_application_when_policy_is_REPLACE_DUPLICATES() throws Exception {
        File file = getFile("/application.xml");
        when(applicationAPI.search(0, 1, "token=MyApplication_Client_tests")).thenReturn(aCallThatReturnApplication(5L));
        when(applicationAPI.search(0, 1, "token=HR-dashboard_Client_tests")).thenReturn(aCallThatReturnApplication(6L));
        when(applicationAPI.delete(eq(5L))).thenReturn(Calls.response(ResponseBody.create(MediaType.parse("text/plain"), "ok")));
        when(applicationAPI.delete(eq(6L))).thenReturn(Calls.response(ResponseBody.create(MediaType.parse("text/plain"), "ok")));

        applicationService.importApplications(file, REPLACE_DUPLICATES);

        verify(applicationAPI).delete(5L);
        verify(applicationAPI).delete(6L);
    }

    @Test
    void should_call_api_with_FAIL_ON_DUPLICATES_policy_when_using_REPLACE_DUPLICATES() throws Exception {
        File file = getFile("/application.xml");
        when(applicationAPI.search(eq(0), eq(1), eq("token=MyApplication_Client_tests"))).thenReturn(aCallThatReturnApplication(5L));
        when(applicationAPI.search(eq(0), eq(1), eq("token=HR-dashboard_Client_tests"))).thenReturn(aCallThatReturnApplication(6L));
        when(applicationAPI.delete(eq(5L))).thenReturn(Calls.response(ResponseBody.create(MediaType.parse("text/plain"), "ok")));
        when(applicationAPI.delete(eq(6L))).thenReturn(Calls.response(ResponseBody.create(MediaType.parse("text/plain"), "ok")));

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
        long id = 6L;
        when(applicationAPI.search(0, 1, "token=tokenOfTheApp")).thenReturn(aCallThatReturnApplication(id));

        Application application = applicationService.getApplication("tokenOfTheApp");

        assertThat(application.getId()).isEqualTo(id);
    }

    @Test
    void should_return_null_if_application_do_not_exists() throws Exception {
        Call<List<Application>> call = Calls.response(emptyList());
        when(applicationAPI.search(0, 1, "token=tokenOfTheApp")).thenReturn(call);

        Application application = applicationService.getApplication("tokenOfTheApp");

        assertThat(application).isNull();
    }

    @Test
    void should_delete_unexisting_application() throws Exception {
        when(applicationAPI.search(0, 1, "token=tokenOfTheApp")).thenReturn(Calls.response(emptyList()));

        boolean result = applicationService.deleteApplication("tokenOfTheApp");

        assertThat(result).isFalse();
    }

    @Test
    void should_delete_existing_application() throws Exception {
        when(applicationAPI.search(0, 1, "token=tokenOfTheApp")).thenReturn(aCallThatReturnApplication(123L));
        when(applicationAPI.delete(123L)).thenReturn(Calls.response(ResponseBody.create(MediaType.parse("plain/test"), "success")));

        boolean result = applicationService.deleteApplication("tokenOfTheApp");

        verify(applicationAPI).delete(123L);
        assertThat(result).isTrue();
    }

    private Call<List<Application>> aCallThatReturnApplication(Long id) {
        return Calls.response(singletonList(new Application().setId(id)));
    }

    private File getFile(String name) {
        return new File(this.getClass().getResource(name).getFile());
    }

}
