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
