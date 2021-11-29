package org.bonitasoft.web.client.services.impl;

import java.io.File;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.bonitasoft.web.client.BonitaClient;
import org.bonitasoft.web.client.api.BdmAccessControlApi;
import org.bonitasoft.web.client.api.BdmApi;
import org.bonitasoft.web.client.api.BusinessDataQueryApi;
import org.bonitasoft.web.client.api.BusinessDataQueryApi.SearchBusinessDataQueryParams;
import org.bonitasoft.web.client.api.SystemTenantApi;
import org.bonitasoft.web.client.api.UploadApi;
import org.bonitasoft.web.client.exception.ClientException;
import org.bonitasoft.web.client.exception.LicenseException;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.BDMAccessControl;
import org.bonitasoft.web.client.model.BDMInstallRequest;
import org.bonitasoft.web.client.model.Bdm;
import org.bonitasoft.web.client.model.BusinessData;
import org.bonitasoft.web.client.model.TenantPauseRequest;
import org.bonitasoft.web.client.model.TenantResourceState;
import org.bonitasoft.web.client.services.BdmService;
import org.bonitasoft.web.client.services.impl.base.AbstractService;
import org.bonitasoft.web.client.services.impl.base.ClientContext;
import org.bonitasoft.web.client.services.impl.bdm.BdmResponseConverter;
import org.jetbrains.annotations.Nullable;

import static java.util.stream.Collectors.toList;

@Slf4j
public class DefaultBdmService extends AbstractService implements BdmService {

	private BdmResponseConverter bdmResponseConverter;

	public DefaultBdmService(
			ClientContext clientContext, ApiProvider apiProvider, BdmResponseConverter bdmResponseConverter) {
		super(apiProvider, bdmResponseConverter.getObjectMapper(), clientContext);
		this.bdmResponseConverter = bdmResponseConverter;
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

		UploadApi uploadApi = apiProvider.get(UploadApi.class);
		String uploadedFileName = uploadApi.uploadFile(bdm);
		log.debug("BDM file uploaded");

		BdmApi bdmApi = apiProvider.get(BdmApi.class);
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
			String message = "BDM AccessControl management skipped: your current Bonita license is 'Community' and this feature is only supported in 'Subscription' editions.";
			throw new LicenseException(message);
		}
		BdmAccessControlApi accessControlApi = apiProvider.get(BdmAccessControlApi.class);
		BDMAccessControl bdmAccessControlStatus = accessControlApi.getBDMAccessControlStatus();
		log.debug("BDM status: {}", bdmAccessControlStatus);
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
	public <T> T querySingle(String businessDataType, SearchBusinessDataQueryParams queryParams, Class<T> queryResultType) {
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
	public <T> List<T> query(String businessDataType, SearchBusinessDataQueryParams queryParams, Class<T> queryResultType) {
		log.info("Query BDM for about {} objects with params {}", businessDataType, queryParams);
		BusinessDataQueryApi queryApi = apiProvider.get(BusinessDataQueryApi.class);
		List<Object> objects = queryApi.searchBusinessData(businessDataType, queryParams);

		if (BusinessData.class.equals(queryResultType)) {
			return (List<T>) bdmResponseConverter.convertToList(objects, BusinessData.class);
		}
		else {
			return objects.stream()
					.map(o -> bdmResponseConverter.convert(o, queryResultType))
					.collect(toList());
		}
	}

}
