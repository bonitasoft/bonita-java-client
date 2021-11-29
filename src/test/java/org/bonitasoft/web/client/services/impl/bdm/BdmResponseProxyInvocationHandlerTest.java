package org.bonitasoft.web.client.services.impl.bdm;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BdmResponseProxyInvocationHandlerTest {

	@Mock
	private ApiProvider apiProvider;

	private ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

	private BdmResponseConverter bdmResponseConverter;

	private Map<String, Object> jsonData = new LinkedHashMap<>();

	private BdmResponseProxyInvocationHandler handler;

	@BeforeEach
	void setUp() {
		bdmResponseConverter = new BdmResponseConverter(objectMapper, apiProvider);

		jsonData = new LinkedHashMap<>();
		jsonData.put("id", 123);
		jsonData.put("userId", 456);
		jsonData.put("content", "Hello !");
	}

	@Test
	void links_should_be_processed() throws Throwable {
		// Given
		handler = new BdmResponseProxyInvocationHandler(bdmResponseConverter, jsonData);

		// When
		Object userId = handler.invoke(null, Post.class.getMethod("getUserId"), null);

		// Then
		assertThat(userId).isEqualTo(456L);
	}

	@Data
	public static class Post {
		private Long id;

		private Long userId;

		private String content;
	}
}
