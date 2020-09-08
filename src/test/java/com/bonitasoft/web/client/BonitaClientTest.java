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
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.bridge.SLF4JBridgeHandler;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import static com.bonitasoft.web.client.BonitaClientBuilder.bonitaClient;
import static com.bonitasoft.web.client.internal.security.OkHttpSecurityContextInterceptor.CSRF_TOKEN_HEADER;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.http.RequestMethod.GET;
import static com.github.tomakehurst.wiremock.http.RequestMethod.POST;
import static com.github.tomakehurst.wiremock.matching.RequestPatternBuilder.newRequestPattern;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

/**
 * @author Laurent Leseigneur
 */
class BonitaClientTest {

    private BonitaClient bonitaClient;
    private WireMockServer server;

    @BeforeAll
    public static void classSetup() {
        // needed to redirect okhttp3.mockwebserver jul logs to slf4j
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }

    @BeforeEach
    void setUp() {
        server = new WireMockServer(WireMockConfiguration.options().dynamicPort());
        server.start();

        bonitaClient = bonitaClient(server.baseUrl()).build();
    }

    @AfterEach
    void tearDown() {
        server.stop();
    }

    @Test
    void should_not_fail_to_create_client_when_url_does_not_ends_with_a_slash() {
        bonitaClient("http://not-ended-with-slash:8080/bonita").build();

        // expect no exception
    }

    @Test
    void should_platform_be_up_while_unauthorized() throws Exception {
        //given
        checkPlatformIsUpAndRunning(401, "should be up, even if unauthorized, platform is up");
    }

    @Test
    void should_platform_be_up() throws Exception {
        //given
        checkPlatformIsUpAndRunning(200, "should be up for already logged user");
    }

    private void checkPlatformIsUpAndRunning(int responseCode, String message) throws InterruptedException {

        server.stubFor(get(anyUrl())
                .willReturn(aResponse().withBody("ok").withStatus(responseCode)));

        //when
        boolean upAndRunning = bonitaClient.isPlatformUpAndRunning();

        //then
        assertThat(upAndRunning).as(message).isTrue();
        server.verify(1, newRequestPattern(GET, urlEqualTo("/API/system/session/unusedId")));
    }

    @Test
    void should_not_platform_be_UpAndRunning() throws Exception {
        //given
        server.stubFor(get(anyUrl())
                .willReturn(aResponse().withBody("ko").withStatus(500)));

        //when
        boolean upAndRunning = bonitaClient.isPlatformUpAndRunning();

        //then
        assertThat(upAndRunning).isFalse();
        server.verify(1, newRequestPattern(GET, urlEqualTo("/API/system/session/unusedId")));
    }

    @Test
    void should_login() throws Exception {
        //when
        callLogin(false);

        //then
        server.verify(1, newRequestPattern(POST, urlEqualTo("/loginservice")));
        server.verify(1, newRequestPattern(GET, urlEqualTo("/API/system/session/unusedId"))
                .withHeader(CSRF_TOKEN_HEADER, equalTo("283cd144-d0ff-4bb8-97c4-77f47a4f1346"))
                .withCookie("bonita.tenant", equalTo("5"))
                .withCookie("JSESSIONID", equalTo("6EECA8AE5BD9CA47A9B6664278E89988"))
        );
    }

    @Test
    void should_logout() throws Exception {
        //given
        callLogin(true);
        server.stubFor(post(urlEqualTo("/logoutservice"))
                .willReturn(aResponse().withBody("ok").withStatus(200)));

        //when
        bonitaClient.logout();

        //then
        server.verify(1, newRequestPattern(POST, urlEqualTo("/logoutservice"))
                .withHeader(CSRF_TOKEN_HEADER, equalTo("283cd144-d0ff-4bb8-97c4-77f47a4f1346"))
        );
    }

