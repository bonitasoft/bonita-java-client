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
package org.bonitasoft.web.client.services;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.bonitasoft.web.client.api.ProcessApi;
import org.bonitasoft.web.client.model.ProcessDefinition;
import org.bonitasoft.web.client.model.ProcessInstantiationResponse;
import org.bonitasoft.web.client.model.ProcessParameter;
import org.bonitasoft.web.client.model.ProcessResolutionProblem;
import org.bonitasoft.web.client.model.UserTask;
import org.bonitasoft.web.client.services.policies.ProcessImportPolicy;

public interface ProcessService {

    /**
     * @param file
     * @param policy throws DuplicatedProcessException : if policy is set to {@link
     *        ProcessImportPolicy#FAIL_ON_DUPLICATES}
     */
    void importProcess(File file, ProcessImportPolicy policy);

    List<ProcessDefinition> searchProcesses(int page, int count);

    List<ProcessDefinition> searchProcesses(ProcessApi.SearchProcessesQueryParams params);

    List<ProcessParameter> searchProcessParameters(int page, int count, String processId);

    List<ProcessResolutionProblem> getProcessProblem(int page, int count, String processId);

    ProcessDefinition getProcess(String name, String version);

    ProcessInstantiationResponse startProcess(String name, String version);

    ProcessInstantiationResponse startProcess(String id);

    ProcessInstantiationResponse startProcess(String id, Map<String, Object> params);

    /**
     * @param taskId
     * @return
     * @throws org.bonitasoft.web.client.exception.NotFoundException if no UserTask for the given id
     */
    UserTask getUserTask(String taskId);

    List<UserTask> searchUserTask(String rootContainerId);

    void assignUserTask(String taskId, String assignedUserId);

    void assignUserTask(String taskId, String assignedUserId, String state);

    void executeUserTask(String taskId);

    void executeUserTask(String taskId, Map<String, Object> contractData);
}
