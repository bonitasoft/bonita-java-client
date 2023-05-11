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

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import org.bonitasoft.web.client.exception.ClientException;

import feign.Response;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DelegatingDecoder implements Decoder {

    private static final String CONTENT_TYPE_HEADER = "Content-Type";

    private final Map<String, Decoder> delegates = new HashMap<>();

    private final Decoder defaultDecoder = new Decoder.Default();

    @Override
    public Object decode(Response response, Type type) throws IOException {
        Collection<String> contentTypeHeader = response.headers().get(CONTENT_TYPE_HEADER);
        if (contentTypeHeader == null) {
            return defaultDecoder.decode(response, type);
        }

        String contentType = contentTypeHeader.stream()
                .findFirst()
                .orElseThrow(
                        () -> new ClientException(
                                "No " + CONTENT_TYPE_HEADER + " header in response headers."));

        log.debug("Decoding body with content-type: {}", contentType);

        return delegates.entrySet().stream()
                .filter(contentTypeRegistered(contentType))
                .findFirst()
                .map(Map.Entry::getValue)
                // Decoder found
                .map(decoder -> decodeNoException(decoder, response, type))
                // Decoder not found, try default as fallback
                .orElseGet(() -> decodeNoException(defaultDecoder, response, type));
    }

    private Predicate<Map.Entry<String, Decoder>> contentTypeRegistered(String contentType) {
        return decoderEntry -> {
            String registeredType = decoderEntry.getKey().toLowerCase();
            String responseContentType = contentType.toLowerCase();
            return responseContentType.startsWith(registeredType);
        };
    }

    private Object decodeNoException(Decoder decoder, Response response, Type type) {
        try {
            return decoder.decode(response, type);
        } catch (IOException e) {
            throw new ClientException("Failed to decode response", e);
        } finally {
            response.close();
        }
    }

    public DelegatingDecoder register(String contentType, Decoder decoder) {
        this.delegates.put(contentType, decoder);
        return this;
    }
}
