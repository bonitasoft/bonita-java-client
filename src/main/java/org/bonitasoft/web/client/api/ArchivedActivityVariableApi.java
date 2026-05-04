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
import org.bonitasoft.web.client.model.ArchivedActivityVariable;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public interface ArchivedActivityVariableApi extends ApiClient.Api {

    /**
     * Finds the ArchivedActivityVariable by case ID and name
     * Since 2022.1 Returns the single ArchivedActivityVariable for the given activity ID and variable name
     * 
     * @param id The identifier of the activity from which to retrieve the variable (required)
     * @param variableName The name of the variable to retrieve (required)
     * @return ArchivedActivityVariable
     */
    @RequestLine("GET /API/bpm/archivedActivityVariable/{id}/{variableName}")
    @Headers({
            "Accept: application/json",
    })
    ArchivedActivityVariable getArchivedActivityInstanceVariable(@Param("id") String id,
            @Param("variableName") String variableName);

    /**
     * Finds the ArchivedActivityVariable by case ID and name
     * Similar to <code>getArchivedActivityInstanceVariable</code> but it also returns the http response headers .
     * Since 2022.1 Returns the single ArchivedActivityVariable for the given activity ID and variable name
     * 
     * @param id The identifier of the activity from which to retrieve the variable (required)
     * @param variableName The name of the variable to retrieve (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/archivedActivityVariable/{id}/{variableName}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<ArchivedActivityVariable> getArchivedActivityInstanceVariableWithHttpInfo(@Param("id") String id,
            @Param("variableName") String variableName);

}
