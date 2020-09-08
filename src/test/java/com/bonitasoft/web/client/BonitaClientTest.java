/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client;

import com.bonitasoft.web.client.exception.NotFoundException;
import com.bonitasoft.web.client.internal.services.ProcessService;
import com.bonitasoft.web.client.policies.ApplicationImportPolicy;
import com.bonitasoft.web.client.policies.DeploymentPolicies;
import com.bonitasoft.web.client.policies.OrganizationImportPolicy;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.bridge.SLF4JBridgeHandler;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import static com.bonitasoft.web.client.BonitaClientBuilder.bonitaClient;
import static com.bonitasoft.web.client.internal.security.OkHttpSecurityContextInterceptor.CSRF_TOKEN_HEADER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

/**
 * @author Laurent Leseigneur
 */
public class BonitaClientTest {

    private MockWebServer server;

    private BonitaClient bonitaClient;
    private int requestCountAfterLogin;
    private MockResponse mockedResponse;

    @BeforeClass
    public static void classSetup() {
        // needed to redirect okhttp3.mockwebserver jul logs to slf4j
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }

    @Before
    public void setup() throws Exception {
        server = new MockWebServer();
        server.start();
        mockedResponse = new MockResponse();

        bonitaClient = bonitaClient(server.url("/").toString()).build();
    }

    @After
    public void cleanup() throws Exception {
        server.close();
    }

    @Test
    public void should_not_fail_to_create_client_when_url_does_not_ends_with_a_slash() throws Exception {
        bonitaClient("http://not-ended-with-slash:8080/bonita").build();

        // expect no exception
    }

    @Test
    public void should_platform_be_up_while_unauthorized() throws Exception {
        //given
        checkPlatformIsUpAndRunning(401, "should be up, even if unauthorized, platform is up");
    }

    @Test
    public void should_platform_be_up() throws Exception {
        //given
        checkPlatformIsUpAndRunning(200, "should be up for already logged user");
    }

    private void checkPlatformIsUpAndRunning(int responseCode, String message) throws InterruptedException {
        server.enqueue(mockedResponse.setResponseCode(responseCode));

        //when
        boolean upAndRunning = bonitaClient.isPlatformUpAndRunning();

        //then
        assertThat(server.getRequestCount()).isEqualTo(1);
        assertThat(upAndRunning).as(message).isTrue();

        RecordedRequest sessionRequest = server.takeRequest();
        assertThat(sessionRequest.getRequestLine()).isEqualTo("GET /API/system/session/unusedId HTTP/1.1");
    }

    @Test
    public void should_not_platform_be_UpAndRunning() throws Exception {
        //given
        server.enqueue(mockedResponse.setResponseCode(500));

        //when
        boolean upAndRunning = bonitaClient.isPlatformUpAndRunning();

        //then
        assertThat(server.getRequestCount()).isEqualTo(1);
        assertThat(upAndRunning).isFalse();

        RecordedRequest sessionRequest = server.takeRequest();
        assertThat(sessionRequest.getRequestLine()).isEqualTo("GET /API/system/session/unusedId HTTP/1.1");
    }

    @Test
    public void should_login() throws Exception {
        //when
        callLogin(false);

        //then
        assertThat(requestCountAfterLogin).isEqualTo(2);

        RecordedRequest loginRequest = server.takeRequest();
        assertThat(loginRequest.getRequestLine()).isEqualTo("POST /loginservice HTTP/1.1");

        RecordedRequest sessionRequest = server.takeRequest();
        assertThat(sessionRequest.getRequestLine()).isEqualTo("GET /API/system/session/unusedId HTTP/1.1");
        assertThat(sessionRequest.getHeader(CSRF_TOKEN_HEADER)).as("should add csrf header")
                .isEqualTo("283cd144-d0ff-4bb8-97c4-77f47a4f1346");
        assertThat(sessionRequest.getHeader("Cookie")).as("should send session and tenant cookie")
                .isEqualTo("bonita.tenant=5;JSESSIONID=6EECA8AE5BD9CA47A9B6664278E89988");
    }

    @Test
    public void should_logout() throws Exception {
        //given
        callLogin(true);
        server.enqueue(mockedResponse);

        //when
        bonitaClient.logout();

        //then
        assertThat(server.getRequestCount() - requestCountAfterLogin).isEqualTo(1);
        RecordedRequest recordedRequest = server.takeRequest();
        assertThat(recordedRequest.getRequestLine()).isEqualTo("POST /logoutservice HTTP/1.1");
        assertThat(recordedRequest.getHeader(CSRF_TOKEN_HEADER)).isEqualTo("283cd144-d0ff-4bb8-97c4-77f47a4f1346");
    }

