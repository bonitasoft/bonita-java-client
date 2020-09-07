/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.services;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bonitasoft.web.client.exception.UnauthorizedException;
import com.bonitasoft.web.client.internal.BonitaCookieInterceptor;
import com.bonitasoft.web.client.internal.api.UserTaskAPI;
import com.bonitasoft.web.client.internal.converters.RestApiConverter;
import com.bonitasoft.web.client.model.UserTask;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

public class UserTaskService extends ClientService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserTaskService.class.getName());

    private final RestApiConverter restApiConverter;
    private final BonitaCookieInterceptor bonitaCookieInterceptor;
    private final UserTaskAPI userTaskAPI;

    public UserTaskService(UserTaskAPI userTaskAPI, RestApiConverter restApiConverter,
            BonitaCookieInterceptor bonitaCookieInterceptor) {
        this.userTaskAPI = userTaskAPI;
        this.restApiConverter = restApiConverter;
        this.bonitaCookieInterceptor = bonitaCookieInterceptor;
    }

    public UserTask get(long taskId) throws IOException, UnauthorizedException {
        LOGGER.debug("Getting User Task {}", taskId);
        bonitaCookieInterceptor.checkLogged();
        Response<UserTask> response = userTaskAPI.get(taskId).execute();
        checkResponse(response);
        UserTask userTask = response.body();
        LOGGER.debug("Retrieved User Task: {}", userTask);
        return userTask;
    }

    public List<UserTask> search(long rootContainerId) throws IOException, UnauthorizedException {
        LOGGER.debug("Searching User Task for process instance {}", rootContainerId);
        bonitaCookieInterceptor.checkLogged();
        Response<List<UserTask>> response = userTaskAPI.search("rootContainerId=" + rootContainerId).execute();
        checkResponse(response);
        List<UserTask> userTasks = response.body();
        LOGGER.debug("Retrieved User Tasks: {}", userTasks);
        return userTasks;
    }

    public void update(long taskId, long assignedUserId, String state) throws IOException, UnauthorizedException {
        LOGGER.debug("Updating User Task {}. Assigned to {} in state {}", taskId, assignedUserId, state);
        bonitaCookieInterceptor.checkLogged();
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("assigned_id", String.valueOf(assignedUserId));
        if (state != null) {
            parameters.put("state", state);
        }
        Response<ResponseBody> response = userTaskAPI.update(taskId, restApiConverter.buildJson(parameters)).execute();
        checkResponse(response);
        LOGGER.debug("User Task {} updated", taskId);
    }

    public void execute(long taskId) throws IOException, UnauthorizedException {
        execute(taskId, null);
    }

    public void execute(long taskId, Map<String, Serializable> params) throws IOException, UnauthorizedException {
        LOGGER.debug("Executing User Task {} with parameters {}", taskId, params);
        bonitaCookieInterceptor.checkLogged();
        Response<ResponseBody> response;
        if (params != null && !params.isEmpty()) {
            response = userTaskAPI.execute(taskId, restApiConverter.buildJson(params)).execute();
        } else {
            response = userTaskAPI.execute(taskId).execute();
        }
        checkResponse(response);
        LOGGER.debug("User Task {} executed", taskId);
    }

}
