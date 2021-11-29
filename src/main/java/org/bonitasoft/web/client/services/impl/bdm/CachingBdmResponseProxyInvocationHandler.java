package org.bonitasoft.web.client.services.impl.bdm;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.bonitasoft.web.client.exception.ClientException;

public class CachingBdmResponseProxyInvocationHandler extends BdmResponseProxyInvocationHandler {

	private final Map<Method, Object> fieldValues = new HashMap<>();

	public CachingBdmResponseProxyInvocationHandler(BdmResponseConverter bdmResponseConverter, Map<String, Object> jsonData) {
		super(bdmResponseConverter, jsonData);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return fieldValues.computeIfAbsent(method, key -> {
			try {
				return super.invoke(proxy, key, args);
			}
			catch (Throwable e) {
				throw new ClientException("Failed to get value for method " + method.getName(), e);
			}
		});
	}
}
