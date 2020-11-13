package org.bonitasoft.web.client.services.impl;

import static java.util.Optional.ofNullable;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.bonitasoft.web.client.api.SystemTenantApi;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.services.SystemService;

@Slf4j
public class DefaultSystemService extends AbstractService implements SystemService {

  public DefaultSystemService(
      ClientContext clientContext, ApiProvider apiProvider, ObjectMapper objectMapper) {
    super(apiProvider, objectMapper, clientContext);
  }

  @Override
  public boolean isTenantPaused() {
    log.info("Check if tenant is paused");
    SystemTenantApi tenantApi = apiProvider.get(SystemTenantApi.class);
    Boolean paused =
        ofNullable(tenantApi.getSystemTenant(DEFAULT_TENANT_ID).getPaused()).orElse(false);
    log.debug("Tenant paused: {}", paused);
    return paused;
  }
}
