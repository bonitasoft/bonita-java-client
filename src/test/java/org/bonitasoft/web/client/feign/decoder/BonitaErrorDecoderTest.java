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
package org.bonitasoft.web.client.feign.decoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.bonitasoft.web.client.TestUtils.mockResponseBuilder;

import java.nio.charset.StandardCharsets;

import org.bonitasoft.web.client.exception.ClientException;
import org.bonitasoft.web.client.exception.NotFoundException;
import org.bonitasoft.web.client.exception.UnauthorizedException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import feign.Response;

@ExtendWith(MockitoExtension.class)
class BonitaErrorDecoderTest {

    @Test
    void should_decode_401() {
        // Given
        final BonitaErrorDecoder decoder = new BonitaErrorDecoder();
        final String reason = "Unauthorized";
        Response response = mockResponseBuilder().status(401).reason(reason).build();

        // When
        final Exception exception = decoder.decode("Api.getData", response);

        // Then
        assertThat(exception).isInstanceOf(UnauthorizedException.class).hasMessageContaining(reason);
    }

    @Test
    void should_decode_404() {
        // Given
        final BonitaErrorDecoder decoder = new BonitaErrorDecoder();
        Response response = mockResponseBuilder().status(404).build();

        // When
        final Exception exception = decoder.decode("Api.getData", response);

        // Then
        assertThat(exception).isInstanceOf(NotFoundException.class);
    }

    @Test
    void should_decode_other() {
        // Given
        final BonitaErrorDecoder decoder = new BonitaErrorDecoder();
        final String errorMessage = "error message";
        Response response = mockResponseBuilder().status(500).body(errorMessage, StandardCharsets.UTF_8).build();

        // When
        final Exception exception = decoder.decode("Api.getData", response);

        // Then
        assertThat(exception).isInstanceOf(ClientException.class).hasMessageContaining(errorMessage);
    }
}
