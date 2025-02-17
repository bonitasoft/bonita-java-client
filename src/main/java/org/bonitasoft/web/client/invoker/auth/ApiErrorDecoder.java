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
package org.bonitasoft.web.client.invoker.auth;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

/**
 * Error decoder that makes the HTTP 401 and 403 Retryable. Sometimes the 401 or 403 may indicate an expired token
 * All the other HTTP status are handled by the {@link feign.codec.ErrorDecoder.Default} decoder
 */
public class ApiErrorDecoder implements ErrorDecoder {

    private final Default defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        //401/403 response codes most likely indicate an expired access token, unless it happens two times in a row
        Exception httpException = defaultErrorDecoder.decode(methodKey, response);
        if (response.status() == 401 || response.status() == 403) {
            return new RetryableException(response.status(),
                    "Received status " + response.status() + " trying to renew access token",
                    response.request().httpMethod(), httpException,
                    //retryAfter => If you don't want to retry, set null.
                    (Long) null, response.request());
        }
        return httpException;
    }
}
