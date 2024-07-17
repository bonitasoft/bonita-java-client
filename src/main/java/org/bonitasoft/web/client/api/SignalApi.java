/** 
 * Copyright (C) 2024 BonitaSoft S.A.
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
import org.bonitasoft.web.client.model.Signal;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public interface SignalApi extends ApiClient.Api {

    /**
     * Broadcast BPM signal events
     * Since 2022.1 Use this resource to broadcast BPM signal events. Signal events are caught by processes using &#x60;catch signal event&#x60; flow nodes (Start,
     * intermediate or boundary).
     * 
     * @param body A Signal event (required)
     */
    @RequestLine("POST /API/bpm/signal")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    void broadcastSignal(Signal body);

    /**
     * Broadcast BPM signal events
     * Similar to <code>broadcastSignal</code> but it also returns the http response headers .
     * Since 2022.1 Use this resource to broadcast BPM signal events. Signal events are caught by processes using &#x60;catch signal event&#x60; flow nodes (Start,
     * intermediate or boundary).
     * 
     * @param body A Signal event (required)
     */
    @RequestLine("POST /API/bpm/signal")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    ApiResponse<Void> broadcastSignalWithHttpInfo(Signal body);

}
