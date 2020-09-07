/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.converters;

import com.bonitasoft.web.client.model.Process;
import com.bonitasoft.web.client.model.*;
import com.bonitasoft.web.client.model.Process.ConfigurationState;
import com.github.zafarkhaja.semver.Version;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SoftAssertionsExtension.class)
class RestApiConverterTest {

    private RestApiConverter restApiConverter = RestApiConverter.INSTANCE;

    static String toDoubleQuote(String json) {
        return json.replaceAll("'", "\"");
    }

    @Test
    void should_convert_json_to_application_list(SoftAssertions softly) throws Exception {
        //given
        String json = read("searchApplication.json");

        //when
        List<Application> applications = restApiConverter.listFromJson(json, Application.class);

        //then
        softly.assertThat(applications).hasSize(2);
        softly.assertThat(applications).extracting(Application::getId).isEqualTo(asList(2L, 1L));
        softly.assertThat(applications).extracting(Application::getDescription).containsExactly("",
                "This is the HR dashboard.");
        softly.assertThat(applications).extracting(Application::getDisplayName).containsExactly("Marketing",
                "My HR dashboard");
        softly.assertThat(applications).extracting(Application::getToken).containsExactly("My", "HR-dashboard");
    }

    @Test
    void should_convert_json_to_Profile_list(SoftAssertions softly) throws Exception {
        //given
        String json = read("searchProfile.json");

        //when
        List<Profile> profiles = restApiConverter.listFromJson(json, Profile.class);

        //then
        softly.assertThat(profiles).hasSize(7);
        softly.assertThat(profiles).extracting(Profile::getId).isEqualTo(asList(2L, 4L, 5L, 3L, 6L, 7L, 1L));
        softly.assertThat(profiles).extracting(Profile::getDescription).containsExactly(
                "The administrator can install a process, manage the organization, and handle some errors (for example, by replaying a task).",
                "",
                "",
                "The Process manager can supervise designated processes, and manage cases and tasks of those processes.",
                "",
                "",
                "The user can view and perform tasks and can start a new case of a process.");
        softly.assertThat(profiles).extracting(Profile::getName).containsExactly(
                "Administrator",
                "HR",
                "HRManager",
                "Process manager",
                "TahitiUser",
                "TeamManager",
                "User");
        softly.assertThat(profiles).extracting(Profile::isDefault).containsExactly(true, false, false, true, false,
                false, true);
    }

    @Test
    void should_convert_json_to_Page_list(SoftAssertions softly) throws Exception {
        //given
        String json = read("searchPage.json");

        //when
        List<Page> pages = restApiConverter.listFromJson(json, Page.class);

        //then
        softly.assertThat(pages).hasSize(3);
        softly.assertThat(pages).extracting(Page::getId).isEqualTo(asList(104L, 102L, 14L));
        softly.assertThat(pages).extracting(Page::getDescription).containsExactly(
                "MyVacations page generated with Bonita BPM UI designer",
                "Rest API to query request vacation for a given month",
                "REST API extension example archive for Bonita BPM Portal. Included examples: Get/Post, how to use a logger, customize response, call SOAP web service.");
        softly.assertThat(pages).extracting(Page::getUrlToken).containsExactly(
                "custompage_MyVacations",
                "custompage_VacationByMonthRestAPI",
                "custompage_apiExtensionExample");
        softly.assertThat(pages).extracting(Page::getContentType).containsExactly("page", "apiExtension",
                "apiExtension");
        softly.assertThat(pages).extracting(Page::isProvided).containsExactly(false, false, true);
    }

    @Test
    void should_convert_upload_response() throws Exception {
        //given
        String uploadResponse = "tmp_8795279717849311826.zip::page.zip";

        //when
        String response = restApiConverter.buildSimpleJson("pageZip", uploadResponse);

        //then
        assertThat(response).isEqualTo("{\"pageZip\":\"" + uploadResponse + "\"}");
    }

    @Test
    void should_convert_tenant_resource_status_response(SoftAssertions softly) throws IOException {
        //given
        String json = "{" +
                "'id':'3'" +
                ",'name':'client-bdm.zip'" +
                ",'type':'BDM'" +
                ",'state':'INSTALLED'" +
                ",'lastUpdatedBy':'-1'" +
                ",'lastUpdateDate':'2018-02-14T16:17:23.0Z'" +
                "}";

        //when
        TenantResourceStatus tenantResourceStatus = restApiConverter.fromJson(toDoubleQuote(json),
                TenantResourceStatus.class);

        //then
        softly.assertThat(tenantResourceStatus.getId()).isEqualTo(3);
        softly.assertThat(tenantResourceStatus.getName()).isEqualTo("client-bdm.zip");
        softly.assertThat(tenantResourceStatus.getType()).isEqualTo("BDM");
        softly.assertThat(tenantResourceStatus.getState()).isEqualTo("INSTALLED");
        softly.assertThat(tenantResourceStatus.getLastUpdatedBy()).isEqualTo("-1");
        softly.assertThat(tenantResourceStatus.getLastUpdateDate())
                .isEqualTo(OffsetDateTime.of(2018, 02, 14, 16, 17, 23, 0, ZoneOffset.UTC));
    }

