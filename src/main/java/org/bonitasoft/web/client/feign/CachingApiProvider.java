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
package org.bonitasoft.web.client.feign;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.bonitasoft.web.client.invoker.ApiClient;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CachingApiProvider implements ApiProvider {

    private final ApiClient apiClient;

    private final Map<Class<? extends ApiClient.Api>, ApiClient.Api> apiCache = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    @Override
    public <T extends ApiClient.Api> T get(Class<T> apiClass) {
        return (T) apiCache.computeIfAbsent(apiClass, apiClient::buildClient);
    }
}
