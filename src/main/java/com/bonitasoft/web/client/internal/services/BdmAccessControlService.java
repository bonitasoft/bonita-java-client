/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.internal.services;

import com.bonitasoft.web.client.event.ImportNotifier;
import com.bonitasoft.web.client.event.ImportWarningEvent;
import com.bonitasoft.web.client.exception.BdmAccessControlException;
import com.bonitasoft.web.client.exception.UnauthorizedException;
import com.bonitasoft.web.client.internal.api.BdmAccessControlAPI;
import com.bonitasoft.web.client.internal.security.SecurityContext;
import com.bonitasoft.web.client.model.TenantResourceStatus;
import com.github.zafarkhaja.semver.Version;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;

import java.io.File;
import java.io.IOException;

import static java.lang.String.format;

@Slf4j
public class BdmAccessControlService extends ClientService {

    private final Version minimumVersionWithBDMAccessControlSupport = new Version.Builder("7.7.0").build();

    private final BdmAccessControlAPI bdmAccessControlAPI;
    private final SystemService systemService;
    private final ImportNotifier importNotifier;

    public BdmAccessControlService(SecurityContext securityContext, BdmAccessControlAPI bdmAccessControlAPI, SystemService systemService, ImportNotifier importNotifier) {
        super(securityContext);
        this.bdmAccessControlAPI = bdmAccessControlAPI;
        this.systemService = systemService;
        this.importNotifier = importNotifier;
    }

    /**
     * Imports an access control file if the Bonita version is at least 7.7.0 and edition is 'Subscription'. Skip
     * deployment for other cases.
     */
    public void importBdmAccessControl(File content)
            throws IOException, BdmAccessControlException {
        securityContext.isAuthenticated();

        if (systemService.getLicense().isCommunityEdition()) {
            String message = "Skipping the BDM Access Control deployment: your current Bonita license is 'Community'"
                    + " and the BDM Access Control feature is supported only on 'Subscription' editions.";
            importNotifier.post(new ImportWarningEvent(message));
            return;
        }

        Version version = systemService.getVersion();
        if (version.lessThan(minimumVersionWithBDMAccessControlSupport)) {
            String message = format("Skipping the BDM Access Control deployment: your current Bonita version is '%s'"
                            + " and the BDM Access Control feature is supported since Bonita '%s'.", version,
                    minimumVersionWithBDMAccessControlSupport);
            importNotifier.post(new ImportWarningEvent(message));
            return;
        }

        try {
            log.info("Deploying BDM Access Control...");
            RequestBody requestFile = RequestBody.create(MultipartBody.FORM, content);
            MultipartBody.Part body = MultipartBody.Part.createFormData("bdmAccessControl.xml",
                    "bdmAccessControl.xml",
                    requestFile);

            log.debug("Uploading Deploying BDM Access Control file...");
            Response<String> responseUpload = bdmAccessControlAPI.uploadContent(body).execute();
            checkResponse(responseUpload);
            log.debug("BDM Access Control file uploaded successfully.");

            String uploadedFile = responseUpload.body();
            Response<ResponseBody> responseImport = bdmAccessControlAPI.importBdmAccessControl(uploadedFile)
                    .execute();
            checkResponse(responseImport);
            log.info("BDM Access Control deployed successfully.");
        } catch (UnauthorizedException | IOException e) {
            String msg = "Error while trying to deploy the BDM Access Control. Possible causes:"
                    + " the feature is not activated"
                    + " or your BDM Access Control file is incoherent with the Business Data Model";
            throw new BdmAccessControlException(msg, e);
        }
    }

    /**
     * Uninstall access control if the Bonita version is at least 7.7.0 and edition is 'Subscription'. Skip uninstalling
     * for other cases.
     */
    public void uninstallBdmAccessControl() throws IOException, UnauthorizedException {
        securityContext.isAuthenticated();

        if (systemService.getLicense().isCommunityEdition()) {
            log.debug("Skipping the BDM Access Control uninstall: your current Bonita license is 'Community'"
                    + " and the BDM Access Control feature is supported only on 'Subscription' editions.");
            return;
        }

        Version version = systemService.getVersion();
        if (version.lessThan(minimumVersionWithBDMAccessControlSupport)) {
            log.debug("Skipping the BDM Access Control uninstall: your current Bonita version is '{}'"
                            + " and the BDM Access Control feature is supported since Bonita '{}'.", version,
                    minimumVersionWithBDMAccessControlSupport);
            return;
        }

        log.debug("Uninstalling BDM Access Control...");
        checkResponse(bdmAccessControlAPI.unInstallBdmAccessControl().execute());
        log.debug("BDM Access Control uninstalled successfully.");
    }

    /**
     * @return a {@link TenantResourceStatus} containing the access control status if the Bonita version is at least
     * 7.7.0 or the UNKNOWN status for other cases.
     */
    public TenantResourceStatus getBdmAccessControlStatus() {
        try {
            securityContext.isAuthenticated();
            Version version = systemService.getVersion();
            if (systemService.getVersion().lessThan(minimumVersionWithBDMAccessControlSupport)) {
                log.debug("It is not possible to retrieve the BDM Access Control status:"
                                + " your current Bonita version is '{}' and the BDM Access Control feature is supported since"
                                + " Bonita '{}'. Returning an UNKNOWN status.", version,
                        minimumVersionWithBDMAccessControlSupport);
                return TenantResourceStatus.UNKNOWN;
            }
            log.debug("Retrieving BDM Access Control status...");
            Response<TenantResourceStatus> response = bdmAccessControlAPI.getBdmAccessControlStatus().execute();
            checkResponse(response);
            log.debug("BDM Access Control status retrieved successfully.");
            return response.body();
        } catch (UnauthorizedException | IOException e) { // feature not activated
            log.debug("Unable to retrieve the BDM Access Control status: the feature is maybe not activated." +
                    " Returning the UNKNOWN status.");
            return TenantResourceStatus.UNKNOWN;
        }
    }

}
