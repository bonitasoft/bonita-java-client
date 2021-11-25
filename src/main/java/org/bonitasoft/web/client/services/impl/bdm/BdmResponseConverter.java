package org.bonitasoft.web.client.services.impl.bdm;

import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bonitasoft.web.client.exception.ClientException;
import org.bonitasoft.web.client.feign.ApiProvider;

@Slf4j
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
		try {
			if (!elementClass.isInterface()) {
				CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, elementClass);
				return objectMapper.convertValue(o, collectionType);
			}
			else {
				return ((List<Object>) o).stream()
						.map(elem -> convertToInterfaceProxy(elem, elementClass))
						.collect(Collectors.toList());
			}
		}
		catch (Exception e) {
			throw new ClientException("Failed to parse response as BusinessData", e);
		}
	}

	public <T> T convert(Object o, Class<T> targetType) {
		try {
			if (!targetType.isInterface()) {
				return convertToClass(o, targetType);
			}
			else {
				return convertToInterfaceProxy(o, targetType);
			}
		}
		catch (ClassCastException | NumberFormatException e) {
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