    @Test
    void should_import_applications() throws Exception {
        //given
        callLogin(true);
        server.stubFor(post(urlEqualTo("/portal/applicationsUpload"))
                .willReturn(aResponse().withBody("ok").withStatus(200)));
        server.stubFor(post(urlEqualTo("/services/application/import"))
                .willReturn(aResponse().withBody("ok").withStatus(200)));

        //when
        String name = "/application.xml";
        bonitaClient.importApplications(getFile(name), ApplicationImportPolicy.FAIL_ON_DUPLICATES);

        //then
        server.verify(1, newRequestPattern(POST, urlEqualTo("/portal/applicationsUpload")));
        server.verify(1, newRequestPattern(POST, urlEqualTo("/services/application/import")));
    }

    @Test
    void should_import_profiles() throws Exception {
        //given
        callLogin(true);
        server.stubFor(post(urlEqualTo("/portal/profilesUpload"))
                .willReturn(aResponse().withBody("ok").withStatus(200)));
        server.stubFor(post(urlEqualTo("/services/profile/import"))
                .willReturn(aResponse().withBody("ok").withStatus(200)));

        //when
        bonitaClient.importProfiles(getFile("/Profile_Data.xml"), DeploymentPolicies.DevelopmentDefaults.getProfileImportPolicy());

        //then
        server.verify(1, newRequestPattern(POST, urlEqualTo("/portal/profilesUpload")));
        server.verify(1, newRequestPattern(POST, urlEqualTo("/services/profile/import")));
    }

    @Test
    void should_search_profiles() throws Exception {
        //given
        callLogin(true);
        server.stubFor(get(urlEqualTo("/API/portal/profile?p=0&c=10"))
                .willReturn(aResponse().withBody("[]").withStatus(200)));

        //when
        bonitaClient.searchProfiles(0, 10);

        //then
        server.verify(1, newRequestPattern(GET, urlEqualTo("/API/portal/profile?p=0&c=10")));
    }

    @Test
    void should_search_applications() throws Exception {
        //given
        callLogin(true);
        server.stubFor(get(urlEqualTo("/API/living/application?p=0&c=10"))
                .willReturn(aResponse().withBody("[]").withStatus(200)));

        //when
        bonitaClient.searchApplications(0, 10);

        //then
        server.verify(1, newRequestPattern(GET, urlEqualTo("/API/living/application?p=0&c=10")));
    }

    @Test
    void should_import_organization() throws Exception {
        //given
        callLogin(true);
        server.stubFor(post(urlEqualTo("/portal/organizationUpload"))
                .willReturn(aResponse().withBody("ok").withStatus(200)));
        server.stubFor(post(urlEqualTo("/services/organization/import"))
                .willReturn(aResponse().withBody("ok").withStatus(200)));

        //when
        bonitaClient.importOrganization(getFile("/Organization_Data.xml"), OrganizationImportPolicy.MERGE_DUPLICATES);

        //then
        server.verify(1, newRequestPattern(POST, urlEqualTo("/portal/organizationUpload")));
        server.verify(1, newRequestPattern(POST, urlEqualTo("/services/organization/import")));
    }

    @Test
    void should_search_pages() throws Exception {
        //given
        callLogin(true);
        server.stubFor(get(urlEqualTo("/API/portal/page?p=0&c=10"))
                .willReturn(aResponse().withBody("[]").withStatus(200)));
        //when
        bonitaClient.searchPages(0, 10);

        //then
        server.verify(1, newRequestPattern(GET, urlEqualTo("/API/portal/page?p=0&c=10")));
    }

    @Test
    void should_search_process_throws_exception_if_process_does_not_exist() throws IOException {
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

        server.stubFor(post(urlEqualTo("/loginservice"))
                .willReturn(aResponse().withBody("ok").withStatus(200)
                        .withHeader("Set-Cookie", "X-Bonita-API-Token=283cd144-d0ff-4bb8-97c4-77f47a4f1346; Path=/bonita")
                        .withHeader("Set-Cookie", "bonita.tenant=5; Path=/bonita")
                        .withHeader("Set-Cookie", "JSESSIONID=6EECA8AE5BD9CA47A9B6664278E89988; Path=/bonita")
                ));
        server.stubFor(get(urlEqualTo("/API/system/session/unusedId"))
                .willReturn(aResponse().withBody("ok").withStatus(200)));

        bonitaClient.login("install", "install");

        if (removeRequest) {
            server.resetRequests();
        }
    }

}
