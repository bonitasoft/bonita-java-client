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
package org.bonitasoft.web.client.invoker.auth;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.bonitasoft.web.client.feign.ApiProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BonitaCookieAuthTest {

    private BonitaCookieAuth auth;

    @BeforeEach
    void setUp() {
        auth = new BonitaCookieAuth(mock(ApiProvider.class));
    }

    @Test
    void cookie_and_csrf_token_should_be_extracted() {
        // Given
        Map<String, Collection<String>> headers = new HashMap<>();
        headers.put(
                "set-cookie",
                asList(
                        "JSESSIONID=C5385BFEE2969D9E46F0160C1952B0F1; Path=/bonita;HttpOnly; SameSite=Lax",
                        BonitaCookieAuth.CSRF_TOKEN_HEADER + "=ed27cbeb-9953-4d77-b5a2-1f62a6c2e0bb"));

        // When
        auth.initFrom(headers);

        // Then
        assertThat(auth.getCookie()).isNotNull().isNotEmpty();
        assertThat(auth.getCsrfHeader()).isNotNull().isNotEmpty();
    }
}
