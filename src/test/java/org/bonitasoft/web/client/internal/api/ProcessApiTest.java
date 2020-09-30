package org.bonitasoft.web.client.internal.api;

import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.internal.model.Contract;
import org.bonitasoft.web.client.internal.model.DesignProcessDefinition;
import org.bonitasoft.web.client.internal.model.Error;
import java.io.File;
import org.bonitasoft.web.client.internal.model.InlineObject18;
import org.bonitasoft.web.client.internal.model.InlineObject19;
import org.bonitasoft.web.client.internal.model.InlineResponse201;
import org.bonitasoft.web.client.internal.model.Process;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ProcessApi
 */
public class ProcessApiTest {

    private ProcessApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ProcessApi.class);
    }

    /**
     * Create the Process
     *
     * Create the Process. A process resource is created using the content of a .bar file that has previously been uploaded, using the [processUpload servlet](#operation/uploadProcess), to get the process archive path. 
     */
    @Test
    public void createProcessTest() {
        InlineObject18 body = null;
        // Process response = api.createProcess(body);

        // TODO: test validations
    }
    /**
     * Delete the Process by ID
     *
     * Delete the single Process for the given ID.  **Warning: Beware! Data loss risk!**  Deleting a process will automatically delete all its cases (on-going and archived alike). Thus, the operation may take a long time, and fail if the transaction timeout is not large enough. This feature should only be used on non-production environments.  **Please proceed at your own risk.** 
     */
    @Test
    public void deleteProcessByIdTest() {
        String id = null;
        // api.deleteProcessById(id);

        // TODO: test validations
    }
    /**
     * Delete the Process by IDs
     *
     * Delete Process for the given list of ID.  **Warning: Beware! Data loss risk!**  Deleting a process will automatically delete all its cases (on-going and archived alike). Thus, the operation may take a long time, and fail if the transaction timeout is not large enough. This feature should only be used on non-production environments.  **Please proceed at your own risk.** 
     */
    @Test
    public void deleteProcessByIdsTest() {
        List<String> requestBody = null;
        // api.deleteProcessByIds(requestBody);

        // TODO: test validations
    }
    /**
     * Finds Processs
     *
     * Finds Processs with pagination params and filters  - can order (default is ASC) on &#x60;name&#x60;, &#x60;version&#x60;, &#x60;deploymentDate&#x60;, &#x60;deployedBy&#x60;, &#x60;activationState&#x60;, &#x60;configurationState&#x60;, &#x60;processId&#x60;, &#x60;displayName&#x60;, &#x60;lastUpdateDate&#x60;, &#x60;categoryId&#x60;, &#x60;label&#x60; - can search on &#x60;name&#x60;, &#x60;displayName&#x60; or &#x60;version&#x60; - can filter on &#x60;name&#x60;, &#x60;version&#x60;, &#x60;deploymentDate&#x60;, &#x60;deployedBy&#x60;, &#x60;activationState&#x60; with the value DISABLED or ENABLED, &#x60;configurationState&#x60; with the value UNRESOLVED, or RESOLVED, &#x60;processId&#x60;, &#x60;displayName&#x60;, &#x60;lastUpdateDate&#x60;, &#x60;categoryId&#x60;, &#x60;label&#x60;, &#x60;supervisor_id&#x60; 
     */
    @Test
    public void findProcesssTest() {
        Integer p = null;
        Integer c = null;
        String f = null;
        String o = null;
        String s = null;
        // List<Process> response = api.findProcesss(p, c, f, o, s);

        // TODO: test validations
    }
    /**
     * Finds the Process by ID
     *
     * Returns the single Process for the given ID 
     */
    @Test
    public void getProcessByIdTest() {
        String id = null;
        // Process response = api.getProcessById(id);

        // TODO: test validations
    }
    /**
     * Finds the Process contract by ID
     *
     * Returns the process contract for the given ID 
     */
    @Test
    public void getProcessContractByIdTest() {
        String id = null;
        // Contract response = api.getProcessContractById(id);

        // TODO: test validations
    }
    /**
     * Finds the Process design by ID
     *
     * Returns the single Process design for the given ID 
     */
    @Test
    public void getProcessDesignByIdTest() {
        String id = null;
        // DesignProcessDefinition response = api.getProcessDesignById(id);

        // TODO: test validations
    }
    /**
     * Instanciate the process
     *
     * Instanciate the process with the provided contract values. 
     */
    @Test
    public void instanciateProcessTest() {
        String id = null;
        Map<String, Object> body = null;
        // InlineResponse201 response = api.instanciateProcess(id, body);

        // TODO: test validations
    }
    /**
     * Update the Process by ID
     *
     * Update the Process for the given ID 
     */
    @Test
    public void updateProcessByIdTest() {
        String id = null;
        InlineObject19 inlineObject19 = null;
        // api.updateProcessById(id, inlineObject19);

        // TODO: test validations
    }
    /**
     * Upload a bar file
     *
     * Upload a bar file 
     */
    @Test
    public void uploadProcessTest() {
        File file = null;
        // api.uploadProcess(file);

        // TODO: test validations
    }
}
