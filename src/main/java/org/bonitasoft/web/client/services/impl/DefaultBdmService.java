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
package org.bonitasoft.web.client.services.impl;

import static java.util.stream.Collectors.toList;

import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.bonitasoft.web.client.api.BdmAccessControlApi;
import org.bonitasoft.web.client.api.BdmApi;
import org.bonitasoft.web.client.api.BusinessDataOperationsApi;
import org.bonitasoft.web.client.api.BusinessDataQueryApi;
import org.bonitasoft.web.client.api.BusinessDataQueryApi.SearchBusinessDataQueryParams;
import org.bonitasoft.web.client.api.MaintenanceApi;
import org.bonitasoft.web.client.api.UploadApi;
import org.bonitasoft.web.client.exception.ClientException;
import org.bonitasoft.web.client.exception.LicenseException;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.BDMAccessControl;
import org.bonitasoft.web.client.model.BDMInstallRequest;
import org.bonitasoft.web.client.model.Bdm;
import org.bonitasoft.web.client.model.BusinessData;
import org.bonitasoft.web.client.model.MaintenanceDetails;
import org.bonitasoft.web.client.model.TenantResourceState;
import org.bonitasoft.web.client.services.BdmService;
import org.bonitasoft.web.client.services.impl.base.AbstractService;
import org.bonitasoft.web.client.services.impl.base.ClientContext;
import org.bonitasoft.web.client.services.impl.bdm.BdmResponseConverter;
import org.jetbrains.annotations.Nullable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultBdmService extends AbstractService implements BdmService {

    private final BdmResponseConverter bdmResponseConverter;

    public DefaultBdmService(
            ClientContext clientContext, ApiProvider apiProvider, BdmResponseConverter bdmResponseConverter) {
        super(apiProvider, bdmResponseConverter.getObjectMapper(), clientContext);
        this.bdmResponseConverter = bdmResponseConverter;
    }

    @Override
    public void importBDM(File bdm) {
        log.info("Importing Business Data Model file: {}", bdm.getName());

        log.debug("Enabling Maintenance mode ...");
        MaintenanceApi maintenanceApi = apiProvider.get(MaintenanceApi.class);
        maintenanceApi.updateMaintenanceDetails(
                new MaintenanceDetails().maintenanceState(MaintenanceDetails.MaintenanceStateEnum.ENABLED));
        log.debug("Maintenance mode enabled");

        deleteBdmAccessControlIfNeeded();

        UploadApi uploadApi = apiProvider.get(UploadApi.class);
        String uploadedFileName = uploadApi.uploadFile(bdm);
        log.debug("BDM file uploaded");

        BdmApi bdmApi = apiProvider.get(BdmApi.class);
        bdmApi.installBDM(new BDMInstallRequest().fileUpload(uploadedFileName));
        log.debug("BDM file installed");

        log.debug("Disabling Maintenance mode ...");
        maintenanceApi.updateMaintenanceDetails(
                new MaintenanceDetails().maintenanceState(MaintenanceDetails.MaintenanceStateEnum.DISABLED));
        log.debug("Maintenance mode disabled");

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
        log.debug("Get BDM status");
        BdmApi bdmApi = apiProvider.get(BdmApi.class);
        Bdm bdm = bdmApi.getBdm();
        log.debug("BDM status: {}", bdm);
        return bdm;
    }

    @Override
    public BDMAccessControl getBdmAccessControlStatus() {
        log.debug("Get BDM Access Control status");
        if (isCommunity()) {
            String message = "BDM AccessControl management skipped: your current Bonita license is 'Community' and this feature is only supported in 'Subscription' editions.";
            throw new LicenseException(message);
        }
        BdmAccessControlApi accessControlApi = apiProvider.get(BdmAccessControlApi.class);
        BDMAccessControl bdmAccessControlStatus = accessControlApi.getBDMAccessControlStatus();
        log.debug("BDM Access Control status: {}", bdmAccessControlStatus);
        return bdmAccessControlStatus;
    }

    @Override
    public <T> T querySingle(String businessDataType, String namedQuery, Class<T> queryResultType) {
        List<T> results = this.query(businessDataType, namedQuery, queryResultType);
        return getSingleResult(results);
    }

    @Override
    public <T> List<T> query(String businessDataType, String namedQuery, Class<T> queryResultType) {
        log.info("Query BDM for about {} objects", businessDataType);
        SearchBusinessDataQueryParams queryParams = new SearchBusinessDataQueryParams();
        queryParams.q(namedQuery).p(0).c(Integer.MAX_VALUE);
        return query(businessDataType, queryParams, queryResultType);
    }

    @Override
    public <T> T querySingle(String businessDataType, SearchBusinessDataQueryParams queryParams,
            Class<T> queryResultType) {
        List<T> results = this.query(businessDataType, queryParams, queryResultType);
        return getSingleResult(results);
    }

    @Nullable
    private <T> T getSingleResult(List<T> results) {
        if (!results.isEmpty()) {
            if (results.size() != 1) {
                throw new ClientException("Query returned more than one single result:" + results);
            }
            return results.get(0);
        }
        log.debug("No result found for this query, returning null instead");
        return null;
    }

    @Override
    public <T> List<T> query(String businessDataType, SearchBusinessDataQueryParams queryParams,
            Class<T> queryResultType) {
        log.info("Query BDM for about {} objects with params {}", businessDataType, queryParams);
        BusinessDataQueryApi queryApi = apiProvider.get(BusinessDataQueryApi.class);
        List<Object> objects = queryApi.searchBusinessData(businessDataType, queryParams);

        if (BusinessData.class.equals(queryResultType)) {
            return (List<T>) bdmResponseConverter.convertToList(objects, BusinessData.class);
        } else {
            return objects.stream()
                    .map(o -> bdmResponseConverter.convert(o, queryResultType))
                    .collect(toList());
        }
    }

    @Override
    public long createBusinessData(String businessDataType, Map<String, Serializable> fields) {
        log.info("Creating new Business Data of type {}", businessDataType);
        BusinessDataOperationsApi api = apiProvider.get(BusinessDataOperationsApi.class);
        return api.insertBusinessData(businessDataType, fields).getNewBusinessDataId().longValue();
    }

    @Override
    public void updateBusinessData(String businessDataType, long identifier, Map<String, Serializable> fields) {
        log.info("Updating Business Data of type {} with id {}", businessDataType, identifier);
        BusinessDataOperationsApi api = apiProvider.get(BusinessDataOperationsApi.class);
        api.updateBusinessData(businessDataType, BigDecimal.valueOf(identifier), fields);
    }

    @Override
    public void deleteBusinessData(String businessDataType, long identifier) {
        log.info("Deleting Business Data of type {} with id {}", businessDataType, identifier);
        BusinessDataOperationsApi api = apiProvider.get(BusinessDataOperationsApi.class);
        api.deleteBusinessData(businessDataType, BigDecimal.valueOf(identifier));
    }

    @Override
    public List<Long> importBusinessDataFile(String businessDataType, File csvFile) {
        log.info("Import Business Data file for type {}", businessDataType);
        BusinessDataOperationsApi api = apiProvider.get(BusinessDataOperationsApi.class);
        return api.importBusinessData(businessDataType, csvFile).getCreatedIds().stream().map(BigDecimal::longValue)
                .collect(toList());
    }

}
