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

import org.bonitasoft.web.client.api.MaintenanceApi;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.MaintenanceDetails;
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
    public boolean isMaintenanceModeEnabled() {
        log.info("Check if Maintenance mode is enabled");
        MaintenanceApi maintenanceApi = apiProvider.get(MaintenanceApi.class);
        final MaintenanceDetails maintenanceDetails = maintenanceApi.getMaintenanceDetails();
        MaintenanceDetails.MaintenanceStateEnum maintenanceState = ofNullable(maintenanceDetails.getMaintenanceState())
                .orElse(MaintenanceDetails.MaintenanceStateEnum.DISABLED);
        log.debug("Maintenance State: {}", maintenanceState);
        return MaintenanceDetails.MaintenanceStateEnum.ENABLED == maintenanceState;
    }
}
