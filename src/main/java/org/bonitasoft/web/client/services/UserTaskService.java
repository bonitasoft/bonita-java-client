package org.bonitasoft.web.client.services;

import org.bonitasoft.web.client.model.UserTask;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface UserTaskService {
    UserTask getUserTask(long taskId);

    List<UserTask> searchUserTask(long rootContainerId);

    void assignUserTask(long taskId, long assignedUserId);

    void executeUserTask(long taskId);

    void executeUserTask(long taskId, Map<String, Serializable> params);
}
