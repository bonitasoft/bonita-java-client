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

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bonitasoft.web.client.feign.ApiProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Test
    void null_multiple_reference_should_not_be_converted() {
        // Given
        Object value = null;

        // When
        List<DummyInterface> converted = converter.convertToList(value, DummyInterface.class);

        // Then
        assertThat(converted).isEmpty();
    }

    @Test
    void null_reference_should_not_be_converted() {
        // Given
        Object value = null;

        // When
        DummyInterface converted = converter.convert(value, DummyInterface.class);

        // Then
        assertThat(converted).isNull();
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
