package org.bonitasoft.web.client.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.bonitasoft.web.client.api.SystemTenantApi;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.SystemTenant;
import org.bonitasoft.web.client.services.SystemService;
import org.bonitasoft.web.client.services.impl.base.AbstractService;
import org.bonitasoft.web.client.services.impl.base.ClientContext;

import static java.util.Optional.ofNullable;
import static org.bonitasoft.web.client.BonitaClient.DEFAULT_TENANT_ID;

@Slf4j
public class DefaultSystemService extends AbstractService implements SystemService {

	public DefaultSystemService(ClientContext clientContext, ApiProvider apiProvider, ObjectMapper objectMapper) {
		super(apiProvider, objectMapper, clientContext);
	}

	@Override
	public boolean isTenantPaused() {
		log.info("Check if tenant is paused");
		SystemTenantApi tenantApi = apiProvider.get(SystemTenantApi.class);
		final SystemTenant systemTenant = tenantApi.getSystemTenant(DEFAULT_TENANT_ID);
		boolean paused = ofNullable(systemTenant.getPaused()).orElse(false);
		log.debug("Tenant paused: {}", paused);
		return paused;
	}

}
