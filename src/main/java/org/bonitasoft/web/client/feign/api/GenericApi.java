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
package org.bonitasoft.web.client.feign.api;

import java.util.List;
import java.util.Map;

import org.bonitasoft.web.client.invoker.ApiClient.Api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * Generic HTTP interface. This allows to perform query against url not known in advance and benefit from the authenticated client.
 */
public interface GenericApi extends Api {

    /**
     * Perform a GET request against the given url and expect result to be a list of object
     * 
     * @param url
     * @return
     */
    @RequestLine("GET /{url}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    List<Map<String, Object>> getList(@Param("url") String url);

    /**
     * Perform a GET request against the given url and expect result to be a single object
     * 
     * @param url
     * @return
     */
    @RequestLine("GET /{url}")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    Map<String, Object> get(@Param("url") String url);
}
