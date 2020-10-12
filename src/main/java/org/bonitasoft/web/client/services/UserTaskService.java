package org.bonitasoft.web.client.services;

import org.bonitasoft.web.client.model.UserTask;

import java.util.List;
import java.util.Map;

public interface UserTaskService {
    UserTask getUserTask(String taskId);

    List<UserTask> searchUserTask(String rootContainerId);

    void assignUserTask(String taskId, String assignedUserId);

    void assignUserTask(String taskId, String assignedUserId, String state);

    void executeUserTask(String taskId);

    void executeUserTask(String taskId, Map<String, Object> params);
}
