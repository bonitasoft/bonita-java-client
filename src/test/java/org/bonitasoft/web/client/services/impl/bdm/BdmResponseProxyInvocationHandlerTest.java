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

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;

import org.bonitasoft.web.client.feign.ApiProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

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
