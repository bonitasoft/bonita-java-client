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

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;
import static org.bonitasoft.web.client.TestUtils.mockResponseBuilder;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.bonitasoft.web.client.invoker.RFC3339DateFormat;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.util.StdDateFormat;

import feign.Response;
import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;

class DecoderTest {

    @Test
    void json_dates() {
        Date date = new Date();
        String stdDate = StdDateFormat.getDateInstance().format(date);
        String rfcDate = RFC3339DateFormat.getDateInstance().format(date);
        String stdDatetime = StdDateFormat.getDateTimeInstance().format(date);
        String rfcDatetime = RFC3339DateFormat.getDateTimeInstance().format(date);
        assertThat(stdDate).isEqualTo(rfcDate);
        assertThat(stdDatetime).isEqualTo(rfcDatetime);
    }

    @Test
    void decode() throws Exception {
        // Given
        String content = "response body";
        Decoder decoder = new DelegatingDecoder().register("application/json", new JacksonDecoder());
        // When
        Object decoded = decoder.decode(knownResponse(content), String.class);
        // Then
        assertThat(decoded).isInstanceOf(String.class).isEqualTo(content);
    }

    private Response knownResponse(String content) {
        InputStream inputStream = new ByteArrayInputStream(content.getBytes(UTF_8));
        Map<String, Collection<String>> headers = new HashMap<String, Collection<String>>();
        headers.put("Content-Type", Collections.singleton("text/plain"));
        return mockResponseBuilder()
                .status(200)
                .headers(headers)
                .body(inputStream, content.length())
                .build();
    }
}
