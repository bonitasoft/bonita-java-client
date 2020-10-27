package org.bonitasoft.web.client.services.impl;

import org.bonitasoft.web.client.model.License;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * Shared context between services. Allow to cache license info,...
 */
public class CachingClientContext implements ClientContext {

    private static final String CONTEXT_LICENSE_KEY = "LICENSE";

    private final Map<String, Object> shareContext = new ConcurrentHashMap<>();

    @Override
    public License getLicense() {
        return (License) shareContext.get(CONTEXT_LICENSE_KEY);
    }

    @Override
    public void setLicense(License license) {
        shareContext.put(CONTEXT_LICENSE_KEY, license);
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

    }

    @Override
    public <T> T remove(String key) {
        if (shareContext.containsKey(key)) {
            return (T) shareContext.remove(key);
        }
        return null;
    }
}
