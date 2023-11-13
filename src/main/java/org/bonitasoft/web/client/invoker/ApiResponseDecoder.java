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
package org.bonitasoft.web.client.invoker;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.bonitasoft.web.client.model.ApiResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.Types;
import feign.jackson.JacksonDecoder;

public class ApiResponseDecoder extends JacksonDecoder {

    public ApiResponseDecoder(ObjectMapper mapper) {
        super(mapper);
    }

    @Override
    public Object decode(Response response, Type type) throws IOException {
        //Detects if the type is an instance of the parameterized class ApiResponse
        if (type instanceof ParameterizedType && Types.getRawType(type).isAssignableFrom(ApiResponse.class)) {
            //The ApiResponse class has a single type parameter, the Dto class itself
            Type responseBodyType = ((ParameterizedType) type).getActualTypeArguments()[0];
            Object body = super.decode(response, responseBodyType);
            Map<String, Collection<String>> responseHeaders = Collections.unmodifiableMap(response.headers());
            return new ApiResponse<>(response.status(), responseHeaders, body);
        } else {
            //The response is not encapsulated in the ApiResponse, decode the Dto as normal
            return super.decode(response, type);
        }
    }
}