    @Test
    void should_convert_session_json_with_snapshot_version_to_version() throws Exception {
        //given
        Version versionToMatch = new Version.Builder("7.7.0").build();
        String response = "{" +
                "'copyright':'Bonitasoft - 2018'" +
                ",'user_id':'4'" +
                ",'user_name':'walter.bates'" +
                ",'session_id':'-3417256225131984474'" +
                ",'conf':'[conf1,conf2]'" +
                ",'is_technical_user':'false'" +
                ",'version':'7.7.0-SNAPSHOT'" +
                "}";

        //when
        Version version = restApiConverter.versionFromSessionJson(toDoubleQuote(response));

        //then
        assertThat(version).isEqualTo(versionToMatch);
    }

    @Test
    void should_convert_session_json_with_weekly_version_to_version() throws Exception {
        //given
        Version versionToMatch = new Version.Builder("7.6.1").build();
        String response = "{" +
                "'copyright':'Bonitasoft - 2017'" +
                ",'user_id':'1'" +
                ",'user_name':'helen.kelly'" +
                ",'session_id':'-3417256223615984474'" +
                ",'conf':'[conf8,conf2]'" +
                ",'is_technical_user':'false'" +
                ",'version':'7.6.1.ANY-STUFF'" +
                "}";

        //when
        Version version = restApiConverter.versionFromSessionJson(toDoubleQuote(response));

        //then
        assertThat(version).isEqualTo(versionToMatch);
    }

    @Test
    void should_convert_json_to_process_including_dates(SoftAssertions softly) throws Exception {
        //given
        String response = "{" +
                "'id':'8216934689697197160'" +
                ",'icon':'example.ico'" +
                ",'description':'A process'" +
                ",'name':'process name'" +
                ",'version':'1.0'" +
                ",'displayName':'Pool of the process'" +
                ",'activationState':'ENABLED'" +
                ",'configurationState':'RESOLVED'" +
                ",'deployedBy':'4'" +
                ",'actorinitiatorid':'3'" +
                ",'deploymentDate':'2015-01-02 07:42:25.347'" +
                ",'last_update_date':'2015-01-02 05:04:30.587'" +
                "}";

        //when
        Process process = restApiConverter.fromJson(toDoubleQuote(response), Process.class);

        //then
        softly.assertThat(process.getId()).isEqualTo(8216934689697197160l);
        softly.assertThat(process.getDescription()).isEqualTo("A process");
        softly.assertThat(process.getName()).isEqualTo("process name");
        softly.assertThat(process.getVersion()).isEqualTo("1.0");
        softly.assertThat(process.isEnabled()).isTrue();
        softly.assertThat(process.getConfigurationState()).isEqualTo(ConfigurationState.RESOLVED);
        softly.assertThat(process.getDeployedBy()).isEqualTo(4L);
        softly.assertThat(process.getDeploymentDate()).isEqualTo("2015-01-02T07:42:25.347");
        softly.assertThat(process.getLastUpdateDate()).isEqualTo("2015-01-02T05:04:30.587");
    }

    // =================================================================================================================
    // UTILS
    // =================================================================================================================

    @Test
    void should_convert_json_into_list_of_processActivationProblem() throws Exception {
        //given
        String response = "[" +
                "{" +
                "'resource_id':'PROCESS_START'" +
                ",'target_type':'form mapping'" +
                ",'message':'error while resolving form mapping...'" +
                "}" +
                ",{" +
                "'resource_id':'Step1'" +
                ",'target_type':'business data'" +
                ",'message':'The business data \\u0027myData\\u0027 with the class name " +
                "\\u0027com.company.model.BadEncoding\\u0027, is not managed by the current " +
                "version of the BDM'" +
                "}" +
                "]";

        //when
        List<ProcessResolutionProblem> processActivationProblems = restApiConverter.listFromJson(
                toDoubleQuote(response),
                ProcessResolutionProblem.class);

        //then
        assertThat(processActivationProblems).hasSize(2);
        assertThat(processActivationProblems).extracting(ProcessResolutionProblem::getResource_id)
                .containsExactlyInAnyOrder("PROCESS_START", "Step1");
        assertThat(processActivationProblems).extracting(ProcessResolutionProblem::getTarget_type)
                .containsExactlyInAnyOrder("form mapping", "business data");
        assertThat(processActivationProblems).extracting(ProcessResolutionProblem::getMessage)
                .containsExactlyInAnyOrder("error while resolving form mapping...",
                        "The business data 'myData' with the class name 'com.company.model." +
                                "BadEncoding', is not managed by the current version of the BDM");
    }

    private String read(String resourceName) throws IOException {
        try (BufferedReader buffer = new BufferedReader(
                new InputStreamReader(this.getClass().getResourceAsStream(resourceName)))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }
    }

}
