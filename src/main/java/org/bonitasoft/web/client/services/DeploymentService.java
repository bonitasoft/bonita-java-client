package org.bonitasoft.web.client.services;

import org.bonitasoft.web.client.api.BdmApi;
import org.bonitasoft.web.client.api.OrganizationApi;
import org.bonitasoft.web.client.api.SystemTenantApi;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.BDMInstallRequest;
import org.bonitasoft.web.client.model.TenantPauseRequest;
import org.bonitasoft.web.client.services.policies.OrganizationImportPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class DeploymentService implements ApiClient.Api {

    public static final String DEFAULT_TENANT_ID = "1";
    private Logger log = LoggerFactory.getLogger(DeploymentService.class);

    private ApiClient apiClient;

    public DeploymentService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public void deployOranization(File organization) {
        OrganizationApi organizationApi = apiClient.buildClient(OrganizationApi.class);
        String uploadedFileName = organizationApi.uploadOrganization(organization);
        organizationApi.importOrganization(uploadedFileName, OrganizationImportPolicy.IGNORE_DUPLICATES.name());
    }

    public void deployBDM(File bdm) {
        // Pause tenant
        SystemTenantApi tenantApi = apiClient.buildClient(SystemTenantApi.class);
        tenantApi.updateSystemTenant(DEFAULT_TENANT_ID, new TenantPauseRequest().paused("true"));

        BdmApi bdmApi = apiClient.buildClient(BdmApi.class);
        String uploadedFileName = bdmApi.uploadBDM(bdm);
        bdmApi.installBDM(new BDMInstallRequest().fileUpload(uploadedFileName));

        // Restart tenant
        tenantApi.updateSystemTenant(DEFAULT_TENANT_ID, new TenantPauseRequest().paused("false"));
        log.info("Business Data Model deployed successfully.");
    }

}
