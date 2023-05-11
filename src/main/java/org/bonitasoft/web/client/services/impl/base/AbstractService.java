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
package org.bonitasoft.web.client.services.impl.base;

import java.io.InputStream;

import org.bonitasoft.web.client.api.LicenseApi;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.bonitasoft.web.client.model.License;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public abstract class AbstractService {

    private static final String COMMUNITY = "Community";

    public static final License COMMUNITY_LICENCE = new License().edition(COMMUNITY)
            .nbCpuCores("" + Runtime.getRuntime().availableProcessors());

    protected final ApiProvider apiProvider;

    protected final ObjectMapper objectMapper;

    /** Shared context between services. Allow to cache license info,... */
    private final ClientContext clientContext;

    public License getLicense() {
        // Get licence only once per client lifecycle
        return clientContext.getLicense(
                cacheKey -> {
                    log.info("Get Bonita license");
                    LicenseApi licenseApi = apiProvider.get(LicenseApi.class);
                    try (Response response = licenseApi.getLicense()) {
                        License license;
                        if (response.status() == 200) {
                            try (final Response.Body body = response.body()) {
                                InputStream inputStream = body.asInputStream();
                                license = objectMapper.readValue(inputStream, License.class);
                                log.debug("Bonita license: {}", license);
                                return license;
                            } catch (Exception e) {
                                log.error("Failed to read license response", e);
                                return COMMUNITY_LICENCE;
                            }
                        } else {
                            log.debug("Bonita license: {}", COMMUNITY_LICENCE);
                            return COMMUNITY_LICENCE;
                        }
                    }
                });
    }

    public boolean isCommunity() {
        return COMMUNITY.equalsIgnoreCase(getLicense().getEdition());
    }
}
