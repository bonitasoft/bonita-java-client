/** 
 * Copyright (C) 2023 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.bonitasoft.web.client;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.awaitility.Awaitility.await;
import static org.awaitility.Durations.ONE_HUNDRED_MILLISECONDS;
import static org.awaitility.Durations.ONE_SECOND;
import static org.awaitility.Durations.TEN_SECONDS;
import static org.bonitasoft.web.client.TestUtils.getClasspathFile;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

import org.bonitasoft.testcontainers.BonitaContainer;
import org.bonitasoft.web.client.api.ApplicationApi.SearchApplicationsQueryParams;
import org.bonitasoft.web.client.api.ArchivedProcessInstanceApi;
import org.bonitasoft.web.client.api.GroupApi;
import org.bonitasoft.web.client.api.GroupApi.SearchGroupsQueryParams;
import org.bonitasoft.web.client.api.ProcessInstanceApi;
import org.bonitasoft.web.client.api.RoleApi;
import org.bonitasoft.web.client.api.UserApi.SearchUsersQueryParams;
import org.bonitasoft.web.client.exception.LicenseException;
import org.bonitasoft.web.client.exception.NotFoundException;
import org.bonitasoft.web.client.exception.UnauthorizedException;
import org.bonitasoft.web.client.exception.process.DuplicatedProcessException;
import org.bonitasoft.web.client.exception.process.ProcessActivationException;
import org.bonitasoft.web.client.log.LogContentLevel;
import org.bonitasoft.web.client.model.ActivationState;
import org.bonitasoft.web.client.model.ActivityState;
import org.bonitasoft.web.client.model.Application;
import org.bonitasoft.web.client.model.ArchivedProcessInstance;
import org.bonitasoft.web.client.model.Bdm;
import org.bonitasoft.web.client.model.BusinessData;
import org.bonitasoft.web.client.model.ConfigurationState;
import org.bonitasoft.web.client.model.Group;
import org.bonitasoft.web.client.model.GroupCreateRequest;
import org.bonitasoft.web.client.model.GroupUpdateRequest;
import org.bonitasoft.web.client.model.Page;
import org.bonitasoft.web.client.model.ProcessDefinition;
import org.bonitasoft.web.client.model.ProcessInstance;
import org.bonitasoft.web.client.model.ProcessInstantiationResponse;
import org.bonitasoft.web.client.model.ProcessResolutionProblem;
import org.bonitasoft.web.client.model.Profile;
import org.bonitasoft.web.client.model.Role;
import org.bonitasoft.web.client.model.RoleCreateRequest;
import org.bonitasoft.web.client.model.Session;
import org.bonitasoft.web.client.model.TenantResourceState;
import org.bonitasoft.web.client.model.User;
import org.bonitasoft.web.client.model.UserCreateRequest;
import org.bonitasoft.web.client.model.UserTask;
import org.bonitasoft.web.client.services.ApplicationService;
import org.bonitasoft.web.client.services.ProcessService;
import org.bonitasoft.web.client.services.UserService;
import org.bonitasoft.web.client.services.policies.ApplicationImportPolicy;
import org.bonitasoft.web.client.services.policies.OrganizationImportPolicy;
import org.bonitasoft.web.client.services.policies.ProcessImportPolicy;
import org.bonitasoft.web.client.services.policies.ProfileImportPolicy;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.vdurmont.semver4j.Semver;
import com.vdurmont.semver4j.Semver.SemverType;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Testcontainers
class BonitaClientIT {

    private static final String ROLE_MEMBER_NAME = "member";

    private static final int MAX_SEARCH_COUNT = 100;

    private static final String BONITA_DOCKER_IMAGE_PROPERTY = "bonita.image";

    private static final String BONITA_DOCKER_IMAGE = System.getProperty(BONITA_DOCKER_IMAGE_PROPERTY, "");

    @Container
    private static final BonitaContainer<? extends BonitaContainer<?>> BONITA_CONTAINER = new BonitaContainer<>(
            BONITA_DOCKER_IMAGE);

    private static final Semver _10_2 = new Semver("10.2.0", SemverType.LOOSE);

    private BonitaClient bonitaClient;

    @BeforeEach
    void setUp() {
        String portalUrl = BONITA_CONTAINER.getPortalUrl();
        bonitaClient = BonitaClient.builder(portalUrl).logContentLevel(LogContentLevel.OFF).build();
    }

    @Test
    void login_with_unknown_user_should_fail() {
        assertThatThrownBy(() -> bonitaClient.login("youknowhow", "tommarvoloriddle"))
                .isInstanceOf(UnauthorizedException.class);
    }

    @Test
    void profiles_should_not_be_uploaded_in_community() throws Exception {
        // Given
        loggedInAsTechnicalUser();

        // When
        File profile = getClasspathFile("/CustomProfile_Data.xml");

        // Then
        final UserService users = bonitaClient.users();
        assertThatThrownBy(() -> users.importProfiles(profile, ProfileImportPolicy.REPLACE_DUPLICATES))
                .isInstanceOf(LicenseException.class);
    }

    @Test
    void unresolved_process_should_not_be_activated() throws Exception {
        // Given
        loggedInAsTechnicalUser();

        // When
        File processFile = getClasspathFile("/bconf/Pool-1.0.bar");

        // Then
        final ProcessService processes = bonitaClient.processes();
        assertThatThrownBy(
                () -> processes.importProcess(processFile, ProcessImportPolicy.IGNORE_DUPLICATES))
                .isInstanceOf(ProcessActivationException.class);
    }

    @Test
    void duplicated_process_should_throw_ex() throws Exception {
        // Given
        loggedInAsTechnicalUser();
        importOrganization();
        importBDM();
        File processFile = getClasspathFile("/CreateAndUpdateData--1.0.bar");

        // First import
        bonitaClient.processes().importProcess(processFile, ProcessImportPolicy.REPLACE_DUPLICATES);

        // When
        // Second import should fail because of policy
        final ProcessService processes = bonitaClient.processes();
        assertThatThrownBy(
                () -> processes.importProcess(processFile, ProcessImportPolicy.FAIL_ON_DUPLICATES))
                .isInstanceOf(DuplicatedProcessException.class);

        // Then
        ProcessDefinition process = bonitaClient.processes().getProcess("CreateAndUpdateData", "1.0");
        assertThat(process.getConfigurationState()).isEqualTo(ConfigurationState.RESOLVED);
        assertThat(process.getActivationState()).isEqualTo(ActivationState.ENABLED);
    }

    @Test
    void bconf_should_not_be_uploaded_in_community() throws Exception {
        // Given
        loggedInAsTechnicalUser();

        // When
        File bconfFile = getClasspathFile("/bconf/default-Production.bconf");

        // Then
        final ApplicationService applications = bonitaClient.applications();
        assertThatThrownBy(() -> applications.importBonitaConfiguration(bconfFile))
                .isInstanceOf(LicenseException.class);
    }

    @Test
    void organization_should_be_uploaded() throws Exception {
        // Given
        loggedInAsTechnicalUser();

        // When
        importOrganization();

        // add "User" profile to all imported users
        Profile userProfile = bonitaClient.users().getProfileByName(BonitaClient.USER_PROFILE_NAME);
        Role memberRole = bonitaClient.users().getRoleByName(ROLE_MEMBER_NAME);
        bonitaClient.users().addRoleToProfile(memberRole.getId(), userProfile.getId());

        // Then
        List<User> users = bonitaClient.users().searchUsers(new SearchUsersQueryParams().p(0).c(MAX_SEARCH_COUNT));
        assertThat(users).isNotEmpty();
    }

    @Test
    void legacy_applications_should_be_uploaded() throws Exception {

        // Given
        loggedInAsTechnicalUser();
        final List<Application> applicationsBefore = bonitaClient.applications().searchApplications(0,
                MAX_SEARCH_COUNT);
        var expectedAppTokens = List.of("MyApplication_Client_tests", "HR-dashboard_Client_tests");

        // When
        File application = getClasspathFile(BONITA_CONTAINER.getImageVersion().isGreaterThanOrEqualTo(_10_2)
                ? "/application.xml" : "/application_1.0.xml");
        bonitaClient
                .applications()
                .importApplications(application, ApplicationImportPolicy.REPLACE_DUPLICATES);

        // Then
        List<Application> applications = bonitaClient
                .applications()
                .searchApplications(new SearchApplicationsQueryParams().p(0).c(MAX_SEARCH_COUNT));
        assertThat(applications).isNotEmpty().hasSize(applicationsBefore.size() + 2);
        assertThat(applications)
                .as("Application names")
                .extracting(Application::getToken)
                .contains(expectedAppTokens.toArray(new String[0]));

        if (BONITA_CONTAINER.getImageVersion().isGreaterThanOrEqualTo(_10_2)) {
            assertThat(applications)
                    .as("Applications must not be linked")
                    .filteredOn(app -> expectedAppTokens.contains(app.getToken()))
                    .extracting(Application::getLink)
                    .containsExactly(false, false);
        } else {
            assertThat(applications)
                    .as("Applications must not be linked")
                    .filteredOn(app -> expectedAppTokens.contains(app.getToken()))
                    .extracting(Application::getLink)
                    .containsExactly(null, null);
        }

    }

    @Test
    void linked_applications_should_be_uploaded() throws Exception {
        // Execute for runtime version > 10.2
        Assumptions.assumeTrue(() -> BONITA_CONTAINER.getImageVersion().isGreaterThanOrEqualTo(_10_2),
                "Linked applications does not exists in versions below 10.2.");

        // Given
        loggedInAsTechnicalUser();
        final List<Application> applicationsBefore = bonitaClient.applications().searchApplications(0,
                MAX_SEARCH_COUNT);
        var expectedAppTokens = List.of("app1", "app2");

        // When
        File application = getClasspathFile("/application-link.xml");
        bonitaClient
                .applications()
                .importApplications(application, ApplicationImportPolicy.REPLACE_DUPLICATES);

        // Then
        List<Application> applications = bonitaClient
                .applications()
                .searchApplications(new SearchApplicationsQueryParams().p(0).c(MAX_SEARCH_COUNT));
        assertThat(applications).isNotEmpty().hasSize(applicationsBefore.size() + 2);
        assertThat(applications)
                .as("Application names")
                .extracting(Application::getToken)
                .contains(expectedAppTokens.toArray(new String[0]));
        assertThat(applications)
                .as("Applications must be linked")
                .filteredOn(app -> expectedAppTokens.contains(app.getToken()))
                .extracting(Application::getLink)
                .containsExactly(true, true);
    }

    @Test
    void user_should_be_created() {

        // Given
        loggedInAsTechnicalUser();

        String firstname = "Jeremy";
        String lastname = "Lambert";
        String username = firstname + "." + lastname;
        String password = "bpm";

        // When
        User user = bonitaClient
                .users()
                .createUser(
                        new UserCreateRequest()
                                .userName(username)
                                .firstname(firstname)
                                .lastname(lastname)
                                .password(password)
                                .passwordConfirm(password)
                                .enabled("true"));

        Profile administratorProfile = bonitaClient.users().getProfileByName(BonitaClient.ADMIN_PROFILE_NAME);
        bonitaClient.users().addUserToProfile(user.getId(), administratorProfile.getId());

        // Then
        User walter = bonitaClient.users().getUser(username);
        assertThat(walter).isEqualTo(user);
    }

    @Test
    void bdm_should_be_uploaded() throws Exception {
        // Given
        loggedInAsTechnicalUser();

        // When
        importBDM();

        // Then
        Bdm bdm = bonitaClient.bdm().getBdmStatus();
        assertThat(bdm.getState()).isEqualTo(TenantResourceState.INSTALLED);
    }

    private void importBDM() throws Exception {
        File bdmFile = getClasspathFile("/bdm.zip");
        bonitaClient.bdm().importBDM(bdmFile);
    }

    @Test
    void page_should_be_uploaded() throws Exception {
        // Given
        loggedInAsTechnicalUser();

        // When
        File pageFile = getClasspathFile("/page.zip");
        Page page = bonitaClient.applications().importPage(pageFile);

        // Then
        Page pageAgain = bonitaClient.applications().getPage(page.getUrlToken());
        assertThat(pageAgain.getId()).isEqualTo(page.getId());
        assertThat(pageAgain.getUrlToken()).isEqualTo(page.getUrlToken());
        assertThat(pageAgain.getDisplayName()).isEqualTo(page.getDisplayName());
        assertThat(pageAgain.getContentName()).isEqualTo(page.getContentName());
    }

    @Test
    void page_should_be_updated() throws Exception {
        // Given
        loggedInAsTechnicalUser();

        // When
        File pageFile = getClasspathFile("/page.zip");
        bonitaClient.applications().importPage(pageFile);
        Page page = bonitaClient.applications().importPage(pageFile);

        // Then
        Page pageAgain = bonitaClient.applications().getPage(page.getUrlToken());
        assertThat(pageAgain.getId()).isEqualTo(page.getId());
        assertThat(pageAgain.getUrlToken()).isEqualTo(page.getUrlToken());
        assertThat(pageAgain.getDisplayName()).isEqualTo(page.getDisplayName());
        assertThat(pageAgain.getContentName()).isEqualTo(page.getContentName());
    }

    @Test
    void page_should_be_deleted() throws Exception {
        // Given
        loggedInAsTechnicalUser();
        final int nbPageBefore = bonitaClient.applications().searchPages(0, MAX_SEARCH_COUNT).size();

        File pageFile = getClasspathFile("/page.zip");
        final Page page = bonitaClient.applications().importPage(pageFile);
        final int nbPageAfterImport = bonitaClient.applications().searchPages(0, MAX_SEARCH_COUNT).size();
        assertThat(nbPageBefore).isEqualTo(nbPageAfterImport - 1);

        // When
        bonitaClient.applications().deletePage(page.getUrlToken());
        final int nbPageAfterDeletion = bonitaClient.applications().searchPages(0, MAX_SEARCH_COUNT).size();

        // Then
        assertThat(nbPageBefore).isEqualTo(nbPageAfterDeletion);
    }

    @Test
    void restapi_should_be_uploaded() throws Exception {
        // Given
        loggedInAsTechnicalUser();

        // When
        File restapiFile = getClasspathFile("/RestAPI-1.0.0.zip");
        Page restapi = bonitaClient.applications().importPage(restapiFile);

        // Then
        Page restapiAgain = bonitaClient.applications().getPage(restapi.getUrlToken());
        assertThat(restapiAgain.getId()).isEqualTo(restapi.getId());
        assertThat(restapiAgain.getUrlToken()).isEqualTo(restapi.getUrlToken());
        assertThat(restapiAgain.getDisplayName()).isEqualTo(restapi.getDisplayName());
        assertThat(restapiAgain.getContentName()).isEqualTo(restapi.getContentName());
    }

    @Test
    void process_should_be_uploaded() throws Exception {
        // Given
        loggedInAsTechnicalUser();
        importOrganization();
        importBDM();
        final String processName = "CreateAndUpdateData";
        final String processVersion = "1.0";

        // When
        File processFile = getClasspathFile(String.format("/%s--%s.bar", processName, processVersion));
        bonitaClient.processes().importProcess(processFile, ProcessImportPolicy.REPLACE_DUPLICATES);

        // Then
        ProcessDefinition process = bonitaClient.processes().getProcess(processName, processVersion);
        assertThat(process.getConfigurationState()).isEqualTo(ConfigurationState.RESOLVED);
        assertThat(process.getActivationState()).isEqualTo(ActivationState.ENABLED);
    }

    @Test
    void process_should_be_found() throws Exception {
        // Given
        loggedInAsTechnicalUser();
        importOrganization();
        importBDM();
        final String processName = "CreateAndUpdateData";
        final String processVersion = "1.0";
        File processFile = getClasspathFile(String.format("/%s--%s.bar", processName, processVersion));
        bonitaClient.processes().importProcess(processFile, ProcessImportPolicy.REPLACE_DUPLICATES);

        // When
        final List<ProcessDefinition> processes = bonitaClient.processes().searchProcesses(0, MAX_SEARCH_COUNT);

        // Then
        Optional<ProcessDefinition> maybeProcess = processes.stream()
                .filter(
                        processDefinition -> processName.equals(processDefinition.getName())
                                && processVersion.equals(processDefinition.getVersion()))
                .findFirst();
        assertThat(maybeProcess).isPresent();
        ProcessDefinition process = maybeProcess.get();
        assertThat(process.getConfigurationState()).isEqualTo(ConfigurationState.RESOLVED);
        assertThat(process.getActivationState()).isEqualTo(ActivationState.ENABLED);
    }

    @Test
    void process_should_be_uploaded_and_started() throws Exception {
        // Given
        loggedInAsTechnicalUser();
        bonitaClient
                .processes()
                .importProcess(
                        getClasspathFile("/standaloneAutomaticProcess--1.0.bar"),
                        ProcessImportPolicy.REPLACE_DUPLICATES);

        // When
        final ProcessInstantiationResponse startProcess = bonitaClient.processes()
                .startProcess("standaloneAutomaticProcess", "1.0");

        // Then
        assertThat(startProcess.getCaseId()).isNotNull().isNotEmpty();
        assertThat(Long.valueOf(startProcess.getCaseId())).isPositive();
    }

    @Test
    void should_assign_then_execute_user_task() throws Exception {
        // Given:
        bonitaClient.login("install", "install");

        bonitaClient
                .users()
                .importOrganization(
                        getClasspathFile("/human-task/Organization.xml"),
                        OrganizationImportPolicy.MERGE_DUPLICATES);
        bonitaClient
                .processes()
                .importProcess(
                        getClasspathFile("/human-task/standaloneOneHumanTask--1.0.bar"),
                        ProcessImportPolicy.REPLACE_DUPLICATES);
        final ProcessInstantiationResponse humanTaskInstance = bonitaClient.processes()
                .startProcess("standaloneOneHumanTask", "1.0");
        final String caseId = humanTaskInstance.getCaseId();

        log.info("Wait for process instance to be started {} ...", caseId);
        await()
                .atMost(ONE_SECOND)
                .until(
                        () -> bonitaClient.processes().searchUserTask(caseId),
                        userTasks -> !userTasks.isEmpty());

        log.info("Retrieving the User tasks for process instance {}", caseId);
        List<UserTask> userTasks = bonitaClient.processes().searchUserTask(caseId);
        log.info("Found user tasks: {}", userTasks);
        assertThat(userTasks).extracting(UserTask::getName).containsExactly("Step 1");
        UserTask initialUserTask = userTasks.get(0);
        assertThat(initialUserTask.getAssignedId()).as("assigned id").isEmpty();
        assertThat(initialUserTask.getAssignedDate()).as("assigned date").isEmpty();
        String taskId = initialUserTask.getId();
        log.info("We are going to manage task {}", taskId);

        // When:
        User user = bonitaClient.users().getUser("human.task"); // imported with the organization
        log.info("Assigning user {} / {} to the human task", user.getId(), user.getUserName());
        bonitaClient.processes().assignUserTask(taskId, user.getId());
        log.info("User assigned");

        // then:
        UserTask userTaskAfterAssignation = bonitaClient.processes().getUserTask(taskId);
        log.info("User task after assignation: {}", userTaskAfterAssignation);
        assertThat(userTaskAfterAssignation.getAssignedId()).as("Assigned id").isEqualTo(user.getId());
        assertThat(userTaskAfterAssignation.getState()).as("state").isEqualTo(ActivityState.READY);

        // When:
        log.info("User to is going to execute the task {}", user);
        bonitaClient.logout();
        bonitaClient.login(user.getUserName(), "bpm");

        log.info("Executing task {}", taskId);
        bonitaClient.processes().executeUserTask(taskId);
        log.info("Execution in progress");
        waitForUserTaskToBeExecuted(taskId);

        // Then:
        final ProcessService processes = bonitaClient.processes();
        Throwable thrown = catchThrowable(() -> processes.getUserTask(taskId));

        // FIXME we should search the task in the archives instead
        assertThat(thrown).isInstanceOf(NotFoundException.class);
        //                .hasMessageContaining("Error happened server side , error code: 404");
        //        assertThat(archivedUserTask.getState()).as("state after
        // execution").isEqualTo("completed");
        //        assertThat(archivedUserTask.getExecutedBy()).as("Execute by").isEqualTo(user.getId());
        //        assertThat(archivedUserTask.getExecutedBySubstitute()).as("Execute by
        // substitute").isEqualTo(user.getId());
        bonitaClient.logout();
    }

    @Test
    void unresolved_process_problem_should_be_listed() throws Exception {
        // Given
        loggedInAsTechnicalUser();

        File processFile = getClasspathFile("/bconf/Pool-1.0.bar");
        String processName = "Pool";
        String processVersion = "1.0";

        final ProcessService processes = bonitaClient.processes();
        assertThatThrownBy(
                () -> processes.importProcess(processFile, ProcessImportPolicy.REPLACE_DUPLICATES))
                .isInstanceOf(ProcessActivationException.class)
                .hasFieldOrPropertyWithValue("processName", processName)
                .hasFieldOrPropertyWithValue("processVersion", processVersion);

        ProcessDefinition process = bonitaClient.processes().getProcess(processName, processVersion);
        assertThat(process.getConfigurationState()).isEqualTo(ConfigurationState.UNRESOLVED);
        assertThat(process.getActivationState()).isEqualTo(ActivationState.DISABLED);

        // When
        List<ProcessResolutionProblem> processProblems = bonitaClient.processes().getProcessProblem(0, MAX_SEARCH_COUNT,
                process.getId());

        // Then
        assertThat(processProblems).isNotEmpty();
    }

    @Test
    void should_create_all_elements_of_the_organization() {
        // Given
        loggedInAsTechnicalUser();

        bonitaClient.users().createUser(new UserCreateRequest()
                .userName("john.doe")
                .firstname("John")
                .lastname("Doe")
                .password("bpm")
                .passwordConfirm("bpm")
                .enabled("true"));
        List<User> users = bonitaClient.users()
                .searchUsers(new SearchUsersQueryParams().p(0).c(1).f(asList("userName=john.doe")));
        assertThat(users).anyMatch(user -> user.getFirstname().equals("John"));

        bonitaClient.users().createRole(new RoleCreateRequest()
                .name("staff")
                .displayName("staff")
                .description("staff of the given group"));
        List<Role> result = bonitaClient.users().searchRoles(new RoleApi.SearchRolesQueryParams().p(0).c(10));
        assertThat(result).extracting(Role::getName).contains("staff");

        Group engineering = bonitaClient.users().createGroup(new GroupCreateRequest()
                .name("engineering")
                .displayName("Engineering")
                .description("Engineering dept"));
        assertThat(engineering.getName()).isEqualTo("engineering");

        Group rdGroup = bonitaClient.users().createGroup(new GroupCreateRequest()
                .name("rd")
                .displayName("RnD")
                .description("Research and dev.")
                .parentGroupId(engineering.getId()));
        assertThat(rdGroup.getName()).isEqualTo("rd");
        assertThat(rdGroup.getParentGroupId()).isEqualTo(engineering.getParentGroupId());

        GroupApi groupApi = bonitaClient.get(GroupApi.class);
        groupApi.updateGroupById(rdGroup.getId(), new GroupUpdateRequest()
                .name("rd")
                .parentGroupId(""));

        var r = groupApi.searchGroups(new SearchGroupsQueryParams().p(0).c(1).f(List.of("name=rd")));
        assertThat(r).hasSize(1).allSatisfy(g -> assertThat(g.getParentGroupId()).isNull());
    }

    private void importOrganization() throws Exception {
        File organization = getClasspathFile("/Organization_Data.xml");
        bonitaClient
                .users()
                .importOrganization(organization, OrganizationImportPolicy.MERGE_DUPLICATES);
    }

    private void loggedInAsTechnicalUser() {
        Session session = bonitaClient.login("install", "install");
        assertThat(session).isNotNull();
        assertThat(session.getUserName()).isEqualTo("install");
    }

    /** Wait at most 10 seconds for the user task. */
    void waitForUserTaskToBeExecuted(String taskId) {
        final Duration waitDuration = TEN_SECONDS;
        log.debug("Waiting at most {} for user task {} to be executed", waitDuration, taskId);
        await()
                .atMost(waitDuration)
                .pollInterval(ONE_HUNDRED_MILLISECONDS)
                .until(() -> {
                    try {
                        UserTask userTask = bonitaClient.processes().getUserTask(taskId);
                        if (ActivityState.COMPLETED.equals(userTask.getState())) {
                            log.debug("User task found in state COMPLETED, so stop waiting");
                            return true;
                        }
                    } catch (NotFoundException e) {
                        log.debug("User task not found, so consider it has been archived and stop waiting");
                        return true;
                    }
                    return false;
                });
    }

    @Test
    void bdm_typed_query_should_be_run() throws Exception {
        // Given
        loggedInAsTechnicalUser();

        // import BDM
        File bdmFile = getClasspathFile("/bdm-setup-query.zip");
        bonitaClient.bdm().importBDM(bdmFile);
        // Provision some BDM data
        bonitaClient.processes().importProcess(getClasspathFile("/bdm-setup-1.0.bar"),
                ProcessImportPolicy.IGNORE_DUPLICATES);
        ProcessInstantiationResponse processInstance = bonitaClient.processes().startProcess("bdm-setup", "1.0");

        await().until(processIsCompleted(processInstance));

        // When
        Integer count = bonitaClient.bdm().querySingle("com.company.model.Comment", "countForFind", Integer.class);
        List<Post> posts = bonitaClient.bdm().query("com.company.model.Post", "find", Post.class);
        List<PostWithAuthorPojo> postsWithAuthorPojo = bonitaClient.bdm().query("com.company.model.Post", "find",
                PostWithAuthorPojo.class);
        List<Comment> comments = bonitaClient.bdm().query("com.company.model.Comment", "find", Comment.class);
        List<BusinessData> commentBOs = bonitaClient.bdm().query("com.company.model.Comment", "find",
                BusinessData.class);

        // Then
        assertThat(count).isEqualTo(10);
        assertThat(posts).hasSize(1);
        Post post = posts.get(0);
        Author author = post.getAuthor();
        assertThat(author.getFirstName()).isEqualTo("Mi");

        PostWithAuthorPojo postWithAuthorPojo = postsWithAuthorPojo.get(0);
        AuthorPojo authorPojo = postWithAuthorPojo.getAuthor();
        assertThat(authorPojo.getFirstName()).isEqualTo("Mi");

        // Trigger lazy http get
        assertThat(post.getComments()).hasSize(comments.size()).hasSize(commentBOs.size());
        assertThat(post.getComments().get(1).getUserId()).isEqualTo(1);
        assertThat(commentBOs.get(1).getAdditionalProperty("userId")).isEqualTo(1);

    }

    private Callable<Boolean> processIsCompleted(ProcessInstantiationResponse processInstance) {
        return () -> {
            try {
                // Search in process instances
                ProcessInstanceApi processInstanceApi = bonitaClient.get(ProcessInstanceApi.class);
                ProcessInstance instance = processInstanceApi.getProcessInstanceById(processInstance.getCaseId(),
                        (String) null);
                return "completed".equalsIgnoreCase(instance.getState().getValue());
            } catch (NotFoundException e) {
                // Search in "archived" process instances
                ArchivedProcessInstanceApi archivedProcessInstanceApi = bonitaClient
                        .get(ArchivedProcessInstanceApi.class);
                List<ArchivedProcessInstance> archivedProcessInstances = archivedProcessInstanceApi
                        .searchArchivedProcessInstances(
                                new ArchivedProcessInstanceApi.SearchArchivedProcessInstancesQueryParams()
                                        .c(1).p(0)
                                        .f(asList("sourceObjectId=" + processInstance.getCaseId())));
                if (!archivedProcessInstances.isEmpty()) {
                    return "completed".equalsIgnoreCase(archivedProcessInstances.get(0).getState().getValue());
                }
                return false;
            }
        };
    }

    public interface Post {

        Author getAuthor();

        String getTitle();

        String getContent();

        List<Comment> getComments();
    }

    public interface PostWithAuthorPojo {

        AuthorPojo getAuthor();

    }

    public interface Comment {

        Long getUserId();

        LocalDateTime getCreationDate();
    }

    public interface Author {

        String getFirstName();

        String getLastName();
    }

    @Data
    public static class AuthorPojo {

        private String firstName;

        private String lastName;
    }
}
