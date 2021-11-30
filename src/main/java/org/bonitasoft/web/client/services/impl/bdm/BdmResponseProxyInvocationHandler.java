package org.bonitasoft.web.client.services.impl.bdm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.bonitasoft.web.client.feign.api.GenericApi;

@Slf4j
public class BdmResponseProxyInvocationHandler implements InvocationHandler {

	private final Map<String, String> links = new HashMap<>();

	private final Map<String, Object> jsonData;

	private final BdmResponseConverter bdmResponseConverter;

	public BdmResponseProxyInvocationHandler(BdmResponseConverter bdmResponseConverter, Map<String, Object> jsonData) {
		this.bdmResponseConverter = bdmResponseConverter;
		this.jsonData = jsonData;
		processLinks(this.jsonData);
	}

	private void processLinks(Map<String, Object> jsonData) {
		List<Map<String, String>> jsonLinks = (List<Map<String, String>>) jsonData.getOrDefault("links", new ArrayList<Map<String, String>>());
		jsonLinks.forEach(link -> {
			String rel = createLinkKey(link);
			String href = link.get("href");
			this.links.put(rel, href);
		});
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getDeclaringClass() != Object.class && isLazyGet(method)) {
			log.debug("Fetch lazy data for {}", method.getName());
			// ex: /API/bdm/businessData/com.company.model.Post/11/comments
			String href = links.get(getLinkKey(method));
			href = removeFirstSlash(href);
			GenericApi call = bdmResponseConverter.getApiProvider().get(GenericApi.class);
			if (Collection.class.isAssignableFrom(method.getReturnType())) {
				List<Map<String, Object>> body = call.getList(href);
				Class<?> returnType = (Class<?>) getGenericType(method);
				return bdmResponseConverter.convertToList(body, returnType);
			}
			else {
				Map<String, Object> body = call.get(href);
				return bdmResponseConverter.convert(body, method.getReturnType());
			}
		}
		else {
			String key = getFieldKey(method);
			// Check if there is a '_string' field and prefer it if any. (JS long serialization bug)
			Object value;
			String stringedKey = key + "_string";
			if (jsonData.containsKey(stringedKey)) {
				log.debug("Get data from json response field {}", stringedKey);
				value = jsonData.get(stringedKey);
			}
			else {
				log.debug("Get data from json response field {}", key);
				value = jsonData.get(key);
			}
			return bdmResponseConverter.convert(value, method.getReturnType());
		}
	}

	private String removeFirstSlash(String url) {
		if (url.startsWith("/")) {
			return url.substring(1);
		}
		return url;
	}

	Type getGenericType(Method method) {
		Type returnType = method.getGenericReturnType();
		if (returnType instanceof ParameterizedType) {
			ParameterizedType paramType = (ParameterizedType) returnType;
			Type[] argTypes = paramType.getActualTypeArguments();
			if (argTypes.length > 0) {
				return argTypes[0];
			}
			else {
				return Object.class;
			}
		}
		else {
			return Object.class;
		}
	}

	private String createLinkKey(Map<String, String> link) {
		return link.get("rel").toLowerCase();
	}

	protected String getLinkKey(Method method) {
		return method.getName().replace("get", "").toLowerCase();
	}

	protected String getFieldKey(Method method) {
		return lowercaseFirst(method.getName().replace("get", ""));
	}

	protected String lowercaseFirst(String text) {
		char[] c = text.toCharArray();
		c[0] = Character.toLowerCase(c[0]);
		return new String(c);
	}

	private boolean isLazyGet(Method method) {
		return this.links.containsKey(getLinkKey(method));
	}
}
