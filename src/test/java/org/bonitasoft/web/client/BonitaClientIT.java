package org.bonitasoft.web.client;

import lombok.extern.slf4j.Slf4j;
import org.bonitasoft.testcontainers.BonitaContainer;
import org.bonitasoft.web.client.exception.LicenseException;
import org.bonitasoft.web.client.exception.NotFoundException;
import org.bonitasoft.web.client.exception.UnauthorizedException;
import org.bonitasoft.web.client.exception.process.DuplicatedProcessException;
import org.bonitasoft.web.client.exception.process.ProcessActivationException;
import org.bonitasoft.web.client.log.LogContentLevel;
import org.bonitasoft.web.client.model.*;
import org.bonitasoft.web.client.services.ApplicationService;
import org.bonitasoft.web.client.services.ProcessService;
import org.bonitasoft.web.client.services.policies.ApplicationImportPolicy;
import org.bonitasoft.web.client.services.policies.OrganizationImportPolicy;
import org.bonitasoft.web.client.services.policies.ProcessImportPolicy;
import org.bonitasoft.web.client.services.policies.ProfileImportPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.awaitility.Awaitility.await;
import static org.awaitility.Durations.*;
import static org.bonitasoft.web.client.TestUtils.getClasspathFile;
import static org.bonitasoft.web.client.api.ApplicationApi.SearchApplicationsQueryParams;
import static org.bonitasoft.web.client.api.UserApi.SearchUsersQueryParams;
import static org.bonitasoft.web.client.model.AbstractTask.StateEnum;

@Slf4j
@Testcontainers
class BonitaClientIT {


    private static final String ROLE_MEMBER_NAME = "member";
    private static final int SEARCH_MAX_COUNT = 100;

    @Container
    private static final BonitaContainer BONITA_CONTAINER = new BonitaContainer();

    private BonitaClient bonitaClient;

    @BeforeEach
    void setUp() {
//         String portalUrl = "http://localhost:8888/bonita";
        String portalUrl = BONITA_CONTAINER.getPortalUrl();
        bonitaClient = BonitaClient.builder(portalUrl)
                .logContentLevel(LogContentLevel.OFF)
                .build();
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
        assertThatThrownBy(() -> bonitaClient.users().importProfiles(profile, ProfileImportPolicy.REPLACE_DUPLICATES))
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
        assertThatThrownBy(() -> {
            processes.importProcess(processFile, ProcessImportPolicy.IGNORE_DUPLICATES);
        })
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
        assertThatThrownBy(() -> {
            processes.importProcess(processFile, ProcessImportPolicy.FAIL_ON_DUPLICATES);
        })
                .isInstanceOf(DuplicatedProcessException.class);

        // Then
        Optional<ProcessDefinition> maybeProcess = bonitaClient.processes().getProcess("CreateAndUpdateData", "1.0");
        assertThat(maybeProcess).isPresent();
        ProcessDefinition process = maybeProcess.get();
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
        assertThatThrownBy(() -> {
            applications.importBonitaConfiguration(bconfFile);
        })
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
        List<User> users = bonitaClient.users().searchUsers(new SearchUsersQueryParams().p(0).c(SEARCH_MAX_COUNT));
        assertThat(users).isNotEmpty();
    }

    @Test
    void applications_should_be_uploaded() throws Exception {
        // Given
        loggedInAsTechnicalUser();
        final List<Application> applicationsBefore = bonitaClient.applications().searchApplications(0, SEARCH_MAX_COUNT);

        // When
        File application = getClasspathFile("/application.xml");
        bonitaClient.applications().importApplications(application, ApplicationImportPolicy.REPLACE_DUPLICATES);

        // Then
        List<Application> applications = bonitaClient.applications().searchApplications(new SearchApplicationsQueryParams().p(0).c(SEARCH_MAX_COUNT));
        assertThat(applications).isNotEmpty().hasSize(applicationsBefore.size() + 2);
        assertThat(applications).as("Application names")
                .extracting(Application::getToken)
                .contains("MyApplication_Client_tests", "HR-dashboard_Client_tests");

    }

    @Test
    void user_should_be_created() throws Exception {

        // Given
        loggedInAsTechnicalUser();

        String firstname = "Jeremy";
        String lastname = "Lambert";
        String username = firstname + "." + lastname;
        String password = "bpm";

        // When
        User user = bonitaClient.users().createUser(
                new UserCreateRequest().userName(username)
                        .firstname(firstname).lastname(lastname)
                        .password(password).passwordConfirm(password)
                        .enabled("true")
        );

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

        // When
        File processFile = getClasspathFile("/CreateAndUpdateData--1.0.bar");
        bonitaClient.processes().importProcess(processFile, ProcessImportPolicy.REPLACE_DUPLICATES);

        // Then
        Optional<ProcessDefinition> maybeProcess = bonitaClient.processes().getProcess("CreateAndUpdateData", "1.0");
        assertThat(maybeProcess).isPresent();
        ProcessDefinition process = maybeProcess.get();
        assertThat(process.getConfigurationState()).isEqualTo(ConfigurationState.RESOLVED);
        assertThat(process.getActivationState()).isEqualTo(ActivationState.ENABLED);
    }

