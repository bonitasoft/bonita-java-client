package org.bonitasoft.web.client.services.impl.bdm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bonitasoft.web.client.feign.ApiProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BdmResponseConverterTest {

	private BdmResponseConverter converter;

	private ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

	@Mock
	private ApiProvider apiProvider;

	@BeforeEach
	void setUp() {
		converter = new BdmResponseConverter(objectMapper, apiProvider);
	}

	@Test
	void int_should_be_converted() {
		// Given
		Object value = "1";

		// When
		Integer converted = converter.convert(value, Integer.class);

		// Then
		assertThat(converted).isEqualTo(1);
	}

	@Test
	void int_list_should_be_converted() {
		// Given
		Object value = asList("1", "2", "3", "4", "5");

		// When
		List<Integer> converted = converter.convertToList(value, Integer.class);

		// Then
		assertThat(converted).hasSize(5)
		                     .containsAll(asList(1, 2, 3, 4, 5));
	}

	@Test
	void long_should_be_converted() {
		// Given
		Object value = "1";

		// When
		Long converted = converter.convert(value, Long.class);

		// Then
		assertThat(converted).isEqualTo(1);
	}

	@Test
	void double_should_be_converted() {
		// Given
		Object value = "1.12";

		// When
		Double converted = converter.convert(value, Double.class);

		// Then
		assertThat(converted).isEqualTo(1.12);
	}

	@Test
	void float_should_be_converted() {
		// Given
		Object value = "1.12";

		// When
		Float converted = converter.convert(value, Float.class);

		// Then
		assertThat(converted).isEqualTo(1.12f);
	}
	@Test
	void targeted_type_should_be_only_casted() {
		// Given
		String value = "abc";

		// When
		String converted = converter.convert(value, String.class);

		// Then
		assertThat(converted).isEqualTo(value);
	}

	@Test
	void object_should_be_converted() {
		// Given
		Map<String, Object> value = new HashMap<String, Object>();
		String a = "a-value";
		value.put("a", a);
		String b = "b-value";
		value.put("b", b);

		// When
		Dummy converted = converter.convert(value, Dummy.class);

		// Then
		assertThat(converted.getA()).isEqualTo(a);
		assertThat(converted.getB()).isEqualTo(b);
	}

	@Test
	void interface_should_be_converted() {
		// Given
		Map<String, Object> value = new HashMap<String, Object>();
		String a = "a-value";
		value.put("a", a);
		String b = "b-value";
		value.put("b", b);

		// When
		DummyInterface converted = converter.convert(value, DummyInterface.class);

		// Then
		assertThat(converted.getA()).isEqualTo(a);
		assertThat(converted.getB()).isEqualTo(b);
	}

	@Test
	void interface_list_should_be_converted() {
		// Given
		Map<String, Object> value = new HashMap<String, Object>();
		String a = "a-value";
		value.put("a", a);
		String b = "b-value";
		value.put("b", b);

		// When
		List<DummyInterface> converted = converter.convertToList(asList(value), DummyInterface.class);

		// Then
		assertThat(converted).hasSize(1);
		assertThat(converted.get(0).getA()).isEqualTo(a);
		assertThat(converted.get(0).getB()).isEqualTo(b);
	}

	public interface DummyInterface {
		String getA();

		String getB();

		Long getC();
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Dummy {
		private String a;

		private String b;
	}
}
