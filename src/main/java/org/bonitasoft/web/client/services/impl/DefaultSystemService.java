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

import static java.util.Optional.ofNullable;
import static org.bonitasoft.web.client.BonitaClient.DEFAULT_TENANT_ID;

import org.bonitasoft.web.client.api.SystemTenantApi;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.SystemTenant;
import org.bonitasoft.web.client.services.SystemService;
import org.bonitasoft.web.client.services.impl.base.AbstractService;
import org.bonitasoft.web.client.services.impl.base.ClientContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

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
        final SystemTenant systemTenant = tenantApi.getSystemTenant(DEFAULT_TENANT_ID);
        boolean paused = ofNullable(systemTenant.getPaused()).orElse(false);
        log.debug("Tenant paused: {}", paused);
        return paused;
    }
}
