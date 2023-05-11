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
package org.bonitasoft.web.client.services.impl.bdm;

import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.bonitasoft.web.client.exception.ClientException;
import org.bonitasoft.web.client.feign.ApiProvider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BdmResponseConverter {

    private final ObjectMapper objectMapper;

    private final ApiProvider apiProvider;

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public ApiProvider getApiProvider() {
        return apiProvider;
    }

    public <T> List<T> convertToList(Object o, Class<T> elementClass) {
        if (o == null) {
            return Collections.emptyList();
        }
        try {
            if (!elementClass.isInterface()) {
                CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class,
                        elementClass);
                return objectMapper.convertValue(o, collectionType);
            } else {
                return ((List<Object>) o).stream()
                        .map(elem -> convertToInterfaceProxy(elem, elementClass))
                        .collect(Collectors.toList());
            }
        } catch (Exception e) {
            throw new ClientException("Failed to parse response as BusinessData", e);
        }
    }

    public <T> T convert(Object o, Class<T> targetType) {
        if (o == null) {
            return null;
        }
        try {
            if (!targetType.isInterface()) {
                return convertToClass(o, targetType);
            } else {
                return convertToInterfaceProxy(o, targetType);
            }
        } catch (ClassCastException | NumberFormatException e) {
            throw new ClientException("Failed to convert query result from " + o.getClass() + " to " + targetType, e);
        }
    }

    private <T> T convertToInterfaceProxy(Object o, Class<T> targetType) {
        return (T) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[] { targetType },
                new CachingBdmResponseProxyInvocationHandler(this, (Map<String, Object>) o));
    }

    private <T> T convertToClass(Object o, Class<T> targetType) {
        if (targetType.isInstance(o)) {
            return targetType.cast(o);
        }
        if (Double.class.equals(targetType)) {
            return (T) Double.valueOf(o.toString());
        }
        if (Long.class.equals(targetType)) {
            return (T) Long.valueOf(o.toString());
        }
        if (Float.class.equals(targetType)) {
            return (T) Float.valueOf(o.toString());
        }
        if (Integer.class.equals(targetType)) {
            return (T) Integer.valueOf(o.toString());
        }
        // Last chance given to object mapper
        return objectMapper.convertValue(o, targetType);
    }
}