    @Test
    void process_should_be_uploaded_and_started() throws Exception {
        // Given
        loggedInAsTechnicalUser();
        bonitaClient.processes().importProcess(getClasspathFile("/standaloneAutomaticProcess--1.0.bar"), ProcessImportPolicy.REPLACE_DUPLICATES);

        // When
        final ProcessInstantiationResponse startProcess = bonitaClient.processes().startProcess("standaloneAutomaticProcess", "1.0");

        // Then
        assertThat(startProcess.getCaseId()).isNotBlank();
        assertThat(Long.valueOf(startProcess.getCaseId())).isGreaterThan(0L);
    }

    @Test
    public void should_assign_then_execute_user_task() throws Exception {
        // Given:
        bonitaClient.login("install", "install");

        bonitaClient.users().importOrganization(getClasspathFile("/human-task/Organization.xml"), OrganizationImportPolicy.MERGE_DUPLICATES);
        bonitaClient.processes().importProcess(getClasspathFile("/human-task/standaloneOneHumanTask--1.0.bar"), ProcessImportPolicy.REPLACE_DUPLICATES);
        final ProcessInstantiationResponse humanTaskInstance = bonitaClient.processes().startProcess("standaloneOneHumanTask", "1.0");
        final String caseId = humanTaskInstance.getCaseId();

        log.info("Wait for process instance to be started {} ...", caseId);
        await().atMost(ONE_SECOND).until(() -> bonitaClient.processes().searchUserTask(caseId), userTasks -> !userTasks.isEmpty());

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

        //then:
        UserTask userTaskAfterAssignation = bonitaClient.processes().getUserTask(taskId);
        log.info("User task after assignation: {}", userTaskAfterAssignation);
        assertThat(userTaskAfterAssignation.getAssignedId()).as("Assigned id").isEqualTo(user.getId());
        assertThat(userTaskAfterAssignation.getState()).as("state").isEqualTo(StateEnum.READY);

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
        Throwable thrown = catchThrowable(() -> {
            processes.getUserTask(taskId);
        });

        // FIXME we should search the task in the archives instead
        assertThat(thrown).isInstanceOf(NotFoundException.class);
        //                .hasMessageContaining("Error happened server side , error code: 404");
        //        assertThat(archivedUserTask.getState()).as("state after execution").isEqualTo("completed");
        //        assertThat(archivedUserTask.getExecutedBy()).as("Execute by").isEqualTo(user.getId());
        //        assertThat(archivedUserTask.getExecutedBySubstitute()).as("Execute by substitute").isEqualTo(user.getId());
        bonitaClient.logout();
    }

    @Test
    void unresolved_process_problem_should_be_listed() throws Exception {
        // Given
        loggedInAsTechnicalUser();

        File processFile = getClasspathFile("/bconf/Pool-1.0.bar");
        String processName = "Pool";
        String processVersion = "1.0";

        assertThatThrownBy(() -> {
            processes.importProcess(processFile, ProcessImportPolicy.REPLACE_DUPLICATES);
        })
                .isInstanceOf(ProcessActivationException.class)
                .hasFieldOrPropertyWithValue("processName", processName)
                .hasFieldOrPropertyWithValue("processVersion", processVersion);

        Optional<ProcessDefinition> maybeProcess = bonitaClient.processes().getProcess(processName, processVersion);
        assertThat(maybeProcess).isPresent();
        ProcessDefinition process = maybeProcess.get();
        assertThat(process.getConfigurationState()).isEqualTo(ConfigurationState.UNRESOLVED);
        assertThat(process.getActivationState()).isEqualTo(ActivationState.DISABLED);

        // When
        List<ProcessResolutionProblem> processProblems = bonitaClient.processes().getProcessProblem(0, SEARCH_MAX_COUNT, process.getId());

        // Then
        assertThat(processProblems).isNotEmpty();
    }


    private void importOrganization() throws Exception {
        File organization = getClasspathFile("/Organization_Data.xml");
        bonitaClient.users().importOrganization(organization, OrganizationImportPolicy.MERGE_DUPLICATES);
    }

    private void loggedInAsTechnicalUser() {
        Session session = bonitaClient.login("install", "install");
        assertThat(session).isNotNull();
        assertThat(session.getUserName()).isEqualTo("install");
    }

    /**
     * Wait at most 10 seconds for the user task.
     */
    public void waitForUserTaskToBeExecuted(String taskId) {
        final Duration waitDuration = TEN_SECONDS;
        log.debug("Waiting at most {} for user task {} to be executed", waitDuration, taskId);
        await().atMost(waitDuration).pollInterval(ONE_HUNDRED_MILLISECONDS)
                .until(() -> {
                    try {
                        UserTask userTask = bonitaClient.processes().getUserTask(taskId);

                        if (StateEnum.COMPLETED.equals(userTask.getState())) {
                            log.debug("User task found in state COMPLETED, so stop waiting");
                            return true;
                        }
                    } catch (NotFoundException e) {
                        log.debug("User task not found, so consider it has been archived and stop waiting");
                        return true;
                    } catch (Exception e) {
                        throw e;
                    }
                    return false;
                });
    }
}