/** 
 * Copyright (C) 2025 BonitaSoft S.A.
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
package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.ApiResponse;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public interface DiagramApi extends ApiClient.Api {

    /**
     * Finds the diagram process by ID
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Use the diagram resource to access the process diagram xml representation. This is necessary
     * for drawing the diagram.
     * 
     * @param id ID of the process to get the diagram from (required)
     * @return String
     */
    @RequestLine("GET /API/bpm/diagram/{id}")
    @Headers({
            "Accept: application/json,application/xml",
    })
    String getProcessDiagramById(@Param("id") String id);

    /**
     * Finds the diagram process by ID
     * Similar to <code>getProcessDiagramById</code> but it also returns the http response headers .
     * ![edition](https://img.shields.io/badge/edition-entreprise-blue) Use the diagram resource to access the process diagram xml representation. This is necessary
     * for drawing the diagram.
     * 
     * @param id ID of the process to get the diagram from (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/diagram/{id}")
    @Headers({
            "Accept: application/json,application/xml",
    })
    ApiResponse<String> getProcessDiagramByIdWithHttpInfo(@Param("id") String id);

}
