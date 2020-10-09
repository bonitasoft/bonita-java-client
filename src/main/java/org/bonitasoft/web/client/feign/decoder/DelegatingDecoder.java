package org.bonitasoft.web.client.feign.decoder;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class DelegatingDecoder implements Decoder {
    private static final String CONTENT_TYPE_HEADER = "Content-Type";

    private static Logger log = LoggerFactory.getLogger(DelegatingDecoder.class);

    private Map<String, Decoder> delegates = new HashMap<>();
    private Decoder defaultDecoder = new Decoder.Default();

    public DelegatingDecoder() {
    }

    public DelegatingDecoder(Map<String, Decoder> delegates) {
        this.delegates.putAll(delegates);
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        Collection<String> contentTypeHeader = response.headers().get(CONTENT_TYPE_HEADER);
        if (contentTypeHeader == null) {
            return defaultDecoder.decode(response, type);
        }

        String contentType = contentTypeHeader.stream().findFirst()
                .orElseThrow(() -> new RuntimeException("No " + CONTENT_TYPE_HEADER + " header in response headers."));

        log.debug("Decoding body with content-type: {}", contentType);

        return delegates.entrySet().stream()
                .filter(contentTypeRegistered(contentType)).findAny()
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
            throw new RuntimeException(e);
        }
    }

    public DelegatingDecoder register(String contentType, Decoder decoder) {
        this.delegates.put(contentType, decoder);
        return this;
    }
}
