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
package org.bonitasoft.web.client.services.impl.base;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import org.bonitasoft.web.client.model.License;

/** Shared context between services. Allow to cache license info,... */
public class CachingClientContext implements ClientContext {

    private static final String CONTEXT_LICENSE_KEY = "LICENSE";

    private final Map<String, Object> shareContext = new ConcurrentHashMap<>();

    @Override
    public License getLicense() {
        return this.get(CONTEXT_LICENSE_KEY);
    }

    @Override
    public void setLicense(License license) {
        this.put(CONTEXT_LICENSE_KEY, license);
    }

    @Override
    public License getLicense(Function<String, Object> value) {
        return (License) shareContext.computeIfAbsent(CONTEXT_LICENSE_KEY, value);
    }

    @Override
    public <T> T get(String key) {
        return (T) shareContext.get(key);
    }

    @Override
    public void put(String key, Object o) {
        shareContext.put(key, o);
    }

    @Override
    public <T> T remove(String key) {
        if (shareContext.containsKey(key)) {
            return (T) shareContext.remove(key);
        }
        return null;
    }

    @Override
    public void clear() {
        shareContext.clear();
    }
}