    @Test
    public void should_import_applications() throws Exception {
        //given
        callLogin(true);
        server.enqueue(mockedResponse);
        server.enqueue(mockedResponse);

        //when
        String name = "/application.xml";
        bonitaClient.importApplications(getFile(name), ApplicationImportPolicy.FAIL_ON_DUPLICATES);

        //then
        assertThat(server.getRequestCount() - requestCountAfterLogin).isEqualTo(2);

        RecordedRequest applicationUpload = server.takeRequest();
        assertThat(applicationUpload.getRequestLine()).isEqualTo("POST /portal/applicationsUpload HTTP/1.1");

        RecordedRequest applicationImport = server.takeRequest();
        assertThat(applicationImport.getRequestLine()).isEqualTo("POST /services/application/import HTTP/1.1");
    }

    @Test
    public void should_import_profiles() throws Exception {
        //given
        callLogin(true);
        server.enqueue(mockedResponse);
        server.enqueue(mockedResponse);

        //when
        bonitaClient.importProfiles(getFile("/Profile_Data.xml"),
                DeploymentPolicies.DevelopmentDefaults.getProfileImportPolicy());

        //then
        assertThat(server.getRequestCount() - requestCountAfterLogin).isEqualTo(2);

        RecordedRequest profileUpload = server.takeRequest();
        assertThat(profileUpload.getRequestLine()).isEqualTo("POST /portal/profilesUpload HTTP/1.1");

        RecordedRequest applicationImport = server.takeRequest();
        assertThat(applicationImport.getRequestLine()).isEqualTo("POST /services/profile/import HTTP/1.1");
    }

    @Test
    public void should_search_profiles() throws Exception {
        //given
        callLogin(true);
        server.enqueue(mockedResponse.setBody("[]"));

        //when
        bonitaClient.searchProfiles(0, 10);

        //then
        assertThat(server.getRequestCount() - requestCountAfterLogin).isEqualTo(1);

        RecordedRequest profileUpload = server.takeRequest();
        assertThat(profileUpload.getRequestLine()).isEqualTo("GET /API/portal/profile?p=0&c=10 HTTP/1.1");
    }

    @Test
    public void should_search_applications() throws Exception {
        //given
        callLogin(true);
        server.enqueue(mockedResponse.setBody("[]"));

        //when
        bonitaClient.searchApplications(0, 10);

        //then
        assertThat(server.getRequestCount() - requestCountAfterLogin).isEqualTo(1);

        RecordedRequest profileUpload = server.takeRequest();
        assertThat(profileUpload.getRequestLine()).isEqualTo("GET /API/living/application?p=0&c=10 HTTP/1.1");
    }

    @Test
    public void should_import_organization() throws Exception {
        //given
        callLogin(true);
        server.enqueue(mockedResponse);
        server.enqueue(mockedResponse);

        //when
        bonitaClient.importOrganization(getFile("/Organization_Data.xml"), OrganizationImportPolicy.MERGE_DUPLICATES);

        //then
        assertThat(server.getRequestCount() - requestCountAfterLogin).isEqualTo(2);

        RecordedRequest uploadRequest = server.takeRequest();
        assertThat(uploadRequest.getRequestLine()).isEqualTo("POST /portal/organizationUpload HTTP/1.1");

        RecordedRequest importRequest = server.takeRequest();
        assertThat(importRequest.getRequestLine()).isEqualTo("POST /services/organization/import HTTP/1.1");
    }

    @Test
    public void should_search_pages() throws Exception {
        //given
        callLogin(true);
        server.enqueue(mockedResponse.setBody("[]"));

        //when
        bonitaClient.searchPages(0, 10);

        //then
        assertThat(server.getRequestCount() - requestCountAfterLogin).isEqualTo(1);

        RecordedRequest profileUpload = server.takeRequest();
        assertThat(profileUpload.getRequestLine()).isEqualTo("GET /API/portal/page?p=0&c=10 HTTP/1.1");
    }

    @Test
    public void should_search_process_throws_exception_if_process_does_not_exist() throws IOException {
        //given:
        ProcessService processService = mock(ProcessService.class);
        BonitaClient client = new BonitaClient(null, null, null, null, null, processService, null, null, null, null,
                null, null);
        doReturn(Optional.empty()).when(processService).getProcess("aName", "aVersion");

        //when:
        Throwable thrown = catchThrowable(() -> client.getProcess("aName", "aVersion"));

        //then:
        assertThat(thrown).isInstanceOf(NotFoundException.class)
                .hasMessage("Process 'aName' in version 'aVersion' does not exist");
    }

    // =================================================================================================================
    // UTILS
    // =================================================================================================================

    private File getFile(String name) {
        return new File(this.getClass().getResource(name).getFile());
    }

    private void callLogin(boolean removeRequest) throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .addHeader("Set-Cookie", "X-Bonita-API-Token=283cd144-d0ff-4bb8-97c4-77f47a4f1346; Path=/bonita")
                .addHeader("Set-Cookie", "bonita.tenant=5; Path=/bonita")
                .addHeader("Set-Cookie", "JSESSIONID=6EECA8AE5BD9CA47A9B6664278E89988; Path=/bonita")
                .setBody("ok"));

        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("ok"));

        bonitaClient.login("install", "install");
        this.requestCountAfterLogin = server.getRequestCount();
        if (removeRequest) {
            server.takeRequest();
            server.takeRequest();
        }
    }

}
