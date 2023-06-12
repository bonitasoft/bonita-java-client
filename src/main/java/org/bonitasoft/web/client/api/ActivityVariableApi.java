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
package org.bonitasoft.web.client.api;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.ActivityVariable;
import org.bonitasoft.web.client.model.ApiResponse;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface ActivityVariableApi extends ApiClient.Api {

    /**
     * Finds the ActivityVariable by ID
     * Returns the single ActivityVariable for the given ID
     * 
     * @param id The identifier of the activity from which to retrieve the variable (required)
     * @param variableName The name of the variable to retrieve (required)
     * @return ActivityVariable
     */
    @RequestLine("GET /API/bpm/activityVariable/{id}/{variableName}")
    @Headers({
            "Accept: application/json",
    })
    ActivityVariable getActivityVariableById(@Param("id") String id, @Param("variableName") String variableName);

    /**
     * Finds the ActivityVariable by ID
     * Similar to <code>getActivityVariableById</code> but it also returns the http response headers .
     * Returns the single ActivityVariable for the given ID
     * 
     * @param id The identifier of the activity from which to retrieve the variable (required)
     * @param variableName The name of the variable to retrieve (required)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("GET /API/bpm/activityVariable/{id}/{variableName}")
    @Headers({
            "Accept: application/json",
    })
    ApiResponse<ActivityVariable> getActivityVariableByIdWithHttpInfo(@Param("id") String id,
            @Param("variableName") String variableName);

}
