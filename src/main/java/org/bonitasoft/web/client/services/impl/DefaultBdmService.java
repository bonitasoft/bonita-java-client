package org.bonitasoft.web.client.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.bonitasoft.web.client.BonitaClient;
import org.bonitasoft.web.client.api.BdmAccessControlApi;
import org.bonitasoft.web.client.api.BdmApi;
import org.bonitasoft.web.client.api.SystemTenantApi;
import org.bonitasoft.web.client.exception.LicenseException;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.*;
import org.bonitasoft.web.client.services.BdmService;
import org.bonitasoft.web.client.services.impl.base.AbstractService;
import org.bonitasoft.web.client.services.impl.base.ClientContext;

import java.io.File;

@Slf4j
public class DefaultBdmService extends AbstractService implements BdmService {

    public DefaultBdmService(
            ClientContext clientContext, ApiProvider apiProvider, ObjectMapper objectMapper) {
        super(apiProvider, objectMapper, clientContext);
    }

    @Override
    public void importBDM(File bdm) {
        log.info("Importing Business Data Model file: {}", bdm.getName());

        // Pause tenant
        log.debug("Pausing tenant ...");
        SystemTenantApi tenantApi = apiProvider.get(SystemTenantApi.class);
        tenantApi.updateSystemTenant(
                BonitaClient.DEFAULT_TENANT_ID, new TenantPauseRequest().paused("true"));
        log.debug("Tenant paused");

        deleteBdmAccessControlIfNeeded();

        BdmApi bdmApi = apiProvider.get(BdmApi.class);
        String uploadedFileName = bdmApi.uploadBDM(bdm);
        log.debug("BDM file uploaded");
        bdmApi.installBDM(new BDMInstallRequest().fileUpload(uploadedFileName));
        log.debug("BDM file installed");

        // Restart tenant
        log.debug("Resuming tenant ...");
        tenantApi.updateSystemTenant(
                BonitaClient.DEFAULT_TENANT_ID, new TenantPauseRequest().paused("false"));
        log.debug("Tenant Resumed");

        log.info("Business Data Model deployed successfully.");
    }

    @Override
    public void importBdmAccessControl(File accessControl) {
        log.info("Importing BDM AccessControl file: {}", accessControl.getName());

        deleteBdmAccessControlIfNeeded();

        BdmAccessControlApi bdmAccessControlApi = apiProvider.get(BdmAccessControlApi.class);
        String uploadedFileName = bdmAccessControlApi.uploadBDMAccessControl(accessControl);
        log.debug("BDM Access Control file uploaded");
        bdmAccessControlApi.importBDMAccessControl(uploadedFileName);
        log.debug("BDM Access Control file installed");

        log.info("BDM AccessControl file imported successfully");
    }

    void deleteBdmAccessControlIfNeeded() {
        if (!isCommunity()
                && TenantResourceState.INSTALLED.equals(getBdmAccessControlStatus().getState())) {
            log.debug("Deleting previous BdmAccessControl ...");
            BdmAccessControlApi accessControlApi = apiProvider.get(BdmAccessControlApi.class);
            accessControlApi.deleteBDMAccessControl();
            log.debug("Previous BdmAccessControl deleted");
        }
    }

    @Override
    public Bdm getBdmStatus() {
        log.info("Get BDM status");
        BdmApi bdmApi = apiProvider.get(BdmApi.class);
        Bdm bdm = bdmApi.getBdm();
        log.debug("BDM status: {}", bdm);
        return bdm;
    }

    @Override
    public BDMAccessControl getBdmAccessControlStatus() {
        log.info("Get BDM AccessControl status");
        if (isCommunity()) {
            String message =
                    "BDM AccessControl management skipped: your current Bonita license is 'Community' and this feature is only supported in 'Subscription' editions.";
            throw new LicenseException(message);
        }
        BdmAccessControlApi accessControlApi = apiProvider.get(BdmAccessControlApi.class);
        BDMAccessControl bdmAccessControlStatus = accessControlApi.getBDMAccessControlStatus();
        log.debug("BDM status: {}", bdmAccessControlStatus);
        return bdmAccessControlStatus;
    }
}
