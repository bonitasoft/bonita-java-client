/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.services;

import com.bonitasoft.web.client.exception.UnauthorizedException;
import com.bonitasoft.web.client.internal.api.UserTaskAPI;
import com.bonitasoft.web.client.internal.security.SecurityContext;
import com.bonitasoft.web.client.model.UserTask;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import retrofit2.Response;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class UserTaskService extends ClientService {

    private final UserTaskAPI userTaskAPI;

    public UserTaskService(SecurityContext securityContext, UserTaskAPI userTaskAPI) {
        super(securityContext);
        this.userTaskAPI = userTaskAPI;
    }


    public UserTask get(long taskId) throws IOException, UnauthorizedException {
        log.debug("Getting User Task {}", taskId);
        securityContext.isAuthenticated();
        Response<UserTask> response = userTaskAPI.get(taskId).execute();
        checkResponse(response);
        UserTask userTask = response.body();
        log.debug("Retrieved User Task: {}", userTask);
        return userTask;
    }

    public List<UserTask> search(long rootContainerId) throws IOException, UnauthorizedException {
        log.debug("Searching User Task for process instance {}", rootContainerId);
        securityContext.isAuthenticated();
        Response<List<UserTask>> response = userTaskAPI.search("rootContainerId=" + rootContainerId).execute();
        checkResponse(response);
        List<UserTask> userTasks = response.body();
        log.debug("Retrieved User Tasks: {}", userTasks);
        return userTasks;
    }

    public void update(long taskId, long assignedUserId, String state) throws IOException, UnauthorizedException {
        log.debug("Updating User Task {}. Assigned to {} in state {}", taskId, assignedUserId, state);
        securityContext.isAuthenticated();
        Map<String, Serializable> parameters = new HashMap<>();
        parameters.put("assigned_id", String.valueOf(assignedUserId));
        if (state != null) {
            parameters.put("state", state);
        }
        Response<ResponseBody> response = userTaskAPI.update(taskId, parameters).execute();
        checkResponse(response);
        log.debug("User Task {} updated", taskId);
    }

    public void execute(long taskId) throws IOException, UnauthorizedException {
        execute(taskId, null);
    }

    public void execute(long taskId, Map<String, Serializable> params) throws IOException, UnauthorizedException {
        log.debug("Executing User Task {} with parameters {}", taskId, params);
        securityContext.isAuthenticated();
        Response<ResponseBody> response;
        if (params != null && !params.isEmpty()) {
            response = userTaskAPI.execute(taskId, params).execute();
        } else {
            response = userTaskAPI.execute(taskId).execute();
        }
        checkResponse(response);
        log.debug("User Task {} executed", taskId);
    }

}
