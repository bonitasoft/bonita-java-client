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

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.bonitasoft.web.client.exception.ClientException;

public class CachingBdmResponseProxyInvocationHandler extends BdmResponseProxyInvocationHandler {

    private final Map<Method, Object> fieldValues = new HashMap<>();

    public CachingBdmResponseProxyInvocationHandler(BdmResponseConverter bdmResponseConverter,
            Map<String, Object> jsonData) {
        super(bdmResponseConverter, jsonData);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return fieldValues.computeIfAbsent(method, key -> {
            try {
                return super.invoke(proxy, key, args);
            } catch (Throwable e) {
                throw new ClientException("Failed to get value for method " + method.getName(), e);
            }
        });
    }
}
